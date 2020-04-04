(ns raza-crew.server
  (:require [io.pedestal.http :as http]
            [com.walmartlabs.lacinia.pedestal :as lacinia]
            [raza-crew.service :as service]))

;; This is an adapted service map, that can be started and stopped
;; From the REPL you can call server/start and server/stop on this service
(defonce runnable-service (http/create-server service/service))

(defn -main
  "The entry-point for 'lein run'"
  [& args]
  (println "\nCreating your server...")
  (http/start runnable-service))
