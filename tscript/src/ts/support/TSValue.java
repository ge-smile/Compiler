package ts.support;

import ts.Message;

/**
 * The super class for all Tscript values.
 */
public abstract class TSValue {
  //
  // References: i.e. getValue and putValue (section 8.7)
  //

  /**
   * Get the value. This method is only overridden in TSReference. Otherwise
   * just return "this".
   *
   * @return value retrieved from the binding
   */
  public TSValue getValue() {
    return this;
  }

  /**
   * Assign to the value. This method is only overridden in TSReference.
   * Otherwise just report an error.
   *
   * @param value
   *          value to store in the binding of the reference
   */
  public void putValue(TSValue value) {
    Message.bug("putValue called for non-Reference type");
  }

  //
  // conversions (section 9)
  //

  /**
   * Convert to Primitive. Override only in TSObject and TSReference. Otherwise
   * just return "this". Note: type hint is not implemented.
   *
   * @return the "this" value
   */
  TSPrimitive toPrimitive() {
    return (TSPrimitive) this;
  }

  abstract public TSNumber toNumber();

  abstract public TSBoolean toBoolean();

  // abstract public TSBoolean equality(final TSValue right);

  // abstract public TSBoolean smaller(final TSValue right);

  // abstract public TSBoolean larger(final TSValue right);

  /**
   * Convert to String. Override for all primitive types and TSReference. It
   * can't be called toString because of Object.toString.
   *
   * @return produced TSString value
   */
  public TSString toStr() {
    TSPrimitive prim = this.toPrimitive();
    return prim.toStr();
  }

  //
  // unary operators (sections 11.4)
  //

  /**
   * Perform an logic not. "this" is the oldValue. If oldValue is true, return
   * false, else return true. OldValue are get from ToBoolean.
   * 
   *
   * @return the result of the logical not
   */
  public final TSPrimitive not() {
    if (this.toBoolean().getInternal()) {
      return TSBoolean.create(false);
    }
    return TSBoolean.create(true);

  }

  /**
   * Perform negate. "this" is the oldValue. If oldValue is nan, return nan,
   * else converts its operand to Number type and then negates it
   * 
   * @return the result of negate
   */
  public final TSNumber negate() {
    TSNumber oldValue = this.toNumber();
    if (Double.isNaN(oldValue.getInternal()))
      return TSNumber.create(Double.NaN);
    else
      return TSNumber.create(-oldValue.getInternal());
  }

  //
  // binary operators (sections 11.5-11.11)
  //

  /**
   * Perform a multiply. "this" is the left operand and the right operand is
   * given by the parameter. Both operands are converted to Number before the
   * multiply.
   *
   * @param right
   *          value to be multiplied
   * @return the result of the multiplication
   */
  public final TSNumber multiply(final TSValue right) {
    TSNumber leftValue = this.toNumber();
    TSNumber rightValue = right.toNumber();
    double leftDouble = leftValue.getInternal();
    double rightDouble = rightValue.getInternal();

    int sign;

    // 1. if either operand is NaN, return NaN
    if (leftValue.isNaN() || rightValue.isNaN())
      return TSNumber.create(Double.NaN);

    // 2. If the operands' sign are the same return positive number,
    // else return negative
    boolean leftSign = Double.doubleToLongBits(leftDouble) >= 0;
    boolean rightSign = Double.doubleToLongBits(rightDouble) >= 0;
    if (leftSign == rightSign)
      sign = 1;
    else
      sign = -1;

    // 3,4,5 Infinity*zero = NaN
    // Infinity*Infinity = (signed)Infinity
    // Infinity*NonZero = (signed)Infinity
    if (Double.isInfinite(leftDouble)) {
      if (rightDouble == 0.0)
        return TSNumber.create(Double.NaN);
      else {
        if (sign == 1)
          return TSNumber.create(Double.POSITIVE_INFINITY);
        if (sign == -1)
          return TSNumber.create(Double.NEGATIVE_INFINITY);
      }
    }

    if (Double.isInfinite(rightDouble)) {
      if (leftDouble == 0.0)
        return TSNumber.create(Double.NaN);
      else {
        if (sign == 1)
          return TSNumber.create(Double.POSITIVE_INFINITY);
        if (sign == -1)
          return TSNumber.create(Double.NEGATIVE_INFINITY);
      }
    }

    // 6.normal case just return
    double multiplication = leftDouble * rightDouble;
    return TSNumber.create(multiplication);
  }

