% 2020-06-03 exam, exercise 7

q(a,X,Z) :- q(b,X,Z).
q(b,c,Z) :- q(a,X,Z).
q(b,b,Z) :- p(Z),r(Z).
p(f(V)).
r(f(V)).

%:?- q(W,b,Y)

% TODO