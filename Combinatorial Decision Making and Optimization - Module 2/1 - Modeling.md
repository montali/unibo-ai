# Modeling

If models don't work that great, we can combine them to unify their strenghts. We don't need a fully combined model to do so: we'll reduce the number of constraints to have the minimum model. Though, maybe, it is good to have all of them: for example, implied constraints may be significant and ignored. Minimal combined model might be enough, but you'll have to check. In the slides, what we're dropping are the sum constraints, which are superfluous. 

## Generalized arc consistency

For every variable, this requires that every variable belongs to its support. This means that **that value contributes to a solution**, i.e. if you cannot find that value in the support it is not ok.

Constraint propagation will go and remove the values that are not found in the support, and after that we will have reached arc consistency. Local consistency is a unique definition, but the process of achieving it is done by an algorithm (constraint propagation algorithm). Now, this can be achieved in many ways: the only point is that in the end, it will have to satisfy arc consistency.

In some cases, the constraint propagation algorithms maintain a lower level of consistency, *Bound Consistency*, as AC may be too difficult. This consistency is weaker: we relax the domain of every variable to a range (obviously the domain has to be ordered, no *blue,red,yellow* domains). The domain is therefore replaced by a range. The domain might present holes, so by doing this we're simplifying the thing. We assume that there are no missing values between min and max. The second one is the definition of the support, no longer a tuple belonging to $C$ containing the accepted variables from the domain, but now we have a tuple of values coming from the range, not the domain.

BC might not detect all inconsistencies, but usually it's easier to achieve.

## Complexity of propagation algorithms

One time AC propagation, following the definition, will take $d^2$ time: for every value, you have to check it into every variable. 

### Global constraints

We'd like a constraint propagation algorithm that puts an effort on recurring constraint, as we don't develop specialized propagation for constraints (very unique application). **Global constraints** capture complex, non-binary and **recurring** combinatorial substructures. These things often appear in problems, and it would be nice to have a constraint that allows us to express a complex constraint, having a constraint propagation algorithm which was designed for this purpose. They have **modeling benefits**, making the model easier, and **solving benefits** making the solver faster. There is a strong inference: there's operational semantics, thanks to the specialized propagation, and we reduce the gap between the problem statement and the model. We have to use as much global constraints as possible in our model. There are lots of global constraints, some examples are the counting, sequencing, scheduling and ordering ones. For example, the *global cardinality constraint*, limits the number of times each value is taken by the variables. The *sequence constraint* constrains the number of values taken from a given set in any sequence of $q$ variables, i.e. every sequence of $n$ elements contains an element from the set. We might use it to specify off days for employees, making sure that in every sequence of 7 values we have 2 variables assigned to OFF.

**How is this specialized propagation implemented?** In constraint decomposition, we decompose the constraint into smaller and simpler constraints, and alltogether we obtain a propagation for the global constraint. This might work for **some global constraints**, not for every one of them. 