

count_leaves_with_sib(nil, 0) :- !.
count_leaves_with_sib(t(_,t(_,nil,nil),t(_,nil,nil)), 2) :- !.
count_leaves_with_sib(t(_,L,R), N) :- count_leaves_with_sib(L, N1), count_leaves_with_sib(R, N2), N is N1+N2.
count_leaves_with_sib(t(_,_,_), 0) :- !.

%?- count_leaves_with_sib(t(a,t(b,nil,nil),t(c,nil,nil)), N)
%?- count_leaves_with_sib(t(a,t(b,nil,nil),t(c,nil,t(d,nil,nil))), N)
%?- count_leaves_with_sib(t(a,t(b,nil,nil),t(c,t(d,nil,nil),t(e,nil,nil))), N)