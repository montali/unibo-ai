# Truth

First of all, we re-define **truth**: basically being in accord with fact or reality, or fidelity to an original or standard. Truth is usually associated to the sensible world: you observe an experiment, if it is repeatable than you have *truth*. For example, you throw a ball to the ground, it is true that it falls because it always will.

In mathematics, we have truth in, for example, *The sum of the internal angles of a triangle is $180$°*, but this becomes false in spherical geometry! The consequences are that the **axiomatic method is not a description of the sensible world**. The conclusion is that we **should replace the notion of pure truth** by the notion of **logical consequence**. The important one is the latter, which is based on the notion of truth. 

In mathematics, we can state that **a statement is true in a specific world, described by a specific axiom**. Rather than focusing on the **absolute** notion of truth, we focuse on a **relative** notion of truth, being relative on a set of axioms, i.e. a model where these axioms are true. Then, rather than talking about general truth, we are interested in the truth with respect to those axioms.

Now, let $\Gamma = F_1, \dots, F_n$ we say that $F$ is a logical consequence of $\Gamma$, written as $\Gamma|=F$, if it is always true that for each world in which all the formulas in $\Gamma$ are true, also $F$ is true. In other terms, whenever all the sentences in $\Gamma$ are true, $F$ is true too. We're not interested in knowing whether $F$ is always true, just in its world. 

Therefore, **truth is always defined with respect to a world** and a **given intepretation of symbols** in that world. We are not interested in the truth of a single sentence, but in the truth with respect to a set of other sentences, i.e. a **logical consequence**. 

## Syntax, semantics, rules

In general, for every system we distinguish **syntax** from **semantics**: the first being rules which tell us **how  sentences are formed**, the latter being the rules which tell us the **meaning of well formed sentences**.

How can we define a syntax? In many ways like informal (e.g. in natural language, for example, it is subject/verb/etc...), BNF, and inductive definitions.

So, how can we define semantics? Basically, if we take C (the language) as an example, what's the meaning of a *for statement*? In order to precisely define the semantics, we use many different methods, like operational semantics, denotational semantics, logical semantics... These are not being teached anymore (*bella*), but they are starting to being used at high levels too.

We have two main realms for semantics: **model theory** (concerning what is true) and **proof theory** (concerning what is provable). Hopefully, the two coincide. 

Propositional logic is the simplest logic, concerning propositions, i.e. statements about a reality which can be true or false. Who defines what is true and false? *Our specific interpretation*.

Now, we all know what propositional logic is (*do we?*), but how do we put propositions together? Using **connectives** (or, and, if...). Propositional logic uses a very restricted set of connectives, because we want to be precise. 

One should be careful, though, because the ordering of propositions may be crucial: *John drove on and hit a pedestrian* is very different from *John hit a pedestrian and drove on*. 

So, we need to create an artificial language with precise meanings: an **alphabet for propositional logic**, which contains a countable set of symbols <img src="svgs/64258665045232115741ed193231351f.svg?invert_in_darkmode" align=middle width=91.52194259999999pt height=14.15524440000002pt/>, connectives AND , OR, <img src="svgs/e5d134f35dc4949fab12ec64d186248a.svg?invert_in_darkmode" align=middle width=16.43840384999999pt height=14.15524440000002pt/>(implication), <img src="svgs/43c24ae4490ffb3a4e8e30d0250ffd2c.svg?invert_in_darkmode" align=middle width=16.43840384999999pt height=14.15524440000002pt/>(double implication), <img src="svgs/23bf728170c10d0449b90561f827623a.svg?invert_in_darkmode" align=middle width=10.95894029999999pt height=14.15524440000002pt/> negation, _ disjunction.

The propositions are also called atoms. 

Now, how do we define well-formed formulas? First of all, 

