# Probabilistic logic programming

The idea was presented in 1995, reasoning about many different worlds, each one being a different logic program. Many languages have been proposed. In LPAD,the head of clause is extended with disjunctions, and each disjunct is annotated with a probability.

It should now be clear what an LPAD program is: it's a logic program with *annotated disjunctions*. If you look at it, it's quite easy. For example, suppose *Bob has a flu and he suffers with hay fever*. We might do something like:

```
sneezing(X): 0.7 ; null:0.3 :- flu(X).
sneezing(X): 0.8 ; null:0.2 :- hay_fever(X).
flu(bob).
hay_fever(bob)
```

to express that people with flu sneeze 70% of the time, and people with hay fever sneeze 80% of the time. 

Note that in LPAD `null` is reserved, which might work in simple Prolog. Note that each rule has a probability distribution over its head, while in *ProbLog* the probability distributions are over facts.

Given a clause C we define the atomic choice the *selection of the i-th atom*, a set of these is a composite choice, and finally we define the probabilty as the product of the probaiblities. We introduce the selection $\sigma$ identifying a program $w_\sigma$ having probability equal to the product of the probabilities of the choices of the prgoram. The idea is *in world 1 we choose the head sneezing bob for 1 and sneezing bob for 2*, getting probability $0.7*0.8$.

Problem: which is the probability of a given query? We look for the world in which the query is in the heads, and we sum them. 