  /**
   * Perform a division. "this" is the left operand and the right operand is
   * given by the parameter. Both operands are converted to Number before the
   * divide.
   *
   * @param right
   *          value to be divided
   * @return the result of the division
   */
  public final TSNumber divide(final TSValue right) {
    TSNumber leftValue = this.toNumber();
    TSNumber rightValue = right.toNumber();
    double leftDouble = leftValue.getInternal();
    double rightDouble = rightValue.getInternal();
    int sign;

    // 1. if either operand is NaN, return NaN
    if (leftValue.isNaN() || rightValue.isNaN())
      return TSNumber.create(Double.NaN);

    // 2. If the operands' sign are the same return positive number,
    // else return negative
    boolean leftSign = Double.doubleToLongBits(leftDouble) >= 0;
    boolean rightSign = Double.doubleToLongBits(rightDouble) >= 0;

    if (leftSign == rightSign)
      sign = 1;
    else
      sign = -1;

    // 3,4,5. Infinity/Infinity = NaN
    // Infinity/zero = (signed)Infinity
    // Infinity/nonzero = (signed)Infinity
    if (Double.isInfinite(leftDouble)) {

      if (Double.isInfinite(rightDouble))
        return TSNumber.create(Double.NaN);
      if (sign == 1)
        return TSNumber.create(Double.POSITIVE_INFINITY);
      else
        return TSNumber.create(Double.NEGATIVE_INFINITY);
    }
    // 6. finite value/Infinity = (signed)zero
    else if (Double.isInfinite(rightDouble)) {
      if (sign == 1)
        return TSNumber.create(0.0);
      else
        return TSNumber.create(-0.0);
    }

    // 7. 0/0 = NaN
    // 0/other finite value = (signed)zero
    else if (leftDouble == 0.0) {
      if (rightDouble == 0.0)
        return TSNumber.create(Double.NaN);
      else {
        if (sign == 1)
          return TSNumber.create(0.0);
        else
          return TSNumber.create(-0.0);
      }
    }
    // 8. none zero finite/0 = (signed)Infinity
    else if (rightDouble == 0) {
      if (sign == 1)
        return TSNumber.create(Double.POSITIVE_INFINITY);
      else
        return TSNumber.create(Double.NEGATIVE_INFINITY);
    }

    // 9. none zero infinite / none zero infinite
    else {
      double division = leftDouble / rightDouble;
      return TSNumber.create(division);
    }
  }

  /**
   * Perform an addition. "this" is the left operand and the right operand is
   * given by the parameter. Both operands are converted to Number before the
   * addition.
   *
   * @param right
   *          value to be added
   * @return the result of the addition
   */
  public final TSPrimitive add(final TSValue right) {
    TSPrimitive lprim = this.toPrimitive();
    TSPrimitive rprim = right.toPrimitive();

    if (lprim.getClass() == TSString.class
        || rprim.getClass() == TSString.class) {
      return TSString.create(lprim.toStr().getInternal()
          + rprim.toStr().getInternal());
    } else{
      TSNumber lval = this.toNumber();
      TSNumber rval = right.toNumber();
      double ldouble = lval.getInternal();
      double rdouble = rval.getInternal();
      
      int sign;
      boolean leftSign = Double.doubleToLongBits(ldouble) >= 0;
      boolean rightSign = Double.doubleToLongBits(rdouble) >= 0;
      if (leftSign == rightSign)
        sign = 1;
      else
        sign = -1;
      boolean lInf = Double.isInfinite(ldouble);
      boolean rInf = Double.isInfinite(rdouble);

      //1. either is NaN, return NaN
      if(Double.isNaN(ldouble)|| Double.isNaN(rdouble)){
        return TSNumber.create(Double.NaN);
      }
      //2,3. sum of two infinity
      else if (lInf && rInf){
        // if the sign is opposite, return NaN
        if(sign == -1)  return TSNumber.create(Double.NaN); 
        // if the sign is same, return it
        else return lval;
      }
      //4. sum of infinity and finite value is infinity
      else if(lInf || rInf){
        return (lInf==true) ? lval:rval;
      }
      //5. -0 + -0 is 0, 0+0 is 0, opposite sign 0 is 0
      else if(ldouble == 0.0 && rdouble == 0.0){
        if(sign == 1) return lval;
        else return TSNumber.create(0.0);
      }
      //6. finite value plus 0
      else if(ldouble == 0.0 || rdouble == 0.0){
        return (ldouble==0.0) ? rval:lval;
      }
      //7. else case
      else return TSNumber.create(ldouble + rdouble);
    }
  }

