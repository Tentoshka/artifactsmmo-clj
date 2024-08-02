(ns artifacts.items
  (:require [clj-http.client :as c]
            [artifacts.data :refer [base-request]]))

(def url-path "/items/")

(defn get-all-items [{:keys [craft-material craft-skill max-lvl min-lvl type]}]
  (base-request {:method   c/get
                 :url-part url-path
                 :body     {:craft_material craft-material
                            :craft_skill    craft-skill
                            :max_level      max-lvl
                            :min_level      min-lvl
                            :type           type}}))

(defn get-item [{:keys [code]}]
  (base-request {:method c/get
                 :url-part (str url-path code)}))


(comment



  )
