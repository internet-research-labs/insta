(ns insta.request
  (:require [clj-http.client :as client]
            [clojure.string :as string])
  (:import [javax.imageio ImageIO]
           [java.awt.image BufferedImage])
           ; [java.io ByteArrayInputStream InputStream]

  (:use [clojure.java.io :refer :all]
        [insta.gram]
        [insta.query :only [params]]))


;; s t r - c a t
;; s t r - c a t
;; s t r - c a t

(defn str-cat [])

;; U R L
;; U R L
;; U R L

(def INSTA-URL 
  "https://api.instagram.com/v1/")

;; T A G U R L
;; T A G U R L
;; T A G U R L

(def INSTA-TAG-URL
  "https://api.instagram.com/v1/tags")

;; r e q u e s t
;; r e q u e s t
;; r e q u e s t

(defn request-tag [tag]
  "
  Request HTTP Response for `tag`
  Return the JSON response from the tag endpoint for tag
  @param tag string
  @return hash-map json
  "
  (def client-id "597d57d253d446a89bda86c03b129326")
  (def secret-key "38a6ea19033641d987385bf8de52d16a")
  (let [url (string/join "/" [INSTA-TAG-URL tag "media" "recent"])
        qp (params {:client_id client-id :client_secret secret-key})]
    (client/get (string/join "" [url qp]))))

;; r e q u e s t - i m a g e
;; r e q u e s t - i m a g e
;; r e q u e s t - i m a g e

(defn request-image [url]
  "
  Synchronous Return of HTTP Response
  @param url string
  @return bytes
  "
  (ImageIO/read (clojure.java.io/input-stream url)))

  ;; ok
; (let [result (client/get url {:as byte-array})]

;   ;; ok
;   (let [bais (input-stream result)]

;     ;; ok
;     (ImageIO/read url))))
