import java.util.*;
import java.lang.*;
import java.io.*;

//handles the initialization of all the tiletype objects
public class TileRegistry {
    //combine these into just a hashtable<String, TileType>
    //public ArrayList<TileType> tileTypes = new ArrayList<TileType>();
    public Hashtable<String, TileType> tileTypes = new Hashtable<String, TileType>();
    
    //ArrayList<String> usedNames = new ArrayList<String>();
    
    Scanner fileIn;
    int tileIndex = 0;
    
    public void readDefaultInfo (File inputFile, Map inputMap)
    {
        try 
        {
            // used to read all data in from the file
            fileIn = new Scanner(inputFile);
        }
        catch (IOException e) 
        {
            System.out.println("File not found");
        }
        while(fileIn.hasNext()) {
            String lineIn = fileIn.nextLine();
            // gets the tile's identifier
            System.out.println(lineIn);
            // stores the name of the current tile being registered to identify it later
            String currentTileName = lineIn;
            // puts the name of the current tile in the usednames list to check later (may not be needed, just a precation for now)
            //usedNames.add(lineIn);
            // creates the tiletype object for the current tiletype being registered
            tileTypes.put(lineIn, new TileType(lineIn));
        
            // gets the tile's display name
            lineIn = fileIn.nextLine();
            System.out.println(lineIn);
            // sets the tiletype's display name
            tileTypes.get(currentTileName).name = lineIn;
        
            // gets the tile's map output
            lineIn = fileIn.nextLine();
            System.out.println(lineIn);
            // sets the tiletype's default map output
            tileTypes.get(currentTileName).defaultMapOutput = lineIn;
            
            // gets the tile's bmp color
            int intIn = fileIn.nextInt();
            System.out.println(intIn);
            // sets the tiletype's default map output
            tileTypes.get(currentTileName).bmpColor = intIn;
            //puts a reference between the tiletypes bmpcolor and the object into the color-tile map
            inputMap.colorTileMap.put(intIn, getTileType(currentTileName));
        
            //  get value of any unknown number of attributes
            lineIn = fileIn.nextLine();
            lineIn = fileIn.nextLine();
            while(!lineIn.equals("END")) {
                // index of the "break" between attribute name and value
                int breakIndex = lineIn.indexOf(":");
            
                // stores the values of each part of the attribute
                String attributeType = lineIn.substring(0, breakIndex);
                String attributeValue = lineIn.substring(breakIndex + 2);
            
                System.out.println("Type : " + attributeType);
                System.out.println("Value : " + attributeValue);
                
                lineIn = fileIn.nextLine();
            }
            System.out.println();
            tileIndex++;
        }
    }
    
    public TileType getTileType(String tileName)
    {
        return tileTypes.get(tileName);
    }
}