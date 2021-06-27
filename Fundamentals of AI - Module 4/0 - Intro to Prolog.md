# Fundamentals of AI - Module 4

[Recording](https://web.microsoftstream.com/video/fb6fe034-df9a-48cb-a2bf-13c7574fa4ac)

This part of the course is mainly devoted to a part of the *classical AI* (not related to ML) regarding reasoning using **rules**. Why rules? It's a form of reasoning that is common between humans.

What is curious is that after the explosion of ML/Deep Learning, currently ruled based approach (for knowledge representation) are widely used to provide *explanations*. Neural networks are not explainable at all, for example, while a model based on rules provides an easy way of explaining these.

The first third of our time will be devoted to system based rules and **Prolog**. 

We'll use it to understand how we can use rules to represent things. This lesson and the next one will specify how prolog will help us.

We'll start with some known concepts about Prolog.

We'll talk about knowledge bases: we want to build decision systems based on knowledge. The topic is therefore the introduction to the reasoning on knowledge using **rules**.

Why *rules?* It was quite evident, since the 1970s, that after some cognitive studies it emerged that humans use **rules**. These come useful instead of using long descriptions: they are a good way of sharing informations.

Another funny saying is that rules can be chained, they allow you to organize knowledge in term of layers, composed by many rules, that we can then merge to achieve a complex system. 

## Prolog

The SWIsh online IDE is suggested.

The difference between a predicate and a term is that the first one is either true or false, while the latter are the *objects of our dialogs*. For example, *Federico* may be a term, while *Marcello shared the slides* is a predicate.

The computation is *SLD resolution*, and prolog proceeds *left-most* and *depth-first*.

If we wanted to create a function `p` that doesn't take any argument and prints something:

```prolog
p :- print('Awesome!')
```

or maybe, with a variable:

```prolog
p(Message) :- print(Message)
```

what really changes from declarative languages is how the thing works. From the syntactic point of view, they are similar. 

Relational operators can be interpreted as true/false. We can compare expressions using these.

### Cut

The cut doesn't have any logical meaning, and doesn't have declarative semantics. It's *nasty low-level stuff*, but it **heavily affects the execution process**.

We have two stacks, the **execution stack** and the **backtracking stack** (open choice points).

Then, we know that prolog respects the definition order of clauses. 

CUT makes the choices that the program took **non-backtrackable**. The evaluation of cut always succeeds.
```prolog
p :- q_1, q_2, ..., q_i, !, q_i+1, q_i+2, ..., q_n
```
If the evaluation of `q_i+1, q_i+2, ..., q_n` fails, the whole `p` fails: even if there are alternatives for `p`, they have been removed by the cut.

The cut therefore removes branches of the SLD resolution. The cut allows us to achieve mutual exclusion between two clauses.

One famous use of the cut is to achieve mututal exclusion between two clauses. Indeed, the expression `if a(X) then b else c` can be written as:
```prolog
p(x) :- a(X), !, b.
p(X) :- c.
```

### Close world assumption

Basically, this means that everything that is not stated is false. For example, if we had a database for children, and we stated that Chesani had two children, Francesco and Chiara, we know that **Chesani has two children!** And not more.

### SLDNF

SLDNF is an extension of SLD to support negation. SLDNF is used in Prolog to implement the Negation as Failure.

Once we have variables in our goal, SLDNF is not safe anymore, hence Prolog implementation is not completely correct. Prolog implements the negation as failure, so prolog tries to prove not A to prove A.


Take for example:
```prolog
capital(rome).
chief_town(bologna).
city(X) :- capital(X).
city(X) :- chief_town(X).

?- ~capital(X), city(X).
```
When we write `~capital(X)` it translates to "Does an X exist such that it doesn't satisfy capital?". We are searching for a city that is not capital, and `bologna` satisfies this query. However Prolog checks out the first sentence (`capital(rome).`), sees that it does not satisfy `~capital(X)` and fails.

Hence, in Prolog we should apply negation only to ground facts.

Instead, in SLDNF, we are looking for a different formula: we wrote something intended "does an X exist for which that is true".

### Iterations

There are no iterations here! We may use **recursion**, though. We know that if we write a special type of recursion, i.e. *tail-recursion*, the computational cost in terms of space and time is exactly the same!

We also know that every recursive function **can be rewritten in tail recursive way!** This is a *deterministic operation*, so it could even be automated.



