# Summary of FAIKR module 2 

## Knowledge Representation Languages

### First Order Logic (*FOL*)

Also known as Predicate Calculus, it can be considered a standard for knowledge representation.

Syntax:

- An infinite set of object constants.
- An infinite set of variables.
- An infinite set of functional symbols of all arities.
- An infinite set of predicates symbols of all arities.
- Connectives: <img src="svgs/f4ac2a9bfb464ea0f19dccc459ef546c.svg?invert_in_darkmode" align=middle width=71.23287434999999pt height=18.264896099999987pt/>
- Quantifiers: <img src="svgs/58948550348485a5775e8d8a05ac742b.svg?invert_in_darkmode" align=middle width=25.57077929999999pt height=22.831056599999986pt/>

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
  - Restricted quantifiers: <img src="svgs/b4c5b626a225ce855a9e41a4287d3cc5.svg?invert_in_darkmode" align=middle width=25.57077929999999pt height=22.831056599999986pt/>
  - Universal and bottom concepts (<img src="svgs/b37a16d4b12caeff164d04ba28599132.svg?invert_in_darkmode" align=middle width=32.87674994999999pt height=22.831056599999986pt/>)
  - Value restriction
    - Universal restriction $\forall R.C$
    - Existential restriction $\exists R.C$
  - Concept subsumption (<img src="svgs/425e4da138ab8b67e31ea86f4f9a6c1e.svg?invert_in_darkmode" align=middle width=73.05938309999999pt height=20.908638300000003pt/>)
  - Concept equivalence (<img src="svgs/ebf45b23c8b2fe7cb8bf20cb8bbd565d.svg?invert_in_darkmode" align=middle width=12.785434199999989pt height=15.24650820000002pt/>)

##### Attributive Language with Complements (*ALC*)
AL extension where, unlike AL, the complement of any concept is allowed, not only the complement of atomic concepts.

##### Attributive Language with Number restrictions (*ALN*)
AL extension where it is possible to use qualified number restrictions.

Extensions can be combined, for example creating ***ALCN***, but each extension increases computational cost.
