# SAT

SAT is a very well known decision problem, considerable as a model where we have a propositional formula. We want to understand whether a propositional formula is **satisfiable**.

We have implications, negations, disjunctions, conjunctions, bi-implications like we always do.

A propositional formula is satisfiable **if it is possible to give an assignation to the variables such that the formula is true**. We're interested to know whether it is satisfiable, and if so, the solution.

Why do we study SAT? We know that this is the first NP complete decision problem, due to the Cook-Levin problem, representing the **starting point of NP-completeness research**! It's important because all the problems in this class can be **reducible to SAT in polynomial time**, so at most difficult to solve as SAT. We also use SAT to probe NP-completeness: we prove that the problem is not NP, and that we can reduce it to NP. If you can find a polynomial time solution for SAT, you can use it for every NP-complete problem. This is what makes solving SAT important. Moreover, SAT is used for solving combinatorial decision problems!

SAT problems appear in a **variety of domains**, like theorem proving, non-monotonic reasoning, planning, ML... There are satisfiable SAT problems in these areas too.

The ML area is concerned with SAT for the explanation of ML models and its verification. People are using SAT solvers to work in ML: it is not just a tool for logic.

SAT applications obviously go beyond AI, a good one being model checking for HW and SW verification (*you have a software, does it really produce what you want?*). This is an automated method that we use to **find design flaws**. We're either proving that it's according to the specifications, or we prove an example in which it doesn't. 

The brute force approach is not acceptable, obviously. Current SAT solvers are incredibly successful, though! If you look at research in the early 90s, SAT solvers could only solve things with hundreds of variables, while the last 20 years have seen an increase in their power.

To a problem to be fed to a SAT solver, it should be in CNF. What makes things difficult is the size of the formula, as in CP we usually have less variables. That concerns the size of encoding, and the performance of the solver. The challenge is therefore coming up with a propositional formula which is not that huge.



