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

A tree has inner nodes. We start from the root, with a test. For instance, we could test an attribute <img src="svgs/2103f85b8b1477f430fc407cad462224.svg?invert_in_darkmode" align=middle width=8.556075000000003pt height=22.831379999999992pt/> of an element <img src="svgs/8cd34385ed61aca950a6b06d09fb50ac.svg?invert_in_darkmode" align=middle width=7.6542015000000045pt height=14.155350000000013pt/>. If, for example, <img src="svgs/2bb55a46c94791a86fc71bcd3de61794.svg?invert_in_darkmode" align=middle width=46.906365pt height=21.18732pt/>, we'll execute the right node, if not we'll execute the left one. Than, the same thing happens with the inner node. When we come to an end, it will be a prediction, i.e. a **leaf node**. The thing is: we've gotta learn what decisions to put in the decision tree, and this is what the training aims to achieve.

Given a set <img src="svgs/698628683f7bc21c83461be0d468657d.svg?invert_in_darkmode" align=middle width=8.219211pt height=14.155350000000013pt/> of elements, we'll grow a decision tree as follows:

- If all the elements belong to a class <img src="svgs/3e18a4a28fdee1744e5e3f79d13b9ff6.svg?invert_in_darkmode" align=middle width=7.113876000000004pt height=14.155350000000013pt/> or if <img src="svgs/84df98c65d88c6adf15d4645ffa25e47.svg?invert_in_darkmode" align=middle width=13.082190000000004pt height=22.46574pt/> is small, generate a leaf node with label <img src="svgs/3e18a4a28fdee1744e5e3f79d13b9ff6.svg?invert_in_darkmode" align=middle width=7.113876000000004pt height=14.155350000000013pt/>
- Otherwise, we choose a test based on a single attribute which may have <img src="svgs/f9c4988898e7f532b9f826a75014ed3c.svg?invert_in_darkmode" align=middle width=14.999985000000004pt height=22.46574pt/> (at least two) outcomes, and will become the root of <img src="svgs/f9c4988898e7f532b9f826a75014ed3c.svg?invert_in_darkmode" align=middle width=14.999985000000004pt height=22.46574pt/> branches

There are many problems to solve: which attribute should we test, which kind of test, what does _<img src="svgs/84df98c65d88c6adf15d4645ffa25e47.svg?invert_in_darkmode" align=middle width=13.082190000000004pt height=22.46574pt/> is small_ mean?

So, given a census dataset, we may ask ourselves: _can we learn the wealth attribute just by looking at the other ones?_

![Census dataset](./res/census.png)

Let's first perform an **exploratory analysis**, i.e. looking at the data, maybe generating histograms...

We could generate a <img src="svgs/63bb9849783d01d91403bc9a5fea12a2.svg?invert_in_darkmode" align=middle width=9.075495000000004pt height=22.831379999999992pt/>-dimensional contingency table, through SQL or whatever. Contingency tables could give us an insight on correlations between attributes, but we could need lots of them! _A shit fucking ton of 'em!_

So, how can we evaluate if a pattern is interesting? To do so, there are several methods. One of them is based on _information theory_, born thanks to the concept of entropy.

To introduce this concept of entropy, an example is needed. Given a variable with 4 possible values and a given probability distribution, an observation of the data stream could return BAACBADCDA. If I want to transmit to a remote agent those readings, I can encode them for instance with two bits, (00,01,10,11). Therefore, the transmission will be 01000010010011101100... But what happens if I the probability distribution is uneven?

<img src="svgs/4acd9b39d099584593e157c83e5d6b40.svg?invert_in_darkmode" align=middle width=389.80540499999995pt height=24.65759999999998pt/>

Of course, the already said coding works, but we could do better: there's a coding requiring a smaller average of bits per symbol:

<img src="svgs/001164ba7c28d1eb9d1153b4c6c5d9c8.svg?invert_in_darkmode" align=middle width=236.17390499999996pt height=22.46574pt/>

