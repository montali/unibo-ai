# Between feasible and unfeasible

This is another key concept: we want to look at what happens between the feasible and unfeasible. We labeled them by their presence inside P (the good ones), or their absence (the bad ones). These are non-trivial classes, but what happens inbetween?

P is the embodyment of tractable (i.e. feasible) problems, while EXP (containing the whole P) contains problem that cannot be solved in polynomial time too.
So, what we're looking for are classes of an hypothetical A:
<p align="center"><img src="svgs/15833fb1e8168ab70005717e60b6482c.svg?invert_in_darkmode" align=middle width=110.68422089999999pt height=13.513684799999998pt/></p>
Is there anything interesting in this *grey land* of problems which are known not to be in P, but trivially in EXP? We'll discover that there's a lot to be done, and a lot of interesting properties to be discovered. Many of the problems we see in AI are in this class. 

## The NP Class

The first concept is the **dicotomy between creating and verifying**.
Very often, the language we'd like to classify can be written as follows:
<p align="center"><img src="svgs/4e7c4bca127939c72aa1398a2ec77374.svg?invert_in_darkmode" align=middle width=333.2067189pt height=29.58934275pt/></p>

The language <img src="svgs/47291815667dfe5994c54805102e144b.svg?invert_in_darkmode" align=middle width=11.337943649999989pt height=22.465723500000017pt/> is the language of all strings for which there exists a certificate y such that <img src="svgs/7392a8cd69b275fa1798ef94c839d2e0.svg?invert_in_darkmode" align=middle width=38.135511149999985pt height=24.65753399999998pt/>, seen as a pair, lies in a set of pairs of <img src="svgs/53d147e7f3fe6e47ee05b88b166bd3f6.svg?invert_in_darkmode" align=middle width=12.32879834999999pt height=22.465723500000017pt/>.
If we want to conclude that <img src="svgs/332cc365a4987aacce0ead01b8bdcc0b.svg?invert_in_darkmode" align=middle width=9.39498779999999pt height=14.15524440000002pt/> is in <img src="svgs/47291815667dfe5994c54805102e144b.svg?invert_in_darkmode" align=middle width=11.337943649999989pt height=22.465723500000017pt/>, we characterize it by another language A (which is a set of pairs of strings), using a certificate <img src="svgs/deceeaf6940a8c7a5a02373728002b0f.svg?invert_in_darkmode" align=middle width=8.649225749999989pt height=14.15524440000002pt/> (which exists).
The other crucial part is <img src="svgs/2ec6e630f199f589a2402fdf3e0289d5.svg?invert_in_darkmode" align=middle width=8.270567249999992pt height=14.15524440000002pt/>, which is a polynomial function.
The certificate which certifies the presence of <img src="svgs/332cc365a4987aacce0ead01b8bdcc0b.svg?invert_in_darkmode" align=middle width=9.39498779999999pt height=14.15524440000002pt/> in <img src="svgs/47291815667dfe5994c54805102e144b.svg?invert_in_darkmode" align=middle width=11.337943649999989pt height=22.465723500000017pt/> must be sufficiently.
Think about <img src="svgs/53d147e7f3fe6e47ee05b88b166bd3f6.svg?invert_in_darkmode" align=middle width=12.32879834999999pt height=22.465723500000017pt/> as a **test** about the fact that <img src="svgs/deceeaf6940a8c7a5a02373728002b0f.svg?invert_in_darkmode" align=middle width=8.649225749999989pt height=14.15524440000002pt/> is an appropriate certificate for <img src="svgs/332cc365a4987aacce0ead01b8bdcc0b.svg?invert_in_darkmode" align=middle width=9.39498779999999pt height=14.15524440000002pt/>. Sometimes this language <img src="svgs/53d147e7f3fe6e47ee05b88b166bd3f6.svg?invert_in_darkmode" align=middle width=12.32879834999999pt height=22.465723500000017pt/> is itself decidable in polynomial time.
Does this imply that <img src="svgs/47291815667dfe5994c54805102e144b.svg?invert_in_darkmode" align=middle width=11.337943649999989pt height=22.465723500000017pt/> itself is decidable in polynomial time?

