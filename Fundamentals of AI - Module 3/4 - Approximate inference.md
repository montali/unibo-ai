# Approximate inference

The idea behind approximate inference is stochastic approximation: we draw <img src="svgs/4e9e77702a1c8278864c977f3ab48980.svg?invert_in_darkmode" align=middle width=14.99998994999999pt height=31.141535699999984pt/> samples from the distribution of <img src="svgs/f9c4988898e7f532b9f826a75014ed3c.svg?invert_in_darkmode" align=middle width=14.99998994999999pt height=22.465723500000017pt/> samples, then compute an approximate posterior probability <img src="svgs/ecae884902d4935aa4b43064e23b222b.svg?invert_in_darkmode" align=middle width=12.83677559999999pt height=31.141535699999984pt/>! This, for <img src="svgs/0320e20eccefc37aad6bfae68d99eee9.svg?invert_in_darkmode" align=middle width=55.57054139999999pt height=31.141535699999984pt/>, will converge to the true probability!

This method, although simple, can be extended to the case where we know some evidence. How can we estimate the probability given the evidence? We produce the samples. It is not super clever: we produce the samples but we don't use them in the end!



