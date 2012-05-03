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

    private JLabel playernum = new JLabel();


    public PlayerPanel(Player p){


        JButton card1 = new JButton();
        JPanel handPanel = new JPanel();
        handPanel.add(card1);
        JButton card2 = new JButton();
        handPanel.add(card2);

        JPanel infoPanel = new JPanel();
        JLabel knight = new JLabel("Knight");
        infoPanel.add(knight);
        JLabel knightNum = new JLabel();
        infoPanel.add(knightNum);
    	
    	this.setLayout(new GridLayout(4,1));
        JLabel player = new JLabel("Player: ");
        this.add(player);
        JLabel deckPic = new JLabel("Deck");
        this.add(deckPic);
    	this.add(handPanel);
    	
    	

    	
    }

    
}