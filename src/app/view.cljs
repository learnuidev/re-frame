(ns app.view
  (:require [reagent.core :as r]))

(defonce app-state (r/atom 0))

(defn app []
   [:div
    [:button {:on-click #(swap! app-state inc)} "Inc"]
    [:div "Counter: " @app-state]])
