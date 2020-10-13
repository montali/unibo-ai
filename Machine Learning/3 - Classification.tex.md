# Classification

Given a dataset composed of D attributes, one of these is the **class**, i.e. a finite value provided by the supervisor. We want to learn how to guess the value of the D-th attribute (class) for individuals which have not been examined by experts. 

## Classification model

It is an algorithm which, given an individual for which the class is not known, computes a guess of the class. In general, the algorithm can have different *flavors* distinguishable by *parameters*: some values which can be tuned to influence the quality of the result. 

So, we'll want to choose the learning algorithm, let the algorithm learn its parametrization, then assess the quality of the model. 

We'll learn using a **training set**, which contains already classified individuals. This will obviously have to be similar to the other ones, as to be representative. When the learning is done, we want to **estimate the accuracy**, for which we'll use a new set, already labeled, to check if the model computes them right. 

There are two *flavors* for classification:

- **Crisp**: the classifier assigns to each individual one label
- **Probabilistic**: the classifier assigns a probability for each of the possible labels

## Classification with decision trees

Decision trees have a quite long story, and have been improved in several ways. 

A tree has inner nodes. We start from the root, with a test. For instance, we could test an attribute $d$ of an element $e$. If, for example, $x_2>5$, we'll execute the right node, if not we'll execute the left one. Than, the same thing happens with the inner node. When we come to an end, it will be a prediction, i.e. a **leaf node**. The thing is: we've gotta learn what decisions to put in the decision tree, and this is what the training aims to achieve. 

Given a set $\Epsilon$ of elements, we'll grow a decision tree as follows: 

- If all the elements belong to a class $c$ or if $E$ is small, generate a leaf node with label $c$
- Otherwise, we choose a test based on a single attribute which may have $N$ (at least two) outcomes, and will become the root of $N$ branches

There are many problems to solve: which attribute should we test, which kind of test, what does *$E$ is small* mean?

So, given a census dataset, we may ask ourselves: *can we learn the wealth attribute just by looking at the other ones?*

![Census dataset](./res/census.png)

Let's first perform an **exploratory analysis**, i.e. looking at the data, maybe generating histograms...

We could generate a $k$-dimensional contingency table, through SQL or whatever. Contingency tables could give us an insight on correlations between attributes, but we could need lots of them! *A shit fucking ton of 'em!* 

So, how can we evaluate if a pattern is interesting? To do so, there are several methods. One of them is based on *information theory*, born thanks to the concept of entropy.

To introduce this concept of entropy, an example is needed. Given a variable with 4 possible values and a given probability distribution, an observation of the data stream could return BAACBADCDA. If I want to transmit to a remote agent those readings, I can encode them for instance with two bits, (00,01,10,11). Therefore, the transmission will be  01000010010011101100... But what happens if I the probability distribution is uneven? 

$P(A)=0.5, P(B)=0.25, P(C)=0.125, P(D)=0.125$

Of course, the already said coding works, but we could do better: there's a coding requiring a smaller average of bits per symbol:

$A=0, B=10, C=110, D=111$

Even with 3 symbols with equal probability, this technique could save bits!

In the general case, given a source $X$ with $V$ possible values, with their probability distribution, the best coding allows the transmission with an average number of bits given by $H(X)=-\sum_j p_j log_2(p_j)$. $H(X)$ is the entropy of the information source $X$.

### Meaning of entropy of an information source

High entropy means that the probabilities are mostly similar. Low entropy means that some symbols have much higher probability. Higher number of allowed symbols gives higher entropy. 

In a binary source, the entropy goes to 0 when one of the probabilities goes to 1 and the other to 0.

 So, what is the purpose of these considerations on entropy? Let's consider a toy example, where in the $X$ column is the graduation of a friend, and the $Y$ column contains whether the person likes *Joker* or not. We can derive the probabilities from value frequencies. 

![Joker table](./res/joker.png)

Now, let's consider the entropy of Y considering only the rows in which $X=v$. When we filter by Math, the entropy stays $1$, but when we filter by History, the entropy goes to $0$. 

This could also be interpreted as the minimum number of bits needed to transmit the value if the receiver know $X$. So, the conditional specific entropy is:

