package gameidea.scripts;

import java.util.ArrayList;
import java.util.Arrays;

/*******************************************************************
 *                      [Collision Class]
 * The games collision will be handled here for both the player
 *                          and enemies.
 *******************************************************************/

public class Collision {
    
    // Checks requested tile and finds if it is solid
    public boolean checkEmpty(char tile) {
        ArrayList<Character> solids = new ArrayList<>(
            Arrays.asList('X', 'E')); // List of solid objects in the game
        
        if (solids.contains(tile) ) {  // If the tile is considered solid, we return false
            return false;
        }
        return true;
    }
    
    // Checks in the tile is an enemy tile and returns true or false
    // This will be used to start combat, or restrict enemies from
    // overlapping
    public boolean checkEnemy(char tile) {
        if (tile != 'E') {
            return false;
        }
        return true;
    }
}
