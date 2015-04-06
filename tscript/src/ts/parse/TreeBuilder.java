package ts.parse;

import java.util.List;

import ts.Location;
import ts.Message;
import ts.support.TSNull;
import ts.tree.*;

/**
 * Provides static methods for building AST nodes
 */
public class TreeBuilder {

  /**
   * Build a "block" statement.
   *
   * @param loc
   *          location in source code (file, line, column)
   * @param statementList
   *          a list of statement
   * @return tree node for a block statement.
   */

  public static Statement buildBlockStatement(final Location loc,
      final List<Statement> statementList) {
    Message.log("TreeBuilder: BlockStatement");
    if (statementList != null) {
      for (Statement statement : statementList) {
        Message.log("TreeBuilder: " + statement.getClass().toString());
      }
    }
    return new BlockStatement(loc, statementList);
  }

  /**
   * Build a "empty" statement.
   *
   * @param loc
   *          location in source code (file, line, column)
   * @return tree node for an empty statement.
   */
  public static Statement buildEmptyStatement(final Location loc) {
    Message.log("TreeBuilder: EmptyStatement");
    return new EmptyStatement(loc);
  }

  /**
   * Build a "while" statement.
   *
   * @param loc
   *          location in source code (file, line, column)
   * @param expression
   *          an expression
   * @param statement
   *          a statement
   * @return tree node for a while statement.
   */
  public static Statement buildWhileStatement(final Location loc,
      final Expression expression, final Statement statement) {
    Message.log("TreeBuilder: WhileStatement");
    Message.log("TreeBuilder: ");
    return new WhileStatement(loc, expression, statement);
  }

  /**
   * Build a "if" statement.
   *
   * @param loc
   *          location in source code (file, line, column)
   * @param expression
   *          an expression
   * @param statement1
   *          a statement
   * @param statement2
   *          a statement
   * @return tree node for a if statement.
   */
  public static Statement buildIfStatement(final Location loc,
      final Expression expression, final Statement statement1,
      final Statement statement2) {
    Message.log("TreeBuilder: IfSatement");
    return new IfStatement(loc, expression, statement1, statement2);
  }

  /**
   * Build a "break" statement.
   *
   * @param loc
   *          location in source code (file, line, column)
   * @param i
   *          an identifier
   * @return tree node for a break statement.
   */
  public static Statement buildBreakStatement(final Location loc, final String i) {
    Message.log("TreeBuilder: BreakStatement (" + i + ")");
    return new BreakStatement(loc, i);
  }

  /**
   * Build a "continue" statement.
   *
   * @param loc
   *          location in source code (file, line, column)
   * @param i
   *          an identifier
   * @return tree node for a continue statement.
   */
  public static Statement buildContinueStatement(final Location loc,
      final String i) {
    Message.log("TreeBuilder: ContinueStatement (" + i + ")");
    return new ContinueStatement(loc, i);
  }

  /**
   * Build a "throw" statement.
   *
   * @param loc
   *          location in source code (file, line, column)
   * @param expression
   *          an expression
   * @return tree node for a throw statement.
   */
  public static Statement buildThrowStatement(final Location loc,
      final Expression expression) {
    Message.log("TreeBuilder: ThrowStatement ");
    return new ThrowStatement(loc, expression);
  }

  /**
   * Build a "try" statement.
   *
   * @param loc
   *          location in source code (file, line, column)
   * @param blockStatement
   *          a block statement
   * @param catchStatement
   *          a catch statement
   * @param finallyStatement
   *          a finally statement
   * @return tree node for a try statement.
   */
  public static Statement buildTryStatement(final Location loc,
      Statement blockStatement, Statement catchStatement,
      Statement finallyStatement) {
    Message.log("TreeBuilder: TryStatement ");
    return new TryStatement(loc, blockStatement, catchStatement,
        finallyStatement);
  }

  /**
   * Build a "catch" statement.
   *
   * @param loc
   *          location in source code (file, line, column)
   * @param identifier
   *          an identifier
   * @param blockStatement
   *          a block statement
   * @return tree node for a try statement.
   */
  public static Statement buildCatchStatement(final Location loc,
      String identifier, Statement blockStatement) {
    Message.log("TreeBuilder: catchStatement ");
    return new CatchStatement(loc, identifier, blockStatement);
  }

