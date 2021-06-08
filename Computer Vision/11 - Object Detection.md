# Object Detection
			
The object detection problem consists in determining if the object in the **_model image_** is present in the **_target image_** and, in case of detection estimating the pose.
Depending on the application the pose may consists in:
- A translation
- A roto-translation
- A similarity (roto-translation + scale)

## Template matching
The model image is slided across the target image to be compared at each  position by a (dis)similarity function, like one of the following:
### (Dis)similarity functions

- #### SSD (sum of squared differences)
![image](https://user-images.githubusercontent.com/31796254/120350505-5137ea00-c2ff-11eb-89e6-b1627072b178.png)

It is equivalent to compute the L2 Norm of the difference matrix.

- #### SAD (sum of absolute differences)
It is equivalent to compute the L1 Norm of the difference matrix.

![image](https://user-images.githubusercontent.com/31796254/120350677-7cbad480-c2ff-11eb-9ff1-ac8be5fcbef6.png)

- #### NCC (normalized cross-correlation) and ZNCC

![image](https://user-images.githubusercontent.com/31796254/120350956-bab7f880-c2ff-11eb-8875-a7856af25c83.png)

It is equivalent to compute the cosine of the angle between vectors I(i,j) and T And it is invariant to linear intensity changes _(I = αT)_.
Intensity invariance can be extended with ZNCC (zero-mean normalized cross-correlation):

![image](https://user-images.githubusercontent.com/31796254/120351241-010d5780-c300-11eb-859c-269704e594cb.png)

With ZNCC the invariance is extended to this type of changes: _I = αT+β_, which make it very robust to intensity change.

### Fast template matching
Template matching can be very slow, especially when the model and/or the target image have a large size. So fastest approaches have been developed. They are divided in **_Approximate methods_** and **_Exact methods_**.
One famous approximate method consists in constructing an image pyramid by putting the original image at level 0, smoothing it and scaling it on both sides (typically by 1/2), and putting the scaled image at level 1, and so on until level L.
The matching starts on top, at level L, with a full search, then local refinement is done through successive levels.

## Shape-based matching
1. A set of control points, P_k, is found in the model through an **_edge detection_** operator, like the Sobel, and the gradient direction of each one is recorded.
2. For each patch (i,j) of the target image the recorded gradient directions are compared with correspondings image points in the patch ![image](https://user-images.githubusercontent.com/31796254/120352147-c9eb7600-c300-11eb-8ce7-d097fc0d739c.png), in order to compute a **_similarity function_**:

![image](https://user-images.githubusercontent.com/31796254/120352359-fdc69b80-c300-11eb-923b-360d0faa35cd.png)

A more robust  similarity function, invariant to global inversion of contrast polarity can be taken by simply considering the absolute value of _S(i,j)_. Invariance can be extended to local contrast polarity with this similarity function:

![image](https://user-images.githubusercontent.com/31796254/120352503-1df65a80-c301-11eb-9442-c90fa7dd46b4.png)

## Hough Transform (HT)
It detects shapes projecting input data in a so called **_parameter_** or  **_Hough space_**, turning a global detection in a local one. At first, it was invented to detect lines, then extended to other analytical shapes (circles, ellipses and so on) as well as to non-analytical ones (**_Generalized Hough Transform_**).

It is robust to noise and to occlusion.

### Basic principle

Let's first consider the original formulation for lines. The general equation of a line is:

y=mx+q

Where, in the usual image space, m and q are fixed. If we instead fix x and y, we obtain a mapping 1→∞ representing all the lines passing for (x,y).
The couples of parameters representing these lines lie on a line in the parameter space.

If we consider n colinear (in the image space) points, their corresponding lines in the parameter space will intersect in a single point, which represents the image line passing through all the n points.

Therefore, HT consists of mapping image points (usually edge points) to their corresponding curves into the parameters space and then finding intersections between these curves:
the more the intersecting curves, the higher the evidence of that line in the image.

To make it in practice, the parameter space is discretized and allocated as a memory array, called Accumulator Array (AA), where each bin indicates the number of lines passing through the corresponding region of the parameter space (voting process).
Finding parameter space points is then translated in finding peaks in the AA.

### HT for line detection

![image](https://user-images.githubusercontent.com/31796254/120352941-9230fe00-c301-11eb-85b8-2058cb448993.png)

### HT for circle detection

![image](https://user-images.githubusercontent.com/31796254/120353047-a7a62800-c301-11eb-876f-77c4dccfdb62.png)

### GHT: Generalized Hough Transform

![image](https://user-images.githubusercontent.com/31796254/120353302-de7c3e00-c301-11eb-8034-c20b4ef1b6c1.png)

#### Handling rotation and scale:

![image](https://user-images.githubusercontent.com/31796254/120353474-fbb10c80-c301-11eb-9bf1-16af9e15ab28.png)




