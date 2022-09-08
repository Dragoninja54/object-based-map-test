public class Tile {
    // Changeable attributes (can be modified by player & other actions for each individual tile)
    public String mapOutput;
    public String outputColor;
    
    public boolean walkable;
    
    public TileType tileType;
    
    public Tile (TileType setTileType) {
        tileType = setTileType;
        walkable = tileType.defaultWalkable;
        outputColor = tileType.defaultOutputColor;
        mapOutput = tileType.defaultMapOutput;
    }
    
    public void printMapOutput () {
        System.out.println(mapOutput);
    }
}