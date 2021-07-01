# Why you should love LISP - written by an hater

LISP is a functional language, this means that programs are expressed as a set of function definitions and the execution is expressed as a set of function evaluations.

It is also a very old language (50s for Lisp, and 80s for Common Lisp), this means that programs are expressed as a set of weird syntax and apparently useless parenthesis.  
So I hate it.  
But you don't have to.  
And this is why you don't.

## Syntax

### Hello World!

`*` is the sbcl prompt.

`quote()` (that can also be used in its short form `'`) suspends evaluation for its arguement. So `* 'foo` will print "foo" instead of evaluate `foo` as a function. Now we have enough knowledge to write an Hello World program:

```LISP
* quote(Hello World!)
Hello World!
```

or, in shorter form:

```LISP
* '(Hello World!)
Hello World!
```

In both examples, and in future codes, the lines without `*` are the values returned by the shell.

### Operators

in Lisp operators use prefix notations, because it is an old weird language. I'm really trying to do my best but it's difficult to understand why I'm studying this shit.

```Lisp
* (+ 5 8)
13
* (* 2 7)
14
```

Other operators are `>`, `<`, `=` (which can be written also as `eq`), `-`, `and`.

### Defining functions

We can define a function with `(defun FUN_NAME (PARAMS) (BODY))`:

```LISP
* (defun square(X) (* X X))
square
* (square 7)
49
```

### Booleans

`T` is true and `NIL` is false.

### Conditionals

LISP **doesn't** provide a classical `if else` structure ~~because is an old, weird, shitty language~~ because it evaluates expression call-by-value. So the only conditional structure is the `cond` special form:

```Lisp
(defun abs (X))
    (cond ((> X 0) X)
          ((= X 0) 0)
          ((< X 0) (-X))))
```
It is a weird mix between an if else and a switch: when a condition is satisfied, then the corresponding body is evaluated and eventual following conditions are simply skipped. If no conditions are true, then `NIL`, which in LISP represents false, is returned.

### Recursion

Let's just see how recursion works with a classical example:

```Lisp
* (defun factorial (N)
      ((cond ((eq N 0) 1)
              (T (* N (fact (- N 1)))))))
```

The number of parenthesis has already become ridicoulus and we are just at the beginning.

EDIT: ok, I admit id, I spent some days hating LISP and asking myself why I had to study a so old language, but then I've tried to look for a valid reason online and I've discovered something.

Why there are all theese parenthesis? Because **every Lisp program in fact is a list**. In our example `defun` is the first element, `factorial` the second one, as third element we have a sublist and so on. So programs and data are the same thing, allowing the so called **syntax abstraction**, a mechanism very rare in other programming languages with which we can do many things like use macros (which have nothing to do with C macros) to extend the language creating new syntactical constructs or even create new languages tailor-made for our problem. 

In this course we don't delve into Lisp enough to truly appreciate it, but it is not a "old, weird shitty language" as I used to think.

### Lists

To create lists we use `cons A B` which basically create a pointer from A to B

```Lisp
* (cons 'a 'b)
(a . b)
```

Longer list we'll have this ~~very practical~~ syntax:

```Lisp 
* (cons 'a (cons 'b (cons 'c 'd)))
(a . b . c . d)
```

To access to lists we can use `car` to access to the first element, or `cdr` to access to the rest of the list:

```Lisp
* (car (cons 'a 'b))
a
* (cdr (cons 'a 'b))
b
```

Exists also a shorten form `cXr` where X is a combination of `a` and `d`. For example:

```Lisp
* (car (cdr (car (cdr '((1 2) (3 4))))))
```

Corresponds to:

```Lisp
* (cadadr '((1 2) (3 4)))
```

The result of the evaluation of both expressions is `4` according to slides, but I don't understand why.

To save a list we can use `setq`:

```Lisp
* (setq mylist (cons 'a (cons 'b (cons 'c ()))))
(a b c)
* mylist
(a b c)
```

### `null` and `atom`

The function `(null A)` returns `T` if `A` is `NIL`, `NIL` otherwise.

The function `(atom A)` returns `T` if `A` is an atom (number, symbol or `NIL`), `NIL` otherwise.

### List functions

`null` and `atom` can be used to implement some list functions, which luckly are already implementes.

 - `(member (A L))` checks if `A` is in `L`.
 - `(equal (X Y))`checks if 2 lists are equal.
 - `(append (L1 L2))` appends the two lists `L1` and `L2`.
 - `(mapcar (F L))` maps the functions `F` on all the elements of list `L`, building the list of results. `F` can be a quoted symbol associated to a function or a **lambda** expression:

```lisp
* (mapcar (lambda (X) (* X 10)) '(1 2 3 4 5))
(10 20 30 40 50)
```

### Macros

As anticipated, in Lisp macros allow to define new operators that are implemented by transformation.

Although a macro definition is similar to a function definition it works differently: while a function produce rules, a macro produce expressions.

Let's suppose for example we want to define a more standard conditional form: `(IF PREDICATE THEN ELSE)`.
We cannot implement it as a function, because both bodies of `THEN` and `ELSE` would be evaluated in the function call independtely from the value of p (because of the call-by-value).

So we have to define a macro with `defmacro`:

```lisp
(defmacro if (p e1 e2)
    (cons ('cond) (cons (cons p (cons e1 NIL))
        (cons (cons T (cons e2 NIL)) NIL))))
```

This can be written in a shorter form introducing a bit of syntactic sugar: the opeators `` ` `` and `,` (backquote and comma). The backquote is like the quote, but allows to introduce entrypoints: expressions that are evaluated and then inserted in the list. This entrypoints are marked with a comma at the beginning. So we will have:

```lisp
(defmacro if (p e1 e2)
    `(cond) (,p ,e1) (T ,e2))
```
