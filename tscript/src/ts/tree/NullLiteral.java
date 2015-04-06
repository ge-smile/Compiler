package ts.tree;

import ts.Location;
import ts.tree.visit.TreeVisitor;

/**
 * AST null literal expression leaf node
 *
 */
public class NullLiteral extends Expression {
  
  public NullLiteral(final Location loc)
  {
    super(loc);
  }

  public <T> T apply(TreeVisitor<T> visitor)
  {
    return visitor.visit(this);
  }

}
