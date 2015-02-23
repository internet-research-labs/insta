(ns insta.core
  (:require [clojure.tools.cli :refer [parse-opts]]
            [clj-http.client :as client]
            [clojure.string :as string]
            ; [javax.imageio.ImageIO :as imageio]
            )
  (:use [compojure.route :only [files not-found]]
        [compojure.handler :only [site]]
        [compojure.core :only [defroutes GET POST DELETE ANY context]]
        [org.httpkit.server]
        [insta.gram]
        [insta.routes :only [app-routes]]
        [insta.request :only [request-tag request-image]]
        [insta.requester]
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
    ; (println options)
    (println errors)

    (let [client-id (:client-key options)
          secret-key (:secret-key options)]

      (println client-id)
      (println secret-key)

      ;; *_*
      ;; o_o
      ;; -_-
      (let [tag-requester (insta.requester/tag-requester client-id secret-key)]
        (println (tag-requester "yolo")))
      ))

  ;; Run the server
  ; (run-server (site #'app-routes) {:port 8080})

  ;; request tag information from instagram, then print
  ; (println (request-tag "yolo"))
  ; (println (request-tag "yolo"))


  ;; 597d57d253d446a89bda86c03b129326
  ;; 38a6ea19033641d987385bf8de52d16a


  ;; x_x
  (println "x_x"))
