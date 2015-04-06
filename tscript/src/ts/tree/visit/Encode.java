/**
 * Traverse an AST to generate Java code.
 *
 */

package ts.tree.visit;

import ts.Message;
import ts.tree.*;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;
import java.util.Stack;

/**
 * Does a traversal of the AST to generate Java code to execute the program
 * represented by the AST.
 * <p>
 * Uses a static nested class, Encode.ReturnValue, for the type parameter. This
 * class contains two String fields: one for the temporary variable containing
 * the result of executing code for an AST node; one for the code generated for
 * the AST node.
 * <p>
 * The "visit" method is overloaded for each tree node type.
 */
public final class Encode extends TreeVisitorBase<Encode.ReturnValue> {
  /**
   * Static nested class to represent the return value of the Encode methods.
   * Contains the following fields:
   * <ul>
   * <li>a String containing the result operand name
   * <li>a String containing the code to be generated
   * </ul>
   * Only expressions generate results, so the result operand name will be null
   * in other cases, such as statements.
   */
  static public class ReturnValue {
    public String result;

    public String code;

    // initialize both fields
    private ReturnValue() {
      result = null;
      code = null;
    }

    // for non-expressions
    public ReturnValue(final String code) {
      this();
      this.code = code;
    }

    // for most expressions
    public ReturnValue(final String result, final String code) {
      this();
      this.result = result;
      this.code = code;
    }
  }

  // simple counter for expression temps
  private int nextTemp = 0;

  // simple counter for function temps
  private int nextFunc = 0;

  // generate fL
  private List<Encode.ReturnValue> fL = new ArrayList<Encode.ReturnValue>();

  public List<Encode.ReturnValue> getfL() {
    return fL;
  }

  // by default start output indented 2 spaces and increment
  // indentation by 2 spaces
  public Encode() {
    this(2, 2);
  }

  // a stack for while-break/continue loop
  public Stack<Integer> counter = new Stack<Integer>();

  // counter for the lexical environment
  public int lexical_counter = 0;

  // lexical Environment Stack
  private Stack<String> lexStack = new Stack<String>();

  // currentLexical Environment
  private String currentLexical;

  // variable Environment Stack
 // private Stack<String> varStack = new Stack<String>();

  // currentVariable Environment
  private String currentVariableLexical;

  // initial indentation value
  private final int initialIndentation;

  // current indentation amount
  private int indentation;

  // how much to increment the indentation by at each level
  // using an increment of zero would mean no indentation
  private final int increment;
  
  // global environment
  private String globalEnvironment = "globalEnvironment";

  // increase indentation by one level
  private void increaseIndentation() {
    indentation += increment;
  }

  // decrease indentation by one level
  private void decreaseIndentation() {
    indentation -= increment;
  }

  public Encode(final int initialIndentation, final int increment) {
    // setup indentation
    this.initialIndentation = initialIndentation;
    this.indentation = initialIndentation;
    this.increment = increment;
  }

  // generate a string of spaces for current indentation level
  private String indent() {
    String ret = "";
    for (int i = 0; i < indentation; i++) {
      ret += " ";
    }
    return ret;
  }

  // generate main method signature
  public String mainMethodSignature() {
    return "public static void main(String args[])";
  }

  // generate and return prologue code for the main method body
  public String mainPrologue(String filename) {
    String ret = "";
    ret += indent() + "{\n";
    increaseIndentation();
    ret += indent() + "try{\n";
    increaseIndentation();
    ret += indent() + "TSLexicalEnvironment " + "lexEnviron" +
            " = TSLexicalEnvironment.newObjectEnvironment(TSGlobalObject.globalObject);\n";
    currentLexical = "lexEnviron";
    currentVariableLexical = "lexEnviron";
  
    return ret;
  }
  


