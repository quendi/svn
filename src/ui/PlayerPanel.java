package ui;

import domain.Player;

import javax.swing.*;

/**
 * User: Joe
 * Date: Apr 16, 2012
 * Time: 9:11:24 PM
 */
public class PlayerPanel extends JPanel{

    private JButton card1;
    private JButton card2;
    private JLabel knights = new JLabel("Knights: ");
    private JLabel playerLabel = new JLabel("Player: ");
    private JLabel currentPlayerLabel = new JLabel();
    private JLabel currentColor = new JLabel();
    private JButton endTurn = new JButton("End Turn");
    private JLabel numberOfKnights = new JLabel();
    Player currentPlayer;


    public PlayerPanel(Player p){

        Player currentPlay = p;
        javax.swing.GroupLayout PlayerPanelLayout = new javax.swing.GroupLayout(this);
        this.setLayout(PlayerPanelLayout);
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
                                                .addComponent(knights, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(51, 51, 51)
                                                .addComponent(numberOfKnights))
                                        .addGroup(PlayerPanelLayout.createSequentialGroup()
                                        .addGap(62, 62, 62)
                                        .addGroup(PlayerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(PlayerPanelLayout.createSequentialGroup()
                                        .addGap(29, 29, 29)
                                        .addComponent(playerLabel)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(PlayerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(currentColor)
                                        .addComponent(currentPlayerLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())
        );
        PlayerPanelLayout.setVerticalGroup(
                PlayerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(PlayerPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(PlayerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(playerLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(currentPlayerLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(3, 3, 3)
                        .addComponent(currentColor)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(PlayerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(card1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(card2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(28, 28, 28)
                        .addGroup(PlayerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(knights, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(numberOfKnights))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 119, Short.MAX_VALUE)
                        .addComponent(endTurn, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(52, 52, 52))
        );

//        card1.setIcon(currentPlayer.getDeck().getTile1().getImage()); // NOI18N
//        card2.setIcon(currentPlayer.getDeck().getTile2().getImage()); // NOI18N

//        card1.addActionListener(new java.awt.event.ActionListener() {
//            public void actionPerformed(java.awt.event.ActionEvent evt) {
//                card1ActionPerformed(evt);
//            }
//        });
//
//        card2.addActionListener(new java.awt.event.ActionListener() {
//            public void actionPerformed(java.awt.event.ActionEvent evt) {
//                card2ActionPerformed(evt);
//            }
//        });
//
//         endTurn.addActionListener(new java.awt.event.ActionListener() {
//            public void actionPerformed(java.awt.event.ActionEvent evt) {
//                endTurnActionPerformed(evt);
//            }
//        });
//    }
    }

    public JButton getCard1() {
        return card1;
    }

    public void setCard1(JButton card1) {
        this.card1 = card1;
    }

    public JButton getCard2() {
        return card2;
    }

    public void setCard2(JButton card2) {
        this.card2 = card2;
    }

    public JLabel getCurrentPlayerLabel() {
        return currentPlayerLabel;
    }

    public void setCurrentPlayerLabel(JLabel currentPlayerLabel) {
        this.currentPlayerLabel = currentPlayerLabel;
    }

    public JLabel getNumberOfKnights() {
        return numberOfKnights;
    }

    public void setNumberOfKnights(JLabel numberOfKnights) {
        this.numberOfKnights = numberOfKnights;
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public void setCurrentPlayer(Player currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

//    private void endTurnActionPerformed(java.awt.event.ActionEvent evt) {
//        //TODO
//
//        if(moves < 1){
//            JOptionPane.showMessageDialog(this, "You must make at least one move.", "More moves are neccessary", JOptionPane.PLAIN_MESSAGE);
//        }
//        else{
//            try {
//                currentPlayer = game.getNextPlayer();
//            } catch (NoSuchPlayerException e) {
//                e.printStackTrace();
//            }
//            moves = 0;
//            playersTurn.setText(Integer.toString(currentPlayer.getId() + 1));
//            numberOfKnights.setText(Integer.toString(currentPlayer.getNumKnights()));
//            card1.setIcon(currentPlayer.getDeck().getTile1().getImage());
//            card2.setIcon(currentPlayer.getDeck().getTile2().getImage());
//            //Change color
//            if (game.getCurrentPlayer().getColor().equals(domain.enums.Color.BLUE)) {
//                currentColor.setText("Blue");
//                InGame.getContentPane().setBackground(new java.awt.Color(0,102,255));
//                PlayerPanel.setBackground(new java.awt.Color(0,102,255));
//            }
//            else if (game.getCurrentPlayer().getColor().equals(domain.enums.Color.GREEN)) {
//                currentColor.setText("Green");
//                InGame.getContentPane().setBackground(new java.awt.Color(0,153,0));
//                PlayerPanel.setBackground(new java.awt.Color(0,153,0));
//            }
//            else if (game.getCurrentPlayer().getColor().equals(domain.enums.Color.YELLOW)) {
//                currentColor.setText("Yellow");
//                InGame.getContentPane().setBackground(new java.awt.Color(255,255,0));
//                PlayerPanel.setBackground(new java.awt.Color(255,255,0));
//            } else {
//                currentColor.setText("Red");
//                InGame.getContentPane().setBackground(new java.awt.Color(255,0,0));
//                PlayerPanel.setBackground(new java.awt.Color(255,0,0));
//            }
//        }
//    }

//   /**
//     * Click event when play clicks on his first card in hand
//     * @param evt
//     */
//    private void card1ActionPerformed(java.awt.event.ActionEvent evt) {
//        selectedCard.setIcon(card1.getIcon());
//        selectedCard.setText(card1.getText());
//        tileInPlay = currentPlayer.getDeck().getTile1();
//
//    }
//
//
//    /**
//    * Click event when play clicks on his second card in hand
//     * @param evt
//     */
//    private void card2ActionPerformed(java.awt.event.ActionEvent evt) {
//        selectedCard.setIcon(card2.getIcon());
//        selectedCard.setText(card2.getText());
//        tileInPlay = currentPlayer.getDeck().getTile2();
//    }
}