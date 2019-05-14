# numbers.core/say

```Clojure
numbers.core/say
([n])
  returns the number `n` ∈ [1,1000] in English words
Spec
  args: (cat :n :numbers.core/nameable-num)
  ret: (and string? num-word?)
```
Clojure code to "read out" numbers between 1 and 1000 inclusive.

## Usage

```Clojure
(require '[numbers.core :as n])

(say 666) ; => "six hundred and sixty-six"

```

## Notes

The `nums` map contains a (near) minimal set of names that are needed to construct all the numbers. These include the digits, and then the non-standard numbers above that. All other numbers can be constructed by adding "teen" or "ty" to a digit name (and then appending the ones if appropriate), and by counting the hundreds.

Unit testing this function *per se* is not really feasible, so only a regression test against previously computed values over key ranges is present. The regression test can be checked by changing appropriate entries in `nums`.

For completeness, a `spec` for the function's input and return values was added, with a `test.check` generative test. `::nameable-num` checks that the argument is between 1 and 1000 inclusive. `num-word?` checks that the return value contains at least one of the names in `nums`. This test can be checked for by changing types of a key in `nums`.
