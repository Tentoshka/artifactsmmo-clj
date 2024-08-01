(ns artifacts.character
  (:require [clj-http.client :as c]
            [artifacts.data :refer [base-request]]))

(defn- url-path [name] (str "my/" name "/action/"))

(defn action-move [{:keys [token name x y]}]
  (base-request {:token    token
                 :method   c/post
                 :url-part (str (url-path name) "move")
                 :body     {:x x
                            :y y}}))

(defn action-fight [{:keys [token name]}]
  (base-request {:token    token
                 :method   c/post
                 :url-part (str (url-path name) "fight")}))

(defn action-gathering [{:keys [token name]}]
  (base-request {:token    token
                 :method   c/post
                 :url-part (str (url-path name) "gathering")}))

(comment
  (assoc (base-request "123")
              :body         (json/generate-string
                             {:x 1
                              :y 2}))

  )
