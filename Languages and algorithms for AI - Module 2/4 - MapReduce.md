# MapReduce

Originally a Google project, now defines a tipology of big data elaboration model.
This idea of elaboration mimics chemical reactions, where milions of reactions between molecules occur in parallel, with the computational power of thousands of cores running in parallel in a data center.

This requires a new programming paradigm with respect to classical programming styles. Two phases are used. In phase 1 input data, given in a collection, is divided in paralellizabled batches and passed through a function (equivalent to the map() higher order function we used in Scala). In the second phase elaborated data, composed by many collections, is reduced to a final output, in a similar way to scala reduce(). The map() is highly parallelizable and this allows operation on enormous datasets.

Scala is particulary useful with this paradigm, for example when used in Apache Spark. Spark implements distributed collections called RDDs. nothing changes when using an RDD as a collection (the same functions are used), but computational load is automatically distributed when using higher order functions such aas map() and reduce().