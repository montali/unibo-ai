# Acting under uncertainty

Imagine we have to reach an airport on time. Our question is: when shall we leave home? Let's consider $A_t$ as leaving the airport $t$ minutes before the flight. We don't know about the road state, other drivers, traffic... The sensors are present but may be noisy, for example the traffic reports may be wrong. There's uncertainty: we could get a flat tire. 

Adopting a purely logical approach may risk falsehood or lead to weak conclusions.

What could we do to deal with uncertainty? The first method would be using *default or non-monotonic logic* (assuming our car doesn't have a flat tire) which we'll see in module 2, and the second one would be **rule-based systems with fudge factors**, i.e. there's this rule, but the rule doesn't hold 100% of the cases. 

This takes into account probability, i.e. *what you can observe in a given number of experiments.*

We therefore introduce *fuzzy logic*, i.e. a logic that handles **degree of truth** (not uncertainty!).

Probabilistic assertions are able to summarize uncertainty. We don't know where these probabilities come from, as they may come from experiments or not... 

They are a concise expression of what happens in the world, which hides two things: laziness (our failure to enumerate exceptions, qualifications, as we don't want to enumerate things and keep things compact) and ignorance (things that we simply don't know).

For example, $P(A_{25} | no reported accidents)=0.06$, with $|$ meaning *given that*.

These tell us something about our own state of knowledge, i.e. our beliefs about the world basing on the knowledge we have. 

So, what do we do with these ways we have of coping with uncertainties? Develop systems that allow us to make decisions!

Utility functions define our gain by taking an action, for example, if our objective would be being on time+eating healthy, we'll want to optimize the sum. This is used in *utility theory*, which, together with probabilistic theory, gets us **decision theory**

## Basic probability notation

We consider *assertions* that say how probable possible worlds are. 

The **sample space** is the set of all the possible worlds, i.e. possible interpretations (which are $2^n$). An **event** is a subset of this, composed of *atomic events* or sample points/possible worlds. Having defined these possible worlds, we may want to label them to reason with probability, i.e. *this world is more probable than another one*. $P(\omega)$ is a **probability space**, i.e. the probability of a world being true. Obviously, the sum of $P$ over the sample space will be 1. A notion we'll use is *probability distribution*, that given a **random variable** (i.e. a function from sample points to some range) X: $P(X=x_i)=\sum P(\omega)$.

Finally, propositions: we can think of them as the event where the proposition is true: if we got boolean RVs $A$ and $B$ we can say that an event $a$ is the set of sample points in which $A(\omega)$ is true. The event $a \wedge b$ is the set in which they are both true. 

We also have discrete, continuous RVs in addition to the boolean ones. 

A *joint probability distribution* expresses the probability for each possible world described by the combination of multiple RVs, i.e. on every sample point. Knowing this, we can easily estimate the probability of an event by summing the probabilities for atomic events. 



