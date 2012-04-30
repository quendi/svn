package ui;

import domain.*;
import domain.enums.Building;
import domain.enums.Terrain;
import exceptions.NoSuchPlayerException;
import utils.GameUtils;

import java.awt.*;
import java.awt.image.BufferedImage;

import java.util.ArrayList;

import javax.sound.sampled.*;
import javax.swing.*;
import java.io.*;


/**
 *
 * @author Aaron
 */
public class GUI implements PlayerListener,BoardListener, TurnListener {

    private JButton selectedCard = new JButton("Null");
    private int moves = 0;
    private Tile tileInPlay;
    protected Player currentPlayer;
    private boolean knightMode = false;
    private Point moveTo;

    public static RobberKnight game;



    protected JFrame InGame;



    protected TileButton card1;
    protected TileButton card2;

    protected JLabel currentColor;

    private JButton endTurn;
    private JButton endKnightPlacement;


    protected JPanel grid;

    private JButton deckLabel;
    private JLabel playerLabel;
    private JLabel knightLabel;
    protected JLabel numberOfKnights;
    protected JLabel playersTurn;
    protected JPanel PlayerPanel;
    private KnightPicker knightPicker;
    private int NumKnightPlace = 0;
    private JComboBox knightPick;
    private JFrame initialTile;
    private int turn = 0;
    private int tilesPlaced = 0;
    private int selectedTile = 0;
    private int first = 0;
    private static final int SIZE = 117 * 7;
    private Tile castleTile;
    private Font font = new Font("Serif", Font.BOLD, 34);

    // End of variables declaration




    public GUI() {
        initComponents();
    }

    // use init to check is this is an initial placement
    private boolean placeTile(Tile tile, Point location, boolean init ) {
//        if (game.placeTile(tile, location, init) == false) {
//            return false;
//        } else
//            return true;
        return game.placeTile(tile, location, init);
    }

