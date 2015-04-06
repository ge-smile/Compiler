
package ts.tree;

import ts.Location;
import ts.tree.visit.TreeVisitor;

/**
 * AST while statement node
 *
 */
public final class IfStatement extends Statement
{
  private Expression expression;
  private Statement statement1;
  private Statement statement2;

  public IfStatement(final Location loc, Expression expression, Statement statement1,
      Statement statement2)
  {
    super(loc);
    this.expression = expression;
    this.statement1 = statement1;
    this.statement2 = statement2;
  }

  public Expression getExpression()
  {
    return expression;
  }
  
  public Statement getIfStatement(){
    return statement1;
  }
  
  public Statement getElseStatement(){
    return statement2;
  }

  public <T> T apply(TreeVisitor<T> visitor)
  {
    return visitor.visit(this);
  }
}

