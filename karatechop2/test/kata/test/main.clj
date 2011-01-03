(ns kata.test.main
  (:use [kata.main])
  (:use [clojure.test]))


;(deftest can-split-an-array
;  (is (= (which-half? [1, 2, 3, 4] 1) :first_half))
;  (is (= (which-half? [1, 2, 3, 4] 2) :first_half))
;  (is (= (which-half? [1, 2, 3, 4, 5] 3) :first_half))
;  (is (= (which-half? [1, 3, 5, 67, 99] 7) :second_half))
;  (is (= (which-half? [1, 3, 5, 67, 99] 5) :first_half))
;    )

(deftest can-tell-whether-a-target-exist
;  (is (= (where-is-it? [1, 2, 3, 4] 1) 0))
  (is (= (where-is-it? [1, 2, 3, 4] 4) 3))
;  (is (= (where-is-it? [1, 2, 3, 4] 5) nil))
  )

(run-tests)