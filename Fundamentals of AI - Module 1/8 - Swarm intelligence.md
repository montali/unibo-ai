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

### Honey bee-colony

Sometimes, we could imagine that the involved agents are not always the same: they may have **different roles**! 

This algorithm is called **honey bee-colony**, and we have **3 kinds of bees**:

- Employeed bees, associated with a nectar source
- Onlookers, that observing the employed bees choose a nectar source
- Scouts that discover new nectar sources

Initially, nectar source are discovered by scouts, then food is consumed and the source is exhausted. The employeed bees in that source become scouts. 

Remember that there are 2 components in the algorithm: **exploration** and **exploitation**, i.e. moving to a different source after finding one, which is what makes this different from a local search. 

Now, the solution is the **position of food** (as many solutions as employed bees), and the **food quantity** for each source.

We have three phases, one for each type of bees, an initialization and a saving of the best solution so far:

![Honey bee-colony algorithm](./res/bee-colony.png)

In the **initialization**, we want to find <img src="svgs/f9c4988898e7f532b9f826a75014ed3c.svg?invert_in_darkmode" align=middle width=14.99998994999999pt height=22.465723500000017pt/> starting points: each bee will start from one of these.

Now, we have a set of employee bees, which travel the the food source area visited in the last cycle, then chooses a new good source in the neighbourhood. We use a fitness function: <img src="svgs/60479b40bef7a70a03ea202f2a50431c.svg?invert_in_darkmode" align=middle width=369.40468619999996pt height=47.6716218pt/> 

The onlooker bees decide among the solutions, depending on the probability value associated with that source: <img src="https://cdn.mathpix.com/snip/images/a0U5LiLnpl4SGakpDMzvwaeIN9JqPnOnxJ0f_1K1A8A.original.fullsize.png" /> 

An employee bee that is performing local search becomes a scout if it can't improve its solution, i.e. *the nectar source is exhausted*.

**Remarks**: The important thing here is that agents have different roles!

### Particle swarm optimization

This is **widely used in robotics**. It was proposed in 1995, and it is still used!

Basically, this was born through the observation of bird flocks: they follow neighbours, stay in the flock and avoid collisions. Usually there's a bird who separates from the flock, then the flock follows it. Every single individual wants to find food, but there's no common objective. What we'd like is having one: with a common objective, a single individual has two choices: moving away from the group to reach the food, or staying in the group.

We can solve optimization problems with two analogies: individuals (tentative configurations that move and sample the solution space) and social interaction (each individual takes advantage from other searches moving toward promising regions). In this way, we have a positive feedback and they're attracted to promising areas. As always, it is a matter of balance between exploration and exploitation.

Individuals are affected by the actions of other individuals (closer to them), so they're part of more subgroups which are not tied to the physical proximity of the configurations in the parameter space but are a priori defined.

The algorihtm moves these particles in the search space through very simple mathematical formulas, deciding direction and speed of movement. The movement is decided by two parts: the best position found by the particle, and the best one found by everyone. This is, in a way, a form of stigmergy. 

Mathematically speaking, the move is calculated with <img src="svgs/0d19b0a4827a28ecffa01dfedf5f5f2c.svg?invert_in_darkmode" align=middle width=12.92146679999999pt height=14.15524440000002pt/> which is the best solution found by the particle <img src="svgs/77a3b857d53fb44e33b53e4c8b68351a.svg?invert_in_darkmode" align=middle width=5.663225699999989pt height=21.68300969999999pt/> and <img src="svgs/3cf4fbd05970446973fc3d9fa3fe3c41.svg?invert_in_darkmode" align=middle width=8.430376349999989pt height=14.15524440000002pt/>, the best solution found by the entire swarm. For each particle, we:

- Initialize the starting value <img src="svgs/14f12dabfc4051bbf95e967b0410c501.svg?invert_in_darkmode" align=middle width=117.67626915pt height=24.65753399999998pt/> where <img src="svgs/5fb566d7c70c0f34898e1fcb4c079b81.svg?invert_in_darkmode" align=middle width=17.76718679999999pt height=22.831056599999986pt/> and <img src="svgs/3a603aa504a0f0d892683a669b4ee180.svg?invert_in_darkmode" align=middle width=21.60342524999999pt height=22.831056599999986pt/> are the lower and upper boundaries of the search space
- Initialize the particle's best known position to that
- If <img src="svgs/5adf13a4433b49a8bc3d823b03c1ccf7.svg?invert_in_darkmode" align=middle width=89.29704464999999pt height=24.65753399999998pt/> we update the swarm's best solution: <img src="svgs/6dd8466a7e20a77e009cdae28914e6d3.svg?invert_in_darkmode" align=middle width=43.26945479999999pt height=14.15524440000002pt/> 
- Initialize the speed <img src="svgs/2617d75a8062e9fbad6e63dc90ed34e4.svg?invert_in_darkmode" align=middle width=251.0605647pt height=24.65753399999998pt/> which is a vector of two quantities 

After this initialization, until a termination criteria is met:

- For each particle we move the swarm according to the position and the speed:
  - Pick random <img src="svgs/d2f1d244924ae495a3650ff05e4bf724.svg?invert_in_darkmode" align=middle width=14.192798399999992pt height=14.15524440000002pt/> and <img src="svgs/4364b58caba8ae1923651f1ca93c1515.svg?invert_in_darkmode" align=middle width=14.24229014999999pt height=14.15524440000002pt/> 
  - Update the velocity <img src="svgs/fbe57c3c76cdfdc600615be821ba04dc.svg?invert_in_darkmode" align=middle width=294.7576302pt height=24.65753399999998pt/> with <img src="svgs/417a5301693b60807fa658e5ef9f9535.svg?invert_in_darkmode" align=middle width=10.75343279999999pt height=14.15524440000002pt/> and <img src="svgs/ae4fb5973f393577570881fc24fc2054.svg?invert_in_darkmode" align=middle width=10.82192594999999pt height=14.15524440000002pt/> being hyperparameters
  - Update the particle's position <img src="svgs/9fc20fb1d3825674c6a279cb0d5ca636.svg?invert_in_darkmode" align=middle width=14.045887349999989pt height=14.15524440000002pt/> 
  - If  <img src="svgs/eaf88e88bc9841ceddc1492184c640d0.svg?invert_in_darkmode" align=middle width=95.7344718pt height=24.65753399999998pt/> we update the best known position <img src="svgs/7b8fc22642ded4862dcf66ea344ba573.svg?invert_in_darkmode" align=middle width=49.70688194999998pt height=14.15524440000002pt/> and if it's the best in the swam we update that too <img src="svgs/6dd8466a7e20a77e009cdae28914e6d3.svg?invert_in_darkmode" align=middle width=43.26945479999999pt height=14.15524440000002pt/>

## Remarks

Note that these algorithms **have to be non-deterministic**, i.e. working with a *probability*. 

## Parameter tuning

These algorithm are very subject to a good parameter tuning: doing that badly will result in a bad solution!

It is really hard to find the optimal configuration, but there are techniques for automatic parameter tuning like *ParamILS*.





