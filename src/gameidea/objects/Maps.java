package gameidea.objects;

/*******************************************************************
 *                          [Maps Class]
 *   Maps class procedurally generates dungeons and spawns player,
 *                       loot, and enemies.
 * 
 * Player coordinates, and the map layout are stored in this object.
 * 
 * All movement is handled from this class, but the collision is
 * handled in the collision class.
 * 
 * the Game class implements these tools.
 *******************************************************************/

public class Maps {
    
    private String mapType = ""; // Determines map generation patterns
    public int playerPosX; // Player position X
    public int playerPosY; // Player Position Y
    public char[][] layout; // Dungeon Layout
    
    public Maps(String mapType) {
        this.mapType = mapType;
        generate();
    }
    
    // Generates maps defined by the map type
    public void generate() {
        switch (this.mapType) {
            // This case is default and basic dungeon generation
            // Procedural generation to come later
            case "test" :
                layout = new char[11][11]; // Set bad boundaries
                
                // Generate map as a big square
                for (int i = 0; i < layout.length; i++) {
                    for (int j = 0; j < layout[0].length; j++) {
                        if (i == 0 || i == layout.length - 1) {
                            layout[i][j] = 'X';
                        } else if (j == 0 || j == layout[0].length - 1) {
                            layout[i][j] = 'X';
                        } else {
                            layout[i][j] = ' ';
                        }
                    }
                }
                
                // Choose player stating position
                layout[1][1] = 'P';
                // Choose enemy locations
                layout[3][1] = 'E';
                layout[1][5] = 'E';
                this.playerPosX = 1;
                this.playerPosY = 1;
                break;
            default:
                // Invalid map type
        }
    }
    
    // Debug for checking map generation
    public void printMap() {
        System.out.print(' ');
        for (int i = 0; i < layout.length; i++) {
            for (int j = 0; j < layout[0].length; j++) {
                if (j == layout[0].length - 1)
                    System.out.println(layout[i][j]);
                else
                    System.out.print(layout[i][j]);
                    System.out.print(' ');
            }
        }
    }
    
    public void movePlayer(char direction) {
        if (direction == 'u') {  // Moving up
            layout[playerPosY][playerPosX] = ' '; // Clear previous location
            layout[playerPosY - 1][playerPosX] = 'P'; // Change player position
            playerPosY--; // Modify player coordinate variables
        } else if (direction == 'd') {  // Moving down
            layout[playerPosY][playerPosX] = ' ';
            layout[playerPosY + 1][playerPosX] = 'P';
            playerPosY++;
        } else if (direction == 'l') {  // Moving left
            layout[playerPosY][playerPosX] = ' ';
            layout[playerPosY][playerPosX - 1] = 'P';
            playerPosX--;
        } else if (direction == 'r') {  // Moving right
            layout[playerPosY][playerPosX] = ' ';
            layout[playerPosY][playerPosX + 1] = 'P';
            playerPosX++;
        }
    }
}