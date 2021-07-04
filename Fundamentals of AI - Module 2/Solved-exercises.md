## Exercise 1

_Build a knowledge base in which the following knowledge is represented: Father, Mother, GrandMother, GrandFather, Aunt, Uncle, Niece, Nephew, Mother of at least 3 sons, Father of at most 2 Daugthers._

### First Order Logic

<!-- $$
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
$$ -->

<div align="center"><img style="background: white;" src="../svg/vlxsRH1O9U.svg"></div>

### ALC

<!-- $$
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
$$ -->

<div align="center"><img style="background: white;" src="../svg/YC12c8NyKV.svg"></div>

## Exercise 2

_Build a knowledge base in which the following knowledge is represented: All humans are mammals; all mammals are warm blooded. All dogs are mammals. Humans own animals. There are animals that are not warm blooded. All mammals are animals. A human cannot own another human._

### First Order Logic

<!-- $$
human(X) \rightarrow mammal(X)\\
mammal(X)\rightarrow warmblooded(X)\\
dog(X) \rightarrow mammal(X)\\
own(X,Y) \rightarrow human(X), animal(Y)\\
\exist X.(animal(X) \wedge \neg warmblooded(X))\\
mammal(X) \rightarrow animal(X)\\
own(X,Y) \rightarrow human(X)\wedge \neg human(Y)
$$ -->

<div align="center"><img style="background: white;" src="../svg/aIzQqCiAQY.svg"></div>

### ALC

<!-- $$
Human \sqsubseteq Mammal \\
Mammal \sqsubseteq WarmBlooded\\
Dog \sqsubseteq Mammal\\
AnimalOwner \equiv Human \sqcap \exist owns.Animal\\
ColdBloodedAnimal \equiv Animal \sqcap \neg WarmBlooded\\
Mammal \sqsubseteq Animal\\
(Human \sqcap \exist owns.Human).\perp
$$ -->

<div align="center"><img style="background: white;" src="../svg/dxa5oiWDhb.svg"></div>

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

