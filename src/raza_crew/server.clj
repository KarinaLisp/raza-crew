(ns raza-crew.server
  (:require [io.pedestal.http :as http]
            [raza-crew.service :as service]))

;; This is an adapted service map, that can be started and stopped
;; From the REPL you can call server/start and server/stop on this service
(defonce runnable-service (http/create-server (service/service)))

(defn start [] (http/start runnable-service))
(defn stop [] (http/stop runnable-service))
(defn restart [] (stop) (start) (println "\nRestarted.\n"))

(defn -main "The entry-point for 'lein run'" []
  (println "\nStarting server...\n")
  (start))
