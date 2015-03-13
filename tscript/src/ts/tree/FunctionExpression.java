
package ts.tree;

import java.util.List;

import ts.Location;
import ts.tree.visit.TreeVisitor;

/**
 * AST FunctionExpression node
 *
 */
public final class FunctionExpression extends Expression
{
  private String identifier;
  private List<String> fpl;
  private List<Statement> functionBody;
  
  public FunctionExpression(final Location loc,
      final String identifier, List<String> fpl,
      final List<Statement> functionBody)
  {
    super(loc);
    this.identifier = identifier;
    this.fpl = fpl;
    this.functionBody = functionBody;
  }
  
  public String getIdentifier()
  {
    return identifier;
  }
  
  public List<String> getFormalParameterList()
  {
    return fpl;
  }
  
  public List<Statement> getFunctionBody()
  {
    return functionBody;
  }

  public <T> T apply(TreeVisitor<T> visitor)
  {
    return visitor.visit(this);
  }
}

