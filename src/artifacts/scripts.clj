(ns artifacts.scripts
  (:require [artifacts.character :refer :all]
            [artifacts.items :refer :all]))

(def continue? (atom true))

(defn- new-thread [func]
  (-> func
      Thread.
      .start))

(defn stop-loop! []
  (reset! continue? false))

(defn gather-loop! [{:keys [token name]}]
  (reset! continue? true)
  (.start
   (Thread.
    (fn []
      (while (true? @continue?)
        (let [res         (action-gathering {:token token :name name})
              char        (:character res)
              gather-data {:mining_level       (:mining_level char)
                           :mining_xp          (:mining_xp char)
                           :mining_max_xp      (:mining_max_xp char)
                           :woodcutting_level  (:woodcutting_level char)
                           :woodcutting_xp     (:woodcutting_xp char)
                           :woodcutting_max_xp (:woodcutting_max_xp char)
                           :fishing_level      (:fishing_level char)
                           :fishing_xp         (:fishing_xp char)
                           :fishing_max_xp     (:fishing_max_xp char)
                           :intentory          (:inventory char)}
              err         (:error res)]
          (if (nil? err)
            (do
              (clojure.pprint/pprint gather-data)
              (-> res
                  :cooldown
                  :totalSeconds
                  (* 1000)
                  Thread/sleep))
            (do
              (reset! continue? false)
              (clojure.pprint/pprint err)))))))))

(defn craft-max [{:keys [token name code]}]
  (let [item (get-item {:code code})
        craft-items (-> item :item :craft :items)
        inventory (->> {:token token}
                       get-my-characters
                       (filter #(= (:name %) name))
                       first
                       :inventory)
        merged-items (->> (map (fn [a]
                                 (map (fn [b] (when (= (:code a) (:code b)) {:code (:code a)
                                                                            :need (:quantity a)
                                                                            :have (:quantity b)}))
                                      inventory))
                                 craft-items)
                            (map #(filter some? %))
                            flatten)
        count-items (first (min (map #(quot (:have %) (:need %)) merged-items)))]
        (action-crafting {:token token :code code :name name :quantity count-items})))


(comment



  )
