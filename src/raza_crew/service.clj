(ns raza-crew.service
  (:require
   [clojure.edn :as edn]
   [clojure.java.io :as io]
   [com.walmartlabs.lacinia.pedestal :refer [service-map]]
   [com.walmartlabs.lacinia.schema :as schema]
   [com.walmartlabs.lacinia.util :as util]
   [io.pedestal.http :as http]))

(defn ^:private resolve-hello
  [context args value]
  "Hello, Clojurians!")

(defn ^:private schema
  []
  (-> "schema.edn"
      io/resource
      slurp
      edn/read-string
      (util/attach-resolvers
        {:resolve-hello resolve-hello})
      schema/compile))

(def service
  (-> (schema)
      (service-map {:graphiql true})))
