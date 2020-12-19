# A*

- Remember that the $g(n)$ is always from the root, not just the node
- Choose the nodes in the heuristic order, **even if you found a goal**
- The heuristic is **admissible** if it is always optimistic
- In case of ties in open nodes, you choose in Lexicographic order

# POP

- You have an initial state
- You build the graph of orders and causal links
- Explicit the threats (for example, subgoals cancling each other), insert promotion/demotion/white knights
- Create plan

# Kowalski

You list the preconditions that have to hold with holds(pre, s0)

You list the add list with holds (effect, do(action))

You list the delete list stating that everything that holds bvefore stays, minus the delete list

# CSP

Remember that the solution will always be one assignment per variable. Skip arrays.

Forward checking only checks the constraints in whcih the just assigned variable appears. PLA, after FC, checks the domains of the free variables deleting values from the first variable only (i.e. if we have $x_2,x_3,x_4$ only checks $x_2 vs x_3, x_2 vs x_4, x_3 vs x_4$), while FLA checks the second variable's domain too: $x_2 vs x_3, x_3 vs x_2, x_2 vs x_4, x_4 vs x_2, x_3 vs x_4, x_4 vs x_3$.



```
2 2 2 2 2 2 2 2 2 2 2 2 2 2 2
29 29 80 24 87 60 58 -85 -13 -43 5 -29 76 93 -70 -1
```

```
holds(at(A), s0)
holds(have_battery, s0)
holds(handempty, s0)

holds(picture(Location), do(take_picture(Location), S))

pact(take_picture(Location), S) :- holds(have_battery, S), holds(have_camera, S), holds(at(Location), S)

holds(V, do(take_picture(Location), S)) :- holds(V,S), V\=have_battery
```