  /**
   * Build a "finally" statement.
   *
   * @param loc
   *          location in source code (file, line, column)
   * @param blockStatement
   *          a block statement
   * @return tree node for a finally statement.
   */
  public static Statement buildFinallyStatement(final Location loc,
      Statement blockStatement) {
    Message.log("TreeBuilder: finallyStatement ");
    return new FinallyStatement(loc, blockStatement);
  }
  
  /**
   * Build a "return" statement.
   *
   * @param loc
   *          location in source code (file, line, column)
   * @param expression
   *          an expression
   * @return tree node for a return statement.
   */
  public static Statement buildReturnStatement(final Location loc,
      Expression expression) {
    Message.log("TreeBuilder: ReturnStatement ");
    return new ReturnStatement(loc, expression);
  }
  
  /**
   * Build a "function" Expression.
   *
   * @param loc
   *          location in source code (file, line, column)
   * @param identifier
   *          a string
   * @param fpl
   *          List of String
   * @param fb
   *          Function Body
   * @return tree node for a functionExpression.
   */
  public static Expression buildFunctionExpression(final Location loc,
      final String identifier, List<String> fpl,final List<Statement> fb) {
    Message.log("TreeBuilder: functionExpression");
    return new FunctionExpression( loc, identifier, fpl, fb );
  }
  
  
  /**
   * Build a "function" Expression.
   *
   * @param loc
   *          location in source code (file, line, column)
   * @param memberExpression
   *          a member expression
   * @param argumentList
   *          a list of arguments
   * @param identifier
   *          a string
   * @return tree node for a call expression.
   */
  public static Expression buildCallExpression(final Location loc, 
      final Expression memberExpression, final List<Expression> argumentList,
      final String identifier) {
    Message.log("TreeBuilder: CallExpression");
    return new CallExpression( loc, memberExpression, argumentList, identifier);
  }
  
  
  /**
   * Build a "member" Expression.
   *
   * @param loc
   *          location in source code (file, line, column)
   * @param memberExpression
   *          an expression
   * @param identifier
   *          a String
   * @return tree node for a member expression.
   */
  public static Expression buildMemberExpression(final Location loc, 
      final Expression memberExpression, final String identifier) {
    Message.log("TreeBuilder: MemberExpression");
    return new PropertyAccessor(loc, memberExpression, identifier);
  }
  
  /**
   * Build a "member" Expression.
   *
   * @param loc
   *          location in source code (file, line, column)
   * @param newExpression
   *          a new expression
   * @return tree node for a new expression.
   */
  public static Expression buildNewExpression(final Location loc, 
      final Expression newExpression, final List<Expression> argumentList) {
    Message.log("TreeBuilder: NewExpression");
    return new NewExpression(loc, newExpression, argumentList);
  }
  
 
  /**
   * Build a "var" statement.
   *
   * @param loc
   *          location in source code (file, line, column)
   * @param statement
   *          a list of varDeclaration statement
   * @return tree node for a var statement.
   */
  public static Statement buildVarStatement(final Location loc,
      final List<Expression> statement) {
    Message.log("TreeBuilder: VarStatement");
    return new VarStatement(loc, statement);
  }

  /**
   * Build a "var" declaration
   * 
   * @param loc
   * @param name
   * @param exp
   * @return VarDeclaration node
   */
  public static Expression buildVarDeclaration(final Location loc,
      final String name, final Expression exp) {
    Message.log("TreeBuilder: VarDeclaration (" + name + ")");
    return new VarDeclaration(loc, name, exp);
  }

  /**
   * Build a expression statement.
   *
   * @param loc
   *          location in source code (file, line, column)
   * @param exp
   *          expression subtree
   * @return tree node for an expression statement.
   */
  public static Statement buildExpressionStatement(final Location loc,
      final Expression exp) {
    Message.log("TreeBuilder: ExpressionStatement");
    return new ExpressionStatement(loc, exp);
  }

  /**
   * Build a binary operator.
   *
   * @param loc
   *          location in source code (file, line, column)
   * @param op
   *          the binary operator
   * @param left
   *          the left subtree
   * @param right
   *          the right subtree
   * @return tree node for a binary operator.
   * @see Binop
   */
  public static Expression buildBinaryOperator(final Location loc,
      final Binop op, final Expression left, final Expression right) {
    Message.log("TreeBuilder: Binop " + op.toString());

    return new BinaryOperator(loc, op, left, right);
  }

