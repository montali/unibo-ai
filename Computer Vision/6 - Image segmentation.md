# Image segmentation

Image segmentation is about splitting an image in two disjoint regions having some semantics meanings. Typically, we'll want to split the image into *background* and *foreground*. This is usually achieved in two steps: the first being the *binarization* (labelling a pixel to the foreground and background), then, if the foreground contains different objects, we'll want to tell them apart.

One way of performing this is just thresholding the intensities.

Denoted as <img src="svgs/a5f650818067f71d246340fa29b0f874.svg?invert_in_darkmode" align=middle width=50.97228344999999pt height=24.65753399999998pt/>, a vector-valued function encoding a set of image properties, the goal of segmentation is to partition the image into disjoint homogeneous regions according to <img src="svgs/df5a289587a2f0247a5b97c1e8ac58ca.svg?invert_in_darkmode" align=middle width=12.83677559999999pt height=22.465723500000017pt/>.

Typically, a good segmentation should preserve spatial proximity (i.e. two nearby pixels must belong to the same region unless they exhibit significantly different <img src="svgs/df5a289587a2f0247a5b97c1e8ac58ca.svg?invert_in_darkmode" align=middle width=12.83677559999999pt height=22.465723500000017pt/> values). In many CV tasks, segmentation brings in key semantic knowledge in th scene. 

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

- <img src="svgs/6de3b719bca2c2778aba5453821356f0.svg?invert_in_darkmode" align=middle width=43.71186599999999pt height=22.465723500000017pt/> (mean), working as long as pixels are equally distributed between the two classes. Every pixel below the mean will be considered as dark, every pixel above it will be light. Note that if we have much more dark/light pixels than the other, this won't work, as the mean will be biased towards the more common one! We could choose a percentile instead of the mean, but we have to get knowledge on the distribution;

- the **peaks method**, picking the value halfways between the two peaks (*local maxima*) in the histogram. The thing is: are there really gonna be two peaks? We suppose that the histogram is bimodal, if it is not, we can't use this method! Otherwise, forget about this approach. <img src="svgs/307b162504f9d3590f6bf4eff4524add.svg?invert_in_darkmode" align=middle width=205.95509714999997pt height=24.65753399999998pt/>, which requires finding the two peaks, which often implies smoothing the histogram before looking for peaks to avoid the search being trapped into spurious local maxima

