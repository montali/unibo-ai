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

**Precision** does not measure error: it simply expresses the number of digits we're using. **Accuracy** does: it is the number of **correct** significant digits. One might ask: **what is a significant digit?** The number <img src="svgs/d0e77e0ae0c927639bbf59b3dd1c524b.svg?invert_in_darkmode" align=middle width=9.395100000000005pt height=21.95721pt/> is said to approximate <img src="svgs/332cc365a4987aacce0ead01b8bdcc0b.svg?invert_in_darkmode" align=middle width=9.395100000000005pt height=14.155350000000013pt/> to <img src="svgs/2103f85b8b1477f430fc407cad462224.svg?invert_in_darkmode" align=middle width=8.556075000000003pt height=22.831379999999992pt/> significant digits if <img src="svgs/2103f85b8b1477f430fc407cad462224.svg?invert_in_darkmode" align=middle width=8.556075000000003pt height=22.831379999999992pt/> is the **largest non-negative** integer for which <img src="svgs/a8597e9b7f58c1a38e482d33571b2098.svg?invert_in_darkmode" align=middle width=98.48173499999999pt height=34.281719999999986pt/>.

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

Let <img src="svgs/0e51a2dede42189d77627c4d742822c3.svg?invert_in_darkmode" align=middle width=14.433210000000003pt height=14.155350000000013pt/> and <img src="svgs/55a049b8f161ae7cfeb0197d75aff967.svg?invert_in_darkmode" align=middle width=9.867000000000003pt height=14.155350000000013pt/> be two positive integers. We call **matrix** the rectangular array having <img src="svgs/0e51a2dede42189d77627c4d742822c3.svg?invert_in_darkmode" align=middle width=14.433210000000003pt height=14.155350000000013pt/> rows and <img src="svgs/55a049b8f161ae7cfeb0197d75aff967.svg?invert_in_darkmode" align=middle width=9.867000000000003pt height=14.155350000000013pt/> columns of elements in a field F:

<img src="svgs/764439eb8f2ac8d931ef46049227dd9d.svg?invert_in_darkmode" align=middle width=228.59380499999997pt height=96.98732999999999pt/>

If <img src="svgs/103a36ecf09d49e563cb987384457874.svg?invert_in_darkmode" align=middle width=46.64385000000001pt height=22.64855999999997pt/> we write, for example, <img src="svgs/ad73601e39ef9a2d0bc591935b918895.svg?invert_in_darkmode" align=middle width=74.357085pt height=26.177579999999978pt/>. If <img src="svgs/fa0a66891711f605a7176c8234000201.svg?invert_in_darkmode" align=middle width=46.217655pt height=14.155350000000013pt/> we can say the matrix is **square**. The set of entries where <img src="svgs/cd479494c39d95dc8012b12ea2a67946.svg?invert_in_darkmode" align=middle width=35.291355pt height=21.683310000000006pt/> is the **main diagonal**. The maximum number of linearly independent columns (or rows!) is called **rank**. <img src="svgs/53d147e7f3fe6e47ee05b88b166bd3f6.svg?invert_in_darkmode" align=middle width=12.328800000000005pt height=22.46574pt/> is said to be **complete** or **full rank** if <img src="svgs/368f9b2b5d12434a7a8dedee0f8bb6bf.svg?invert_in_darkmode" align=middle width=156.891405pt height=24.65759999999998pt/>.

A **lower triangular** matrix is a matrix that has elements in the diagonal and under it. An upper triangular matrix has elements in the diagonal and over it.

We can do operations with matrices too! These are the most used: *matrix addition*, *matrix multiplication by a scalar*, *matrix multiplication* (notice that it is defined only when <img src="svgs/0efdbed97466f783a3d89f8b00dd976d.svg?invert_in_darkmode" align=middle width=198.154605pt height=26.177579999999978pt/>), *transposition*. 

A **diagonal matrix** is a matrix having elements on the diagonal only, and 0 elsewhere.

The **identity matrix** is a diagonal matrix having 1s on the diagonal. Note that this is the identity element for the multiplication. 

A matrix <img src="svgs/53d147e7f3fe6e47ee05b88b166bd3f6.svg?invert_in_darkmode" align=middle width=12.328800000000005pt height=22.46574pt/> is called **invertible** (or **nonsingular**) if there exists a matrix <img src="svgs/61e84f854bc6258d4108d08d4c4a0852.svg?invert_in_darkmode" align=middle width=13.293555000000003pt height=22.46574pt/> such that <img src="svgs/5e12777a129307ac636e6e8c28c0d5bc.svg?invert_in_darkmode" align=middle width=103.595745pt height=22.46574pt/>. <img src="svgs/61e84f854bc6258d4108d08d4c4a0852.svg?invert_in_darkmode" align=middle width=13.293555000000003pt height=22.46574pt/> is called the **inverse** of <img src="svgs/53d147e7f3fe6e47ee05b88b166bd3f6.svg?invert_in_darkmode" align=middle width=12.328800000000005pt height=22.46574pt/> and it is denoted by <img src="svgs/471d65ea6d03a4f1ea1dd8be931d26c9.svg?invert_in_darkmode" align=middle width=29.1555pt height=26.76201000000001pt/>. A non-invertible matrix is said **singular**. The inverse of a matrix is also invertible, and it results in the original matrix. The inverse of a product is the product of the inverses: <img src="svgs/fa93cf6a0623f7e915926d87a603d380.svg?invert_in_darkmode" align=middle width=138.07101000000003pt height=26.76201000000001pt/>. If a square matrix is invertible, then <img src="svgs/6da422975b734006d19c0be96c05afaf.svg?invert_in_darkmode" align=middle width=182.209005pt height=27.656969999999987pt/> .

A **square** matrix is invertible iff its column vectors are linearly independent.

A square matrix is called **symmetric** if the transpose is equal to the original matrix, i.e. <img src="svgs/e2704e851675be21b9ae796d884727c3.svg?invert_in_darkmode" align=middle width=56.93094000000001pt height=27.656969999999987pt/>, **antisymmetric** if <img src="svgs/2ac5ae7e81d9ce5e3403aca69be55085.svg?invert_in_darkmode" align=middle width=68.89443pt height=27.656969999999987pt/>, **orthogonal** if <img src="svgs/0e73d7bb58eaa0b08bb72c5148b796ab.svg?invert_in_darkmode" align=middle width=73.757475pt height=27.656969999999987pt/>. Note that if it is orthogonal, we have that <img src="svgs/aa01fe248afbb34d913e6a93fbea4b22.svg?invert_in_darkmode" align=middle width=122.37769500000002pt height=27.656969999999987pt/>.

### Determinant of a matrix

Let <img src="svgs/4a750ea101ce75a11b3982f2cc3eb8c6.svg?invert_in_darkmode" align=middle width=70.81816500000001pt height=26.177579999999978pt/> be a **square matrix**. We call the **determinant** of <img src="svgs/53d147e7f3fe6e47ee05b88b166bd3f6.svg?invert_in_darkmode" align=middle width=12.328800000000005pt height=22.46574pt/> the scalar defined by 

<img src="svgs/6a79bde4c965e32f0bc5741fe5a0c3e5.svg?invert_in_darkmode" align=middle width=556.641855pt height=47.67179999999999pt/>

which is a fancy way to express that we have to:

- Fix one of the two indices;
- Put a negative sign before the quantities that belong to *indices summing to an odd number*;
- Calculate the determinant of the submatrix obtained by removal of the column and row we are analyzing;
- Multiply this quantity for the actual number at the index;
- Sum all of these.

This procedure is known as **Laplace rule**.

If <img src="svgs/53d147e7f3fe6e47ee05b88b166bd3f6.svg?invert_in_darkmode" align=middle width=12.328800000000005pt height=22.46574pt/> is diagonal or triangular, we just have to **multiply the elements on the diagonal**.

The determinant has some interesting properties:

- **Transposing** the matrix **doesn't change** the determinant: <img src="svgs/2dd9da64ff04d2dae6e5b1bec3b3756b.svg?invert_in_darkmode" align=middle width=126.79408499999998pt height=27.656969999999987pt/> 
- The **multiplication of determinants** is the **determinant of multiplications** in square matrices having the same size: <img src="svgs/f4bc56b311ac4df76e7db7f9103879a8.svg?invert_in_darkmode" align=middle width=177.956955pt height=24.65759999999998pt/>
- The determinant of the **inverse** is <img src="svgs/e5355330b158ce6cf27892bfe544c88f.svg?invert_in_darkmode" align=middle width=38.20575pt height=27.775769999999994pt/> : <img src="svgs/345eb82ef953152406319d0dedc27ebf.svg?invert_in_darkmode" align=middle width=150.91362pt height=26.76201000000001pt/>
- The determinant of a scalar multiplication is the scalar multiplication to the power <img src="svgs/55a049b8f161ae7cfeb0197d75aff967.svg?invert_in_darkmode" align=middle width=9.867000000000003pt height=14.155350000000013pt/>, with <img src="svgs/55a049b8f161ae7cfeb0197d75aff967.svg?invert_in_darkmode" align=middle width=9.867000000000003pt height=14.155350000000013pt/> being the matrix size: <img src="svgs/7360d85f1d4c5197e1278b0f782814c1.svg?invert_in_darkmode" align=middle width=206.49865499999999pt height=24.65759999999998pt/>
- Every **orthogonal matrix** is invertible and its determinant is <img src="svgs/9ae0fd34c5ab292d1ccce6a94d7188d5.svg?invert_in_darkmode" align=middle width=21.004665000000006pt height=21.18732pt/>
- The determinant of a <img src="svgs/5642f62a9faca8d26da9e24171f49747.svg?invert_in_darkmode" align=middle width=36.52968pt height=21.18732pt/> square matrix is computable by subtracting the multiplication of the main diagonal elements to the one of the inverse diagonal: <img src="svgs/87dc94194a164c500945c45d53039428.svg?invert_in_darkmode" align=middle width=179.59705499999998pt height=24.65759999999998pt/>
- The determinant of a <img src="svgs/53e14fe4f3521c64c328f4a15bffeef3.svg?invert_in_darkmode" align=middle width=36.52968pt height=21.18732pt/> matrix is computable with the **Sarrus rule**, which basically is the same principle.

### Calculating the inverse using the determinant

If <img src="svgs/53d147e7f3fe6e47ee05b88b166bd3f6.svg?invert_in_darkmode" align=middle width=12.328800000000005pt height=22.46574pt/> is invertible, then its inverse is computable by calculating the **cofactor matrix**, which contains elements defined by <img src="svgs/4d33f6f9f26d1a1d15c26525e7e48707.svg?invert_in_darkmode" align=middle width=161.069205pt height=27.159000000000013pt/>, called **cofactors**.

<img src="svgs/44114dd91883e2ca53d5fa30a31b9e52.svg?invert_in_darkmode" align=middle width=92.07329999999999pt height=34.09889999999999pt/>

### Eigenvalues and eigenvectors

Let's consider a **square** matrix <img src="svgs/4058b231996dd16d611ab57a6ef400dd.svg?invert_in_darkmode" align=middle width=70.81816500000001pt height=26.177579999999978pt/>. The number <img src="svgs/fd8be73b54f5436a5cd2e73ba9b6bfa9.svg?invert_in_darkmode" align=middle width=9.589140000000002pt height=22.831379999999992pt/> is called an **eigenvalue** of <img src="svgs/53d147e7f3fe6e47ee05b88b166bd3f6.svg?invert_in_darkmode" align=middle width=12.328800000000005pt height=22.46574pt/> if we have a vector <img src="svgs/c1eb784d6e6e1cadb2add784cd9a22a8.svg?invert_in_darkmode" align=middle width=39.53185500000001pt height=22.831379999999992pt/>, named **eigenvector**, such that <img src="svgs/de134c5fee8195ddcb5802524b4cab4e.svg?invert_in_darkmode" align=middle width=62.625585pt height=22.831379999999992pt/>. The set of eigenvalues is called **spectrum** of <img src="svgs/53d147e7f3fe6e47ee05b88b166bd3f6.svg?invert_in_darkmode" align=middle width=12.328800000000005pt height=22.46574pt/> and it is denoted by <img src="svgs/b13aeffb44573c812f4907226de5112f.svg?invert_in_darkmode" align=middle width=35.097150000000006pt height=24.65759999999998pt/>. 

**How can we find these eigenvalues?** They are the solutions of the characteristic equation: <img src="svgs/77216447609e8196e4dbeb8e344495f5.svg?invert_in_darkmode" align=middle width=178.86445500000002pt height=24.65759999999998pt/>, where <img src="svgs/925931f2542689e0259081e9ac0d3ec7.svg?invert_in_darkmode" align=middle width=41.35296pt height=24.65759999999998pt/> is called the **characteristic polynomial**. Thanks to the fundamental theorem of algebra we can say that a matrix with **real or complex** entries has <img src="svgs/55a049b8f161ae7cfeb0197d75aff967.svg?invert_in_darkmode" align=middle width=9.867000000000003pt height=14.155350000000013pt/> eigenvalues, counted with their multiplicity. The algebraic multiplicity of an eigenvalue <img src="svgs/10b25a8965607b9859b33bd6a26ec73b.svg?invert_in_darkmode" align=middle width=14.239995000000002pt height=22.831379999999992pt/> is the number of times the root appears in the characteristic polynomial. Let's make an example: we have a matrix <img src="svgs/76a1cc4c89adb5db61e2c4a52a2f7eba.svg?invert_in_darkmode" align=middle width=136.98629999999997pt height=67.39788pt/>, and we'll now calculate <img src="svgs/51b37e810ccb12623379c4a0b03b971f.svg?invert_in_darkmode" align=middle width=126.35271000000002pt height=24.65759999999998pt/>:

<img src="svgs/f71b59a9b1e721e8658f3eba2e469167.svg?invert_in_darkmode" align=middle width=320.09075999999993pt height=222.41293799999997pt/>

As you can see, we have two roots <img src="svgs/a727f6d657c0b5c8830432b6130080c7.svg?invert_in_darkmode" align=middle width=36.529845pt height=21.18732pt/>, but <img src="svgs/034d0a6be0424bffe9a6e7ac9236c0f5.svg?invert_in_darkmode" align=middle width=8.219277000000005pt height=21.18732pt/> cancels <img src="svgs/253c305350b3c5dbbd6a3842b0efd203.svg?invert_in_darkmode" align=middle width=18.156600000000005pt height=14.155350000000013pt/> two times, so it will have multiplicity <img src="svgs/76c5792347bb90ef71cfbace628572cf.svg?invert_in_darkmode" align=middle width=8.219277000000005pt height=21.18732pt/>, while <img src="svgs/e11a8cfcf953c683196d7a48677b2277.svg?invert_in_darkmode" align=middle width=21.004665000000006pt height=21.18732pt/> will have multiplicity <img src="svgs/034d0a6be0424bffe9a6e7ac9236c0f5.svg?invert_in_darkmode" align=middle width=8.219277000000005pt height=21.18732pt/>.

