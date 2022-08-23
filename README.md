# AdventureGame!

A text-based adventure game.
### Class Diagram;


### Charcters;

| Character | Id | Damage  | Health  | Money  |
|:---------:|:--:|:-------:|:-------:|:------:|
| Samurai   | 1  | 5       | 21      | 15     |
| Archer    | 2  | 7       | 18      | 20     |
| Knight    | 3  | 8       | 24      | 5      |

### Monsters;

| Monster | Id | Damage  | Health  | Money  |
|:-------:|:--:|:-------:|:-------:|:------:|
| Zombie  | 1  | 3       | 10      | 4      |
| Vampire | 2  | 4       | 14      | 7      |
| Bear    | 3  | 7       | 20      | 12     |
| Snake   | 4  | 3-6     | 12      | 0      |

### Places;
- Safe House
  - Feature: Regenerating Health
- Cave
  - Monster :   Zombie (1-3)
  - Attribute : War + Loot
  - Item :      Food
- Forest
  - Monster :   Vampire (1-3 Pieces)
  - Attribute : War + Loot 
  - Item :      Wood
- River
  - Monster :   Bear (1-3 Pieces)
  - Attribute : War + Loot
  - Item :      Water
- Mine
  - Monster :   Snake (1-5 Pieces)
  - Attribute : War + Loot
  - Item :      Random Item or Coin
- ToolStore
  - Feature : Buying Supporting Items
  - Weapon :  Gun, Sword, Rifle
  - Armor :   Light, Medium, Heavy

 
