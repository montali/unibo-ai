import Math.abs

object FixPoint {
  def main(args: Array[String]) = {
    println("sqrt(1) = " + sqrt(1))
    println("sqrt(2) = " + sqrt(2))
    println("sqrt(4) = " + sqrt(4))
    println("sqrt(9) = " + sqrt(9))
    println("sqrt(10000) = " + sqrt(10000))
  }

  def fixPoint(f: Double => Double) = {
    val tolerance = 0.00001
    def isCloseEnough(x: Double, y: Double) = abs((x - y) / x) < tolerance
    def iterate(guess: Double): Double = {
      val next = f(guess)
      if (isCloseEnough(guess, next)) next
      else iterate(next)
    }
    iterate(1.0)
  }

  // Let's try implementing Newton method for sqrt with higher order functions and fixPoint()

  //def sqrt(x: Double) = fixPoint(y => x / y)
  // Computation diverges with some values (like 2) because it keeps looping between two values
  // We can solve this by averaging successive values

  def average(f: Double => Double, g: Double => Double) = 
    (x: Double) => (f(x) + g(x)) / 2
  def sqrt(x: Double) = fixPoint(average(y => y, y => x / y))
}
