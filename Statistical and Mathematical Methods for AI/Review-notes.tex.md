# Numerical computation and finite numbers

## Solving a problem

Usually, to solve a problem, we can enumerate some simple steps:

- Developing a **mathematical model**;
- Developing algorithms to compute the **numerical solution**;
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

- **Absolute error**: <img src="svgs/98d8410703d5a79d12a93e7726ce2b25.svg?invert_in_darkmode" align=middle width=81.209865pt height=22.46574pt/>
- **Relative error**: <img src="svgs/da0fc63cdd1f48dd120e844cf3d73d35.svg?invert_in_darkmode" align=middle width=69.830805pt height=28.424219999999995pt/>, obviously stating that <img src="svgs/c831bfaf6e49a680a4f1250d2dcd6d3f.svg?invert_in_darkmode" align=middle width=39.53185500000001pt height=22.831379999999992pt/>

## Accuracy and precision

**Precision** does not measure error: it simply expresses the number of digits we're using. **Accuracy** does: it is the number of **correct** significant digits. One might ask: **what the f\*\*k is a significant digit?** The number <img src="svgs/d0e77e0ae0c927639bbf59b3dd1c524b.svg?invert_in_darkmode" align=middle width=9.395100000000005pt height=21.95721pt/> is said to approximate <img src="svgs/332cc365a4987aacce0ead01b8bdcc0b.svg?invert_in_darkmode" align=middle width=9.395100000000005pt height=14.155350000000013pt/> to <img src="svgs/2103f85b8b1477f430fc407cad462224.svg?invert_in_darkmode" align=middle width=8.556075000000003pt height=22.831379999999992pt/> significant digits if <img src="svgs/2103f85b8b1477f430fc407cad462224.svg?invert_in_darkmode" align=middle width=8.556075000000003pt height=22.831379999999992pt/> is the **largest non-negative** integer for which <img src="svgs/a8597e9b7f58c1a38e482d33571b2098.svg?invert_in_darkmode" align=middle width=98.48173499999999pt height=34.281719999999986pt/>.

## Data error and computational error

In a computational problem, we can define the **total error** as <img src="svgs/bf78575119f4c27fd0de3d6ddc142359.svg?invert_in_darkmode" align=middle width=84.08697000000001pt height=31.50708000000001pt/>, where <img src="svgs/c41f490710f05d3d7b527a61b284ef00.svg?invert_in_darkmode" align=middle width=11.758230000000003pt height=31.50708000000001pt/> is the approximated function, while <img src="svgs/f84e86b97e20e45cc17d297dc794b3e8.svg?invert_in_darkmode" align=middle width=9.395100000000005pt height=22.831379999999992pt/> is the approximated input: it is pretty obvious that the error depends on both the function approximation and the data one. The error inherent to the function one is called **computational error** <img src="svgs/efa4295436c149c1dbde725d48655605.svg?invert_in_darkmode" align=middle width=84.086805pt height=31.50708000000001pt/>, the one inherent to the data is called **propagated data error** <img src="svgs/4b2045f21d7317e34c0a4e46dea9b60a.svg?invert_in_darkmode" align=middle width=84.08697000000001pt height=24.65759999999998pt/>.

We can further divide the computational error into the **truncation error** and the **rounding error**. The first one states the difference between the true result and the one produced by given algorithm using **exact arithmetic** (due to approximations such as truncating infinite series), the latter states the difference between the result produced by given algorithm using exact arithmetic and result produced by the same algorithm using **limited precision** arithmetic (due to inexact representation of real numbers). 

## Sensivity and conditioning

**Sensitivity** and **conditioning** are concerned with propagated data error. **Conditioning** is just a way to quantitatively measure sensitivity. A problem is **sensitive** (or **ill-conditioned**) if the relative change in the solution can be much larger than the one in the input data. In other words, a problem is sensitive when, if we change the input by a small quantity, the result changes a lot.

The condition number is expressed as <img src="svgs/56aceb1fc25eaae3d05d05250ab13a7a.svg?invert_in_darkmode" align=middle width=213.149805pt height=33.20559pt/>.

## Representation of a real number in basis <img src="svgs/8217ed3c32a785f0b5aad4055f432ad8.svg?invert_in_darkmode" align=middle width=10.165650000000005pt height=22.831379999999992pt/>

Given an integer <img src="svgs/2e15dd312a6a8979845225e707722553.svg?invert_in_darkmode" align=middle width=40.302405pt height=22.831379999999992pt/> a real number <img src="svgs/c831bfaf6e49a680a4f1250d2dcd6d3f.svg?invert_in_darkmode" align=middle width=39.53185500000001pt height=22.831379999999992pt/> can be expressed in a unique way as <img src="svgs/38930313ca396f93676c514673537933.svg?invert_in_darkmode" align=middle width=252.99235499999998pt height=26.76201000000001pt/>, where <img src="svgs/9da246aababfb069d71ed489a6fb485e.svg?invert_in_darkmode" align=middle width=154.15537500000002pt height=26.76201000000001pt/> is called **mantissa** <img src="svgs/c1af73a7f18e65d681c0f149e3bbb8ce.svg?invert_in_darkmode" align=middle width=91.26348pt height=27.775769999999994pt/>, and <img src="svgs/afe6fc8ae2245c9133fda046afda6180.svg?invert_in_darkmode" align=middle width=16.942035000000004pt height=22.831379999999992pt/> is the **exponential part**. The **normalized scientific representation** is the one starting with 0: <img src="svgs/376c8f263bd0a1cfb16899629845e0f7.svg?invert_in_darkmode" align=middle width=148.10086500000003pt height=24.65759999999998pt/>, the **mixed representation** has leading zeros.

## Floating point systems

