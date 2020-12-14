import java.io._

/** Implementation of the complex number
  *
  * @param a Real part
  * @param b Imaginary part
  */
class Complex(val a: Double, val b: Double) {
  def +(that: Complex) = new Complex(this.a + that.a, this.b + that.b)
  def *(that: Complex) = new Complex(
    this.a * that.a - this.b * that.b,
    this.a * that.b + that.a * this.b
  )
  def abs() = Math.sqrt(this.a * this.a + this.b * this.b)
}

/** The Mandelbrot set is the set of complex numbers such that ..(..((c)^2+c)^2+c)^2..+c)^2.. is finite in abs value
  *
  * To be more clear:
  * z_0(c) = 0
  * z_1(c) = c
  * z_2(c) = c^2 + c
  * z_3(c) = (c^2 + c)^2 + c
  * ...
  * z_i(c) = z_{i-1}(c)^2 + c
  *
  * c is part of the Mandelbrot set iff z_infinite(c) is finite in absolute value.
  * Of course we are not able to sum infinite time so we will approximate
  */
object Mandelbrot {
  def main(args: Array[String]) = {
    //val fileName = "/Users/zavattar/IdeaProjects/IntroductionToScala/scalaimage.pgm"
    val fileName = "scalaimage.pgm"

    /** Create a square black and white image depicting the mandlebot set
      *
      * @param n Image side size
      * @param level Max deptth (max i of the z_i(c) function)
      */
    def run(n: Int, level: Int): Unit = {
      val out = new FileOutputStream(fileName)
      out.write(("P5\n" + n + " " + n + "\n255\n").getBytes())

      // Serial iteration
      //for (j <- (0 until n * n)) {

      // Parallel iteration
      var a = new Array[Int](n * n)
      for (j <- (0 until n * n).par) {

        // Generate the x coordinate of the position in the image
        val x = -2.0 + (j % n) * 3.0 / n
        // Generate the x coordinate of the position in the image
        val y = -1.5 + (j / n) * 3.0 / n
        // Create the zero complex as reference
        var z = new Complex(0, 0)
        // Create the complex number for the current position in the image
        var c = new Complex(x, y)
        // Genzerate the z
        // Equivalent to for(i=0; z.abs < 2 && i < level; i++) { z = z * z + c}
        // z.abs < 2 => Test for convergence
        // i < level => Test for max depth
        var i = 0
        while (z.abs < 2 && i < level) { z = z * z + c; i = i + 1 }
        // i => Depth reached before the value diverged
        // i == level => Max depth reached
        // level-i => depth left until the max depth
        // (level - i) / level => Variable which represents a normalized distance from divergence

        // Only for serial iteration
        //out.write(255 * (level - i) / level)
      }

      // Only for parallel iteration
      for (k <- 0 until n * n) out.write(a[k])

      out.close()
    }

    run(1000, 50)
    // During lesson on professr's dual core computer serial took 5995ms while parallel took 4812ms
  }
}
