(ns stiltzkin.core
  (:gen-class)
  (:require [clojure.math.combinatorics :as combo]
            [clojure.string :as str]))

;; Words may have started with a capital letter or not
;; Words may have had a space between them or not
;; Passphrase may have had a period
;; Passphrase may have had a newline at the end or not
;; Passphrase may have had a carriage return at the end or not
;; Passphrase may have had a space at the end or not

(str/lower-case "HELLO")
(str/upper-case "Hello")

(defn -main
  "Generates possible combinations for a passphrase given the ordered list of element words"
  [& args]
  (println "Hello, World!"))
