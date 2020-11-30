% 2020-11-30 - exercise 2
% Greatest element of a list, recursive implementation
maxel([], []).
maxel([E], E) :- !.
maxel([X|Y], Z) :- maxel(Y,Z), Z>=X. % The max value is not the first element, recursively search it in the rest of the list 
maxel([X|Y], X) :- maxel(Y,Z), Z<X. % Th max value is the first element. Z<X necessary to prevent the program from choosing the first element when it's not the max element 

% ?- maxel([1,7,3,9,2], A)
% ?- maxel([5,5,6], 5).