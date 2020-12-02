# Constraint satisfaction

In many AI problems we can find **constraints**: you have to take **decisions**, decide values for variables which are subject to constraints. We want to find the state of the problem that is compatible with all the constraints. 

For example, in the *Eight Queens Problem*, we have a **chessboard** on which we put 8 queens, which can move on the row, on the column and on the 2 diagonals. There are 92 possible solutions. You can generalise this problem to a $n\times n$ chessboard. For $n>3$ there always is a solution. So, we could already solve this with a **search**. We have to describe a **state**, starting from the root of the tree with an empty chessboard, then put 1 queen for each level. When we have placed 8 queens, we are there. 

The description of the state can be done in two ways, the first one being a 0/1 in case of non-queen/queen. With this, we can write the constraints. 

The second one might just be saving 8 variables containing the $x$ for the queen in the row: we can't assign two queens on a single row. This last thing is a constraint too.

So, we have **two types of constraints**: unary and binary. What do constraints do, generally? They force the assignments of variables to be **linked through a relation**. So, every assignment that I do to my variables is not free, rather it should satisfy these constraints. The first **unary** constraint we meet is the domain, i.e. $1 \le x_i \le 8$. Then, the **binary** constraints involve **two variables**. 

We could consider **scheduling** as a constraint problem, where the variables are the starting time of activities, and domains the possible starting times. Activities can be ordered: $Start_1+d_1 < Start_2$.

**Map coloring** too could be *constrainized*: we have to color a map and we have that two contiguous regions have to be different. So, how can you model this state? 

A **Constraint Satisfaction Problem** is defined on a finite set of variables, i.e. the decisions we have to take, the domains of the possible values, and a set of constraints. A constraint between k variable is a subset of the cartesian product of the domains, specifying which values are compatible with each other. The subset must not be explcitly defined but is represented in terms of relations. The solution is achieved through assignments.

The assignment is complete when all the variables are assigned to a feasible value.

Using constraints in search trees can reduce their complexity. Before instantiating and then failing, we could **prune** the search tree using constraints, to remove **portions** of the search space that are guaranteed to lead to a failure: we **prevent failures** rather than recovering.

This eliminates subtrees that lead to a failure, limiting unnnecessary backtracking.

Given a CSP, we have two approaches: **propagation algorithms** and **consistency techniques**. The first ones have traditionally been used during the search: while searching we propagate these constraints. Consistency techniques have instead been proposed for reaching properties. 

The available **a posteriori** algorithms are the **Generate and Test** (GT) and **Standard Backtracking.**

The **propagation algorithms** we'll see re **Forward Checking** and **Look Ahead**, we constrain then generate.

## Tree search

We are exploring a search tree, where the initial state is the empty assignment ,and assign a variable at each level of the tree.

## A posteriori algorithms

### Generate and test

The **Generate and Test** is a very simple algorithm, trying to assign a random configuration to the variables in one shot, then check if it is ok. By using permutation, we are not discarding all the constraints, one remains: the variables are all different!

### Standard Backtracking

This is the search we have seen so far. Instead of assigning all the variables, we assign one at a time and check if the lastly assigned is compatible with the constraints. For the eight queens problems, this would have been a huge improvement from GT.

## Propagation algorithms

A pitfall of SB is that it uses constraints a posteriori, i.e. after the instantiation. Exploiting constraints involving free variables would detect this situation in advance. The idea begind a priori propagation algorihms is an **active use of the constraints** during search, **pruning** the tree. At every step we use the constraints actively, by removing values that are incompatible with the already done assignments. These values are stored in domains.

### Forward checking

At every assignment of a variable $x_i$, it **propagates** all the contraints involving $x_i$. It removes from the domain of other variables, the values which are incompatible with $x_i$: you don't have to *try*, they have been removed (their whole search tree was removed). This is very effective.

### Look Agead

Look Ahead, besides checking the constraints with the current instantiated variable, also checks the **non-assigned variables**. Checking the existence, in the domains associated with non-assigned variables, of values that are compatible with...