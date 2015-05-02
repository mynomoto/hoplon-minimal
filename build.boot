(set-env!
  :dependencies  '[[adzerk/boot-cljs          "0.0-2814-3"]
                   [adzerk/boot-cljs-repl     "0.1.9"]
                   [adzerk/boot-reload        "0.2.6"]
                   [tailrecursion/boot-hoplon "0.1.0-SNAPSHOT"]
                   [tailrecursion/hoplon      "6.0.0-SNAPSHOT"]]
  :source-paths   #{"src"})

(require
  '[adzerk.boot-cljs          :refer [cljs]]
  '[adzerk.boot-reload        :refer [reload]]
  '[adzerk.boot-cljs-repl     :refer [cljs-repl start-repl]]
  '[tailrecursion.boot-hoplon :refer [hoplon prerender]])

(deftask dev
  "Build hoplon-minimal for local development."
  []
  (comp
    (watch)
    (speak)
    (hoplon)
    (reload)
    (cljs-repl)
    (cljs)))

(deftask prod
  "Build hoplon-minimal for production deployment."
  []
  (comp
    (hoplon)
    (cljs :optimizations :advanced)
    (prerender)))
