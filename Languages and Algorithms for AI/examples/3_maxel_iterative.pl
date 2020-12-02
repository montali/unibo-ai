% 2020-11-30 - exercise 2
% Greatest element of a list, iterative implementation
maxel([N|L], E) :- maxel(L,N,E). % Get the greatest among the first and the rest

maxel([],E,E) :- !.
maxel([M|L], N, E) :- M>=N, maxel(L,M,E), !. % The greatest element is not the first. Ex: maxel([5, [6,4]], X) :- maxel([6,4], 5, X).
maxel([M|L], N, E) :- M<N, maxel(L,N,E). % Ex: The greatest element is the first.

% ?- maxel([1,7,3,9,2], A)
% ?- maxel([5,5,6], 5).