We can therefore define a system of floating point numbers <img src="svgs/4eea8cf647d3dd27deea645edcad2081.svg?invert_in_darkmode" align=middle width=88.45534500000001pt height=24.65759999999998pt/>, where the parameters define the **base** <img src="svgs/8217ed3c32a785f0b5aad4055f432ad8.svg?invert_in_darkmode" align=middle width=10.165650000000005pt height=22.831379999999992pt/> , the **precision** <img src="svgs/4f4f4e395762a3af4575de74c019ebb5.svg?invert_in_darkmode" align=middle width=5.936155500000004pt height=20.222069999999988pt/>, and the exponent range <img src="svgs/d71369fd4630ca9ce95b2c4db8960a33.svg?invert_in_darkmode" align=middle width=40.641645000000004pt height=24.65759999999998pt/>. The system is **normalized** when it has no leading zeros: <img src="svgs/e0fec874e861bbf6bd95ae5bdd8df9e3.svg?invert_in_darkmode" align=middle width=46.06734pt height=22.831379999999992pt/>. Why bother to do so? The representation of each number is **unique**, we don't waste digits and the leading bit doesn't have to be stored (binary-lly speaking).

### Properties of floating point systems

A floating point number system is **finite** and **discrete**. The total number of normalized floating point numbers is given by <img src="svgs/27c7240a60b85d2886098bd47f317805.svg?invert_in_darkmode" align=middle width=205.960755pt height=26.76201000000001pt/>. The **smallest positive normalized** number, aka the **UnderFlow Level** is <img src="svgs/36fda4016eff3e1731562da57620d6b3.svg?invert_in_darkmode" align=middle width=78.158685pt height=27.656969999999987pt/>, while the largest number, aka the **OverFlow Level** is <img src="svgs/622a8011486e58eab93e4d00a5e8cf96.svg?invert_in_darkmode" align=middle width=164.09695499999998pt height=27.656969999999987pt/>. Floating point numbers are equally spaced only between successive powers of <img src="svgs/8217ed3c32a785f0b5aad4055f432ad8.svg?invert_in_darkmode" align=middle width=10.165650000000005pt height=22.831379999999992pt/>: **not all real numbers are representable**, just the **machine numbers**, i.e. elements of <img src="svgs/4eea8cf647d3dd27deea645edcad2081.svg?invert_in_darkmode" align=middle width=88.45534500000001pt height=24.65759999999998pt/>.

## Rounding rules

Since not all real numbers are representable, we have to find a way of approximating them to a floating point number <img src="svgs/e6d0263a97a594d025aae07a2798c208.svg?invert_in_darkmode" align=middle width=70.76487pt height=24.65759999999998pt/>. Usually, two strategies are used: **chop**, which truncates the number after the <img src="svgs/4f4f4e395762a3af4575de74c019ebb5.svg?invert_in_darkmode" align=middle width=5.936155500000004pt height=20.222069999999988pt/>-st digit, and **round to nearest** (aka *round to even*), using the floating point number whose last stored digit is even in case of a tie. **Round to nearest is the most accurate**: to state so, we define the accuracy characterized by *unit roundoff*, denoted by <img src="svgs/f03b6d41ffe5cc356176afeab3f2680e.svg?invert_in_darkmode" align=middle width=39.03834pt height=14.155350000000013pt/>. The first rounding rule has a <img src="svgs/1703c0b1f11080da989fad73a383de3c.svg?invert_in_darkmode" align=middle width=93.73584pt height=26.76201000000001pt/>, while the second one <img src="svgs/e14b1820bf9d06df18899511038029e2.svg?invert_in_darkmode" align=middle width=104.23347pt height=27.775769999999994pt/>. The difference is pretty easily spottable: <img src="svgs/47d54de4e337a06266c0e1d22c9b417b.svg?invert_in_darkmode" align=middle width=6.552644999999998pt height=27.775769999999994pt/>. We even have an alternative definition for <img src="svgs/f03b6d41ffe5cc356176afeab3f2680e.svg?invert_in_darkmode" align=middle width=39.03834pt height=14.155350000000013pt/>, which is the smallest <img src="svgs/7ccca27b5ccc533a2dd72dc6fa28ed84.svg?invert_in_darkmode" align=middle width=6.672451500000003pt height=14.155350000000013pt/> such that <img src="svgs/9ec029ef57e67a76c54a1d3d15c97e0d.svg?invert_in_darkmode" align=middle width=92.950935pt height=24.65759999999998pt/>.

We know that the maximum relative error in representing a real number x is always lesser or equal to <img src="svgs/aaa62263c41d42f00da2eab65d60334c.svg?invert_in_darkmode" align=middle width=40.02009pt height=14.155350000000013pt/>: <img src="svgs/d6a0265a2d3c5ddf8919996eb5a74c72.svg?invert_in_darkmode" align=middle width=123.24048pt height=37.80842999999999pt/>.

Remember: **do not confuse <img src="svgs/f03b6d41ffe5cc356176afeab3f2680e.svg?invert_in_darkmode" align=middle width=39.03834pt height=14.155350000000013pt/> with UFL**, the first one is decided by the precision <img src="svgs/4f4f4e395762a3af4575de74c019ebb5.svg?invert_in_darkmode" align=middle width=5.936155500000004pt height=20.222069999999988pt/> of the mantissa, the second one by the minimum exponent <img src="svgs/ddcb483302ed36a59286424aa5e0be17.svg?invert_in_darkmode" align=middle width=11.187330000000003pt height=22.46574pt/>. Therefore, <img src="svgs/3954f67dfa4b417326be68386c393c29.svg?invert_in_darkmode" align=middle width=187.926255pt height=22.46574pt/>.

### Subnormals and gradual underflow

You can easily imagine how normalization causes a gap around zero: to solve this, we can allow leading zeros just when the exponent is at its minimum value. We have filled in the gap with **additional subnormal/denormalized floating point numbers**. These extend the range of representable magnitudes, without increasing the precision. Augmented systems, therefore, exhibit **gradual underflow**.

IEEE has introduced some exceptional values, like <img src="svgs/d8fbc05883bc9ebbcf639b4cdf6bb85f.svg?invert_in_darkmode" align=middle width=64.24621499999999pt height=20.09139000000001pt/> and <img src="svgs/1f31616e14bdba2ef27b7f858f60401f.svg?invert_in_darkmode" align=middle width=25.890315pt height=20.09139000000001pt/>, which stands for *Not a Number*.

