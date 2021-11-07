# Classification

Given a dataset composed of D attributes, one of these is the **class**, i.e. a finite value provided by the supervisor. We want to learn how to guess the value of the D-th attribute (class) for individuals which have not been examined by experts.

## Classification model

It is an algorithm which, given an individual for which the class is not known, computes a guess of the class. In general, the algorithm can have different _flavors_ distinguishable by _parameters_: some values which can be tuned to influence the quality of the result.

So, we'll want to choose the learning algorithm, let the algorithm learn its parametrization, then assess the quality of the model.

We'll learn using a **training set**, which contains already classified individuals. This will obviously have to be similar to the other ones, as to be representative. When the learning is done, we want to **estimate the accuracy**, for which we'll use a new set, already labeled, to check if the model computes them right.

There are two _flavors_ for classification:

- **Crisp**: the classifier assigns to each individual one label
- **Probabilistic**: the classifier assigns a probability for each of the possible labels

## Classification with decision trees

Decision trees have a quite long story, and have been improved in several ways.

A tree has inner nodes. We start from the root, with a test. For instance, we could test an attribute $d$ of an element <!-- $e$ --> <img style="transform: translateY(0.1em); background: white;" src="..\svg\lkjYKpZRfU.svg">. If, for example, <!-- $x_2>5$ --> <img style="transform: translateY(0.1em); background: white;" src="..\svg\8XxzCJ7vAZ.svg">, we'll execute the right node, if not we'll execute the left one. Than, the same thing happens with the inner node. When we come to an end, it will be a prediction, i.e. a **leaf node**. The thing is: we've gotta learn what decisions to put in the decision tree, and this is what the training aims to achieve.

Given a set <!-- $\Epsilon$ --> <img style="transform: translateY(0.1em); background: white;" src="..\svg\H2YMkYALWo.svg"> of elements, we'll grow a decision tree as follows:

- If all the elements belong to a class <!-- $c$ --> <img style="transform: translateY(0.1em); background: white;" src="..\svg\oZXhMl9m2f.svg"> or if <!-- $E$ --> <img style="transform: translateY(0.1em); background: white;" src="..\svg\d9AAroc8Q6.svg"> is small, generate a leaf node with label <!-- $c$ --> <img style="transform: translateY(0.1em); background: white;" src="..\svg\uWBP8sq0bT.svg">
- Otherwise, we choose a test based on a single attribute which may have <!-- $N$ --> <img style="transform: translateY(0.1em); background: white;" src="..\svg\N0qBDmxx3K.svg"> (at least two) outcomes, and will become the root of <!-- $N$ --> <img style="transform: translateY(0.1em); background: white;" src="..\svg\YY4NjuZU4N.svg"> branches

There are many problems to solve: which attribute should we test, which kind of test, what does _<!-- $E$ --> <img style="transform: translateY(0.1em); background: white;" src="..\svg\uCBPdyKTny.svg"> is small_ mean?

So, given a census dataset, we may ask ourselves: _can we learn the wealth attribute just by looking at the other ones?_

![Census dataset](./res/census.png)

Let's first perform an **exploratory analysis**, i.e. looking at the data, maybe generating histograms...

We could generate a k-dimensional contingency table, through SQL or whatever. Contingency tables could give us an insight on correlations between attributes, but we could need lots of them! _A shit fucking ton of 'em!_

So, how can we evaluate if a pattern is interesting? To do so, there are several methods. One of them is based on _information theory_, born thanks to the concept of entropy.

To introduce this concept of entropy, an example is needed. Given a variable with 4 possible values and a given probability distribution, an observation of the data stream could return BAACBADCDA. If I want to transmit to a remote agent those readings, I can encode them for instance with two bits, (00,01,10,11). Therefore, the transmission will be 01000010010011101100... But what happens if I the probability distribution is uneven?

<!-- $P(A)=0.5, P(B)=0.25, P(C)=0.125, P(D)=0.125$ --> <img style="transform: translateY(0.1em); background: white;" src="..\svg\A8pKvWrc1V.svg">

Of course, the already said coding works, but we could do better: there's a coding requiring a smaller average of bits per symbol:

<!-- $A=0, B=10, C=110, D=111$ --> <img style="transform: translateY(0.1em); background: white;" src="..\svg\KcCve9wlRJ.svg">

Even with 3 symbols with equal probability, this technique could save bits!

In the general case, given a source <!-- $X$ --> <img style="transform: translateY(0.1em); background: white;" src="..\svg\vGfeOP0wvU.svg"> with <!-- $V$ --> <img style="transform: translateY(0.1em); background: white;" src="..\svg\5aS2RWM4jv.svg"> possible values, with their probability distribution, the best coding allows the transmission with an average number of bits given by <!-- $H(X)=-\sum_j p_j log_2(p_j)$ --> <img style="transform: translateY(0.1em); background: white;" src="..\svg\FDgWzgvqjp.svg">. <!-- $H(X)$ --> <img style="transform: translateY(0.1em); background: white;" src="..\svg\TKPDTIzSJ4.svg"> is the entropy of the information source <!-- $X$ --> <img style="transform: translateY(0.1em); background: white;" src="..\svg\5Pto2xUaFs.svg">.

### Meaning of entropy of an information source

High entropy means that the probabilities are mostly similar. Low entropy means that some symbols have much higher probability. Higher number of allowed symbols gives higher entropy.

In a binary source, the entropy goes to 0 when one of the probabilities goes to 1 and the other to 0.

So, what is the purpose of these considerations on entropy? Let's consider a toy example, where in the <!-- $X$ --> <img style="transform: translateY(0.1em); background: white;" src="..\svg\lqwoB64hLB.svg"> column is the graduation of a friend, and the <!-- $Y$ --> <img style="transform: translateY(0.1em); background: white;" src="..\svg\1tJvmTBXW2.svg"> column contains whether the person likes _Joker_ or not. We can derive the probabilities from value frequencies.

