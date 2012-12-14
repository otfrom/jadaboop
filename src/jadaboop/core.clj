(ns jadaboop.core
  (:use cascalog.api)
  (:require [cascalog [vars :as v] [ops :as c] [workflow :as w]]
            [clojure.string :as s])
  (:import  [com.twitter.maple.jdbc JDBCScheme JDBCTap TableDesc]
            [cascading.tuple Fields])
  (:gen-class))

(def tweets
  [["mrjaba-1" "mrjaba" "tweet 1"]
   ["mrjaba-2" "mrjaba" "tweet 2"]
   ["bld-1" "bld" "tweet 1"]
   ["bld-2" "bld" "tweet 2"]
   ["bld-3" "bld" "tweet 3"]
   ])

(defn db-tap []
  (let [scheme (JDBCScheme.
                (Fields. (into-array String ["?id" "?handle" "?tweet"]))
                (into-array String ["id" "handle" "tweet"]))
        table-desc (TableDesc. "tweets"
                               (into-array String ["?id"])
                               (into-array String ["id"])
                               (into-array String []))
        tap (JDBCTap. "jdbc:postgresql://localhost:5432/bld"
                      "<username>"
                      "<password>"
                      "org.postgresql.Driver"
                      ;;"com.mysql.jdbc.Driver"
                      table-desc
                      scheme)]
    tap))
 
(defn -main []
  (?<-
   (db-tap)
   ;;(stdout)
   [?id ?handle ?tweet]
   (tweets ?id ?handle ?tweet))
  )
