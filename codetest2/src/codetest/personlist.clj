(ns codetest.personlist)

(defn make-a-person [lastname firstname middle-initial sex color birthdate]
  (let [person {:lastname lastname,
                :firstname firstname,
                :middle-initial middle-initial,
                :sex sex,
                :color color,
                :birthdate birthdate}]
    person))

(defn split [longstring delimiter]
  (map #(.trim %) (.split longstring delimiter)))

(defn delim [string]
  (if (.contains string ",") "," (if (.contains string "|") "\\|" (if (.contains string " ") " "))))

(defn parse-date [date-string format]
  (let [date-formatter (java.text.SimpleDateFormat. format)]
    (.parse date-formatter date-string)))

(defn parse-sex [param]
  (if (.startsWith (.toLowerCase param) "m") :male :female))

(defmulti parse-line delim)

(defmethod parse-line "," [string]
  (let [row (split string ",")]
    (make-a-person (nth row 0) (nth row 1) "" (parse-sex (nth row 2)) (nth row 3) (parse-date (nth row 4) "MM/dd/yyyy"))))

(defmethod parse-line "\\|" [string]
  (let [row (split string "\\|")]
    (make-a-person (nth row 0) (nth row 1) (nth row 2) (parse-sex (nth row 3)) (nth row 4) (parse-date (nth row 5) "MM-dd-yyyy"))))

(defmethod parse-line " " [string]
  (let [row (split string " ")]
    (make-a-person (nth row 0) (nth row 1) (nth row 2) (parse-sex (nth row 3)) (nth row 5) (parse-date (nth row 4) "MM-dd-yyyy"))))

(defn parse-and-sort-by-last-name-desc [text]
  (sort-by :lastname #(.compareTo %2 %1) (map #(parse-line %) (split text "\n"))))

(defn complicated-compare [firstvector secondvector]
  (let [sex-is-the-same (.compareTo (.toString (first firstvector)) (.toString (first secondvector)))]
    (cond
      (= sex-is-the-same 0) (.compareTo (nth firstvector 1) (nth secondvector 1))
      :else sex-is-the-same)))

(defn parse-and-sort-by-sex-then-last-name [text]
  (sort-by #(vec (map % [:sex :lastname])) complicated-compare (map #(parse-line %) (split text "\n"))))

(defn parse-and-sort-by-birthdate [text]
  (sort-by :birthdate (map #(parse-line %) (split text "\n"))))

(defn output [list-of-persons]
  (map #(str (:lastname %) " " (:firstname %) " " (:sex %) " " (:birthdate %) " " (:color %) "\n") list-of-persons))

(defn person-roster []
  (let [text (str
    (slurp "../codetest_files/input_files/comma.txt") "\n"
    (slurp "../codetest_files/input_files/pipe.txt") "\n"
    (slurp "../codetest_files/input_files/space.txt"))]
    (map #(print %)
      (list (output (parse-and-sort-by-sex-then-last-name text))
        (output (parse-and-sort-by-birthdate text))
        (output (parse-and-sort-by-last-name-desc text))))))