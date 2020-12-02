# Blob analysis

We have seen how to perform a foreground/background segmentation, and how to improve its output by simple tools such as morphology operators. Opening/Closing in particular allow us to significantly improve the output of the segmentation. But now, what we're left with is an image having *several objects* with all their pixels marked in *black* (nothing else than a foreground label) and all the other pixels marked as *white* (label denoting the background). Obviously, these labels could be different, maybe 0/1.

The next task would be the analysis of the individual foreground objects, to achieve some kind of high-level knowledge on the scene. The process of analyzing the single objects is called **blob analysis**: it starts with a background/foreground image, and has the goal of understanding what we need about the individual objects.

Such knowledge might be detecting the type of object, taking measurements on the dimensions and their orientation, assessing defects or inaccuracies... Blob stands for **Binary Large Objects**, which first need to be isolated. This first step is called *connected components labeling*.

The properties that we extract once we have found the blobs are typically known as **features**. Sometimes we only need the contour: in such a case, we are looking for **contour features**. How do we extract these? Obviously, through an erosion, getting us the inner contour, then we take the original image and subtract it. Now, there's many features and we'll just discover a small set of them.

Shape features must be invariant to the transformation that the object might undergo when they are image in the system. For example, having an elliptical object, we would expect that if we compute a feature highlighting how much this object resembles an ellipsis, we might get a high score, but we would like is that if the object appears rotated the result doesn't change. 

So, we can now label the objects, maybe by using *pseudocolors* showing what an object is labeled with. 

Each connected component will now be assumed to correspond to a single entity, analyzed separately. We need to define exactly what these connected components are. To do so, let's define connectivity, which is related to the notion of *distance* on the discrete plane <img src="svgs/ec98e5a999a97406ff498c3555463115.svg?invert_in_darkmode" align=middle width=19.63472444999999pt height=26.76175259999998pt/>. 

The distance on the discrete plane, given 3 points <img src="svgs/0bb6814cae35fd4be51c2d10d877d8b4.svg?invert_in_darkmode" align=middle width=60.724933499999985pt height=14.15524440000002pt/> we say that a function is a distance if it is non-negative for each pair, <img src="svgs/29632a9bf827ce0200454dd32fc3be82.svg?invert_in_darkmode" align=middle width=8.219209349999991pt height=21.18721440000001pt/> only if two points are the same, it is symmetric (<img src="svgs/5510907ab9d4fa248cdba92f4361b1ba.svg?invert_in_darkmode" align=middle width=152.8128327pt height=24.65753399999998pt/>) and finally: <img src="svgs/18611f96edceeeb1738b2602d9bb5801.svg?invert_in_darkmode" align=middle width=246.57051044999997pt height=24.65753399999998pt/>.

The city-block distance, <img src="svgs/654fa11bb9fe0a9bcbfe27df4b7c7b24.svg?invert_in_darkmode" align=middle width=20.16214364999999pt height=22.465723500000017pt/> is defined as:
<p align="center"><img src="svgs/ea413f65407d89316d400befa8fcd79a.svg?invert_in_darkmode" align=middle width=229.92428909999998pt height=16.438356pt/></p>
basically a distance in which you can't travel diagonally.

Now, the set of points having a distance minor than a threshold, is a rhombus with diagonals of length <img src="svgs/d8720f518b5999473a5863998a2f39ad.svg?invert_in_darkmode" align=middle width=44.402565899999985pt height=21.18721440000001pt/>.

Differenlty, we could define the *Chessboard distance* as:
<p align="center"><img src="svgs/1fe10184fa387ca31d449fdca72baa49.svg?invert_in_darkmode" align=middle width=265.99739265pt height=16.438356pt/></p>
This means that unlike the Manhattan distance, you can also move diagonally, and a step along the diagonal would have the same length as an horizontal/vertical step. Indeed, the set of points having distance minor than a threshold, is a square with size <img src="svgs/d8720f518b5999473a5863998a2f39ad.svg?invert_in_darkmode" align=middle width=44.402565899999985pt height=21.18721440000001pt/>. The set of neighbours of <img src="svgs/2ec6e630f199f589a2402fdf3e0289d5.svg?invert_in_darkmode" align=middle width=8.270567249999992pt height=14.15524440000002pt/> such that <img src="svgs/4d78458f4e0e67e45ded0731f1ec3ca3.svg?invert_in_darkmode" align=middle width=51.120895649999994pt height=22.465723500000017pt/> is called the *8-neighbourhood* of <img src="svgs/2ec6e630f199f589a2402fdf3e0289d5.svg?invert_in_darkmode" align=middle width=8.270567249999992pt height=14.15524440000002pt/> (think about MineSweeper!).

