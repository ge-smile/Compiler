package ts.tree;

import ts.Location;
import ts.tree.visit.TreeVisitor;

/**
 * AST var statement node
 *
 */
public final class VarDeclaration extends Expression
{
  private String name;
  private Expression exp;

  public VarDeclaration(final Location loc, final String name, final Expression exp)
  {
    super(loc);
    this.name = name;
    this.exp = exp;
  }

  public String getName()
  {
    return name;
  }
  
  public Expression getExp()
  {
    return exp;
  }

  public <T> T apply(TreeVisitor<T> visitor)
  {
    return visitor.visit(this);
  }
}