## Floating point arithmetic

Results of floating point arithmetic operations might differ from the real ones: in **addition and subtraction**, the shifting of mantissa to match the exponents might cause loss of digits, in **multiplication** the product might contain up to <img src="svgs/b03d2c90e8d8e2b659ff5a34285a73c2.svg?invert_in_darkmode" align=middle width=14.155350000000004pt height=21.18732pt/> digits, in **division** the quotient might contain more than <img src="svgs/4f4f4e395762a3af4575de74c019ebb5.svg?invert_in_darkmode" align=middle width=5.936155500000004pt height=20.222069999999988pt/> digits. Real results may also fail to be representable because the exponent <img src="svgs/2ec6e630f199f589a2402fdf3e0289d5.svg?invert_in_darkmode" align=middle width=8.270625000000004pt height=14.155350000000013pt/> is beyond available range. Keep in mind that **overflow is worse than underflow**: ultra small numbers can be rounded to 0, ultra big ones are not <img src="svgs/f7a0f24dc1f54ce82fecccbbf48fca93.svg?invert_in_darkmode" align=middle width=16.438455000000005pt height=14.155350000000013pt/>.

Ideally, we want floating point operations to produce correctly rounded results: <img src="svgs/7725b68af0182eba6d3d16999de98c64.svg?invert_in_darkmode" align=middle width=168.06355499999998pt height=24.65759999999998pt/>. Computers satisfying IEEE standards achieve this ideal, as long as <img src="svgs/ec42c40fec0c601f7e47e78a2589360c.svg?invert_in_darkmode" align=middle width=45.241845pt height=14.155350000000013pt/> is within the range of the floating point system.

### Cancellation

**Cancellation** happens when we subtract two <img src="svgs/4f4f4e395762a3af4575de74c019ebb5.svg?invert_in_darkmode" align=middle width=5.936155500000004pt height=20.222069999999988pt/>-digit numbers having same sign and similar magnitudes, yielding results with fewer than <img src="svgs/4f4f4e395762a3af4575de74c019ebb5.svg?invert_in_darkmode" align=middle width=5.936155500000004pt height=20.222069999999988pt/> digits: leading digits of the two numbers cancel (their difference is <img src="svgs/29632a9bf827ce0200454dd32fc3be82.svg?invert_in_darkmode" align=middle width=8.219277000000005pt height=21.18732pt/>).

# Linear algebra basics for AI

## Vector spaces

A **vector space** over a field <img src="svgs/b8bc815b5e9d5177af01fd4d3d3c2f10.svg?invert_in_darkmode" align=middle width=12.853995000000003pt height=22.46574pt/> (which might be, for example, <img src="svgs/f3e711926cecfed3003f9ae341f3d92b.svg?invert_in_darkmode" align=middle width=11.872245000000005pt height=22.64855999999997pt/> or <img src="svgs/81324f07e9ffb7920321df72cc0bee1b.svg?invert_in_darkmode" align=middle width=11.872245000000005pt height=22.64855999999997pt/>) is a set closed under **vector addition** and **scalar multiplication**. The elements of <img src="svgs/a9a3a4a202d80326bda413b5562d5cd1.svg?invert_in_darkmode" align=middle width=13.242075000000003pt height=22.46574pt/> are called **vectors** while the elements of <img src="svgs/b8bc815b5e9d5177af01fd4d3d3c2f10.svg?invert_in_darkmode" align=middle width=12.853995000000003pt height=22.46574pt/> are called **scalars**. The two operations must satisfy the **commutativity and associativity** of addition, the **existence of the identity element** for addition, the **existence of the additive inverse** (<img src="svgs/f6f6858821f6de3e0e0582b3ddb1537e.svg?invert_in_darkmode" align=middle width=46.575374999999994pt height=22.46574pt/>), the **existence of the identity element** for scalar multiplication (<img src="svgs/546cb86004fe0f4c80868528f2a05eb4.svg?invert_in_darkmode" align=middle width=41.164365000000004pt height=22.46574pt/>), the **compatibility of scalar multiplication with field multiplication**, the **distributivity of scalar multiplication** with respect to field addition, the **distributivity of scalar multiplication** with respect to vector addition.

For example some vector spaces might be <img src="svgs/8a86f4a11e2fbfc03de61d587ba826de.svg?invert_in_darkmode" align=middle width=19.998330000000006pt height=22.64855999999997pt/> , <img src="svgs/4397b563e5324f31e1f31a0dcb1c00dd.svg?invert_in_darkmode" align=middle width=19.998330000000006pt height=22.64855999999997pt/>, <img src="svgs/6ee7f3ea71fe37cfe8a9d444203cb1a7.svg?invert_in_darkmode" align=middle width=18.171780000000005pt height=22.64855999999997pt/> (polynomials with degree <img src="svgs/4f733d7c20d8dfac63d05769f79e5ebd.svg?invert_in_darkmode" align=middle width=27.218400000000003pt height=20.908799999999992pt/>).

Given a vector space <img src="svgs/a9a3a4a202d80326bda413b5562d5cd1.svg?invert_in_darkmode" align=middle width=13.242075000000003pt height=22.46574pt/> over the field <img src="svgs/b8bc815b5e9d5177af01fd4d3d3c2f10.svg?invert_in_darkmode" align=middle width=12.853995000000003pt height=22.46574pt/>, the set <img src="svgs/84c95f91a742c9ceb460a83f9b5090bf.svg?invert_in_darkmode" align=middle width=17.808285000000005pt height=22.46574pt/> is a **subspace** of <img src="svgs/a9a3a4a202d80326bda413b5562d5cd1.svg?invert_in_darkmode" align=middle width=13.242075000000003pt height=22.46574pt/> if and only if <img src="svgs/42615d7f0ce1a1b1449cdeef5973ef8b.svg?invert_in_darkmode" align=middle width=52.96797pt height=22.46574pt/> (**subset**) and <img src="svgs/84c95f91a742c9ceb460a83f9b5090bf.svg?invert_in_darkmode" align=middle width=17.808285000000005pt height=22.46574pt/> is a **vector space** over <img src="svgs/b8bc815b5e9d5177af01fd4d3d3c2f10.svg?invert_in_darkmode" align=middle width=12.853995000000003pt height=22.46574pt/>.