- **Otsu's algorithm**, which is an effective automatic threshold selection algorithm. The concept here is (and it is the case for most algorithm) finding the optimal threshold, which means optimal wrt some criterion. We'll perform an optimization of a function (or maximization of a reward). In this algorithm, we choose the threshold that minimize the *within-group variance* of the resulting regions, which basically states how homogeneous the region intensities turn out to be. To mathematically formalize this, we'll need some notation:

  - We'll define <img src="svgs/93c14a66a95afc01ccf309435c052b5d.svg?invert_in_darkmode" align=middle width=60.68598029999998pt height=22.465723500000017pt/> as the set of gray levels in the image, <img src="svgs/f9c4988898e7f532b9f826a75014ed3c.svg?invert_in_darkmode" align=middle width=14.99998994999999pt height=22.465723500000017pt/> the number of pixels in the image, <img src="svgs/7c8675abfdfa021a83d6f117fc6235a2.svg?invert_in_darkmode" align=middle width=59.94324104999998pt height=27.91243950000002pt/> entry of the image histogram and <img src="svgs/0f9742358a9f73e66741d53039501d42.svg?invert_in_darkmode" align=middle width=98.86258635pt height=24.65753399999998pt/> the probability.

  - The mean <img src="svgs/07617f9d8fe48b4a7b3f523d6730eef0.svg?invert_in_darkmode" align=middle width=9.90492359999999pt height=14.15524440000002pt/> and variance <img src="svgs/e6718aa5499c31af3ff15c3c594a7854.svg?invert_in_darkmode" align=middle width=16.535428799999988pt height=26.76175259999998pt/> of the <img src="svgs/5e06b1f3eeeddccd8d082b4e87abf2b0.svg?invert_in_darkmode" align=middle width=32.52108254999999pt height=22.831056599999986pt/> associated to the gray levels can be expressed as <img src="svgs/ac5425031524263c556ed47b24abe94f.svg?invert_in_darkmode" align=middle width=106.41302594999998pt height=32.256008400000006pt/> and <img src="svgs/6d353d8e6be80224a1e885b4ccb16f56.svg?invert_in_darkmode" align=middle width=161.28179264999997pt height=32.256008400000006pt/>. The <img src="svgs/07617f9d8fe48b4a7b3f523d6730eef0.svg?invert_in_darkmode" align=middle width=9.90492359999999pt height=14.15524440000002pt/> is the expectation, while the variance is the expectation of the square error wrt the mean.

  - We can now define the *within-group variances* generated in the binarization. Any threshold value <img src="svgs/4f4f4e395762a3af4575de74c019ebb5.svg?invert_in_darkmode" align=middle width=5.936097749999991pt height=20.221802699999984pt/> . If we want to compute the variance, we'll first want to compute the mean <img src="svgs/d4c22567d6bf353815350caad68420a0.svg?invert_in_darkmode" align=middle width=16.45747124999999pt height=14.15524440000002pt/> and <img src="svgs/d9324c21b00105263d6f54123813d99c.svg?invert_in_darkmode" align=middle width=16.45747124999999pt height=14.15524440000002pt/>. How can we compute that, for example wrt the first class? We'll want to compute the pixels with intensity below the chosen threshold: <img src="svgs/3dd9f647cfc4c020f0b8118d33dc3cb5.svg?invert_in_darkmode" align=middle width=133.70956499999997pt height=30.685221600000023pt/> . Note tehat we shall not divide by <img src="svgs/f9c4988898e7f532b9f826a75014ed3c.svg?invert_in_darkmode" align=middle width=14.99998994999999pt height=22.465723500000017pt/> but by <img src="svgs/3bd1d510559f062f1989f670d3aad98d.svg?invert_in_darkmode" align=middle width=19.760314199999993pt height=22.465723500000017pt/>, i.e. the number of pixels in class 1 and not the whole of them. Now, if we multiply and divide by <img src="svgs/f9c4988898e7f532b9f826a75014ed3c.svg?invert_in_darkmode" align=middle width=14.99998994999999pt height=22.465723500000017pt/>, we get <img src="svgs/519a65875f353a42b2be1cbf2e602713.svg?invert_in_darkmode" align=middle width=22.62095715pt height=33.20539859999999pt/> which is <img src="svgs/1431e18dc1be43ccef488d6c7ed92402.svg?invert_in_darkmode" align=middle width=26.71922714999999pt height=24.65753399999998pt/>! We can then rewrite this as <img src="svgs/fb23b1b0fe9f9b97afc16634e40b98e8.svg?invert_in_darkmode" align=middle width=93.39083819999999pt height=30.685221600000023pt/> What's this last fraction? Let's define it as <img src="svgs/b0b09043cff3fb7cbabd0375af9311cc.svg?invert_in_darkmode" align=middle width=55.43076989999999pt height=29.205422400000014pt/>, being the fraction of pixels in class 1. Now, if I remember what <img src="svgs/3bd1d510559f062f1989f670d3aad98d.svg?invert_in_darkmode" align=middle width=19.760314199999993pt height=22.465723500000017pt/> is, i.e. <img src="svgs/981f6aaa77923cdef3856c3e31d1ed43.svg?invert_in_darkmode" align=middle width=198.38221754999998pt height=33.20539859999999pt/>. Because of this definition, we finally get <img src="svgs/1b3237495ac00259b624e54afbe9419f.svg?invert_in_darkmode" align=middle width=55.131156299999994pt height=28.670654099999997pt/>, <img src="svgs/b4edd4d96a5518749741d6a444b417cc.svg?invert_in_darkmode" align=middle width=87.57155219999999pt height=33.20539859999999pt/>, and <img src="svgs/db6c6eb80978c9b77acadffc4c7a92af.svg?invert_in_darkmode" align=middle width=243.51657329999998pt height=33.20539859999999pt/> with <img src="svgs/9012237815e0d097520f4931c3a17fb4.svg?invert_in_darkmode" align=middle width=55.43076989999999pt height=29.205422400000014pt/>.

  - In case we want to find the variances, we can go over the same steps, with the only difference being the function on which we are computing the expectation which is now <img src="svgs/057b7fbee55c0800a296af8bafa84e26.svg?invert_in_darkmode" align=middle width=54.997321499999984pt height=26.76175259999998pt/>.

    Recapping:


<p align="center"><img src="svgs/e6f2b3abee13a2a3aacebb633d9b9c20.svg?invert_in_darkmode" align=middle width=437.59997819999995pt height=106.059657pt/></p>

  ​		with 
<p align="center"><img src="svgs/1dcca6d5529285bdf077819e1800db32.svg?invert_in_darkmode" align=middle width=246.15628784999998pt height=49.17595815pt/></p>

