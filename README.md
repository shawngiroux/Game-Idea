# Game Idea

## What is this?
I am currently ~~goofing around~~ working on this side project for ~~fun~~ important business. 

The idea is to create an engine for my game that secludes the important parts of code so that I will be able to port it over to something else later (likely mobile).

The file structure that you see here was from creating the project in the NetBeans IDE.

**NOTE: I don't have a name for this yet, as you may have noticed.**

# Classes 

This rundown is up to date as of 7/18/2017

# Gameidea folder

### Gameidea.java
This [class](https://github.com/shawngiroux/Game-Idea/blob/master/src/gameidea/Gameidea.java) is just the entry point into the program, it branches to the game class

### Game.java
This [class](https://github.com/shawngiroux/Game-Idea/blob/master/src/gameidea/Game.java) will be for displaying the game in a console setting. Most code here should not be integral to the game engine, aside from maybe the messages. If I manage to keep it fairly separated, porting over to mobile shouldn't be all that bad.

# Objects Folder
This folder should contain only things that I consider to be objects in the game (self-documenting names!!!)

### Enemy.java
This [class](https://github.com/shawngiroux/Game-Idea/blob/master/src/gameidea/objects/Enemy.java) will hold data on various enemies, along with holding their messages and damage. It currently only supports the enemy "rat", but it will choose based on dungeon difficulty later.

### Maps.java
Contains algorithms for dungeon generation. As of now, it only creates a box,  but later I will look into procedural generation, along with having layouts based on themes.

This [class](https://github.com/shawngiroux/Game-Idea/blob/master/src/gameidea/objects/Maps.java) also keeps track of player coordinates, and player movement from within the map.

### Player.java
Holds player data.  Things like name, hitpoints, damage, equipment, are stored from within this [class](https://github.com/shawngiroux/Game-Idea/blob/master/src/gameidea/objects/Player.java).  Just like they enemies object, it also caluclates attacking damage and attack messages.

# Scripts Folder
More self-documentation!

### Collision.java
This [class](https://github.com/shawngiroux/Game-Idea/blob/master/src/gameidea/scripts/Collision.java) handles collisions between player/enemies with solid objects, along with enemy collisions.  

This is where I'll most likely forget to update the solid object list, and have a lot of problems in the future.

# Conclusion
Even if I never get to finish the game, this project gives me the opportunity to learn how to better organize my code, along with planning my development. It will also gives me the chance to create, and play around with.

I will keep working at this while I have free time until it is either done, or something else takes priority.