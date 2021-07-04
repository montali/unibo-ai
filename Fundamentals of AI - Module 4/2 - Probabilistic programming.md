# Probabilistic logic programming

The idea was presented in 1995, reasoning about many different worlds, each one being a different logic program. Many languages have been proposed. In LPAD,the head of clause is extended with disjunctions, and each disjunct is annotated with a probability.

It should now be clear what an LPAD program is: it's a logic program with *annotated disjunctions*. If you look at it, it's quite easy. For example, suppose *Bob has a flu and he suffers with hay fever*. We might do something like:

```lpad
sneezing(X): 0.7 ; null:0.3 :- flu(X).
sneezing(X): 0.8 ; null:0.2 :- hay_fever(X).
flu(bob).
hay_fever(bob)
```

to express that people with flu sneeze 70% of the time, and people with hay fever sneeze 80% of the time. 

Note that in LPAD `null` is reserved, which might work in simple Prolog. Note that each rule has a probability distribution over its head, while in *ProbLog* the probability distributions are over facts.

Given a clause C we define the atomic choice the *selection of the i-th atom*, a set of these is a composite choice, and finally we define the probability as the product of the probabilities. We introduce the selection <!-- $\sigma$ --> <img style="transform: translateY(0.1em); background: white;" src="..\svg\nDbnytXtC6.svg"> identifying a program <!-- $w_\sigma$ --> <img style="transform: translateY(0.1em); background: white;" src="..\svg\gPi2QLj5o0.svg"> having probability equal to the product of the probabilities of the choices of the program. The idea is *in world 1 we choose the head sneezing bob for 1 and sneezing bob for 2*, getting probability 0.7*0.8.

Problem: which is the probability of a given query? We look for the world in which the query is in the heads, and we sum them. 

## Case study

[Recording](https://web.microsoftstream.com/video/da96109d-8e46-4adb-804d-6dc431f7770f)

Today, we'd like to answer a question: we know risk factors about people, and we want to get how probable it is that they will fall. We can use LPAD to compute the probability of risk!

```lpad
fall: 0.079.
fall : 0.077 :- gait.
fall : 0.0147 :- diabetes.
```

Let's first start to deal with some issues.

### Dealing with the unknown

Suppose that the profile of our subject contains just `gait`: what does it mean? Is it the only one, or it's the only one we know about? In prolog, we have the closed world assumption: everything that is not specified is false. The idea, now, is that since there's `gait` only in the list, the subject isn't subject (*lol*) to diabetes too. However, there are cases in which we **don't know**! 

We can therefore enrich the profile with more information:

```lpad
s= [(gait, t), (diabetes, f), (parkinson,u)]
```

so that `gait` is true, `diabetes` is false, `parkinson` is unknown. 

The meaning of being mathematically precise depends on the data collection: if we are making a small project over a small dataset constructed by informed people, we'll find data which is statistically precise, while if we construct a dataset with data from idiots it won't be good.

### Exposure to a risk factor

Some risk factors are defined vaguely, like *visual impairment*. This is because *physicians*, as any other specific domain experts, have a background knowledge which is assumed to be known by you too. This is not true! The different criteria from different experts are a typical example of expert knowledge that we need to mix up with probabilistic reasoning. We define a `check` predicate as *we go and look*, the idea is that we just introduced a new predicate `factor3`. The second level deals with the thing that we may not know about vision impairment, while the predicate `factor3` deals with the idea of introducing a *level/threshold* for visual impairment. This final factor may be true if one of the three scores for visual impairment is under the threshold. We then have rules to avoid counting the visual impairment too many times.