Even with 3 symbols with equal probability, this technique could save bits!

In the general case, given a source <img src="svgs/cbfb1b2a33b28eab8a3e59464768e810.svg?invert_in_darkmode" align=middle width=14.908740000000003pt height=22.46574pt/> with <img src="svgs/a9a3a4a202d80326bda413b5562d5cd1.svg?invert_in_darkmode" align=middle width=13.242075000000003pt height=22.46574pt/> possible values, with their probability distribution, the best coding allows the transmission with an average number of bits given by <img src="svgs/42195e7b10f34bf2d2a19a20dc2dbeac.svg?invert_in_darkmode" align=middle width=178.745655pt height=24.65792999999999pt/>. <img src="svgs/d569400f8445654a0819b16a7ad56f9c.svg?invert_in_darkmode" align=middle width=42.69408pt height=24.65759999999998pt/> is the entropy of the information source <img src="svgs/cbfb1b2a33b28eab8a3e59464768e810.svg?invert_in_darkmode" align=middle width=14.908740000000003pt height=22.46574pt/>.

### Meaning of entropy of an information source

High entropy means that the probabilities are mostly similar. Low entropy means that some symbols have much higher probability. Higher number of allowed symbols gives higher entropy.

In a binary source, the entropy goes to 0 when one of the probabilities goes to 1 and the other to 0.

So, what is the purpose of these considerations on entropy? Let's consider a toy example, where in the <img src="svgs/cbfb1b2a33b28eab8a3e59464768e810.svg?invert_in_darkmode" align=middle width=14.908740000000003pt height=22.46574pt/> column is the graduation of a friend, and the <img src="svgs/91aac9730317276af725abd8cef04ca9.svg?invert_in_darkmode" align=middle width=13.196370000000005pt height=22.46574pt/> column contains whether the person likes _Joker_ or not. We can derive the probabilities from value frequencies.

![Joker table](./res/joker.png)

Now, let's consider the entropy of Y considering only the rows in which <img src="svgs/05323f2f22dc9fd14cdb9903ef8f086d.svg?invert_in_darkmode" align=middle width=45.38424pt height=22.46574pt/>. When we filter by Math, the entropy stays <img src="svgs/034d0a6be0424bffe9a6e7ac9236c0f5.svg?invert_in_darkmode" align=middle width=8.219277000000005pt height=21.18732pt/>, but when we filter by History, the entropy goes to <img src="svgs/29632a9bf827ce0200454dd32fc3be82.svg?invert_in_darkmode" align=middle width=8.219277000000005pt height=21.18732pt/>.

This could also be interpreted as the minimum number of bits needed to transmit the value if the receiver know <img src="svgs/cbfb1b2a33b28eab8a3e59464768e810.svg?invert_in_darkmode" align=middle width=14.908740000000003pt height=22.46574pt/>. So, the conditional specific entropy is:

![Entropy](res/entropy.png)

<img src="svgs/bda076524274763969532cb83bbd0a72.svg?invert_in_darkmode" align=middle width=103.378935pt height=24.65759999999998pt/>, therefore, <img src="svgs/cbfb1b2a33b28eab8a3e59464768e810.svg?invert_in_darkmode" align=middle width=14.908740000000003pt height=22.46574pt/> provided some insight on <img src="svgs/91aac9730317276af725abd8cef04ca9.svg?invert_in_darkmode" align=middle width=13.196370000000005pt height=22.46574pt/>.

Now, how can we decide if a person likes _Joker_ or not?

### Information Gain

Now we can formally define the **Information Gain**, which states the amount of insight that <img src="svgs/cbfb1b2a33b28eab8a3e59464768e810.svg?invert_in_darkmode" align=middle width=14.908740000000003pt height=22.46574pt/> provides in the forecasting of <img src="svgs/91aac9730317276af725abd8cef04ca9.svg?invert_in_darkmode" align=middle width=13.196370000000005pt height=22.46574pt/>.

