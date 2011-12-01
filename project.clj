(defproject expectations "1.3.0"
  :description "testing framework"
  :jar-name "expectations.jar"
  :java-source-path "src"
  :test-path "test/clojure"
  :dev-dependencies [[lein-expectations "0.0.1"]]
  :dependencies [[org.clojure/clojure "1.2.0"]
                 [junit/junit "4.8.1"]])

(ns leiningen.publish
  (:require leiningen.jar)
  (:use clojure.java.shell))

(defn publish [project & args]
  (leiningen.jar/jar project)
  (let [response (apply sh "fig" "--publish" (str (:name project) "/" (:version project)) args)]
    (println "OUT:" (:out response))
    (println "ERR:" (:err response))))
