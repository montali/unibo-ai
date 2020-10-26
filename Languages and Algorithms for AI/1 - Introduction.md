

# Languages and algorithms for AI

There are 3 modules in this course: Gabbrielli, Zavattaro, Dal Lago. Basically, they are 3 different exams. The exams are not extremely difficult, the first module is written only, Zavattaro is usually a project, Dal Lago is a written exam.

Module 1 is about logics, Zavattaro is about cloud computing, Dal Lago is about theoretical complexity of algorihtms. 

This is not a typical engineering course, more on the science side.

## Contents for module one

Basically, logic languages. In particular, logic programming languages and constraint programming languages. 

We'll have an **introduction to logic**, with propositional logic, FOL, Resolution, Unification. 

Logic programming and constraint programming.

## Material for the course

First of all, the **slides**, which contain all the technical material you'll need, without containing explanations: you won't understand anything by just looking at the slides.

It's important to attend lessons: without doing so, you won't understand anything. 

The *Russel Norvig* will be used too. We'll use *Logic and Structure* by *Dirk Van Dalen*, which is available online.

Then, we'll use some resources on PROLOG, like *Triska - The power of PROLOG*, and on constraint programming, *The MiniZinc Handbook*.

## Two motivational examples

These should explain why we're studying these things. We're talking about programming in general, not AI.

### A combinatorial problem

Arrange three 1s, three 2s,..., three 9s in sequence in such a way that between two successive occurrences of the number $i$, there are exactly $i$ numbers netween successive occurrences of $i$. **Coding a solution would be a pain in the ass.** So we can work in a *declarative* way, by expressing, for example, that the 1s have to be like $[1,-,1,-,1]$. This will have to be a sublist of the full sequence $S$, containing 27 elements. Then we consider the pattern for the 2s, $[2,-,-,2,-,-,2]$. We can do so for every number, than try to merge them thanks to a PROLOG program:

```prolog
sequence([_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_])
question(S):-
		sequence(S),
		sublist([9,_,_,_,_,_,_,_,_,_,9,_,_,_,_,_,_,_,_,_,9],S),
		...
		sublist([1,_,1,_,1], S)
```

The `question` is a **first order logic formula**.

Now, the **PROLOG interpreter** essentially constructs a derivation tree (depth-first search) and explores it. Suppose that we have to prove that this program **solves the problem**. What we can do is reasoning by induction on the structure of the terms we're using.

The first reason on why we're studying these languages is, as seen here, that they can allow you to solve problems in a super easy way. 

### An optimization problem: the 🍰 problem

We need to bake some cakes for a party.

We know how to make two types of cakes, banana cakes and chocolate ones.

Each one of them has different ingredients and have different costs. We have a given set of ingredients in our store cupboard.

So, we can use MiniZinc to solve this problem, declaring our constraints and then simply maximizing the profit formula.

```minizinc
var 0..100 b; % no. of banana cakes
var 0..100 c; % no. of chocolate cakes

% flour
constraint 250*b + 200*c <= 4000
% bananas
constraint 2*b <= 6
% sugar
constraint 75*b + 150 * c <= 2000
...
solve maximize 400*b+450*c

output["no. of banana = \(b)\", "no. of chocolate = \(c)\n"]
```

## Declarative programming

The ideas we explored can be summarised into a quote from *Bob Kowalski*: *Algorithm=Logic+Control*, i.e. an algorithm has to be composed by the logic, and the control. In a traditional programming language you specify both of these, here, the revolutionary idea is that **the programmer takes care of the logic, while the control part is taken care of by the machine**.

This idea is generalized in **declarative programming** (opposed to *imperative programming*), which includes logic programming and constraint programming, where the programmer specifies the problem to be solved, not how.

We have 3 main paradigms: **logic** programming (Prolog), **functional** programming (ML, Haskel, OCAML), **constraint** programming (MiniZinc, CLP, ILOG).

Logic uses *relations*, functional uses *functions*, constraint uses *constraints*. No shit, Sherlock 🕵️‍♂️ 

## What the heck is logic?

It comes from greek, basically meaning the systematic study of the form of valid inference, and the most general laws of truth. It studies **the way human beings think**. When we think, we use *2 ingredients*: the notion of truth (what is true and false), and the notion of inference (i.e. deduction). E.g. *I have that all human beings die, I am a human being, therefore I die*. 

*Leibniz*, in the 600s, said that a universal language would be achievable, allowing us to do reasoning in all kinds of subjects.

*HIlbert* had a dream of *the complete axiomatization of all mathematics*, so that they could be expressed as a single set of axioms.

