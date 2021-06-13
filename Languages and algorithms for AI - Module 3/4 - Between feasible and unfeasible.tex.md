# Between feasible and unfeasible

This is another key concept: we want to look at what happens between the feasible and unfeasible. We labeled them by their presence inside P (the good ones), or their absence (the bad ones). These are non-trivial classes, but what happens inbetween?

P is the embodyment of tractable (i.e. feasible) problems, while EXP (containing the whole P) contains problem that cannot be solved in polynomial time too.
So, what we're looking for are classes of an hypothetical A:

$$
\mathbf{P} \subseteq \mathbf{A} \subseteq \mathbf{E X} \mathbf{P}
$$

Is there anything interesting in this _grey land_ of problems which are known not to be in P, but trivially in EXP? We'll discover that there's a lot to be done, and a lot of interesting properties to be discovered. Many of the problems we see in AI are in this class.

## The NP Class

The first concept is the **dicotomy between creating and verifying**.
Very often, the language we'd like to classify can be written as follows:

$$
\mathcal{L}=\left\{x \in\{0,1\}^{*} \mid \exists y \in\{0,1\}^{p(|x|)} .(x, y) \in \mathcal{A}\right\}
$$

The language $\mathcal{L}$ is the language of all strings for which there exists a certificate y such that $(x,y)$, seen as a pair, lies in a set of pairs of $A$.
If we want to conclude that $x$ is in $\mathcal{L}$, we characterize it by another language A (which is a set of pairs of strings), using a certificate $y$ (which exists).
The other crucial part is $p$, which is a polynomial function.
The certificate which certifies the presence of $x$ in $\mathcal{L}$ must be sufficiently.
Think about $A$ as a **test** about the fact that $y$ is an appropriate certificate for $x$. Sometimes this language $A$ is itself decidable in polynomial time.
Does this imply that $\mathcal{L}$ itself is decidable in polynomial time?

The point is that one way of checking whether $x$ is in $\mathcal{L}$ is looking for certificates. If we find a certificate the problem is solved!
If we cannot find a certificate which satisfies the test, and if we check **all certificates** we can say that $x$ is not in $\mathcal{L}$.
The point is there's too many certificates: the strings of length $n$ are exponentially many. Checking all of them is too expensive. Not necessarily, given $x$, we can check all possible $y$ (smaller than $p(x)$). This is not the only way though. We could follow alternative rules.

There is a dicotomy between crafting a solution for the problem, and checking a candidate solution to be an actual solution. Finding $y$ could be much more difficult than checking if $y$ is a solution. Looking for the appropriate certificates cannot be done in polynomial time. Checking is easier. Crafting requires some sort of _creativity_, which algorithms generally do not have.

### Modern definition of NP

And that's it. The complexity class **NP** can be defined as the set of all languages L for which there exists a polynomial $p$ and a polynomial time TM $M$ such that

$$
\mathcal{L}=\left\{x \in\{0,1\}^{*} \mid \exists y \in\{0,1\}^{p(|x|)} . \mathcal{M}(\llcorner x, y\lrcorner)=1\right\}
$$

We want M to return 1 when fed with the pair $(x,y)$. NP is the class of languages for which **checking certificates** can be checked in polynomial time. This doesn't mean that we can find a solution in polynomial time, rather check certificates.

So, M can be said **verifier** for $\mathcal{L}$. The class NP does not have a natural **counterpart**. It is a class of languages, and it's important for the definition that $\mathcal{L}$ is a language. Otherwise, it's not so easy to think about it as a generalization.

A **theorem** on which we will spend some time is the following: NP is one example of a class which is between P and EXP:

$$
\mathbf{P} \subseteq \mathbf{N P} \subseteq \mathbf{E X P} \subset \text{Computable problems}
$$

Examples of **NP** languages include _Maximum Independent Set_, _Subset Sum_, _Composite Numbers_ (actually in **P**), _Factoring_, _Decisional Linear Programming_ (actually in **P**), _Decisional 0/1 Linear Programming_.

### Original definition of NP

The class **NP** can also be defined using a variant of Turing machines, called the NonDeterministic Turing Machines or NDTM (this is the original definition and is the reason for the **N** in **NP**: non-deterministic).
A NDTM has and additional state $q_{accept}$ and two transition functions $\delta_0$ and $\delta_1$ instead of one and at each step one of them is chosen non-deterministically (currently only theoretical, not implementable).

We say that a NDTM $\mathcal{M}$ accepts an input $x\in\{0,1\}^*$ iff a possible evolution of $\mathcal{M}$ with input $x$ which reaches $q_{accept}$.

$\mathcal{M}$ runs in time $T:\mathbb{N} \to \mathbb{N}$ iff for every $x\in\{0,1\}^*$ and for every possible nondeterministic evolution $\mathcal{M}$ reaches $q_{halt}$ or $q_{accept}$ within $c*T(|x|)$ steps with $c>0,$.

For every $T:\mathbb{N} \to \mathbb{N}$ and $\mathcal{L}\subseteq \{0,1\}^*$ we say that $\mathcal{L}\in \mathbf{NDTIME}(T(n))$ iff there is a NDTM $\mathcal{M}$ working in time $T$ such that $\mathcal{M}(x)=1$ iff $x\in\mathcal{L}$.

