/** Immutable parametric covariant list
  */
trait CustomList[+T] {
  def isEmpty: Boolean

  def head: T

  def tail: CustomList[T]

  /** Append an item to the list
    *
    * If we used "append(e:T): CustomList[T]" we would get an error
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
    * Of course now the return list can contain elements of type U which is more generic than T so we must return CustomList[U]
    */
  def append[U >: T](e: U): CustomList[U]
}

class ConsList[T](val head: T, val tail: CustomList[T]) extends CustomList[T] {
  def isEmpty = false
  def append[U >: T](e: U) = new ConsList[U](head, tail append e)
}

/** Covariance allows us to prevent using "class NilList[T] extends CustomList[T]" and use a single object instead
  * Since CustomList[+T] is covariant we can use Nothing as T
  * This way NilList is a subtype of CustomList[Nothing], a subtype of any CustomList[T]
  */
object NilList extends CustomList[Nothing] {
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
