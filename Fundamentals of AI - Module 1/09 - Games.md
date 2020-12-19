# Games

Now, a crucial topic: **how to deal with games**.

The search algorithms are kind of different: we're using a game and have an opponent. We'll concentrate on games which have 2 players. This search field is linked with economics.

Each of the players has a goal, which are opponent: everyone wants to win!

There are of course techniques that deal with probabilistic information (e.g. poker cards), but we don't have deterministic certainty. In board games, all the players have the same informations. 

The development of a match **can be seen as a tree**, with the root being the starting position and the leaves being the final positions. At each level, one player makes a move. 

If we can reach these leaves, we can assign <img src="svgs/e11a8cfcf953c683196d7a48677b2277.svg?invert_in_darkmode" align=middle width=21.00464354999999pt height=21.18721440000001pt/> to the configurations where <img src="svgs/a7101771c696ecea3c61d4c7eae04429.svg?invert_in_darkmode" align=middle width=41.25567269999999pt height=22.465723500000017pt/> wins, <img src="svgs/29632a9bf827ce0200454dd32fc3be82.svg?invert_in_darkmode" align=middle width=8.219209349999991pt height=21.18721440000001pt/> when nobody wins, <img src="svgs/c11fe0cea175e1b787b3403c763dc9b0.svg?invert_in_darkmode" align=middle width=21.00464354999999pt height=21.18721440000001pt/> where <img src="svgs/14644715e552e23b94c15f767c509df8.svg?invert_in_darkmode" align=middle width=44.977203149999994pt height=22.465723500000017pt/> wins. <img src="svgs/a7101771c696ecea3c61d4c7eae04429.svg?invert_in_darkmode" align=middle width=41.25567269999999pt height=22.465723500000017pt/> and <img src="svgs/14644715e552e23b94c15f767c509df8.svg?invert_in_darkmode" align=middle width=44.977203149999994pt height=22.465723500000017pt/> are the two players, called like that because they have complementary objective functions. 

## MinMax Algorithm

The minmax algorithm is designed to determine the optimal strategy for MAX and to suggest the best performable move. MIN is assumed to play at its best. We are not interested in the path but only in the next move. Note that both players know all of the state (e.g. in card games like *briscola* we don't).

This algorithm is **complete**, **optimal**, has temporal complexity <img src="svgs/fd5c58af667a7f6ef22a2f2b76fb7590.svg?invert_in_darkmode" align=middle width=45.870433949999985pt height=24.65753399999998pt/> and space complexity <img src="svgs/8095a0026c8a596585d57c84effd95d4.svg?invert_in_darkmode" align=middle width=47.81677064999999pt height=24.65753399999998pt/> (depth first). Note that trees can become giant (e.g. in chess <img src="svgs/c700088967273da3b28b20ab31176225.svg?invert_in_darkmode" align=middle width=113.72508839999999pt height=22.831056599999986pt/>) so we need to **prune them**. Therefore, this is extremely inefficient. 😔

### The algorithm

When you reach a goal, one of the following three leaves is reached: A wins, B wins, tie. Once you've reached the leaves, you can backpropagate.

We'll need a heuristic that provides a score stating how good or bad is a state. Obviously, the highest values of this heuristic will have the highest possibility of MAX winning.

Basically, <img src="svgs/86fcf883b7084a700dabd113c5794001.svg?invert_in_darkmode" align=middle width=60.44328839999999pt height=24.65753399999998pt/> for MAX winning, <img src="svgs/29632a9bf827ce0200454dd32fc3be82.svg?invert_in_darkmode" align=middle width=8.219209349999991pt height=21.18721440000001pt/> for tie, <img src="svgs/e11a8cfcf953c683196d7a48677b2277.svg?invert_in_darkmode" align=middle width=21.00464354999999pt height=21.18721440000001pt/> for MIN, and all the values in-between.

The thing we'd like to capture with this heuristic is the **knowledge of the game**, and it can be thought of with experts, maybe.

Obviously, overcomplicating this might be damaging: the time used in computing the heuristic is important too.

So, now the algorithm changes in this way: when we want to evaluate a node <img src="svgs/55a049b8f161ae7cfeb0197d75aff967.svg?invert_in_darkmode" align=middle width=9.86687624999999pt height=14.15524440000002pt/> in a tree, we put it into a list of open nodes, if there's a value we return it, otherwise we can update the value with the minimum between <img src="svgs/6819c59950efcf6e2cf46404142c4b0a.svg?invert_in_darkmode" align=middle width=21.512597699999986pt height=22.465723500000017pt/> and <img src="svgs/bda296fea0ae38036b335c2b5f6a636a.svg?invert_in_darkmode" align=middle width=22.63701824999999pt height=22.465723500000017pt/>. If there's no value and we decide not to expand the three further, we can assign the value of <img src="svgs/3926f8802d5b10d44ac2e12937451488.svg?invert_in_darkmode" align=middle width=29.83455914999999pt height=24.65753399999998pt/> to the node.

If <img src="svgs/332cc365a4987aacce0ead01b8bdcc0b.svg?invert_in_darkmode" align=middle width=9.39498779999999pt height=14.15524440000002pt/> is not assigned any value, we assign <img src="svgs/28a09935202e77512f9c21dfab5fdfcd.svg?invert_in_darkmode" align=middle width=73.7784861pt height=22.465723500000017pt/> for MAX nodes or <img src="svgs/ffd33733658d80955c066f7916795dfb.svg?invert_in_darkmode" align=middle width=73.7784861pt height=22.465723500000017pt/> for MIN nodes.

The only difference is basically in the moment we assign the heuristic value.

The question now is: *how do we decide whether or not to expand a given node?* We could maybe set a number of levels to stop at, and this could work for simple games, but would work badly in complicated games.

Sometimes it pays to do a secondary search, focused on the best move search. 

### Alfa-beta cuts

From what we've seen so far, computers simply play all possible matches up to a certain depth, so they also consider moves and nodes that will never occur: we should try to reduce the search space.

Considering a node <img src="svgs/f9c4988898e7f532b9f826a75014ed3c.svg?invert_in_darkmode" align=middle width=14.99998994999999pt height=22.465723500000017pt/> in the three, *will the player move to that node?* If the player had a better choice in the parent node level or anywhere else along the path, then <img src="svgs/f9c4988898e7f532b9f826a75014ed3c.svg?invert_in_darkmode" align=middle width=14.99998994999999pt height=22.465723500000017pt/> will **never be selected!** We'll call ALFA the value of the best choice found on the path for MAX (i.e. the highest), while BETA the same thing for MIN (i.e. the lowest). We update ALPHA and BETA during the search, and when there are specific conditions we can **cut branches**!

So, how **effective** are these cuts? Suppose that the nodes are ordered from the most promising to the less promising, or vice versa, in which situation will the cuts be more effective? Obviously, the first one: here, we can always cut.

