# LAAI - Module 3

AI and ML are everywhere. Every problem could possibly be solved by AI! We may want to find the algorithms that solve a problem in a **better way**, i.e. efficiently and with good accuracy. If we know that a task is intrinsically hard, we could direct towards methodologies which are made for that, avoid spending our time on stupid solutions, inform the stakeholders...

Suppose we wanted to write a python program multiplying two integers, without using the python multiplication operator: our numbers will be considered as *lists of digits*, having length `n`, each element of which is a char between 0 and 9. There's multiple methods for solving this.

## Modern Theory of Computation (ToC)

Provides a precise definition of the computable and many results about it.
Born in the 20th century, it has evolved into a fully fledged scientific field.
The theoretical notion of computation existed before (and keeps influencing) modern electronic computers. 

**Computability theory**: Computability = is a certain task computable (i.e. solvable by a computer)?

**Computational complexity theory**: Efficiency = is a certain task solvable in a reasonable amount of time and space (i.e. working memory)?
If not, the task may be theoretically computable but pratically uncomputable because of the time or space it requires. This will be the subject of this course.

## Modelling computation

**Computational task**: A problem that needs to be solved.

**Computational process**: A sequence of actions capable of solving a computational task. In the Theory of Computation is taken to be an algorithm (a finite description of a series of elementary computation steps, where the way the next step is determined must be deterministic).

A computational task can have 0..N solving processes. A task with no solving processes is an unsolved task. Distinct processes can solve the same task in different ways and some of them can be unacceptable (i.e. requiring too much time or space).

For example, two <img src="svgs/55a049b8f161ae7cfeb0197d75aff967.svg?invert_in_darkmode" align=middle width=9.86687624999999pt height=14.15524440000002pt/>-digits numbers <img src="svgs/44bc9d542a92714cac84e01cbbb7fd61.svg?invert_in_darkmode" align=middle width=8.68915409999999pt height=14.15524440000002pt/> and <img src="svgs/4bdc8d9bcfb35e1c9bfb51fc69687dfc.svg?invert_in_darkmode" align=middle width=7.054796099999991pt height=22.831056599999986pt/> can be multiplied (<img src="svgs/aa9ac28882b306b4e881fbaacbafc4b7.svg?invert_in_darkmode" align=middle width=31.268917349999988pt height=22.831056599999986pt/>) in (at least) two ways.
The first method ("repeated addition") by summing <img src="svgs/44bc9d542a92714cac84e01cbbb7fd61.svg?invert_in_darkmode" align=middle width=8.68915409999999pt height=14.15524440000002pt/> <img src="svgs/4bdc8d9bcfb35e1c9bfb51fc69687dfc.svg?invert_in_darkmode" align=middle width=7.054796099999991pt height=22.831056599999986pt/> times (<img src="svgs/3049d386c04588a0fd49fc94ff49362d.svg?invert_in_darkmode" align=middle width=100.03970789999998pt height=19.1781018pt/>), which for each sum requires <img src="svgs/55a049b8f161ae7cfeb0197d75aff967.svg?invert_in_darkmode" align=middle width=9.86687624999999pt height=14.15524440000002pt/> steps, hence the total cost is proportional to <img src="svgs/458e8b6dad5a69d223deeaf241ce1f43.svg?invert_in_darkmode" align=middle width=32.44663949999999pt height=22.831056599999986pt/> steps.
The second method ("grid method") is the classic method we learnt at elementary school and has a cost proportional to <img src="svgs/f4afc77016e004d110eee6a7001a7a87.svg?invert_in_darkmode" align=middle width=35.25871964999999pt height=15.296829900000011pt/> steps.
Notice that <img src="svgs/4bdc8d9bcfb35e1c9bfb51fc69687dfc.svg?invert_in_darkmode" align=middle width=7.054796099999991pt height=22.831056599999986pt/> can be exponential in <img src="svgs/55a049b8f161ae7cfeb0197d75aff967.svg?invert_in_darkmode" align=middle width=9.86687624999999pt height=14.15524440000002pt/> (<img src="svgs/ac76bed504f78662b400fd78ad426795.svg?invert_in_darkmode" align=middle width=105.50023274999998pt height=24.65753399999998pt/>).
The repeated addition is potentially way slower than the grid method because there is a huge (exponential) difference between <img src="svgs/f4afc77016e004d110eee6a7001a7a87.svg?invert_in_darkmode" align=middle width=35.25871964999999pt height=15.296829900000011pt/> and <img src="svgs/c77bd97048dbe2638b94e266d9e64d1c.svg?invert_in_darkmode" align=middle width=91.87403444999998pt height=24.65753399999998pt/>. 
For example, supposing <img src="svgs/60956056c8ac4a0bb767ef199f98b76b.svg?invert_in_darkmode" align=middle width=56.442135749999984pt height=21.18721440000001pt/> and <img src="svgs/a938957de7ebf1ed5afe74305dc62c33.svg?invert_in_darkmode" align=middle width=102.41999955pt height=26.76175259999998pt/> (the worst case scenario) and that each step requires a millisecond, the grid method would require a second while the repeated addition 10^80 years.

Computational processes can be classified as **P** (Polynomial time, efficient), **NP** (Nondeterministic Polynomial time), **NP-complete**, **NP-hard** (pratically uncomputable).

