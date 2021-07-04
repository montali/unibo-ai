# Project specifications

[Description](https://github.com/montali/unibo-ai/blob/master/Combinatorial%20Decision%20Making%20and%20Optimization%20-%20Module%202/CDMO_Project_2021.pdf)

This is an interesting application of a very common problem, which we'll have to **model** and **solve**. The general idea is that we model and use it with CP, then SAT and/or SMT. 

We get extra points if we do SAT and SMT both. SAT is more efficient then SMT, as it doesn't have to find the CNF. 

We are going to submit it through Virtuale. 

There's no strict deadline, but we'll have to submit the thing whenever we can, there's two general deadlines, the first due to half of july, the second one in september. 

We have silicon chips and a plate, and we want to integrate as many chips as possible. We try to fit those that are given to us, and **minimize the used space**: any placement is generally not so difficult, the optimized one is. We are given a fixed width plate, and we want to make the chips fit in a way that minimizes the total used space. 

We have 14 instances which are for **experimental usage**, so don't infer patterns from them. We can just use them to test the algorithm and improve the result. Some of these are pretty difficult, and not all of them may be solved. Don't assume anything basing on these.

Every instance has the *instance-i* names, and we'll have to use the same pattern for outputs.

We may have simmetries in the problem, or maybe in the way we model it. 

Breaking symmetries is crucial: notice that symmetry breaking constraints may fail, but don't surrender. There can be one solution in which multiple simmetry breaking constraints are satisfied. Conflicts with simmetry breaking will increase the search size, so not only the multiple symmetry breaking constraints must be different, but the conflicts have to avoided too. If we had a $a<b$ constraint, and our search explores the domain from the lower to the higher values, we'll want to start with the assignment of the right one. Simmetry breaking is all about ordering, so if you have a situation in which maybe two simmetry breaking constraints conflict, we cannot satisfy them both. In SAT and SMT you can't really program a search, while in CP you can. This helps solving hard problems. We should avoid ORs in CP as much as possible. SAT and SMTs are okay with that tho.

There will be no presentation: we'll just submit the project (report+code), they'll read our report and we'll discuss the things in it. If the report's not clear, we'll all take a look at the code and maybe run it. Add a README explaining how to run the thing. Don't insert code in the report, but mathematical notation of the model. MiniZinc notation is okay, but no Z3py code. 

We should also report some experimental results: they want to see how the model acts on the instances. Don't insert them all, just some examples, the best ones possibly. 

They want to see the model, the global constraints, the symmetry breaking constraints, the search it uses...

Avoid making too long of a report: they don't look at the lines, just at the content. 
