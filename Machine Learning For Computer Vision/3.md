# 3. Improving gradient descent
Gradient descent is one of the possible ways to find the solution to the problem of minimizing the loss. Our loss decomposes into a sum of contributions of individuals examples in the training set, which means, since the gradient is a linear operators, that also the gradient decomposes into a sum of gradients.
So if we have a very big dataset, like ImageNet (1.3M of training images) we must compute the gradient for each image and the sum all of them, just to know in each direction perform one step, which usually is very tiny, since the learning rate is usually small.

This is very inefficient but it's the only way to compute the _exact_ gradient. The point is that this is not actually the real gradient, indeed even if ImageNet is large, it is just a small fraction of all the possible images of its 1000 classes, so the gradient computed by gradient descent is an approximation of the _true_ gradient, even when computed on all available training data.

## SGD - Stochastic Gradient Descent

So if our only possibility is to rely on an approximation, at least we can choose a more efficient one, like the **Stochastic Gradient Descent (SGD)**, that is sometimes called _on-line gradient descent_, since it consists in updating the model immediately after each sample is received. One important step in the SGD is to shuffle the sample at each epoch, because it minimize the probabilities of having a bad ordering of our input data. The algorithm can be summed up in these steps:
 - Randomly initialize parameters
 - for _e = 0,...,E-1_ epochs:
   - Randomly shuffle examples in _D<sup>train</sup>_
   - for _i = 0,...,N-1_:
     - forward pass
     - backward pass
     - update the parameters

## SGD - Stochastic Gradient Descent with minibatches

A compromise between the two extremes of updating the model only after that every image in the training set is processed and update it after each image, is to use a **mini-batch of data of size _B_** at each iteration instead of a single example. This is called **Stochastic Gradient Descent with minibatches**, but more often that not people just simply say SGD to refer to this version with minibatches, instead that to the base SGD. The number of parameters update in each epoch will be _U = |N/B|_.

The algorithm can be summed up by these steps:
 - Randomly initialize parameters
 - for _e = 0,...,E-1_ epochs:
   - Randomly shuffle examples in _D<sup>train</sup>_
   - for _u = 0,...,U-1_:
     - forward pass over _B_ examples
     - backward pass over _B_ examples
     - update the parameters

What is a good choice for _B_? Usually larger batches provide smoother (less noisy) estimations of the gradient and also better exploit parallel hardware. However very large batches could be to big for GPU's memory. Usually a good choice is a power of 2 that fit in the GPU's memory. Smaller batches may have a regularization effect and results in better generalization, at the cost of higher runtime.

## Problems with gradient descent and SGD and how to solve them

Gradient descent and SGD (with or without minibatches) **like "spheres"** because in this case the convergence is straight and fast. In other shapes, like "canyons" performance can be very slower and/or we could be forced to use small learning values (resulting in even more slow performances).

### Second order methods

The solution is to use a so-called **second order method**. The idea is to take larger steps in areas of low curvatures and smaller steps in areas of high curvatures. Doing some math, it turns out the best update is _-f'(x<sub>t</sub>)/f''(x<sub>t</sub>). When theoretical conditions are met (quadratic functions) we get convergence in one step without using the learning rate, unfortunately in the real world our loss is not quadratic at all. So we have to compute this:

![](assets/markdown-img-paste-20211003174317512.png)
where _H<sub>f</sub> is the Hessian matrix, which is the matrix of the second-order derivatives.

In modern machine learning we have millions of parameters, and storing _H_ requires _O(k<sup>2</sup>) memory. Moreover we have to invert it, which takes _O(k<sup>3</sup>)_ operations. There are algorithms to reduce memory and time complexity in the batch case but they are yet to be extended successfully in the mini-batch case.

### Critical points and Momentum

Another problem of (S)GD are critical points, like saddle points and local minima, which can attract and halt the optimization, even if in reality is difficult to be halted by a saddle point, but it is still probable for local minima.

One of the most used modifications of SGD, which also solve this problem, is **momentum**. The key idea is to adda _velocity_ term to SGD, so now the update rule is:

_v<sup>(t+1)</sup> = &beta;v<sup>(t)</sup> - lr &nabla;L(&theta;<sup>(t)</sup>)_  
_&theta;<sup>(t+1)</sup> = &theta;<sup>(t)</sup> + v<sup>(t+1)</sup>_

Where _&beta;_ is the momentum. It reduces the effect of noise and allows to obtain faster convergence.

#### Nesterov momentum

It's a variant of momentum proposed in 1983.

_v<sup>(t+1)</sup> = &beta;v<sup>(t)</sup> - lr &nabla;L(&theta;<sup>(t)</sup> + &beta;v<sup>(t)</sup>)_  
_&theta;<sup>(t+1)</sup> = &theta;<sup>(t)</sup> + v<sup>(t+1)</sup>_

The concepte is to look ahead to the next position, calculate the gradient there, and use it to correct the computed direction at the current point. usually there is not a big difference in performances between Nesterov momentum and base momentum, but sometimes using Nesterov's helps getting better performances.

### Adaptive Learning Rates
If changes in the steepness of the loss are axis-aligned, we can think also of momentum as:
 - reducing the step of updates for dimensions whose gradient direction is not consistent across iterations;
 - increasing the step of updates for dimensions whose gradients direction is consistent across iterations.

However, momentum does not assume that effects are axis-aligned and may therefor lead to better solutions, if properly tuned. Yet, adaptive learning rates methods, and especially ADAM, tend to work reasonably well even when their parameters are not perfectly tuned.

#### AdaGrad

It propose to rescale each entry of the gradient with the inverse of the history of its values.

![](assets/markdown-img-paste-20211006152311914.png)

What happens is that weights receiving small gradients have their effective learning rate increased, while, on the other hand, weights  receiving large gradients have their effective learning rate decreased. The main problem of this approach is that it may readuce all learning rates too early, when we are still far from a good minimum.

#### RMSProp

This modification to AdaGrad introduces a parameter &beta; &in; [0,1] (typically 0.9 or higher) to govern the dacay of _s<sup>(t)</sup>_ through an exponential moving average (EMA)

![](assets/markdown-img-paste-20211006153009812.png)

What happens is that the more the history is in the past, the less it influences the computation of the new learning rate.

#### ADAM

ADAM is a combination between RMSProp and momentum

![](assets/markdown-img-paste-20211006153811321.png)
