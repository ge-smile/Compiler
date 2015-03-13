
package ts.tree;

import java.util.List;

import ts.Location;
import ts.tree.visit.TreeVisitor;

/**
 * AST block statement node
 *
 */
public final class BlockStatement extends Statement
{
  private List<Statement> statementList;

  public BlockStatement(final Location loc, List<Statement> statementList)
  {
    super(loc);
    this.statementList = statementList;
  }

  public List<Statement> getStatementList()
  {
    return statementList;
  }

  public <T> T apply(TreeVisitor<T> visitor)
  {
    return visitor.visit(this);
  }
}

