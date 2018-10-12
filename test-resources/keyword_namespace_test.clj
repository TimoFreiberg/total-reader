(ns keyword-namespace-test
  (:require [clojure.string :as string]))

::string/test

(let [m #::string{:key1 "val"
                  :key2 "other val"}
      {::string/keys [key1 key2]} m]
  [key1 key2])
