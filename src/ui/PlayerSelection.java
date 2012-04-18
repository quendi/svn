package ui;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.*;

import domain.RobberKnight;
import domain.enums.Color;
import ui.GUI;

public class PlayerSelection extends GUI {
	private JFrame PlayerSelection = new javax.swing.JFrame();
    private javax.swing.JComboBox kindPlayer1 = new javax.swing.JComboBox();
    private javax.swing.JComboBox kindPlayer2 = new javax.swing.JComboBox();
    private javax.swing.JComboBox kindPlayer3 = new javax.swing.JComboBox();
    private javax.swing.JComboBox kindPlayer4 = new javax.swing.JComboBox();
    private javax.swing.JComboBox color1 = new javax.swing.JComboBox();
    private javax.swing.JComboBox color2 = new javax.swing.JComboBox();
    private javax.swing.JComboBox color3 = new javax.swing.JComboBox();
    private javax.swing.JComboBox color4 = new javax.swing.JComboBox();
    private javax.swing.JComboBox day1 = new javax.swing.JComboBox();
    private javax.swing.JComboBox day2 = new javax.swing.JComboBox();
    private javax.swing.JComboBox day3 = new javax.swing.JComboBox();
    private javax.swing.JComboBox day4 = new javax.swing.JComboBox();
    private javax.swing.JPanel firstPlayer = new javax.swing.JPanel();
    private javax.swing.JPanel fourthPlayer = new javax.swing.JPanel();
    private javax.swing.JPanel secondPlayer = new javax.swing.JPanel();
    private javax.swing.JButton startGame = new javax.swing.JButton();
    private javax.swing.JPanel thirdPlayer = new javax.swing.JPanel();
    private javax.swing.JComboBox year1 = new javax.swing.JComboBox();
    private javax.swing.JComboBox year2 = new javax.swing.JComboBox();
    private javax.swing.JComboBox year3 = new javax.swing.JComboBox();
    private javax.swing.JComboBox year4 = new javax.swing.JComboBox();
    private javax.swing.JComboBox month1 = new javax.swing.JComboBox();
    private javax.swing.JComboBox month2 = new javax.swing.JComboBox();
    private javax.swing.JComboBox month3 = new javax.swing.JComboBox();
    private javax.swing.JComboBox month4 = new javax.swing.JComboBox();
    private javax.swing.JLabel jLabel22  = new javax.swing.JLabel();
    private javax.swing.JLabel jLabel23 = new javax.swing.JLabel();
    private javax.swing.JLabel jLabel24 = new javax.swing.JLabel();
    private javax.swing.JLabel jLabel25 = new javax.swing.JLabel();
    private javax.swing.JLabel jLabel26 = new javax.swing.JLabel();
    private javax.swing.JLabel jLabel27 = new javax.swing.JLabel();
    private javax.swing.JLabel jLabel28 = new javax.swing.JLabel();
    private javax.swing.JLabel jLabel29 = new javax.swing.JLabel();
   
    
	public PlayerSelection(boolean visible){
		PlayerSelection.setVisible(visible);
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
		
	}
	
	private void startGameActionPerformed(java.awt.event.ActionEvent evt) {
        //Check to see if there is at least two players
        // TODO : need to add more checks
        ArrayList<Date> dates = new ArrayList<Date>();
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
        card1.setIcon(currentPlayer.getDeck().getTile1().getImage()); // NOI18N
        card2.setIcon(currentPlayer.getDeck().getTile2().getImage()); // NOI18N
        InGame.setVisible(true);
        PlayerSelection.setVisible(false);
        //Display current Player #
        playersTurn.setText(Integer.toString(currentPlayer.getId() + 1));
        numberOfKnights.setText(Integer.toString(currentPlayer.getNumKnights()));
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

        setUpGrid(grid, numOfPlayers);


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

}
