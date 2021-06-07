# Solved Exercises
Solutions provided here are not the _official_ ones from professor, but are made by me.
Even if I have verified almost all the results with a compiler, be careful with the provided solutions.

## Exam 01/14/21

### 1
Consider the following excerpt of code:
```scala
class A (val x:Int) {
  def m1 = x+1
}

class B (k: Int, val z: Int) extends A(k) {
  override def  m1 = z-1
  def m2 = m1
}

val z:A = new B(5,3)

println(z.m2)
```

**Solution:**
No, it isn't correct. Even if is possible to assign to a variable of type ```A``` an istance of its subclass ```B```,
then it will not possible to access to ```m2``` without casting ```z``` to ```B```.
If the print is replaced with ```println(z.asInstanceOf[B].m2)``` the output will be 2.

### 2
Describe by words and by means of an example the foldRight higher order function

**Solution:**
```foldRight``` can be invocated on a list of objects of type T passing it an object of type T and a function (T,T) => T. It will pass the element of the list and the result of the previous application to the function passed as arguement. The value passed as arguement will be passed to the function when the list is over.
Example:
```scala
List(1, 3, 7).foldRight(5)(_ - _) == (1 - (3 - (7 - 5))) == 0
```

### 3
What does the following function compute?
```scala
def mystery2(l: List[String]) =
  (0 :: (l map (_.length))) reduce (_ + _)
```
 Justify your answer

**Solution:**
This function compute the sum of the lenghts of the strings in the list ```l``` passed as arguement. Indeed it maps each string to its length. Then it append a 0 to the List obtained with the mapping, in order to avoid exceptions with list with only one elements.
At the end, it sums all the elements in the list with the ```reduce``` higher order function.

### 4
What is the type and the result of the evaluation of the following expression:
```scala
for {
  i <- Set(2, 3)
  j <- 1 to i
  k <- i to 2 by -1
} yield (j,k)
```
**Solution:**
The type returned by a ```for yield``` expression is determined by the type of the first collection in the for body. In this case we have a ```Set```, which is a trait, so the returned type will be one of its implementations.
In particular, when the returned object has 5 or more elements, its type will be ```HashSet```. In our case ```HashSet[(Int, Int)]```.
So the returned object, keeping in mind that sets have no order and repeated elements, will be:
```scala
HashSet((1,2), (2,2), (1,3), (2,3), (3,3), (3,2))
```

### 5
Consider the following function:
```scala
def mystery(n:Int) =
  List(2,3,5,7) takeWhile (n%_ == 0)
```
and the following expression:
```scala
mystery(42)
```
What is the result and the evaluation of the above expression?
Justify your answer.

**Solution:**
Recalling that the ```takeWhile``` higher order function returns all the elements of a list while a certain condition is satisfied, the evaluation of the above expression is the following:
```scala
mystery(42) ==
List(2,3,5,7) takeWhile(42%_ == 0) ==
List(2,3)
```

## Exam 06/11/20

### 1
Consider the following declarations:
```scala
val S = Set(1,3,4,7)
val S2 = S ++ (S map (_+1))
```
What is the type and the value of S2? 
Justify your answer.

**Solution:**
Recalling that```++``` is the concatenation operator, ```S2``` is evaluated in the folloing way:
```scala
S2 == S ++ (S map (_+1)) ==
Set(1,3,4,7) ++ (Set(1,3,4,7) map (_+1)) ==
Set(1,3,4,7) ++ Set(2,4,5,8) ==
Set(1,2,3,4,5,7,8)
```

### 2

Consider the following expression:
```scala
(List(3,9,12) foldLeft 4)(_ - _)
```
Describe its evaluation and the final computed value.

**Solution:**
```scala
(List(3,9,12) foldLeft 4)(_ - _) ==
((4 - 3) - 9) - 12 ==
(1 - 9) - 12 ==
-8 - 12 ==
-20
```

### 3
Consider the following function:
```scala
def mystery(f: Int=>Int, x: Int): Int = f(x+1)
```
What is the result of the evaluation of the following expression:
```scala
List(5,1,3) map (x => x+mystery(_+1, x+1))
```
Justify your answer.

**Solution:**
The expression is evaluated in the following way:
```scala
List(5,1,3) map (x => x+mystery(_+1, x+1)) ==
List(5,1,3) map (x => x + x+1+1+1) ==
List(5,1,3) map (x => x + x + 3) ==
List(13, 5, 9)
```

