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

For example suppose <img src="svgs/51ea793aad42e760f5acf5135930081a.svg?invert_in_darkmode" align=middle width=20.45482229999999pt height=22.465723500000017pt/> means that leaving home <img src="svgs/55a049b8f161ae7cfeb0197d75aff967.svg?invert_in_darkmode" align=middle width=9.86687624999999pt height=14.15524440000002pt/> minutes before the flight starts will mean I don't lose the flight. Suppose <img src="svgs/c631f303ec13bde1dd6a5fc8a1bfffde.svg?invert_in_darkmode" align=middle width=103.01948909999999pt height=24.65753399999998pt/>, <img src="svgs/c3801c10df64e11e995bb3b0c074f606.svg?invert_in_darkmode" align=middle width=109.57203014999999pt height=24.65753399999998pt/>, <img src="svgs/aedcb68669c26d6a0a39dd2dda964491.svg?invert_in_darkmode" align=middle width=132.56299155pt height=24.65753399999998pt/>, leaving home 1440 minutes before will mean that we are almost certain not to lose the flight but we will havo to sleep in the airport, how desirable is that? We have to strike a balance.

### Basic probability notation
Consider the assertions about possible worlds.
**Logical assertions** say which worlds are ruled out.
**Probabilistic assertions** say how probable they are.

The set of all possible worlds is called the **sample space**, denoted <img src="svgs/9432d83304c1eb0dcb05f092d30a767f.svg?invert_in_darkmode" align=middle width=11.87217899999999pt height=22.465723500000017pt/>.

Any subset <img src="svgs/2ec0879462895df61085e74108970f69.svg?invert_in_darkmode" align=middle width=44.29211489999999pt height=22.465723500000017pt/> is an **event**.

Any element <img src="svgs/3d85ac6329aa8e5e211a66725e102a98.svg?invert_in_darkmode" align=middle width=42.78522269999999pt height=22.465723500000017pt/> is called a **sample point**/**possible world**/**atomic event**.

A **probability space** or **probability model** is a sample space with an
assignment <img src="svgs/e62710bed731756b5ebe883cb3b56aac.svg?invert_in_darkmode" align=middle width=36.444110999999985pt height=24.65753399999998pt/> for every <img src="svgs/3d85ac6329aa8e5e211a66725e102a98.svg?invert_in_darkmode" align=middle width=42.78522269999999pt height=22.465723500000017pt/> such that <img src="svgs/bd9be5b332320797ae1afdb4f0a871f6.svg?invert_in_darkmode" align=middle width=96.71779095pt height=24.65753399999998pt/> and <img src="svgs/f9965c692a3c010477c2c1f445a8d1a8.svg?invert_in_darkmode" align=middle width=70.5660978pt height=24.657735299999988pt/>.

A **random variable** is a function from sample points to some range, (e.g. reals or Booleans).

P induces a **probability distribution** for any random variable <img src="svgs/cbfb1b2a33b28eab8a3e59464768e810.svg?invert_in_darkmode" align=middle width=14.908688849999992pt height=22.465723500000017pt/>: <img src="svgs/9925fec5670d19a45884a9b5bd4694dd.svg?invert_in_darkmode" align=middle width=222.40284989999998pt height=24.657735299999988pt/>

A probabilistic **proposition** can be described as thedisjunction of events where a logic proposition of is true.

The syntax of propositions varies basing on the type of random variable. Some examples:
- **Propositional** or **Boolean** random variables: *Cavity=true*
- **Discrete** random variables (finite or infinite): Weather <img src="svgs/c973c3602a8d89e113316aeb53b8b6b0.svg?invert_in_darkmode" align=middle width=23.74424909999999pt height=24.65753399999998pt/>sunny,rain,cloudy<img src="svgs/3b95a53f17b42854b8a9aadfd2e09e98.svg?invert_in_darkmode" align=middle width=8.219209349999991pt height=24.65753399999998pt/>, *Weather=rain*
- **Continuous** random variables (bounded or unbounded): *Temp=21,6*; *Temp<22,0*

The **Joint Probability Distribution** for a set of random variables gives the probability of every atomic event on those variables (i.e., every sample point)