% 2020-07-06 exam, exercise 6

% A binary tree is either empty or it is composed of a root element and two successors,
% which are binary trees themselves. In Prolog we represent the empty tree by the atom nil and
% the non-empty tree by the term t(X,L,R) where X denotes the root node and L and R denote the
% left and right subtree, respectively. A leaf is a node with no successors. Two nodes are siblings
% if they have the same parent. For example, the tree in the Figure is represented by the term
% t(a,t(b,nil,nil),t(c,nil,nil)) and b and c are leaves.

% Write a Prolog program which denes a predicate count leaves without sib(T,N) which counts
% the number of leafs which have no siblings
% count_leaves_without_sib(T,N) :- the binary tree T has N leafs whith no siblings.

count_leaves_without_sib(nil, 0) :- !.
count_leaves_without_sib(t(_,nil,nil), 0) :- !.
count_leaves_without_sib(t(_,t(_,nil,nil),nil), 1) :- !.
count_leaves_without_sib(t(_,nil,t(_,nil,nil)), 1) :- !.
count_leaves_without_sib(t(_,L,R), N) :- count_leaves_without_sib(L, N1), count_leaves_without_sib(R, N2), N is N1+N2.

%?- count_leaves_without_sib(t(a,t(b,nil,nil),t(c,nil,nil)), N)
%?- count_leaves_without_sib(t(a,t(b,nil,nil),t(c,nil,t(d,nil,nil))), N)
%?- count_leaves_without_sib(t(a,t(b,nil,nil),t(c,t(d,nil,nil),t(e,nil,nil))), N)