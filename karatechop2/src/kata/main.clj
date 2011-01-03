(ns kata.main
  (:use clojure.contrib.math))

(defn first-half [array]
  (take (/ (count array) 2) array)
  )

(defn i-am-in-second-half []
  (print "I am in second half\n")
  :second_half
  )

(defn which-half? [array target]
  (print "target=" target " sub list ="  array "\n")
  (let [first-half (first-half array)]
    (cond
      (>= (last first-half) target) :first_half
      :else (i-am-in-second-half))
    ))


(defn sub-array [array from to]
  (subvec array from to)
  )

(defn calculate-index [to from]
  (+ (/ to 2) (/ (- to from) 2))
  )

(defn- private-where-is-it? [array target from-index to-index]
  ;  (print "target = " target " list =" array " from " from-index " to " to-index "\n")
  (cond
    (and (= from-index to-index) (= (nth array to-index) target)) to-index
    (and (= from-index to-index) (not= (nth array to-index) target)) nil
    :else
    (let [which-half? (which-half? (sub-array array from-index to-index) target)]
      (cond
        (= which-half? :first_half) (private-where-is-it? array target from-index (floor (/ to-index 2)))
        :else (private-where-is-it? array target (calculate-index  to-index from-index) to-index)
        ))
    )
  )

(defn where-is-it? [array target]
  (private-where-is-it? array target 0 (count array))
  )
  

