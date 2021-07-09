# FAI Module 2 - 07/07/2021 exam

## Simone Montali

I'll choose **First Order Logic** to solve this exercise, as it is expressive and simple enough. Note that along this exercise I will use some arithmetic operators with infix notation, for example $Difference =Area-45$ would actually be equivalent to using a predicate $difference(Area,45,Difference)$, defined as true whenever $Area-45=Difference$. This is seen in Prolog too as the predicate `is`, and will make the syntax more clear (though keeping in mind this important definition.)

### Predicates

First, we'll want to introduce the predicates we'll need:

- $flat\_area(garibaldi, 40)$ stating the area in square meters of a flat, in the example a flat in Garibaldi is $40 m^2$;
- $bedrooms(garibaldi, 2)$ stating the number of bedrooms in a flat, namely the apartment in Garibaldi has 2 bedrooms;
- $floor(garibaldi, 2)$ stating the floor of the apartment;
- $elevator(garibaldi)$ stating that the flat has an elevator;
- $animals\_allowed(garibaldi)$ stating that animals are allowed in the apartment
- $located(garibaldi, center)$ and $located(casalecchio, suburbs)$ states whether a flat is in the center or in the suburbs
- $willing\_to\_pay(garibaldi, 100)$ states that the student is willing to pay 100€/month for the apartment $garibaldi$
- $choose(X,Y,X)$ means that the student prefers apartment X to apartment Y
- $unacceptable(garibaldi)$ means that the apartment in garibaldi is unacceptable
- $address(garibaldi, "via\ garibaldi\ 1")$ states the address of a flat
- $price(garibaldi, 200)$ states the price for a flat
- $acceptable(garibaldi)$ states that the apartment is acceptable with respect to the requirements
- $apartment(X)$ states that $X$ is, in fact, an apartment.
- $acceptable\_price(garibaldi)$ means that the apartment's price is acceptable, namely the student is willing to pay the given price for that apartment
- $garden\_area(garibaldi,10)$ states the area of the garden in square meters, and $garden\_area(nogarden,0)$ states that apartment $nogarden$ has, in fact, no garden

### Defining the KB

Let's first find the statements we'll need, then formalize them in FOL. First, we can list the student's requirements: the area, the number of bedrooms, the elevator (in case floor >= 4), the pets, the price.

So, we can formalize this first, large condition as:
$$
\forall X.(apartment(X) \wedge \\(\exist Y.flat\_area(X,Y) \wedge Y\ge45) \wedge\\(\exist Y.(floor(X,Y) \wedge Y\ge4) \rightarrow elevator(X))\wedge \\animals\_allowed(X)\wedge \\ acceptable\_price(X)) \rightarrow acceptable(X)
$$
namely, for all the X apartments that have a $\ge45$ **area**, an **elevator** if they are on a high floor, accept **animals**, and have an **acceptable price**, we can state that the **apartment is acceptable**.

The negation is true aswell: $\forall X.(\neg acceptable(X))\rightarrow unacceptable(X)$

Then, we'll want to define what's an acceptable price. First, we'll define $willing\_to\_pay(X,Money)$, namely the money that the student is willing to pay for an apartment. We know that:

- $45 m^2$ apartments in the center are worth 400€: $\forall X.(apartment(X) \wedge flat\_area(X,45) \wedge located(X, center)) \rightarrow willing\_to\_pay(X,400)$
- $45 m^2$ apartments in the suburbs are worth 300€: $\forall X.(apartment(X) \wedge flat\_area(X,45) \wedge located(X, suburbs)) \rightarrow willing\_to\_pay(X,300)$
- If the apartment is larger, he's willing to pay 20€ more per square meter: $\forall X\exist Area,Difference,Surplus,Final.\\(apartment(X) \wedge\\(flat\_area(X,Area) \wedge\\ (Area>45)\wedge\\(Difference =Area-45)) \wedge\\(Surplus = Difference*20)\wedge\\ located(X,center)\wedge\\ (Final=400+Surplus)\wedge \\(Final \le 500)) \rightarrow willing\_to\_pay(X, Final)$.
  - namely, if an apartment has an **area** $Area$, different from 45 by quantity $Difference$, is **located in the center**, the **surplus is not more than 100€**, the student is willing the $Final$ price.
