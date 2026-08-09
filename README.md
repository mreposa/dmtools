# dmtools
The DM Tools project creates a Java Swing program containing various tools to aid a Dungeon Master in developing material for the Advanced Dungeons and Dragons 1st edition game.

## Resources
DM Tools uses tables and data from the Advanced Dungeons and Dragons 1st edition Dungeon Masters Guide, Players Handbook, Unearthed Arcana, and Monster Manual.

## Building dmtools
To build the project on your machine you will need to install the Java SE Development Kit, Git, and Maven.
To generate an executable JAR file, clone this project and use the following commands:
```
cd dmtools
mvn clean package
```
The executable JAR file will be found in:
```
dmtools\target
```
Double-click the JAR file to start the program.

## License
Copyright 2025 Michael Reposa

Licensed under the Apache License, Version 2.0 (the "License");
you may not use these files except in compliance with the License.
You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.

## Feature List

### Character Stats Tab
* Generate stats for all classes and races in Players Handbook and Unearthed Arcana
* Methods I - IV from the Dungeon Masters Guide, plus straight 3d6 and 5d6 (take best 3)
* Sort generated ability scores by class

### Roll Dice Tab
* d4, d6, d8, d10, d12, d20, d100

### Character Facts and Traits Tab
* Randomly generate height, weight, secondary skills, and other character details
* Generate random languages

### Thief Functions Tab
* Calculate all Thief Function percentages based on level, race, Dexterity score, and armor

### Treasure Generator Tab
* Randomize Treasure Types A - Z

### Gem Generator Tab
* Randomize gems

### Jewelry Generator Tab
* Randomize jewelry

### Magic Items Generator Tab
* Randomize magic items of any type
* Randomize intelligent weapons

### Pouch Generator Tab
* Generate random amounts of coins for large and small pouches
* Includes 100 random items that might be found in a pouch
