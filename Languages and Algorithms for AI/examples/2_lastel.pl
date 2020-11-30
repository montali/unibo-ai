% 2020-11-30 - exercise 1
% Last element of a list
lastel([],[]).
lastel([E], E) :- !. % Cut operator necessary to prevent
lastel([_|X],Y) :- lastel(X,Y).

% ?- lastel([1,2,3,4],Z)
% ?- trace, lastel([1,2,3,4],Z)