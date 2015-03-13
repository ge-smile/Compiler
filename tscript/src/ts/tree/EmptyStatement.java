
package ts.tree;

import java.util.List;

import ts.Location;
import ts.tree.visit.TreeVisitor;

/**
 * AST empty statement node
 *
 */
public final class EmptyStatement extends Statement
{
  private Statement statement = null;
  
  public EmptyStatement(final Location loc)
  {
    super(loc);
  }

  public Statement getStatement()
  {
    return statement;
  }

  public <T> T apply(TreeVisitor<T> visitor)
  {
    return visitor.visit(this);
  }
}

