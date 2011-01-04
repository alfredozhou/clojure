(ns kata.test.bruteforce
  (:use [kata.bruteforce])
  (:use [clojure.test]))

(deftest can-iterate-over-list-and-output
  (is (= (where-is-it? [1,2,3,4] 1) 0))
  (is (= (where-is-it? [1,2,3,4] 2) 1))
  (is (= (where-is-it? [1,2,3,4] 3) 2))
  (is (= (where-is-it? [1,2,3,4] 4) 3))
  (is (nil? (where-is-it? [1,2,3,4] 5)))
  (is (nil? (where-is-it? [1,2,3,4] -1)))
  (is (nil? (where-is-it? [1,2,3,4] 35)))
  )

(run-tests)