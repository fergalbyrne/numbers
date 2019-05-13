(ns numbers.core-test
  (:require [clojure.test :refer :all]
            [numbers.core :refer :all]))

;(mapv say (range 97 115))

(def computed
  {[0 20]
   ["0 is not a natural number"
    "one" "two" "three" "four" "five"
    "six" "seven" "eight" "nine" "ten"
    "eleven" "twelve" "thirteen" "fourteen" "fifteen"
    "sixteen" "seventeen" "eighteen" "nineteen"]
   [50 72]
   ["fifty" "fifty-one" "fifty-two" "fifty-three" "fifty-four" "fifty-five"
    "fifty-six" "fifty-seven" "fifty-eight" "fifty-nine" "sixty"
    "sixty-one" "sixty-two" "sixty-three" "sixty-four" "sixty-five"
    "sixty-six" "sixty-seven" "sixty-eight" "sixty-nine" "seventy"
    "seventy-one"]
   [97 115]
   ["ninety-seven" "ninety-eight" "ninety-nine" "one hundred"
    "one hundred and one" "one hundred and two" "one hundred and three"
    "one hundred and four" "one hundred and five" "one hundred and six"
    "one hundred and seven" "one hundred and eight" "one hundred and nine"
    "one hundred and ten" "one hundred and eleven" "one hundred and twelve"
    "one hundred and thirteen" "one hundred and fourteen"]
   [998 1002]
   ["nine hundred and ninety-eight" "nine hundred and ninety-nine"
    "one thousand" "no idea"]})

(defn check-nums [[n m]]
  (= (computed [n m]) (mapv say (range n m))))

(map check-nums (keys computed))

(deftest regression-test
  (testing "Names for key ranges of numbers"
    (are [x y] (= x y)
         (computed [0 20])     (mapv say (range 0 20)) 
         (computed [50 72])    (mapv say (range 50 72))
         (computed [97 115])   (mapv say (range 97 115))
         (computed [998 1002]) (mapv say (range 998 1002)))))
