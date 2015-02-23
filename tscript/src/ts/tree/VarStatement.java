
package ts.tree;

import java.util.List;

import ts.Location;
import ts.tree.visit.TreeVisitor;

/**
 * AST var statement node
 *
 */
public final class VarStatement extends Statement
{
  private List<Expression> statement;

  public VarStatement(final Location loc, List<Expression> statement)
  {
    super(loc);
    this.statement = statement;
  }

  public List<Expression> getStatement()
  {
    return statement;
  }

  public <T> T apply(TreeVisitor<T> visitor)
  {
    return visitor.visit(this);
  }
}