​    

  - Now, we can find the *within-group variance*, which is the **weighted sum** of the two variances: <img src="svgs/ab0e592b00d72cdd86b1379dc89143d9.svg?invert_in_darkmode" align=middle width=224.1041847pt height=26.76175259999998pt/>. If this is small, it means that the classes are homogeneous! The search space is 1D, which makes it easy, but it could make sense to make this a little faster. This is obtained by sum algebraic manipulations turning this minimzation problem into an easier maximisation problem. Minimization of the within-group variance requires computing the means and the variances. By deploying a property of this parameter, i.e. its relation with the whole image's variance, we can cast this problem into a more efficient one.

  - We already introduced the whole image's variance, i.e. the expectation of the square error on the mean. Now, we can split this sum into two terms, being the sum up to <img src="svgs/4f4f4e395762a3af4575de74c019ebb5.svg?invert_in_darkmode" align=middle width=5.936097749999991pt height=20.221802699999984pt/> and the sum from <img src="svgs/628783099380408a32610228991619a8.svg?invert_in_darkmode" align=middle width=34.24649744999999pt height=21.18721440000001pt/> to <img src="svgs/ddcb483302ed36a59286424aa5e0be17.svg?invert_in_darkmode" align=middle width=11.18724254999999pt height=22.465723500000017pt/>. But then, what we'll do is, rather than considering <img src="svgs/e2b6a2e82c81317320b9ca79a3e56c27.svg?invert_in_darkmode" align=middle width=35.65934129999999pt height=21.68300969999999pt/>, we can subtract and add <img src="svgs/d4c22567d6bf353815350caad68420a0.svg?invert_in_darkmode" align=middle width=16.45747124999999pt height=14.15524440000002pt/> and do the same with <img src="svgs/d9324c21b00105263d6f54123813d99c.svg?invert_in_darkmode" align=middle width=16.45747124999999pt height=14.15524440000002pt/>, obtaining <img src="svgs/224d53d8e98d33d144ff9bafa8043fb9.svg?invert_in_darkmode" align=middle width=129.73847204999998pt height=26.76175259999998pt/>, allowing us to rewrite the expression of the whole image's variance as a sum of these. 

  - <p align="center"><img src="svgs/ffb5f2f5ccfc9c6ea4045a9c7d45d1ac.svg?invert_in_darkmode" align=middle width=519.86611215pt height=106.84505039999999pt/></p>

  - Now, we expand the binomials, do some math tricks I don't want to copy and get 

  - <p align="center"><img src="svgs/5f609d23a7d416d08abaca5ab9d4046e.svg?invert_in_darkmode" align=middle width=254.75003564999997pt height=106.059657pt/></p>

  - So, now we get <img src="svgs/e3dbf665650723d4057903dd53cecd3a.svg?invert_in_darkmode" align=middle width=666.4314327000001pt height=32.256008400000006pt/>, and we know that maximizing the between group variance minimizes the withing-group variance

  Finally:
<p align="center"><img src="svgs/9cf618c21fde68f4b56a65d58265512c.svg?invert_in_darkmode" align=middle width=512.4601448999999pt height=54.4770567pt/></p>
  where <img src="svgs/fc3ded8cc88c2227f1edab36d37222e1.svg?invert_in_darkmode" align=middle width=39.42915074999999pt height=26.76175259999998pt/> being the between-group variance, which is maximized. 

  So, as <img src="svgs/e6718aa5499c31af3ff15c3c594a7854.svg?invert_in_darkmode" align=middle width=16.535428799999988pt height=26.76175259999998pt/> is independent of <img src="svgs/4f4f4e395762a3af4575de74c019ebb5.svg?invert_in_darkmode" align=middle width=5.936097749999991pt height=20.221802699999984pt/>, the above relation suggests we might wish to maximize the between-group variance rather than minimizing the within-group one, since we don't need to compute variances in the first one. Further computational savings can be achieved, getting to:
<p align="center"><img src="svgs/b581339a5aeaad2e29f86cd4d2630f4d.svg?invert_in_darkmode" align=middle width=291.6941643pt height=20.611885799999996pt/></p>

  ## Adaptive thresholding

  When the lighting isn't uniform, a spatially varying threshold should be adopted. Tipically, adaptive methods compute a specific threshold at each image pixel, based on the intensities within a small neighbourhood. However, too small a neighbourhood might lack either background or foreground pixels, which sould imply segmentation errors unless the issue is dealt with explicitly. For the sake of efficiency, we tipically adopt simple operators on each pixel, like the mean or the median. 

  ### Color-based segmentation

  This is another frequent technique. We don't tend to use color that much in CV (often it does not bring additional information wrt the additional cost). Sometimes we can segmentize object from the background basing on the color: we know the object and the background have a very different color. It is often the case that the user would be allowed to control the color of the background, choosing one that is different from the one in the foreground, like blue or green (the infamous *green screen*). For example, in the food industry, it is quite usual to use blue conveyor belts, since food is unlikely to be blue. We can denote the pixel intensity as a matrix in RGB: <img src="svgs/2a6766d3d7d2f3c6ece3f1f405ad9003.svg?invert_in_darkmode" align=middle width=125.77571325pt height=67.39784699999998pt/> .

  Then, segmentation can be achieved by computing and thresholding the distance between the pixel's colour and the reference background colour <img src="svgs/07617f9d8fe48b4a7b3f523d6730eef0.svg?invert_in_darkmode" align=middle width=9.90492359999999pt height=14.15524440000002pt/>.
