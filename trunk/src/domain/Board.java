package domain;

import java.awt.Point;
import java.util.ArrayList;

import domain.enums.Building;
import domain.enums.Color;
import utils.GameUtils;
//import org.apache.commons.lang3.ArrayUtils;

/**
 * Created by IntelliJ IDEA.
 * User: Joe
 * Date: Apr 10, 2012
 * Time: 5:42:36 PM
 * To change this template use File | Settings | File Templates.
 */



public class Board {
    private int size;
    private Tile[][] tiles;
    private BoardListener boardListener;
    
	private boolean x_end=false;
	private boolean y_end=false;

    private static int MAX_KNIGHTS = 4;

    public Board(int numPlayers) {
        if ( numPlayers == 2 )
            size=7+1;
        else if ( numPlayers == 3 )
            size=9+1;
        else
            size=10+1;

        tiles=new Tile[size][size];
    }

    /**
     * Places tile in location.
     * @param t
     * @param p
     * @return
     */
    //todo check if tile is placed in a valid location
    public boolean placeTile(Tile t, Point p, boolean init) {
        // if there has an exist tile, new tile can't be put
        if ( tiles[(int) p.x][(int) p.y] == null ){
        	if ( isValidMove(p) == true || init == true ){
                t.setLocation(p);
                tiles[(int) t.getLocation().getX()][(int) t.getLocation().getY()] = t;
                notifyPlaced(t); 
                System.out.println("X: " + t.getLocation().getX() + " Y: " + t.getLocation().getY());
                if( t.getLocation().getX() == 0 || 
                    t.getLocation().getY() == 0 || 
                    t.getLocation().getY() == size - 1 ||
                	t.getLocation().getX() == size - 1 ){
                	OutofBound(t);
                }
       		
        	}
        	else
        		return false;
        }
        else
            return false;
        return true;
    }
    
    private void OutofBound(Tile t){
    	int i, j;
    	
        if( t.getLocation().getX() == 0 ){
        	// check if it already reach the maximum board size
        	for( i = 0; i < size-1; i++ ){
        		if( tiles[size-2][i] != null ){
        			// System.out.println("x can't shift");
        			x_end = true;
        	    	// Remove current grid layout
        			notifyRemoved(x_end, y_end);
        			//Rebuild new Grid layout
        	    	for( i = 0;  i < size-1; i++){
        	    		for( j = 0;  j < size; j++){
        	    			if( tiles[i][j] != null ){
        	                    notifyPlaced(tiles[i][j]); 
        	    			}
        	        	}
        	    	}
        			return;
        		}
        	}
        	// System.out.println("shift x=x+1");
        	// shift the board
        	for( i = size-2;  i >= 0; i--){
        		for( j = 0;  j < size; j++){
        			if( tiles[i][j] != null ){
        				tiles[i][j].setLocation(new Point(i+1,j));
        				tiles[i+1][j] = tiles[i][j];
        				tiles[i][j] = null;
        			}
            	}
        	}
        } 
        if( t.getLocation().getY() == 0 ){
        	for( i = 0; i < size-1; i++ ){
        		if( tiles[i][size-2] != null ){
        			// System.out.println("can't shift");
        			y_end = true;
        	    	// Remove current grid layout
        			notifyRemoved(x_end, y_end);
        			//Rebuild new Grid layout
        	    	for( i = 0;  i < size; i++){
        	    		for( j = 0;  j < size; j++){
        	    			if( tiles[i][j] != null ){
        	                    notifyPlaced(tiles[i][j]); 
        	    			}
        	        	}
        	    	}
        			return;
        		}
        	}
        	// System.out.println("shift y=y+1");
        	// shift the board
        	for( i = size-2;  i >= 0; i--){
        		for( j = 0;  j < size; j++){
        			if( tiles[j][i] != null ){
        				tiles[j][i].setLocation(new Point(j,i+1));
        				tiles[j][i+1] = tiles[j][i];
        				tiles[j][i] = null;
        			}
            	}
        	}
        }
        if( t.getLocation().getY() == size - 1 ){
        	for( i = 0; i < size; i++ ){
        		if( tiles[i][1] != null ){
        			// System.out.println("can't shift");
        			y_end = true;
        			// return;
        		}
        	}
        	// System.out.println("shift y=y-1");
        	// shift the board
        	for( i = 1;  i < size; i++){
        		for( j = 0;  j < size; j++){
        			if( tiles[j][i] != null ){
        				tiles[j][i].setLocation(new Point(j,i-1));
        				tiles[j][i-1] = tiles[j][i];
        				tiles[j][i] = null;
        			}
            	}
        	}
        }
        if( t.getLocation().getX() == size - 1 ){
        	for( i = 0; i < size; i++ ){
        		if( tiles[1][i] != null ){
        			// System.out.println("can't shift");
        			x_end = true;
        			// return;
        		}
        	}
        	// System.out.println("shift x=x-1");
        	// shift the board
        	for( i = 1;  i < size; i++){
        		for( j = 0;  j < size; j++){
        			if( tiles[i][j] != null ){
        				tiles[i][j].setLocation(new Point(i-1,j));
        				tiles[i-1][j] = tiles[i][j];
        				tiles[i][j] = null;
        			}
            	}
        	}
        }
    	// Remove current grid layout
		notifyRemoved(x_end, y_end);
		//Rebuild new Grid layout
    	for( i = 0;  i < size; i++){
    		for( j = 0;  j < size; j++){
    			if( tiles[i][j] != null ){
                    notifyPlaced(tiles[i][j]); 
    			}
        	}
    	}
    }

//    //todo this is not the purpose of calculate points.  you have to add up each players point for the game.  the tile will already know the points by the
//    // building on it.
//    public int calculatePoints( Color c ){
//    	int point = 0;
//    	for( Tile t : tiles){
//    		if( t.TopKnight == c ){
//    			if( t.getBuilding() == Building.Castle )
//    				point+=1;
//    			else if( t.getBuilding() == Building.Village )
//    				point+=2;
//    			else if( t.getBuilding() == Building.Town )
//    				point+=3;
//
//
//    		}
//    	}
//    	return point;
//    }

