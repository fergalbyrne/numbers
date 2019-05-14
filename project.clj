(defproject numbers "0.1.0"
  :description "read numbers between 1 and 100 in English"
  :url "http://example.com/FIXME"
  :dependencies [[org.clojure/clojure "1.10.0"]]

  :main ^:skip-aot numbers.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}
             :dev {:dependencies [[proto-repl "0.3.1"]
                                  [pjstadig/humane-test-output "0.9.0"]
                                  [org.clojure/test.check "0.9.0"]]
                   :plugins [[com.jakemccrary/lein-test-refresh "0.24.1"]]
                   :injections [(require 'pjstadig.humane-test-output)
                                (pjstadig.humane-test-output/activate!)]
                   :test-refresh {:notify-command ["terminal-notifier" "-title" "Tests" "-message"]
                                     :quiet true
                                     :changes-only true}}})
