package domain;


import domain.enums.Building;
import domain.enums.Color;
import domain.utils.GameUtils;

import java.awt.Point;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.*;

/**
 *
 * @author Aaron
 */
public class GUI extends javax.swing.JFrame {


    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public GUI() {
        initComponents();
    }

    private void placeTile(Tile tile, Point location){
        game.placeTile(tile, location);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        PlayerSelection = new javax.swing.JFrame();
        firstPlayer = new javax.swing.JPanel();
        kindPlayer1 = new javax.swing.JComboBox();
        color1 = new javax.swing.JComboBox();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        month1 = new javax.swing.JComboBox();
        day1 = new javax.swing.JComboBox();
        year1 = new javax.swing.JComboBox();
        secondPlayer = new javax.swing.JPanel();
        kindPlayer2 = new javax.swing.JComboBox();
        color2 = new javax.swing.JComboBox();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        month2 = new javax.swing.JComboBox();
        day2 = new javax.swing.JComboBox();
        year2 = new javax.swing.JComboBox();
        thirdPlayer = new javax.swing.JPanel();
        kindPlayer3 = new javax.swing.JComboBox();
        color3 = new javax.swing.JComboBox();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        month3 = new javax.swing.JComboBox();
        day3 = new javax.swing.JComboBox();
        year3 = new javax.swing.JComboBox();
        fourthPlayer = new javax.swing.JPanel();
        kindPlayer4 = new javax.swing.JComboBox();
        color4 = new javax.swing.JComboBox();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        month4 = new javax.swing.JComboBox();
        day4 = new javax.swing.JComboBox();
        year4 = new javax.swing.JComboBox();
        startGame = new javax.swing.JButton();
        InGame = new javax.swing.JFrame();
        PlayerPanel = new javax.swing.JPanel();
        jButton104 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        endTurn = new javax.swing.JButton();
        card1 = new javax.swing.JButton();
        card2 = new javax.swing.JButton();
        numberOfNights = new javax.swing.JLabel();
        playersTurn = new javax.swing.JLabel();
        currentColor = new javax.swing.JLabel();
        grid = new javax.swing.JPanel();
        errorNotEnoughPlayers = new javax.swing.JDialog();
        errorNotEnoughPlayersMsg = new javax.swing.JLabel();
        errorOK = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        Menu = new javax.swing.JMenuBar();
        File = new javax.swing.JMenu();
        newGame = new javax.swing.JMenuItem();
        loadGame = new javax.swing.JMenuItem();
        close = new javax.swing.JMenuItem();
        Edit = new javax.swing.JMenu();
        Help = new javax.swing.JMenu();
        about = new javax.swing.JMenuItem();
        help = new javax.swing.JMenuItem();

        PlayerSelection.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        PlayerSelection.setMinimumSize(new java.awt.Dimension(1100, 500));
        PlayerSelection.setResizable(false);

        kindPlayer1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Player" }));
        kindPlayer1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kindPlayer1ActionPerformed(evt);
            }
        });

        color1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Blue" }));
        color1.setEnabled(false);

        jLabel22.setText("Color");

        jLabel23.setText("Birthdate");

        month1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" }));

        day1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));

        year1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1988", "1989", "1990", "1991", "1992", "1993", "1994", "1995", "1996", "1997", "1998", "1999", "2000", "2001", "2002", "2003", "2004", "2005", "2006", "2007", "2008", "2009", "2010", "2011", "2012" }));

        javax.swing.GroupLayout firstPlayerLayout = new javax.swing.GroupLayout(firstPlayer);
        firstPlayer.setLayout(firstPlayerLayout);
        firstPlayerLayout.setHorizontalGroup(
            firstPlayerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(firstPlayerLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(firstPlayerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel23, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel22, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(kindPlayer1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(color1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(firstPlayerLayout.createSequentialGroup()
                        .addComponent(month1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(day1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(year1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 20, Short.MAX_VALUE)))
                .addContainerGap())
        );
        firstPlayerLayout.setVerticalGroup(
            firstPlayerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(firstPlayerLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(kindPlayer1, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(color1, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(firstPlayerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(month1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(day1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(year1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(44, Short.MAX_VALUE))
        );

        kindPlayer2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Player" }));
        kindPlayer2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kindPlayer2ActionPerformed(evt);
            }
        });

        color2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Green" }));
        color2.setEnabled(false);

        jLabel24.setText("Color");

        jLabel25.setText("Birthdate");

        month2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" }));

        day2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));

        year2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1988", "1989", "1990", "1991", "1992", "1993", "1994", "1995", "1996", "1997", "1998", "1999", "2000", "2001", "2002", "2003", "2004", "2005", "2006", "2007", "2008", "2009", "2010", "2011", "2012" }));

        javax.swing.GroupLayout secondPlayerLayout = new javax.swing.GroupLayout(secondPlayer);
        secondPlayer.setLayout(secondPlayerLayout);
        secondPlayerLayout.setHorizontalGroup(
            secondPlayerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(secondPlayerLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(secondPlayerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel25, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel24, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(kindPlayer2, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(color2, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(secondPlayerLayout.createSequentialGroup()
                        .addComponent(month2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(day2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(year2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 20, Short.MAX_VALUE)))
                .addContainerGap())
        );
        secondPlayerLayout.setVerticalGroup(
            secondPlayerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(secondPlayerLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(kindPlayer2, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(color2, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(secondPlayerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(month2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(day2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(year2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(44, Short.MAX_VALUE))
        );

        kindPlayer3.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Player", "No Player" }));
        kindPlayer3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kindPlayer3ActionPerformed(evt);
            }
        });

        color3.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Yellow" }));
        color3.setEnabled(false);

        jLabel26.setText("Color");

        jLabel27.setText("Birthdate");

        month3.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" }));

        day3.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));

        year3.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1988", "1989", "1990", "1991", "1992", "1993", "1994", "1995", "1996", "1997", "1998", "1999", "2000", "2001", "2002", "2003", "2004", "2005", "2006", "2007", "2008", "2009", "2010", "2011", "2012" }));

        javax.swing.GroupLayout thirdPlayerLayout = new javax.swing.GroupLayout(thirdPlayer);
        thirdPlayer.setLayout(thirdPlayerLayout);
        thirdPlayerLayout.setHorizontalGroup(
            thirdPlayerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(thirdPlayerLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(thirdPlayerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel27, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel26, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(kindPlayer3, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(color3, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(thirdPlayerLayout.createSequentialGroup()
                        .addComponent(month3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(day3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(year3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 20, Short.MAX_VALUE)))
                .addContainerGap())
        );
        thirdPlayerLayout.setVerticalGroup(
            thirdPlayerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(thirdPlayerLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(kindPlayer3, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(color3, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(thirdPlayerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(month3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(day3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(year3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(44, Short.MAX_VALUE))
        );

        kindPlayer4.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Player", "No Player" }));
        kindPlayer4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kindPlayer4ActionPerformed(evt);
            }
        });

        color4.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Red" }));
        color4.setEnabled(false);

        jLabel28.setText("Color");

        jLabel29.setText("Birthdate");

        month4.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" }));

        day4.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));

        year4.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1988", "1989", "1990", "1991", "1992", "1993", "1994", "1995", "1996", "1997", "1998", "1999", "2000", "2001", "2002", "2003", "2004", "2005", "2006", "2007", "2008", "2009", "2010", "2011", "2012" }));

        javax.swing.GroupLayout fourthPlayerLayout = new javax.swing.GroupLayout(fourthPlayer);
        fourthPlayer.setLayout(fourthPlayerLayout);
        fourthPlayerLayout.setHorizontalGroup(
            fourthPlayerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(fourthPlayerLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(fourthPlayerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel29, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel28, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(kindPlayer4, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(color4, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(fourthPlayerLayout.createSequentialGroup()
                        .addComponent(month4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(day4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(year4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        fourthPlayerLayout.setVerticalGroup(
            fourthPlayerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(fourthPlayerLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(kindPlayer4, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(color4, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(fourthPlayerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(month4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(day4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(year4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        startGame.setText("Start Game");
        startGame.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startGameActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PlayerSelectionLayout = new javax.swing.GroupLayout(PlayerSelection.getContentPane());
        PlayerSelection.getContentPane().setLayout(PlayerSelectionLayout);
        PlayerSelectionLayout.setHorizontalGroup(
            PlayerSelectionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PlayerSelectionLayout.createSequentialGroup()
                .addContainerGap(152, Short.MAX_VALUE)
                .addComponent(firstPlayer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(secondPlayer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(thirdPlayer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PlayerSelectionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PlayerSelectionLayout.createSequentialGroup()
                        .addComponent(fourthPlayer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(48, 48, 48))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PlayerSelectionLayout.createSequentialGroup()
                        .addComponent(startGame, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        PlayerSelectionLayout.setVerticalGroup(
            PlayerSelectionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PlayerSelectionLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PlayerSelectionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PlayerSelectionLayout.createSequentialGroup()
                        .addComponent(fourthPlayer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(startGame, javax.swing.GroupLayout.DEFAULT_SIZE, 61, Short.MAX_VALUE))
                    .addGroup(PlayerSelectionLayout.createSequentialGroup()
                        .addGroup(PlayerSelectionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(firstPlayer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(thirdPlayer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(secondPlayer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        PlayerSelection.getAccessibleContext().setAccessibleParent(newGame);

        InGame.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        InGame.setMinimumSize(new java.awt.Dimension(900, 600));

        jButton104.setText("Deck");
        jButton104.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton104ActionPerformed(evt);
            }
        });

        jLabel1.setText("Player:");

        jLabel2.setText("Knights");

        endTurn.setText("End Turn");
        endTurn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                endTurnActionPerformed(evt);
            }
        });

        card1.setIcon(new ImageIcon("resources/castle.jpg")); // NOI18N
        card1.setText("CASTLE"); // NOI18N
        card1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                card1ActionPerformed(evt);
            }
        });

        //card2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/RobberKnights/resources/Village.jpg"))); // NOI18N
        card2.setIcon(new ImageIcon("resources/village.jpg"));
        card2.setText("VILAGE"); // NOI18N
        card2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                card2ActionPerformed(evt);
            }
        });

        numberOfNights.setText("jLabel5");

        playersTurn.setText("Number");

        currentColor.setText("Color");

        javax.swing.GroupLayout PlayerPanelLayout = new javax.swing.GroupLayout(PlayerPanel);
        PlayerPanel.setLayout(PlayerPanelLayout);
        PlayerPanelLayout.setHorizontalGroup(
            PlayerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PlayerPanelLayout.createSequentialGroup()
                .addGroup(PlayerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PlayerPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(card1, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(card2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addGroup(PlayerPanelLayout.createSequentialGroup()
                        .addGroup(PlayerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(PlayerPanelLayout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addComponent(endTurn, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(PlayerPanelLayout.createSequentialGroup()
                                .addGap(33, 33, 33)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(51, 51, 51)
                                .addComponent(numberOfNights))
                            .addGroup(PlayerPanelLayout.createSequentialGroup()
                                .addGap(62, 62, 62)
                                .addGroup(PlayerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButton104, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(PlayerPanelLayout.createSequentialGroup()
                                        .addGap(29, 29, 29)
                                        .addComponent(jLabel1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(PlayerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(currentColor)
                                            .addComponent(playersTurn, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        PlayerPanelLayout.setVerticalGroup(
            PlayerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PlayerPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PlayerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(playersTurn, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(3, 3, 3)
                .addComponent(currentColor)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton104, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PlayerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(card1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(card2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(28, 28, 28)
                .addGroup(PlayerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(numberOfNights))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 119, Short.MAX_VALUE)
                .addComponent(endTurn, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52))
        );

        javax.swing.GroupLayout gridLayout = new javax.swing.GroupLayout(grid);
        grid.setLayout(gridLayout);
        gridLayout.setHorizontalGroup(
            gridLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 574, Short.MAX_VALUE)
        );
        gridLayout.setVerticalGroup(
            gridLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout InGameLayout = new javax.swing.GroupLayout(InGame.getContentPane());
        InGame.getContentPane().setLayout(InGameLayout);
        InGameLayout.setHorizontalGroup(
            InGameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, InGameLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(grid, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(PlayerPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        InGameLayout.setVerticalGroup(
            InGameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(InGameLayout.createSequentialGroup()
                .addComponent(PlayerPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(InGameLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(grid, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        errorNotEnoughPlayers.setIconImage(null);
        errorNotEnoughPlayers.setMinimumSize(new java.awt.Dimension(400, 300));
        errorNotEnoughPlayers.setResizable(false);

        errorNotEnoughPlayersMsg.setText("                               Error: Must have at least two players");

        errorOK.setText("OK");
        errorOK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                errorOKActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout errorNotEnoughPlayersLayout = new javax.swing.GroupLayout(errorNotEnoughPlayers.getContentPane());
        errorNotEnoughPlayers.getContentPane().setLayout(errorNotEnoughPlayersLayout);
        errorNotEnoughPlayersLayout.setHorizontalGroup(
            errorNotEnoughPlayersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(errorNotEnoughPlayersLayout.createSequentialGroup()
                .addGroup(errorNotEnoughPlayersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(errorNotEnoughPlayersLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(errorNotEnoughPlayersMsg, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE))
                    .addGroup(errorNotEnoughPlayersLayout.createSequentialGroup()
                        .addGap(146, 146, 146)
                        .addComponent(errorOK, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        errorNotEnoughPlayersLayout.setVerticalGroup(
            errorNotEnoughPlayersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(errorNotEnoughPlayersLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(errorNotEnoughPlayersMsg, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(errorOK, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(52, Short.MAX_VALUE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        //jLabel4.setIcon(new javax.swing.ImageIcon("/trunk/resources/RobberKnights.jpg")); // NOI18N
        
        
        File.setText("File");

        newGame.setText("New Game");
        newGame.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newGameActionPerformed(evt);
            }
        });
        File.add(newGame);

        loadGame.setText("Load Game");
        File.add(loadGame);

        close.setText("Close");
        close.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeActionPerformed(evt);
            }
        });
        File.add(close);

        Menu.add(File);

        Edit.setText("Edit");
        Menu.add(Edit);

        Help.setText("Help");

        about.setText("About");
        about.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aboutActionPerformed(evt);
            }
        });
        Help.add(about);

        help.setText("Help");
        help.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                helpActionPerformed(evt);
            }
        });
        Help.add(help);

        Menu.add(Help);

        setJMenuBar(Menu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel4)
                .addContainerGap(30, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel4)
                .addContainerGap(33, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>

    private void aboutActionPerformed(java.awt.event.ActionEvent evt) {                                      
        // TODO add your handling code here:
    }                                     

    private void helpActionPerformed(java.awt.event.ActionEvent evt) {                                     
        // TODO add your handling code here:
    }                                    

    private void startGameActionPerformed(java.awt.event.ActionEvent evt) {                                          
        //Check to see if there is at least two players
        // TODO : need to add more checks
        ArrayList<Date> dates = new ArrayList<Date>();
        
        /*SimpleDateFormat sdf = new SimpleDateFormat("MM/DD/YYYY");
        
//        String dateStr = new String(month1.getSelectedIndex() + "/" + day1.getSelectedIndex() + "/" + year1.getSelectedIndex());

        try {
            Date d1 = GameUtils.parseDate((String) month1.getSelectedItem(), (String) day1.getSelectedItem(), (String) year1.getSelectedItem());
            Date d2 = GameUtils.parseDate((String) month2.getSelectedItem(), (String) day2.getSelectedItem(), (String) year2.getSelectedItem());
            Date d3 = GameUtils.parseDate((String) month3.getSelectedItem(), (String) day3.getSelectedItem(), (String) year3.getSelectedItem());
            Date d4 = GameUtils.parseDate((String) month4.getSelectedItem(), (String) day4.getSelectedItem(), (String) year4.getSelectedItem());
            dates.add(d1);
            dates.add(d2);
            dates.add(d3);
            dates.add(d4);

        } catch (ParseException e) {//TODO: add handling
            e.printStackTrace();
        }*/

        dates.add(new Date(Integer.parseInt(year1.getSelectedItem().toString()) - 1900, month1.getSelectedIndex(), day1.getSelectedIndex()+1));
        dates.add(new Date(Integer.parseInt(year2.getSelectedItem().toString()) - 1900, month2.getSelectedIndex(), day2.getSelectedIndex()+1));
        dates.add(new Date(Integer.parseInt(year3.getSelectedItem().toString()) - 1900, month3.getSelectedIndex(), day3.getSelectedIndex()+1));
        dates.add(new Date(Integer.parseInt(year4.getSelectedItem().toString()) - 1900, month4.getSelectedIndex(), day4.getSelectedIndex()+1));
        int numOfPlayers = 2;
        ArrayList<Color> colors = new ArrayList<Color>();
        colors.add(Color.BLUE);
        colors.add(Color.GREEN);
        colors.add(Color.YELLOW);
        colors.add(Color.RED);

        if (kindPlayer3.getSelectedIndex() == 0) {
            numOfPlayers++;
        }
        if (kindPlayer4.getSelectedIndex() == 0) {
            numOfPlayers++;
        }

        game = new RobberKnight(numOfPlayers, colors, dates);
        currentPlayer = game.getFirstPlayer();
        InGame.setVisible(true);
        PlayerSelection.setVisible(false);
        //Display current Player #
        playersTurn.setText(Integer.toString(game.getFirstPlayer() + 1));
        //Display Color
        if (game.getCurrentPlayer().getColor().equals(domain.enums.Color.BLUE)) {
            currentColor.setText("Blue");
            InGame.getContentPane().setBackground(new java.awt.Color(0,102,255));
            PlayerPanel.setBackground(new java.awt.Color(0,102,255));
        }
        else if (game.getCurrentPlayer().getColor().equals(domain.enums.Color.GREEN)) {
            currentColor.setText("Green");
            InGame.getContentPane().setBackground(new java.awt.Color(0,153,0));
            PlayerPanel.setBackground(new java.awt.Color(0,153,0));
        }
        else if (game.getCurrentPlayer().getColor().equals(domain.enums.Color.YELLOW)) {
            currentColor.setText("Yellow");
            InGame.getContentPane().setBackground(new java.awt.Color(255,255,0));
            PlayerPanel.setBackground(new java.awt.Color(255,255,0));
        } else {
            currentColor.setText("Red");
            InGame.getContentPane().setBackground(new java.awt.Color(255,0,0));
            PlayerPanel.setBackground(new java.awt.Color(255,0,0));
        }

        

        if (numOfPlayers == 2) {
            grid.setLayout(new java.awt.GridLayout(7, 7));
            for (int i = 0; i < 7 * 7; i++) {
                final javax.swing.JButton button = new javax.swing.JButton();
                button.addActionListener(new java.awt.event.ActionListener() {

                    @Override
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        //button.setIcon(selectedCard.getIcon());
                        button.setText(selectedCard.getText());
                        //TODO check to see if it's a valid move
                        //draw a new card
                        //after first play, set it = null
                    }
                });
                grid.add(button);
            }
        } else if (numOfPlayers == 3) {
            grid.setLayout(new java.awt.GridLayout(9, 9));
            for (int i = 0; i < 9 * 9; i++) {
                final javax.swing.JButton button = new javax.swing.JButton();
                button.addActionListener(new java.awt.event.ActionListener() {

                    @Override
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        //button.setIcon(selectedCard.getIcon());
                    	button.setText(selectedCard.getText());
                    }
                });
                grid.add(button);
            }
        } else {
            grid.setLayout(new java.awt.GridLayout(10, 10));
            for (int i = 0; i < 10 * 10; i++) {
                final javax.swing.JButton button = new javax.swing.JButton();
                button.addActionListener(new java.awt.event.ActionListener() {

                    @Override
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        //button.setIcon(selectedCard.getIcon());
                    	button.setText(selectedCard.getText());
                    }
                });
                grid.add(button);
            }
        }

        
    }                                         

    private void kindPlayer1ActionPerformed(java.awt.event.ActionEvent evt) {                                           
        if (kindPlayer1.getSelectedIndex() == 1){
            month1.setEnabled(false);
            day1.setEnabled(false);
            year1.setEnabled(false);
            color1.setEnabled(false);
            
        }
        if (kindPlayer1.getSelectedIndex() == 0){
            month1.setEnabled(true);
            day1.setEnabled(true);
            year1.setEnabled(true);
            color1.setEnabled(true);
        }
    }                                          

    private void kindPlayer2ActionPerformed(java.awt.event.ActionEvent evt) {                                            
        if (kindPlayer2.getSelectedIndex() == 1){
            month2.setEnabled(false);
            day2.setEnabled(false);
            year2.setEnabled(false);
            color2.setEnabled(false);

        }
        if (kindPlayer2.getSelectedIndex() == 0){
            month2.setEnabled(true);
            day2.setEnabled(true);
            year2.setEnabled(true);
            color2.setEnabled(true);
        }
    }                                           

    private void kindPlayer3ActionPerformed(java.awt.event.ActionEvent evt) {                                            
        if (kindPlayer3.getSelectedIndex() == 1){
            month3.setEnabled(false);
            day3.setEnabled(false);
            year3.setEnabled(false);
            color3.setEnabled(false);
        }
        if (kindPlayer3.getSelectedIndex() == 0){
            month3.setEnabled(true);
            day3.setEnabled(true);
            year3.setEnabled(true);
            color3.setEnabled(true);
        }
    }                                           

    private void kindPlayer4ActionPerformed(java.awt.event.ActionEvent evt) {                                            
        if (kindPlayer4.getSelectedIndex() == 1){
            month4.setEnabled(false);
            day4.setEnabled(false);
            year4.setEnabled(false);
            color4.setEnabled(false);
        }
        if (kindPlayer4.getSelectedIndex() == 0){
            month4.setEnabled(true);
            day4.setEnabled(true);
            year4.setEnabled(true);
            color4.setEnabled(true);
        }
    }                                           

    private void errorOKActionPerformed(java.awt.event.ActionEvent evt) {                                        
        errorNotEnoughPlayers.setVisible(false);
    }                                       

    private void newGameActionPerformed(java.awt.event.ActionEvent evt) {                                        
        PlayerSelection.setVisible(true);
        this.setVisible(false);
    }                                       

    private void closeActionPerformed(java.awt.event.ActionEvent evt) {                                      
        System.exit(0);
    }                                     

    private void endTurnActionPerformed(java.awt.event.ActionEvent evt) {
        //TODO
        currentPlayer = game.getNextPlayer();
        playersTurn.setText(Integer.toString(currentPlayer + 1));
        //Change color
        if (game.getCurrentPlayer().getColor().equals(domain.enums.Color.BLUE)) {
            currentColor.setText("Blue");
            InGame.getContentPane().setBackground(new java.awt.Color(0,102,255));
            PlayerPanel.setBackground(new java.awt.Color(0,102,255));
        }
        else if (game.getCurrentPlayer().getColor().equals(domain.enums.Color.GREEN)) {
            currentColor.setText("Green");
            InGame.getContentPane().setBackground(new java.awt.Color(0,153,0));
            PlayerPanel.setBackground(new java.awt.Color(0,153,0));
        }
        else if (game.getCurrentPlayer().getColor().equals(domain.enums.Color.YELLOW)) {
            currentColor.setText("Yellow");
            InGame.getContentPane().setBackground(new java.awt.Color(255,255,0));
            PlayerPanel.setBackground(new java.awt.Color(255,255,0));
        } else {
            currentColor.setText("Red");
            InGame.getContentPane().setBackground(new java.awt.Color(255,0,0));
            PlayerPanel.setBackground(new java.awt.Color(255,0,0));
        }
    }

    private void card1ActionPerformed(java.awt.event.ActionEvent evt) {
        //selectedCard.setIcon(card1.getIcon());
    	selectedCard.setText(card1.getText());
    	//TODO add tile to game
        //game.placeTile();
    }

    private void card2ActionPerformed(java.awt.event.ActionEvent evt) {
        //selectedCard.setIcon(card2.getIcon());
        selectedCard.setText(card2.getText());
        //TODO add tile to game
        //game.placeTile();
    }

    private void jButton104ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new GUI().setVisible(true);
            }
        });
    }
    private javax.swing.JButton selectedCard = new javax.swing.JButton("Null");
    private RobberKnight game = new RobberKnight(0, null, null);
    private int currentPlayer = 0;
    // Variables declaration - do not modify
    private javax.swing.JMenu Edit;
    private javax.swing.JMenu File;
    private javax.swing.JMenu Help;
    private javax.swing.JFrame InGame;
    private javax.swing.JMenuBar Menu;
    private javax.swing.JPanel PlayerPanel;
    private javax.swing.JFrame PlayerSelection;
    private javax.swing.JMenuItem about;
    private javax.swing.JButton card1;
    private javax.swing.JButton card2;
    private javax.swing.JMenuItem close;
    private javax.swing.JComboBox color1;
    private javax.swing.JComboBox color2;
    private javax.swing.JComboBox color3;
    private javax.swing.JComboBox color4;
    private javax.swing.JLabel currentColor;
    private javax.swing.JComboBox day1;
    private javax.swing.JComboBox day2;
    private javax.swing.JComboBox day3;
    private javax.swing.JComboBox day4;
    private javax.swing.JButton endTurn;
    private javax.swing.JDialog errorNotEnoughPlayers;
    private javax.swing.JLabel errorNotEnoughPlayersMsg;
    private javax.swing.JButton errorOK;
    private javax.swing.JPanel firstPlayer;
    private javax.swing.JPanel fourthPlayer;
    private javax.swing.JPanel grid;
    private javax.swing.JMenuItem help;
    private javax.swing.JButton jButton104;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JComboBox kindPlayer1;
    private javax.swing.JComboBox kindPlayer2;
    private javax.swing.JComboBox kindPlayer3;
    private javax.swing.JComboBox kindPlayer4;
    private javax.swing.JMenuItem loadGame;
    private javax.swing.JComboBox month1;
    private javax.swing.JComboBox month2;
    private javax.swing.JComboBox month3;
    private javax.swing.JComboBox month4;
    private javax.swing.JMenuItem newGame;
    private javax.swing.JLabel numberOfNights;
    private javax.swing.JLabel playersTurn;
    private javax.swing.JPanel secondPlayer;
    private javax.swing.JButton startGame;
    private javax.swing.JPanel thirdPlayer;
    private javax.swing.JComboBox year1;
    private javax.swing.JComboBox year2;
    private javax.swing.JComboBox year3;
    private javax.swing.JComboBox year4;
    // End of variables declaration
}
