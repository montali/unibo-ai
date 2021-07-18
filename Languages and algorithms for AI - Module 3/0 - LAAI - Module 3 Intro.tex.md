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

For example, two $n$-digits numbers $a$ and $b$ can be multiplied ($a*b$) in (at least) two ways.
The first method ("repeated addition") by summing $a$ $b$ times ($a+a+...+a$), which for each sum requires $n$ steps, hence the total cost is proportional to $n*b$ steps.
The second method ("grid method") is the classic method we learnt at elementary school and has a cost proportional to $n*n$ steps.
Notice that $b$ can be exponential in $n$ ($b \in [0, 10^n-1]$).
The repeated addition is potentially way slower than the grid method because there is a huge (exponential) difference between $n*n$ and $n*(10^n-1)$. 
For example, supposing $n=100$ and $b=100^{100}-1$ (the worst case scenario) and that each step requires a millisecond, the grid method would require a second while the repeated addition 10^80 years.

Computational processes can be classified as **P** (Polynomial time, efficient), **NP** (Nondeterministic Polynomial time), **NP-complete**, **NP-hard**, **EXP** (pratically uncomputable).

Proving tasks not solvable by processes beyond a certain level of efficiency is very rarely possible.
We can, however, interrelate different tasks to compare their complexity.

## Mathematical preliminaries

Mathematical concepts needed for the course:

- Sets (i.e. $X$)
  - cardinality (i.e. $\lvert X \rvert$)
  - finiteness
- Naturals and integers
- Conditions holding  for a sufficiently large variable (i.e. $n \in \mathbb{N}$, $P(n)$ holds if $\exists N \in \mathbb{N}$ such that $P(n)$ holds $\forall n > N$)
- Floor (i.e. $\lfloor x \rfloor$)
- Ceil (i.e. $\lceil x \rceil$)
- $n \in \mathbb{N} \Rightarrow [n]=\{1,2,...,n\}$
- We will use 2 as canonical base for logarithms (i.e. $\log(x) = \log_2(x)$)
- String $S^n$ over the alphabet $S$ with length $n$
  - Empty string ($\varepsilon = S^0$)
  - Set of all string over $S$ ($S^* = \bigcup_{n=0}^\infty S^n$) 
  - Concatenation $xy$ of $x$ and $y$
  - Concatenation $x^k$ of $x$ with itself $k$ times
  - Length $\lvert x \rvert$ of a string $x$

#
[Next section](1%20-%20Sets%20and%20numbers.md)