  // generate and return epilogue code for main method body
  public String mainEpilogue() {
    decreaseIndentation();
    String ret = "";
    ret += indent() + "}\n";
    ret += indent() + "catch(TSException " + getTemp() + "){\n";
    ret += indent() + "}\n";
    decreaseIndentation();
    ret += indent() + "}";
    return ret;
  }

  // return string for name of next expression temp
  private String getTemp() {
    String ret = "temp" + nextTemp;
    nextTemp += 1;
    return ret;
  }

  // return string for name of next LexicalEnvironment temp
  private String getLexicalEnvironment() {
    String ret = "lexicalEnvironment" + lexical_counter;
    lexical_counter += 1;
    return ret;
  }

  // return string for name of next function temp
  private String getFunctionName() {
    String ret = "Function" + nextFunc;
    nextFunc += 1;
    return ret;
  }

  // visit a list of ASTs and generate code for each of them in order
  // use wildcard for generality: list of Statements, list of Expressions, etc
  public List<Encode.ReturnValue> visitEach(final Iterable<?> nodes) {
    List<Encode.ReturnValue> ret = new ArrayList<Encode.ReturnValue>();

    for (final Object node : nodes) {
      ret.add(visitNode((Tree) node));
    }
    return ret;
  }
  
  // gen and return code for this expression
  public Encode.ReturnValue visit(final ThisExpression thisExpression)
  {
    String code = indent() + "Message.setLineNumber(" + thisExpression.getLineNumber() + ");\n";
    return new Encode.ReturnValue("TSGlobalObject.globalObject", code);
  }

  // gen and return code for a unary operator
  public Encode.ReturnValue visit(final UnaryOperator unaryOperator) {
    String expResult;

    // generate code to evaluate subtree
    Encode.ReturnValue ReturnValue = visitNode(unaryOperator.getExp());
    String code = ReturnValue.code;

    expResult = getTemp();
    code += indent() + "TSValue " + expResult + " = " + ReturnValue.result
        + ".getValue();\n";

    // finally generate code to do the unary operator itself
    String result = getTemp();
    String methodName = getMethodNameForUnaryOperator(unaryOperator);
    code += indent() + "TSValue " + result + " = " + expResult + "."
        + methodName + "( );\n";

    return new Encode.ReturnValue(result, code);
  }

  // support routine for handling unary operators
  private static String getMethodNameForUnaryOperator(final UnaryOperator opNode) {
    final Unop op = opNode.getOp();

    switch (op) {
    case NOT:
      return "not";
    case MINUS:
      return "negate";
    default:
      assert false : "unexpected operator: " + opNode.getOpString();
    }
    // cannot reach
    return null;
  }

  // gen and return code for a binary operator
  public Encode.ReturnValue visit(final BinaryOperator binaryOperator) {
    String leftResult;

    // generate code to evaluate left subtree
    Encode.ReturnValue leftReturnValue = visitNode(binaryOperator.getLeft());
    String code = leftReturnValue.code;

    // don't want to deref the left subtree if the operator is ASSIGN
    if (binaryOperator.getOp() == Binop.ASSIGN) {
      leftResult = leftReturnValue.result;
    } else {
      // if not ASSIGN, generate code to do deref
      leftResult = getTemp();
      code += indent() + "TSValue " + leftResult + " = "
          + leftReturnValue.result + ".getValue();\n";
    }

    // generate code to evaluate right subtree
    Encode.ReturnValue rightReturnValue = visitNode(binaryOperator.getRight());
    code += rightReturnValue.code;

    // always generate code to deref right subtree
    String rightResult = getTemp();
    code += indent() + "TSValue " + rightResult + " = "
        + rightReturnValue.result + ".getValue();\n";

    // finally generate code to do the binary operator itself
    String result = getTemp();
    String methodName = getMethodNameForBinaryOperator(binaryOperator);
    code += indent() + "TSValue " + result + " = " + leftResult + "."
        + methodName + "(" + rightResult + ");\n";

    return new Encode.ReturnValue(result, code);
  }

