
/**
 * @author Samareh
 */

package domain;

import java.io.Serializable;
import java.util.*;

import domain.enums.Building;
import domain.enums.Color;
import domain.enums.Terrain;

public class Deck implements Serializable{
    // SerialversionUID for serialization
	private static final long serialVersionUID = 1L;
	
	private ArrayList<Tile> tiles = new ArrayList<Tile>();
    private Random generator = new Random(System.currentTimeMillis());

    public Deck( Color color ){
        initialize( color );       
    }
    public void initialize( Color color ){ 
    	int rep;
    	populateDeck( color );
    	rep = generator.nextInt(10)+10;
    	shuffleTiles(4, 8, rep);	//b
    	rep = generator.nextInt(10)+10;
    	shuffleTiles(9, 13, rep);	//c
    	rep = generator.nextInt(10)+10;
    	shuffleTiles(14, 18, rep);	//e
    	rep = generator.nextInt(10)+10;
    	shuffleTiles(19, 23, rep);	//f
         }
    
    private void populateDeck( Color color ){
    	// create a stack of tiles
    	tiles.add(new Tile(Terrain.Plain, Building.Nothing, 'A', color)); 
    	tiles.add(new Tile(Terrain.Plain, Building.Village, 'A', color));
    	tiles.add(new Tile(Terrain.Plain, Building.Castle, 'A', color)); 
    	tiles.add(new Tile(Terrain.Mountain, Building.Nothing, 'A', color)); 
    	tiles.add(new Tile(Terrain.Plain, Building.Village, 'B', color));
    	tiles.add(new Tile(Terrain.Forest, Building.Village, 'B', color));
    	tiles.add(new Tile(Terrain.Plain, Building.Town, 'B', color));
    	tiles.add(new Tile(Terrain.Plain, Building.Castle, 'B', color));
    	tiles.add(new Tile(Terrain.Lake, Building.Nothing, 'B', color));
    	tiles.add(new Tile(Terrain.Plain, Building.Nothing, 'C', color));
    	tiles.add(new Tile(Terrain.Plain, Building.Nothing, 'C', color));
    	tiles.add(new Tile(Terrain.Forest, Building.Town, 'C', color));
    	tiles.add(new Tile(Terrain.Plain, Building.Castle, 'C', color));
    	tiles.add(new Tile(Terrain.Forest, Building.Castle, 'C', color));
    	tiles.add(new Tile(Terrain.Forest, Building.Village, 'D', color));
    	tiles.add(new Tile(Terrain.Plain, Building.Town, 'D', color));
    	tiles.add(new Tile(Terrain.Plain, Building.Castle, 'D', color));
    	tiles.add(new Tile(Terrain.Plain, Building.Castle, 'D', color));
    	tiles.add(new Tile(Terrain.Mountain, Building.Nothing, 'D', color));
    	tiles.add(new Tile(Terrain.Plain, Building.Nothing, 'E', color));
    	tiles.add(new Tile(Terrain.Forest, Building.Village, 'E', color));
    	tiles.add(new Tile(Terrain.Plain, Building.Town, 'E', color));
    	tiles.add(new Tile(Terrain.Plain, Building.Castle, 'E', color));
    	tiles.add(new Tile(Terrain.Forest, Building.Castle, 'E', color));
    }
    
    private void shuffleTiles(int start, int end, int repeat){
    	int one;
    	int two;
    	
    	for(int i = 0; i < repeat; i++){
    		one = (generator.nextInt(end-start+1)) + start;
    		two = (generator.nextInt(end-start+1)) + start;
    		Collections.swap(tiles, one, two);
    	}  	
    }
    
    // PlayTile takes the tile number that is played (1 or 2) and removes it from the deck
    // upon success, it returns true, else it return false
    public boolean PlayTile(int n){
    	if(n == 1 || n == 2)
    	{
    		tiles.remove(n - 1);
    		return true;
    	}
    	else return false;
    	
    }

    public boolean playTile(Tile t){
        return tiles.remove(t);
    }
    
    public Tile getTile1(){
    	return tiles.get(0);
    }
    
    public Tile getTile2(){
    	return tiles.get(1);
    }
    
    public Tile getTile3(){
    	return tiles.get(2);
    }
    
    public Tile getTile4(){
    	return tiles.get(3);
    }
    
    public char getTopLetter(){
    	return tiles.get(2).getLetter();
    }

    public int getSize(){
        return tiles.size();
    }
}
