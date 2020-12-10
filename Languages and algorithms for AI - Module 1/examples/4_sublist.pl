% 2020-11-30 - exercise 3
% Given a list L1 and a integer N, write a predicate question1(L1, N, L2) where L2 must be the list of elements in L1 that are list with 2 positive values between 1 and 9 which sum is N.
question1([],_,[]).
question1([[A,B]|R ], N, [[A,B]|S]):- % The current element is a valid list, collect it and recursively procede to the rest
    A>=1, A=<9, B>=1, B=<9,
    N is A + B, !,
    question1( R,N,S ).
question1([_|R], N,S ):- question1( R,N,S ). % The current element is not valid, recursively procede to the rest

% ?- question1([[1,5,3,7], [], [1,3], [1,4], [2,6]], 4, X).
% ?- question1([[1,5,3,7], [], [1,3], [1,4], [2,6]], 4, [[1,3]]).