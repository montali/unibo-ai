# Bayesian network representation

## Independence

Independence is related to what we've already seen. If we consider our model of the world with 4 independent variables, imagine that *cavity, tootache* and *catch* are binary RVs, and *Weather* is a discrete variable with 4 values. 

However, if we consider that the weather is independent from the *tooth situation*, we can separate these two worlds, and the distribution can be expressed with <!-- $2*2*2 + 4 = 12$ --> <img style="transform: translateY(0.1em); background: white;" src="..\svg\7KaWybFlyb.svg"> values, instead of <!-- $2*2*2*4 = 32$ --> <img style="transform: translateY(0.1em); background: white;" src="..\svg\LFLjDL1tjn.svg">.

We get from 32 values to 12, only thanks to the observation that these are independent.

How do we denote **independence**? We use <!-- $\mathbf{P} \models(A \perp B)$ --> <img style="transform: translateY(0.1em); background: white;" src="..\svg\j9zYUTTtdL.svg"> to say that <!-- $A$ --> <img style="transform: translateY(0.1em); background: white;" src="..\svg\ZVLwYqs1oN.svg"> is independent to <!-- $B$ --> <img style="transform: translateY(0.1em); background: white;" src="..\svg\dYPC7iZKLL.svg">. How can this be a property of the distribution? We can say that the probability of <!-- $P(A|B)=P(A)$ --> <img style="transform: translateY(0.1em); background: white;" src="..\svg\AUzKms1RyM.svg"> or <!-- $P(B|A)=P(B)$ --> <img style="transform: translateY(0.1em); background: white;" src="..\svg\Vx196nYcbB.svg">. A last way of saying this is <!-- $P(A,B)=P(A)P(B)$ --> <img style="transform: translateY(0.1em); background: white;" src="..\svg\yg5sNlYJuR.svg">.

Independence is a property of the way we model the world, but it is reflected in the distributions!

This type of independence (**marginal**) is very convenient but it is pretty rare: it is difficult to find separate values in the same domain.

Given that we have a cavity, the probe will catch. This happens even if we also have a tootache, or we don't. So if you already know that you have a cavity, whether you have a tootache or not, the probability of catch is the same:

<!-- $$
P(\text { catch } \mid \text { toothache, cavity })=P(\text { catch } \mid \text { cavity })
$$ --> 

<div align="center"><img style="background: white;" src="..\svg\sKdjtspn6p.svg"></div>

How can I express this concept? This is **powerful**: we can forget about the tootache. We can express this by writing a simple conditional expression like the preceding formula. As we see, the independence is not absolute as before, but it is conditional:

<!-- $$
\mathbf{P} \models(\text { Catch } \perp \text { Toothache } \mid \text { Cavity })
$$ --> 

<div align="center"><img style="background: white;" src="..\svg\yG7zLC8Rhw.svg"></div>

Therefore, if we gather the evidence, we can in exchange produce some independence expressions/relations that help us simplify the problem!

This idea is called **conditional independence**. Catch is conditionally independent of tootache given cavity, if the following holds: <!-- $\mathrm{P}(\text { Catch } \mid \text { Toothache, Cavity })=\mathrm{P}(\text { Catch } \mid \text { Cavity })$ --> <img style="transform: translateY(0.1em); background: white;" src="..\svg\TXDzkzbbIX.svg">, basically *tootache* is ininfluential.

Since the independence is symmetrical, we can write this in other ways, like saying *the probability of tootache fiven catch and cavity, is equal to the probability of tootache given cavity*:

<!-- $$
\mathrm{P}(\text { Toothache } \mid \text { Catch, Cavity })=\mathrm{P}(\text { Toothache } \mid \text { Cavity })
$$ --> 

<div align="center"><img style="background: white;" src="..\svg\xfyoHy0Noo.svg"></div>

The third formula uses the product: the joint probability of having tootache and catch, given cavity, is equal to the joint probability of the two distributions:

<!-- $$
\mathrm{P} \text { ( Toothache, Catch|Cavity) }=\mathrm{P} \text { ( Toothache|Cavity) } \mathrm{P} \text { ( Catch|Cavity) }
$$ --> 

<div align="center"><img style="background: white;" src="..\svg\EnG3kxtzbZ.svg"></div>

These expressions are the same, the only change is that now we're having **conditionals**.

This is very important: imagine that we don't have 3 variables, but 100, the result of this possibility of *expressing conditional independence relations in our domain* will let us reduce the number of independent probability values that we must put in our system from an exponential number to, in the best case, a **linear number**.