  // support routine for handling binary operators
  private static String getMethodNameForBinaryOperator(
      final BinaryOperator opNode) {
    final Binop op = opNode.getOp();

    switch (op) {
    case ADD:
      return "add";
    case MINUS:
      return "minus";
    case ASSIGN:
      return "simpleAssignment";
    case MULTIPLY:
      return "multiply";
    case DIVIDE:
      return "divide";
    case EQUALITY:
      return "equality";
    case SMALLER:
      return "smaller";
    case LARGER:
      return "larger";
    default:
      assert false : "unexpected operator: " + opNode.getOpString();
    }
    // cannot reach
    return null;
  }

  // process an expression statement
  public Encode.ReturnValue visit(final ExpressionStatement expressionStatement) {
    Encode.ReturnValue exp = visitNode(expressionStatement.getExp());
    String code = indent() + "Message.setLineNumber("
        + expressionStatement.getLineNumber() + ");\n";
    code += exp.code;
    return new Encode.ReturnValue(code);
  }

  // generate code for Identifier;
  public Encode.ReturnValue visit(final Identifier identifier) {
    String result = getTemp();
    String code = indent() + "TSValue " + result + " = " + currentLexical
        + ".getIdentifierReference(TSString.create(\"" + identifier.getName()
        + "\"));\n";
    /*
    code += indent() + "if(" + result + ".isUnresolvableReference())\n" +
            indent() + "{\n";
    increaseIndentation();
    /*code += indent() +  "throw new TSException(TSString.create(\"ReferenceError: " + identifier.getName() +
            " is not defined\"));\n";*/
    /*
    code += indent() + "if(TSGlobalObject.globalObject.hasProperty(TSString.create(\"" +
        identifier.getName() + "\"))){\n";
    increaseIndentation();
    code += indent() + result + ".putValue(" + "TSGlobalObject.globalObject.getProperty(\""
        + identifier.getName() +"\"));\n";
    decreaseIndentation();
    code += indent() +"}\n";
    code += indent() + "else{\n";
    increaseIndentation();
    code += indent() + "TSGlobalObject.globalObject.putProperty(\"" + identifier.getName() 
        + "\", TSUndefined.value);\n";
    decreaseIndentation();
    code += indent() +"}\n";
    
    decreaseIndentation();
    code += indent() +"}\n";
    */

    return new Encode.ReturnValue(result, code);
  }

  // generate code for NumbericalLiteral
  public Encode.ReturnValue visit(final NumericLiteral numericLiteral) {
    String result = getTemp();
    String code = indent() + "TSValue " + result + " = " + "TSNumber.create"
        + "(" + numericLiteral.getValue() + ");\n";

    return new Encode.ReturnValue(result, code);
  }

  // generate code for StringLiteral
  public Encode.ReturnValue visit(final StringLiteral stringLiteral) {
    String result = getTemp();
    String code = indent() + "TSValue " + result + " = " + "TSString.create"
        + "(\"" + stringLiteral.getValue() + "\");\n";

    return new Encode.ReturnValue(result, code);
  }

  // generate code for NullLiteral
  public Encode.ReturnValue visit(final NullLiteral nullLiteral) {
    String result = getTemp();
    String code = indent() + "TSValue " + result + " = " + "TSNull.value;\n";

    return new Encode.ReturnValue(result, code);
  }

  // generate code for BooleanLiteral
  public Encode.ReturnValue visit(final BooleanLiteral booleanLiteral) {
    String result = getTemp();
    String code = indent() + "TSValue " + result + " = " + "TSBoolean.create"
        + "(" + booleanLiteral.getValue() + ");\n";
    return new Encode.ReturnValue(result, code);
  }

  // generate code for pirntStatement
  public Encode.ReturnValue visit(final PrintStatement printStatement) {
    Encode.ReturnValue exp = visitNode(printStatement.getExp());
    String code = indent() + "Message.setLineNumber("
        + printStatement.getLineNumber() + ");\n";
    code += exp.code;
    code += indent() + "System.out.println(" + exp.result
        + ".toStr().getInternal());\n";
    return new Encode.ReturnValue(code);
  }

