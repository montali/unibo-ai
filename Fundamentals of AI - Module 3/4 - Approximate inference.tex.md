# Approximate inference

The idea behind approximate inference is stochastic approximation: we draw $\hat{N}$ samples from the distribution of $N$ samples, then compute an approximate posterior probability $\hat{P}$! This, for $\hat{N}\rightarrow N$, will converge to the true probability!

This method, although simple, can be extended to the case where we know some evidence. How can we estimate the probability given the evidence? We produce the samples. It is not super clever: we produce the samples but we don't use them in the end!



