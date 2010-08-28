(ns lazytest.runtests
  (:require lazytest.runner.console
	    lazytest.report.nested))

(doseq [sym '[lazytest.expect-asserts
	      lazytest.context.stub-asserts]]
  (println "Running assertions in" sym)
  (require sym))

(println "All assertions passed.")

(doseq [sym '[examples.suite1
	      examples.describe1]]
  (println "Loading" sym)
  (require sym)
  (println "Running tests in" sym)
  (lazytest.report.nested/report
   (lazytest.runner.console/run-tests sym)))


