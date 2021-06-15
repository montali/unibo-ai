# A Glimpse in Computational Learning Theory

#### Table of Contents

<a name="intro"/> 

## Learning Problems as Computational Problems
Any learning algorithm _A_ computes a function _fA_ whose input is a finite sequence of **labelled data** and whose output is a **classifier**, so **learning problems** can be seen as computational problems.

![image](https://user-images.githubusercontent.com/31796254/122075503-6a11c680-cdfa-11eb-842b-34b5d82863fa.png)

Training data are **labelled** to let _fA_ learn what relationship exists between data and labels, while data that the classifier _C_ takes in input are no labelled, because _C_'s tas is to find the appropriate label for each of them.

_A_ can be seen as a TM if we assume that a real number can be encoded in a binary string and that _A_ can be a randomized algorithm (i.e. it can perform randomized steps).

The confidence is the probability that the output a of _A_ is a valid classifier _C_, while the accuracy is the probability that _C_ classifies data correctly.



## The algorithm _A\_BFP_

To make things easy let's take an example:
we want learn a rectangle (shape and position in the plane) having in input a set of point labelled as positive (belonging to the rectangle) or negative (not belonging to it).
We know that rectangle's edges are parallel to rhe axis.

We can define the algorithm **_A\_BFP_** as follows:
 1. Given the data _((x1, y1), p1), ..., ((xn, yn), pn)_, where _(xi, yi)_ represents the i-th point _pi_ tells if that point is a positive instance;
 2. Determine the smallest rectangle _R_ with edges parallel to the axes enclosing all the positivie instances;
 3. Return _R_

The output of **_A\_BFP_** can be really different from the target rectangle _T_, but this doesn't means that **_A\_BFP_** is incorrect.
Indeed we can define the **probability of error** in using _R_ as a replacement of _T_ (with distribution of the input data **D**) as:

![image](https://user-images.githubusercontent.com/31796254/122074860-de983580-cdf9-11eb-9593-2b8895b72bfd.png)

As the number of samples **D** grows, the probability of error of _R_ approaches 0, even if _R_ does not necessarly approach to _T_.
So **_A\_BFP_** is (approxiamtely) correct.

## The General Model

### Some terminology

Now let's study things froma mor general point of view. Instead of points we will have no better specified **objects**, and instead of a plane with points we have an **instance space _X_**, which is the set of (encondings of) instances of objects the learner wants to classify.
Data from _X_ are generated through a distribution **D**, unkwown to the learner.

**Concepts** are subsets of X and they can be thought as properties that objects can have (So, a concept will be a set containing all the objects with a certain property).

A **concept class _C_** is a collection of concepts, namely a subset of the [powerset](https://en.wikipedia.org/wiki/Power_set) of _X_. It includes all the concepts sufficiently simple to describe and to be handled by an algorithm.

Between all the concepts contained in the concept class we call **target concept** the concept the learner wants to build a classifer for.

### The learning algorithm _A_

The learner **doesn't know** the target concept nor the distribution **D**. 

The interface of any learning algorithm _A_ can be described as follows:

![image](https://user-images.githubusercontent.com/31796254/122079337-9aa72f80-cdfd-11eb-9fc2-c9a9fa511073.png)

where:
 - _delta_ and _epsilon_ are respectively the coinfidence and the accuracy, as described [above](#intro).
 - _EX_(_c_, **D**) is the _oracle_: a procedure that _A_ can call whenever it wants to and which returns in output an element _x_ of **D**, labelled according whether it is in _c_ or not (where _c_ is a concept in _C_).
