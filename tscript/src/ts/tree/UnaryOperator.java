
package ts.tree;

import ts.Location;
import ts.tree.visit.TreeVisitor;

/**
 * AST binary operator node
 *
 */
public class UnaryOperator extends Expression
{
  private Unop op;
  private Expression exp;

  public UnaryOperator(final Location loc, final Unop op,
     final Expression exp)
  {
    super(loc);
    this.op = op;
    this.exp = exp;
  }

  public Unop getOp()
  {
    return op;
  }

  /** Convert operator kind to (Java) String for displaying.
   *
   *  @return Java string for the name of this operator
   */
  public String getOpString()
  {
    return op.toString();
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

