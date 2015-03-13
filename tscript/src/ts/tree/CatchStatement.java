
package ts.tree;

import java.util.List;

import ts.Location;
import ts.tree.visit.TreeVisitor;

/**
 * AST catch statement node
 *
 */
public final class CatchStatement extends Statement
{
  private Statement blockStatement;
  private String identifier;

  public CatchStatement(final Location loc, String identifier,
      Statement blockStatement)
  {
    super(loc);
    this.identifier = identifier;
    this.blockStatement = (BlockStatement)blockStatement;  
  }

  public Statement getBlockStatement()
  {
    return blockStatement;
  }
  
  public String getIdentifer()
  {
    return identifier;
  }
  
  public <T> T apply(TreeVisitor<T> visitor)
  {
    return visitor.visit(this);
  }
}