  /**
   * Perform a subtraction. "this" is the left operand and the right operand is
   * given by the parameter. Both operands are converted to Number before the
   * subtraction.
   *
   * @param right
   *          value to be subtracted
   * @return the result of the subtraction
   */
  public final TSPrimitive minus(final TSValue right) {
    return add(right.negate());
  }

  /**
   * Perform an assignment. "this" is the left operand and the right operand is
   * given by the parameter.
   *
   * @param right
   *          value to be assigned
   * @return the value assigned
   */
  public final TSValue simpleAssignment(final TSValue right) {
    TSValue rightValue = right.getValue();
    this.putValue(rightValue);
    return rightValue;
  }

  /**
   * Perform an equality comparison. "this" is the left operand and the right
   * operand is given by the parameter.
   *
   * @param right
   *          value to be examined
   * @return the result of the equals operator
   */
  public final TSBoolean equality(final TSValue right) {
    // double d = Double.parseDouble("fefd");
    // System.out.println(d);
    // 1. if x,y are the same type
    if (this.getClass() == right.getClass()) {

      // 1.a if Type(x) is Undefined
      if (this.isUndefined()) {
        return TSBoolean.create(true);
      }
      // 1.b if Type(x) is NULL
      else if (this.isNull()) {
        return TSBoolean.create(true);
      }
      // 1.c if Type(x) is Number
      else if (this.getClass() == TSNumber.class) {
        TSNumber x = this.toNumber();
        TSNumber y = right.toNumber();

        if (x.isNaN()) // x is NaN
          return TSBoolean.create(false);
        else if (y.isNaN()) // y is NaN
          return TSBoolean.create(false);
        else if (x.getInternal() == y.getInternal()) // x == y
          return TSBoolean.create(true);
        else if (Math.abs(x.getInternal()) == 0.0
            && Math.abs(y.getInternal()) == 0.0) // x, y -- +0, -0
          return TSBoolean.create(true);
        else
          return TSBoolean.create(false); // not equal
      }
      // 1.d Type(x) is string, x==y
      else if (this.getClass() == TSString.class) {
        if (this.toStr().getInternal().equals(right.toStr().getInternal()))
          return TSBoolean.create(true);
        else
          return TSBoolean.create(false);
      }
      // 1.e Type(x) is boolean, x==y
      else if (this.getClass() == TSBoolean.class) {
        if (this.toBoolean().getInternal() && right.toBoolean().getInternal())
          return TSBoolean.create(true);
        else if (!this.toBoolean().getInternal()
            && !right.toBoolean().getInternal())
          return TSBoolean.create(true);
        else
          return TSBoolean.create(false);
      }
      // 1.f object...

      // else return false
      else
        return TSBoolean.create(false);
    }
    // 2. Type(x) is null, Type(y) is undefined
    else if (this.isNull() && right.isUndefined()) {
      return TSBoolean.create(true);
    }
    // 3. Type(x) is undefined, Type(y) is null
    else if (this.isUndefined() && right.isNull()) {
      return TSBoolean.create(true);
    }
    // 4. Type(x) is number, Type(y) is string
    else if (this.getClass() == TSNumber.class
        && right.getClass() == TSString.class) {
      if (right.toNumber() == null)
        return TSBoolean.create(false);
      else
        return equality(right.toNumber());
    }
    // 5. Type(x) is string, Type(y) is number
    else if (this.getClass() == TSString.class
        && right.getClass() == TSNumber.class) {
      if (this.toNumber() == null)
        return TSBoolean.create(false);
      else
        return this.toNumber().equality(right);
    }
    // 6. Type(x) is boolean
    else if (this.getClass() == TSBoolean.class) {
      return this.toNumber().equality(right);
    }
    // 7. Type(x) is boolean
    else if (right.getClass() == TSBoolean.class) {
      return equality(right.toNumber());
    }
    // 8. ...
    // 9. ...
    // 10. false
    else {
      return TSBoolean.create(false);
    }
  }

