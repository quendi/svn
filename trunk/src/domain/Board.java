package domain;

import java.awt.Point;
import java.util.ArrayList;

import domain.enums.Building;
import domain.enums.Color;

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

    //todo check if tile is placed in a valid location
    public void placeTile(Tile t, Point p) {
    	t.setLocation(p);
    	tiles[(int) t.getLocation().getX()][(int) t.getLocation().getY()] = t;
//    	notifyPlaced(t, p);
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

    public void addBoardListener(BoardListener bl){
        this.boardListener = bl;
    }

    public void notifyPlaced(Tile t, Point p){
        boardListener.placeTile(t, p);
    }
}
