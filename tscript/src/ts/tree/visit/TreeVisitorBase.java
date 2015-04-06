package ts.tree.visit;

import ts.tree.*;

import java.util.List;
import java.util.ArrayList;

/**
 * Base implementation for AST visitors. Performs complete traversal but does
 * nothing. Parameterized by return value.
 * <p>
 * The "visit" method is overloaded for every tree node type.
 */
public class TreeVisitorBase<T> implements TreeVisitor<T> {
  // override to add pre- and/or post-processing
  protected T visitNode(final Tree node) {
    return node.apply(this);
  }

  // visit a list of ASTs and return list of results
  // use wildcard to allow general use, with list of Statements, list
  // of Expressions, etc
  protected List<T> visitEach(final Iterable<?> nodes) {
    final List<T> visited = new ArrayList<T>();
    for (final Object node : nodes) {
      visited.add(visitNode((Tree) node));
    }
    return visited;
  }

  public T visit(final BinaryOperator binaryOperator) {
    visitNode(binaryOperator.getLeft());
    visitNode(binaryOperator.getRight());
    return null;
  }

  public T visit(final ExpressionStatement expressionStatement) {
    visitNode(expressionStatement.getExp());
    return null;
  }

  public T visit(final Identifier identifier) {
    return null;
  }

  public T visit(final NumericLiteral numericLiteral) {
    return null;
  }

  public T visit(final PrintStatement printStatement) {
    visitNode(printStatement.getExp());
    return null;
  }

  public T visit(final VarStatement varStatement) {
    for(final Expression varDeclaration:varStatement.getStatement()){
      visit((VarDeclaration)varDeclaration);
    }  
    return null;
  }
  
  public T visit(VarDeclaration varDeclaration) {
    visitNode(varDeclaration.getExp());
    return null;
  }
  
  public T visit(final UnaryOperator unaryOperator) {
    visitNode(unaryOperator.getExp());
    return null;
  }

  public T visit(final NullLiteral nullLiteral) {
    return null;
  }

  public T visit(final BooleanLiteral booleanLiteral) {
    return null;
  }

  public T visit(final StringLiteral stringLiteral) {
    return null;
  }

  public T visit(final BlockStatement blockStatement) {
    visitEach(blockStatement.getStatementList());
    return null;
  }

  public T visit(EmptyStatement emptyStatement) {
    return null;
  }

  public T visit(WhileStatement whileStatement) {
    visitNode(whileStatement.getExpression());
    visitNode(whileStatement.getStatement());
    return null;
  }

  public T visit(IfStatement ifStatment) {
    // TODO Auto-generated method stub
    return null;
  }

  public T visit(BreakStatement breakStatement) {
    // TODO Auto-generated method stub
    return null;
  }

  public T visit(ContinueStatement continueStatement) {
    // TODO Auto-generated method stub
    return null;
  }

  public T visit(ThrowStatement throwStatement) {
    // TODO Auto-generated method stub
    return null;
  }
  
  public T visit(TryStatement tryStatement) {
    // TODO Auto-generated method stub
    return null;
  }
  
  public T visit(CatchStatement catchStatement) {
    // TODO Auto-generated method stub
    return null;
  }

  public T visit(FinallyStatement finallyStatement) {
    // TODO Auto-generated method stub
    return null;
  }
  
  public T visit(FunctionExpression functionExpression) {
    // TODO Auto-generated method stub
    return null;
  }

  public T visit(CallExpression callexpression) {
    // TODO Auto-generated method stub
    return null;
  }

  public T visit(ReturnStatement returnStatement) {
    // TODO Auto-generated method stub
    return null;
  }

  public T visit(NewExpression newExpression) {
    // TODO Auto-generated method stub
    visitNode(newExpression.getExpression());
    return null;
  }
  
  public T visit(PropertyAccessor memberExpression){
    visitNode(memberExpression.getExpression());
    return null;
  }

  public T visit(ThisExpression thisExpression) {
    // TODO Auto-generated method stub
    visitNode(thisExpression);
    return null;
  }
 
}
