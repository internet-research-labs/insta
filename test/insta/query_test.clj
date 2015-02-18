(ns insta.query-test
  (:require [clojure.test :refer :all]
            [insta.query :refer :all]))

(deftest params-returns-string
  (testing "query parameter returns a string"
    (let [result (params nil)]
      (is (string? result))
      (is (count result) 0))))

(deftest params-returns-nonzero-string-1
  (testing "query parameter returns a string"
    (let [result (params nil)]
      (is (string? result)))))

(deftest params-returns-nonzero-string-2
  (testing "query parameter returns a string"
    (let [result (params {})]
      (is (= result "")))))

(deftest params-returns-nonzero-string-3
  (testing "query parameter returns a string"
    (let [result (params {:red 10})]
      (is (= result "?red=10")))))

;; j o i n - k e y - v a l
;; j o i n - k e y - v a l
;; j o i n - k e y - v a l

(deftest test-join-key-val
  (testing "can join key and val"
    (let [result (join-key-val "red" 10)]
      (is (= result "red=10")))))

;; a r r a y
;; a r r a y
;; a r r a y

(deftest test-join-key-val
  (testing "can join key and val"
    (let [result (pair-array {})]
      (is (= (count result) 0)))))

(deftest test-join-key-val
  (testing "can join key and val"
    (let [result (pair-array {:red 10 :blue 20})]
      (is (= (count result) 2)))))
