% 2020-11-30 - exercise 1
% Last element of a list
lastel([],[]).
lastel([E], E) :- !. % Cut operator necessary to prevent the empty list as second result of the search (given by the last clause)
lastel([_|X],Y) :- lastel(X,Y). % There is more than one element in the list, skip the first and recursively search the rest

% ?- lastel([1,2,3,4],Z)
% ?- trace, lastel([1,2,3,4],Z)