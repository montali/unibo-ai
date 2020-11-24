# Feature selection

Feature selection might enable the algorithm to train faster, reduce the complexity of a model and making it easier to interpret. 

Feature seleciton might be supervised or not. For the unsupervised, there are lots of methods, like the feature transformation techiniques suchnas PCA, which could reduce the number of features.

So, filter methods are based on general characteristics pf dthe data. The idea is to select a subset of attributes, independently from the classifying method. They measure the relevant features by their correlation with the dependent variable, while wrapper methods measure the usefulness of a subset of features by actually training a method on it.

These may failto find the best subset, while wrapper methods are generally more secure. On the other hand, wrapper methods are computationally heavier and can incur in overfitting. 

Instead of considering which subset of attributes is to be ignored it is possible to map the dataset into a new space with fewer attributes. 

## PCA

The aim is finding a new set of dimensions that are sufficiently informative. The first new attribute will capture most of the variability, the second is orthogonal to the first one and captures most of the remaining variability, and so on... There is a method to check the amount of the variability captured by each feature. 

## MDS

This starts from the distances among the elements of tge dataset, and it fits the projection of these into an <img src="svgs/55a049b8f161ae7cfeb0197d75aff967.svg?invert_in_darkmode" align=middle width=9.86687624999999pt height=14.15524440000002pt/>-dimensional space such that the distances among the elements are preserved. There are version for non-metric spaces too! 

## Baseline estimator

The idea is removing features with low variance. Obviously this is unsupervised. Which variance threshold should we choose? We need a little computation. 

## Univariate feature selection

The idea is that we should select the best feature set basing on univariate statistical tests. This is supervised, we consider the set of features and the target. For each feature we return a score and a pvalue. The score functions evaluate how much a feature is useful to rpedict the target, the most important being the *mutual_info_classif*, a generalization of the *information gain*. Another one is the *f_classif*, based a fisher test with ANOVA (analysis of variance). 

Then, among the results, we can select the <img src="svgs/d6328eaebbcd5c358f426dbea4bdbf70.svg?invert_in_darkmode" align=middle width=15.13700594999999pt height=22.465723500000017pt/> best or the percentiles.

## Recursive Feature Elimination

This is a feature ranking with recursive feature elimination. In the other we scored each feature wrt the target, in this case we apply the estimator, i.e. we do the entire process.