(ns test.core
  (:gen-class)
  (:import clojure.lang.IFn
           (org.graalvm.polyglot Context)
           org.graalvm.nativeimage.IsolateThread
           org.graalvm.nativeimage.c.function.CEntryPoint
           org.graalvm.word.Pointer)
  (:require [clojure.java.io :as io]))

(defn -main
  [& args]
  (let [context (.. (Context/newBuilder (into-array ["R"])) (allowAllAccess true) (build))]

    (prn :args args)
    (prn :result (.eval context "R" "
3^2 + 2^2
"))

;;        (prn :result (.eval context "R" (slurp (io/resource "svg.r"))))
    ))
