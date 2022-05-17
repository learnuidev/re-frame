(ns app.view
  (:require [reagent.core :as r]
            [reagent.ratom :refer [reaction]]
            [app.re-frame.core :as rf]))

;; initial state
(defonce initial-state {:counter 0})


;; reg-event-db
(rf/register-handler
 :increment
 (fn [db _]
   (update db :counter inc)))

(rf/register-handler
 :init
 (fn [db _]
   initial-state))

(rf/dispatch-sync [:init])

;; subscriptions 101
(rf/register-sub
  :counter
  (fn
    [db _]
    ;; you need to wrap your subscription code in a reaction
    (reaction (:counter @db))))

(comment)
(comment
  @(rf/subscribe [:counter]))


(defn app []
   [:div
    [:button {:on-click #(rf/dispatch [:increment])}
     "Increment 2"]
    [:div "Counter: "   @(rf/subscribe [:counter])]])
