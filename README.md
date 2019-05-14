# numbers.core/say

Clojure code to "read out" numbers between 1 and 1000 inclusive.

```Clojure
numbers.core/say
([n])
  returns the number `n` ∈ [1,1000] in English words
Spec
  args: (cat :n :numbers.core/nameable-num)
  ret: (and string? num-word?)
```

## Usage

```Clojure
(require '[numbers.core :as n])

(n/say 666) ; => "six hundred and sixty-six"

```

## Design and Dev Notes

The `nums` map contains a (near) minimal set of names that are needed to construct all the numbers. These include the digits, and then the non-standard numbers above that. All other numbers can be constructed by adding "teen" or "ty" to a digit name (and then appending the ones if appropriate), and by counting the hundreds.

For invalid inputs outside the range, an appropriate string message is returned. This could be replaced by returning errors or by throwing an exception.

I decided that a single function `say` was better than a number of functions for 21-99 and 101-1000, which would require a `(declare say)` due to mutual recursion and would spread the simple logic over multiple functions. This also encouraged a minimal approach for each case in the main `cond` expression.

Unit testing this function *per se* was not really feasible, so only a regression test against previously computed values over key ranges is present. The regression test can be checked by changing appropriate entries in `nums`.

For completeness, a `spec` for the function's input and return values was included, with a `test.check` generative test. `::nameable-num` checks that the argument is between 1 and 1000 inclusive. `num-word?` checks that the return value contains at least one of the names in `nums`. This test can be checked for by changing types of a key in `nums`.

Development used Atom with [proto-repl](https://atom.io/packages/proto-repl), [humane-test-output](https://github.com/pjstadig/humane-test-output) and [lein-test-refresh](https://github.com/jakemcc/lein-test-refresh). Illustrative config for these is included in `project.clj` rather than in `~/.lein/profiles.clj`.

To rerun tests on every saved code change, run `lein test-refresh`. Note that [terminal-notifier](https://github.com/julienXX/terminal-notifier) is being used with the current `project.clj`.
