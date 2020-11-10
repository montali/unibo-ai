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

