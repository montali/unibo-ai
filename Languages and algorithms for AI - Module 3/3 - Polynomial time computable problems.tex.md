# Polynomial time computable problems

It's now time to take a look at what it means to solve a task in a **reasonable amount of time**: our notion of computability, even though it specifies the actual time which is needed, doesn't say much about what it means for such a function to bound the time to be small enough. We have also seen exercises having a time of computation which is linear: the function bounding the time is a linear function. 

Is it small enough? Too big? A time is reasonable if **polynomial**. We want the task to be computable with resource bounds: a reasonable amount of time and space. When the input string gets bigger, the amount of time grows, but not *too much*. Beware: when we work with a complexity class we are not talking about a set of machines, rather of tasks (functions/languages). Of course we can say that a machine works in polynomial time, though this doesn't mean that the machine is part of that class. We want to classify tasks, not machines. We'll work with tasks given by **decision problems**, i.e. we work with subsets of the set of all binary strings. 

A TM deciding the language runs in time $n \rightarrow c \cdot T(n)$. The letter *D* in $DTIME$ refers to **determinism**: the machine works deterministically. These are the kind of machines we have already studied. They cannot *branch and decide*, i.e. working in non-deterministic ways. We could base our analysis on these classes.

Why do we need something robust? Let's first define this robustness: we need a class which is not just in the form $DTIME(t)$, but in the union of these classes $P$, defined as the union on all the constants $c$ of $DTIME(n^c)$: a problem is in $P$ if ti can be solved by a TM working deterministically and taking polynomial time. Why is that? The $c$ is arbitrary, we take the union of all the possible $c$, i.e. the quadratic, cubic,... times. It is a rather big class, but as long as $c$ is finite, it is still polynomial. 

So, why are we considering this class? One of the reasons lies in the *Church-Turing thesis*. One may wonder why TM are an appropriate basis for computer complexity theory. Every computer can be simulated by a TM with an overhead in time, so the class of computable tasks would not be larger if formalized as so. This is a thesis: it's impossible to prove it for all possible architectures, but most scientists believe in it and nobody has still found a counterexample. Then, there's a **strong** version of this, having to do with complexity rather than computability: we've said that the overhead may be very large, and in this thesis we impose the constraint that the actual overhead **must be polynomial**. According to this thesis, the class $P$ would be the **exact same**, provided that it holds. If it holds and a problem can be solved in polynomial time with any hardware, it can be solved in polynomial time with a TM. Of course the exponent will grow, though. This thesis is more controversial, for example due to quantum computation. 

Why polynomials? First of all, $P$ is robust: they seem to be the smallest çlass of bounds which make $P$ robust. Then, exponents are often quite small: we could object to the fact that they can be arbitrarily big. We may be right, but usually we get quadratic/cubic bounds. Finally, we can well say that the class $P$ is closed under various operations on programs, in particular composition and bounded loops. Suppose that you have one problem which can be spelled out as the composition of 2 different problems, like solving the problem of multiplying two numbers by iterating additions. As a result, it is pretty easy to prove that a problem is in the class: it suffices to give an algorithm and prove that it solves in polynomial time.

There are downsides too. One of these is that it is based on worst cases: the definition of $P$ says that there must be one signle polynomial and one TM such that for every input... If for example, a problem requires linear time in most of the cases and exponential time in just one case, we cannot conclude that the problem is in $P$. This is a quite big problem. There are then alternative computational problems giving birth to other classes, like BPP or BQP. Finally, not all problems can be expressed as decision problems but just as functions. 

## FP class

We'd like to classify functions instead of languages. A function is in the class $FDTIME$ if there is a TM computing $f$ in time proportional to $T(n)$ for some constant $c$. 
$$
\mathbf{F P}=\bigcup_{c \geq 1} \mathbf{F D T I M E}\left(n^{c}\right)
$$
Obviously, if we have a characteristic function $f$ for a language which is in $P$, $f$ will be in $FP$.

We can turn functions into languages (the inverse is obvious - is it?) in some canonical ways. 

Some examples of problems in this class might be introduced with **lists**, like scanning them, inverting them, sorting them...

## Proving a task being in P or FP

Now, how do we actually prove if a task is in P or FP? In most cases, we'll be allowed to use pseudocode describing an algorithm that actually solves the problem. This is much easier to write than a TM. We'll want to prove that the input can be encoded as a binary string, that all the instructions take polynomial time to be simulated.

## EXP

There is one last thing: a class bigger than $P$, $EXP$. This is a superset.