  /**
   * Build a unary operator.
   *
   * @param loc
   *          location in source code (file, line, column)
   * @param op
   *          the unary operator
   * @param exp
   *          the subtree
   * @return tree node for a unary operator.
   * @see Unop
   */
  public static Expression buildUnaryOperator(final Location loc,
      final Unop op, final Expression exp) {
    Message.log("TreeBuilder: Unop " + op.toString());

    return new UnaryOperator(loc, op, exp);
  }

  /**
   * Build a identifier expression.
   *
   * @param loc
   *          location in source code (file, line, column)
   * @param name
   *          name of the identifier.
   * @return tree node for an identifier.
   */
  public static Expression buildIdentifier(final Location loc, final String name) {
    Message.log("TreeBuilder: Identifier (" + name + ")");
    return new Identifier(loc, name);
  }

  /**
   * Build a this expression.
   *
   * @param loc
   *          location in source code 
   * @return tree node for a thisExpression.
   */
  public static Expression buildThisExpression(final Location loc){
    Message.log("TreeBuilder: ThisExpression"); 
    return new ThisExpression(loc);
  }
  
  /**
   * Build a numeric literal expression. Converts the String for the value to a
   * double.
   *
   * @param loc
   *          location in source code (file, line, column)
   * @param value
   *          value of the literal as a String
   * @return tree node for a numeric literal.
   */
  public static Expression buildNumericLiteral(final Location loc,
      final String value) {
    double d = 0.0;
    try {
      d = Double.parseDouble(value);
    } catch (NumberFormatException nfe) {
      try {
        d = Long.decode(value);
      } catch (NumberFormatException e) {
        Message.bug(loc, "numeric literal not parsable");
      }
    }
    Message.log("TreeBuilder: NumericLiteral " + d);
    return new NumericLiteral(loc, d);
  }

  /**
   * Build a string literal expression.
   *
   * @param loc
   *          location in source code (file, line, column)
   * @param value
   *          value of the literal as a String
   * @return tree node for a string literal.
   */
  public static Expression buildStringLiteral(final Location loc,
      final String value) {
    Message.log("TreeBuilder: StringLiteral " + value);
    String s = value.substring(1, value.length() - 1);
    if (value.charAt(0) == '\'') {
      s = s.replace("\"", "\\\"");
      return new StringLiteral(loc, s);
    }

    return new StringLiteral(loc, s);
  }

  /**
   * Build a null literal expression. Converts the String for the value to a
   * null.
   *
   * @param loc
   *          location in source code (file, line, column)
   * @return tree node for a null literal.
   */
  public static Expression buildNullLiteral(final Location loc) {
    Message.log("TreeBuilder: NullLiteral null");
    return new NullLiteral(loc);
  }

  /**
   * Build a boolean literal expression. Converts the String for the value to a
   * boolean.
   *
   * @param loc
   *          location in source code (file, line, column)
   * @param value
   *          value of the literal as a String
   * @return tree node for a numeric literal.
   */
  public static Expression buildBooleanLiteral(final Location loc,
      final String value) {
    Message.log("TreeBuilder: BooleanLiteral " + value);
    return new BooleanLiteral(loc, value);

  }

  /**
   * Build a print statement.
   *
   * @param loc
   *          location in source code (file, line, column)
   * @param exp
   *          expression subtree.
   * @return tree node for a print statement.
   */
  public static Statement buildPrintStatement(final Location loc,
      final Expression exp) {
    Message.log("TreeBuilder: PrintStatement");
    return new PrintStatement(loc, exp);
  }

  //
  // methods to detect "early" (i.e. semantic) errors
  //

  // helper function to detect "reference expected" errors
  private static boolean producesReference(Node node) {
    if (node instanceof Identifier || node instanceof PropertyAccessor) {
      return true;
    }
    return false;
  }

  /**
   * Used to detect non-references on left-hand-side of assignment.
   *
   * @param loc
   *          location in source code (file, line, column)
   * @param node
   *          tree to be checked
   */
  public static void checkAssignmentDestination(Location loc, Node node) {
    if (!producesReference(node)) {
      Message.error(loc, "assignment destination must be a Reference");
    }
  }

}
