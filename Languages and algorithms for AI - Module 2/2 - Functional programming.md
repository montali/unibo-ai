# Functional programming

First, some basic concepts (that we actually already introduced): traditionally, functinoal programming is based on **expressions**, so we typicallly write an expression, evaluate it, and print the result. This is known as REPL (*Read-Eval-Print-Loop*). This characterizes the style we previously mentioned. Obviously, the most important is the evaluation. How are the expressions we write evaluated? There are simple rules that are followed, these are the rules for standard operator expressions:

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

As you can see, we may have two different evaluation strategies, leading to the same result. These are known as *call-by-value* and *call-by-name*. At the end, the two different strategies return the same result, but it is possible (in some cases) that one of them might infinitely loop and fail. 

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