<p align="center"><img src="svgs/91e3e6fbdc70ff8bfdb9bf07c64d1e5c.svg?invert_in_darkmode" align=middle width=276.05785679999997pt height=39.452455349999994pt/></p>

<p align="center"><img src="svgs/80ae970d8ddc738a5de29d58f138d477.svg?invert_in_darkmode" align=middle width=436.18321890000004pt height=35.23975455pt/></p>

  How can we **estimate the reference colour**? This is tipically done by taking some training images, then estimating it, for example by taking pixels, then taking their mean:
<p align="center"><img src="svgs/5783590c4597d91266b39b8325277cc6.svg?invert_in_darkmode" align=middle width=198.76736055pt height=59.1786591pt/></p>
We consider a threshold of color, then whatever color appears in the circle is part of the background, whatever is out of it is not.

![Color threshold in the RGB plot](./res/color_threshold.png)

It may happen that there's more variation along one axis or the other (i.e. the circle has to be *kind of oval*).

In such a case, the error we end up with is pretty high. ![Wrong color threshold](./res/color-threshold-wrong.png)

To create a *oval* threshold, we can use a slightly more complex approach, based into taking into account not only the mean, but also next order statistics, the *covariance* (not the variance because we have a multivariate random vector).

Another kind of distance (different from this *Euclidean distance*) is frequently used. *We'll discover that in the next episode.*

## Mahalanobis distance

A far richer probabilistic characterization of the colour distribution among the foreground pixels can be obtained by estimating the covariance too:
<p align="center"><img src="svgs/f5ac67a089d1edfb8233a9305932cef9.svg?invert_in_darkmode" align=middle width=558.41693985pt height=61.08431175pt/></p>
In this way, we capture the correlation between channels too. The covariance matrix is symmetric. To go from the plain euclidean distance, we add the inverse of <img src="svgs/813cd865c037c89fcdc609b25c465a05.svg?invert_in_darkmode" align=middle width=11.87217899999999pt height=22.465723500000017pt/>, the covariance matrix:
<p align="center"><img src="svgs/b057624f235504b16186c3b94419c549.svg?invert_in_darkmode" align=middle width=322.7552394pt height=24.9700737pt/></p>

### Understanding the difference between Euclidean and Mahalanobis

To understand the difference between the two distances, let's for now assume that the convariance matrix is diagonal (this isn't true, actually). This means that the data are not correlated. Computing the inverse of this is easy:
<p align="center"><img src="svgs/60493a25c86a20d480b43ca65d5e1a0f.svg?invert_in_darkmode" align=middle width=496.74760409999993pt height=59.1786591pt/></p>
Therefore, we can multiply the last two terms of the distance <img src="svgs/d83459ae2b58d0a615f9b05f19dad6f0.svg?invert_in_darkmode" align=middle width=101.87415149999998pt height=26.76175259999998pt/> getting <img src="svgs/4ccae7798f098e33815edf88e83acde2.svg?invert_in_darkmode" align=middle width=159.54125219999997pt height=67.39784699999998pt/>.

Finally, we get:
<p align="center"><img src="svgs/6f431fa36b54a46bac300c7247090b17.svg?invert_in_darkmode" align=middle width=469.00289204999996pt height=54.96598305pt/></p>
  Contrary to the euclidean distance, the Mahalanobis distance weighs the differences along the components of the random vector differently. In particular, they are weighted according to the inverse proportionality to the learned variances. 

Now, which region of the RGB space determines the segmentation? ![Which region determines the segmentation?](./res/segmentation-rgb-region.png)

This interpretation is of general validity! Indeed, the convariance matrix can always be diagonalized by a rotation of the coordinate axes. Thus, in the new coordinate system, it is a weighted sum of the contribution along the new axes, with weights being inversely proportional to the variances along the new axes. This is due to the *EigenValue Decomposition* (EVD) of any real and symmetric matrix:
<p align="center"><img src="svgs/03ac52353d78196a7c45c47c181b0f35.svg?invert_in_darkmode" align=middle width=391.3477788pt height=59.1786591pt/></p>
Now, there's always a transformation which turns the covariance into a diagonal matrix. This is a rotation to matrix <img src="svgs/552ef540d5e36ad33e07adf8864441a0.svg?invert_in_darkmode" align=middle width=22.14218819999999pt height=27.6567522pt/>. So if we start with the initial data (color pixel), rotate them (in the color space) according to <img src="svgs/552ef540d5e36ad33e07adf8864441a0.svg?invert_in_darkmode" align=middle width=22.14218819999999pt height=27.6567522pt/> we get what we want. 

