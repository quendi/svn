package ui;


import domain.*;
//import domain.PlayerSelection;
import domain.enums.Building;
import domain.enums.Color;
import exceptions.NoSuchPlayerException;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Point;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.*;



/**
 *
 * @author Aaron
 */
public class GUI extends javax.swing.JFrame implements PlayerListener, BoardListener {
    private javax.swing.JButton selectedCard = new javax.swing.JButton("Null");
    private int moves = 0;
    private Tile tileInPlay;
    protected Player currentPlayer;

    public RobberKnight game;
    PlayerSelection playerSelection;

    // Variables declaration - do not modify
    private javax.swing.JMenu Edit;
    private javax.swing.JMenu File;
    private javax.swing.JMenu Help;
    protected javax.swing.JFrame InGame;
    private javax.swing.JMenuBar Menu;

    private javax.swing.JMenuItem about;
    protected javax.swing.JButton card1;
    protected javax.swing.JButton card2;
    private javax.swing.JMenuItem close;
    protected javax.swing.JLabel currentColor;

    private javax.swing.JButton endTurn;
    private javax.swing.JDialog errorNotEnoughPlayers;
    private javax.swing.JLabel errorNotEnoughPlayersMsg;
    private javax.swing.JButton errorOK;

    protected javax.swing.JPanel grid;
    private javax.swing.JMenuItem help;
    private javax.swing.JButton jButton104;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel titleScreen;
    private javax.swing.JMenuItem loadGame;
    protected javax.swing.JMenuItem newGame;
    protected javax.swing.JLabel numberOfKnights;
    protected javax.swing.JLabel playersTurn;
    protected javax.swing.JPanel PlayerPanel;
    private javax.swing.JFrame pickKnightNum;
    private int NumKnightPlace = 0;
    private JComboBox knightPick;
    private JFrame initialTile;
    private int turn = 0;
    private int tilesPlaced = 0;
    private int selectedTile = 0;

    // End of variables declaration

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    public GUI() {
        initComponents();
    }

