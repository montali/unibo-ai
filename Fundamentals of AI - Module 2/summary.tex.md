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
- Quantifiers: $\forall, \exist$

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
  - Restricted quantifiers: $\exist, \forall$
  - Universal and bottom concepts ($\top,\bot$)
  - Value restriction
    - Universal restriction $\forall R.C$
    - Existential restriction $\exist R.C$
  - Concept subsumption ($\sqsubset, \sqsubseteq, \sqsupset, \sqsupseteq$)
  - Concept equivalence ($\equiv$)

##### Attributive Language with Complements (*ALC*)
AL extension where, unlike AL, the complement of any concept is allowed, not only the complement of atomic concepts.

##### Attributive Language with Number restrictions (*ALN*)
AL extension where it is possible to use qualified number restrictions.

Extensions can be combined, for example creating ***ALCN***, but each extension increases computational cost.
