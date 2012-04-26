package ui;

import java.awt.*;

import domain.Player;

import javax.swing.*;

/**
 * User: Joe
 * Date: Apr 16, 2012
 * Time: 9:11:24 PM
 */
@SuppressWarnings("serial")
public class PlayerPanel extends JPanel {


    private JLabel knights = new JLabel("Knights: ");
    private JLabel playerLabel = new JLabel("Player: ");
    private JLabel currentPlayerLabel = new JLabel();
    private JLabel currentColor = new JLabel();
    private JButton endTurn = new JButton("End Turn");
    private JLabel numberOfKnights = new JLabel();
    Player currentPlayer;
    
    /**
     * First
     */
    private JLabel player = new JLabel("Player: ");
    private JLabel playernum = new JLabel();
    
    /**
     * Second
     */
    private JLabel deckPic = new JLabel("Deck");
    /**
     * Third
     */
    private JPanel handPanel = new JPanel();
    private JButton card1 = new JButton();
    private JButton card2 = new JButton();

    /**
     * Fourth
     */
    private JPanel infoPanel = new JPanel();
    private JLabel knight = new JLabel("Knight");
    private JLabel knightNum = new JLabel();
    
    
    public PlayerPanel(Player p){

    	
    	handPanel.add(card1);
    	handPanel.add(card2);
    	
    	infoPanel.add(knight);
    	infoPanel.add(knightNum);
    	
    	this.setLayout(new GridLayout(4,1));
    	this.add(player);
    	this.add(deckPic);
    	this.add(handPanel);
    	
    	

    	
    }

    
}