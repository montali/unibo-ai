object QuickSort {
  // Original WRONG comment create an array of random 10000 random ints
  // Correct: create an array of random 1000 random ints in [0, 100000[
  val r = scala.util.Random
  val randomArray = (for (i <- 1 to 1000) yield r.nextInt(100000)).toArray

  def main(args: Array[String]) = {
    // do the sorting
    val sortedArray = quickSort(randomArray)
    // print the ordered array
    sortedArray.foreach(println)
  }

  // the quicksort recursive algorithm
  def quickSort(xs: Array[Int]): Array[Int] = {
    if (xs.length <= 1) { // Empty array or array with single element
      xs // Reteturn the array itself
    } else { // Array with more than one element
      val pivot = xs(xs.length / 2)
      Array.concat(
        //quickSort(xs filter (pivot >)),
        quickSort(xs filter (pivot > _)),
        //quickSort(xs filter ((x) => (pivot > x))),
        //xs filter (pivot ==),
        xs filter (pivot == _),
        //xs filter ((x) => (pivot == x)),
        //quickSort(xs filter (pivot <))
        quickSort(xs filter (pivot < _))
        //quickSort(xs filter ((x) => (pivot < x)))
      )
    }
  }
}
