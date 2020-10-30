# Intensity transformations

We want to improve an image so that it becomes easier to analyze for CV.

We'll not go over too many image processing techniques. Intensity transformation are image processing operators aimed at enhancing the quality (the contrast) of the image. At most such operators rely on the computation of the gray-level histogram of the input image, we start by defining this useful function. The gray-level histogram of ani mage is simply a function associating to each gray-level the number of pixels in the image taking that level. 

Computing the histogram is straightforward: we define a vector <img src="svgs/7b9a0316a2fcd7f01cfd556eedf72e96.svg?invert_in_darkmode" align=middle width=14.99998994999999pt height=22.465723500000017pt/> having as many elements as the number of grayscale levels, then scan the image to increment the element of the vector corresponding to the level of the pixel.

These are operators that modify the histogram to improve the quality of the image. The intensity of a pixel in the output is computed only basing on its intensity in the input. It's just a mapping function from a gray level to another one.

### Thresholding operator

An example of this is the **thresholding operator**, where we can set a threshold graylevel and set to black all the intensities under that threshold and to white everything over that.

This is used to get ultra simple images, maybe to get objects.

These operators can be implemented as a LookUp Table, which is often convenient.

We can formalize these intensity transformations as follows:

<img src="svgs/f667e402671b2523c186aaf468e932be.svg?invert_in_darkmode" align=middle width=272.26293269999996pt height=47.6716218pt/> 

So, apart from thresholding, we can cite linear contrast stretching. Now, we don't know anything about the content of the image, but from the histogram we can get an approximate quality determination. For example, we can check if the full range of grayscales is present: the contrast may not be good.

So, if we *stretch* the graylevel range, we should improve the contrast. 

We are spreading noise too, but we'll not deal with this now.

<img src="svgs/f41af4107023513ce063a4e66c219bc1.svg?invert_in_darkmode" align=middle width=345.24309105pt height=51.33464490000001pt/>

The second equation is the most common formulation, where we remap the range into the whole range.

If the histogram is stretched but with a peak, it is kind of useless (minimum around 0 maximum around 255). Therefore, it needs a peak only with no *tails*. To solve this, we can apply the linear contrast stretching by using percentiles instead of min and max.

### Exponential operator

Until now, we treated all the pixels the same way, but working on the interesting area only might be useful.

This can be done with non-linear operators, like the **exponential** (aka gamma correction), where fiven <img src="svgs/deceeaf6940a8c7a5a02373728002b0f.svg?invert_in_darkmode" align=middle width=8.649225749999989pt height=14.15524440000002pt/> the output and <img src="svgs/332cc365a4987aacce0ead01b8bdcc0b.svg?invert_in_darkmode" align=middle width=9.39498779999999pt height=14.15524440000002pt/> the input graylevel, we compute <img src="svgs/7a7e7ce011577e48679ff929f98fad82.svg?invert_in_darkmode" align=middle width=46.41927344999999pt height=21.839370299999988pt/> with <img src="svgs/739ee6999fd26ee3d6eefc4888a41d39.svg?invert_in_darkmode" align=middle width=216.35427330000002pt height=24.65753399999998pt/> where we increase contrast in bright areas if <img src="svgs/d186406072bfb64fe9974804fa2f41c5.svg?invert_in_darkmode" align=middle width=38.009795999999994pt height=21.18721440000001pt/> in dark areas if <img src="svgs/142a8172dc1024dc37aa398adff66236.svg?invert_in_darkmode" align=middle width=38.009795999999994pt height=21.18721440000001pt/>.

Now, if for example we had the range <img src="svgs/358d4d0949e47523757b4bc797ab597e.svg?invert_in_darkmode" align=middle width=21.00464354999999pt height=21.18721440000001pt/> with <img src="svgs/8d361665b71fb69d7bb2eac977fde7ac.svg?invert_in_darkmode" align=middle width=59.01443789999998pt height=21.18721440000001pt/>, which gets the darkest area a higher contrast, while the brighter ones are going to be squeezed into a smaller range.

