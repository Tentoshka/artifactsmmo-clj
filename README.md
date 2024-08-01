# artifactsmmo-clj

A Clojure library created for playing artifactsmmo

## Usage

Work in progress...

**Get Status**

``` clojure
(require '[artifacts.core :as c])

(c/get-status)
```

Result:

``` clojure
{:status            "online",
 :version           "1.3",
 :characters_online 528,
 :announcements
 [{:message    "Welcome to Artifacts Alpha 1. The server is up.",
   :created_at "2024-08-01T15:24:50.410Z"}],
 :last_wipe         "2023-07-11",
 :next_wipe         "N/A"}
```

---

**Action Move**

``` clojure
(require '[artifacts.character :as char])

(char/action-move {:token "123456"
                   :name  "char-name"
                   :x     0
                   :y     1})
```

Result:

``` clojure
{:cooldown
 {:total_seconds     5,
  :remaining_seconds 5,
  :totalSeconds      5,
  :remainingSeconds  5,
  :expiration        "2024-08-01T15:15:02.590652Z",
  :reason            "movement"},
 :destination {:name "Spawn", :x 0, :y 0, :content nil},
 :character
 {:y                         0,
  :artifact2_slot            "",
  :consumable2_slot_quantity 0,
  :critical_strike           0,
  :task_type                 "",
  :inventory_slot1           "",
  :mining_max_xp             150,
  :inventory_slot20_quantity 0,
  :task_progress             0,
  :gearcrafting_max_xp       150,
  :dmg_air                   0,
  :inventory_slot12          "",
  :res_air                   0,
  :mining_xp                 0,
  :inventory_slot5           "",
  :inventory_slot8           "",
  :inventory_slot3_quantity  0,
  :inventory_slot17_quantity 0,
  :inventory_slot2           "",
  :inventory_slot13_quantity 0,
  :inventory_slot7           "",
  :inventory_slot4           "",
  :consumable2_slot          "",
  :inventory_slot13          "",
  :inventory_slot1_quantity  0,
  :jewelrycrafting_max_xp    150,
  :task                      "",
  :speed                     100,
  :inventory_max_items       100,
  :inventory_slot14_quantity 0,
  :cooldown_expiration       "2024-08-01T15:15:02.590Z",
  :leg_armor_slot            "",
  :inventory_slot9           "",
  :name                      "Tentoshka",
  :inventory_slot3           "",
  :inventory_slot8_quantity  0,
  :woodcutting_level         1,
  :inventory_slot4_quantity  0,
  :inventory_slot10          "",
  :cooking_level             1,
  :inventory_slot15          "",
  :inventory_slot11          "",
  :inventory_slot14          "",
  :fishing_xp                0,
  :cooldown                  5,
  :stamina                   0,
  :artifact1_slot            "",
  :inventory_slot16_quantity 0,
  :inventory_slot5_quantity  0,
  :weapon_slot               "wooden_stick",
  :inventory_slot20          "",
  :helmet_slot               "",
  :shield_slot               "",
  :inventory
  [{:slot 1, :code "", :quantity 0}
   {:slot 2, :code "", :quantity 0}
   {:slot 3, :code "", :quantity 0}
   {:slot 4, :code "", :quantity 0}
   {:slot 5, :code "", :quantity 0}
   {:slot 6, :code "", :quantity 0}
   {:slot 7, :code "", :quantity 0}
   {:slot 8, :code "", :quantity 0}
   {:slot 9, :code "", :quantity 0}
   {:slot 10, :code "", :quantity 0}
   {:slot 11, :code "", :quantity 0}
   {:slot 12, :code "", :quantity 0}
   {:slot 13, :code "", :quantity 0}
   {:slot 14, :code "", :quantity 0}
   {:slot 15, :code "", :quantity 0}
   {:slot 16, :code "", :quantity 0}
   {:slot 17, :code "", :quantity 0}
   {:slot 18, :code "", :quantity 0}
   {:slot 19, :code "", :quantity 0}
   {:slot 20, :code "", :quantity 0}],
  :ring1_slot                "",
  :consumable1_slot          "",
  :haste                     0,
  :artifact3_slot            "",
  :inventory_slot6_quantity  0,
  :level                     1,
  :gold                      0,
  :attack_fire               0,
  :res_fire                  0,
  :consumable1_slot_quantity 0,
  :jewelrycrafting_xp        0,
  :inventory_slot10_quantity 0,
  :inventory_slot15_quantity 0,
  :woodcutting_max_xp        150,
  :dmg_fire                  0,
  :inventory_slot2_quantity  0,
  :max_xp                    150,
  :ring2_slot                "",
  :inventory_slot9_quantity  0,
  :amulet_slot               "",
  :gearcrafting_level        1,
  :weaponcrafting_max_xp     150,
  :attack_earth              4,
  :cooking_xp                0,
  :weaponcrafting_level      1,
  :res_earth                 0,
  :attack_water              0,
  :inventory_slot6           "",
  :fishing_level             1,
  :inventory_slot17          "",
  :inventory_slot19_quantity 0,
  :weaponcrafting_xp         0,
  :dmg_water                 0,
  :gearcrafting_xp           0,
  :inventory_slot18          "",
  :inventory_slot19          "",
  :inventory_slot11_quantity 0,
  :woodcutting_xp            0,
  :body_armor_slot           "",
  :fishing_max_xp            150,
  :inventory_slot18_quantity 0,
  :total_xp                  0,
  :x                         0,
  :res_water                 0,
  :inventory_slot12_quantity 0,
  :hp                        120,
  :xp                        0,
  :inventory_slot16          "",
  :task_total                0,
  :boots_slot                "",
  :cooking_max_xp            150,
  :inventory_slot7_quantity  0,
  :skin                      "men2",
  :dmg_earth                 0,
  :attack_air                0,
  :mining_level              1,
  :jewelrycrafting_level     1}}
  ```

