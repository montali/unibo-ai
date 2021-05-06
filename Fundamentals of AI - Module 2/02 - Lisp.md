# Lisp

Lisp is a functional AI language for symbolic programming.

## Functional languages

In functional languages programs are expressed as a set of function definitions:
```
f1(X,Y) = +(X,Y)
f2(X) = f1(X,X)
f3(Y,X) = f2(f1(Y,X))
```
Program execution is expressed as a sequence of function evaluations:
```
f2(3) -> f1(3,3) -> +(3,3) -> 6
```

The evaluation can be executed in two ways:
- **Normal evaluation** of a lambda expression is the repeated application of the leftmost reducible function application. In other words, normal evaluation is the strategy that substitutes the function definition without evaluating the arguments: (call-by-name). Also called "internal left based evaluation rule".
- **Applicative evaluation** means that a function’s arguments are evaluated before the function is applied. In other words, with applicative-order evaluation, internal reductions are applied first, and only after all internal reductions are complete, the function is reduced: (call-by-value).

For example:

Function: `λ X,Y. +(X,Y)` (lambda equivalent of `function f(X,Y) { return +(X,Y); }`)

Arguments: `X=*(5,2)` e `Y=+(1,3)`

Normal evaluation:
```
(λ X,Y. +(X,Y)) *(5,2) +(1,3)
+(*(5,2) ,+(1,3))
+(10,4)
14
```
Applicative evaluation:
```
(λ X,Y. +(X,Y)) *(5,2) +(1,3)
(λ X,Y. +(X,Y)) 10 4
+(10,4)
14
```

The applicative evaluation rule cannot be used for
evaluating conditional functions like `if(Condition,Then,Else)` because both the `Then` and `Else` parts are always evaluated.

Lisp adopts the applicative evaluation rule (because it is more efficient) and introduces an ad-hoc implementation for conditionals and other special forms.

## Common Lisp

Common Lisp is the main dialect of Lisp.

Commands can be executed quickly in the interpreter `sbcl`.

In Lisp `(a b c)` executes the function `a` with parameters `b` and `c`. The reason for these parenthesis is that you can look a t this command both as a list of data and a command.

Example of addition:
```lisp
(+ 1 2)
;Result: 3
```

Example of multiplication:
```lisp
(* 3 5)
;Result: 15
```

In Lisp `NIL` represents false and `T` represents true.

The function `quote` or its equivalent notation `'` suspends the evaluation of its argument:
```lisp
(quote (a b c))
;Equivalent alternative: '(a b c)
;Result: (a b c)
```

Symbols in lisp are used for several purposes, as variables, function names, parameters and for representing symbolic information. Lisp is
not case sensitive. Example:
```lisp
(set 'foo 5)
;Equivalent alternative: (setq foo 5)
foo
;Equivalent alternative: (symbol-value 'foo)
;Result: 5
```

### Defining functions

Functions can be defined with the `defun` keyword:
```lisp
(defun FUN-NAME (PAR1 PAR2 ... PARm)
    (EXPR1)
    (EXPR2)
    ...
    (EXPRn))
```
Functions always return the value of the last expression (`EXPRn`). It's not possible to return more values with base language (we will see a way to do it but it will require more advanced constructs).

Examples of function definition:

Square of a number:
```lisp
(defun square (X) (* X X))

(square 21)
;Result: 441
```

Recursive factorial with `if`:
```lisp
(defun factorial(n)
    (if (<= n 1)
        1
        (* n (factorial (- n 1)))))

(factorial 3)
;Result: 6
```

### Conditionals
The `cond` special form contains a sequence of pairs
(Condiction Expression).
```lisp
(cond (<p1> <e1>)
    (<p2> <e2>)
    (<p3> <e3>)
    ...
    (<pn> <en>))
```
Pairs are evaluated in sequence. When the first condition succeeds (`pi`) the corresponding expression is evaluated (`ei`) and `cond` returns its value. If none of the conditions are true `cond` returns `NIL`.
This is in some way similar to the `switch` in imperative languages (except, obviously, this is declarative).
Examples:

Absolute value:
```lisp
(defun absnum (X)
    (cond ((> X 0) X)
        ((= X 0) 0) 
        ((< X 0) (-  X))))

(absnum -6)
;Result: 6
```

Recursive factorial with `cond`:
```lisp
(defun fact (N)
    (cond ((eq N 0) 1)
        (T 
        (* N (fact (- N 1))))))

(fact 3)
;Result: 6
```

Recursive Fibonacci sequence:
```lisp
(defun fib (N)
    (cond ((eq N 0) 0)
        ((eq N 1) 1)
        (T (+ (fib (-  N 1)) (fib (-  N 2))))))

(fib 7)
;Result: 13
```
The function `(= A B)` works only with numbers.
The function `(eq A B)` returns `T` in `A` and `B` are the same, `NIL` otherwise.

### Data structures
Being a functional language, Lisp represents **data structures** with lists and functions which create and access them:

- `cons` creates the list
- `car` accesses the first element of the list (head)
- `cdr` accesses the rest of the list (tail)

The notation `(a . b)` indicates a cons cell. A cons cell is not the same thing as a list, it's a cell that represents an element of a list including a value and the pointer to the rest of the list.

`(a)` = `(a . NIL)`

`(a b)` = `(a . (b . NIL))`

Examples:

Single element list:
```lisp
(cons a NIL)
;Result: (a)
```

Two element list:
```lisp
(cons a (cons b NIL))
;Result: (a b)
```

Two element cons cell:
```lisp
(cons 'a 'b)
;Result: (a.b)
```

Access the head 
```lisp
(car (cons 'a 'b))
;Result: a
```

Access the tail:
```lisp
(cdr (cons 'a 'b))
;Result: b
```

Assignment of a list to a symbol:
```lisp
(setq mylist (cons 'a (cons 'b (cons 'c ()))))
mylist
;Result: (a b c)
```

Nested `car` and `cdr` can be shrunk:

`cXr (cYr (... (cZr 'l)...))` = `cXY...Zr 'l`

Example:
```lisp
(car (cdr (car (cdr '((1 2) (3 4))))))
;Result: 4
```
```lisp
(cadadr '((1 2) (3 4)))
;Result: 4
```

The function `(and A B)` returns `T` if both `A` and `B` are different from `NIL`, `NIL` otherwise.

The function `(atom A)` returns `T` if `A` is an atom (number, symbol, `NIL`), `NIL` otherwise.