The formula, with typical levels becomes <img src="svgs/5e77f102d504e16f4a6cfb96b9fd3b18.svg?invert_in_darkmode" align=middle width=95.1827613pt height=26.76175259999998pt/>.

The operator is called gamma correction because in the past it was used in CRT monitors, which resulted in an exponential operator of gamma <img src="svgs/e3215d9b11087aa1771302e80cc5235d.svg?invert_in_darkmode" align=middle width=38.35617554999999pt height=21.18721440000001pt/>, so they used a negative gamma as countermeasure.

### Histogram equalization

This is the most known operator. It uniformly spreads pixel intensities aceoss the whole available range, which usually improves the contrast. Why do we do this? **Improving the contrast, not flatting the histogram**. Unlike linear stretching, which requires manual intervention to set min and max, this one works automatically.

To find the mapping, considering a continuous variable x and a strictlt monotonically increasing function T:

![HE](/Users/simone/UniBO/unibo-ai/Computer Vision/res/HE.png)



The goal is turning the histogram into a flat one, using the theory of random variables. We know that there's a link between the PDF and the graylevel histogram.

Now, denoting as <img src="svgs/663451bb32d00406e2470cdc667b0364.svg?invert_in_darkmode" align=middle width=19.94529239999999pt height=14.15524440000002pt/> the PDF of x and <img src="svgs/2086b7841a7e68b492647310c5c50c6e.svg?invert_in_darkmode" align=middle width=18.82887434999999pt height=14.15524440000002pt/> the PDF of y, as <img src="svgs/2f118ee06d05f3c2d98361d9c30e38ce.svg?invert_in_darkmode" align=middle width=11.889314249999991pt height=22.465723500000017pt/> is monotonically increasing:

<img src="svgs/2c17ff3261b666cc35f4f350e3699dce.svg?invert_in_darkmode" align=middle width=293.2203846pt height=44.71244909999998pt/>

We take an infinitesimal interval of x, <img src="svgs/0c13cecb2885fd60177b46a9225b4dba.svg?invert_in_darkmode" align=middle width=47.437130399999994pt height=22.831056599999986pt/> mapping to <img src="svgs/33a736677b0cc65370e3af22e687836e.svg?invert_in_darkmode" align=middle width=45.94558649999998pt height=22.831056599999986pt/>. What if we pick any <img src="svgs/d0e77e0ae0c927639bbf59b3dd1c524b.svg?invert_in_darkmode" align=middle width=9.39498779999999pt height=21.95701200000001pt/> in the interval? Due to T monotonically increasing, we know that it is in the interval. So, the relation between the probabilities of RV x and y in the interval, we know that the probability of x being in the interval is the same.

So, the probability is <img src="svgs/aa7d2b7648a5ed4454e5b83a36e42da5.svg?invert_in_darkmode" align=middle width=189.54557654999996pt height=28.26507089999998pt/> and if we take an infinitesimal interval we can establish this relationship between these two probabilities: the probability of x and y to belong to their infinitesimal intervals is exactly the same, which allows deriving the pdf of y as a function of T and the pdf of x:

<img src="svgs/225ad42fbae7b3140cf2943f6630e01e.svg?invert_in_darkmode" align=middle width=273.49995914999994pt height=28.92634470000001pt/>

Note that <img src="svgs/bf8cd12607af3b4d947a29deb5cc1a4a.svg?invert_in_darkmode" align=middle width=14.297449649999997pt height=28.92634470000001pt/> is the derivative of the inverse function : <img src="svgs/4c71b54937500110cff82ae399974342.svg?invert_in_darkmode" align=middle width=82.28502644999999pt height=26.76175259999998pt/>.

Now, what kind of function T should we use if we want a uniform result? We choose the **Cumulative Distribution Function CDF**, which is guaranteed to map into <img src="svgs/acf5ce819219b95070be2dbeb8a671e9.svg?invert_in_darkmode" align=middle width=32.87674994999999pt height=24.65753399999998pt/> and be monotonically increasing:

