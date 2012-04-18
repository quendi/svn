
/**
 * @author Samareh
 */

package domain;

import java.util.*;

import domain.enums.Building;
import domain.enums.Terrain;

public class Deck {
	private ArrayList<Tile> tiles = new ArrayList<Tile>();
    private Random generator = new Random(System.currentTimeMillis());

    public Deck(){
        initialize();       
    }
    public void initialize(){ 
    	int rep;
    	populateDeck();
    	rep = generator.nextInt(10)+10;
    	shuffleTiles(4, 8, rep);	//b
    	rep = generator.nextInt(10)+10;
    	shuffleTiles(9, 13, rep);	//c
    	rep = generator.nextInt(10)+10;
    	shuffleTiles(14, 18, rep);	//e
    	rep = generator.nextInt(10)+10;
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
    		one = (generator.nextInt(end-start+1)) + start;
    		two = (generator.nextInt(end-start+1)) + start;
    		System.out.println("swapping " + one + "and" + two);
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

    public void playTile(Tile t){
        tiles.remove(t);
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

    public Integer getSize(){
        return tiles.size();
    }
}
