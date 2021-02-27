object PatternMatchingTest {

  /** Insertion sort algorithm
    */
  def isort(xs: List[Int]): List[Int] = xs match {
    case List()  => List()
    case y :: ys => insert(y, isort(ys))
  }

  def insert(x: Int, xs: List[Int]): List[Int] = xs match {
    case List()  => List(x)
    case y :: ys => if (x < y) x :: xs else y :: insert(x, ys)
  }

  /** Merge sort algorithm
    */
  def msort(xs: List[Int]): List[Int] = {
    val n = xs.length / 2
    if (n == 0) xs
    else {
      def merge(xs: List[Int], ys: List[Int]): List[Int] =
        /*      xs match {
        case List() => ys
        case x :: xs1 =>
          ys match {
            case List() => xs
            case y :: ys1 =>
              if (x < y) x :: merge(xs1, ys)
              else y :: merge(xs, ys1)
          }
         */
        (xs, ys) match {
          case (List(), ys) => ys
          case (xs, List()) => xs
          case (x :: xs1, y :: ys1) =>
            if (x < y) x :: merge(xs1, ys)
            else y :: merge(xs, ys1)
        }
      val (fst, snd) = xs splitAt n
      merge(msort(fst), msort(snd))
    }
  }

  def time[R](block: => R): R = {
    val t0 = System.nanoTime()
    val result = block // call-by-name
    val t1 = System.nanoTime()
    println("Elapsed time: " + (t1 - t0) / 1000000 + "ms")
    result
  }

  def main(args: Array[String]) {
    println("Insertion sort: " + isort(List(4268, 5471, 2548, 2798, 9521, 3521, 9789, 2189)))
    println("Merge sort: " + msort(List(4268, 5471, 2548, 2798, 9521, 3521, 9789, 2189)))

    val numList = List.fill(1000)(100000).map(scala.util.Random.nextInt)

    time(isort(numList))

    time(msort(numList))

  }
}