<img src="svgs/c9811bfe0783d8077121773eec656cdd.svg?invert_in_darkmode" align=middle width=228.608655pt height=24.65759999999998pt/>

So, **how can we use** the information gain? It could help us predict the probability of long life given some historical data on person characteristics and life style. _Higher IG means that a 2D contingency table would be more interesting._

Getting back to the decision tree, **how can we decide which attribute to test?** Now the answer is obvious: we should choose the one with the maximum information gain for the class in the dataset! Having decided this, we'll now have a number of subtrees to generate.

Deciding the attribute giving the highest IQ couldn't always be the right choice. But we'll get to this later.

So in the end, the algorithm looks like this:

![Decision tree algorithm](./res/decision-tree-algo.png)

We'll execute the generated decision tree on the training set itself, count the number of discordances, thus obtain the **training set error**. Obviously, when trying to use the tree with the test set, the error rises.

Is there any general lesson we can learn from this fact? With a smaller tree we increase the training error, but we decrease the test error. Bigger trees are more prone to overfitting.

## Overfitting

In real life, there's noise in data. The ability to predict classes is indeed not perfect, and we'll sometimes make wrong predictions. **Overfitting** happens when the learning is affected by noise.

Stating this in a formal way, while a decision tree is a hypothesis of the relationship between the predictor attributes and the class. If <img src="svgs/2ad9d098b937e46f9f58968551adac57.svg?invert_in_darkmode" align=middle width=9.471165000000003pt height=22.831379999999992pt/> is the hypotesis, we can define the error of the hypothesis on the training set <img src="svgs/f5bb716113be65657443dbb93a77eb04.svg?invert_in_darkmode" align=middle width=93.19332pt height=24.65759999999998pt/>, and the error of the hypothesis on the entire dataset <img src="svgs/41bcab0d727085b60da5be9cac91ef85.svg?invert_in_darkmode" align=middle width=67.34178pt height=24.65759999999998pt/>. <img src="svgs/2ad9d098b937e46f9f58968551adac57.svg?invert_in_darkmode" align=middle width=9.471165000000003pt height=22.831379999999992pt/> overfits the training set if there is an alternative hypothesis <img src="svgs/375bd127b228e9401b2a8acaebe6eb67.svg?invert_in_darkmode" align=middle width=13.261215000000004pt height=24.716340000000006pt/> such that

<img src="svgs/70ee0a4a7ab5ba36813e99f0fa260b0c.svg?invert_in_darkmode" align=middle width=212.91550499999997pt height=24.716340000000006pt/>

<img src="svgs/4e99aab2122798e45732671cd954720a.svg?invert_in_darkmode" align=middle width=161.212755pt height=24.716340000000006pt/>

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

It is a **non-parametric approach** to build classification models. Finding the best one is **NP complete**, while the heuristic algorithms allow to find sub-optimal solutions in reasonable time. The run time use of a DT to classify new instances is extremely efficient: <img src="svgs/34109b622bca0e0d13a8a0d0cca985dd.svg?invert_in_darkmode" align=middle width=35.800050000000006pt height=24.65759999999998pt/>, where <img src="svgs/2ad9d098b937e46f9f58968551adac57.svg?invert_in_darkmode" align=middle width=9.471165000000003pt height=22.831379999999992pt/> is the height of the tree.

### Choosing the attribute to split the dataset

We're looking for the split generating the maximum **purity**. We can use some functions, like **Information Gain**, **Gini Index**, **Misclassification Error**, the latter being the worse one.

Of course there are several variants for building these trees, we can use different strategies for the construction, the pruning...

# Evaluation of a classifier

**Model selection** is essential to the good design of a classifier: when I have hyperparameters to tune, I need to select several alternatives. But in practice, when we say model selection we go to a _higher level_, because we can select between different learning algorithms too. We could also go further: before feeding the data, we can transform them!

We need **measures** to compare different algorithms, strategies, etc... and choose the best one!

Empirically, the more training data we have the best we train the dataset.

