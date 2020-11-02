# Games

Now, a crucial topic: **how to deal with games**.

The search algorithms are kind of different: we're using a game and have an opponent. We'll concentrate on games which have 2 players. This search field is linked with economics.

Each of the players has a goal, which are opponent: everyone wants to win!

There are of course techniques that deal with probabilistic information (e.g. poker cards), but we don't have deterministic certainty. In boards games, all the players have the same informations. 

The development of a match **can be seen as a tree**, with the root being the starting position and leaver being the final positions. At each level, one player makes a move. 

If we can reach these leaves, we can assign $-1$ to the configurations where $MIN$ wins, $0$ when nobody wins, $+1$ where $MAX$ wins. $MIN$ and $MAX$ are the two players, called like that because they have complementary objective functions. 

## MinMax Algorithm

The minmax algorithm is designed to determine the optimal strategy for MAX and to suggest the best performable move. MIN is assumed to play at its best. We are not interested in the path but only in the next move. 

This algorithm is **complete**, **optimal**, has temporal complexity $\mathcal{O}(b^m)$ and space complexity $\mathcal{O}(bm)$ (depth first). Note that trees can become giant (e.g. in chess $b\approx 35, m \approx 100$) so we need to **prune them**.

