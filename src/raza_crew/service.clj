(ns raza-crew.service
  (:require
   [clojure.edn :as edn]
   [clojure.java.io :as io]
   [com.walmartlabs.lacinia.pedestal :refer [service-map]]
   [com.walmartlabs.lacinia.schema :as schema]
   [com.walmartlabs.lacinia.util :refer [attach-resolvers]]
   [io.pedestal.http :as http]))

(defn ^:private get-hero [context arguments value]
  (let [{:keys [episode]} arguments]
    (if (= episode :NEWHOPE)

      {:id 1000
       :name "Luke"
       :home_planet "Tatooine"
       :appears_in ["NEWHOPE" "EMPIRE" "JEDI"]}

      {:id 2000
       :name "Lando Calrissian"
       :home_planet "Socorro"
       :appears_in ["EMPIRE" "JEDI"]})))

(defn ^:private schema []
  (-> "schema.edn"
      io/resource
      slurp
      edn/read-string
      (attach-resolvers {:get-hero get-hero
                         :get-droid (constantly {})})
      schema/compile))

(def service
  (-> (schema)
      (service-map {:graphiql true})))
