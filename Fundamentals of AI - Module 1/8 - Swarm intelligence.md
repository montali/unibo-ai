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

So, we have a graph called *construction graph* <img src="svgs/8552f1f7272fd3c4ddd05346f173861b.svg?invert_in_darkmode" align=middle width=78.13222559999998pt height=24.65753399999998pt/>, where vertexes <img src="svgs/9b325b9e31e85137d1de765f43c0f8bc.svg?invert_in_darkmode" align=middle width=12.92464304999999pt height=22.465723500000017pt/> are solution components and arcs <img src="svgs/ddcb483302ed36a59286424aa5e0be17.svg?invert_in_darkmode" align=middle width=11.18724254999999pt height=22.465723500000017pt/> are connections. States are paths on <img src="svgs/5201385589993766eea584cd3aa6fa13.svg?invert_in_darkmode" align=middle width=12.92464304999999pt height=22.465723500000017pt/>. Contraints can be represented to define what is a consistent solution.

For example, in solving the *Traveling Salesmen Problem*, we can build a model where:

- Nodes of <img src="svgs/5201385589993766eea584cd3aa6fa13.svg?invert_in_darkmode" align=middle width=12.92464304999999pt height=22.465723500000017pt/> are cities to be visited;
- Arcs are connections between cities;
- A solution is an Hamiltonian path in the graph;
- Constraints are used to avoid sub cycles: each ant can visit a city once.

The only information that ants have is the pheromon. We'd like to add a little help, then, with some problem specific informations: we add a **heuristic value**. Since our goal is traversing a graph, we can represent background knowledge that is provided by us. We merge the pheromon and the heuristic in a single value, and we'll have a higher probability of choosing the best one. Note that there still is a small probability of choosing the worst path.

![ACO schema](./res/aco.png)

So, the algorithm:

InitializePheromoneValues() --> can be 0, resulting in random behaviour

**while** termination conditions not met **do**

**for all** ants <img src="svgs/093389674502221e9d1394082bbabd6f.svg?invert_in_darkmode" align=middle width=41.10908999999999pt height=22.465723500000017pt/> **do**

<img src="svgs/ac675e1a130b2152f8fe81dce9dc70c4.svg?invert_in_darkmode" align=middle width=14.83586279999999pt height=14.15524440000002pt/> <-- ConstructSolution<img src="svgs/d91a765636739204f73e1d3b9c6af6f1.svg?invert_in_darkmode" align=middle width=36.97684154999999pt height=24.65753399999998pt/>

**end for**

ApplyOnlineDelayedPheromoneUpdate()

**endwhile**



So, how do we select a path? The longer the distance, the lower the heuristic: we prefer shorter arcs. How do we combine them? The **probability** of choosing an arc <img src="svgs/e5a8bc7bac1dd7d337c9e609a4ae3f99.svg?invert_in_darkmode" align=middle width=13.373644349999989pt height=21.68300969999999pt/> is proportional to the pheromone to the power of <img src="svgs/c745b9b57c145ec5577b82542b2df546.svg?invert_in_darkmode" align=middle width=10.57650494999999pt height=14.15524440000002pt/>, the heuristic to the power <img src="svgs/8217ed3c32a785f0b5aad4055f432ad8.svg?invert_in_darkmode" align=middle width=10.16555099999999pt height=22.831056599999986pt/>, divided by the sum of the other possibilities to normalize the thing:

<img src="svgs/93b82f56370a405b372890fd65d70279.svg?invert_in_darkmode" align=middle width=301.26545955pt height=57.53473439999999pt/>  

This is different from 0 if we have an arc ij. We associate this probability which is proportional to a product of the pheromone trail on that arc times the heuristic that is the inverse of the distance, normalized for all the feasible paths.

We can insert constraints in this problem by, for example, removing arcs from the graph.

The pheromone is updated as long as you find the solution, with the following rule:

<img src="svgs/e9883a87c8beb2ebf6fb7b220378e6cc.svg?invert_in_darkmode" align=middle width=200.98179255pt height=27.91243950000002pt/> where <img src="svgs/6dec54c48a0438a5fcde6053bdb9d712.svg?invert_in_darkmode" align=middle width=8.49888434999999pt height=14.15524440000002pt/> is the evaporation coefficient: if nobody uses this arc <img src="svgs/e5a8bc7bac1dd7d337c9e609a4ae3f99.svg?invert_in_darkmode" align=middle width=13.373644349999989pt height=21.68300969999999pt/>, the pheromone decreases.

In addition we have to add a value that is the sum, for all ants <img src="svgs/0e51a2dede42189d77627c4d742822c3.svg?invert_in_darkmode" align=middle width=14.433101099999991pt height=14.15524440000002pt/>, of <img src="svgs/30eb0f5053915886f4906f17f0bb3439.svg?invert_in_darkmode" align=middle width=29.65194539999999pt height=27.91243950000002pt/> which means that we take all the solutions, select only the ones using this arc (otherwise it is 0), then we put on this arc an increase in pheromon which is proportional to the total length of the path:

<img src="svgs/59499802859cbba0fb1e47de3cfa17a4.svg?invert_in_darkmode" align=middle width=282.86762129999994pt height=47.6716218pt/> where <img src="svgs/bfb6e556d3874a3157379133a8d7917a.svg?invert_in_darkmode" align=middle width=18.45327164999999pt height=22.465723500000017pt/> is the length of the path followed by the ant <img src="svgs/63bb9849783d01d91403bc9a5fea12a2.svg?invert_in_darkmode" align=middle width=9.075367949999992pt height=22.831056599999986pt/>.

![Screenshot 2020-10-27 at 10.22.24](/Users/simone/UniBO/unibo-ai/Fundamentals of AI - Module 1/res/aco_alternative.png)

where **AntBasedSolutionConstruction** is the building of a solution made by ants, which move by applying a stochastic local decision policy that uses values of pheromone and heuristic, taking track of the partial solutions.

Ants can backward upgrade the pheromone on components used on the basis of the quality of the overalll solution, and evaporation is applied all time.

Optionally, we can introduce `DaemonActions()` which are **centralized actions** that cannot be executed by the single ants. These can provide some global heuristic or collection of global informations: previously each ant updated its own path, but we can globalize the thing adding pheromone to guide search from a global perspective. 

We can even apply local searches to solutions after we've found them.



