# total-reader

[![Clojars Project](https://img.shields.io/clojars/v/total-reader.svg)](https://clojars.org/total-reader)
[![Build Status](https://travis-ci.org/TimoFreiberg/total-reader.svg?branch=master)](https://travis-ci.org/TimoFreiberg/total-reader)

`[total-reader "1.0.1"]`

A clojure reader which can read keywords with namespace aliases.

It should be able to read all idiomatic clojure files.

Built on top of [org.clojure/tools.reader](https://github.com/clojure/tools.reader).

Extracted from https://github.com/jonase/kibit, which introduced this functionality to fix https://github.com/jonase/kibit/issues/14

## Why use this library?

If you want to be able to read a file containing namespace aliased keywords, map namespace syntax or [namespaced map binding destructuring](https://clojure.org/reference/special_forms#_map_binding_destructuring).

#### Example file containing these features:
```clojure
(ns keyword-namespace-test
  (:require [clojure.string :as string]))

;; namespace aliased keyword
::string/test

;; map namespace syntax using an alias
(let [m #::string{:key1 "val"
                  :key2 "other val"}
       ;; namespaced map binding destructuring using an alias
      {::string/keys [key1 key2]} m]
  [key1 key2])
```

## Usage

```clojure
(require 'total-reader.core :as reader)

(reader/read-file
 (-> "path/to/file.clj"
     io/reader
     LineNumberingPushbackReader.)
 'user)
```

## License

Copyright © 2018 Timo Freiberg

Distributed under the Eclipse Public License either version 1.0 or (at
your option) any later version.
