package domain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import domain.enums.*;

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

    public RobberKnight(int numPlayers, ArrayList<Color> colors, ArrayList<Date> dates){
        initialize(numPlayers, colors, dates);
    }


    /**
     * Initializes current game board and players.
     * @param numPlayers - used in determining size of board.
     */
    //TODO: how to handle player color?
    private void initialize(int numPlayers, ArrayList<Color> colors, ArrayList<Date> birthDates){
         numPlayers = numPlayers;
         for(int i = 0; i < numPlayers; i++){
             players.add(new Player(colors.get(i), birthDates.get(i)));
         }
        board = new Board(numPlayers);
    }

    /**
     * Place playesr chosen tile on turn.
     */
    private void startGame(ArrayList<Tile> tiles){
        board.placeTile(tiles);
        takeTurn();

    }

    private void takeTurn() {
    }




}