Note that the sum of the multiplicities **can never** be higher than the matrix dimension.

The maximum eigenvalue **in module** of a matrix <img src="svgs/4058b231996dd16d611ab57a6ef400dd.svg?invert_in_darkmode" align=middle width=70.81816500000001pt height=26.177579999999978pt/> is called the **spectral radius** of <img src="svgs/53d147e7f3fe6e47ee05b88b166bd3f6.svg?invert_in_darkmode" align=middle width=12.328800000000005pt height=22.46574pt/> and is denoted by <img src="svgs/5051e103190d79cfd732c60b72edf4d2.svg?invert_in_darkmode" align=middle width=33.61314000000001pt height=24.65759999999998pt/>: <img src="svgs/c8d04dd1ee846ce5c459ad8c735e34a4.svg?invert_in_darkmode" align=middle width=153.0705pt height=24.65759999999998pt/>. The set of all the eigenvalues is called the **spectrum** of <img src="svgs/53d147e7f3fe6e47ee05b88b166bd3f6.svg?invert_in_darkmode" align=middle width=12.328800000000005pt height=22.46574pt/>.

Please note that the **eigenvectors are not unique**: for example, multiplying all of the eigenvectors by a constant <img src="svgs/3e18a4a28fdee1744e5e3f79d13b9ff6.svg?invert_in_darkmode" align=middle width=7.113876000000004pt height=14.155350000000013pt/> would still make them valid eigenvectors for the same values.

We can **link the eigenvalues to the determinant**! In fact, the determinant of a square matrix is the product of all its eigenvalues: <img src="svgs/29107fc410dccaaf27befb7835e035a9.svg?invert_in_darkmode" align=middle width=124.48458pt height=26.438939999999977pt/>.

A matrix is **singular** iff it has at least **one null eigenvalue**.

**Eigenvalues in triangular and diagonal matrices are ultra easy!** In fact, they are the elements of the diagonal. 

A symmetric (<img src="svgs/e2704e851675be21b9ae796d884727c3.svg?invert_in_darkmode" align=middle width=56.93094000000001pt height=27.656969999999987pt/>) positive (semi)definite matrix has eigenvalues greater(equal) than(to) zero.

Two matrices **with the same size** are said **similar** if the nonsingular matrix <img src="svgs/df5a289587a2f0247a5b97c1e8ac58ca.svg?invert_in_darkmode" align=middle width=12.836835000000004pt height=22.46574pt/> exists: <img src="svgs/b39d85f7b525362fb5d242227352a03d.svg?invert_in_darkmode" align=middle width=90.04000500000001pt height=26.76201000000001pt/>. This implies that they have the **same eigenvalues** too.

### Scalar product and norms in vector spaces

Let's consider a vector space <img src="svgs/a9a3a4a202d80326bda413b5562d5cd1.svg?invert_in_darkmode" align=middle width=13.242075000000003pt height=22.46574pt/> over the field <img src="svgs/b8bc815b5e9d5177af01fd4d3d3c2f10.svg?invert_in_darkmode" align=middle width=12.853995000000003pt height=22.46574pt/>. We define a function <img src="svgs/1547e775fb2eee42b0bd9c907a9552ed.svg?invert_in_darkmode" align=middle width=95.502pt height=24.65759999999998pt/> as a **norm** if it satisfies the following properties:

- It is always **greater or equal to <img src="svgs/29632a9bf827ce0200454dd32fc3be82.svg?invert_in_darkmode" align=middle width=8.219277000000005pt height=21.18732pt/>**, and it is <img src="svgs/29632a9bf827ce0200454dd32fc3be82.svg?invert_in_darkmode" align=middle width=8.219277000000005pt height=21.18732pt/> **only when the vector itself is**: 
  <img src="svgs/7fc3fcfc64e8a2596640f71e2d5cf3af.svg?invert_in_darkmode" align=middle width=292.876155pt height=24.65759999999998pt/>
- If **multiplied by a constant**, the result is the norm **multiplied by the absolute value** of the constant: <img src="svgs/fd2f2e08ce2d6d466fb73f70f283b2c7.svg?invert_in_darkmode" align=middle width=223.70320499999997pt height=24.65759999999998pt/>
- The **norm of a sum** is **less or equal** than the **sum of the norms**: <img src="svgs/f8c5b943c0c3c782148b0bac5f3b6de1.svg?invert_in_darkmode" align=middle width=240.95890499999996pt height=24.65759999999998pt/>

If <img src="svgs/c87ca14efe98f13246c068238f27f47b.svg?invert_in_darkmode" align=middle width=42.53980500000001pt height=22.64855999999997pt/>, its module is called a *normed space*. 

Now, considering a generic vector <img src="svgs/6c4adbc36120d62b98deef2a20d5d303.svg?invert_in_darkmode" align=middle width=8.557890000000002pt height=14.155350000000013pt/>, its **euclidean norm** is <img src="svgs/cccf136bca22b2a24bbd86874857eeb7.svg?invert_in_darkmode" align=middle width=160.387755pt height=29.899979999999978pt/>. Its **one norm** is <img src="svgs/cbdc11177ef27fa40dfa9b200fae274d.svg?invert_in_darkmode" align=middle width=120.75162000000002pt height=26.438939999999977pt/>. Its **infinity norm** is <img src="svgs/317ff3a45415038bbfa22a3928d8875e.svg?invert_in_darkmode" align=middle width=168.192255pt height=24.65759999999998pt/>. Some of you may have noted a pattern: we can generalize the concept with the **p-norm** of <img src="svgs/6c4adbc36120d62b98deef2a20d5d303.svg?invert_in_darkmode" align=middle width=8.557890000000002pt height=14.155350000000013pt/>, which is <img src="svgs/51fb8191d3056fd200d94e54b1b7f72c.svg?invert_in_darkmode" align=middle width=249.05380499999998pt height=35.57103pt/>.

Two norms are said **equivalent** if we can find two positive constants <img src="svgs/71c4fccbd0db74aca45d5bea8971c4d3.svg?invert_in_darkmode" align=middle width=20.328165000000006pt height=14.155350000000013pt/> and <img src="svgs/646507d9bddf0d2330f6cb4a9ee4aef0.svg?invert_in_darkmode" align=middle width=24.96318pt height=22.46574pt/> that we can multiply the norm for to obtain the following inequality: <img src="svgs/16f873169a8bd657465f41c6d9ca98de.svg?invert_in_darkmode" align=middle width=244.57735499999998pt height=24.65759999999998pt/>. This is a fancy concept but it reveals a great thing: **in a vector space all the <img src="svgs/2ec6e630f199f589a2402fdf3e0289d5.svg?invert_in_darkmode" align=middle width=8.270625000000004pt height=14.155350000000013pt/> norms are equivalent!**

### Matrix norms

A matrix norm is a function satisfying the above-mentioned properties. We can say that a matrix norm <img src="svgs/7967404d7b62656850c755d46b2a46d0.svg?invert_in_darkmode" align=middle width=28.767255000000002pt height=24.65759999999998pt/> is **compatible** with a vector norm <img src="svgs/dbbf39034141548942b5402cebc12d73.svg?invert_in_darkmode" align=middle width=25.83339pt height=24.65759999999998pt/> if the norm of the multiplication is lesser or equal than the multiplication of the norms: <img src="svgs/e8b1886971e51fb0e3045a97bafc8a2e.svg?invert_in_darkmode" align=middle width=108.15073499999997pt height=24.65759999999998pt/>.

The **spectral norm** of a matrix is equal to <img src="svgs/62843c08ef0ffb3081a46e32a45403b5.svg?invert_in_darkmode" align=middle width=133.534995pt height=29.70791999999998pt/>. Note that the **spectral norm of the identity matrix** is equal to <img src="svgs/034d0a6be0424bffe9a6e7ac9236c0f5.svg?invert_in_darkmode" align=middle width=8.219277000000005pt height=21.18732pt/>.

We can say that the ***1-norm*** of a matrix is the maximum between the sums of the **columns** absolute values: <img src="svgs/c2a28a5ba4b64e8b1903d865397e5027.svg?invert_in_darkmode" align=middle width=214.21570499999999pt height=26.438939999999977pt/>. Obviously, when dealing with identity matrices this will be equal to <img src="svgs/034d0a6be0424bffe9a6e7ac9236c0f5.svg?invert_in_darkmode" align=middle width=8.219277000000005pt height=21.18732pt/>.

The ***infinity norm*** is the same concept, but on **rows**: <img src="svgs/6c860bba4729dbe8f12b979ab76ea43c.svg?invert_in_darkmode" align=middle width=220.76950499999998pt height=26.438939999999977pt/>. Notice that on **symmetric matrices** these two values coincide. Obviously, when dealing with identity matrices this will be equal to <img src="svgs/034d0a6be0424bffe9a6e7ac9236c0f5.svg?invert_in_darkmode" align=middle width=8.219277000000005pt height=21.18732pt/>.

Lastly, we define the **Frobenius norm** of a matrix <img src="svgs/53d147e7f3fe6e47ee05b88b166bd3f6.svg?invert_in_darkmode" align=middle width=12.328800000000005pt height=22.46574pt/> as the square root of the sum of all the squares:

<img src="svgs/2c5725ab5cad719ae6a3c44e6e810040.svg?invert_in_darkmode" align=middle width=167.040555pt height=39.5802pt/>. For identity matrices, this will be equal to <img src="svgs/4fd78aba72015f7697ab298a89ec8a9c.svg?invert_in_darkmode" align=middle width=23.565630000000002pt height=24.99551999999999pt/>.

# Matrix decompositions

**Matrix factorisations** (aka decompositions) are incredibly useful tools for linear algebra problems. They write a generic matrix <img src="svgs/53d147e7f3fe6e47ee05b88b166bd3f6.svg?invert_in_darkmode" align=middle width=12.328800000000005pt height=22.46574pt/> as a product of matrices, that are usually easier to compute (for example, triangulars or diagonals).

Let's start by considering factorizations by **triangular matrices**.

<a name="lufact"></a>

## Gaussian elimination method 

Let's consider a square matrix <img src="svgs/40cc18b0e7d1320f7eb9bd9d3fd71470.svg?invert_in_darkmode" align=middle width=70.81816500000001pt height=26.177579999999978pt/>. If <img src="svgs/53d147e7f3fe6e47ee05b88b166bd3f6.svg?invert_in_darkmode" align=middle width=12.328800000000005pt height=22.46574pt/> is non-singular (therefore, it is invertible) and all its **principal minors** are non-singular, then we can find two matrices <img src="svgs/ddcb483302ed36a59286424aa5e0be17.svg?invert_in_darkmode" align=middle width=11.187330000000003pt height=22.46574pt/> and <img src="svgs/6bac6ec50c01592407695ef84f457232.svg?invert_in_darkmode" align=middle width=13.016025000000003pt height=22.46574pt/> that, multiplied, result in <img src="svgs/53d147e7f3fe6e47ee05b88b166bd3f6.svg?invert_in_darkmode" align=middle width=12.328800000000005pt height=22.46574pt/>. The cool thing is that <img src="svgs/ddcb483302ed36a59286424aa5e0be17.svg?invert_in_darkmode" align=middle width=11.187330000000003pt height=22.46574pt/> stands for **Lower triangular**, while <img src="svgs/6bac6ec50c01592407695ef84f457232.svg?invert_in_darkmode" align=middle width=13.016025000000003pt height=22.46574pt/> stands for **Upper triangular**. Pretty useful, huh?

We call this the **LU factorization**.

The matrices can be computed in <img src="svgs/efcf8d472ecdd2ea56d727b5746100e3.svg?invert_in_darkmode" align=middle width=38.17737pt height=21.18732pt/> steps with the so-called **Gaussian Elimination Method**, which has a computational cost of <img src="svgs/ef9d2b7e8ee7d6389b95c3ee58562a02.svg?invert_in_darkmode" align=middle width=60.008685pt height=26.76201000000001pt/>. We can start by computing the matrix <img src="svgs/6bac6ec50c01592407695ef84f457232.svg?invert_in_darkmode" align=middle width=13.016025000000003pt height=22.46574pt/> as follows: we define a matrix <img src="svgs/f4125d0f27977a227268af329c65cc60.svg?invert_in_darkmode" align=middle width=39.865485pt height=29.19113999999999pt/> of multipliers, with the diagonal elements equal to <img src="svgs/034d0a6be0424bffe9a6e7ac9236c0f5.svg?invert_in_darkmode" align=middle width=8.219277000000005pt height=21.18732pt/>, the elements under the diagonal **on the column k** <img src="svgs/51b305325a6d990c19d75c17818c3f52.svg?invert_in_darkmode" align=middle width=207.709755pt height=42.51654pt/>, and <img src="svgs/29632a9bf827ce0200454dd32fc3be82.svg?invert_in_darkmode" align=middle width=8.219277000000005pt height=21.18732pt/> otherwise. We then compute <img src="svgs/db29c54bcab39a393b805f0f4d7fd681.svg?invert_in_darkmode" align=middle width=135.222945pt height=29.19113999999999pt/>, then iterate until we obtain <img src="svgs/0141c6862df0df028b327d2313bec2ec.svg?invert_in_darkmode" align=middle width=66.48444pt height=29.19113999999999pt/>.

There's just one problem: this algorithm is **unstable**! This means that the **algorithmic error is not limited**, and it happens because the elements <img src="svgs/2dcd38efa74bb3fe4a77f85e7b661451.svg?invert_in_darkmode" align=middle width=26.229225000000003pt height=34.33782pt/> can be ultra small (or even zero!), thus leading to errors. We can solve this problem by computing the **pivoting algorithm**, i.e. we swap two rows so that <img src="svgs/2dcd38efa74bb3fe4a77f85e7b661451.svg?invert_in_darkmode" align=middle width=26.229225000000003pt height=34.33782pt/> is the element with the maximum absolute value. We then get a **permutation matrix** <img src="svgs/df5a289587a2f0247a5b97c1e8ac58ca.svg?invert_in_darkmode" align=middle width=12.836835000000004pt height=22.46574pt/>, i.e. an **identity matrix with the needed rows swapped**.

