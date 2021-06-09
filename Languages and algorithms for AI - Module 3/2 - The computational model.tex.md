# The computational model aka Turing Machines

A computational model computes some specific functions on strings, taking a binary string of arbitrary length, and outputting a single bit.
These are called **characteristic functions**, corresponding to decision problems/languages.

This computational model is made by:
- a finite set of instructions, each of which can be executed more than once;
- a scratchpad in which the CPU can read and write;
-  the input and the output.

This model has the peculiar feature that each instance (finite set of instruction) of it can be encoded itself as a machine.
Actually, in the model we can observe this by proving that there exists the universal Turing Machine, a particular instance of this which simulates all the other machines.
This does nothing less than taking in input a pair of strings $(x,\alpha)$, and simulating the input of the machine of index $\alpha$ with the input $x$. This is basically an interpreter: it takes a program and an input and produces an output!

Actually, the simulation is quite efficient: if the original machine works in time $t$, then the universal machine takes a time which is slightly more, just with a logarithmic overhead.
The functions which can be computed by Turing Machines do not completely saturate the space of all functions: they are infinitely many, some of them are intrinsically uncomputable. 

## The model, formally

We want to be able to precisely and formally state theorems about the computable functions: we therefore need a mathematical definition. If we didn't give a definition, anybody could say *well, that scratchpad could contain this, and we could solve that*. Let's first take a look at the scratchpad: this is actually called the worktape in Turing Machines. We can think about it as a sequence of cells, each of which containing a binary digit, and the machine cannot access the tape at the place it wants: at every moment, it points to a specific cell in the tape, the *head*. In the case of the work tape, it is R/W. There's also the input tape (R only) and the output tape (R/W). We can only read from the input, not modify it. These tapes are infinite, though at every moment only a finite set of this has a value different from blank. We also have many blank cells in the work tape: the machine has never accessed these cells so far. The initial value of any cell is blank. The output tape is where the output of the computation is written. Then, what we have in the machine is a **state**: this is stored in a specific register, able to only hold a finite amount of information, since the number of states is finite. Basically, the state tells us *write something there, read something here, move the tape forward, bla bla bla*. It basically reacts to symbols it reads, and moves tapes accordingly. For different states, the way the machine reacts could be different. 

### Scratchpads

A scratchpad consists of $k$ tapes: there can be any number of tapes. Any of these is a line of cells infinite in one direction, holding values from a finite alphabet. Each of this has a head, which can read or write, and move left or right. The first tape is always the input tape. There could exist machines with no input or output: they may collapse to just one tape. Instead, other machines can have much more than 3 tapes. The only point is that $k$ cannot change during computation. 

### Instructions

The movement of the head is regulated by the **instructions**, and the machine has a finite set of states called $Q$. At each step, the machine does the following:
1. it reads the symbols under the $k$ tape heads
2. for the $k-1$ R/W tapes it replaces the symbol with a new one or leave it unchanged
3. it may change the state to a new one
4. it may move the heads

These instructions are super basic: we cannot think about arithmetic operations, just some finite amount of information that produces some necessary information required to modify the internal state of the machine. 

### Turing machines

We can now define a **Turing Machine** TM working on $k$ tapes, described as a triple made of 

* An alphabet $\Gamma$, a finite set of tape symbols, namely those symbols that can be found in the tapes. These symbols must include the blank symbol ($\Box$, the box), the start symbol ($\rhd$), and the binary digits 0 and 1. There can be more, for example A,B,C,3,5...

* A finite set of **states** $Q$ (including a designated initial state $Q_{init}$ and a designated final state $Q_{halt}$)

* A **transition function**, what really matters, i.e. the actual program. this models how the machine reacts to input and produces outputs. Nothing more than a function taking the current state (element of $Q$), a vector of length k from gamma (i.e. the symbols the machine reads form the tapes), and produces an output containing the next state (element of $Q$), then the symbols it puts into the $k-1$ R/W tapes (work tapes and output tapes), then a vector of length $k$ made with an alphabet composed of $L$ (move the corresponding head to left), $S$ (let the head $i$ stay in place), $R$ (move the head to right). This can be expressed formally as:
$$
\delta: Q \times \Gamma^k \to Q \times \Gamma^{k-1} \times \{L,S,R\}
$$

This function only includes a **finite amount of information**, so the possible inputs are finite and the possible outputs are finite.
Now, there is one thing to say: when the first parameter is $q_{halt}$, the tapes/heads cannot be touched, so we take for granted that: 
$$
\delta\left(q_{\text {halt }},\left(\sigma_{1}, \ldots, \sigma_{k}\right)\right)=\left(q_{\text {halt }},\left(\sigma_{2} \ldots, \sigma_{k}\right),(\mathrm{S}, \ldots, \mathrm{S})\right)
$$
meaning that the machine stays in this position.

The Turing Machine can be referred as $\mathcal{M} = (\Gamma,Q,\delta)$.

