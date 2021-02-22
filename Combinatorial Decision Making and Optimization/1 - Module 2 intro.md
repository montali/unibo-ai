# Introduction - Module 2

On Virtuale we can find `opanalytics` and `requirements` which aid us in setting up the Python environment.

## Prerequisites

There are no formal ones, we'll see some mathematics, some python, some algorithms, statistics.. We have to know how the libraries work at their core. 

# Optimization

Optimization is a scenery of mathematical programming, referring to the selection of the best available alternative. It always makes reference to some kind of objective function to minimise/maximize.

An optimization problem can be defined, given a function from some set A to the real numbers, as the search of a value for which f is minor/greater than for every other value in the set A.

We have lots of subfields, like **linear programming** LP (f is linear and constraints are linear), **non-linear programming** (obj. fn and constraint may be non-linear), Integer Programming, Combinatorial Optimization (where the set of solutions is discrete or reducible to that)...

## Non-linear optimization

This is the basis for most neural networks learning algorithms. The obj fn or/and the constraints can have non-linear components. 

## Linear optimization

Both the objective fn and constraints are linear. 

## Integer linear programming

These are linear optimization problems in which variables have to be integers. It can be **Mixed** Integer Linear Programming if some of the variables are continuous. 

We'll need derivatives knowledge. 

## Some maths we'll need

We'll have to know the concept of **minimum/maximum** (0-derivative, +/- 2nd derivative), the **Jacobian**, i.e. the generalization of the derivative to vector-valued functions. It's the vector containing the partial derivatives of the function over the single variables. 

The **hessian** corresponds to the second derivatives: a square matrix of the partial derivatives wrt different variable couples. 

The trace of the hessian is the **Laplacian** (vector of 2nd order partial derivatives). 

A **taylor series** represents, polinomially, a function from the values of the function derivatives at a point $c$, with an infinite number of terms. If we don't write every term, the function gets approximated.

A function is **convex** if given any two point, if we consider a point in the domain in-between these two points, the value of the function is below it, i.e. the line segment between any two points lies above or on the graph. It can be extended to 2D.

The **inner product** (aka inner product) is given by the sum of the products of the corresponding elements of the two vectors. 

The **dot product** is different, having magnitude and angle.

The inner product of orthogonal vectors is 0. A vector normal to a plane is orthogonal to any vector lying on the plane.

A **plane** is defined by a point and a vector normal to the plane. We can therefore derive the equation of the plane. We have a vector $overrightarrow{n}$ having 3 components, vector $overrightarrow{v}$ too, $overrightarrow{v_0}$ is the same. If we take the inner product of n by $v-v_0$, I get a value v (so the inner product would be 0). Therefore, $v-v_0$ can be represented as the different of the components, and the inner product is the sum of the corresponding elements of the two vectors. Finally, we get:
$$
a(x-x_0)+b(y-y_0)+c(z-z_0)
$$
if we define $d=x_0+y+0+z+0$, the equation becomes $ax+by+cz=d$. The normal vector $n$ is $(a,b,c)$.



