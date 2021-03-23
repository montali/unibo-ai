#  

Today, we'd like to answer a question: we know risk factors about people, and we want to get how probable it is that they will fall. We can use LPAD to compute the probability of risk!

```
fall: 0.079.
fall : 0.077 :- gait.
fall : 0.0147 :- diabetes.
```

Let's first start to deal with some issues.

### Dealing with the unknown

Suppose that the profile of our subject contains just `gait`: what does it mean? Is it the only one, or it's the only one we know about? In prolog, we have the closed world assumption: everything that is not specified is false. The idea, now, is that since there's `gait` only in the list, the subject isn't subject (*lol*) to diabetes too. However, there are cases in which we **don't know**! 

We can therefore enrich the profilewith more information:

```
s= [(gait, t), (diabetes, f), (parkinson,u)]
```

so that `gait` is true, `diabetes` is false, `parkinson` is unknown. 

The meaning of being mathematically precise depends on the data collection: if we are making a small project over a small dataset constructed by informed people, we'll find data which is statistically precise, while if we construct a dataset with data from idiots it won't be good.

### Exposure to a risk factor

Some risk factors are defined vaguely, like *visual impairment*. This is because *physicians*, as any other specific domain experts, have a background knowledge which is assumed to be known by you too. This is not true! The different criteria from different experts are a typical example of expert knowledge that we need to mix up with probabilistic reasoning. We define a `check` predicate as *we go and look*, the idea is that we just introduced a new predicate `factor3`. The second level deals with the thing that we may not know about vision impairment, while the predicate `factor3` deals with the idea of introducing a *level/threshold* for visual impairment. This final factor may be true if one of the three scores for visual impairment is under the threshold. We then have rules to avoid counting the visual impairment too many times: if it is unknown, 

## Rules

Rules are built as premises --> consequences. For example, *if you don't study, you will fail the exam*. We can reason about rules with the *modus ponens*: we write what we know over the line, what we want to infer under it. Now, what if new informations become available? A naive solution would be restarting from scratch.

