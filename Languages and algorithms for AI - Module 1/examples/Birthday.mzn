% In probability theory, the birthday problem, or birthday paradox, 
% pertains to the probability that in a set of randomly chosen people 
% some pair of them will have the same birthday. In a group of 23 (or more) 
% randomly chosen people, there is more than 50% probability that some pair of them 
% will both have been born on the same day of the year. For 57 or more people, the 
% probability is more than 99%, tending toward 100% as the pool of people grows. 
% The mathematics behind this problem leads to a well-known cryptographic 
% attack called the birthday attack.

% http://en.wikipedia.org/wiki/Birthday_problem

% Write a model that computes probability that some pair persons in a group 
% of p persons have been born on the same day of the year



int: n = 365; % number of days of a year 
int: p = 100; % number of persons to check

array[1..p] of var 0.0..1.0: prob_no_dup;
array[1..p] of var 0.0..1.0: prob_dup;

constraint prob_no_dup[1] = 1.0
/\ 
forall(i in 2..p) 
(prob_no_dup[i] = prob_no_dup[i-1]* int2float(n-i-1)/int2float(n))
/\
forall(i in 1..p) 
(prob_dup[i] = 1 - prob_no_dup[i]);

solve satisfy;

output
["num persons: prob of dup.icates\n"
] ++
[show(i) ++ ":" ++ show(prob_dup[i]) ++ "\n" | i in 1..p
];
