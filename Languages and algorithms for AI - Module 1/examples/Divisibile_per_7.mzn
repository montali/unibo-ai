
% Three numbers (6, 3 and 1) are drawn on the sides of
% three cubes- a number per cube.
% Can you arrange the three cubes in a line so that to create
% a 3-digit number divisible by 7? 
% Each cube must be employed.


include "globals.mzn";

int: n = 3;
array[1..n] of var {1,3,6,9}: x;
var int: z = 100*x[1] + 10*x[2] + x[3];

constraint 

alldifferent(x) /\ z mod 7 = 0
/\
x[1] + x[2] + x[3] < 15;
%Cannot have both 6 and 9 as digit

solve satisfy;

output["x:" ++ show(x)];