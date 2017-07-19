package gameidea;

import gameidea.objects.Enemy;
import gameidea.objects.Maps;
import gameidea.objects.Player;
import gameidea.scripts.Collision;
import java.util.Scanner;

/*******************************************************************
 *                          [Game Class]
 *             The game class is to be built per device.
 * 
 * For example: In this case, the game class is built to be run in
 * a console, hence the use of console printing.
 * 
 * If all goes well, this program will be built enough that the
 * main engine functionality is excluded from the game class.
 * 
 * This means that whenever the game is ported, only this class
 * needs to be rewritten.
 *******************************************************************/

// Note: These should all be refactored into classes instead of methods later
// --->  with the exception of maybe "menu"

public class Game {
    
    
    Player player;
    String input;
    Scanner scan = new Scanner(System.in);
    
    /*******************************************************************
    *                              [Menu]
    *     Starting menu to continue games, start a new one, or exit.
    * 
    * Currently is just used to test the dungeon.
    *******************************************************************/
    
    public void menu() {
        
        
        // Option: Starting a new game
        CharacterCreation c = new CharacterCreation();
        c.start();
        
        // Option: Continue a saved game
        
        // Option: Exit
        
        // Option: Debug section
        
        Dungeon dun = new Dungeon("test"); // Debug for testing the dungeon
        dun.delve();
    }
    
    private class CharacterCreation {
        String name = "";
        String race = "";
        String pClass= "";
        int hp = 0;
        int dmg = 0;
        
        String input; // Holds user input
        
        void start() {
            System.out.print("Enter your character's name: ");
            input = scan.nextLine();
            this.name = input;
            
            // Debug data start
            this.race = "Human";
            this.pClass = "Fighter";
            this.hp = 17;
            this.dmg = 2;
            // Debug data end
            
            // Set player
            player = new Player(this.name, this.race, this.pClass, this.hp, this.dmg);
            saveCharacter();
        }
        void saveCharacter() {
            // Save to a file for continuing later
        }
    }
    
    /*******************************************************************
    *                            [Dungeon]
    * Generates a dungeon for the player, and passes a dungeon tile set
    *    to let the map class what to type of dungeon to generate.
    *******************************************************************/
    private class Dungeon {
        
        boolean inDungeon = true;
        Collision collision = new Collision();
        Maps map; // Move to dungeon class later
        
        Dungeon(String tileSet) {
            this.map = new Maps(tileSet);
        }
        
        void delve() {
            while(inDungeon) {
                // Debug: printing spaced for display purposes in netbeans it's
                // --->   basically a clear screen
                for(int i = 0; i < 15; i++) {
                    System.out.println();
                }

                map.printMap(); // Reprint the map for the player
                System.out.print("Enter your direction: "); // Player instruction prompt
                input = scan.nextLine().toLowerCase(); // Stores user input

                /*******************************************************************
                *                      [Movement & Collision]
                *   Takes in user input, then checks the array for a solid object.
                * 
                * tileUp/Down/Left/Right are the tiles relative to the players
                * current position. They are updated each loop cycle.
                * 
                * The collision class has a list of solids, and compares them to the
                * tile passed in "collision.checkEmpty()"
                * 
                * The player is then moved in the map to those positions after
                * the proper checks.
                *******************************************************************/

                char tileUp = map.layout[map.playerPosY - 1][map.playerPosX];
                char tileDown = map.layout[map.playerPosY + 1][map.playerPosX];
                char tileLeft = map.layout[map.playerPosY][map.playerPosX - 1];
                char tileRight = map.layout[map.playerPosY][map.playerPosX + 1];

                // Moving up
                if (input.equals("u")) {
                    if (collision.checkEmpty(tileUp)) { // Valid location
                        map.movePlayer('u');
                    } else if (collision.checkEnemy(tileUp)) {
                        battle();
                        map.movePlayer('u');
                    }

                // Moving down    
                } else if (input.equals("d")) {
                    if (collision.checkEmpty(tileDown)) {
                        map.movePlayer('d');
                    } else if (collision.checkEnemy(tileDown)) {
                        battle();
                        map.movePlayer('d');
                    }

                // Moving left    
                } else if (input.equals("l")) {
                    if (collision.checkEmpty(tileLeft)) {
                        map.movePlayer('l');
                    }  else if (collision.checkEnemy(tileLeft)) {
                        battle();
                        map.movePlayer('l');
                    }

                // Moving right
                } else if (input.equals("r")) {
                    if (collision.checkEmpty(tileRight)) {
                        map.movePlayer('r');
                    } else if (collision.checkEnemy(tileRight)) {
                        battle();
                        map.movePlayer('r');
                    }
                }
            }
        }
        
        void battle() {
            boolean inBattle = true; // Controls when to end combat
            Enemy enemy = new Enemy();
            
            while(inBattle) {
                
                System.out.printf("Enemy: %s | hp: %d\n", enemy.name, enemy.chp);
                player.printAttributes();
                for (int i = 0; i < 5; i++) {
                    System.out.println();
                }
                
                System.out.println("1) Fight");
                System.out.println("2) Seppuku");
                System.out.println("3) Wait");
                System.out.print("> ");
                
                input = scan.nextLine(); // Player choice
                switch(input) {
                    case "1":
                        enemy.chp -= player.roleDamage();
                        if (enemy.chp < 1) {
                            System.out.println("YOU WIN!");
                            inBattle = false;
                        }
                        break;
                    case "2":
                        System.out.println("You disembowel yourself.  You have brought great honor upon your family.");
                        System.out.println("GAME OVER");
                        System.exit(0);
                        break;
                    case "3":
                        System.out.println("You glare at the rat, a pathetic attempt at intidmiation.");
                }
                
                if (inBattle) {
                    player.chp -= enemy.roleDamage();
                }
                
                if (player.chp < 1) {
                    System.out.println("You have succumbed to your wounds.");
                    System.out.println("GAME OVER");
                    System.exit(0);
                }
            }
            System.out.println("Press enter to continue...");
            try {System.in.read();} catch (Exception e){}
            
        }
    }
    
    public class town {
        
        void enter() {
            
            while(true) {
                
                System.out.println("You have entered the town.");
                for(int i = 0; i < 5; i++){ 
                    System.out.println();
                }
                System.out.println("1) Item Shop");
                System.out.println("2) Blacksmith");
                System.out.println("3) Tavern");
                System.out.println("4) Enter the dungeon");

                System.out.println("> ");
                input = scan.nextLine();

                switch(input) {
                    case "1":
                        itemShop();
                        break;
                    case "2":
                        blacksmith();
                        break;
                    case "3":
                        tavern();
                        break;
                    case "4":
                        dungeon();
                        break;
                    default:
                        System.out.println("That was not an option!");
                        break;
                }
            }
        }
        
        void itemShop() {
            System.out.println("You see a man stocking shelves in the shop.");
            System.out.println("You notice that much of the shelves are empty.");
            System.out.println("The shop keeper looks up at you and says, \"We're still opening\"");
            System.out.println("You leave.");
        }
        
        void blacksmith() {
            
        }
        
        void tavern() {
            
        }
        
        void dungeon() {
            Dungeon dungeon = new Dungeon("test");
            dungeon.delve();
        }
    }
}