The point is that one way of checking whether <img src="svgs/332cc365a4987aacce0ead01b8bdcc0b.svg?invert_in_darkmode" align=middle width=9.39498779999999pt height=14.15524440000002pt/> is in <img src="svgs/47291815667dfe5994c54805102e144b.svg?invert_in_darkmode" align=middle width=11.337943649999989pt height=22.465723500000017pt/> is looking for certificates. If we find a certificate the problem is solved!
If we cannot find a certificate which satisfies the test, and if we check **all certificates** we can say that <img src="svgs/332cc365a4987aacce0ead01b8bdcc0b.svg?invert_in_darkmode" align=middle width=9.39498779999999pt height=14.15524440000002pt/> is not in <img src="svgs/47291815667dfe5994c54805102e144b.svg?invert_in_darkmode" align=middle width=11.337943649999989pt height=22.465723500000017pt/>.
The point is there's too many certificates: the strings of length <img src="svgs/55a049b8f161ae7cfeb0197d75aff967.svg?invert_in_darkmode" align=middle width=9.86687624999999pt height=14.15524440000002pt/> are exponentially many. Checking all of them is too expensive. Not necessarily, given <img src="svgs/332cc365a4987aacce0ead01b8bdcc0b.svg?invert_in_darkmode" align=middle width=9.39498779999999pt height=14.15524440000002pt/>, we can check all possible <img src="svgs/deceeaf6940a8c7a5a02373728002b0f.svg?invert_in_darkmode" align=middle width=8.649225749999989pt height=14.15524440000002pt/> (smaller than <img src="svgs/c9ea84eb1460d2895e0cf5125bd7f7b5.svg?invert_in_darkmode" align=middle width=30.450987599999987pt height=24.65753399999998pt/>). This is not the only way though. We could follow alternative rules.

There is a dicotomy between crafting a solution for the problem, and checking a candidate solution to be an actual solution. Finding <img src="svgs/deceeaf6940a8c7a5a02373728002b0f.svg?invert_in_darkmode" align=middle width=8.649225749999989pt height=14.15524440000002pt/> could be much more difficult than checking if <img src="svgs/deceeaf6940a8c7a5a02373728002b0f.svg?invert_in_darkmode" align=middle width=8.649225749999989pt height=14.15524440000002pt/> is a solution. Looking for the appropriate certificates cannot be done in polynomial time. Checking is easier. Crafting requires some sort of *creativity*, which algorithms generally do not have. 

### Modern definition of NP

And that's it. The complexity class **NP** can be defined as the set of all languages L for which there exists a polynomial <img src="svgs/2ec6e630f199f589a2402fdf3e0289d5.svg?invert_in_darkmode" align=middle width=8.270567249999992pt height=14.15524440000002pt/> and a polynomial time TM <img src="svgs/fb97d38bcc19230b0acd442e17db879c.svg?invert_in_darkmode" align=middle width=17.73973739999999pt height=22.465723500000017pt/> such that
<p align="center"><img src="svgs/56ff8c1d882de45f8a37ccc92b855c9b.svg?invert_in_darkmode" align=middle width=366.306105pt height=29.58934275pt/></p>

We want M to return 1 when fed with the pair <img src="svgs/7392a8cd69b275fa1798ef94c839d2e0.svg?invert_in_darkmode" align=middle width=38.135511149999985pt height=24.65753399999998pt/>. NP is the class of languages for which **checking certificates** can be checked in polynomial time. This doesn't mean that we can find a solution in polynomial time, rather check certificates. 

So, M can be said **verifier** for <img src="svgs/47291815667dfe5994c54805102e144b.svg?invert_in_darkmode" align=middle width=11.337943649999989pt height=22.465723500000017pt/>. The class NP does not have a natural **counterpart**. It is a class of languages, and it's important for the definition that <img src="svgs/47291815667dfe5994c54805102e144b.svg?invert_in_darkmode" align=middle width=11.337943649999989pt height=22.465723500000017pt/> is a language. Otherwise, it's not so easy to think about it as a generalization.