When we're dealing with **symmetric positive definite** matrices there's a great simplification: it is always possible to compute the LU factorization **without pivoting** and it simply is <img src="svgs/22c698b7ad423606bd4f040e74c676c9.svg?invert_in_darkmode" align=middle width=66.15477pt height=27.656969999999987pt/>. This factorization is obviously less costly: using the Cholesky algorithm, it has a complexity of <img src="svgs/2b72192b16b235f27d3b5565f77fb346.svg?invert_in_darkmode" align=middle width=60.008685pt height=26.76201000000001pt/>.

We can therefore use the **Cholesky decomposition**, which is greatly used in ML because we often deal with symmetric positive definite matrices, like the covariance matrix of a multivariate Gaussian. This decomposition can be used to efficiently compute the determinant too: since the obtained matrices are triangular, the determinant will just be the **product of the diagonal**. 

## Decompositions involving diagonal matrices

These ones are about a diagonal matrix, not a triangular one.

There are two main decompositions involving diagonal matrices: the **eigendecomposition** and the **Singular Value Decomposition**. 

### Eigendecomposition

Let's consider a **square matrix** <img src="svgs/53d147e7f3fe6e47ee05b88b166bd3f6.svg?invert_in_darkmode" align=middle width=12.328800000000005pt height=22.46574pt/> of size <img src="svgs/2be744f3276b5219af5f8dd5f793e02c.svg?invert_in_darkmode" align=middle width=39.82506pt height=19.178279999999994pt/>, which can be decomposed as <img src="svgs/712dd58fc85263346c5640e112596cdf.svg?invert_in_darkmode" align=middle width=90.812865pt height=26.76201000000001pt/>. <img src="svgs/df5a289587a2f0247a5b97c1e8ac58ca.svg?invert_in_darkmode" align=middle width=12.836835000000004pt height=22.46574pt/> is a non-singular (obviously: we have to invert it!) matrix of size <img src="svgs/2be744f3276b5219af5f8dd5f793e02c.svg?invert_in_darkmode" align=middle width=39.82506pt height=19.178279999999994pt/> and <img src="svgs/78ec2b7008296ce0561cf83393cb746d.svg?invert_in_darkmode" align=middle width=14.066250000000002pt height=22.46574pt/> is a diagonal matrix with the eigenvalues on the diagonal. Beware: the eigenvectors **have to be linearly independent** and **form a basis** of <img src="svgs/8a86f4a11e2fbfc03de61d587ba826de.svg?invert_in_darkmode" align=middle width=19.998330000000006pt height=22.64855999999997pt/>. This decomposition can **only be applied to square matrices with particular properties on their spectrum**.

### Singular Value Decomposition (SVD)

This one can be applied to **all the matrices**. Pretty cool, huh? First, tho, we need to clarify a few concepts:

- Two vectors <img src="svgs/2aec3383d84485daa90d961611e9b21c.svg?invert_in_darkmode" align=middle width=65.36343000000001pt height=22.64855999999997pt/> are **orthogonal** if their product is equal to 0. This is the vector product, i.e. the product you'd obtain by multiplicating <img src="svgs/7e21464f860cf1a61bf68c7631ac42c4.svg?invert_in_darkmode" align=middle width=47.593095000000005pt height=27.656969999999987pt/>;
- A **unit vector** is a vector <img src="svgs/cdbb034375cae1a8fed3043570f71626.svg?invert_in_darkmode" align=middle width=49.499669999999995pt height=22.64855999999997pt/> which has norm equal to 1: <img src="svgs/edfdcf5e41e1b2a2b7fd9780226dc9c1.svg?invert_in_darkmode" align=middle width=55.985655pt height=24.65759999999998pt/>;
- The **normalization** of a vector is the division between the vector and its norm, which always returns a **unit vector**: <img src="svgs/2ec7537cb715af18f3297a730e6a9a39.svg?invert_in_darkmode" align=middle width=54.543060000000004pt height=22.853489999999976pt/>;
- A set of vectors <img src="svgs/d85cb90adfb500a1629eebbfedf80fcc.svg?invert_in_darkmode" align=middle width=164.91040500000003pt height=24.65759999999998pt/> is an **orthogonal set** if all of the possible products are equal to <img src="svgs/29632a9bf827ce0200454dd32fc3be82.svg?invert_in_darkmode" align=middle width=8.219277000000005pt height=21.18732pt/>, i.e. <img src="svgs/f93f967dafa9653d9e3a8aa8b8f907ea.svg?invert_in_darkmode" align=middle width=195.565755pt height=27.656969999999987pt/>;
- If some vectors are **orthogonal**, they are **linearly independent**. Therefore, the set they compose forms an orthogonal basis for <img src="svgs/6795a49b4f1add902293d6612f119dba.svg?invert_in_darkmode" align=middle width=172.09780500000002pt height=24.65759999999998pt/>;
- The set <img src="svgs/d85cb90adfb500a1629eebbfedf80fcc.svg?invert_in_darkmode" align=middle width=164.91040500000003pt height=24.65759999999998pt/> is an **orthonormal set** if it is an **orthogonal** set of **unit vectors**. A basis of orthonormal vector is called an **orthonormal basis**;
- Applying these concepts to matrices, we get that <img src="svgs/6bac6ec50c01592407695ef84f457232.svg?invert_in_darkmode" align=middle width=13.016025000000003pt height=22.46574pt/> is an **orthogonal matrix** iff <img src="svgs/1e67b013a99745f085f2343f746f48a9.svg?invert_in_darkmode" align=middle width=66.821205pt height=27.656969999999987pt/>. If the matrix is **square**, then <img src="svgs/5a8a83bc4970a9b00b29bf2af903094c.svg?invert_in_darkmode" align=middle width=75.13176pt height=27.656969999999987pt/>;
- If a matrix is orthogonal, then:
  - The 2-norm of the **matrix multiplied by a vector** is equal to the **2-norm of the vector only**: <img src="svgs/9c87bb374d60ff6beb5dec18445b3761.svg?invert_in_darkmode" align=middle width=165.728805pt height=24.65759999999998pt/>
  - The **product between the matrix multiplied by two vectors** is the **product of the two vectors**: <img src="svgs/f1c3170fb33dd5b7701fa4df82ff5967.svg?invert_in_darkmode" align=middle width=208.60570499999997pt height=24.65759999999998pt/>
  - Therefore, the above mentioned product is equal to <img src="svgs/29632a9bf827ce0200454dd32fc3be82.svg?invert_in_darkmode" align=middle width=8.219277000000005pt height=21.18732pt/> **only when the product between <img src="svgs/332cc365a4987aacce0ead01b8bdcc0b.svg?invert_in_darkmode" align=middle width=9.395100000000005pt height=14.155350000000013pt/> and <img src="svgs/deceeaf6940a8c7a5a02373728002b0f.svg?invert_in_darkmode" align=middle width=8.649300000000004pt height=14.155350000000013pt/> is**: <img src="svgs/4384f2295cba71369e36f02d573d6c6a.svg?invert_in_darkmode" align=middle width=286.229955pt height=24.65759999999998pt/>
  - We can then conclude that **transformations by orthogonal matrices preserve both length and angles!**

Now we're ready for the real thing!

Any matrix <img src="svgs/ad73601e39ef9a2d0bc591935b918895.svg?invert_in_darkmode" align=middle width=74.357085pt height=26.177579999999978pt/> with <img src="svgs/20ce14c761900230f78ed61012621c14.svg?invert_in_darkmode" align=middle width=91.61163pt height=24.65759999999998pt/>, where <img src="svgs/aecf2a0ee257e027bea1c3890c510e73.svg?invert_in_darkmode" align=middle width=40.85994pt height=22.831379999999992pt/> can be written as:

<img src="svgs/cd73f89b468a51e9644a57ae2c50d085.svg?invert_in_darkmode" align=middle width=81.91029pt height=27.656969999999987pt/>

where <img src="svgs/cd0e3808823fef5f9645350c98ac2029.svg?invert_in_darkmode" align=middle width=78.58306499999999pt height=26.177579999999978pt/> is an **orthogonal matrix** with orthogonal vectors <img src="svgs/194516c014804d683d1ab5a74f8c5647.svg?invert_in_darkmode" align=middle width=14.061300000000003pt height=14.155350000000013pt/>, <img src="svgs/eb0168f11a121ecb0ef5892c9c960d1e.svg?invert_in_darkmode" align=middle width=71.73144pt height=26.177579999999978pt/> is an orthogonal matrix with orthogonal vectors <img src="svgs/9f7365802167fff585175c1750674d42.svg?invert_in_darkmode" align=middle width=12.619035000000006pt height=14.155350000000013pt/>, and <img src="svgs/a4dd428e653a866fe122b5c285e8b60e.svg?invert_in_darkmode" align=middle width=73.90053pt height=26.177579999999978pt/> is a matrix whose diagonal entries are the **singular values** <img src="svgs/e61ae7f2cb94c8418c30517775fde77d.svg?invert_in_darkmode" align=middle width=14.044140000000004pt height=14.155350000000013pt/> of <img src="svgs/53d147e7f3fe6e47ee05b88b166bd3f6.svg?invert_in_darkmode" align=middle width=12.328800000000005pt height=22.46574pt/> and with extra-diagonal entries equal to <img src="svgs/29632a9bf827ce0200454dd32fc3be82.svg?invert_in_darkmode" align=middle width=8.219277000000005pt height=21.18732pt/>. <img src="https://cdn.mathpix.com/snip/images/N3oanb3v-5R-_eXPha80gAU0FPOP4Y7gUgHKkjIDZrM.original.fullsize.png" />

The singular values are in **ascending order** in the diagonal, and the first <img src="svgs/63bb9849783d01d91403bc9a5fea12a2.svg?invert_in_darkmode" align=middle width=9.075495000000004pt height=22.831379999999992pt/> are non-null while the other <img src="svgs/47c4614e970adb63a68a4037abbb66ad.svg?invert_in_darkmode" align=middle width=39.03355500000001pt height=22.831379999999992pt/> are equal to <img src="svgs/29632a9bf827ce0200454dd32fc3be82.svg?invert_in_darkmode" align=middle width=8.219277000000005pt height=21.18732pt/>. The singular matrix <img src="svgs/813cd865c037c89fcdc609b25c465a05.svg?invert_in_darkmode" align=middle width=11.872245000000005pt height=22.46574pt/> **is unique**, the other two **aren't**.

Observe that the matrix <img src="svgs/813cd865c037c89fcdc609b25c465a05.svg?invert_in_darkmode" align=middle width=11.872245000000005pt height=22.46574pt/> is rectangular, this means that it has a diagonal submatrix that contains the singular values and needs additional zero padding. 

From the geometric point of view, the SVD is nothing more than sequential linear transformations performed on the bases. The SVD intuition is similar to the eigendecomposition one: broadly speaking, it performs a basis change via <img src="svgs/4cb4714074eaef8a432de7a7f9594820.svg?invert_in_darkmode" align=middle width=22.775775000000003pt height=27.656969999999987pt/>, followed by a scaling and augmentation/reduction in dimensionality via the singular value matrix <img src="svgs/813cd865c037c89fcdc609b25c465a05.svg?invert_in_darkmode" align=middle width=11.872245000000005pt height=22.46574pt/>. Finally, it performs a second basis change via <img src="svgs/6bac6ec50c01592407695ef84f457232.svg?invert_in_darkmode" align=middle width=13.016025000000003pt height=22.46574pt/>.

Basically: 

- <img src="svgs/a9a3a4a202d80326bda413b5562d5cd1.svg?invert_in_darkmode" align=middle width=13.242075000000003pt height=22.46574pt/> performs a basis change in the domain <img src="svgs/8a86f4a11e2fbfc03de61d587ba826de.svg?invert_in_darkmode" align=middle width=19.998330000000006pt height=22.64855999999997pt/> from <img src="svgs/3a4b11477082188db06b7b3af9da3666.svg?invert_in_darkmode" align=middle width=13.293555000000003pt height=30.267599999999987pt/> to the standard basis <img src="svgs/61e84f854bc6258d4108d08d4c4a0852.svg?invert_in_darkmode" align=middle width=13.293555000000003pt height=22.46574pt/>. The inverse of <img src="svgs/a9a3a4a202d80326bda413b5562d5cd1.svg?invert_in_darkmode" align=middle width=13.242075000000003pt height=22.46574pt/> (which, as <img src="svgs/a9a3a4a202d80326bda413b5562d5cd1.svg?invert_in_darkmode" align=middle width=13.242075000000003pt height=22.46574pt/> is orthogonal, is <img src="svgs/2229d330ef74da68bf0b50eba6d39de2.svg?invert_in_darkmode" align=middle width=75.58386pt height=27.656969999999987pt/>) performs the inverse change from <img src="svgs/61e84f854bc6258d4108d08d4c4a0852.svg?invert_in_darkmode" align=middle width=13.293555000000003pt height=22.46574pt/> to <img src="svgs/3a4b11477082188db06b7b3af9da3666.svg?invert_in_darkmode" align=middle width=13.293555000000003pt height=30.267599999999987pt/>;
- Having changed the coordinate system to <img src="svgs/e1c304a11300e11f1b5826600eb8bc95.svg?invert_in_darkmode" align=middle width=13.293555000000003pt height=30.267599999999987pt/>, we can scale to the new coordinates by the matrix <img src="svgs/813cd865c037c89fcdc609b25c465a05.svg?invert_in_darkmode" align=middle width=11.872245000000005pt height=22.46574pt/>, i.e. by the singular values <img src="svgs/e61ae7f2cb94c8418c30517775fde77d.svg?invert_in_darkmode" align=middle width=14.044140000000004pt height=14.155350000000013pt/>;
- Finally, <img src="svgs/6bac6ec50c01592407695ef84f457232.svg?invert_in_darkmode" align=middle width=13.016025000000003pt height=22.46574pt/> performs a basis change in the codomain <img src="svgs/1281caf41453d6d5cb92c8276ef582dd.svg?invert_in_darkmode" align=middle width=23.537085000000005pt height=22.64855999999997pt/> from <img src="svgs/565c7b3b11e4bd7f28c691e0249b88e7.svg?invert_in_darkmode" align=middle width=12.924780000000005pt height=30.267599999999987pt/> to the canonical basis of <img src="svgs/1281caf41453d6d5cb92c8276ef582dd.svg?invert_in_darkmode" align=middle width=23.537085000000005pt height=22.64855999999997pt/>.