We can define a **confidence interval**, a concept that derives from the Bernoulli process, i.e. forecasting each element of the test set is like one experiment of a Bernoulli process, a binary success/failure. 

Therefore, the empirical frequency of error is <img src="svgs/deb9016a8ab58949c99e5b5553bbd61b.svg?invert_in_darkmode" align=middle width=64.15513664999999pt height=24.65753399999998pt/>.

With some algebra we can compute the **Wilson Score Interval**, which is the abscissa delimiting the area <img src="svgs/900d920909b4893be83c15f105c8ae1c.svg?invert_in_darkmode" align=middle width=38.88690464999999pt height=21.18721440000001pt/> for a normal distribution. The formula doesn't have to be remembered.

So, <img src="svgs/c745b9b57c145ec5577b82542b2df546.svg?invert_in_darkmode" align=middle width=10.57650494999999pt height=14.15524440000002pt/> is the probability of a wrong estimate. Increasing <img src="svgs/f9c4988898e7f532b9f826a75014ed3c.svg?invert_in_darkmode" align=middle width=14.999985000000004pt height=22.46574pt/>, with constant empirical frequency, the uncertainty for <img src="svgs/2ec6e630f199f589a2402fdf3e0289d5.svg?invert_in_darkmode" align=middle width=8.270567249999992pt height=14.15524440000002pt/> narrows. 

## Accuracy of a classifier

Accuracy and error frequency are complements (<img src="svgs/f5901e14df8c2452eaee8fb04a4397d4.svg?invert_in_darkmode" align=middle width=70.21096829999999pt height=22.465723500000017pt/>). Error frequency is thes um of errors of any class, divided by the number of tested records. A good statistic could be the maximum error frequencies instead. 

So, why should we use other statistics? Maybe, estimating the cost of errors might need more statistics.

Every ML algorithm has hyperparameters to tune, and several training loops are usually needed to find the best set of hyperparameters.

It is crucial to obtain a higly reliable estimate of runtime performance. Sometime it is necessary to find the best compromise between the optimisation step and the quality of the result. 

The train/validation loop is usually faster than cross validation. 

## Performance measures of a classifier

We already know what the accuracy is. For the moment, let's consider **binary predictions**. There are other possible indicators, like velocity, robustness, scalability, interpreatability. A classification error could have different consequences, which could be dangerous!

Another important measure is the  **f-measure**, i.e. the armonic mean of precision and recall, aka F1 score or balanced F1 score: <img src="svgs/a13bc6fd22ea240e322a0279e464a445.svg?invert_in_darkmode" align=middle width=144.66795419999997pt height=30.648287999999997pt/>.

### Beyond the accuracy

When we evaluate the quality of a classifier, we should also take into account the *a-priori* information, i.e. the distribution of our supervised data. If the classes are perfectly balanced, we'll be correctly guessing the accuracy, but by chance. If, instead, our dataset is heavily unbalanced, like in the case of a disease with <img src="svgs/45a0b00b513fa74f40b37aafadb94773.svg?invert_in_darkmode" align=middle width=21.91788224999999pt height=24.65753399999998pt/> of positivity.

So, when we evaluate a prediction, instead of just using accuracy, we should use a metric that considers the distribution. 