    private void initComponents() {

        initialTile = new JFrame("Choose initial tiles");
        InGame = new JFrame();
        deckLabel = new JButton();
        playerLabel = new JLabel();
        knightLabel = new JLabel();
        endTurn = new JButton();
        endKnightPlacement = new JButton("End Knight Placement");
        card1 = new TileButton();
        card2 = new TileButton();
        numberOfKnights = new JLabel();
        playersTurn = new JLabel();
        currentColor = new JLabel();
        grid = new JPanel();


        PlayerPanel = new JPanel();

        grid.setBackground(null);

//        knightPicker.setBounds(500, 500, 200, 100);
//        knightPicker.setDefaultCloseOperation(HIDE_ON_CLOSE);
//        JPanel knightPanel = new JPanel();
//        JLabel message = new JLabel("Number of Knight to Place");
//        knightPick = new JComboBox(new DefaultComboBoxModel(
//                new String[] { "0", "1", "2", "3", "4", "5" }));
//        JButton ok = new JButton("OK");
//        ok.addActionListener(new java.awt.event.ActionListener() {
//            public void actionPerformed(java.awt.event.ActionEvent evt) {
//                okActionPerformed(evt);
//            }
//        });
//        knightPanel.add(message);
//        knightPanel.add(knightPick);
//        knightPanel.add(ok);
//        knightPicker.add(knightPanel);

        InGame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        InGame.setMinimumSize(new java.awt.Dimension(900, 600));

//        deckLabel.setText("");
//        deckLabel.addActionListener(new java.awt.event.ActionListener() {
//            public void actionPerformed(java.awt.event.ActionEvent evt) {
//                jButton104ActionPerformed(evt);
//            }
//        });

        playerLabel.setText("Player:");

        knightLabel.setText("Knights");

        endTurn.setText("End Turn");
        endTurn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                endTurnActionPerformed(evt);
            }
        });

        endKnightPlacement.setVisible(false);
         endKnightPlacement.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                endKnightMovement();
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

        GroupLayout PlayerPanelLayout = new GroupLayout(
                PlayerPanel);
        PlayerPanel.setLayout(PlayerPanelLayout);
        PlayerPanelLayout
                .setHorizontalGroup(PlayerPanelLayout
                        .createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(
                        PlayerPanelLayout
                                .createSequentialGroup()
                                .addGroup(
                                        PlayerPanelLayout
                                                .createParallelGroup(
                                                        GroupLayout.Alignment.LEADING)
                                                .addGroup(
                                                        PlayerPanelLayout
                                                                .createSequentialGroup()
                                                                .addContainerGap()
                                                                .addComponent(
                                                                        card1,
                                                                        117,
                                                                        117,
                                                                        117)
                                                                .addPreferredGap(
                                                                        LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(
                                                                card2,
                                                                117,
                                                                117,
                                                                117))
                                                .addGroup(
                                                PlayerPanelLayout
                                                        .createSequentialGroup()
                                                        .addGroup(
                                                                PlayerPanelLayout
                                                                        .createParallelGroup(
                                                                                GroupLayout.Alignment.LEADING,
                                                                                false)
                                                                        .addGroup(
                                                                                PlayerPanelLayout
                                                                                        .createSequentialGroup()
                                                                                        .addGap(24,
                                                                                                24,
                                                                                                24)
                                                                                        .addComponent(
                                                                                        endTurn,
                                                                                        GroupLayout.PREFERRED_SIZE,
                                                                                        233,
                                                                                        GroupLayout.PREFERRED_SIZE))

                                                                        .addGroup(PlayerPanelLayout
                                                                                .createSequentialGroup()
                                                                                .addGap(24,
                                                                                        24,
                                                                                        24)
                                                                                .addComponent(
                                                                                endKnightPlacement,
                                                                                GroupLayout.PREFERRED_SIZE,
                                                                                233,
                                                                                GroupLayout.PREFERRED_SIZE))
                                                                        .addGroup(
                                                                                PlayerPanelLayout
                                                                                        .createSequentialGroup()
                                                                                        .addGap(33,
                                                                                                33,
                                                                                                33)
                                                                                        .addComponent(
                                                                                                knightLabel,
                                                                                                GroupLayout.PREFERRED_SIZE,
                                                                                                55,// TODO
                                                                                                GroupLayout.PREFERRED_SIZE)
                                                                                        .addGap(51,
                                                                                                51,
                                                                                                51)
                                                                                        .addComponent(
                                                                                        numberOfKnights))
                                                                        .addGroup(
                                                                        PlayerPanelLayout
                                                                                .createSequentialGroup()
                                                                                .addGap(62,
                                                                                        62,
                                                                                        62)
                                                                                .addGroup(
                                                                                PlayerPanelLayout
                                                                                        .createParallelGroup(
                                                                                                GroupLayout.Alignment.LEADING)
                                                                                        .addComponent(
                                                                                                deckLabel,
                                                                                                GroupLayout.PREFERRED_SIZE,
                                                                                                144,
                                                                                                GroupLayout.PREFERRED_SIZE)
                                                                                        .addGroup(
                                                                                        PlayerPanelLayout
                                                                                                .createSequentialGroup()
                                                                                                .addGap(29,
                                                                                                        29,
                                                                                                        29)
                                                                                                .addComponent(
                                                                                                        playerLabel)
                                                                                                .addPreferredGap(
                                                                                                        LayoutStyle.ComponentPlacement.RELATED)
                                                                                                .addGroup(
                                                                                                PlayerPanelLayout
                                                                                                        .createParallelGroup(
                                                                                                                GroupLayout.Alignment.LEADING)
                                                                                                        .addComponent(
                                                                                                                currentColor)
                                                                                                        .addComponent(
                                                                                                        playersTurn,
                                                                                                        GroupLayout.PREFERRED_SIZE,
                                                                                                        45,
                                                                                                        GroupLayout.PREFERRED_SIZE))))))
                                                        .addGap(0,
                                                        0,
                                                        Short.MAX_VALUE)))
                                .addContainerGap()));
        PlayerPanelLayout
                .setVerticalGroup(PlayerPanelLayout
                        .createParallelGroup(
                                GroupLayout.Alignment.LEADING)
                        .addGroup(
                        PlayerPanelLayout
                                .createSequentialGroup()
                                .addContainerGap()
                                .addGroup(
                                        PlayerPanelLayout
                                                .createParallelGroup(
                                                        GroupLayout.Alignment.BASELINE)
                                                .addComponent(
                                                        playerLabel,
                                                        GroupLayout.PREFERRED_SIZE,
                                                        24,
                                                        GroupLayout.PREFERRED_SIZE)
                                                .addComponent(
                                                playersTurn,
                                                GroupLayout.PREFERRED_SIZE,
                                                24,
                                                GroupLayout.PREFERRED_SIZE))
                                .addGap(3, 3, 3)
                                .addComponent(currentColor)
                                .addPreferredGap(
                                        LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(
                                        deckLabel,
                                        GroupLayout.PREFERRED_SIZE,
                                        122,
                                        GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(
                                        LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(
                                        PlayerPanelLayout
                                                .createParallelGroup(
                                                        GroupLayout.Alignment.LEADING,
                                                        false)
                                                .addComponent(
                                                        card1,
                                                        117,
                                                        117,
                                                        117)
                                                .addComponent(
                                                card2,
                                                117,
                                                117,
                                                117))
                                .addGap(28, 28, 28)
                                .addGroup(
                                        PlayerPanelLayout
                                                .createParallelGroup(
                                                        GroupLayout.Alignment.BASELINE)
                                                .addComponent(
                                                        knightLabel,
                                                        GroupLayout.PREFERRED_SIZE,
                                                        28,
                                                        GroupLayout.PREFERRED_SIZE)
                                                .addComponent(
                                                numberOfKnights))
                                .addPreferredGap(
                                        LayoutStyle.ComponentPlacement.RELATED,
                                        119, Short.MAX_VALUE)
                                .addComponent(
                                        endTurn,
                                        GroupLayout.PREFERRED_SIZE,
                                        63,
                                        GroupLayout.PREFERRED_SIZE)

                                .addGap(52, 52, 52)
                                .addGroup(
                                        PlayerPanelLayout
                                                .createParallelGroup(
                                                        GroupLayout.Alignment.BASELINE)
                                                .addComponent(
                                                        knightLabel,
                                                        GroupLayout.PREFERRED_SIZE,
                                                        28,
                                                        GroupLayout.PREFERRED_SIZE)
                                                .addComponent(
                                                numberOfKnights))
                                .addPreferredGap(
                                        LayoutStyle.ComponentPlacement.RELATED,
                                        119, Short.MAX_VALUE)
                                .addComponent(
                                        endKnightPlacement,
                                        GroupLayout.PREFERRED_SIZE,
                                        63,
                                        GroupLayout.PREFERRED_SIZE)

                                .addGap(52, 52, 52)
                ));

        GroupLayout gridLayout = new GroupLayout(grid);
        grid.setLayout(gridLayout);


        GroupLayout InGameLayout = new GroupLayout(
                InGame.getContentPane());
        InGame.getContentPane().setLayout(InGameLayout);
        InGame.setExtendedState(JFrame.MAXIMIZED_BOTH);

        InGameLayout
                .setHorizontalGroup(InGameLayout
                        .createParallelGroup(
                                GroupLayout.Alignment.LEADING)
                        .addGroup(
                        GroupLayout.Alignment.TRAILING,
                        InGameLayout
                                .createSequentialGroup()
                                .addContainerGap()

                                .addComponent(grid,
                                        SIZE,
                                        SIZE,
                                        SIZE
                                )
                                .addPreferredGap(
                                        LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(
                                PlayerPanel,
                                GroupLayout.PREFERRED_SIZE,
                                GroupLayout.DEFAULT_SIZE,
                                GroupLayout.PREFERRED_SIZE)));
        InGameLayout.setVerticalGroup(InGameLayout
                .createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(
                        InGameLayout
                                .createSequentialGroup()
                                .addComponent(PlayerPanel,
                                        GroupLayout.PREFERRED_SIZE,
                                        GroupLayout.DEFAULT_SIZE,
                                        GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                .addGroup(
                InGameLayout.createSequentialGroup().addContainerGap()
                        .addComponent(grid,
                                SIZE,
                                SIZE,
                                SIZE)
                        .addComponent(grid
                        ).addContainerGap()));





        InGame.setJMenuBar(new GameMenu(true, null));

    }





    /**
     * Moves current turn to next player.
     *
     * @param evt
     */
    private void endTurnActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO
        if (moves < 1) {
            JOptionPane.showMessageDialog(InGame,
                    "You must make at least one move.",
                    "More moves are neccessary", JOptionPane.PLAIN_MESSAGE);
        } else {
            try {
                currentPlayer = game.getNextPlayer();
            } catch (NoSuchPlayerException e) {
                e.printStackTrace();
            }

        }
    }

    /**
     * Click event when play clicks on his first card in hand
     *
     * @param evt
     */
    private void card1ActionPerformed(java.awt.event.ActionEvent evt) {
        selectedCard.setIcon(card1.getIcon());
        selectedCard.setText(card1.getText());
        tileInPlay = currentPlayer.getDeck().getTile1();

    }

    /**
     * Click event when play clicks on his second card in hand
     *
     * @param evt
     */
    private void card2ActionPerformed(java.awt.event.ActionEvent evt) {
        selectedCard.setIcon(card2.getIcon());
        selectedCard.setText(card2.getText());
        tileInPlay = currentPlayer.getDeck().getTile2();
    }

//    private void jButton104ActionPerformed(java.awt.event.ActionEvent evt) {
//        // TODO add your handling code here:
//    }

    /**
     *  Draws grid based on approriate player size/state of game.
     * @param grid
     * @param numPlayers - players in game
     * @param x_end - boolean flag to show that board has reached the x boundary
     * @param y_end - boolean flag to show that board has reached the y boundary
     */
    public void setUpGrid(JPanel grid, int numPlayers, boolean x_end, boolean y_end) {
        int size = 0;

        if (numPlayers == 2)
            size=7+1;
        else if (numPlayers == 3)
            size=9+1;
        else if (numPlayers == 4)
            size=10+1;

        grid.setLayout(new java.awt.GridLayout(size, size));
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                final TileButton button = new TileButton();
                final Point location = new Point(j, i);
                addGridListener(button, location);
                grid.add(button);
                if(j==size-1 && x_end)
                    button.setVisible(false);
                if(i==size-1 && y_end)
                    button.setVisible(false);
            }
        }
    }



    /**
     * Add listen to button that will place tile in corresponding location when
     * clicked.
     *
     * @param button
     * @param location
     */
    private void addGridListener(final TileButton button, final Point location) {
        button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                if(knightMode){
                    knightPicker.setKnightPicker(game.getMoveableKnights(castleTile, location));
                    knightPicker.setVisible(true);
                    moveTo = location;
                }
                if (tileInPlay != null && selectedCard != null) {
                    // check if tile have already been placed in location
                    if (game.placeTile(tileInPlay, location, false)) {
                        if(tileInPlay.getTerrain() == Terrain.Lake)
                            playSound("resources/LakePlacement.wav");
                        if(tileInPlay.getTerrain() == Terrain.Mountain)
                            playSound("resources/Mountains(rubble).wav");
                        if(tileInPlay.getTerrain() == Terrain.Forest)
                            playSound("resources/Forest.wav");
                        if(tileInPlay.getTerrain() == Terrain.Plain)
                            playSound("resources/plains.wav");
                        if(tileInPlay.getBuilding() == Building.Town)
                            playSound("resources/TownPlacement.wav");
                        if(tileInPlay.getBuilding() == Building.Village)
                            playSound("resources/village.wav");
                        moves++;
                        tileInPlay = null;
                        // End turn once player has made 3 turns
                        //TODO change this so when a castle is placed on the last turn it will activate knight movement
                        if (moves > 2) {
                            endTurnActionPerformed(evt);
                        }
                    }
                }
            }
        });
    }



    /**
     * Get starting layout of tiles from players.
     * Castle placement is not allowed in this phase.
     */

    public void initializeTiles() {
        /**
         * Initialization
         */
        initialTile.setVisible(true);
        initialTile.setBounds(100, 100, 850, 450);
        initialTile.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);

        JPanel tilePanel = new JPanel();
        tilePanel.setLayout(new BorderLayout());
        JLabel display = new JLabel("Player");


        final JLabel playerNumber = new JLabel(Integer.toString(currentPlayer
                .getId() + 1));
        final TileButton tile1 = new TileButton();
        tile1.setIcon(currentPlayer.getDeck().getTile1().getImage());
        tile1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectedCard = tile1;
                selectedTile = 0;
                first = 2;

            }
        });
        final TileButton tile2 = new TileButton();
        tile2.setIcon(currentPlayer.getDeck().getTile2().getImage());
        tile2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectedCard = tile2;
                selectedTile = 1;
                if (first == 2) {
                    selectedTile = 0;
                } else {
                    first = 1;
                }

            }
        });

        final TileButton tile4 = new TileButton();
        tile4.setIcon(currentPlayer.getDeck().getTile4().getImage());
        tile4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectedCard = tile4;
                selectedTile = 3;
                if (first == 1 || first == 2) {
                    selectedTile = 2;
                } else {
                    selectedTile = 3;
                }
            }
        });
        final JButton select = new JButton("Next Player");
        final JPanel gridHolder = new JPanel();
        gridHolder.setLayout(new GridLayout(2, game.getNumPlayers()));
        for (int i = 0; i < game.getNumPlayers() * 2; i++) {
            final TileButton gridButton = new TileButton();
            gridButton.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    if (tilesPlaced < 2) {
                        if (gridButton.getIcon() == null
                                && selectedCard != null) {
                            gridButton.setIcon(selectedCard.getIcon());
                            selectedCard.setEnabled(false);
                            if (selectedTile == 0) {
                                placeTile(
                                        game.getCurrentPlayer().getDeck()
                                                .getTile1(),
                                        new Point(gridButton.getLocation().x
                                                / gridButton.getWidth() + 3,
                                                gridButton.getLocation().y
                                                        / gridButton
                                                        .getHeight()
                                                        + 3), true);
                                if(tilesPlaced < 1)
                                    selectedCard = null;
                            }
                            if (selectedTile == 1) {
                                placeTile(
                                        game.getCurrentPlayer().getDeck()
                                                .getTile2(),
                                        new Point(gridButton.getLocation().x
                                                / gridButton.getWidth() + 3,
                                                gridButton.getLocation().y
                                                        / gridButton
                                                        .getHeight()
                                                        + 3), true);
                                if(tilesPlaced < 1)
                                    selectedCard = null;
                            }
                            if (selectedTile == 2) {
                                placeTile(
                                        game.getCurrentPlayer().getDeck()
                                                .getTile3(),
                                        new Point(gridButton.getLocation().x
                                                / gridButton.getWidth() + 3,
                                                gridButton.getLocation().y
                                                        / gridButton
                                                        .getHeight()
                                                        + 3), true);
                                if(tilesPlaced < 1)
                                    selectedCard = null;
                            }
                            if (selectedTile == 3) {
                                placeTile(
                                        game.getCurrentPlayer().getDeck()
                                                .getTile4(),
                                        new Point(gridButton.getLocation().x
                                                / gridButton.getWidth() + 3,
                                                gridButton.getLocation().y
                                                        / gridButton
                                                        .getHeight()
                                                        + 3), true);
                                if(tilesPlaced < 1)
                                    selectedCard = null;
                            }
                            tilesPlaced++;
                        } else if (selectedCard == null) {
                            JOptionPane.showMessageDialog(initialTile,
                                    "You cannot place the same tile twice.",
                                    "Error", JOptionPane.ERROR_MESSAGE);
                        } else {
                            JOptionPane.showMessageDialog(initialTile,
                                    "You cannot place over other tiles.",
                                    "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    } else {
                        JOptionPane.showMessageDialog(initialTile,
                                "You cannot place more than two tiles.",
                                "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            });
            gridHolder.add(gridButton);
        }
        /**
         * Display
         */
        display.setFont(font);
        playerNumber.setFont(font);
        select.setPreferredSize(new Dimension(300, 100));
        tilePanel.setForeground(new java.awt.Color(0,0,255));

        /**
         * Add contents to frame
         */
        JPanel northHolder = new JPanel();
        northHolder.add(display);
        northHolder.add(playerNumber);
        tilePanel.add(northHolder, BorderLayout.NORTH);

        JPanel westHolder = new JPanel();
        westHolder.add(tile1);
        westHolder.add(tile2);
        westHolder.add(tile4);
        tilePanel.add(westHolder, BorderLayout.WEST);

        JPanel centerHolder = new JPanel();
        centerHolder.add(gridHolder);
        tilePanel.add(centerHolder, BorderLayout.CENTER);

        JPanel southHolder = new JPanel();
        southHolder.add(select);
        tilePanel.add(southHolder, BorderLayout.SOUTH);


        select.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    if (turn < game.getNumPlayers() - 1) {
                        if (tilesPlaced >= 2) {
                            turn++;
                            currentPlayer = game.getNextPlayer();
                            playerNumber.setText(Integer.toString(currentPlayer
                                    .getId() + 1));
                            tile1.setIcon(currentPlayer.getDeck().getTile1()
                                    .getImage());
                            tile2.setIcon(currentPlayer.getDeck().getTile2()
                                    .getImage());
                            tile4.setIcon(currentPlayer.getDeck().getTile4()
                                    .getImage());
                            if (turn >= game.getNumPlayers() - 1) {
                                select.setText("Start Game");
                            }
                            tile1.setEnabled(true);
                            tile2.setEnabled(true);
                            tile4.setEnabled(true);
                            tilesPlaced = 0;
                            first = 0;
                        } else {
                            JOptionPane.showMessageDialog(initialTile,
                                    "You must place two tiles.", "Error",
                                    JOptionPane.PLAIN_MESSAGE);
                        }
                    } else {
                        initialTile.setVisible(false);
                        currentPlayer = game.getNextPlayer();
                        InGame.setVisible(true);
                        selectedCard = new JButton();
                    }
                } catch (NoSuchPlayerException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

            }
        });

        initialTile.add(tilePanel);

    }

    /**
     * Sets up ui according to current game.
     * @param game
     */

    public void startGame(RobberKnight game){
        this.game = game;
        currentPlayer = this.game.getFirstPlayer();
        card1.setIcon(currentPlayer.getDeck().getTile1().getImage());
        card2.setIcon(currentPlayer.getDeck().getTile2().getImage());
        playersTurn.setText(Integer.toString(currentPlayer.getId() + 1));
        numberOfKnights.setText(Integer.toString(currentPlayer.getNumKnights()));
        setUpGrid(grid, this.game.getNumPlayers(), false, false);
        initializeTiles();
    }



    // LISTENER IMPLEMENTATION

    /**
     * Triggers when it is the next players turn. Updates UI accordingly.
     * @param currentPlayer
     */
    public void playerTurn(Player currentPlayer) {
        // Reset move count, update ui to reflect current player.
        moves = 0;
        playersTurn.setText(Integer.toString(currentPlayer.getId() + 1));
        numberOfKnights.setText(Integer.toString(currentPlayer
                .getNumKnights()));
        // Change color
        currentColor.setText(currentPlayer.getColor().toString());
        InGame.getContentPane().setBackground(GameUtils.getColor(currentPlayer.getColor()));
        PlayerPanel.setBackground(GameUtils.getColor(currentPlayer.getColor()));


    }

    /**
     * Signal to ui to end the game.  Show end screen with point totals.
     */
    public void endGame() {
        new WinScreen(game);

    }

    /**
     * Draw knights on an icon
     */

    public void drawKnights(JButton button, Tile t){

        Icon icon = button.getIcon();
        BufferedImage bi = new BufferedImage(
                icon.getIconWidth(),
                icon.getIconHeight(),
                BufferedImage.TYPE_INT_RGB);
        Graphics g = bi.createGraphics();
        icon.paintIcon(null, g, 0,0);

        int d = button.getHeight()/2;
        int j = button.getHeight()-5;
        System.out.println("button height is" + button.getHeight());
        for(int i = 0; i < t.getNumKnights(); i++){
            g.setColor(GameUtils.getColor(t.knights.get(i)));
            g.fillOval(d-10, d-10, 20, 20);
            g.fillRect(button.getWidth()-20, j, 20, 5);
            j = j - 6;
        }


        g.dispose();
        button.setIcon(new ImageIcon(bi));


        System.out.println("game has " + game.getNumPlayers() + " players");


    }
    /**
     * Remove knights from button
     */

    public void removeKnights(Tile tile, JButton button){
        /**
         * Reset image
         */
        button.setIcon(tile.getImage());
        TileButton tileButton = (TileButton) button;
        tileButton.setIcon(tile.getImage(), game.getNumPlayers());

        /**
         * redraw knights
         */
        drawKnights(button, tile);
    }
    /**
     * Triggers when a piece is placed on the game board.  Updates UI board accordingly.
     * @param t - tile being placed
     */
    public void placedTile(Tile t) {
        int gridLocation = GameUtils.getGridLocation(t, game.getBoard().getSize());
        TileButton button = (TileButton) grid.getComponent(gridLocation);
        button.setIcon(t.getImage(), game.getNumPlayers());
        // If a castle has been placed, prompt user for knight placement.

        // Detect the Knights on this tile
        if( t.getNumKnights() != 0){
            /*button.setHorizontalTextPosition(SwingConstants.CENTER);
               button.setText(Integer.toString(t.getNumKnights()));
               button.setOpaque(true);
               button.setFont(new Font(selectedCard.getFont().getName(),selectedCard.getFont().getStyle(),30));
               button.setForeground( GameUtils.getColor(t.getTopKnight()) ); */
            drawKnights(button, t);
        }
    }

    public void placedCastle(Tile castle) {
        endKnightPlacement.setVisible(true);
        knightPicker = new KnightPicker(this, castle.getMinimumKnights());
        knightPicker.setVisible(true);
        castleTile = castle;
    }

    // while shift, remove the icon of the tile which has been set to null
    public void removedTile(boolean x_end, boolean y_end) {
        grid.removeAll();
        setUpGrid(grid, this.game.getNumPlayers(), x_end, y_end);
    }

    /**
     * Draws knight of castle tile.  CAalled when knights are intiailly placed ona castle.
     * @param castle - tile knights are being placed on
     * @param numKnights - number of knight being placed
     */
    public void placedKnight(Tile castle, int numKnights, Color playerColor) {
        int gridLocation = GameUtils.getGridLocation(castle, game.getBoard().getSize());
        TileButton button = (TileButton) grid.getComponent(gridLocation);
        button.setHorizontalTextPosition(SwingConstants.CENTER);
        //button.setText(Integer.toString(t.getNumKnights()));
        //button.setText(Integer.toString(castle.getNumKnights()));
        button.setOpaque(true);
        //button.setFont(new Font(selectedCard.getFont().getName(),selectedCard.getFont().getStyle(),30));

        drawKnights(button, castle);

        // joe - testing valid knight moves
        ArrayList<Integer> gridLocations = game.getBoard().getValidMoves(castle, numKnights);
        if(!gridLocations.isEmpty()){
            //TODO add something to allow user to end knight movement early if they choose to
            disableAllExcept(gridLocations);
//            knightPicker.setKnightPicker(castle.getNumKnights() - castle.getMinimumKnights());
            knightMode = true;
            castleTile = castle;
        }
        else{
            endKnightMovement();
        }

        playSound("resources/KnightMovement.wav");
    }

    /**
     * Triggers when knights have been moved sucessfully.
     * @param castle - tile where knights are being moved from
     * @param numKnights - new total of knights on castle tile
     * @param destination  - tile knights are being moved to
     * @param knights - new total of knights on destination
     * @param playerColor - color of knight on top of destination tile
     */
    public void movedKnight(Tile castle, int numKnights, Tile destination, int knights, Color playerColor) {
        //To change body of implemented methods use File | Settings | File Templates.
        TileButton startButton = (TileButton) grid.getComponent(GameUtils.getGridLocation(castle, game.getBoard().getSize()));
        TileButton destinationButton = (TileButton) grid.getComponent(GameUtils.getGridLocation(destination, game.getBoard().getSize()));
        startButton.setHorizontalTextPosition(SwingConstants.CENTER);
        //startButton.setText(Integer.toString(castle.getNumKnights()));
        startButton.setOpaque(true);
        startButton.setFont(new Font(selectedCard.getFont().getName(),selectedCard.getFont().getStyle(),30));
        startButton.setForeground(playerColor); startButton.setHorizontalTextPosition(SwingConstants.CENTER);
        destinationButton.setHorizontalTextPosition(SwingConstants.CENTER);
        //destinationButton.setText(Integer.toString(destination.getNumKnights()));
        destinationButton.setOpaque(true);
        destinationButton.setFont(new Font(selectedCard.getFont().getName(),selectedCard.getFont().getStyle(),30));
        //destinationButton.setForeground(playerColor);
        ArrayList<Integer> gridLocations = game.getBoard().getValidMoves(castleTile, destination, castle.getNumKnights());

        System.out.println("numknights-1" + (numKnights-1));
        System.out.println("destination.getnumknights..." + destination.getNumKnights());

        drawKnights(destinationButton, destination);
        removeKnights(castle, startButton);


        if(!gridLocations.isEmpty()){
            reenableAll();
            disableAllExcept(gridLocations);
            knightMode = true;
        }
        else{
            endKnightMovement();
        }

    }


    private void reenableAll(){
        if(currentPlayer.getDeck().getSize() > 0)
            card1.setEnabled(true);
        else
            card1.setEnabled(false);
        if(currentPlayer.getDeck().getSize() > 1)
            card2.setEnabled(true);
        else
            card2.setEnabled(false);
        for(Component c : grid.getComponents()){
            c.setEnabled(true);
        }
    }

    /**
     * Helper method that disables all buttons on grid except for locations given in array.
     * TODO: maybe disable isn't the right thing to do.  this way the player cannot tell what color knights are on each tile.
     * TODO: when they are placing them     *
     * @param gridLocations - location of buttons to be left enabled
     */
    private void disableAllExcept(ArrayList<Integer> gridLocations) {
        card1.setEnabled(false);
        card2.setEnabled(false);
        for(int i = 0; i < grid.getComponentCount(); i++){
            if(!gridLocations.contains(i)){
                grid.getComponent(i).setEnabled(false);
            }
        }
    }

    /**
     * Updates hand in ui to current player. Triggered when player places a tile.
     */
    public void updateHand() {
        if(currentPlayer.getDeck().getSize() > 0){
            card1.setIcon(currentPlayer.getDeck().getTile1().getImage());
            card1.setEnabled(true);
        }
        else{
            try {
                // go to next player if current player has no tiles remaining.
                currentPlayer = game.getNextPlayer();
                return;
            } catch (NoSuchPlayerException e) {
                e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            }
            card1.setIcon(null);
            card2.setEnabled(false);
        }
        if(currentPlayer.getDeck().getSize() > 1){
            card2.setIcon(currentPlayer.getDeck().getTile2().getImage());
            card2.setEnabled(true);
        }
        else{
            card2.setIcon(null);
            card2.setEnabled(false);
        }
    }

    /**
     * Updates hand in ui to current player. Triggered when it is a new player's turn.
     */
    public void updateHand(Player p){
        if(p.getDeck().getSize() > 0){
            card1.setIcon(p.getDeck().getTile1().getImage());
            card1.setEnabled(true);
        }
        else{
            try {
                // go to next player if current player has no tiles remaining.
                currentPlayer = game.getNextPlayer();
                return;
            } catch (NoSuchPlayerException e) {
                e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            }
            card1.setIcon(null);
            card2.setEnabled(false);
        }
        if(p.getDeck().getSize() > 1){
            card2.setIcon(p.getDeck().getTile2().getImage());
            card2.setEnabled(true);
        }
        else{
            card2.setIcon(null);
            card2.setEnabled(false);
        }
    }

    /**
     * Updates knight count after a player sucessfully places a knight on a tile.
     * @param numberOfKnights
     */
    public void updateKnights(int numberOfKnights) {
        this.numberOfKnights.setText(Integer.toString(numberOfKnights));
    }

    // END LISTENER IMPLEMENTATION

    /**
     * Informs game that knights have been placed on castle
     * @param numberOfKnights
     */
    public void placeKnight(int numberOfKnights) {
        game.placeKnight(castleTile, numberOfKnights);
    }

    /**
     * Informs game knights have moved.
     */
    public void moveKnight(int numberOfKnights) {
        game.moveKnight(castleTile, moveTo, numberOfKnights);
        Player current = game.getCurrentPlayer();
        Tile goTo = game.getBoard().getTile(moveTo);
        if(goTo.knights.size() > 0)
            if(current.getColor() != goTo.getTopKnight())
                playSound("KillStab.wav");
    }

    public void endKnightMovement() {
        endKnightPlacement.setVisible(false);
        knightPicker.setVisible(false);
        castleTile = null;
        reenableAll();
        knightMode = false;
    }

    public static void playSound(String filename){
        try {
            AudioInputStream audio = AudioSystem.getAudioInputStream(new java.io.File(filename)); //e.g. "resources/GallopingHorse.wav"
            DataLine.Info info = new DataLine.Info(Clip.class, audio.getFormat());
            Clip clip = (Clip) AudioSystem.getLine(info);
            clip.open(audio);
            clip.start();
        }

        catch(UnsupportedAudioFileException uae) {
            System.out.println(uae);
        }
        catch(IOException ioe) {
            System.out.println(ioe);
        }
        catch(LineUnavailableException lua) {
            System.out.println(lua);
        }
        catch(Exception e){
            System.out.println(e);
        }
    }


}
