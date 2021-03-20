# Bayesian network representation

## Independence

Independence is related to what we've already seen. If we consider our model of the world with 4 independent variables, imagine that *cavity, tootache* and *catch* are binary RVs, and *Weather* is a discrete variable with 4 values. 

However, if we consider that the weather is independent from the *tooth situation*, we can separate these two worlds, and the distribution can be expressed with <img src="svgs/3dc0c2a66a5936690c18f2951d111dec.svg?invert_in_darkmode" align=middle width=84.01796369999998pt height=21.18721440000001pt/> values, instead of <img src="svgs/cf32576b88f8278331688ebdb73dc12c.svg?invert_in_darkmode" align=middle width=79.45173884999998pt height=21.18721440000001pt/>.

We get from 32 values to 12, only thanks to the observation that these are independent.

How do we denote **independence**? We use 
<p align="center"><img src="svgs/f747c03437e8f9dd1c8752f382bdace6.svg?invert_in_darkmode" align=middle width=96.99177015pt height=16.438356pt/></p>
 to say that <img src="svgs/53d147e7f3fe6e47ee05b88b166bd3f6.svg?invert_in_darkmode" align=middle width=12.32879834999999pt height=22.465723500000017pt/> is independent to <img src="svgs/61e84f854bc6258d4108d08d4c4a0852.svg?invert_in_darkmode" align=middle width=13.29340979999999pt height=22.465723500000017pt/>. How can this be a property of the distribution? We can say that the probability of <img src="svgs/9f52414eb1bc1399e6100e831442c5c3.svg?invert_in_darkmode" align=middle width=115.67926589999998pt height=24.65753399999998pt/> or <img src="svgs/9abb9428462ae3587e58a3865ac31d39.svg?invert_in_darkmode" align=middle width=116.64387074999998pt height=24.65753399999998pt/>. A last way of saying this is <img src="svgs/4ccfbf6c413696300fa5e25bdde3481b.svg?invert_in_darkmode" align=middle width=157.33453394999998pt height=24.65753399999998pt/>.

Independence is a property of the way we model the world, but it is reflected in the distributions!

This type of independence (**marginal**) is very convenient but it is pretty rare: it is difficult to find separate values in the same domain.

Given that we have a cavity, the probe will catch. This happens even if we also have a tootache, or we don't. So if you already know that you have a cavity, whether you have a tootache or not, the probability of catch is the same:
<p align="center"><img src="svgs/558ee1ea08cd9c616c1412def9619055.svg?invert_in_darkmode" align=middle width=386.40405375pt height=16.438356pt/></p>
How can I express this concept? This is **powerful**: we can forget about the tootache. We can express this by writing a simple conditional expression like the preceding formula. As we see, the independence is not absolute as before, but it is conditional:
<p align="center"><img src="svgs/fe8af644e76fa7f64505a082e25c44a8.svg?invert_in_darkmode" align=middle width=282.32853825pt height=16.438356pt/></p>
Therefore, if we gather the evidence, we can in exchange produce some independence expressions/relations that help us simplify the problem!

This idea is called **conditional independence**. Catch is conditionally independent of tootache given cavity, if the following holds: <img src="svgs/02e0d411f1ad0878609b33f9b059521b.svg?invert_in_darkmode" align=middle width=405.47945459999994pt height=24.65753399999998pt/>, basically *tootache* is ininfluential.

Since the independence is symmetrical, we can write this in other ways, like saying *the probability of tootache fiven catch and cavity, is equal to the probability of tootache given cavity*:
<p align="center"><img src="svgs/a114078bc816bebcc262536942669591.svg?invert_in_darkmode" align=middle width=437.4429972pt height=16.438356pt/></p>
The third formula uses the product: the joint probability of having tootache and catch, given cavity, is equal to the joint probability of the two distributions:
<p align="center"><img src="svgs/99df1fade8c1c3c1792af62a8c410d62.svg?invert_in_darkmode" align=middle width=573.288606pt height=16.438356pt/></p>
These expressions are the same, the only change is that now we're having **conditionals**.

