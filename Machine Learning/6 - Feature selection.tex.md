# Feature selection

Feature selection might enable the algorithm to train faster, reduce the complexity of a model and making it easier to interpret. 

Feature selection might be supervised or not. For the unsupervised, there are lots of methods, like the feature transformation techiniques such as PCA, which could reduce the number of features.

So, filter methods are based on general characteristics of the data. The idea is to select a subset of attributes, independently from the classifying method. They measure the relevant features by their correlation with the dependent variable, while wrapper methods measure the usefulness of a subset of features by actually training a method on it.

These may fail to find the best subset, while wrapper methods are generally more secure. On the other hand, wrapper methods are computationally heavier and can incur in overfitting. 

Instead of considering which subset of attributes is to be ignored it is possible to map the dataset into a new space with fewer attributes. 

## PCA

The aim is finding a new set of dimensions that are sufficiently informative. The first new attribute will capture most of the variability, the second is orthogonal to the first one and captures most of the remaining variability, and so on... There is a method to check the amount of the variability captured by each feature. 

## MDS

This starts from the distances among the elements of the dataset, and it fits the projection of these into an $n$-dimensional space such that the distances among the elements are preserved. There are version for non-metric spaces too! 

## Baseline estimator

The idea is removing features with low variance. Obviously this is unsupervised. Which variance threshold should we choose? We need a little computation. 

## Univariate feature selection

The idea is that we should select the best feature set basing on univariate statistical tests. This is supervised, we consider the set of features and the target. For each feature we return a score and a pvalue. The score functions evaluate how much a feature is useful to rpedict the target, the most important being the *mutual_info_classif*, a generalization of the *information gain*. Another one is the *f_classif*, based a fisher test with ANOVA (analysis of variance). 

Then, among the results, we can select the $K$ best or the percentiles.

## Recursive Feature Elimination

This is a feature ranking with recursive feature elimination. In the other we scored each feature wrt the target, in this case we apply the estimator, i.e. we do the entire process.