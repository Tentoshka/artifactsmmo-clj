# ArtifactsMMO-clj 

A Clojure library created for playing artifactsmmo

## Base actions

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


### Character

**Action Move**

``` clojure
(require '[artifacts.character :as char])

(char/action-move {:token "123456"
                   :name  "char-name"
                   :x     0
                   :y     1})
```

**Action Equip**

``` clojure
(require '[artifacts.character :as char])

(char/action-equip {:token token
                    :name  char-name
                    :slot  slot
                    :code  item-code})
```

**Action Unequip**

``` clojure
(require '[artifacts.character :as char])

(char/action-unequip {:token token
                      :name  char-name
                      :slot  slot})
```

**Action Fight**

``` clojure
(require '[artifacts.character :as char])

(char/action-fight {:token "123456"
                    :name  "char-name"})
```

**Action Gathering**

``` clojure
(require '[artifacts.character :as char])

(char/action-gathering {:token "123456"
                    :name  "char-name"})
```

**Action Crafting**

``` clojure
(require '[artifacts.character :as char])

(char/action-crafting {:token    token
                       :name     char-name
                       :code     item-code
                       :quantity 1})
```

**Get Character Logs**

``` clojure
(require '[artifacts.character :as char])

(char/get-character-log {:token token 
                         :name  char-name
                         :page  1
                         :size  50})
```

**Get All Characters Logs**

``` clojure
(require '[artifacts.character :as char])

(char/get-all-characters-logs {:token token
                               :page  1
                               :size  50})
```

**Get My Characters**

``` clojure
(require '[artifacts.character :as char])

(char/get-my-characters {:token token})
```

### Items

**Get All Items**

``` clojure
(require '[artifacts.items :as items])

(items/get-all-items {:craft-material craft-material
                      :craft-skill    craft-skill
                      :max-lvl        max-lvl
                      :min-lvl        min-lvl
                      :type           type})
```

**Get Item**

``` clojure
(require '[artifacts.items :as items])

(items/get-item {:code code})
```

### Error handling

If was error you can get error message by game

Example:

``` clojure
{:error {:code 490 :message "Character already at destination."}}
```

## Extra scripts

**Gathering loop**

Allows you to perform a gathering action in a loop. This can be useful for automatic resource extraction

``` clojure
(require '[artifacts.scripts :as s])

(s/gather-loop! {:token token
                 :name  char-name})
```

The script will automatically extract resources and report changes in experience, level, as well as items in the inventory

``` clojure
{:mining_level       4,
 :mining_xp          112,
 :mining_max_xp      450,
 :woodcutting_level  2,
 :woodcutting_xp     96,
 :woodcutting_max_xp 250,
 :fishing_level      1,
 :fishing_xp         0,
 :fishing_max_xp     150,
:intentory
 [{:slot 1, :code "raw_chicken", :quantity 1}
  {:slot 2, :code "ash_wood", :quantity 7}
  {:slot 3, :code "copper_ore", :quantity 30}
  {:slot 4, :code "", :quantity 0}
  {:slot 5, :code "wooden_staff", :quantity 1}
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
  {:slot 20, :code "", :quantity 0}]
 }
```

**Maximize crafting**

Allows you to craft the maximum amount of an item from available resources

For example, you have 20 copper ore in your inventory, the craft-max function will allow you to craft the maximum amount of copper (3) from them without burdening you with calculations

``` clojure
(require '[artifacts.scripts :as s])

(s/craft-max {:token token
              :name  char-name
              :code  item-code})
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
