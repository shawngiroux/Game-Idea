package gameidea.objects;

import java.util.concurrent.ThreadLocalRandom;

public class Enemy {
    public String name = "Rat";
    private int[] dmg = { 1, 3 };
    private int[] hp = { 4, 6 };
    public int chp; // Current hp
    
    public Enemy() {
        
        chp = ThreadLocalRandom.current().nextInt(hp[0], hp[1] + 1);
    }
    
    public int roleDamage() {
        // Role damage using the dmg range & set an attack message
        // Crit is a multiplied role?
        int attackDamage = ThreadLocalRandom.current().nextInt(dmg[0], dmg[1] + 1);
        printAttack("The rat lunges at you, hitting you for " + attackDamage + " hitpoints!");
        return attackDamage;
    }
    
    private void printAttack(String attackMessage) {
        System.out.println(attackMessage);
    }
}
