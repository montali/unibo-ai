
# Clustering

Given a set of $N$ ovjects, the task is now finding a partitioning in K clusters and possibly a number of noise objects.

We want this classification to *emerge from the data*. Our mapping ahs to maximize the intra-cluster similarity, and minimize the inter-cluster one.

There's a large number of methods, like partitioning, hierarchic, methods based on linkafe, density, statistics...

## K-means clustering

We'll start with an intuitive algorithm. Given a 2D dataset, where we have *5 clouds*, how can we model this distribution?

![Distribution](./res/clustering-distribution.png)

So, how do we guess the numver *five* in a D-dimensional space? In order to reason about this, we consider the idea of **transmission**: we have this 2D dataset, with each point being a pair of coordinates, and we want to **transmit** this by using only two bits per point. This transmission will obviously be lossy. Our task is to find the best approximation in this transmission: we need a coding/decoding mechanism, where each point will be encoded/decoded. We could split the plane into 4 subsquares 00,01,10,11.  

We could the partition the space into a different grid, moving the *centroid* (average of the vector/center of gravity) to the *clouds* of points. 

So, let's say that a user gives us the number $K$ of clusters. Given that, we can start with a random set of centroids (temporary centers), then start labeling the points of the dataset. For each one, we can find the nearest center to the point. 

After that, each center can find the center of gravity of its points (which are the ones having that center as the nearest one), and move the center there.

Remember that **centroid=center of gravity**.

### Distortion

We now have two functions, encoding and decoding. Since the encoding is lossy, the result will be different from the input. We can define the distortion as the difference between the original value and the decoded one: $\text { Distortion }=\sum_{i=1}^{N}\left(e_{i}-\mathbf{C}_{\text {Encode }\left(e_{i}\right)}\right)^{2}$.

Which properties are requested to the $c$ to have minimal distortion? 

- $e_i$ must be encoded with the nearest center (otherwise it could be reducible by changing center)
- The partial derivative of distortion with respect to the position of each center must be zero, because in that case the function has either a maximum or a minimum
  - $\begin{aligned}
    &\begin{aligned}
    \text { Distortion } &=\sum_{i=1}^{N}\left(e_{i}-\mathbf{c}_{\text {Encode }\left(e_{i}\right)}\right)^{2} \\
    &=\sum_{j=1}^{K} \sum_{i \in \text { Owned } B y\left(c_{j}\right)}\left(e_{i}-\mathbf{c}_{j}\right)^{2} \\
    \frac{\partial \text { Distortion }}{\partial \mathbf{c}_{j}} &=\frac{\partial}{\partial \mathbf{c}_{j}} \sum_{i \in \text { Owned } B y\left(\mathbf{c}_{j}\right)}\left(e_{i}-\mathbf{c}_{j}\right)^{2} \\
    &=-2 \sum_{i \in \text { Owned } B y\left(c_{j}\right)}\left(e_{i}-\mathbf{c}_{j}\right)
    \end{aligned}\\
    &=0 \text { when minimum distortion }
    \end{aligned}$
  - $\mathbf{c}_{j}=\frac{1}{\mid \text { OwnedBy }\left(\mathbf{c}_{j}\right) \mid} \sum_{i \in \text { Owned } B y\left(c_{j}\right)}\left(e_{i}-\mathbf{c}_{j}\right)$
  - Therefore, each center **must be the centroid** of the points it owns!

### Improving a sub-optimal solution

We can alternately perform steps 1 and 2: it can be proved that after a finite number of steps, either one of the two steps produces no change, reaching a final state.

### Algorithm termination

Note that the distortion function is **convex**: this means that we can reach a final state!

There's a finite number of configurations, and if after one iteration the state changes, the distortion is reduced. In summary, sooner or later there will be no new reachable states. 

*Is this the best solution?* No, we could end in a state which is not the best one.

How do we choose the number of clusters? We could consider it as an hyperparameter, since the best value is a compromise.

It may happen that a centroid does not own points: if the initial random values are particular, our cluster may become empty, resulting in a different number of clusters. In this cases, we should change the centroid to a new one, maybe changing the seed.

Sometimes it's a good idea to remove outliers before computing the k-means. 

K-means is generally so fast that it's good to be used for data esploration.

If we discretize the values, using as discretizing values the centroid of he cluster, we simplify the data thus reducing the error: w want to transform a continuous domain inot a discrete one. 

K-means is the basis for vector quantisation and for choosing color palettes.

It is surprisingly fast and fairly efficient. Though, it has weanesses: it is defined for spaces where the centroid can be computed, it requires the K parameter, it is very sensitive to outliers, doesn't deal with noise, and doesn't properly deal with non convex clusters.

The evaluation of a clustering scheme is very important, but we don't have informations )it is non-supervised) about that: we need some measures.

We should distinguish patterns from random apparent regularities, find the best number of clusters.

### Cohesion

It's the proximity of objects in the same cluster, it should be high. It is the sum of proximities between the elements of the cluster and the geometric genter: *centroid* (means of dataset), *medioid* (element whose average dissimilarity from the others is minimal). 

### Separation

Measures the inter-proximity, there are several possibilities: measuring the distance between the nearest objects, the most distant, the centroids.

### Global separation of a clustering scheme

<img src="https://cdn.mathpix.com/snip/images/Y-19Y6KgAOvtOF39Z3a5ir6ZPCBWlkJ-y5Hdvqc2Olw.original.fullsize.png" />

Which is the weighted sum of the distances. It is weighted so that bigger clusters have bigger influence.

We can find a link between cohesion and separation. Let $TSS$ be the total sum of squares, which is composed by $SSE$ and $SSB$.

### Silhouette index of a cluster

For each $i$ object we compute the average distance with respect to the other objects in its cluster, and call this $a_i$. Then, we compute the average distance from all the objects of the cluster (for any cluster), and find the minimum with respect to all the clusters. This value is called $b_i$

Then, we calculate the silhouette index as 
$$
s_{i}=\frac{b_{i}-a_{i}}{\max \left(a_{i}, b_{i}\right)} \in[-1,1]
$$
When $1$, the object is very well clustered, when $-1$ it's not. 

We can compute this for each object, then average it for the full dataset. 

Silhouette index is a good measure, but it has a bad aspect: it requires significant effort for the computation!

## Looking for the best number of clusters

The measures are obviously influenced by the K number. SSE and silhouettes are the most used measures. Note that when we reach the right number of clusters the slope changes: the SSE decreases more slowly.

We can even use **supervised measures**, like a partition named **gold standard** to validate a clustering technique which can be applied later to new data.









