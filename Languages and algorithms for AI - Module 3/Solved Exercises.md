# Exercise Book

- [Exercises proposed and solved by professors](exercise_book.pdf)
  - [Solution to exercise 2.4 of the file](http://turingmachinesimulator.com/shared/vbwvbqjngd)

# Problem Examples from Virtuale 20/21 - WIP

Solutions provided are not _official_ solutions by professor, but are made by me. So be careful.

## Problem 1

Construct a deterministic TM of the kind you prefer, which decides the following language:

![L=\{w\in\{0,1\}^*\mid&space;w&space;$&space;does&space;not&space;contain&space;01&space;as&space;a&space;substring$\}](https://latex.codecogs.com/svg.latex?L%3D%5C%7Bw%5Cin%5C%7B0%2C1%5C%7D%5E*%5Cmid%20w%20%24%20does%20not%20contain%2001%20as%20a%20substring%24%5C%7D)

Study the complexity of TM you have defined.

### Solution

The alphabet Γ can be defined as {▷, 0, 1, □}, while the set of states Q is {qinit, q1, q2, q3, qhalt}. The transition function δ is specified as follows:

(qinit, ▷) → (q1, ▷, S)  
(q1, ▷) → (q1, ▷, R)  
(q1, 0) → (q2, 0, R)  
(q1, 1) → (q1, 1, R)  
(q2, 0) → (q2, 0, R)  
(q1, □) → (q3, □, L)  
(q2, □) → (q3, □, L)  
(q3, 0) → (q3, 0, L)  
(q3, 1) → (q3, 1, L)  
(q3, ▷) → (qhalt, ▷, S)  

If the TM reaches the ending state qhalt, then the string is accepted, otherwise, when the TM reaches a state where δ is not defined, the string is rejected.

Note that there are no transitions for the configuration (q2, 1), which corresponds to substring 01 detected.

When the TM read □ (i.e. the input string is finished), it goes to the state q3, in which it simply goes back to the starting position (the cell with ▷) and then it passes to the state qhalt, terminating and accepting the string. 

## Problem 2

You are required to prove that the following function _**f**_ is in **FP**. To do that, you can give a TMs or define some pseudocode.
The function is one that, given a list _L=L1,…,Ln_, returns its inverse, namely _Ln,Ln−1,…,L1_.

### Solution

First, we define a pseudocode that compute _**f**_:

```
def f (L=[L1,L2,...,Ln]):
  Reverse = new List[n]
  for i in range(n):
    Reverse[i] = L[n-1-i]
  return Reverse
```

Now we have to prove that this algorithm works in polynomial time. To do this we have to:

1. encode the input as a binary string. Our analysis of the time complexity will be done with respect of the length _l_ of such a string;
2. prove tha the number of instructions is bounded by a polynomial function in _l_;
3. prove that each instruction can be simulated by a TM in polynomial time
4. show that all the "intermediate" data and results use a space bounded by a polynomial function in _l_.

**Step 1**: In order to encode _L = [L1, L2, Ln]_ we need at first to encode its components _Li_. We can do it with one of the standards encoding of natural numbers in _{0,1}\*_.
Since using n bits allows us to encode _2^n - 1_ numbers, the encoding of _Li_ requires _log(Li) + 1_ bits.

Now we need to encode the whole list _L_. To do that we introduce a separator character # between elements of the list and then we encode 1 as 11, 0 as 00 and # as 01. So the total encoding will have length:

![l = \sum{i=1}^{n}{(2\log{L_i}+2)} + 2(n-1)](https://latex.codecogs.com/svg.latex?l%20%3D%20%5Csum_%7Bi%3D1%7D%5E%7Bn%7D%7B%282%5Clog%7BL_i%7D&plus;2%29%7D%20&plus;%202%28n-1%29)

**Step 2**: The only relevant instruction is ```Reverse[i] = L[n-1-i]``` which is executed _n_ times, which is polynomial. Other instructions (updating i and similar) have also a polynomial bound and can be trivially translated in a polynomial number of TM steps.

**Step 3**: Let's suppose to have a TM with two tapes. On the first we have the input (_L_), on the second one we write the output. Let's suppose that the head of the first tape it's in the first cell (the one before the input) and the head of the second tape it is in the first blank cell after the output written until this moment. To execute ```Reverse[i] = L[n-1-i]``` we need to moove the head of the input tape until the end of the string (□ read) which takes at most _l_ steps, then we have to go back until we read 01 (the binary encoding for the separator #) which takes around _l/n_ steps. Now we can copy what we read in the first tape on the second tape, replacing all the cells in the first tape with □, which takes again around _l/n_ steps. Then we have to move the first head on the first cell again: _l_ steps in the worst case.
This algorithm, which is far to be the most efficient, takes _2l + 2l/n_ steps, which is polynomial in l.

**Step 4**: We never use more than _l_ cells in each tape.

## Problem 3

We studied the problem **CLIQUE**.
You are required to classify the subset **THREECLIQUE** of **CLIQUE** consisting of all the pairs **(_G_,3)**.
To which class does **THREECLIQUE** belong? 

### Solution

**THREECLIQUE** is a way simpler problem than **CLIQUE**. In fact we can solve it with the algorithm described by this simple pseudocode:

```
def threeclique(V, E):
  for u in V:
    for v in V - {u}:
      for w in V - {u, v}:
        if (u,v), (v,w) and (u,w) belongs to E:
          return true
  return false
```

Checking if an edge belongs to the set of edges of the graph can be done by simpling comparing it with alle the m edges of the graph, which can be done in polynomial time.
This operation is inside a triple nested ```for```, so it will be done a very big number of times, but still polynomial. SO the problem belongs to the **P** class.


# Question Examples from Virtuale 20/21

Let _f, g_ be the functions defined as ![f(n)=2^nn^2](https://latex.codecogs.com/svg.latex?f%28n%29%3D2%5Enn%5E2) and ![g(n) = n2^n](https://latex.codecogs.com/svg.latex?g%28n%29%20%3D%20n2%5En).  
Select one or more.
- [x] ![f\in\Omega(g)](https://latex.codecogs.com/svg.latex?f%5Cin%5COmega%28g%29)
- [ ] ![f\in O(g)](https://latex.codecogs.com/svg.latex?f%5Cin%20O%28g%29)
- [ ] ![f\in\Theta(g)](https://latex.codecogs.com/svg.latex?f%5Cin%5CTheta%20%28g%29)

- - - 
In Turing Machines:  
Select one or more.
 - [ ] The presence of many tapes can make the class **P** different
 - [x] What can be computed in exponential time is different from what can be computed in polynomial time
 - [x] The presence of many tapes can make the class **DTIME(_n_)** different
 - [ ] The class **EXP** can be equal to **P**

- - -
The problem **3SAT** is:  
Select one or more.
 - [x] Such that **INDSET** can be reduced to it
 - [x] **NP**-hard
 - [x] In the class **EXP**
 - [ ] Computable in polynomial time

- - -
Suppose a language **_L_** is both in **NP** and in **EXP**. Then  
Select one or more.
 - [ ] **EXP** and **NP** are necessarly equal.
 - [x] **_L_** can even be **NP**-complete.
 - [x] **NP** and **EXP** are maybe different.
 - [ ] **_L_** cannot be in **P**.

- - -
The notion of PAC-learnable concept class:  
Select one or more.
 - [x] Needs to hold for every distribution D on the instance class.
 - [x] Does not make any reference to the time complexity of the learning algorithm.
 - [ ] Requires the output concept to have probability of error ε, in all cases.
 - [ ] Cannot be reached when the underlying concept class is the one conjunctions of literals.

# Problems from Exam 06/26/2020

## Problem 1

Give a TM to decide _**L**_= set of strings for which if 01 is present, then is followed by all 0s.

### Solution

The alphabet Γ can be defined as {▷, 0, 1, □}, while the set of states Q is {qinit, q1, q2, qhalt}. The transition function δ is specifies as follows:

(qinit, ▷) → (q1, ▷, S)  
(q1, ▷) → (q1, ▷, R)  
(q1, 0) → (q2, 0, R)  
(q1, 1) → (q1, 1, R)  
(q2, 0) → (q2, 0, R)  
(q2, 1) → (q3, 1, R)  
(q3, 0) → (q3, 0, R)  
(q1, □) → (q4, □, L)  
(q2, □) → (q4, □, L)  
(q3, □) → (q4, □, L)  
(q4, 0) → (q4, 0, L)  
(q4, 1) → (q4, 1, L)  
(q4, ▷) → (qhalt, ▷, S)  

If the TM reaches the ending state qhalt, then the string is accepted, otherwise, when the TM reaches a state where δ is not defined, the string is rejected.

States explanantion:
  - **qinit**: it is just the initial state. The TM immediately passes to q1.
  - **q1**: the TM read the string charachter by charachter. If it read 0, it passes to q2.
  - **q2**: as q1, but a 0 has been detected yet, so reading a 1 will mean that 01 is detected and the TM will pass to q3.
  - **q3**: 01 detected, so the TM only reads 0s, indeed there are no transitions for the configuration (q3, 1).
  - **q4**: This state is reached when the TM reads a blank charachter, meaning that the string is finished and has to be accepted. It just reset the head at the start of the tape, before passing to qhalt, which is the final state.

When the TM read □ (i.e. the input string is finished), it goes to the state q3, in which it simply goes back to the starting position (the cell with ▷) and then it passes to the state qhalt, terminating and accepting the string. 

## Problem 2

Prove that the problem is in **NP**: check if a number is the sum of powers of 3 by giving a TM or pseudocode.
(Asked to the professor, he said that 3^0 is not allowed as the problem would be trivial).

### Solution

We at first notice that a number can be expressed as a sum between power of 3 (3 to thw ower of 0 excluded) iff it is divisible by 3.
Since we have to show that the problem is in **NP** we can describe a non-deterministic algorithm. So our algorithm can just pick a random number non-determinstically, multiply it by 3 and check if it is equal to the input number n.
The multiplication and the comparison between two numbers can be of course executed in polynomial time.
The pseudocode is the following:
```
def f(n):
  assign non-determinstically a number greater than 0 to k
  k = k * 3
  return k == n
```

## Problem 3

PP is the set of theorems expressed in the Principia Matematica, published by Bertrand Russel in 1909-13. Do they fall in a complexity class? Motivate

### Solution
This formulation of the problem (which is indeed a reformulation by a student) is actually a bit tricky and it would require to know all the algorithm of the book to establish to which subset of **NEXP** the algorithms belong (**NEXP** is a set enough big to make us quite sure that all the algorithms in that book belong to it).

However, I've found similar exercises with the original formulations of the professor, which are more clear. The problem asks to establish which is the complexity of establishing if an algorithm (which is given in input with some binary codification) belongs to PP.

This can be achieved comparing (in linear time) it with all the algorithms of the book (which are a constants number), so of course is a **P** problem.







