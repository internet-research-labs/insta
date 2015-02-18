(ns insta.routes
  (:require [clojure.tools.cli :refer [parse-opts]]
            [clj-http.client :as client]
            [clojure.string :as string])
  (:use [compojure.route :only [files not-found]]
        [compojure.handler :only [site]]
        [compojure.core :only [defroutes GET POST DELETE ANY context]]
        [org.httpkit.server]
        [insta.gram]
        [clostache.parser])
  (:gen-class))


;; List of available routes
;; List of available routes
;; List of available routes
(defroutes app-routes
  ;; DocumentRoot
  (GET "/" [] {:status 200
               :header {"Content-Type" "text/html"}
               :body (render-resource "templates/index.mustache" {:name "matt vv/e"})})

  ;; h a n d s h a k e
  (GET "auth" [] {:status 200
                  :header {"Content-Type" "text/html"}
                  :body "Because we are your friends"})

  ;; n e w i m a g e
  (GET "/new-image" [] {:status 200
                        :header {"Content-Type" "text/html"}
                        :body "Because we are your friends"})

  ;; n e w i m a g e
  (POST "/new-image" [] {:status 200
                         :header {"Content-Type" "text/html"}
                         :body "You'll never be alone again"}))
