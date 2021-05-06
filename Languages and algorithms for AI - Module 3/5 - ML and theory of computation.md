# ML and theory of computation

How can we see ML as an input-output task? Encoding! There's a canonical way of seeing a problem as a function, or better its **characteristic function**, i.e. something telling us whether a function is inside or outside $\mathcal{L}$. Any learning algorithm actually computes a function having input the training data, producing in output classifiers. We are of course restricting the scope: we're talking about supervised learning. 

Seeing data as binary strings is kinda easy: everything can be encoded as binary strings. But how about classifiers? Depending on the domain, the thing can be quite different! The classifier itself is a function: it takes data as input, and outputs a class. The output of learning is an algorithm itself! 

The kind of rectangles we use to label data are not standard rectangles: the vertices are perfectly aligned with the axis. The algorithm knows that data are labeled according to a rectangle, but it doesn't know the actual rectangle. We'd like our classifier to converge to a correct one the more training data we add. Converge to what? The classifier that was *impliclty used* when labeling the data.

Another crucial point is the following: how about how the data is created? Are we sure that the data *arrives* in the right square? It may well happen that the distribution is not standard. We'd like our algorithm to be robust, i.e. independently on the distribution of the training data, the algorithm still produces good results. The algorithm is supposed to work for every possible distribution, not just for one. 

We could define an algorithm that given the data, determines the smallest rectangle R including all the positive instances, then return R. This rectangle could be very different from the target. But it's not that easy to conclude that it is a wrong algorithm. The only thing we can hope for is that it is wrong on limits, while correctness holds for the majority of cases. We have to talk about **accuracy**. 