## Linear independence

Given a vector space <img src="svgs/a9a3a4a202d80326bda413b5562d5cd1.svg?invert_in_darkmode" align=middle width=13.242075000000003pt height=22.46574pt/> over <img src="svgs/b8bc815b5e9d5177af01fd4d3d3c2f10.svg?invert_in_darkmode" align=middle width=12.853995000000003pt height=22.46574pt/>, the set <img src="svgs/84c95f91a742c9ceb460a83f9b5090bf.svg?invert_in_darkmode" align=middle width=17.808285000000005pt height=22.46574pt/> of all finite linear combinations of vectors <img src="svgs/ac00f6cfcf3e00b4d18b2815a9a8fbac.svg?invert_in_darkmode" align=middle width=80.546235pt height=24.65759999999998pt/>, with <img src="svgs/1c5d5e44e91b0e80d8cd0db25441b56f.svg?invert_in_darkmode" align=middle width=46.774035000000005pt height=22.46574pt/> is called the **subspace spanned by** <img src="svgs/e283713453ff07ba6652a2f92f7a1e8b.svg?invert_in_darkmode" align=middle width=100.47114pt height=24.65759999999998pt/> and it is written as <img src="svgs/f0c43409f758db3530677aeeea3c7513.svg?invert_in_darkmode" align=middle width=368.073255pt height=26.438939999999977pt/>. The system <img src="svgs/ac00f6cfcf3e00b4d18b2815a9a8fbac.svg?invert_in_darkmode" align=middle width=80.546235pt height=24.65759999999998pt/> is called a **system of generators** for <img src="svgs/a9a3a4a202d80326bda413b5562d5cd1.svg?invert_in_darkmode" align=middle width=13.242075000000003pt height=22.46574pt/>. 

Now, given a vector space <img src="svgs/a9a3a4a202d80326bda413b5562d5cd1.svg?invert_in_darkmode" align=middle width=13.242075000000003pt height=22.46574pt/> over <img src="svgs/b8bc815b5e9d5177af01fd4d3d3c2f10.svg?invert_in_darkmode" align=middle width=12.853995000000003pt height=22.46574pt/>, a system of vectors <img src="svgs/ac00f6cfcf3e00b4d18b2815a9a8fbac.svg?invert_in_darkmode" align=middle width=80.546235pt height=24.65759999999998pt/> is said **linearly independent** if <img src="svgs/831f80c2ceefed9586702f135745f431.svg?invert_in_darkmode" align=middle width=380.90530499999994pt height=21.18732pt/> with <img src="svgs/5a379de6b56db6751e2b9716f4178d51.svg?invert_in_darkmode" align=middle width=102.14803500000001pt height=22.46574pt/>. Otherwise, the system is called **linearly dependent**. From a geometrical point of view, vectors are linearly dependent if they lie on the same hyperplane.

We call a **basis** for a vector space <img src="svgs/a9a3a4a202d80326bda413b5562d5cd1.svg?invert_in_darkmode" align=middle width=13.242075000000003pt height=22.46574pt/> any system of linearly independent generators of <img src="svgs/a9a3a4a202d80326bda413b5562d5cd1.svg?invert_in_darkmode" align=middle width=13.242075000000003pt height=22.46574pt/>.

If a vector space <img src="svgs/a9a3a4a202d80326bda413b5562d5cd1.svg?invert_in_darkmode" align=middle width=13.242075000000003pt height=22.46574pt/> admits a basis of <img src="svgs/55a049b8f161ae7cfeb0197d75aff967.svg?invert_in_darkmode" align=middle width=9.867000000000003pt height=14.155350000000013pt/> vectors, any other basis of <img src="svgs/a9a3a4a202d80326bda413b5562d5cd1.svg?invert_in_darkmode" align=middle width=13.242075000000003pt height=22.46574pt/> will have exactly <img src="svgs/55a049b8f161ae7cfeb0197d75aff967.svg?invert_in_darkmode" align=middle width=9.867000000000003pt height=14.155350000000013pt/> elements. <img src="svgs/55a049b8f161ae7cfeb0197d75aff967.svg?invert_in_darkmode" align=middle width=9.867000000000003pt height=14.155350000000013pt/> is the **dimension** of <img src="svgs/a9a3a4a202d80326bda413b5562d5cd1.svg?invert_in_darkmode" align=middle width=13.242075000000003pt height=22.46574pt/>, noted by <img src="svgs/843ab97eb2030becd5c05de5f2440a1f.svg?invert_in_darkmode" align=middle width=86.46428999999999pt height=24.65759999999998pt/>.

## Matrices

Let $m$ and $n$ be two positive integers. We call **matrix** the rectangular array having $m$ rows and $n$ columns of elements in a field F:

$\mathrm{A}=\left[\begin{array}{cccc}
a_{11} & a_{12} & \cdots & a_{1 n} \\
a_{21} & a_{22} & \cdots & a_{2 n} \\
\vdots & \vdots & \ddots & \vdots \\
a_{m 1} & a_{m 2} & \cdots & a_{m n}
\end{array}\right]$

If $F=\mathbb{R}$ we write, for example, $A \in \mathbb{R}^{m\times n}$. If $m=n$ we can say the matrix is **square**. The set of entries where $i=j$ is the **main diagonal**. The maximum number of linearly independent columns (or rows!) is called **rank**. $A$ is said to be **complete** or **full rank** if $rank(A)=min(m,n)$.

A **lower triangular** matrix is a matrix that has elements in the diagonal and under it. An upper triangular matrix has elements in the diagonal and over it.

We can do operations with matrices too! These are the most used: *matrix addition*, *matrix multiplication by a scalar*, *matrix multiplication* (notice that it is defined only when $A \in \mathbb{R}^{m\times p}, B \in \mathbb{R}^{p \times n}, p=p$), *transposition*. 

