# Camera calibration

Camera calibration is about measuring the important parameters of a camera. Important, i.e. we want to detect some quantitative measurements on the image. 

The thing is, the mapping in perspective projection is **non-linear**, and we'd like it to be.

Now, why are the problems noisy? Well, all images are, since sensor are affected by noise.

So, we have to solve the equations in a way that is non subsceptible to noise.

The following is, as always, a mapping from real world coordinates to the image ones: $\left\{\begin{array}{l}
u=\frac{f}{z} x \\
v=\frac{f}{z} y
\end{array}\right.$

So, how do we turn these non-linear equations into linear ones? We have to move our POV from the euclidean one to the **projective space**, which is a mathematical instrument that is great to handle perspective projection. So, the vector space we're familiar with is the 3D euclidean space ($R^3$).

Now, let's turn a *Euclidean vector* into another vector, where we append a fourth coordinate, equal to $1$, which still represents the same point. Now, we just say that not only $(x,y,z,1)$ is valid representation, but if we multiply it by a scalar like $2$, we always get the same valid representation.What we are saying is that we can represent $(x,y,z)$ with 4 coordinates, and that all the representations that differ by a scalar $k$ are just the same. 

These 4 coordinates are called **homogeneous coordinates** (*projective coordinates*), and the vector space described by these coordinates is called **Projective Space**.

Basically, this transformation is always just a 4-th dimension added to the coordinates then the vector gets multiplied by a nonzero constant $k$.

Now, if we are given let's say a point in an n-dimensional projective space, the vector will consist in $n+1$ coordinates $[x_1,\dots,x_n,x_{n+1}]$. To do the inverse mapping, we'll divide everything by$x_{n+1}$ then remove the last dimension. Note that this allows us to represent infinity: if $x_{n+1}$ is $0$, the point is at infinity!

Let's consider the parametric equation of a 3D line: $\begin{array}{l}
\mathrm{M}=M_{0}+\lambda D=\left[\begin{array}{l}
x_{0} \\
y_{0} \\
z_{0}
\end{array}\right]+\lambda\left[\begin{array}{l}
a \\
b \\
c
\end{array}\right]=\left[\begin{array}{l}
x_{0}+\lambda a \\
y_{0}+\lambda b \\
z_{0}+\lambda c
\end{array}\right]
\end{array}$, where $\lambda$ just specifies how much we're moving along the direction. Now, we can expand this representation and append the $1$, then multiply it by a scalar $k$.

If we multiply it by $\frac{1}{\lambda}$, we get this: $\tilde{M}=\left[\begin{array}{c}
M \\
1
\end{array}\right]=\left[\begin{array}{c}
x_{0}+\lambda a \\
y_{0}+\lambda b \\
z_{0}+\lambda c \\
1
\end{array}\right]=\left[\begin{array}{c}
\frac{x_{0}}{\lambda}+a \\
\frac{y_{0}}{\lambda}+b \\
\frac{z_{0}}{\lambda}+c \\
\frac{1}{\lambda}
\end{array}\right]$ . So, if we take the limit for $\lambda\rightarrow\infty$ gets us $x_{n+1}=0$!

Now, how many points at infinity exist in a projective space? Infinite: we could append a 0 to every point.

That's nice because at the end, these can be handled in a projective space as normal points!

Note that $(0,0,0,0)$ is **undefined**, the origin is $(0,0,0,k)$.

So, why are we doing this stuff? Because perspective projection is more conveniently dealt with projective coordinates!

Please note that the value $k$ is **irrelevant!** 

So, let's denote a point $M$ irl and the image point $m$ as column vectors: $\tilde{\mathbf{m}}=\left[\begin{array}{l}
u \\
v \\
1
\end{array}\right] \quad \tilde{\mathbf{M}}=\left[\begin{array}{l}
x \\
y \\
z \\
1
\end{array}\right]$

Now, we can transform the perspective projection, which becomes a **linear transformation!**

We use as $k$ $z$, so that the thing simplifies: 

$\left[\begin{array}{l}
u \\
v \\
1
\end{array}\right]=\left[\begin{array}{c}
f \frac{x}{z} \\
f \frac{y}{z} \\
1 \\
d
\end{array}\right]=\left[\begin{array}{c}
f x \\
f y \\
z
\end{array}\right]=\left[\begin{array}{cccc}
f & 0 & 0 & 0 \\
0 & f & 0 & 0 \\
0 & 0 & 1 & 0
\end{array}\right]\left[\begin{array}{l}
x \\
y \\
z \\
1
\end{array}\right]$, where the last one is the projective representation of the point. So, we can get th image points by $k\tilde{m}=\tilde{P}\tilde{M}$ ,which sometimes is substituted by a $m\approx \tilde{P}\tilde{M}$, which mneans "equal up to an arbitrary scale factor".