A **theorem** on which we will spend some time is the following: NP is one example of a class which is between P and EXP:
<p align="center"><img src="svgs/5f43d76d96a6b371f577cae4d3ca9561.svg?invert_in_darkmode" align=middle width=304.1547597pt height=14.611878599999999pt/></p>

Examples of **NP** languages include *Maximum Independent Set*, *Subset Sum*, *Composite Numbers* (actually in **P**), *Factoring*, *Decisional Linear Programming* (actually in **P**), *Decisional 0/1 Linear Programming*.

### Original definition of NP

The class **NP** can also be defined using a variant of Turing machines, called the NonDeterministic Turing Machines or NDTM (this is the original definition and is the reason for the **N** in **NP**: non-deterministic).
A NDTM has and additional state <img src="svgs/c127078f8a1d831780e5ff20527ebc97.svg?invert_in_darkmode" align=middle width=44.197187099999994pt height=14.15524440000002pt/> and two transition functions <img src="svgs/154a8763eb0cadfcb320a4fe139b6ec2.svg?invert_in_darkmode" align=middle width=13.858486949999989pt height=22.831056599999986pt/> and <img src="svgs/05c0545df5a118015e87a57e968327bf.svg?invert_in_darkmode" align=middle width=13.858486949999989pt height=22.831056599999986pt/> instead of one and at each step one of them is chosen non-deterministically (currently only theoretical, not implementable).

We say that a NDTM <img src="svgs/b5eaea000e06d5cf2e882f8fdbc71e36.svg?invert_in_darkmode" align=middle width=19.740822749999992pt height=22.465723500000017pt/> accepts an input <img src="svgs/d3017d4becb3ab5e77fa9fe6a279ed7c.svg?invert_in_darkmode" align=middle width=76.40404199999999pt height=24.65753399999998pt/> iff a possible evolution of <img src="svgs/b5eaea000e06d5cf2e882f8fdbc71e36.svg?invert_in_darkmode" align=middle width=19.740822749999992pt height=22.465723500000017pt/> with input <img src="svgs/332cc365a4987aacce0ead01b8bdcc0b.svg?invert_in_darkmode" align=middle width=9.39498779999999pt height=14.15524440000002pt/> which reaches <img src="svgs/c127078f8a1d831780e5ff20527ebc97.svg?invert_in_darkmode" align=middle width=44.197187099999994pt height=14.15524440000002pt/>.

<img src="svgs/b5eaea000e06d5cf2e882f8fdbc71e36.svg?invert_in_darkmode" align=middle width=19.740822749999992pt height=22.465723500000017pt/> runs in time <img src="svgs/17726fa8b5401d1429efa4fd9faad060.svg?invert_in_darkmode" align=middle width=74.90269049999998pt height=22.648391699999998pt/> iff for every <img src="svgs/d3017d4becb3ab5e77fa9fe6a279ed7c.svg?invert_in_darkmode" align=middle width=76.40404199999999pt height=24.65753399999998pt/> and for every possible nondeterministic evolution <img src="svgs/b5eaea000e06d5cf2e882f8fdbc71e36.svg?invert_in_darkmode" align=middle width=19.740822749999992pt height=22.465723500000017pt/> reaches <img src="svgs/d8746fd75da8832672e018f29e6e103e.svg?invert_in_darkmode" align=middle width=31.354299899999987pt height=14.15524440000002pt/> or <img src="svgs/c127078f8a1d831780e5ff20527ebc97.svg?invert_in_darkmode" align=middle width=44.197187099999994pt height=14.15524440000002pt/> within <img src="svgs/12bb47b7ba3dd8f50cd2a9b0bb99f2ec.svg?invert_in_darkmode" align=middle width=65.84095154999999pt height=24.65753399999998pt/> steps with <img src="svgs/f4783f38548a88936edb864704d68288.svg?invert_in_darkmode" align=middle width=41.81686904999999pt height=21.18721440000001pt/>.

