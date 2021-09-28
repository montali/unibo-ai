# 3. Edit distance, spelling correction and the noisy channel

### Table of contents

- [Edit distance](#edit-distance)
  * [Minimum edit distance](#minimum-edit-distance)
    + [Example](#example)
  * [Levenshtein distance](#levenshtein-distance)

## Edit distance

Sometimes we care how similar are two strings to deal with spelling correction and coreference

### Minimum edit distance

One simple measure of this similarity is **minimum edit distance** which is defined as the minimum number of edit operations needed to transform one string into another. Edit operations are:
 - insertion
 - deletion
 - substitution

#### Example
INTENTION -> EXECUTION.
It can be seen as an alignment problem:

```
I N T E N * T I O N
| | | | | | | | | |
* E X E C U T I O N
d s s   s i
```

The minimum edit distance is 5.

### Levenshtein distance

It is defined as the minimum edit distance, but the cost of a substitution operation is 2, so in the previous example the Levenshtein distance is not 5, but 8, since there are 3 substitutions.

### How do we find the distance?

Findining the distance is a search problem that consists in finding the shortest path from one string to another

## Spelling Correction and the Noisy Channel

### Spelling Correction

### The Noisy Channel

The goal is to build a model of the channel and this can be done through a kind of **Bayesian inference**: find the original word _w_ such that _P(w|x)_ is highest, where _x_ is the noisy word. So the guessed word _w̃_ will be:

_w̃ =_ argmax<sub>w</sub> _P(w|x)_ = argmax<sub>w</sub> _P(x|w) P(w)_

A **noisy channel spelling method** works as follow:
 1. Find words at distance _1_ from input word. Majority of errors are single-letter change, including transpositions, so a suitable measure of the distance is **Damerau-Levenshtein** edit distance, which also includes the operation _transpose adjacent_.
 2. Score each candidate based on language model and channel model (aka **error model**). This can be done using an _|A| x |A|_ **confusion matrix** that for each couple of character tells us how ofter the former is substituted for the latter.
