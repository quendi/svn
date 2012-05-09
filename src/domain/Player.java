package domain;

import domain.enums.Color;

import java.io.Serializable;
import java.util.Date;

/**
 * User: Joe
 * Date: Apr 10, 2012
 * Time: 5:41:38 PM
 */
public class Player implements Serializable{
    // SerialversionUID for serialization
	private static final long serialVersionUID = 1L;
	
	private int numKnights;
    private String name;
    private Color color;
    private int id;
    private Date birthDate;
    private Deck deck;
    private boolean inGame;
    private boolean surrendered;
    transient private PlayerListener playerListener;

    public Player(){}

    public Player(String name, Color color, Date birthdate, int id, PlayerListener pl) {
    	this.name = name;
        this.inGame = true;
        this.surrendered = false;
        this.color = color;
        this.birthDate = birthdate;
        this.deck = new Deck( color );
        this.numKnights = 30;
        this.id = id;
        this.playerListener = pl;
    }

    public void reduceKnights(int n){
    	numKnights -= n;
        playerListener.updateKnights(numKnights);
    }

    public Color getColor() {
        return this.color;
    }


    public int getId() {
        return id;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public Deck getDeck() {
        return deck;
    }

    public boolean isInGame() {
        return inGame;
    }

    public void setInGame(boolean inGame) {
        this.inGame = inGame;
    }

    public String getName() {
        return name;
    }

    public int getNumKnights() {
        return numKnights;
    }

    public void playTile(Tile t){
        deck.playTile(t);
        playerListener.updateHand();
    }

    public void notifyHand(){
        playerListener.updateHand(this);
    }
    
    public void addPlayerListener(PlayerListener pl){
        this.playerListener = pl;
    }

    public boolean isSurrendered() {
        return surrendered;
    }

    public void setSurrendered(boolean surrendered) {
        this.surrendered = surrendered;
    }


}
