% 2020-01-28 exam, exercise 6
%
% A binary tree is either empty or it is composed of a root element and two successors,
% which are binary trees themselves. In Prolog we represent the empty tree by the atom nil and the
% non-empty tree by the term t(X,L,R) where X denotes the root node and L and R denote the left
% and right subtree, respectively. A leaf is a node with no successors. For example, the tree in the
% Figure is represented by the term t(a,t(b,nil,nil),t(c,nil,nil)) and b and c are leaves.
%
% (Figure 1: a tree with only a root and two leaves)
%
% Write a Prolog program which def1nes a predicate count leaves/2 to count the leaves of a tree:
%
% count_leaves(T,N) :- the binary tree T has N leaves.
%
% Implementation WITHOUT constraints:

tree_count(nil, 0) :- !.
tree_count(t(_, nil, nil), 1) :- !. % Leaf
tree_count(t(_, L, R), N) :- % Node is NOT a leaf
    tree_count(L, N1), tree_count(R, N2), N is N1+N2.
    % BEWARE! This would not work: N is N1+N2, tree_count(L, N1), tree_count(R, N2)
    % The "is" operator requires the right-hand elements to be already defined

% Alternative implementation WITH constraints:

:- use_module(library(clpfd)).
tree_count(nil, 0) :- !.
tree_count(t(_, nil, nil), 1) :- !.
tree_count(t(_, L, R), N) :-
    N = N1+N2, tree_count(L, N1), tree_count(R, N2).

% Interrogation:

%?- tree_count(t(a,t(b,nil,nil),t(c,nil,nil)), N)
%?- tree_count(t(a,t(b,nil,nil),t(c,nil,nil)), 1)
%?- tree_count(t(a,t(b,nil,nil),t(c,nil,nil)), 2)