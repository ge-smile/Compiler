
package ts.tree;

import ts.Location;
import ts.tree.visit.TreeVisitor;

/**
 * AST catch statement node
 *
 */
public final class FinallyStatement extends Statement
{
  private Statement blockStatement;

  public FinallyStatement(final Location loc, final Statement blockStatement)
  {
    super(loc);
    this.blockStatement = blockStatement;
  }

  public Statement getBlockStatement()
  {
    return blockStatement;
  }
  
  public <T> T apply(TreeVisitor<T> visitor)
  {
    return visitor.visit(this);
  }
}

