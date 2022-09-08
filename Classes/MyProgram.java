//every tile on map is an object of Tile
//every tile type gets a tileType object
//every tile on map gets assigned one of the tileType objects

import java.io.*;
import java.util.*;
import java.net.*;

public class MyProgram
{
    public static MyProgram program = new MyProgram();
    
    public TileRegistry tileRegistry = new TileRegistry();
    public Map map = new Map();
    
    public static void main(String[] args)
    {
        program.tileRegistry.readDefaultInfo(new File("tileDefaults.txt"), program.map);
        
        try 
        {
            program.map.readMap(new URL("https://codehs.com/uploads/2aed7fe0084f553815ad3504de6795eb"));
        }
        catch (MalformedURLException e)
        {
            e.printStackTrace();
        }

        System.out.println();
        System.out.println(program.tileRegistry.getTileType("DIRT").name);
        System.out.println(program.tileRegistry.getTileType("STONE").name);
        System.out.println(program.tileRegistry.getTileType("GRASS").name);
        System.out.println(program.map.colorTileMap.get(-4621737).name);
        
        for(int i = 0; i < program.map.mapTileList.size(); i++)
        {
            System.out.println();
            for(int b = 0; b < program.map.mapTileList.get(i).size(); b++)
            {
                System.out.print(program.map.mapTileList.get(i).get(b).mapOutput);
            }
        }
    }
}