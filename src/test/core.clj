(ns test.core
  (:gen-class)
  (:import clojure.lang.IFn))

(defn -main
  [& args]
  (prn :args args))
