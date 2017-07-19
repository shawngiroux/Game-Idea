package gameidea.objects;

/*******************************************************************
 *                         [Player Class]
 *             All player data is stored in this object.
 *******************************************************************/

public class Player {
    private String name = "";
    private String race = "";
    private String pClass = ""; // Player's Class
    private int hp = 0;
    private int dmg = 0; // Base damage
    public int chp = 0; // Current hp
    /*************************************
    * Gear is stored as such:
    * 0: Helmet
    * 1: Armor
    * 2: Weapon
    * 3: Shield
    *************************************/
    private int[] gear = new int[4];
    
    public Player(String name, String race, String pClass, int hp, int dmg) {
        this.name = name;
        this.pClass = pClass; // player class (class is reserved)
        this.race = race;
        this.hp = hp;
        this.dmg = dmg;
        this.chp = hp;
    }
    
    // Debug for checking current attributes
    public void printAttributes() {
        System.out.printf("Name: %s | Class: %s | Race: %s | HP: %d/%d | DMG: %d\n", 
                this.name, this.pClass, this.race, this.chp, this.hp, this.dmg);
    }
    
    public int roleDamage() {
        // Role damage using the dmg range & set an attack message
        // Crit is a multiplied role?
        int attackDamage = dmg;
        printAttack("You slash at the rat with your sword, hitting it for " + attackDamage + " damage");
        return attackDamage;
    }
    
    private void printAttack(String attackMessage) {
        System.out.println(attackMessage);
    }
}