% 2020-11-30 - exercise 2
% Greatest element of a list, iterative implementation
maxel([N|L], E) :- maxel(L,N,E).

maxel([],E,E) :- !.
maxel([M|L], N, E) :- M>=N, maxel(L,M,E), !. % Ex: TODO
maxel([M|L], N, E) :- M<N, maxel(L,N,E). % Ex: TODO

% ?- maxel([1,7,3,9,2], A)
% ?- maxel([5,5,6], 5).