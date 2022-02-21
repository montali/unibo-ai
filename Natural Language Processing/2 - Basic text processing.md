# 2. Basic text processing

### Table of contents

- [Regular expressions (regex)](#regular-expressions-regex)
  * [How to describe patterns](#how-to-describe-patterns)
  * [Substitution](#substitution)
  * [Tools](#tools)
- [Text normalization](#text-normalization)
  * [Simple tokenization in UNIX:](#simple-tokenization-in-unix)
  * [Issues in tokenization](#issues-in-tokenization)
  * [Normalization](#normalization)
  * [Lemmization and stemming](#lemmization-and-stemming)
  * [Sentence segmentation](#sentence-segmentation)
- [Datasets and Tools](#datasets-and-tools)

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

Every NLP task needs to do text normalization. At first we have to define what a word is: in the sentence _I do uh main-mainly business data processing._ there are two kinds of **disfluencies**: fragments and filled pauses. Are these words? Do we have to consider them?

Another problem are words that are the same **lemma** but different **wordforms**, like _cat_ and _cats_.

We have to define a vocabulary whose elements are called **types**, an istance of a type in running text is called **token**.

If _**N**_ is the number of tokens, _**V**_ is the vocabulary, the hempirical Herdan's Law states that _|V| = kN^β_ where _β_ is approximately _3/4_

### Simple tokenization in UNIX:
Given a text file, output the word tokens and their frequences sorted by frequence
```
tr -sc 'A-Za-z' '\n' < sh.txt | tr A-Z a-z | sort | uniq -c | sort -n -r
```

### Issues in tokenization

Some issues in tokenization can be caused by words like _Finland's_, _isn't_, _state-of-the-art_, _San Francisco_, _rock' n' roll_, _PhD._ and also numbers, dates, hastags and URLs.

Specific languages have specific issues, too.

### Normalization

Some of this problems can be solved with **word normalization**, which consists in putting words/tokens in a standard format. For example we may want to match _U.S.A._ with _USA_. A kind of normalization iscase folding, which consists in mapping everything to lowercase.

### Lemmization and stemming

in other cases we wants to put together also morphologically different words that should behave similarly. For example we may want to map _am_, _are_ and _is_ to the base form _be_. This process which reduces inflections or variant forms to base form is called **lemmization**.
While an accurate lemmization requires a complete morphological parsing that takes in account both stems and affixes, sometimes reduce words to theirs stems is enough. This simpler method is called **stemming** and is performerd by cutting affixes. A widely used algorithm is **Porter Stemmer** which consists in cascade rewrite rules, such as: _ational_ -> _ate_ and _sees_ -> _ss_.

### Sentence segmentation

Another important task is to segmentate sentences. While question marks and exclamation points are relatively ambiguous, periods are more ambigous. Indeed they can appear in words like _Mr._ without divide two sentences. One rule-based approach to this task is [Stanford's CoreNLP](https://stanfordnlp.github.io/CoreNLP/).

## Datasets and Tools

[NLTK](https://www.nltk.org/book/) provides various corpora an tools including tokenizers, stemmers and lemmatizers in Python.

```python
import nltk
nltk.download()
```

