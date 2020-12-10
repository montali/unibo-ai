# MiniZinc

In a minizinc model (i.e. a program) you have 4(actually 5) components:

- Some libraries (classico *include*)
- Parameters (i.e. variables)  --> instantiated by the programmer 
- Variables (aka decision variables): specified by a type, maybe a range. These are variables the user cannot *fill*, its domain values will be checked in order to find the solution
- Constraints specifying our requirements

We have **aggregation functions**, like sum, product, min, max, forall, exists... that take an array and aggregate it into a variable through some function.

A **constraint** in MiniZinc too is a rule that a solution must respect. It contains an atomic or FOL formula.

After specifying the previously written components, we simply can `solve satisfy` and get a solution!

We could use MiniZinc to optimize things too, like in the *Traveling Salesman Problem*.

We can simply state the array of distances, the start city, the end city (as ints), then an array of **variables** to contain the cities for the solution, and an array of strings `city_name`.

Then, the constraints: we want the first element of the `city` array to be the start, the last to be the end city. We even have to specify that the array must contain different elements. Then, we have to specify the distance formula, which is what we want to optimize with `solve minimize`.