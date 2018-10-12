# total-reader

A clojure reader which can read keywords with namespace aliases.

It should be able to read all idiomatic clojure files.

Built on top of [org.clojure/tools.reader](https://github.com/clojure/tools.reader).

Extracted from https://github.com/jonase/kibit, which introduced this functionality to fix https://github.com/jonase/kibit/issues/14

## Why choose this over tools.reader?

If you want to be able to read a file containing namespace aliased keywords, map namespace syntax or [namespaced map binding destructuring](https://clojure.org/reference/special_forms#_map_binding_destructuring).

Resolving namespace aliases at read time requires an alias map, which 


## Usage

See https://github.com/clojure/tools.reader#example-usage

## License

Copyright © 2018 Timo Freiberg

Distributed under the Eclipse Public License either version 1.0 or (at
your option) any later version.
