package ts.support;

/**
 * The class for Tscript References for TS Exception
 *
 */
public final class TSException extends RuntimeException
{
  /**
   * 
   */
  private static final long serialVersionUID = 1L;
  
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
  
  public TSException(final String val)
  {
    super();
    this.val = TSString.create(val);
  }
    
  public TSValue getValue(){
    return val;
  }
}

