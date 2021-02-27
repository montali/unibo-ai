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

The full commented example cand be found in [1_QuickSort.scala](examples/1_QuickSort.scala).

## Scala's collection

Scala offers some data structures, provided by the standard libraries, called **collections**. These are equiped with useful higher-order functions, which we'll use often when exploiting the possibilities of the standard collections.

They allow us to *prettify* the code, since we can delegate fucntions to these.

Take a read to *An empirical comparison of several programming languages*, a paper containing the same problems solved with different languages. We can see that Scala showed an easiness and shortness of the code that led to less lines of code, written in less time.

An example of usage of collections can be found in [2_T9.scala](examples/2_T9.scala).

## Multithreaded programming

Scala provides parallel collections too: this enables us to exploit parallel threads, where the data are split in separated groups and elaborated in parallel, then the results are combined. 

This obviously improves the performances of our programs. 

We can consider the possibility to have several collaborating threads (independent executions), performing work parallelly. They *collaborate* in the sense that they sync, avoiding thread locks and threats.

We'll have our parallel architecture with independent nodes, that work at the same time in order to ocmplete the manipulation behind the higher order function. If we take advantage of the parallel architecture our same program will be executed in this parallel way. We won't use the stanard lubrary collections, but the ones from the *parallel library*. We can cast the collections to this type.

The *Mandelbrot set* example consists of computing what is known as the *Mandelbrot set*, a set of complex numbers, being composed of a pair of real numbers in which the second one is multiplied by the imaginary unit, $i$.

The Scala Mandelbrot example can be found in [3_Mandelbrot.scala](examples/3_Mandelbrot.scala).

# Spark

Spark is the platform we'll use to speriment Scala large-scale data processing. We need to move from a single computing node to a distributed context. 

What we'll experiment will be the programming style we studied, but with some specific features related to Spark that we'll need to study in order to adapt the programming style in the distributed setting.

**RDD** stands for *Resilient Distributed Dataset*, where *Resilient* means that Spark offers some fault-prevention mechanisms.

A small example of usage of Spark can be found in [4_PageRank.scala](examples/4_PageRank.scala).

# Exam

Written examination for Module 2, first date in June. 6 dates for the academic year: 3 in June/july, 1 in september, 2 in the winter.

It's composed of 5 open questions, usually simple. The time will be 50 minutes (more or less 10 minutes per question).

One type may be about interpretation of code, asking to comment a snippet of code, then some questions about the meaning of functions, like *groupby*...

The exam doesn't ask to write code from scratch, rather to interpret pieces of code or theoretical questions (like *What is an higher order function?*).

Possibility of an alternative project work, proposed by the student and presented to the prof. 

This could be used as the 3-points project work for the MSc. 