A **diagonal matrix** is a matrix having elements on the diagonal only, and 0 elsewhere.

The **identity matrix** is a diagonal matrix having 1s on the diagonal. Note that this is the identity element for the multiplication. 

A matrix $A$ is called **invertible** (or **nonsingular**) if there exists a matrix $B$ such that $AB=BA=I$. $B$ is called the **inverse** of $A$ and it is denoted by $A^{-1}$. A non-invertible matrix is said **singular**. The inverse of a matrix is also invertible, and it results in the original matrix. The inverse of a product is the product of the inverses: $(AB)^{-1} = B^{-1}A^{-1}$. If a square matrix is invertible, then $(A^T)^{-1}=(A^{-1})^T = A^{-T}$ .

A **square** matrix is invertible iff its column vectors are linearly independent.

A square matrix is called **symmetric** if the transpose is equal to the original matrix, i.e. $A^T=A$, **antisymmetric** if $A=-A^T$, **orthogonal** if $A^{-1}=A^T$. Note that if it is orthogonal, we have that $AA^T=A^TA=I$.

### Determinant of a matrix

Let $A \in \mathbb{C}^{n \times n}$ be a **square matrix**. We call the **determinant** of $A$ the scalar defined by 

$\operatorname{det}(\mathrm{A})=\left\{\begin{array}{cl}
a_{11} & \text { if } n=1 \\
\sum_{j=1}^{n}(-1)^{i+j} \operatorname{det}\left(\mathrm{A}_{i j}\right) a_{i j}=\sum_{i=1}^{n}(-1)^{i+j} \operatorname{det}\left(\mathrm{A}_{i j}\right) a_{i j} & \text { if } n>1
\end{array}\right.$

which is a fancy way to express that we have to:

- Fix one of the two indices;
- Put a negative sign before the quantities that belong to *indices summing to an odd number*;
- Calculate the determinant of the submatrix obtained by removal of the column and row we are analyzing;
- Multiply this quantity for the actual number at the index;
- Sum all of these.

This procedure is known as **Laplace rule**.

If $A$ is diagonal or triangular, we just have to **multiply the elements on the diagonal**.

The determinant has some interesting properties:

- **Transposing** the matrix **doesn't change** the determinant: $det(A)=det(A^T)$ 
- The **multiplication of determinants** is the **determinant of multiplications** in square matrices having the same size: $det(AB)=det(A)det(B)$
- The determinant of the **inverse** is $\frac{1}{det(A)}$ : $det(A^{-1})=det(A)^{-1}$
- The determinant of a scalar multiplication is the scalar multiplication to the power $n$, with $n$ being the matrix size: $det(\alpha A) = \alpha^n det(A), \forall\alpha \in F$
- Every **orthogonal matrix** is invertible and its determinant is $\pm1$
- The determinant of a $2\times2$ square matrix is computable by subtracting the multiplication of the main diagonal elements to the one of the inverse diagonal: $\operatorname{det}(\mathrm{A})=a_{11} a_{22}-a_{21} a_{12}$
- The determinant of a $3\times3$ matrix is computable with the **Sarrus rule**, which basically is the same principle.

### Calculating the inverse using the determinant

If $A$ is invertible, then its inverse is computable by calculating the **cofactor matrix**, which contains elements defined by $c_{i j}=(-1)^{i+j} \operatorname{det}\left(\mathrm{A}_{i j}\right)$, called **cofactors**.

$A^{-1}=\frac{C^T}{det(A)}$

### Eigenvalues and eigenvectors

Let's consider a **square** matrix $A \in \mathbb{C}^{n\times n}$. The number $\lambda$ is called an **eigenvalue** of $A$ if we have a vector $x\neq 0$, named **eigenvector**, such that $Ax=\lambda x$. The set of eigenvalues is called **spectrum** of $A$ and it is denoted by $\sigma(A)$. 

**How can we find these eigenvalues?** They are the solutions of the characteristic equation: $p_A(\lambda) = det(A-\lambda I)=0$, where $p_A(\lambda)$ is called the **characteristic polynomial**. Thanks to the fundamental theorem of algebra we can say that a matrix with **real or complex** entries has $n$ eigenvalues, counted with their multiplicity. The algebraic multiplicity of an eigenvalue $\lambda_i$ is the number of times the root appears in the characteristic polynomial. Let's make an example: we have a matrix $A=\left(\begin{array}{lll}
0 & 1 & 0 \\
1 & 0 & 0 \\
0 & 0 & 1
\end{array}\right)$, and we'll now calculate $p_A=det(A-\lambda I)$:

$\begin{array}{l}
p_{A}(\lambda)=\operatorname{det}\left(A-\lambda \mathrm{Id}_{3}\right)= \\
=\operatorname{det}\left[\left(\begin{array}{ccc}
0 & 1 & 0 \\
1 & 0 & 0 \\
0 & 0 & 1
\end{array}\right)-\lambda\left(\begin{array}{ccc}
1 & 0 & 0 \\
0 & 1 & 0 \\
0 & 0 & 1
\end{array}\right)\right]= \\
=\operatorname{det}\left[\left(\begin{array}{ccc}
0 & 1 & 0 \\
1 & 0 & 0 \\
0 & 0 & 1
\end{array}\right)-\left(\begin{array}{ccc}
\lambda & 0 & 0 \\
0 & \lambda & 0 \\
0 & 0 & \lambda
\end{array}\right)\right]= \\
=\operatorname{det}\left(\begin{array}{ccc}
-\lambda & 1 & 0 \\
1 & -\lambda & 0 \\
0 & 0 & 1-\lambda
\end{array}\right)= \\
=(1-\lambda)\left(\lambda^{2}-1\right)
\end{array}$

As you can see, we have two roots $1, -1$, but $1$ cancels $p_A$ two times, so it will have multiplicity $2$, while $-1$ will have multiplicity $1$.

Note that the sum of the multiplicities **can never** be higher than the matrix dimension.

