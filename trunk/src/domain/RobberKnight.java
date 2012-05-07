package domain;

import java.awt.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

import domain.enums.Color;
import exceptions.NoSuchPlayerException;

/**
 * User: Joe
 * Date: Apr 10, 2012
 * Time: 5:40:45 PM
 * To change this template use File | Settings | File Templates.
 */
public class RobberKnight implements Serializable{
    // SerialversionUID for serialization
    private static final long serialVersionUID = 1L;

    private int numPlayers;
    private ArrayList<Player> players;
    private Board board;
    private int currentPlayerId;
    transient private TurnListener turnListener;
    private static final int MAX_KNIGHT = 4;
    private int moveCounter = 0;


    public RobberKnight(int numPlayers, ArrayList<String> names, ArrayList<Color> colors, ArrayList<Date> dates, BoardListener bl){
        players = new ArrayList<Player>();
        initialize(numPlayers, names, colors, dates, bl);
    }

    /**
     * Return an array containing totals
     */
    public int[] getTotals(){
        board.calculatePoints();
        int[] playerTotals = board.getPlayerTotals();
        for(Player p : players){
            if(p.isSurrendered()){
                playerTotals[p.getId()] = 0;
            }
        }
        return playerTotals;
    }

    public Player getPlayerByNumber(int playerNumber){
        return players.get(playerNumber);
    }

    /**
     * Initializes current game board and players.
     * @param numPlayers - used in determining size of board.
     */
    private void initialize(int numPlayers, ArrayList<String> names, ArrayList<Color> colors, ArrayList<Date> birthDates, BoardListener bl){
        this.numPlayers = numPlayers;
        PlayerListener pl = (PlayerListener) bl;
        for(int i = 0; i < numPlayers; i++){
            players.add(new Player(names.get(i), colors.get(i), birthDates.get(i), i, pl));
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
        if (playersHaveTiles()) {
            try {
                Player next;
                // Get next player that is still in the game.  Repeat loop until a player that is still in the game is found.
                do {
                    currentPlayerId = (currentPlayerId + 1) % numPlayers;
                    next = lookUpPlayerById(currentPlayerId);
                } while (!next.isInGame());
                resetMoveCounter();
                notifyTurn(next);
                next.notifyHand();
                return next;
            } catch (NoSuchPlayerException e) {
                throw new NoSuchPlayerException("No player with id " + currentPlayerId + "found.");
            }
        }
        else{
            turnListener.endGame();
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
        try {
            Player p = lookUpPlayerById(currentPlayerId);
            if (board.placeTile(t, location, init, p)){
                return true;
            }
        }
        catch (NoSuchPlayerException e) {
            e.printStackTrace();
        }
        return false;

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
     * Takes given player out of game. End game if only one player is left after surrendering.  Is able to forcibly end a players turn,
     * even if they have yet to take a move.
     */
    public void surrender(){
        try{
            Player p = lookUpPlayerById(currentPlayerId);
            p.setInGame(false);
            p.setSurrendered(true);
            int playersLeft = 0;
            for(Player player : players){
                if (player.isInGame()){
                    playersLeft++;
                }

            }
            if(playersLeft == 1){
                turnListener.endGame();
            }
            turnListener.skipTurn();

        }

        catch(Exception e){
            e.printStackTrace();
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
        moveCounter = 0;
        turnListener.playerTurn(currentPlayer);
    }

    /**
     * Get the maximum amount of knights that are avaiable to move from castle to destination.
     * @param castle - castle kngihts are being moved from.
     * @param moveTo - location of tile player wishes to move to
     * @return - max # of knights that can be moved.
     */
    public int getMoveableKnights(Tile castle, Point moveTo){
        Tile goTo = board.getTile(moveTo);
        int castleKnightsMoveable = castle.getNumKnights() - castle.getMinimumKnights();
        int knightAvailable = MAX_KNIGHT - goTo.getNumKnights();
        return (knightAvailable <= castleKnightsMoveable) ?  knightAvailable : castleKnightsMoveable;
    }

    /**
     * Delegates to board the work of moveing a tile from castle to the tile the player wihses to move to.
     * End knight movement if kngihts are not able to be moved.
     * @param castle - tile where knights are moving from
     * @param moveTo - tile knights are being moved to
     * @param numberOfKnights - knights being moved
     */
    public void moveKnight(Tile castle, Tile moveTo, int numberOfKnights) {
        try {
            Player current = lookUpPlayerById(currentPlayerId);
            if (!board.moveKnight(castle, moveTo, numberOfKnights, current.getColor())){
                turnListener.endKnightMovement();
            }
        } catch (NoSuchPlayerException e) {
            e.printStackTrace();
        }
    }

    /**
     * Reset listeners for game.  Used when loading a new game.
     * @param bl
     * @param pl
     * @param tl
     */
    public void setListeners(BoardListener bl, PlayerListener pl, TurnListener tl){
        board.addBoardListener(bl);
        for(Player p : players){
            p.addPlayerListener(pl);
        }
        this.turnListener = tl;
    }

    public int getMoveCounter() {
        return moveCounter;
    }

    public void incrementMoveCounter(){
        moveCounter++;
    }

    public void resetMoveCounter() {
        this.moveCounter = 0;
    }

    public void confirmPlayerTurn() {
        if(moveCounter > 2){
            turnListener.endTurn();
        }
    }
}
