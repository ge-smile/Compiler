package ts.tree;

import ts.Location;
import ts.tree.visit.TreeVisitor;

/**
 * AST boolean literal expression leaf node
 *
 */
public class BooleanLiteral extends Expression {

  private boolean value;
  public BooleanLiteral(final Location loc, final String value)
  {
    super(loc);
    if(value.equals("true"))
      this.value = true;
    else
      this.value = false;
  }
  
  public boolean getValue()
  {
    return value;
  }

  public <T> T apply(TreeVisitor<T> visitor)
  {
    return visitor.visit(this);
  }

}
