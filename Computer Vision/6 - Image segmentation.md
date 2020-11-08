# Image segmentation

Denoted as <img src="svgs/a5f650818067f71d246340fa29b0f874.svg?invert_in_darkmode" align=middle width=50.97228344999999pt height=24.65753399999998pt/>, a vector-valued function encoding a set of image properties, teh goal of segmentation is to partition the image into disjoint homogeneous regions according to <img src="svgs/df5a289587a2f0247a5b97c1e8ac58ca.svg?invert_in_darkmode" align=middle width=12.83677559999999pt height=22.465723500000017pt/>.

Typically, a good segmentation should preserve spatial proximity (i.e. two nearby pixels must belong to the same region unless they exhibit significantly different <img src="svgs/df5a289587a2f0247a5b97c1e8ac58ca.svg?invert_in_darkmode" align=middle width=12.83677559999999pt height=22.465723500000017pt/> values). In maany CV tasks, segmentation brings in key semantic knowledge in th scene. 

In many cases, we work with *inherently binary images*, meaning that clearly, in the given image, there's two regions, one being dark and one being clear. 

The first step is to just perform this **binarization**.

Inherently binary images exhibit a clearly bimodal gray-level histogram, with two well-separated peals corresponding to foreground and background pixels. Therefore, binarization can be achieved straightforwardly by means of a thresholding operator deploying a suitably chosen threshold:

![Binarization](./res/binarization.png)

How do we pick the threshold? We simply can look at the histogram.

