(ns insta.core
  (:require [clojure.tools.cli :refer [parse-opts]]
            [clj-http.client :as client]
            [clojure.string :as string])
  (:use [compojure.route :only [files not-found]]
        [compojure.handler :only [site]]
        [compojure.core :only [defroutes GET POST DELETE ANY context]]
        [org.httpkit.server]
        [insta.gram]
        [insta.routes :only [app-routes]]
        [clostache.parser])
  (:gen-class))


;; Argument parser
;; Argument parser
;; Argument parser
(def cli-options 

  ;; create local scope for validator functions
  (letfn [(not-empty? [x] (not (string/blank? x)))]

    ;; client-key argument
    [["-k" "--client-key CLIENT-KEY" "client-key"
      :id :client-key
      :validate [not-empty? "client-key must be non-empty"]]
     
     ;; secret-key argument
     ["-s" "--secret-key SECRET-KEY" "secret-key"
      :id :secret-key
      :validate [not-empty? "secret-key must be non-empty"]]]))


;; Main
;; Main
;; Main
(defn -main [& args]

  ;; Parse options and store
  (let [{:keys [options arguments errors summary]} (parse-opts args cli-options)]
    (println options)
    (println errors))

  ;; Run the server
  (run-server (site #'app-routes) {:port 8080})


  ; https://api.instagram.com/v1/tags/{tag-name}?access_token=ACCESS-TOKEN
  ; 597d57d253d446a89bda86c03b129326
  ; 38a6ea19033641d987385bf8de52d16a
  (def url "https://api.instagram.com/v1/media/popular?")
  (def client-id "597d57d253d446a89bda86c03b129326")
  (def secret-key "597d57d253d446a89bda86c03b129326")

; (let [url (string/join "" (url client-id
; (let [res (client/GET "https://api.instagram.com/v1/media/popular?client_id=CLIENT-ID")]
;   (println res))

  ; x_x
  (println "x_x"))
