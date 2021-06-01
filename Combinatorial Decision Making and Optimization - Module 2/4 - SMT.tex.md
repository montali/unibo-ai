# SMT

SAT does not have enough espressivity that we need, as some problems are more naturally expressed in logics rather than propositional logic. Translation to propositional logic can therefore be complicated. That motivated some extension of SAT solvers. 

In SAT we only have boolean reasoning, while in SMT we have first order logic! No more propositional logic only, therefore. 

We are also able to have domain-specific reasoning thanks to FOL. The first advantage is in terms of expressivity, as the encoding is much more understandable. There is also some downside in terms of efficiency, though. Formulas in SMT are composed of atoms with no logical expressions, but they are themselves some formulas in the background we are working in. 

In SAT we had to introduce bit variables, while in SMT we can use directly bit-vectors to do bitwise operations on. 

## Formulas we can write

Linear arithmetic is the most used. Atoms are in the form of formulas, like $a_ix_1+...+a_nx_n$ which are equal to/lower than/higher/.../ of some $b$.

Variables can be real or integer, if all variables are linear we have a problem of Linear Real Artihmetic, while integer-variables are in Linear Integer Arithmetics.

The only required property for function symbols is that if $x=y$, $f(x)=f(y)$. 

Arrays in programs and memories in hardware allow us to save things. What happens is that when I read in a location that I wrote a value before, I must return the same value. We are storing in the $i$ position a value $d$, and if we select the same position the return must be $d$. The second axiom states that two different memory positions are not influenced by each other, then the final one means that if for all $i$ two memory cells are the same, then they are the same.

You can also use bit vectors, useful for strings, logical bit-wise things. The example formula states that we have two bit vectors $a,b$, saying that the two initial indices must be different, then performs some kind of calculation.

That's everything we need to know.

### Some examples of SMT encodings

We first want to prove that two snippets of code are equivalent. Then we need two formulas: $\phi_a$ and $\phi_b$. The first one encodes the for loop in the left, while the second one is the right snippet of code. 

We can use SMT to perform disjunctive scheduling, implementing the precedence between tasks as a disequality constraint, and minimizing the makespan (i.e. the time required). We can use disjunctions (or), differently from CP, because now we have a SAT solver underneath our solver!

