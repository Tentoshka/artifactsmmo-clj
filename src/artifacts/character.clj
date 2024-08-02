(ns artifacts.character
  (:require [clj-http.client :as c]
            [artifacts.data :refer [base-request]]))

(defn- url-path [name] (str "my/" name "/"))

(defn- action-url-path [name] (str (url-path name) "action/"))

(defn action-move [{:keys [token name x y]}]
  (base-request {:token    token
                 :method   c/post
                 :url-part (str (action-url-path name) "move")
                 :body     {:x x
                            :y y}}))

(defn action-equip [{:keys [token name slot code]}]
  (base-request {:token    token
                 :method   c/post
                 :url-part (str (action-url-path name) "equip")
                 :body     {:slot slot
                            :code code}}))

(defn action-unequip [{:keys [token name slot]}]
  (base-request {:token    token
                 :method   c/post
                 :url-part (str (action-url-path name) "unequip")
                 :body     {:slot slot}}))

(defn action-fight [{:keys [token name]}]
  (base-request {:token    token
                 :method   c/post
                 :url-part (str (action-url-path name) "fight")}))

(defn action-gathering [{:keys [token name]}]
  (base-request {:token    token
                 :method   c/post
                 :url-part (str (action-url-path name) "gathering")}))

(defn action-crafting [{:keys [token name code quantity]}]
  (base-request {:token    token
                 :method   c/post
                 :url-part (str (action-url-path name) "crafting")
                 :body     {:code     code
                            :quantity quantity}}))

(defn get-character-log [{:keys [token name page size]}]
  (base-request {:token    token
                 :method   c/get
                 :url-part (str (url-path name) "logs")
                 :body     {:page page :size size}}))

(defn get-all-characters-log [{:keys [token page size]}]
  (base-request {:token    token
                 :method   c/get
                 :url-part "my/logs"
                 :body     {:page page :size size}}))

(defn get-my-characters [{:keys [token]}]
  (base-request {:token    token
                 :method   c/get
                 :url-part "my/characters"}))

(comment
  (assoc (base-request "123")
              :body         (json/generate-string
                             {:x 1
                              :y 2}))

  )
