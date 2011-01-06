(ns weekdaycalculator.test.core
  (:use [weekdaycalculator.core] :reload)
  (:use [clojure.test]))

(deftest can-chop-the-last-two-digits
  (is (= (chop-last-two-digits 2001) 1))
  )

(deftest can-get-month-number
  (is (= (month-number 1) 6))
  (is (= (month-number 8) 1))
  )

(deftest can-calculate-quarter
  (is (= (quarter 5) 1))
  (is (= (quarter 7) 1))
  (is (= (quarter 8) 2))
  )

(deftest can-calculate-year-value
  (is (= (calculate-year 2004) 5))
  )

(run-tests)