For every <img src="svgs/17726fa8b5401d1429efa4fd9faad060.svg?invert_in_darkmode" align=middle width=74.90269049999998pt height=22.648391699999998pt/> and <img src="svgs/1193f839031c92d4e8dfe44b4c99e114.svg?invert_in_darkmode" align=middle width=80.1734901pt height=24.65753399999998pt/> we say that <img src="svgs/c8d59884ac5b074adb1e59006cd760fd.svg?invert_in_darkmode" align=middle width=158.73286769999999pt height=24.65753399999998pt/> iff there is a NDTM <img src="svgs/b5eaea000e06d5cf2e882f8fdbc71e36.svg?invert_in_darkmode" align=middle width=19.740822749999992pt height=22.465723500000017pt/> working in time <img src="svgs/2f118ee06d05f3c2d98361d9c30e38ce.svg?invert_in_darkmode" align=middle width=11.889314249999991pt height=22.465723500000017pt/> such that <img src="svgs/116611362f6f419054db1dd0f622292e.svg?invert_in_darkmode" align=middle width=72.05808389999999pt height=24.65753399999998pt/> iff <img src="svgs/9e8d0c2724191a046bb7b49e0d651686.svg?invert_in_darkmode" align=middle width=40.82406899999999pt height=22.465723500000017pt/>.

<p align="center"><img src="svgs/a66c344b35e850f296d19c6c14ef4985.svg?invert_in_darkmode" align=middle width=193.78437044999998pt height=16.438356pt/></p>

## NP-hardness and NP-completeness

The language <img src="svgs/47291815667dfe5994c54805102e144b.svg?invert_in_darkmode" align=middle width=11.337943649999989pt height=22.465723500000017pt/> is said to be **polynomial-time reducible** to another language <img src="svgs/8209c0f8b3c5233ea2e20dae55588c43.svg?invert_in_darkmode" align=middle width=14.041179899999989pt height=22.465723500000017pt/> (**<img src="svgs/2d69fa47366657f0914364490b5e4d99.svg?invert_in_darkmode" align=middle width=54.89512874999999pt height=22.465723500000017pt/>**) iff there is a poly-time computable function <img src="svgs/77ea3409d3c031126c48f9b526391c43.svg?invert_in_darkmode" align=middle width=143.74415879999998pt height=24.65753399999998pt/> such that <img src="svgs/23609a2799541f2ef2d51f25fb12d4cb.svg?invert_in_darkmode" align=middle width=155.35576319999998pt height=24.65753399999998pt/>.
<img src="svgs/ec0291fa3db83f00fa7927122924d935.svg?invert_in_darkmode" align=middle width=19.56191159999999pt height=20.908638300000003pt/> is a pre-order (reflexive and transitive).

For classes **P** or above it and <img src="svgs/2d69fa47366657f0914364490b5e4d99.svg?invert_in_darkmode" align=middle width=54.89512874999999pt height=22.465723500000017pt/>, then <img src="svgs/8209c0f8b3c5233ea2e20dae55588c43.svg?invert_in_darkmode" align=middle width=14.041179899999989pt height=22.465723500000017pt/> is at least as difficult as <img src="svgs/47291815667dfe5994c54805102e144b.svg?invert_in_darkmode" align=middle width=11.337943649999989pt height=22.465723500000017pt/>. 

A language <img src="svgs/3a965f05dff06a55fe4ba6bdaf0d1aae.svg?invert_in_darkmode" align=middle width=82.87670324999998pt height=24.65753399999998pt/> is said to be:
- **NP-hard** if <img src="svgs/824e228fc68a0deecccc60222ebd7153.svg?invert_in_darkmode" align=middle width=130.47929234999998pt height=22.831056599999986pt/>. This means that it is at least as hard as any language in **NP**. Simplifying it means that it cannot be too easy (it could be un-computable, **NP**-complete or outside **NP**).
- **NP-complete** if <img src="svgs/18e61ca7af57709a425157bb703d8c88.svg?invert_in_darkmode" align=middle width=61.84905539999999pt height=22.55708729999998pt/> is **NP**-hard. Note that **NP**-hardness does not imply **NP**-completeness as a **NP**-hard language may be un-computable or outside **NP**.

