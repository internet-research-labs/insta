(defproject de.razorbla/insta "0.1.0-SNAPSHOT"
  :description "Instagram for math heads yo"
  :url "http://example.com/FIXME"
  :main insta.core
  :license {:name "UNLICENSE"
            :url "http://unlicense.org"}
  :dependencies [[org.clojure/clojure "1.6.0"]
                 [org.clojure/tools.cli "0.3.1"]
                 [org.clojure/core.async "0.1.346.0-17112a-alpha"]
                 [clj-http "1.0.1"]
                 [http-kit "2.1.16"]
                 [javax.servlet/servlet-api "2.5"]
                 [ring/ring-core "1.3.2"]
                 [de.ubercode.clostache/clostache "1.4.0"]
                 [compojure "1.3.1"]])