Proving tasks not solvable by processes beyond a certain level of efficiency is very rarely possible.
We can, however, interrelate different tasks to compare their complexity.

## Mathematical preliminaries

Mathematical concepts needed for the course:

- Sets (i.e. <img src="svgs/cbfb1b2a33b28eab8a3e59464768e810.svg?invert_in_darkmode" align=middle width=14.908688849999992pt height=22.465723500000017pt/>)
  - cardinality (i.e. <img src="svgs/50471a7853b2ca91c0e1f4c5107c5b5e.svg?invert_in_darkmode" align=middle width=24.041115449999985pt height=24.65753399999998pt/>)
  - finiteness
- Naturals and integers
- Conditions holding  for a sufficiently large variable (i.e. <img src="svgs/f23b2b8e0bd22c498e6cc9b7055ccaa9.svg?invert_in_darkmode" align=middle width=41.83019279999999pt height=22.648391699999998pt/>, <img src="svgs/e720ef2e3dc10278f2cc0341a8635074.svg?invert_in_darkmode" align=middle width=35.489081099999986pt height=24.65753399999998pt/> holds if <img src="svgs/aa5de451edffae97a3e3d72e0a7ec57a.svg?invert_in_darkmode" align=middle width=56.09573309999998pt height=22.831056599999986pt/> such that <img src="svgs/e720ef2e3dc10278f2cc0341a8635074.svg?invert_in_darkmode" align=middle width=35.489081099999986pt height=24.65753399999998pt/> holds <img src="svgs/7e73289f5bec62c25edaafcb79810100.svg?invert_in_darkmode" align=middle width=55.916945699999985pt height=22.831056599999986pt/>)
- Floor (i.e. <img src="svgs/b8d683e1dea27b14d549c3389b65dbb6.svg?invert_in_darkmode" align=middle width=24.00689774999999pt height=24.65753399999998pt/>)
- Ceil (i.e. <img src="svgs/f4037aedb6bf0d1b1b9e417d27abee42.svg?invert_in_darkmode" align=middle width=24.00689774999999pt height=24.65753399999998pt/>)
- <img src="svgs/d1e718b4aa9726f0f13e86387d942b7f.svg?invert_in_darkmode" align=middle width=186.67778414999998pt height=24.65753399999998pt/>
- We will use 2 as canonical base for logarithms (i.e. <img src="svgs/1c0c99ea7db547da9f713133df4e10cc.svg?invert_in_darkmode" align=middle width=116.11875329999998pt height=24.65753399999998pt/>)
- String <img src="svgs/13595c3035ea1b1b4d90f5571df51b7c.svg?invert_in_darkmode" align=middle width=19.15340624999999pt height=22.465723500000017pt/> over the alphabet <img src="svgs/e257acd1ccbe7fcb654708f1a866bfe9.svg?invert_in_darkmode" align=middle width=11.027402099999989pt height=22.465723500000017pt/> with length <img src="svgs/55a049b8f161ae7cfeb0197d75aff967.svg?invert_in_darkmode" align=middle width=9.86687624999999pt height=14.15524440000002pt/>
  - Empty string (<img src="svgs/0f291e5628e5da63790748b4acc9709f.svg?invert_in_darkmode" align=middle width=47.163063749999985pt height=26.76175259999998pt/>)
  - Set of all string over <img src="svgs/e257acd1ccbe7fcb654708f1a866bfe9.svg?invert_in_darkmode" align=middle width=11.027402099999989pt height=22.465723500000017pt/> (<img src="svgs/33c9972f4ece02756df855c07b50ecc0.svg?invert_in_darkmode" align=middle width=101.68568684999998pt height=26.438629799999987pt/>) 
  - Concatenation <img src="svgs/65f1b48fb5f326a680b0f7393b9d8b6d.svg?invert_in_darkmode" align=middle width=18.044213549999988pt height=14.15524440000002pt/> of <img src="svgs/332cc365a4987aacce0ead01b8bdcc0b.svg?invert_in_darkmode" align=middle width=9.39498779999999pt height=14.15524440000002pt/> and <img src="svgs/deceeaf6940a8c7a5a02373728002b0f.svg?invert_in_darkmode" align=middle width=8.649225749999989pt height=14.15524440000002pt/>
  - Concatenation <img src="svgs/ca258fdb5aa2e16d091da2d680a2bc60.svg?invert_in_darkmode" align=middle width=16.66101689999999pt height=27.91243950000002pt/> of <img src="svgs/332cc365a4987aacce0ead01b8bdcc0b.svg?invert_in_darkmode" align=middle width=9.39498779999999pt height=14.15524440000002pt/> with itself <img src="svgs/63bb9849783d01d91403bc9a5fea12a2.svg?invert_in_darkmode" align=middle width=9.075367949999992pt height=22.831056599999986pt/> times
  - Length <img src="svgs/cd8f6d1a08b2e1ed11a4305d3f6caab3.svg?invert_in_darkmode" align=middle width=18.52743584999999pt height=24.65753399999998pt/> of a string <img src="svgs/332cc365a4987aacce0ead01b8bdcc0b.svg?invert_in_darkmode" align=middle width=9.39498779999999pt height=14.15524440000002pt/>

#
[Next section](1%20-%20Sets%20and%20numbers.md)