$$
\mathbf{N P} = \cup_{c\in\mathbb{N}} \mathbf{NDTIME}(n^c)
$$

Some problems are known to be in $P$ or outside of $P$. For example, there is no polynomial time algorithm for the maximum independent set problem.

So, could we just stop here and say that all the problems in NP and not known to be in P are equivalent? They could be but nobody knows. In fact, complexity theory has done much around these, finding a way of classifying problems in $NP$ and find those in which difficulty is maximal.

Generally, any $NP$ problem is maximal or not. To better understand this concept, we'll have to introduce _nondeterministic Turing Machines_.

These are the way in which $NP$ were originally defined. The $N$ in $NP$ stands for that.

Now, what does _nondeterministic_ actually mean? Definitely, there is just one difference: there are two transition functions, and the machine chooses a random one at every step. The choice is non-deterministic. There is no furthere information on how the transition function is chosen. This is not a _realistic_ computational model: choosing the $\delta_0$ and $\delta_1$ is something the machine cannot do. Nondeterminism doesn't really exist in computer science. The machine can evolve in two different ways, making these TM not so realistic.

We assume that there's one state $q_{accept}$ which we use to state if a NDTM accepts the input iff there exist **one among** the many possible evolutions of the machine when fed with $x$ makes it reach $q_{accept}$. In a deterministic machine, there is just one possible evolution, while now the evolutions become a binary tree. There just has to be **one** evolution. If none exists, the input is rejected.

This existance condition is connected with the concept of certificates: choosing a transition function is similar to finding a certificate.

We say that NDTM M runs in time $T$ iff for every $x$ and for every possible nondeterministic evolution, M reaches either the halting state or $q_{accept}$ within $c \cdot T(|x|)$ steps.

We have lifted all the definitions we had to NDTM.

## Reductions

A reduction is just a mapping from a binary string to another binary string. Such a reduction could be a way of comparing difficulty of languages.

We'd want a function fo to turn a element inside $L$ to an element inside $H$. It may be that all the elements of L are mapped to the same element of H. It is very rare, but that may happen.

A problem can be NP-Hard or NP-complete. It is the first case if m

It is in HP-hard if its is as hard $\mathcal{L} \leq_{p} \mathcal{H}$ for every language in $NP$, and complete if $\mathcal{H}$ is in $NP$. NP-hardness does not imply NP-completeness, while the inverse is true.

NP completeness is a stronger assumption: we also want the problem to be in $NP$.

IF we were to describe NP complete problems, it **would not be a subset of NP**, but just have an intersection. If a problem is NP-Hard, translating any string to $\mathcal{L}$ is feasible.

The first interesting example of an NP-complete problem is **simulating a Turing Machine**. We introduce TMSAT, a language composed of quadruples, where the first component is a turing machine, hte second its input, the third a string of length $N$ which value doesn't matter, and the fourth be a string of length $t$. We are interested in those quadruples such that there exists a certificate such that the machine alpha outputs 1 on an input which is computed from $x$ but also from $u$. We are kind of checking if the TM indexed by $\alpha$ outputs 1 on the right input, **within a time bound**.
If there weren't any bounds, the problem would be quite complicated, close to the halting problem. We therefore explicitly state that we want the machine to halt in $t$ steps. It's clear that we are doing something that is _hard_: we are encoding all TM. This is not so useful, as it can't prove other problems to be NP complete.

## Cook Levin theorem

We want to take any language in NP, and we want to show that $\mathcal{L}$ is $\le_p$ than SAT.

The machine $\mathcal{M}$ tests certificates. Then, we define a polynomial time transformation, which given a string returns a boolean formula, the encoding of a CNS such that the output formula is satisfied iff the closing language . We need to dig into M, and understand that even if it is a machine can be simulated by logic. Even if the machine is automatic, it works by logic, i.e. it checks whether the input is a certain symbol, the state is something, and evolve. There's a way to encode this in propositional logic, being quite laborious but very elegant.

Suppose we're studying a language L, and we're convinced that the underlying problem is hard. How could we prove this? Proving that L is in EXP could be easy, but this doesn't tell us anything about the difficulty of L: knowing that L is in EXP doesn't mean much. We could prove that L is in NP, but again this doesn't mean much. The way to proceed is trying to prove that L is NP-complete. The NP-complete problems are at least **as hard as problems in NP**.

We then have to prove two statements: that L is in NP (typically easy) and that any other language in NP can be reduced to L.
We could prove this directly, but it is quite difficult. We more often prefer proving that a certain language I, which is already known to be NP-complete (for example SAT) is smaller or equal to L. If you do so, that is fine: the relation $\le_p$ is transitive, meaning that you can go through I.

## Proving a problem hard

There's this language $\mathcal{L}$ that we want to prove is hard. We could try to prove that it is in P, but it won't be that helpful: probably it isn't, as it might be easy if so.
We might try to prove it to be in EXP. This, though, doesn't correspond to its hardness. The fact that there's an exponential algorithm doesn't mean much: a really efficient algorithm might not be the only one, as there might be efficient ones. This way, we could always use a stupid algorithm to prove a problem hard. Finally, we may prove that $\mathcal{L}$ is NP-complete: this way we can prove that the problem is not so hard (being in NP) but not so easy either.