Now, given a pixel <img src="svgs/2ec6e630f199f589a2402fdf3e0289d5.svg?invert_in_darkmode" align=middle width=8.270567249999992pt height=14.15524440000002pt/> (point in the frame), a **path** from <img src="svgs/2ec6e630f199f589a2402fdf3e0289d5.svg?invert_in_darkmode" align=middle width=8.270567249999992pt height=14.15524440000002pt/> to pixel <img src="svgs/d5c18a8ca1894fd3a7d25f242cbe8890.svg?invert_in_darkmode" align=middle width=7.928106449999989pt height=14.15524440000002pt/> is a sequence of points such that for every pair of successive points, they are neighbours.

Now, given this notion, we say that a set of pixels are a connected region if, for any 2 pixels <img src="svgs/9ee547e0827e5bb29b5feb9f5f574193.svg?invert_in_darkmode" align=middle width=23.504556899999987pt height=14.15524440000002pt/> in <img src="svgs/1e438235ef9ec72fc51ac5025516017c.svg?invert_in_darkmode" align=middle width=12.60847334999999pt height=22.465723500000017pt/> there always exists a path contained in <img src="svgs/1e438235ef9ec72fc51ac5025516017c.svg?invert_in_darkmode" align=middle width=12.60847334999999pt height=22.465723500000017pt/>. There's always at least a path connecting <img src="svgs/2ec6e630f199f589a2402fdf3e0289d5.svg?invert_in_darkmode" align=middle width=8.270567249999992pt height=14.15524440000002pt/> and <img src="svgs/d5c18a8ca1894fd3a7d25f242cbe8890.svg?invert_in_darkmode" align=middle width=7.928106449999989pt height=14.15524440000002pt/>. 

Depending on the choice of distance, we can say that <img src="svgs/1e438235ef9ec72fc51ac5025516017c.svg?invert_in_darkmode" align=middle width=12.60847334999999pt height=22.465723500000017pt/> is *4-connected* or *8-connected*.

Now, we can define a *connected foreground region* if it is a connected region and includes foreground pixels only. Likewise, we can define a connected background region. 

A **connected component** of a binary image is a **maximal** connected foreground region: you cannot add points, that's the maximal size.

What matters in labeling algorihtms is **speed**.

The classical **2-scans algorithm** is a sequential algorithm.

The algorithm (raster scan) starts scanning the image, and when it finds a **foreground pixel** it assigns a temporary label. If something is already labeled, it labels its neighbours. We may incur in a situation in which two labels are adjacent. This is why we need a second scan: we'll handle these conflicts during the second scan.

Upon the first scan, different blobs certainly have been given different labels, though, depending on the shape, a single blob might have been labeled differently inside its pixels. 

To handle that problem and come up with a unique labeling, we can do a second scan, allowing a unique final label to be assigned to those parts belonging to the same blob that had been given different temporary labels. 

We run the first scan, record the equivalences, find the equivalent class and then relabel the final image with a unique label taken from each of the equivalent classes found in the processing that takes place between the two scans.

