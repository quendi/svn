package domain;
import java.awt.Point;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

/**
 * @author Aaron
 */
@SuppressWarnings("serial")
public class GUI extends JFrame {
    public GUI() {
        initComponents();
    }

    private void initComponents() {

        PlayerSelection = new JFrame();
        firstPlayer = new JPanel();
        kindPlayer = new JComboBox();
        color = new JComboBox();
        jLabel22 = new JLabel();
        jLabel23 = new JLabel();
        month = new JComboBox();
        day = new JComboBox();
        year = new JComboBox();
        secondPlayer = new JPanel();
        kindPlayer2 = new JComboBox();
        color2 = new JComboBox();
        jLabel24 = new JLabel();
        jLabel25 = new JLabel();
        month2 = new JComboBox();
        day2 = new JComboBox();
        year2 = new JComboBox();
        thirdPlayer = new JPanel();
        kindPlayer3 = new JComboBox();
        color3 = new JComboBox();
        jLabel26 = new JLabel();
        jLabel27 = new JLabel();
        month3 = new JComboBox();
        day3 = new JComboBox();
        year3 = new JComboBox();
        fourthPlayer = new JPanel();
        kindPlayer4 = new JComboBox();
        color4 = new JComboBox();
        jLabel28 = new JLabel();
        jLabel29 = new JLabel();
        month4 = new JComboBox();
        day4 = new JComboBox();
        year4 = new JComboBox();
        startGame = new JButton();
        InGame = new JFrame();
        card1 = new JButton();
        card2 = new JButton();
        jButton104 = new JButton();
        jLabel2 = new JLabel();
        jLabel3 = new JLabel();
        errorNotEnoughPlayers = new JDialog();
        errorNotEnoughPlayersMsg = new JLabel();
        errorOK = new JButton();
        jLabel1 = new JLabel();
        Menu = new JMenuBar();
        File = new JMenu();
        newGame = new JMenuItem();
        loadGame = new JMenuItem();
        close = new JMenuItem();
        Edit = new JMenu();
        Help = new JMenu();
        about = new JMenuItem();
        help = new JMenuItem();

        PlayerSelection.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        PlayerSelection.setMinimumSize(new Dimension(1100, 500));
        PlayerSelection.setResizable(true);

        kindPlayer.setModel(new DefaultComboBoxModel(new String[] { "Player", "AI", "No Player" }));
        kindPlayer.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                kindPlayerActionPerformed(evt);
            }
        });

        color.setModel(new DefaultComboBoxModel(new String[] { "Blue", "Red", "Green", "Yellow" }));

        jLabel22.setText("Color");

        jLabel23.setText("Birthdate");

        month.setModel(new DefaultComboBoxModel(new String[] { "January", "Feburary", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December" }));
        month.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                //jComboBox38ActionPerformed(evt);
            }
        });

        day.setModel(new DefaultComboBoxModel(new String[] { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));

        year.setModel(new DefaultComboBoxModel(new String[] { "1988", "1989", "1990", "1991", "1992", "1993", "1994", "1995", "1996", "1997", "1998", "1999", "2000", "2001", "2002", "2003", "2004", "2005", "2006", "2007", "2008", "2009", "2010", "2011", "2012" }));

        GroupLayout firstPlayerLayout = new GroupLayout(firstPlayer);
        firstPlayer.setLayout(firstPlayerLayout);
        firstPlayerLayout.setHorizontalGroup(
            firstPlayerLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(firstPlayerLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(firstPlayerLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel23, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel22, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(kindPlayer, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(color, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(firstPlayerLayout.createSequentialGroup()
                        .addComponent(month, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(day, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(year, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 20, Short.MAX_VALUE)))
                .addContainerGap())
        );
        firstPlayerLayout.setVerticalGroup(
            firstPlayerLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(firstPlayerLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(kindPlayer, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel22, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(color, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel23, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(firstPlayerLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(month, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(day, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(year, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addContainerGap(44, Short.MAX_VALUE))
        );

        kindPlayer2.setModel(new DefaultComboBoxModel(new String[] { "Player", "AI", "No Player" }));
        kindPlayer2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                kindPlayer2ActionPerformed(evt);
            }
        });

        color2.setModel(new DefaultComboBoxModel(new String[] { "Blue", "Red", "Green", "Yellow" }));

        jLabel24.setText("Color");

        jLabel25.setText("Birthdate");

        month2.setModel(new DefaultComboBoxModel(new String[] { "January", "Feburary", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December" }));
        month2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                //month2jComboBox38ActionPerformed(evt);
            }
        });

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

        kindPlayer3.setModel(new DefaultComboBoxModel(new String[] { "Player", "AI", "No Player" }));
        kindPlayer3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                kindPlayer3ActionPerformed(evt);
            }
        });

        color3.setModel(new DefaultComboBoxModel(new String[] { "Blue", "Red", "Green", "Yellow" }));

        jLabel26.setText("Color");

        jLabel27.setText("Birthdate");

        month3.setModel(new DefaultComboBoxModel(new String[] { "January", "Feburary", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December" }));
        month3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                //month3jComboBox38ActionPerformed(evt);
            }
        });

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

        kindPlayer4.setModel(new DefaultComboBoxModel(new String[] { "Player", "AI", "No Player" }));
        kindPlayer4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                kindPlayer4ActionPerformed(evt);
            }
        });

        color4.setModel(new DefaultComboBoxModel(new String[] { "Blue", "Red", "Green", "Yellow" }));

        jLabel28.setText("Color");

        jLabel29.setText("Birthdate");

        month4.setModel(new DefaultComboBoxModel(new String[] { "January", "Feburary", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December" }));
        month4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
               // month4jComboBox38ActionPerformed(evt);
            }
        });

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
        startGame.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                startGameActionPerformed(evt);
            }
        });

        GroupLayout PlayerSelectionLayout = new GroupLayout(PlayerSelection.getContentPane());
        PlayerSelection.getContentPane().setLayout(PlayerSelectionLayout);
        PlayerSelectionLayout.setHorizontalGroup(
            PlayerSelectionLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(PlayerSelectionLayout.createSequentialGroup()
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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

        PlayerSelection.getAccessibleContext().setAccessibleParent(newGame);

        InGame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        InGame.setMinimumSize(new Dimension(900, 600));

        card1.setText("Card 1");
        card1.addMouseMotionListener(new MouseMotionAdapter() {
            public void mouseDragged(MouseEvent evt) {
                card1MouseDragged(evt);
            }
        });

        card2.setText("Card 2");
        card2.addMouseMotionListener(new MouseMotionAdapter() {
            public void mouseDragged(MouseEvent evt) {
                card2MouseDragged(evt);
            }
        });

        jButton104.setText("Deck");

        jLabel2.setText("Knights");

        jLabel3.setText("# of Knights");

        GroupLayout InGameLayout = new GroupLayout(InGame.getContentPane());
        InGame.getContentPane().setLayout(InGameLayout);
        InGameLayout.setHorizontalGroup(
            InGameLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, InGameLayout.createSequentialGroup()
                .addGap(0, 609, Short.MAX_VALUE)
                .addComponent(card1, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(card2, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton104, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
            .addGroup(GroupLayout.Alignment.TRAILING, InGameLayout.createSequentialGroup()
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addGap(53, 53, 53))
        );
        InGameLayout.setVerticalGroup(
            InGameLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(InGameLayout.createSequentialGroup()
                .addGap(200, 200, 200)
                .addGroup(InGameLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton104, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
                    .addComponent(card2, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
                    .addComponent(card1, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE))
                .addGap(53, 53, 53)
                .addGroup(InGameLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE))
                .addContainerGap(238, Short.MAX_VALUE))
        );

        errorNotEnoughPlayers.setIconImage(null);
        errorNotEnoughPlayers.setMinimumSize(new Dimension(400, 300));
        errorNotEnoughPlayers.setResizable(true);

        errorNotEnoughPlayersMsg.setText("                               Error: Must have at least two players");

        errorOK.setText("OK");
        errorOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                errorOKActionPerformed(evt);
            }
        });

        GroupLayout errorNotEnoughPlayersLayout = new GroupLayout(errorNotEnoughPlayers.getContentPane());
        errorNotEnoughPlayers.getContentPane().setLayout(errorNotEnoughPlayersLayout);
        errorNotEnoughPlayersLayout.setHorizontalGroup(
            errorNotEnoughPlayersLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(errorNotEnoughPlayersLayout.createSequentialGroup()
                .addGroup(errorNotEnoughPlayersLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(errorNotEnoughPlayersLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(errorNotEnoughPlayersMsg, GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE))
                    .addGroup(errorNotEnoughPlayersLayout.createSequentialGroup()
                        .addGap(146, 146, 146)
                        .addComponent(errorOK, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        errorNotEnoughPlayersLayout.setVerticalGroup(
            errorNotEnoughPlayersLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(errorNotEnoughPlayersLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(errorNotEnoughPlayersMsg, GroupLayout.PREFERRED_SIZE, 191, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(errorOK, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                .addContainerGap(52, Short.MAX_VALUE))
        );

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(true);
        //upload picture to package
        jLabel1.setIcon(new ImageIcon("C:\\Users\\Aaron\\Pictures\\RobberKnights.jpg")); 

        File.setText("File");

        newGame.setText("New Game");
        newGame.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                newGameActionPerformed(evt);
            }
        });
        File.add(newGame);

        loadGame.setText("Load Game");
        File.add(loadGame);

        close.setText("Close");
        close.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                closeActionPerformed(evt);
            }
        });
        File.add(close);

        Menu.add(File);

        Edit.setText("Edit");
        Menu.add(Edit);

        Help.setText("Help");

        about.setText("About");
        about.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                //aboutActionPerformed(evt);
            }
        });
        Help.add(about);

        help.setText("Help");
        help.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
               // helpActionPerformed(evt);
            }
        });
        Help.add(help);

        Menu.add(Help);

        setJMenuBar(Menu);

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel1)
                .addContainerGap(32, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel1)
                .addContainerGap(52, Short.MAX_VALUE))
        );

        pack();
    }



    private void startGameActionPerformed(ActionEvent evt) {
        //Check to see if there is at least two players
        // TODO : need to add more checks (only one player and no AI)
        if (kindPlayer.getSelectedIndex() == 2 && kindPlayer2.getSelectedIndex() == 2 && kindPlayer3.getSelectedIndex() == 2 && kindPlayer4.getSelectedIndex() == 2){
            errorNotEnoughPlayers.setVisible(true);
        }
        else{
            InGame.setVisible(true);
            PlayerSelection.setVisible(false);
        }
    }

    private void kindPlayerActionPerformed(ActionEvent evt) {
        if (kindPlayer.getSelectedIndex() == 1 || kindPlayer.getSelectedIndex() == 2){
            month.setEnabled(false);
            day.setEnabled(false);
            year.setEnabled(false);
            if(kindPlayer.getSelectedIndex() == 2){
                color.setEnabled(false);
            }
        }
        if (kindPlayer.getSelectedIndex() == 0){
            month.setEnabled(true);
            day.setEnabled(true);
            year.setEnabled(true);
            color.setEnabled(true);
        }
    }

    private void kindPlayer2ActionPerformed(ActionEvent evt) {
        if (kindPlayer2.getSelectedIndex() == 1 || kindPlayer2.getSelectedIndex() == 2){
            month2.setEnabled(false);
            day2.setEnabled(false);
            year2.setEnabled(false);
            if(kindPlayer2.getSelectedIndex() == 2){
                color2.setEnabled(false);
            }
        }
        if (kindPlayer2.getSelectedIndex() == 0){
            month2.setEnabled(true);
            day2.setEnabled(true);
            year2.setEnabled(true);
            color2.setEnabled(true);
        }
    }



    private void kindPlayer3ActionPerformed(ActionEvent evt) {
        if (kindPlayer3.getSelectedIndex() == 1 || kindPlayer3.getSelectedIndex() == 2){
            month3.setEnabled(false);
            day3.setEnabled(false);
            year3.setEnabled(false);
        if(kindPlayer3.getSelectedIndex() == 2){
                color3.setEnabled(false);
            }
        }
        if (kindPlayer3.getSelectedIndex() == 0){
            month3.setEnabled(true);
            day3.setEnabled(true);
            year3.setEnabled(true);
            color3.setEnabled(true);
        }
    }


    private void kindPlayer4ActionPerformed(ActionEvent evt) {
        if (kindPlayer4.getSelectedIndex() == 1 || kindPlayer4.getSelectedIndex() == 2){
            month4.setEnabled(false);
            day4.setEnabled(false);
            year4.setEnabled(false);
        if(kindPlayer4.getSelectedIndex() == 2){
                color4.setEnabled(false);
            }
        }
        if (kindPlayer4.getSelectedIndex() == 0){
            month4.setEnabled(true);
            day4.setEnabled(true);
            year4.setEnabled(true);
            color4.setEnabled(true);
        }
    }


    private void card1MouseDragged(MouseEvent evt) {
        
        Point p = evt.getLocationOnScreen();
        p.x = p.x - 50;
        p.y = p.y - 70;
        card1.setLocation(p);
    }

    private void card2MouseDragged(MouseEvent evt) {
        Point p = evt.getLocationOnScreen();
        p.x = p.x - 50;
        p.y = p.y - 70;
        card2.setLocation(p);
    }

    private void errorOKActionPerformed(ActionEvent evt) {
        errorNotEnoughPlayers.setVisible(false);
    }

    private void newGameActionPerformed(ActionEvent evt) {
        PlayerSelection.setVisible(true);
        this.setVisible(false);
    }

    private void closeActionPerformed(ActionEvent evt) {
        System.exit(0);
    }

    
    public static void main(String args[]) {     
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUI().setVisible(true);
            }
        });
    }
    private JMenu Edit;
    private JMenu File;
    private JMenu Help;
    private JFrame InGame;
    private JMenuBar Menu;
    private JFrame PlayerSelection;
    private JMenuItem about;
    private JButton card1;
    private JButton card2;
    private JMenuItem close;
    private JComboBox color;
    private JComboBox color2;
    private JComboBox color3;
    private JComboBox color4;
    private JComboBox day;
    private JComboBox day2;
    private JComboBox day3;
    private JComboBox day4;
    private JDialog errorNotEnoughPlayers;
    private JLabel errorNotEnoughPlayersMsg;
    private JButton errorOK;
    private JPanel firstPlayer;
    private JPanel fourthPlayer;
    private JMenuItem help;
    private JButton jButton104;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel jLabel22;
    private JLabel jLabel23;
    private JLabel jLabel24;
    private JLabel jLabel25;
    private JLabel jLabel26;
    private JLabel jLabel27;
    private JLabel jLabel28;
    private JLabel jLabel29;
    private JLabel jLabel3;
    private JComboBox kindPlayer;
    private JComboBox kindPlayer2;
    private JComboBox kindPlayer3;
    private JComboBox kindPlayer4;
    private JMenuItem loadGame;
    private JComboBox month;
    private JComboBox month2;
    private JComboBox month3;
    private JComboBox month4;
    private JMenuItem newGame;
    private JPanel secondPlayer;
    private JButton startGame;
    private JPanel thirdPlayer;
    private JComboBox year;
    private JComboBox year2;
    private JComboBox year3;
    private JComboBox year4;
}