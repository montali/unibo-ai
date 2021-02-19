class Rational(x: Int, y: Int) {
  // By writing (x: Int, y: Int) we implicitly declare two integer
  // variables x (numerator) and y (denominator) and two parameters
  // required by the default constructor which will be used to initialize them.
  // The whole class body will be used as the default constructor body.

  private def gcd(a: Int, b: Int): Int =
    if (b == 0) a
    else gcd(b, a % b)

  val numer = x / gcd(x, y)

  val denom = y / gcd(x, y)

  def neg = new Rational(-numer, denom)

  // Method identifiers can be operators:

  //def add(r: Rational) = new Rational(numer * r.denom + r.numer * denom, denom * r.denom)
  def +(r: Rational) =
    new Rational(numer * r.denom + r.numer * denom, denom * r.denom)

  //def sub(r: Rational) = add(r.neg)
  def -(r: Rational) = this + (r.neg)

  //def less(r: Rational) = numer * r.denom < r.numer * denom
  def <(r: Rational) = numer * r.denom < r.numer * denom

  def max(r: Rational) =
    //if (this.less(r)) r
    if (this < r) r
    else this

  override def toString = numer+"/"+denom 
}

object RationalTest {
  def main(args: Array[String]) {
    val r1 = new Rational(10, 6)
    val r2 = new Rational(5, 3)
    println("10/6 + 5/3 = " + (r1+r2))
    println("10/6 - 5/3 = " + (r1-r2))
    println("10/6 < 5/3 ? " + (r1<r2))
    println("max(10/6, 5/3) = " + r1.max(r2))
    
    // Unary mathods identifiers can be used as infix
    println("max(10/6, 5/3) = " + (r1 max r2))
  }
}
