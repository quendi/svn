package ui;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.*;

import domain.RobberKnight;
import domain.enums.Color;

public class PlayerSelection {
    private JFrame PlayerSelection = new JFrame();
    private JComboBox kindPlayer1 = new JComboBox();
    private JComboBox kindPlayer2 = new JComboBox();
    private JComboBox kindPlayer3 = new JComboBox();
    private JComboBox kindPlayer4 = new JComboBox();
    private JComboBox color1 = new JComboBox();
    private JComboBox color2 = new JComboBox();
    private JComboBox color3 = new JComboBox();
    private JComboBox color4 = new JComboBox();
    private JComboBox day1 = new JComboBox();
    private JComboBox day2 = new JComboBox();
    private JComboBox day3 = new JComboBox();
    private JComboBox day4 = new JComboBox();
    private JPanel firstPlayer = new JPanel();
    private JPanel fourthPlayer = new JPanel();
    private JPanel secondPlayer = new JPanel();
    private JButton startGame = new JButton();
    private JPanel thirdPlayer = new JPanel();
    private JComboBox year1 = new JComboBox();
    private JComboBox year2 = new JComboBox();
    private JComboBox year3 = new JComboBox();
    private JComboBox year4 = new JComboBox();
    private JComboBox month1 = new JComboBox();
    private JComboBox month2 = new JComboBox();
    private JComboBox month3 = new JComboBox();
    private JComboBox month4 = new JComboBox();
    private JLabel jLabel22  = new JLabel();
    private JLabel jLabel23 = new JLabel();
    private JLabel jLabel24 = new JLabel();
    private JLabel jLabel25 = new JLabel();
    private JLabel jLabel26 = new JLabel();
    private JLabel jLabel27 = new JLabel();
    private JLabel jLabel28 = new JLabel();
    private JLabel jLabel29 = new JLabel();
    private RobberKnight game;
    private GUI gui;


