# Propositional Logic

## Syntax, semantics, rules

In general, for every system we distinguish **syntax** from **semantics**: the first being rules which tell us **how  sentences are formed**, the latter being the rules which tell us the **meaning of well formed sentences**.

How can we define a syntax? In many ways like informal (e.g. in natural language, for example, it is subject/verb/etc...), BNF, and inductive definitions.

So, how can we define semantics? Basically, if we take C (the language) as an example, what's the meaning of a *for statement*? In order to precisely define the semantics, we use many different methods, like operational semantics, denotational semantics, logical semantics... These are not being teached anymore (*bella*), but they are starting to being used at high levels too.

We have two main realms for semantics: **model theory** (concerning what is true) and **proof theory** (concerning what is provable). Hopefully, the two coincide. 

Propositional logic is the simplest logic, concerning propositions, i.e. statements about a reality which can be true or false. Who defines what is true and false? *Our specific interpretation*.

Now, we all know what propositional logic is (*do we?*), but how do we put propositions together? Using **connectives** (or, and, if...). Propositional logic uses a very restricted set of connectives, because we want to be precise. 

One should be careful, though, because the ordering of propositions may be crucial: *John drove on and hit a pedestrian* is very different from *John hit a pedestrian and drove on*. 

So, we need to create an artificial language with precise meanings: an **alphabet for propositional logic**, which contains a countable set of symbols , connectives AND , OR, (implication), (double implication),  negation, _ disjunction.

The propositions are also called atoms. 

Now, how do we define well-formed formulas? First of all, 

- **an atom is a formula** (atom=any propositional formula)
- if  is a formula,  is a formula
- if  and  are formulas, ^ is a formula
- If  and  are formulas, _ is a formula (disjunction,  being an OR)
- All well-formed formulas are formed by applying the above rules

The Backus-Naur Form (BNF) defines formulas analytically.

The third definition (100% precise) defines by induction: we have three rules, which define the set . 

- For any propositional value . 

- If I have two formulas  

  - Be careful not to confuse  with , the first one not being part of the language but the meta-language we use to describe the problem, while the latter is part of it.

