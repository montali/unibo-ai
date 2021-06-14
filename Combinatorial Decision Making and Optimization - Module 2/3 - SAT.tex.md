# SAT

SAT is a very well known decision problem, considerable as a model where we have a propositional formula. We want to understand whether a propositional formula is **satisfiable**.

We have implications, negations, disjunctions, conjunctions, bi-implications like we always do.

A propositional formula is satisfiable **if it is possible to give an assignation to the variables such that the formula is true**. We're interested to know whether it is satisfiable, and if so, the solution.

Why do we study SAT? We know that this is the first NP complete decision problem, due to the Cook-Levin theorem, representing the **starting point of NP-completeness research**! It's important because all the problems in this class can be **reducible to SAT in polynomial time**, so at most difficult to solve as SAT. We also use SAT to probe NP-completeness: we prove that the problem is in NP, and that we can reduce everything else in NP to it. If you can find a polynomial time solution for SAT, you can use it for every NP-complete problem. This is what makes solving SAT important. Moreover, SAT is used for solving combinatorial decision problems!

SAT problems appear in a **variety of domains**, like theorem proving, non-monotonic reasoning, planning, ML... There are satisfiable SAT problems in these areas too.

The ML area is concerned with SAT for the explanation of ML models and its verification. People are using SAT solvers to work in ML: it is not just a tool for logic.

SAT applications obviously go beyond AI, a good one being model checking for HW and SW verification (*you have a software, does it really produce what you want?*). This is an automated method that we use to **find design flaws**. We're either proving that it's according to the specifications, or we prove an example in which it doesn't. 

The brute force approach is not acceptable, obviously. Current SAT solvers are incredibly successful, though! If you look at research in the early 90s, SAT solvers could only solve things with hundreds of variables, while the last 20 years have seen an increase in their power.

To a problem to be fed to a SAT solver, it should be in CNF. What makes things difficult is the size of the formula, as in CP we usually have less variables. That concerns the size of encoding, and the performance of the solver. The challenge is therefore coming up with a propositional formula which is not that huge.

A quick recap: we know that in CNF we have conjunctions of clauses. Every clause itself is composed of literals ($p$ or $\neg p$) or disjunctions of them. **It is enough to satisfy one of the literals in a disjunction, to satisfy a disjunction!** However, the empty clause is always falsified. 

## Tseitin transformation

We introduce the **Tseitin transformation**, of which the idea is not using De Morgan or anything like that: that wouldn't be a linear transformation, as we don't want to increase the size of the formula. We name every subformula to a new variable, so that we eliminate subformulas as if they were new variables. First of all we do this on the *big formula* (formula with more than 3 variables): small formulas can be solved with De Morgan's law. Instead, we'll apply this idea of labeling for big formulas. 

You have to focus on the subformulas, introducing new names for them. We'll have the new name, and add *if and only ifs* that connect the encoding to the original subformula. We'll have to convert this to CNF.

It is now important to understand on which formulas we do this: negations of other formulas, or compositions of subformulas. 

The following formula:
$$
\phi=(\neg s \wedge p) \leftrightarrow((q \rightarrow r) \vee \neg p)
$$
would therefore be converted to:
$$
\begin{aligned}
T(\phi)=& A \wedge \\
& \operatorname{cnf}(A \leftrightarrow(B \leftrightarrow C)) \wedge \operatorname{cnf}(B \leftrightarrow(\neg S \wedge p)) \wedge \\
& \operatorname{cnf}(C \leftrightarrow(D \vee \neg p)) \wedge \operatorname{cnf}(D \leftrightarrow(q \rightarrow r))
\end{aligned}
$$
As you can see, we renamed $\phi$ to A, and its subformulas to B,C,D. We introduce a formula composed by $A$ and its *if and only ifs* than interconnect the original formula to this. Finally, we convert them to cnf to be able to use De Morgan's. How do we convert these? For every subformula with at most 3 variables, we are guaranteed to achieve a CNF equivalent with at most 4, using De Morgan's.

