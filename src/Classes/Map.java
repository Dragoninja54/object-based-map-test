package Classes;

import java.io.*;
import javax.imageio.*;
import java.awt.image.*;
import java.net.*;
import java.util.*;

public class Map {
    BufferedImage mapImage;
    public Hashtable<Integer, TileType> colorTileMap = new Hashtable<Integer, TileType>();
    public ArrayList<ArrayList<Tile>> mapTileList = new ArrayList<ArrayList<Tile>>();
    
    public void readMap (File inputFile) {
        try
        {
            mapImage = ImageIO.read(inputFile);
        }
        catch (MalformedURLException e)
        {
            e.printStackTrace();
        }
        catch (IOException b)
        {
            b.printStackTrace();
        }
        
        for(int a = 0; a < mapImage.getWidth(); a++) {
            mapTileList.add(new ArrayList<Tile>());
            for(int b = 0; b < mapImage.getHeight(); b++) {
                mapTileList.get(a).add(new Tile(colorTileMap.get(mapImage.getRGB(a, b))));
            }
        }
    }
}