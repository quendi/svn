package domain;

import domain.enums.*;
import domain.enums.Color;

import java.awt.*;
import java.util.Date;

/**
 * Created by IntelliJ IDEA.
 * User: Joe
 * Date: Apr 10, 2012
 * Time: 5:41:38 PM
 * To change this template use File | Settings | File Templates.
 */
public class Player {
	private int numKnights;
    private String name;
    private Color color;
    private int id;
    private Date birthDate;
    private Deck deck;
    private boolean inGame;
    private PlayerListener playerListener;

    public Player(){}

    public Player(Color color, Date birthdate, int id, PlayerListener pl) {
        this.color = color;
        this.birthDate = birthdate;
        this.deck = new Deck();
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumKnights() {
        return numKnights;
    }

    public void setNumKnights(int numKnights) {
        this.numKnights = numKnights;
    }

    public void playTile(Tile t){
        deck.playTile(t);
        playerListener.updateHand();
    }

    public void notifyHand(){
        playerListener.updateHand(this);
    }
}