Let's say we had 3 binary variables, where the combinations are 8 values, of which 7 are independent. Thanks to the conditional independence between tootache and catch, given cavity, we obtain an equivalent expression where the probabilities are equal to <!-- $\mathrm{P}(\text { Toothache } \mid \text { Cavity }) \mathrm{P}(\text { Catch } \mid \text { Cavity }) \mathrm{P}(\text { Cavity })$ --> <img style="transform: translateY(0.1em); background: white;" src="..\svg\vsZ8s4vPpN.svg">.

So in total, we'll have 5 independent numbers instead of 7. This is a small gain in the example, but becomes big in real life.

## Bayes rule

This can be obtained thanks ot the product rule:

<!-- $$
P(a \wedge b)= P(a \mid b) P(b)=P(b \mid a) P(a)
$$ --> 

<div align="center"><img style="background: white;" src="..\svg\p2YyxTCitz.svg"></div>

<!-- $$
P(a \mid b)=\frac{P(b \mid a) P(a)}{P(b)}
$$ --> 

<div align="center"><img style="background: white;" src="..\svg\gGSkknhJcR.svg"></div>

This allows us to compute problems like the one that follows:

*1 individual in 50,000 suffers from meningitis, 1% from a stiff neck, 70% of the times meningitis causes a stiff neck. What is the probability that an individual with a stiff neck has meningitis?*

Now, lets's consider <!-- $\mathrm{P}(\text { Cavity } \mid \text { toothache } \wedge \text { catch })$ --> <img style="transform: translateY(0.1em); background: white;" src="..\svg\6ABF8D2nJY.svg">. If we also consider what we knew, i.e. that toothache is independent of catch, given cavity. Then, we can say that this can be expressed as the product of two probabilities:

<!-- $$
\begin{aligned}
&P(\text{Cavity}|\text{toothache} \wedge \text{catch} ) \\
=&\alpha \mathbf{P}( \text{toothache} \wedge \text{catch} \mid \text{Cavity} ) \mathbf{P}( \text{Cavity} ) \\
=&\alpha \mathbf{P}( \text{toothache} \mid \text{Cavity} ) \mathbf{P}( \text{catch} \mid \text{Cavity} ) \mathbf{P}( \text{Cavity} )
\end{aligned}
$$ --> 

<div align="center"><img style="background: white;" src="..\svg\SqyzbUmRQp.svg"></div>

We lastly hae to mention one classifier that we've already seen: the *Naive Bayes classifier*. These are quite efficient. This can be formalized as follows:

<!-- $$
\mathbf{P}\left(\text { Cause }, \text { Effect }_{1}, \ldots, \text { Effect }_{n}\right)=\mathbf{P}(\text { Cause }) \prod_{i} \mathbf{P}\left(\text { Effect }_{i} \mid \text { Cause }\right)
$$ --> 

<div align="center"><img style="background: white;" src="..\svg\DijIQgMLhj.svg"></div>

Now, if we can make the independence assumption, the distribution can be expressed as a product of terms, where each term links an individual effect with a cause. 

## Bayesian networks

These are a way to represent knowledge. A very simple graphical notation that allows us to express conditional independence assertions in a graphical way. We find a directed **acyclic graph**. ![Network](./res/bayesian_net.png)This is a bayesian network, and it allows us to capture direct consequences (tootache is a direct consequence of cavity), but another important information is what *is missing*: weather is disconnected from the rest, i.e. it is independent from the other ones.

To further build the network, we can add a *conditional probability table*, giving the distribution over <!-- $X_i$ --> <img style="transform: translateY(0.1em); background: white;" src="..\svg\aqzgMu4fat.svg"> for each combination of parent values.

![Network with CPT](./res/bayesian_net_with_cpt.png)

Note that we're not listing the *nots* in the tables: they're simply <!-- $1-P$ --> <img style="transform: translateY(0.1em); background: white;" src="..\svg\FzeOErtHlT.svg">.

Let's give a look to another example: the *student network* (2nd book, not AIMA).

![Student network](./res/student_net.png)

The interesting point here are the **reasoning patterns**. We can define various types of reasoning:

* **Causal**, we use it to make predictions;
* **Evidential**, used to produce explanations. We know nothing, and we want to *know whether George is a good recruit*. Imagine that he has a weak letter. Based on our evidence, is George a potential recruit? I.e. what is the probability of intelligence?
* **Intercausal**, allows us to infer reasons behind a conclusion, like *why did George score high?* 

### Compactness