Summing things up, SVD performs **two changes of basis**, via the orthogonal matrices <img src="svgs/6bac6ec50c01592407695ef84f457232.svg?invert_in_darkmode" align=middle width=13.016025000000003pt height=22.46574pt/> and <img src="svgs/a9a3a4a202d80326bda413b5562d5cd1.svg?invert_in_darkmode" align=middle width=13.242075000000003pt height=22.46574pt/> and a scaling operation via the matrix <img src="svgs/813cd865c037c89fcdc609b25c465a05.svg?invert_in_darkmode" align=middle width=11.872245000000005pt height=22.46574pt/>. The columns of <img src="svgs/6bac6ec50c01592407695ef84f457232.svg?invert_in_darkmode" align=middle width=13.016025000000003pt height=22.46574pt/> and <img src="svgs/a9a3a4a202d80326bda413b5562d5cd1.svg?invert_in_darkmode" align=middle width=13.242075000000003pt height=22.46574pt/> are orthonormal basis of <img src="svgs/1281caf41453d6d5cb92c8276ef582dd.svg?invert_in_darkmode" align=middle width=23.537085000000005pt height=22.64855999999997pt/> and <img src="svgs/8a86f4a11e2fbfc03de61d587ba826de.svg?invert_in_darkmode" align=middle width=19.998330000000006pt height=22.64855999999997pt/>, respectively. The change of basis is in both the domain and the codomain: this is in contrast with the eigendecomposition, which operates within the same vector space (the basis change is applied but then undone). What makes SVD special is that these two different bases are simultaneously linked by the singular value matrix <img src="svgs/813cd865c037c89fcdc609b25c465a05.svg?invert_in_darkmode" align=middle width=11.872245000000005pt height=22.46574pt/>.

We can link the singular values of <img src="svgs/53d147e7f3fe6e47ee05b88b166bd3f6.svg?invert_in_darkmode" align=middle width=12.328800000000005pt height=22.46574pt/> to the eigenvalues of <img src="svgs/4a90a521023b2e61f36dc36d23846cb5.svg?invert_in_darkmode" align=middle width=35.01333pt height=27.656969999999987pt/>: 

- Let's first substitute A by its SVD: <img src="svgs/f435c2f9e43e1a11523a65076941ef1f.svg?invert_in_darkmode" align=middle width=318.25150499999995pt height=27.656969999999987pt/>, which, since <img src="svgs/6bac6ec50c01592407695ef84f457232.svg?invert_in_darkmode" align=middle width=13.016025000000003pt height=22.46574pt/> is orthogonal, simplifies to <img src="svgs/5949b2245e2c31e0ab386180ed8f8227.svg?invert_in_darkmode" align=middle width=78.63372pt height=27.656969999999987pt/>;
- We know that <img src="svgs/b664993acd5987e42763079d8c9225b8.svg?invert_in_darkmode" align=middle width=34.100055000000005pt height=27.656969999999987pt/> simplifies to a diagonal matrix with the singular values (squared) in it: <img src="svgs/c494c40ba8272afb0e3b9f07c523e989.svg?invert_in_darkmode" align=middle width=336.24475499999994pt height=77.48333999999998pt/> 

Hence, we know that <img src="svgs/798ff1b69d81778edee4e8e38513268f.svg?invert_in_darkmode" align=middle width=190.059705pt height=29.70791999999998pt/>. In particular, the **first** one will be <img src="svgs/0be7defadd529f2d21f723689100300e.svg?invert_in_darkmode" align=middle width=196.81975500000001pt height=29.70791999999998pt/>, and the **last** one will be <img src="svgs/8ae61d790ab08265a135ddb813ff280e.svg?invert_in_darkmode" align=middle width=256.704855pt height=29.70791999999998pt/>, so the 2-norm of the inverse will be the inverse of <img src="svgs/28cf960b1f96e750df70968130f6b0db.svg?invert_in_darkmode" align=middle width=17.519205000000003pt height=14.155350000000013pt/>.

Therefore, the left singular vectors of <img src="svgs/53d147e7f3fe6e47ee05b88b166bd3f6.svg?invert_in_darkmode" align=middle width=12.328800000000005pt height=22.46574pt/> are the eigenvectors of <img src="svgs/4a90a521023b2e61f36dc36d23846cb5.svg?invert_in_darkmode" align=middle width=35.01333pt height=27.656969999999987pt/>. The right singular vectors of <img src="svgs/53d147e7f3fe6e47ee05b88b166bd3f6.svg?invert_in_darkmode" align=middle width=12.328800000000005pt height=22.46574pt/> are the eigenvectors of <img src="svgs/d4f5cd9596d7bf6138dc0de701a2ffc1.svg?invert_in_darkmode" align=middle width=34.1913pt height=27.656969999999987pt/>. **For symmetric matrices, the eigendecomposition and the SVD are the same thing.**

### Moore-Penrose inverse

The SVD can be used to compute a pseudo-inverse, named **Moore-Penrose inverse** of a matrix <img src="svgs/53d147e7f3fe6e47ee05b88b166bd3f6.svg?invert_in_darkmode" align=middle width=12.328800000000005pt height=22.46574pt/>:

<img src="svgs/1cae54ed1cdb64708c40c6df487da859.svg?invert_in_darkmode" align=middle width=103.73698499999999pt height=27.656969999999987pt/>, where <img src="svgs/dc13ef5e6a0d7b25eb96e800fe53b9b2.svg?invert_in_darkmode" align=middle width=21.963645000000003pt height=26.177579999999978pt/> is the pseudoinverse of <img src="svgs/813cd865c037c89fcdc609b25c465a05.svg?invert_in_darkmode" align=middle width=11.872245000000005pt height=22.46574pt/>, which is computable by taking the reciprocal of every non-zero diagonal element and transposing the matrix:

<img src="svgs/7635e2e138b0c84e1830649992af913a.svg?invert_in_darkmode" align=middle width=461.74870500000003pt height=181.39076999999997pt/>

### Matrix approximation using SVD

Given the SVD of a matrix <img src="svgs/8bfe675241e89fad660320923a91a157.svg?invert_in_darkmode" align=middle width=47.66388pt height=27.656969999999987pt/>, we can use it to represent the matrix <img src="svgs/53d147e7f3fe6e47ee05b88b166bd3f6.svg?invert_in_darkmode" align=middle width=12.328800000000005pt height=22.46574pt/> as a **sum of low-rank matrices** <img src="svgs/ba15937b4998e8d17369c8df88ccaf91.svg?invert_in_darkmode" align=middle width=79.829805pt height=26.177579999999978pt/> with <img src="svgs/eb71a14b5c38e753b886f895f9e1256f.svg?invert_in_darkmode" align=middle width=96.22833pt height=24.65759999999998pt/> such that <img src="svgs/73928680f8ee97c30f84bd7fd7d080d2.svg?invert_in_darkmode" align=middle width=72.69388500000001pt height=27.656969999999987pt/>. The matrix <img src="svgs/53d147e7f3fe6e47ee05b88b166bd3f6.svg?invert_in_darkmode" align=middle width=12.328800000000005pt height=22.46574pt/> can then be written as the **sum** (to <img src="svgs/63bb9849783d01d91403bc9a5fea12a2.svg?invert_in_darkmode" align=middle width=9.075495000000004pt height=22.831379999999992pt/>, which is the original rank of <img src="svgs/53d147e7f3fe6e47ee05b88b166bd3f6.svg?invert_in_darkmode" align=middle width=12.328800000000005pt height=22.46574pt/>) of **these matrices multiplied by the singular values**: <img src="svgs/c6d1565538b10b98bf4e3d9297a208d3.svg?invert_in_darkmode" align=middle width=221.08795499999997pt height=32.51192999999998pt/>. To obtain a rank-<img src="svgs/2ec6e630f199f589a2402fdf3e0289d5.svg?invert_in_darkmode" align=middle width=8.270625000000004pt height=14.155350000000013pt/> approximation of the matrix, we can **truncate the sum** at the index <img src="svgs/2ec6e630f199f589a2402fdf3e0289d5.svg?invert_in_darkmode" align=middle width=8.270625000000004pt height=14.155350000000013pt/>. The error introduced with this approximation can be computed as the **2-norm of the difference**, <img src="svgs/acc3d1c804f7fb9c000092508a1c1b00.svg?invert_in_darkmode" align=middle width=75.33817499999999pt height=24.65759999999998pt/>, which is equal to the **sum of the matrices from <img src="svgs/2ec6e630f199f589a2402fdf3e0289d5.svg?invert_in_darkmode" align=middle width=8.270625000000004pt height=14.155350000000013pt/> to <img src="svgs/63bb9849783d01d91403bc9a5fea12a2.svg?invert_in_darkmode" align=middle width=9.075495000000004pt height=22.831379999999992pt/>:** this quantity, though, is simply the **next singular value** <img src="svgs/2fb0728c73c8bc07384ac627b2476fbd.svg?invert_in_darkmode" align=middle width=32.813550000000006pt height=14.155350000000013pt/>. Great! This means that if <img src="svgs/2fb0728c73c8bc07384ac627b2476fbd.svg?invert_in_darkmode" align=middle width=32.813550000000006pt height=14.155350000000013pt/> is small we have a good approximation and we can stop.

Now, if we have a rank-<img src="svgs/2ec6e630f199f589a2402fdf3e0289d5.svg?invert_in_darkmode" align=middle width=8.270625000000004pt height=14.155350000000013pt/> approximation <img src="svgs/7555b00e2f6df9ab19ad9738f9c91b7a.svg?invert_in_darkmode" align=middle width=131.89341000000002pt height=27.656969999999987pt/>, for every matrix of the same rank <img src="svgs/2ec6e630f199f589a2402fdf3e0289d5.svg?invert_in_darkmode" align=middle width=8.270625000000004pt height=14.155350000000013pt/>, we get that the 2-norm of the difference will always be greater or equal than the difference from <img src="svgs/53d147e7f3fe6e47ee05b88b166bd3f6.svg?invert_in_darkmode" align=middle width=12.328800000000005pt height=22.46574pt/> to <img src="svgs/f7e5e35d144ef377e6586f25a5c7e554.svg?invert_in_darkmode" align=middle width=19.105350000000005pt height=22.46574pt/>. This is just a fancy way of saying that <img src="svgs/f7e5e35d144ef377e6586f25a5c7e554.svg?invert_in_darkmode" align=middle width=19.105350000000005pt height=22.46574pt/> is the best way of approximating <img src="svgs/53d147e7f3fe6e47ee05b88b166bd3f6.svg?invert_in_darkmode" align=middle width=12.328800000000005pt height=22.46574pt/> with a rank <img src="svgs/2ec6e630f199f589a2402fdf3e0289d5.svg?invert_in_darkmode" align=middle width=8.270625000000004pt height=14.155350000000013pt/>. No other <img src="svgs/2ec6e630f199f589a2402fdf3e0289d5.svg?invert_in_darkmode" align=middle width=8.270625000000004pt height=14.155350000000013pt/>-rank matrix does that better: <img src="svgs/0c5a1962217bbb779f5377f370042989.svg?invert_in_darkmode" align=middle width=350.45455499999997pt height=26.177579999999978pt/>.

Note that this is a lossy compression. 

### Let's sum up things!

We can therefore conclude that we can decompose a matrix in lots of ways:

![Matrix decompositions](./res/matrix-decompositions.png)





# Linear systems

