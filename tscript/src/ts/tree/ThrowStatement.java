
package ts.tree;

import ts.Location;
import ts.tree.visit.TreeVisitor;

/**
 * AST block statement node
 *
 */
public final class ThrowStatement extends Statement
{
  private Expression expression;

  public ThrowStatement(final Location loc, Expression expression)
  {
    super(loc);
    this.expression = expression;
  }

  public Expression getExpression()
  {
    return expression;
  }

  public <T> T apply(TreeVisitor<T> visitor)
  {
    return visitor.visit(this);
  }
}

