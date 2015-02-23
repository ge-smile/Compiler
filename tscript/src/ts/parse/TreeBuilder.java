package ts.parse;

import java.util.List;

import ts.Location;
import ts.Message;
import ts.support.TSNull;
import ts.tree.*;

/**
 * Provides static methods for building AST nodes
 */
public class TreeBuilder {

  /**
   * Build a "block" statement.
   *
   * @param loc
   *          location in source code (file, line, column)
   * @param statement
   *          a list of varDeclaration statement
   * @return tree node for a var statement.
   */
  
  public static Statement buildBlockStatement(final Location loc,
      final List<Statement> statement){
    Message.log("TreeBuilder: BlockStatement (" + statement.toString() + ")");
    return new BlockStatement(loc, statement);
  }
  
  /**
   * Build a "var" statement.
   *
   * @param loc
   *          location in source code (file, line, column)
   * @param statement
   *          a list of varDeclaration statement
   * @return tree node for a var statement.
   */
  public static Statement buildVarStatement(final Location loc,
      final List<Expression> statement) {
    Message.log("TreeBuilder: VarStatement (" + statement.toString() + ")");
    return new VarStatement(loc, statement);
  }
  

  /**
   * Build a "var" declaration
   * 
   * @param loc
   * @param name
   * @param exp
   * @return VarDeclaration node
   */
  public static Expression buildVarDeclaration(final Location loc,
      final String name, final Expression exp) {
    Message.log("TreeBuilder: VarDeclaration (" + name + ")");
    return new VarDeclaration(loc, name, exp);
  }

  /**
   * Build a expression statement.
   *
   * @param loc
   *          location in source code (file, line, column)
   * @param exp
   *          expression subtree
   * @return tree node for an expression statement.
   */
  public static Statement buildExpressionStatement(final Location loc,
      final Expression exp) {
    Message.log("TreeBuilder: ExpressionStatement");
    return new ExpressionStatement(loc, exp);
  }

  /**
   * Build a binary operator.
   *
   * @param loc
   *          location in source code (file, line, column)
   * @param op
   *          the binary operator
   * @param left
   *          the left subtree
   * @param right
   *          the right subtree
   * @return tree node for a binary operator.
   * @see Binop
   */
  public static Expression buildBinaryOperator(final Location loc,
      final Binop op, final Expression left, final Expression right) {
    Message.log("TreeBuilder: Binop " + op.toString());

    return new BinaryOperator(loc, op, left, right);
  }

  /**
   * Build a unary operator.
   *
   * @param loc
   *          location in source code (file, line, column)
   * @param op
   *          the unary operator
   * @param exp
   *          the subtree
   * @return tree node for a unary operator.
   * @see Unop
   */
  public static Expression buildUnaryOperator(final Location loc,
      final Unop op, final Expression exp) {
    Message.log("TreeBuilder: Unop " + op.toString());

    return new UnaryOperator(loc, op, exp);
  }

  /**
   * Build a identifier expression.
   *
   * @param loc
   *          location in source code (file, line, column)
   * @param name
   *          name of the identifier.
   * @return tree node for an identififier.
   */
  public static Expression buildIdentifier(final Location loc, final String name) {
    Message.log("TreeBuilder: Identifier (" + name + ")");
    return new Identifier(loc, name);
  }

  /**
   * Build a numeric literal expression. Converts the String for the value to a
   * double.
   *
   * @param loc
   *          location in source code (file, line, column)
   * @param value
   *          value of the literal as a String
   * @return tree node for a numeric literal.
   */
  public static Expression buildNumericLiteral(final Location loc,
      final String value) {
    double d = 0.0;
    try {
      d = Double.parseDouble(value);
    } catch (NumberFormatException nfe) {
      try{
        d = Long.decode(value);
      }
      catch (NumberFormatException e) {
        Message.bug(loc, "numeric literal not parsable");
      }
    }
    Message.log("TreeBuilder: NumericLiteral " + d);
    return new NumericLiteral(loc, d);
  }

  /**
   * Build a string literal expression.
   *
   * @param loc
   *          location in source code (file, line, column)
   * @param value
   *          value of the literal as a String
   * @return tree node for a string literal.
   */
  public static Expression buildStringLiteral(final Location loc,
      final String value) {
    Message.log("TreeBuilder: StringLiteral " + value);
    String s = value.substring(1, value.length() - 1);
    if (value.charAt(0) == '\'') {
      s = s.replace("\"", "\\\"");
      return new StringLiteral(loc, s);
    }
    
    return new StringLiteral(loc, s);
  }

  /**
   * Build a null literal expression. Converts the String for the value to a
   * null.
   *
   * @param loc
   *          location in source code (file, line, column)
   * @return tree node for a null literal.
   */
  public static Expression buildNullLiteral(final Location loc) {
    Message.log("TreeBuilder: NullLiteral null");
    return new NullLiteral(loc);
  }

  /**
   * Build a boolean literal expression. Converts the String for the value to a
   * boolean.
   *
   * @param loc
   *          location in source code (file, line, column)
   * @param value
   *          value of the literal as a String
   * @return tree node for a numeric literal.
   */
  public static Expression buildBooleanLiteral(final Location loc,
      final String value) {
    Message.log("TreeBuilder: BooleanLiteral " + value);
    return new BooleanLiteral(loc, value);

  }

  /**
   * Build a print statement.
   *
   * @param loc
   *          location in source code (file, line, column)
   * @param exp
   *          expression subtree.
   * @return tree node for a print statement.
   */
  public static Statement buildPrintStatement(final Location loc,
      final Expression exp) {
    Message.log("TreeBuilder: PrintStatement");
    return new PrintStatement(loc, exp);
  }

  //
  // methods to detect "early" (i.e. semantic) errors
  //

  // helper function to detect "reference expected" errors
  private static boolean producesReference(Node node) {
    if (node instanceof Identifier) {
      return true;
    }
    return false;
  }

  /**
   * Used to detect non-references on left-hand-side of assignment.
   *
   * @param loc
   *          location in source code (file, line, column)
   * @param node
   *          tree to be checked
   */
  public static void checkAssignmentDestination(Location loc, Node node) {
    if (!producesReference(node)) {
      Message.error(loc, "assignment destination must be a Reference");
    }
  }

}
