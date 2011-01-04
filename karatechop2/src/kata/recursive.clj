(ns kata.recursive
  (:use clojure.contrib.math))

(defn middle-index [array]
  (floor (/ (count array) 2))
  )

(defn pivit-value [array]
  (if (> (count array) 0) (nth array (middle-index array)))
  )

(defn sub-array [array from to]
  (subvec array from to)
  )

(defn which-half? [array target from to]
  (let [sub-array (sub-array array from to)]
    (let [pivit (pivit-value sub-array)]
      (cond
        (nil? pivit) nil
        (> pivit target) :first_half
        (= pivit target) (+ (middle-index sub-array) from)
        :else :second_half))
    )
  )

(defn- private-where-is-it? [array target from-index to-index]
  (let [which-half-is-it? (which-half? array target from-index to-index)]
    (cond
      (= which-half-is-it? :first_half) (private-where-is-it? array target from-index (floor (/ to-index 2)))
      (= which-half-is-it? :second_half) (private-where-is-it? array target (+ from-index (floor (/ to-index 2))) to-index)
      :else which-half-is-it?
      ))
  )

(defn where-is-it? [array target]
  (private-where-is-it? array target 0 (count array))
  )
  

