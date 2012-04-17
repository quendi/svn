package domain;

import domain.enums.*;

import java.util.Date;

/**
 * Created by IntelliJ IDEA.
 * User: Joe
 * Date: Apr 10, 2012
 * Time: 5:41:38 PM
 * To change this template use File | Settings | File Templates.
 */
public class Player implements PlayerListener {
	public int numKnights;
    private Color color;
    private int id;
    private Date birthDate;
    private Deck deck;
    private boolean inGame;
    private PlayerListener playerListener;

    public Player(){}

    public Player(Color color, Date birthdate, int id) {
        this.color = color;
        this.birthDate = birthdate;
        this.deck = new Deck();
        this.numKnights = 30;
        this.id = id;
    }
    
    public void reduceKnights(int n){
    	numKnights -= n;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public Deck getDeck() {
        return deck;
    }

    public void setDeck(Deck deck) {
        this.deck = deck;
    }

    public boolean isInGame() {
        return inGame;
    }

    public void setInGame(boolean inGame) {
        this.inGame = inGame;
    }

    public void addInventoryListener(PlayerListener il){
        this.playerListener = il;
    }



    public void placeTile(){
        
        
    }

    public int getNumKnights() {
        return numKnights;
    }

    public void setNumKnights(int numKnights) {
        this.numKnights = numKnights;
    }

    /**
     * Execute player turn
     */
    //TODO: How to handle this?  Prompt ui to let them know current player is taking their turn?
    public void takeTurn() {
    }

    public void updateDeck(Tile t) {
        this.getDeck().playTile(t);
    }

    public void updateKnights(int knights) {
        this.reduceKnights(knights);
    }
}