Note that:
- <img src="svgs/a85b3a23cd1b786139824ba981dbf605.svg?invert_in_darkmode" align=middle width=44.35138949999999pt height=22.55708729999998pt/> is **NP**-hard <img src="svgs/68bf0daed9e28ab0d5a9cba1d27c3863.svg?invert_in_darkmode" align=middle width=83.56119915pt height=22.55708729999998pt/>.
- <img src="svgs/a85b3a23cd1b786139824ba981dbf605.svg?invert_in_darkmode" align=middle width=44.35138949999999pt height=22.55708729999998pt/> is **NP**-hard <img src="svgs/b76492a2d67002f71be342b015b34d03.svg?invert_in_darkmode" align=middle width=101.82604079999999pt height=22.55708729999998pt/>.

No such language has been found and <img src="svgs/03c6d1a0e85a425a91b17393616670d6.svg?invert_in_darkmode" align=middle width=62.556697499999984pt height=22.55708729999998pt/> has not yet been proven (famous **P** vs **NP** problem).

![Venn diagram of P and NP](res/p-np.png)

Proving that a problem is **NP**-complete proves that the problem is not so hard (being in NP), but not so easy either (unless P = NP).

If we want to prove <img src="svgs/47291815667dfe5994c54805102e144b.svg?invert_in_darkmode" align=middle width=11.337943649999989pt height=22.465723500000017pt/> to be **NP**-complete we have to prove two statements:
- <img src="svgs/47291815667dfe5994c54805102e144b.svg?invert_in_darkmode" align=middle width=11.337943649999989pt height=22.465723500000017pt/> is **NP** (see above)
- <img src="svgs/f5e97a4b79e688b564ee9a52624f72d3.svg?invert_in_darkmode" align=middle width=54.895107299999985pt height=22.465723500000017pt/> for any other language <img src="svgs/18e61ca7af57709a425157bb703d8c88.svg?invert_in_darkmode" align=middle width=61.84905539999999pt height=22.55708729999998pt/>. Since <img src="svgs/ec0291fa3db83f00fa7927122924d935.svg?invert_in_darkmode" align=middle width=19.56191159999999pt height=20.908638300000003pt/>  is transitive, we can simply prove that, <img src="svgs/ec2e298ee13fa363ab9ebff85920b637.svg?invert_in_darkmode" align=middle width=55.03203254999999pt height=22.465723500000017pt/> where <img src="svgs/8cc0a6e490c5b777ac8dd9629bb06051.svg?invert_in_darkmode" align=middle width=14.17810184999999pt height=22.465723500000017pt/> is a language already known as **NP**-complete.

### The Cook-Levin Theorem

A **kCNF** (**k-Conjunctive Normal Form**) is a propositional formula which is a conjunction of disjunctions ("clauses") which contain at most <img src="svgs/091a3af356c1abf7e80434e9d0049f52.svg?invert_in_darkmode" align=middle width=41.03867954999999pt height=22.831056599999986pt/> literals.
  
The following languages are **NP**-complete:
- <img src="svgs/7a0fdd099bac2c3c4a93595fc894e257.svg?invert_in_darkmode" align=middle width=265.10874885pt height=24.65753399999998pt/>
- <img src="svgs/c6deb0fd567b2bbae3787e0978d4c40d.svg?invert_in_darkmode" align=middle width=281.54716095pt height=24.65753399999998pt/>

This is a relevant proof of existence of **NP**-complete problems.

#
[Previous section](https://github.com/montali/unibo-ai/blob/master/Languages%20and%20algorithms%20for%20AI%20-%20Module%203/3%20-%20Polynomial%20time%20computable%20problems.md) · [Next section](https://github.com/montali/unibo-ai/blob/master/Languages%20and%20algorithms%20for%20AI%20-%20Module%203/5%20-%20ML%20and%20theory%20of%20computation.md)