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

Rules are built as premises --> consequences. For example, *if you don't study, you will fail the exam*. We can reason about rules with the *modus ponens*: we write what we know over the line, what we want to infer under it. Now, what if new informations become available? A naive solution would be restarting from scratch. But a great question would be *when to actually restart?*

Production rule systems allow us to explicitly have side effects in the RHS, like printing out things. In prolog this ispossible: the side effects are placed in the body. Production rules are designed to skip the logical setting, working towards a more procedural framework: this pushes towards forward reasoning. Unfortunately, if we start to abandon the logical setting, a number of issues raise. For example, what if I decide to add a fact to the KB which is inconsistentwith another? Actually, no one really cares about inconsistencies: we are not is a logical setting anymore. Anoter problem may be *what if new facts trigger more rules? Which rule shall I choose?* 

When a new fact we match for the rules that match it, we try to solve the conflicts, execute the RHS and iterate. 

The working memory is crucial to Production Rules systems, containing the set of facts, the set of rules, and the set of the copies of partially matched rules. Since the system heavily relies on this memory, the performance of the whole system is usually heavily proportional to the one of this memory. 

## RETE

The RETE algorithm was proposed in 1992, it is a quite old paper but it is proved to be the fastest algorithm for the general problem of production rules. The basic idea behind it is avoiding the iteration over facts by storing, for each pattern, the facts that the pattern matches with. Not all the premises have been matched yet, but we keep track of these patterns. We have two types of these patterns: the ones testing intra-elements featrues (test on the new fact on data inside the new fact), while inter-elements features put the condition between different pacts/patterns. The intra elements are saved in what are called alpha networks, their outcomes in alpha-memories, while inter-elements are in beta-networks, with outputs in beta-memories.

Supppose wehave a rule *When a Professor $\mathrm{P}$ with name $\mathrm{N}$ and age $>30,$ when $\mathrm{a}$ Course C with subject "ai" and teacher N THEN do something*, every time I put it into my alpha network, we insert a new professor P, with name N, suppose that the secretary adds a new course AI by the professor, in the alpha memory we'l have a new ai course. In this moment the beta network will compare the two Ns (we make some comparison, i.e. we look that the name of the professor N is exactly the name of the teacher N) and save the conflict set in the beta store, i.e. the list of tules for which the LHS is completely matched, so that they're ready to be executed. Then, the step 2, i.e. conflict resolution, has to choose which rule has to be executed first if we have more than one to execute. This has been discussed for long, and finally everyone agreed on the fact that it depends on the domain. For example, we could decide a priority, or some temporal attribute, the complexity... Modern rule based production system support all of these. Finally, we'll have to execute all of the rules. We could decide to only execute the first one and re-iterate, or execute them all. What about loops? It is quite rare to see them in backward reasoning, while creating them in forward reasoning is quite straightforward: we'll commonly end in infinite loops. 

## DROOLS

Drools is a freely available commercial framework, supported by RedHat. A rule has a name, a LHS defined with `when` a RHS defined with `then` and an `end` closing the rule. The LHS is a conjunction of patterns (i.e. the atomic element describing a conjunct). Note that, differently from Java, the operator `==` exists. We have variables starting with `$` and assigned with `:`, making rules easier to write. We could even list all the patterns to satisfy for a more complex rule that gets triggered only when all of them are triggered. Note that all the possible combinations for more rules are generated, for example if we created a rule triggered on weddings, it will trigger for Elena->Federico and Federico->Elena both. This may result in a double execution. Sometimes we can avoid variables and just use `this`, an operator referred to the instance that is outside the parenthesis. We could also use quantifiers: `exists`, `not` and `forall`. There's a problem with `not`: when should we check for it? When we start, our working memory is empty and it will always trigger! This is quite an unfortunate situation. ß

 

