(ns kata.test.main
  (:use [kata.main])
  (:use [clojure.test]))


(deftest can-split-an-array
  (is (= (which-half? [1, 2, 3, 4] 1 0 4) :first_half))
  (is (= (which-half? [1, 2, 3, 4] 2 0 4) :first_half))
  (is (= (which-half? [1, 2, 3, 4, 5] 3 0 4) 2))
  (is (= (which-half? [1, 3, 5, 67, 99] 7 0 5) :second_half))
  (is (= (which-half? [1, 3, 5, 67, 99] 5 0 5) 2))
  )

(deftest can-tell-whether-a-target-exist
  (is (= (where-is-it? [1, 2, 3, 4] 1) 0))
  (is (= (where-is-it? [1, 2, 3, 4] 2) 1))
  (is (= (where-is-it? [1, 2, 3, 4] 3) 2))
  (is (= (where-is-it? [1, 2, 3, 4] 4) 3))
  (is (= (where-is-it? [1, 2, 3, 4, 5] 5) 4))
  (is (= (where-is-it? [0, 1, 2, 3, 4, 5, 6, 7, 8] 3) 3))
  (is (nil? (where-is-it? [1, 2, 3, 4] 5)))
  )

(run-tests)