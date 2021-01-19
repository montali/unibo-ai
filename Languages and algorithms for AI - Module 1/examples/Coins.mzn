% Three coins lie on a table in the order tails, heads, tails. 
% In precisely three moves make them face either all heads or all tails

int: n = 3;
int: num_moves = 3;

array[1..num_moves+1,1..n] of var 0..1: x;
% 0 = head, 1 = tail, x contains the 4 situations after 3 moves, 
% first row is the init

array[1..n] of 0..1: init = [1,0,1];
%initial situation

var 0..n: last_sum;

constraint 

forall(i in 1..n) (
                  x[1,i] = init[i]
                  )
/\
forall(m in 2..num_moves + 1)(
  sum(i in 1..n) (bool2int(x[m-1,i]!= x[m,i])) = 1
                  )
% one difference per move
/\
last_sum = sum(i in 1..n) (x[num_moves + 1,i])
/\
(last_sum = 0 \/ last_sum = n
)
;
% all heads or all tails

output
[if j = 1 then "\n" else " " endif ++
show(x[m,j]) | m in 1..num_moves+1, j in 1..n
]
++
["\n"];

