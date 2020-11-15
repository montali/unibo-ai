# Image segmentation

Image segmentation is about splitting an image in two disjoint regions having some semantics meanings. Typically, we'll want to split the image into *background* and *foreground*. This is usually achieved in two steps: the first being the *binarization* (labelling a pixel to the foreground and background), then, if the foreground contains different objects, we'll want to tell them apart.

One way of performing this is just thresholding the intensities.

Denoted as $P(x,y)$, a vector-valued function encoding a set of image properties, the goal of segmentation is to partition the image into disjoint homogeneous regions according to $P$.

Typically, a good segmentation should preserve spatial proximity (i.e. two nearby pixels must belong to the same region unless they exhibit significantly different $P$ values). In many CV tasks, segmentation brings in key semantic knowledge in th scene. 

In many cases, we work with *inherently binary images*, meaning that clearly, in the given image, there's two regions, one being dark and one being clear. 

The first step is to just perform this **binarization**.

Inherently binary images exhibit a clearly bimodal gray-level histogram, with two well-separated peals corresponding to foreground and background pixels. Therefore, binarization can be achieved straightforwardly by means of a thresholding operator deploying a suitably chosen threshold:

![Binarization](./res/binarization.png)

How do we pick the threshold? We simply can look at the histogram.

Whenever the histogram is not clearly bimodal (e.g. due to illumination varying), binarization by threshold obviously fails.![Segmentation by threshold fails](./res/segmentation-by-threshold.png)

Sometimes it happens that the non-perfect bimodality is caused by noise, leading to the two modes *overlapping*. A smoothing to the image might solve that:![Binarization of a noisy image](./res/binarization-noisy.png)

Due to our knowledge of the *unimodality* of the histogram being caused by noise, we shall apply a denoising filter!

In many practical applications stability over time of the lighting conditions cannot be guaranteed: we'll need an approach in which **no manual intervention is needed**, rather every image will first be analyzed by a suitable algorithm in charge of finding the right threshold for **that given image only**. This addresses well the issue of temporally varying lighting. Spatial variations will need other techniques, while temporal variations are solvable like this.

How do we compute these? There are multiple approaches, and we can start by simple heuristic approaches like:

- $T=\mu$ (mean), working as long as pixels are equally distributed between the two classes. Every pixel below the mean will be considered as dark, every pixel above it will be light. Note that if we have much more dark/light pixels than the other, this won't work, as the mean will be biased towards the more common one! We could choose a percentile instead of the mean, but we have to get knowledge on the distribution;

- the **peaks method**, picking the value halfways between the two peaks (*local maxima*) in the histogram. The thing is: are there really gonna be two peaks? We suppose that the histogram is bimodal, if it is not, we can't use this method! Otherwise, forget about this approach. $T=argmin\{h(i)| i \in [i_1,i_2]\}$, which requires finding the two peaks, which often implies smoothing the histogram before looking for peaks to avoid the search being trapped into spurious local maxima

