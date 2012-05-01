package domain;

import domain.enums.Building;
import domain.enums.Color;
import utils.GameUtils;

import java.awt.*;
import java.io.Serializable;
import java.util.ArrayList;
//import org.apache.commons.lang3.ArrayUtils;

/**
 * Created by IntelliJ IDEA.
 * User: Joe
 * Date: Apr 10, 2012
 * Time: 5:42:36 PM
 * To change this template use File | Settings | File Templates.
 */



public class Board implements Serializable{
    private int size;
    private Tile[][] tiles;
    private BoardListener boardListener;

    private boolean x_end=false;
    private boolean y_end=false;

    private static int MAX_KNIGHTS = 4;


    private int[] playerTotals = new int[4];


    /**
     * Creates board according to number of players
     * @param numPlayers - number of players in game
     */
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
     * Iterate through the array of tiles, check top knight, add points to player according to building
     */
    public void calculatePoints(){
        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                if(tiles[i][j] != null && tiles[i][j].getNumKnights() > 0){
                    if(tiles[i][j].getTopKnight().equals(Color.BLUE)){
                        if(tiles[i][j].getBuilding().equals(Building.Castle))
                            playerTotals[0]++;
                        else if(tiles[i][j].getBuilding().equals(Building.Village))
                            playerTotals[0]+=2;
                        else if(tiles[i][j].getBuilding().equals(Building.Town))
                            playerTotals[0]+=3;
                    }
                    else if(tiles[i][j].getTopKnight().equals(Color.GREEN)){
                        if(tiles[i][j].getBuilding().equals(Building.Castle))
                            playerTotals[1]++;
                        else if(tiles[i][j].getBuilding().equals(Building.Village))
                            playerTotals[1]+=2;
                        else if(tiles[i][j].getBuilding().equals(Building.Town))
                            playerTotals[1]+=3;
                    }
                    else if(tiles[i][j].getTopKnight().equals(Color.YELLOW)){
                        if(tiles[i][j].getBuilding().equals(Building.Castle))
                            playerTotals[2]++;
                        else if(tiles[i][j].getBuilding().equals(Building.Village))
                            playerTotals[2]+=2;
                        else if(tiles[i][j].getBuilding().equals(Building.Town))
                            playerTotals[2]+=3;
                    }
                    else{
                        if(tiles[i][j].getBuilding().equals(Building.Castle))
                            playerTotals[3]++;
                        else if(tiles[i][j].getBuilding().equals(Building.Village))
                            playerTotals[3]+=2;
                        else if(tiles[i][j].getBuilding().equals(Building.Town))
                            playerTotals[3]+=3;
                    }
                }
                else{
                    //Do nothing
                }
            }
        }
    }
    /**
     * Return final scores to RobberKnight class
     */
    public int[] getPlayerTotals(){
        return playerTotals;
    }

    /**
     * Places tile in location.
     * @param t
     * @param p
     * @return
     */

    public boolean placeTile(Tile t, Point p, boolean init, Player player) {
        // if there has an exist tile, new tile can't be put
        if ( tiles[p.x][p.y] == null ){
            if ( isValidMove(p) || init){
                t.setLocation(p);
                tiles[(int) t.getLocation().getX()][(int) t.getLocation().getY()] = t;
                player.playTile(t);
                notifyPlaced(t, false);
                if (Building.Castle.equals(t.getBuilding())) {
                    notifyCastlePlacement(t);
                }
                //System.out.println("X: " + t.getLocation().getX() + " Y: " + t.getLocation().getY());
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

    private void notifyCastlePlacement(Tile t) {
        boardListener.placedCastle(t);
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
                                notifyPlaced(tiles[i][j], true);
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
                                notifyPlaced(tiles[i][j], true);
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
                    notifyPlaced(tiles[i][j], true);
                }
            }
        }
    }


    /**
     * Places knight on tile castle.  Returns true if successful.
     * @param castle
     * @param numKnights
     * @param currentPlayerColor
     * @return
     */
    public boolean placeKnight(Tile castle, int numKnights, Color currentPlayerColor){
        // Make sure the number of knights being placed is at least the minimum amount of knights for the tile.
        if(numKnights >= castle.getMinimumKnights()){
        	castle.AddKnights(numKnights, currentPlayerColor);
            boardListener.placedKnight(castle, castle.getNumKnights(), GameUtils.getColor(currentPlayerColor));
            return true;
        }
        return false;
    }

    /**
     * Moves knight from tile to adjacent tile.  Returns true on success.
     * @param start - tile to move knight from
     * @param destination - tile to move knights to
     * @param numKnights - number of knights player chooses to move
     * @param currentPlayerColor - color of player making move
     * @return
     */
    public boolean moveKnight(Tile start, Tile destination, int numKnights, Color currentPlayerColor){
        // Make sure there are enough knights left behind to move
        if(start.getNumKnights() - numKnights < start.getMinimumKnights()){
            return false;
        }

        // Make sure there are enough knights on the destination tile, but not greather than 4
        else if (destination.getNumKnights() + numKnights > MAX_KNIGHTS || destination.getNumKnights() + numKnights < destination.getMinimumKnights()){
            return false;
        }

        // Remove knights from the start tile and add too the distination's knight.
        else{
        	start.RemoveKnights(numKnights);
            destination.AddKnights(numKnights, currentPlayerColor);
            boardListener.movedKnight(start, start.getNumKnights(), destination, destination.getNumKnights(), GameUtils.getColor(currentPlayerColor));
            return true;
        }

    }

    /**
     * Get valid moves after player has made a move.  Called after knights have been moved.
     * @param castle  - castle knight movement originated from.
     * @param lastPlaced  - the last tile the player moved kngihts to.
     * @param numKnights  - number of knnight player wishes to move
     * @return
     */
    public ArrayList<Integer> getValidMoves(Tile castle, Tile lastPlaced, int numKnights){
        int diffX = (int) ( lastPlaced.getLocation().getX() - castle.getLocation().getX());
        int diffY = (int) (lastPlaced.getLocation().getY() - castle.getLocation().getY());
        Point p = lastPlaced.getLocation();
        // Tile that can possible by moved to next
        Tile nextMovement = null;

        // Knights are being moved horizontally
        if(diffX != 0){
            // Knights are being moved to the right.
            if(diffX > 0){
                // Check next tile to the right of tile where movement last occured.
                if (p.x != 0) {
                    if(tiles[p.x +1][p.y] != null){
                        nextMovement = tiles[p.x +1][p.y];
                    }
                }
            }
            // Knight are being moved to the left.
            else{
                // Check next tile to the left of tile where movement last occured.
                if (p.x != size-1) {
                    if (tiles[p.x -1][p.y] != null ){
                        nextMovement = tiles[p.x -1][p.y];
                    }
                }
            }
        }

        // Knights are being moved vertically.
        else{
            // Knight are being moved down.
            if(diffY > 0){
                // Check next tile below the tile where movement last occured.
                if (p.y != size-1) {
                    if(tiles[p.x][p.y +1] != null){
                        nextMovement = tiles[p.x][p.y +1];
                    }
                }
            }
            // Knight are being moved up.
            else{
                // Check next tile above the tile where movement last occured.
                if (p.y != 0) {
                    if(tiles[p.x][p.y -1] != null){
                        nextMovement = tiles[p.x][p.y -1];
                    }
                }
            }
        }

        ArrayList<Integer> boardLocations = new ArrayList<Integer>();
        if(nextMovement != null){
            int moveableKnights = numKnights - castle.getMinimumKnights();
            if (moveableKnights > 0) {
                ArrayList<Integer> knightsAvailble = new ArrayList<Integer>();
                for(int i = 1; i <= moveableKnights; i++){
                    knightsAvailble.add(moveableKnights);
                }
                // Check which adjacent tiles can be moves with the amount of knights the player can move.
                for (Integer knights : knightsAvailble) {
                    if(knights + nextMovement.getNumKnights() >= nextMovement.getMinimumKnights() && knights + nextMovement.getNumKnights() <= MAX_KNIGHTS) {
                        int gridLocation = GameUtils.getGridLocation(nextMovement, size);
                        if(!boardLocations.contains(gridLocation)){
                            boardLocations.add(gridLocation);
                        }
                    }
                }
            }
        }
        return boardLocations;
    }

    /**
     * Return grid locations of valid moves. Called when player is intially placing tiles on castle
     * @param castle - castle tile player is moving knights from
     * @param numKnights - number of knights available for the player to move
     * @return
     */
    public ArrayList<Integer> getValidMoves(Tile castle, int numKnights){
        Point p = castle.getLocation();
        // get adjacent tiles
        ArrayList<Tile> adjacentTiles = new ArrayList<Tile>();
        ArrayList<Integer> boardLocations = new ArrayList<Integer>();
        if( p.x != 0 ){
            if( tiles[p.x -1][p.y] != null )
                adjacentTiles.add(tiles[p.x -1][p.y]);
        }
        if( p.y != 0 ){
            if( tiles[p.x][p.y -1] != null )
                adjacentTiles.add(tiles[p.x][p.y -1]);
        }
        if( p.x != size-1 ){
            if( tiles[p.x +1][p.y] != null )
                adjacentTiles.add(tiles[p.x +1][p.y]);
        }
        if( p.y != size-1 ){
            if( tiles[p.x][p.y +1] != null )
                adjacentTiles.add(tiles[p.x][p.y +1]);
        }
        // Number of knights available for movement is obtained by the minimum knights the must be left behind
        int moveableKnights = numKnights - castle.getMinimumKnights();
        if (moveableKnights > 0) {
            ArrayList<Integer> knightsAvailble = new ArrayList<Integer>();
            for(int i = 1; i <= moveableKnights; i++){
                knightsAvailble.add(i);
            }
            // Check which adjacent tiles can be moves with the amount of knights the player can move.
            for(Tile tile : adjacentTiles){
                for (Integer knights : knightsAvailble) {
                    if(knights + tile.getNumKnights() >= tile.getMinimumKnights() && knights + tile.getNumKnights() <= MAX_KNIGHTS) {
                        int gridLocation = GameUtils.getGridLocation(tile, size);
                        if(!boardLocations.contains(gridLocation)){
                            boardLocations.add(gridLocation);
                        }
                    }
                }
            }
        }
        return boardLocations;
    }

    /**
     * Check is if tile is adjacent to a already placed tile.
     * @param p - location of tile to be placed
     * @return
     */
    public boolean isValidMove(Point p) {
        if( p.x != 0 ){
            if( tiles[p.x -1][p.y] != null )
                return true;
        }
        if( p.y != 0 ){
            if( tiles[p.x][p.y -1] != null )
                return true;
        }
        if( p.x != size-1 ){
            if( tiles[p.x +1][p.y] != null )
                return true;
        }
        if( p.y != size-1 ){
            if( tiles[p.x][p.y +1] != null )
                return true;
        }
        return false;
    }

    public void addBoardListener(BoardListener bl){
        this.boardListener = bl;
    }

    public void notifyPlaced(Tile t, boolean sys){
        boardListener.placedTile(t, sys);
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


    public Tile getTile(Point moveTo) {
        return tiles[(int) moveTo.getX()][(int)moveTo.getY()];
    }

//    public ArrayList<Integer> getValidKnights(Tile castleTile, ArrayList<Integer> gridLocations) {
//        ArrayList<Tile> tilesToMoveTo = new ArrayList<Tile>();
//        for(Integer i : gridLocations){
//
//        }
//    }
}