A CPT for boolean <!-- $X_i$ --> <img style="transform: translateY(0.1em); background: white;" src="..\svg\i8pwsIb0DY.svg"> with <!-- $k$ --> <img style="transform: translateY(0.1em); background: white;" src="..\svg\4nCKIv4HXq.svg"> boolean parents has <!-- $2^k$ --> <img style="transform: translateY(0.1em); background: white;" src="..\svg\zmfDzlo6yh.svg"> rows for th combinations of parent values. Each row requires one number <!-- $p$ --> <img style="transform: translateY(0.1em); background: white;" src="..\svg\efxBUNpN7q.svg"> for <!-- $X_i$ --> <img style="transform: translateY(0.1em); background: white;" src="..\svg\SK4gwAFQpE.svg"> true.

The number of parameters therefore grows linearly with the number of nodes, except for the full joint distribution, which grows exponentially.

Global semantics define, in practice, that the individual parent/child relations perfectly encode all the full joint probability distributions. In other words, <!-- $P\left(x_{1}, \ldots, x_{n}\right)$ --> <img style="transform: translateY(0.1em); background: white;" src="..\svg\HVyi9SOuoA.svg">, i.e. the full joint distribution probability is equal to <!-- $\prod_{i=1}^{n} P\left(x_{i} \mid \text { parents }\left(X_{i}\right)\right)$ --> <img style="transform: translateY(0.1em); background: white;" src="..\svg\eFjKrVSeAo.svg">.

For example, <!-- $P(j \wedge m \wedge a \wedge \neg b \wedge \neg e)=P(j|a)P(m|a)P(a|\neg b, \neg e)P(\neg b)P(\neg e)$ --> <img style="transform: translateY(0.1em); background: white;" src="..\svg\pS5SYi5qxo.svg">.

Now, we can illustrate how independence can be captured by a bayesian network through some examples: what is <!-- $L$ --> <img style="transform: translateY(0.1em); background: white;" src="..\svg\x2nXnDaxxy.svg"> independent of in the student network problem?

If we know the grade, then the letter is independent on anything else, since the letter only depends on ht grade. We can say that if G is in the evidence (i.e. given the grade), the leter is independent of anything else:

<!-- $$
P \models (L \perp D, I, S |G)
$$ --> 

<div align="center"><img style="background: white;" src="..\svg\YwniKF5CCe.svg"></div>

If we still don't know anything, we can say that S is independent of D:

<!-- $$
\mathbf{P} \models(S \perp D)
$$ --> 

<div align="center"><img style="background: white;" src="..\svg\rG6waQZXOK.svg"></div>

and we know that given I, <!-- $\mathbf{P} \models(S \perp G, D, L |I)$ --> <img style="transform: translateY(0.1em); background: white;" src="..\svg\0L9j3TMTcV.svg">.

### Flow of probabilistic influence

We want to know how to determine independence basing on the graph. They may have influence on one another basing on the **flow of influence**.

![Screenshot 2021-02-26 at 16.01.18](res/fow.png)

This flow can be either **direct** (direct causes and direct effect) or indirect:

* <!-- $X\rightarrow Y$ --> <img style="transform: translateY(0.1em); background: white;" src="..\svg\CeI9yYkZ4n.svg"> (direct cause)
* <!-- $X \leftarrow Y$ --> <img style="transform: translateY(0.1em); background: white;" src="..\svg\NnNeLhars0.svg"> (direct effect)
* <!-- $X \rightarrow Z \rightarrow Y$ --> <img style="transform: translateY(0.1em); background: white;" src="..\svg\v0h7DWPSYi.svg"> (causal trail)
* <!-- $X \leftarrow Z \leftarrow Y$ --> <img style="transform: translateY(0.1em); background: white;" src="..\svg\bIRiJ6HHhx.svg"> (evidential trail)
* <!-- $X \leftarrow Z \rightarrow Y$ --> <img style="transform: translateY(0.1em); background: white;" src="..\svg\xtrwfsH4GJ.svg"> (common cause)
* <!-- $X \rightarrow Z \leftarrow Y$ --> <img style="transform: translateY(0.1em); background: white;" src="..\svg\RCXjKgi2TI.svg"> (common effect)

Note that if we know G (Z in the notation), the flow is **broken**! If the middle node is part of the evidence, there's no way for them to influence each other.

The last relation is different from the others. G is a common effect of D and I. D and I are independent, however they have G, a common effect. Now, if we don't see that effect (in the evidence), they keep being independent. However, if we know the grade, the two different causes are now linked! *If the guy is intelligent, but the grade is low, maybe the difficulty was high.* This works not only if G is in the evidence, but L too: in a way, L tells us something about G. If we have the element or its subtree, this is possible. 

Remember that bayesian networks are kind of symmetric: an arrow allows us to infer the inverse. *The flow can go in both ways.* Whenever I have a direct link, I can never say that two instances are independent. 

A trail is said **active** if either there is no node along the trail that is in Z, ad each time we got a V structure, we must have the contrary.

There is also a method to determine the independence, which is algorithmic and less intuitive. 