**Action Fight**
``` clojure
(require '[artifacts.character :as char])

(char/action-fight {:token "123456"
                    :name  "char-name"})
```

Result:

``` clojure
{:cooldown
 {:total_seconds     58,
  :remaining_seconds 58,
  :totalSeconds      58,
  :remainingSeconds  58,
  :expiration        "2024-08-01T15:52:15.676078Z",
  :reason            "fight"},
 :fight
 {:xp                   43,
  :gold                 1,
  :drops                [{:code "raw_chicken", :quantity 1}],
  :turns                29,
  :monster_blocked_hits {:fire 0, :earth 0, :water 0, :air 0, :total 0},
  :player_blocked_hits  {:fire 0, :earth 0, :water 0, :air 0, :total 0},
  :logs
  ["Turn 1: The character used earth attack and dealt 4 damage."
   "Turn 2: The monster used water attack and dealt 4 damage."
   "Turn 3: The character used earth attack and dealt 4 damage."
   "Turn 4: The monster used water attack and dealt 4 damage."
   "Turn 5: The character used earth attack and dealt 4 damage."
   "Turn 6: The monster used water attack and dealt 4 damage."
   "Turn 7: The character used earth attack and dealt 4 damage."
   "Turn 8: The monster used water attack and dealt 4 damage."
   "Turn 9: The character used earth attack and dealt 4 damage."
   "Turn 10: The monster used water attack and dealt 4 damage."
   "Turn 11: The character used earth attack and dealt 4 damage."
   "Turn 12: The monster used water attack and dealt 4 damage."
   "Turn 13: The character used earth attack and dealt 4 damage."
   "Turn 14: The monster used water attack and dealt 4 damage."
   "Turn 15: The character used earth attack and dealt 4 damage."
   "Turn 16: The monster used water attack and dealt 4 damage."
   "Turn 17: The character used earth attack and dealt 4 damage."
   "Turn 18: The monster used water attack and dealt 4 damage."
   "Turn 19: The character used earth attack and dealt 4 damage."
   "Turn 20: The monster used water attack and dealt 4 damage."
   "Turn 21: The character used earth attack and dealt 4 damage."
   "Turn 22: The monster used water attack and dealt 4 damage."
   "Turn 23: The character used earth attack and dealt 4 damage."
   "Turn 24: The monster used water attack and dealt 4 damage."
   "Turn 25: The character used earth attack and dealt 4 damage."
   "Turn 26: The monster used water attack and dealt 4 damage."
   "Turn 27: The character used earth attack and dealt 4 damage."
   "Turn 28: The monster used water attack and dealt 4 damage."
   "Turn 29: The character used earth attack and dealt 4 damage."
   "Fight result: win. (Character HP: 64, Monster HP: 0)"],
  :result               "win"},
 :character
 {:y                         1,
  :artifact2_slot            "",
  :consumable2_slot_quantity 0,
  :critical_strike           0,
  :task_type                 "",
  :inventory_slot1           "raw_chicken",
  :mining_max_xp             150,
  :inventory_slot20_quantity 0,
  :task_progress             0,
  :gearcrafting_max_xp       150,
  :dmg_air                   0,
  :inventory_slot12          "",
  :res_air                   0,
  :mining_xp                 0,
  :inventory_slot5           "",
  :inventory_slot8           "",
  :inventory_slot3_quantity  0,
  :inventory_slot17_quantity 0,
  :inventory_slot2           "",
  :inventory_slot13_quantity 0,
  :inventory_slot7           "",
  :inventory_slot4           "",
  :consumable2_slot          "",
  :inventory_slot13          "",
  :inventory_slot1_quantity  1,
  :jewelrycrafting_max_xp    150,
  :task                      "",
  :speed                     100,
  :inventory_max_items       100,
  :inventory_slot14_quantity 0,
  :cooldown_expiration       "2024-08-01T15:52:15.676Z",
  :leg_armor_slot            "",
  :inventory_slot9           "",
  :name                      "Tentoshka",
  :inventory_slot3           "",
  :inventory_slot8_quantity  0,
  :woodcutting_level         1,
  :inventory_slot4_quantity  0,
  :inventory_slot10          "",
  :cooking_level             1,
  :inventory_slot15          "",
  :inventory_slot11          "",
  :inventory_slot14          "",
  :fishing_xp                0,
  :cooldown                  58,
  :stamina                   0,
  :artifact1_slot            "",
  :inventory_slot16_quantity 0,
  :inventory_slot5_quantity  0,
  :weapon_slot               "wooden_stick",
  :inventory_slot20          "",
  :helmet_slot               "",
  :shield_slot               "",
  :inventory
  [{:slot 1, :code "raw_chicken", :quantity 1}
   {:slot 2, :code "", :quantity 0}
   {:slot 3, :code "", :quantity 0}
   {:slot 4, :code "", :quantity 0}
   {:slot 5, :code "", :quantity 0}
   {:slot 6, :code "", :quantity 0}
   {:slot 7, :code "", :quantity 0}
   {:slot 8, :code "", :quantity 0}
   {:slot 9, :code "", :quantity 0}
   {:slot 10, :code "", :quantity 0}
   {:slot 11, :code "", :quantity 0}
   {:slot 12, :code ";; => ", :quantity 0}
   {:slot 13, :code "", :quantity 0}
   {:slot 14, :code "", :quantity 0}
   {:slot 15, :code "", :quantity 0}
   {:slot 16, :code "", :quantity 0}
   {:slot 17, :code "", :quantity 0}
   {:slot 18, :code "", :quantity 0}
   {:slot 19, :code "", :quantity 0}
   {:slot 20, :code "", :quantity 0}],
  :ring1_slot                "",
  :consumable1_slot          "",
  :haste                     0,
  :artifact3_slot            "",
  :inventory_slot6_quantity  0,
  :level                     1,
  :gold                      2,
  :attack_fire               0,
  :res_fire                  0,
  :consumable1_slot_quantity 0,
  :jewelrycrafting_xp        0,
  :inventory_slot10_quantity 0,
  :inventory_slot15_quantity 0,
  :woodcutting_max_xp        150,
  :dmg_fire                  0,
  :inventory_slot2_quantity  0,
  :max_xp                    150,
  :ring2_slot                "",
  :inventory_slot9_quantity  0,
  :amulet_slot               "",
  :gearcrafting_level        1,
  :weaponcrafting_max_xp     150,
  :attack_earth              4,
  :cooking_xp                0,
  :weaponcrafting_level      1,
  :res_earth                 0,
  :attack_water              0,
  :inventory_slot6           "",
  :fishing_level             1,
  :inventory_slot17          "",
  :inventory_slot19_quantity 0,
  :weaponcrafting_xp         0,
  :dmg_water                 0,
  :gearcrafting_xp           0,
  :inventory_slot18          "",
  :inventory_slot19          "",
  :inventory_slot11_quantity 0,
  :woodcutting_xp            0,
  :body_armor_slot           "",
  :fishing_max_xp            150,
  :inventory_slot18_quantity 0,
  :total_xp                  86,
  :x                         0,
  :res_water                 0,
  :inventory_slot12_quantity 0,
  :hp                        120,
  :xp                        86,
  :inventory_slot16          "",
  :task_total                0,
  :boots_slot                "",
  :cooking_max_xp            150,
  :inventory_slot7_quantity  0,
  :skin                      "men2",
  :dmg_earth                 0,
  :attack_air                0,
  :mining_level              1,
  :jewelrycrafting_level     1}}
```

**Error handling**

If was error you can get error message by game

Example:

``` clojure
{:error {:code 490 :message "Character already at destination."}}
```

## License

Copyright © 2024 Tentoshka

This program and the accompanying materials are made available under the
terms of the Eclipse Public License 2.0 which is available at
http://www.eclipse.org/legal/epl-2.0.

This Source Code may also be made available under the following Secondary
Licenses when the conditions for such availability set forth in the Eclipse
Public License, v. 2.0 are satisfied: GNU General Public License as published by
the Free Software Foundation, either version 2 of the License, or (at your
option) any later version, with the GNU Classpath Exception which is available
at https://www.gnu.org/software/classpath/license.html.
