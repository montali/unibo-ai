# A final Scala example

Today we're gonna take a look at _An empirical comparison of seven programming languages_, a paper written in 2000 that compares seven programming languages by asking 7 teams of programmers to solve problems in their language, then comparing these solutions through _problem length, memory consumption, reliability and so on..._

The problem is the following:

_The idea is to consider a particular way of tarnslating sentences (i.e. sequences of letters) into sequences of digits. This translation is based on the Phonecode, an encoding inspired by old mobile phones. Different sentences could generate the same phone code! When we perform the transformation in the opposite direction, we could generate several sentences. The problem is implementing such an opposite translation_.

We'll first have to create a map between letters and digits, using the `for` construct to extract the correspondencies between digits/letters, then we extract each letter as another generator, and for each of these pair we produce a key/value pair, starting from a letter to a digit.

```scala
val mnem = Map('2'-> "ABC", '3'-> "DEF") // and so on...
val charCode: Map[Char, Char] =
for {
  (digit, str) <- mnem
  ltr <- str
} yield ltr -> digit
```

In this case a string is used as a standard collection, on which we execute the higher order function `Map`.

We then continue with a very compact function that performs a lot of work. The idea is to have a function that, given a sequence of digits, returns all the possible words in our vocabulary such that our phonecode generates that sequence of digits. Now we then want to create a Map that given a sequence of digits, returns all the words in the vocabulary that generate that.

```scala
val wordsForNum: Map[String, Seq[String]] =
word groupby wordCode withDefaultValue Seq()
```

This is a map, but it can be used as a function.

Then, we can define an `encode` function that takes a number as input and recurses until there are no numbers to be translated. In a unique `for` construct, the first line considers a suffix to be translated with a recusrive call, while the prefix will be taken by `wordsForNum`. We finally create the sentence by placing word in front of the rest.

```scala
def encode(number: String): Set[List[String]] =
if (number.isEmpty) Set(List())
else {
	for {
    split <- 1 to number.length
    word <- wordsForNum(number take split)
    rest <- encode (number drop split)
  } yield word::res
}.toSet
```

Now, what is the expected return? Is it a set? If we didn't add the `toSet`, we'd get an indexed sequence and not a set. Note that by choosing a set, we have guaranteed protection from **duplicates**!

# MapReduce

Originally a Google project, now defines a tipology of big data elaboration model.
This idea of elaboration mimics chemical reactions, where milions of reactions between molecules occur in parallel, with the computational power of thousands of cores running in parallel in a data center.

This requires a new programming paradigm with respect to classical programming styles. Two phases are used. In phase 1 input data, given in a collection, is divided in paralellizabled batches and passed through a function (equivalent to the map() higher order function we used in Scala). In the second phase elaborated data, composed by many collections, is reduced to a final output, in a similar way to scala reduce(). The map() is highly parallelizable and this allows operation on enormous datasets.

Scala is particulary useful with this paradigm, for example when used in Apache Spark. Spark implements distributed collections called RDDs. nothing changes when using an RDD as a collection (the same functions are used), but computational load is automatically distributed when using higher order functions such aas map() and reduce().
