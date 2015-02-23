
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
}

