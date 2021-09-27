# 1. ML basics and kNN

When applying machine learning methods we have a training set _D<sup>train</sup>_ and a test set _D<sup>test</sup>_. Both contain couples _(x<sup>(i)</sup>, y<sup>(i)</sup>)_, where _x<sup>(i)</sup>_ are the features representing a real world item and _y<sup>(i)</sup>_ is the output we want for that item. 

## The kNN (k nearest neighbor) classifier

### Training
 1. Store all the training examples and labels.

### Testing
 1. Compute distance in feature space between test sample and all the training examples;
 2. Retrieve labels for the closest _k_ examples;
 3. Aggregate them to define the predicted label for the test sample.

kNN is a non-parametric instance based algorithm which can predict complex data distributions. Its performances only depend from the quality of the features and of the distance. Its biggest flaw is that, being a lazy algorithm, all the computation is postponed to test time.

_k_ and the distance are hyperparameters and so they are not learned from the data but we have to manually set them. This is done because they are either too hard to be learned from data or not appropriate to learn (i.e. the best value you can compute on the test set is likely to perform poorly on the test set).

### Model capacity

By increasing _k_ we decrease the model capacity of the classifier, which can be thought as a measure of how much flexible the function that can be learned are. With _k = 1_ we obtain a model that can perfectly classify any training dataset. However we are not interested in training error, but only in test error and it cannot estimated by training data. The only way is to see how the modle perform on unseen data. For this reason we separate some examples from the training set and use them to create the validation set. Then we test hyperparameters on the validation set and select hyperparameters combination that performs best and we finally runthe model once on the test set to evaluate  generalization.
