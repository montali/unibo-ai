# Local invariant features

The term *feature* actually hides lots of meanings in CV. They might be properties, special pixels in the image, and so on. There's another kind of features we can find, properties we can use to perform inavariant object detection, i.e. translation, rotation and scale changes (i.e. the most difficult ones).

So, nonetheless, we'll start with an often heard statement in CV: *correspondences are everything*. 

What we mean by ***correspondences***? Given two or more images of the same scene, then corresponding points are image points that correspond to the same scene points. This process is also known as *wide baseline stereo*, meaning that there's a wide difference.

For example, this may become useful for *mosaicing*, aiming to merge two images to form a **panoramic image** by finding correspondences between the different individual images. To do so, we may align by estimating a homography, which requires at least 4 correspondences. We try to find the *salient points*, computing a local *description*. Each pixel has basically 3 numbers (comparing the RGB color). In most practical cases this algorithm would work even on grayscale images. We can't really use a single pixel! What we do will therefore be not considering a single pixel, rather a patch of them, a neighbourhood. After finding these salient points, we compute a *local description*, a fraction of a patch around the point, which in literature is called a **descriptor** of the key point, being a function of the neighbourhood around the point. 

So, if we call $p$ a point, then $N(p)$ the patch around a point, when trying to establish correspondences, we compute its descriptor, i.e. a function $f(N(p))$ and we'll compare the descriptor at $p$ with the descriptor at $p'$ using the same function.

So, we do not directly compare patches, rather we compare descriptors, i.e. functions of patches. What are these descriptors? We want to find a function that factors out changes and keeps the essence of the patch. Is this magic? Kind of. 

We divide the task into what the **detector** has to do (i.e. finding the keypoints) and what the **descriptor** has to do.

The detector should be able to find the **same keypoints** in **different views** of the scene, and should find keypoints which are surrounded by informative patterns of intensities.

The descriptor should be repeatable, i.e. the descriptions provided at homologous points should be similar, distinctive, i.e. it should capture the salient information around a key point (so, what is really important should be kept, and what it isn't is not, the more we compress the more informations we lose), and compact, i.e. it should be as concise as possible to minimize memory occupancy.

Speed is desirable for both, particularly for detectors, which need to be run on the whole image. 

As always, we have a tradeoff between false positives and true positives.
$$
\text { Recall }=\frac{T P}{P} ; \quad \text { Precision }=\frac{T P}{T P+F P}
$$
 So, what kind of points should we look for to build a lcoal invariant feature pipeline? What kind of local feature are we able to find now? Just edges. Are edges useful? They are! The cool thing is that if you have an edge, you have a direction along it stays. What should we do to avoid this? As an edge, we have a strong variation perpendicularly to it, no variation parallelly. So, if we have a high variation along as many directions as possible, we are in the most interesting points!

Moravec proposed the follwonig: I pick a patch around the interesting point, maybe a 7x7 one (should be a small size). Then, I want to compute the *interestingness of a point*, i.e. how much that point *is a corner*. How do I compute such *cornerness* function? I consider another patch , which is tha latter shifted by some pixels, and compare those. If the point is interesting, these two patches should be pretty different. So, we can compute a pixelwise difference between these two patches. 
$$
C=\min \left\{\sum_{i, j \in w}(I(i+m, j+n)-I(i, j))^{2}\right\} ; m, n \in\{-1,0,1\}, \neq(0,0)
$$


- For a point in a **uniform** area, all patches around it are the same, so $C$ is small;
- For a point in an **edge**, the change along the edge direction is small, so $C$ is small;
- In a **corner**, we have significant change in every direction: $C$ is big!

This function which compares patches is called *error function*, i.e. the error between two adjacent patches.

Now, let's reformulate the same idea, but building a continuous formulation of this function. We take the whole image, and assume that we shift the whole image by an infinitesimal quantity. This is the *Harris&Stephens solution*. We then formulate the error function as a function of this infinitesimal shift. Then, we compute the error, i.e. the difference between correspondent pixels in the shift and in the original image. This will be really small.Now, rather than considering the whole patch, we'll only concentrate on a pixel. We compute all of the differences, but those in the window that stays the same are multiplied by 0. So, the difference will only be concerned about the space that is excluded by the intersection of the patches. Now, why does this shift have to be infinitesimal? We can deploy Taylor's expansion of the intensity function at $(x,y)$! 
$$
I(x+\Delta x, y+\Delta y)-I(x, y) \cong \frac{\partial I(x, y)}{\partial x} \Delta x+\frac{\partial I(x, y)}{\partial y} \Delta y=I_{x}(x, y) \Delta x+I_{y}(x, y) \Delta y
$$
After substituting some things, we get:
$$
E(\Delta x, \Delta y)=\left[\begin{array}{ll}
\Delta x & \Delta y
\end{array}\right] M\left[\begin{array}{l}
\Delta x \\
\Delta y
\end{array}\right]
$$
Now, we can hypothise that the strcuture matrix is always diagonal/can always be diagonalized (property of simmetric matrices).

Because the structuret matrix is real and symmetric, you can always rotate the axis such that the matrix becomes diagonal. Particularly, the directions along which we should align the axis, are the eigenvectors. 
$$
M=R\left[\begin{array}{cc}
\lambda_{1} & 0 \\
0 & \lambda_{2}
\end{array}\right] R^{T}
$$
with the elements of the diagonal being the eigenvalues. 

So, we can always just forget about doing this, we shall directly study the eigenvalues!

If both eigenvalues are large, we are at a corner, if just one is we are on an edge:

![Eigenvalues vs corners](/Users/simone/UniBO/unibo-ai/Computer Vision/res/eigenvalues-vs-corners.png)

Harris finally proposed this function to be used:
$$
C=\operatorname{det}(M)-k \cdot \operatorname{tr}(M)^{2}=\lambda_{1} \lambda_{2}-k\left(\lambda_{1}+\lambda_{2}\right)^{2}
$$
where $k$ is a parameter, the trace is the sum of the elements along the main diagonal and the determinant is their product. So, the determinant and the trace are a function of the eigenvalues, so we can establish the cornerness and skipping the eigenvalues, just using the determinant and trace. 

![Harris cornerness](/Users/simone/UniBO/unibo-ai/Computer Vision/res/harris-cornerness.png)