So, considering a confusion matrix with 3 classes, we have accuracy <img src="svgs/10e4f71da84fa363761b231c6947575b.svg?invert_in_darkmode" align=middle width=39.16826595pt height=33.20569890000001pt/>, precision <img src="svgs/fbe9e0ae50f65372e974136f27c55182.svg?invert_in_darkmode" align=middle width=23.110393349999995pt height=29.205422400000014pt/> and recall <img src="svgs/6ce695eef38de31dfa13aa16c8ae1633.svg?invert_in_darkmode" align=middle width=23.110393349999995pt height=29.205422400000014pt/>. There will obviously be a number of false predictions. So, let's say that the classifier <img src="svgs/ff8ed7ff7206dcbee8e3ce3546c04a31.svg?invert_in_darkmode" align=middle width=12.92464304999999pt height=27.725679300000007pt/> generates this confusion matrix. Then, we have 200 predictions, in 100:6:40 proportion, of which 140 are correct. 
If we had a random classifier <img src="svgs/c0965f62635cd7feb1d989d50a2a51c3.svg?invert_in_darkmode" align=middle width=23.53788524999999pt height=22.465723500000017pt/> which generates the same proportion, but randomly, 82 predictions are exact **by chance**. The improvement of <img src="svgs/ff8ed7ff7206dcbee8e3ce3546c04a31.svg?invert_in_darkmode" align=middle width=12.92464304999999pt height=27.725679300000007pt/> over <img src="svgs/c0965f62635cd7feb1d989d50a2a51c3.svg?invert_in_darkmode" align=middle width=23.53788524999999pt height=22.465723500000017pt/> is 58. We now can define <img src="svgs/1c871f58bd45412a72aaed4d21f6fd77.svg?invert_in_darkmode" align=middle width=165.37901324999999pt height=27.725679300000007pt/> as the **improvement** of the classifier.

This statistic evaluates the concordance between two classifications. 

<img src="svgs/63bb9849783d01d91403bc9a5fea12a2.svg?invert_in_darkmode" align=middle width=9.075495000000004pt height=22.831379999999992pt/> is therefore the ratio between the concordance exceeding the random component and the maximum surplus possible. <img src="svgs/e11a8cfcf953c683196d7a48677b2277.svg?invert_in_darkmode" align=middle width=21.00464354999999pt height=21.18721440000001pt/> means a total disagreement, <img src="svgs/29632a9bf827ce0200454dd32fc3be82.svg?invert_in_darkmode" align=middle width=8.219277000000005pt height=21.18732pt/> a random agreement, <img src="svgs/034d0a6be0424bffe9a6e7ac9236c0f5.svg?invert_in_darkmode" align=middle width=8.219277000000005pt height=21.18732pt/> total agreement.

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

Considering a toy example, with temperature, outlook, humidity, wind, we have a terget **are we going to play or not?**

So, the task is, given the features, are we going to play? We'll deal with this as a statistical problem, considering the features as **equally important** (they're independent evidence). We then obtain the likelihood of yes and no, then normalize to 1, getting <img src="svgs/8237fe839881ccf9479b09e460cc33ae.svg?invert_in_darkmode" align=middle width=122.34413894999997pt height=24.65753399999998pt/> and <img src="svgs/457415f8ba4f91e8148370c4eb28a624.svg?invert_in_darkmode" align=middle width=116.17024319999999pt height=24.65753399999998pt/>.

So, in principle, things are not complicated. How can I train this classifier? I need to scan my dataset and compute those frequencies. 

This works thanks to the Bayes' theorem <img src="svgs/cd477e562da2bc8c4dd60fe272a5434e.svg?invert_in_darkmode" align=middle width=184.29981239999998pt height=33.20539859999999pt/>, and the hypothesis is the class, say <img src="svgs/3e18a4a28fdee1744e5e3f79d13b9ff6.svg?invert_in_darkmode" align=middle width=7.113876000000004pt height=14.155350000000013pt/>, the evidence is the tuple of values to be classified. We can then split the evidence into pieces, one per attribute, and if the attributes are independent: <img src="svgs/ed00e7ca9989a05d3dfa5360419f5749.svg?invert_in_darkmode" align=middle width=359.78014049999996pt height=33.20539859999999pt/>.

## The Naive Bayes method

We can compute the probabilities for the classes, then choose the one having the maximum likelihood. It is **naive** cause the assumption of independence is quite simplicistic. 

The problem is that we can overcast to a 0 probability of No, which kills our formula by setting everything to 0.