  /**
   * Perform a relational comparison. "this" is the left operand and the right
   * operand is given by the parameter.
   *
   * @param right
   *          value to be examined
   * @return the result
   */
  public final TSValue relationalComparison(boolean leftFirst,
      final TSValue right) {
    TSPrimitive px, py;
    // 1. LeftFirst is true
    if (leftFirst == true) {
      px = this.toPrimitive();
      py = right.toPrimitive();

    }
    // 2. LeftFirst is false
    else {
      py = this.toPrimitive();
      px = right.toPrimitive();
    }
    // 3. Type(px) or Type(py) are not string
    if (px.getClass() != TSString.class || py.getClass() != TSString.class) {
      TSNumber nx = px.toNumber(); // 3.a
      TSNumber ny = py.toNumber(); // 3.b
      if (nx.isNaN())
        return TSUndefined.value; // 3.c
      if (ny.isNaN())
        return TSUndefined.value; // 3.d
      if (nx == ny)
        return TSBoolean.create(false); // 3.e
      if (nx.getInternal() == +0.0 && ny.getInternal() == -0.0)
        return TSBoolean.create(false); // 3.f
      if (nx.getInternal() == -0.0 && ny.getInternal() == +0.0)
        return TSBoolean.create(false); // 3.g
      if (nx.getInternal() == Double.POSITIVE_INFINITY)
        return TSBoolean.create(false); // 3.h
      if (ny.getInternal() == Double.POSITIVE_INFINITY)
        return TSBoolean.create(true); // 3.i
      if (ny.getInternal() == Double.NEGATIVE_INFINITY)
        return TSBoolean.create(false); // 3.j
      if (nx.getInternal() == Double.NEGATIVE_INFINITY)
        return TSBoolean.create(true); // 3.k
      if (nx.getInternal() < ny.getInternal())
        return TSBoolean.create(true); // 3.l
      else
        return TSBoolean.create(false);
    }
    // 4. Type(px) and Type(py) are both string
    else {
      String s_px = px.toString();
      String s_py = py.toString();
      // 4.a py is a prefix of px
      if (s_px.startsWith(s_py))
        return TSBoolean.create(false);
      // 4.b px is a prefix of py
      if (s_py.startsWith(s_px))
        return TSBoolean.create(true);
      // 4.c k is the smallest nonnegative integer that px[k] != py[k]
      int k = 0;
      int small = Math.min(s_px.length(), s_py.length());
      while (k < small) {
        if (s_px.charAt(k) == s_py.charAt(k))
          k++;
        else
          break;
      }
      // 4.d m = px[k]
      int m = px.toString().charAt(k);
      // 4.e n = py[k]
      int n = py.toString().charAt(k);

      // 4.g m<n, then return true, otherwise false
      if (m < n)
        return TSBoolean.create(true);
      else
        return TSBoolean.create(false);
    }
  }

  /**
   * Perform a smaller-than comparison. "this" is the left operand and the right
   * operand is given by the parameter.
   *
   * @param right
   *          value to be examined
   * @return the result of the less-than operator
   */
  public final TSBoolean smaller(final TSValue right) {
    TSValue r = relationalComparison(true, right);
    if (r.isUndefined())
      return TSBoolean.create(false);
    else
      return r.toBoolean();
  }

  /**
   * Perform a greater-than comparison. "this" is the left operand and the right
   * operand is given by the parameter.
   *
   * @param right
   *          value to be examined
   * @return the result of the greater operator
   */
  public final TSBoolean larger(final TSValue right) {
    TSValue r = relationalComparison(false, right);
    if (r.isUndefined())
      return TSBoolean.create(false);
    else
      return r.toBoolean();
  }

  //
  // test for null and undefined
  //

  /**
   * Is this value Undefined? Override only in TSUndefined and TSReference.
   *
   * @return true or false, is this value the undefined value?
   */
  public boolean isUndefined() {
    return false;
  }

  /**
   * Is this value null? Override only in TSNull and TSReference.
   *
   * @return true or false, is this value the null value?
   */
  public boolean isNull() {
    return false;
  }

}