This is very important: imagine that we don't have 3 variables, but 100, the result of this possibility of *expressing conditional independence relations in our domain* will let us reduce the number of independent probability values that we must put in our system from an exponential number to, in the best case, a **linear number**.

Let's say we had 3 binary variables, where the combinations are 8 values, of which 7 are independent. Thanks to the conditional independence between tootache and catch, given cavity, we obtain an equivalent expression where the probabilities are equal to <img src="svgs/8405b8254ecbe4103191bfdc7ae9e3ba.svg?invert_in_darkmode" align=middle width=413.47060259999995pt height=24.65753399999998pt/>.

So in total, we'll have 5 independent numbers instead of 7. This is a small gain in the example, but becomes big in real life.

## Bayes rule

This can be obtained thanks ot the product rule: 
<p align="center"><img src="svgs/3eeaeb3eda0fb806e132e24b6378b46f.svg?invert_in_darkmode" align=middle width=280.58363024999994pt height=16.438356pt/></p>

<p align="center"><img src="svgs/9efeabaff69d49384312229b1c279b96.svg?invert_in_darkmode" align=middle width=168.33074115pt height=38.83491479999999pt/></p>

This allows us to compute problems like the one that follows:

*<img src="svgs/034d0a6be0424bffe9a6e7ac9236c0f5.svg?invert_in_darkmode" align=middle width=8.219209349999991pt height=21.18721440000001pt/> individual in 50,000 suffers from meningitis, <img src="svgs/4024fa5a3921f078171014869f74efb1.svg?invert_in_darkmode" align=middle width=21.91788224999999pt height=24.65753399999998pt/> from a stiff neck, <img src="svgs/495761d29bb672c2620f7086be77f8d1.svg?invert_in_darkmode" align=middle width=30.137091599999987pt height=24.65753399999998pt/> of the times meningitis causes a stiff neck. What is the probability that an individual with a stiff neck has meningitis?*

Now, lets's consider <img src="svgs/1fb98e08db9ca82ac96aa8dd4a649229.svg?invert_in_darkmode" align=middle width=244.52055704999998pt height=24.65753399999998pt/>. If we also consider what we knew, i.e. that toothache is independent of catch, given cavity. Then, wecan say that this can be expressed as the product of two probabilities:

<img src="svgs/25b4faff48ef59bb4dfe5c244f1da506.svg?invert_in_darkmode" align=middle width=144.42349844999998pt height=24.65753399999998pt/><img src="svgs/27290dc895d845aaaa0cf6cd9efb862f.svg?invert_in_darkmode" align=middle width=10.95894029999999pt height=18.264896099999987pt/><img src="svgs/ed2e7c46dbecfa86b604d783eac1c7d4.svg?invert_in_darkmode" align=middle width=38.323974149999984pt height=22.831056599999986pt/>)
<img src="svgs/636cd23b96bfc59f90f7bad1fc5d57ca.svg?invert_in_darkmode" align=middle width=60.028488299999985pt height=24.65753399999998pt/> toothache <img src="svgs/27290dc895d845aaaa0cf6cd9efb862f.svg?invert_in_darkmode" align=middle width=10.95894029999999pt height=18.264896099999987pt/> catch <img src="svgs/57fe5a91a139252a27ed191b2680eda7.svg?invert_in_darkmode" align=middle width=4.5662248499999905pt height=24.65753399999998pt/> Cavity <img src="svgs/8316f8ee6c3ba48f414564b8cbbbb664.svg?invert_in_darkmode" align=middle width=25.70774084999999pt height=24.65753399999998pt/> Cavity <img src="svgs/c0ef67b62c66b541c81467e7b3e3dc2c.svg?invert_in_darkmode" align=middle width=6.39271709999999pt height=24.65753399999998pt/> <img src="svgs/fb3b227c9514189e8a55ed763906da48.svg?invert_in_darkmode" align=middle width=47.24305409999999pt height=24.65753399999998pt/> toothache <img src="svgs/57fe5a91a139252a27ed191b2680eda7.svg?invert_in_darkmode" align=middle width=4.5662248499999905pt height=24.65753399999998pt/> Cavity <img src="svgs/8316f8ee6c3ba48f414564b8cbbbb664.svg?invert_in_darkmode" align=middle width=25.70774084999999pt height=24.65753399999998pt/> catch <img src="svgs/57fe5a91a139252a27ed191b2680eda7.svg?invert_in_darkmode" align=middle width=4.5662248499999905pt height=24.65753399999998pt/> Cavity <img src="svgs/8316f8ee6c3ba48f414564b8cbbbb664.svg?invert_in_darkmode" align=middle width=25.70774084999999pt height=24.65753399999998pt/> Cavity <img src="svgs/c0ef67b62c66b541c81467e7b3e3dc2c.svg?invert_in_darkmode" align=middle width=6.39271709999999pt height=24.65753399999998pt/>

