# Games

Now, a crucial topic: **how to deal with games**.

The search algorithms are kind of different: we're using a game and have an opponent. We'll concentrate on games which have 2 players. This search field is linked with economics.

Each of the players has a goal, which are opponent: everyone wants to win!

There are of course techniques that deal with probabilistic information (e.g. poker cards), but we don't have deterministic certainty. In board games, all the players have the same informations. 

The development of a match **can be seen as a tree**, with the root being the starting position and the leaves being the final positions. At each level, one player makes a move. 

If we can reach these leaves, we can assign $-1$ to the configurations where $MIN$ wins, $0$ when nobody wins, $+1$ where $MAX$ wins. $MIN$ and $MAX$ are the two players, called like that because they have complementary objective functions. 

## MinMax Algorithm

The minmax algorithm is designed to determine the optimal strategy for MAX and to suggest the best performable move. MIN is assumed to play at its best. We are not interested in the path but only in the next move. Note that both players know all of the state (e.g. in card games like *briscola* we don't).

This algorithm is **complete**, **optimal**, has temporal complexity $\mathcal{O}(b^m)$ and space complexity $\mathcal{O}(bm)$ (depth first). Note that trees can become giant (e.g. in chess $b\approx 35, m \approx 100$) so we need to **prune them**. Therefore, this is extremely inefficient. 😔

### The algorithm

When you reach a goal, one of the following three leaves is reached: A wins, B wins, tie. Once you've reached the leaves, you can backpropagate.

We'll need a heuristic that provides a score stating how good or bad is a state. Obviously, the highest values of this heuristic will have the highest possibility of MAX winning.

Basically, $e(n)=1$ for MAX winning, $0$ for tie, $-1$ for MIN, and all the values in-between.

The thing we'd like to capture with this heuristic is the **knowledge of the game**, and it can be thought of with experts, maybe.

Obviously, overcomplicating this might be damaging: the time used in computing the heuristic is important too.

So, now the algorithm changes in this way: when we want to evaluate a node $n$ in a tree, we put it into a list of open nodes, if there's a value we return it, otherwise we can update the value with the minimum between $Vp$ and $Vx$. If there's no value and we decide not to expand the three further, we can assign the value of $e(x)$ to the node.

If $x$ is not assigned any value, we assign $Vx=-\infty$ for MAX nodes or $Vx=+\infty$ for MIN nodes.

The only difference is basically in the moment we assign the heuristic value.

The question now is: *how do we decide whether or not to expand a given node?* We could maybe set a number of levels to stop at, and this could work for simple games, but would work badly in complicated games.

Sometimes it pays to do a secondary search, focused on the best move search. 

### Alfa-beta cuts

From what we've seen so far, computers simply play all possible matches up to a certain depth, so they also consider moves and nodes that will never occur: we should try to reduce the search space.

Considering a node $N$ in the three, *will the player move to that node?* If the player had a better choice in the parent node level or anywhere else along the path, then $N$ will **never be selected!** We'll call ALFA the value of the best choice found on the path for MAX (i.e. the highest), while BETA the same thing for MIN (i.e. the lowest). We update ALPHA and BETA during the search, and when there are specific conditions we can **cut branches**!

So, how **effective** are these cuts? Suppose that the nodes are ordered from the most promising to the less promising, or vice versa, in which situation will the cuts be more effective? Obviously, the first one: here, we can always cut.