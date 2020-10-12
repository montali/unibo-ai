# Numerical computation and finite numbers

## Solving a problem

Usually, to solve a problem, we can enumerate some simple steps:

- Developing a **mathematical model**;
- Developing algorithm to compute the **numerical solution**;
- **Implement** these algorithms;
- Run the software to **simulate** the physical process numerically;
- **Graphically visualize** the results;
- **Interpret** and **validate** the results.

## Sources of approximation

Generally speaking, 4 types of errors can happen during the previously cited process:

- **Measure errors**: caused by the measure instrument;
- **Arithmetic errors**: the rounding errors linked to **each operation** get propagated during the algorithmic process;
- **Truncation errors**: an infinite procedure gets **truncated** to a finite one, causing loss of informations;
- **Inherent errors**: the finite representation of data might lead to loss of informations.

## Measuring error

We can talk about **absolute error** and **relative error**, the latter being the first one divided by the real value:

- **Absolute error**: $E_x = \tilde{x} - x$
- **Relative error**: $R_x = \frac{\tilde{x} - x}{x}$, obviously stating that $x \neq 0$

## Accuracy and precision

**Precision** does not measure error: it simply expresses the number of digits we're using. **Accuracy** does: it is the number of **correct** significant digits. One might ask: **what the f\*\*k is a significant digit?** The number $\tilde{x}$ is said to approximate $x$ to $d$ significant digits if $d$ is the **largest non-negative** integer for which $\left|\frac{\tilde{x}-x}{x}\right|<\frac{10^{1-d}}{2}$.

## Data error and computational error

In a computational problem, we can define the **total error** as $\hat{f}(\hat{x}) - f(x)$, where $\hat{f}$ is the approximated function, while $\hat{x}$ is the approximated input: it is pretty obvious that the error depends on both the function approximation and the data one. The error inherent to the function one is called **computational error** $\hat{f}(\hat{x}) - f(\hat{x})$, the one inherent to the data is called **propagated data error** $f(\hat{x}) - f(x)$.

We can further divide the computational error into the **truncation error** and the **rounding error**. The first one states the difference between the true result and the one produced by given algorithm using **exact arithmetic **(due to approximations such as truncating infinite series), the latter states the difference between the result produced by given algorithm using exact arithmetic and result produced by the same algorithm using **limited precision** arithmetic (due to inexact representation of real numbers). 

## Sensivity and conditioning

**Sensitivity** and **conditioning** are concerned with propagated data error. **Conditioning** is just a way to quantitatively measure sensitivity. A problem is **sensitive** (or **ill-conditioned**) if the relative change in the solution can be much larger than the one in the input data. In other words, a problem is sensitive when, if we change the input by a small quantity, the result changes a lot.

The condition number is expressed as $K = \frac{\left|\textrm{relative change in solution}\right|}{\left|\textrm{relative change in input data}\right|}$.

## Representation of a real number in basis $\beta$

Given an integer $\beta > 1$ a real number $x \neq 0$ can be expressed in a unique way as $x = \textrm{sign}(x)(d_1\beta^{-1}+d_2\beta^{-2}+...)\beta^p$, where $(d_1\beta^{-1}+d_2\beta^{-2}+...)$ is called **mantissa** $(\frac{1}{\beta} \le m < 1)$, and $\beta^p$ is the **exponential part**. The **normalized scientific representation** is the one starting with 0: $x = \pm (0.d_1d_2d_3...)\beta^p$, the **mixed representation** has leading zeros.

## Floating point systems

We can therefore define a system of floating point numbers $\mathcal{F}(\beta, t, L,U)$, where the parameters define the **base** $\beta$ , the **precision** $t$, and the exponent range $[L,U]$. The system is **normalized** when it has no leading zeros: $d_1 \neq 0$. Why bother to do so? The representation of each number is **unique**, we don't waste digits and the leading bit doesn't have to be stored (binary-lly speaking).

### Properties of floating point systems

A floating point number system is **finite** and **discrete**. The total number of normalized floating point numbers is given by $2(\beta - 1) \beta^{t-1} (U-L+1)+1$. The **smallest positive normalized** number, aka the **UnderFlow Level** is $UFL=\beta^L$, while the largest number, aka the **OverFlow Level** is $OFL=\beta^{U+1} (1-\beta^{-t})$. Floating point numbers are equally spaced only between successive powers of $\beta$: **not all real numbers are representable**, just the **machine numbers**, i.e. elements of $\mathcal{F}(\beta, t, L,U)$.

## Rounding rules

Since not all real numbers are representable, we have to find a way of approximating them to a floating point number $fl(x) \in \mathcal{F}$. Usually, two strategies are used: **chop**, which truncates the number after the $t$-st digit, and **round to nearest** (aka *round to even*), using the floating point number whose last stored digit is even in case of a tie. **Round to nearest is the most accurate**: to state so, we define the accuracy characterized by *unit roundoff*, denoted by $\epsilon_{mach}$. The first rounding rule has a $\epsilon_{mach} = \beta^{1-t}$, while the second one $\epsilon_{mach} = \frac{1}{2}\beta^{1-t}$. The difference is pretty easily spottable: $\frac{1}{2}$. We even have an alternative definition for $\epsilon_{mach}$, which is the smallest $\epsilon$ such that $fl(1+\epsilon) > 1$.

We know that the maximum relative error in representing a real number x is always lesser or equal to $e_{mach}$: $\left|\frac{fl(x)-x}{x}\right| \le \epsilon_{mach}$.

Remember: **do not confuse $\epsilon_{mach}$ with UFL**, the first one is decided by the precision $t$ of the mantissa, the second one by the minimum exponent $L$. Therefore, $0< UFL < \epsilon_{mach} < OFL$.

### Subnormals and gradual underflow

You can easily imagine how normalization causes a gap around zero: to solve this, we can allow leading zeros just when the exponent is at its minimum value. We have filled in the gap with **additional subnormal/denormalized floating point numbers**. These extend the range of representable magnitudes, without increasing the precision. Augmented systems, therefore, exhibit **gradual underflow**.

IEEE has introduced some exceptional values, like $\texttt{Inf}=\infty$ and $\texttt{NaN}$, which stands for *Not a Number*.

## Floating point arithmetic

Results of floating point arithmetic operations might differ from the real ones: in **addition and subtraction**, the shifting of mantissa to match the exponents might cause loss of digits, in **multiplication** the product might contain up to $2t$ digits, in **division** the quotient might contain more than $t$ digits. Real results may also fail to be representable because the exponent $p$ is beyond available range. Keep in mind that **overflow is worse than underflow**: ultra small numbers can be rounded to 0, ultra big ones are not $\infty$.

Ideally, we want floating point operations to produce correctly rounded results: $x\ fl(op)\ y = fl(x\ op\ y)$. Computers satisfying IEEE standards achieve this ideal, as long as $x\ op\ y$ is within the range of the floating point system.

### Cancellation

**Cancellation** happens when we subtract two $t$-digit numbers having same sign and similar magnitudes, yielding results with fewer than $t$ digits: leading digits of the two numbers cancel (their difference is $0$).





