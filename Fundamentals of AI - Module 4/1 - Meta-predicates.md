# Meta-predicates

[Recording](https://web.microsoftstream.com/video/b6be2a31-03da-4341-a7c5-f5b6e94de852)

One of the things that make prolog great is that predicates and terms have the same syntactical structure: we could exchange and exploit them in different roles!

This is  a feature that was available from the beginning, and it has been exploited in a great number of applications that did reasoning. Why? It was possible to represent Knowledge bases as **rules**, using them as the program or as data. We could therefore create programs with these to do different tasks. The same feature has been achieved in modern programming languages only recently.

This idea of having programs passed as parameters is interesting: think about lambdas in python!

## Built-in Predicates

### `call(T)`
The first predicate we're interested in is `call(T)`, having the effect that the term `T` is considered as an atom (a predicate) and prolog evaluates it. We could obviously mix this up with other things. The meaning is *take `X` as a variable that probably has been bound to a program, and try to prove such a goal*.

### `fail`
Another one is the `fail`: each evaluation of this **fails**. This forces the program to look for alternatives. `fail` can be used for many things:

#### `not(P)`
`fail` can be used for ezample to implement negation:
```prolog
not(P):- call(P), !, fail.
not(P).
```
The predicate `not`: `not(P)` is true if `P` is not a consequence.

This behaviour is already available with the built-in predicate `\+(P)`, which is also faster, since relies on many optimizations.

#### Default behaviour vs exceptions
It's a common case in a knowledge base to have a default behaviour and some exceptions to it. For example all birds fly, but some exceptions, as the penguin and the ostrich. This can be implemented with a combination of `cut` and `fail`

```prolog
% Exceptions
fly(X) :- penguin(X), !, fail.
fly(X) :- ostrich(X), !, fail.

% Default behaviour
fly(X) :- bird(X).
```

### `setof(X,P,S)` and `bagof(X,P,L)`
`setof(X,P,S)` returns the set (ideally without repetitions, some intepreters ignore this and leave repetitions) of instances `X` that satisfy `P`. 
`bagof(X,P,L)` returns the list (possibly with repetitions) of instances `X` that satisfy `P`.
We can query sets/lists with a conjunction of parameters or a parameter only.
It basically returns those variables that verify the goal in a set.
We're asking the set for which the **query is true**.

Exmple:
```prolog
p(1).
p(2).
p(0).
p(1).
q(2).
r(7).

:- setof(X, p(X), S).
% yes S = [0,1,2]

:- bagof(X, p(X), S).
% yes S = [1,2,0,1]
```

### `findall(X,P,S)`
The `findall` returns the terms that satisfy the goal, **without repetitions**.

Example:
```prolog
father(giovanni,mario).
father(giovanni,giuseppe).
father(mario, paola).
father(mario,aldo).
father(giuseppe,maria).

:- findall(X, father(X,Y), S)
% yes S=[giovanni, mario, giuseppe]
% Equivalent to setof(X, Y^father(X,Y), S)
```

### Others
* `var(Term)`:true if Term is currently a variable
* `nonvar(Term)`: true if Term currently is not a free variable
* `number(Term)`: true if Term is a number
* `ground(Term)`: true if Term holds no free variables

## Reflection

Terms and programs have the same syntactic structure, but prolog supports reflection: it can explore its source code itself. Suppose we have a prolog program:

```prolog
h.
h :- b1,b2,...,bn.
```

They correspond to the terms:

```
(h, true)
(h, ','(b1, ','(b2, ','( ...','( bn-1, bn) ...)))
```

### `clause(Head, Body)`
The predicate `clause(Head, Body)` allows us to check if there exists such a clause `(Head, Body)`. Note that `Head` must be non-numeric, and `Body` can be a variable or a term.

Remember that everything starting with a capital or an underscore is a variable.

# Meta-interpreters

[Recording](https://web.microsoftstream.com/video/9ae90012-d375-4c8e-a65c-f724d8e165dd)

As we said, a term can be interpreted as a program or as a predicate. The idea behind meta-interpreters is that inputs are not simple data but programs. We'll talk about this class of programs we use as input, **meta-interpreters**. They are not passed at all, but they allow us to do rapid prototyping. In Prolog a meta-interpreter for a langugage `L` is defined as an interpreter for L, but written in Prolog. 

Even though we could write Prolog interpreters in all the languages (e.g. Python, Java, C...), we couldn't write a **Prolog interpreter in Prolog**. 

### Vanilla meta-interpreter
The starting point is the **vanilla meta-interpreter**, i.e. defineing a predicate `solve` that takes a goal as input and returns true iff the goal is provable using the current KB. the solution is the following:

```prolog
solve(true) :- !.
solve( (A,B) ) :- !, solve(A), solve(B).
solve(A) :- clause(A,B), solve(B).
```

If we query the goal with true, the program is true. Otherwise, we could invoke clause with `(A,B)` as args, 

If you look at it, it represents the behaviour of the prolog interpreter: if we have a conjunction, the leftmost part is solved first, then the remaining part is. `clause` returns the possible conjunctions of `A` and `B`.

An objection might be *ok, this does nothing, why would we want to do this?* This would be right: it is just the starting point for constructing many other different meta-interpreters, changing its behaviour.

### Rright-most interpreter
We could for example invert the order of selection, obtaining a **right-most interpretation**:

```prolog
solve(true) :- !.
solve( (A,B) ) :- !, solve(B), solve(A).
solve(A) :- clause(A,B), solve(B).
```

The `!` in the second rule avoids loops.

