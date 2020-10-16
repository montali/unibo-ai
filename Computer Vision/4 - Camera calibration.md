# Camera calibration

Camera calibration is about measuring the important parameters of a camera. Important, i.e. we want to detect some quantitative measurements on the image. 

The thing is, the mapping in perspective projection is **non-linear**, and we'd like it to be.

Now, why are the problems noisy? Well, all images are, since sensor are affected by noise.

So, we have to solve the equations in a way that is non subsceptible to noise.

The following is, as always, a mapping from real world coordinates to the image ones: <img src="svgs/158e76f8511f49cc85eaf23900e58df7.svg?invert_in_darkmode" align=middle width=72.91591889999998pt height=50.70319979999998pt/>

So, how do we turn these non-linear equations into linear ones? We have to move our POV from the euclidean one to the **projective space**, which is a mathematical instrument that is great to handle perspective projection. So, the vector space we're familiar with is the 3D euclidean space (<img src="svgs/88b8a2e57772e3be969c3fc12c2a7095.svg?invert_in_darkmode" align=middle width=19.161017699999988pt height=26.76175259999998pt/>).

Now, let's turn a *Euclidean vector* into another vector, where we append a fourth coordinate, equal to <img src="svgs/034d0a6be0424bffe9a6e7ac9236c0f5.svg?invert_in_darkmode" align=middle width=8.219209349999991pt height=21.18721440000001pt/>, which still represents the same point. Now, we just say that not only <img src="svgs/61c9e3563169ae64883715619a9f0480.svg?invert_in_darkmode" align=middle width=69.33410549999999pt height=24.65753399999998pt/> is valid representation, but if we multiply it by a scalar like <img src="svgs/76c5792347bb90ef71cfbace628572cf.svg?invert_in_darkmode" align=middle width=8.219209349999991pt height=21.18721440000001pt/>, we always get the same valid representation.What we are saying is that we can represent <img src="svgs/a35d9ea85439dede6d90c9f53db8be8c.svg?invert_in_darkmode" align=middle width=53.80901294999998pt height=24.65753399999998pt/> with 4 coordinates, and that all the representations that differ by a scalar <img src="svgs/63bb9849783d01d91403bc9a5fea12a2.svg?invert_in_darkmode" align=middle width=9.075367949999992pt height=22.831056599999986pt/> are just the same. 

These 4 coordinates are called **homogeneous coordinates** (*projective coordinates*), and the vector space described by these coordinates is called **Projective Space**.

Basically, this transformation is always just a 4-th dimension added to the coordinates then the vector gets multiplied by a nonzero constant <img src="svgs/63bb9849783d01d91403bc9a5fea12a2.svg?invert_in_darkmode" align=middle width=9.075367949999992pt height=22.831056599999986pt/>.

Now, if we are given let's say a point in an n-dimensional projective space, the vector will consist in <img src="svgs/3f18d8f60c110e865571bba5ba67dcc6.svg?invert_in_darkmode" align=middle width=38.17727759999999pt height=21.18721440000001pt/> coordinates <img src="svgs/a8495f236de6d6ce3c6255dde3c0a0ad.svg?invert_in_darkmode" align=middle width=123.06695774999999pt height=24.65753399999998pt/>. To do the inverse mapping, we'll divide everything by<img src="svgs/14e12a1273c346610e9daaf5e3aee29a.svg?invert_in_darkmode" align=middle width=34.16493134999999pt height=14.15524440000002pt/> then remove the last dimension. Note that this allows us to represent infinity: if <img src="svgs/14e12a1273c346610e9daaf5e3aee29a.svg?invert_in_darkmode" align=middle width=34.16493134999999pt height=14.15524440000002pt/> is <img src="svgs/29632a9bf827ce0200454dd32fc3be82.svg?invert_in_darkmode" align=middle width=8.219209349999991pt height=21.18721440000001pt/>, the point is at infinity!

Let's consider the parametric equation of a 3D line: <img src="svgs/4b4c69069d6139d50488239d9891e015.svg?invert_in_darkmode" align=middle width=375.97591515pt height=67.39784699999998pt/>, where <img src="svgs/fd8be73b54f5436a5cd2e73ba9b6bfa9.svg?invert_in_darkmode" align=middle width=9.58908224999999pt height=22.831056599999986pt/> just specifies how much we're moving along the direction. Now, we can expand this representation and append the <img src="svgs/034d0a6be0424bffe9a6e7ac9236c0f5.svg?invert_in_darkmode" align=middle width=8.219209349999991pt height=21.18721440000001pt/>, then multiply it by a scalar <img src="svgs/63bb9849783d01d91403bc9a5fea12a2.svg?invert_in_darkmode" align=middle width=9.075367949999992pt height=22.831056599999986pt/>.

