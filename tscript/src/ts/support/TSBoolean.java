package ts.support;

/**
 * Represents the Boolean value
 * (<a href="http://www.ecma-international.org/ecma-262/5.1/#sec-8.3">ELS
 * 8.3</a>).
 */

public class TSBoolean extends TSPrimitive {

	// use the "create" method instead
	private TSBoolean(final boolean value) {
		this.value = value;
	}

	private final boolean value;

	/**
	 * Create a Tscript boolean from a Java boolean.
	 *
	 * @param value
	 *            Java boolean
	 * @return TSBoolean encapsulating the Java boolean passed in
	 */
	public static TSBoolean create(final boolean value) {
		// could use hashmap to screen for common strings?
		return new TSBoolean(value);
	}

	/**
	 * Get the value of the boolean.
	 *
	 * @return the Java boolean value of the TSBoolean
	 */
	public boolean getInternal() {
		return value;
	}

	/**
	 * Convert Boolean to Number (<a
	 * href="http://www.ecma-international.org/ecma-262/5.1/#sec-9.3">ELS
	 * 9.3</a>)
	 */
	public TSNumber toNumber() {
		if (value == true) {
			return TSNumber.create(1.0);
		} else
			return TSNumber.create(+0.0);
	}

	/** Convert to a boolean, so nothing to do. */
	public TSBoolean toBoolean() {
		return this;
	}

	/** Convert to String ("true" or false). */
	public TSString toStr() {
		return value ? TSString.create("true") : TSString.create("false");
	}

}
