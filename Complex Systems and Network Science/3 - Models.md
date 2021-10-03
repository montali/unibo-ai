# 3\. Models
A model, to be useful, must be _compact_ and _simple_, while maintaining _fidelity_ to what is being modeled. This can be done only abstracting away the unnecessary details yet maintaining the essence.

> Everything should be made as simple as possible, but no simpler.
> \- Albert Einstein (1933)

Examples of well-known models are:
 - geographic maps,
 - plate tectonics,
 - solar system,
 - Bohr's atom,
 - pandemics.

## Cellular Automata

Cellular automata is an abstract model developed by John von Neumann for simple individual behavior and simple interactions between individuals leading to complex aggregate behaviors.

### 1-Dimensional CA
The model, constrained to only one dimension, consists of an infinite array of _cells_. Each cell has a value from a _k_-ary state, a position _i_ in the array and _r_ left and _r_ right neighbors. The state of a cell at time _t+1_ is a function of cell's state and its neighbors state at time _t_.

Assume _k=2_ (binary state) and _r=1_ (neighborhood of size 2). Then the function that tells how a cell change state could be the one expressed in this look-up table

![LUT](assets/markdown-img-paste-20211003132906734.png)

The possible look up tables are _2 <sup>k <sup>2 r + 1</sup></sup>_ and since a CA is defined by its state that transitions, that corresponds to the number of possible CAs. So, for _k=2_ and _r=1_ there are 256 possible 1-Dimensional CAs.
If we read off the final state column of the LUT as a binary number we obtain the **Wolfram canonical enumeration** which identifies each possible CA with a number in the range _{0,...,255}_

![image](assets/markdown-img-paste-20211003134030866.png)
