package ts.tree;

import ts.Location;
import ts.tree.visit.TreeVisitor;

public class PropertyAccessor extends Expression
{
  private Expression memberExpression;
  private String identifier;
  
  public PropertyAccessor(Location loc, final Expression memberExpression,
      final String identifier) {
    super(loc);
    this.memberExpression = memberExpression;
    this.identifier = identifier;
  }
  
  public Expression getExpression(){
    return memberExpression;
  }
  
  public String getIdentifier(){
    return identifier;
  }

  public <T> T apply(TreeVisitor<T> visitor) {
    return visitor.visit(this);
  }
  
}
