(ns weekdaycalculator.core)

(defn chop-last-two-digits [year]
  (- year 2000)
  )

(defn quarter [number]
1
  )

(defn calculate-year [year]
  (let [last-two-digits (chop-last-two-digits year)]
  (+ (quarter last-two-digits) last-two-digits))
  )

(defn month-number [month]
  (cond
    (= month 1) 6
    (= month 2) 2
    (= month 3) 2
    (= month 4) 5
    (= month 5) 0
    (= month 6) 3
    (= month 7) 5
    (= month 8) 1
    (= month 9) 4
    (= month 10) 6
    (= month 11) 2
    (= month 12) 4
    )
  )
