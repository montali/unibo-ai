# Exams

## FAI2 - 16/06/2020

$\exists X.stays\_home(X)$

$\exists X.(works\_from\_home(X))$

$\exists X.limits\_contact(X)$

$\exists X.(\forall Y contact(X,Y) \rightarrow min\_distance(X,Y,2))$

$\exists X.(\forall Y.(live\_together(X,Y) \wedge has\_symptoms(Y)) \rightarrow not\_leave(X))$

$\exists X.washes\_hands(X)$

$\forall X.(stays\_home(X) \wedge works\_from\_home(X) \wedge limits\_contact(X)\wedge \\(\forall Y contact(X,Y) \rightarrow min\_distance(X,Y,2)) \wedge \\(\forall Y.(live\_together(X,Y) \wedge has\_symptoms(Y)) \rightarrow not\_leave(X))\\ \wedge washes\_hands(X)) \rightarrow safe(X)$

$\forall(X).(\neg safe(X) \rightarrow not\_safe(X))$

$\forall(X).(not\_safe(X) \rightarrow might\_die(X))$

$\forall X,Y(not\_safe(X) \wedge not\_safe(Y) \wedge infected(X) \rightarrow might\_transmit\_virus(X,Y))$

$\exists X.(not\_safe(X) \rightarrow died(X))$

$stays\_home(simmy)$.

### Query

$?-\exist X.(might\_transmit\_virus(simmy, X))$

### ALC

$$

## FAI2 - 07/07/2020

### First Order Logic

$\forall X.bus(x) \rightarrow (\exists Y.wheels(X, Y)\wedge Y>3) \wedge powered(X, engine)$

$\forall X.car(X) \rightarrow wheels(X,4) \wedge powered(X, engine)$

$\forall X.bike(X) \rightarrow wheels(X,2) \wedge powered(X, human)$

$\forall X.ebike(X) \leftrightarrow bike(X) \wedge powered(X, engine)$

$\forall(Y).Drives(X, Y) \wedge car(Y) \rightarrow HasLicense(X,B) \wedge adult(X)$

$\forall(X).Drives(X, Y) \wedge bus(Y) \rightarrow HasLicense(X,C) \wedge adult(X)$

$\forall X.HasLicense(X,C) \rightarrow HasLicense(X,B)$

$\forall X.drives(X, Y) \wedge bike(Y) \rightarrow person(X)$

$\exists X,Y,T,Z.(drives(X,T) \wedge drives(Y,Z) \wedge X \neq Y \wedge T \neq Z)$

$?- \exists X.(drives(driver1, X) \wedge \neg drives(driver2, X))$

### ALC

$Bus \sqsubseteq (\ge 4 hasComponent.wheel\sqcap poweredBy.engine)$

$Car \sqsubseteq (\ge 4 hasComponent.wheel \sqcap \le 4 hasComponent.wheel \sqcap \exists poweredBy.engine)$

$Bike \sqsubseteq (\ge 2 hasComponent.wheel \sqcap \le 2 hasComponent.wheel \sqcap \exists poweredBy.human)$

$eBike \sqsubseteq (\ge 2 hasComponent.wheel \sqcap \le 2 hasComponent.wheel \sqcap \exists poweredBy.human \sqcap \exists poweredBy.engine)$

$CarDriver \sqsubseteq (Adult \sqcap \exist hasLicense.BLicense)$

$CarDriver \equiv Adult \sqcap \exist Drives.Car$

$BusDriver \equiv Adult \sqcap \exist Drives.Bus$

$BikeDriver \equiv Adult \sqcap \exists Drives.Bus$

$BusDriver \sqsubseteq (Adult \sqcap \exist hasLicense.CLicense)$

$CLicense \sqsubseteq BLicense$

$BikeDriver \sqsubseteq Person$

$Vehicle \equiv Bus \sqcup Car \sqcup Bike \sqcup eBike$

The *There are different type of drivers is already encoded in the fact that $CarDriver$* and $BusDriver$ are two different entities.

$hasLicense(driver1, X) \wedge hasLicense(driver2, Y) \wedge (X\sqsubseteq Y)$

## FAI2 - 10/6/2021

We can define a $contains(molecule, element,quantity, ion)$ predicate that states that some element in contained in a molecule with given quantity and ionization (for for neutral). For example, $H_2O$ would be encoded as

$contains(h2o, h, 2, 0) \wedge contains(h2o, o, 1, 0)$.

Then, we can encode possible reactions in our becher as implications:

$becher\_contains(h2) \wedge becher\_contains(o) \rightarrow becher\_contains(h2o)$

