# 1. Dynamics
Dynamics studies how systems **change** over time, for example planetary dynamics studies motion of planets, fluid dynamics studies motion of fluid, crowd dynamics studies the behaviour of groups of people and so on.

In the _clockwork_ universe theorized by Laplace in 1840s, an intellect that known the position of every particle in the Universe and all the laws and forces that move them, it is able to predict the future. This theory started to change in the beginning of 900, with Poincaré stating that small differences in the initial conditions produce very great ones in the final phenomena. This fact is today called _butterfly effect_.

## Dynamics of iteration
Dynamics result from some process repeating itself over and over, such as the population of some species. At each time step every member of the population gives birth to some constant number of new members. So the system is regulated only by the _initial population_ and the _birth rate_. The **system state**, composed by **state variables** in this example is composed by _n<sub>t</sub>_ only, which denote the size of the population at time _t_. The initial population is _n<sub>0</sub>. Let _R_ denote the birth rate, we have that _n<sub>1</sub> = Rn<sub>0</sub>_ and so on. In general **_n<sub>t</sub> = Rn<sub>t-1</sub>_**.

This system is _exponential_ in the time series, but _linear_ in the state space. The linearity is due to the fact that there are no interactions among the individuals, so the whole is the sum of its parts.

Let's introduce _nonlinearity_ by adding a _negative feedback_ resulting from interactions above members. We extend the model supposing that limited resources result in the death of some individuals. We obtain the new model **_n<sub>t+1</sub> = R(n<sub>t</sub>-d)_** where _d_ is the _death rate_.

It's reasonable to assume that the death rate is proportional to the square of the population size. So let's assume _d = n<sub>t</sub><sup>2</sup>/k_ where _k_ is the maximum _carrying capacity_. If we substitute it in the previous formula we obtain:
**_n<sub>t+1</sub> = R(n<sub>t</sub>-n<sub>t</sub><sup>2</sup>/k)_**. This is no longer a linear relationship, because we have a term which is squared.

If we rewrite _n<sub>t</sub>/k_ as _x<sub>t</sub>_ we obtain **_x<sub>t+1</sub> = R(x<sub>t</sub>-x<sub>t</sub><sup>2</sup>)_** which is called **logistic map**. Logistic map defines a time series that converges to a value (0<_R_<2) or that oscillates between to values, depending on _R_. Increasing _R_ the period of the oscillation grows reaching rapidly an infinite-lenght cycle (_R_=4), this phenomena is called _onset of chaos_.

Each time the period increases, we say we have a _bifurcation_. The first bifurcation is a _R_=3, the second one at _R_=3.44949. The distance between a bifurcation and another becomes shorter and shorter and around _R_=3.57 the onset of chaos occurs.

If we take the the limit of the ratio of consecutive differences as the number of bifurcations tends to infinity, we obtain the _Feigenbaum's constant_. Feigenbaum proved that the result apllies to any dynamical system that is characterized through a "one-humped" map, from economics to brain and heart activity.

The fact that a simple and deterministic equation, like the Logistic Map, can possess dynamical trajectories which look like some sort of random noise has disturbing practical implications: arbitrarly close initial conditions can lead to trajectores which, after a sufficiently long time, diverge widely.

Chaos is characterized not so much by randomness but by extreme sensitivity to initial conditions.

Let _f(x) = 4(x - x<sup>2</sup>)_, then _x<sub>1</sub> = f(x<sub>0</sub>) = f<sup>1</sup>_, _x<sub>2</sub> = f(f(x<sub>0</sub>)) = f<sup>2</sup>_ and so on. As already seen _f<sup>1</sup>_ has 1 hump. However the growth of humps is not linear, but is exponential, so _f<sup>n</sup>_ has _2<sup>n-1</sup>_ humps.

