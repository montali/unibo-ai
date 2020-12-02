# PROLOG

## List, arithmetic, data structures

In PROLOG are stated with capital letters, constants, functions and predicates lowercase. The rules have a conjunction of atoms, a :- and another conjunction of atoms. We are considering **SLD resolution**: we start from the goal and try to prove it. We have a **selection rule**, selecitng the leftmost atom, and the order of clauses is the syntactic order in the program, i.e. from top to bottom.

In PROLOG a list is represented by a term defined as: `[]` for the empty list, `[t1|t2]` for the list having `t1` as head, and `t2` as tail, note that it is not the second element, rather the **rest of the list**.

You can compute the number of elements using `length(L,N)`, where `N` is the length. Note that we don't really need numbers in these programs. In order to represent the numbers, it's ok to use a single constant (0) and its successors: `s(0)=1` with `s` being the successor function, `s(s(0))=2` and so on.

**Recursion** comes at hand when defining lists.

Assuming that the length of `L` is `N`, then the length of the list containing any element as head of the list, and the list as tail, will be `N+1`.  So we could basically take the program of the slides, and we should be able to compute the length of the list.

Then, to know if something is element of a list, we can use `member(X,L)`, that enables us to check whether `X` appears in the list `L`.

We can concatenate two lists with `append(L1, L2, L)`, where `L` is the resulting concatenation. Assume that appending L1 and L2 gives me L, then when I append `X | L1` and `L2`, I'll get `X|L`

A very important point is **how do I use this**? The first two lines are the program, the other ones the goal. Then, for the first line, the results will be `Z=[a,b,c]`. Now, what if we wanted the third element to be an input and the central one the output? Suppose that the result is `[a,c,e,f]`, the first element is `[X]`, and the central one `[c,Y]`. Now, the question is how can I define `Y` so that the result is `[a,c,e,f]`? The program can therefore compute `Y`.

Note that PROLOG is not typed. Now, we get to numbers. First of all, the modern PROLOG are constrained programming languages. The classic PROLOG have some pre-defined predicates which can be used in expressions. The predicates are the following: `is`, meaning that the values are unified, `=:=`, meaning that the values are equal, `=\=`, meaning that the values are different, and `>` meaning that one is greater than the other. 

## Constraint programming

We have seen that logic programming languages are **declarative**, and the idea is that you specify the problem and the computer solves it. Costraint programming goes a step forward. 

The idea is simple: using constraints (i.e. a conjunction of predicates, atomic formulas in terms of FOL), we can represent a problem. For example, if you know the domain of `x` and know that it is greater than 5, we can propagate the constraints and get the actual domain, pruned by the constraints. If you consider a standard imperative language, and want to do so, you have to reason *one value at a time*. Since we are using constraints, which are realtions, the inference is done in a single step without having to consider all the possible values. 

You don't need values, just **relations**! Then you have a constraint solver, which uses propagation (propagating the information provided by the constraints) and simplification (makin implicit information explicit). 

So, from the terminological point of view, a constraint is a **conjunction of atomic constraints**,a constraint problem is a given, initial constraint, while a constraint solution is a valuation for the variables in a given CSP that satisfies all the constraints.

Now it's important to realize that you can have an answer which is different from the one provided by an imperative language, and can also be a **partial answer**, containing infinite values for the variables.

Summarizing, constraint reasoning provides a very general framework for modeling problems (with partial or infinite informations), reasoning problems (with new informations), and solving problems (combinatorial problems).

We have two main classes: the **Constraint Satisfaction Problems** (CSP) and the **Constraint Optimization Problems** (COP), the first being defined as a finite set of variables, a domain for each variable and a set of constraints, having as solution a set of assignments. The latter is a CSP defined on the variables and domains, together with an objective function $f: D(X_1),\dots,D(X_n) \rightarrow D$, having as solution the one that **optimizes** the value of $f$.

We have two main families of constraint languages, the **Constraint Logic Programming** (CLP), which basically add constraints to logic programming, resulting in two declarative paradigms together or the **Imperative Languages with constraints**, which basically integrates constraints to imperative languages, like C. The latter are less efficient and expressive. Modern PROLOG implementations are CLP. The idea is simple: taking a PROLOG program, we integrate it with constraints keeping the rest (refutation, backtracking...). 

### CLP syntax and semantics

First of all, in the signature we have a new set of predicate symbols, $C$ added to $P$, the standard predicate symbols, which define the problems. $C$ is composed of symbols like $<,>,\neq,\sqrt{}$. The rest is the same. A clause has this form: $K ::= A \leftarrow G$, where the head is an atom, and the body contains two things: a constraint and the remaining standard atoms (the body). 

So, how can we define the semantics? We want to define these to understand how the evaluation of these programs works. We use a transition system, having two components, a goal and a constraint (in logic programs we had a substitution). If the constraint we obtain in the end is different from false, that's the solution.

Assume we start from a state whch has the form $\langle A \wedge G, C \rangle$, and we want to find a clause such that the end of the goal is satisfiable. What we're saying is that, if we have the goal $A$ and the clause $B\leftarrow H$, rather tha unifying $A$ and $B$ we want to require that the formula $\vDash B=A$ is satisfiable,meaning that we have an equation $B=A$, we express unification by leaving it implicit in the solution of the equatino. We want two find a solution for this equation, and want to find a solution for the constraint $C$ (which is the one we have computed so far, for example if $C$ says that $X=4$, and I want to solve $X$ unifies with $Y$, the result will be $Y=4$). So, summarizing, if I find such a clause, which allows this kind of unification between the goal and the head of the clause, then I can do a transition step and exactly as in logic programming, the goal is deleted and replaced by the body of the clause. In logic programming we had composition and substitution, while we now simply add the equation specifying the unification, which is a constraint. If such a clause doesn't exist, we have a failure. The difference is taht now we can also have a **solving step**, i.e. I have a constraint $C$, a set of already computed constraints $D$, ad I perform one solving step by transforming these two into $D_2$, the only condition being that $(C \wedge D_1)$ and $D_2$ are equivalent.

Note that:

- Explicit unification is substituted by solution of equations
- We have some constraint solving steps, accumulating them

Remember that (**exam question!**) the difference with logic programming is that in **logic programming** you have **generate and test** while in CLP you have **constraint and generate**. In the *SEND MONEY* example, you want to find a correct sum. For each variablem we have one possible number in the set. 

Then, in the *Generate/Test* approach, we `label` the variables, taking their domains and assigning one specific value to the variables. We specify the problem, stating that the first chars have to be different from 0, then we have that they all have to be different, if the solution fails we backtrack and re-assign the values. This is obviously pretty time-consuming: we generate the values **then** test them.

In the *Constraint/Generate* approach, we first write down the constraints then generate the possible values, while the constraints delete possible values reducing the search space.

