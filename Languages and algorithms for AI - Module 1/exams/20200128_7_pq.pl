% 2020-01-28 exam, exercise 7

p(a,X,Z) :- p(X,Y,Z).
p(a,b,Z) :- p(a,b,Z).
p(b,c,Z) :- q(Z),r(Z).
%p(f(W)). % Original exercise
q(f(W)). % Correct exercise
r(a).

%:?- q(X1,b,Z1)

% With original exercise it nevr terminates because at some point p(a,b,Z) keeps failing to unify with p(a,X,Z) and unifying with itself
% With correct exercise it ends with a failure because f() is undefined