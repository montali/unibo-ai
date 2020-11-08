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

We know that if an operator is an LSI (linear/shift-invariant), if the input can be expressed as a weighted sum, it turns out that the output is given by the same weighted sum (the <img src="svgs/31fae8b8b78ebe01cbfbe2fe53832624.svg?invert_in_darkmode" align=middle width=12.210846449999991pt height=14.15524440000002pt/> aren't gonna change) of the responses to the elementary functions shifted by the same quantity. 

This is useful: every signal can be expressed as a weighted sum of elementary functions. More specifically, a sum of displaced unit impulses (dirac delta function):
<p align="center"><img src="svgs/bad10b69df653b6791913f534dda81c0.svg?invert_in_darkmode" align=middle width=343.44768645pt height=41.7812571pt/></p>
We normally have a sum of a certain number of functions <img src="svgs/670e2f572d2d6a18251e96e79b69557c.svg?invert_in_darkmode" align=middle width=14.920167899999992pt height=14.15524440000002pt/>, but now this is an infinite sum. We have this double integral summing across the whole 2D plane. The weights are the <img src="svgs/2c7429b258f9f5c79f93d6b7b5613a0b.svg?invert_in_darkmode" align=middle width=46.49657429999999pt height=24.65753399999998pt/> and not the <img src="svgs/61046e5eadc702c4e6063bccd2508c6f.svg?invert_in_darkmode" align=middle width=19.03453859999999pt height=14.15524440000002pt/> anymore. 

What we can see is that the amount of shift is given by <img src="svgs/a4e80986c12176a9830ef85b8225d816.svg?invert_in_darkmode" align=middle width=28.047932549999988pt height=22.831056599999986pt/>. So, how can we read this formula? This is expressed as impulses which can be located everywhere, and each fo them is multiplied by the value of the function in that position. We are seeing the function as impulses multiplied by the value of the function in the position they are located.

This property (that we can see a function as a weighted sum of weighted impulses) is known as the *sifting property of the unit impulse*.

The output we get if we feed the operator <img src="svgs/2f118ee06d05f3c2d98361d9c30e38ce.svg?invert_in_darkmode" align=middle width=11.889314249999991pt height=22.465723500000017pt/> by the elementary function dirac delta is known as <img src="svgs/2ad9d098b937e46f9f58968551adac57.svg?invert_in_darkmode" align=middle width=9.47111549999999pt height=22.831056599999986pt/>, the **impulse response** or point-spread function: <img src="svgs/de046db701f65a2c918e32c41e427985.svg?invert_in_darkmode" align=middle width=143.91556905pt height=24.65753399999998pt/>.

So, we know that for whatever input signal (every one of them can be expressed in this form) we can get the output of an LSI operator in this form. 
<p align="center"><img src="svgs/2eafe6dfc09bc97526da971fd5fb954d.svg?invert_in_darkmode" align=middle width=441.3396503999999pt height=41.7812571pt/></p>
Now that we've found this formula to compute the output of T, a convolution gets applied. More precisely, since we're working with 2D continuous signals, this is known as a **2D continuous convolution**. 

We often denote the convolution operation by the symbol <img src="svgs/7c74eeb32158ff7c4f67d191b95450fb.svg?invert_in_darkmode" align=middle width=8.219209349999991pt height=15.296829900000011pt/>:
<p align="center"><img src="svgs/0b0770c33efac05f7c59408fc4b834a8.svg?invert_in_darkmode" align=middle width=174.95152125pt height=16.438356pt/></p>
The convolution has some useful properties: the **associative** property (<img src="svgs/9af9313d795c1bde546213c64026ecf9.svg?invert_in_darkmode" align=middle width=165.02613599999998pt height=24.65753399999998pt/>), the **commutative** property (<img src="svgs/6f25feb6b0b8df78c4ec121ff4ccc0ad.svg?invert_in_darkmode" align=middle width=89.4631089pt height=22.831056599999986pt/>), the **distributive** property wrt the sum (<img src="svgs/be6d4c8d934d4cfcceae521290578b37.svg?invert_in_darkmode" align=middle width=186.7155312pt height=24.65753399999998pt/>) and the **convolutional commutes** with differentiation (<img src="svgs/3d9406f8844e6ed53c9d0fcf1a042029.svg?invert_in_darkmode" align=middle width=170.9526192pt height=24.7161288pt/>). The last one is pretty much esoteric but so useful. I want to compute the derivative of <img src="svgs/62b2911d4dc6791b51bb482167dd3406.svg?invert_in_darkmode" align=middle width=33.77275604999999pt height=22.831056599999986pt/> (could be first,second, third...), it is the same as applying that derivation to either one of the two functions.

 A practical interpretation of convolution: for every point in the domain, we're kind of multypling them (by a value linked to the function's value) and adding up all these products.