First of all, we should distinguish between types of logic:

- **Classical logic**, considering truth and inference. Normally it's interested in deriving new facts from the known ones. I can use the proof technique, in ways like the *reductio ad absurdo*, where I start from what I know, then assume that a third thing is false, and check if I obtain a contradiction;
- **Intuitionistic logic**, considering constructive proofs. The previous direct way is no more allowed: I must construct the proof, starting from the other proofs. If I start from X and Y and examine all the possible cases, and in no one W was false, then I deduce that W must be true: this isn't sufficient, *we need proof*;
- **Linear logic**, considering resources. *If I have X and Y, can I exchange them for W?* *It rains today and it rains today.* $\neq$ *I have a server with 2TB and I have a server with 2TB. The total is 4TB!*;
- **Epistemic logic**, considering knowledge and belief;
- **Temporal logic**, considering evolutions in time: *sooner or later it will rain*.

### Why should we study logic?

There are several reasons:

- **Historical reason**: Computer Science *derives from logic!* CS existed before actual computers existed. These studies on theoretical aspects of CS were crucial to the birth of computers.

## 2020-10-23 Lesson - **TODO**
[MS Stream link](https://web.microsoftstream.com/video/b3cfb9f9-1697-4ed8-b507-0c3add4961ba?list=user&userId=f9f103f3-1732-4b8e-8ba9-fff748a59273)
1. Metalanguage
2. Paradoxes in languages (natural, mathematical, ...) caused by overlap of language with metalanguage
3. Total functions
4. Facts
    1. Functions computed by programs are not only total
    2. Termination is not decidable
    3. any programming language cannot express all mathematical functions
5. Meaning of AI
6. History of AI 

## 2020-10-26 Lesson
### Symbolic computation
Also called **Expert systems** and **Decision Support Systems**. Examples are systems that ask doctor the syntoms/conditions of a patient and suggest a therapy basing on **pre-existing specialistic knowledge** in the medical field.

These can be implemented in standard languages such as python but it's better to **use formalisms strongly based on logic**. This is because we can represent all the facts and rules used by humans and let the system obtain a solution by creating a "*deduction tree*".

Of course these systems solve problems in a limited domain but they can perform better than human experts. The system **does not create new knowledge**. The knowledge is explicitly contained in the given rules. It is possible to make modification to the system logic.

### Sub-symbolic computation
System treated in other courses (**Machine Learning and Deep Learning**). Examples are neural networks which are trained on images of normal and pathological cells and can suggest the state of the cell in a new image.

The **knowledge is obtaind from the data**, but **it's impossible to extract any general rule** (which we can use outside the system). If any small modification is needed it is necessary to rebuild the system.

### The notion of truth

Any statement is true only in a certain domain (for example, the sum of inner angles of a triangle is 180° only in euclidean geometry, not in spherical geometry).

Since we are not able to define a global domain for a truth, working with logic we will not focus on the notion of thruth but rather the notion of **logical consequence** (which is derived from the notion of truth).

Given a set of sentences $\Gamma = F_1,\dots,F_n$ (*promises*) and a sentence $F$ (*conclusion*), $F$ is a logical consequence of  $\Gamma$ ($\bold{\Gamma |= F}$) if it always true that if all the formulas in $\Gamma$ are true then also $F$ is true.

$F$ logically equivalent to $G \iff F|=G$ and $G|=F$.

### Propostitional logic

In any logic or programming language we distinguish 

1. **Syntax**: rules that define **how sentences must be constructed**
    - Defines the symbols used too represent propositions, variables, ...
    - Well formed sentences are called *formulas* 
2. **Semantics**: rules which define the **meaning of well formed sentences**
    - Two realms (hopefully they coincide):
        - Model theory: what is true
        - Proof theory: what is provable

A **proposition** is a statement about some world which in that world can be true, false or neither (but not both). The truth or falsity in our interpretation is called **truth value**.

Propositions are joined with connectives (and, or, not...). We will use only useful connectives (for example, *but* is used to convey surprise, we use instead *and* which is neutral).

We define an **alphabet** of propositional logic, consisting of:
- A countable number of ***proposition symbols*** (also called ***atoms***):  $p_0, p_1, \dots$
- ***Connectives***:  $\land, \lor, \neg, \rightarrow, \leftrightarrow, \dots$
- ***Auxiliary symbols***:  ,

The **syntax of propositional logic** can be defined with a recursive definition, an inductive definition or through Backus-Naur Form (BNF):

![Propositional Logic syntax (Backus-Naur Form)](img/pls_bnf.png)