Basically, $P$ is the **perspective projection matrix** (PPM) and it represents the geometric camera model. It's the equivalent of the previous equations of perspective projection between euclidean spaces. 

Now, let's assume that distances are measurable in **focal length units**, so the PPM becomes $\tilde{\mathbf{P}}=\left[\begin{array}{llll}
1 & 0 & 0 & 0 \\
0 & 1 & 0 & 0 \\
0 & 0 & 1 & 0
\end{array}\right]=[\mathbf{I} \mid \mathbf{0}]$, for example if the focal length is $8mm$, $f=2 \rightarrow 16mm$.

This is more compactly expressed by the notation $[I|0]$, where $I$ is an identity matrix and $0$ is that 0 column vector.

This type of representation is called **canonical or standard PPM**.

To come up with a useful camera model we still have two issues to address: image digitization and the 6 DOF rigid motion between the Camera Reference Frame and the World Reference Frame. There's no way to measure coordinates in an *abstract* reference frame. What can we do? We can apply $\tilde{m}=\tilde{P}\tilde{M}$, but to do so we have to measure the *world coordinates* $\tilde{M}$, therefore we need a coordinate system for the real world! 

There's one other thing that we can observe between the entities: actually, we cannot observe the image coordinates too! 

We need to find the 2 dimensions in the pixel grid. We can get the vector from the upper left corner, which represents the element at the righ pixel coordinates.

$\begin{array}{ll}
u=\frac{f}{z} x \quad & \rightarrow u=\frac{1}{\Delta u} \frac{f}{z} x=k_{u} \frac{f}{z} x+u_{0} \\
v=\frac{f}{z} y & \rightarrow v=\frac{1}{\Delta v} \frac{f}{z} y=k_{v} \frac{f}{z} y+v_{0}
\end{array}$ where $\Delta$ are the pixel sizes.

Now, we have the CRF coordinates, and we can move onto pixels. These two equations are still non-linear tho. This can be rewritten as a mapping between this new formulation and the PPM: $\tilde{\mathbf{P}}=\left[\begin{array}{cccc}
f k_{u} & 0 & u_{0} & 0 \\
0 & f k_{i} & v_{0} & 0 \\
0 & 0 & 1 & 0
\end{array}\right]$ and to get an image point we can mulitply it by $[x,y,z,1]^T$, getting us a column vector containing $[xfk_u+u_0z, yfk_v+v_0z,z]^T$, and dividing it by $z$ to *remove the tilde* we get $[x\frac{f}{z}k_u+u_0=u, y\frac{f}{z}+v_0=v]$. This means that the PPM can be rewritten to take into account pixelization. 

Now, there's another nice thing we can observe, i.e. this matrix can be factorized in two matrices: $\left[\begin{array}{ccc}
f k_{u} & 0 & u_{0} \\
0 & f k_{v} & v_{0} \\
0 & 0 & 1
\end{array}\right]\left[\begin{array}{llll}
1 & 0 & 0 & 0 \\
0 & 1 & 0 & 0 \\
0 & 0 & 1 & 0
\end{array}\right]=A[I|0]$

The matrix $A$ model the characteristics of the image sensing device, and is called **Intrinsic Parameter Matrix**. $A$ is **device specific!**

Now, sometimes you wouldn't find $fk_u,fk_v$ expressed as such, but as $a_u,a_v$, i.e. focal lengths in horizontal and vertical pixel sizes.

So far we have assumed 3D coordinates to be measured into the CRF, though this is hardly feasible in practice. Generally, 3D coordinates are measured into a WRF external to the camera, then the WRF will be related to the CRF by a **rototranslation** (i.e. a rotation around the optical center, then a translation). Therefore, the relation between the coordinates between the two RFs is $\mathbf{W}=\left[\begin{array}{l}
X \\
Y \\
Z
\end{array}\right], \mathbf{M}=\left[\begin{array}{l}
x \\
y \\
z
\end{array}\right] \Rightarrow \mathbf{M}=\mathbf{R} \mathbf{W}+\mathbf{T}$ , which can be rewritten in homogeneous coordinates. 

So far we have seen how to map a 3D point expressed in the CRF: $k\tilde{m}=A[I|0]\tilde{M}$, and we now need to consider the rigid motion between the WRF and the CRF: $k\tilde{m}=A[I|0]G\tilde{W}$

Now, the PPM can be expressed as $A[R|T]$, because $k\tilde{m}=A[RT]\tilde{w}$, or alternatively $\tilde{P}=\tilde{A}[I|0]G$.

The PPM is based on the pinhole model. However, real lenses introduce distortions to the model, especially cheap ones. The most significant deviation is known as **radal distortion**, and second order effects are induced by tangential distortion. 

Lens distortion is modeled through a non-linear transformation which maps ideal (*undistorted*) image coordinates into the observed image coordinates. 







