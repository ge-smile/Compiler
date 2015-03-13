package ts.support;

import ts.Message;

/**
 * The class for Tscript References for TS Exception
 *
 */
public final class TSException extends Exception
{
  private TSValue val;

  /** Create a Reference for a name in an environment.
   *
   * @param val
   *        TSValue 
   */
  public TSException(final TSValue val)
  {
    super();
    this.val = val;
  }
  
  public TSValue getValue(){
    return val;
  }
}

