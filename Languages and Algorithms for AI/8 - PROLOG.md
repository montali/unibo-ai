# PROLOG

## List, arithmetic, data structures

In PROLOG are stated with capital letters, constants, functions and predicates lowercase. The rules have a conjunction of atoms, a :- and another conjunction of atoms. We are considering **SLD resolution**: we start from the goal and try to prove it. We have a **selection rule**, selecitng the leftmost atom, and the order of clauses is the syntactic order in the program, i.e. from top to bottom.

In PROLOG a list is represented by a term defined as: `[]` for the empty list, `[t1|t2]` for the list having `t1` as head, and `t2` as tail, note that it is not the second element, rather the **rest of the list**.

You can compute the number of elements using `length(L,N)`, where `N` is the length. Note that we don't really need numbers in these programs. In order to represent the numbers, it's ok to use a single constant (0) and its successors: `s(0)=1` with `s` being the successor function, `s(s(0))=2` and so on.

**Recursion** comes at hand when defining lists.

Assuming that the length of `L` is `N`, then the length of the list containing any element as head of the list, and the list as tail, will be `N+1`.  So we could basically take the program of the slides, and we should be able to compute the length of the list.

Then, to know if something is element of a list, we can use `member(X,L)`, that enables us to check whether `X` appears in the list `L`.

We can concatenate two lists with `append(L1, L2, L)`, where `L` is the resulting concatenation. Assume that appending L1 and L2 gives me L, then when I append `X | L1` and `L2`, I'll get `X|L`

A very important point is **how do I use this**? The first two lines are the program, the other ones the goal. Then, for the first line, the results will be `Z=[a,b,c]`. Now, what if we wanted the third element to be an input and the central one the output? Suppose that the result is `[a,c,e,f]`, the first element is `[X]`, and the central one `[c,Y]`. Now, the question is how can I define `Y` so that the result is `[a,c,e,f]`? The program can therefore compute `Y`.

Note that PROLOG is not typed. Now, we get to numbers. First of all, the modern PROLOG are constrained programming languages. The classic PROLOG have some pre-defined predicates which can be used in expressions. The predicates are the following: `is`, meaning that the values are unified, `=:=`, meaning that the values are equal, `=\=`, meaning that the values are different, and `>` meaning that one is greater than the other. 