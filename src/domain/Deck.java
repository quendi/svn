package domain;

import java.util.*;

import domain.enums.Building;
import domain.enums.Terrain;

public class Deck {
	private ArrayList<Tile> tiles = new ArrayList<Tile>();
	private Random generator = new Random(System.currentTimeMillis());
	/**
     * Initializes a player's deck.
     */
    public void initialize(){ 
    	int rep;
    	rep = generator.nextInt()%10;
    	populateDeck();
    	shuffleTiles(0, 3, rep);  	//a
    	shuffleTiles(4, 8, rep);	//b
    	shuffleTiles(9, 13, rep);	//c
    	shuffleTiles(14, 18, rep);	//e
    	shuffleTiles(19, 23, rep);	//f
         }
    
    private void populateDeck(){
    	// create a stack of tiles
    	tiles.add(new Tile(Terrain.Plain, Building.Nothing, 'A')); 
    	tiles.add(new Tile(Terrain.Plain, Building.Village, 'A'));
    	tiles.add(new Tile(Terrain.Plain, Building.Castle, 'A')); 
    	tiles.add(new Tile(Terrain.Mountain, Building.Nothing, 'A')); 
    	tiles.add(new Tile(Terrain.Plain, Building.Village, 'B')); 
    	tiles.add(new Tile(Terrain.Forest, Building.Village, 'B')); 
    	tiles.add(new Tile(Terrain.Plain, Building.Town, 'B')); 
    	tiles.add(new Tile(Terrain.Plain, Building.Castle, 'B')); 
    	tiles.add(new Tile(Terrain.Lake, Building.Nothing, 'B')); 
    	tiles.add(new Tile(Terrain.Plain, Building.Nothing, 'C')); 
    	tiles.add(new Tile(Terrain.Plain, Building.Nothing, 'C')); 
    	tiles.add(new Tile(Terrain.Forest, Building.Town, 'C')); 
    	tiles.add(new Tile(Terrain.Plain, Building.Castle, 'C')); 
    	tiles.add(new Tile(Terrain.Forest, Building.Castle, 'C')); 
    	tiles.add(new Tile(Terrain.Forest, Building.Village, 'D')); 
    	tiles.add(new Tile(Terrain.Plain, Building.Town, 'D')); 
    	tiles.add(new Tile(Terrain.Plain, Building.Castle, 'D')); 
    	tiles.add(new Tile(Terrain.Plain, Building.Castle, 'D')); 
    	tiles.add(new Tile(Terrain.Mountain, Building.Nothing, 'D')); 
    	tiles.add(new Tile(Terrain.Plain, Building.Nothing, 'E')); 
    	tiles.add(new Tile(Terrain.Forest, Building.Village, 'E')); 
    	tiles.add(new Tile(Terrain.Plain, Building.Town, 'E')); 
    	tiles.add(new Tile(Terrain.Plain, Building.Castle, 'E')); 
    	tiles.add(new Tile(Terrain.Forest, Building.Castle, 'E'));
    }
    
    private void shuffleTiles(int start, int end, int repeat){
    	int one;
    	int two;
    	
    	for(int i = 0; i < repeat; i++){
    		one = generator.nextInt()%(end-start)+start;
    		two = generator.nextInt()%(end-start)+start;
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
    
    public Tile getTile1(){
    	return tiles.get(0);
    }
    
    public Tile getTile2(){
    	return tiles.get(1);
    }

    public Integer getSize(){
        return tiles.size();
    }
}
