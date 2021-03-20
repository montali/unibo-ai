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

The **Joint Probability Distribution** for a set of random variables gives the probability of every atomic event on those variables (i.e., every sample point).

This is easy when we have a world modeled by 2 RVs, but real applications are obviously more complicated than that. 

For example, we can have RVs with **continuous values**. Imagine we have got the temperature RV (between 10 and 20 deg.), the value of this temperature can be described by some distribution, like the **uniform distribution**:

![Uniform distribution](./res/uniform.png)

or the **Gaussian (Normal) Distribution**.

These distributions differ in the probabilities given to discrete RVs. 

The probability for a discrete value is always between 0 and 1, and the sum of distributions must be 1. In the case of continuous values, we can't sum them! Therefore, we **integrate** obtaining the PDF:
<p align="center"><img src="svgs/b153b5e71b600e2134a918696a287ebe.svg?invert_in_darkmode" align=middle width=132.09715365pt height=40.2286731pt/></p>
So, one reason for things to get complicated are continuous values. Another one, is the fact that IRL you don't have 2 values but many of them! The number of events grows exponentially (<img src="svgs/f8f25e4580c418a51dc556db0d8d2b93.svg?invert_in_darkmode" align=middle width=16.34523329999999pt height=21.839370299999988pt/>).

We'll need something that gives us as much information as a joint probability distribution, but **more compact**! 

In the examples seen so far, we considered probabilities that we can call **prior**. Most commonly, we know something about the world, and we're in a position to betterm estimate the probability of events: for example, we may state the probability of the weather being sunny, given that it's 30 outside.

The **conditional probability** (aka *posterior*) tells us the probability of an event, given another one:

![Conditional probability](/Users/simone/UniBO/unibo-ai/Fundamentals of AI - Module 3/res/conditional.png)

Note that *tootache* is **all we know**! If the dentist collected evidence for *tootache **and** cavity*, the probability of cavity becomes 100%. The less specific belief is still true, but it is not always useful. It may happen that new evidence is still irrelevant to the problem: this happens when the RVs are **independent**. We can use this notion of independence to *reduce our scope* to a more restricted set of RVs.![New evidence and independence](./res/new_evidence.png)

We can also write expressions that denote conditional probabilities in a more compact way by using **capital letters**: when something starts with a capital, it is true.

We're now talking about a distribution, not an event, and we have a bold **P**, denoting the whole distribution, *the whole table*. 

Conditional probability can be formally defined using this formula:
<p align="center"><img src="svgs/b13b585e36793ab4df7c35026f677e35.svg?invert_in_darkmode" align=middle width=223.92001994999998pt height=38.83491479999999pt/></p>
It basically is the ratio between the joint probability of <img src="svgs/44bc9d542a92714cac84e01cbbb7fd61.svg?invert_in_darkmode" align=middle width=8.68915409999999pt height=14.15524440000002pt/> and <img src="svgs/4bdc8d9bcfb35e1c9bfb51fc69687dfc.svg?invert_in_darkmode" align=middle width=7.054796099999991pt height=22.831056599999986pt/>, over the probability of <img src="svgs/4bdc8d9bcfb35e1c9bfb51fc69687dfc.svg?invert_in_darkmode" align=middle width=7.054796099999991pt height=22.831056599999986pt/>.![Conditional probabilities in whole distributions](./res/conditional_whole_distrib.png)

The probabilities **chain rule** says that the joint probability of the probabilities <img src="svgs/03cce5c7708a8d16e4b6e70e79dbc521.svg?invert_in_darkmode" align=middle width=71.04842414999999pt height=22.465723500000017pt/>, is the product of the probabilities <img src="svgs/7462e2dd47a84a2e41972b4d64cc641b.svg?invert_in_darkmode" align=middle width=114.31908344999998pt height=24.65753399999998pt/> and <img src="svgs/8c4284d323dc6e6615985bde8d0a0099.svg?invert_in_darkmode" align=middle width=141.45199695pt height=24.65753399999998pt/>,  which can be further expanded: we'll repeat this until we have the probabilities of one single value, given everything else.
<p align="center"><img src="svgs/409ca6cdfe55bd9bab37442ef089a604.svg?invert_in_darkmode" align=middle width=913.02883155pt height=120.6782676pt/></p>
We'll see this formulation many times.

## Inference using full joint distributions

We'll now try to extract informations from full joint distributions. 

Starting from the joint distribution we see here, with binary RVs having probabilities, we think of a proposition as all the atomic events in which the proposition is true. We can compute the probability of <img src="svgs/f50853d41be7d55874e952eb0d80c53e.svg?invert_in_darkmode" align=middle width=9.794543549999991pt height=22.831056599999986pt/> by summing the probability of the events in which <img src="svgs/f50853d41be7d55874e952eb0d80c53e.svg?invert_in_darkmode" align=middle width=9.794543549999991pt height=22.831056599999986pt/> is true.

