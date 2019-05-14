(ns numbers.core
  ^{:doc "Numbers in English"
    :author "Fergal Byrne"}
  (:require [clojure.spec.alpha :as s]))

(s/def ::nameable-num (s/and int? #(< 0 % 1001)))

(def ^:private nums {"one" 1 "two" 2 "three" 3 "four" 4 "five" 5
                     "six" 6 "seven" 7 "eight" 8 "nine" 9 "ten" 10
                     "eleven" 11 "twelve" 12 "thirteen" 13 "fifteen" 15
                     "eighteen" 18
                     "twenty" 20 "thirty" 30 "forty" 40 "fifty" 50
                     "eighty" 80 "one hundred" 100 "one thousand" 1000})

(def ^:private names (zipmap (vals nums) (keys nums)))

(defn num-word?
  "valid numbers contain at least one of the words in names"
  [n]
  (re-find (re-pattern (clojure.string/join "|" (keys nums))) n))

(s/fdef say
  :args (s/cat :n ::nameable-num)
  :ret  (s/and string? num-word?))

(defn say
  "returns the number `n` ∈ [1,1000] in English words"
  [n]
  (or (names n)
      (cond
        (< n 1)    (str n " is not a natural number")
        (< n 20)   (str (say (- n 10)) "teen")
        (< n 100)  (let [tens (quot n 10) ones (mod n 10)]
                     (str (or (names (* 10 tens))
                              (str (say tens) "ty"))
                          (when (pos? ones) (str "-" (say ones)))))
        (< n 1000) (str (say (quot n 100)) " hundred"
                        (when (pos? (mod n 100))
                          (str " and " (say (mod n 100)))))
        :else (str n " is over 1000"))))
