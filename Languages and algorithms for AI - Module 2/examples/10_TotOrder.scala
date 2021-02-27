class NewRational(x: Int, y: Int) {
  val numer = x
  val denom = y
  override def toString = numer + "/" + denom
}

class Segment(x: Int, y: Int) {
  val x_axis = x; val y_axis = y
  override def toString = "<" + x_axis + "," + y_axis + ">"
}

trait TotallyOrderable[T] {
  def compare(r: T): Double
  // positive if this is greater
  def >(r: T) = (this compare r) > 0
  def <(r: T) = (this compare r) < 0
  def >=(r: T) = !(this < r)
  def <=(r: T) = !(this > r)
}

trait Multipliable[T] {
  def sum(r1: T, r2: T): T
  def zero: T
  def *(x: Int) = multip(x, zero)
  private def multip(x: Int, acc: T): T =
    if (x == 0) acc else multip(x - 1, sum(this.asInstanceOf[T], acc))
}

/** Totally orderable rational number
  */
class OrderableRational(x: Int, y: Int)
    extends NewRational(x, y)
    with TotallyOrderable[OrderableRational] {
  def compare(r: OrderableRational) = (numer * r.denom - r.numer * denom)
}

/** Totally orderable segment from the origin to a certain point on the cartesian plane
  */
class OrderableSegment(x: Int, y: Int)
    extends Segment(x, y)
    with TotallyOrderable[OrderableSegment]
    with Multipliable[OrderableSegment] {
  def compare(r: OrderableSegment) = (
    Math.sqrt((x_axis * x_axis) + (y_axis * y_axis)) -
      Math.sqrt((r.x_axis * r.x_axis) + (r.y_axis * r.y_axis))
  )

  def zero = new OrderableSegment(0, 0)

  def sum(r1: OrderableSegment, r2: OrderableSegment) =
    new OrderableSegment(r1.x_axis + r2.x_axis, r1.y_axis + r2.y_axis)
}

object TotallyOrderableTest {
  def main(args: Array[String]) {
    val fiveThirds = new OrderableRational(5, 3)
    val fourThirds = new OrderableRational(4, 3)
    val segment = new OrderableSegment(1, 3)
    println("5/3 > 4/3 ? " + (fiveThirds > fourThirds))
    println("5/3 > 5/3 ? " + (fiveThirds > fiveThirds))
    println("4/3 > 5/3 ? " + (fourThirds > fiveThirds))
    println("seg = " + segment)
    println("seg*2 = " + (segment * 2))
  }
}

/*object TotallyOrderableQuickTest extends TotallyOrderable {
  // object can directly extend traits
}*/
