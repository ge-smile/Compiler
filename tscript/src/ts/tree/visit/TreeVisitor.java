
package ts.tree.visit;

import ts.tree.*;

/**
 * All visitor classes for ASTs will implement this interface, which
 *   is parameterized by return type.
 *
 */
public interface TreeVisitor<T>
{
  T visit(BinaryOperator binaryOperator);
  
  T visit(UnaryOperator unaryOperator);
  
  T visit(NullLiteral nullLiteral);
  
  T visit(BooleanLiteral booleanLiteral);

  T visit(ExpressionStatement expressionStatement);

  T visit(Identifier identifier);

  T visit(NumericLiteral numericLiteral);
  
  T visit(StringLiteral stringLiteral);

  T visit(PrintStatement printStatement);

  T visit(VarStatement varStatement);
  
  T visit(VarDeclaration varDeclaration);
  
  T visit(BlockStatement blockStatement);
  
  T visit(EmptyStatement emptyStatement);
  
  T visit(WhileStatement whileStatement);
  
  T visit(IfStatement ifStatment);
  
  T visit(BreakStatement breakStatement);
  
  T visit(ContinueStatement continueStatement);
  
  T visit(ThrowStatement throwStatement);
  
  T visit(TryStatement tryStatement);
  
  T visit(CatchStatement catchStatement);
  
  T visit(FinallyStatement finalllyStatement);
  
  T visit(FunctionExpression functionExpression);
    
  T visit(CallExpression callexpression);

  T visit(ReturnStatement returnStatement);
  
  T visit(NewExpression newExpression);
  
  T visit(PropertyAccessor memberExpression);
  
  T visit(ThisExpression thisExpression);
}

