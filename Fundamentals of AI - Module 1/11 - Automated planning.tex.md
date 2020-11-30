# Automated planning

**Automated planning** is a problem solving activity which consists in synthetising a **sequence of actions** performed bu an agent that leads from an inital state of the world to a given target state. 

In other words, it is devoted to create a **plan** from an initial state to a final state.

Let's move step by step: we want to reach a **goal**, e.g. we have a robot that has to be moved to another room. Apparently, this is something that we do everyday: trips, routes, events.

While it is basically an *obvious activity*, it is quite complex for a machine: it is **semi-decidable**, so if a plan exists it's possible to find it, but if it does not exist we could end in an infinite loop.

An important notion is that of the **action**: it depends on the kind of moves that you can do.

We start with: an *initial state*, a *set of actions we can perform*, and a *state to achieve*. We want to find **a plan**: a partially or totally ordered set of actions needed to achieve the goal from the initial state. Planning is one application per se, or a common activity in many applications such as *diagnosis, scheduling, robotics*...

An **automated planner** is an intelligent agent that operates in a certain domain described by a *representation of the initial state*, a *representation of the goal* and *a formal description of the executable actions*. I repeat: we need a **non-ambiguous, formal** way of describing these.

## Action representation

The planner relies on the formal description of the action, called **domain theory**. We want to express two list of properties: the **preconditions of the action**, i.e. the set of properties that should be true for the action to be executed (e.g. to drink a glass of water, there should be water inside it), and the **postconditions**, which represent the effects of the action on the world.

## Planning

When we want to create a planning solution, we can say that it is **non decomposable** (there can be interaction between subgoals, i.e. if we have more goals these are obviously interacting; this will be a problem for linear solvers) and **reversible** (i.e. the choices made during the plan are backtrackable).

Note that the process is **offline**: you have a very tight hypotesis, i.e. **nobody else is changing the world**.

A planner is **complete** if it always finds a plan, given that a plan exists. 

A planner is **correct** when the solution found is correct, i.e. the solution leads from the initial state to the goal.

