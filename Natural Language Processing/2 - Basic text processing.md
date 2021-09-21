# 2. Basic text processing

## Regular expressions (regex)
We use regular expressions to describe text patterns, to extract information from text and to convert text into a convenient`standard form. The latter process is called **text normalization**, which can mainly be of 3 kinds:
 - **tokenization**;
 - **lemmization** and **stemming**, example: _sang_, _sing_ and _sings_ count as a single lemme;
 - **sentence segmentation**.

### How to describe patterns

 - **disjunctions**: letters inside square brackets. For example `[ab]` means _a_ or _b_;
   - **ranges**: `[A-Z]`, `[a-z]`, `0-9]` respctively mean any upper case letter, any lower case letter or any digit;
   - **pipe |**: another way to specify disjunction: `a|b|c`, `[abc]` and `[a-c]` have the same meaning;
 - **negations**: `[^Ss]` means neither _S_ or _s_. It works only if _^_ is the first character in [], indeed `[e^]` means either _e_ or _^_;
 - **optional elements and wildcards**:
   - **?** optional previous character: `colou?r` means _color_ or _colour_;
   - __\*__ zero or more instances of the previous character;
   - **+** one or more instances of the previous character, `aa*` and `a+` have the same meaning;
   - **.** any symbol: `.\*` means a sequence of any lenght of any character;
   - **\\** escape special characters: `\.` means the dot, and not any symbol;
 - **anchors**:
   - **^** start of a line: `^Hello`;
   - **$** end of a line: `World!$`;
   - **\\b** word boundary: `\bthe\b`;
   - **\\B** word non-boundary: `\Bthe\B`;
   - **\\n** new line;
   - **\\t** tab.

To test if a regular expression is correct you can go to [regex101.com](https:``regex101.com`).

### Substitution

One of the main uses of regex is substitution: replace a pattern with another string. It makes use of **pattern groups**: `\1` refers to the first pattern and it will be inserted in the new string.

### Tools
Regex are built-in in most programming languages, as well as in word processors and shell utilites such as `sed` and `awk`. The former is a stream editor that comes with Linux.
In Python you can use the library `re`.

## Text normalization

Every NLP task needs to do text normalization. At first we have to define whatis a word: in the sentence _I do uh main-mainly business data processing._ ther are two kinds of **disfluencies**: fragments and filled pauses. Are these words? Do we have to consider them?

Another problem are words that are the same **lemma** but different **wordforms**, like _cat_ and _cats_.

We have to define a vocabulary whose elements are called **types**, an istance of a type in running text is called **token**.

If _**N**_ is the number of tokens, _**V**_ is the vocabulary, the hempirical Herdan's Law states that _|V| = kN^β_ where _β_ is approximately _3/4_

### Simple tokenization in UNIX:
Given a text file, output the word tokens and their frequences sorted by frequence
```
tr -sc 'A-Za-z' '\n' < sh.txt | tr A-Z a-z | sort | uniq -c | sort -n -r
```
