package domain;

import java.awt.*;
import java.util.ArrayList;
import java.util.Date;

import domain.enums.Color;
import exceptions.NoSuchPlayerException;
import utils.GameUtils;

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
    private int[] playerTotals = new int[4];


    public RobberKnight(int numPlayers, ArrayList<Color> colors, ArrayList<Date> dates, BoardListener bl){
        players = new ArrayList<Player>();
        initialize(numPlayers, colors, dates, bl);
    }
    
    /**
     * Return an array containing totals
     */
    public int[] getTotals(){
    	board.calculatePoints();
    	playerTotals = board.getPlayerTotals();
		return playerTotals;
    }

    /**
     * Initializes current game board and players.
     * @param numPlayers - used in determining size of board.
     */
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
        //TODO end the game
        if (playersHaveTiles()) {
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
        return null;
    }


    /**
     * Places tile on given location.  Return true on success, false on failure.
     * @param t -tile to be placed
     * @param location - location of tile
     * @param init - check to see if placement is part of intitial tile placement
     * @return
     */
    public boolean placeTile(Tile t, Point location, boolean init){
    	// if there has an exist tile, new tile can't be put
    	if(board.placeTile(t, location, init)){
            try {
                Player p = lookUpPlayerById(currentPlayerId);
                p.playTile(t);

            } catch (NoSuchPlayerException e) {
                e.printStackTrace();
            }
            return true;
        }
        else{
            return false;
        }
    }

    /**
     * Places knight of game board.  Returns true on success, false on failure
     * @param t - tile on which to place knights
     * @param numberOfKnights - knights to be placed
     * @return
     */
    public boolean placeKnight(Tile t, int numberOfKnights){
        try {
            Player p = lookUpPlayerById(currentPlayerId);
            // If knights are successfully replaced decrement player's knight count.
            if(board.placeKnight(t, numberOfKnights, p.getColor())){
                p.reduceKnights(numberOfKnights);
                return true;
            }
        } catch (NoSuchPlayerException e) {
            e.printStackTrace();         }
        return false;
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

    public int getMoveableKnights(Tile castle, Point moveTo){
        Tile goTo = board.getTile(moveTo);
        return (castle.getNumKnights() - castle.getMinimumKnights()) - goTo.getNumKnights();
    }

    //TODO Get direction of travel to limit knights movement.
    public void moveKnight(Tile castle, Point moveTo, int numberOfKnights) {
        try {
            Player current = lookUpPlayerById(currentPlayerId);
            Tile goTo = board.getTile(moveTo);
            if (!board.moveKnight(castle, goTo, numberOfKnights, current.getColor())){
                 turnListener.endKnightMovement();
            }
        } catch (NoSuchPlayerException e) {
            e.printStackTrace();
        }
    }
}
