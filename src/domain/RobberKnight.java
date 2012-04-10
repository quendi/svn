package domain;

import java.util.ArrayList;

/**
 * Created by IntelliJ IDEA.
 * User: Joe
 * Date: Apr 10, 2012
 * Time: 5:40:45 PM
 * To change this template use File | Settings | File Templates.
 */
public class RobberKnight {

    private int numPlayers;
    private ArrayList<Player> players;
    private Board board;

    public RobberKnight(){}


    /**
     * Initializes current game board and players.
     * @param numPlayers - used in determining size of board.
     */
    //TODO: how to handle player color?
    public void initialize(int numPlayers){
         numPlayers = numPlayers;
         for(int i = 0; i < numPlayers; i++){
             players.add(new Player());
         }

    }
    

    
    
}