For example, focusing on 4-connectivity, given the raster scan order, if <img src="svgs/332cc365a4987aacce0ead01b8bdcc0b.svg?invert_in_darkmode" align=middle width=9.39498779999999pt height=14.15524440000002pt/> is a foreground pixel, the already visited neighbours are <img src="svgs/2ec6e630f199f589a2402fdf3e0289d5.svg?invert_in_darkmode" align=middle width=8.270567249999992pt height=14.15524440000002pt/> and <img src="svgs/d5c18a8ca1894fd3a7d25f242cbe8890.svg?invert_in_darkmode" align=middle width=7.928106449999989pt height=14.15524440000002pt/>. In the first scan, we'll label <img src="svgs/332cc365a4987aacce0ead01b8bdcc0b.svg?invert_in_darkmode" align=middle width=9.39498779999999pt height=14.15524440000002pt/> based on the labels we already gave to <img src="svgs/2ec6e630f199f589a2402fdf3e0289d5.svg?invert_in_darkmode" align=middle width=8.270567249999992pt height=14.15524440000002pt/> and <img src="svgs/d5c18a8ca1894fd3a7d25f242cbe8890.svg?invert_in_darkmode" align=middle width=7.928106449999989pt height=14.15524440000002pt/>. If both of them are labeled as background, <img src="svgs/332cc365a4987aacce0ead01b8bdcc0b.svg?invert_in_darkmode" align=middle width=9.39498779999999pt height=14.15524440000002pt/> is a foreground pixel though its neighbours are background pixels. If this is the case, we assign it a new label and increment the label counter. If <img src="svgs/d5c18a8ca1894fd3a7d25f242cbe8890.svg?invert_in_darkmode" align=middle width=7.928106449999989pt height=14.15524440000002pt/> has been given a label, while <img src="svgs/2ec6e630f199f589a2402fdf3e0289d5.svg?invert_in_darkmode" align=middle width=8.270567249999992pt height=14.15524440000002pt/> is background? <img src="svgs/332cc365a4987aacce0ead01b8bdcc0b.svg?invert_in_darkmode" align=middle width=9.39498779999999pt height=14.15524440000002pt/> shall have the same label as <img src="svgs/d5c18a8ca1894fd3a7d25f242cbe8890.svg?invert_in_darkmode" align=middle width=7.928106449999989pt height=14.15524440000002pt/>. Likewise, if the already labeled one is <img src="svgs/2ec6e630f199f589a2402fdf3e0289d5.svg?invert_in_darkmode" align=middle width=8.270567249999992pt height=14.15524440000002pt/>, then <img src="svgs/332cc365a4987aacce0ead01b8bdcc0b.svg?invert_in_darkmode" align=middle width=9.39498779999999pt height=14.15524440000002pt/> will have its label. If both <img src="svgs/2ec6e630f199f589a2402fdf3e0289d5.svg?invert_in_darkmode" align=middle width=8.270567249999992pt height=14.15524440000002pt/> and <img src="svgs/d5c18a8ca1894fd3a7d25f242cbe8890.svg?invert_in_darkmode" align=middle width=7.928106449999989pt height=14.15524440000002pt/> are labeled equally, we use it.

**But**, if <img src="svgs/2ec6e630f199f589a2402fdf3e0289d5.svg?invert_in_darkmode" align=middle width=8.270567249999992pt height=14.15524440000002pt/> and <img src="svgs/d5c18a8ca1894fd3a7d25f242cbe8890.svg?invert_in_darkmode" align=middle width=7.928106449999989pt height=14.15524440000002pt/> are labeled, and they're labeled differently, what shall we label <img src="svgs/332cc365a4987aacce0ead01b8bdcc0b.svg?invert_in_darkmode" align=middle width=9.39498779999999pt height=14.15524440000002pt/>? Because of the existence of <img src="svgs/332cc365a4987aacce0ead01b8bdcc0b.svg?invert_in_darkmode" align=middle width=9.39498779999999pt height=14.15524440000002pt/>, then the labels in <img src="svgs/2ec6e630f199f589a2402fdf3e0289d5.svg?invert_in_darkmode" align=middle width=8.270567249999992pt height=14.15524440000002pt/> and <img src="svgs/d5c18a8ca1894fd3a7d25f242cbe8890.svg?invert_in_darkmode" align=middle width=7.928106449999989pt height=14.15524440000002pt/> are equivalent! We'll give to <img src="svgs/332cc365a4987aacce0ead01b8bdcc0b.svg?invert_in_darkmode" align=middle width=9.39498779999999pt height=14.15524440000002pt/> either one of the labels, and somehow record that <img src="svgs/247ca9d8cf371e16f3db4442254b82af.svg?invert_in_darkmode" align=middle width=11.681353199999991pt height=22.831056599999986pt/> and <img src="svgs/afb7fb120ae5389c5d25f91e9a279ff0.svg?invert_in_darkmode" align=middle width=11.34271214999999pt height=22.831056599999986pt/> are indeed the same label! 

## Blob features

There's lots of algorithms that perform blob analysis differing in speed, mainly. 

