package ts.tree;

import ts.Location;
import ts.tree.visit.TreeVisitor;

/**
 * AST while statement node
 *
 */
public final class WhileStatement extends Statement
{
  private Expression expression;
  private Statement statement;

  public WhileStatement(final Location loc, Expression expression, Statement statement)
  {
    super(loc);
    this.expression = expression;
    this.statement = statement;
  }

  public Statement getStatement()
  {
    return statement;
  }
  
  public Expression getExpression()
  {
    return expression;
  }

  public <T> T apply(TreeVisitor<T> visitor)
  {
    return visitor.visit(this);
  }
}

