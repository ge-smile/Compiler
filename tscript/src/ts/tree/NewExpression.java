
package ts.tree;

import java.util.List;

import ts.Location;
import ts.tree.visit.TreeVisitor;

/**
 * AST new expression node
 *
 */
public class NewExpression extends Expression
{
  private Expression newExpression;
  private List<Expression> argumentList;

  public NewExpression(final Location loc, final Expression newExpression, 
      final List<Expression> argumentList)
  {
    super(loc);
    this.newExpression = newExpression;
    this.argumentList = argumentList;
  }

  public Expression getExpression()
  {
    return newExpression;
  }
  
  public List<Expression> getArgumentLists(){
    return argumentList;
  }
  
  public <T> T apply(TreeVisitor<T> visitor)
  {
    return visitor.visit(this);
  }
}

