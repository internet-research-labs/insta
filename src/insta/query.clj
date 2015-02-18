(ns insta.query
  (:require [clojure.string :as string]))

(defn join-key-val [param-key param-val]
  "
  Join a Parameter Key and a Value
  @Note This is a function that is used by `params`
  @param param-key string
  @param param-val string
  @return string
  "
  (string/join "=" [param-key param-val]))

(defn pair-array [p]
  "
  Return 
  "
  (if (or (nil? p) (empty? p))
    []
    (map (fn [entry-key] (join-key-val (name entry-key) (entry-key p))) (keys p))))

(defn params [p]
  "
  @param p hash-map
  @return string
  "
  (if (or (nil? p) (empty? p))
    ""
    (string/join "" ["?" (string/join "" (pair-array p))])))