### Query

$\exist X,Y,I.contains(h2o, X, Y,I)$ and continue iterating to find them all, which is something we could do in Prolog with a `findall([X,Y,I], contains(h2o, X, Y, I), R)`.

### ALC

$Molecule\sqsubseteq \exist contains.Element$

$Molecule \sqsubseteq \exists hasFormula.Formula$

$Formula \sqsubseteq String$

$Ion \equiv (Atom \sqcap ((\exists hasIonization.PositiveIonization) \sqcup (\exists hasIonization.NegativeIonization)))$

$Atom \sqsubseteq isComposedOf.Element$

$Ion \sqsubseteq Atom$

$Element \sqsubseteq Molecule$ An element can be considered as a single molecule?

$ChemicalReaction \sqsubseteq \ge 2 hasReactants.Molecule$

$ChemicalReaction \sqsubseteq \exists hasProducts.Molecule$

### Query

$q(x) \leftarrow isComposedOf(querymolecule, x)$

# Exercise sheet

## Exercise 1

_Build a knowledge base in which the following knowledge is represented: Father, Mother, GrandMother, GrandFather, Aunt, Uncle, Niece, Nephew, Mother of at least 3 sons, Father of at most 2 Daugthers._

### First Order Logic

$$
parent(Fabrizio, Simone)\\
parent(Rossella, Simone)\\
woman(Rossella)\\
man(Fabrizio)\\
parent(X,Y) \wedge man(X) \rightarrow father(X, Y)\\
parent(X,Y) \wedge woman(X) \rightarrow mother(X, Y)\\
parent(X,Y) \wedge parent(Y,Z) \wedge woman(X) \rightarrow grandmother(X,Z)\\
parent(X,Y) \wedge sister(Z,Y) \rightarrow aunt(Z,X)\\
parent(X,Y) \wedge brother(Z,Y) \rightarrow uncle(Z,X)\\
sibling(X,Y) \wedge man(X) \rightarrow brother(X,Y)\\
sibling(X,Y) \wedge woman(X) \rightarrow sister(X,Y)\\
(uncle(X,Z) \vee aunt(X,Z)) \wedge woman(Z) \rightarrow niece(Z,X)\\
(uncle(X,Z) \vee aunt(X,Z)) \wedge man(Z) \rightarrow nephew(Z,X)\\
mother(X,A) \wedge mother(X,B) \wedge mother(X,C) \wedge (A\neq B\neq C)\wedge \\ man(A)\wedge man(B) \wedge man(C) \rightarrow mother_3(X)\\
father(X,A) \wedge father(X,B) \wedge (A\neq B)\wedge woman(A)\wedge woman(B) \rightarrow father_2(X)\\
$$


### ALC

$$
Father \equiv Parent \sqcap Man\\
Son \equiv (Man \sqcap\exist hasParent.Person)\\
Daughter \equiv (Woman \sqcap\exist hasParent.Person)\\
Mother \equiv Parent \sqcap Woman\\
GrandMother \equiv (Mother \sqcap\exist hasChild.Parent)\\
GrandFather \equiv (Father \sqcap\exist hasChild.Parent)\\
Aunt \equiv (Woman \sqcap\exist hasSibling.Parent)\\
Uncle \equiv (Man \sqcap\exist hasSibling.Parent)\\
Sibling \equiv (Brother \sqcup Sister)\\
Niece \equiv (Woman \sqcap\exist Parent.Sibling)\\
Nephew \equiv (Man \sqcap\exist Parent.Sibling)\\
Mother_3 \equiv (Woman \sqcap\ge 3 Son)\\
Father_2 \equiv (Man \sqcap \le 2 Daughter)
$$

## Exercise 2

_Build a knowledge base in which the following knowledge is represented: All humans are mammals; all mammals are warm blooded. All dogs are mammals. Humans own animals. There are animals that are not warm blooded. All mammals are animals. A human cannot own another human._

### First Order Logic

$$
human(X) \rightarrow mammal(X)\\
mammal(X)\rightarrow warmblooded(X)\\
dog(X) \rightarrow mammal(X)\\
own(X,Y) \rightarrow human(X), animal(Y)\\
\exist X.(animal(X) \wedge \neg warmblooded(X))\\
mammal(X) \rightarrow animal(X)\\
own(X,Y) \rightarrow human(X)\wedge \neg human(Y)
$$

### ALC

