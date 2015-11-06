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

;; Juxt should be fed all the functions that will mutate. However, I reserve
;; the right to create that list of functions dynamically.

;; Testing to see if that would work.
(def whitespace-mutators [with-leading-space as-is with-trailing-space])
(def capitalization-mutators [str/lower-case str/upper-case str/capitalize])
;; What if I use the combinators package to create the caresian product of
;; the set of functions dealing with spacing and the set of functions that
;; deal with capitalization?

(def composed
  (fn [args]
    (apply comp args)))

(def mutators (map composed (combo/cartesian-product whitespace-mutators capitalization-mutators)))

;; I'm assuming there's duplication here that will need to be removed from the
;; functions and so (with-leading-space (str/upper-case w))
;; will be commutative. Then again, maybe it will try and capitalize the
;; leading whitespace. That's one to check.

(def word-variations
  (apply juxt mutators))

(def phrase-variations
  (fn [words]
    (apply combo/cartesian-product (map word-variations words))))

(defn -main
  "Generates possible combinations for a passphrase given the ordered list of element words"
  [& args]
  (println (map str/join (phrase-variations args))))
