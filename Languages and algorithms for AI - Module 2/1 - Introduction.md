# LAAI - Module 2

This module deals with **programming languages** following a style that combines traditional approaches: 

- **Functional programming**, with *higher order functions*, meaning you do not separate functions from data, functinos that depend no something that is only known at runtime, becoming entities that can be manipulated
- **Object-oriented programming**, with generic classes

These two concepts are merged into an approach that we'll study in this module? Why will we? This style is adopted in modern platforms for large dataset manipulation, like *Apache Spark*, a ML library.

So, why do we need this prgorgamming style for manipulating large datasets? Considering traditional programming, we are not interested in using the programming style we're going to presetn. But we may get problems when manipulating large amounts of data. This new style will make it easier to scale problems when we re-organize and distribute the data, and it will help us distribute and coordinate the process. In some cases this programmin style is said **scalable**, simply because you can use the same approach to design a single-node application or a many-nodes application.

How is this possible? This is made possible by those distributed platforms, like *Spark*. This is diferernt from container orchestration in the sense that in that we replicate the same container, while in Scala the processes are not equal to each other, working on different data which has been split.

The scalability we mentioned in Scala is vertical scalability, while the container one is *horizontal*.

The idea is that in Spark, we have availability of computing resources, data and source code, and given the data to compute, the program to be executed and the nodes on which to execute those, the platform transparently decides on its own how, where and what to compute. 

It simply uses some resource manager to distribute the data and the source code and *orchestrate* the computation. Our application is designed in one way, and this design will be okay for single nodes execution or scaled execution too.

To use Scala code, we can use **SBT** (Scala Build Tool) and **IntelliJ IDEA**: Scala programs are translated in Java bytecode and executed on JVM. Scala was in fact born to improve Java in the sense of functionality.

Scala can be used in interactive mode too, like IPython.

In the `QuickSort` example, we see `object`, being a class we only instantiate once. We won't use the `class` keyword in this cases.

```scala
object QuickSort {
  // create an array of random 10000 random ints
  val r = scala.util.Random
  val randomArray = (for (i <- 1 to 1000) yield r.nextInt(100000)).toArray
  def main(args: Array[String]) = {
    // do the sorting
    val sortedArray = quickSort(randomArray) // print the ordered array 				sortedArray.foreach(println)
  }
    // the quicksort recursive algorithm
  def quickSort(xs: Array[Int]): Array[Int] = { if (xs.length <= 1) xs
    else {
      val pivot = xs(xs.length / 2) Array.concat(
      quickSort(xs filter (pivot >)), xs filter (pivot ==), quickSort(xs filter (pivot <))) // Note that those after filter are ultra-minimal lambdas, = to (x) =>(pivot>x)
      // The underscore does the same thing, instead of explicitly naming x
    } 
  }
}
```

the `QuickSort` object will auto-start itself once it is part of the JVM, starting the `main()` method, which calls `quickSort()`, then print the results.





