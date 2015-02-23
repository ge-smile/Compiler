
package ts.support;

/**
 * Represent Number values
 * (<a href="http://www.ecma-international.org/ecma-262/5.1/#sec-8.5">ELS
 * 8.5</a>).
 */
public final class TSNumber extends TSPrimitive
{
  /** pre-built value for 0 */
  public static final TSNumber pluszeroValue = new TSNumber(0.0);
  public static final TSNumber negzeroValue = new TSNumber(-0.0);

  /** pre-built value for 1 */
  public static final TSNumber oneValue = new TSNumber(1.0);

  // use the "create" method instead
  private TSNumber(final double value)
  {
    this.value = value;
  }

  private final double value;

  /** Create a Number with the given value.
   *
   *  @param value the Java double to be encapsulated by the TSNumber
   *  @return the new TSNumber
   */
  public static TSNumber create(final double value)
  {
    // could screen for more common values?
    // even use a hashmap?

    if (value == 0.0)
    {
      if(Double.doubleToLongBits(value) >= 0)
        return pluszeroValue;
      else
        return negzeroValue;
    }
    else if (value == 1.0)
    {
      return oneValue;
    }
    return new TSNumber(value);
  }

  /** Get the value.
   *
   *  @return the Java double from the TSNumber
   */
  public double getInternal()
  {
    return value;
  }
  
  /** test the number is NaN.
  *
  *  @return the Java boolean: true or false
  */
 public boolean isNaN()
 {
   if(Double.isNaN(value)){
     return true;
   }
   else 
     return false;
 }
  
  /**
	 * Convert Number to boolean (<a
	 * href="http://www.ecma-international.org/ecma-262/5.1/#sec-9.2">ELS
	 * 9.2</a>)
	 */
  public TSBoolean toBoolean() {
		if(value == 0.0 || Double.isNaN(value)){
			return TSBoolean.create(false);
		}
		else{
			return TSBoolean.create(true);
		}
	}
  
  /** Convert to a Number, so nothing to do. */
  public TSNumber toNumber()
  {
    return this;
  }

  /** Convert Number to String
   * (<a href="http://www.ecma-international.org/ecma-262/5.1/#sec-9.8.1">ELS
   * 9.8.1</a>)
   */
  public TSString toStr()
  {
    if (Double.isNaN(value))
    {
      return TSString.create("NaN");
    }

    if ((value == +0.0) || (value == -0.0))
    {
      return TSString.create("0");
    }

    boolean isNegative = false;
    String result = null;
    double temp = value;
    if (temp < 0.0)
    {
      isNegative = true;
      temp = -temp;
    }

    if (Double.isInfinite(temp))
    {
      result = "Infinity";
    }
    else
    {
      String tmp = String.format("%.15e", temp);
      byte buf[] = tmp.getBytes();
      byte out[] = new byte[tmp.length()];

      // 'e' will be at offset 17
      int p = 17;

      // get the exponent value
      p += 1;
      boolean expIsNegative = false;
      if (buf[p] == '-')
      {
        expIsNegative = true;
      }
      p += 1;
      int expValue = 0;
      while ((p < buf.length) && Character.isDigit(buf[p]))
      {
        expValue = (expValue * 10) + (buf[p] - '0');
        p += 1;
      }
      if (expIsNegative)
      {
        expValue = -expValue;
      }

      // truncate off trailing zeros in mantissa
      p = 16;
      while (buf[p] == '0')
      {
        p -= 1;
      }
      int k = p;
      int n = expValue + 1;
      int next = 0;

      int i;

      if ((k <= n) && (n <= 21))
      {
        out[next] = buf[0];
        next += 1;
        for (i = 1; i < k; i++)
        {
          out[next] = buf[i+1];
          next += 1;
        }
        for (i = 0; i < (n - k); i++)
        {
          out[next] = '0';
          next += 1;
        }
        result = new String(out, 0, next);
      }

      else if ((0 < n) && (n <= 21))
      {
        out[next] = buf[0];
        next += 1;
        for (i = 1; i < n; i++)
        {
          out[next] = buf[i+1];
          next += 1;
        }
        out[next] = '.';
        next += 1;
        for (; i < k; i++)
        {
          out[next] = buf[i+1];
          next += 1;
        }
        result = new String(out, 0, next);
      }

      else if ((-6 < n) && (n <= 0))
      {
        out[next] = '0';
        next += 1;
        out[next] = '.';
        next += 1;
        for (i = 0; i < -n; i++)
        {
          out[next] = '0';
          next += 1;
        }
        out[next] = buf[0];
        next += 1;
        for (i = 1; i < k; i++)
        {
          out[next] = buf[i+1];
          next += 1;
        }
        result = new String(out, 0, next);
      }

      else if (k == 1)
      {
        out[next] = buf[0];
        next += 1;
        out[next] = 'e';
        next += 1;
        String tmp2 = null;
        if ((n - 1) >= 0)
        {
          out[next] = '+';
          next += 1;
          tmp2 = String.format("%d", n - 1);
        }
        else
        {
          out[next] = '-';
          next += 1;
          tmp2 = String.format("%d", -(n - 1));
        }
        result = new String(out, 0, next) + tmp2;
      }

      else 
      {
        out[next] = buf[0];
        next += 1;
        out[next] = '.';
        next += 1;
        for (i = 1; i < k; i++)
        {
          out[next] = buf[i+1];
          next += 1;
        }
        out[next] = 'e';
        next += 1;
        String tmp2 = null;
        if ((n - 1) >= 0)
        {
          out[next] = '+';
          next += 1;
          tmp2 = String.format("%d", n - 1);
        }
        else
        {
          out[next] = '-';
          next += 1;
          tmp2 = String.format("%d", -(n - 1));
        }
        result = new String(out, 0, next) + tmp2;
      }
    }

    if (isNegative)
    {
      result = "-" + result;
    }

    return TSString.create(result);
  }
}



