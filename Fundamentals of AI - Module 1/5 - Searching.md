# Searching for solutions

The simplest example we can find is traveling from a point A to a point B, having to find the best path.

When we have to solve this problem automatically, we have to find out what the space is, and the operators that take us to a different space. The process of trying to find the actions that take you from the initial state to the goal is called **search**. We can then build a decision tree, where the root is the **initial state**. Now, there are lots of algorithms that explore the decision tree in different way. The main distintion between these is between the **non-informed** and the **informed**. Informed strategies use the problem knowledge, e.g. if I have to choose between city A,B,C or D, an informed one may choose the nearest one. Informed state strategies are trying to evaluate an action and choose one that is promising.

### Searching for solutions

So, we want to **generate a sequence of actions** that bring you from the initial state to the goal. 

- **Expansion**: one starts from a state, and it generates new states by choosing which node to expand. When you reach a leave, it is either a goal or a node to expand.
- **Search strategy**: at each step, choose which state to expand
- **Search tree**

The basic idea is a simulated exploration obtained by expanding states that have already been explored. So you **start** from the initial state, and you **loop**. If you don't have nodes to expand and you didn't find a goal, you've **failed**. If there are candidates, then you have to choose one according to the strategy. 

If the node contains a goal state, we have a solution, so we return the corresponding solution. 

For example, let's say our goal is being in Bucharest, the state is being in a city, and the actions are just travels between connected cities. The solution is the sequence of states that gets you to Bucharest from Arad. ![Cities example](./res/map-cities.png)

The problem has four points: the initial state, the successor functions (i.e. actions-state pairs), a goal, the cost of the path, and a solution.

![Tree search algorithm](./res/tree-search-algo.png)

The problem takes a problem, and a fringe, i.e. the available nodes. The action is the operator you can apply. Now, we have to ask ourselves a few questions:

- Can we find a solution?
- Is it a good one?
- What is the cost of the search?

### Evaluating search strategies

We can evaluate a search strategy basing on:

- **Completeness**
- **Time complexity**
- **Space complexity**
- **Optimality**: does it find the *best solution?*

### Non-informed search strategies

- Breadth-first
- Depth-first
- Depth-first limited depth
- Iterative deepening

### Breadth-first search

So, we take the **general search strategy**, then the **breadth-first search**. We firstly have to define *depth*. This search always expands the least deep node. The problem is that you have to keep all the nodes open. The time and space complexities are exponential. This strategy ensures **completeness**, but it isn't efficient. This strategy will always find the shortest path from the root to the goal, *if the cost equals the depth.* If you have a uniform cost, you don't have this guarantee. It will always find the first, depth-wise. 

How do you obtain this strategy? Every time you have a node, you expand it and add the expansion to the tail of your fringe. Therefore, it is FIFO. It is **complete**, with **exponential** time, keeps every node in memory, and **optimal** if cost is 1 per step.

If we now consider the cost, where each node is labelled with a cost, we shall enter the successors in order of increasing path cost.

### Depth-first search

This always expands the deepest nodes. In this case, you don't have to keep a huge fringe open, so the memory cost is super low. You just have to store the nodes of a path. The temporal complexity is exponential, though. In the worst case, if the maximum depth is $d$ and the branching factor $b$, the maximum number of nodes is $b^d$. 

The algorithm is **efficient**, but **not complete.** The fringe here is a LIFO stack. 

It is **not complete** (it could be, but if fails, for instance, in infinite depth spaces), has **exponential time**, **linear space** (pretty good), and **not optimal**: the solution you find is just a random one. 

### Limited depth search

This one is a depth first variant. When we reach the maximum depth (previously defined), it explores alternative paths, then alternative paths at less than one unit of depth, and so forth: this thing is called **backtracking**. It is **not complete**: the solution might be at a higher depth, but at least it avoids infinite branches. The implementation has to be **recursive**, we have a flag that defines if we reached the maximum depth. 

### Iterative deepening

This one is a limited depth search, but it increases the depth at every iteration. This solves the incompleteness problem. It has the advantages of depth-first and breadth-first searches, but the drawback is that it analyzes the same nodes a shit ton of times. 

When the search space is very large we can use variants of iterative deepening.

It is **complete**, has **exponential time**, has **linear space**, and it is **optimal**: you always find the shortest path if every step has cost equal to 1.