    private int placeTile(Tile tile, Point location){
        if ( game.placeTile(tile, location) == -1){
            return -1;
        }
        else
            return 0;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        initialTile = new JFrame();
        pickKnightNum = new javax.swing.JFrame();
        InGame = new javax.swing.JFrame();
        jButton104 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        endTurn = new javax.swing.JButton();
        card1 = new javax.swing.JButton();
        card2 = new javax.swing.JButton();
        numberOfKnights = new javax.swing.JLabel();
        playersTurn = new javax.swing.JLabel();
        currentColor = new javax.swing.JLabel();
        grid = new javax.swing.JPanel();
        errorNotEnoughPlayers = new javax.swing.JDialog();
        errorNotEnoughPlayersMsg = new javax.swing.JLabel();
        errorOK = new javax.swing.JButton();
        titleScreen = new javax.swing.JLabel();
        Menu = new javax.swing.JMenuBar();
        File = new javax.swing.JMenu();
        newGame = new javax.swing.JMenuItem();
        loadGame = new javax.swing.JMenuItem();
        close = new javax.swing.JMenuItem();
        Edit = new javax.swing.JMenu();
        Help = new javax.swing.JMenu();
        about = new javax.swing.JMenuItem();
        help = new javax.swing.JMenuItem();
        PlayerPanel = new javax.swing.JPanel();






        pickKnightNum.setBounds(500, 500, 200, 100);
        pickKnightNum.setDefaultCloseOperation(HIDE_ON_CLOSE);
        JPanel knightPanel = new JPanel();
        JLabel message = new JLabel( "Number of Knight to Place" );
        knightPick = new JComboBox( new javax.swing.DefaultComboBoxModel(new String[] { "1", "2", "3", "4", "5" }));
        JButton ok = new JButton( "OK" );
        ok.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okActionPerformed(evt);
            }
        });
        knightPanel.add(message);
        knightPanel.add(knightPick);
        knightPanel.add(ok);
        pickKnightNum.add(knightPanel);


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

        card1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                card1ActionPerformed(evt);
            }
        });

        card2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                card2ActionPerformed(evt);
            }
        });

        numberOfKnights.setText("BLANK");

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
                                                .addComponent(numberOfKnights))
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
                                .addComponent(numberOfKnights))
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
        InGame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        InGameLayout.setHorizontalGroup(
                InGameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, InGameLayout.createSequentialGroup()
                        .addContainerGap()
                        //.addComponent(grid, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(grid/*, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE*/)
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
                        //.addComponent(grid, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(grid/*, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE*/)
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

        titleScreen.setIcon(new javax.swing.ImageIcon("resources/RobberKnights.jpg")); // NOI18N


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
                        .addComponent(titleScreen)
                        .addContainerGap(30, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(titleScreen)
                        .addContainerGap(33, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>

    protected void okActionPerformed(ActionEvent evt) {
        pickKnightNum.setVisible(false);
        NumKnightPlace = knightPick.getSelectedIndex()+1;
        //System.out.println("#ofknights" + NumKnightPlace);
    }

    private void aboutActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void helpActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    //startgame removed here



    private void errorOKActionPerformed(java.awt.event.ActionEvent evt) {
        errorNotEnoughPlayers.setVisible(false);
    }

    private void newGameActionPerformed(java.awt.event.ActionEvent evt) {
        playerSelection = new PlayerSelection(true, this);//true
        this.setVisible(false);
    }

    private void closeActionPerformed(java.awt.event.ActionEvent evt) {
        System.exit(0);
    }

    /**
     * Moves current turn to next player.
     * @param evt
     */
    private void endTurnActionPerformed(java.awt.event.ActionEvent evt) {
        //TODO
        if(moves < 1){
            JOptionPane.showMessageDialog(InGame, "You must make at least one move.", "More moves are neccessary", JOptionPane.PLAIN_MESSAGE);
        }
        else{
            try {
                currentPlayer = game.getNextPlayer();
            } catch (NoSuchPlayerException e) {
                e.printStackTrace();
            }
            moves = 0;
            playersTurn.setText(Integer.toString(currentPlayer.getId() + 1));
            numberOfKnights.setText(Integer.toString(currentPlayer.getNumKnights()));
            card1.setPreferredSize(new Dimension(117,117));
            card2.setPreferredSize(new Dimension(117,117));
            card1.setIcon(currentPlayer.getDeck().getTile1().getImage());
            card2.setIcon(currentPlayer.getDeck().getTile2().getImage());
            //Change color
//            currentColor.setText(currentPlayer.getColor().toString());
//            InGame.getContentPane().setBackground(currentPlayer.getColor());
//            PlayerPanel.setBackground(currentPlayer.getColor());
        }
    }


    /**
     * Click event when play clicks on his first card in hand
     * @param evt
     */
    private void card1ActionPerformed(java.awt.event.ActionEvent evt) {
        selectedCard.setIcon(card1.getIcon());
        selectedCard.setText(card1.getText());
        tileInPlay = currentPlayer.getDeck().getTile1();

    }


    /**
     * Click event when play clicks on his second card in hand
     * @param evt
     */
    private void card2ActionPerformed(java.awt.event.ActionEvent evt) {
        selectedCard.setIcon(card2.getIcon());
        selectedCard.setText(card2.getText());
        tileInPlay = currentPlayer.getDeck().getTile2();
    }

    private void jButton104ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }



    /**
     * Creates appropriate grid for player size.
     * @param grid - Jpanel representation of game board
     * @param numPlayers
     */

    public void setUpGrid(JPanel grid, int numPlayers){
        if (numPlayers == 2) {
            grid.setLayout(new java.awt.GridLayout(7, 7));
            for(int i = 0; i < 7; i++){
                for(int j = 0; j < 7; j++){
                    final TileButton button = new TileButton();
                    final Point location = new Point(j, i);
                    addGridListener(button, location);
                    button.setPreferredSize(new Dimension(117, 117));
                    grid.add(button);
                }
            }

        } else if (numPlayers == 3) {
            grid.setLayout(new java.awt.GridLayout(9, 9));
            for(int i = 0; i < 9; i++){
                for(int j = 0; j < 9; j++){
                    final TileButton button = new TileButton();
                    final Point location = new Point(j, i);
                    addGridListener(button, location);
                    button.setPreferredSize(new Dimension(117, 117));
                    grid.add(button);
                }
            }
        } else {
            grid.setLayout(new java.awt.GridLayout(10, 10));
            for(int i = 0; i < 10; i++){
                for(int j = 0; j < 10; j++){
                    final TileButton button = new TileButton();
                    final Point location = new Point(j, i);
                    addGridListener(button, location);
                    button.setPreferredSize(new Dimension(117, 117));
                    grid.add(button);
                }
            }
        }
        System.out.println(grid.getComponent(0).toString());
    }

    /**
     * Add listen to button that will place tile in corresponding location when clicked.
     * @param button
     * @param location
     */
    private void addGridListener(final TileButton button,final Point location){
        button.addActionListener(new java.awt.event.ActionListener() {

            @Override
            // Click event for when play clicks on space in board.
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                if (tileInPlay != null && selectedCard != null) {
                    // if there has an exist tile, new tile can't be put
                    if( game.placeTile(tileInPlay, location) == 0 ){
                        moves++;
                        if( tileInPlay.getBuilding() == Building.Castle ){
                            pickKnightNum.setVisible(true);
                        }
                        tileInPlay.setLocation(location);
                        game.placeTile(tileInPlay, location);
                        currentPlayer.getDeck().playTile(tileInPlay);
                        tileInPlay = null;
                        updateHand();
                        if(moves > 2){
                            endTurnActionPerformed(evt);
                        }
                    }
                }
                //TODO check to see if it's a valid move
                //draw a new card
                //after first play, set it = null
            }
        });
    }

    public void updateHand(){
        card1.setIcon(currentPlayer.getDeck().getTile1().getImage());
        card2.setIcon(currentPlayer.getDeck().getTile2().getImage());
    }

    public void updateKnights(){

    }


    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                GUI gui = new GUI();
                gui.setVisible(true);
            }
        });
    }

    public void initializeTiles(){
        initialTile.setVisible(true);
        initialTile.setBounds(0, 0, 1200, 1200);
        initialTile.setDefaultCloseOperation(HIDE_ON_CLOSE);
        JPanel TilePanel = new JPanel();
        JLabel display = new JLabel("Player");
        final JLabel playername = new JLabel(Integer.toString(currentPlayer.getId()+1));
        final JButton tile1 = new JButton();
        tile1.setIcon(currentPlayer.getDeck().getTile1().getImage());
        tile1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectedCard = tile1;
                selectedTile = 0;
            }
        });
        final JButton tile2 = new JButton();
        tile2.setIcon(currentPlayer.getDeck().getTile2().getImage());
        tile2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectedCard = tile2;
                selectedTile = 1;
            }
        });
        final JButton tile4 = new JButton();
        tile4.setIcon(currentPlayer.getDeck().getTile4().getImage());
        tile4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectedCard = tile4;
                selectedTile = 2;
            }
        });
        final JButton select = new JButton("Next Player");
        final JPanel gridHolder = new JPanel();
        gridHolder.setLayout(new GridLayout(2, game.getNumPlayers()));

        for(int i=0; i < game.getNumPlayers()*2; i++){
            final JButton gridButton = new JButton();
            gridButton.setPreferredSize(new Dimension(117, 117));
            gridButton.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    if(tilesPlaced < 2){
                    	if(gridButton.getIcon() == null){
    	                	gridButton.setIcon(selectedCard.getIcon());
    	                    selectedCard.setEnabled(false);
    	                    if(selectedTile == 0){
    	                    	placeTile(game.getCurrentPlayer().getDeck().getTile1(), 
    	                    			new Point(gridButton.getLocation().x/gridButton.getWidth()+3, 
    	                    					gridButton.getLocation().y/gridButton.getHeight()+3));
    	                        currentPlayer.getDeck().playTile(game.getCurrentPlayer().getDeck().getTile1());
    	                    	updateHand();
    	                    }
    	                    if(selectedTile == 1){
    	                    	placeTile(game.getCurrentPlayer().getDeck().getTile2(), 
    	                    			new Point(gridButton.getLocation().x/gridButton.getWidth()+3, 
    	                    					gridButton.getLocation().y/gridButton.getHeight()+3));
    	                        currentPlayer.getDeck().playTile(game.getCurrentPlayer().getDeck().getTile2());
    	                    	updateHand();
    	                    }
    	                    if(selectedTile == 2){
    	                    	placeTile(game.getCurrentPlayer().getDeck().getTile4(), 
    	                    			new Point(gridButton.getLocation().x/gridButton.getWidth()+3, 
    	                    					gridButton.getLocation().y/gridButton.getHeight()+3));
    	                        currentPlayer.getDeck().playTile(game.getCurrentPlayer().getDeck().getTile4());
    	                    	updateHand();
    	                    }
    	                    tilesPlaced++;
                    	}else{
                    		JOptionPane.showMessageDialog(initialTile, "You cannot place over other tiles.", "Error", JOptionPane.PLAIN_MESSAGE);
                    	}
                    }
                    else{
                    	 JOptionPane.showMessageDialog(initialTile, "You cannot place more than two tiles.", "Error", JOptionPane.PLAIN_MESSAGE);
                    }
                }
            });
            gridHolder.add(gridButton);
        }

        TilePanel.add(display);
        TilePanel.add(playername);
        TilePanel.add(tile1);
        TilePanel.add(tile2);
        TilePanel.add(tile4);
        TilePanel.add(gridHolder);
        TilePanel.add(select);
        select.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    if(turn < game.getNumPlayers()-1){
                    	if(tilesPlaced >= 2){
	                        turn++;
	                        currentPlayer = game.getNextPlayer();
	                        playername.setText(Integer.toString(currentPlayer.getId()+1));
	                        tile1.setIcon(currentPlayer.getDeck().getTile1().getImage());
	                        tile2.setIcon(currentPlayer.getDeck().getTile2().getImage());
	                        tile4.setIcon(currentPlayer.getDeck().getTile4().getImage());
	                        if(turn >= game.getNumPlayers()-1)
	                            select.setText("Start Game");
	                        tile1.setEnabled(true);
	                        tile2.setEnabled(true);
	                        tile4.setEnabled(true);
	                        tilesPlaced = 0;
                    	}
                    	else{
                    		JOptionPane.showMessageDialog(initialTile, "You must place two tiles.", "Error", JOptionPane.PLAIN_MESSAGE);
                        }
                    }
                    else{
                        initialTile.setVisible(false);
                        InGame.setVisible(true);
                    }
                } catch (NoSuchPlayerException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

            }
        });


        initialTile.add(TilePanel);

    }

    public void placedTile(Tile t) {
        int gridLocation = (int) t.getLocation().getY() * playerSelection.game.getBoard().getSize() + ((int) t.getLocation().getX());
        TileButton button = (TileButton) playerSelection.grid.getComponent(gridLocation);
        button.setIcon(t.getImage());
    }

    public void placedKnight(Tile t) {

    }
}