So, we have two functions <img src="svgs/77a3b857d53fb44e33b53e4c8b68351a.svg?invert_in_darkmode" align=middle width=5.663225699999989pt height=21.68300969999999pt/> and <img src="svgs/2ad9d098b937e46f9f58968551adac57.svg?invert_in_darkmode" align=middle width=9.47111549999999pt height=22.831056599999986pt/> defined in the domain known as *plane <img src="svgs/a4e80986c12176a9830ef85b8225d816.svg?invert_in_darkmode" align=middle width=28.047932549999988pt height=22.831056599999986pt/>*.

The first square is representing the set in the domain <img src="svgs/a4e80986c12176a9830ef85b8225d816.svg?invert_in_darkmode" align=middle width=28.047932549999988pt height=22.831056599999986pt/> in which <img src="svgs/77a3b857d53fb44e33b53e4c8b68351a.svg?invert_in_darkmode" align=middle width=5.663225699999989pt height=21.68300969999999pt/> is non-zero. Then we have <img src="svgs/2ad9d098b937e46f9f58968551adac57.svg?invert_in_darkmode" align=middle width=9.47111549999999pt height=22.831056599999986pt/>, another function which is non-zero in another region. Usually we consider <img src="svgs/77a3b857d53fb44e33b53e4c8b68351a.svg?invert_in_darkmode" align=middle width=5.663225699999989pt height=21.68300969999999pt/> as the input and <img src="svgs/2ad9d098b937e46f9f58968551adac57.svg?invert_in_darkmode" align=middle width=9.47111549999999pt height=22.831056599999986pt/> as the filter: this is why <img src="svgs/2ad9d098b937e46f9f58968551adac57.svg?invert_in_darkmode" align=middle width=9.47111549999999pt height=22.831056599999986pt/> has a smaller square. So, now, <img src="svgs/e2422452ef7d65e15f62276f42bcf94c.svg?invert_in_darkmode" align=middle width=53.33136764999998pt height=22.831056599999986pt/> represent the set of values <img src="svgs/2ad9d098b937e46f9f58968551adac57.svg?invert_in_darkmode" align=middle width=9.47111549999999pt height=22.831056599999986pt/> takes in the four subregions. We said convolution is about multiplying corresponding values, and if we look at <img src="svgs/77a3b857d53fb44e33b53e4c8b68351a.svg?invert_in_darkmode" align=middle width=5.663225699999989pt height=21.68300969999999pt/> in the definition, it appears unchanged, while <img src="svgs/2ad9d098b937e46f9f58968551adac57.svg?invert_in_darkmode" align=middle width=9.47111549999999pt height=22.831056599999986pt/> is not appearing as <img src="svgs/aa4c36432811d98c7222f43955c3954d.svg?invert_in_darkmode" align=middle width=50.30446244999998pt height=24.65753399999998pt/> but is manipulated. We have <img src="svgs/6d0dc6875ab513c603d1c4a402b32106.svg?invert_in_darkmode" align=middle width=75.87532919999998pt height=24.65753399999998pt/>: this means that we're flipping <img src="svgs/2ad9d098b937e46f9f58968551adac57.svg?invert_in_darkmode" align=middle width=9.47111549999999pt height=22.831056599999986pt/> around the origin. <img src="svgs/2ad9d098b937e46f9f58968551adac57.svg?invert_in_darkmode" align=middle width=9.47111549999999pt height=22.831056599999986pt/> not only undergoes a flip, but a shift too by <img src="svgs/0acac2a2d5d05a8394e21a70a71041b4.svg?invert_in_darkmode" align=middle width=25.350096749999988pt height=14.15524440000002pt/>. So, to compute the convolution at <img src="svgs/7392a8cd69b275fa1798ef94c839d2e0.svg?invert_in_darkmode" align=middle width=38.135511149999985pt height=24.65753399999998pt/> we leave <img src="svgs/77a3b857d53fb44e33b53e4c8b68351a.svg?invert_in_darkmode" align=middle width=5.663225699999989pt height=21.68300969999999pt/> unchanged, then pick <img src="svgs/2ad9d098b937e46f9f58968551adac57.svg?invert_in_darkmode" align=middle width=9.47111549999999pt height=22.831056599999986pt/>, reflect it around the origin and shift it at <img src="svgs/0acac2a2d5d05a8394e21a70a71041b4.svg?invert_in_darkmode" align=middle width=25.350096749999988pt height=14.15524440000002pt/>. Then, we multiply them together and sum them.

