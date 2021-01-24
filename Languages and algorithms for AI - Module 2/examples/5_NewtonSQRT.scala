object NewtonSQRT {
  def main(args: Array[String]) = {
    println("sqrt(1) = "+sqrt(1))
    println("sqrt(2) = "+sqrt(2))
    println("sqrt(4) = "+sqrt(4))
    println("sqrt(9) = "+sqrt(9))
    println("sqrt(10000) = "+sqrt(10000))
  }

  /** Compute the square root of a number using the Newton method:
    * We have an input r and we want to find x = sqrt(r)
    * Suppose f'(x)=x and f(x)=r/x
    * We are searching the intersection of the two function (such that r=x^2)
    * Approximate x with z_1, z_2, ..., sqrt(r) until desired estimation precision
    * z_1 is arbitrary
    * z_{n+1} = z_n + (f'(z_n) + f(z_n))/2
    * 
    * We implement the algorithm recursively
    * It would also be possible to implement it iteratively
    * Typically the iterative implementation would be faster (it would not have an overhead for new local variables)
    * Scala however optimizes the execution in case of TAIL RECURSION (such as this example) making it as fast as iterative
    * Tail recursion is a kind of recursion where
    *   - the recursive call is the last call of the function
    *   - the value returned by the recursive call is returned without being touched
    *
    * @param z Input value
    * @return Square root of the input value
    */
  def sqrt(z: Double) = {
    /** Recursive estimation computation
      *
      * @param guess
      * @param x
      * @return
      */
    def sqrtIter(guess: Double, x: Double): Double =
      if (isGoodEnough(guess, x)) guess
      else sqrtIter(improve(guess, x), x)

    def improve(guess: Double, x: Double) =
      (guess + x / guess) / 2

    /** Is estimation precision good enough?
      *
      * @param guess
      * @param z
      * @return
      */
    def isGoodEnough(guess: Double, z: Double) =
      //Math.abs(guess * guess - z) < 0.001 // Absolute error
      Math.abs(guess * guess - z) / z < 0.001 // Relative error
    
    // We use z_1 = 1.0
    sqrtIter(1.0, z)
  }
}