A **linear system** can be written as <img src="svgs/6ffa573707fca115cad7b243d91a7109.svg?invert_in_darkmode" align=middle width=50.69625pt height=22.831379999999992pt/>, where <img src="svgs/53d147e7f3fe6e47ee05b88b166bd3f6.svg?invert_in_darkmode" align=middle width=12.328800000000005pt height=22.46574pt/> is a matrix of size <img src="svgs/63b142315f480db0b3ff453d62cc3e7f.svg?invert_in_darkmode" align=middle width=44.391270000000006pt height=19.178279999999994pt/> (let's suppose <img src="svgs/0964aa9a8c5b7a612534543d20ddc673.svg?invert_in_darkmode" align=middle width=46.217655pt height=20.908799999999992pt/> for now),  <img src="svgs/332cc365a4987aacce0ead01b8bdcc0b.svg?invert_in_darkmode" align=middle width=9.395100000000005pt height=14.155350000000013pt/> is a column vector of length <img src="svgs/55a049b8f161ae7cfeb0197d75aff967.svg?invert_in_darkmode" align=middle width=9.867000000000003pt height=14.155350000000013pt/> and <img src="svgs/4bdc8d9bcfb35e1c9bfb51fc69687dfc.svg?invert_in_darkmode" align=middle width=7.054855500000005pt height=22.831379999999992pt/> is a column vector of length <img src="svgs/0e51a2dede42189d77627c4d742822c3.svg?invert_in_darkmode" align=middle width=14.433210000000003pt height=14.155350000000013pt/>. <img src="svgs/332cc365a4987aacce0ead01b8bdcc0b.svg?invert_in_darkmode" align=middle width=9.395100000000005pt height=14.155350000000013pt/> represents the unknown solution, while <img src="svgs/4bdc8d9bcfb35e1c9bfb51fc69687dfc.svg?invert_in_darkmode" align=middle width=7.054855500000005pt height=22.831379999999992pt/> is given. This form can therefore be expanded as 

<img src="svgs/68b6432b2fc96d39d647d77e05e7c5c8.svg?invert_in_darkmode" align=middle width=256.72911000000005pt height=93.27878999999997pt/>

We are interested in some informations about the system:

- Does a solution **exist**? Is it **unique**?
- What are the **numerical methods** we can exploit to actually find this solution?
- What are the **conditions** of the problem?

Let's separately consider the case of **square** linear systems and **least square** ones.

## Square linear systems

The solution of the system <img src="svgs/6ffa573707fca115cad7b243d91a7109.svg?invert_in_darkmode" align=middle width=50.69625pt height=22.831379999999992pt/> where A has size <img src="svgs/2be744f3276b5219af5f8dd5f793e02c.svg?invert_in_darkmode" align=middle width=39.82506pt height=19.178279999999994pt/> and <img src="svgs/4bdc8d9bcfb35e1c9bfb51fc69687dfc.svg?invert_in_darkmode" align=middle width=7.054855500000005pt height=22.831379999999992pt/> has size <img src="svgs/55a049b8f161ae7cfeb0197d75aff967.svg?invert_in_darkmode" align=middle width=9.867000000000003pt height=14.155350000000013pt/> **exists and is unique** if and only if one of the following conditions is true:

- A is **non-singular**;
- The rank of <img src="svgs/53d147e7f3fe6e47ee05b88b166bd3f6.svg?invert_in_darkmode" align=middle width=12.328800000000005pt height=22.46574pt/> is <img src="svgs/55a049b8f161ae7cfeb0197d75aff967.svg?invert_in_darkmode" align=middle width=9.867000000000003pt height=14.155350000000013pt/>: <img src="svgs/c2ad9b3735be33abe87fd6a76c20de5f.svg?invert_in_darkmode" align=middle width=92.40313499999999pt height=24.65759999999998pt/>;
- The system only admits the solution <img src="svgs/8436d02a042a1eec745015a5801fc1a0.svg?invert_in_darkmode" align=middle width=39.53185500000001pt height=21.18732pt/>.

The solution can be algebrically computed by calculation of the inverse of <img src="svgs/53d147e7f3fe6e47ee05b88b166bd3f6.svg?invert_in_darkmode" align=middle width=12.328800000000005pt height=22.46574pt/>: <img src="svgs/f02a9fe447e5053233378f67fcd0f12f.svg?invert_in_darkmode" align=middle width=144.61161pt height=26.76201000000001pt/>. The problem is that computing the inverse can be pretty difficult. We can exploit the **Cramer's rule**, which simply allows us to calculate the <img src="svgs/9fc20fb1d3825674c6a279cb0d5ca636.svg?invert_in_darkmode" align=middle width=14.045955000000003pt height=14.155350000000013pt/>s by substituting the <img src="svgs/77a3b857d53fb44e33b53e4c8b68351a.svg?invert_in_darkmode" align=middle width=5.663295000000005pt height=21.683310000000006pt/>-th column of <img src="svgs/53d147e7f3fe6e47ee05b88b166bd3f6.svg?invert_in_darkmode" align=middle width=12.328800000000005pt height=22.46574pt/> with <img src="svgs/4bdc8d9bcfb35e1c9bfb51fc69687dfc.svg?invert_in_darkmode" align=middle width=7.054855500000005pt height=22.831379999999992pt/>, obtaining <img src="svgs/4ebf880807deff5796460f39aea46f80.svg?invert_in_darkmode" align=middle width=16.979820000000004pt height=22.46574pt/>, then dividing the determinant of <img src="svgs/4ebf880807deff5796460f39aea46f80.svg?invert_in_darkmode" align=middle width=16.979820000000004pt height=22.46574pt/> for the determinant of <img src="svgs/53d147e7f3fe6e47ee05b88b166bd3f6.svg?invert_in_darkmode" align=middle width=12.328800000000005pt height=22.46574pt/>: <img src="svgs/4722257d2e513af80075e7e2c0276bc9.svg?invert_in_darkmode" align=middle width=165.81295500000002pt height=29.461410000000004pt/>.

The computation can still be pretty complicated, so we can distinguish between two methodologies:

- **Direct methods** yield the solution in a finite number of steps, which are usually computationally costly;
- **Iterative methods** theoretically require an infinite number of steps: they converge to the solution for <img src="svgs/7127d8b7d6f62743e98c1fe712bd4191.svg?invert_in_darkmode" align=middle width=47.672295000000005pt height=21.683310000000006pt/>. They are less precise but less expensive.

It is also very important to check the errors we obtained, that are usually generated in two ways: the **rounding errors** (aka arithmetic errors), which depend on the algorithm steps, and **inherent errors**, which depend on the data representation and not on the algorithm. When the first ones are limited to a constant, we can define the algorithm **stable**. When the latter are large, we define the problem as **ill-posed**.

### Direct methods

To solve the problem, we can [LU factorize the matrix](#lufact), then solve two triangular systems: <img src="svgs/83d259ea7b38ad807b9299e13981fcd3.svg?invert_in_darkmode" align=middle width=109.092555pt height=22.831379999999992pt/>. This can be obtained by: <img src="svgs/c4254968840ed022c69d56ef9ea23542.svg?invert_in_darkmode" align=middle width=380.85085499999997pt height=26.76201000000001pt/>.

If we're using the pivoting algorithm, we have to remind that <img src="svgs/549ff8d7e94442ee4eea3366cfffeb7f.svg?invert_in_darkmode" align=middle width=76.369755pt height=22.831379999999992pt/>, therefore <img src="svgs/1c728a3e964dc62f37c4faf87f41e9b5.svg?invert_in_darkmode" align=middle width=121.92939pt height=22.831379999999992pt/>.

### Iterative methods

**Iterative methods** allow us to approximate the solution, which ideally would be obtained with an infinite amount of steps. 

The basic idea is to construct a sequence of vectors <img src="svgs/41a0912d0f46af38c7fa2115d8f0386e.svg?invert_in_darkmode" align=middle width=16.661040000000003pt height=14.155350000000013pt/> that converge to the solution: <img src="svgs/572fbb6188fe06833df3ce10d619f697.svg?invert_in_darkmode" align=middle width=115.15349999999998pt height=22.831379999999992pt/>, where <img src="svgs/1da57587812d6070f08b912a6488a939.svg?invert_in_darkmode" align=middle width=16.130235000000003pt height=22.638659999999973pt/> is the exact solution and the starting guess <img src="svgs/e714a3139958da04b41e3e607a544455.svg?invert_in_darkmode" align=middle width=15.947580000000002pt height=14.155350000000013pt/> is given. 

In general, the sequence <img src="svgs/41a0912d0f46af38c7fa2115d8f0386e.svg?invert_in_darkmode" align=middle width=16.661040000000003pt height=14.155350000000013pt/> is obtained through a function (or a particular set of operations) <img src="svgs/3cf4fbd05970446973fc3d9fa3fe3c41.svg?invert_in_darkmode" align=middle width=8.430510000000004pt height=14.155350000000013pt/>, that acts on the last <img src="svgs/332cc365a4987aacce0ead01b8bdcc0b.svg?invert_in_darkmode" align=middle width=9.395100000000005pt height=14.155350000000013pt/>: <img src="svgs/de747edd5f9f4b421421aa0b937c6845.svg?invert_in_darkmode" align=middle width=94.92581999999999pt height=24.65759999999998pt/>. Different classes of iterative methods are available, with the most common being **stationary iterative methods** and **gradient-like methods**. The first ones take the form <img src="svgs/2ff51da76a00b2d0156371305da96a2e.svg?invert_in_darkmode" align=middle width=116.729415pt height=22.831379999999992pt/>, where <img src="svgs/61e84f854bc6258d4108d08d4c4a0852.svg?invert_in_darkmode" align=middle width=13.293555000000003pt height=22.46574pt/> is called an *iteration matrix* and <img src="svgs/190083ef7a1625fbc75f243cffb9c96d.svg?invert_in_darkmode" align=middle width=9.817500000000004pt height=22.831379999999992pt/> is a vector obtained from <img src="svgs/4bdc8d9bcfb35e1c9bfb51fc69687dfc.svg?invert_in_darkmode" align=middle width=7.054855500000005pt height=22.831379999999992pt/>. The latter take the form of <img src="svgs/fd9600b0ea778ea3a101edeaf5a56f46.svg?invert_in_darkmode" align=middle width=127.75883999999998pt height=19.178279999999994pt/>, where <img src="svgs/520ccf06899de2fec066cf3ff72514a5.svg?invert_in_darkmode" align=middle width=50.566889999999994pt height=22.64855999999997pt/> is a constant called **stepsize** and <img src="svgs/a28020cb9b58a3a875adec3adf5d824a.svg?invert_in_darkmode" align=middle width=15.536730000000006pt height=14.155350000000013pt/> is a vector called **direction.**

If <img src="svgs/53d147e7f3fe6e47ee05b88b166bd3f6.svg?invert_in_darkmode" align=middle width=12.328800000000005pt height=22.46574pt/> is symmetric and positive definite, and the vectors <img src="svgs/a28020cb9b58a3a875adec3adf5d824a.svg?invert_in_darkmode" align=middle width=15.536730000000006pt height=14.155350000000013pt/> have the conjugacy property (which basically means that <img src="svgs/d21ad60891c8cb92a3006d4bb499ed9c.svg?invert_in_darkmode" align=middle width=136.89307499999998pt height=27.656969999999987pt/>) the method is called **conjugate gradients**.

All of these methods require a matrix multiplication for every step: therefore, the computational complexity is <img src="svgs/c5566036dd2bd924fef1c6263072eb45.svg?invert_in_darkmode" align=middle width=43.57023pt height=26.76201000000001pt/>. Since the steps should be infinite, we have to define stopping criteria, which are usually based on the residual <img src="svgs/5e0fb508b2d36e5b54723e62fb2376f8.svg?invert_in_darkmode" align=middle width=93.557805pt height=22.831379999999992pt/>, in the absolute way (<img src="svgs/32e2db224f97440bb4832398e6d5a1f8.svg?invert_in_darkmode" align=middle width=60.532725pt height=24.65759999999998pt/>) or relative (<img src="svgs/2236d05875f5877ef69913f4f393d83f.svg?invert_in_darkmode" align=middle width=57.322649999999996pt height=33.20559pt/>). We can even just check how much the <img src="svgs/332cc365a4987aacce0ead01b8bdcc0b.svg?invert_in_darkmode" align=middle width=9.395100000000005pt height=14.155350000000013pt/> changes from one iteration to the other: <img src="svgs/e9c2aa7b68d816d2a8c6baaf565dfe41.svg?invert_in_darkmode" align=middle width=119.10393pt height=24.65759999999998pt/>.

### Inherent errors in linear systems

Remember that **inherent errors** only depend on the data representation, not on the algorithm.

We should therefore try to consider **what happens to the solution** <img src="svgs/332cc365a4987aacce0ead01b8bdcc0b.svg?invert_in_darkmode" align=middle width=9.395100000000005pt height=14.155350000000013pt/> when the input data **slightly change**. Let's suppose that <img src="svgs/53d147e7f3fe6e47ee05b88b166bd3f6.svg?invert_in_darkmode" align=middle width=12.328800000000005pt height=22.46574pt/> doesn't change, and <img src="svgs/4bdc8d9bcfb35e1c9bfb51fc69687dfc.svg?invert_in_darkmode" align=middle width=7.054855500000005pt height=22.831379999999992pt/> changes by a quantity <img src="svgs/0d03c7a2c2508c590e57358de56f07df.svg?invert_in_darkmode" align=middle width=20.753535000000003pt height=22.831379999999992pt/>: <img src="svgs/6ad85c3017c6799e1e6b9e86fcb09e61.svg?invert_in_darkmode" align=middle width=147.511155pt height=24.65759999999998pt/>. We now want to **compare the relative changes** <img src="svgs/98dfe091fb378cd8c904eca107690a28.svg?invert_in_darkmode" align=middle width=40.46361pt height=28.67072999999997pt/> and <img src="svgs/7db388610bebbbd75040d74bad88ed26.svg?invert_in_darkmode" align=middle width=38.79018000000001pt height=28.926479999999973pt/> to see how much the solution changes. Let's subtract <img src="svgs/6ffa573707fca115cad7b243d91a7109.svg?invert_in_darkmode" align=middle width=50.69625pt height=22.831379999999992pt/> to the equation we obtained: <img src="svgs/ec74bb1b76ac6331dadf3f76fd321c21.svg?invert_in_darkmode" align=middle width=78.093675pt height=22.831379999999992pt/>, then extract <img src="svgs/3919bbc84b8079e27194efe99a1f6a80.svg?invert_in_darkmode" align=middle width=23.09373pt height=22.46574pt/>: <img src="svgs/cdbe937f3513c2f4eff52d28d7a0bae4.svg?invert_in_darkmode" align=middle width=95.742075pt height=26.76201000000001pt/>. We know as a property of norms that the norm of the multiplication is always lesser or equal than the multiplication of the norms: <img src="svgs/74682a6f23fa2391f2aaafa14ccd5483.svg?invert_in_darkmode" align=middle width=172.695105pt height=26.76201000000001pt/>.

Getting back to our usual equation, we know that <img src="svgs/aeb0df286b1708ef52b568fce4e3cb0d.svg?invert_in_darkmode" align=middle width=83.57316pt height=24.65759999999998pt/>, mirror it, <img src="svgs/0dd43818682484db6c6c6cdf16145ec5.svg?invert_in_darkmode" align=middle width=83.57316pt height=24.65759999999998pt/>, then observe that, as before, the norm of the multiplication is lesser or equal than the multiplication of the norms: <img src="svgs/27c0c049e6cf2d50ec09a7feefcac113.svg?invert_in_darkmode" align=middle width=114.68044499999999pt height=24.65759999999998pt/>. We can therefore conclude that <img src="svgs/7cf26ad1eb4aa9e65f91d29e968acab2.svg?invert_in_darkmode" align=middle width=79.84712999999999pt height=28.926479999999973pt/>.

Let's put together all of these things and we get that 

<img src="svgs/b3c1b2b1ded522859853a704bded2424.svg?invert_in_darkmode" align=middle width=193.331655pt height=33.20559pt/>. We can give a name to <img src="svgs/46dd5742a919e73b90b59f595dd5d5c4.svg?invert_in_darkmode" align=middle width=87.05499pt height=26.76201000000001pt/>, and we'll call it **condition number** <img src="svgs/0044dd7421e9e5ad6989f7ed5a24b3e1.svg?invert_in_darkmode" align=middle width=40.25125500000001pt height=24.65759999999998pt/>.

In general, <img src="svgs/0044dd7421e9e5ad6989f7ed5a24b3e1.svg?invert_in_darkmode" align=middle width=40.25125500000001pt height=24.65759999999998pt/> depends on the choice of the norm, indicated by a subscript. Notice that <img src="svgs/efe1423de3a871920d3e2bce8e416949.svg?invert_in_darkmode" align=middle width=70.388175pt height=24.65759999999998pt/> since $AA^{-1}=I$, therefore has norm equal to 1,

 but basing on the norm properties we know that the norm of <img src="svgs/12006f890b98ff5e1b3c0e226ff98bde.svg?invert_in_darkmode" align=middle width=41.484300000000005pt height=26.76201000000001pt/> will always be greater or equal than the single norms multiplied. If <img src="svgs/0044dd7421e9e5ad6989f7ed5a24b3e1.svg?invert_in_darkmode" align=middle width=40.25125500000001pt height=24.65759999999998pt/> is large, we know that the matrix <img src="svgs/53d147e7f3fe6e47ee05b88b166bd3f6.svg?invert_in_darkmode" align=middle width=12.328800000000005pt height=22.46574pt/> is almost a singular matrix and its column are almost linearly dependent. Regularization techniques can reduce <img src="svgs/0044dd7421e9e5ad6989f7ed5a24b3e1.svg?invert_in_darkmode" align=middle width=40.25125500000001pt height=24.65759999999998pt/>. 

## Linear least squares

Now, let's consider an *overdetermined* system $Ax=b$, where $A$ has dimension $m \times n$ with $m > n$, $x$ has dimension $n$ and $b$ has dimension $m$.

Such a system usually **has no solution**: $b$ does not lie on the subspace spanned by the columns of $A$. Since no solution exists, we'd like to get an **approximation**.

We'll need some tools first.

**Projections** are an important class of linear transformations. When working in ML, we often have high-dimensional data which is pretty hard to visualize. Oftentimes, only a few dimensions are useful: we can therefore compress the data to still get *knowledge* from a reduced set of data, minimizing the loss.

The **projection** $z=\prod_U(x)$ is the closest point to $x$ of the subspace $U$ generated by $b$. With *closest*, we mean that it has the least distance of the 2-norm. The vector $z-x$ is orthogonal to the subspace U, which just means that $\left\langle\mathbf{z}-\mathbf{x}, \mathbf{b}\right\rangle=0$.

The vector $z$ is a vector of the subspace generated by $b$, hence $z=\alpha b, \alpha \in \mathbb{R}$.

We can find $\alpha$ by knowing that $\left\langle x-z,b \right\rangle = 0 \rightarrow \left\langle z-\alpha x,b \right\rangle = 0 \rightarrow \left\langle x,b \right\rangle - \alpha\left\langle b,b \right\rangle = 0$. 

Let's divide and we get $\alpha = \frac{\left\langle x,b \right\rangle}{\left\langle b,b \right\rangle}=\frac{x^Tb}{\|b\|^2}$.

### Best approximation theorem

Let's consider a subspace $W$, with dimension $p$ of $\mathbb{R}^n, y \in \mathbb{R}^n$ and $\hat{y}=proj_W(y)$.

Then, the distance $\|y-\hat{y}\|<\|y-v\|, \forall v \in W, v \neq \hat{y}$. This means that $\hat{y}$ is the **best approximation** of $y$ in the subspace $W$, i.e. no other vector in the subspace is as near as $\hat{y}$.

The idea is to use projections to find the vector in $Col(A)$, the subspace generated by set of all the columns of A, which is closest to $b$. As we have just seen, this vector is nothing more than the orthogonal projection of $b$ onto the subspace $Col(A)$.

### The linear least squares problem

As already said, finding the solution of $Ax=b$ when $m > n$ is impossible. The orthogonal projections allow us to find a vector $x$ that is **near** (i.e. has a low 2-norm distance) the solution. The problem is then formulated as to find a $\hat{x}$ that minimises the distance: $\hat{x}=argmin_x\|Ax-b\|^2_2$.

To analyze the existence and uniqueness of the solution, we can consider two different cases:

- $rank(A)=n$, meaning that every column of $A$ is **linearly independent**. We can say that a unique solution exists for every $b$ in $\mathbb{R}^m$. Let $x^*$ be the approximate solution, we have $Ax^*=proj_{Col(A)}(b)$, which means that $\mathbf{b}-\mathrm{Ax}^{*} \in[\operatorname{Col}(\mathrm{A})]^{\perp} \rightarrow A^T(b-Ax^*)=0$. We then obtain the normal equations $A^TAx^*=A^Tb$ which is a linear system in $n$ equations and $n$ unknowns. $A^TA$ is called *Gramian Matrix* of $A$ and is non-singular, positive definite and symmetric. We can finally get the approximate solution: $x^*=(A^TA)^{-1}A^Tb$;

- $rank(A)=k, k<n$, meaning that there is an **infinite number of solutions**. We can find the least squares solution to the problem by using the **pseudoinverse** obtained via SVD:

  $\mathrm{Ax}=\mathbf{b} \Longrightarrow \mathrm{A}^{+} \mathrm{Ax}^{*}=\mathrm{A}^{+} \mathbf{b} \Longrightarrow \mathbf{x}^{*}=\mathrm{A}^{+} \mathbf{b} \Longrightarrow \mathbf{x}^{*}=\sum_{i=1}^{k} \frac{\mathbf{u}_{\mathrm{i}}^{T} \mathbf{b}}{\sigma_{i}} \mathbf{v}_{i}$

  It is possible to modify the linear least squares problem by introducing a weight matrix with the aim of giving different weights to the components of $x$: $\hat{\mathbf{x}}=\operatorname{argmin}_{x}\|\mathbf{W} \AA \mathbf{x}-\mathbf{b}\|_{2}^{2}$ where $W$ is an invertible matrix, which gets us to the *weighted normal equations*: $(\mathrm{WA})^{T} \mathrm{WAx}=(\mathrm{WA})^{T} \mathbf{b}$

# Numerical optimization

We've now come at the core of it all: Machine Learning is actually all about **minimization**. In fact, in order to train ML models we need to compute the **best parameters** for the training data set. The thing is: *how do we find what's best?* We can consider *best parameters* as those that minimize (or maximize) the objective function, which is usually called **loss function**. The algorithms that do this are called **optimization algorithms**. Basing on the problem, we can have unconstrained or constrained optimisation: oftentimes the problem imposes some constraints.

Before we talk about **how to find** solutions, we've gotta find out whether **they exist** and are **unique**.

The minimization of a function in several variables can be formulated, with $f:\mathbb{R}^n \rightarrow \mathbb{R}$ called **objective function** as minimize $f(x)$ in $\mathbb{R}^n$: this is called an **unconstrained optimization problem**. 

Typically, we want to determine the optimal values of several variables that have constraints, like equality or inequality ones or maybe being lying on a subset of $\mathbb{R}^n$. This kind of optimization is said **constrained** (still pretty obvious) and can be formulated as minimize $f(x)$ in $\Omega \subset \mathbb{R}^n$. 

Before we actually dive into the topic, let's consider a bit of *context*.

## Preliminaries on multivariate functions

### Partial derivatives and gradients

Let's consider a function $f:\mathbb{R}^n\rightarrow\mathbb{R}$. We say that $f$ is **differentiable with respect to $x_i$** if the limit $lim_{h\rightarrow0} \frac{f(x_1,\dots,x_i+h,\dots,x_n) - f(x_1,\dots,x_n)}{h} = \frac{\partial f}{\partial x_{i}}(\mathbf{x})$ exists. A function is said **differentiable at a point $x_0$** if and only if **all the partial derivatives** exist in $x_0$.

Given a function $f:\mathbb{R}^n\rightarrow \mathbb{R}$, the vector containing all of the partial derivatives is called **gradient of $f$**: $\nabla f(x)=\left(\frac{\partial f}{\partial x_{1}}(\mathbf{x}), \dots, \frac{\partial f}{\partial x_{n}}(\mathbf{x})\right)$.

Given a function $f:\mathbb{R}^n\rightarrow \mathbb{R}$, **differentiable to the second order**, its **Hessian** matrix $\nabla^2 f(x)$ is defined as follows:

$\mathrm{H}_{f}(\mathbf{x})=\nabla^{2} f(\mathbf{x})=\left[\begin{array}{cccc}
\frac{\partial^{2} f}{\partial x_{1}^{2}} & \frac{\partial^{2} f}{\partial x_{1} \partial x_{2}} & \cdots & \frac{\partial^{2} f}{\partial x_{1} \partial x_{n}} \\
\frac{\partial^{2} f}{\partial x_{2} \partial x_{1}} & \frac{\partial^{2} f}{\partial x_{2}^{2}} & \cdots & \frac{\partial^{2} f}{\partial x_{2} \partial x_{n}} \\
\vdots & \vdots & \ddots & \vdots \\
\frac{\partial^{2} f}{\partial x_{n} \partial x_{1}} & \frac{\partial^{2} f}{\partial x_{n} \partial x_{2}} & \cdots & \frac{\partial^{2} f}{\partial x_{n}^{2}}
\end{array}\right]$

Given a function $f: \mathbb{R}^n \rightarrow \mathbb{R}^m$ (note that this time **the output of the function is a vector and not a scalar**), and knowing that all its partial derivatives exist, we call **Jacobian** the following matrix:

$\mathrm{J}_{f}(\mathbf{x})=\frac{\partial \mathbf{f}}{\partial \mathbf{x}}(\mathbf{x})=\left[\begin{array}{c}
\nabla f_{1}(\mathbf{x}) \\
\nabla f_{2}(\mathbf{x}) \\
\vdots \\
\nabla f_{m}(\mathbf{x})
\end{array}\right]=\left[\begin{array}{cccc}
\frac{\partial f_{1}}{\partial x_{1}} & \frac{\partial f_{1}}{\partial x_{2}} & \cdots & \frac{\partial f_{1}}{\partial x_{n}} \\
\frac{\partial f_{2}}{\partial x_{1}} & \frac{\partial f_{2}}{\partial x_{2}} & \cdots & \frac{\partial f_{2}}{\partial x_{n}} \\
\vdots & \vdots & \ddots & \vdots \\
\frac{\partial f_{m}}{\partial x_{1}} & \frac{\partial f_{m}}{\partial x_{2}} & \cdots & \frac{\partial f_{m}}{\partial x_{n}}
\end{array}\right]$

If we have two functions $f: \mathbb{R}^n \rightarrow \mathbb{R}^m$ and $g:\mathbb{R}^m \rightarrow \mathbb{R}^p$ and we **compose** them $\mathbf{g} \circ \mathbf{f}: \mathbb{R}^{n} \rightarrow \mathbb{R}^{r}$, the Jacobian is given by $J_{g\circ f}(x)=J_g(f(x)) \cdot J_f(x)$.

### Minimum points

A point $x^* \in \mathbb{R}^n$ is called a (strict) **local minimum point** if the function is at its lowest value in a range $\epsilon$: $f\left(\mathbf{x}^{*}\right) \leq f(\mathbf{x})\left(\text { resp. } f\left(\mathbf{x}^{*}\right)<f(\mathbf{x})\right), \quad \forall \mathbf{x} \in \mathbb{R}^{n}, \mathbf{x} \neq \mathbf{x}^{*}$.

The same point is called **global minimum** if the *range* is $\mathbb{R}^n$: $f\left(\mathrm{x}^{*}\right) \leq f(\mathrm{x})\left(\text { resp. } f\left(\mathrm{x}^{*}\right)<f(\mathrm{x})\right), \quad \forall \mathrm{x} \in \mathbb{R}^{n}, \mathrm{x} \neq \mathrm{x}^{*}$.

The **first order optimality condition**, also known as **Fermat's theorem for stationary points**, states that if $x^*$ is a local **optimum** point and $f$ is differentiable in $x^*$, then the gradient is equal to zero: $\nabla f(x^*) = 0$.

The **second order optimality condition** states that if $x^*$ is a local **minimum** point for $f$, and $f$ is twice differentiable around $x^*$, the $\nabla f(x^*)$ will be 0 and the $\nabla^2 f(x^*)$ is **positive semidefinite**.

Therefore, we can state the final condition for the local minimum points: if $f: \mathbb{R}^n \rightarrow \mathbb{R}$ is twice differentiable with **continuity** around $x^* \in \mathbb{R}^n$ and $\nabla f(x^*)=0$, with $\nabla^2 f(x^*)$ **positive definite**, then $x^*$ **is a strict local minimum point**.

### Convexity

Let's consider a set $\mathbb{C} \subset \mathbb{R}^n$: we can say it is a **convex set** if, for every $x,y$ in the set and a scalar $\theta \in[0,1]$ we have that $\theta x + (1-\theta)y \in \mathbb{C}$.

Now, having a function $f: \mathbb{D} \rightarrow \mathbb{R}$, where $\mathbb{D} \subset \mathbb{R}^n$ is a **convex set**, $f$ is a **convex function** if, for all the $x,y \in \mathbb{D}$ and $\theta \in[0,1]$, we have that $f(\theta x + (1-\theta)y) \le \theta f(x) + (1-\theta)f(y)$.

Finally, we state some properties:

- If $f$ is **twice differentiable** in $x$ and (strictly) **convex**, then $\nabla^2 f(x)$ is **positive semidefinite** (definite);
- If $f$ is a **convex** function, then **each point of local minimum is a global minimum**;
- If $f$ is **strictly convex**, then **a unique point of global minimum exists**.

## Iterative methods

So, what are iterative methods? An iterative method, given an initial vector $x_0 \in \mathbb{R}^n$, computes $x_{k+1}=g(x_k)$ for $k\ge0$ , **until convergence**. $g(x)$ is an arbitrary function. What do we mean by convergence? Basically, we have that $x_k \rightarrow x^*$ for $k\rightarrow \infty$, where $x^*$ is a stationary point, i.e. a local minimum. 

As we're working in the real world, it's pretty obvious that we can't compute an infinite amount of steps 😔. What we can do, though, is computing $x_k$ until we reach a **stopping criterion**, which might be, for example,  an **absolute** one like the norm of the gradient $\|\nabla f(x_k)\| < \tau_a$ or a **relative** one like the same quantity divided by the norm of the function $\frac{\|\nabla f(x_k)\|}{\|f\| (x_0)}<\tau_R$. We might even check the succeding values, in absolute $\|x_{k+1}-x_k\|<\tau_{AP}$ and relative $\frac{\|x_{k+1}-x_k}{x_k}<\tau_{RP}$ ways.

In order to evaluate how fast the algorithm will approximate the solution, we define the **convergence speed** as, considering $Px_k$ as a sequence converging to $x^*$:

- **Q-linear** if the distance from the solution reduces by a constant factor $r \in (0,1)$ at $k\rightarrow \infty$: $lim_{k\rightarrow\infty} \frac{\|x_{k+1}-x^*\|}{\|x_k-x^*\|}\le r, \forall k > k^*$
- **Q-superlinear** if the same limit converges to $0$: $lim_{k\rightarrow\infty} \frac{\|x_{k+1}-x^*\|}{\|x_k-x^*\|}=0$
- **Q-quadratic** if it is even faster, in fact $\frac{\|x_{k+1}-x^*\|}{\|x_k-x^*\|^2} \le M, \forall k > k^*$

The Q stands for **Q**uotient because, well, they're quotients 🤷

Remember that these methods converge to a **stationary point**, but that **doesn't always mean** it is a global minimum too.

## Descent methods

The most useful subset of iterative methods is the one containing **descent methods**. These, given an initial vector $x_0 \in \mathbb{R}^n$, compute $x_{k+1}=x_k +\alpha_k p_k$ for $k\ge0$ until convergence. Here, $\alpha_k$ is called **stepsize** and $p_k$ is the **descent direction**. It is effectively called *descent direction* if, for a given $a_k>0$, we have $f(x_k+\alpha_kp_k)<f(x_k)$

Provided that $f$ is continuously differentiable around $x_k$, we have that $p_k^T \nabla f(x_k) < 0$ when $\nabla f(x_k)\neq 0$ and $p_k=0$ when $\nabla f(x_k)= 0$. This basically means that the direction *goes towards* the stationary points.

Note that **the choice of the stepsize is crucial**: a small stepsize could make the descent too slow, while a large stepsize can make the convergence impossible. 

The stepsize is therefore chosen by a *line search* algorithm, implemented with a backtracking algorithm, where an iterative procedure decreases the value of the step size $\alpha$ until suitable conditions for the convergence of the method are satisfied. Why *line search*? Because the new iterate $x_{k+1}$ is searched along the line $p_k$.

We can distinguish between **exact line search**, where $\alpha_k$ is chosen as the minimum of the function $\Phi(\alpha)=f\left(\mathbf{x}_{k}+\alpha \mathbf{p}\right), \quad \alpha \geq 0$ (which is pretty slow) and **inexact line search**, where $\alpha_k$ is chosen to belong to intervals where the convergence is guaranteed. The most common conditions that guarantee this are the **Wolfe** conditions. 

The first one, named **Armijo condition** is the following: $f(x_k + \alpha_kp_k) \le f(x_k)+c_1\alpha \nabla f(x_k)^T p_k$. This ensures that $\alpha_k$ is not too large, but it allows it to be really small. Another way of describing this condition is to say that the decrease in the objective function should be proportional to both the step length and the directional derivative of the function and step direction. In general, $c_1$ is a very small value, $~10^{-4}$.

Since this first condition allows $a_k$ to be very small, we should limit this. The second condition, also known as the **curvature condition**, does exactly so: $\nabla f(x_k + \alpha_k p_k)^T p_k \ge c_2 \nabla f(x_k)^T p_k$. Since this condition is computationally expensive, we can just apply a backtracking algorithm that progressively reduces a starting value of $\alpha$ until the Armijo condition is satisfied. The algorithm should check if $\alpha$ becomes to small: in that case, it just stops.

### Gradient descent method

The **gradient descent method** is basically what we're here for. It is a first order optimization where the descent direction is set as $p_k=-\nabla f(x_k)$. This means that we get $x_{k+1}$ as $x_k-\alpha\nabla f(x_k)$.

The convergence speed is **linear**. To speed things up a bit, we introduce what we call **momentum**. This means that a *memory* part is added to the equation, so that the formula to update $x_k$ becomes: $x_{k+1} = x_k - \gamma_i ((\nabla f)(x_i))^T + \alpha \Delta x_i$, where $\Delta x_i$ is just the distance between the last $x_i$ and the preceding one: $x_i-x_{i-1}=\alpha\Delta x_{i-1} - \gamma_{i-1}((\nabla f)(x_{i-1}))^T$.

### Newton method

The **Newton method** uses second order information of $f$, the **Hessian**.

The direction is set as $p_k=-H_f^{-1} (x_k)\nabla f(x_k)$, provided that $H_f$ is positive definite, within a sufficiently large range of $x^*$. At each iteration we compute $p_k$ as a solution of the linear system $H_f 
(x_k)p_k = \nabla f(x_k)$. 

We know that $p_k$ is a descent direction only if the Hessian $H_f$ is positive definite, and the **convergence properties** are strictly related to it. In fact, if $f \in C^2(\Omega)$, $H_f$ is a Liptschiz function around $x^*$ (which means that $|f(x)-f(y)| \le K\|x-y\|$) and $H_f$ is positive definite we can say that if $x_0$ is near a stationary point $x^*$, the sequence **converges quadratically**. Which is fast.

To speed things up furthermore, we could approximate $H_f$ with a positive definite matrix $B_f(x_k)$, and solve the linear system to compute the direction $p_k$ with **iterative methods** instead of the direct ones.

### Just one more thing

Remember that the starting guess $x_0$ has a crucial role: the algorithm converges to a local minimum, so $x_0$ determines the local minimum it will descend to. Obviously, we don't know where the global is, but if we have an estimation of where it might be we can choose $x_0$ as near as possible. In any case, there's no guarantee that we'll fall into the right minimum 😔

## Convex optimization

Convex quadratic functions take the following form: $q(x)=\frac{1}{2} x^T Qx + c^Tx(+w)$, where $x,c \in \mathbb{R}^n$ and $Q \in \mathbb{R}^{n\times n}$ is symmetric positive definite. A typical quadratic optimization problem is the **least square problem**: *min*$\|Ax-b\|^2$. The objective is to **minimize** $\frac{1}{2} \|Ax-b\|^2=\frac{1}{2}(Ax-b)^T (Ax-b)=\frac{1}{2}x^TA^TAx-b^TAx+\frac{1}{2}b^Tb$, which can be **rewritten in quadratic form** by setting $Q=A^TA$ and $c^T=-b^TQ$. 

We know that the **gradient** $\nabla f(x)$ is $Q^TQx-A^Tb$, therefore when we set $\nabla f(x)=0$ we obtain the normal equation $(Q^TQ)x=Q^Tb$.

A strictly convex function that is frequently encountered in applications is the **quadratic function** $f(x)=\frac{1}{2} x^TQx + b^Tx$, where $Q$ is a **square matrix** of size $n\times n$, symmetric and positive definite, and $b \in \mathbb{R}^n$. In this particular case we have that the gradient $\nabla f(x)$ is $Qx-b$, and the second order gradient $\nabla^2 f(x)$ is simply $A$.

This leads us to the fact that the unique minimizer of $f$ is the solution of the linear system representing $\nabla f(x)=0$, which is $Qx=b$.

### Steepest descent method

The **steepest descent method** is the gradient method applied to a quadratic convex function with **exact line search**. The step length $\alpha_k$ is computed as the global minimum of the variable $\alpha$ (in this case the function is convex) $0=\left.\frac{d}{d\alpha} \phi(\alpha)\right|_{{\alpha=\alpha_k}}$, which leads us to $\alpha_{k}=\frac{\left(\nabla f\left(x_{k}\right)\right)^{T} \nabla f\left(x_{k}\right)}{\left(\nabla f\left(x_{k}\right)\right)^{T} Q \nabla f\left(x_{k}\right)}>0$.

Finally, the algorithm will be something like:

1. $g_k = Q_{x_k} -b$
2. $\alpha_k = \frac{g_k^T g_k}{g_k^T Qg_k}$ 
3. $x_{k+1} = x_k - \alpha_k g_k, k = k+1$

The gradient can be modified by considering Q-conjugate directions $p_i$: $p_i^T Qp_j = 0, \textrm{ for }i\neq j$.

We even cite the **Conjugate Gradient** algorithm, a very fast iterative algorithm for the minimization of a quadratic function (i.e. it solves a linear system $Qx=b$ with $Q$ symmetric and positive definite).

$\begin{array}{l}
\alpha_{k}=-\frac{g_{k}^{T} p_{k}}{p_{k}^{T} A p_{k}} \\
x_{k+1}=x_{k}+\alpha_{k} p_{k} \\
g_{k+1}=A x_{k+1}-b ; \textrm { if } g_{k+1}=0, \textrm { stop } \\
\beta_{k}=\frac{g_{k+1}^{T} A p_{k}}{p_{k}^{T} A p_{k}} \\
p_{k+1}=-g_{k+1}+\beta_{k} p_{k} \\
k=k+1
\end{array}$

If A is symmetric and positive definite, with at most $s$ distinct eigenvalues, then the CG method **converges** in at most **$s$ iterations**!

For any symmetric and positive definite matrix $Q$, we define the *energy norm* $\|x\|_Q=\sqrt{x^TQx}$. Concerning the convergence speed of gradient descent and conjugate gradient algorithms when they're applied to a quadratic function, we can say that the CG method is quite faster than the gradient descent: the steepest gradient descent holds $\left\|\mathbf{x}_{k}-\mathbf{x}^{*}\right\|_{Q}^{2} \leq\left(\frac{K(Q)-1}{K(Q)+1}\right)^{2}\left\|\mathbf{x}_{k-1}-\mathbf{x}^{*}\right\|_{Q}^{2}$, while the CG method holds $\left\|\mathbf{x}_{k}-\mathbf{x}^{*}\right\|_{Q}^{2} \leq\left(\frac{K(Q)-1}{K(Q)+1}\right)\left\|\mathbf{x}_{k-1}-\mathbf{x}^{*}\right\|_{Q}^{2}$, where $k$ is the iteration number and $K(Q)$ is the condition number of $Q$.

## Stochastic optimization

The objective function in ML problems is sometimes related to **probabilistic events**, and it can take the following form $G(x)=\sum_{i=1}^n G_i(x)$, where $G: \mathbb{R}^n\rightarrow \mathbb{R}$ is the loss function computed at the $i\textrm{-th}$ observation of the dataset.

For example, in a **supervised classification problem** we'll want to minimize the **empirical risk function**, i.e. the sum of loss functions for all the examples $x_i$: $R_n(w) = \frac{1}{n}\sum_{i=1}^n l(h(x_i,w))$, where the loss function $l$ is related to the probability distribution of the examples $x_i$.

In the case of a **standard gradient descent**, the iteration is $x_{k+1}=x{k}+\alpha_k \nabla G(x_k)$, which means that we have to calculate the gradient for every sample: $x_k-\alpha_k \sum_{i=1}^n \nabla G_i(x_k)$.

As everyone can imagine, if we have millions of samples in the batch this is crazily difficult to compute🥴

In **stochastic gradient descent**, the true gradient is approximated at each iteration by the gradient at a **single observation**, randomly picked. The iteration step becomes $x_{k+1}=x_k-\alpha_k \nabla G_i(x_k)$.

A compromise between the SGD and the *standard* gradient descent is using a **mini-batch** of randomly picked samples. The step size $\alpha_k$ can be fixed or even computed with a line search procedure. Each iteration is now **very cheap**, and $x_1,\dots,x_k$ is a stochastic process, with a behaviour defined by the random sequence of $i$s. Even if the direction might not be a real descent direction, it is a descent direction in **expectation**, which is proved to converge *in expectation* to a local minimum. The convergence of SGD has been analyzed using the theories behind convex minimization and stochastic approximation; since ML doesn't require a super precise localization of the minimum, SGD is a tremendously good compromise between accuracy and speed.

## Non-linear least squares problem

In non-linear least squares problem we get residuals defined as a **non-linear function** $r: \mathbb{R}^n \rightarrow \mathbb{R}^m$, where $n$ is the dimension of the space of the data and $m$ is the dimension of the space of the unknowns. The minimization of these residuals can be written as $\text{min}\|r(x)\|^2 = \text{min}\sum_{i=1}^m r_i^2 (x)$. We can therefore write the **gradient** of the function $f$ representing the residuals $f: \mathbb{R}^m \rightarrow \mathbb{R}, f=\frac{1}{2}\sum_{i=1}^m r_i^2 (x)$, which is $\nabla f(x)=\sum_{i=1}^m r_i(x)\nabla r_i(x) = J_r^T (x)\cdot r(x)$. 

We can even compute the **Hessian** of $f$ as $\begin{aligned}
\mathrm{H}_{f}(\mathbf{x}) &=\sum_{i=1}^{m}\left(\nabla r_{i}(\mathbf{x}) \cdot \nabla^{T} r_{i}(\mathbf{x})+\nabla r_{i}(\mathbf{x}) \cdot \mathrm{H}_{r_{i}}^{T}(\mathbf{x})\right)=\\
&=\mathrm{J}_{r}^{T}(\mathbf{x}) \cdot \mathrm{J}_{r}(\mathbf{x})+\sum_{i=1}^{m} \nabla r_{i}(\mathbf{x}) \cdot \mathrm{H}_{r_{i}}^{T}(\mathbf{x})
\end{aligned}$

As you can imagine, these formula can be pretty harsh to compute. The methods we can use to solve these problems are the *gradient methods, Newton-like methods, the Gauss-Newton method* (where $p_k$ is computed as $\left(\mathrm{J}_{r}^{T} \cdot \mathrm{J}_{r}\right)\left(\mathbf{x}_{k}\right) \cdot \mathbf{p}_{k}=-\mathrm{J}_{r}^{T}\left(\mathbf{x}_{k}\right) \cdot \mathbf{r}\left(\mathbf{x}_{k}\right)$), or *the Levenberh-Marquardt method*, which adds regularization because the product of the two Jacobians can be ill-conditioned ($p_k$ is computed as $\left(\mathrm{J}_{r}^{T}\left(\mathbf{x}_{k}\right) \cdot \mathrm{J}_{r}\left(\mathbf{x}_{k}\right)+\lambda \mathrm{I}\right) \cdot \mathbf{p}_{k}=-\mathrm{J}_{r}^{T}\left(\mathbf{x}_{k}\right) \cdot \mathbf{r}\left(\mathbf{x}_{k}\right)$).

## Constrained optimization, Lagrange multipliers

We finally consider the problem $\text{min}_xG(x)$, with $h_i(x) \le 0, i-1,\dots,m$.

A possible way of solving this is the introduction of *Lagrange multipliers* $\lambda_i \ge 0$. The *Lagrangian function* associated to the problem is $L(x,\lambda) = G(x)+\sum_{i=1}^m \lambda_i h_i (x)$.

Many numerical methods also use the concept of duality. The minimization in a set of variables, let's say $x$, is transformed into the minimization of another set of variables, like $\lambda$. 

We can associate the **Lagrangian dual problem** to the *primal problem*, in the form of $\text{max}_{\lambda \in R^m} D(\lambda)$ such that $\lambda\ge0$, where $D(\lambda) = \text{min}_{x\in R^n} L(x,\lambda)$ and $\lambda$ are the **dual variables**.

The first one ($D$) is the **minimax problem**; if the solution can be easily performed, then the problem is easy to solve. In fact, the maximization problem of $D(\lambda)$ is a **concave problem**, which has an easy to find maximum, even if $G$ and $h_i$ are not convex.

A particular case is when the functions $G$ and $h_i$ are linear: this is called the **linear programming problem**.

# Probability and statistics

The objective of probability is to **quantify the uncertainty**. We want to first introduce the concepts of random variables and probability distributions. Cool shit. When working in ML, probability is often used to formalize the design of automated reasoning systems. We are also interested in the errors an algorithm produces. We can distinguish between two interpretations of probability: the **Bayesian** interpretation and the **frequentist** interpretation. The first one is also called *subjective probability* because it is used to quantify the degree of uncertainty the user has about an event. The second one considers the frequency of events related to the total number of them. 

## Basics

Here we are, back to basics. Let's define a **random experiment** as an experiment which has an outcome *determined by chance*. The **sample space** is simply the set of all possible outcomes of the experiment. An **event** is a collection of results, i.e. a **subset** of the sample space. The **space of the events** $S(A)$ is the set of all possible events. The **probability of an event $A$** is a function $P: S(A) \rightarrow [0,1] \in \mathbb{R}$ that associates each event $A$ to a number, called **probability** of $A$.

Each **probability function** satisfies 3 properties:

- $P(A)\ge0$, which means that a probability can't be negative;
- $P(S)=1$ , which means that the probability of one of **all the possible outcomes** is 100%
- Given $A_1,\dots,A_n$ disjoint events, the probability of any of them happening is the sum of all the probabilities: $P\left(A_{1} \cup A_{2} \cup \ldots \cup A_{n}\right)=\sum_{i=1}^{n} P\left(A_{i}\right)$

The **conditional probability** of an event $B$ given the event $A$ is $P(B|A)=\frac{P(A \cup B)}{P(A)}$.

For any fixed $A$ having $P(A)>0$, we know that $P(B|A)\ge0$ for every $B$ in the sample space. We know that $P(S|A)=1$, and given $B_1,\dots,B_n$ disjoint events, we know that the probability of one of them happening given $A$ is the sum of all the probabilities given A: $P\left(\bigcup_{i=1}^{n} B_{i} \mid A\right)=\sum_{i=1}^{n} P\left(B_{i} \mid A\right)$. We even know that $\forall A_1,\dots,A_n$ events, $P\left(A_{1} \cap \ldots \cap A_{n}\right)=P(A) \cdot P\left(A_{2} \mid A_{1}\right) \cdot \ldots \cdot P\left(A_{n} \mid A_{1} \cap \ldots \cap A_{n-1}\right)$, which means that the probability of them happening all at the same time is the multiplication of all the conditional probabilities.

Two events $A$ and $B$ are **independent** if and only if the probability of them happening at the same time is the multiplication of the single probabilities: $P(A \cap B ) = P(A)\cdot P(B)$.

Given two disjoint events $A,B$, with the union of them being the sample space, we have that $P(B|A) = \frac{P(A|B)P(B)}{P(A)}$. This theorem, known as the **Bayes' theorem**, can be extended to multiple events, pairwise disjoint and exhaustive: $P\left(B_{i} \mid A\right)=\frac{P\left(A \mid B_{i}\right) P\left(B_{i}\right)}{\sum_{i=j}^{n} P\left(A \mid B_{j}\right) P\left(B_{j}\right)}$.

## Random variables

A **random variable** associates events to numbers. This helps us in the mathematical description of the probabilities. Mathematically speaking, a **random variable** is a function $X: S \rightarrow \mathbb{R}$ that associates each outcome $w\in S$ to a number $x\in\mathbb{R}$: $X(w)=x$. The set of all the possible values of the random variable is called **target space** (aka **support**) of $X, S_X$.

If the target space is a countable set, the random variable is said **discrete**. If it is not countable, we're working with a **continuous RV**.

We can associate to the RV probability functions, that describe how the probabilities are distributed. We'll talk about **univariate** distributions when there's a single RV involved, and **multivariate** when there's more.

### Probability Mass Function

Each **discrete** RV has a function associated to itself, called **Probability Mass Function** (PMF), which describes the mapping between the event and the outcome: $p_X: S_X \rightarrow [0,1] \in \mathbb{R}$, such that the function takes a value as input and outputs the probability that the RV has that value: $p_X(x)=P(X=x), x \in S_X$. Obviously, the sum of all the possible outputs will be equal to $1$.

The **expectation** of a discrete RV is defined as $\mu = \mathbb{E}[X]=\sum_{x\in S_X} xf_X(x)$.

We can extend the concept **to functions**, so that $\mathbb{E}[g(X)]=\sum_{x\in S_X} g(x)p_X(x)$.

The **variance** of a discrete RV is defined as $\sigma^2=\mathbb{E}[(X-\mu)^2]$, or simply $\mathbb{E}[X^2]-\mathbb{E}^2[X]$.

Some examples of PMF might be the *discrete uniform distribution* $\frac{1}{n}$, or the Poisson $p_X(x)=e^{-\lambda}\frac{\lambda^x}{x!}$, where $\mu=\lambda$ and $\sigma^2=\lambda$.

### Multivariate discrete distributions

While in the univariate case, the target space of a RV is a vector, now it's the cartesian product of the single target spaces: a **multidimensional array**. For example, in bivariate RVs it's a matrix.

The **joint probability mass function** of $X$ and $Y$ is defined as $p_{XY}=P(X=x_i, Y=y_j)=\frac{a_{ij}}{N}$, with $(x,y) \in S_{XY}$, where $a_{ij}$ is the elemeent of the matrix storing all the possible $X$ and $Y$s, and $N$ is the total number of matrix elements. We can also write $f_{XY}$ as $p(x,y)$.

Given the $p_{XY}$ joint probability mass function, we define the **marginal probability distribution** of $X$ as $p_X(x)=\sum_{y \in S_Y} P(X=x, Y=y)$ and the one of $Y$ as $p_Y(y)=\sum_{x \in S_X} P(X=x, Y=y)$. Note that this is basically just the consideration of the probabilities of a single variable.

### Continuous random variables

Obviously, we can't have PMFs with continuous RVs. What we have, though, are **Probability Density Functions** (PDF), which are basically the continuous version of PMFs: $P(a\le X\le b) = \int_a^b p_X(x)dx, \forall[a,b] \in S_X$. Obviously, when considering the whole target space we'll get $1$ as always: $\int_a^b p(x)dx=1$.

Some examples of PDFs are the *normal distribution* $p_X(x)=\frac{1}{\sigma\sqrt{2\pi}} \text{exp}\left(-\frac{(x-\mu)^2}{2\sigma^2}\right)$, where $\mu$ is the expectation and $\sigma$ the standard deviation, and the *exponential distribution* $p_X(x)=\lambda e^{-\lambda x}$ which ahs mean $\mu=\frac{1}{\lambda}$ and standard deviation $\sigma=\frac{1}{\lambda}$.

## Bayes' theorem

Given two RVs $X$ and $Y$, let's consider the instances in which $X=x$. We can define ***conditional probability*** of $y$ given $x$  $p(y|x)$ the fraction of instances for which $Y=y$.

Note that the following calculations are made in the *discrete* case: for continuous RVs, substitute sums with integrals.

### Sum rule

Let's consider two discrete RVs $x$ and $y$, we know that $p(x)=\sum_{y\in Y} p(x,y)$, i.e. the probability of $x$ happening is the sum of all the probabilities in which $x$ happens together with every $y$: the **marginal distribution** of one rv is the sum on the events of the other rv. If we have more RVs, we can just sum them:  $p\left(x_{i}\right)=\sum_{y \in\left(x 1, \ldots x_{i-1}, x i+1, \ldots x_{n}\right)} p\left(x_{1}, \ldots x_{n}\right)$.

### Product rule

Now, with $x$ and $y$, we can state that $p(x,y)=p(y|x)p(x)$, i.e. the probability of $x$ and $y$ happening is the probability of $y$ happening when $x$ has happened, multiplied by the probability of $x$ happening. Still pretty obvious.

Let's suppose we have prior on an unobserved variable $x$, and we know the relationship between $x$ and another RV, $y$, which is observed. We can say that 

$p(x|y)=\frac{p(y|x)p(x)}{p(y)}$, where:

- $p(x|y)$ is called **posterior**, and it is the information we're seeking;
- $p(y|x)$ is the **likelihood**, which is the probability of the observed rv, $y$, given $x$. Basically the inverse of what we're seeking;
- $p(x)$ is the **prior**, i.e. knowledge about the discrete probability distribution of $x$, the unobserved RV;
- $p(y)$ is the **evidence**, i.e. the known probability of the observed $y$.

Sometimes, calculating the exact posterior can be difficult, maybe because we only got some informations like the mean or the maximum. Some ML algorithms aim exactly at finding the posterior.

# Statistics

We call **statistic** and index related to a RV. Let's first introduce the **expected value** of a function $g(x)$ of a univariate RV $X$ with PDF $p(x)$ as $\mathbb{E}[g(x)]=\sum_{x \in S_X} g(x) p(x)dx$.

If we consider multivariate RVs, we can just put the results in a vector.

The **mean** of a univariate RV with states $\{x_1,...,x_n\}$ is an average defined as $\mathbb{E}_X[x]=\sum_{x_i \in S_X} x_i p(x_d=x_i)$, with extension for multivariate as before.

We can also define the **median** as the measure of the center of the distribution.

For two univariate RVs $X$ and $Y$ we can define the **covariance**, which measures how independent they are: $\operatorname{Cov}[x,y]=\mathbb{E}[(x-\mu_x)(y-\mu_y)]=\mathbb{E}[xy]-\mathbb{E}[x]\mathbb{E}[y]$.

Obviously, $\operatorname{Cov}(x,x)$ is the variance of $X, \mathbb{V}_X[x]$, and the square root of the variance is the **standard deviation**. For multivariate RVs we can define the covariance as $\operatorname{Cov}(x,y)=\mathbb{E}[xy^T]-\mathbb{E}[x]\mathbb{E}[y^T]$.

The **correlation** between two RVs $X$ and $Y$ is defined as $\operatorname{Corr}(x,y)=\frac{\operatorname{Cov}(x,y)}{\sigma(x)\sigma(y)} \in [-1,1]$

## Inferential statistics

**Inferential statistics** try to deduce underlying properties of a distribution just by looking at some samples. 

Suppose we have identical distributed univariate RVs $X_1,\dots,X_n$, with realizations $x_1,\dots,x_n$. The **empirical mean** is defined as $\overline{x}=\frac{1}{N}\sum_{i=1}^N x_i$, while the **empirical variance** is defined as $\Sigma=\frac{1}{N}\sum_{i=1}^N (x_i-\overline{x})^2$.

In the case of multivariate RVs $X_1,\dots,X_n$, the mean is a $D$ vector of mean and the covariance is a $D \times D$ matrix defined by $\Sigma=\frac{1}{N} \sum_{i=1}^N (x_i-\overline{x})(x_i-\overline{x})^T$.

Two RVs $X$ and $Y$ are **independent** if $p(x,y)=p(x)p(y)$.

## Gaussian distribution

The **Gaussian distribution** is super famous. The PDF is $p(x|\mu, \sigma^2) = \frac{1}{\sqrt{2\pi \sigma^2}} \operatorname{exp}\left(-\frac{(x-\mu)^2}{2\sigma^2}\right)$. In the case of $\mu=0, \sigma=1$, the distribution is called **normal distribution**.

The conditional and marginal distributions of the Gaussian have a closed form. If we consider the probability $p(\boldsymbol{x}, \boldsymbol{y})=\mathcal{N}\left(\left[\begin{array}{l}
\boldsymbol{\mu}_{x} \\
\boldsymbol{\mu}_{y}
\end{array}\right],\left[\begin{array}{ll}
\boldsymbol{\Sigma}_{x x} & \boldsymbol{\Sigma}_{x y} \\
\boldsymbol{\Sigma}_{y x} & \boldsymbol{\Sigma}_{y y}
\end{array}\right]\right)$ with $\Sigma_{xx} = \operatorname{Cov}[x,x]$ and $\Sigma_{yy}=\operatorname{Cov}[y,y]$, the **marginal covariance matrices** then $\begin{aligned}
p(\boldsymbol{x} \mid \boldsymbol{y}) &=\mathcal{N}\left(\boldsymbol{\mu}_{x \mid y}, \boldsymbol{\Sigma}_{x \mid y}\right) \\
\boldsymbol{\mu}_{x \mid y} &=\boldsymbol{\mu}_{x}+\boldsymbol{\Sigma}_{x y} \boldsymbol{\Sigma}_{y y}^{-1}\left(\boldsymbol{y}-\boldsymbol{\mu}_{y}\right) \\
\boldsymbol{\Sigma}_{x \mid y} &=\boldsymbol{\Sigma}_{x x}-\boldsymbol{\Sigma}_{x y} \boldsymbol{\Sigma}_{y y}^{-1} \boldsymbol{\Sigma}_{y x}
\end{aligned}$ and the marginal distribution is $p(x)=\int p(x,y)dy = \mathcal{N}(x|\mu_x, \Sigma_{xx})$.

# Predictive function models

Machine Learning aims at constructing functions to predict the behaviour of new data from the behaviour of training data.

These functions are called **predictors**, and they can be a **deterministic function** or a **probabilistic model**.

## Model as a function

We must now determine a function $f: \mathbb{R}^D \rightarrow \mathbb{R}$, i.e. the **best predictor** basing on a measure of quality.

This is called **empirical risk minimization**, with the empirical risk defined as the loss.

Suppose we have $N$ examples $x_i$ and the corresponding labels $y_i$. We'll estimate a predictor $f(x_i, \theta)$ which approximates the labels as well as possible. The empirical risk is defined as

$R_{emp}=\frac{1}{N}\sum_{i=1}^N l(y_i-f(x_i,\theta))$, where the loss function is decided by the programmer. A good loss function might be the quadratic function, from which we get:

$\operatorname{min}_{\theta \in \mathbb{R}^D} \frac{1}{N} \sum_{i=1}^N (y_i-f(x_i,\theta))^2$

The empirical risk minimization can lead to **overfitting**, which means that the predictor perfectly fits the training data but can't generalize to new data. We can introduce a penalty term for overly complicated models, choosing a regularization parameter $\lambda$ so that the problem now becomes $\operatorname{min}_\theta \frac{1}{N}\|y-X\theta\|^2 + \lambda \|\theta\|^2$.

## Model as probability

### Maximum Likelihood Estimation

Now, we can consider a probability model and use the **Maximum Likelihood Estimation** procedure to define a function of the parameters to find a good model fitting the data. The Maximum Likelihood is in fact a function of the parameters of the probability function.  

Now, given a sample $x_1,\dots,x_n$ and a probability function $p(x|\theta)$, the Likelihood is defined as $L(\theta)=\prod_{i=1}^N p(x_i|\theta)$, and we'll consider the negative log likelihood. 

For example, if we supposed that the conditional distribution of the labels given the examples is a Gaussian with zero mean $N(0, \sigma^2)$, we get $p(y_i|x_i, \theta) = N(y_i|x_i^T \theta,\sigma^2)$, hence the negative log likelihood is $L(\theta)=-\log \prod_{i=1}^{N} p\left(y_{i} \mid x_{i}, \theta\right)=-\sum_{i=1}^{N} \log \left(p\left(y_{i} \mid x_{i}, \theta\right)\right)$.

### Maximum A Posteriori Estimation

We can use the **Maximum A Posteriori** estimate when we have **prior knowledge** about the distribution of the parameters $\theta$ through a term $p(\theta)$. We can therefore use the **Bayes' theorem** to infer about the a posteriori distribution: $p(\theta|x)=\frac{p(x|\theta)p(\theta)}{p((x))}$, which we want to maximize by minimizing its negative log likelihood.