Through **resolution**, we cannot prove satisfiability, but unsatisfiability. Given two clauses in form $p \vee V$ and $\neg p \vee W$, you can eliminate $p$: $V \vee W$. If $p$ is true, $\neg p$ is false, then $W$ must be true. The other way round, if $p$ is false, $V$ must be true.

In the end, we want to derive the empty clause to prove unsatisfiability.

If a clause is a unit clause, then resolution will allow us to remove the negation of $l$ from a clause containing $\neg l$. So, when $V$ or $W$ is empty in $\frac{p \vee V, \neg p \vee W}{V \vee W}$, we end up with:
$$
\frac{p, \neg p \vee W}{W} \text { or } \frac{p \vee V, \neg p}{V}
$$
SAT solvers do resolution with unit clauses, this is called **Unit resolution**, nothing different from resolution, it just involves a unit clause.

Now, how does this help us? Not all formulas are unsatisfiable. We can though **take the negation to show that a formula is satisfiable!**

Resolution is managed by the SAT solver, which uses an algorithm. Resolution is one basic idea, but it's not enough for SAT solvers. We want to find an answer too, like *what are the assignments of the variables we need?* We therefore need some algorithms that solve the formula, which will still use resolution. The most famous algorithm is DPLL, based on unit resolution, that establishes SAT/UNSAT of a CNF.

The name comes from the creators. The idea is pretty simple: while there exists a clause $l$ consisting of one literal, we remove its negation $\neg l$ from the clauses containing it, and remove all clauses containing $l$.

It applies unit resolution for as long as possible, then we start searching. We choose a variable and assign a value, then test the others for true and false, until all the variables have an answer. We keep going on until we fail, we backtrack and go on.

**DPLL is not implemented in this way, though 🥺**

To avoid copying the formula too many times, enhancing the complexity, we keep a list $M$ of literals that have been decided and derived from DPLL. What do we mean by decided? They are the ones that we search with, so we choose $p$ to be true/false and search. Anything that comes up with the unit resolution or by backtracking is a **derived literal** instead. $l$ is undefined iff it is not part of $M$ in its normal or negated form. 

We can mimick this algorithm starting with an empty $M$ and applying the 4 rules for as long as possible. The current CNF will correspond to the original CNF plus this $M$, composed of the literals we're deciding and deriving. We can obviously then remove the negations of the literals that are in $M$ from CNF, as they must be true if they're in there. At the end, we'll either fail (corresponding to UNSAT) or get the list $M$ that solves the CNF. The first rule is `UnitPropagate`, mimicking the generation of a new unit clause in DPLL. `Decide` is a decision of a variable to be put in $M$. Then, `Backtrack`, backtracking to the negation of the last decision. We do this if **we find contradiction** from what we've derived so far. `Fail` is when we fail, i.e. there's a clause in $M$ that contradicts, and **M does not contain any decision literal**, meaning that we **can't backtrack**.

In order to do `UnitPropagate` there has to be a unit clause, so we start with `Decide` then `UnitPropagate` and add a derivation to $M$.

After seeing how we can use DPLL, and how the current SAT solvers are based on it (while still being better than the pure implementation), we'll now see something about how they got better: **non-chronological learning**. Failing in chronological order, it may be that backtracking doesn't solve the problem. Maybe it's better to identify the problem, since the more we backtrack, the more we're pruning the tree. In the DPLL frmaework, there's no learning: we fail, we backtrack and maybe we fail again from the same reason. The idea behind the current successful SAT solvers is the concept of **conflict-driven clause learning**: each time we fail, the clause learning learns the clause, expanding the original CNF with a conflict clause which summatizes the root cause of the contradiction. In the future, in case we end up doing the same thing, it prevents us to do so. Then another thing is backjumping: the learning gives us an idea about where to backtrack too. 

Basically, now we have a new rule, which augmented the existing ones. We are saying that we have a sequence of literals derived using M, then we have another sequence learned through M, if we learn the first clause, we fail and we derive a clause with resolution. Once we know this backjumping clause, it's easy to decide what to do: using the rule, we derive how to backtrack. 

