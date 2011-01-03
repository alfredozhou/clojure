(ns kata.test.main
  (:use [kata.main])
  (:use [clojure.test]))


(deftest can-split-an-array
  (is (= (which-half? [1, 2, 3, 4] 1) '(1,2)))
  (is (= (which-half? [1, 2, 3, 4] 2) '(1,2)))
  (is (= (which-half? [1, 2, 3, 4, 5] 3) '(1,2,3)))
  (is (= (which-half? [1, 3, 5, 67, 99] 7) '(67,99)))
  (is (= (which-half? [1, 3, 5, 67, 99] 5) '(1,3,5)))
    )

(deftest can-tell-whether-a-target-exist
  (is (= (where-is-it? [1, 2, 3, 4] 1) :true))
  (is (= (where-is-it? [1, 2, 3, 4] 4) :true))
  (is (= (where-is-it? [1, 2, 3, 4] 5) nil))
  )

(run-tests)