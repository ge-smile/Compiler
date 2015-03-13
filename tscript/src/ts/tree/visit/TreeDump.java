package ts.tree.visit;

import ts.tree.*;

import java.io.PrintWriter;
import java.util.List;

/**
 * Dump an AST to a stream. Uses prefix order with indentation.
 * <p>
 * Using Object for the type parameter but there is really no return type.
 * <p>
 * The "visit" method is overloaded for each tree node type.
 */
public final class TreeDump extends TreeVisitorBase<Object> {
  // where to write the dump to
  private PrintWriter writer;

  // current indentation amount
  private int indentation;

  // how much to increment the indentation by at each level
  // using an increment of zero would mean no indentation
  private int increment;

  // by default start even to the left margin and increment indentation
  // by 2 spaces
  public TreeDump(final PrintWriter writer) {
    this(writer, 0, 2);
  }

  public TreeDump(final PrintWriter writer, final int indentation,
      final int increment) {
    this.writer = writer;
    this.indentation = indentation;
    this.increment = increment;
  }

  // generate a string of spaces for current indentation level
  private void indent() {
    for (int i = 0; i < indentation; i++) {
      writer.print(" ");
    }
  }

  // visit a list of ASTs and dump them in order
  // use wildcard for generality: list of Statements, list of Expressions, etc
  public List<Object> visitEach(final Iterable<?> nodes) {
    for (final Object node : nodes) {
      visitNode((Tree) node);
    }
    return null;
  }

  public Object visit(final BinaryOperator binaryOperator) {
    indent();
    writer.println(binaryOperator.getOpString());
    indentation += increment;
    visitNode(binaryOperator.getLeft());
    visitNode(binaryOperator.getRight());
    indentation -= increment;
    return null;
  }

  public Object visit(final ExpressionStatement expressionStatement) {
    indent();
    writer.println("ExpressionStatement");
    indentation += increment;
    visitNode(expressionStatement.getExp());
    indentation -= increment;
    return null;
  }

  public Object visit(final Identifier identifier) {
    indent();
    writer.println("Identifier " + identifier.getName());
    return null;
  }

  public Object visit(final NumericLiteral numericLiteral) {
    indent();
    writer.println("NumericLiteral " + numericLiteral.getValue());
    return null;
  }

  public Object visit(final PrintStatement printStatement) {
    indent();
    writer.println("PrintStatement");
    indentation += increment;
    visitNode(printStatement.getExp());
    indentation -= increment;
    return null;
  }

  public Object visit(final VarStatement varStatement) {
    indent();
    for (final Expression dclr : varStatement.getStatement()) {
      VarDeclaration varDeclaration = (VarDeclaration)dclr;
      writer.println("Var " + varDeclaration.getName());
      Expression exp = varDeclaration.getExp();
      if (exp != null) {
        indentation += increment;
        visitNode(exp);
        indentation -= increment;
      }
    }
    return null;
  }
  
  public Object visit(final BlockStatement blockStatement) {
    indent();
    writer.println("BlockStatement");
    indentation += increment;
    if(blockStatement.getStatementList() != null){
      visitEach(blockStatement.getStatementList());
    }
    indentation -= increment;
    return null;
  }
  
  public Object visit(final EmptyStatement emptyStatement) {
    indent();
    writer.println("EmptyStatement");
    return null;
  }

  public Object visit(final WhileStatement whileStatement) {
    indent();
    writer.println("WhileStatement ");
    visitNode(whileStatement.getExpression());
    visitNode(whileStatement.getStatement());
    return null;
  }
  
  public Object visit(final BreakStatement breakStatement) {
    indent();
    writer.println("BreakStatement");
    return null;
  }
  
  public Object visit(final ContinueStatement continueStatement){
    indent();
    writer.println("continueStatement");
    return null;
  }
  
  public Object visit(final ThrowStatement throwStatement){
    indent();
    writer.println("throwStatement");
    return null;
  }
  
  public Object visit(final TryStatement tryStatement) {
    indent();
    writer.println("tryStatement");
    indentation += increment;
    Statement catchStatement = tryStatement.getCatchStatement();
    Statement finallyStatement = tryStatement.getFinallyStatement();
    if(catchStatement != null){
      visitNode(catchStatement);
    }
    
    if(finallyStatement != null){
      visitNode(finallyStatement);
    }
    
    indentation -= increment;
    return null;
  }
  
  public Object visit(final CatchStatement catchStatement){
    indent();
    writer.println("catchStatement");
    return null;
  }
  
  public Object visit(final FinallyStatement finallyStatement){
    indent();
    writer.println("finallyStatement");
    return null;
  }
  
  public Object visit(final FunctionExpression functionExpression){
    indent();
    writer.println("functionExpression");
    indentation += increment;
    visitEach(functionExpression.getFunctionBody());
    indentation -= increment;
    return null;
  }
  
  public Object visit(final CallExpression callExpression){
    indent();
    writer.println("CallExpression");
    indentation += increment;
    Expression exp = callExpression.getMemberExpression();
    List<Expression> aug = callExpression.getArguments();
    if(exp != null)
    {
      visitNode(callExpression.getMemberExpression());
    }
    
    if(aug != null)
    {
    visitEach(callExpression.getArguments());
    }
    indentation -= increment;
    return null;
  }

  public Object visit(final ReturnStatement returnStatement){
    indent();
    writer.println("ReturnStatement");
    indentation += increment;
    Expression exp = returnStatement.getExpression();
    if(exp != null)
    {
      visitNode(exp);
    }
    indentation -= increment;
    
    return null;
  }
  
}
