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
        players = new ArrayList<Player>();
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
     * Place players chosen tile on turn.
     */
    private void startGame(ArrayList<Tile> tiles){
        for(Tile t : tiles){
            board.placeTile(t);
        }
        beginTurns();
    }

    /**
     * Main loop that keeps game running until all tiles have been exhausted.
     */
    private void beginTurns() {
        while(playersHaveTiles()){
            for(Player p : players){
                if(p.isInGame()){
                    p.takeTurn();
                }
            }
        }
        endGame();
    }

    /**
     * Totals points and ends game.
     */
    private void endGame() {

    }


    /**
     * Checks if all players still have tiles remaining. Sets players without tiles to inactive.  Returns false if all player's
     * decks are empty.
     * @return - status of game
     */
    private boolean playersHaveTiles(){
        boolean continueGame = false;
        for(Player p : players){
            if(p.getDeck().getSize() <= 0){
                p.setInGame(false);
            }
            else{
                continueGame = true;
            }
        }
        return continueGame;
    }

    /**
     * Takes given player out of game.
     * @param playerId
     */
    private void surrender(int playerId){
        try{
            Player p = lookUpPlayerById(playerId);
            p.setInGame(false);
        }
        catch(Exception e){

        }

    }

    /**
     * Looks up current player in game by id.
     * @param id
     * @return
     * @throws NoSuchPlayerException
     */
    private Player lookUpPlayerById(int id) throws NoSuchPlayerException{
        for(Player p : players){
            if(p.getId().equals(id)){
                return p;
            }
        }

        throw new NoSuchPlayerException("No player with given id current in game.");
    }
}
