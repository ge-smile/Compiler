
package ts.tree;

import ts.Location;
import ts.tree.visit.TreeVisitor;

/**
 * AST block statement node
 *
 */
public final class ContinueStatement extends Statement
{
  private String identifier;

  public ContinueStatement(final Location loc, String i)
  {
    super(loc);
    this.identifier = i;
  }

  public String getIdentifier()
  {
    return identifier;
  }

  public <T> T apply(TreeVisitor<T> visitor)
  {
    return visitor.visit(this);
  }
}

