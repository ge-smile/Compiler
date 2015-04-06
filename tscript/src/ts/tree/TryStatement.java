
package ts.tree;

import ts.Location;
import ts.tree.visit.TreeVisitor;

/**
 * AST try statement node
 *
 */
public final class TryStatement extends Statement
{
  private Statement blockStatement;
  private Statement catchStatement;
  private Statement finallyStatement;

  public TryStatement(final Location loc, Statement blockStatement,
      Statement catchStatement, Statement finallyStatement)
  {
    super(loc);
    this.blockStatement = blockStatement;
    this.catchStatement = catchStatement;
    this.finallyStatement = finallyStatement;
  }

  public Statement getBlockStatement()
  {
    return blockStatement;
  }
  
  public Statement getCatchStatement()
  {
    return catchStatement;
  }
  
  public Statement getFinallyStatement()
  {
    return finallyStatement;
  }

  public <T> T apply(TreeVisitor<T> visitor)
  {
    return visitor.visit(this);
  }
}

