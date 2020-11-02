# Games

Now, a crucial topic: **how to deal with games**.

The search algorithms are kind of different: we're using a game and have an opponent. We'll concentrate on games which have 2 players. This search field is linked with economics.

Each of the players has a goal, which are opponent: everyone wants to win!

There are of course techniques that deal with probabilistic information (e.g. poker cards), but we don't have deterministic certainty. In boards games, all the players have the same informations. 

The development of a match **can be seen as a tree**, with the root being the starting position and leaver being the final positions. At each level, one player makes a move. 

If we can reach these leaves, we can assign <img src="svgs/e11a8cfcf953c683196d7a48677b2277.svg?invert_in_darkmode" align=middle width=21.00464354999999pt height=21.18721440000001pt/> to the configurations where <img src="svgs/a7101771c696ecea3c61d4c7eae04429.svg?invert_in_darkmode" align=middle width=41.25567269999999pt height=22.465723500000017pt/> wins, <img src="svgs/29632a9bf827ce0200454dd32fc3be82.svg?invert_in_darkmode" align=middle width=8.219209349999991pt height=21.18721440000001pt/> when nobody wins, <img src="svgs/c11fe0cea175e1b787b3403c763dc9b0.svg?invert_in_darkmode" align=middle width=21.00464354999999pt height=21.18721440000001pt/> where <img src="svgs/14644715e552e23b94c15f767c509df8.svg?invert_in_darkmode" align=middle width=44.977203149999994pt height=22.465723500000017pt/> wins. <img src="svgs/a7101771c696ecea3c61d4c7eae04429.svg?invert_in_darkmode" align=middle width=41.25567269999999pt height=22.465723500000017pt/> and <img src="svgs/14644715e552e23b94c15f767c509df8.svg?invert_in_darkmode" align=middle width=44.977203149999994pt height=22.465723500000017pt/> are the two players, called like that because they have complementary objective functions. 

## MinMax Algorithm

The minmax algorithm is designed to determine the optimal strategy for MAX and to suggest the best performable move. MIN is assumed to play at its best. We are not interested in the path but only in the next move. 

This algorithm is **complete**, **optimal**, has temporal complexity <img src="svgs/fd5c58af667a7f6ef22a2f2b76fb7590.svg?invert_in_darkmode" align=middle width=45.870433949999985pt height=24.65753399999998pt/> and space complexity <img src="svgs/8095a0026c8a596585d57c84effd95d4.svg?invert_in_darkmode" align=middle width=47.81677064999999pt height=24.65753399999998pt/> (depth first). Note that trees can become giant (e.g. in chess <img src="svgs/c700088967273da3b28b20ab31176225.svg?invert_in_darkmode" align=middle width=113.72508839999999pt height=22.831056599999986pt/>) so we need to **prune them**.

