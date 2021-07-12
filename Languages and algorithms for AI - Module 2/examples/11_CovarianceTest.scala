// A <: B <=> A subtype of B
// A :> B <=> A >: B <=> A supertype of B <=> B <: A

/**
 * Scala: [T] <=> Invariant with respect to T <=> Java: <T>
 * 
 * U = V => InvariantExample[U] = InvariantExample[V]
 * Variables of type InvariantExample[W] accept only instances of InvariantExample[W] 
 */
class InvariantExample[T](x: T) {
    def get: T = return x
}

/**
 * Scala: [+T] <=> Covariant with respect to T <=> Java: <? extends T>
 * 
 * U <: V => CovariantExample[U] <: CovariantExample[V]
 * Variables of type CovariantExample[V] accept only instances of CovariantExample[U] with U <: V (U is V or subtype of V)
 */
class CovariantExample[+T](x: T) {
    def get: T = return x
}

/**
 * Scala: [-T] <=> Contravariant with respect to T <=> Java: <? super T>
 * 
 * U <: V => ContravariantExample[U] :> ContravariantExample[V]
 * Variables of type ContravariantExample[V] accept only instances of ContravariantExample[U] with U :> V (U is V or supertype of W)
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
    ERROR! InvariantExample[Base] accepts ONLY Base
    Error thrown by the compiler:
        type mismatch;
          found   : InvariantExample[Derived]
          required: InvariantExample[Base]
        Note: Derived <: Base, but class InvariantExample is invariant in type T.
        You may wish to define T as +T instead.
     */

    def cov: CovariantExample[Base] = new CovariantExample[Derived](new Derived)
    // OK, CovariantExample[Base] accepts Base and subtypes, CovariantExample[Base] <: CovariantExample[Derived]

    def con: ContravariantExample[Base] = new ContravariantExample[Derived](new Derived)
    /*
    ERROR! ContravariantExample[Base] accepts Base and its supertypes
    Error thrown by the compiler:
      type mismatch;
        found   : ContravariantExample[Derived]
        required: ContravariantExample[Base]
     */
  }
}