The **exectution** is generally **irreversible** (often the execution of an action is not backtrackable, e.g. I can drink a bottle of water but can't put it back) and **non-deterministic**, i.e. the plan can have effects that are different from what we expect: working in the real world, the effects are not deterministic/totally predictable.

## Generative Planning

This is an off-line planning that produces the whole plan before execution: this is cool, we can always restart if we don't find a solution!

### Planning as search

Planning can be seen as a search activity! At the end of the day, though, we'll resort to special purpose algorithms because general purpose search is often too complex.

The search algorithm could proceed **forward** (starting from the initial state and finding a state which is a superset of the goal) or **backward** (starting from the goal and finding a state which is subset of the initial state).

The latter is basically **goal regression**, i.e. a mechanism to reduce a goal in subgoals during search by applying rules.

## Deductive planning

The previous two are never used, because they have a problem: *we still don't know what that is, tho.*

**Deductive planning** is a general purpose type of planning, based on *First Order Logic*, which describes the initial states, the actions and the goal.

The **situation** is a world snapshot describing properties (*fluents*) that hold in a given state $s$.
$$
Example: block\ world\\
o n(b, a, s)\\
ontable (c, s)
$$
The **actions** define which fluents are true as a consequence of an action. Note that uppercase letters are constants. The *put on table* action might be defined as follows:
$$
\begin{aligned}
&\begin{array}{l}
\text { on }(X, Y, S) \text { and } \operatorname{clear}(X, S) \rightarrow \\
\text { (ontable }(X, d o \text { (putOntable }(X), S))) \text { and }
\end{array}\\
&\text { (clear(Y,do(putOn Table }(X), \text { S }) \text { ) }
\end{aligned}
$$
The action *put on table* has two preconditions, before the arrow, and consequences after.

Given the situation calculus (initial state, actions) we can use *resolution* (i.e. the traditional way we use in logic to solve problems) to create a plan. We'll use  *unification* too, as in logic. 

If, for example, we ask *Is it possible to find an $s$ where $b$ is on the table?* We can use our resolution to put $b$ on top of the table, because it is on top of it and the table is clear. 

The resolution tells us that it is true that you can achieve the required state.

### Frame problem

We have to explicitly list all fluents that change and **do not** change after the state transition. We can't just state those that change! We have to bring all of them to the next level.

To solve this, we can transform the implications with *not A, or B*,. **We take the whole implications negged and orred, orred with one of the conclusions, then the other one.**

Resolution works by finding contradictions: we negate the goal and we try to find the empty clause, by unifying the clauses.

Since we have to move all of the fluents, we need a frame aziom for each condition that is not changed by each action! To describe an action, we therefore need all the fluents. This means that **if the problem is too complex, we have too many axioms!**

The frame axioms specify, for all the possible fluents, that if they do not change thanks to the action, they have to stay right where they are.

### Kowalski formulation

We use a predicate $holds(rel,s/a)$ to describe all the true relations in a state $s$ or made true by an action $a$. Then, we have a preidcate $poss(s)$ that states if a state is *possible* (i.e. reachable). Finally, a predicate $pact(a,s)$ to indicate that it is possible to execute an action $A$ in state $s$, namely the preconditions of $a$ are true in $s$. 

So, we need one frame assertion per action (which is good compared to Green).

We have moved the property as **terms**, which can be done in PROLOG etc. We say that the initial state is reachable, and in the initial state $s_0$ we list the properties that hold. For the action *move*, we have two facts that describe the effects. So we can say that for every state $s$, if we apply the action *move*, it holds *clear(Y)*...

When you have the effects, you have to use one single fact for all of the effects. For the preconditions, we use $pact$ (*precondition actions*).  

## STRIPS

**Stanford Research Institute Problem Solver** is a specific language for the actions, having an easier syntax and an ad hoc algorithm for the plan construction. The state is represented through the fluents that are true in a given state, and the goal is represented as the fluent that are true in the goal state. 

The **action representation** is composed of 3 components: 

- *preconditions*;
- *DELETE list* (fluents that become false after the move);
- *ADD list* (fluents becoming true after the move).

### Algorithm

First of all, as for all the other planners we have seen so far, **STRIPS is a generative planner** (i.e. nobody else is changing our world while we search). Remember that what we state in the state is true, what we don't is false. We have two data structures: the **goal stack** and the **description of the current state**, which obviously starts from the initial one. The goal stack **proceeds backward**, while the current state **proceeds forward**. Here we have the two components: it applies the **goal regression** and the **the state forward search**. These two structures should *meet*.

- We initialize the stack with the goals to reach
- At each step
  - We remove the top from the stack and analyze it. The thing is simple: there can be different things here. Initially, we just have a goal. We can then check if the goal can be unified (the unified is stated as $\theta$) with the *current state*. We remove the goal, because it is true, and apply the unification on the other stack. If it is not true in the current state, we have to find an action that achieves this goal! How can we find it? Where should this goal unified with the other stack? We have to find an action where this $A$ is in the *ADD list*. 
  - Then, you remove the goal from the stack, you insert the action and all the preconditions in the *GOAL stack*
  - Finally, having pushed the action on the stack, this will emerge when all the preconditions are true.
  - This is the only time where you change the state description by **applying this action**!

### Example

The only thing that emerges from the goal stack is an AND. Note that the order in which we put these goals is extremely important. So, now, we extract $on(a,c)$ and we ask ourselves if it is already true in the initial state. The answer is no: we extract it from the stack, and have to find an action that does so, which will be $stack(a,c)$, and *all its preconditions*. We put the action and the precondition in the goal stack, where $on(a,c)$ was. Now, we order the preconditions and leave an AND. $holding(c)$ is not true, so we have to find an action that makes that true! We then substitute $holding(c)$ with the preconditions and action that makes that true. This proceeds until we find the preconditions in the initial state! When that happens, we can apply the action in the state stack! We therefore add to the DELETE list $handempty$ and $on(c,a)$, and ADD $holding(c)$. So, we remove from the goal stack what has to be removed, and so on....

### Some notes

Up to now, having found a conjunction of goals, we consider them to be independent. If my goal is putting on my shoes, it is independent if I put the left one first or the right one. But if the goal is putting the socks on then the shoe, it's a problem. **There are cases in which the goals are not independent**: they interact with each other. It may, for example, happen that you reach a goal, and destroy the other one. Every time we select a conjunction (AND) of goals, you have to keep it on the stack! After achieving each of them separately, it may be the case that the AND is not achieved too! Note that the order in which subgoals are inserted is a *non-deterministic* choice point.

The *Sussman anomaly* is a good example of this.

The **search space is very large**, and we can solve this by using heuristics like the *means-ends analysis*.

### What we'll find in the exam

We always find one exercise that is either a **STRIPS**, asking to explore one **single** path from the starting state to the goal, or a **POP**, *partial order planning*. Then, the theoretical questions might be like the *Kowalski formulation* (express, given the domain theory, the initial state and one possible move in the Kowalski formulation), and one on graph plan.

## Search in the space of plans

If I don't have to commit to an order, why do I use it? While the algorithms we have seen are in the **state space**, we now want to deal with non-linear planners: we don't work in a tree search where each node is a state, rather each node **is a plan**. We start with an empty plan, having the initial state and the goal. We don't impose constraints that we don't really need: if we make a non-necessary decision, which may be wrong, we'll have to backtrack. A non-linear plan is represented by a **set of actions**, a non-exhaustive set of **orderings** between actions and a set of **casual links**.

The empty plan has two fake actions, i.e. **start** (no preconditions, effects matching the initial state) and **stop** (no effects, preconditions matching the goal), and an ordering, i.e. the start has to precede the stop.

At each step, you can do two things to refine the plan:

- Adding an action
- Play with the orderings, and if the ordering is not required you don't post it

A **causal link** is a triple that consists of two operator $S_i,S_j$ and a subgoal $c$, . This shows how we can understand, syntactically how two plans can interact with each other. Therefore, a causal link might be threatened by another action in the plan. Basically, a causal link stores the causal relations between actions, tracing why a given operator has been introduced in the plan.

While the plan is not complete (i.e. not achieved all goals and no interactions threatening the plan) I have to select an action $S_n$ having a not satisfied precondition (aka an **open goal**), either already in the plan or a new one, that has $c$ among its effects. I then have to add an ordering constraint and a *causal link* ($S$ has been inserted in the plan because $S_n$ requires $c$).

To check if there are threatenings, we have to check if there are actions which are misordered. We check that the conditions that are negated by a given action do not interact with the one in the crucial link.

# Partial Order Planning

We start with an initial empty plan, having the start, the stop and the goal, then we go on. If the plan has achieved all open goals and the threats are safe, we return the plan. Otherwise, we select a subgoal from the plan, which is still open, with $c$ precondition of $S_n$ and choose an opeartor that satisfies $c$, then resolve the threats (protect the causal links which are threatened by the action).

The *choose_operator* chooses an action $S$ with effect $c$ from ops or from the steps of the plan (already inserted actions).  If $S$ does not exist, we fail, otherwise we add the causal link and add the ordering constraint. If $S$ is new we add it to the plan then add it to the steps, with the constraint $Start<S<Stop$.

The *solve_threat*, for each action $S$ threatening a causall link, we either choose **demotion** (add the constraint $S<S_i$) or **promotion** (add the constraint $S_j<S$). If the plan is not consistent, it fails.

If there are more than one chain from the goal to the start, we have to check that there are no threats, i.e. solve the problem of interacting goals.

# Modal Truth Criterion (MTC)

Up to now, we've seen two ways of solving a threat: demotion or promotion. We need 4, to cover all possibilities. There is a criterion, named **modal truth criterion**, which is basically a construction process that guarantees the completeness of a planner. It tells us which operators we can use to move in the partial space, i.e. from one node of the search tree to another one. 

We have 5 methods: the first one is not a way of solving threats, just an estblishment (I pick an open goal, and you can achieve it throw either a new action inserted in the plan, or an action which is already there, or through a variable assignment). What is this *variable assignment*? It's a unification (with an action which is already in the plan) that enables us to achieve something. We then have 4 other ways: the first two we have already seen, then two other ones. The first one is the **white knight**, something that should be used when you cannot solve the threat through ordering constraints (demotion/promotion): the action should go between $S_1$ and $S_2$, i.e. the 2 actions that you don't want. I cannot use demotion/promotion, so I have to accept this but then impose a white knight that re establishes the precondition. Then, the **separation** (less used), where you basically say that the two blocks should not be the same. This is quite rarely used, and is useful when variable have not been instantiated. 

In the Sussman anomaly, we can obtain the same plan as we had for strips after a few readjustments, just by considering the goal as independent and then understanding the solutions through threats.

# Closing Remarks

It is always preferable to apply demotion/promotion, because we keep the number of actions limited, before inserting the white knite. These can generate very long plans, even if correct.

# Hierarchical Planning

Hierarchical planners are search algorithms that manage the creation of complex plans at different levels of abstraction, by considering the simplest details only after finding a solution for the most difficult ones. The thing is the following: hierarchical planners basically organiza meta-level searcha nd then extract abstract planning to concrete plans.

The first example is **ABSTRIPS** (abstract strips), basically ait assigns a criticality value to a precondition, i.e. the less intuitive approach. The most intuitive would be starting from macro actions. 

At every level of abstraction we only consider some preconditions, so we impose a value of criticality, all the preconditions having a criticality value lower than the threshold are considered true, for the other ones, we have to plan. Then, we refine this macro-level planning by lowering the criticality value. 

Considering the block world, which is the most difficult precondition? The *on*. Then, we have ontable, clear and holding. Finally, we have handempty.

We have two types of operatoers: **atomic** operators (defined as STRIPS rules) and **macro** operators. The first ones are usually described with preconditions and postconditions, while the latter is a sequence or partial plan of atomic operators. 

We have to be careful when **decomposing** an action: we have to decompose an action **only if this action has specific features**: we have to take into account some things. We have that $A$ is the big action, and $X$ an effect of it, expanded with a plan $P$. We know that $X$ is an effect of at least one of the actions, and it is protected (no other action deletes it). A precondition must be guaranteed by its previous action, or to be guaranteed by the macro action!

In the exam, we can only have question about hierarchical planning like *explain what it is*, etc...

So, how does this execute? Generative planners have some hypothesis. The first one is that we take a snapshot of our initial state, then we plan *offline*, then when we have a complete plan we execute it irl: we make the hypothesis that nobody else is changing the world. The second one is that all our actions have **deterministic effects**. Generally, this is not realistic 😔

One possibility to deal with that is releasing the *world* assumption. My agent could now sense the real world (using sensors) to understand the state of the environment. This is done through a set of actions, called **sensing actions**, that are modelled as the causal actions working on the description of the world and changing it. Now, everything written in the initial state is true, but everything that is not is now **unknown, not false!** We have to check those through a sensing action! Now, the problem is that a sensing action could provide different outcomes! So, if I have sensing actions in the plan, then I have to plan for all the possible contingenties (i.e. the possible results of the sensing action). This is what is done by **conditional planning**. It **generates conditional plans** for each result of the sensing action. The problem is that if you have $n$ sensing actions, with $2$ possible outcomes, you get $2^n$ plans! That is crazily complex. But this is the only way of dealing with scenarios that are **safety critical**, where you don't want *bad surprises*.

So, a conditional plan is created by **causal actions** (the ones we have already seen), **sensing actions**, and several alternative partial plans.

# Reactive planning

On the opposite side wrt conditional planners are **reactive planners**. In the eighties, national agencies funded universities for research on planning. This is why we have a huge literature.

*Brooks* presented a paper in 1986 that was pretty disruptive. These planners are able to interact with the real system: they are **online algorithms** capable of interacting with the world to deal with its dinamicity and non-determinism. 

## Pure reactive planners

These do not use models, perceive just the changes, and they are super fast: they do not reason, they just act. They just have access to a knowledge base that describes what actions must be carried out in what circumstances. For example, a thermostat turns the heat up if the temperature is low, turns it down if it is high. 

Their performance in predictable domains (that require reasoning) are quite low.

## Hybrid systems

Modern responsive planners are hybrids: they integrate a generative approach and a reactive approach. The execution of the plan is monitored: the action we are performing must work correctly, and their preconditions must be satisfied. In case of failure, we either restart from scratch or backtrack the action.

# Graph planning

Going back to generative planners, **graph plan** is one of the most efficient generative planners created so far. The second reason we want to study these is that it introduces a number of concepts that we haven't seen so far, the first being the concept of **time**, i.e. a set of time points where actions can happen. It is not concerned by the duration of an action, but by **when** an action can be executed. 

The new concept is that while planning, it builds a **data structure**. This is called **planning graph**, and it is built at each time point. Then, at some point it stops the construction of this graph, and it *backward finds* a possible plan. This graph basically contains all the possible plans. It creates **optimal plans**, i.e. the shortest possible plans. Differently from POP, which is complete but creates very long plans because of the white knights: it doesn't backtrack on failures but it tries to *always adjust a threat*.

Here, actions are represented as in STRIPS with preconditions, add list, delete list. Note that since objects have a type, you can move them. The interesting thing is that basically if you do not model actions by expretssing the fact that $A$ and $B$ are loads, $T$ is a track.... i.e. you don't treat them as real objects, then you can have a strange behaviour of the actions. In graph plans this doesn't happen: we know the type. There is also a *no-op* action, which does not change the state.

In a planning graph, there are different levels, the **proposition levels** (where nodes represent propositions) and **the action levels** (where nodes represent actions). The level 0 corresponds to initial state. Arcs are divided into *precondition arcs* (proposition $\rightarrow$ action), *add arcs* (action $\rightarrow$ proposition), *delete arcs* (action $\rightarrow$ proposition).

It's basically a very compact way of writing a breadth first search: in the same level there are always actions that cannot be executed together. 

Now we basically have to find an automated way to find these incompatibilities! Each action level contains all actions that are applicable at that time step, and also possible incompatibilities between actions (they can't be executed neither simultaneously, nor in any order).  

The construction process does not imply any choice in the selection of the arc: this is not a plan, just the set of all possible plans squeezed into the graph.

Now we have to find a way to understand the inconsistencies. Two actions can be inconsistent in the same time step, and two propositions can be inconsistent in the same time step. 

Now, talking about **inconsistent actions**, we might see:

- **Inconsistent effects**: one action negates the effect of another
- **Interference**: an action deletes a precondition of the other
- **Competing needs**: two actions have mutually exclusive preconditions

While **inconsistent propositions** might be *one is the negation of the other*, or if *all the ways to reach them are exclusive*.

All true propositions in the initial state are inserted in the first proposition level, then the action level gets created unifying its preconditions to rpopositions in the previous proposition level. Then, for every proposition in the previous prop level, add a no-op operator. Then, we check if the action nodes do not interfere each other: otherwise, we mark them as mutually exclusive. We can then **create the proposition level**, for each actoin node in the previous level, add propositions in its add list through solid arcs and add dotted arcs for the delete list. We do the same process for no-op, then mark as mutually exclusive two propositions such that all the ways to achieve one are incompatible with all the ways to reach the other. 

So, now we have to extract (if it exists!) a valid plan, i.e. a connected and consistent subgraph of the graph. Note that actions can be executed either in parallel or in order (they don't need to be ordered, they do not interfere). If in a planning graph two actions are mutually exclusive in a time step if a valid plan that contains both does not exist. If there is a valid plan then this is a subgraph of the planning graph. In a planning graph, two propositions are incompatible in a time step if they are mutually exclusive.

Note that **the inconsistencies basically prune the search tree**.

## Fast Forward

The Fast Forward is an extremely efficient heuristic planner introduced in 2k, which uses graph planning as heuristic!