![Joker table](./res/joker.png)

Now, let's consider the entropy of Y considering only the rows in which <!-- $X=v$ --> <img style="transform: translateY(0.1em); background: white;" src="..\svg\uTgfqOZFXm.svg">. When we filter by Math, the entropy stays 1, but when we filter by History, the entropy goes to 0.

This could also be interpreted as the minimum number of bits needed to transmit the value if the receiver know <!-- $X$ --> <img style="transform: translateY(0.1em); background: white;" src="..\svg\V2mZ0D3G2n.svg">. So, the conditional specific entropy is:

![Entropy](res/entropy.png)

<!-- $H(Y|X)=0.5$ --> <img style="transform: translateY(0.1em); background: white;" src="..\svg\FJyodZpsST.svg">, therefore, <!-- $X$ --> <img style="transform: translateY(0.1em); background: white;" src="..\svg\YIRiyDY3DF.svg"> provided some insight on <!-- $Y$ --> <img style="transform: translateY(0.1em); background: white;" src="..\svg\5g1bZagyLe.svg">.

Now, how can we decide if a person likes _Joker_ or not?

### Information Gain

Now we can formally define the **Information Gain**, which states the amount of insight that <!-- $X$ --> <img style="transform: translateY(0.1em); background: white;" src="..\svg\GuJ4SU7ZfE.svg"> provides in the forecasting of $Y$.

<!-- $I G(Y \mid X)=H(Y)-H(Y \mid X)$ --> <img style="transform: translateY(0.1em); background: white;" src="..\svg\g54zLqf0Mk.svg">

So, **how can we use** the information gain? It could help us predict the probability of long life given some historical data on person characteristics and life style. _Higher IG means that a 2D contingency table would be more interesting._

Getting back to the decision tree, **how can we decide which attribute to test?** Now the answer is obvious: we should choose the one with the maximum information gain for the class in the dataset! Having decided this, we'll now have a number of subtrees to generate.

Deciding the attribute giving the highest IQ couldn't always be the right choice. But we'll get to this later.

So in the end, the algorithm looks like this:

![Decision tree algorithm](./res/decision-tree-algo.png)

We'll execute the generated decision tree on the training set itself, count the number of discordances, thus obtain the **training set error**. Obviously, when trying to use the tree with the test set, the error rises.

Is there any general lesson we can learn from this fact? With a smaller tree we increase the training error, but we decrease the test error. Bigger trees are more prone to overfitting.

## Overfitting

In real life, there's noise in data. The ability to predict classes is indeed not perfect, and we'll sometimes make wrong predictions. **Overfitting** happens when the learning is affected by noise.

Stating this in a formal way, while a decision tree is a hypothesis of the relationship between the predictor attributes and the class. If <!-- $h$ --> <img style="transform: translateY(0.1em); background: white;" src="..\svg\nNFDPkGSPX.svg"> is the hypotesis, we can define the error of the hypothesis on the training set <!-- $error_{train}(h)$ --> <img style="transform: translateY(0.1em); background: white;" src="..\svg\ajz69ttEUQ.svg">, and the error of the hypothesis on the entire dataset <!-- $error_{\epsilon} (h)$ --> <img style="transform: translateY(0.1em); background: white;" src="..\svg\efJqeEEhMP.svg">. $h$ overfits the training set if there is an alternative hypothesis <!-- $h'$ --> <img style="transform: translateY(0.1em); background: white;" src="..\svg\gG1lhfHfnm.svg"> such that