- We can do the same thing for the suburbs: $\forall X\exist Area,Difference,Surplus,Final.\\(apartment(X) \wedge\\(flat\_area(X,Area)\wedge\\ (Area>45) \wedge\\(Difference =Area-45) \wedge\\(Surplus = Difference*20)\wedge\\ located(X,suburbs)\wedge\\ (Final=300+Surplus)\wedge \\(Final \le 500)) \rightarrow willing\_to\_pay(X, Final)$
- Then, if the apartment has a garden, we are willing to pay a bit more. As before, we differentiate between the center and the suburbs:
  - $\forall X\exist Area,Difference,Surplus,Final.\\(apartment(X) \wedge\\(garden\_area(X,Area) \wedge\\(Surplus = Area*10)\wedge\\ located(X,center)\wedge\\ (Final=400+Surplus)\wedge \\(Final \le 500)) \rightarrow willing\_to\_pay(X, Final)$
  - $\forall X\exist Area,Difference,Surplus,Final.\\(apartment(X) \wedge\\(garden\_area(X,Area) \wedge\\(Surplus = Area*10)\wedge\\ located(X,suburbs)\wedge\\ (Final=300+Surplus)\wedge \\(Final \le 500)) \rightarrow willing\_to\_pay(X, Final)$
- Finally, we could consider the case in which there is a **bigger area** and a **garden**:
  - $\forall X\exist Area,Gardenarea, Difference,AreaSurplus,GardenSurplus,Final, FinalSurplus.\\(apartment(X) \wedge\\(flat\_area(X,Area)\wedge\\(garden\_area(X,Gardenarea) \wedge\\ (Area>45)\wedge\\(Difference =Area-45)) \wedge\\(AreaSurplus = Difference*20)\wedge\\(GardenSurplus = Gardenarea*10)\wedge\\ located(X,center)\wedge\\ (FinalSurplus=GardenSurplus+AreaSurplus)\wedge\\ (Final=400+FinalSurplus)\wedge \\(Final \le 500)) \rightarrow willing\_to\_pay(X, Final)$
  - $\forall X\exist Area,Gardenarea, Difference,AreaSurplus,GardenSurplus,Final, FinalSurplus.\\(apartment(X) \wedge\\(flat\_area(X,Area)\wedge\\(garden\_area(X,Gardenarea) \wedge\\ (Area>45)\wedge\\(Difference =Area-45)) \wedge\\(AreaSurplus = Difference*20)\wedge\\(GardenSurplus = Gardenarea*10)\wedge\\ located(X,suburbs)\wedge\\ (FinalSurplus=GardenSurplus+AreaSurplus)\wedge\\ (Final=300+FinalSurplus)\wedge \\(Final \le 500)) \rightarrow willing\_to\_pay(X, Final)$

We can just say that if an apartment costs X, and the student is willing to pay $\ge X$, the price is acceptable:

$\forall X,P,W.(apartment(X)\wedge\\ price(X,P) \wedge\\ willing\_to\_pay(X,W)\wedge\\ (W>P)) \rightarrow\\ acceptable\_price(X)$

Now, we can define whether the student prefers an apartment to the other with the following predicates:

- First, if the prices differ, the student will prefer the cheapest: $\forall X,Y,XPrice, YPrice.(price(X,XPrice) \wedge price(Y,YPrice) \wedge\\(X>Y)) \rightarrow choose(X,Y,X)$
- Then, if the prices are equal, we check the presence (or better, the **size**) of the garden $\forall X,Y,XPrice, YPrice,XGarden, YGarden.\\(price(X,XPrice) \wedge\\ price(Y,YPrice) \wedge\\(X=Y)\wedge\\ garden\_area(X,XGarden)\wedge\\garden\_area(Y,YGarden)\wedge\\(XGarden>YGarden)) \rightarrow choose(X,Y,X)$
- Finally, if both the preceding conditions are equal, we check the space:
  - $\forall X,Y,XPrice, YPrice,XGarden, YGarden,XSpace,YSpace.\\(price(X,XPrice) \wedge\\ price(Y,YPrice) \wedge\\(X=Y)\wedge\\ garden\_area(X,XGarden)\wedge\\garden\_area(Y,YGarden)\wedge\\(XGarden=YGarden)\wedge\\flat\_area(X,Xspace)\wedge\\flat\_area(Y,YSpace)\wedge\\(XSpace>YSpace)) \rightarrow choose(X,Y,X)$

Remember, also, that we'll have to inverse the condition so that it works the other way too:

$\forall X,Y.(choose(Y,X,Y) \rightarrow choose(X,Y,Y))$

### Facts

It is now possible to add some facts to the KB:
$$
apartment(garibaldi)\\
bedrooms(garibaldi,4)\\
floor(garibaldi,2)\\
animals\_allowed(garibaldi)\\
located(garibaldi, center)\\
price(garibaldi,350)\\
garden\_area(garibaldi, 0)\\
address(garibaldi, "via\ garibaldi\ 1")\\
\\
apartment(mazzini)\\
bedrooms(mazzini,2)\\
floor(mazzini,5)\\
elevator(mazzini)\\
located(mazzini, center)\\
price(mazzini,450)\\
garden\_area(mazzini, 10)\\
address(mazzini, "via\ mazzini\ 42")\\
\\
apartment(casalecchio)\\
bedrooms(casalecchio,6)\\
floor(casalecchio,2)\\
located(casalecchio, suburbs)\\
price(casalecchio,300)\\
garden\_area(casalecchio, 25)\\
address(mazzini, "via\ reno\ 12")\\
$$

### Queries

The query asked in question number 3 is as follows:

$\exist X.(address(X,A)\wedge acceptable(X))$

while the second query, for example, if we wanted to compare $mazzini$ and $garibaldi$ would be $\exist X.choose(mazzini, garibaldi,X)$ in which $X$ would contain the answer.