Once blobs have been found, we can focus on each of these and try to compute their properties(features). What kind of features? There's many kinds, related to the size, the shape... We'll discuss some of them.

### Area and barycentre

The first ones will be **area** and **barycentre**. The **area** is just the **number of pixels of a blob**: <img src="svgs/bd1a8912145ca18b83bc7836804b720e.svg?invert_in_darkmode" align=middle width=88.97558174999999pt height=24.657735299999988pt/>. Then, quite related to it is the **barycentre**, being computed by usingthe two coordinates <img src="svgs/b800d00109d1bfa2d633a86af2d21652.svg?invert_in_darkmode" align=middle width=32.12211089999999pt height=21.68300969999999pt/>: 
<p align="center"><img src="svgs/e8f863fa0194e2856d0f15282d945487.svg?invert_in_darkmode" align=middle width=378.18380985pt height=45.717186899999994pt/></p>

### Perimeter

Another useful feature is the **perimeter**, i.e. the length of the contour. We first have to get what pixels belong to the contour, using the concept of connectivity. A pixel <img src="svgs/2ec6e630f199f589a2402fdf3e0289d5.svg?invert_in_darkmode" align=middle width=8.270567249999992pt height=14.15524440000002pt/> belongs to the contour if there exists at least **a background pixel** in its neighbourhood. We can decide to rely on 4-connectivity (manhattan distance) or 8-connectivity.
<p align="center"><img src="svgs/46f2b4dbd0b2fc86cbbcf22960ae964f.svg?invert_in_darkmode" align=middle width=247.06774620000002pt height=39.1417719pt/></p>


Note that the 4 and 8 are **inverted**: if the connectivity is 4-connected, the perimeter is said of length 8. Considering a blob, and finding <img src="svgs/60fe977bd0752a4efa88e64770ef019b.svg?invert_in_darkmode" align=middle width=18.30139574999999pt height=22.465723500000017pt/> then <img src="svgs/2ceece01d321b0ff9942f0e602a670c6.svg?invert_in_darkmode" align=middle width=18.30139574999999pt height=22.465723500000017pt/>, the first one is the contour found if we rely on 4-connectivity. Under this assumption, the length of <img src="svgs/6ed772078e0eaa68357ac9f795009f8e.svg?invert_in_darkmode" align=middle width=17.10619349999999pt height=22.465723500000017pt/> (the <img src="svgs/60fe977bd0752a4efa88e64770ef019b.svg?invert_in_darkmode" align=middle width=18.30139574999999pt height=22.465723500000017pt/> perimeter), it will be higher than the one calculated using <img src="svgs/2ceece01d321b0ff9942f0e602a670c6.svg?invert_in_darkmode" align=middle width=18.30139574999999pt height=22.465723500000017pt/>:

![Comparation of perimeters](./res/perimeter-compared.png)

To solve this, we could average them: <img src="svgs/67b26d5fba2a27812c7e5340bd7d7d7b.svg?invert_in_darkmode" align=middle width=76.38819704999999pt height=32.054807400000016pt/>.

A better estimation of the contour length is finding the <img src="svgs/6ed772078e0eaa68357ac9f795009f8e.svg?invert_in_darkmode" align=middle width=17.10619349999999pt height=22.465723500000017pt/> and taking into account the *ideal curve* joining two nearby pixels. Given the order of pixels, when counting how much we should weigh each pixel, we check whether the ideal curve joining two consequent pixels is vertical/horizontal or diagonal:

![Ideal curve perimeter](./res/ideal-perimeter.png)

We can formalize it as: *for each pixel, we add 1 if the curve is horizontal/vertical, and we add <img src="svgs/71486f265f83bc1e3d2b6f67704bcc23.svg?invert_in_darkmode" align=middle width=21.91788224999999pt height=28.511366399999982pt/> if it is diagonal*.
<p align="center"><img src="svgs/2c56bfec8769da1ded06a5dc387f3987.svg?invert_in_darkmode" align=middle width=366.68371905pt height=42.31983525pt/></p>
This is probably the best approach to compute perimeters.

If a blob has *holes*, we have to find both of the perimeters. 

### Compactness 

