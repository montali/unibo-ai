# 2. Dynamics
Dynamics studies how systems **change** over time, for example planetary dynamics studies motion of planets, fluid dynamics studies motion of fluid, crowd dynamics studies the behavior of groups of people and so on.

In the _clockwork_ universe theorized by Laplace in 1840s, an intellect that known the position of every particle in the Universe and all the laws and forces that move them, it is able to predict the future. This theory started to change in the beginning of 900, with Poincaré stating that small differences in the initial conditions produce very great ones in the final phenomena. This fact is today called _butterfly effect_.

## Dynamics of iteration
Dynamics result from some process repeating itself over and over, such as the population of some species. At each time step every member of the population gives birth to some constant number of new members. So the system is regulated only by the _initial population_ and the _birth rate_. The **system state**, composed by **state variables** in this example is composed by _n<sub>t</sub>_ only, which denote the size of the population at time _t_. The initial population is _n<sub>0</sub>. Let _R_ denote the birth rate, we have that _n<sub>1</sub> = Rn<sub>0</sub>_ and so on. In general **_n<sub>t</sub> = Rn<sub>t-1</sub>_**.

This system is _exponential_ in the time series, but _linear_ in the state space. The linearity is due to the fact that there are no interactions among the individuals, so the whole is the sum of its parts.

Let's introduce _nonlinearity_ by adding a _negative feedback_ resulting from interactions above members. We extend the model supposing that limited resources result in the death of some individuals. We obtain the new model **_n<sub>t+1</sub> = R(n<sub>t</sub>-d)_** where _d_ is the _death rate_.

It's reasonable to assume that the death rate is proportional to the square of the population size. So let's assume _d = n<sub>t</sub><sup>2</sup>/k_ where _k_ is the maximum _carrying capacity_. If we substitute it in the previous formula we obtain:
**_n<sub>t+1</sub> = R(n<sub>t</sub>-n<sub>t</sub><sup>2</sup>/k)_**. This is no longer a linear relationship, because we have a term which is squared.

If we rewrite _n<sub>t</sub>/k_ as _x<sub>t</sub>_ we obtain **_x<sub>t+1</sub> = R(x<sub>t</sub>-x<sub>t</sub><sup>2</sup>)_** which is called **logistic map**. Logistic map defines a time series that converges to a value (0<_R_<2) or that oscillates between to values, depending on _R_. Increasing _R_ the period of the oscillation grows reaching rapidly an infinite length cycle (_R_=4), this phenomena is called _onset of chaos_.

Each time the period increases, we say we have a _bifurcation_. The first bifurcation is a _R_=3, the second one at _R_=3.44949. The distance between a bifurcation and another becomes shorter and shorter and around _R_=3.57 the onset of chaos occurs.

If we take the limit of the ratio of consecutive differences as the number of bifurcations tends to infinity, we obtain the _Feigenbaum's constant_. Feigenbaum proved that the result applies to any dynamical system that is characterized through a "one-humped" map, from economics to brain and heart activity.

The fact that a simple and deterministic equation, like the Logistic Map, can possess dynamical trajectories which look like some sort of random noise has disturbing practical implications: arbitrary close initial conditions can lead to trajectories which, after a sufficiently long time, diverge widely.

## Chaos and limits to prediction

Chaos is characterized not so much by randomness but by extreme sensitivity to initial conditions.

Let _f(x) = 4(x - x<sup>2</sup>)_, then _x<sub>1</sub> = f(x<sub>0</sub>) = f<sup>1</sup>_, _x<sub>2</sub> = f(f(x<sub>0</sub>)) = f<sup>2</sup>_ and so on. As already seen _f<sup>1</sup>_ has 1 hump. However the growth of humps is not linear, but is exponential, so _f<sup>n</sup>_ has _2<sup>n-1</sup>_ humps.

