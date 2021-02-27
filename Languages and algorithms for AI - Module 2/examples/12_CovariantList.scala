/** Immutable parametric covariant list
  */
trait List[+T] {
  def isEmpty: Boolean

  def head: T

  def tail: List[T]

  /** Append an item to the list
    *
    * If we used "append(e:T): List[T]" we would get an error
    * This is because in return position we should have a fixed type or a lower bound
    * T has instead an upper bound since is marked as covariant (+T)
    *
    * More in general:
    * - A type declared contravariant cannot appear as a return type (and cannot appear as type lower bound)
    * - A type declared covariant cannot appear as a parameter type (and cannot appear as type upper bound)
    *
    * This is the error message that we would get:
    *   covariant type T occurs in contravariant position in type T of value e
    *
    * Hence, we will use a type U with T as lower bound and use it as parameter type
    * Of course now the return list can contain elements of type U which is more generic than T so we must return List[U]
    */
  def append[U >: T](e: U): List[U]
}

class ConsList[T](val head: T, val tail: List[T]) extends List[T] {
  def isEmpty = false
  def append[U >: T](e: U) = new ConsList[U](head, tail append e)
}

object NilList extends List[Nothing] {
  def isEmpty = true
  def head = throw new NoSuchElementException("Nil.head")
  def tail = throw new NoSuchElementException("Nil.tail")
  def append[U](e: U) = new ConsList[U](e, NilList)
}

class Base {
  def f = println("Base Class")
}

class Derived extends Base {
  override def f = println("Derived Class")
  def g = println("Derived Class")
}

/*
object CovarianceTest {
  def isort(xs: List[Int]): List[Int] = xs match {
    case List()  => List()
    case y :: ys => insert(y, isort(ys))
  }

  def insert(x: Int, xs: List[Int]): List[Int] = xs match {
    case List()  => List(x)
    case y :: ys => if (x < y) x :: xs else y :: insert(x, ys)
  }

  /** Quick-sort
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
    isort(List(4268, 5471, 2548, 2798, 9521, 3521, 9789, 2189))
    msort(List(4268, 5471, 2548, 2798, 9521, 3521, 9789, 2189))

    val numList = List.fill(1000)(100000).map(scala.util.Random.nextInt)

    time(isort(numList))

    time(msort(numList))

  }
}
*/