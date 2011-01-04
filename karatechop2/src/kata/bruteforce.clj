(ns kata.bruteforce)

(defn where-is-it? [array target]
  (loop [index 0]
    (cond
      (= index (count array)) nil 
      (not= (nth array index) target) (recur (inc index))
      :else index)))