![image](https://user-images.githubusercontent.com/31796254/135715890-399308c0-8138-4275-8d3a-c90339418fcc.png)

If we associate to the value of the logistic map a choiche **Yes/No**, choosing "yes" when the value is greater than 0.5 and choosing "no" otherwise, then the logistic map divides the space in regions, as shown in the figure above where green regions correspond to "yes" and red region to "no". The number of regions is twice the number of humps plus one, therefore _f<sup>n</sup>_ has _2<sup>n</sup> + 1_ regions.

Since predicting _f<sup>m</sup>_ needs to distinguish which of the _2<sup>m</sup>+1_ regions the initial value falls into, the initial value should be encoded with at least _m+1_ bits of accuracy, because if we used fewer bits, the prediction would not be better than a random guess. So each time step into the future, "consumes" one bit of information.

## Characteristics of chaos

All chaotic systems have the following properties:
 - _Deterministic_: given its history, the future of a chaotic system is not random but completely determined;
 - _sensitive_: chaotic systems are extremely sensitive to initial conditions (_butterfly effect_);
 - _ergodic_: the state space trajectory of a chaotic system will always return to the local region of previous point on the trajectory, without revisiting any other already visited state.

These properties are necessary but not sufficient. For example if we have a system that is continuous in time, for the ergodic property if it has fewer than 3 state variables it cannot be chaotic. We can demonstrate it for contradiction: suppose that a continuous time system with only 2 state variables is chaotic, then the state space can be seen as a plane. Ergodicity requires that each point in this plane can be reached, with no point ever being revisited, which is equivalent to starting from a point, covering the entire plane with ink without ever crossing a line or lifting the pen and then _returning to the initial point_ - impossible.

## Chaos and randomness
Prior to chaos theory, we believed that determinism and randomness were mutually exclusive and that random behavior was possible only through physical processes related to quantum-level events, but chaos showed that is possible to create an effectively random behavior through a deterministic process

### Tent map
Now we define the Tent Map _T(x)_ as follows:

![image](https://user-images.githubusercontent.com/31796254/135717864-2a8af6ce-a651-4e7b-9073-31451c973dff.png)

Which is not a continuous definition, but a piecewise one, indeed the function is not derivable in _x = 1/2_.

![image](https://user-images.githubusercontent.com/31796254/135717977-4eff710d-b5cc-4373-81ac-cdf63b3be5b0.png)

The Tent Map is important because it has the same property of the Logistic Map _L(x)_, so whatever we prove about one map applies directly to the other.

To compute _T(x)_ we need to know if _x_ is less than _1/2_. Let's rewrite _x_ in its binary form (recall that _0≤x≤1_): _x=0.b<sub>1</sub>b<sub>2</sub>b<sub>3</sub>…_. If _x_ is less than _1/2_, must be _b<sub>1</sub> = 0_, i.e. _x=0.0b<sub>2</sub>b<sub>3</sub>…_. Otherwise must be _b<sub>1</sub> = 1_, i.e. _x=0.1b<sub>2</sub>b<sub>3</sub>…_.

In other words, it suffices to examine _b<sub>1</sub>_ to decide which of the two linear pieces of _T(x)_ to compute: _2x_ or _2(1-x)_. The former is easy: it just need to shift _x_ one bit to the left: _x=0.b<sub>2</sub>b<sub>3</sub>…_. The latter is a bit more complicate:
 1. _(1-x) = 0.1111... - 0.1b<sub>2</sub>b<sub>3</sub>b<sub>4</sub>… = 0.0b̄<sub>2</sub>b̄<sub>3</sub>b̄<sub>4</sub>…_ (_b̄<sub>i</sub> = 1-b<sub>i</sub>_)
 2. Double by shifting one bit to the left: _2(1-x) = 0.b̄<sub>2</sub>b̄<sub>3</sub>b̄<sub>4</sub>_

If we put both together we obtain

![image](https://user-images.githubusercontent.com/31796254/135718940-1be96419-75a1-433e-871b-ab1b80c79aad.png)

So each iteration "consumes" one bit of the input.

What can we say about the long-term trajectory of _T(x)_? We need to consider 3 different cases depending on the choice of _x<sub>0</sub>_.

 1. _x<sub>0</sub>_ is a rational number with a finite binary representation such as _1/2 + 1/32 + 1/1024 = 0.1000100001_;
 2. _x<sub>0</sub>_ is a rational number with an infinite but repeating binary representation such as _0.10111011101110111..._;
 3. _x<sub>0</sub>_ is an irrational number with an infinite binary representation that never repeats such as _π/10_.

In the long term the value of _T(x)_ will be:
 1. "fixed point";
 2. "periodic";
 3. "chaotic";

The Logistic Map at chaos can be turned into a _random bit generator_.
