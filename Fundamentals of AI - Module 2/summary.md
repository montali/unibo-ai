# Summary of FAIKR module 2 

## Knowledge Representation Languages

### First Order Logic (*FOL*)

Also known as Predicate Calculus, it can be considered a standard for knowledge representation.

Syntax:

- An infinite set of object constants.
- An infinite set of variables.
- An infinite set of functional symbols of all arities.
- An infinite set of predicates symbols of all arities.
- Connectives: $\land, \lor, \rightarrow, \neg$
- Quantifiers: $\forall, \exists$

### Description Logic (*DL*)

Notations that are designed to describe definitions and properties of categories, formalizing what a semantic network means and studying the reasoning mechanisms.

A DL knowledge base is composed by a ***TBox*** (a set of "schema" axioms) and an ***ABox*** (a set of "data" axioms, or ground facts).

#### Attributive Language (*AL*)

It does not support disjunction and provides limited forms of negation and existential quantifier only.
The syntax is composed by

- Atomic concepts
- Roles (relationships)
- Individuals (nominals)
- Boolean operators
  - Conjunction $\sqcap$
  - Disjunction $\sqcup$
  - Negation $\neg$, applicable only to atomic concepts
- Restricted quantifiers: $\exists, \forall$
- Universal and bottom concepts ($\top,\bot$)
- Value restriction
  - Universal restriction $\forall R.C$
  - Existential restriction $\exists R.C$
- Concept subsumption ($\sqsubset, \sqsubseteq, \sqsupset, \sqsupseteq$)
- Concept equivalence ($\equiv$)

##### AL extensions

- Attributive Language with Complements (***ALC***): AL extension where, unlike AL, the complement of any concept is allowed (e.g. $\neg(A\sqcup\exists R.(\forall S.B \sqcap\neg A))$ ), not only the complement of atomic concepts.

- Attributive Language with role Hierarchy (***ALH***): AL extension where it is possible to have role hierarchy (e.g. $\text{hasDaughter} \sqsubseteq \text{hasChild}$ ).

- Attributive Language with Inverse roles (***ALI***): AL extension where it is possible to use qualified number restrictions (e.g. $inverse(\text{hasSister},\text{sisterOf})$ ).

- Attributive Language with Number restrictions (***ALN***): AL extension where it is possible to use number restrictions without qualification (e.g. $\le 2 \ \text{hasChild}.\top$ ).

- Attributive language with Nominal/Singleton classes (**ALO**).

- Attributive Language with Qualified number restrictions (**ALQ**): AL extension where it is possible to use number restrictions with qualification (e.g. $\le 2 \ \text{hasChild}.\text{Female}$ ).

  

Extensions can be combined, for example creating ***ALCN***, but each extension increases computational cost.