We lastly hae to mention one classifier that we've already seen: the *Naive Bayes classifier*. These are quite efficient. This can be formalized as follows:
<p align="center"><img src="svgs/09e8b3fe16d1af7b1db7a9d94d884cf4.svg?invert_in_darkmode" align=middle width=530.470314pt height=36.6554298pt/></p>
Now, if we can make the independence assumption, the distribution can be expressed as a product of terms, where each term links an individual effect with a cause. 

## Bayesian networks

These are a way to represent knowledge. A very simple graphical notation that allows us to express conditional independence assertions in a graphical way. We find a directed **acyclic graph**. ![Network](./res/bayesian_net.png)This is a bayesian network, and it allows us to capture direct consequences (tootache is a direct consequence of cavity), but another important information is what *is missing*: weather is disconnected from the rest, i.e. it is independent from the other ones.

To further build the network, we can add a *conditional probability table*, giving the distribution over <img src="svgs/1338d1e5163ba5bc872f1411dd30b36a.svg?invert_in_darkmode" align=middle width=18.269651399999987pt height=22.465723500000017pt/> for each combination of parent values.![Network with CPT](./res/bayesian_net_with_cpt.png)

Note that we're not listing the *nots* in the tables: they're simply <img src="svgs/94cd2e933afb2438e94eecda17e6d170.svg?invert_in_darkmode" align=middle width=41.14717529999999pt height=22.465723500000017pt/>.

Let's give a look to another example: the *student network* (2nd book, not AIMA).

![Student network](./res/student_net.png)

The interesting point here are the **reasoning patterns**. We can define various types of reasoining:

* **Causal**, we use it to make predictions;
* **Evidential**, used to produce explanations. We know nothing, and we want to *know whether George is a good recruit*. Imagine that he has a weak letter. Based on our evidence, is George a potential recruit? I.e. what is the probability of intelligence?
* **Intercausal**, allows us to infer reasons behind a conclusion, like *why did George score high?* 

### Compactness

A CPT for boolean <img src="svgs/1338d1e5163ba5bc872f1411dd30b36a.svg?invert_in_darkmode" align=middle width=18.269651399999987pt height=22.465723500000017pt/> with <img src="svgs/63bb9849783d01d91403bc9a5fea12a2.svg?invert_in_darkmode" align=middle width=9.075367949999992pt height=22.831056599999986pt/> boolean parents has <img src="svgs/91f4e50a1561b60d45e7079ca70f2ed4.svg?invert_in_darkmode" align=middle width=15.48523844999999pt height=27.91243950000002pt/> rows for th combinations of parent values. Each row requires one number <img src="svgs/2ec6e630f199f589a2402fdf3e0289d5.svg?invert_in_darkmode" align=middle width=8.270567249999992pt height=14.15524440000002pt/> for <img src="svgs/1338d1e5163ba5bc872f1411dd30b36a.svg?invert_in_darkmode" align=middle width=18.269651399999987pt height=22.465723500000017pt/> true.

The number of parameters therefore grows linearly with the number of nodes, except for the full joint distribution, which grows exponentially.

