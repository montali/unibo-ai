# Local search

90% of problems requiring search are solved through a meta-heuristic. This is nice, tree searches are better but are costly. 

Tree search is a **constructive method**: you start from nothing, and at each step you add a component of the solution. The nice thing is that at each node, you keep all the possibilities open in case one path is not good. 

Local search is completely different. You **start from a solution**, a path, and then you try to adjust or improve this solution through **local moves**.

Given the n queens problem (i.e. position n queens into a chessboard so that they do not attack each other), a tree search would start with the empty board and then every step is **placing a single queen** on the board. 

Local search does it another way: we start by randomly putting the queens on the board. Then, we begin making local moves, i.e. I take a queen and move it. Indeed, I select one queen and explore all the possible moves, than pick one. So, how can we select a new position? We **foresee some improvement.**

In a way, every configuration has a value which measures how good or bad is a situation. 

Every time we define a local move, this move can be applied to a configuration for all possible components: suppose you have a local move that picks up a queen and moves it to the bottom. The same movement could be applied to the other queens too. This is called a **neighbourhood**. It is a function from the **state space** to the power set of this state space. It basically assigns a set of other configurations to a given state, obtainable by local moves. 

In the TSP problem, we obviously want to minimize the cost. We can consider the **2-opt**, i.e. you **remove 2 arcs and intersect them**, still getting an Hamiltonian path. You can observe that one is better than the other one. You can then perform this 2-opt to every other pair of arcs! You can even do the **3-opt**, which does the same with 3 arcs. Obviously, you now have more ways of reshuffling them!

You start from a node, you explore its neighbourhood and check if there's a better configuration. Then, move to that and recompute the neighbourhood, and so on...

**When does this algorithm stop?** When the neighbourhood doesn't contain anything that makes the configuration better. This is called **hill climbing**: you proceed towards an improving solution, until you reach the *peak of the hill*. It's basically a **local minimum** (or iterative improvement), without the certainty of it being a global one. There are several variants, like computing the neighbourhood one-by-one and choosing the first improvement I find, we can pick the best solution, we can stochasticly choose a move...

The High-level algorithm basically states that you:

- S = initialSolution
- loop
  - s = BestOf(s, N(s))
- Until no improvement is possible

**The drawbacks** are that it is **not effective in exploring** the search space (it stops for the first local minimum) and it **does not remember** the already reached search states.

While it is not a good method, it is the basis of metaheuristics.

Note that **the larger the neighbourhood, the more likely a local maximum is global too**.

There are other problems too: **plateau**, when all the neighbouring states have the same value, and **ridges**, a higher area adjacent to where we should go, but we can't go there directly.

![Local search space](./res/local-state-space.png)