(ns artifacts.data
  (:require [cheshire.core :as json]))

(def base-url "https://api.artifactsmmo.com/")

(defn base-request-data [token]
  {:throw-exceptions? false
   :oauth-token       token
   :accept            :json
   :content-type      :json})

(defn base-request [{:keys [method token url-part body]}]
  (let [res (-> (str base-url url-part)
            (method
             (assoc (base-request-data token)
                    :body (json/generate-string body)))
            :body
            (json/parse-string true))]
    (if (contains? res :error)
      res
      (:data res))))
