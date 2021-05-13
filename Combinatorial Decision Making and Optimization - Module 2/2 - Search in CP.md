# 2 - Search in CP

We'll now see how we can imporve how we can improve our search performance. The aim is having a **good model** and a **good search**. We know we have a constraint solver that enumerates the possible combinations by a systematic backtracking tree search.

The nodes represent variables, and the branches represent decisions on those variables. This is sometimes called **labeling**, i.e. assigning a single value to a node. We create a branch, and add a unary constraint to that branch!

One way is picking a value and assigning it, i.e. creating two branches: the branch of equality, and the branch of inequality. Most of the solvers use two way branching, avoiding creating one branch per value, but just these two. Now the question is **which value and which node to choose**? Heuristics tell us.

How does this backtracking tree search work? Assume that there's no constraint propagation: we can still find a solution, we create a node for every variable, instantiate them, and perform a depth first search.

Propagation reduces the size of our search, though!

## Search heuristics

We could classify these into problem specific vs. generic. Also, there are static and dynamic herustics. The first decide values and variables **before the start**, while the latter decide the order dynamically!

Heuristics for infeasible problems follow the **fail-first principle**: we try first where we are most likely to fail. Usually, heuristics focus on the variables to choose rather than the values: we have to try all the values to decide whether the problem is infeasible. Even if the FFP tends to go for values that are likely to give a solution, our main focus should be variable choosing heuristics. 

Therefore, we get to some generic dynamic variable ordering: choosing the **minimum domain** (we have a variable, it has less values, of course it is more likely to cause a failure).

Another option would be to choose the **most constrained**. This is still a fail first heuristic. 

We could combine these two approaches in the **dom/deg approach**, minizming the ratio between the domain size and the degree of constraints.

We'd though like to check the difficult constraints more than the easy one: we could assign a weight to the constraints. It starts at 1, then every time it fails during the search, its weight is incrased by 1. In this way, we can know which constraints are more difficult to achieve. This heuristic works like dom/deg but with weights, choosing the variable with min $dom(X_i)/ w(X_i)$. This is called **domWdeg**.

All these heuristics are pretty simple and cheap to calculate, but they can make a big difference in the performances of the solver. There are of course many other heuristics, but we don't have time :(

If we change the solver parameters, it looks like the instance is sometimes easy, sometimes difficult. If we use the right heuristic, the problem is easy to solve. The problem is we don't always know which heuristic is the best one! Why is this happening? Why don't all the heuristics work equally? They sometimes make mistakes and end up in infeasible subproblems! This may take a lot of time to backtrack from. 

The observation here is that when you have a problem having differnet instances, and we're checking the runtime of the instances. The distribution of these has a long tail: some exceptionally hard instances change the mean. Heuristics make mistakes, so the idea is trying to add a randomized parameter in search. We introduce random decisions in our search: since the heuristic is sometimes wrong, we don't always listen to it!

This idea has been tested in a variety of contexts, and surprisingly it performs rather well. For instance, we can pick some variables or values randomly, or break ties randomly (there might be more than one variable having the same heuristic value, we have to pick one).

When we introduce randomization, the solver will never explore two identical subtrees.

What else can we do to deal with these behaviours? Another way is **restarting**: we restart the search when it looks like it's stuck, and we perform the search differently, maybe thanks to randomization. 

When restarting, we could use information collected in the previous runs. For instance, domWdeg works well with restart: when we restart we know something more about the weights!

So, when do we restart? Maybe after using a constant value of **resources** (constant restart), or maybe a **geometric restart** increasing the value $L$ to $aL,a^2L,a^3L...$.

What is the most powerful is **Luby restart**, with $L$ coefficients according to a **Luby sequence** like $1,1,2,1,1,2,4,1,1,2,1,1,2,4,8$ which repeats two copies of the sequence before adding a new value. 

Sometimes we'd like to reach an optimal solution, not just one that respects the constraints.

The **branch and bound** algorithm solves a sequence of CSP to solve a COP. This happens with a restrained search tree: we create it, find a solution, backtrack and continue to look for a solution with the additional bounding constraint assuring that **the new solution must be better**.

An example of this kind of problems is the **optimal map coloring problem**, a map coloring problem in which we want to use the minimum number of colours. 

Our model presents a variable for each region, an inequality constraint for each neighbour region, and an objective function equal to the number of different colors. We'd like to minimize this objective function.

In heuristic search, constraints are handled pretty bad: they don't have propagation, they usually just penalize solutions that don't satisfy the costraints. Because of this, even finding an initial good solution can be rather difficult, while in CP the solution is found rapidly. So, when we look at these kind of solutions, CP and Heuristic Search have complementary strengths! 

A solution would therefore be defining a rather large neighourhood, but plug in CP to explore this neighobourhood. So, how do we define a large neighbourhood? The way we do this is so general that we can apply it to every problem. We have an initial solution, we define a neighbourhood by fixing some variables to values of this solution, and we relax the remaining to be assigned. Somehow we are saying *ok, I have a solution, another solution will share some values with this one*. At the same time, the fact that we're assigning values, initiates propagation! We end up with a neighbourhood that is pretty easy for CP to explore. 

### A cumulative scheduling problem

In this problem, temporal constraints are precedence constraints. The arrows represent precedence: the first has to finish before the start of the next one. 

We basically have n jobs to be performed in order, having different durations, and m dedicate machines that can operate a single task at a time: we have a disjunctive constraint being that the machine cannot process two tasks at a time.