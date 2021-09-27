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
