(ns app.re-frame.core
  (:require
    [app.re-frame.handlers   :as handlers]
    [app.re-frame.subs       :as subs]
    [app.re-frame.router     :as router]
    [app.re-frame.middleware :as middleware]))


;; --  API  -------

(def dispatch         router/dispatch)
(def dispatch-sync    router/dispatch-sync)

(def register-sub  subs/register)
(def subscribe     subs/subscribe)



(def pure        middleware/pure)
(def debug       middleware/debug)
(def undoable    middleware/undoable)
(def path        middleware/path)
(def enrich      middleware/enrich)
(def trim-v      middleware/trim-v)
(def after       middleware/after)
; (def log-events  middleware/log-events)

(comment
  (type pure)
  (fn? pure))



;; --  Convenience API -------

;; Almost 100% of handlers will be pure, so make it easy to
;; register with "pure" middleware in the correct position.
(defn register-handler
  ([id handler]
   (handlers/register-base id pure handler))
  ([id middleware handler]
   (handlers/register-base id [pure middleware] handler)))
