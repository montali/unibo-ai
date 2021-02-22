# Functional programming

Functional programming is a programming style that is grwoing in popularity because it allows us to work on small, medium and big quantities of data without having to do much changes. The same program can be executed locally or on distributed systems. 

First, some basic concepts (that we actually already introduced): traditionally, functional programming is based on **expressions**, so we typicallly write an expression, evaluate it, and print the result. This is known as REPL (*Read-Eval-Print-Loop*). This characterizes the style we previously mentioned. Obviously, the most important is the evaluation. How are the expressions we write evaluated? There are simple rules that are followed, these are the rules for standard operator expressions:

- We evaluate the single operands that are passed to the operator, once all the parameters (from left to right) have been evaluated,
- we evaluate the operands,
- then, we apply the operator to the operands.

When we assign variables, a name is evaluated by replacing it with the right hand side of its definition. The evaluation process then stops once it results in a **value**.

Note that `def` and `val` differ in the sense that when you write `def` the right-hand side is not immediately evaluated. If we had a `def` instantiated with a sum, the sum wouldn't be computed at the time of instantiation. So, the environment knows that there is an expression, and the association value is not computed, though it will be computed in case the `def` will be used in a *formula*, while for now it just saves the sum as a sum. If we used `val`, the right-hand side would be immediately evaluated. Note that the every time a `def` is used in an expression, it is computed: the result is not saved.

Note that `def` will be used to define functions too:

```scala
def sumOfSquares(x:Double, y: Double) = 
	square(x)+square(y)
```

Scala is *lazy* in the evaluation of parameters, meaning that the evaluation of parameters is deferred as much as possible. 

![First approach](./res/sumofsquares.png)

![Second approach](./res/sumofsquares2.png)

As you can see, we may have two different evaluation strategies, leading to the same result. These are known as *call-by-value* (CBV) and *call-by-name* (CBN).
At the end, the two different strategies return the same result, but it is possible (in some cases) that one of them might infinitely loop and fail. 

They both reduce to the same values, **as long as**: there are no side-effects (no changing of the environment when the evaluation is performed) and both evaluations terminate. 

CBV has the advantage that it evaluates every function argument **just once**.

CBN has the advantage that a function argument is not evaluated if the corresponding parameter is not used in the evaluation of the function body.

We have side-effects where an evaluation of an expression changes the environment (i.e. the identifiers, their meanings, the constants, the body of the functions...). There are case in which, during the evaluation, the environment changes. When does this happen? If we for example define an identifier `var`, this allows us to change the value associated to this identifier, which has the side-effect of changing the environment, which before contained a different value for `x`.

The only way to have different results for CBV and CBN is having some modifications of the environment inbetween the two instants in which the evaluation starts and ends:

```scala
def f(x:Int) {
  y = y+1
  return x
}

y = 1
f(10+y)
```

Here, CBV would return 11, and CBN would return 12!

If we wanted to reimplement `&&` and `||`, we could do something like:

```scala
def and(x:Boolean, y:Boolean) = 
	if(x) y else false

def or(x:Boolean, y:Boolean) = 
	if(x) x else y
```

