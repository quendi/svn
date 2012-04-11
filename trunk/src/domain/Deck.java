package domain;

import java.util.*;

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
    	tiles.add(new Tile()); //a 
    	tiles.add(new Tile()); //a 
    	tiles.add(new Tile()); //a 
    	tiles.add(new Tile()); //a 
    	tiles.add(new Tile()); //b 
    	tiles.add(new Tile()); //b 
    	tiles.add(new Tile()); //b 
    	tiles.add(new Tile()); //b 
    	tiles.add(new Tile()); //b 
    	tiles.add(new Tile()); //c 
    	tiles.add(new Tile()); //c 
    	tiles.add(new Tile()); //c 
    	tiles.add(new Tile()); //c 
    	tiles.add(new Tile()); //c 
    	tiles.add(new Tile()); //d 
    	tiles.add(new Tile()); //d 
    	tiles.add(new Tile()); //d 
    	tiles.add(new Tile()); //d 
    	tiles.add(new Tile()); //d 
    	tiles.add(new Tile()); //e 
    	tiles.add(new Tile()); //e 
    	tiles.add(new Tile()); //e 
    	tiles.add(new Tile()); //e 
    	tiles.add(new Tile()); //e
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
    
    public Tile drawTile(){
    	Tile drawn = tiles.get(0);
    	tiles.remove(0);
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
