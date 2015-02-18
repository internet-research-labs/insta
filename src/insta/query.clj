(ns insta.query
  (:require [clojure.string :as string]))

;; j o i n - k e y - v a l
;; j o i n - k e y - v a l
;; j o i n - k e y - v a l

(defn join-key-val [param-key param-val]
  "
  Join a Parameter Key and a Value
  @Note This is a function that is used by `params`
  @param param-key string
  @param param-val string
  @return string
  "
  (string/join "=" [(name param-key) param-val]))

;; p a i r - a r r a y
;; p a i r - a r r a y
;; p a i r - a r r a y

(defn pair-array [p]
  "
  Return 
  "
  (if (or (nil? p) (empty? p))
    []
    (map (fn [entry-key] (join-key-val entry-key (entry-key p))) (keys p))))

;; p a r a m s
;; p a r a m s
;; p a r a m s

(defn params [p]
  "
  @param p hash-map
  @return string
  "
  (if (or (nil? p) (empty? p))
    ""
    (string/join "" ["?" (string/join "" (pair-array p))])))
