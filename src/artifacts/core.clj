(ns artifacts.core
  (:require [clj-http.client :as c]
            [cheshire.core :as json]
            [artifacts.data :refer [base-url]]))

(defn get-status []
  (-> base-url
      (c/get {:accept :json
              :content-type :json})
      :body))

(comment

  (get-status)

  )
