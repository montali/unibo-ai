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

  ![Truth table](file:///Users/simone/UniBO/unibo-ai/Languages%20and%20Algorithms%20for%20AI/res/truth_table.png?lastModify=1604312935)

  ## Model

  The notion of **model** is important. We can say that an interpretation  is a model of the formula  written  if  is true when the truth value of propositional symbols is defined according to .

  Note that it is the same symbol we're using for logical consequence.

  A **valid formula** is true, no matter the interpretation. A valid formula is also called a **Tautology**.

  For example: .

  If  is valid, we can write .

  For example, we prove the *deMorgan's Law*:

  ![de Morgan's Law](file:///Users/simone/UniBO/unibo-ai/Languages%20and%20Algorithms%20for%20AI/res/deMorgans_law.png?lastModify=1604312935)

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

  ![Equivalence rules](file:///Users/simone/UniBO/unibo-ai/Languages%20and%20Algorithms%20for%20AI/res/equivalence.png?lastModify=1604312935)

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

  We want to be able to derive <img src="svgs/b8bc815b5e9d5177af01fd4d3d3c2f10.svg?invert_in_darkmode" align=middle width=12.85392569999999pt height=22.465723500000017pt/> from <img src="svgs/b2af456716f3117a91da7afe70758041.svg?invert_in_darkmode" align=middle width=10.274003849999989pt height=22.465723500000017pt/>. We are interested in logical consequences, which allow us to derive conclusions about truth in specific worlds described by specific axioms, and we want to prove them by using syntax, i.e. syntactic manipulation of the symbols which appear in the formulas. 

  All the rules have the general idea that **given a set of premises**, you get a **conclusion**. 

  We'll see one of the systems for propositional logic, called **natural deduction** (natural because rules appear in a natural way).

  ### Natural Deduction

  This is an extremely simple formalism, but it allows to do complicated tasks. The idea is that you have these rules, premises leading to conclusions. The specific rules are based on the idea that you can either **introduce** or **eliminate** connectives. We only consider the connectives <img src="svgs/47d9c4fd1deb4afc4969558d2d0fa3e6.svg?invert_in_darkmode" align=middle width=94.06384349999998pt height=22.831056599999986pt/>. There is no  <img src="svgs/fd925eff76f375c2bf103304b13a5b35.svg?invert_in_darkmode" align=middle width=10.95894029999999pt height=18.264896099999987pt/>, because it has a quite different meaning in constructive and non-constructive approaches.

  This is still complete: limiting the connectives is not a limitation itself. The or is one of the major complications when moving from classical logic to intuitionistic logic: in the latter, the rule <img src="svgs/b546af1cb1548941e23cb36c264ccf76.svg?invert_in_darkmode" align=middle width=105.06836999999997pt height=22.465723500000017pt/> is not valid.

  These 3 connectives allow us to define the **introduction rules**:
  <p align="center"><img src="svgs/f42e6bb397f0e5eca4014c7223c46b8d.svg?invert_in_darkmode" align=middle width=103.30193114999999pt height=37.0084374pt/></p>
  where <img src="svgs/a812d3a7f0501c27242993b0fcbffb77.svg?invert_in_darkmode" align=middle width=34.1961081pt height=30.648287999999997pt/> has the premise on the upper side and the conclusion on the lower side.

  What about the elimination of a connective, for example the conjunction?

  If we have the premise that <img src="svgs/3be825bbaf86027bd3eeab25d75f8544.svg?invert_in_darkmode" align=middle width=40.31573864999999pt height=22.831056599999986pt/> holds, we know that <img src="svgs/417a5301693b60807fa658e5ef9f9535.svg?invert_in_darkmode" align=middle width=10.75343279999999pt height=14.15524440000002pt/> only holds and viceversa:
  <p align="center"><img src="svgs/b3f06fdcce21214c3aeb341639f3f8d5.svg?invert_in_darkmode" align=middle width=220.918896pt height=37.0084374pt/></p>
  If I have proved these, then I can prove the conjunction of them too:

  Note that <img src="svgs/84df98c65d88c6adf15d4645ffa25e47.svg?invert_in_darkmode" align=middle width=13.08219659999999pt height=22.465723500000017pt/> stands for elimination, and <img src="svgs/21fd4e8eecd6bdf1a4d3d6bd1fb8d733.svg?invert_in_darkmode" align=middle width=8.515988249999989pt height=22.465723500000017pt/> for introduction.

  Now, we can eliminate an implication: if I have an implication <img src="svgs/05c18f81fe556aca8d688971df554168.svg?invert_in_darkmode" align=middle width=47.62164164999999pt height=22.831056599999986pt/> and I have proof of <img src="svgs/417a5301693b60807fa658e5ef9f9535.svg?invert_in_darkmode" align=middle width=10.75343279999999pt height=14.15524440000002pt/> , I can derive the conclusion <img src="svgs/7e3c241c2dec821bd6c6fbd314fe4762.svg?invert_in_darkmode" align=middle width=11.29760774999999pt height=22.831056599999986pt/>:
  <p align="center"><img src="svgs/8e67c729bf5718bfea593b207c1838d0.svg?invert_in_darkmode" align=middle width=164.28351225pt height=37.0084374pt/></p>
   *Elimination rules* means that we eliminate a connective, in this case the implication. 

  The difficult rule is the last one, the rule of implication introduction. It basically says: assume I have a formula <img src="svgs/417a5301693b60807fa658e5ef9f9535.svg?invert_in_darkmode" align=middle width=10.75343279999999pt height=14.15524440000002pt/>, assuming that using some other *derivation steps* (i.e. application of rules), and I have reached the proof of <img src="svgs/7e3c241c2dec821bd6c6fbd314fe4762.svg?invert_in_darkmode" align=middle width=11.29760774999999pt height=22.831056599999986pt/>, using the implication introduction rule I can introduce the formula <img src="svgs/05c18f81fe556aca8d688971df554168.svg?invert_in_darkmode" align=middle width=47.62164164999999pt height=22.831056599999986pt/> and I **discard the hypothesis**. What does *discard the hypothesis* mean? Suppose we want to get the deduction of *a triangle has two equal sides, then the two angles are equal*. In order for the theorem to be true, do we need the assumption? Not anymore: the assumption is contained in the theorem we obtain *if the sides are equal, the angles are too*. Here we are doing the same: assume that starting from <img src="svgs/417a5301693b60807fa658e5ef9f9535.svg?invert_in_darkmode" align=middle width=10.75343279999999pt height=14.15524440000002pt/> I reach <img src="svgs/7e3c241c2dec821bd6c6fbd314fe4762.svg?invert_in_darkmode" align=middle width=11.29760774999999pt height=22.831056599999986pt/>, then I have proved that <img src="svgs/05c18f81fe556aca8d688971df554168.svg?invert_in_darkmode" align=middle width=47.62164164999999pt height=22.831056599999986pt/> is false, because this assumption is not needed anymore, I can prove that without any assumption.

  <img src="https://cdn.mathpix.com/snip/images/AXjJg1OhwP-6g-DnMH48EWGsYBK9t6h_5WjNYoJzBnc.original.fullsize.png" />

  What we're saying is that we start with an assumption and reach a conclusion, then I can introduce the implication and while doing so I can delete the assumption itself: it won't be needed anymore, as it is contained in the implication. If starting from *if it's raining* I can derive that *I have to take the umbrella*, I can state *If it's raining I have to take the umbrella*, then I can remove the assumption that *It is raining*.

  ### Two more rules

  These ruels concern the use of negation (<img src="svgs/23bf728170c10d0449b90561f827623a.svg?invert_in_darkmode" align=middle width=10.95894029999999pt height=14.15524440000002pt/>) and false (<img src="svgs/6fc05ced17ac7d77ba19372f815467dd.svg?invert_in_darkmode" align=middle width=12.785434199999989pt height=22.831056599999986pt/>). If at a certain point in your derivation, you get to a premise which is false, than you can conclude that any possible formula can be derived from false:
  <p align="center"><img src="svgs/2673d374e80d02bf3d9fea35b9f522f5.svg?invert_in_darkmode" align=middle width=59.653020899999994pt height=37.0084374pt/></p>
  Remember that the *fraction* is composed of a premise and a conclusion.

  The other rule is the *reduction ad absurdum*: suppose that you start from a formula <img src="svgs/127bde3d2d1ad2be6040ddcfb0ac2729.svg?invert_in_darkmode" align=middle width=21.71237309999999pt height=14.15524440000002pt/> (forget about the square brackets), then you perform some kind of derivation, then you can derive false and conclude that <img src="svgs/417a5301693b60807fa658e5ef9f9535.svg?invert_in_darkmode" align=middle width=10.75343279999999pt height=14.15524440000002pt/> and you discard the hypothesis <img src="svgs/127bde3d2d1ad2be6040ddcfb0ac2729.svg?invert_in_darkmode" align=middle width=21.71237309999999pt height=14.15524440000002pt/>, which means that you have proved <img src="svgs/417a5301693b60807fa658e5ef9f9535.svg?invert_in_darkmode" align=middle width=10.75343279999999pt height=14.15524440000002pt/> without any assumption. This is exactly the way you perform proof by reductio ad absurdo in all sciences: you want to prove that something holds, you start with a negation of it (*assume that <img src="svgs/417a5301693b60807fa658e5ef9f9535.svg?invert_in_darkmode" align=middle width=10.75343279999999pt height=14.15524440000002pt/> doesn't hold*), and reach a contradiction: this means that <img src="svgs/417a5301693b60807fa658e5ef9f9535.svg?invert_in_darkmode" align=middle width=10.75343279999999pt height=14.15524440000002pt/> was true.
  <p align="center"><img src="svgs/7e9d8ec72e7559a087e9fa53a99408f1.svg?invert_in_darkmode" align=middle width=50.9772714pt height=71.28252945pt/></p>
  Note that the symbols that surround the definition are just there to *name* the rules, they don't serve a purpose.

  Note that only the latter allows us to discard the hypothesis.

  ## Derivations

  Reminding that <img src="svgs/2e1334206c2263ea2cb848279cd14079.svg?invert_in_darkmode" align=middle width=51.27744104999999pt height=22.465723500000017pt/> being the set of all propositional formulas (defined in the inductive way too), we want to define all the possible derivations: reasoning by induction, a single formula is a tree, if I have two trees I can compose them to construct a bigger tree. I can repeat this process for all the possible trees.

  ### Completeness theorem

  Having seen the notion <img src="svgs/ca0911a969eefcb030ad11abd77cf481.svg?invert_in_darkmode" align=middle width=40.20532064999998pt height=22.758598499999987pt/> , <img src="svgs/8e606bf4edcf58fd4b6202991dd5d19f.svg?invert_in_darkmode" align=middle width=40.20532064999998pt height=22.831056599999986pt/>  means that you can find a derivation (and therefore a derivation tree) that, starting from the hypothesis contained in <img src="svgs/b2af456716f3117a91da7afe70758041.svg?invert_in_darkmode" align=middle width=10.274003849999989pt height=22.465723500000017pt/>, allows you to derive the conclusion. If the set of <img src="svgs/b2af456716f3117a91da7afe70758041.svg?invert_in_darkmode" align=middle width=10.274003849999989pt height=22.465723500000017pt/> is the empty set (i.e. all the assumptions have been canceled), then we can say that <img src="svgs/417a5301693b60807fa658e5ef9f9535.svg?invert_in_darkmode" align=middle width=10.75343279999999pt height=14.15524440000002pt/> is a **theorem**.

  One can observe that the notion of derivability and the notion of truth coincide, i.e. the following holds:
  <p align="center"><img src="svgs/ccd8cbb06632a69a984d0753f4169897.svg?invert_in_darkmode" align=middle width=105.98124074999998pt height=14.611878599999999pt/></p>
  This gets us a **corollary too**: the set of theorems coincide with the set of tautologies.

  The theorem is derived in two parts, the **soundness** (correctness), which says that if you can perform a derivation, then <img src="svgs/d977a3b05f22573feceb3d445ba75299.svg?invert_in_darkmode" align=middle width=105.98124239999999pt height=22.831056599999986pt/>. The inverse is provable too: <img src="svgs/6a0e5bb4be20e3dde7abbd55b2db5e3f.svg?invert_in_darkmode" align=middle width=105.98124239999999pt height=22.831056599999986pt/>. 

  If a set of formulas <img src="svgs/b2af456716f3117a91da7afe70758041.svg?invert_in_darkmode" align=middle width=10.274003849999989pt height=22.465723500000017pt/> is inconsistent (i.e. you can derive false), then you can divide it into two parts <img src="svgs/f3a26a8545f8b6780d9c3b62b61733fd.svg?invert_in_darkmode" align=middle width=50.25107669999999pt height=22.465723500000017pt/> and <img src="svgs/2cbce50dee7704503243016eb402064b.svg?invert_in_darkmode" align=middle width=39.29213474999999pt height=22.465723500000017pt/>...

  If something cannot be derived, that is not a logical consequence.

   # Resolution for propositional logic

  First of all, summarising what we've seen: if a logic can be considered as a *formal system* it consists in 3 components, syntax (i.e. the set of rules which allow us to specify how expression are constructed), semantics (i.e. specifies the meanings of expressions) and calculus.

  **Axioms** are given formulas , elementary tautologies and contradictions which cannot be derived within the calculus. A **derivation** <img src="svgs/f1880a0fe6ac5dc59d8fe1d1215ac54d.svg?invert_in_darkmode" align=middle width=40.27003529999999pt height=22.831056599999986pt/> is the sequence of inference rule applications starting from formula <img src="svgs/f50853d41be7d55874e952eb0d80c53e.svg?invert_in_darkmode" align=middle width=9.794543549999991pt height=22.831056599999986pt/> and ending with formula <img src="svgs/7e3c241c2dec821bd6c6fbd314fe4762.svg?invert_in_darkmode" align=middle width=11.29760774999999pt height=22.831056599999986pt/>.

  An inference rule has the form
  <p align="center"><img src="svgs/d7b67ab5889e11322b0300d3ce6e2648.svg?invert_in_darkmode" align=middle width=73.9933722pt height=33.62942055pt/></p>
  where the formulae <img src="svgs/252db897805def69d9476e5b5a76c4ac.svg?invert_in_darkmode" align=middle width=73.171494pt height=22.465723500000017pt/> are the premises, and <img src="svgs/b8bc815b5e9d5177af01fd4d3d3c2f10.svg?invert_in_darkmode" align=middle width=12.85392569999999pt height=22.465723500000017pt/> is the conclusion. Given a set of formulae <img src="svgs/cbfb1b2a33b28eab8a3e59464768e810.svg?invert_in_darkmode" align=middle width=14.908688849999992pt height=22.465723500000017pt/>, if the premises are given (i.e. <img src="svgs/21fd4e8eecd6bdf1a4d3d6bd1fb8d733.svg?invert_in_darkmode" align=middle width=8.515988249999989pt height=22.465723500000017pt/> contained in <img src="svgs/cbfb1b2a33b28eab8a3e59464768e810.svg?invert_in_darkmode" align=middle width=14.908688849999992pt height=22.465723500000017pt/>), then the conclusion is added to <img src="svgs/cbfb1b2a33b28eab8a3e59464768e810.svg?invert_in_darkmode" align=middle width=14.908688849999992pt height=22.465723500000017pt/>.

  A derivation step is the application of an inference rules: <img src="svgs/04232136c4cb89614df62eea645761ca.svg?invert_in_darkmode" align=middle width=106.02521819999998pt height=22.831056599999986pt/>.

  A derivation is just a sequence of derivation steps where the conclusion is taken as premises for the next step. A set of derivations can be represented by derivation trees.

  ## Resolution

  This was invented by Robinson in 1965. The idea was to try and find the set of inference rules which would be easier to use with machines. The idea is to work with contradictions.

  # First order logic

  Why do we need another, complicated, logic? The fact is that propositional logic is nice about lots of things, but it's too simple: it doesn't allow structures, no reasoning about specific object in specific domains. E.g. *every man is mortal, Socrate is a man, Socrate is mortal*. If you try to express this in propositional logic, you can't derive it. 

  We now have <img src="svgs/03c54486f0c18b8e265a9c922d83ad33.svg?invert_in_darkmode" align=middle width=12.78544904999999pt height=22.465723500000017pt/> predicate symbols, <img src="svgs/84cc939597f3eec200843a2fc8830732.svg?invert_in_darkmode" align=middle width=13.447466999999989pt height=22.465723500000017pt/> function symbols, <img src="svgs/76105ebc974ce8a02de91bcaf0d6d25f.svg?invert_in_darkmode" align=middle width=11.424730349999988pt height=22.465723500000017pt/> a countably infinite set of variables.

  Then, as logic symbols, we have the truth symbols, the logical connectives, the quantors and syntactic symbols.

  A set of terms <img src="svgs/e170e1cca0005f6e4238b82ae55d22c2.svg?invert_in_darkmode" align=middle width=56.51937554999999pt height=24.65753399999998pt/> is a variable from <img src="svgs/76105ebc974ce8a02de91bcaf0d6d25f.svg?invert_in_darkmode" align=middle width=11.424730349999988pt height=22.465723500000017pt/> and a function term <img src="svgs/ff35acb96f985564864b679072cc2665.svg?invert_in_darkmode" align=middle width=28.538924699999992pt height=25.481758500000016pt/> where <img src="svgs/190083ef7a1625fbc75f243cffb9c96d.svg?invert_in_darkmode" align=middle width=9.81741584999999pt height=22.831056599999986pt/> is an n-ary function symbol from <img src="svgs/813cd865c037c89fcdc609b25c465a05.svg?invert_in_darkmode" align=middle width=11.87217899999999pt height=22.465723500000017pt/> and arguments <img src="svgs/4f4f4e395762a3af4575de74c019ebb5.svg?invert_in_darkmode" align=middle width=5.936097749999991pt height=20.221802699999984pt/> are terms.

  We can define a set of well-formed formulae <img src="svgs/0887a8cbf5c75ad0d58b14d1679e5d55.svg?invert_in_darkmode" align=middle width=157.48278315pt height=24.65753399999998pt/>:

  -  an atomic formula (constructed with <img src="svgs/2ec6e630f199f589a2402fdf3e0289d5.svg?invert_in_darkmode" align=middle width=8.270567249999992pt height=14.15524440000002pt/> and n-ary predicate symbol from <img src="svgs/813cd865c037c89fcdc609b25c465a05.svg?invert_in_darkmode" align=middle width=11.87217899999999pt height=22.465723500000017pt/> and arity <img src="svgs/55a049b8f161ae7cfeb0197d75aff967.svg?invert_in_darkmode" align=middle width=9.86687624999999pt height=14.15524440000002pt/>, <img src="svgs/1f22ccc3f2b4c20e0139b41a1466bd16.svg?invert_in_darkmode" align=middle width=77.56103024999999pt height=24.65753399999998pt/> where the <img src="svgs/4f4f4e395762a3af4575de74c019ebb5.svg?invert_in_darkmode" align=middle width=5.936097749999991pt height=20.221802699999984pt/>s are terms.
  - 

  

  ## Resources

- [List of logic symbols for LaTeX](https://en.wikipedia.org/wiki/List_of_logic_symbols)

