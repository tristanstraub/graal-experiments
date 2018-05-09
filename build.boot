(set-env! :dependencies '[[org.clojure/clojure "1.9.0"]
                          [org.graalvm/graal-sdk "1.0.0-rc1"]
                          [criterium "0.4.4"]]
          :source-paths #{"src"}
          :resource-paths #{"resources"})

(def my-compiler-opts
  {:direct-linking true})

(deftask build
  []
  (comp (javac)
        (aot :all true)
        (uber)
        (jar :main 'test.core :file "libproject.jar")))

(deftask dev
  []
  (with-pre-wrap fs
    (alter-var-root #'clojure.core/*compiler-options*
                    (constantly my-compiler-opts))
    fs))

(deftask direct
  []
  (comp (dev)
        (build)))
