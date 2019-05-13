(ns numbers.core)

(def nums {"one" 1 "two" 2 "three" 3 "four" 4 "five" 5
           "six" 6 "seven" 7 "eight" 8 "nine" 9 "ten" 10
           "eleven" 11 "twelve" 12 "thirteen" 13 "fifteen" 15
           "eighteen" 18
           "twenty" 20 "thirty" 30 "forty" 40 "fifty" 50
           "eighty" 80 "one hundred" 100 "one thousand" 1000})

(def revnums (zipmap (vals nums) (keys nums)))

(defn say [n]
  (or (revnums n)
      (cond
        (< n 1)    (str n " is not a natural number")
        (< n 20)   (str (say (- n 10)) "teen")
        (< n 100)  (let [tens (quot n 10) ones (mod n 10)]
                     (str (or (revnums (* 10 tens))
                              (str (say tens) "ty"))
                          (when (pos? ones) (str "-" (say ones)))))
        (< n 1000) (str (say (quot n 100)) " hundred"
                        (when (pos? (mod n 100))
                          (str " and " (say (mod n 100)))))
        :else "no idea")))
