
package ts.tree;

import java.util.List;

import ts.Location;
import ts.tree.visit.TreeVisitor;

/**
 * AST block statement node
 *
 */
public final class blockStatement extends Statement
{
  private List<Statement> statement;

  public blockStatement(final Location loc, List<Statement> statement)
  {
    super(loc);
    this.statement = statement;
  }

  public List<Statement> getStatement()
  {
    return statement;
  }

  public <T> T apply(TreeVisitor<T> visitor)
  {
    return visitor.visit(this);
  }
}

