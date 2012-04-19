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

    private static int MAX_KNIGHTS = 4;

    //TODO: create board by numplayers
    public Board(int numPlayers) {
        if ( numPlayers == 2 )
            size=7;
        else if ( numPlayers == 3 )
            size=9;
        else
            size=10;

        tiles=new Tile[size][size];
    }

    /**
     * Places tile in location.  Returns 0 if successfull, -1 if failed.
     * @param t
     * @param p
     * @return
     */
    //todo check if tile is placed in a valid location
    public int placeTile(Tile t, Point p, int init) {
        // if there has an exist tile, new tile can't be put
        if ( tiles[(int) p.x][(int) p.y] == null ){
        	if (isValidMove(p) == 0 || init == 1){
                t.setLocation(p);
                tiles[(int) t.getLocation().getX()][(int) t.getLocation().getY()] = t;
                System.out.println("X: " + t.getLocation().getX() + " Y: " + t.getLocation().getY());
                if( t.getLocation().getX() == 0 || 
                    t.getLocation().getY() == 0 || 
                    t.getLocation().getY() == size - 1 ||
                	t.getLocation().getX() == size - 1 ){
                	OutofBound(t);
                }
                notifyPlaced(t);        		
        	}
        	else
        		return -1;
        }
        else
            return -1;
        return 0;
    }
    
    private void OutofBound(Tile t){
        if( t.getLocation().getX() == 0 ){
//        	if(  )
            	
        } 
        if( t.getLocation().getY() == 0 ){


        }
        if( t.getLocation().getY() == size - 1 ){


        }
        if( t.getLocation().getX() == size - 1 ){


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
            castle.setNumKnights(numKnights);
            castle.setTopKnight(currentPlayerColor);
            boardListener.placedKnight(castle, numKnights, GameUtils.getColor(currentPlayerColor));
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
    
    // check if this placement is next to an existed tile
    public int isValidMove(Point p) {
    	if( (int) p.x != 0 ){
        	if( tiles[(int) p.x-1][(int) p.y] != null )
        		return 0;    		
    	}
    	if( (int) p.y != 0 ){
    		if( tiles[(int) p.x][(int) p.y-1] != null )
        		return 0;
    	}
    	if( (int) p.x != size-1 ){
    		if( tiles[(int) p.x+1][(int) p.y] != null )
    			return 0;
    	}
    	if( (int) p.y != size-1 ){
    		if( tiles[(int) p.x][(int) p.y+1] != null )
    			return 0;
    	}
		return -1;
    }

    public void addBoardListener(BoardListener bl){
        this.boardListener = bl;
    }

    public void notifyPlaced(Tile t){
        boardListener.placedTile(t);
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
