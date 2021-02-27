/**
 * T is invariant
 * U = T => InvariantExample[U] = InvariantExample[T]
 */
class InvariantExample[T](x: T) {
    def get: T = return x
}

/**
 * T is covariant
 * U <: T => InvariantExample[U] <: InvariantExample[T]
 */
class CovariantExample[+T](x: T) {
    def get: T = return x
}

/**
 * T is contravariant
 * U <: T => InvariantExample[U] >: InvariantExample[T]
 */
class ContravariantExample[-T](x: T) {
    def get: T = return x
}

class Base {
  def f = println("Base class")
}

class Derived extends Base {
  override def f = println("Derived class")
  def g = println("Derived class")
}

object CovarianceTest {
  def main(args: Array[String]) {
    def inv: InvariantExample[Base] = new InvariantExample[Derived](new Derived)
    /*
    ERROR! Accepts ONLY Base
    Error thrown by the compiler:
        type mismatch;
          found   : InvariantExample[Derived]
          required: InvariantExample[Base]
        Note: Derived <: Base, but class InvariantExample is invariant in type T.
        You may wish to define T as +T instead.
     */

    def cov: CovariantExample[Base] = new CovariantExample[Derived](new Derived)
    // OK, accepts Base and subtypes, CovariantExample[Base] <: CovariantExample[Derived]

    def con: ContravariantExample[Base] = new ContravariantExample[Derived](new Derived)
    /*
    ERROR! Accepts Base and its supertypes
    Error thrown by the compiler:
      type mismatch;
        found   : ContravariantExample[Derived]
        required: ContravariantExample[Base]
     */
  }
}
