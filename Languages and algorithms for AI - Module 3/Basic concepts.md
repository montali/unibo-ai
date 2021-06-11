This is a recap file I will update with the most basic concepts required for the course and for the exam when they come to mind.

This not pretend to be a full recap, but could still be useful as a first approach to the subject or to quickly check main concepts before the exam.

# Touring Machines
Assuming that the reader already knows what a TM is and how it works, let's talk about how professor Dal Lago decided to formalize them in his course.
Indeed it is possible to give different, although still very similar, definitions and implementations of a TM (and it is possible to demonstrate that we can pass from one definition to another one with just a polynomial bound overhead, so the theory you construct with a definition is valid also with all the other one) and the one Dal Lago wants could be quite different from the one you already know.

In this course the tape is limited on the left side and unlimited on the right side. When the computation start we have in the first cell the special charachter ▷, that identifies the first cell of the tape, followed by the input string. The rest of the cells contatin the empty charachter □.

Although the professor doesn't seem to have clearly stated that the only admissible charachters are the two special charachter shown above (□ and ▷) plus the two binary digits 0 and 1, he clearly prefer that only this charachters are used, so the alphabet of your TM should be _L_ = {0,1,▷,□}.

You can choose if have only one tape or more than one, but usually you will be fine with just one in both homeworks and exams.

For accepting a string you have to define a final state (the professor uses the name _qhalt_ usually) and to reject them you can choose if define a trap state or if not provide transactions when the string must be rejected, just be sure to explicitly clarify how your TM accepts and rejects strings.

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

# Rice's Theorem
The Rice Theorem is one of the most interestaing theorems studied in the course. It states that all **non-trivial**, **extensional** properties of a program are undecidable.

We say that a property is trivial when either all or none of the programs have that property (obviously, a property is non-trivial when it is not trivial).

We say that a property P is extensional when, if m has the property P and m and n have the same input-output function, then also n has the property P.



It is interesting because it identifies a set of pragmatic things which are undecidable.
