# A Glimpse in Computational Learning Theory

#### Table of Contents

## Learning Problems as Computational Problems
Any learning algorithm _A_ computes a function _fA_ whose input is a finite sequence of **labelled data** and whose output is a **classifier**, so **learning problems** can be seen as computational problems.

![image](https://user-images.githubusercontent.com/31796254/122075503-6a11c680-cdfa-11eb-842b-34b5d82863fa.png)

Training data are **labelled** to let _fA_ learn what relationship exists between data and labels, while data that the classifier _C_ takes in input are no labelled, because _C_'s tas is to find the appropriate label for each of them.

_A_ can be seen as a TM if we assume that a real number can be encoded in a binary string and that _A_ can be a randomized algorithm (i.e. it can perform randomized steps).

## The algorithm _A\_BFP_

To make things easy let's take an example:
we want learn a rectangle (shape and position in the plane) having in input a set of point labelled as positive (belonging to the rectangle) or negative (not belonging to it).
We know that rectangle's edges are parallel to rhe axis.

We can define the algorithm **_A\_BFP_** as follows:
 1. Given the data _((x1, y1), p1), ..., ((xn, yn), pn)_, where _(xi, yi)_ represents the i-th point _pi_ tells if that point is a positive instance;
 2. Determine the smallest rectangle _R_ with edges parallel to the axes enclosing all the positivie instances;
 3. Return _R_

The output of **_A\_BFP_** can be really different from the target rectangle _T_, but this doesn't means that **_A\_BFP_** is incorrect.
Indeed we can define the **probability of error** in using _R_ as a replacement of _T_ (with distribution of the input data _D_) as:

![image](https://user-images.githubusercontent.com/31796254/122074860-de983580-cdf9-11eb-9593-2b8895b72bfd.png)

As the number of samples _D_ grows, the probability of error of _R_ approaches 0, even if _R_ does not necessarly approach to _T_.