- If I have 

  Note that the implication  was not included in the first syntax, because it can be derived by . 

  Let's define **interpretations**: given a propositional formula, i.e. a set of atoms , an interpretation  is an assignment of truth values to . For example, if we take the formula  in the language defined by  ^^. *ha cambiato slide scusate mi sono perso un pezzo dioccc*.

  

  ## Evaluation of a formula

  Once we have the meaning of the symbols, we can use truth tables to evaluate the truth value of a formula:

  ![Truth table](./res/truth_table.png?lastModify=1604312935)

  ## Model

  The notion of **model** is important. We can say that an interpretation  is a model of the formula  written  if  is true when the truth value of propositional symbols is defined according to .

  Note that it is the same symbol we're using for logical consequence.

  A **valid formula** is true, no matter the interpretation. A valid formula is also called a **Tautology**.

  For example: .

  If  is valid, we can write .

  For example, we prove the *deMorgan's Law*:

  ![de Morgan's Law](./res/deMorgans_law.png?lastModify=1604312935)

  An **unsatisfiable** formula is always false, under any interpretation.

  A formula which is not inconsistent is consistent/satisfiable.

  Note that **invalid**  **inconsistent**.

  From the definitions we can prove that a formula is valid iff its negation is inconsistent (if you take a valid F it is true for every possible interpreation, so the negation is always false).

  We say that a formula is **consistent** if there's at least one interpretation in which it is true. An inconsistent formula is always invalid, but an invalid formula isn't always inconsistent.

  ### Decidability

  What we are interested in, given a formula, is checking wheter it is valid.

  Suppose we have a set of axioms  which describe some *world*. Then, we have a formula . We want to know whether  i.e.  is a logical consequence of : it is true under all the possible interpretations which make the set of axioms  true.

  For example  is a formula describing a fault in an electric circuit involving the variables . *Is F satisfiable?* means: is there an  such that ?

  So, to define whether a formula is valid, we can enumerate all possible interpretations (exponential, not so good), then evaluate the formula for each interpretation. The number of interpretations is finite: .

  Decidability is a very strong and desirable property.

  A problem is **NP hard** when the best algorithm has **exponential complexity**.

  With **logical equivalence** we mean that two formulas  and  are said so iff the truth values of  and  are the same every under interpretation of them. We can list some useful equivalence rules:

  ![Equivalence rules](./res/equivalence.png?lastModify=1604312935)

  ## Standard forms

  We have two standard ways of writing formulas: the **Conjunctive Normal Form** and the **Disjunctive Normal Form**. A **literal** is an atom or the negation of an atom. A formula is said to be in **Negation Normal Form** iff negations only appear in front of atoms.

  A clause is formed as . Sometimes we write formulas in CNF as a set of clauses. 

  The DNF is a disjunction of conjunctions of literals.

  It is always possible to transform a formula into normal form by using the equivalences.

  ## Deduction theorem

  Given a set of formulas  and a formula G, /\  /\  meaning it is a logical consequence from the Fs. From the definition of logical consequence, we can derive that every interpretation  which makes  true makes  true too.

  ### Why do we use Propositional Logic?

  For example, we can use this to represent problems, like the *Chang-Lee example*: *Given that if the congress refuses to enact new laws, then the strike will not be over unless it lasts for more than a year or the president of the firm resigns, will the strike be over if the congress refuses to act and the strike just started? [Chang-Lee example 2.12]* 

  ## Proof Theory

  This is another way to provide a semantic to propositional logic. We have already seen the notions of models, now we want to base on syntax rather than semantics. We want to have a way to perform a computation (i.e. manipulation of symbols) which allows us to do deductions and eventually get the same results as in the model approach.

  We want to be able to derive $F$ from $\Gamma$. We are interested in logical consequences, which allow us to derive conclusions about truth in specific worlds described by specific axioms, and we want to prove them by using syntax, i.e. syntactic manipulation of the symbols which appear in the formulas. 

  All the rules have the general idea that **given a set of premises**, you get a **conclusion**. 

  We'll see one of the systems for propositional logic, called **natural deduction** (natural because rules appear in a natural way).

  ### Natural Deduction

  This is an extremely simple formalism, but it allows to do complicated tasks. The idea is that you have these rules, premises leading to conclusions. The specific rules are based on the idea that you can either **introduce** or **eliminate** connectives. We only consider the connectives $\wedge, \rightarrow \text { and } \perp$. There is no  $\vee$, because it has a quite different meaning in constructive and non-constructive approaches.

  This is still complete: limiting the connectives is not a limitation itself. The or is one of the major complications when moving from classical logic to intuitionistic logic: in the latter, the rule $A \vee \neg A = \text{true}$ is not valid.

  These 3 connectives allow us to define the **introduction rules**:
  $$
  (\wedge I) \quad \frac{\varphi \quad \psi}{\varphi \wedge \psi} \wedge I \\
  $$
  where $\frac{\varphi \quad \psi}{\varphi \wedge \psi}$ has the premise on the upper side and the conclusion on the lower side.

  What about the elimination of a connective, for example the conjunction?

  If we have the premise that $\varphi \wedge \psi$ holds, we know that $\varphi$ only holds and viceversa:
  $$
  (\wedge E) \quad \frac{\varphi \wedge \psi}{\varphi} \wedge E \quad \frac{\varphi \wedge \psi}{\psi} \wedge E
  $$
  If I have proved these, then I can prove the conjunction of them too:

  Note that $E$ stands for elimination, and $I$ for introduction.

  Now, we can eliminate an implication: if I have an implication $\varphi \rightarrow \psi$ and I have proof of $\varphi$ , I can derive the conclusion $\psi$:
  $$
  (\rightarrow E) \quad \frac{\varphi \quad \varphi \rightarrow \psi}{\psi} \rightarrow E
  $$
   *Elimination rules* means that we eliminate a connective, in this case the implication. 

  The difficult rule is the last one, the rule of implication introduction. It basically says: assume I have a formula $\varphi$, assuming that using some other *derivation steps* (i.e. application of rules), and I have reached the proof of $\psi$, using the implication introduction rule I can introduce the formula $\varphi \rightarrow \psi$ and I **discard the hypothesis**. What does *discard the hypothesis* mean? Suppose we want to get the deduction of *a triangle has two equal sides, then the two angles are equal*. In order for the theorem to be true, do we need the assumption? Not anymore: the assumption is contained in the theorem we obtain *if the sides are equal, the angles are too*. Here we are doing the same: assume that starting from $\varphi$ I reach $\psi$, then I have proved that $\varphi \rightarrow \psi$ is false, because this assumption is not needed anymore, I can prove that without any assumption.
  
  $$
  (\rightarrow I) \quad \dfrac{\begin{array}{c} [\varphi] \\ \vdots \\ \psi \end{array}}{\varphi \rightarrow \psi} \rightarrow I
  $$

  What we're saying is that we start with an assumption and reach a conclusion, then I can introduce the implication and while doing so I can delete the assumption itself: it won't be needed anymore, as it is contained in the implication. If starting from *if it's raining* I can derive that *I have to take the umbrella*, I can state *If it's raining I have to take the umbrella*, then I can remove the assumption that *It is raining*.

  ### Two more rules

  These ruels concern the use of negation ($\neg$) and false ($\bot$). If at a certain point in your derivation, you get to a premise which is false, than you can conclude that any possible formula can be derived from false:
  $$
  (\perp) \frac{\perp}{\varphi} \perp
  $$
  Remember that the *fraction* is composed of a premise and a conclusion.

  The other rule is the *reduction ad absurdum*: suppose that you start from a formula $\neg \varphi$ (forget about the square brackets), then you perform some kind of derivation, then you can derive false and conclude that $\varphi$ and you discard the hypothesis $\neg \varphi$, which means that you have proved $\varphi$ without any assumption. This is exactly the way you perform proof by reductio ad absurdo in all sciences: you want to prove that something holds, you start with a negation of it (*assume that $\varphi$ doesn't hold*), and reach a contradiction: this means that $\varphi$ was true.
  $$
  \begin{array}{l}
  {[\neg \varphi]} \\
  \vdots \\
  \frac{\perp}{\varphi} \mathrm{RAA}
  \end{array}
  $$
  Note that the symbols that surround the definition are just there to *name* the rules, they don't serve a purpose.

  Note that only the latter allows us to discard the hypothesis.

  ## Derivations

  Reminding that $PROP$ being the set of all propositional formulas (defined in the inductive way too), we want to define all the possible derivations: reasoning by induction, a single formula is a tree, if I have two trees I can compose them to construct a bigger tree. I can repeat this process for all the possible trees.

  ### Completeness theorem

  Having seen the notion $\Gamma \vDash \varphi$ , $\Gamma \vdash \varphi$  means that you can find a derivation (and therefore a derivation tree) that, starting from the hypothesis contained in $\Gamma$, allows you to derive the conclusion. If the set of $\Gamma$ is the empty set (i.e. all the assumptions have been canceled), then we can say that $\varphi$ is a **theorem**.

  One can observe that the notion of derivability and the notion of truth coincide, i.e. the following holds:
  $$
  \Gamma \vdash \varphi \Leftrightarrow \Gamma \vDash \varphi
  $$
  This gets us a **corollary too**: the set of theorems coincide with the set of tautologies.

  The theorem is derived in two parts, the **soundness** (correctness), which says that if you can perform a derivation, then $\Gamma \vdash \varphi \rightarrow \Gamma \vDash \varphi$. The inverse is provable too: $\Gamma \vDash \varphi\rightarrow\Gamma \vdash \varphi$. 

  If a set of formulas $\Gamma$ is inconsistent (i.e. you can derive false), then you can divide it into two parts $\Gamma \cup \neg\varphi$ and $\Gamma \cup \varphi$...

  If something cannot be derived, that is not a logical consequence.

   # Resolution for propositional logic

  First of all, summarising what we've seen: if a logic can be considered as a *formal system* it consists in 3 components, syntax (i.e. the set of rules which allow us to specify how expression are constructed), semantics (i.e. specifies the meanings of expressions) and calculus.

  **Axioms** are given formulas , elementary tautologies and contradictions which cannot be derived within the calculus. A **derivation** $\phi\vdash\psi$ is the sequence of inference rule applications starting from formula $\phi$ and ending with formula $\psi$.

  An inference rule has the form
  $$
  \frac{F_1,\dots,F_n}{F}
  $$
  where the formulae $F_1,\dots,F_n$ are the premises, and $F$ is the conclusion. Given a set of formulae $X$, if the premises are given (i.e. $I$ contained in $X$), then the conclusion is added to $X$.

  A derivation step is the application of an inference rules: $F_1,\dots,F_n \vdash F$.

  A derivation is just a sequence of derivation steps where the conclusion is taken as premises for the next step. A set of derivations can be represented by derivation trees.

  ## Resolution

  This was invented by Robinson in 1965. The idea was to try and find the set of inference rules which would be easier to use with machines. The idea is to work with contradictions.

  # First order logic

  Why do we need another, complicated, logic? The fact is that propositional logic is nice about lots of things, but it's too simple: it doesn't allow structures, no reasoning about specific object in specific domains. E.g. *every man is mortal, Socrate is a man, Socrate is mortal*. If you try to express this in propositional logic, you can't derive it. 

  We now have $\mathcal{P}$ predicate symbols, $\mathcal{F}$ function symbols, $\mathcal{V}$ a countably infinite set of variables.

  Then, as logic symbols, we have the truth symbols, the logical connectives, the quantors and syntactic symbols.

  A set of terms $\mathcal{T}(\Sigma, \mathcal{V})$ is a variable from $\mathcal{V}$ and a function term $f(\overline{t})$ where $f$ is an n-ary function symbol from $\Sigma$ and arguments $t$ are terms.

  We can define a set of well-formed formulae $\mathcal{F}(\Sigma,\mathcal{V})=(A,B,C...)$:

  -  an atomic formula (constructed with $p$ and n-ary predicate symbol from $\Sigma$ and arity $n$, $p(t_1,...,t_n)$ where the $t$s are terms.
  - 

  

  ## Resources

- [List of logic symbols for LaTeX](https://en.wikipedia.org/wiki/List_of_logic_symbols)

