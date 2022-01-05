# 2. Linear classifier

In lesson 1 we have seen how to use kNN  to create an image classifier. The main problem is that it needs a lot of sample, so now we see what happens if we use just one **global parametric** model.

What we want to find are a function _f_ and a parameter _W_, such that, given an image _x_, _f(x;W) = class_, where _class_ is a scalar.
Since _class_ is a scalar, and _x_ is a _Nx1_ flatten vector, the easiest approach is to define _f(x;W) = Wx_ with _W_ being a _1xN_ vector. In this way the result _class_ is a scalar and our only concern is to find a proper vector _W_.

This is actually a bad idea, since classes are assigned to integer ids randomly, so 2 classes with nearby ids does not necessarly share visual similarities.

A better approach is to look for a parameter _W_ such that, given an image _x_, _f(x;W) = Wx = scores_, where scores is a vector _Mx1_, with _M_ the number of classes and so _W_'s size is _MxN_. What we obtain is a score for each class and the predicted one will be the class with the highest score. This process corresponds to correlate an image with each class "template". Templates are learned during training.

Actually, _f_ is defined as _f(x;θ) = Wx + b_ (with _θ = (W, b)_ and _b_'s shape equal to _Mx1_). _b_ is called _bias_ and it makes the model more flexible.

## Learning as optimization
The **hypothesis space H** of a machine learning model is the space of the functions it can learn. So the learning step corresponds to solve the optimization problem that finds the best function _h*_ ∈ H such that _h* =_ argmin<sub>h∈H</sub> _L_(_h,D<sup>train</sup>_). In a paramteric model this means finding the best parameters _θ*_ such that
_θ* =_ argmin<sub>θ∈Θ</sub> _L_(_θ,D<sup>train</sup>_).

_L_ is called **loss function**. Defining it as the number of errors (**0-1 loss**) is not a good choice, because the number of errors is insensible to small (and sometimes also big) changes of the parameters, so the 0-1 loss does not tell us if we are "moving" in the "right" direction.

## Softmax function
There are theoretical and practical reasons to **prefer a loss that transforms the scores computed by the classifier into probabilities** and then perform maximum likelihood estimation of _θ_. The simplest way to transform random scores into a probability mass function over the space of classes is the **softmax** function. It applies the exponential function to scores, and then normalize the scores vector.

## Cross-entropy loss
After we have applied softmax to our scores, we can think our linear classifier as a family of probability mass functions over the classes given an image, indexed by the vector of parameters _θ_. Then, if we calculate the maximum likelihood estimation of _θ_ we obtain the cross-entropy loss.

### Losses in PyTorch

In PyTorch there are both `NLLLoss` (where NLL stands for negative log likelihood) and `CrossEntropyLoss`. The former expects raw scores, while the latter expects probabilities.
