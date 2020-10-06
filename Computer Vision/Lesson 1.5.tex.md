# Lesson 2, Image formation and acquisition

## Introduction

What we do in computer vision is we extrapolate infos from images. So, computer vision solves a different problem from computer graphics. To do that right, we have to understand the **image acquisition process**, in which we go from a real world scene to an image.

There's many aspects: one may be the **geometric relationship** between scene points and image points, one may concern the **radiometric relationship** between the scene and the image, and the last one being the **image digitalization** process.

First, we need to find a device to capture the image with. The simplest device is called a *pinhole camera*, just a hole in a box that reflects an image in a box. If we take a light ray emitted from a point in the scene, this ray will pass through the hole and hit the **photosensitive** material on the plane, therefore creating an image. Just as this one, every point will emit light in different directions, but because of the small size of the hole, just one ray will be able to pass the hole: the image is forged just by drawing straight rays from the points to the pinhole.

Obviously, **nobody uses these.** Nonetheless, these devices model the image formation that happens in more sophisticated devices: modern cameras' mechanisms are tremendously similar to this. 

## Perspective projection

We should now define the mathematical model behind this. This kind of geometric model is known as ***perspective projection***.

We should obviously define a **mapping** between the scene points and the corresponding image points! This mapping will be in the form of equations, composed by coordinates, regarding the two reference systems, a 3D one (the real world one), and a 2d one (the image plane). These two systems merge in the pinhole, the **optical center**. The 3D reference system <img src="svgs/a35d9ea85439dede6d90c9f53db8be8c.svg?invert_in_darkmode" align=middle width=53.80914pt height=24.65759999999998pt/> is named **camera reference system**. The 2D <img src="svgs/2c4a788685c5c98364a6d234f540b9eb.svg?invert_in_darkmode" align=middle width=38.05956pt height=24.65759999999998pt/> one is called **image reference system**. 

Now, how can we find this relationship? Let's first consider the plane where x and u are.

![Perspective projection](./res/perspective.png)

Pay attention to the **minus**: this means that the image will be **inverted**!

To avoid the problems an inversion causes, we can imagine the image plane as lying in front rather than behind the optical center.

![Flipping the perspective projection](/Users/simone/UniBO/unibo-ai/Computer Vision/res/flipped-perspective.png)

This proves an important fact: **image coordinates are a scaled version of the scene ones!** Thus, knowing a point's position in the real world, we can find its position in the image.

It is obvious that we'll lose some informations: we're in fact mapping a **3D space to a 2D one**. Indeed, the mapping is not a bijection: a given scene point is mapped into a unique image point, but the opposite isn't true. Thus, recovering the 3D structure from a 2D image is an ill-posed problem (the solution is not unique), we can only position the point on a line (corresponding to the dimension we lost).

This takes us to **stereo images**: having two images from differents POVs, we can infer the 3D coordinates!

Using **triangulation**, we therefore intersect the projection rays and associate them with the corresponding points in two cameras looking at the same scene.

### Standard stereo geometry

The two cameras are now just horizontally placed with a distance b. Therefore, they have the same focal length and coplanar image planes. The axis are parallel.

Therefore, the transformation between the two reference frames is just **a translation**, usually **horizontal**.

The reason why <img src="svgs/0707b553b86997d6bad96ffe87f10a13.svg?invert_in_darkmode" align=middle width=45.713415pt height=22.46574pt/> is that we build the camera around this constraint: this simplifies things a lot. <img src="svgs/b0f9b1a8559f80880692a2e83f7bdf58.svg?invert_in_darkmode" align=middle width=17.077830000000002pt height=14.155350000000013pt/> is the same as <img src="svgs/bf20d01f48eb15dd06cf6b72c191855d.svg?invert_in_darkmode" align=middle width=18.021300000000004pt height=14.155350000000013pt/>, <img src="svgs/710717f013d73b35492c709f431babf3.svg?invert_in_darkmode" align=middle width=16.663020000000003pt height=14.155350000000013pt/> as <img src="svgs/51e6f9f5f1810dab77755cf524a22204.svg?invert_in_darkmode" align=middle width=17.60649pt height=14.155350000000013pt/>. This way, a given 3D point will be seen at the **same height** in the image, the same vertical coordinates. 

So, <img src="svgs/bba624515bbe78331da72f6c5ff0afb0.svg?invert_in_darkmode" align=middle width=16.986420000000003pt height=14.155350000000013pt/> and <img src="svgs/fb4ce08ba3dd6dbda94aa6bc6e03480d.svg?invert_in_darkmode" align=middle width=17.92989pt height=14.155350000000013pt/> are equal, but <img src="svgs/0a83216b2892fe514549b7efae3aed62.svg?invert_in_darkmode" align=middle width=18.428685000000005pt height=14.155350000000013pt/> and <img src="svgs/ceb6ffe0800c5263400d41b76cf0629b.svg?invert_in_darkmode" align=middle width=19.372155000000006pt height=14.155350000000013pt/> aren't, and we can use that difference to infer the third dimension we're seeking!