- **an atom is a formula** (atom=any propositional formula)
-  if <img src="svgs/b8bc815b5e9d5177af01fd4d3d3c2f10.svg?invert_in_darkmode" align=middle width=12.85392569999999pt height=22.465723500000017pt/> is a formula, <img src="svgs/503de64a64aaa26ba921d2c566b599bb.svg?invert_in_darkmode" align=middle width=21.986342399999987pt height=22.465723500000017pt/> is a formula
- if <img src="svgs/264fba1c7ab2f0bc1611dac6780708a6.svg?invert_in_darkmode" align=middle width=16.632471899999988pt height=22.465723500000017pt/> and <img src="svgs/7684afeaf2968f03abc32b7d309d9ff2.svg?invert_in_darkmode" align=middle width=16.632471899999988pt height=22.465723500000017pt/> are formulas, <img src="svgs/3c550e455a25a573cc12b8f9173f1b25.svg?invert_in_darkmode" align=middle width=16.632471899999988pt height=22.465723500000017pt/>^<img src="svgs/4fadbac804fb961039cec6f365bc13e2.svg?invert_in_darkmode" align=middle width=16.632471899999988pt height=22.465723500000017pt/> is a formula
- If <img src="svgs/264fba1c7ab2f0bc1611dac6780708a6.svg?invert_in_darkmode" align=middle width=16.632471899999988pt height=22.465723500000017pt/> and <img src="svgs/7684afeaf2968f03abc32b7d309d9ff2.svg?invert_in_darkmode" align=middle width=16.632471899999988pt height=22.465723500000017pt/> are formulas, <img src="svgs/264fba1c7ab2f0bc1611dac6780708a6.svg?invert_in_darkmode" align=middle width=16.632471899999988pt height=22.465723500000017pt/>_<img src="svgs/7684afeaf2968f03abc32b7d309d9ff2.svg?invert_in_darkmode" align=middle width=16.632471899999988pt height=22.465723500000017pt/> is a formula (disjunction, <img src="svgs/0ade148489027173f7a25bfec12976ce.svg?invert_in_darkmode" align=middle width=14.137028399999998pt height=14.15524440000002pt/> being an OR)
- All well-formed formulas are formed by applying the above rules

The Backus-Naur Form (BNF) defines formulas analytically.

The third definition (100% precise) defines by induction: we have three rules, which define the set <img src="svgs/cbfb1b2a33b28eab8a3e59464768e810.svg?invert_in_darkmode" align=middle width=14.908688849999992pt height=22.465723500000017pt/>. 

- For any propositional value <img src="svgs/03032657e995bacbca315d0417d884d2.svg?invert_in_darkmode" align=middle width=98.35496715pt height=22.831056599999986pt/>. 
- If I have two formulas <img src="svgs/e0f2f7fe5e5d83478f0dd5f830c4a20e.svg?invert_in_darkmode" align=middle width=85.36121055pt height=22.831056599999986pt/> <img src="svgs/39318a336c20135bac19dc14453ba5f7.svg?invert_in_darkmode" align=middle width=416.6630688pt height=24.65753399999998pt/>
  - Be careful not to confuse <img src="svgs/777d001ea1ec5971b67bb546ed760f97.svg?invert_in_darkmode" align=middle width=16.43840384999999pt height=14.15524440000002pt/> with <img src="svgs/e5d134f35dc4949fab12ec64d186248a.svg?invert_in_darkmode" align=middle width=16.43840384999999pt height=14.15524440000002pt/>, the first one not being part of the language but the meta-language we use to describe the problem, while the latter is part of it.
- If I have <img src="svgs/7a2e46a8c62d74ac057cd553a83f0095.svg?invert_in_darkmode" align=middle width=108.85807679999999pt height=22.465723500000017pt/>

Note that the implication <img src="svgs/d2eef72b80b480c710c8297a418103e8.svg?invert_in_darkmode" align=middle width=51.19280924999999pt height=22.465723500000017pt/> was not included in the first syntax, because it can be derived by <img src="svgs/84e38163194a1efae16932052e851e52.svg?invert_in_darkmode" align=middle width=72.42592664999998pt height=22.465723500000017pt/>. 

Let's define **interpretations**: given a propositional formula, i.e. a set of atoms <img src="svgs/21960040b28b98e46bfef0f7d0db735e.svg?invert_in_darkmode" align=middle width=76.6874955pt height=22.465723500000017pt/>, an interpretation <img src="svgs/21fd4e8eecd6bdf1a4d3d6bd1fb8d733.svg?invert_in_darkmode" align=middle width=8.515988249999989pt height=22.465723500000017pt/> is an assignment of truth values to <img src="svgs/21960040b28b98e46bfef0f7d0db735e.svg?invert_in_darkmode" align=middle width=76.6874955pt height=22.465723500000017pt/>. For example, if we take the formula <img src="svgs/5201385589993766eea584cd3aa6fa13.svg?invert_in_darkmode" align=middle width=12.92464304999999pt height=22.465723500000017pt/> in the language defined by <img src="svgs/7cf04ace8f715566d5666640ff6c24c6.svg?invert_in_darkmode" align=middle width=44.535448649999985pt height=24.65753399999998pt/> ^<img src="svgs/d3337f9be36baa942ccdde64290faaad.svg?invert_in_darkmode" align=middle width=30.18843299999999pt height=24.65753399999998pt/>^<img src="svgs/3f5b3c90f09be874446a5406b5ff8dec.svg?invert_in_darkmode" align=middle width=19.38814184999999pt height=24.65753399999998pt/>. *ha cambiato slide scusate mi sono perso un pezzo dioccc*.

