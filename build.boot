(set-env!
  :dependencies '[[adzerk/boot-cljs          "1.7.48-3"]
                  [adzerk/boot-reload        "0.3.2"]
                  [org.clojure/clojurescript "1.7.122"]
                  [org.clojure/clojure       "1.7.0"]
                  [hoplon/boot-hoplon        "0.1.9"]
                  [hoplon/hoplon             "6.0.0-alpha10"]]
  :source-paths #{"src"})

(require
  '[adzerk.boot-cljs   :refer [cljs]]
  '[adzerk.boot-reload :refer [reload]]
  '[hoplon.boot-hoplon :refer [hoplon prerender]])

(deftask dev
  "Build hoplon-minimal for local development."
  []
  (comp
    (watch)
    (speak)
    (hoplon)
    (reload)
    (cljs)))

(deftask prod
  "Build hoplon-minimal for production deployment."
  []
  (comp
    (hoplon)
    (cljs :optimizations :advanced)
    (prerender)))
