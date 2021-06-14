# Combinatorial decision making and optimization - Module 2

We have a tutor, who will help with the practical exercise (project) from second year.

We'll have a lesson with prof. Peter Stuckey, leader of the MiniZinc team.

We won't know the project topic until the end of the course. She wants us to work after we have followed lectures and learned about the theory and tools of **MiniZinc** and **Z3**.

We can introduce new projects (or possibly old projects done in a new way), and do it in groups of 2-3 people.

When we talk about AI, people usually think about ML. The things we have seen so far are part of optimization, but they are not that *AI-centric*. We now want to see an AI approach to optimization. For example, some years ago IBM provided an optimization for a London bike sharing service, that used ML to forecast and predict the movements, and optimization to decide how to move bikes. 

In this module we will see two approaches: *constraint programming* and *SAT* (and its extension).

## Constraint programming

This is a very popular area of AI, many companies are contributing to the advancement of the state of the art (IBM for sure). 

Another example of good CP was made by Ocado Retail Ltd, a company in the online groceries business with over 15k employees. The company decided to Covid-test every employee, every week. Scheduling these tests is kinda hard: no manual solution was found.

The data science team developed a CP-based solution, which was succesfully used to schedule up to 3500 employees across 4 sites. 

CP is a declarative programming paradigm for stating and solving combinatorial optimization problems. For example, in the covid19 use case, we had *availability constraints* (employee must be at work, tester must be available, testing room too...), *frequency constraints* (one test per week), *operational constraints* (each employee tested in their shift, test eterogeneously across locations...).

The CP will then assign variables by exploring the space of possible values. 

### How is this different from the last module?

These are in a way very similar: we have domains, constraints, decision variables...

However, CP provides a **rich language for modeling**: in ILP we have linear equations, modeling is not that easy. 

Basically, in CP the focus is **on constraints and feasability**, not on **optimality** anymore.

These approaches look similar, but they have inherent differences. In ILP the calculations are numerical, but in CP the solutions are obtained through **logics**.

The focus of ILP is objective functions and optimality, while in CP the focus is on **feasability**. Instead of **bounding**, we have **propagation**.

CP is therefore very succesful on irregular calculus. 

The best approaches are combinations of different approaches! ILP, CP and HS (heuristic search) best work when combined!

## Constraint solver

We said that a solver enumerates all possible variable-values combinatios via a systematic backtracking tree search. It is not just search: there is the **propagation**, in which the solver examines all the constraints to remove inconsistent values (which don't satisfy the constraints). The search space keeps shrinking. This search needs some guidance: which variable to check, which values... We need **search heuristics**! The solver exploits the search space to understand how to perform better. We have different algorithms, different models, different searches, heuristics...

### Dual role of a model

The model is not just about **stating the problem**: all the propagation is done on the constraints that you choose to model the problem. 

### Search and propagation

These two are done together. You propagate, guess a value, propagate, guess a value...

The expectation from CP is very nice: the user declaratively models the problem and gets a solution. In reality, it ain't that easy: we, as a user, have to come up with a model. Default search of the solution is not always *the solution*: we have to tweak the solver to make it work better.

Heuristics are important, but that's not all: the main problem is propagation. We may say that *we did propagation in the non-heuristic example*, but we'd like a stronger form of propagation, a more intelligent one. 