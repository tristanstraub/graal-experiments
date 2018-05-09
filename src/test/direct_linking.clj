(ns test.direct-linking
  (:gen-class))

(defn fib
  ([n]
   (take n (fib 1 1)))
  ([a b]
   (cons a (lazy-seq (fib b (+ a b))))))

(defn -main []
  (println (fib 20)))
