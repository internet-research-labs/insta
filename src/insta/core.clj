(ns insta.core
  (:require [clojure.tools.cli :refer [parse-opts]]
            [clj-http.client :as client]
            [clojure.string :as string])
  (:use [compojure.route :only [files not-found]]
        [compojure.handler :only [site]]
        [compojure.core :only [defroutes GET POST DELETE ANY context]])
  (:use org.httpkit.server)
  (:gen-class))

(defn not-empty? [x]
  (not (string/blank? x)))

;; Argument Parser
(def cli-options

  ;; client-key argument
  [["-k" "--client-key CLIENT-KEY" "client-key"
    :id :client-key
    :validate [not-empty? "client-key must be non-empty"]]
   
   ;; secret-key argument
   ["-s" "--secret-key SECRET-KEY" "secret-key"
    :id :secret-key
    :validate [not-empty? "secret-key must be non-empty"]]])


;; List of available routes
;; List of available routes
;; List of available routes
(defroutes yer-routes
  ;; DocumentRoot
  (GET "/" [] {:status 200
               :header {"Content-Type" "text/html"}
               :body "Because we are your friends"})

  ;; ;;
  (GET "/handshake" [] {:status 200
                        :header {"Content-Type" "text/html"}
                        :body "Because we are your friends"})

  ;; matt handler
  (GET "/matt" [] {:status 200
                   :header {"Content-Type" "text/html"}
                   :body "You'll never be alone again"}))


; Main
(defn -main [& args]

  ;; Parse options and store
  (let [{:keys [options arguments errors summary]} (parse-opts args cli-options)]
    (println options)
    (println errors))
  
  (run-server (site #'yer-routes) {:port 8080})

  ; x_x
  (println "x_x"))