  // generate code for VarStatement
  public Encode.ReturnValue visit(final VarStatement varStatement) {
    String code = indent() + "Message.setLineNumber("
        + varStatement.getLineNumber() + ");\n";

    List<Expression> statement = varStatement.getStatement();

    for (Expression dclr : statement) {
      VarDeclaration varDeclaration = (VarDeclaration) dclr;
      code += indent() + currentVariableLexical + ".declareVariable(TSString.create"
          + "(\"" + varDeclaration.getName() + "\"), false);\n";
     /* code += indent() + "lex.declareVariable(TSString.create"
          + "(\"" + varDeclaration.getName() + "\"), false);\n";*/
      Expression exp = varDeclaration.getExp();
      if (exp != null) {
        Encode.ReturnValue returnValue = visitNode(exp);
        code += returnValue.code;
      }
    }
    return new Encode.ReturnValue(code);
  }

  // generate code for BlockStatement
  public Encode.ReturnValue visit(final BlockStatement blockStatement) {
    increaseIndentation();
    String code = indent() + "Message.setLineNumber("
        + blockStatement.getLineNumber() + ");\n";

    List<Statement> statements = blockStatement.getStatementList();
    if (statements != null) {
      List<Encode.ReturnValue> retList = visitEach(statements);
      for (Encode.ReturnValue ret : retList) {
        if (ret != null) {
          code += ret.code;
        }
      }
    }

    decreaseIndentation();
    return new Encode.ReturnValue(code);
  }

  // generate code for EmptyStatement
  public Encode.ReturnValue visit(final EmptyStatement emptyStatement) {
    return null;
  }

  // generate code for whileStatement
  public Encode.ReturnValue visit(final WhileStatement whileStatement) {
    String code = indent() + "Message.setLineNumber("
        + whileStatement.getLineNumber() + ");\n";
    code += indent() + "while( true )\n";
    code += indent() + "{\n";

    increaseIndentation();
    Encode.ReturnValue rtExp = visitNode(whileStatement.getExpression());
    code += rtExp.code;
    String temp = getTemp();
    code += indent() + "TSValue " + temp + " = " + rtExp.result
        + ".getValue();\n";
    code += indent() + "if(" + temp
        + ".getValue().toBoolean().getInternal())\n";
    code += indent() + "{\n";
    counter.push(1);
    Encode.ReturnValue rtStatement = visitNode(whileStatement.getStatement());

    if (rtStatement != null) {
      code += rtStatement.code;
    }
    code += indent() + "}\n";
    counter.pop();
    code += indent() + "else\n" + indent() + "break;\n";
    decreaseIndentation();
    code += indent() + "}\n";

    return new Encode.ReturnValue(code);
  }

  // generate code for ifStatement
  public Encode.ReturnValue visit(final IfStatement ifStatement) {
    String code = indent() + "Message.setLineNumber("
        + ifStatement.getLineNumber() + ");\n";
    Encode.ReturnValue rtExp = visitNode(ifStatement.getExpression());
    code += rtExp.code;
    code += indent() + "if(" + rtExp.result
        + ".getValue().toBoolean().getInternal())\n";
    code += indent() + "{\n";
    increaseIndentation();
    Encode.ReturnValue iStatement = visitNode(ifStatement.getIfStatement());
    if (iStatement != null) {
      code += iStatement.code;
    }
    decreaseIndentation();
    code += indent() + "}\n";
    if (ifStatement.getElseStatement() != null) {
      code += "else\n";
      code += indent() + "{\n";
      increaseIndentation();
      Encode.ReturnValue elseStatement = visitNode(ifStatement
          .getElseStatement());
      code += elseStatement.code;
      decreaseIndentation();
      code += indent() + "}\n";
    }
    return new Encode.ReturnValue(code);
  }

