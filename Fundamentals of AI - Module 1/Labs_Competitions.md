# Competitions 
A lot of these notes are taken from Allegra De Filippo's talk during lesson.

Non-mandatory challenges (?) **2** bonus points given. We can participate in teams.

## Tablut challenge

Acceptable solutions: any solution **using AI** (exploration of the state space, genetic/swarm, nn, contraint-based, prolog-based)

### The game

Tablut, no written trace of the original rules, we'll use the **Ashton** ones. Game board of 9x9, two players alternating (attacker/defender). Checkers move orthogonally. They are captured if surrounded on 2 opposite sides. 

### Useful links

- [Official intro PDF](https://virtuale.unibo.it/pluginfile.php/612250/mod_resource/content/1/ChallengeAITablut2020-2021.pdf)
- [More official info](http://ai.unibo.it/games/tablut).
- [Official server](https://github.com/AGalassi/TablutCompetition)
- [Android app with Tablut](https://play.google.com/store/apps/details?id=com.fellhuhn.hnefatafl) ("Linnaeus' Tablut" looks like our our rule except the starting color)
- Some previous implementations: [1](https://github.com/pptr3/TablutAI), [2](https://github.com/EleMisi/TablutAI), [3](https://github.com/AlessandroPomponio/B2P-Penicilin-Tablut-AI), [4](https://github.com/virtualms/Tablut2020_FrittoMisto)

### What to make

Gotta create a software agent able to play a game, by communicating with the engine. Communication messages are JSON strings, a possible state representation is provided (but may not be used). 

## NAO planning

Check out [the PDF](https://virtuale.unibo.it/pluginfile.php/612248/mod_resource/content/1/NAOPlanningChallenge2020-2021.pdf).

**NAO** is a humanoid robot with lots of good sh*t inside. 

We'll have to build a coreography with suitable music, 3 mins max. We can use positions from the available set. You have to find the possible incompatibilities, you have time constraints, and constraints on the number of intermediate positions to be used in the whole coreography. 

Try not to fall. 

Generate an algorithm A able to plan the sequence of positions satisfying the given constraints. 

We must use at least 5 of the intermediate positions, which are in 2 types: simple positions written in python, and more complex ones.

# Lab sessions

Check out [the PDF](https://virtuale.unibo.it/pluginfile.php/612251/mod_resource/content/1/Lab-VirtualMachineInstallation%2BRequirements.pdf).

We'll have 3 lab sessions:

- Search strategies (AIMA)
- Swarm Intelligence (Netlogo)
- Graph Based Planning

## First lab

Check out [the official material](https://virtuale.unibo.it/mod/folder/view.php?id=411632)

1. Python3 (Venv suggested)
2. Install **numpy**
3. Clone [the AIMA repository](https://github.com/aimacode/aima-python)
4. Copy in project *search.py* and *utils.py*
5. Install Jupyter
6. Follow instructions in lab pdf

## Second lab

Check out [the official material](https://virtuale.unibo.it/mod/folder/view.php?id=426404)

- We'll use a Xubuntu VM, using VirtualBox and its extension pack. The planners and material are already present. Username: **VM-info**	Password: **admin**
- It is also possible to [download NetLogo on any PC](https://ccl.northwestern.edu/netlogo/) (note: Allegra De Filippo said that implementing the second problem on 6.1.1 is different than on 5.0.2, the version we used in lab)
- [NetLogo manual](https://ccl.northwestern.edu/netlogo/docs/)

