
package ts.support;

/**
 * Represents the NULL value
 * (<a href="http://www.ecma-international.org/ecma-262/5.1/#sec-8.2">ELS
 * 8.2</a>).
 */
public final class TSNull extends TSPrimitive
{
  /** Single value for this singleton class. */
  public static final TSNull value = new TSNull();

  // hide the constructor
  private TSNull()
  {
  }

  /** Convert to Number. Undefined gets mapped to NaN. */
  public TSNumber toNumber()
  {
    return TSNumber.create(+0);
  }

  /**
   * Convert null to boolean (<a
   * href="http://www.ecma-international.org/ecma-262/5.1/#sec-9.2">ELS
   * 9.2</a>)
   */
  public TSBoolean toBoolean() {
    return TSBoolean.create(false);
  }
  
  /** Convert to String ("null"). */
  public TSString toStr()
  {
    return TSString.create("null");
  }

  /** Always returns true. */
  public boolean isNull()
  {
    return true;
  }
}

