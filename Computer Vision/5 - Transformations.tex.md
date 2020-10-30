# Intensity transformations

We want to improve an image so that it becomes easier to analyze for CV.

We'll not go over too many image processing techniques. Intensity transformation are image processing operators aimed at enhancing the quality (the contrast) of the image. At most such operators rely on the computation of the gray-level histogram of the input image, we start by defining this useful function. The gray-level histogram of ani mage is simply a function associating to each gray-level the number of pixels in the image taking that level. 

Computing the histogram is straightforward: we define a vector $H$ having as many elements as the number of grayscale levels, then scan the image to increment the element of the vector corresponding to the level of the pixel.

These are operators that modify the histogram to improve the quality of the image. The intensity of a pixel in the output is computed only basing on its intensity in the input. It's just a mapping function from a gray level to another one.

### Thresholding operator

An example of this is the **thresholding operator**, where we can set a threshold graylevel and set to black all the intensities under that threshold and to white everything over that.

This is used to get ultra simple images, maybe to get objects.

These operators can be implemented as a LookUp Table, which is often convenient.

We can formalize these intensity transformations as follows:

$\mathbf{p}=\left[\begin{array}{l}
u \\
v
\end{array}\right], \forall \mathbf{p} \in \mathbf{I}: \mathbf{o}[\mathbf{p}]=\mathbf{L} \mathbf{U} \mathbf{T}[\mathbf{I}[\mathbf{p}]]$ 

So, apart from thresholding, we can cite linear contrast stretching. Now, we don't know anything about the content of the image, but from the histogram we can get an approximate quality determination. For example, we can check if the full range of grayscales is present: the contrast may not be good.

So, if we *stretch* the graylevel range, we should improve the contrast. 

We are spreading noise too, but we'll not deal with this now.

$\begin{array}{c}
s=\frac{s_{\max }-S_{\min }}{r_{\max }-r_{\min }}\left(r-r_{\min }\right)+s_{\min } \\
S_{\min }=0, s_{\max }=255 \rightarrow s=\frac{255}{r_{\max }-r_{\min }}\left(r-r_{\min }\right)
\end{array}$

The second equation is the most common formulation, where we remap the range into the whole range.

If the histogram is stretched but with a peak, it is kind of useless (minimum around 0 maximum around 255). Therefore, it needs a peak only with no *tails*. To solve this, we can apply the linear contrast stretching by using percentiles instead of min and max.

### Exponential operator

Until now, we treated all the pixels the same way, but working on the interesting area only might be useful.

This can be done with non-linear operators, like the **exponential** (aka gamma correction), where fiven $y$ the output and $x$ the input graylevel, we compute $y=x^r$ with $x=[0,1], r=0.25,0.5,2,4,\dots$ where we increase contrast in bright areas if $r>1$ in dark areas if $r<1$.

Now, if for example we had the range $0.2$ with $r=0.25$, which gets the darkest area a higher contrast, while the brighter ones are going to be squeezed into a smaller range.

The formula, with typical levels becomes $y=255^{1-r} x^{r}$.

The operator is called gamma correction because in the past it was used in CRT monitors, which resulted in an exponential operator of gamma $ \approx 2.2$, so they used a negative gamma as countermeasure.

### Histogram equalization

This is the most known operator. It uniformly spreads pixel intensities aceoss the whole available range, which usually improves the contrast. Why do we do this? **Improving the contrast, not flatting the histogram**. Unlike linear stretching, which requires manual intervention to set min and max, this one works automatically.

To find the mapping, considering a continuous variable x and a strictlt monotonically increasing function T:

![HE](/Users/simone/UniBO/unibo-ai/Computer Vision/res/HE.png)



The goal is turning the histogram into a flat one, using the theory of random variables. We know that there's a link between the PDF and the graylevel histogram.

Now, denoting as $p_X$ the PDF of x and $p_Y$ the PDF of y, as $T$ is monotonically increasing:

$\begin{array}{l}
\forall \tilde{x} \in[x, x+d x] \rightarrow \tilde{y}=T(\widetilde{x}) \in[y, y+d y] \\
\text {with } y=T(x), y+d y=T(x+d x)
\end{array}$

We take an infinitesimal interval of x, $x+dx$ mapping to $y+dy$. What if we pick any $\tilde{x}$ in the interval? Due to T monotonically increasing, we know that it is in the interval. So, the relation between the probabilities of RV x and y in the interval, we know that the probability of x being in the interval is the same.