Now another type of feature, a **shape** one, very useful to characterize the blob's shape: the **compactness** (aka Form Factor, P square over A). The computing is simple, you take the squared perimeter divided by the area. In case of continuous 2D shapes, it takes the minimum value (i.e. <img src="svgs/4a69aabb89e6e0cc23abc48cea9ba5af.svg?invert_in_darkmode" align=middle width=18.179315549999988pt height=21.18721440000001pt/>) for a circle.

Taking a circle as example, we draw another shape over it:

![Strange shape example](./res/strange-shape.png)

Assuming the *inner* concavities have the same area of the *outer* concavities, the blue areas are equal to the red ones, although the perimeter will be much longer than the circle one. So, clearly, this measure is **higher** for shapes showing **many concavities**!
<p align="center"><img src="svgs/bf00f479db817c333a58af35416a11a3.svg?invert_in_darkmode" align=middle width=57.02609714999999pt height=35.77743345pt/></p>
Note that we want shape features to be *scale-invariant*.

### Haralick circularity

Another researcher did show however that compactness is minimum for a circle, in practice, due to quantization issues, this is not the case for **digital shapes**, i.e. quantized ones, where the minimum is defined by an octagon or a diamond (basing on 4-connectivity of 8). This guy, named *Haralick*, proposed another circularity feature:
<p align="center"><img src="svgs/e95d61a25cb66e2f54a95921a69c8ef4.svg?invert_in_darkmode" align=middle width=561.0027934499999pt height=39.452455349999994pt/></p>
Note that<img src="svgs/61e84f854bc6258d4108d08d4c4a0852.svg?invert_in_darkmode" align=middle width=13.29340979999999pt height=22.465723500000017pt/> is he barycentre, and we can compute, for every pixel <img src="svgs/2ec6e630f199f589a2402fdf3e0289d5.svg?invert_in_darkmode" align=middle width=8.270567249999992pt height=14.15524440000002pt/>, its distance from the barycentre. If we consider the set of all those distances, there's a property that holds for a circle only: the distance of the perimeter from the center is **always the same**. So, how can we define the difference from a circle? We could measure the **variance** of these distances: if they're not varying much (there's noise due to quantization), we have a circle! So, we compute the mean distance and the variance:
<p align="center"><img src="svgs/8a0557354f81a2b8396c145729b70c07.svg?invert_in_darkmode" align=middle width=296.9672541pt height=45.2741091pt/></p>
 and we migh find this circularity as <img src="svgs/aab4a5069babaab41bcd7a37087dfcb8.svg?invert_in_darkmode" align=middle width=44.845175099999985pt height=32.054807400000016pt/>. The more <img src="svgs/8cda31ed38c6d59d14ebefa440099572.svg?invert_in_darkmode" align=middle width=9.98290094999999pt height=14.15524440000002pt/> gets small, the more the circularity gets higher. 

Note that this is a shape feature, and it has to be **shape-invariant**, but the larger the number of pixels (i.e. the longer the contour), the higher will be the variance! So we need to normalize that to obtain a scale-invariant shape feature, by changing the circularity from the previously cited to one normalized by the mean:
<p align="center"><img src="svgs/b95bb0a17dfa743e436f2e0c0b412baa.svg?invert_in_darkmode" align=middle width=57.503476799999994pt height=31.939908pt/></p>

### Euler number

Another quite useful feature is the **Euler number**, defined for a binary image, is equal to <img src="svgs/f1d3df4a31feaf82d645e126a23c8291.svg?invert_in_darkmode" align=middle width=83.01562664999999pt height=22.465723500000017pt/>, i.e. the number of connected components minus the number of holes:![Euler number](./res/euler-number.png)

Why is this useful? We can compute it for each blob, having <img src="svgs/d5b2262cbb37ba867aa8a38c3b639be9.svg?invert_in_darkmode" align=middle width=102.31140479999999pt height=22.465723500000017pt/>, ending up with a number that tells you how many holes are there in a blob.

How is this computed? Using a library, but a simple way to do that would be labeling the image and the re-labeling the holes inside this. Note that <img src="svgs/84df98c65d88c6adf15d4645ffa25e47.svg?invert_in_darkmode" align=middle width=13.08219659999999pt height=22.465723500000017pt/> is a topological feature, i.e. it is invariant to *rubber sheet transformations*. 

### Moments

Let's define some other widespread features, **moments**. Assume we have a function returning the Euler number for a blob. Then, we could compute it using the double labeling, but there's another algorithm known as *Bit Quads*, providing other features too! 

We can define the moment of a region as the following sum: <img src="svgs/e322d2af832e5d524946db817d01652b.svg?invert_in_darkmode" align=middle width=142.87841369999998pt height=24.657735299999988pt/>.

Note that <img src="svgs/c68485604cc32fc15fff623f58c5e452.svg?invert_in_darkmode" align=middle width=32.956740299999986pt height=22.465723500000017pt/> is indeed the area: <img src="svgs/306a394c2abbcda2366695a23529ecc4.svg?invert_in_darkmode" align=middle width=241.22197439999997pt height=26.76175259999998pt/>. Other relevant moments are <img src="svgs/636403e65a2c02be38143a984f231817.svg?invert_in_darkmode" align=middle width=32.956740299999986pt height=22.465723500000017pt/>, being the sum of <img src="svgs/f3c68d7948fe906e4e1d13cbfb69a00c.svg?invert_in_darkmode" align=middle width=14.26296464999999pt height=26.76175259999998pt/>, i.e. the sum of all the distances to the <img src="svgs/77a3b857d53fb44e33b53e4c8b68351a.svg?invert_in_darkmode" align=middle width=5.663225699999989pt height=21.68300969999999pt/> axis, or the *moment of inertia wrt the <img src="svgs/77a3b857d53fb44e33b53e4c8b68351a.svg?invert_in_darkmode" align=middle width=5.663225699999989pt height=21.68300969999999pt/> axis*.

Obviously, <img src="svgs/deb5f8913e89e5afc3e071e6a8d8b21e.svg?invert_in_darkmode" align=middle width=32.956740299999986pt height=22.465723500000017pt/> is the moment of inertia wrt the <img src="svgs/36b5afebdba34564d884d347484ac0c7.svg?invert_in_darkmode" align=middle width=7.710416999999989pt height=21.68300969999999pt/> axis. 

Finally, <img src="svgs/0ff88ae2010c5faecaa3868741eb4bc4.svg?invert_in_darkmode" align=middle width=32.956740299999986pt height=22.465723500000017pt/> is the *deviation moment of inertia*. 

Let's consider these moments' invariance to translation: if we take an object and move it further away from the origin, the distances from the axis change and the moments change!

To solve this, we could normalize them by calculating them in relation to the barycentre:
<p align="center"><img src="svgs/26ab3e90791d8a1d4eb24728ffd76630.svg?invert_in_darkmode" align=middle width=218.83580729999997pt height=39.1417719pt/></p>
with such moments said **central moments**.

To achieve scale-invariance too, we have to normalize them again:
<p align="center"><img src="svgs/b14b332b8699c84442e851e539d84802.svg?invert_in_darkmode" align=middle width=216.87994349999997pt height=36.346059749999995pt/></p>
**Hu** has shown that shape features invariant to rotation, translation and scaling can be defined startingfrom normalized central moments. 

### Orientation

How could we find the **orientation** of the blobs? Let's first define it: if an object is sort of *elongated*, then we can define an orientation according to the direction of the axis (obviously, a circle has no orientation!), the **line through the barycentre** having the **smallest moment of inertia**. This line is known as the *major axis*, and minimizes the moment of inertia with respect to the line <img src="svgs/2f2322dff5bde89c37bcae4116fe20a8.svg?invert_in_darkmode" align=middle width=5.2283516999999895pt height=22.831056599999986pt/>, considering lines to the barycentre:
<p align="center"><img src="svgs/dfe7ea7c6eb2d1188ab3c4e4fe9a4460.svg?invert_in_darkmode" align=middle width=253.40502659999999pt height=59.1786591pt/></p>
It is conveninent to define an orientation **given by an angle**, taking the angle between this line and the horizontal axis. Now, since the orientation is given by a line, it is computed for blobs, and it is determined modulo <img src="svgs/f30fdded685c83b0e7b446aa9c9aa120.svg?invert_in_darkmode" align=middle width=9.96010619999999pt height=14.15524440000002pt/>: <img src="svgs/27e556cf3caa0673ac49a8f0de3c73ca.svg?invert_in_darkmode" align=middle width=8.17352744999999pt height=22.831056599999986pt/> and <img src="svgs/22e1ab3b8cc389580d81bea9425762bf.svg?invert_in_darkmode" align=middle width=38.224825649999985pt height=22.831056599999986pt/> are the same angle!

Now, let's note how we can compute the distance from a point to a line: given the line <img src="svgs/6b35600207c479609db3eaa244198d0d.svg?invert_in_darkmode" align=middle width=125.47738664999999pt height=22.831056599999986pt/>, the squared distance from a point <img src="svgs/7fa383db4e33c6cdf26544cd849d5600.svg?invert_in_darkmode" align=middle width=41.735527349999984pt height=24.65753399999998pt/> can be expressed as
<p align="center"><img src="svgs/abd188c094b3f0f184c3dfd68d27ae1a.svg?invert_in_darkmode" align=middle width=157.45023855pt height=37.147307999999995pt/></p>
Now, if we consider the point, we denote its projection on the line as <img src="svgs/a935bfad8837a3dbc6f71cd28a221cfa.svg?invert_in_darkmode" align=middle width=10.07140364999999pt height=23.744328300000017pt/>, its distance from <img src="svgs/2ec6e630f199f589a2402fdf3e0289d5.svg?invert_in_darkmode" align=middle width=8.270567249999992pt height=14.15524440000002pt/> can either be *positive* or *negative*, depending on where it is with respect to the line: on the left, or on the right, since <img src="svgs/1c08f8ef2ff061978dc0536f6d0f4041.svg?invert_in_darkmode" align=middle width=89.31694694999999pt height=24.65753399999998pt/>. The distance is given by the dot product divided by the norm of <img src="svgs/55a049b8f161ae7cfeb0197d75aff967.svg?invert_in_darkmode" align=middle width=9.86687624999999pt height=14.15524440000002pt/> multiplied by the cosine: <img src="svgs/066af5b844157a14e7aca66ee1625d7d.svg?invert_in_darkmode" align=middle width=107.79455279999998pt height=33.20539859999999pt/>. We the get a quantity which can be either positive or negative, whether the point is on one of the two subplanes defined by the line. We therefore get an information, not only on the distance, but on the position of the point wrt the line. 

Now, we can find the major axis, i.e. the line to the barycentre of ther blob having smallest inertia. Now, we'll parametrize this axis, as a line to the origin, parametrized wrt the angle. Any given pixel will be <img src="svgs/7fa383db4e33c6cdf26544cd849d5600.svg?invert_in_darkmode" align=middle width=41.735527349999984pt height=24.65753399999998pt/>, the barycentre <img src="svgs/db2fac21146c9fd17b6f3fde0a0e97c4.svg?invert_in_darkmode" align=middle width=59.02284464999999pt height=24.65753399999998pt/>. 

We translate to a new reference system having the center in <img src="svgs/61e84f854bc6258d4108d08d4c4a0852.svg?invert_in_darkmode" align=middle width=13.29340979999999pt height=22.465723500000017pt/>: the coordinates of a generic pixel in the new reference system pointed in the **barycentre** will be <img src="svgs/c351919fb4c5b8173203fd7363decfac.svg?invert_in_darkmode" align=middle width=170.80167884999997pt height=47.6716218pt/>.

Now, we'll parametrize the generic line to this vector <img src="svgs/2f2322dff5bde89c37bcae4116fe20a8.svg?invert_in_darkmode" align=middle width=5.2283516999999895pt height=22.831056599999986pt/>:
<p align="center"><img src="svgs/3a9a30e1b293608d2c3e488899b3e175.svg?invert_in_darkmode" align=middle width=175.78169565pt height=39.452455349999994pt/></p>
The minus is there vecause the axis is pointed as such.

Now, we can write the equation of this generic line: 
<p align="center"><img src="svgs/6c99f87be7db2a24f27096bee86cfa5e.svg?invert_in_darkmode" align=middle width=355.530285pt height=39.83452935pt/></p>
The equation of our line, parametrized to the angle <img src="svgs/5c73580b6d2cc20f0fea7704a5f039c4.svg?invert_in_darkmode" align=middle width=8.17352744999999pt height=28.091038800000003pt/> in the new reference system. Then we can minimize the moment of inertia with respect to the line, remembering the square distance in a normal environment: <img src="svgs/a21f7fe63942ccb8bd3b86b0c14f726a.svg?invert_in_darkmode" align=middle width=127.29023504999998pt height=36.460254599999985pt/>. Note that <img src="svgs/1f97c56152a7b8f2fdd2a00c16c4f7eb.svg?invert_in_darkmode" align=middle width=80.72090234999999pt height=26.76175259999998pt/>, ad we get to the final formula:
<p align="center"><img src="svgs/370964b0124d9460b12401d7836fd4e8.svg?invert_in_darkmode" align=middle width=641.1875068499999pt height=78.90491235pt/></p>
Now, how do we compute the moment of inertia? For each point we compute the sum of the square distance to the line under consideration, finally getting to:
<p align="center"><img src="svgs/02e341930a9986606dff509c88f79902.svg?invert_in_darkmode" align=middle width=245.99365229999998pt height=39.1417719pt/></p>
Now, both <img src="svgs/c745b9b57c145ec5577b82542b2df546.svg?invert_in_darkmode" align=middle width=10.57650494999999pt height=14.15524440000002pt/> and <img src="svgs/8217ed3c32a785f0b5aad4055f432ad8.svg?invert_in_darkmode" align=middle width=10.16555099999999pt height=22.831056599999986pt/> can be extracted from the sum, getting <img src="svgs/4d586ba735a081c25434063710aea11b.svg?invert_in_darkmode" align=middle width=352.6693153499999pt height=27.817082700000007pt/>. Note that these quantities are something we've already seen: they are the **central moments**!
<p align="center"><img src="svgs/2298e38749b2445c28cede512ec5b463.svg?invert_in_darkmode" align=middle width=262.842459pt height=20.50407645pt/></p>
 Now, what is going to change are the parameters <img src="svgs/c745b9b57c145ec5577b82542b2df546.svg?invert_in_darkmode" align=middle width=10.57650494999999pt height=14.15524440000002pt/> and <img src="svgs/8217ed3c32a785f0b5aad4055f432ad8.svg?invert_in_darkmode" align=middle width=10.16555099999999pt height=22.831056599999986pt/> which define the orientation of the line. So, we now need to minimize this quantity where the central moments are constants, so we indeed need to minimize <img src="svgs/c745b9b57c145ec5577b82542b2df546.svg?invert_in_darkmode" align=middle width=10.57650494999999pt height=14.15524440000002pt/> and <img src="svgs/8217ed3c32a785f0b5aad4055f432ad8.svg?invert_in_darkmode" align=middle width=10.16555099999999pt height=22.831056599999986pt/>! Since these are just the sine and cosine, we get:
<p align="center"><img src="svgs/8a4db86f5feb106937ff38c61dce14a4.svg?invert_in_darkmode" align=middle width=515.0622246pt height=39.452455349999994pt/></p>
trying to find the minimum of a function of 1 variable, and we can just set the derivative to 0.

We can then find the major and minor axis by analysis of the second derivative: the maximum is the minor axis, while the minimum is the major axis.

We could even express these in the image reference frame:
<p align="center"><img src="svgs/f2a7a2ffdf94e1bfa45cfb637c38a008.svg?invert_in_darkmode" align=middle width=661.9359615pt height=59.178683850000006pt/></p>

<p align="center"><img src="svgs/a41c60bca09cbe652f76ee67d092556a.svg?invert_in_darkmode" align=middle width=698.30168595pt height=59.178683850000006pt/></p>

Now, given the two axes, we might wish to draw a bounding box alignedto the object, also known as *Minimum Enclosing Rectangle*. We therefore need to find the four points lying at maximum distance on opposite sides of the two axes. 

Then, having found these points <img src="svgs/6fd0ad91bafcb06c97be23d09b18321e.svg?invert_in_darkmode" align=middle width=97.58897444999998pt height=22.465723500000017pt/>, we just need to find the lines through <img src="svgs/52480c8a8db9958406e6ab7faa50bb63.svg?invert_in_darkmode" align=middle width=44.73058919999999pt height=22.465723500000017pt/> parallel to the major axis, and those through <img src="svgs/e0279e615a00d4e5d0528074c875eac0.svg?invert_in_darkmode" align=middle width=44.73058919999999pt height=22.465723500000017pt/> parallel to the minor axis. 

The MER allows us to find interesting features, like the **length, width, elongatedness, rectangularity and ellipticity**.



