Global semantics define, in practice, that the individual parent/child relations perfectly encode all the full joint probability distributions. In other words, <img src="svgs/df256e4da1f5cf7434edd98740d0e93a.svg?invert_in_darkmode" align=middle width=100.00365045pt height=24.65753399999998pt/>, i.e. the full joint didstriubtion probability is equal to <img src="svgs/5291369f15ac3eb38a51a3c29bad3f1c.svg?invert_in_darkmode" align=middle width=195.53358989999998pt height=26.438629799999987pt/>.

For example, <img src="svgs/d0471b53be9920ec409068e93f6843d0.svg?invert_in_darkmode" align=middle width=458.63831145pt height=24.65753399999998pt/>.

Now, we can illustrate how independence can be captured by a bayesian network through some examples: what is <img src="svgs/ddcb483302ed36a59286424aa5e0be17.svg?invert_in_darkmode" align=middle width=11.18724254999999pt height=22.465723500000017pt/> independent of in the student network problem?

If we know the grade, then the letter is independent on anything else, since the letter only depends on ht grade. We can say that if G is in the evidence (i.e. given the grade), the leter is independent of anything else:
<p align="center"><img src="svgs/298687fc4d214a4f8070b6f5985d3134.svg?invert_in_darkmode" align=middle width=148.18348709999998pt height=16.438356pt/></p>
If we still don't know anything, we can say that S is independent of D:
<p align="center"><img src="svgs/0345d879aa28f29d26c408e815af6fec.svg?invert_in_darkmode" align=middle width=96.46318109999999pt height=16.438356pt/></p>
and we know that given I, <img src="svgs/f1190578faae00c049df34e20fde250f.svg?invert_in_darkmode" align=middle width=148.26902309999997pt height=24.65753399999998pt/>.

### Flow of probabilistic influence

We want to know how to determine independence basing on the graph. They may have influence on one another basing on the **flow of influence**.![Screenshot 2021-02-26 at 16.01.18](/Users/simone/UniBO/unibo-ai/Fundamentals of AI - Module 3/res/fow.png)

This flow can be either **direct** (direct causes and direct effect) or indirect:

* <img src="svgs/e3e48dc87c5c913c44d94b0104bf57c2.svg?invert_in_darkmode" align=middle width=53.67565334999998pt height=22.465723500000017pt/> (direct cause)
* <img src="svgs/2a3520d1a2aee7a77274c702ca0b5b8c.svg?invert_in_darkmode" align=middle width=53.67565334999998pt height=22.465723500000017pt/> (direct effect)
* <img src="svgs/55a8b8fe35143c6b0d556fd46a25cae1.svg?invert_in_darkmode" align=middle width=91.64352285pt height=22.465723500000017pt/> (causal trail)
* <img src="svgs/10189ec44663423d9ed6c39b1256f01e.svg?invert_in_darkmode" align=middle width=91.64352285pt height=22.465723500000017pt/> (evidential trail)
* <img src="svgs/3086a478932aefd1ef2b3ecb2bee8600.svg?invert_in_darkmode" align=middle width=91.64352285pt height=22.465723500000017pt/> (common cause)
* <img src="svgs/772ad123744ad8be728c398dedaa34d1.svg?invert_in_darkmode" align=middle width=91.64352285pt height=22.465723500000017pt/> (common effect)

Note that if we know G (Z in the notation), the flow is **broken**! If the middle node is part of the evidence, there's no way for them to influence each other.

The last relation is different from the others. G is a common effect of D and I. D and I are independent, however they have G, a common effect. Now, if we don't see that effect (in the evidence), they keep being independent. However, if we know the grade, the two different causes are now linked! *If the guy is intelligent, but the grade is low, maybe the difficulty was high.* This works not only if G is in the evidence, but L too: in a way, L tells us something about G. If we have the element or its subtree, this is possible. 

Remember that bayesian networks are kind of symmetric: an arrow allows us to infer the inverse. *The flow can go in both ways.* Whenever I have a direct link, I can never say that two instances are independent. 

A trail is said **active** if either there is no node along the trail that is in Z, ad each time we got a V structuer, we must have the contrary.

There is also a method to determine the independence, which is algorithmic and less intuitive. 





