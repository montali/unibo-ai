// Management of lists in functional programming:
//nil => empty list
//cons(x,l) => concatenate the element x to the list y

abstract class IntSet {
  def add(x: Int): IntSet
  def union(x: IntSet): IntSet
  def contains(x: Int): Boolean
}

// Equivalent of nil
class Empty extends IntSet {
  def isEmpty = true

  def contains(x: Int): Boolean = false

  def add(x: Int): IntSet = new NonEmpty(x, new Empty, new Empty)

  def union(x: IntSet): IntSet = x

  override def toString = "."
}

//Equivalent of cons
class NonEmpty(elem: Int, left: IntSet, right: IntSet) extends IntSet {
  def isEmpty = false

  def contains(x: Int): Boolean =
    if (x < elem) left contains x
    else if (x > elem) right contains x
    else true

  def add(x: Int): IntSet =
    if (x < elem) new NonEmpty(elem, left add x, right)
    else if (x > elem) new NonEmpty(elem, left, right add x)
    else this

  def union(x: IntSet): IntSet = new NonEmpty(elem, left, right union x)

  override def toString = "{" + left + elem + right + "}"
}

object IntSetTest {
  def main(args: Array[String]) {
    var set: IntSet = (((new Empty) add 3 add 2) add 4)
    println("(Empty add 3 add 2) add 4 = " + set)
    println("4 in ((Empty add 3 add 2) add 4) ? " + (set contains 4))
    /*
        Empty   =>    3     =>       3      =>     3
                    /   \          /   \         /   \
                 Empty Empty      /   Empty     /     \
                                 /             /       4
                                2  <-----------      /   \
                              /   \              Empty Empty
                           Empty Empty
     */
    var set2: IntSet = ((new Empty) add 5 add 6)
    println("((Empty + 3 + 2) + 4) union (Empty + 5 + 6) = " + (set union set2))
  }
}
