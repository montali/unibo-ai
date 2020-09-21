# Fundamentals of AI
## Lesson 1
### Exam: two averaged parts
* Part I: material taught in fall: 2 types of exercise (asking to solve a problem; theoretical questions)
* Part II: material taught in spring (module 2,3,4)
Se ridai l’esame e lo consegni, resetti il voto. Exercises on one game and on planning, submitted to a contest. Two points for the challenge 🙋 
Probably a pre exam before Christmas, than sessione ordinaria
### Email
Specify in the subject “Fundamentals of AI”
### Book
S.J. Russel, Norvig, Artificial Intelligence: a modern approach

### What is intelligence?
This is the first question we’d like to answer. Intelligence has been defined in many ways. 
Can a machine behave intelligently? Alan Turing developed a test (Turing test) in which an interviewer tries to discover if he’s talking with a computer.
We’ll talk about **agents**. To solve the Turing test the agent will have to understand natural language, will have to get knowledge and will have to be able to learn. Another interesting test is based on **matemathical puzzles** (_come quelli delle elementari)_: the agents reads the text and provides a solution.  
### Turing Forecast
Turing said that around 2000 it would be possible to pass the Turing test in 70% of the trials. 
### Weak vs Strong AI
We can talk about 
* **weak AI**: is it possible to build systems that act as if they were intelligent? 
* **strong AI**: is it possible to build systems that are intelligent, with conscious minds, wills and sentiments?
### General and narrow AI
If you look at many tasks, like vision, computers have higher performances than humans. But when the task is general, it becomes more difficult. 
* **General AI**: refers to systems which are able to cope with any generalised task which is asked of it, much like a human.
* **Narrow AI**: refers to AI which is able to handle just one particular task, display a certain degree of intelligence in a particular field, but it remain computer systems that perform highly specialised tasks for humans.

Humans are generally intelligent.
Things like common sense (e.g. your age always grows every year) are connected with general but not narrow. 

### Artificial Intelligence 
_The study is to proceed on the basis of the conjecture that every aspect of learning or any other feature of intelligence can in principle be so precisely described that a machine can be made to simulate it._
AI: _Study on how to make computers do things that humans do better._ Or, better: **/Study of how to build computers that pass the Turing test. If situated in an environment also perception, vision, movement, robotics. /**

### Two main AI approaches
We can work top-down (**symbolic AI**), where we try to encode all the knowledge on the problem into symbols: logics, ontologies, rule based systems, declarative architecture. The models are here human understandable. 
We can work bottom-up (**connessionist approach**) too. The knowledge, here, is not symbolic and it is _encoded_ into connections between **neurons**. Concepts are learned by examples, the neural network is not understandable by humans. 
There are some domains in which the capability of explaining your model is crucial: suppose you are a doctor, and the machine says there’s something but you cannot understand what it is, the result is useless.
### PROLOG program
PROLOG is a logic programming language. You have **rules**, **facts** and a **goal**.  If we wanted to define a sum program, a fact might be, for example, that 0+x is x.  It is not really performant.
### Reasoning and logic
* Deductive reasoning: it doesn’t not allow us to learn a new knowledge.
* Inductive reasoning starts from the observation, and extracts a generalisation.
* Hypothetical or abductive reasoning makes hypothesis: you make hypothesis that don’t prove your model (?)
* Reasoning by analogy: you have seen many before, and work basing on experience.
* Constraint reasoning and optimisation: using constraints, probability, statistics

Deduction is crucial here. 
### Different algorithm interpretations
Algorithm may stand for data structures/instructions, or for logic (knowledge)+control (engine inference), or for examples (experience)+machine learning. The level of generality and intelligence increases.
### Deduction and induction
I know T and B, I can deduct E.
I know E+, E- (negative examples), and B, I can induct T.
### Abduction
Abduction is different: if you have rules, you then infer hypothesis thanks to constraints. 

