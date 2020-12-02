% Path on an oriented graph
edge(a,b).
edge(b,c).
edge(c,d).
edge(d,e).
edge(d,f).
edge(a,f).
path(X,Y):-edge(X,Y).
path(X,Y):-edge(X,T),path(T,Y).

% ?- edge(a,e).
% ?- path(a,e).
% ?- path(a,X),path(X,Y).
% ?- path(a,X).
% ?- trace, path(a,X).
% ?- trace,path(a,X),path(X,Y)
% ?- path(a,X),trace,path(X,Y)
% ?- trace, path(a,e).
% ?- edge(a,Y),edge(X,Y),X\==a.