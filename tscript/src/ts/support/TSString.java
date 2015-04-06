package ts.support;

/**
 * Represents (Tscript) String values (<a
 * href="http://www.ecma-international.org/ecma-262/5.1/#sec-8.4">ELS 8.4</a>).
 * <p>
 * This class only currently allows String values to be created and does not yet
 * support operations on them.
 */
public final class TSString extends TSPrimitive {

  private final String value;

  // use the "create" method instead
  private TSString(final String value) {
    this.value = value;
  }

  /**
   * Get the value of the String.
   *
   * @return the Java string value of the TSString
   */
  public String getInternal() {
    return value;
  }

  /** Overrides Object.equals because TSString used as key for Map */
  public boolean equals(Object anObject) {
    if (anObject instanceof TSString) {
      return value.equals(((TSString) anObject).getInternal());
    }
    return false;
  }

  /** Need to override Object.hashcode() when overriding Object.equals() */
  public int hashCode() {
    return value.hashCode();
  }

  /**
   * Convert string to boolean (<a
   * href="http://www.ecma-international.org/ecma-262/5.1/#sec-9.2">ELS 9.2</a>)
   */
  public TSBoolean toBoolean() {
    if (value.isEmpty()) {
      return TSBoolean.create(false);
    } else
      return TSBoolean.create(true);
  }

  /**
   * Create a Tscript String from a Java String.
   *
   * @param value
   *          Java string
   * @return TSString encapsulating the Java string passed in
   */
  public static TSString create(final String value) {
    // could use hashmap to screen for common strings?
    return new TSString(value);
  }

  /** Convert String to Number. */
  public TSNumber toNumber() {
    double d = 0.0;
    try {
      d = Double.parseDouble(value);
    } catch (NumberFormatException nfe) {
      try {
        d = Long.decode(value);
      } catch (NumberFormatException e) {
        return TSNumber.create(Double.NaN);
      }
    }
    return TSNumber.create(d);
  }

  /** Override in TSValue */
  public TSString toStr() {
    return this;
  }
}
