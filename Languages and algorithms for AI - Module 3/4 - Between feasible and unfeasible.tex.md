# Between feasible and unfeasible

This is another key concept: we want to look at what happens between the feasible and unfeasible. We labeled them by their presence inside P (the good ones), or their absence (the bad ones). These are non-trivial classes, but what happens inbetween?

P is the embodyment of tractable (i.e. feasible) problems, while EXP (containing the whole P) contains problem that cannot be solved in polynomial time too.
So, what we're looking for are classes of an hypothetical A:
$$
\mathbf{P} \subseteq \mathbf{A} \subseteq \mathbf{E X} \mathbf{P}
$$
Is there anything interesting in this *grey land* of problems which are known not to be in P, but trivially in EXP? We'll discover that there's a lot to be done, and a lot of interesting properties to be discovered. Many of the problems we see in AI are in this class. 

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

There is a dicotomy between crafting a solution for the problem, and checking a candidate solution to be an actual solution. Finding $y$ could be much more difficult than checking if $y$ is a solution. Looking for the appropriate certificates cannot be done in polynomial time. Checking is easier. Crafting requires some sort of *creativity*, which algorithms generally do not have. 

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

Examples of **NP** languages include *Maximum Independent Set*, *Subset Sum*, *Composite Numbers* (actually in **P**), *Factoring*, *Decisional Linear Programming* (actually in **P**), *Decisional 0/1 Linear Programming*.

### Original definition of NP

The class **NP** can also be defined using a variant of Turing machines, called the NonDeterministic Turing Machines or NDTM (this is the original definition and is the reason for the **N** in **NP**: non-deterministic).
A NDTM has and additional state $q_{accept}$ and two transition functions $\delta_0$ and $\delta_1$ instead of one and at each step one of them is chosen non-deterministically (currently only theoretical, not implementable).

We say that a NDTM $\mathcal{M}$ accepts an input $x\in\{0,1\}^*$ iff a possible evolution of $\mathcal{M}$ with input $x$ which reaches $q_{accept}$.

$\mathcal{M}$ runs in time $T:\mathbb{N} \to \mathbb{N}$ iff for every $x\in\{0,1\}^*$ and for every possible nondeterministic evolution $\mathcal{M}$ reaches $q_{halt}$ or $q_{accept}$ within $c*T(|x|)$ steps with $c>0,$.

For every $T:\mathbb{N} \to \mathbb{N}$ and $\mathcal{L}\subseteq \{0,1\}^*$ we say that $\mathcal{L}\in \mathbf{NDTIME}(T(n))$ iff there is a NDTM $\mathcal{M}$ working in time $T$ such that $\mathcal{M}(x)=1$ iff $x\in\mathcal{L}$.

$$
\mathbf{N P} = \cup_{c\in\mathbb{N}} \mathbf{NDTIME}(n^c)
$$

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
- $\mathcal{H} \le_p \mathcal{L}$ for any other language $\mathcal{H} \in \mathbf{N P}$. Since $\le_p$  is transitive, we can simply prove that, $\mathcal{J} \le_p \mathcal{L}$ where $\mathcal{J}$ is a language already known as **NP**-complete.

### The Cook-Levin Theorem

A **kCNF** (**k-Conjunctive Normal Form**) is a propositional formula which is a conjunction of disjunctions ("clauses") which contain at most $k \in \mathbb{N}$ literals.
  
The following languages are **NP**-complete:
- $SAT = \{\lfloor F \rfloor | F \text{ is a satisfiable CNF}\}$
- $3SAT = \{\lfloor F \rfloor | F \text{ is a satisfiable 3CNF}\}$

This is a relevant proof of existence of **NP**-complete problems.