<img src="svgs/021a9d0845dc726d65cf75a19035928d.svg?invert_in_darkmode" align=middle width=162.31345019999998pt height=28.26507089999998pt/>

So, our previous relationship now becomes

<img src="svgs/9193ddd655751ecd0dfb182cee7f6f31.svg?invert_in_darkmode" align=middle width=304.16317305pt height=33.20539859999999pt/>

Now, if T is that function, its derivative is exactly the PDF <img src="svgs/b6f959924c0344acfabaec3406cb85ed.svg?invert_in_darkmode" align=middle width=42.94761074999999pt height=24.65753399999998pt/> getting to <img src="svgs/034d0a6be0424bffe9a6e7ac9236c0f5.svg?invert_in_darkmode" align=middle width=8.219209349999991pt height=21.18721440000001pt/>. We got a RV whose PDF is always 1, therefore a **uniform random variable**.

We have thus found that by mapping any continuous random variable through its cdf we obtain a uniformly distributed random variable. Now, how can we use this to equalize an image?

We proceed by discretizing the previous result, i.e. by considering the cumulative PMF of the discrete RV associated with the graylevel of a pixel, whose PMF is given by the normalized histogram.

<img src="svgs/b621e83319c4a85cc0bed844ab32e37e.svg?invert_in_darkmode" align=middle width=559.1250093pt height=57.53473439999999pt/>

# Spatial filtering

So, these operators are sometimes called  **local operators**. We now compute the output basing on the input pixel as before, **and its neighbourhood** (aka support of the pixel).

We use these for **denoising** and **sharpening**.

An important subclass is called **linear shift-invariant** operators, which we'll consider first.

## Linear shift-invariant operators (LSI)

Straightforward extension of 1D signal theory dictates their application to consist in **2D convolution** between the input image and the impulse response function (*point spread function* or *kernel*, i.e. the output of the pixel when the input is an impulse) of the LSI.

### Convolutions

First of all, considering a 2D signal <img src="svgs/566968b8d54359aa6ed106ac81021be3.svg?invert_in_darkmode" align=middle width=43.79873684999999pt height=24.65753399999998pt/> let's call an operator <img src="svgs/2f118ee06d05f3c2d98361d9c30e38ce.svg?invert_in_darkmode" align=middle width=11.889314249999991pt height=22.465723500000017pt/> which generates the output signal. T is linear iff <img src="svgs/d9c4ecef0c439d3b62a751609d836a59.svg?invert_in_darkmode" align=middle width=624.4620755999999pt height=24.65753399999998pt/>.

If the input is a weighted sum of signals, the output is too.

Shift invariance is defined as: <img src="svgs/1c30808984ab00f14c649d6dcd0ee20d.svg?invert_in_darkmode" align=middle width=293.13798854999993pt height=24.65753399999998pt/> so what we get is the same shift in the output as in the input.

Let us now assume <img src="svgs/1d5a294fbf0372fa6581a0237d39475e.svg?invert_in_darkmode" align=middle width=244.18201335pt height=24.657735299999988pt/> and pose <img src="svgs/e28e729c70f8a95f9f921241523e0a2d.svg?invert_in_darkmode" align=middle width=120.98946914999998pt height=24.65753399999998pt/> which is the output of the operator when the input is <img src="svgs/670e2f572d2d6a18251e96e79b69557c.svg?invert_in_darkmode" align=middle width=14.920167899999992pt height=14.15524440000002pt/>.

Due to the two properties, the output is the same weighted sum, shifted.

<img src="svgs/ca2102870a8cde119a3ec4d52c54daad.svg?invert_in_darkmode" align=middle width=285.9045882pt height=148.90476479999998pt/>

If the input is a weighted sum of displaced elementary functinos, the output is given by the same weighted sum of the displaced responses to elementary functions.