    public PlayerSelection(boolean visible, GUI gui, RobberKnight game){
        this.gui = gui;
        PlayerSelection.setVisible(visible);
        PlayerSelection.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        PlayerSelection.setMinimumSize(new java.awt.Dimension(1100, 500));
        PlayerSelection.setResizable(false);
        kindPlayer1.setModel(new DefaultComboBoxModel(new String[] { "Player" }));
        kindPlayer1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kindPlayer1ActionPerformed(evt);
            }
        });

        color1.setModel(new DefaultComboBoxModel(new String[] { "Blue" }));
        color1.setEnabled(false);

        jLabel22.setText("Color");

        jLabel23.setText("Birthdate");

        month1.setModel(new DefaultComboBoxModel(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" }));

        day1.setModel(new DefaultComboBoxModel(new String[] { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));

        year1.setModel(new DefaultComboBoxModel(new String[] { "1988", "1989", "1990", "1991", "1992", "1993", "1994", "1995", "1996", "1997", "1998", "1999", "2000", "2001", "2002", "2003", "2004", "2005", "2006", "2007", "2008", "2009", "2010", "2011", "2012" }));

        GroupLayout firstPlayerLayout = new GroupLayout(firstPlayer);
        firstPlayer.setLayout(firstPlayerLayout);
        firstPlayerLayout.setHorizontalGroup(
                firstPlayerLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(firstPlayerLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(firstPlayerLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel23, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel22, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(kindPlayer1, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(color1, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(firstPlayerLayout.createSequentialGroup()
                                .addComponent(month1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(day1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(year1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 20, Short.MAX_VALUE)))
                        .addContainerGap())
        );
        firstPlayerLayout.setVerticalGroup(
                firstPlayerLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(firstPlayerLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(kindPlayer1, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel22, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(color1, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel23, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(firstPlayerLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(month1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addComponent(day1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addComponent(year1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(44, Short.MAX_VALUE))
        );

        kindPlayer2.setModel(new DefaultComboBoxModel(new String[] { "Player" }));
        kindPlayer2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kindPlayer2ActionPerformed(evt);
            }
        });

        color2.setModel(new DefaultComboBoxModel(new String[] { "Green" }));
        color2.setEnabled(false);

        jLabel24.setText("Color");

        jLabel25.setText("Birthdate");

        month2.setModel(new DefaultComboBoxModel(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" }));

        day2.setModel(new DefaultComboBoxModel(new String[] { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));

        year2.setModel(new DefaultComboBoxModel(new String[] { "1988", "1989", "1990", "1991", "1992", "1993", "1994", "1995", "1996", "1997", "1998", "1999", "2000", "2001", "2002", "2003", "2004", "2005", "2006", "2007", "2008", "2009", "2010", "2011", "2012" }));

        GroupLayout secondPlayerLayout = new GroupLayout(secondPlayer);
        secondPlayer.setLayout(secondPlayerLayout);
        secondPlayerLayout.setHorizontalGroup(
                secondPlayerLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(secondPlayerLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(secondPlayerLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel25, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel24, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(kindPlayer2, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(color2, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(secondPlayerLayout.createSequentialGroup()
                                .addComponent(month2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(day2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(year2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 20, Short.MAX_VALUE)))
                        .addContainerGap())
        );
        secondPlayerLayout.setVerticalGroup(
                secondPlayerLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(secondPlayerLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(kindPlayer2, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel24, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(color2, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel25, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(secondPlayerLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(month2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addComponent(day2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addComponent(year2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(44, Short.MAX_VALUE))
        );

        kindPlayer3.setModel(new DefaultComboBoxModel(new String[] { "Player", "No Player" }));
        kindPlayer3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kindPlayer3ActionPerformed(evt);
            }
        });

        color3.setModel(new DefaultComboBoxModel(new String[] { "Yellow" }));
        color3.setEnabled(false);

        jLabel26.setText("Color");

        jLabel27.setText("Birthdate");

        month3.setModel(new DefaultComboBoxModel(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" }));

        day3.setModel(new DefaultComboBoxModel(new String[] { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));

        year3.setModel(new DefaultComboBoxModel(new String[] { "1988", "1989", "1990", "1991", "1992", "1993", "1994", "1995", "1996", "1997", "1998", "1999", "2000", "2001", "2002", "2003", "2004", "2005", "2006", "2007", "2008", "2009", "2010", "2011", "2012" }));

        GroupLayout thirdPlayerLayout = new GroupLayout(thirdPlayer);
        thirdPlayer.setLayout(thirdPlayerLayout);
        thirdPlayerLayout.setHorizontalGroup(
                thirdPlayerLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(thirdPlayerLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(thirdPlayerLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel27, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel26, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(kindPlayer3, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(color3, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(thirdPlayerLayout.createSequentialGroup()
                                .addComponent(month3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(day3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(year3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 20, Short.MAX_VALUE)))
                        .addContainerGap())
        );
        thirdPlayerLayout.setVerticalGroup(
                thirdPlayerLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(thirdPlayerLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(kindPlayer3, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel26, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(color3, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel27, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(thirdPlayerLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(month3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addComponent(day3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addComponent(year3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(44, Short.MAX_VALUE))
        );

        kindPlayer4.setModel(new DefaultComboBoxModel(new String[] { "Player", "No Player" }));
        kindPlayer4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kindPlayer4ActionPerformed(evt);
            }
        });

        color4.setModel(new DefaultComboBoxModel(new String[] { "Red" }));
        color4.setEnabled(false);

        jLabel28.setText("Color");

        jLabel29.setText("Birthdate");

        month4.setModel(new DefaultComboBoxModel(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" }));

        day4.setModel(new DefaultComboBoxModel(new String[] { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));

        year4.setModel(new DefaultComboBoxModel(new String[] { "1988", "1989", "1990", "1991", "1992", "1993", "1994", "1995", "1996", "1997", "1998", "1999", "2000", "2001", "2002", "2003", "2004", "2005", "2006", "2007", "2008", "2009", "2010", "2011", "2012" }));

        GroupLayout fourthPlayerLayout = new GroupLayout(fourthPlayer);
        fourthPlayer.setLayout(fourthPlayerLayout);
        fourthPlayerLayout.setHorizontalGroup(
                fourthPlayerLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(fourthPlayerLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(fourthPlayerLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel29, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel28, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(kindPlayer4, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(color4, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(fourthPlayerLayout.createSequentialGroup()
                                .addComponent(month4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(day4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(year4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())
        );
        fourthPlayerLayout.setVerticalGroup(
                fourthPlayerLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(fourthPlayerLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(kindPlayer4, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel28, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(color4, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel29, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(fourthPlayerLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(month4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addComponent(day4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addComponent(year4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(22, Short.MAX_VALUE))
        );

        startGame.setText("Start Game");
        startGame.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startGameActionPerformed(evt);
            }
        });

        GroupLayout PlayerSelectionLayout = new GroupLayout(PlayerSelection.getContentPane());
        PlayerSelection.getContentPane().setLayout(PlayerSelectionLayout);
        PlayerSelectionLayout.setHorizontalGroup(
                PlayerSelectionLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(PlayerSelectionLayout.createSequentialGroup()
                        .addContainerGap(152, Short.MAX_VALUE)
                        .addComponent(firstPlayer, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(secondPlayer, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(thirdPlayer, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(PlayerSelectionLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(PlayerSelectionLayout.createSequentialGroup()
                                .addComponent(fourthPlayer, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGap(48, 48, 48))
                        .addGroup(GroupLayout.Alignment.TRAILING, PlayerSelectionLayout.createSequentialGroup()
                        .addComponent(startGame, GroupLayout.PREFERRED_SIZE, 211, GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        PlayerSelectionLayout.setVerticalGroup(
                PlayerSelectionLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(PlayerSelectionLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(PlayerSelectionLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addGroup(PlayerSelectionLayout.createSequentialGroup()
                                        .addComponent(fourthPlayer, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(startGame, GroupLayout.DEFAULT_SIZE, 61, Short.MAX_VALUE))
                                .addGroup(PlayerSelectionLayout.createSequentialGroup()
                                .addGroup(PlayerSelectionLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(firstPlayer, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(thirdPlayer, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(secondPlayer, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())
        );


    }

    /**
     * Event that creates new game accoarding to information entered into ui.
     * @param evt
     */

	private void startGameActionPerformed(java.awt.event.ActionEvent evt) {
        //Check to see if there is at least two players
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

        // Create game and return to main window(GUI).
        game = new RobberKnight(numOfPlayers, colors, dates, gui);
        gui.startGame(game);
        PlayerSelection.setVisible(false);
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
