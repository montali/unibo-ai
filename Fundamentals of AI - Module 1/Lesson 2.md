# Lesson 2

**Machine learning** will not be covered during this course, but a slight introduction is mandatory. 

The machine learns like a kid does (?)

There are two definitions: the first being **declarative** (concerning on the growth of knowledge), the second one being **operational** (increasing the ability of performing a task).

One might ask, **why is machine learning a hot topic right now?** Lots of data, and much computational power to extract value from the data.

There's three main ways of learning: **supervised**, where a human is *helping* the machine with a *labeled* training set (usually classification or regression), **unsupervised**, usually in data mining, where we group together similar data (clustering) with respect to some similarity on their features, **reinforcement** (RL), created to learn in the *operational* way, where you learn a policy by observating if a choice was good or bad (reward system). 

## Examples of tasks

**Classification** can be binary or multiclass, and it is the task of approximating a **mapping function** from input variables to discrete output variables. How can you judge if the model is good? By computing the accuracy.

**Regression** finds a mapping function too, but it maps an input variable to a number instead of a class: it is not discrete but continuous. If there's multiple input variables, it is known as *multivariate*, if the input variables are ordered by time we talk about *time series forecasting*.

**Clustering** is an unsupervised learning method which groups objects according to similarities between them. We can talk about *hard clustering* (one single cluster per object), or *soft clustering* (one or more clusters per object). Beware: **we don't know the classes of the training data, the patterns emerge during the processing and not before.**

### Artificial neuron

The idea is simulating brain function: a basic neuron receives a set of inputs, makes a weighted sum, applies an activation function to calculate the output. Through neural networks, we are able to find patterns and for example linearly separe the input space into two classes. Adding layers of neurons makes the network able to represent more complex concepts. 

**What are the drawbacks?** One layer can only represent linear functions. Adding multiple layers (and nonlinearities!) makes the network able to model pretty much everything. 

### Deep Learning

When we're talking about **deep learning**, we're talking about models and algorithms that use neural networks with many neurons and many layers, that can learn complex functions. Commonly, levels between 7 and 50 are used. 

## Automated planning

**Automated planning** is an area/application, but also a *way of reasoning*. It consists in synthesizing a sequence of actions performed by an agent that leads from an initial state of the world to a given target state (*goal*). It's a problem solving technique, heavily relying on the **representation** of the possible actions and the world around the agent.

Given an initial state, a set of actions and a state to achieve, the agent has to find **a plan**: a partially or totally ordered set of actions needed to achieve the goal.

So, *how can we represent goals, states, actions?* The initial state is a closed world, while actions can be represented by two lists: the **preconditions** (that have to be true for the actions to be executed), and the **effects**. 

### Swarm intelligence

In nature, swarms achieve a form of *distributed intelligence* that looks like it was **planned**. These smart behaviours emerge autonomously without central coordination. Intelligent systems could base on these phenomenons: *swarm intelligence* and *swarm robotics*.



