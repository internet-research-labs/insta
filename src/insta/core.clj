(ns insta.core
  (:require [clojure.tools.cli :refer [parse-opts]])
  (:require [clj-http.client :as client])
  (:use [compojure.route :only [files not-found]]
        [compojure.handler :only [site]]
        [compojure.core :only [defroutes GET POST DELETE ANY context]])
  (:use org.httpkit.server)
  (:gen-class))

; Parse argeuments
(def cli-options
  [["-k" "--client-key" "client key"
    :default "key"
    :id :client-key]
   ["-s" "--secret-key" "secret key"
    :default "secret-key"
    :id :secret-key]])

;; List of available routes
;; List of available routes
;; List of available routes
(defroutes yer-routes
  ;; DocumentRoot
  (GET "/" [] {:status 200
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