The maximum eigenvalue **in module** of a matrix $A \in \mathbb{C}^{n\times n}$ is called the **spectral radius** of $A$ and is denoted by $\rho(A)$: $\rho(\mathrm{A})=\max _{\lambda \in \sigma(\mathrm{A})}|\lambda|$. The set of all the eigenvalues is called the **spectrum** of $A$.

Please note that the **eigenvectors are not unique**: for example, multiplying all of the eigenvectors by a constant $c$ would still make them valid eigenvectors for the same values.

We can **link the eigenvalues to the determinant**! In fact, the determinant of a square matrix is the product of all its eigenvalues: $\operatorname{det}(\mathrm{A})=\prod_{i=1}^{n} \lambda_{i}$.

A matrix is **singular** iff it has at least **one null eigenvalue**.

**Eigenvalues in triangular and diagonal matrices are ultra easy!** In fact, they are the elements of the diagonal. 

A symmetric ($A^T=A$) positive (semi)definite matrix has eigenvalues greater(equal) than(to) zero.

Two matrices **with the same size** are said **similar** if the nonsingular matrix $P$ exists: $B=PAP^{-1}$. This implies that they have the **same eigenvalues** too.

### Scalar product and norms in vector spaces

Let's consider a vector space $V$ over the field $F$. We define a function $||\cdot||:V\rightarrow F$ as a **norm** if it satisfies the following properties:

- It is always **greater or equal to $0$**, and it is $0$ **only when the vector itself is**: 
  $||\mathbf{v}\| \geq 0, \forall \mathbf{v} \in V \text { and }\|\mathbf{v}\|=0 \Longleftrightarrow \mathbf{v}=\mathbf{0}$
- If **multiplied by a constant**, the result is the norm **multiplied by the absolute value** of the constant: $\|\alpha \mathbf{v}\|=|\alpha| \|\mathbf{v}\|, \forall \alpha \in F, \forall \mathbf{v} \in V$
- The **norm of a sum** is **less or equal** than the **sum of the norms**: $\|\mathbf{v}+\mathbf{w}\| \leq\|\mathbf{v}\|+\|\mathbf{w}\|, \forall \mathbf{v}, \mathbf{w} \in V$

If $\alpha \in \mathbb{C}$, its module is called a *normed space*. 

Now, considering a generic vector $v$, its **euclidean norm** is $\|\mathbf{v}\|_{2}=\sqrt{v_{1}^{2}+v_{2}^{2}+v_{3}^{2}}$. Its **one norm** is $\|\mathbf{v}\|_{1}=\sum_{i=1}^{n}\left|v_{i}\right|$. Its **infinity norm** is $\|\mathbf{v}\|_{\infty}=\max _{i=1, \ldots, n}\left|v_{i}\right|$. Some of you may have noted a pattern: we can generalize the concept with the **p-norm** of $v$, which is $\|\mathbf{v}\|_{p}=\left(\sum_{i=1}^{n}\left|v_{i}\right|^{p}\right)^{1 / p}, 1 \leq p<\infty$.

Two norms are said **equivalent** if we can find two positive constants $c_{pq}$ and $C_{pq}$ that we can multiply the norm for to obtain the following inequality: $c_{p q}\|\mathbf{x}\|_{q} \leq\|\mathbf{x}\|_{p} \leq C_{p q}\|\mathbf{x}\|_{q} \forall \mathbf{x} \in V$. This is a fancy concept but it reveals a great thing: **in a vector space all the $p$ norms are equivalent!**

### Matrix norms

A matrix norm is a function satisfying the above-mentioned properties. We can say that a matrix norm $\|A\|$ is **compatible** with a vector norm $\|x\|$ if the norm of the multiplication is lesser or equal than the multiplication of the norms: $|\mathrm{Ax}||\leq\|\mathrm{A}\| \| \mathbf{x}|$.

The **spectral norm** of a matrix is equal to $\|\mathrm{A}\|_2 =\sqrt{\rho\left(\mathrm{A}^{T} A\right)}$. Note that the **spectral norm of the identity matrix** is equal to $1$.

We can say that the ***1-norm*** of a matrix is the maximum between the sums of the **columns** absolute values: $\|\mathrm{A}\|_{1}=\max _{j=1, \ldots, n} \sum_{i=1}^{n}\left|a_{i j}\right|$. Obviously, when dealing with identity matrices this will be equal to $1$.

The ***infinity norm*** is the same concept, but on **rows**: $\|\mathrm{A}\|_{\infty}=\max _{i=1, \ldots, n} \sum_{j=1}^{n}\left|a_{i j}\right|$. Notice that on **symmetric matrices** these two values coincide. Obviously, when dealing with identity matrices this will be equal to $1$.

Lastly, we define the **Frobenius norm** of a matrix $A$ as the square root of the sum of all the squares:

$\|\mathrm{A}\|_{F}=\sqrt{\sum_{i, j=1}^{n}\left|a_{i j}\right|^{2}}$. For identity matrices, this will be equal to $\sqrt{n}$.

# Matrix decompositions

**Matrix factorisations** (aka decompositions) are incredibly useful tools for linear algebra problems. They write a generic matrix $A$ as a product of matrices, that are usually easier to compute (for example, triangulars or diagonals).

Let's start by considering factorizations by **triangular matrices**.

## Gaussian elimination method

Let's consider a square matrix $A \in \mathbb{R}^{n\times n}$. If $A$ is non-singular (therefore, it is invertible) and all its **principal minors** are non-singular, then we can find two matrices $L$ and $U$ that, multiplied, result in $A$. The cool thing is that $L$ stands for **Lower triangular**, while $U$ stands for **Upper triangular**. Pretty useful, huh?

We call this the **LU factorization** (*no shit, Sherlock*).