Therefore, we can apply a smoothing technique, the **Laplace smoothing**, which uses a parameter <img src="svgs/c745b9b57c145ec5577b82542b2df546.svg?invert_in_darkmode" align=middle width=10.57650494999999pt height=14.15524440000002pt/> (typically <img src="svgs/034d0a6be0424bffe9a6e7ac9236c0f5.svg?invert_in_darkmode" align=middle width=8.219277000000005pt height=21.18732pt/>) let's say we have an absolute frequenci of <img src="svgs/9f7365802167fff585175c1750674d42.svg?invert_in_darkmode" align=middle width=12.61896569999999pt height=14.15524440000002pt/> in attribute <img src="svgs/2103f85b8b1477f430fc407cad462224.svg?invert_in_darkmode" align=middle width=8.556075000000003pt height=22.831379999999992pt/> over class <img src="svgs/3e18a4a28fdee1744e5e3f79d13b9ff6.svg?invert_in_darkmode" align=middle width=7.113876000000004pt height=14.155350000000013pt/>, then <img src="svgs/a9a3a4a202d80326bda413b5562d5cd1.svg?invert_in_darkmode" align=middle width=13.242075000000003pt height=22.46574pt/> the number of distinct values, and the absolute frequency <img src="svgs/474a7c18247a3878e09311ac1a57cc03.svg?invert_in_darkmode" align=middle width=22.61179304999999pt height=22.831056599999986pt/> of class <img src="svgs/3e18a4a28fdee1744e5e3f79d13b9ff6.svg?invert_in_darkmode" align=middle width=7.113876000000004pt height=14.155350000000013pt/> in the dataset. The smoothed frequency is: <img src="svgs/4bfac7769e0cb59235d6880b937c9b0b.svg?invert_in_darkmode" align=middle width=146.7369585pt height=34.95557999999999pt/>

When <img src="svgs/1924b0e737a1c5c085f6e7f1b0fa4840.svg?invert_in_darkmode" align=middle width=40.713337499999994pt height=21.18721440000001pt/>, the formula is unsmoothed, but higher values of <img src="svgs/c745b9b57c145ec5577b82542b2df546.svg?invert_in_darkmode" align=middle width=10.57650494999999pt height=14.15524440000002pt/> give more importance to the prior probabilities for the values of <img src="svgs/2103f85b8b1477f430fc407cad462224.svg?invert_in_darkmode" align=middle width=8.556075000000003pt height=22.831379999999992pt/>. This means that this frequency will be smaller if we have a higher number of values. The <img src="svgs/a9a3a4a202d80326bda413b5562d5cd1.svg?invert_in_darkmode" align=middle width=13.242075000000003pt height=22.46574pt/> component is basically the prior probability. So, <img src="svgs/c745b9b57c145ec5577b82542b2df546.svg?invert_in_darkmode" align=middle width=10.57650494999999pt height=14.15524440000002pt/> allows us to mix the prior probability with the current value. Smoothing is necessary when some frequencies are zero, and it reduces overfitting.

So, the components of this classifier are **independence** and **smoothing**.

If there's missing values, we may have another problem. In decision trees, we either remove the column or the row (or try to guess). 

With the Naive Bayes Classifier, **they do not affect the model!** We simply don't include the record in the frequency count: it's not a big deal.

So, here we have seen how we can count for categorical attributes. What happens if we have numerical attributes? We do an additional assumption: the values have a **Gaussian distribution**.

Instead of fraction of counts, we can now compute the mean and the variance of teh values of each numeric attribute per class.

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

Each change ofweights moves the hyperplane towards the misclassified instance: <img src="svgs/7e898f5524ebea623864829490b5455f.svg?invert_in_darkmode" align=middle width=385.083468pt height=24.65753399999998pt/>, and the result is increased by a positive amount which is the squared value of the components: <img src="svgs/ff95105af1a49e7a5b6d519ff5b89ee6.svg?invert_in_darkmode" align=middle width=93.14522249999999pt height=26.76175259999998pt/>, therefore the result will be less negative or even positive.

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

