(ns codetest.test.personlist
  (:use [codetest.personlist])
  (:use [clojure.test]))

(deftest make-person-will-make-a-person
  (let [person (make-a-person "schwarz" "john" "m" "male" "tan" "12/23/2001")]
    (is (= (:firstname person) "john"))
    (is (= (:lastname person) "schwarz"))
    (is (= (:middle-initial person) "m"))
    (is (= (:sex person) "male"))
    (is (= (:color person) "tan"))
    (is (= (:birthdate person) "12/23/2001"))
    )
  )

(deftest split-a-string
  (let [wordlist (split "a b c" " ")]
    (is (= (count wordlist) 3)))
  (let [wordlist (split "ants | before | chores" "\\|")]
    (is (= (first wordlist) "ants")))
  )

(deftest determine-delimiter
  (let [delimiter (delim "long time")]
    (is (= delimiter " "))
    )
  (let [delimiter (delim "long, time")]
    (is (= delimiter ","))
    )
  (let [delimiter (delim "long | time")]
    (is (= delimiter "\\|"))
    )
  )

(deftest can-parse-a-line-into-a-person
  (let [person (parse-line "Abercrombie, Neil, Male, Tan, 2/13/1943")]
    (is (= (:lastname person) "Abercrombie"))
    (is (= (:firstname person) "Neil"))
    (is (= (:sex person) :male))
    (is (= (:color person) "Tan"))
    )
  (let [person (parse-line "Smith | Steve | D | M | Red | 3-3-1985")]
    (is (= (:firstname person) "Steve"))
    )
  (let [person (parse-line "Kournikova Anna F F 6-3-1975 Red")]
    (is (= (:firstname person) "Anna"))
    (is (= (:color person) "Red"))
    (is (= (:sex person) :female))
    )
  )

(deftest can-parse-multiple-lines-and-sort
  (let [list-of-people (parse-and-sort-by-last-name-desc "Smith | Steve | D | M | Red | 3-3-1985\nKournikova Anna F F 6-3-1975 Red")]
    (is (= (:firstname (first list-of-people)) "Steve"))
    (is (= (:firstname (last list-of-people)) "Anna"))
    )
  (let [list-of-people (parse-and-sort-by-sex-then-last-name "Seles Monica H F 12-2-1973 Black\nSmith | Steve | D | M | Red | 3-3-1985\nKournikova Anna F F 6-3-1975 Red")]
    (is (= (:firstname (first list-of-people)) "Anna"))
    (is (= (:firstname (nth list-of-people 1)) "Monica"))
    (is (= (:firstname (last list-of-people)) "Steve"))
    )
  (let [list-of-people (parse-and-sort-by-birthdate "Seles Monica H F 12-2-1973 Black\nSmith | Steve | D | M | Red | 3-3-1985\nKournikova Anna F F 6-3-1975 Red")]
    (is (= (:firstname (first list-of-people)) "Monica"))
    (is (= (:firstname (nth list-of-people 1)) "Anna"))
    (is (= (:firstname (last list-of-people)) "Steve"))
    )
  )

(deftest can-do-complicated-compare
  (is (> (complicated-compare [:female "hingis"] [:female "apfel"]) 0))
  )

(deftest can-parse-date
  (let [bdate (parse-date "12/23/2009" "MM/dd/yyyy")]
    (is (= (.toString bdate) "Wed Dec 23 00:00:00 EST 2009")))

  (let [bdate (parse-date "12-23-2009" "MM-dd-yyyy")]
    (is (= (.toString bdate) "Wed Dec 23 00:00:00 EST 2009")))
  )

(deftest can-parse-sex
  (let [sex (parse-sex "Male")]
    (is (= sex :male))
    )
  (let [sex (parse-sex "FeMale")]
    (is (= sex :female))
    )
  )

(deftest can-open-and-slurp-files
  (person-roster)
  )

(run-tests)