  // generate code for breakStatement
  public Encode.ReturnValue visit(final BreakStatement breakStatement) {
    String code = indent() + "Message.setLineNumber("
        + breakStatement.getLineNumber() + ");\n";
    try {
      if (counter.peek() == 1) {
        code += indent() + "break;\n";
        counter.pop();
        counter.push(0);
      }
    } catch (EmptyStackException e) {
      code += indent()
          + "System.out.println(\"Syntax Error: Break exists without loop at Line "
          + breakStatement.getLineNumber() + "\");\n";
    }
    return new Encode.ReturnValue(code);
  }

  // generate code for continueStatement
  public Encode.ReturnValue visit(final ContinueStatement continueStatement) {
    String code = indent() + "Message.setLineNumber("
        + continueStatement.getLineNumber() + ");\n";

    try {
      if (counter.peek() == 1) {
        code += indent() + "continue;\n";
      }
    } catch (EmptyStackException e) {
      code += indent()
          + "System.out.println(\"Syntax Error: Continue exists without loop at Line "
          + continueStatement.getLineNumber() + "\");\n";
    }

    return new Encode.ReturnValue(code);
  }

  // generate code for throwStatement
  public Encode.ReturnValue visit(final ThrowStatement throwStatement) {
    String code = indent() + "Message.setLineNumber("
        + throwStatement.getLineNumber() + ");\n";
    Encode.ReturnValue rtExp = visitNode(throwStatement.getExpression());
    code += rtExp.code;
    code += indent() + "throw new TSException(";
    code += rtExp.result + ");\n";
    return new Encode.ReturnValue(code);
  }

  // generate code for tryStatement
  public Encode.ReturnValue visit(final TryStatement tryStatement) {


    Encode.ReturnValue rtB = visitNode(tryStatement.getBlockStatement());
    String code = indent() + "try\n";
    code += indent() + "{\n";
    code += indent() + "Message.setLineNumber("
        + tryStatement.getLineNumber() + ");\n";
    increaseIndentation();
    code += rtB.code;
    decreaseIndentation();
    code += indent() + "}\n";

    if (tryStatement.getCatchStatement() != null) {
      CatchStatement c = (CatchStatement) tryStatement.getCatchStatement();
      Encode.ReturnValue rtBC = visit(c);
      code += rtBC.code;
    }

    
    if (tryStatement.getFinallyStatement() != null) {
      FinallyStatement f = ((FinallyStatement) tryStatement
          .getFinallyStatement());
      Encode.ReturnValue rtFB = visitNode(f);
      code += rtFB.code;
    }

    return new Encode.ReturnValue(code);
  }

  // generate code for catchStatement
  public Encode.ReturnValue visit(final CatchStatement catchStatement) {

    String temp = getTemp();
    String code = indent() + "catch( TSException " + temp + "){\n";
    increaseIndentation();
    code += indent() + "Message.setLineNumber("
        + catchStatement.getLineNumber() + ");\n";
    String lexicalTemp = getLexicalEnvironment();
    String s = catchStatement.getIdentifer();
    // outerLexical = currentLexical;
    lexStack.push(currentLexical);
    code += indent() + "TSLexicalEnvironment " + lexicalTemp + " = "
        + "TSLexicalEnvironment.newDeclarativeEnvironment(" + currentLexical
        + ");\n";
    currentLexical = lexicalTemp;
    code += indent() + lexicalTemp + ".declareParameter(\"" + s + "\"" + ", "
        + temp + ".getValue());\n";
    decreaseIndentation();
    Encode.ReturnValue rtCB = visitNode(catchStatement.getBlockStatement());
    code += rtCB.code;
    code += indent() + "}\n";
    // currentLexical = outerLexical;
    currentLexical = lexStack.pop();

    return new Encode.ReturnValue(code);
  }

