(ns weekdaycalculator.core
  (:use [clojure.contrib.math]))

(defn chop-last-two-digits [year]
  (- year 2000)
  )

(defn quarter [number]
  (floor (/ number 4))
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

(defn to-int [string]
  (Integer/parseInt string)
  )

(defn to-week-day [day]
  (cond
    (= day 1) "Monday"
    (= day 2) "Tuesday"
    (= day 3) "Wednesday"
    (= day 4) "Thursday"
    (= day 5) "Friday"
    (= day 6) "Saturday"
    (= day 7) "Sunday"
    ))

(defn calculate-day-of-week [datestring]
  (let [date-splits (.split datestring "-")]
    (to-week-day  (mod (+ (calculate-year (to-int (last date-splits)))
      (month-number (to-int (first date-splits)))
      (to-int (nth date-splits 1))
      ) 7)))
  )