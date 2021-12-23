(ns app.core
  (:require [reagent.core :as r]
            [reagent.dom :as rdom]
            [app.view :refer [app]]))

(defn ^:dev/after-load render
  "Render the toplevel component for this app."
  []
  (rdom/render [app] (.getElementById js/document "app")))

(defn ^:export main
  "Run application startup logic."
  []
  (render))
