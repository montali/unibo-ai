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

Functions can be defined with the `defun` keyword:
```lisp
(defun FUN-NAME (PAR1 PAR2 ... PARm)
    (EXPR1)
    (EXPR2)
    ...
    (EXPRn))
```
Examples:
```lisp
(defun square (X) (* X X))
(square 21)
;Result: 441
```

```lisp
(defun factorial(n)
    (if (<= n 1)
        1
        (* n (factorial (- n 1)))))

(factorial(3))
;Result: 6
```

