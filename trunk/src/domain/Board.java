package domain;

import java.awt.Point;
import java.util.ArrayList;

/**
 * Created by IntelliJ IDEA.
 * User: Joe
 * Date: Apr 10, 2012
 * Time: 5:42:36 PM
 * To change this template use File | Settings | File Templates.
 */
public class Board {
	private int size;
	
    //TODO: create board by numplayers
    public Board(int numPlayers) {
    	if ( numPlayers == 2 )
    		size=7;
    	else if ( numPlayers == 3 )
    		size=9;
    	else
    		size=10;
    }

    public void placeTile(Tile t) {
    	
    }
    
    
    
}
