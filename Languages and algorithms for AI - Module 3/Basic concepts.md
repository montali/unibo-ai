This is a recap file I will update with the most basic concepts required for the course and for the exam when they come to mind.

This not pretend to be a full recap, but could still be useful as a first approach to the subject or to quickly check main concepts befor the exam.

# P, NP, EXP, NEXP

**P**, **NP**, **EXP** and **NEXP** are complessity classes used to classify decision problems.
You can imagine them as sets of of decision problems for which the problem instances can be prooved to have a "yes" answer in a bounded time on a particular kind of Touring Machine:
 - **P**: polynomial time on a deterministic TM
 - **NP** polynomial time on a **non**-determinstic TM
 - **EXP**: exponential time on a determinstic TM
 - **NEXP**: exponetial time on a **non**-deterministic TM

These sets are linked together by the following realtionship:

**P ⊆ NP ⊆ EXP ⊆ NEXP**

**P = NP ?** is one of the most important open question in math and computer science.

Also we know that **P ≠ EXP** (**P ⊂ EXP**), this means that if **P = NP**, then **NP ≠ EXP** and viceversa.

# NP-Hard and NP-complete

A problem is **NP-hard** (i.e. it belongs to the **NP-hard** class) iff it is _at least_ difficoult as the hardest problems in **NP**, and maybe more (this is an informal definition, just to understand the concept). Note that a problem can be **NP-hard** and still not be in **NP**.

Indeed we have another definition for problems that are both **NP** and **NP-hard**: **NP-complete**.
This scheme from Wikipedia clarify the situation in both the cases **P = NP** and **P ≠ NP**, that we remind is an open question. 

![scheme](https://upload.wikimedia.org/wikipedia/commons/thumb/a/a0/P_np_np-complete_np-hard.svg/800px-P_np_np-complete_np-hard.svg.png)
