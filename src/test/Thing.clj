(ns test.Thing
  (:import org.graalvm.nativeimage.IsolateThread
           org.graalvm.word.Pointer)
)

(gen-class
 :name test.Thing
 :main false
 :methods [#^{:static true}
           [;; #^{org.graalvm.nativeimage.c.function.CEntryPoint {:name "add3"}}
            add3 [;; org.graalvm.nativeimage.IsolateThread
                  int int
                  ] int]])

(defn -add3
  [a b]
  @(future (Thread/sleep 1000)
           10))
