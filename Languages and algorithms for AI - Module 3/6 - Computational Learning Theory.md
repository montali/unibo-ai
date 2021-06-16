# A Glimpse in Computational Learning Theory

#### Table of Contents

 - [Learning Problems as Computationa Problems](#intro)
 - [The Algorithm _A\_BFP_](#example)
 - [The General Model](#general_model)
   + [Some Terminology](#terminology)
   + [The Learning Algorithm _A_](#A)
   + [PAC Concept Classes](#PAC)
 - [Representation Classes](#representation_classes)
   + [Boolean Functions as Representation Class](#boolean)
 - [Learning Conjunctions of Literals](#conjunctions)
 - [Intractability of Learning DNFs](#DNF)
 - [Is This the End of the Story?](#end)
   + [Some Books to Learn More](#books)

<a name="intro"/> 

## Learning Problems as Computational Problems
Any learning algorithm _A_ computes a function _fA_ whose input is a finite sequence of **labelled data** and whose output is a **classifier**, so **learning problems** can be seen as computational problems.

![image](https://user-images.githubusercontent.com/31796254/122075503-6a11c680-cdfa-11eb-842b-34b5d82863fa.png)

Training data are **labelled** to let _fA_ learn what relationship exists between data and labels, while data that the classifier _C_ takes in input are no labelled, because _C_'s tas is to find the appropriate label for each of them.

_A_ can be seen as a TM if we assume that a real number can be encoded in a binary string and that _A_ can be a randomized algorithm (i.e. it can perform randomized steps).

The confidence is the probability that the output a of _A_ is a valid classifier _C_, while the accuracy is the probability that _C_ classifies data correctly.

<a name="example"/>

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

<a name="general_model"/>

## The General Model

<a name="terminology"/>

### Some terminology

Now let's study things froma mor general point of view. Instead of points we will have no better specified **objects**, and instead of a plane with points we have an **instance space _X_**, which is the set of (encondings of) instances of objects the learner wants to classify.
Data from _X_ are generated through a distribution **D**, unkwown to the learner.

**Concepts** are subsets of X and they can be thought as properties that objects can have (So, a concept will be a set containing all the objects with a certain property).

A **concept class _C_** is a collection of concepts, namely a subset of the [powerset](https://en.wikipedia.org/wiki/Power_set) of _X_. It includes all the concepts sufficiently simple to describe and to be handled by an algorithm.

Between all the concepts contained in the concept class we call **target concept** the concept the learner wants to build a classifer for.

<a name="A"/>

### The learning algorithm _A_

The learner **doesn't know** the target concept nor the distribution **D**. 

The interface of any learning algorithm _A_ can be described as follows:

![image](https://user-images.githubusercontent.com/31796254/122079337-9aa72f80-cdfd-11eb-9fc2-c9a9fa511073.png)

where:
 - _𝛿_ and _ε_ are respectively the coinfidence and the accuracy, as described [above](#intro).
 - _EX_(_c_, **D**) is the _oracle_: a procedure that _A_ can call whenever it wants to and which returns in output an element _x_ of **D**, labelled according whether it is in _c_ or not (where _c_ is the target concept).

_A_ returns a concept _h_ approximating _c_. We can compute the error of _h_ as:

![image](https://user-images.githubusercontent.com/31796254/122189371-2c13b180-ce91-11eb-91a8-106b2af425c5.png)

Note that this is a theoretical representation, what happens in practice is usually different: _𝛿_ and _ε_ are not input parameters of _A_, but they are estimated after that _h_ has been returned. However, this is still a valid theorethical model.

<a name="PAC"/>

### PAC (Probably Approximately Correct) Concept Classes
Let _C_ be a concept class over the instance space _X_. We say that _C_ is **PAC learnable** iff there is an algorithm _A_ such that for every _c_ ∈ _C_, for every distribution **D**, for every 0 < _ε_ < ½, for every 0 < _𝛿_ < ½, then

![image](https://user-images.githubusercontent.com/31796254/122191235-d809cc80-ce92-11eb-8214-ca0e9a21f193.png)

where the probability is taken over the calls to _EX_(_c_, **D**)

If the time complexity of _A_, measured taking into account the number of calls to _EX_(_c_, **D**), is polynomially bounded in _1/𝛿_ and _1/ε_, we say that _C_ is **efficiently PAC learnable**.

Note that our [example problem](#example) is efficiently PAC learnable.

<a name="representation_classes"/>

## Representation Classes
In our definition of efficient PAC learning, _A_, having no access to the target concept _c_, must work in polynomial time **independently** on _c_.

We assume concepts in _C_ can be represented as binary strings, and each concept _e_ ∈ _C_ requires _size_(_e_) bits. We talk of a **representation class**.

#### Examples:
 - _X\_n_ could be {0,1}^_n_, which is the set of boolean vectors of fixed lenght _n_, and _Cn_ is the set of all the substes of _X\_n_ **represented by CNFs**.
 - _X\_n_ could be **R**^_n_, which is the set of vectors of real numbers of lenght _n_, and _Cn_ is the set of all the substes of _X\_n_ **represented by some form of neural network** with _n_ inputs and 1 output.

In many cases (e.g. SGD) we have a **single** algorithm _A_ that works for every value of _n_, in such a case we allow (in the definition of PAC learning) _A_ to take polynomial time in _n_, _size_, _1/𝛿_ and _1/ε_.

<a name="boolean"/>

### Boolean Functions as Representation Class

Let's take as instance class _X_ the set obtained by te unions of all the set of boolean vectors of fixed lenght _n_, for each _n_ ∈ **N** (so a union between _X\_n_, for each _n_ ∈ **N**).

A first example of a representation class for _X\_n_ is the class **CL**\__n_ of all **conjunctions of literals** on the variables _x1, x2, ..., xn_.  
So, as an example, the conjunction _x1_ ∧ ¬_x2_ ∧ _x4_ defines a subset of {0,1}^4.  
Note that not all subsets of {0,1}^_n_ can be captured this way.

A second example of a represantion class for _X\_n_ is the more famous class **CNF**\__n_ of CNFs over _x1, x2, ..., xn_ which are the **conjunctions of disjunctions of literals**.  
In this way all subsets of {0,1}^_n_ can be captured.

<a name="conjunctions"/>

## Learning Conjunctions of Literals

Suppose our target concept is a conjunction of literals _c_ on _n_ variables _x1, x2, ..., xn_.

Data are in the form (_s_, _b_), where _s_ is in {0,1}^_n_, while _b_ is a boolean telling us if _s_ ∈ _c_.

Our learning algorithm could proceed by keeping a conjunction of literal _h_ as its state, initally set to

_x1 ∧ ¬x1 ∧ x2 ∧ ¬x2 ∧ ··· ∧ xn ∧ ¬xn_

and updating it according to (_s_, _b_) when _b_ = 1. (When _b_ = 0 data are discarded).

#### Example:
 - _n_ = 3
 - current state of _h_: _x1 ∧ x2 ∧ ¬x2 ∧ ¬x3_
 - we receive (101, 1)
 - _h_ is updated to: _x1 ∧ ¬x2_

#### Theorem:
_The representation of a boolean conjunction of literal is efficiently PAC learnable._

<a name="DNF"/>

## Intractability of learning DNFs
We have just seen that conjunctions of literals are efficiently PAC learnable, however they are not a complete represenation of boolean functions.

Let's take a representation class which is **slighty more general** than conjunction of literals:
**3-term DNF** formulas over _n_ bits, which are formulas in the form _T1 ∨ T2 ∨ T3_, where each _Ti_ is a conjunction of literals over _x1, ..., xn_.

We can imagine it as the _dual_ of 3CNFs.

It is a more general class of conjunctions of literals, but still not universal.

#### Theorem:
_If_ **RP ≠ NP**_, then the representation class of 3-term DNF formulas is **not** efficiently PAC learnable_

<a name="end"/>

## Is This the End of the Story?

Not at all, we have just **scratched the surface** of computational learning theory. There many models and results that are not part of this course, such as:
 - The VC Dimension
 - The Foundamental Theorem of Learning
 - The No-Free Lunch Theorem
 - Occam's Razor
 - Positive and negative results aboutneural networks
 - ...

<a name="books"/>

### Some books to learn more:

 - Mehryar Mohri, Afshin Rostamizadeh, and Ameet Talwalkar. _Foundations of Machine Learning_ Second Edition. The MIT Press. 2018
 - Shai Shalev-Shwartz and Shai Ben-David. _Understanding Machine Learning: from Theory to Algorithms_ Cambridge University Press. 2014.
 - Michael Kearns and Umesh Vazirani. _An Introduction to Computational Learning Theory_. The MIT Press. 1994

#

[Previous section](5%20-%20ML%20and%20theory%20of%20computation.md) · [Solved exercises](Solved%20Exercises.md)

