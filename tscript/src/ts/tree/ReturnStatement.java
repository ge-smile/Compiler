
package ts.tree;

import ts.Location;
import ts.Message;
import ts.tree.visit.TreeVisitor;

/**
 * superclass for Return Statement nodes
 *
 */
public final class ReturnStatement extends Statement
{
  private Expression expression;
  
  public ReturnStatement(final Location loc, final Expression expression)
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

