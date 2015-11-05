(ns stiltzkin.core
  (:gen-class)
  (:require [clojure.math.combinatorics :as combo]
            [clojure.string :as str]))

;; Words may have started with a capital letter or not
;; Words may have had a leading space or not
;; Words may have had a trailing space or not 
;; Passphrase may have had a leading space
;; Passphrase may have had a period
;; Passphrase may have had a newline at the end or not
;; Passphrase may have had a carriage return at the end or not
;; Passphrase may have had a space at the end or not

(def with-trailing-space
  (fn [w]
    (str w " ")))

(def with-leading-space
  (fn [w]
    (str " " w)))

(def as-is
  (fn [w]
    w))

(def possibilities
  (juxt with-leading-space as-is with-trailing-space))



(possibilities "stuart")
(str/lower-case "HELLO")
(str/upper-case "Hello")

(defn -main
  "Generates possible combinations for a passphrase given the ordered list of element words"
  [& args]
  (println "Hello, World!"))