where the class of exampole <img src="svgs/77a3b857d53fb44e33b53e4c8b68351a.svg?invert_in_darkmode" align=middle width=5.663225699999989pt height=21.68300969999999pt/> is either <img src="svgs/e11a8cfcf953c683196d7a48677b2277.svg?invert_in_darkmode" align=middle width=21.00464354999999pt height=21.18721440000001pt/> or <img src="svgs/034d0a6be0424bffe9a6e7ac9236c0f5.svg?invert_in_darkmode" align=middle width=8.219277000000005pt height=21.18732pt/> and <img src="svgs/fb97d38bcc19230b0acd442e17db879c.svg?invert_in_darkmode" align=middle width=17.73973739999999pt height=22.465723500000017pt/> is the margin.

So, this is the first contribution: among the infinite hyperplanes, we want to find the one with the maximum margin. If a separating hyperplane does not exist, we want to find one which almost separates the classes, and disregard examples generating a very narrow margin. 

The soft margin ensures a greater robustness to individual observation, and a better classification of most of the training observation. It is obtained by adding a constraint (penalty term, the sum of all the points on the wrong side) to the optimization problem expressed by a parameter <img src="svgs/9b325b9e31e85137d1de765f43c0f8bc.svg?invert_in_darkmode" align=middle width=12.92464304999999pt height=22.465723500000017pt/>.

So, we have seen how to deal with non-linear separability, but there's another possibility: we can have datasets which are non linearly-separable because of something more than a few exceptions, like:

![Screenshot 2020-10-23 at 17.32.30](res/nonlineards.png)

 

There is no linear hyperplane that separates these. We can then perform a linear transformation, to a higher dimension space with the third dimension being <img src="svgs/1749ec7316ee7ac73b892273f7338fc3.svg?invert_in_darkmode" align=middle width=62.12324414999999pt height=26.76175259999998pt/>. It happens that if we project in the 3D space those points, now we have linear separability. We call the original space **input space**, and the new one **feature space**. 

This idea is called a **kernel trick**: for mathematical reasons, it happens that this computation, seemingly difficult, is feasible with an affordable computational complexity. Separating the hyperplane requires a series of **dot products**. If we define the mapping on the basis of a particular family of functions, called **kernel functions**, the mapping doesn't need to be explicitly computed, and the computation is done in the input space. 

What has to remembered for the exam is that there's different kernel functions available.

The time complexity is mainly influenced by the efficiency of the optimization library (like *libSVM*), which scales from <img src="svgs/04512f6f2faaab87f50584ec70eeff54.svg?invert_in_darkmode" align=middle width=78.29449979999998pt height=26.76175259999998pt/> and <img src="svgs/fb213e6764b771627b3d91ce7ca026f2.svg?invert_in_darkmode" align=middle width=78.29449979999998pt height=26.76175259999998pt/>; in case of sparse data, it is reduced. 

So, learning is generally slower than simpler methods, tuning is necessary (and not so easy), but the results can be very accurate. It is explicitly based on a strong mathematical model, it is not affected by local minima (optimizers can be very effective) and it does not suffer from the curse of dimensionality, since it doesn't use any notion of distance. 

# Neural networks

These were inspired by the brain of animals, trying to reproduce neutrons, generating intelligence.

The idea is that if we put together several neurons, we can generate a decision boundary which is much more complicated.

Brains are actually much more complicated than this, but who gives a sh*t?

So, a **neuron** is a signal processor with a threshold: it receives inputs and it gives outputs. The inputs are not simply transmitted from a neuron to the other, but they are **weighted**. The weights are the *engine of the reasoning*, and they're adapted with learning.

We have processors and weights, and we must learn the weights, through examples. It's actually better to limit the connections.

This **multi-layer perceptron** has signals which are transmitted, and they're modeled as **real numbers**. The processing element is inspired to the biological system, when an input is higher than a threshold, something happens. We could linearly increase those, but there are better solutions, like using a **sigmoid** or an **arctan** or a **ReLU**.

These are called **squashing functions**, which map reals into <img src="svgs/f27d1a8ebacee1389ff26e63ae976661.svg?invert_in_darkmode" align=middle width=32.87674994999999pt height=24.65753399999998pt/>. 

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