![Tootache probs](./res/tootache.png)

With <img src="svgs/3af88d03f62ae297e9026ef94c354094.svg?invert_in_darkmode" align=middle width=27.146075549999992pt height=22.831056599999986pt/> *tootache*:
<p align="center"><img src="svgs/a57b736708188275a80ffc92155c46e4.svg?invert_in_darkmode" align=middle width=381.78661619999997pt height=16.438356pt/></p>
We could even consider <img src="svgs/3af88d03f62ae297e9026ef94c354094.svg?invert_in_darkmode" align=middle width=27.146075549999992pt height=22.831056599999986pt/> *tootache or cavity*:
<p align="center"><img src="svgs/b26a33915d5dded45144c7b1a28c4fee.svg?invert_in_darkmode" align=middle width=577.2203976pt height=36.164383199999996pt/></p>
and also conditional probabilities
<p align="center"><img src="svgs/e2d988edf5b3569fd194808ada694f8b.svg?invert_in_darkmode" align=middle width=355.67925855pt height=46.074327749999995pt/></p>
This is called **inference by enumeration**: we enumerate all the events and calculate probabilities. This is possible for small problems only, otherwise it becomes pretty complicated.

Let's think about this last expression for a while: we have the probability of not having cavity given a tootache. We don't consider this as the probability itself, but as the way of getting to the distribution <img src="svgs/089f96df3802c0605ccba5947541ed1c.svg?invert_in_darkmode" align=middle width=141.43063274999997pt height=24.65753399999998pt/>.

We now have the Random Variable <img src="svgs/dca4133d4b456d6b18a3f668490174f0.svg?invert_in_darkmode" align=middle width=50.42018189999999pt height=22.465723500000017pt/>, which represents the distribution. This is simply a compact way of expressing the probabilities <img src="svgs/0d3e5c601b07952c83137f303ea125c5.svg?invert_in_darkmode" align=middle width=138.27392534999998pt height=24.65753399999998pt/> and <img src="svgs/7c7e93aa3fb4f336840a0c90ecff5c93.svg?invert_in_darkmode" align=middle width=185.43962084999998pt height=24.65753399999998pt/>. It's a **vector**!

From the point of the distribution, we get that the denominator is just a normalization constant over the distribution: it's always gonna get normalized to the same values!

So another, even more compact way of expressing this is:
<p align="center"><img src="svgs/3269295e4d552b0bedf447fd1a06ac71.svg?invert_in_darkmode" align=middle width=371.30735895pt height=16.438356pt/></p>
with <img src="svgs/c745b9b57c145ec5577b82542b2df546.svg?invert_in_darkmode" align=middle width=10.57650494999999pt height=14.15524440000002pt/> being a normalization constant we don't care about. Let's say in the end we get 2 values in our vector, and they don't sum to 1: we normalize it to make it so, and we're done!

When we're summing over a row or column, we are **marginalizing** or **summing out**: <img src="svgs/21f27d86587a5cd5c5bdc43f817ea4a4.svg?invert_in_darkmode" align=middle width=171.87790619999998pt height=24.65753399999998pt/>.

When we're considering evidence (a conditional probability, then), we're performing **reduction**, since we're considering the possible worlds that agree with the evidence: <img src="svgs/24d3128a17e913c080ad6232d01f91d8.svg?invert_in_darkmode" align=middle width=391.19288835pt height=24.65753399999998pt/>.

This is general what we can tell from the specific example. A **probability query** is something in the form *the probability distribution of some RV given some evidence*. There is one or more query variables, and one or more evidence variables. In order to answer this query, we consider the other variables (the hidden variables <img src="svgs/4e3e2ee5648e950a5f30f25e4d17b39f.svg?invert_in_darkmode" align=middle width=14.794451099999991pt height=22.55708729999998pt/> that don't appear in the expression), and in order to compute the probability of <img src="svgs/91aac9730317276af725abd8cef04ca9.svg?invert_in_darkmode" align=middle width=13.19638649999999pt height=22.465723500000017pt/> given the evidence, we apply the expression we've seen earlier, and in order to compute the joint probability of Y given the E evidence, we sum over the hidden variables (for all the values), and end up with the distribution.
<p align="center"><img src="svgs/404fc15a27306d1d4a79c903fc2b2262.svg?invert_in_darkmode" align=middle width=427.46579699999995pt height=37.03214955pt/></p>
This is **inference by enumeration**: we enumerate the possible worlds, and we sum the values. If there are not many, we can do that. This method has some obvious problems, two having to do with the **complexity** (time and space), the last one being how do we find the numbers for <img src="svgs/1d32e1b09db4b9b39346f04b20114c1b.svg?invert_in_darkmode" align=middle width=43.28476019999999pt height=24.65753399999998pt/> entries. We'll need a more compact method. That's what we're going to see next.