- **Otsu's algorithm**, which is an effective automatic threshold selection algorithm. The concept here is (and it is the case for most algorithm) finding the optimal threshold, which means optimal wrt some criterion. We'll perform an optimization of a function (or maximization of a reward). In this algorithm, we choose the threshold that minimize the *within-group variance* of the resulting regions, which basically states how homogeneous the region intensities turn out to be. To mathematically formalize this, we'll need some notation:

  - We'll define $i=1...L$ as the set of gray levels in the image, $N$ the number of pixels in the image, $h(i): i^{th}$ entry of the image histogram and $p(i)=h(i)/N$ the probability.

  - The mean $\mu$ and variance $\sigma^2$ of the $pmf$ associated to the gray levels can be expressed as $\mu=\sum_{i=1}^L ip(i)$ and $\sigma^2=\sum_{i=1}^L (i-\mu)^2p(i)$. The $\mu$ is the expectation, while the variance is the expectation of the square error wrt the mean.

  - We can now define the *within-group variances* generated in the binarization. Any threshold value $t$ . If we want to compute the variance, we'll first want to compute the mean $\mu_1$ and $\mu_2$. How can we compute that, for example wrt the first class? We'll want to compute the pixels with intensity below the chosen threshold: $\mu_1(t)=\sum_{i=1}^t ih(i)$ . Note tehat we shall not divide by $N$ but by $N_1$, i.e. the number of pixels in class 1 and not the whole of them. Now, if we multiply and divide by $N$, we get $\frac{h(i)}{N}$ which is $p(i)$! We can then rewrite this as $\sum_{i=1}^t ip(i) \frac{N}{N_1}$ What's this last fraction? Let's define it as $q_1=\frac{N_1}{N}$, being the fraction of pixels in class 1. Now, if I remember what $N_1$ is, i.e. $h_1=\sum_{i=1}^t \frac{h(i)}{N}=\sum_{i=1}^t  p(i)$. Because of this definition, we finally get $\frac{N}{N_1}=\frac{1}{q_1}$, $\mu_1 (t) =\frac{ip(i)}{q_1(t)}$, and $\mu_2(t)=\sum_{i=1}^L i \frac{h(i)}{N_2}\rightarrow\sum_{i=t+1}^L \frac{ip(i)}{q_2}$ with $q_2=\frac{N_2}{N}$.

  - In case we want to find the variances, we can go over the same steps, with the only difference being the function on which we are computing the expectation which is now $(i-\mu)^2$.

    Recapping:


  $$
    \begin{aligned}
    \mu_{1}(t) &=\sum_{i=1}^{t} i p(i) / q_{1}(t) & & \sigma_{1}^{2}(t)=\sum_{i=1}^{t}\left(i-\mu_{1}(t)\right)^{2} p(i) / q_{1}(t) \\
    \mu_{2}(t) &=\sum_{i=t+1}^{L} i p(i) / q_{2}(t) & & \sigma_{2}^{2}(t)=\sum_{i=t+1}^{L}\left(i-\mu_{2}(t)\right)^{2} p(i) / q_{2}(t)
    \end{aligned}
  $$

  ​		with 
  $$
  q_{1}(t)=\sum_{i=1}^{t} p(i) \quad q_{2}(t)=\sum_{i=t+1}^{L} p(i)
  $$

    

  - Now, we can find the *within-group variance*, which is the **weighted sum** of the two variances: $\sigma_{W}^{2}(t)=q_{1}(t) \sigma_{1}^{2}(t)+q_{2}(t) \sigma_{2}^{2}(t)$. If this is small, it means that the classes are homogeneous! The search space is 1D, which makes it easy, but it could make sense to make this a little faster. This is obtained by sum algebraic manipulations turning this minimzation problem into an easier maximisation problem. Minimization of the within-group variance requires computing the means and the variances. By deploying a property of this parameter, i.e. its relation with the whole image's variance, we can cast this problem into a more efficient one.

  - We already introduced the whole image's variance, i.e. the expectation of the square error on the mean. Now, we can split this sum into two terms, being the sum up to $t$ and the sum from $t+1$ to $L$. But then, what we'll do is, rather than considering $i-\mu$, we can subtract and add $\mu_1$ and do the same with $\mu_2$, obtaining $(i-\mu_1+\mu_1-\mu)^2$, allowing us to rewrite the expression of the whole image's variance as a sum of these. 

  - $$
    \begin{aligned}
    \sigma^{2} &=\sum_{i=1}^{L}(i-\mu)^{2} p(i) \\
    &=\sum_{i=1}^{t}\left(i-\mu_{1}(t)+\mu_{1}(t)-\mu\right)^{2} p(i)+\sum_{i=t+1}^{L}\left(i-\mu_{2}(t)+\mu_{2}(t)-\mu\right)^{2} p(i)
    \end{aligned}
    $$

  - Now, we expand the binomials, do some math tricks I don't want to copy and get 

  - $$
    \begin{aligned}
    \sum_{i=1}^{t}\left(i-\mu_{1}(t)\right)\left(\mu_{1}(t)-\mu\right) p(i) &=0 \\
    \sum_{i=t+1}^{L}\left(i-\mu_{2}(t)\right)\left(\mu_{2}(t)-\mu\right) p(i) &=0
    \end{aligned}
    $$

  - So, now we get $\sigma^{2}=\sum_{i=1}^{t}\left(i-\mu_{1}(t)\right)^{2} p(i)+\sum_{i=t+1}^{L}\left(i-\mu_{2}(t)\right)^{2} p(i)+\left(\mu_{1}(t)-\mu\right)^{2} q_{1}(t)+\left(\mu_{2}(t)-\mu\right)^{2} q_{2}(t)$, and we know that maximizing the between group variance minimizes the withing-group variance

  Finally:
  $$
  \begin{aligned}
  \sigma^{2} &=\left[q_{1}(t) \sigma_{1}^{2}(t)+q_{2}(t) \sigma_{2}^{2}(t)\right]+\left[\left(\mu_{1}(t)-\mu\right)^{2} q_{1}(t)+\left(\mu_{2}(t)-\mu\right)^{2} q_{2}(t)\right] \\
  \sigma^{2} &=\sigma_{W}^{2}(t)+\sigma_{B}^{2}(t)
  \end{aligned}
  $$
  where $\sigma^2_B(t)$ being the between-group variance, which is maximized. 

  So, as $\sigma^2$ is independent of $t$, the above relation suggests we might wish to maximize the between-group variance rather than minimizing the within-group one, since we don't need to compute variances in the first one. Further computational savings can be achieved, getting to:
  $$
  \sigma_{B}^{2}(t)=q_{1}(t)\left(1-q_{1}(t)\right)_{i}\left(\mu_{1}(t)-\mu_{2}(t)\right)^{2}
  $$

  ## Adaptive thresholding

  When the lighting isn't uniform, a spatially varying threshold should be adopted. Tipically, adaptive methods compute a specific threshold at each image pixel, based on the intensities within a small neighbourhood. However, too small a neighbourhood might lack either background or foreground pixels, which sould imply segmentation errors unless the issue is dealt with explicitly. For the sake of efficiency, we tipically adopt simple operators on each pixel, like the mean or the median. 

  ### Color-based segmentation

  This is another frequent technique. We don't tend to use color that much in CV (often it does not bring additional information wrt the additional cost). Sometimes we can segmentize object from the background basing on the color: we know the object and the background have a very different color. It is often the case that the user would be allowed to control the color of the background, choosing one that is different from the one in the foreground, like blue or green (the infamous *green screen*). For example, in the food industry, it is quite usual to use blue conveyor belts, since food is unlikely to be blue. We can denote the pixel intensity as a matrix in RGB: $I(p)=\left[\begin{array}{c}
  I_{r}(p) \\
  I_{g}(p) \\
  I_{b}(p)
  \end{array}\right]$ .

  Then, segmentation can be achieved by computing and thresholding the distance between the pixel's colour and the reference background colour $\mu$.
  $$
  \forall p \in \mathbf{I}:\left\{\begin{array}{l}
  d(\mathbf{I}(p), \boldsymbol{\mu}) \leq T \rightarrow O(p)=B \\
  d(\mathbf{I}(p), \boldsymbol{\mu})>T \rightarrow O(p)=F
  \end{array}\right.
  $$

  $$
  d(\mathbf{I}(p), \boldsymbol{\mu})=\left(\left(I_{r}(p)-\mu_{r}\right)^{2}+\left(I_{g}(p)-\mu_{g}\right)^{2}+\left(I_{b}(p)-\mu_{b}\right)^{2}\right)^{\frac{1}{2}}
  $$

  How can we **estimate the reference colour**? This is tipically done by taking some training images, then estimating it, for example by taking pixels, then taking their mean:
  $$
  \boldsymbol{\mu}=\left[\begin{array}{c}
  \mu_{r} \\
  \mu_{g} \\
  \mu_{b}
  \end{array}\right]=\frac{1}{N} \sum_{k=1}^{N} \mathbf{I}\left(p_{k}\right)
  $$
  Another kind of distance (different from this *Euclidean distance*) is frequently used. *We'll discover that in the next episode.*

  

  

