(defproject jadaboop "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :repositories {"conjars" "http://conjars.org/repo"}
  :dependencies [[org.clojure/clojure "1.4.0"]
                 [cascalog "1.10.0"]
                 ;; Cascalog JDBC tap
                 [com.twitter/maple "0.2.5"]
                 ;; JDBC driver for postgres
                 [postgresql/postgresql "9.1-901.jdbc4"]
                 ;; Command line args processing
                 [org.clojure/tools.cli "0.2.1"]]
  :profiles {:dev
             {:dependencies [[org.apache.hadoop/hadoop-core "0.20.2-dev"]
                             [midje-cascalog "0.4.0"]
                             [lein-midje "1.0.10"]]}})