If we multiply it by <img src="svgs/c50f251ee09e2b51f8bcb84b6c167a1d.svg?invert_in_darkmode" align=middle width=7.796853899999999pt height=27.77565449999998pt/>, we get this: <img src="svgs/49da7045c9fca50367fe00efad3cc2c0.svg?invert_in_darkmode" align=middle width=313.46911034999994pt height=87.1240788pt/> . So, if we take the limit for <img src="svgs/5b5e735b4fe2de517c5b33ff3b40de1e.svg?invert_in_darkmode" align=middle width=51.59808719999999pt height=22.831056599999986pt/> gets us <img src="svgs/2740ec70c6ea75402eca55dbc102763c.svg?invert_in_darkmode" align=middle width=65.12367674999999pt height=21.18721440000001pt/>!

Now, how many points at infinity exist in a projective space? Infinite: we could append a 0 to every point.

That's nice because at the end, these can be handled in a projective space as normal points!

Note that <img src="svgs/bbda227b291123a9ddd7ec80cf1680d3.svg?invert_in_darkmode" align=middle width=67.57992119999999pt height=24.65753399999998pt/> is **undefined**, the origin is <img src="svgs/b6bf4870828826c72dba98ab1c74f6fe.svg?invert_in_darkmode" align=middle width=68.43607319999998pt height=24.65753399999998pt/>.

So, why are we doing this stuff? Because perspective projection is more conveniently dealt with projective coordinates!

Please note that the value <img src="svgs/63bb9849783d01d91403bc9a5fea12a2.svg?invert_in_darkmode" align=middle width=9.075367949999992pt height=22.831056599999986pt/> is **irrelevant!** 

So, let's denote a point <img src="svgs/fb97d38bcc19230b0acd442e17db879c.svg?invert_in_darkmode" align=middle width=17.73973739999999pt height=22.465723500000017pt/> irl and the image point <img src="svgs/0e51a2dede42189d77627c4d742822c3.svg?invert_in_darkmode" align=middle width=14.433101099999991pt height=14.15524440000002pt/> as column vectors: <img src="svgs/3d0dec26415b1d7a235b4ff75adf6353.svg?invert_in_darkmode" align=middle width=192.22945499999997pt height=87.12407549999999pt/>

Now, we can transform the perspective projection, which becomes a **linear transformation!**

We use as <img src="svgs/63bb9849783d01d91403bc9a5fea12a2.svg?invert_in_darkmode" align=middle width=9.075367949999992pt height=22.831056599999986pt/> <img src="svgs/f93ce33e511096ed626b4719d50f17d2.svg?invert_in_darkmode" align=middle width=8.367621899999993pt height=14.15524440000002pt/>, so that the thing simplifies: 

<img src="svgs/1607642d7c98c731c7a86f41abbb17c4.svg?invert_in_darkmode" align=middle width=404.89658054999995pt height=87.12407549999999pt/>, where the last one is the projective representation of the point. So, we can get th image points by <img src="svgs/c31b7378ef626cd574a520ee6acce78c.svg?invert_in_darkmode" align=middle width=76.00260359999999pt height=30.267491100000004pt/> ,which sometimes is substituted by a <img src="svgs/018bddf0fd728dd0ab7f86a387f4746d.svg?invert_in_darkmode" align=middle width=66.92724059999999pt height=30.267491100000004pt/>, which mneans "equal up to an arbitrary scale factor".

Basically, <img src="svgs/df5a289587a2f0247a5b97c1e8ac58ca.svg?invert_in_darkmode" align=middle width=12.83677559999999pt height=22.465723500000017pt/> is the **perspective projection matrix** (PPM) and it represents the geometric camera model. It's the equivalent of the previous equations of perspective projection between euclidean spaces. 

Now, let's assume that distances are measurable in **focal length units**, so the PPM becomes <img src="svgs/a7980c0546b1a7ef677f1b661a033d96.svg?invert_in_darkmode" align=middle width=216.75747554999995pt height=67.39784699999998pt/>, for example if the focal length is <img src="svgs/fe28575f3f38c0fe9dc15502907ebb03.svg?invert_in_darkmode" align=middle width=37.08540989999999pt height=21.18721440000001pt/>, <img src="svgs/57fe9c9e96017f3216697f4a8ed09a2c.svg?invert_in_darkmode" align=middle width=110.82947369999998pt height=22.831056599999986pt/>.

This is more compactly expressed by the notation <img src="svgs/200d808f6f92da1fa54ae7373884f89e.svg?invert_in_darkmode" align=middle width=30.43384739999999pt height=24.65753399999998pt/>, where <img src="svgs/21fd4e8eecd6bdf1a4d3d6bd1fb8d733.svg?invert_in_darkmode" align=middle width=8.515988249999989pt height=22.465723500000017pt/> is an identity matrix and <img src="svgs/29632a9bf827ce0200454dd32fc3be82.svg?invert_in_darkmode" align=middle width=8.219209349999991pt height=21.18721440000001pt/> is that 0 column vector.

This type of representation is called **canonical or standard PPM**.

To come up with a useful camera model we still have two issues to address: image digitization and the 6 DOF rigid motion between the Camera Reference Frame and the World Reference Frame. There's no way to measure coordinates in an *abstract* reference frame. What can we do? We can apply <img src="svgs/d6c454b2aa41e4518b9aeecca3158710.svg?invert_in_darkmode" align=middle width=66.92724059999999pt height=30.267491100000004pt/>, but to do so we have to measure the *world coordinates* <img src="svgs/d218b4d5df0580d68b6142a044223f26.svg?invert_in_darkmode" align=middle width=17.73973739999999pt height=30.267491100000004pt/>, therefore we need a coordinate system for the real world! 