More info on variable types can be found [here](https://docs.scala-lang.org/overviews/scala-book/two-types-variables.html). To recap:

| Variable type | Lazy/Eager? | Stored? | Constant? |
| ----- | ----- | ----- | ----- |
| `def` | Lazy | Not stored | Yes |
| `val` | Eager | Stored | Yes |
| `lazy val` | Lazy | Stored | Yes |
| `var` | Eager | Stored | No |

An important feature of Scala is higher order functions.
An example can be found [here](examples/6_HigherOrderSum.scala).

## Classes

We'll now start aiming towards OOP. Let's imagine we had a class `Greeter` that allows us to declare **fields** and **methods**, i.e. functions that describe activities executable by the object. 

We'll consider, for this example, this class `Greeter`:

```scala
class Greeter {
  val message = "Hello!"
  def SayHi() = println(message)
}
```

that we can use as follows:

```scala
val greeter = new Greeter()
greeter.SayHi()
```

We can extend this class as follows:

```scala
class ItalianGreeter extends Greeter {
  override val message = "Ciao!"
}
val greeter_it: Greeter = new ItalianGreeter
```

Note that we can skip the `()` in the creation of an object if it has **no parameters**.

Remember that `val` indicates immutable identifiers: our `message` will never change, but it can be overridden through the `override` keyword. This can also be applied to methods. 

We can add a **parameter** to the class:

```scala
class GenericGreeter(msg: String) extends Greeter {
  override val message = msg
}
val greeter_gen = new GenericGreeter("Bonjour!")
```

Note that we're considering the body of the class declaration as the body of the **default constructor**. 

We can even define other constructors:

```scala
class GenericWithDefaultGreeter(override val message: String) extends Greeter {
  def this() = this("Hallo Welt")
}
```

This adds a constructor without parameters `this()`, so the default behaviour will be `"Hallo Welt"`.

Every new constructor shall be linked to another one: when we add a new constructor, we should call another existing constructor in it, and so on, so that we build a calling chain that ends on the **default constructor**. 

Note that we previously generated objects specifying the type: `val greeter_it: Greeter = new ItalianGreeter()`. This explains the concept of **subtypes**: if a class extends another one, it will be a subtype of it.

We can say that `greeter_it` has the **static type** equal to `Greeter` (i.e. what the compiler expects), but inside the variable we can put objects of a different subtype, the **dynamic type** (i.e. what we put inside the `val` at runtime).

Another thing that shall be noted is that the behaviour of the `message` overriding in the last two code snippets is the same, we're just shortening the thing. 

### Abstract classes

Abstract classes are classes that are **not completely defined**. We may have an `AbstractGreeter` having a message variable, but missing its value:

```scala
class AbstractGreeter {
  val message: String
  def SayHi() = println(message)
}
```

Suppose that we perform a `new` on this: we'll fail because we're missing some content! We'll therefore have to **create an actual class** extending this abstract one:

```scala
class SpanishGreeter extends Greeter {
  val message="Hola!"
}
```

Note that we removed the `override`, since there is **no overriding** happening. Leaving it would still not cause any problems: it is **optional** indeed.

We'll use classes to represent data and data structures. 

We could define a `Rational` (i.e. a numerator and a denominator) data type as a class, together with some useful methods:

```scala
class Rational (val x: Int, val y: Int) {
  def add(r: Rational) = new Rational(x*r.y +r.x*y, y*r.y)
  def neg = new Rational (-x, y)
  def sub(r: Rational) = add(r.neg)
}
```

We could even redefine operators, just by calling a function with the symbol. But how can we use this syntax on user-defined data types? We have to understand two things. When we have a unary method, infix notation can be used: `r add s` is equal to `r.add(s)`. Furthermore, we can call standard methods with the standard operators. If we use the infix notation on methods with these particular names, we can redefine the operators.

```scala
def + (r: Rational) = new Rational (num + r.denom + r.num * denom, denom*r.denom)
```

## Lists

If the array is the typical data structures in imperative programming, **lists** are the ones for functional programming.

We'll start by defining the **emtpy list**, `nil`, then every other list is just an extension of it, consisting in the head, and the rest of the list: `cons(h, l)`.

Imagine that we have a list `[1,2,3]` in memory, so that we save the first element, and a pointer to the rest of the list:

![Lists](./res/lists.png)

We have two operations: `head` and `tail`, used to access the two values in the structure.

`l1.head` would therefore be `1`, while `l1.tail` would be `[2,3]`.

We could therefore define a list `l2` as `cons(4, l1.tail)`, being equal to `[4,2,3]`.

This could only be done in **immutable** lists: if we modified `l1`, `l2` would change too!