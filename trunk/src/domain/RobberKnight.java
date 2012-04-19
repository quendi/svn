package domain;

import java.awt.*;
import java.util.ArrayList;
import java.util.Date;

import domain.enums.Color;
import exceptions.NoSuchPlayerException;

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
    private int currentPlayerId;
    private TurnListener turnListener;

    public RobberKnight(int numPlayers, ArrayList<Color> colors, ArrayList<Date> dates, BoardListener bl){
        players = new ArrayList<Player>();
        initialize(numPlayers, colors, dates, bl);
    }

    /**
     * Initializes current game board and players.
     * @param numPlayers - used in determining size of board.
     */
    //TODO: how to handle player color?
    private void initialize(int numPlayers, ArrayList<Color> colors, ArrayList<Date> birthDates, BoardListener bl){
        this.numPlayers = numPlayers;
        PlayerListener pl = (PlayerListener) bl;
        for(int i = 0; i < numPlayers; i++){
            players.add(new Player(colors.get(i), birthDates.get(i), i, pl));
        }
        board = new Board(numPlayers);
        board.addBoardListener(bl);
        this.turnListener = (TurnListener) bl;
    }

    /**
     * Find the player to begin game by birthdate
     * @return id of player to begin game
     */
    public Player getFirstPlayer(){
        Date firstDate = new Date();
        Player firstPlayer = new Player();
        for(Player p : players){
            if(p.getBirthDate().before(firstDate)){
                firstDate = p.getBirthDate();
                firstPlayer = p;
            }
        }
        currentPlayerId = firstPlayer.getId();
        notifyTurn(firstPlayer);
        return firstPlayer;
    }

    /**
     * Get next player to take turn.  Set current player to that id.
     * @return id of next player
     */
    public Player getNextPlayer() throws NoSuchPlayerException {
        currentPlayerId = (currentPlayerId + 1) % numPlayers;
        System.out.println("New player " + currentPlayerId + "of total " + numPlayers);
        try {
            Player next = lookUpPlayerById(currentPlayerId);
            notifyTurn(next);
            next.notifyHand();
            return next;
        } catch (NoSuchPlayerException e) {
            throw new NoSuchPlayerException("No player with id " + currentPlayerId + "found.");
        }
    }

    public Player NextPlayer() throws NoSuchPlayerException {
        return lookUpPlayerById((currentPlayerId + 1) % numPlayers);
    }

    // use init to check if this placement is the initial placement
    public boolean placeTile(Tile t, Point location, boolean init){
    	// if there has an exist tile, new tile can't be put
    	if ( board.placeTile(t, location, init) == false)
    		return false;
    	else
    		return true;
    }

    public Player getCurrentPlayer()
    {
        return players.get(currentPlayerId);
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
    protected Player lookUpPlayerById(int id) throws NoSuchPlayerException {
        for(Player p : players){
            if(p.getId() == id){
                return p;
            }
        }

        throw new NoSuchPlayerException("No player with id " + id + "found.");

    }

    public int getNumPlayers() {
        return numPlayers;
    }

    public void setNumPlayers(int numPlayers) {
        this.numPlayers = numPlayers;
    }

    public Board getBoard() {
        return board;
    }

    public void notifyTurn(Player currentPlayer){
        turnListener.playerTurn(currentPlayer);
    }
}