Now, the current state of the machine is not just the current state $q$, but the **configuration**, composed of $q$, the contents of the $k$ tapes, and the position of the $k$ heads! One such configuration will be indicated as $C$.

Given the input $x \in \{0,1\}^*$, in the initial configuration $\mathcal{I}_x$ the state is $q_{init}$, the input  tape contains $\rhd x$, work and output tape contain $\rhd$ and the tape heads are positioned on the first symbol of their tape.

TMs are an interesting strategy of showing that a function is computable. The point is that computing it in another way is still a good proof. So, why are we obsessed with these fucking Turing Machines? We cannot get negative results with these! The border between what can be done and what can't be done is exactly what we are searching for.

We usually ask the TM to compute things in a bounded amount of steps: $T$ is a bound, not in the strict sense, rather in a function sense.
If we say that a function  is computed in time $T$, we insist on $T$ to be a function: it would be non-sense to require the computational time to be fixed for different inputs.
The time bound is dependent on the length on the input! What matters about the input is its length: **if an input is longer, we'll allow the machine to take a longer time.**

Given $f:\{0,1\}^* \to \{0,1\}^*$ and $T:\mathbb{N} \to \mathbb{N}$, these are equivalent:
* $f$ is **computable** in time $T$.
* A TM $\mathcal{M}$ computes $f$ in time $T$.
* $\mathcal{M}$ returns $f(x)$ on input $x$ in a number of steps smaller or equal to $T(|x|) \forall x \in \{0,1\}^*$. 

Then, we can finally say that a **language** $\mathcal{L}_{f} \subseteq\{0,1\}^{*}$ is decidable in time $T$ if and only if $f$ is computable in time $T$.

A function $T:\mathbb{N} \to \mathbb{N}$ is **time-constructible** if the function itself can be computed on a Turing Machine (i.e. $\forall x \in \{0,1\}^*$ $x \to \lfloor T(|x|) \rfloor$ is computable). 

How robust is our definition? There are many details that are arbitrary.
We have chosen this not because it's the best, but because it's okay. For example, rather than having an alphabet for the tapes we may restrict it to the minimal, or restrict the number of tapes, or make the tapes infinite in both directions, etc.
However it can be proved that these more restrictive notions of TM simulate the more general one, with polynomial overhead, so they are equivalent.

What keeps our definition so simple is that describing it is just describing the transition function $\delta$: the states are finitely many, the symbols are finite, the tapes too. So, the description is nothing more than the description of this subset. 

We can state that there exists a **Universal Turing Machine** (UTM) $\mathcal{U}$, a TM which can generate all the TMs from their description, halting with just an additional logaritmic overhead (hence it can be used to efficiently simulate all TMs). More formally, $\forall x, \alpha \in \{0,1\}^*$ (where $\alpha$ represents the TM $\mathcal{M}_{\alpha}$):
* $\mathcal{U}(x,\alpha) = \mathcal{M}_{\alpha}(x)$
* $\mathcal{M}_{\alpha}(x)$ halts within $T$ steps $\Rightarrow \mathcal{U}(x,\alpha)$ halts within $cT\log(T)$ steps (where $c$ depends only on $\mathcal{M}_{\alpha}$, not on $x$)

We can even state that there exists a function $uc$ that is not computable by any TM: the proof is constructive. Before being able to return 0, the following function has to wait until this process finishes. We'd want to wait that it is over, and that is not possible!
$$
u c(\alpha)=\left\{\begin{array}{ll}
0 & \text { if } \mathcal{M}_{\alpha}(\alpha)=1 \\
1 & \text { otherwise }
\end{array}\right.
$$

If this was computable, there would exist a TM able to compute this for every $\alpha$. This is a contradiction: it's like saying factorial of 3 is equal to 6 if and only if factorial of 3 is 7. Only one can be true! Why do we have this if and only if chain? If it returns 1, we must be on the *otherwise* branch. So how do we change branch? If $M$ is different from 1 it must be 0, there is no other way. $M$ is equal to $uc$, and on the one hand we used the second definition, while on the other hand we used the other equation. We can't go from a statement to the other! Why did we manage to prove this? There's a mechanism here called *diagonalization*: we see it as $\alpha$ is used twice, as input and as output.
$$
u c(\llcorner\mathcal{M}\lrcorner)=1 \Leftrightarrow \mathcal{M}(\llcorner\mathcal{M}\lrcorner) \neq 1 \Leftrightarrow u c(\llcorner\mathcal{M}\lrcorner)=0
$$
 This is the root of the problem. The incompleteness theorem we studied at the beginning relies on this too. This allows for negative results both in logic and CS. 

A *diophantine equation* is a polynomial equality with integer coefficients and finitely many unknowns. 

We want a language to be semantic, i.e. whenever an encoding of a Turing Machine is in the language and there exists a TM which computes the same function as $M$, also the encoding of that TM is in that language. 

#
[Previous section](1%20-%20Sets%20and%20numbers.md) · [Next section](3%20-%20Polynomial%20time%20computable%20problems.md)
