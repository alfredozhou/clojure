(ns kata.main)

(defn first-half [array]
  (take (/ (count array) 2) array)
  )

(defn second-half [array]
  (drop (/ (count array) 2) array)
  )

(defn which-half? [array target]
  (let [first-half (first-half array)]
    (cond
      (>= (last first-half) target) first-half
      :else (second-half array))
    ))

(defn where-is-it? [array target]
  (let [section (which-half? array target)]
    (cond
      (= (count section) 0) nil
      (and (= (count section) 1) (= (first section) target)) :true
      :else (where-is-it? section target))
    )
  )
  

