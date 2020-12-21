/** Higher-Order Functions (HOF) example
  * Create (in various ways) a function that sums the result of a function on all the Ints in a a range
  * In latex terms, we want \sum_{x=a}^{b}{f(x)}
  */
object HigherOrderSum {
  def main(args: Array[String]) = {
    println("Sum numbers from 1 to 100 with sumA: " + sumA(x => x, 1, 100))
    println("Sum numbers from 1 to 100 with sumB: " + sumInts(1, 100))
    println("Sum numbers from 1 to 100 with mapReduce: " + sumInts3(1, 100))
    println("Sum squares from 1 to 100 with sumA: " + sumA(x => x * x, 1, 100))
    println("Sum squares from 1 to 100 with sumB: " + sumSquares(1, 100))
    println("Sum squares from 1 to 100 with mapReduce: " + sumSquares3(1, 100))
  }

  /** Sum function that accepts a function Int=>Int and range of Ints
    * For each element in the range the function is applied and all the values are summed
    *
    * @param f Transforming function
    * @param a Start of the number range
    * @param b End of the number range
    * @return Sum of the transformations
    */
  def sumA(f: Int => Int, a: Int, b: Int): Int = {
    if (a > b)
      0
    else
      f(a) + sumA(f, a + 1, b)
  }

  /** Sum function template, accepting function as argument
    *
    * @param f Transforming function
    * @return Sum of the transformations
    */
  def sumB(f: Int => Int): (Int, Int) => Int = {
    def sumF(a: Int, b: Int): Int =
      if (a > b) 0 else f(a) + sumF(a + 1, b)

    sumF
  }

  def sumInts = sumB(x => x)
  def sumSquares = sumB(x => x * x)
  def sumCubes = sumB(x => x * x * x)

  /** Alternative notation for the sum function template
    *
    * When specializing the function it will be necessary to specify the parameters
    * As a shorthand, an underscore ("fold left") operator can be used instead of the parameters
    * The underscore denotes that we are not immediately interested in instanciating the arguments and we want to use the default ones
    *
    * @param f Transforming function
    * @param a Start of the number range
    * @param b End of the number range
    * @return Sum of the transformations
    */
  def sumC(f: Int => Int)(a: Int, b: Int): Int =
    if (a > b) 0 else f(a) + sumC(f)(a + 1, b)

  //def sumInts2(a: Int, b: Int) = sumC(x => x)(a, b)
  def sumInts2 = sumC(x => x) _
  //def sumSquares2(a: Int, b: Int) = sumC(x => x*x)(a, b)
  def sumSquares2 = sumC(x => x * x) _
  def sumCubes2 = sumC(x => x * x * x) _

  /** Product function template, accepting function as argument
    *
    * @param f Transforming function
    * @param a Start of the number range
    * @param b End of the number range
    * @return Product of the transformations
    */
  def product(f: Int => Int)(a: Int, b: Int): Int =
    if (a > b) 1 else f(a) * product(f)(a + 1, b)

  def factorial(n: Int) = product(x => x)(1, n)
  def sumFactorials = sumB(factorial)

  /** Generalization of the previous sum/product higher order functions
    * The type of binary operation executed on the transformed value is specified in the "operator" parameter
    *
    * @param f Transforming function
    * @param operator Binary operator applied at each step on the transformed value and the current state
    * @param zero Starting value for the accumulation (in math terms, give the binary operator, this is the identity element)
    * @param a Start of the number range
    * @param b End of the number range
    * @return Accumulation the results of the transformations with the operator
    */
  def mapReduce(f: Int => Int, operator: (Int, Int) => Int, zero: Int)(
      a: Int,
      b: Int
  ): Int =
    if (a > b) zero
    else operator(f(a), mapReduce(f, operator, zero)(a + 1, b))

  // We will use the _+_ and _*_ notations  as a shorthand to pass the sum and multiplication operators
  //def sumInts3 = mapReduce(x => x, (x,y)=>x+y, 0) _
  def sumInts3 = mapReduce(x => x, _ + _, 0) _
  //def sumInts3 = mapReduce(x => x*x, (x,y)=>x+y, 0) _
  def sumSquares3 = mapReduce(x => x * x, _ + _, 0) _
  //def factorial3(n: Int) = mapReduce(x => x, (x,y)=>x*y, 1) (1, n)
  def factorial3(n: Int) = mapReduce(x => x, _ * _, 1)(1, n)
}
