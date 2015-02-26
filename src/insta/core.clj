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
        [clojure.data.json :as json]
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

;; g e t - i m a g e s
;; g e t - i m a g e s
;; g e t - i m a g e s

(defn get-images
  "
  Get Images from Response
  @param x
  @return tuple of url's
  "
  [x]

  (defn get-low-resolution-url [item]
    (if (contains? item :images)
      (:url (:low_resolution (:images item)))
      nil))

  (let [result (json/read-str (:body x) :key-fn keyword)
        data (:data result)]

    ;; Remove nil and empty
    (filter some? (map get-low-resolution-url data))))

;; g e 

(defn get-images-url
  "Returns a List of URL
  - client-key: a string
  - secret-key: a string
  - tag: a string
  "
  [client-id secret-key tag]
  (get-images (request-tag client-id secret-key tag)))



;; - m a i n
;; - m a i n
;; - m a i n

(defn -main [& args]

  ;; Parse options and store
  (let [{:keys [options arguments errors summary]} (parse-opts args cli-options)
        client-id (:client-key options)
        secret-key (:secret-key options)
        ;; client-key=597d57d253d446a89bda86c03b129326
        ;; secret-key=38a6ea19033641d987385bf8de52d16a
        image-list (get-images-url client-id secret-key "yolo")]

    (println errors)
    (println image-list))

  ;; Run the server
  ;; (run-server (site #'app-routes) {:port 8080})

  ;; x_x
  (println "x_x"))
