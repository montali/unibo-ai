In the Theory of Computation, a process is taken to be an **algorithm**.

Giving a precise definition of algorithm isn't possible right now. We though want to be sure that we'll be able someday: we'll want to define whether a task can be solved or not with a given algorithm, and to do so, we **have to know what an algorithm is**. We know that algorithms must satisfy some constraints: it must be a finite description of a series of computation steps (maybe parallel, but the description must be finite, i.e. no infinite time to describe it), each step must be elementary (i.e. it must be basic, performable in a finite time), and the next step must always be deterministically determinable (given the state, there can always be found the next step; in other words, the process must be deterministic).

One could say that we could take a program and define it as the description of an algorithm. There's a little problem in this: it is a **very high-level description**, i.e. the instructions are pretty *esoteric*, we don't know what's actually happening under the hood. In this course, we will give a different/abstract/low-level definition.

How can we prove the non-existence of an algorithm to solve a given task? We could start by saying that this is very rarely possible: something can be said/done, but we're still at a point in which the techniques are very few and don't always work. 

## Sets and numbers

In this course, since we're dealing with computation, we might deal with finite or (at most) integer numbers. A condition $P(n)$ (with $n$ tipically quite big) holds for a sufficiently large $n$ if there's $N \in \mathbb{N}$ such that the condition holds for every $n>N$, i.e. from given moment it always holds. Let's consider the notation of the *floor function*, i.e. the smallest number of the set such that it is greater than all the elements in the set. We don't use the canonical base for logarithms $e$ but $2$.

### Strings

If we fix a finite set, thinking about it as an alphabet, we can form strings over this alphabet as finite or possibly empty tuples. This can also be taken as an alphabet of binary digits. The set of all the strings over a certain alphabet having $n$ length is indicated as $S^n$, for example $S^0$ is the set of empty strings. 

The concatenation of two strings $x$ and $y$ is $xy$. The concatenation by itself is indicated as $x^k$. Therefore, strings form a *monoid* (concept of algebra). Note that the neutral element is epsilon. The length is a natural number, indicated as $|x|$.

## Tasks

We have formally defined tasks (kind of problems we want to solve by computation devices). We'll take a *standard path* by saying that tasks are functions. We want to compute functions which link a binary set 0,1 to itself, meaning that the domain and codomain are equal to $\{0,1\}*$.

We don't consider tasks as functions on finite inputs, we just consider an infinite domain: we want to solve a problem not just on a finite amount of instances, but on infinitely many instances. We may want to obtain a string by flipping 0 and 1s, but we'll want to do this on strings of arbitrary length. 

Someone may ask *Well, if we consider a function that maps bitmap images, this has nothing to do with strings!* The point is that strings are a very peculiar discrete set, but they are flexbile enough to be able to represent many other data! When we say that we always assume the task to be given as a function, we're saying that the problem consists in mapping an element of A into an element of B.

 The encoding of any element $x$ of $A$ as a string is often indicated as \_x_.

Suppose that the strings in $S^*$ are composed of elements of $S=\{a,b,c\}$. Now, $a$ can be encoded as $00$, $b$ becomes $01$ and $c$ becomes $10$.

Now, what happens if we start to construct more complex domains, like couples of strings? For example,  

Another interesting class of functions is the one in which the length of the strings is exactly one: **boolean functions**.
These are also known as *characteristic functions*, and they are related to decision problems because, for example, in these we'll want to decide whether a string is good/bad, part of a set/not...

### Asymptotic notation

Asymptotic notation allows to compare the rate of growth of two functions, for example a function and a functions we take a limits on the amount of resources we want to devote to solving a particular problem.
We are now concerned with functions dedicated to natural numbers.

Let's consider two function $f:\mathbb{N}\to\mathbb{N}$ and $g:\mathbb{N}\to\mathbb{N}$, we want to compare them as per their rate of growth. We'd like to be able to say if $f$ grows faster than $g$, asymptotically speaking:
- $f$ is $\mathbf{O(g)}$ if it grows asymptotically less or as  much as $g$ ($\exists c \in \mathbb{R}^+ : f(n) \le c * g(n)$ for sufficiently large $n$);
- $f$ is $\mathbf{\Omega(g)}$ if it grows asymptotically more or as much as $g$ ($\exists c \in \mathbb{R}^+ : f(n) \ge c * g(n)$ for sufficiently large $n$).
- $f$ is $\mathbf{\theta(g)}$ if it grows asymptotically in the same way ($f$ is both $O(g)$ and $\Omega(g)$).

So, showing that two functions $f$ and $g$ are comparable, is made by studying the limit of the ratio $\frac{f(n)}{g(n)}$ for $n\rightarrow\infty$ and proving that it is constant. 

#
[Previous section](0%20-%20LAAI%20-%20Module%203%20Intro.md) · [Next section](2%20-%20The%20computational%20model.md)