$$
Human \sqsubseteq Mammal \\
Mammal \sqsubseteq WarmBlooded\\
Dog \sqsubseteq Mammal\\
AnimalOwner \equiv Human \sqcap \exist owns.Animal\\
ColdBloodedAnimal \equiv Animal \sqcap \neg WarmBlooded\\
Mammal \sqsubseteq Animal\\
(Human \sqcap \exist owns.Human).\perp
$$
## Exercise 3

### First Order Logic

$student(X) \rightarrow smart(X)$

$\exists X.student(X)$

$\exists X.(student(X) \wedge smart(X))$

$\forall X\exists Y.(student(X) \wedge student(Y) \wedge loves(X,Y))$

$\forall X \exists Y . (student(X) \wedge student(Y) \wedge loves(X,Y)\wedge X\neq Y)$

$\exists X.(\forall Y.student(X) \wedge student(Y)\wedge loves(Y,X))$

$student(mark)$

$student(paul)$

$takes(mark, analysis) \leftrightarrow \neg takes(mark, geometry)$

$\neg takes(mark, analysis) \leftrightarrow takes(mark, geometry)$

$takes(paul, analysis) \wedge takes(paul, geometry)$

$\neg takes(mark, analysis)$

$\forall Y.(student(Y) \rightarrow \neg loves(Y, paul))$

### ALC

$Student \sqsubseteq Smart$

$SmartStudent \equiv Student \sqcap Smart$

$(Student \sqcap \exists loves.Student)\equiv Student$

Sentence 5 is not encodable in ALC (I think)

$Student \sqcap \forall loves.Student $

$Mark \sqsubseteq Student$

$Paul \sqsubseteq Student$

$Mark \sqsubseteq ((\exists takes.GeometryExam \sqcap \neg \exists takes.AnalysisExam) \sqcup$

$ (\exists takes.AnalysisExam \sqcap \neg \exists takes.GeometryExam))$

$Paul \sqsubseteq (\exist takes.GeometryExam \sqcap \exist takes.AnalysisExam)$

$Mark \sqsubseteq \neg \exists takes.AnalysisExam$

$(Student \sqcap \exist loves.Paul).\perp$



# Other exercises

_Not all students attend both the History and the Biology courses. The best mark in History is higher than the best mark in Biology. One only student did not pass the exam in History. One only student did not pass both the exam in History and the exam in Biology._

$\exists X.(attends(X, history) \wedge \neg attends(X, biology))$

$\forall X,Y.(best\_mark(history, X) \wedge best\_mark(biology, Y) \rightarrow (X>Y)$

$\forall X,Y.(\neg pass(X,history) \wedge \neg pass(Y,history) \rightarrow X=Y)$

$\forall X,Y.(\neg pass(X,history) \wedge \neg pass(Y,history) \wedge \neg pass(Y,biology)\wedge \neg pass(X,biology) \rightarrow X=Y)$

_Politicians always fool someone, and sometimes fool everyone, but they do not always fool everyone._

$\forall X.policitian(X) \exist Y.fools(X,Y)$

$\exists X.policitian(X)\wedge (\forall Y. fools(X,Y))$

$\neg (\forall X.politician(X) \rightarrow (\forall Y.fools(X,Y)))$

_Every person who does not like any vegetarian is intelligent. Nobody likes a vegetarian who is intelligent. There is a woman who likes every man who is not a vegetarian._

$\forall X,Y.(vegetarian(Y)\rightarrow not\_like(X,Y))\rightarrow intelligent(X)$

$\neg \exist X,Y.(likes(X,Y) \wedge vegetarian(Y) \wedge intelligent(Y))$

$\exists X.woman(X) (\forall Y (\neg vegetarian(Y) \wedge man(Y)) \rightarrow likes(X, Y))$

1. *(a) Tony, Mike and John are members of the Alpine Club* 
2. *(b) Every member of the Alpine Club is a skier or a climber*
3. *(c) No climber likes rain*
4. *(d) Every skier likes snow*
5. *(e) Mike does not like everything that Tony likes* 
6. *(f) Mike likes everything Tony does not like*
7. *(g) Tony likes both rain and snow*

$member(alpine, tony)$

$member(alpine, mike)$

$\forall x.member(alpine, x) \rightarrow (\neg skier(x) \wedge \neg climber(x))$

$\neg \exist x.(climber(x) \wedge likes(rain, x))$

$\forall x.skier(x)\rightarrow likes(snow, x)$

$\exists x.(likes(x, tony) \wedge likes(y,mike))$

$likes(rain, tony) \wedge likes(snow, tony)$

<img src="https://cdn.mathpix.com/snip/images/S65a7Tdupmb47mm88f2heU9MKKhmAHyhtw2iOdWkVzU.original.fullsize.png" />

