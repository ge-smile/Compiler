
package ts.tree;

import java.util.List;

import ts.Location;
import ts.tree.visit.TreeVisitor;

/**
 * AST call Expression node
 *
 */
public class CallExpression extends Expression
{
  private Expression memberExpression;
  private List<Expression> argumentList;

  public CallExpression(final Location loc, final Expression memberExpression,
             final List<Expression> argumentList)
  {
    super(loc);
    this.memberExpression = memberExpression;
    this.argumentList = argumentList;
  }

  public Expression getMemberExpression()
  {
    return memberExpression;
  }

  public List<Expression> getArguments()
  {
    return argumentList;
  }

  public <T> T apply(TreeVisitor<T> visitor)
  {
    return visitor.visit(this);
  }
}

