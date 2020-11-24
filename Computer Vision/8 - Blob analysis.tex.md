# Blob analysis

We have seen how to perform a foreground/background segmentation, and how to improve its output by simple tools such as morphology operators. Opening/Closing in particular allow us to significantly improve the output of the segmentation. But now, what we're left with is an image having *several objects* with all their pixels marked in *black* (nothing else than a foreground label) and all the other pixels marked as *white* (label denoting the background). Obviously, these labels could be different, maybe 0/1.

The next task would be the analysis of the individual foreground objects, to achieve some kind of high-level knowledge on the scene. The process of analyzing the single objects is called **blob analysis**: it starts with a background/foreground image, and has the goal of understanding what we need about the individual objects.

Such knowledge might be detecting the type of object, taking measurements on the dimensions and their orientation, assessing defects or inaccuracies... Blob stands for **Binary Large Objects**, which first need to be isolated. This first step is called *connected components labeling*.

The properties that we extract once we have found the blobs are typically known as **features**. Sometimes we only need the contour: in such a case, we are looking for **contour features**. How do we extract these? Obviously, through an erosion, getting us the inner contour, then we take the original image and subtract it. Now, there's many features and we'll just discover a small set of them.

Shape features must be invariant to the transformation that the object might undergo when they are image in the system. For example, having an elliptical object, we would expect that if we compute a feature highlighting how much this object resembles an ellipsis, we might get a high score, but we would like is that if the object appears rotated the result doesn't change. 

So, we can now label the objects, maybe by using *pseudocolors* showing what an object is labeled with. 

Each connected component will now be assumed to correspond to a single entity, analyzed separately. We need to define exactly what these connected components are. To do so, let's define connectivity, which is related to the notion of *distance* on the discrete plane $E^2$. 

The distance on the discrete plane, given 3 points $p_1,p_2,p_3$ we say that a function is a distance if it is non-negative for each pair, $0$ only if two points are the same, it is symmetric ($D(p_1, p_2)=D(p_2,p_1)$) and finally: $D\left(p_{1}, p_{3}\right) \leq D\left(p_{1}, p_{2}\right)+D\left(p_{2}, p_{3}\right)$.

The city-block distance, $D_4$ is defined as:
$$
D_{4}\left(p_{1}, p_{2}\right)=\left|i_{1}-i_{2}\right|+\left|j_{1}-j_{2}\right|
$$
basically a distance in which you can't travel diagonally.

Now, the set of points having a distance minor than a threshold, is a rhombus with diagonals of length $2r+1$.

Differenlty, we could define the *Chessboard distance* as:
$$
D_{8}\left(p_{1}, p_{2}\right)=\max \left(\left|i_{1}-i_{2}\right|,\left|j_{1}-j_{2}\right|\right)
$$
This means that unlike the Manhattan distance, you can also move diagonally, and a step along the diagonal would have the same length as an horizontal/vertical step. Indeed, the set of points having distance minor than a threshold, is a square with size $2r+1$. The set of neighbours of $p$ such that $D_8=1$ is called the *8-neighbourhood* of $p$ (think about MineSweeper!).

Now, given a pixel $p$ (point in the frame), a **path** from $p$ to pixel $q$ is a sequence of points such that for every pair of successive points, they are neighbours.

Now, given this notion, we say that a set of pixels are a connected region if, for any 2 pixels $p,q$ in $R$ there always exists a path contained in $R$. There's always at least a path connecting $p$ and $q$. 

Depending on the choice of distance, we can say that $R$ is *4-connected* or *8-connected*.

Now, we can define a *connected foreground region* if it is a connected region and includes foreground pixels only. Likewise, we can define a connected background region. 

A **connected component** of a binary image is a **maximal** connected foreground region: you cannot add points, that's the maximal size.

What matters in labeling algorihtms is **speed**.

The classical **2-scans algorithm** is a sequential algorithm.

The algorithm (raster scan) starts scanning the image, and when it finds a **foreground pixel** it assigns a temporary label. If something is already labeled, it labels its neighbours. We may incur in a situation in which two labels are adjacent. This is why we need a second scan: we'll handle these conflicts during the second scan.

Upon the first scan, different blobs certainly have been given different labels, though, depending on the shape, a single blob might have been labeled differently inside its pixels. 

To handle that problem and come up with a unique labeling, we can do a second scan, allowing a unique final label to be assigned to those parts belonging to the same blob that had been given different temporary labels. 

We run the first scan, record the equivalences, find the equivalent class and then relabel the final image with a unique label taken from each of the equivalent classes found in the processing that takes place between the two scans.

For example, focusing on 4-connectivity, given the raster scan order, if $x$ is a foreground pixel, the already visited neighbours are $p$ and $q$. In the first scan, we'll label $x$ based on the labels we already gave to $p$ and $q$. If both of them are labeled as background, $x$ is a foreground pixel though its neighbours are background pixels. If this is the case, we assign it a new label and increment the label counter. If $q$ has been given a label, while $p$ is background? $x$ shall have the same label as $q$. Likewise, if the already labeled one is $p$, then $x$ will have its label. If both $p$ and $q$ are labeled equally, we use it.

**But**, if $p$ and $q$ are labeled, and they're labeled differently, what shall we label $x$? Because of the existence of $x$, then the labels in $p$ and $q$ are equivalent! We'll give to $x$ either one of the labels, and somehow record that $l_p$ and $l_q$ are indeed the same label! 

