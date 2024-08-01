(ns artifacts.character
  (:require [clj-http.client :as c]
            [artifacts.data :refer [base-request]]))

(defn action-move [{:keys [token name x y]}]
  (base-request {:token    token
                 :method   c/post
                 :url-part (str "my/" name "/action/move")
                 :body     (json/generate-string
                            {:x x
                             :y y})}))


(comment
  (assoc (base-request "123")
              :body         (json/generate-string
                             {:x 1
                              :y 2}))

  )