**Now, how do we derive this backjumping clause through resolution?** The SAT solvers store every decision, and are able to unit propagate the corresponding clause and the derived literal. Then, at every contradiction, the solver investigates literals and clauses. To do that they usee an **implication graph**, has a set of nodes/edges, it's a directed graph recording the history of decisions and the resulting deductions derived with UnitPropagate. Every node represents a decision or derived literal, or the conflict. Of course there are different decision levels to keep track of, which we need when we backjump. These basically represent the depth of the tree. We'll label every node as `l@d` meaning literal derived at level `d`. An edge will have a label and an associated clause. For example, $\mathcal{v} \stackrel{c_{i}}{\rightarrow} w$ means that clause $c_i$ allowed us to derive w with one of the literals of the clause being v.

Now the idea is finding intermediate points in which we decide that the path is already good and I don't need to backtrack anymore. To do that, we use the concept of **Unit Implication Points**, any node in the graph that is on all paths from the current decision literal to the conflict. Why do we want to do that? We'll see that it guarantees a high backtrack jump in the search tree, avoiding the waste of time on too-short of a backtracking. We want to stop when we reach the first UIP. How do we know that? There's a UIP at decision level d, then the number of literals assigned at this level, in an intermediate learnt clause is 1. **If there's only one clause that is learned at that decision level, then you are in a UIP.**

Starting from the conflict, the first found UIP is 1UIP. 

Some heuristics have been added to this great tool. One idea is called *Dynamic Largest Individual Sum*, selecting the literal satisfying the most unresolved clauses: we'll set it to true or false, and solve the clause. We need a lot of computation for this, as SAT problems may have thousands of variables. Therefore, mini SAT solvers use *Variable State Independent Decaying Sum*, selecting the literal happening most frequently in all the clauses. These are being improved using clauses' age and sometimes on activity of the variables. What does *activity* stand for? Some variables are more oftenly called in clause learning, so we should focus on the conflicting variables (similarly to what we do in DOMWDEG). We give importance to the more active variables, maybe focusing more on recent conflicts rather than old ones. These kind of ideas are also used in CP, where they define activity for CP variables creating failures, then focus on the most active variables. Basically, you don't contribute to that as a user, but SAT solvers apply these kind of ideas to decide which variables to branch on. SAT solvers put some limitation on the amount of learning, and on the size of the learnt clauses, but also introduce the mechanism of *forgetting*, as very old clauses get deleted when new ones are added. As these are heuristics, deleting things will maybe change performance but will not break things. Activity could be considered in deletion. Different SAT solvers perform differently because on the different heuristics and performance tunings they apply. 

Another strategy are **search restarts**, i.e. we restart if the search for a solution does not progress, while many clauses have been learnt. When we restart, we forget the clauses, and basically restart with a new CNF: even if we apply the same search, the learnt clauses will be different (thanks to randomization, heuristics...). The restarting idea is very powerful: no SAT solver uses no restarting.

Another idea is *optimizing unit propagation*: the process in which we have a clause and k literals, and all except one are false, we put the last one to true. We want to inspect a clause only if k-1 clauses are false. How do we do that? We have a clause with k literals, we *watch* 2 random unassigned literals (keep track of what's going on), and if they are true the clause is true and there's no reason for unit propagation. We start wondering whether to inspect the clause if one of the found ones are false: maybe the other ones are false too. In that case we can check for unit propagation. Basically, we watch these two random, and examine the clause when one of them is assigned to false. Then, during the search for solutions, every time a literal is assigned to true, we have to check the clauses in the watch list of the negated literal. If all the literals are set to false, we return UNSAT, if any is true, we continue, otheerwise we remove k from the watch list of not a and add it to the watch list of its remaining unassigned literals. The idea is that you do Unit Propagation only when there's some doubt about it.

All these ideas are integrated if **Chuffed**, a SAT solver developed by **Peter Stuckey**. 

