
package ts.tree;

import java.util.List;

import ts.Location;
import ts.tree.visit.TreeVisitor;

/**
 * AST block statement node
 *
 */
public final class BreakStatement extends Statement
{
  private String identifier;

  public BreakStatement(final Location loc, String i)
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

