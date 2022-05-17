(ns app.re-frame.db
  (:require [reagent.core :as reagent]))


;; -- Application State  --------------------------------------------------------------------------
;;
;; Should not be accessed directly by application code
;; Read access goes through subscriptions.
;; Updates via event handlers.
(def  app-db (reagent/atom {}))


(comment
  @app-db)

(comment
  (reset! app-db {:counter 0}))