![Disparity in stereo images](./res/disparity-in-stereo.png)

This quantity <img src="svgs/a07f8a981f6592dec8cff5b9166c00e2.svg?invert_in_darkmode" align=middle width=58.713930000000005pt height=19.178279999999994pt/> is called **disparity**. We finally get the fundamental equation: depth is proportional to disparity. <img src="svgs/3edd1ff1a04d8c533f518d93c8f8c775.svg?invert_in_darkmode" align=middle width=177.179805pt height=24.65759999999998pt/> 

Now, knowing the disparity, we can obtain <img src="svgs/76092abb25ebaf3fd411261d8c8769e4.svg?invert_in_darkmode" align=middle width=18.232500000000005pt height=14.155350000000013pt/> thanks to the fact that corresponding points have the same <img src="svgs/0a83216b2892fe514549b7efae3aed62.svg?invert_in_darkmode" align=middle width=18.428685000000005pt height=14.155350000000013pt/>. Thus, the search space is a line, it's one-dimensional. 

Now, how can we find a single correspondence? One problem could be that maybe you have a point you see in one camera and not the other one. We can therefore group similar pixels to find correspondences between the two images: we *slide* an image onto the other, and find the best match in the positioning of the pixels.

### Epipolar geometry

If you know the focal length and the relative position between the two cameras (**rotation, translation**) you can compute the **epipolar geometry.** Just knowing the **relative position** between the two cameras and the focal length! The search space of the stereo correspondence is always 1-dimensional, but being the lines oblique you can compute the **epipolar line** corresponding to the point. All the epipolar lines in an image meet at a point called epipoint. Given any two images taken under an arbitrary relationship, we can warp the images as if they were acquired through a standard geometry by computing and applying to both a transformation known as ***rectification.***

One might decide not to go into this complications implied by epipolar geometry, and go for standard geometry; but in practice, we can never get rid of rectification: it is almost impossible to perfectly align the two cameras!

### Some properties of perspective projection

- The farther objects are from the camera, the smaller they appear. For instance, a 3d line segment of length <img src="svgs/ddcb483302ed36a59286424aa5e0be17.svg?invert_in_darkmode" align=middle width=11.187330000000003pt height=22.46574pt/> lying in a plane parallel to the image at distance <img src="svgs/f93ce33e511096ed626b4719d50f17d2.svg?invert_in_darkmode" align=middle width=8.367645000000003pt height=14.155350000000013pt/> from the optical center will have a length given by <img src="svgs/851fc257b02f077acfd55872f000ca85.svg?invert_in_darkmode" align=middle width=48.005759999999995pt height=30.648420000000016pt/>
- Perspective projection maps 3D lines into image lines
- Rations of lengths are not preserved (**distortion**) unless we are in a planar, parallel to the image plane.

### Vanishing points

The **vanishing point** of a 3D line is the image of the point at infinity of the line, i.e. the image of the point on the line which is infinitely distant from the optical center. 

 

![Vanishing points](./res/vanishing-points.png)

All parallel 3D lines will therefore share the same vanishing point, i.e. they meet at their vanishing point in the image, but at infinity (the 3D lines are parallel to the image plane).

To find the vanishing point of a line, we're gonna use the parametric equation of the line, where <img src="svgs/fb97d38bcc19230b0acd442e17db879c.svg?invert_in_darkmode" align=middle width=17.739810000000002pt height=22.46574pt/> is the equation, <img src="svgs/7ae1d6da5db0b75a96bddc0e0fc2ab9a.svg?invert_in_darkmode" align=middle width=22.50006pt height=22.46574pt/> is a point, <img src="svgs/78ec2b7008296ce0561cf83393cb746d.svg?invert_in_darkmode" align=middle width=14.066250000000002pt height=22.46574pt/> is the cosine of the angle between the line and the axis of the reference system (three-dimensional vector for each axis).

<img src="svgs/aa88d6cebc9bd50bf25dc7c39b3f9616.svg?invert_in_darkmode" align=middle width=230.357655pt height=67.39788pt/> 

Now, how can we find the vanishing point? We first project a generic point of the line, to get it at infinity we have to set lambda to infinity! In fact, the larger the lambda, the more you move along the line. So, rather than projecting an ordinary point, if we take the limit with lambda going to infinity of the point equations, we get <img src="svgs/faef4edd74643c43c82727bc0b375146.svg?invert_in_darkmode" align=middle width=50.24844pt height=22.853489999999976pt/> and <img src="svgs/ffb9d1197e536dde094d241d7fdef521.svg?invert_in_darkmode" align=middle width=48.140235000000004pt height=28.926479999999973pt/>.

![Calculating vanishing points](./res/vanishing-points-equation.png)

