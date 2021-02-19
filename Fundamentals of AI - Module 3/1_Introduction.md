# Introduction

This module is about uncertainty and probabilistic reasoning. We cannot observe everything in the world, something will be hidden, non determinable, etc.
We need to be able to model this uncertainty.
When we make decisions we must keep a belief state and generate a contingency plan.
This module is composed by 10 hours of lecture in 5 lectures.

### Topics
- Basic probability notation: Probabilistic notations already studied in Statistical and Matematical Methods, Logical connectives
- Inference using full joint distributions: Take decisions basing on the modeled world
- Independence: Construct complex models of the world in an abstract way (more compact than probabilistic notation)
- Bayesian network representation: Another way of mdeling the world
- Constructing Bayesian networks
- Exact and approximate inference: Thought process based on baesyan networks 
- Simple case studies

### Material
- Slides on Virtuale
- The same of FAIKR mod 1 (Russel, Norvig, "Artificial Intelligence. A modern Approach"), chapters 13 & 14
- ipython notebooks on Virtuale

### Exams
Grades on an 8-point scale (to be summed with mod 2 and 4 and averaged with mod 1). Grades don't expire.

Two alterantives:
- Written exam
  - Questions and exercises, 4 dates a year (jun, jul, sep, jan)
  - slide 5 contains example case studies similar to questions in the exam
  - If you don't like your grade you can repeat it
- Project
  - Implementation of simple case study in pgmpy or other library
  - ipython notebook + good notebook comments or pdf report
  - Oral exam to present work done and answer questions (3 discussion periods in jun+jul, sep and jan+feb)
  - Can be done alone or in groups u to 3 people
  - You should give the project exam when you are ready to make it one-shot, you shouldn't get in a situation where you don't like your grade

## Uncertainty

Modeling an uncertain world with standard logical notations will lead either to false statements, conclusions that are too weak for decision making (for example full of conditionals).
Two methods for handling uncertainty:
- Default or nonmonotonic logic
  - Make reasonable assumptions and model the world with these assumptions ("Assume my car does not have a flat tire...")
  - Hardly usable for very complex scenarios
  - "Monotonic" = Will not take away conclusions if you add facts, the more facts you have, the more conclusions you have. "Nonmonotonic" => You can use facts which reduce conclusions.
- Rule-based systems with fudge factors
  - Introduce operators with quantified probability

Remark: Fuzzy logic handles degree of truth, NOT uncertainty.

### Probability
Probabilistic assertions summarize uncertainty. Probabilities relate propositions to one's own state of knowledge and aren't claims of a "probabilistic tendency" in the current situation.

Decision theory: In order to make decisions under uncertainty you need a way to model the uncertainty ("Probability theory") and a set of preferences basing on which you can obtain an "utility function" which quantifies how much I like a certain outcome ("Utility theory").

For example suppose $A_n$ means that leaving home $n$ minutes before the flight starts will mean I don't lose the flight. Suppose $P(A_{25}) = 0.04$, $P(A_{120}) = 0.95$, $P(A_{1440}) = 0.9999$, leaving home 1440 minutes before will mean that we are almost certain not to lose the flight but we will havo to sleep in the airport, how desirable is that? We have to strike a balance.

### Basic probability notation
Consider the assertions about possible worlds.
**Logical assertions** say which worlds are ruled out.
**Probabilistic assertions** say how probable they are.

The set of all possible worlds is called the **sample space**, denoted $\Omega$.

Any subset $A \in \Omega$ is an **event**.

Any element $\omega \in \Omega$ is called a **sample point**/**possible world**/**atomic event**.

A **probability space** or **probability model** is a sample space with an
assignment $P(\omega)$ for every $\omega \in \Omega$ such that $0 \le P(\omega) \le 1$ and $\sum_{\omega}\omega = 1$.

A **random variable** is a function from sample points to some range, (e.g. reals or Booleans).

P induces a **probability distribution** for any random variable $X$: $P(X = x_i)=\sum_{\omega:X(\omega)=x_i}P(\omega)$

A probabilistic **proposition** can be described as thedisjunction of events where a logic proposition of is true.

The syntax of propositions varies basing on the type of random variable. Some examples:
- **Propositional** or **Boolean** random variables: *Cavity=true*
- **Discrete** random variables (finite or infinite): Weather $\in\{$sunny,rain,cloudy$\}$, *Weather=rain*
- **Continuous** random variables (bounded or unbounded): *Temp=21,6*; *Temp<22,0*

The **Joint Probability Distribution** for a set of random variables gives the probability of every atomic event on those variables (i.e., every sample point)