So, the probability is $p(x \in [x_1,x_2]) = \int_{x_1}^{x_2} p_Xdx$ and if we take an infinitesimal interval we can establish this relationship between these two probabilities: the probability of x and y to belong to their infinitesimal intervals is exactly the same, which allows deriving the pdf of y as a function of T and the pdf of x:

$p_{y}(y) d y=p_{x}(x) d x \rightarrow p_{y}(y)=p_{x}(x) \frac{d x}{d y}$

Note that $\frac{dx}{dy}$ is the derivative of the inverse function : $x=T ^{-1}(y)$.

Now, what kind of function T should we use if we want a uniform result? We choose the **Cumulative Distribution Function CDF**, which is guaranteed to map into $[0,1]$ and be monotonically increasing:

$y=T(x)=\int_{0}^{x} p_{x}(\xi) d \xi$

So, our previous relationship now becomes

$p_{y}(y)=p_{x}(x) \frac{d x}{d y}=p_{x}(x) \frac{1}{\mathrm{dy} / \mathrm{dx}}=\frac{p_{x}(x)}{p_{x}(x)}=1$

Now, if T is that function, its derivative is exactly the PDF $p_X(x)$ getting to $1$. We got a RV whose PDF is always 1, therefore a **uniform random variable**.

We have thus found that by mapping any continuous random variable through its cdf we obtain a uniformly distributed random variable. Now, how can we use this to equalize an image?

We proceed by discretizing the previous result, i.e. by considering the cumulative PMF of the discrete RV associated with the graylevel of a pixel, whose PMF is given by the normalized histogram.

$\left\{\begin{array}{l}
N=\sum_{i=0}^{L-1} h(i) \\
\mathrm{p}(\mathrm{i})=\frac{h(i)}{N} \rightarrow j=T(i)=\sum_{k=0}^{i} p(k)=\frac{1}{N} \sum_{k=0}^{i} h(k) \rightarrow j=\frac{L-1}{N} \sum_{k=0}^{i} h(k) \\
\end{array}\right.$

# Spatial filtering

So, these operators are sometimes called  **local operators**. We now compute the output basing on the input pixel as before, **and its neighbourhood** (aka support of the pixel).

We use these for **denoising** and **sharpening**.

An important subclass is called **linear shift-invariant** operators, which we'll consider first.

## Linear shift-invariant operators (LSI)

Straightforward extension of 1D signal theory dictates their application to consist in **2D convolution** between the input image and the impulse response function (*point spread function* or *kernel*, i.e. the output of the pixel when the input is an impulse) of the LSI.

### Convolutions

First of all, considering a 2D signal $i(x,y)$ let's call an operator $T$ which generates the output signal. T is linear iff $T\left\{a i_{1}(x, y)+b i_{2}(x, y)\right\}=a o_{1}(x, y)+b o_{2}(x, y), \text { with } o_{1}(\cdot)=\sigma\left\{i_{1}(\cdot)\right\}, o_{2}(\cdot)=T\left\{i_{2}(\cdot)\right\}$.

If the input is a weighted sum of signals, the output is too.

Shift invariance is defined as: $T\left\{i\left(x-x_{0}, y-y_{0}\right)\right\}=o\left(x-x_{0}, y-y_{0}\right)$ so what we get is the same shift in the output as in the input.

Let us now assume $i(x, y)=\sum_{k} w_{k} e_{k}\left(x-x_{k}, y-y_{k}\right)$ and pose $h_{k}(\cdot)=T\left\{e_{k}(\cdot)\right\}$ which is the output of the operator when the input is $e_k$.

Due to the two properties, the output is the same weighted sum, shifted.

$\begin{aligned}
o(x, y) &=T\left\{\sum_{k} w_{k} e_{k}\left(x-x_{k}, y-y_{k}\right)\right\} \\
&=\sum_{k} w_{k} T\left\{e_{k}\left(x-x_{k}, y-y_{k}\right)\right\} \\
&=\sum_{k} w_{k} h_{k}\left(x-x_{k}, y-y_{k}\right)
\end{aligned}$

If the input is a weighted sum of displaced elementary functinos, the output is given by the same weighted sum of the displaced responses to elementary functions.