The matrices can be computed in $n-1$ steps with the so-called **Gaussian Elimination Method**, which has a computational cost of $\mathcal{O}(n^3/3)$. We can start by computing the matrix $U$ as follows: we define a matrix $M^{(K)}$ of multipliers, with the diagonal elements equal to $1$, the elements under the diagonal **on the column k** $m_{i k}=-\frac{a_{i k}^{(k)}}{a_{k k}^{(k)}}, i=k+1, \ldots, n$, and $0$ otherwise. We then compute $A^{(k+1)} = M^{(k)}A^{(k)}$, then iterate until we obtain $A^{(n)}=U$.

There's just one problem: this algorithm is **unstable**! This means that the **algorithmic error is not limited**, and it happens because the elements $a_{kk}^{(k)}$ can be ultra small (or even zero!), thus leading to errors. We can solve this problem by computing the **pivoting algorithm**, i.e. we swap two rows so that $a_{kk}^{(k)}$ is the element with the maximum absolute value. We then get a **permutation matrix** $P$, i.e. an **identity matrix with the needed rows swapped**.

When we're dealing with **symmetric positive definite** matrices there's a great simplification: it is always possible to compute the LU factorization **without pivoting** and it simply is $A=LL^T$. This factorization is obviously less costly: using the Cholesky algorithm, it has a complexity of $\mathcal{O}(n^3/6)$.

We can therefore use the **Cholesky decomposition**, which is greatly used in ML because we often deal with symmetric positive definite matrices, like the covariance matrix of a multivariate Gaussian. This decomposition can be used to efficiently compute the determinant too: since the obtained matrices are triangular, the determinant will just be the **product of the diagonal**. 

## Decompositions involving diagonal matrices

These ones are about a diagonal matrix, not a triangular one.

There are two main decompositions involving diagonal matrices: the **eigendecomposition** and the **Singular Value Decomposition**. 

### Eigendecomposition

Let's consider a **square matrix** $A$ of size $n\times n$, which can be decomposed as $A=PDP^{-1}$. $P$ is a non-singular (obviously: we have to invert it!) matrix of size $n\times n$ and $D$ is a diagonal matrix with the eigenvalues on the diagonal. Beware: the eigenvectors **have to be linearly independent** and **form a basis** of $\mathbb{R}^n$. This decomposition can **only be applied to square matrices with particular properties on their spectrum**.

### Singular Value Decomposition (SVD)

This one can be applied to **all the matrices**. Pretty cool, huh? First, tho, we need to clarify a few concepts:

- Two vectors $u,v \in \mathbb{R}^n$ are **orthogonal** if their product is equal to 0. This is the vector product, i.e. the product you'd obtain by multiplicating $u\times v^T$;
- A **unit vector** is a vector $u \in \mathbb{R}^n$ which has norm equal to 1: $\|u\|=1$;
- The **normalization** of a vector is the division between the vector and its norm, which always returns a **unit vector**: $\hat{u}=\frac{u}{\|u\|}$;
- A set of vectors $\{u_1,u_2,...,u_p\}, u_i \in \mathbb{R}^n$ is an **orthogonal set** if all of the possible products are equal to $0$, i.e. $\left\langle\mathbf{u}_{i}, \mathbf{u}_{j}\right\rangle=\mathbf{u}_{\mathbf{i}}^{T} \mathbf{u}_{j}=0, \forall i \neq j$;
- If some vectors are **orthogonal**, they are **linearly independent**. Therefore, the set they compose forms an orthogonal basis for $U=span\{u_1,u_2,...,u_p\}$;
- The set $\{u_1,u_2,...,u_p\}, u_i \in \mathbb{R}^n$ is an **orthonormal set** if it is an **orthogonal** set of **unit vectors**. A basis of orthonormal vector is called an **orthonormal basis**;
- Applying these concepts to matrices, we get that $U$ is an **orthogonal matrix** iff $U^TU=I$. If the matrix is **square**, then $U^T=U^{-1}$;
- If a matrix is orthogonal, then:
  - The 2-norm of the **matrix multiplied by a vector** is equal to the **2-norm of the vector only**: $\|\mathrm{Ux}\|_{2}=\|\mathrm{x}\|_{2}, \forall \mathbf{x} \in \mathbb{R}^{n}$
  - The **product between the matrix multiplied by two vectors** is the **product of the two vectors**: $\langle\mathrm{Ux}, \mathrm{Uy}\rangle=\langle\mathbf{x}, \mathbf{y}\rangle, \forall \mathbf{x}, \mathbf{y} \in \mathbb{R}^{n}$
  - Therefore, the above mentioned product is equal to $0$ **only when the product between $x$ and $y$ is**: $\langle\mathrm{Ux}, \mathrm{Uy}\rangle=0 \Longleftrightarrow\langle\mathbf{x}, \mathbf{y}\rangle=0, \forall \mathbf{x}, \mathbf{y} \in \mathbb{R}^{n}$
  - We can then conclude that **transformations by orthogonal matrices preserve both length and angles!**

Now we're ready for the real thing!

Any matrix $A \in \mathbb{R}^{m\times n}$ with $rank(A)=k$, where $k \le n$ can be written as:

$A = U \Sigma V^T$

where $U \in \mathbb{R}^{m\times m}$ is an **orthogonal matrix** with orthogonal vectors $u_i$, $V \in \mathbb{R}^{n\times n}$ is an orthogonal matrix with orthogonal vectors $v_i$, and $\Sigma \in \mathbb{R}^{m\times n}$ is a matrix whose diagonal entries are the **singular values** $\sigma_i$ of $A$ and with extra-diagonal entries equal to $0$. <img src="https://cdn.mathpix.com/snip/images/N3oanb3v-5R-_eXPha80gAU0FPOP4Y7gUgHKkjIDZrM.original.fullsize.png" />

The singular values are in **ascending order** in the diagonal, and the first $k$ are non-null while the other $n-k$ are equal to $0$. The singular matrix $\Sigma$ **is unique**, the other two **aren't**.

Observe that the matrix $\Sigma$ is rectangular, this means that it has a diagonal submatrix that contains the singular values and needs additional zero padding. 

From the geometric point of view, the SVD is nothing more than sequential linear transformations performed on the bases. The SVD intuition is similar to the eigendecomposition one: broadly speaking, it performs a basis change via $V^T$, followed by a scaling and augmentation/reduction in dimensionality via the singular value matrix $\Sigma$. Finally, it performs a second basis change via $U$.

