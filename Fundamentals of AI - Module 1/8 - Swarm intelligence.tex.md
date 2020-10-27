# Swarm intelligence

Swarm intelligence studies the **collective behaviour** of a set of decentralized agents. There is **no centralized control** telling agents how to behave, they simply follow rules.

In a way, the nice thing that emerges is that in many cases, a sort of organized behaviour emerges. SI was born after observing nature, where there are lots of examples of complex structures built by animals, like ant colonies, bird flocks, bacteria molding...

There are multiple studies in which biologists and engineers collaborated (*Kennedy & Eberhart*), stating that we evaluate, compare, imitate, learn from experience, enabling people to adapt to complex environments.

Therefore, culture and cognition are consequences of human social choices.

So, **what are the features of these systems?** (*this might be an exam question*)

The first thing we have to take into account is that the system is composed by a number of **simple individuals**, not able to have sophisticated reasoning techniques. 

They **aren't aware** of the system in its **global view**, nor the goal of the system, just their *local goal* (e.g. find food).

They **interact** through local communication patterns, with mechanisms like *stigmergic*, i.e. an indirect interaction that happens through *changes of the environment*. 

We have **no centralized coordination** of individual activities: the computation is fully distributed.

The idea in human brains is that if you remove a part of the brain, the other parts will take its roles (*graceful degradation*). This thing is applied in SI systems. This means that SI systems are more robust to changes.

**Probability** is important here: nothing is deterministic here!

The ***ingredients*** for an SI system are:

- Multiple interactions among agents: created with **simple agents** in **multi-agent systems**;
- Positive feedback: reinforcing common (good) behaviours, amplificating random fluctuations and structure formation
- Negative feedback: saturation, competition, exhaust resources

## Comunication

Agents can *normally comunicate*, but there's another form of communication which is widely used: **stigmergy**. When ants are moving anywhere, they're leaving a **pheromon trail**, which enables their *swarm movements*.

![Swarm intelligence in nature](./res/stigmergy.png)

Basically, in stigmergy agents **change the environment**, communicating.

## Algorithms

We will see 3 algorithms for swarm intelligence:

- **Ant Colony Optimization** (*Dorigo, 1992*): based on ants' behaviour, positive feedback based on pheromone trails
- **Artificial Bee Colony Algorithm**: we can also have individuals with different functions;
- **Particle Swarm Optimization PSO**: based on the observation of bird flocks or fish shouls. Stigmergy is used as communication.

### Ant Colony Optimization

From the observation of ants we discover that they deposti pheromone trails while walking from the nest to the food and vice versa. They tend to choose the paths marked with higher pheromone concentrations. It emerges that they're always choosing the shortest path to the food.![Ants finding the way](./res/ants.png)

When you insert an obstacle, these systems tend to be **adaptive**. 

So, how can we translate this behaviour into an algorithm?

First of all, we have to build a **probabilistic, parametrized model**: the ***pheromone model***.

Note that the solution is **built incrementally**: we're not in the field of local searches, we're building the path arc by arc, and at the end we can evaluate the solution.

So, we have a graph called *construction graph* $G=(C,L)$, where vertexes $C$ are solution components and arcs $L$ are connections. States are paths on $G$. Contraints can be represented to define what is a consistent solution.

For example, in solving the *Traveling Salesmen Problem*, we can build a model where:

- Nodes of $G$ are cities to be visited;
- Arcs are connections between cities;
- A solution is an Hamiltonian path in the graph;
- Constraints are used to avoid sub cycles: each ant can visit a city once.

The only information that ants have is the pheromon. We'd like to add a little help, then, with some problem specific informations: we add a **heuristic value**. Since our goal is traversing a graph, we can represent background knowledge that is provided by us. We merge the pheromon and the heuristic in a single value, and we'll have a higher probability of choosing the best one. Note that there still is a small probability of choosing the worst path.

![ACO schema](./res/aco.png)

So, the algorithm:

InitializePheromoneValues() --> can be 0, resulting in random behaviour

**while** termination conditions not met **do**

**for all** ants $a \in A$ **do**

$s_a$ <-- ConstructSolution$(\tau, \eta)$

**end for**

ApplyOnlineDelayedPheromoneUpdate()

**endwhile**



So, how do we select a path? The longer the distance, the lower the heuristic: we prefer shorter arcs. How do we combine them? The **probability** of choosing an arc $ij$ is proportional to the pheromone to the power of $\alpha$, the heuristic to the power $\beta$, divided by the sum of the other possibilities to normalize the thing:

$\mathrm{pij}=\left\{\begin{array}{c}
\frac{\left[\tau_{i j}\right]^{\alpha}\left[\eta_{i j}\right]^\beta}{\sum_{k \text { feasible }}\left[\tau_{i j}\right]^{\alpha}\left[\eta_{i j}\right] \beta} \hspace{5px}\text{if j consistent}\\
0 \hspace{5px}\text{otherwise}
\end{array}\right.$  

This is different from 0 if we have an arc ij. We associate this probability which is proportional to a product of the pheromone trail on that arc times the heuristic that is the inverse of the distance, normalized for all the feasible paths.

We can insert constraints in this problem by, for example, removing arcs from the graph.

The pheromone is updated as long as you find the solution, with the following rule:

$\tau_{\mathrm{ij}} \leftarrow(1-\rho) \tau_{\mathrm{ij}}+\sum_{\mathrm{k}=1}^{\mathrm{m}} \Delta\tau_{ \mathrm{ij}}^{\mathrm{k}}$ where $\rho$ is the evaporation coefficient: if nobody uses this arc $ij$, the pheromone decreases.

In addition we have to add a value that is the sum, for all ants $m$, of $\Delta\tau_{ \mathrm{ij}}^{\mathrm{k}}$ which means that we take all the solutions, select only the ones using this arc (otherwise it is 0), then we put on this arc an increase in pheromon which is proportional to the total length of the path:

$\Delta \tau_{i j}=\left\{\begin{array}{ll}
1 / L_{k} & \text { if ant } k \text { used arc (i,j) } \\
0 & \text { otherwise }
\end{array}\right.$ where $L_k$ is the length of the path followed by the ant $k$.

![Screenshot 2020-10-27 at 10.22.24](/Users/simone/UniBO/unibo-ai/Fundamentals of AI - Module 1/res/aco_alternative.png)

where **AntBasedSolutionConstruction** is the building of a solution made by ants, which move by applying a stochastic local decision policy that uses values of pheromone and heuristic, taking track of the partial solutions.

Ants can backward upgrade the pheromone on components used on the basis of the quality of the overalll solution, and evaporation is applied all time.

Optionally, we can introduce `DaemonActions()` which are **centralized actions** that cannot be executed by the single ants. These can provide some global heuristic or collection of global informations: previously each ant updated its own path, but we can globalize the thing adding pheromone to guide search from a global perspective. 

We can even apply local searches to solutions after we've found them.



