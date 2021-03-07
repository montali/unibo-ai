/** EXERCISE
  * Implement the brute force algorithm for the n-queens problem
  * A solution is represented as a Vector[Int] with n values:
  *   at each position i, the vector contains the column of the
  *   queen on line i
  * Find all possible solutions (return a Set[List[Int]])
  */
object N_Queens {
  def queens(n: Int) = {
    def isSafe(col: Int, queens: Vector[Int]): Boolean = {
      val row = queens.length
      val queensWithRows = (0 until queens.length) zip queens
      queensWithRows forall (p =>
        (col != p._2) && (math.abs(col - p._2) != row - p._1)
      )
    }

    def placeQueens(k: Int): Set[Vector[Int]] = {
      if (k == 0) Set(Vector())
      else
        for {
          queens <- placeQueens(k - 1)
          col <- 0 until n
          if isSafe(col, queens)
        } yield queens :+ col
    }
    placeQueens(n)
  }

  def show(queens: Vector[Int]) = {
    val lines =
      for (col <- queens)
        yield Vector.fill(queens.length)(" *").updated(col, " X")

    ("\n" +: (lines flatMap (l => l :+ "\n"))).mkString
  }

  //queens(5)

  def main(args: Array[String]) {
    queens(5) map show
  }
}