    /**
     * Places knight on tile castle.  Returns true if successful.
     * @param castle
     * @param numKnights
     * @param currentPlayerColor
     * @return
     */
    public boolean placeKnight(Tile castle, int numKnights, Color currentPlayerColor){
        if(numKnights >= castle.getMinimumKnights()){
            castle.setNumKnights(numKnights + castle.getNumKnights());
            castle.setTopKnight(currentPlayerColor);
            boardListener.placedKnight(castle, numKnights + castle.getNumKnights(), GameUtils.getColor(currentPlayerColor));
            return true;
        }
        return false;
    }

    /**
     * Moves knight from tile to adjacent tile.  Returns true on success.
     * @param start
     * @param destination
     * @param numKnights
     * @param currentPlayerColor
     * @return
     */
    public boolean moveKnight(Tile start, Tile destination, int numKnights, Color currentPlayerColor){
        if(start.getNumKnights() - numKnights < start.getMinimumKnights()){
            return false;
        }

        else if (destination.getNumKnights() + numKnights > MAX_KNIGHTS){
            return false;
        }

        else{
            start.setNumKnights(start.getNumKnights() - numKnights);
            destination.setNumKnights(destination.getNumKnights() + numKnights);
            destination.setTopKnight(currentPlayerColor);
            return true;
        }

    }


    /**
     * Return valid locations a player can move to from current tile with current number of knights
     * @param t
     * @param numKnights
     * @return
     */
    public ArrayList<Point> getValidMoves(Tile t, int numKnights){
        int x = (int) t.getLocation().getX();
        int y = (int) t.getLocation().getY();
        ArrayList<Tile> row = new ArrayList<Tile>();
        ArrayList<Tile> column = new ArrayList<Tile>();
        for(int i = 0; i < size; i++){
            row.add(tiles[i][y]);
        }
        for(int i = 0; i < size; i++){
            column.add(tiles[x][y]);
        }


    return null;
    }

    /**
     * Check is if tile is adjacent to a already placed tile.
     * @param p - location of tile to be placed
     * @return
     */
    public boolean isValidMove(Point p) {
    	if( (int) p.x != 0 ){
        	if( tiles[(int) p.x-1][(int) p.y] != null )
        		return true;    		
    	}
    	if( (int) p.y != 0 ){
    		if( tiles[(int) p.x][(int) p.y-1] != null )
        		return true;
    	}
    	if( (int) p.x != size-1 ){
    		if( tiles[(int) p.x+1][(int) p.y] != null )
    			return true;
    	}
    	if( (int) p.y != size-1 ){
    		if( tiles[(int) p.x][(int) p.y+1] != null )
    			return true;
    	}
		return false;
    }

    public void addBoardListener(BoardListener bl){
        this.boardListener = bl;
    }

    public void notifyPlaced(Tile t){
        boardListener.placedTile(t);
    }
    
    // while shift, remove the icon of the tile which has been set to null
    public void notifyRemoved(boolean x_end, boolean y_end){
        boardListener.removedTile(x_end, y_end);
    }

    public void notifyKnightPlaced(Tile t, int numKnights, java.awt.Color playerColor){
        boardListener.placedKnight(t, numKnights, playerColor);
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }


}
