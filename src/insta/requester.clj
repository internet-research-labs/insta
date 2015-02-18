(ns insta.requester
  (:require [clj-http.client :as client]
            [clojure.string :as string])
  (:use [insta.gram]
        [insta.query :only [params]]))


;; T A G U R L
;; T A G U R L
;; T A G U R L

(def INSTA-TAG-URL
  "https://api.instagram.com/v1/tags")

;; t a g - r e q u e s t e r
;; t a g - r e q u e s t e r
;; t a g - r e q u e s t e r

(defn tag-requester [client-id secret-key]
  "
  Return a requester closure
  Returns an anonymous function that returns media for the specified tag
  @param client-id string client id
  @param secret-key string secret key
  @return function that can get a particular tag
  "
  ; Return anonymous function with proper specs for client stuff
  (fn [tag]
    (let [url (string/join "/" [INSTA-TAG-URL tag "media" "recent"])
          qp (params {:client_id client-id :client_secret secret-key})]
      (client/get (string/join "" [url qp])))))
