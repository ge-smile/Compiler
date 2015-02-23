
package ts.support;

/**
 * The super class for all Tscript environment records
 * (<a href="http://www.ecma-international.org/ecma-262/5.1/#sec-10.2.1">ELS
 * 10.2.1</a>).
 * <p>
 * The subclasses are:
 * <ul>
 * <li> declarative environment records
 * <li> object environment records (not implemented yet)
 * </ul>
 *
 */
public abstract class TSEnvironmentRecord
{
  /** Does the environment have a binding for this name?
   *
   *  @param name name to be searched for
   *  @return true or false, does the name have a binding in this environment?
   */
  abstract boolean hasBinding(TSString name);

  /** Create a mutable binding for a name.
   *
   *  @param name name to create the binding for
   *  @param isDeletable indicates whether the new binding can be deleted
   */
  abstract void createMutableBinding(TSString name,
    boolean isDeletable);

  /** Put a value into an existing mutable binding for a name.
   *
   *  @param name name whose value should be updated
   *  @param value value to be assigned to the name
   */
  abstract void setMutableBinding(TSString name, TSValue value);

  /** Get the value from the binding for a name.
   *
   *  @param name name to get the binding value for
   *  @return the binding value found for the name
   */
  abstract TSValue getBindingValue(TSString name);

  /** Try to delete a binding for a name.
   *
   *  @param name name to be deleted
   *  @return success or failure. TODO: return value should be TSBoolean.
   */
  abstract TSNumber deleteBinding(TSString name);

  /** Return the implicit "this" value for this environment.
   *
   * @return the implicit "this" value for this environment
   */
  abstract TSValue implicitThisValue();
}