![Convolution](./res/Convolution.png)

### Correlation

We can introduce the **correlation**:
<p align="center"><img src="svgs/6e997a19333ec01c184bcb2ff9312393.svg?invert_in_darkmode" align=middle width=408.12232064999995pt height=41.7812571pt/></p>
Accordingly, the correlation of <img src="svgs/2ad9d098b937e46f9f58968551adac57.svg?invert_in_darkmode" align=middle width=9.47111549999999pt height=22.831056599999986pt/> vs <img src="svgs/77a3b857d53fb44e33b53e4c8b68351a.svg?invert_in_darkmode" align=middle width=5.663225699999989pt height=21.68300969999999pt/>:
<p align="center"><img src="svgs/f8557662bf3e49fec353635ca1607109.svg?invert_in_darkmode" align=middle width=408.12232064999995pt height=41.7812571pt/></p>
Note that correlation, differently from convolution, **is not commutative**.

Convolution is about flipping and shifting, correlation is about shifting only. In convolution you take <img src="svgs/2ad9d098b937e46f9f58968551adac57.svg?invert_in_darkmode" align=middle width=9.47111549999999pt height=22.831056599999986pt/> flip and shift, in correlation of <img src="svgs/2ad9d098b937e46f9f58968551adac57.svg?invert_in_darkmode" align=middle width=9.47111549999999pt height=22.831056599999986pt/> vs <img src="svgs/77a3b857d53fb44e33b53e4c8b68351a.svg?invert_in_darkmode" align=middle width=5.663225699999989pt height=21.68300969999999pt/> you take <img src="svgs/2ad9d098b937e46f9f58968551adac57.svg?invert_in_darkmode" align=middle width=9.47111549999999pt height=22.831056599999986pt/> and shift it only. Now, because <img src="svgs/2ad9d098b937e46f9f58968551adac57.svg?invert_in_darkmode" align=middle width=9.47111549999999pt height=22.831056599999986pt/> gets reflected in convolution, left unchanged in correlation, there's a special case in which **the two coincide**.

If the function is symmetric around the origin (which often happens), if you flip you don't really change anything!

Let us now consider a discrete 2D KSI operator, <img src="svgs/27cd371f4dfa2c4a5993985661b43389.svg?invert_in_darkmode" align=middle width=32.89395449999999pt height=24.65753399999998pt/>, whose response to the 2D discrete unit impulse (*Kronecker Delta Function*) is denoted as <img src="svgs/4b834623e51e8893a0d7abc37f6e1156.svg?invert_in_darkmode" align=middle width=48.030047999999994pt height=24.65753399999998pt/>.
<p align="center"><img src="svgs/ecc5efbe66047de25ab43f67b4d00be1.svg?invert_in_darkmode" align=middle width=405.69724634999994pt height=39.452455349999994pt/></p>
In imag processing both the input and impulse are stored into matrices of given sizes. Conceptually, we need to slide the kernel across the whole image to compute the new intensity at each pixel, without overwriting the input matrix.

## Mean Filter

