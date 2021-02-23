# Bayesian network representation

## Independence

Independence is related to what we've already seen. If we consider our model of the world with 4 independent variables, imagine that *cavity, tootache* and *catch* are binary RVs, and *Weather* is a discrete variable with 4 values. 

However, if we consider that the weather is independent from the *tooth situation*, we can separate these two worlds, and the distribution can be expressed with $2*2*2 + 4$ values, instead of $2*2* 2*4$.

We get from 32 values to 12, only thanks to the observation that these are independent.

How do we denote **independence**? We use 
$$
\mathbf{P} \models(A \perp B)
$$
 to say that $A$ is independent to $B$. How can this be a property of the distribution? We can say that the probability of $P(A|B)=P(A)$ or $P(B|A)=P(B)$. A last way of saying this is $P(A,B)=P(A)P(B)$.

Independence is a property of the way we model the world, but it is reflected in the distributions!

This type of independence (**marginal**) is very convenient but it is pretty rare: it is difficult to find separate values in the same domain.

Given that we have a cavity, the probe will catch. This happens even if we also have a tootache, or we don't. So if you already know that you have a cavity, whether you have a tootache or not, the probability of catch is the same:
$$
P(\text { catch } \mid \text { toothache, cavity })=P(\text { catch } \mid \text { cavity })
$$
How can I express this concept? This is **powerful**: we can forget about the tootache. We can express this by writing a simple conditional expression like the preceding formula. As we see, the independence is not absolute as before, but it is conditional:
$$
\mathbf{P} \models(\text { Catch } \perp \text { Toothache } \mid \text { Cavity })
$$
Therefore, if we gather the evidence, we can in exchange produce some independence expressions/relations that help us simplify the problem!

This idea is called **conditional independence**. Catch is conditionally independent of tootache given cavity, if the following holds: $\mathrm{P}(\text { Catch } \mid \text { Toothache, Cavity })=\mathrm{P}(\text { Catch } \mid \text { Cavity })$, basically *tootache* is ininfluential.

Since the independence is symmetrical, we can write this in other ways, like saying *the probability of tootache fiven catch and cavity, is equal to the probability of tootache given cavity*:
$$
\mathrm{P}(\text { Toothache } \mid \text { Catch, Cavity })=\mathrm{P}(\text { Toothache } \mid \text { Cavity })
$$
The third formula uses the product: the joint probability of having tootache and catch, given cavity, is equal to the joint probability of the two distributions:
$$
\mathrm{P} \text { ( Toothache, Catch|Cavity) }=\mathrm{P} \text { ( Toothache|Cavity) } \mathrm{P} \text { ( Catch|Cavity) }
$$
These expressions are the same, the only change is that now we're having **conditionals**.

This is very important: imagine that we don't have 3 variables, but 100, the result of this possibility of *expressing conditional independence relations in our domain* will let us reduce the number of independent probability values that we must put in our system from an exponential number to, in the best case, a **linear number**.

Let's say we had 3 binary variables, where the combinations are 8 values, of which 7 are independent. Thanks to the conditional independence between tootache and catch, given cavity, we obtain an equivalent expression where the probabilities are equal to $\mathrm{P}(\text { Toothache } \mid \text { Cavity }) \mathrm{P}(\text { Catch } \mid \text { Cavity }) \mathrm{P}(\text { Cavity })$.

So in total, we'll have 5 independent numbers instead of 7. This is a small gain in the example, but becomes big in real life.



