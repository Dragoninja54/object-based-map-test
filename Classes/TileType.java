public class TileType {
    //Will never change between instances of Tile that use the same tiletype
    public String identifier;
    public String name;
    public int bmpColor;
    
    //Default values when a new tile with this tile type is created
    public String defaultOutputColor;
    public String defaultMapOutput;
    
    public boolean defaultWalkable;
    
    //main constructor
    public TileType (String nameInput) 
    {
        identifier = nameInput;
    }
}