### 4 
The following function mystery3 is not tail recursive:
```scala
def max(x1: Int, x2: Int) = if (x1>x2) x1 else x2
def mystery3(l:List[Int]):Int =
  if (l == Nil) 0
  else max(l.head,mystery3(l.tail))
```
Write an equivalent tail recursive function.

**Solution:**
Recalling that in a tail recursive function the recursive call must be the last thing evaluated by the function, we write this formulation of the function ```mystery3```:
```scala
def mystery3(l: List[Int]): Int = {
  def r(m: Int, l: List[Int]) =
    if (l == Nil) m
    else r(max(m, l.head), l.tail)
  
  r(0, l)
}
```

### 5
What does the following function compute?
```scala
def mystery2(l: List[Int]) =
  (0 :: (l filter (_ < 100) map (x=>1))) reduce (_ + _)
```

**Solution:**
The function ```mystery2``` computes the number of integers smaller than 100 contained in the list ```l```.
Indeed, it remove from ```l``` all the elements equal or greater than 100 with the ```filter``` higher order function.
Then it maps all the remained elements to 1 with the ```map``` higher order function and appends a 0 with the ```::``` operator, in order to avoid exceptions when the list ```l``` has only one element.
At the end, it sums all the elements in the list with the ```reduce``` higher order function. The value obtained, as said above, is exactly the number of elements in ```l``` smaller than 100.
  
## Exam 07/07/2020

### 1
Consider the following function:
```scala
def mystery(l:List[Int],f:Int=>Boolean)=
  ((l filter f) foldLeft 0) (_ + _)
```
and the following expression:
```scala
mystery(List(5,2,7,9,21,15), ((x) => (5<x) && (x<16)))
```
What is the result of the evaluation of the above expression?
Justify your answer.

**Solution:**
The above expression is evaluated as follows:
```scala
mystery(List(5,2,7,9,21,15), ((x) => (5<x) && (x<16))) ==
((List(5,2,7,9,21,15) filter ((x) => (5<x) && (x<16))) foldLeft 0) (_ + _) ==
(List(7, 9, 15) foldLeft 0) (_ + _) ==
((0 + 7) + 9) + 15 ==
31
```

### 2

What does the following function compute?
```scala
def mystery2(l:List[Int]) = {
  def f(l:List[Int]):List[Int]=
    if (l.isEmpty) List(0)
    else (l takeWhile (_ == l.head)).length ::
      f(l dropWhile (_ == l.head))

  f(l).max
}
```
Justify your answer.

**Solution:**
The function ```mystery2``` returns the length of the longer sequence of equal elements in the list ```l```. If ```l``` is empty, ```mystery2``` returns 0.
Indeed, the function ```f(l)``` returns ```List(0)``` when ```l``` is empty, otherwise it replace the first sequence of equal elements with its length and then it is recursively reapplied on the rest of the list, obtaining a result list which contains the lengths of all the sequences of equal numbers in ```l```.
Then ```mystery2``` returns the max of such list.
Example:
```scala
mistery2(List(1,1,1,5,5,2,8,8) ==
f(List(1,1,1,5,5,2,8,8)).max ==
List(3,2,1,2).max ==
3
```

### 3
Are the following declarations correct or not?
```scala
val x1: List[String] = List[Nothing]()
val x2: Array[String] = Array[Nothing]()
```
Justify your answer.

**Solution:**
The first declaration is correct, but the second one is incorrect. ```Array[T]``` is a mutable object, so it not should accept covariance, indeed it is invariant in type ```T```.

### 4
Consider the following excerpt of code:
```scala
class A (val x:Int) {
  def get = x+1
}

class B (k:Int) extends A(k) {
  override def get = x-1
}

val z:A = new B(5)

println (z.get)
```
What is printed? Justify your answer.

**Solution:**
It prints 4, because, even if ```z``` is of type ```A```, the object assigned is of type ```B```, so the ```get``` method of class ```A``` is overridden by the ```get``` method of the subclass ```B```.

### 5
Describe by words and by means of an example the ```groupBy``` higher-order function.

**Solution:**
```groupBy``` is called on a collection of ```T``` and takes as arguement a function ```T => S```. It groups all the elements of the collection by the results of the passed function and returns them as a ```Map``` object.
Example:
```scala
List("abc", "def", "gh", "ijkl", "mnop", "q").groupBy(x => x.length) ==
HashMap(1 -> List("q"), 2 -> List("gh"), 3 -> List("abc", "def"), 4 -> List("ijkl", "mnop"))
```












