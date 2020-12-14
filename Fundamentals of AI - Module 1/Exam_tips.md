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

