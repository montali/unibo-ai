# Integer programming

Many algorithms, classifiable in 3 main classes. The first one, composed by exact algorithms (i.e. able to find the optimal solution of an integer problem), the second one, composed by approximation algorithms (providing a suboptimal solution together with a bound), and heuristic algorithms (they can provide a solution, but with no guarantee on its quality: it may be optimal, close to it, super bad...).

## Branch and bound

Divide et impera. In order to solve the problem we decompose it into subproblems, and try to solve each of these, eventually combining/comparing the solutions. 

If the subproblems are too complicated, we re-decompose them. 

We don't want fractional values in our solutions, so we start with a linear programming relaxation (we don't consider the request for integrality), so we're left with a simplex, which has a solution with - probably - fractional values. We can choose breadth-first or depth-first explorations.

## Branch and cut

It looks kind of the same, except that instead that in the latter, if we had an infeasible variable we created one branch adding a constraint only for the first infeasible variable, while in this we add all the constraint we have that could be active on all the infeasible variables we have. 

## Heuristics

We have a problem, we want to solve it. The problem is NP hard: there's no guarantee that I can find the solution in the general case! Heuristics can provide a solution (unless the problem is strictly NP hard), but without guarantee on its quality: tipically, the less computation, the worse the solution. Heuristics have been intensely studied because of this. They are usually simple, and we can split them into **constructive algorithms** (we start assigning value to a decision variable, then another, then another... we incrementally construct the solutions), **local search algorithms** (we start from a bad quality yet feasible solution, and we try to improve it), **metaheuristics** (trying to avoid local optima with different techniques).

### K-means

This is a non-linear integer (all points need to be assigned to a centroid, which is an integer variable) algorithm, the coordinates are continuous (continuous variables) and the objective funciton is quadratic (quadratic norm). The heuristic that is most often used is very simple: we generate the K centroids, compute the assigned center for each point, calculate the barycentre for each cluster, then update.