There's one other thing that we can observe between the entities: actually, we cannot observe the image coordinates too! 

We need to find the 2 dimensions in the pixel grid. We can get the vector from the upper left corner, which represents the element at the righ pixel coordinates.

<img src="svgs/85ff2761b74960d6d02857881203ba8b.svg?invert_in_darkmode" align=middle width=277.29720975pt height=50.70319979999998pt/> where <img src="svgs/7e9fe18dc67705c858c077c5ee292ab4.svg?invert_in_darkmode" align=middle width=13.69867124999999pt height=22.465723500000017pt/> are the pixel sizes.

Now, we have the CRF coordinates, and we can move onto pixels. These two equations are still non-linear tho. This can be rewritten as a mapping between this new formulation and the PPM: <img src="svgs/bb2eee2b3ea92a099bf31b40121d2dd5.svg?invert_in_darkmode" align=middle width=198.3326037pt height=67.39784699999998pt/> and to get an image point we can mulitply it by <img src="svgs/e2fce9faad69587e7ce475475d6791de.svg?invert_in_darkmode" align=middle width=75.21483914999999pt height=27.6567522pt/>, getting us a column vector containing <img src="svgs/506e71f7e2eeb101c6959814bc93c049.svg?invert_in_darkmode" align=middle width=201.88944599999996pt height=27.6567522pt/>, and dividing it by <img src="svgs/f93ce33e511096ed626b4719d50f17d2.svg?invert_in_darkmode" align=middle width=8.367621899999993pt height=14.15524440000002pt/> to *remove the tilde* we get <img src="svgs/50ebdc3af2c3003bb6b3f0f8846fa7d1.svg?invert_in_darkmode" align=middle width=209.0375991pt height=30.648287999999997pt/>. This means that the PPM can be rewritten to take into account pixelization. 

Now, there's another nice thing we can observe, i.e. this matrix can be factorized in two matrices: <img src="svgs/d0f9a6a2867b6886de2dedc5cb905293.svg?invert_in_darkmode" align=middle width=329.14053314999995pt height=67.39784699999998pt/>

The matrix <img src="svgs/53d147e7f3fe6e47ee05b88b166bd3f6.svg?invert_in_darkmode" align=middle width=12.32879834999999pt height=22.465723500000017pt/> model the characteristics of the image sensing device, and is called **Intrinsic Parameter Matrix**. <img src="svgs/53d147e7f3fe6e47ee05b88b166bd3f6.svg?invert_in_darkmode" align=middle width=12.32879834999999pt height=22.465723500000017pt/> is **device specific!**

Now, sometimes you wouldn't find <img src="svgs/3692b044e0cc10b70411e6143f4e40dc.svg?invert_in_darkmode" align=middle width=59.63878964999999pt height=22.831056599999986pt/> expressed as such, but as <img src="svgs/c0df8a5b321c4fd86bd869894e9a7736.svg?invert_in_darkmode" align=middle width=40.26651914999999pt height=14.15524440000002pt/>, i.e. focal lengths in horizontal and vertical pixel sizes.

So far we have assumed 3D coordinates to be measured into the CRF, though this is hardly feasible in practice. Generally, 3D coordinates are measured into a WRF external to the camera, then the WRF will be related to the CRF by a **rototranslation** (i.e. a rotation around the optical center, then a translation). Therefore, the relation between the coordinates between the two RFs is <img src="svgs/96dc1ed965d0a4a29f13e81ab1ae59d4.svg?invert_in_darkmode" align=middle width=323.20640715pt height=67.39784699999998pt/> , which can be rewritten in homogeneous coordinates. 

So far we have seen how to map a 3D point expressed in the CRF: <img src="svgs/7df51f6a3dfa7c8b13a961d33e1a59e4.svg?invert_in_darkmode" align=middle width=105.92847704999997pt height=30.267491100000004pt/>, and we now need to consider the rigid motion between the WRF and the CRF: <img src="svgs/dc8f943ffafda748f9fec73012531178.svg?invert_in_darkmode" align=middle width=118.92164294999999pt height=30.267491100000004pt/>

Now, the PPM can be expressed as <img src="svgs/4d693c79524eded2c878d24957703d61.svg?invert_in_darkmode" align=middle width=50.525252249999994pt height=24.65753399999998pt/>, because <img src="svgs/ce228235b0861e953db19c1294e51baf.svg?invert_in_darkmode" align=middle width=103.59596609999998pt height=24.65753399999998pt/>, or alternatively <img src="svgs/c3870cb3438ad01de6ec5f9617104c38.svg?invert_in_darkmode" align=middle width=90.44168595pt height=30.267491100000004pt/>.

The PPM is based on the pinhole model. However, real lenses introduce distortions to the model, especially cheap ones. The most significant deviation is known as **radal distortion**, and second order effects are induced by tangential distortion. 

Lens distortion is modeled through a non-linear transformation which maps ideal (*undistorted*) image coordinates into the observed image coordinates. 