![Entropy](/Users/simone/UniBO/unibo-ai/Machine Learning/res/entropy.png)

$H(Y|X)=0.5$, therefore, $X$ provided some insight on $Y$.

Now, how can we decide if a person likes *Joker* or not?

### Information Gain

Now we can formally define the **Information Gain**, which states the amount of insight that $X$ provides in the forecasting of $Y$.

$I G(Y \mid X)=H(Y)-H(Y \mid X)$

So, **how can we use** the information gain? It could help us predict the probability of long life given some historical data on person characteristics and life style. *Higher IG means that a 2D contingency table would be more interesting.* 

Getting back to the decision tree, **how can we decide which attribute to test?** Now the answer is obvious: we should choose the one with the maximum information gain for the class in the dataset! Having decided this, we'll now have a number of subtrees to generate. 

Deciding the attribute giving the highest IQ couldn't always be the right choice. But we'll get to this later.

So in the end, the algorithm looks like this:

![Decision tree algorithm](./res/decision-tree-algo.png)

We'll execute the generated decision tree on the training set itself, count the number of discordances, thus obtain the **training set error**. Obviously, when trying to use the tree with the test set, the error rises. 

Is there any general lesson we can learn from this fact? With a smaller tree we increase the training error, but we decrease the test error. Bigger trees are more prone to overfitting.

## Overfitting

In real life, there's noise in data. The ability to predict classes is indeed not perfect, and we'll sometimes make wrong predictions. **Overfitting** happens when the learning is affected by noise. 

Stating this in a formal way, while a decision tree is a hypothesis of the relationship between the predictor attributes and the class. If $h$ is the hypotesis, we can define the error of the hypothesis on the training set $error_{train}(h)$, and the error of the hypothesis on the entire dataset $error_{\epsilon} (h)$. $h$ overfits the training set if there is an alternative hypothesis $h'$ such that

$error_{train}(h)<error_{train} (h')$ 

$error_{\epsilon} (h) > error_{\epsilon}(h')$

Overfitting is caused by two phenomenons, the **presence of noise** and the **lack of representative instances**.

**Everything should be made as simple as possible, but not simpler.**

**Pruning** a decision tree is a way to simplify it.

Pre-pruning means early stopping the tree while it is growing, post-pruning is a pruning done after the tree is finished.

The **validation set** is a third dataset, which we can use after the pruning. In this way, my set will be more reliable: I'm using fresh data. 

There are many ways to prune data, one of these is the **statistical pruning**: it uses statistics to infer if a new node I'm generating is prone to being affected by noise. 

The **minimum description length principle** states that when the complication is bigger than the reduction of errors we are basically wasting our time.

![Pruning effects on classification](/Users/simone/UniBO/unibo-ai/Machine Learning/res/pruning.png)

The supervised data are then split in 3 parts:

- **Training set**, to build the model;
- **Validation set**, to tune the model and minimize the error;
- **Test set**, to assess the final error.

### Minimum Description Length

This is another *way of thinking*. We know that the learning process produces a theory on a set of data, which can be then used to predict the class on a set of data. So, how can we describe this theory? We could encode the theory, and the errors underneath. So, the length of the theory is the sum of the length of the tree + the length of the errors. So, the **Minimum Description Length Principle** states that we should choose the theory with the **shorter description**: a bigger theory includes bigger errors. In the extreme cases, we may have a very simple theory with lots of exceptions, and a very complex theory with a few exceptions. 

A decision tree is not **extremely powerful**: it's a compromise, it works and it's not too computationally heavy. We should choose a single attribute to train it, otherwise it might get too complicated.

### Characteristics of a decision tree

It is a **non-parametric approach** to build classification models. Finding the best one is **NP complete**, while the heuristic algorithms allow to find sub-optimal solutions in reasonable time. The run time use of a DT to classify new instances is extremely efficient: $\mathcal{O}(h)$, where $h$ is the height of the tree.

### Choosing the attribute to split the dataset

We're looking for the split generating the maximum **purity**. We can use some functions, like **Information Gain**, **Gini Index**, **Misclassification Error**, the latter being the worse one. 

Of course there are several variants for building these trees, we can use different strategies for the construction, the pruning...

