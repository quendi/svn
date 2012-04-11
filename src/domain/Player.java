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
public class Player {
    private Color color;
    private int id; // TODO make this random.  create in contructor
    private Date birthDate;
    private Deck deck;
    private boolean inGame;
    public Player(Color color, Date birthdate) {
        //To change body of created methods use File | Settings | File Templates.
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

    /**
     * Exucute player turn
     */
    //TODO: How to handle this?  Prompt ui to let them know current player is taking their turn?
    public void takeTurn() {
    }
}
