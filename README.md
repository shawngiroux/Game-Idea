# Game Idea

## What is this?
I am currently ~~goofing around~~ working on this side project for ~~fun~~ important business. 

The idea is to create an engine for my game that secludes the important parts of code, to make porting it over to something else later (likely mobile) easy.

The file structure that you see here was from creating the project in the NetBeans IDE.

**NOTE: I don't have a name for this yet, as you may have noticed.**

# Classes 

This rundown is up to date as of 7/18/2017

# Gameidea folder

### Gameidea.java
This class is just the entry point into the program, it branches to the game class

### Game.java
This class will be for displaying the game in a console setting. Most code here should not be integral to the game engine, aside from maybe the messages. If I manage to keep it fairly separated, porting over to mobile shouldn't be all that bad. The goal is to make visuals and controls the most demanding part.

# Objects Folder
This folder should contain only things that I consider to be objects in the game (self-documenting names!!!)

### Enemy.java
This class will hold data on various enemies, along with holding their messages and damage. It currently only supports the enemy "rat", but it will choose based on dungeon difficulty later.

### Maps.java
Contains algorithms for dungeon generation. As of now, it only creates a box, but later I will consider procedural generation, along with having layouts based on themes.

This class also keeps track of player coordinates, and player movement from within the map array.

### Player.java
Holds player data.  Things like name, hitpoints, damage, and equipment, are stored from within this class.  Just like the enemy object, it also calculates attacking damage and attack messages.

# Scripts Folder
More self-documentation!

### Collision.java
Handles collisions between player/enemies with solid objects, along with enemy collisions.  

This is where I'll most likely forget to update the solid object list, and have a lot of problems in the future.

# Conclusion
Even if I never get to finish the game, this project gives me the opportunity to learn how to better organize my code, along with planning my development. It will also give me the outlet to create, and play around.

I will keep working at this while I have free time until it is either done, or something else takes priority.
