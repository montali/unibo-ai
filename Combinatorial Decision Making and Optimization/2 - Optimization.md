# Nonlinear programming

## Newton method

The methods we'll present today were developed a while ago. We start from **Newton**, who proposed a method to find approximate roots of non-linear equations. It's not an optimization method, it just permits to find approximate solutions of the domain values where, given a function, takes value 0.

It tries to find value $x_0$ in the domain, where $f(x_0)=0$.

If we wanted to perform optimization (minimum/maximum), it assumes the non-linear function, and tries to find the root solution, starting somewhere sufficiently close to this root we're looking for, compute the derivativ eof the function in that particular point, and move in the direction of decreasing/increasing.

The equation of the tangent at $x_0$ is:
$$
y=f^{\prime}\left(x_{0}\right)\left(x-x_{0}\right)+f\left(x_{0}\right)
$$
and we want to find the intercept with the X axis:
$$
0=f^{\prime}\left(x_{0}\right)\left(x-x_{0}\right)+f\left(x_{0}\right)
$$
This method only works for unconstrained non-linear functions, when it works, it is quite fast, and in order to use it I must define a satisfaction level in the form of an error (it is not guaranteed that I find the actual root) or a limit to the iterations. 

A python implementation of this method might be the following:

```python
def newton(f,Df,x0,epsilon,max_iter):
    '''Approximate solution of f(x)=0 by Newton's method.

    Parameters
    ----------
    f : function
        Function for which we are searching for a solution f(x)=0.
    Df : function
        Derivative of f(x).
    x0 : number
        Initial guess for a solution f(x)=0.
    epsilon : number
        Stopping criteria is abs(f(x)) < epsilon.
    max_iter : integer
        Maximum number of iterations of Newton's method.

    Returns
    -------
    xn : number
        Implement Newton's method: compute the linear approximation
        of f(x) at xn and find x intercept by the formula
            x = xn - f(xn)/Df(xn)
        Continue until abs(f(xn)) < epsilon and return xn.
        If Df(xn) == 0, return None. If the number of iterations
        exceeds max_iter, then return None.

    Examples
    --------
    >>> f = lambda x: x**2 - x - 1
    >>> Df = lambda x: 2*x - 1
    >>> newton(f,Df,1,1e-8,10)
    Found solution after 5 iterations.
    1.618033988749989
    '''
    xn = x0
    for n in range(0,max_iter):
        fxn = f(xn)
        if abs(fxn) < epsilon:
            print('Found solution after',n,'iterations.')
            return xn
        Dfxn = Df(xn)
        if Dfxn == 0:
            print('Zero derivative. No solution found.')
            return None
        xn = xn - fxn/Dfxn
    print('Exceeded maximum iterations. No solution found.')
    return None
```

If we want to find maximums or minimums, we know that the derivative is $0$ in this points. We're therefore seeking for the roots of the derivatives!

By means of the Newton method, we try to move towards these roots.

When we move to multivariate cases, like a paraboloid $f(x,y)=x^2+y^2$, we know that the derivatives are $2x$ and $2y$. The **gradient** (Jacobian of a scalar) is the vector of these partial derivatives: $\nabla f =[2x,2y]$, which becomes $0$ only when $x=0,y=0$. We know that local optima sit at $\nabla f=0$.

This is a method that makes use of derivatives. There are other *derivative-free* methods, and they are of interest for a number of reasons, mainly because it sometimes is difficult to compute derivatives, or the function is not derivable in every point. We won't cover them, but they have to be mentioned:

* Simple line search
* Dichotomous search
* Golden section method
* Nelder-Mead
* Particle Swarm Optimization

These could be used in projects.

## Gradient descent

Just a couple of centuries ago. This was implemented in many different contexts. The idea is to **exploit the Newton approach**, but *without looking for the intercept on the X axis*. Simply, we move in the direction which is suggested by the gradient. For example, if I had to find the minimum of a function, I try to find a near point, compute the gradient of the function in that point, and move along the gradient direction for a **step**. I then recompute the gradient on this point, and go on. Obviously, the choice of the step size is **crucial**. If we choose too big of a step, we get far from the optimum and oscillate. If we choose a too little step, it may take too long to find the solution. 

We try to minimise the **mean square error** by gradient descent.

We could create a linear classifier with GD. This is not that robust (SVM for better performance).

It permits to classify all elements as belonging to a low value of a logistic function, and high values of the logistic function. There are also values in which the logistic function is not that clearly high or low. 

Maybe, the function to optimize is *derived* from some other application setting. This is the case of learning with multilayer perceptrons: there are cases in which the function I want to optimise takes a lot of time in order to be computed. There are ways to derive the gradient of this function, and a few improvements have been proposed. 

One of these options is the **stochastic gradient descent**, in which we take a subset of the sample points, and perform the error computation only with respect to these. Notice that they are **randomly chosen**. Next iteration, I randomly select another subset. 

## Scipy

Here we can find the Newton and GD methods.

## Lagrangian optimization

So far we have seen **unconstrained optimization**. Moving to **constrained optimization**, the major contribution was given by Giuseppe Lagrangia (Lagrange). His contribution was based on the assumption that constraints actually didn't exist. 

*I want to find the minimum, but the point must be kept inside this green plane.* This obviously generates inconsistencies in the previous methods, especially in the determination of a final solution. 

We'll therefore still need a way of moving towards the optimum in this constrained case. 

We have to distinguish between cases for **equality** constraints and cases for **inequality** constraints. 

### Equality constraints

To check for local optimality, we consider the constraining hyperplane. If this is parallel to the function's gradient, it means that we're at an optimum point. For it to be parallel, we have to check that:
$$
\nabla f=\mu \nabla h
$$
where $\mu$ is called a **lagrangian multiplier**, and is a scalar.

### Inequality constraints

In case of inequality constraints, the situation is more complicated: I'm not anymore constrained to a surface, rather to a space. I start from a point, and I can move anywhere as long as I keep inside my desired space. Constraints could be $\ge$ or $\le$. Starting from $\ge$, assuming that the optmial solution lies on the bottom of the paraboloid, the situation is basically as before: I can move anywhere in the subspace, I can follow the gradient and move along it, as long as I don't hit the limiting plane of my inequality.

Sooner or later, I will hit it, and then I am in the same situation for the equality case: I won't move away from this plane, since doing so would mean an increase in the objective function. The following trajectory would be the exact same:
$$
\nabla f=\lambda \nabla g
$$
with $\lambda>0$.

The case of $\le$ is somewhat different: the constraint is not a *real constraint* anymore. We can move along the gradient without hitting the borders of the constraint hyperplane. If we set the lagrangian multiplier to 0, I can represent the condition by means of the same formula of before, knowing that in order to be valid, I must have null Lagrangian multipliers.