<!-- $error_{train}(h)<error_{train} (h')$ --> <img style="transform: translateY(0.1em); background: white;" src="..\svg\F75VQwjfwy.svg">

<!-- $error_{\epsilon} (h) > error_{\epsilon}(h')$ --> <img style="transform: translateY(0.1em); background: white;" src="..\svg\UEtIj5x3id.svg">

Overfitting is caused by two phenomenons, the **presence of noise** and the **lack of representative instances**.

**Everything should be made as simple as possible, but not simpler.**

**Pruning** a decision tree is a way to simplify it.

Pre-pruning means early stopping the tree while it is growing, post-pruning is a pruning done after the tree is finished.

The **validation set** is a third dataset, which we can use after the pruning. In this way, my set will be more reliable: I'm using fresh data.

There are many ways to prune data, one of these is the **statistical pruning**: it uses statistics to infer if a new node I'm generating is prone to being affected by noise.

The **minimum description length principle** states that when the complication is bigger than the reduction of errors we are basically wasting our time.

![Pruning effects on classification](res/pruning.png)

The supervised data are then split in 3 parts:

- **Training set**, to build the model;
- **Validation set**, to tune the model and minimize the error;
- **Test set**, to assess the final error.

### Minimum Description Length

This is another _way of thinking_. We know that the learning process produces a theory on a set of data, which can be then used to predict the class on a set of data. So, how can we describe this theory? We could encode the theory, and the errors underneath. So, the length of the theory is the sum of the length of the tree + the length of the errors. So, the **Minimum Description Length Principle** states that we should choose the theory with the **shorter description**: a bigger theory includes bigger errors. In the extreme cases, we may have a very simple theory with lots of exceptions, and a very complex theory with a few exceptions.

A decision tree is not **extremely powerful**: it's a compromise, it works and it's not too computationally heavy. We should choose a single attribute to train it, otherwise it might get too complicated.

### Characteristics of a decision tree

It is a **non-parametric approach** to build classification models. Finding the best one is **NP complete**, while the heuristic algorithms allow to find sub-optimal solutions in reasonable time. The run time use of a DT to classify new instances is extremely efficient: <!-- $\mathcal{O}(h)$ --> <img style="transform: translateY(0.1em); background: white;" src="..\svg\mfVj3Ehsib.svg">, where $h$ is the height of the tree.

### Choosing the attribute to split the dataset

We're looking for the split generating the maximum **purity**. We can use some functions, like **Information Gain**, **Gini Index**, **Misclassification Error**, the latter being the worse one.

Of course there are several variants for building these trees, we can use different strategies for the construction, the pruning...

# Evaluation of a classifier

**Model selection** is essential to the good design of a classifier: when I have hyperparameters to tune, I need to select several alternatives. But in practice, when we say model selection we go to a _higher level_, because we can select between different learning algorithms too. We could also go further: before feeding the data, we can transform them!

We need **measures** to compare different algorithms, strategies, etc... and choose the best one!

Empirically, the more training data we have the best we train the dataset.

We can define a **confidence interval**, a concept that derives from the Bernoulli process, i.e. forecasting each element of the test set is like one experiment of a Bernoulli process, a binary success/failure. 

Therefore, the empirical frequency of error is <!-- $f=S/N$ --> <img style="transform: translateY(0.1em); background: white;" src="..\svg\8W5exKNEIO.svg">.

With some algebra we can compute the **Wilson Score Interval**, which is the abscissa delimiting the area <!-- $1-\alpha$ --> <img style="transform: translateY(0.1em); background: white;" src="..\svg\PQbdnkRiXx.svg"> for a normal distribution. The formula doesn't have to be remembered.

So, <!-- $\alpha$ --> <img style="transform: translateY(0.1em); background: white;" src="..\svg\zXYOTOLcOU.svg"> is the probability of a wrong estimate. Increasing <!-- $N$ --> <img style="transform: translateY(0.1em); background: white;" src="..\svg\G8XCDaUNIE.svg">, with constant empirical frequency, the uncertainty for <!-- $p$ --> <img style="transform: translateY(0.1em); background: white;" src="..\svg\DZH3zaHot8.svg"> narrows. 

## Accuracy of a classifier

Accuracy and error frequency are complements (<!-- $A=1-e$ --> <img style="transform: translateY(0.1em); background: white;" src="..\svg\ELU1BlSLRO.svg">). Error frequency is the sum of errors of any class, divided by the number of tested records. A good statistic could be the maximum error frequencies instead. 

So, why should we use other statistics? Maybe, estimating the cost of errors might need more statistics.

Every ML algorithm has hyperparameters to tune, and several training loops are usually needed to find the best set of hyperparameters.

It is crucial to obtain a higly reliable estimate of runtime performance. Sometime it is necessary to find the best compromise between the optimisation step and the quality of the result. 

The train/validation loop is usually faster than cross validation. 

## Performance measures of a classifier

We already know what the accuracy is. For the moment, let's consider **binary predictions**. There are other possible indicators, like velocity, robustness, scalability, interpreatability. A classification error could have different consequences, which could be dangerous!

Another important measure is the  **f-measure**, i.e. the harmonic mean of precision and recall, aka F1 score or balanced F1 score: <!-- $F=2\frac{precision\cdot recall}{precision+recall}$ --> <img style="transform: translateY(0.1em); background: white;" src="..\svg\ryNsIqwmy6.svg">.

### Beyond the accuracy

When we evaluate the quality of a classifier, we should also take into account the *a-priori* information, i.e. the distribution of our supervised data. If the classes are perfectly balanced, we'll be correctly guessing the accuracy, but by chance. If, instead, our dataset is heavily unbalanced, like in the case of a disease with 2% of positivity.

So, when we evaluate a prediction, instead of just using accuracy, we should use a metric that considers the distribution. 

So, considering a confusion matrix with 3 classes, we have accuracy <!-- $\frac{\sum TP_i}{N}$ --> <img style="transform: translateY(0.1em); background: white;" src="..\svg\Tv9I7k6rYh.svg">, precision <!-- $\frac{TP_i}{P_i}$ --> <img style="transform: translateY(0.1em); background: white;" src="..\svg\0hJRLoeUQ2.svg"> and recall <!-- $\frac{TP_i}{T_i}$ --> <img style="transform: translateY(0.1em); background: white;" src="..\svg\bTtpQ6SNCg.svg">. There will obviously be a number of false predictions. So, let's say that the classifier <!-- $\overline{C}$ --> <img style="transform: translateY(0.1em); background: white;" src="..\svg\uGZ9CkhoQK.svg"> generates this confusion matrix. Then, we have 200 predictions, in 100:6:40 proportion, of which 140 are correct. 
If we had a random classifier <!-- $R_{\overline{C}}$ --> <img style="transform: translateY(0.1em); background: white;" src="..\svg\12zyQ3Y7Mm.svg"> which generates the same proportion, but randomly, 82 predictions are exact **by chance**. The improvement of <!-- $\overline{C}$ --> <img style="transform: translateY(0.1em); background: white;" src="..\svg\2Y3pkIZbtm.svg"> over <!-- $R_{\overline{C}}$ --> <img style="transform: translateY(0.1em); background: white;" src="..\svg\PFX7KzJQ80.svg"> is 58. We now can define <!-- $k(\overline{C})=58/118=0.492$ --> <img style="transform: translateY(0.1em); background: white;" src="..\svg\j3iCYXcnO7.svg"> as the **improvement** of the classifier wrt the improvement of the perfect classifier.

This statistic evaluates the concordance between two classifications. 

<!-- $k$ --> <img style="transform: translateY(0.1em); background: white;" src="..\svg\87UIYoCPgL.svg"> is therefore the ratio between the concordance exceeding the random component and the maximum surplus possible. -1 means a total disagreement, 0 a random agreement, 1 total agreement.

### Cost of errors

Our decisions are driven by predictions, and bad predictions imply a **cost**.

The easy solution is computing the weighted cost of errors, i.e. errors which have an higher cost should be avoided more. We can even alter the dataset by duplicating the examples for which the classification error is higher, in this way the classifier will become more able to classify the classes for which the error cost is higher.

## Evaluation of a probabilistic classifier

So, up to now we were considering a **sharp** classifier (crisp prediction), giving an exact answer. What if we were working with a probabilistic classifier?

If we need an instant decision, a crisp classifier is good, but if the classification is part of a bigger process involving several evaluations, a probabilistic output could be more accurate.

### Lift chart

This is used to evaluate various scenarios, depending on the application. Let's consider a dataset with 1k positives and apply a probabilistic classification scheme. We want to make a bidimensional chart with two axis, shere <img src="svgs/332cc365a4987aacce0ead01b8bdcc0b.svg?invert_in_darkmode" align=middle width=9.39498779999999pt height=14.15524440000002pt/> is the sample size, and <img src="svgs/deceeaf6940a8c7a5a02373728002b0f.svg?invert_in_darkmode" align=middle width=8.649225749999989pt height=14.15524440000002pt/> the positive samples. 

Now, a straight line plots the number of positives obtained with a random choice of a sample of test data, while the curve plots the number of positives obtained drawing a fraction of test data with decreasing probability. So, with the *sorting* I generated with my classifier, if I take the first 10% of my dataset we're able to get 400 positives. To reach another 400, we need to get to 40%. 

So, this line is the number of positives I get with my probability classifier. The larger the area between the two curves, the best the classification model.

### ROC curve

The ROC curve describes a tradeoff between the hit rate and false alarm in a noisy channel. The noise can alter the recognition of the transmission, and alters the two levels according to a gaussian.

With less noise the two gaussian are better separated. 

Moving the threshold, we change the ration between false positives and false positives. A good classifier gives us an increase in TP with a small increase in FP.

Threshold steps allow to track the ROC curve: we sort the test elements by decreasing positive probability, set the threshold to the highest probability, then move.

Decreasing the threshold increases the recall.

# Transforming a binary classifier into multiclass

Why this? We have seen that DT are able to classificate non-binary target and binary, but other classifiers cannot. How can we adapt a binary classifier to a non binary problem?

They are One vs One, and One vs All.

So, the idea is to use a set of binary classifiers and combine the results.

## One vs One

We have 3 or 4 classes, <img src="svgs/e2422452ef7d65e15f62276f42bcf94c.svg?invert_in_darkmode" align=middle width=53.33136764999998pt height=22.831056599999986pt/>, we generate a binary classifier for each pair of classes: <img src="svgs/d3c5844a77cb38963445bf7ccd567f82.svg?invert_in_darkmode" align=middle width=193.78449915pt height=24.65753399999998pt/> 

Of course, each binary problem will be trained with the 2 classes. Then, at prediction time, we will use all the classifiers: for the right classifier, it will be right (there are 3 classifiers with the class), the others will have a random example. So, we count the maximum class, and that will be it. 

## One vs Rest/One vs All

We now consider <img src="svgs/9b325b9e31e85137d1de765f43c0f8bc.svg?invert_in_darkmode" align=middle width=12.92464304999999pt height=22.465723500000017pt/> binary problem, where class <img src="svgs/3e18a4a28fdee1744e5e3f79d13b9ff6.svg?invert_in_darkmode" align=middle width=7.113876000000004pt height=14.155350000000013pt/> is a positive example, and all the others are negatives. We'll have <img src="svgs/9b325b9e31e85137d1de765f43c0f8bc.svg?invert_in_darkmode" align=middle width=12.92464304999999pt height=22.465723500000017pt/> classifiers, producing a *confidence score*, then choose the one with the maximum confidence. 

So, OVO requires a higher number of problems, while OVA tends to be intrinsically unbalanced.

## Ensemble methods

We now consider methods related to this. We start training a set of **base classifiers** instead of a single one. Then, we obtain a final prediction taking the votes of the base classifiers. This works better than a single classifier. 

Why is that? Let's consider 25 binary classifiers, each of them having an error rate <img src="svgs/568337fef6bd2e9f956188bc13ffc6a6.svg?invert_in_darkmode" align=middle width=58.79562149999999pt height=21.18721440000001pt/>.

If we put them together, the error becomes: <img src="svgs/14bf11a81fa489ba0254ca4997ccdcbf.svg?invert_in_darkmode" align=middle width=332.27141969999997pt height=47.6716218pt/> 

Of course, if we are using 25 times the same classifier, which is a deterministic machine, this reasoning doesn't work. But if they are different and independent, this makes it better!

So, the ensemble will be wrong only if the majority is wrong, i.e. it will probably be statistically right!

### Rationale for ensemble methods

We can obtain good results only if the base classifiers are independent, and the performance of the base classifier is **better than a random choice**.

So, how can we make them independent? We can, for example, train them on different datasets (i.e. partition the dataset). There are other methods too: **bagging** (repeatedly sampling with replacement according to a uniform probability distribution), **boosting** (iteratively change the distribution of training examples so that the base classifier focuses on examples which are hard to classify), **Adaboost** (the importance of each base classifier depends on its error rate).

Another possibility, instead of working **horizontally**, is working **vertically**: we partition the columns!

What should we consider? The correlation with the goal, the independency/correlation between columns...

**Random Forest** is a variant of DT which works on these principles.

There's another possibility, **manipulating class labels**, which we do when we have many class labels: this usually makes the classifier bad. So, we randomly partition the classes into two sets, and relabel the dataset. Then, we train binary classifiers as a *tree*, like a binary search. 

![General scheme for ensemble methods](./res/ensemble.png)

# Naive Bayes Classifier

We can classify with methods different from a decision tree.

We'll start with the **statistical modeling**, which is strictly related to the Bayes' theorem.

We now consider the contribution of all the attributes of the dataset, assuming that each one of them if independent from others, given the class. So, the probability can be rewritten as a **joint probability**.

We'll use the empirical frequency as probability.

Considering a toy example, with temperature, outlook, humidity, wind, we have a target **are we going to play or not?**

So, the task is, given the features, are we going to play? We'll deal with this as a statistical problem, considering the features as **equally important** (they're independent evidence). We then obtain the likelihood of yes and no, then normalize to 1, getting <img src="svgs/8237fe839881ccf9479b09e460cc33ae.svg?invert_in_darkmode" align=middle width=122.34413894999997pt height=24.65753399999998pt/> and <img src="svgs/457415f8ba4f91e8148370c4eb28a624.svg?invert_in_darkmode" align=middle width=116.17024319999999pt height=24.65753399999998pt/>.

So, in principle, things are not complicated. How can I train this classifier? I need to scan my dataset and compute those frequencies. 

This works thanks to the Bayes' theorem <img src="svgs/cd477e562da2bc8c4dd60fe272a5434e.svg?invert_in_darkmode" align=middle width=184.29981239999998pt height=33.20539859999999pt/>, and the hypothesis is the class, say <img src="svgs/3e18a4a28fdee1744e5e3f79d13b9ff6.svg?invert_in_darkmode" align=middle width=7.113876000000004pt height=14.155350000000013pt/>, the evidence is the tuple of values to be classified. We can then split the evidence into pieces, one per attribute, and if the attributes are independent: <img src="svgs/ed00e7ca9989a05d3dfa5360419f5749.svg?invert_in_darkmode" align=middle width=359.78014049999996pt height=33.20539859999999pt/>.

## The Naive Bayes method

We can compute the probabilities for the classes, then choose the one having the maximum likelihood. It is **naive** cause the assumption of independence is quite simplicistic. 

The problem is that we can overcast to a 0 probability of No, which kills our formula by setting everything to 0.

Therefore, we can apply a smoothing technique, the **Laplace smoothing**, which uses a parameter <img src="svgs/c745b9b57c145ec5577b82542b2df546.svg?invert_in_darkmode" align=middle width=10.57650494999999pt height=14.15524440000002pt/> (typically <img src="svgs/034d0a6be0424bffe9a6e7ac9236c0f5.svg?invert_in_darkmode" align=middle width=8.219277000000005pt height=21.18732pt/>) let's say we have an absolute frequency of <img src="svgs/9f7365802167fff585175c1750674d42.svg?invert_in_darkmode" align=middle width=12.61896569999999pt height=14.15524440000002pt/> in attribute <img src="svgs/2103f85b8b1477f430fc407cad462224.svg?invert_in_darkmode" align=middle width=8.556075000000003pt height=22.831379999999992pt/> over class <img src="svgs/3e18a4a28fdee1744e5e3f79d13b9ff6.svg?invert_in_darkmode" align=middle width=7.113876000000004pt height=14.155350000000013pt/>, then <img src="svgs/a9a3a4a202d80326bda413b5562d5cd1.svg?invert_in_darkmode" align=middle width=13.242075000000003pt height=22.46574pt/> the number of distinct values, and the absolute frequency <img src="svgs/474a7c18247a3878e09311ac1a57cc03.svg?invert_in_darkmode" align=middle width=22.61179304999999pt height=22.831056599999986pt/> of class <img src="svgs/3e18a4a28fdee1744e5e3f79d13b9ff6.svg?invert_in_darkmode" align=middle width=7.113876000000004pt height=14.155350000000013pt/> in the dataset. The smoothed frequency is: <img src="svgs/4bfac7769e0cb59235d6880b937c9b0b.svg?invert_in_darkmode" align=middle width=146.7369585pt height=34.95557999999999pt/>

When <img src="svgs/1924b0e737a1c5c085f6e7f1b0fa4840.svg?invert_in_darkmode" align=middle width=40.713337499999994pt height=21.18721440000001pt/>, the formula is unsmoothed, but higher values of <img src="svgs/c745b9b57c145ec5577b82542b2df546.svg?invert_in_darkmode" align=middle width=10.57650494999999pt height=14.15524440000002pt/> give more importance to the prior probabilities for the values of <img src="svgs/2103f85b8b1477f430fc407cad462224.svg?invert_in_darkmode" align=middle width=8.556075000000003pt height=22.831379999999992pt/>. This means that this frequency will be smaller if we have a higher number of values. The <img src="svgs/a9a3a4a202d80326bda413b5562d5cd1.svg?invert_in_darkmode" align=middle width=13.242075000000003pt height=22.46574pt/> component is basically the prior probability. So, <img src="svgs/c745b9b57c145ec5577b82542b2df546.svg?invert_in_darkmode" align=middle width=10.57650494999999pt height=14.15524440000002pt/> allows us to mix the prior probability with the current value. Smoothing is necessary when some frequencies are zero, and it reduces overfitting.

So, the components of this classifier are **independence** and **smoothing**.

If there's missing values, we may have another problem. In decision trees, we either remove the column or the row (or try to guess). 

With the Naive Bayes Classifier, **they do not affect the model!** We simply don't include the record in the frequency count: it's not a big deal.

So, here we have seen how we can count for categorical attributes. What happens if we have numerical attributes? We do an additional assumption: the values have a **Gaussian distribution**.

Instead of fraction of counts, we can now compute the mean and the variance of the values of each numeric attribute per class.

For a given attribute and class, the distribution is supposed to be <img src="svgs/1567b5a4fdabae414e5ac827018eecaa.svg?invert_in_darkmode" align=middle width=148.95874289999998pt height=43.66282139999998pt/>

The probability of a value assuming **exactly** a single real value is zero. A value of the density function is the probability that the variable lies in a small interval around that value. The value we use are of course rounded at some precision factor, i.e. the same for all classes. Null values don't break the algorithm. 

So, what can we say about this classifier? First of all, the semantics is clear. In many cases, it works well (e.g. spam filters). It is obviously simplicistic. If there's no independence, we get a **dramatic degradation**. For example, if an attribute is the copy of another one, the result is squared.  

Another possible violation of the assumption refers to the distribution: if it is not Gaussian, we have problems.

# Linear classification with Perceptrons

This is also called **artificial neuron**: each input connection has a weight. In practice, it is a linear combination of weighted inputs.

It learns a hyperplane such that all the positives lay on one side, the negatives on the other.

The hyperplane is described as a set of weights <img src="svgs/39e4045199843ef756075817a5188988.svg?invert_in_darkmode" align=middle width=74.28397019999998pt height=14.15524440000002pt/> in a linear equation on the data attributes <img src="svgs/7fb477ffcc4ed26719221f90b9ae1789.svg?invert_in_darkmode" align=middle width=66.0552288pt height=14.15524440000002pt/>.

There are either **none** or **infinite** such hyperplanes:

<img src="svgs/e9d6c3f954bf258e847065880c1d42ab.svg?invert_in_darkmode" align=middle width=393.34797315000003pt height=47.6716218pt/> 

The following is a pseudocode algorithm:

![Perceptron algorithm](./res/perceptron_algo.png)

Each change of weights moves the hyperplane towards the misclassified instance: <img src="svgs/7e898f5524ebea623864829490b5455f.svg?invert_in_darkmode" align=middle width=385.083468pt height=24.65753399999998pt/>, and the result is increased by a positive amount which is the squared value of the components: <img src="svgs/ff95105af1a49e7a5b6d519ff5b89ee6.svg?invert_in_darkmode" align=middle width=93.14522249999999pt height=26.76175259999998pt/>, therefore the result will be less negative or even positive.

The corrections are incremental and can interfere with previous updates, the algorithm converges if the dataset is linearly separable: this method is not so powerful 😔.

# Support Vector Machines

What can we do if data are not **linearly separable**?

We could give up the linearity, like: <img src="svgs/16ae882da71b87b4235738505ecdc768.svg?invert_in_darkmode" align=middle width=319.34492205pt height=26.76175259999998pt/> .

This method would become soon intractable for any reasonable number of variables, and **extremely prone** to overfitting (having thousands of coefficients...). 

So, we must find different ways!

We now consider using optimization instead of greedy search.

So, let's consider a maximum margin hyperplane:

![Maximum margin hyperplane](./res/maximum_margin.png)

We could now track some separations on the plane, and may ask which is the best one.![MArgin calculation](./res/margin.png)

We need the definition of **margin**: drawing parallel lines, we find the nearest example from the linear separation.

Finding the support vectors and the maximum margin hyperplane belongs to the well known class of constrained quadratic optimization problems:

<img src="svgs/53733bd5bde01f18cd01dfa19a9ed781.svg?invert_in_darkmode" align=middle width=359.44368239999994pt height=65.81767500000002pt/>

where the class of example <img src="svgs/77a3b857d53fb44e33b53e4c8b68351a.svg?invert_in_darkmode" align=middle width=5.663225699999989pt height=21.68300969999999pt/> is either <img src="svgs/e11a8cfcf953c683196d7a48677b2277.svg?invert_in_darkmode" align=middle width=21.00464354999999pt height=21.18721440000001pt/> or <img src="svgs/034d0a6be0424bffe9a6e7ac9236c0f5.svg?invert_in_darkmode" align=middle width=8.219277000000005pt height=21.18732pt/> and <img src="svgs/fb97d38bcc19230b0acd442e17db879c.svg?invert_in_darkmode" align=middle width=17.73973739999999pt height=22.465723500000017pt/> is the margin.

So, this is the first contribution: among the infinite hyperplanes, we want to find the one with the maximum margin. If a separating hyperplane does not exist, we want to find one which almost separates the classes, and disregard examples generating a very narrow margin. 

The soft margin ensures a greater robustness to individual observation, and a better classification of most of the training observation. It is obtained by adding a constraint (penalty term, the sum of all the points on the wrong side) to the optimization problem expressed by a parameter <img src="svgs/9b325b9e31e85137d1de765f43c0f8bc.svg?invert_in_darkmode" align=middle width=12.92464304999999pt height=22.465723500000017pt/>.

So, we have seen how to deal with non-linear separability, but there's another possibility: we can have datasets which are non linearly-separable because of something more than a few exceptions, like:

![Screenshot 2020-10-23 at 17.32.30](res/nonlineards.png)

 

There is no linear hyperplane that separates these. We can then perform a linear transformation, to a higher dimension space with the third dimension being <img src="svgs/1749ec7316ee7ac73b892273f7338fc3.svg?invert_in_darkmode" align=middle width=62.12324414999999pt height=26.76175259999998pt/>. It happens that if we project in the 3D space those points, now we have linear separability. We call the original space **input space**, and the new one **feature space**. 

This idea is called a **kernel trick**: for mathematical reasons, it happens that this computation, seemingly difficult, is feasible with an affordable computational complexity. Separating the hyperplane requires a series of **dot products**. If we define the mapping on the basis of a particular family of functions, called **kernel functions**, the mapping doesn't need to be explicitly computed, and the computation is done in the input space. 

What has to remembered for the exam is that there's different kernel functions available.

The time complexity is mainly influenced by the efficiency of the optimization library (like *libSVM*), which scales from <img src="svgs/04512f6f2faaab87f50584ec70eeff54.svg?invert_in_darkmode" align=middle width=78.29449979999998pt height=26.76175259999998pt/> and <img src="svgs/fb213e6764b771627b3d91ce7ca026f2.svg?invert_in_darkmode" align=middle width=78.29449979999998pt height=26.76175259999998pt/>; in case of sparse data, it is reduced. 

So, learning is generally slower than simpler methods, tuning is necessary (and not so easy), but the results can be very accurate. It is explicitly based on a strong mathematical model, it is not affected by local minima (optimizers can be very effective) and it does not suffer from the curse of dimensionality, since it doesn't use any notion of distance. 

## K Nearest Neighbour classifier

This classifier **keeps all the training data**, i.e. the model is the entire training set.

The idea is that new predictions can be computed simply computing the similarities between the new data and the dataset. Then, it picks the K closest entries among the training set data. The main parameters are the number of neighbours to track, and the metric used to compute the distance (like the Mahalanobis distance).

# Neural networks

These were inspired by the brain of animals, trying to reproduce neutrons, generating intelligence.

The idea is that if we put together several neurons, we can generate a decision boundary which is much more complicated.

Brains are actually much more complicated than this, but who gives a sh*t?

So, a **neuron** is a signal processor with a threshold: it receives inputs and it gives outputs. The inputs are not simply transmitted from a neuron to the other, but they are **weighted**. The weights are the *engine of the reasoning*, and they're adapted with learning.

We have processors and weights, and we must learn the weights, through examples. It's actually better to limit the connections.

This **multi-layer perceptron** has signals which are transmitted, and they're modeled as **real numbers**. The processing element is inspired to the biological system, when an input is higher than a threshold, something happens. We could linearly increase those, but there are better solutions, like using a **sigmoid** or an **arctan** or a **ReLU**.

The sigmoid is also called **squashing function**, mapping reals into <img src="svgs/f27d1a8ebacee1389ff26e63ae976661.svg?invert_in_darkmode" align=middle width=32.87674994999999pt height=24.65753399999998pt/>. 

Why are we using non-linearities? In linearities, noise is completely transmitted <img src="svgs/a9759fd3091d9449634c24dce3f24102.svg?invert_in_darkmode" align=middle width=196.98634395pt height=24.65753399999998pt/>, in particular if <img src="svgs/95d239357c7dfa2e8d1fd21ff6ed5c7b.svg?invert_in_darkmode" align=middle width=15.94753544999999pt height=14.15524440000002pt/> is generated by noise. In a non-linear system, in general, <img src="svgs/1acf81be9ab9909c48076ade663632b8.svg?invert_in_darkmode" align=middle width=196.98634395pt height=24.65753399999998pt/>, and the impact of the noise is reduced.

The idea is that inputs feed an **input layer**, which feeds a **hidden layer**, which feeds an **output layer**. The signal flows through the input, then the layers, then the output. For binary classification, we have one single output node, while for multi-class classification the simplest way is having one node per class (*one-hot encoding)*.

![Multi-layer NN](./res/multi-layer_net.png)

This is a **feed-forward multi-layer neural network**. Why is it *feed-forward*? Signal flows left-to-right in this schema. We're missing a feedback. 

We can add a unitary input <img src="svgs/824a0be2acf2b955fb812cf516864cf4.svg?invert_in_darkmode" align=middle width=14.206684799999989pt height=14.15524440000002pt/> to deal with the bias, as in the case of a linear perceptron. Therefore the dimensions are just 2. The number of nodes in the hidden layers is arbitrary, but a higher number is able to discover more complicated patterns. Note that <img src="svgs/a0377869f11bf54f0a0e8ac338ecea79.svg?invert_in_darkmode" align=middle width=25.782015599999987pt height=24.65753399999998pt/> is the non-linear transfer function, e.g. the sigmoid. 

When you increase the number of layers, you move towards **deep learning**, which needs more complex techniques. 

In the beginning, the network knows nothing, so we **randomly initialize** the weights. Then, we apply an example to the input nodes and obtain an output. Then, we compare the output with the desired one. Generally, they'll be different. 

So, while the termination conditions are not met, we feed the network with an example, compute the weight corrections (through *gradient descent*) for <img src="svgs/9c9d07018c7de5bbfdd05ec608b0f982.svg?invert_in_darkmode" align=middle width=87.14519879999999pt height=24.65753399999998pt/>, then backpropagate them. The weights will then encode the knowledge given by the supervised examples, but the encoding is not easily understandable. Note that **convergence is not guaranteed**: the decision function is not guaranteed to be convex.

So, what happens if there's a feature having values much higher than the other ones? This could be pretty bad. It is therefore useful to change the range of the attributes and standardize them, to have zero mean and unit variance.

We could stop when we reach a situation where new rounds do not improve our accuracy, or maybe a threshold on accuracy. Note that we may be overfitting. 

Therefore, we must decide **when to stop**: generally, we stop on timeouts, 100% accuracies, or performance not getting better.

Letting <img src="svgs/332cc365a4987aacce0ead01b8bdcc0b.svg?invert_in_darkmode" align=middle width=9.39498779999999pt height=14.15524440000002pt/> and <img src="svgs/deceeaf6940a8c7a5a02373728002b0f.svg?invert_in_darkmode" align=middle width=8.649225749999989pt height=14.15524440000002pt/> be the input vector and the desired output, <img src="svgs/31fae8b8b78ebe01cbfbe2fe53832624.svg?invert_in_darkmode" align=middle width=12.210846449999991pt height=14.15524440000002pt/> the weight vector of a node, the error is <img src="svgs/696c0622e34463bdf5e84f60e8948077.svg?invert_in_darkmode" align=middle width=231.63763424999996pt height=27.77565449999998pt/>.

![Error functions](res/error_fns.png)



The error function could be **convex or not**. 

### Gradient computation

To move towards a minimum of the error, we follow the gradient, composed of the partial derivatives of the error as a function of the weights. 

The weight is changed subtracting the partial derivative multiplied by a **learning rate**, which influences the convergence speed and can be adjusted as a tradeoff between speed and precision. The subtraction moves **towards smaller errors**. Generally, the learning rate is adaptively adjusted. 

Obviously, the derivatives of the input weights of the nodes of a layer can be computed only if the derivatives for the following layers are known.

We can then revise the algorithm:

![Revised training algorithm](res/revised_nn.png)

We cite two learning modes: **stochastic learning**, where each forward propagation is immediately followed by a weight update, which introduces some noise (transferred after each update) but reduces the chance of getting stuck in local minimums, and **batch learning**, where many propagation occur before updating the weights, accumulating errors over the samples within a batch, generally yielding faster and stable descent towards local minimums, since the update is performed in the direction of the average error.

We should regularize to reduce overfitting, basically correcting the loss function in order to smooth the fitting to the data, and the amount of regularization must be tuned.

# Preprocessing

## Similarity and dissimilarity

**Similarity** is a numerical measure of how alike two data objects are, while **dissimilarity** is the measure of how different they are.

**Proximity** is a synonim of both.

![Similarity and dissimilarity](./res/similarity.png)

The **euclidean distance** <img src="svgs/df462f35a4c10eaa472f883b791b0cd6.svg?invert_in_darkmode" align=middle width=186.00097395pt height=42.265142700000006pt/> tells us how near <img src="svgs/2ec6e630f199f589a2402fdf3e0289d5.svg?invert_in_darkmode" align=middle width=8.270567249999992pt height=14.15524440000002pt/> and <img src="svgs/d5c18a8ca1894fd3a7d25f242cbe8890.svg?invert_in_darkmode" align=middle width=7.928106449999989pt height=14.15524440000002pt/> are. <img src="svgs/4327ea69d9c5edcc8ddaf24f1d5b47e4.svg?invert_in_darkmode" align=middle width=17.73978854999999pt height=22.465723500000017pt/> distance is just a special case of the **Minkowski distance** <img src="svgs/7f23fe37507e96518435ba0c4ce4c679.svg?invert_in_darkmode" align=middle width=193.22476799999998pt height=49.10932949999999pt/>, which when <img src="svgs/f8cf106374ecdf7acfa0a8d1cce0612e.svg?invert_in_darkmode" align=middle width=38.009795999999994pt height=21.18721440000001pt/> is the euclidean norm, <img src="svgs/1d441f45efa7801396f8e8f3524942ae.svg?invert_in_darkmode" align=middle width=38.009795999999994pt height=21.18721440000001pt/> Manhatthan distance, <img src="svgs/0f036007f34817ada9bad69a53ab6658.svg?invert_in_darkmode" align=middle width=46.228988849999986pt height=14.15524440000002pt/> the Chebyshev distance, which only considers the maximum difference among coordinates.

Another, more sofisticated, distance which considers the data distribution is the **Mahalanobis distance**.

It increases if, keeping the same euclidean distance, the segment connecting the points is stretched along a direction of greater variation of data.

We need the **covariance matrix** of the dataset to calculate it, which is the summation of differences between the mean and the elements. 

Then, 

<img src="svgs/1a774c94ad093878fa27b7e7caaa7fad.svg?invert_in_darkmode" align=middle width=263.78767304999997pt height=52.81499189999999pt/>

A distance has some common properties: **positive definiteness**, **symmetry**, and **triangle inequality**.

Similarity has some properties too: <img src="svgs/823e90172079d40d4a75bd0defd86d13.svg?invert_in_darkmode" align=middle width=97.55051954999999pt height=24.65753399999998pt/> only if <img src="svgs/0e344c5123fb43fc335de6ff20e5c7de.svg?invert_in_darkmode" align=middle width=38.11630349999999pt height=14.15524440000002pt/> and <img src="svgs/d167691cf9e1c41fe0aa01bab0b83da2.svg?invert_in_darkmode" align=middle width=156.74499059999997pt height=24.65753399999998pt/>.

If we have binary spaces instead of vector spaces, it's more common to define similarity in another way:

![Binary similarity](./res/binary-similarity.png)

We can now define two coefficients, the **SMC** and the **Jaccard Coefficient**, the latter being the one ignoring zero values.

The **cosine similarity** is usually more interested for positive values, and it is a dot product divided by the product of the norms: <img src="svgs/1731a9377dc0aca17b8ce1217381d700.svg?invert_in_darkmode" align=middle width=122.34444254999998pt height=25.374350099999997pt/>.

The **extended Jaccard distance** is an evolution of the latter used for continuous or count attributes: <img src="svgs/5a308a444fcc9a8dcf32bf86ff6c86c7.svg?invert_in_darkmode" align=middle width=162.52254315pt height=25.374350099999997pt/>

It is crucial to choose the **right proximity measure**.

Finally, we consider the **correlation of quantitative data**: after the standardization of data, for two given attributes <img src="svgs/2ec6e630f199f589a2402fdf3e0289d5.svg?invert_in_darkmode" align=middle width=8.270567249999992pt height=14.15524440000002pt/> and <img src="svgs/d5c18a8ca1894fd3a7d25f242cbe8890.svg?invert_in_darkmode" align=middle width=7.928106449999989pt height=14.15524440000002pt/> is the dot product between <img src="svgs/4ae3393b40dfbbbc0932cf55cbc55bc3.svg?invert_in_darkmode" align=middle width=12.060528149999989pt height=24.7161288pt/> and <img src="svgs/7ab060f50dcd94fe27db68355e6d1529.svg?invert_in_darkmode" align=middle width=11.71804919999999pt height=24.7161288pt/>. A zero correlation states an absence of linear relationship between the variables. 

The **symmetric uncertainty** <img src="svgs/338ecd1a7fdc741e75d3b29d2d6e7b2e.svg?invert_in_darkmode" align=middle width=197.87401425pt height=33.20539859999999pt/> is a ratio (between 0 and 1) calculated using the entropies on <img src="svgs/2ec6e630f199f589a2402fdf3e0289d5.svg?invert_in_darkmode" align=middle width=8.270567249999992pt height=14.15524440000002pt/> and <img src="svgs/d5c18a8ca1894fd3a7d25f242cbe8890.svg?invert_in_darkmode" align=middle width=7.928106449999989pt height=14.15524440000002pt/>. It tells us how many values of <img src="svgs/2ec6e630f199f589a2402fdf3e0289d5.svg?invert_in_darkmode" align=middle width=8.270567249999992pt height=14.15524440000002pt/> are strictly related to the values of <img src="svgs/d5c18a8ca1894fd3a7d25f242cbe8890.svg?invert_in_darkmode" align=middle width=7.928106449999989pt height=14.15524440000002pt/>.