Mean filtering is the simplest way to carry out an image smoothing (i.e. a low-pass filtering). Note that the notion of frequency in images is applicable (Fourier's theory). When you low-pass a signal, remind that high frequencies are responsible for rapid changes in the signal, so the signal will be smoother. This is foten aimed at image denoising, though sometimes the purpose is to just cancel out small-size unwanted details that might hinder the image analysis task. 

Note that noise is usually in the high frequencies!

Another reason to perform smoothing is to create a so-called *scale-space*, which is a representation made of multiple images, smoothed by larger and larger filters, used, for example, to recognize objects.

Scale is the term used to denote *size in the image*: a small scale object occupies a small portion of the image.

The mean filter just **replaces each pixel intensity by the average intensity over a given neighbourhood**.

Formally, a mean filter is an LSI operator, but in practice we can just compute the mean. We can use **box filtering** to efficiently compute the mean by incremental calculation. 

In box filtering, we proceed adding a column and removing another one. Calling these columns <img src="svgs/7dbb6bcd9bd21cd359e11736bf1f3c80.svg?invert_in_darkmode" align=middle width=23.33340404999999pt height=26.17730939999998pt/> and <img src="svgs/da0092545def177ce5d33bac35a67325.svg?invert_in_darkmode" align=middle width=23.516052449999986pt height=26.17730939999998pt/>. So, when we compute the sum, given the sum at position <img src="svgs/4fe48dde86ac2d37419f0b35d57ac460.svg?invert_in_darkmode" align=middle width=20.679527549999985pt height=21.68300969999999pt/>, we simply add a column's sum and subtract the other one. Doing that from scratch, we would need <img src="svgs/fef58e24166ee139d0143d7c3ebc0bd9.svg?invert_in_darkmode" align=middle width=64.94295224999999pt height=26.76175259999998pt/> computations, resulting in a complexity of <img src="svgs/44e278b8dbcb11e1871a562fb2ca4542.svg?invert_in_darkmode" align=middle width=42.77869529999999pt height=26.76175259999998pt/>, while using box filtering results in a complexity of <img src="svgs/e550bf3f9bc0881caf6d4f5d3b9d3842.svg?invert_in_darkmode" align=middle width=35.40423644999999pt height=24.65753399999998pt/>:
<p align="center"><img src="svgs/10fe07fd32271fe3a63e0c34e0bb1cea.svg?invert_in_darkmode" align=middle width=344.79527939999997pt height=18.0201615pt/></p>
![Gaussian noise](./res/gaussian-noise.png)

![Impulse noise](./res/impulse-image.png)

The latter is sometimes called *salt and pepper noise*, being built by adding outliers.

## Gaussian filter

This is the **best filter** among the linear operators. It's the most widespread for smoothing operations.

It's a filter whose kernel is a **Gaussian function**. Since we're dealing with 2D signals, this will be a 2D Gaussian. 

![Gaussian function](./res/gaussian-function.png)

Note that a 2D Gaussian is just the product of 2 Gaussians along x and y.

The larger the <img src="svgs/8cda31ed38c6d59d14ebefa440099572.svg?invert_in_darkmode" align=middle width=9.98290094999999pt height=14.15524440000002pt/>, the stronger is the smoothing filter. This can be understood by observing that as <img src="svgs/8cda31ed38c6d59d14ebefa440099572.svg?invert_in_darkmode" align=middle width=9.98290094999999pt height=14.15524440000002pt/> increases, the weights of closer points get smaller while those of farther points become larger.

Another way of proving this is computing the Fourier transform, which is another Gaussian with sigma <img src="svgs/ad07c3b182678c5cb7d12d536560c8af.svg?invert_in_darkmode" align=middle width=67.24809794999999pt height=24.65753399999998pt/>, meaning that the higher the <img src="svgs/8cda31ed38c6d59d14ebefa440099572.svg?invert_in_darkmode" align=middle width=9.98290094999999pt height=14.15524440000002pt/> the narrower the bandwidth of the filter.

If the Gaussian is large in the signal domain, it shall be narrow in the Fourier domain, and vice versa. 

The Gaussian is more effective than the Mean filter, as the frequency response of the former is monotonically decreasing, while the latter exihibits significant ripple.

The discrete Gaussian kernel can be obtained by sampling the corresponding continuous function, which is however of infinite extent. A finite size must therefore be properly chosen. 

Sigma is what decides how many coefficients we need for a precise approximation of the continuous filter: the larger the size of the kernel, the more accurate the approximaiton. Note that the computational cost rises with filter size, and the gaussian gets smaller when we move away from the origin. Therefore, we can use a *rule of thumb*: it is ok if we use a <img src="svgs/63bb9849783d01d91403bc9a5fea12a2.svg?invert_in_darkmode" align=middle width=9.075367949999992pt height=22.831056599999986pt/> (size of the kernel, <img src="svgs/fc30db31d93b89eaf5fc5090968e634a.svg?invert_in_darkmode" align=middle width=45.60497204999999pt height=22.831056599999986pt/> squared for 2D) equal to <img src="svgs/037fb401cd64687d6b68dca59f77dadb.svg?invert_in_darkmode" align=middle width=18.202110299999987pt height=21.18721440000001pt/>. 

It may be convenient/mandatory to convolve the image by an integer rather than floating point kernel. 

An integer Gaussian kernel can be obtained by dividing all coefficients by the smallest one, rounding to the nearest integer and finally normalizing by the sum of the integer coefficients. 

Another important thing is how we can make the filter faster. We can deploy the separability property, due to the 2D Gaussian being the product of 2 1D Gaussians, the original 2D convolution can be split into the chain of two 1D convolutions, i.e. either along x first and then along y.

## Median filter

This is a **non-linear** filter where each pixel intensity is replaced by th median over a neighbourhood, the median being the value falling half-way in the sorted set of intensities (*50-th percentile*).

This is able to deal with impulse noise too, without introducing significant blur. Yet, gaussian like noise can't be solved with a median filter.

## Bilateral filter

This is an advanced non-linear filter to accomplish the denoising of Gaussian-like noise without blurring the image: **edge preserving smoothing**. It basically only denoises the noisy areas.

Let's start with an example. Let's say we had a filter built like this:

![Bilateral filter](./res/bilateral-filter.png)

A bilateral filter would smooth the *step*. 

The function of the filter is the product of two Gaussian functions:![Screenshot 2020-11-06 at 14.38.19](/Users/simone/UniBO/unibo-ai/Computer Vision/res/bilinear-fomrula.png)

where <img src="svgs/4ab2481d9106644aa2e5c96abf7a3f5c.svg?invert_in_darkmode" align=middle width=15.01341104999999pt height=22.831056599999986pt/> is the distance between intensities, which is large only for those pixels <img src="svgs/d5c18a8ca1894fd3a7d25f242cbe8890.svg?invert_in_darkmode" align=middle width=7.928106449999989pt height=14.15524440000002pt/> such that <img src="svgs/8a92ec65f5e20227f5a41adda70d26d0.svg?invert_in_darkmode" align=middle width=13.66388759999999pt height=22.465723500000017pt/> is near to <img src="svgs/336cf683005129257f2753915c5f3974.svg?invert_in_darkmode" align=middle width=14.00252864999999pt height=22.465723500000017pt/>.

We want the filter to have a unitary gain, so if we multiply two gaussians, we get that all the coefficients have to be normalized by the sum of all the coefficients. 

The bilateral filter is not super-fast: it is computationally pretty heavy. 

### Non-local means filter

This is a more recent *edge preserving smoothing filter*, based on the key idea that the similarityamong parches spread over the image can be deployed to achieve denoising.

How large is the computational complexity of this? If we have <img src="svgs/55a049b8f161ae7cfeb0197d75aff967.svg?invert_in_darkmode" align=middle width=9.86687624999999pt height=14.15524440000002pt/> pixels, we'll get a complexity of <img src="svgs/021273d50c6ff03efebda428e9e42d77.svg?invert_in_darkmode" align=middle width=16.41942389999999pt height=26.76175259999998pt/>: for each pixel, we have to take a weighted sum of all the other pixels in the image.

