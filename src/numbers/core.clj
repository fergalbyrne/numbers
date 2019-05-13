(ns numbers.core
  (:gen-class))

(def nums {"one" 1 "two" 2 "three" 3 "four" 4 "five" 5
           "six" 6 "seven" 7 "eight" 8 "nine" 9 "ten" 10
           "eleven" 11 "twelve" 12 "thirteen" 13 "fifteen" 15
           "eighteen" 18
           "twenty" 20 "thirty" 30 "forty" 40 "fifty" 50
           "eighty" 80 "one hundred" 100 "one thousand" 1000})

(def revnums (zipmap (vals nums) (keys nums)))

(declare say)

(defn say-21-99 [n]
  (let [tens (quot n 10)
        ones (mod n 10)
        tens-name (or (revnums (* 10 tens))
                      (str (say tens) "ty"))
        ones-name (if (zero? ones) ""
                      (str "-" (say ones)))]
      (str tens-name ones-name)))

(defn say [n]
  (or (revnums n)
      (cond
        (< n 1) (str n " is not a natural number")
        (< n 20) (str (say (- n 10)) "teen")
        (< n 100) (say-21-99 n)
        (< n 1000) (str (say (quot n 100))
                        " hundred"
                        (if (zero? (mod n 100)) ""
                             (str " and " (say (mod n 100)))))
        :else "no idea")))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Hello, World!"))