Basically: 

- $V$ performs a basis chenage in the domain $\mathbb{R}^n$ from $\tilde{B}$ to the standard basis $B$. The inverse of $V$ (which, as $V$ is orthogonal, is $V^T=V^{-1}$) performs the inverse change from $B$ to $\tilde{B}$;
- Having changed the coordinate system to $\tilde{{B}}$, we can scale to the new coordinates by the matrix $\Sigma$, i.e. by the singular values $\sigma_i$;
- Finally, $U$ performs a basis change in the codomain $\mathbb{R}^m$ from $\tilde{{C}}$ to the canonical basis of $\mathbb{R}^m$.

Summing things up, SVD performs **two changes of basis**, via the orthogonal matrices $U$ and $V$ and a scaling operation via the matrix $\Sigma$. The columns of $U$ and $V$ are orthonormal basis of $\mathbb{R}^m$ and $\mathbb{R}^n$, respectively. The change of basis is in both the domain and the codomain: this is in contrast with the eigendecomposition, which operates within the same vector space (the basis change is applied but then undone). What makes SVD special is that these two different bases are simultaneously linked by the singular value matrix $\Sigma$.

We can link the singular values of $A$ to the eigenvalues of $A^TA$: 

- Let's first substitute A by its SVD: $A^TA = (U\Sigma V^T)^T (U\Sigma V^T) = V\Sigma^TU^TU\Sigma V^T$, which, since $U$ is orthogonal, simplifies to $V\Sigma^TI\Sigma V^T$;
- We know that $\Sigma^T\Sigma$ simplifies to a diagonal matrix with the singular values (squared) in it: $\boldsymbol{A}^{\top} \boldsymbol{A}=\boldsymbol{V} \boldsymbol{\Sigma}^{\top} \boldsymbol{\Sigma} \boldsymbol{V}^{\top}=\boldsymbol{V}\left[\begin{array}{ccc}
  \sigma_{1}^{2} & 0 & 0 \\
  0 & \ddots & 0 \\
  0 & 0 & \sigma_{n}^{2}
  \end{array}\right] \boldsymbol{V}^{\top}$ 

Hence, we know that $\sigma_i = \sqrt{\lambda_i (A^TA)}, i=\dots,n$. In particular, the **first** one will be $\sigma_1= \sqrt{\lambda_{max}(A^TA)}=\|A\|_2$, and the **last** one will be $\sigma_1= \sqrt{\lambda_{min}(A^TA)}\rightarrow\|A^{-1}\|_2 = \frac{1}{\sigma_n}$, so the 2-norm of the inverse will be the inverse of $\sigma_n$.

Therefore, the left singular vectors of $A$ are the eigenvectors of $A^TA$. The right singular vectors of $A$ are the eigenvectors of $AA^T$. **For symmetric matrices, the eigendecomposition and the SVD are the same thing.**

### Moore-Penrose inverse

The SVD can be used to compute a pseudo-inverse, named **Moore-Penrose inverse** of a matrix $A$:

$A^+=V\Sigma^+U^T$, where $\Sigma^+$ is the pseudoinverse of $\Sigma$, which is computable by taking the reciprocal of every non-zero diagonal element and transposing the matrix:

$\Sigma=\left[\begin{array}{cccc}
\sigma_{1} & 0 & \ldots & 0 \\
0 & \sigma_{2} & \ldots & 0 \\
0 & 0 & \ddots & 0 \\
0 & 0 & 0 & \sigma_{n} \\
0 & 0 & 0 & 0 \\
\vdots & \vdots & \vdots & \vdots \\
0 & 0 & 0 & 0
\end{array}\right], \quad \Sigma^{+}=\left[\begin{array}{ccccc}
\frac{1}{\sigma_{1}} & 0 & \ldots & 0 & \ldots & 0 \\
0 & \frac{1}{\sigma_{2}} & \ldots & 0 & \ldots & 0 \\
0 & 0 & \ddots & 0 & \ldots & 0 \\
0 & 0 & 0 & \frac{1}{\sigma_{n}} & \ldots & 0
\end{array}\right]$

### Matrix approximation using SVD

Given the SVD of a matrix $U\Sigma V^T$, we can use it to represent the matrix $A$ as a **sum of low-rank matrices** $A_i \in \mathbb{R}^{m\times n}$ with $rank(A_i)=1$ such that $A_i=u_i v_i^T$. The matrix $A$ can then be written as the **sum** (to $k$, which is the original rank of $A$) of **these matrices multiplied by the singular values**: $A=\sum_{i=1}^k \sigma_i A_i = \sum_{i=1}^k \sigma_i u_i v_i^T$. To obtain a rank-$p$ approximation of the matrix, we can **truncate the sum** at the index $p$. The error introduced with this approximation can be computed as the **2-norm of the difference**, $\|A-A_p\|_2$, which is equal to the **sum of the matrices from $p$ to $k$:** this quantity, though, is simply the **next singular value** $\sigma_{p+1}$. Great! This means that if $\sigma_{p+1}$ is small we have a good approximation and we can stop.

Now, if we have a rank-$p$ approximation $A_p = \sum_{i=1}^p \sigma_i u_i v_i^T$, for every matrix of the same rank $p$, we get that the 2-norm of the difference will always be greater or equal than the difference from $A$ to $A_p$. This is just a fancy way of saying that $A_p$ is the best way of approximating $A$ with a rank $p$. No other $p$-rank matrix does that better: $\forall \mathrm{B} \in \mathbb{R}^{m \times n}, \operatorname{rank}(\mathrm{B})=p,\left\|\mathrm{A}-\mathrm{A}_{p}\right\|_{2} \leq\|\mathrm{A}-\mathrm{B}\|_{2}$.

Note that this is a lossy compression. 

### Let's sum up things!

We can therefore conclude that we can decompose a matrix in lots of ways:

![Matrix decompositions](./res/matrix-decompositions.png)





 