  // generate code for finallyStatement
  public Encode.ReturnValue visit(final FinallyStatement finallyStatement) {
   // Message.log("fin!!!!");
    String code = indent() + "finally{\n ";
    code += indent() + "Message.setLineNumber("
        + finallyStatement.getLineNumber() + ");\n";
    Encode.ReturnValue rtFB = visitNode(finallyStatement.getBlockStatement());
    increaseIndentation();
    if (rtFB != null)
      code += rtFB.code;
    decreaseIndentation();
    code += indent() + "}\n ";

    return new Encode.ReturnValue(code);
  }

  // generate code for Function Expression
  public Encode.ReturnValue visit(final FunctionExpression functionExpression) {
    // Step 1:
    String funcName = getFunctionName();
    String code = "public TSValue execute (Boolean isConstructorCall, "
        + "TSValue ths, TSValue args[], TSLexicalEnvironment env)";
    code += "{\n";
    increaseIndentation();
    String lexicalTemp = getLexicalEnvironment();
    String outerLexical = currentLexical;
    lexStack.push(currentLexical);
    currentLexical = lexicalTemp;
    currentVariableLexical = currentLexical;
    
    code += indent() + "TSLexicalEnvironment " + lexicalTemp + " = "
        + "TSLexicalEnvironment.newDeclarativeEnvironment(env);\n";
    
    if (functionExpression.getFormalParameterList() != null) {
      int length = functionExpression.getFormalParameterList().size();

      // if the actual argument number is less than parameter number,
      // then initialize parameters that are not specified as "undifined"
      String argLen = getTemp();
      code += indent() + "int " + argLen + " = args.length;\n";
      
      String tmpstring = "";
      for (int i = 0; i < length; i++) {
        tmpstring = functionExpression.getFormalParameterList().get(i);
        code += indent() + "if(" + i + "<" + argLen + "){\n";
        code += indent() + lexicalTemp + ".declareParameter(" + "\""
            + tmpstring + "\"" + ",args[" + i + "]);\n";
        code += indent() + "}\n";
        code += indent() + "else{\n";
        code += indent() + lexicalTemp + ".declareParameter(" + "\""
            + tmpstring + "\", TSUndefined.value);\n";
        code += indent() + "}\n";
        
      }
    }

    List<Statement> statements = functionExpression.getFunctionBody();
    if (statements != null) {
      List<Encode.ReturnValue> retList = visitEach(statements);
      for (Encode.ReturnValue ret : retList) {
        if (ret != null) {
          code += ret.code;
        }
      }
    }

    code += "return TSUndefined.value;";
    decreaseIndentation();
    code += "}\n";
    fL.add(new Encode.ReturnValue(funcName, code));
   // Message.log(code);

    // Step 2:
    String codeJava = "";
    String tempFunc = getTemp();
    String tempFuncObject = getTemp();
    codeJava += indent() + "TSCode " + tempFunc + " = new " + funcName
        + "();\n";
    codeJava += indent() + "TSValue " + tempFuncObject + " = TSFunctionObject."
        + "createTSFunctionObject(" + tempFunc + "," + outerLexical + ");\n";

    // Step 3:
    String id = functionExpression.getIdentifier();
    if (id != null) {
      codeJava += indent() + outerLexical + ".declareFunctionName(\"" + id
          + "\", " + tempFuncObject + ");\n";
    }

    // restore lexEnv
    // currentLexical = outerLexical;
    currentLexical = lexStack.pop();
    currentVariableLexical = currentLexical;
    return new Encode.ReturnValue(tempFuncObject, codeJava);
  }

