(ns total-reader.core-test
  (:require [clojure.test :refer :all]
            [total-reader.core :as reader]
            [clojure.java.io :as io])
  (:import [clojure.lang LineNumberingPushbackReader]))

(deftest derive-aliases-test
  (are [expected-alias-map ns-form]
      (= expected-alias-map (reader/derive-aliases ns-form))
    '{foo foo.bar.baz} '(ns derive.test.one
                          (:require [foo.bar.baz :as foo]))
    '{foo foo.bar.baz
      foom foo.bar.baz.macros} '(ns derive.test.one
                                  (:require [foo.bar.baz :as foo])
                                  (:require-macros [foo.bar.baz.macros :as foom]))
    '{str clojure.string} '(require (quote [clojure.string :as str]))
    '{pprint clojure.pprint} '(alias 'pprint 'clojure.pprint)))

(deftest read-file-test
  (is (reader/read-file (-> "test/resources/keyword_namespace_test.clj"
                            io/file
                            io/reader
                            LineNumberingPushbackReader.)
                        'user)))