So, how do we do that? We have to prove two statements, the first one being that $\mathcal{L}$ is in NP (as we know, this means we need to find a polynomial P and a TM working in polynomial time such that the problem is solved by it). The second step is trying to prove that any other language $\mathcal{H}$ in NP is lower or equal than $\mathcal{L}$.
We therefore have to find a _third_ language between $\mathcal{H}$ and $\mathcal{L}$ which can itself be reduced to $\mathcal{L}$ we can conclude that any language can: the relation is transitive.

Of course, if the problem is NP-hard we can always find that language. This is more about creativity than computing. Coming up with the right problem and the right reduction might be difficult. That's why we're rarely asked to solve these problems in exams, and when we are, the problem $\mathcal{I}$ is suggested.

For example, the _Maximum Independent Set_ problem is NP-complete.

Even the _subset sum problem_ is NP-complete. The problem is trivial in NP (the certificate is just a subset), but we can also prove that the problem is NP-complete, so it's not in the easy side of the class.

This turns into the graph of NP-complete: we can start by stipulating that a pair of NP-complete problems, then go on with the others. For example, we know SAT to be NP-complete, then we can go to 3SAT, then we can go from SAT to INDSET and ILP. To reach SUBSETSUM, we go through OL3SET. This graph is giant: lots of problems are known to be NP-complete!

We would be happy if in some way we could solve these problems efficiently, even though they are NP-complete. Is the hope completely lost? Actually no! We know that no polynomial time for $\mathcal{L}$ is available, because P would be equal to NP then. Once we have a problem $\mathcal{L}$ which is NP-complete, and in particular is NP, we can try to reduce the problem to SAT, and since it is NP-complete we can always do it.
Of course, this reduction can always be done, and it allows us to map strings in $\mathcal{L}$ to strings in SAT. There are tools that solve SAT problems, called **SAT solvers** which take in input a CNF and decide if it's solvable. There are lots of problems in which SAT solvers work real well.

## NP-hardness and NP-completeness

The language $\mathcal{L}$ is said to be **polynomial-time reducible** to another language $\mathcal{H}$ (**$\mathcal{L} \le_p \mathcal{H}$**) iff there is a poly-time computable function $f: \{0,1\}^* \to \{0,1\}^*$ such that $x \in \mathcal{L} \iff f(x) \in \mathcal{H}$.
$\le_p$ is a pre-order (reflexive and transitive).

For classes **P** or above it and $\mathcal{L} \le_p \mathcal{H}$, then $\mathcal{H}$ is at least as difficult as $\mathcal{L}$.

A language $\mathcal{H} \subseteq \{0,1\}^*$ is said to be:

- **NP-hard** if $\forall \mathcal{L} \in \mathbf{N P},   \mathcal{L} \le_p \mathcal{H}$. This means that it is at least as hard as any language in **NP**. Simplifying it means that it cannot be too easy (it could be un-computable, **NP**-complete or outside **NP**).
- **NP-complete** if $\mathcal{H} \in \mathbf{N P}$ is **NP**-hard. Note that **NP**-hardness does not imply **NP**-completeness as a **NP**-hard language may be un-computable or outside **NP**.

Note that:

- $\mathcal{L} \in \mathbf{P}$ is **NP**-hard $\Rightarrow \mathbf{P}=\mathbf{N P}$.
- $\mathcal{L} \in \mathbf{P}$ is **NP**-hard $\iff \mathbf{P}=\mathbf{N P}$.

No such language has been found and $\mathbf{P}=\mathbf{N P}$ has not yet been proven (famous **P** vs **NP** problem).

![Venn diagram of P and NP](res/p-np.png)

Proving that a problem is **NP**-complete proves that the problem is not so hard (being in NP), but not so easy either (unless P = NP).

If we want to prove $\mathcal{L}$ to be **NP**-complete we have to prove two statements:

- $\mathcal{L}$ is **NP** (see above)
- $\mathcal{H} \le_p \mathcal{L}$ for any other language $\mathcal{H} \in \mathbf{N P}$. Since $\le_p$ is transitive, we can simply prove that, $\mathcal{J} \le_p \mathcal{L}$ where $\mathcal{J}$ is a language already known as **NP**-complete.

### The Cook-Levin Theorem

A **kCNF** (**k-Conjunctive Normal Form**) is a propositional formula which is a conjunction of disjunctions ("clauses") which contain at most $k \in \mathbb{N}$ literals.

The following languages are **NP**-complete:

- $SAT = \{\lfloor F \rfloor | F \text{ is a satisfiable CNF}\}$
- $3SAT = \{\lfloor F \rfloor | F \text{ is a satisfiable 3CNF}\}$

This is a relevant proof of existence of **NP**-complete problems.

#
[Previous section](3%20-%20Polynomial%20time%20computable%20problems.md) · [Next section](5%20-%20ML%20and%20theory%20of%20computation.md)