  public Encode.ReturnValue visit(final CallExpression callExpression) {
    String code = indent() + "Message.setLineNumber("
        + callExpression.getLineNumber() + ");\n";
    Encode.ReturnValue func = visitNode(callExpression.getMemberExpression());
    code += func.code;
    String name = getTemp();
    code += indent() + "TSFunctionObject " + name + " = (TSFunctionObject)"
        + func.result + ".getValue();\n";

    String ref = getTemp();
    code += indent() + "TSValue " + ref + " = " + func.result + ".getValue();\n"; 
    
    String ths = getTemp();
    code += indent() + "TSObject " + ths + " = null;\n";
    code += indent() + "if(" + ref + " instanceof TSObject){\n";
    code += indent() + ths + " = " + ref + ";\n";
    code += indent() + "}\n";
    code += indent() + "else{\n";
    code += indent() + "}\n";
    

    
    // build argument List
    String argumentList = getTemp();
    String returnTemp = getTemp();

    if (callExpression.getArguments() != null) {
      int length = callExpression.getArguments().size();
      List<Encode.ReturnValue> retList = visitEach(callExpression
          .getArguments());
      code += indent() + "TSValue[] " + argumentList + " = new TSValue["
          + length + "];\n";
      int i = 0;
      for (Encode.ReturnValue ret : retList) {
        if (ret != null) {
          String currentValue = getTemp();
          code += ret.code;
          code += indent() + "TSValue " + currentValue + " = " + ret.result
              + ".getValue();\n";
          code += indent() + argumentList + "[" + i + "]" + " = "
              + currentValue + ";\n";
          i++;
        }
      }
      code += indent() + "TSValue " + returnTemp + " = " + name
          + ".functionCall(false, null," + argumentList + ");\n";
    } else {
      code += indent() + "TSValue " + returnTemp + " = " + name
          + ".functionCall(false, null,null);\n";
    }

    //Message.log(code);
    return new Encode.ReturnValue(returnTemp, code);
  }
  
  public Encode.ReturnValue visit(final NewExpression newExpression){
    String code = indent() + "Message.setLineNumber("
        + newExpression.getLineNumber() + ");\n";
    Encode.ReturnValue func = visitNode(newExpression.getExpression());
    code += func.code;
    String name = getTemp();
 
    
    code += indent() + "TSObject " + name + ";\n"; // + " = new TSObject();\n";
    String ref = getTemp();
    code += indent() + "TSValue " + ref + " = " + func.result + ".getValue();\n"; 
    
    // expression is function object
    code += indent() + "if(" + ref + " instanceof TSFunctionObject){\n";
    code += indent() + name + " = (TSObject)((TSFunctionObject)" + ref + ").functionCall(true, null, null);\n";
    code += indent() + "}\n";
    code += indent() + "else{\n";
    code += indent() + name  + " = new TSObject();\n";
    code += indent() + "}\n";
    
    code += indent() + "if(" + ref + " instanceof TSObject && ((TSObject)" +
            ref + ").hasPrototype() ){\n";
    increaseIndentation();
    code += indent() + name + ".putPrototype(((TSObject)" + ref  +").getPrototype());\n";
    decreaseIndentation();
    code += indent() + "}\n";

    return new Encode.ReturnValue(name, code);
  }
  
  public Encode.ReturnValue visit(final PropertyAccessor propertyAccessor){
    String code = indent() + "Message.setLineNumber("
        + propertyAccessor.getLineNumber() + ");\n";
    Encode.ReturnValue exp = visitNode(propertyAccessor.getExpression());
    code += exp.code;
    //Message.log(code);
    String ref = getTemp();
    code += indent() + "TSPropertyReference " + ref + " = "+ " new TSPropertyReference(\""
        + propertyAccessor.getIdentifier() + "\", " + exp.result + ".getValue());\n";
   
    return new Encode.ReturnValue(ref, code);
  }

  public Encode.ReturnValue visit(final ReturnStatement returnStatement) {
    String code = "";

    if (returnStatement.getExpression() == null) {
      code += "return TSUndefined.value;\n";
    } else {
      String temp = getTemp();
      Encode.ReturnValue ret = visitNode(returnStatement.getExpression());
      code += ret.code;
      code += "TSValue " + temp + " = " + ret.result + ".getValue();\n";
      code += "return " + temp + ";\n";
    }
    return new Encode.ReturnValue(code);
  }

}
