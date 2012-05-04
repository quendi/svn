package ui;

import domain.*;
import domain.enums.Building;
import domain.enums.Terrain;
import exceptions.NoSuchPlayerException;
import utils.GameUtils;

import java.awt.*;
import java.awt.image.BufferedImage;

import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.sound.sampled.*;
import javax.swing.*;

import java.io.*;


/**
 *
 * @author Aaron
 */
public class GUI implements PlayerListener,BoardListener, TurnListener{

    private JButton selectedCard = new JButton("Null");
    private Tile tileInPlay;
    protected Player currentPlayer;
    private Point moveTo;

    public static RobberKnight game;

    protected JFrame InGame;

    protected TileButton card1;
    protected TileButton card2;

    protected JLabel currentColor;

    private JButton endKnightPlacement;


    protected JPanel grid;

    private JButton deckLabel;
    protected JLabel numberOfKnights;
    protected JLabel playersTurn;
    protected JPanel PlayerPanel;
    private KnightPicker knightPicker;
    private JFrame initialTile;
    private int turn = 0;
    private int tilesPlaced = 0;
    private int selectedTile = 0;
    private int first = 0;
    private static final int SIZE = 117 * 7;
    private Font font = new Font("Serif", Font.BOLD, 34);
    private CardLayout cl = new CardLayout();

    private JPanel normalPanel = new JPanel();
    JPanel abovePanel;
    private String separator = File.separator;

    // End of variables declaration

    public GUI() {
        initComponents();
    }

    private void initComponents() {

        initialTile = new JFrame("Choose initial tiles");
        InGame = new JFrame();
        deckLabel = new JButton();

        JLabel knightLabel = new JLabel();
        JButton endTurn = new JButton();
        endKnightPlacement = new JButton("End Knight Placement");
        card1 = new TileButton();
        card2 = new TileButton();
        numberOfKnights = new JLabel();
        playersTurn = new JLabel();
        currentColor = new JLabel();
        grid = new JPanel();
        PlayerPanel = new JPanel();

        grid.setBackground(null);

        InGame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        InGame.setMinimumSize(new java.awt.Dimension(900, 600));



        knightLabel.setText("Knights");

        endTurn.setText("End Turn");
        endTurn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                endTurnActionPerformed();
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
        //playersTurn.setText(currentPlayer.getName());
        playersTurn.setFont(new Font("Serif", Font.BOLD, 22));
        currentColor.setText("Color");

        knightPicker = new KnightPicker(this, 0, Color.LIGHT_GRAY);
        JPanel knightPickerPanel = new JPanel();
        knightPickerPanel.add(knightPicker);
        knightPickerPanel.add(endKnightPlacement);
        abovePanel = new JPanel(cl);
        abovePanel.add(normalPanel, "1");
        abovePanel.add(knightPickerPanel, "2");

        GroupLayout PlayerPanelLayout = new GroupLayout (
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
                                                                                abovePanel,
                                                                                GroupLayout.PREFERRED_SIZE,
                                                                                300,
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
                                                                                                117,
                                                                                                117,
                                                                                                117)
                                                                                        .addGroup(
                                                                                        PlayerPanelLayout
                                                                                                .createSequentialGroup()
                                                                                                .addGap(29,
                                                                                                        29,
                                                                                                        29)
                                                                                                
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
                                                                                                        400,
                                                                                                        400,
                                                                                                        400))))))
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
                                                playersTurn,
                                                45,
                                                45,
                                                45))
                                .addGap(3, 3, 3)
                                .addComponent(currentColor)
                                .addPreferredGap(
                                        LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(
                                        deckLabel,
                                        117,
                                        117,
                                        117)
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

                                        //.addGap(52, 52, 52)
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
                                        abovePanel,
                                        GroupLayout.PREFERRED_SIZE,
                                        100,
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

    }

    /**
     *  Action taken when player chooses to end their turn.
     */
    private void endTurnActionPerformed() {
        // Only allow player to end turn when knight movement has ended.
        if (!game.getBoard().isKnightmode()) {
            if (game.getMoveCounter() < 1) {
                JOptionPane.showMessageDialog(InGame,
                        "You must make at least one move.",
                        "More moves are neccessary", JOptionPane.PLAIN_MESSAGE);
            } else {
                try {
                    game.resetMoveCounter();
                    currentPlayer = game.getNextPlayer();
                    normalPanel.setBackground(GameUtils.getColor(currentPlayer.getColor()));
                } catch (NoSuchPlayerException e) {
                    e.printStackTrace();
                }

            }
        }
        else{
            JOptionPane.showMessageDialog(InGame,
                    "You must finish placing knights before ending your turn.",
                    "Place your knights.", JOptionPane.PLAIN_MESSAGE);
        }
        //InGame.setJMenuBar(new GameMenu(true, null, game));
    }

    /**
     * Click event when player clicks on his first card in hand.     *
     * @param evt
     */
    private void card1ActionPerformed(java.awt.event.ActionEvent evt) {
        selectedCard.setIcon(card1.getIcon());
        selectedCard.setText(card1.getText());
        tileInPlay = currentPlayer.getDeck().getTile1();

    }

    /**
     * Click event when player clicks on his second card in hand
     *
     * @param evt
     */
    private void card2ActionPerformed(java.awt.event.ActionEvent evt) {
        selectedCard.setIcon(card2.getIcon());
        selectedCard.setText(card2.getText());
        tileInPlay = currentPlayer.getDeck().getTile2();
    }

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
            size=8;
        else if (numPlayers == 3)
            size=10;
        else if (numPlayers == 4)
            size=11;

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
        InGame.repaint();
    }

    private GUI getGUI(){
        return this;
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

                // If kngihts are being placed, click event will be used to place knights
                if(game.getBoard().isKnightmode()){
                    int moveableKnights = game.getMoveableKnights(game.getBoard().getCastleTile(), location);
                    // If there is a moveable amount of kngihts from the castle tile to the location the playe clicked on, allow user to place knights
                    if( moveableKnights > 0 ){
                        KnightPicker knightPicker2 = new KnightPicker(getGUI(), game.getBoard().getCastleTile().getMinimumKnights(), GameUtils.getColor(currentPlayer.getColor()));
                        knightPicker2.setBackground(GameUtils.getColor(currentPlayer.getColor()));
                        abovePanel.setBackground(GameUtils.getColor(currentPlayer.getColor()));
                        // If tile moveing to is empty, limit minimum option in knight picker to the minimum knights on tile
                        if(game.getBoard().getTile(location).getNumKnights() == 0)
                            knightPicker2.setKnightPicker(moveableKnights,game.getBoard().getTile(location).getMinimumKnights());
                        else
                            knightPicker2.setKnightPicker(moveableKnights);
                        JPanel panel = new JPanel();
                        panel.setBackground(GameUtils.getColor(currentPlayer.getColor()));
                        panel.add(knightPicker2);
                        panel.add(endKnightPlacement);
                        abovePanel.add(panel, "3");
                        cl.show(abovePanel, "3");
                        game.getBoard().setTileMovingTo(game.getBoard().getTile(location));
                        // moveTo = location;
                    }

                    // If no knights are playable, end knight movement
                    else
                        endKnightMovement();
                }

                // If knights are not being placed, click event will place tiles.
                if (tileInPlay != null && selectedCard != null) {
                    // Play neat sounds.
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
                        tileInPlay = null;
                    }
                }
            }
        });
    }

    // use init to check is this is an initial placement
    private boolean placeTile(Tile tile, Point location, boolean init ) {
        return game.placeTile(tile, location, init);
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

        // TEST
        //currentColor.setText(currentPlayer.getColor().toString());
        //InGame.getContentPane().setBackground(GameUtils.getColor(currentPlayer.getColor()));
        initialTile.setBackground(GameUtils.getColor(currentPlayer.getColor()));

        initialTile.setBounds(100, 100, 850, 450);
        initialTile.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);

        JPanel tilePanel = new JPanel();
        tilePanel.setLayout(new BorderLayout());

        final JLabel playerNumber = new JLabel(currentPlayer.getName());
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
        playerNumber.setFont(font);
        select.setPreferredSize(new Dimension(300, 100));
        tilePanel.setForeground(new java.awt.Color(0,0,255));

        /**
         * Add contents to frame
         */
        JPanel northHolder = new JPanel();
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
                            playerNumber.setText(currentPlayer.getName());
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
                        // fix the bug when the final player can start the game with place 2 init tiles
                        if (tilesPlaced >= 2) {
                            initialTile.setVisible(false);
                            currentPlayer = game.getNextPlayer();
                            InGame.setVisible(true);
                            selectedCard = new JButton();
                        }
                        else {
                            JOptionPane.showMessageDialog(initialTile,
                                    "You must place two tiles.", "Error",
                                    JOptionPane.PLAIN_MESSAGE);
                        }
                    }
                } catch (NoSuchPlayerException e) {
                    e.printStackTrace();
                }

            }
        });

        normalPanel.setBackground(GameUtils.getColor(currentPlayer.getColor()));
        initialTile.add(tilePanel);

    }

    /**
     * Sets up ui according to current game.
     * @param game
     */

    public void startGame(RobberKnight game){
        GUI.game = game;
        currentPlayer = GUI.game.getFirstPlayer();
        card1.setIcon(currentPlayer.getDeck().getTile1().getImage());
        card2.setIcon(currentPlayer.getDeck().getTile2().getImage());
        deckLabel.setIcon(currentPlayer.getDeck().getTile3().getBack());
        playersTurn.setText(currentPlayer.getName());
        numberOfKnights.setText(Integer.toString(currentPlayer.getNumKnights()));
        setUpGrid(grid, GUI.game.getNumPlayers(), false, false);
        initializeTiles();
        InGame.setJMenuBar(new GameMenu(true, null, game, this));
    }

    /**
     * Loads game into ui.  Resets listeners in game to use current gui and update the gui to reflect state of loaded game.
     * @param game - Instance of RobberKnights that is loaded.
     */
    public void loadGame(RobberKnight game){
        GUI.game = game;
        currentPlayer = GUI.game.getCurrentPlayer();
        updateHand();
        playersTurn.setText(currentPlayer.getName());
        numberOfKnights.setText(Integer.toString(currentPlayer.getNumKnights()));
        setUpGrid(grid, GUI.game.getNumPlayers(), false, false);
        InGame.setVisible(true);
        game.setListeners(this, this, this);
        game.getBoard().loadBoard();

        currentColor.setText(currentPlayer.getColor().toString());
        InGame.getContentPane().setBackground(GameUtils.getColor(currentPlayer.getColor()));
        PlayerPanel.setBackground(GameUtils.getColor(currentPlayer.getColor()));
        normalPanel.setBackground(GameUtils.getColor(currentPlayer.getColor()));
        knightPicker.changeColor(GameUtils.getColor(currentPlayer.getColor()));

        loadKnightPlacement(game);
        InGame.setJMenuBar(new GameMenu(true, null, game, this));
    }



    private void loadKnightPlacement(RobberKnight game) {
        if(game.getBoard().isKnightmode()){
            if(game.getBoard().getTileMovingTo() != null){
                game.getBoard().validateKnightMovement(game.getBoard().getCastleTile(), game.getBoard().getTileMovingTo());
            }
            else{
                if(game.getBoard().getCastleTile().getNumKnights() == 0){
                    placedCastle(game.getBoard().getCastleTile());
                }
                else{
                    game.getBoard().validateKnightMovement(game.getBoard().getCastleTile());
                }
            }
            endKnightPlacement.setVisible(true);
        }
    }

    // LISTENER IMPLEMENTATION

    /**
     * Triggers when it is the next players turn. Updates UI accordingly.
     * @param currentPlayer
     */
    public void playerTurn(Player currentPlayer) {
        // Reset move count, update ui to reflect current player.
        //  moves = 0;
        playersTurn.setText(currentPlayer.getName());
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

        int d = button.getIcon().getIconHeight()/2;
        int j = button.getIcon().getIconHeight()-7;
        for(int i = 0; i < t.getNumKnights(); i++){
            g.setColor(GameUtils.getColor(t.knights.get(i)));
            BufferedImage img = null;
            img = getKnightImage(t.knights.get(i), 0);
            g.drawImage(img , d-15, d-15, null);
            img = getKnightImage(t.knights.get(i), 1);
            g.drawImage(img , button.getIcon().getIconWidth()-22, j, null);
            j = j - 5;
        }
        g.dispose();
        button.setIcon(new ImageIcon(bi));
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
     * Triggered when board is successfully placed on tile.
     * @param t - tile being placed
     * @param sys - boolean represent if player placed tile, or the system did ( when redrawing board after shifting/ loading game)
     */
    public void placedTile(Tile t, boolean sys) {
        int gridLocation = GameUtils.getGridLocation(t, game.getBoard().getSize());
        TileButton button = (TileButton) grid.getComponent(gridLocation);
        button.setIcon(t.getImage(), game.getNumPlayers());

        // Do not change move counter if the system is placing tiles.
        if(!sys){
            // Increment moves if it is not a castle placed.  This is to allow player to initiate knight movement on the last move of their turn.
            if(!Building.Castle.equals(t.getBuilding())){
                game.incrementMoveCounter();
                if(currentPlayer.getDeck().getSize() == 0){
                    try {
                        currentPlayer = game.getNextPlayer();
                        return;
                    } catch (NoSuchPlayerException e) {
                        e.printStackTrace();
                    }
                }
            }
            game.confirmPlayerTurn();
        }
        // Detect the Knights on this tile
        if( t.getNumKnights() != 0){
            drawKnights(button, t);
        }
    }

    /**
     * Triggers when a castle tile is placed.  Turns knight movement mode on.
     * @param castle - castle tile that has been placed.
     */
    public void placedCastle(Tile castle) {
        endKnightPlacement.setVisible(true);

        // Get valid locations for movement around castle
        ArrayList<Integer> gridLocations = game.getBoard().getValidMoves(castle, Tile.getMaxCastleKnights());
        KnightPicker knightPicker2;
        // If kngihts can be moved, allow player to place up to 5 knights
        if(!gridLocations.isEmpty()){
            knightPicker2 = new KnightPicker(this, castle.getMinimumKnights(), GameUtils.getColor(currentPlayer.getColor()));
        }

        // If there are no places to move to, only allow player to move 4 knights.
        else{
            knightPicker2 = new KnightPicker(this, castle.getMinimumKnights(), GameUtils.getColor(currentPlayer.getColor()), true);
        }
        abovePanel.setBackground(GameUtils.getColor(currentPlayer.getColor()));
        knightPicker2.setVisible(true);
        JPanel panel = new JPanel();
        panel.setBackground(GameUtils.getColor(currentPlayer.getColor()));
        panel.add(knightPicker2);
        panel.add(endKnightPlacement);
        abovePanel.add(panel, "3");
        cl.show(abovePanel, "3");
        game.incrementMoveCounter();
    }

    /**
     * Removed tile and redraws grid based on which boundary the board has hit.
     * @param x_end - determines if board has hit x boundary
     * @param y_end - determines if board has hit y boudary
     */
    public void removedTile(boolean x_end, boolean y_end) {
        grid.removeAll();
        setUpGrid(grid, GUI.game.getNumPlayers(), x_end, y_end);
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
        button.setOpaque(true);
        drawKnights(button, castle);
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
        TileButton startButton = (TileButton) grid.getComponent(GameUtils.getGridLocation(castle, game.getBoard().getSize()));
        TileButton destinationButton = (TileButton) grid.getComponent(GameUtils.getGridLocation(destination, game.getBoard().getSize()));
        startButton.setHorizontalTextPosition(SwingConstants.CENTER);
        startButton.setOpaque(true);
        startButton.setFont(new Font(selectedCard.getFont().getName(),selectedCard.getFont().getStyle(),30));
        startButton.setForeground(playerColor); startButton.setHorizontalTextPosition(SwingConstants.CENTER);
        destinationButton.setHorizontalTextPosition(SwingConstants.CENTER);
        destinationButton.setOpaque(true);
        destinationButton.setFont(new Font(selectedCard.getFont().getName(),selectedCard.getFont().getStyle(),30));
        drawKnights(destinationButton, destination);
        removeKnights(castle, startButton);
        if(destination.getNumKnights() != 0  && !castle.getTopKnight().equals( destination.getBottomKnight())){
            playSound("resources/KnightTakesKnight.wav");
        }
    }


    /**
     * Enables all buttons on UI.
     */
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
        if(currentPlayer.getDeck().getSize() > 2)
            deckLabel.setEnabled(true);
        else
            deckLabel.setEnabled(false);
    }

    /**
     * Helper method that disables all buttons on grid except for locations given in array.
     * @param gridLocations - location of buttons to be left enabled
     */
    private void disableAllExcept(ArrayList<Integer> gridLocations) {
        card1.setEnabled(false);
        card2.setEnabled(false);
        deckLabel.setEnabled(false);
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
        if(currentPlayer.getDeck().getSize() < 3){
            deckLabel.setIcon(null);
        }
        if(currentPlayer.getDeck().getSize() > 0){
            card1.setIcon(currentPlayer.getDeck().getTile1().getImage());
            card1.setEnabled(true);
            if(currentPlayer.getDeck().getSize() > 2){
                deckLabel.setIcon(currentPlayer.getDeck().getTile3().getBack());
            }
        }
        else{
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
        if(currentPlayer.getDeck().getSize() > 2){
            deckLabel.setIcon(currentPlayer.getDeck().getTile3().getBack());
            deckLabel.setEnabled(true);
        }
        else{
            deckLabel.setIcon(null);
            deckLabel.setEnabled(false);
        }
    }

    /**
     * Updates hand in ui to current player. Triggered when it is a new player's turn.
     */
    public void updateHand(Player p){
        if(p.getDeck().getSize() > 0){
            card1.setIcon(p.getDeck().getTile1().getImage());
            card1.setEnabled(true);
            if(currentPlayer.getDeck().getSize() > 3){
                deckLabel.setIcon(currentPlayer.getDeck().getTile3().getBack());
            }
        }
        else{
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
        if(p.getDeck().getSize() > 2){
            deckLabel.setIcon(p.getDeck().getTile3().getBack());
            deckLabel.setEnabled(true);
        }
        else{
            deckLabel.setIcon(null);
            deckLabel.setEnabled(false);
        }
    }

    /**
     * Updates knight count after a player sucessfully places a knight on a tile.
     * @param numberOfKnights
     */
    public void updateKnights(int numberOfKnights) {
        this.numberOfKnights.setText(Integer.toString(numberOfKnights));
    }

    /**
     * Ends knight movement
     */
    public void endKnightMovement() {
        if(game.getBoard().getCastleTile().getNumKnights() < Tile.getMaxCastleKnights()){
            endKnightPlacement.setVisible(false);
            //knightPicker.setVisible(false);
            normalPanel.setBackground(GameUtils.getColor(currentPlayer.getColor()));
            cl.show(abovePanel, "1");
            reenableAll();
            game.getBoard().setCastleTile(null);
            game.getBoard().setTileMovingTo(null);
            game.getBoard().setKnightmode(false);
            if(currentPlayer.getDeck().getSize() == 0){
                try {
                    currentPlayer = game.getNextPlayer();
                    return;
                } catch (NoSuchPlayerException e) {
                    e.printStackTrace();
                }
            }
            game.confirmPlayerTurn();
        }
        else{
            JOptionPane.showMessageDialog(InGame,
                    "You cannot leave 5 knights on a castle.",
                    "5 knights are left on a castle.", JOptionPane.PLAIN_MESSAGE);

        }
    }

    /**
     * Shows valid locations obtained from board.
     * @param locations - locations in grid that are avaibleable for movement.
     */
    public void showValidLocations(ArrayList<Integer> locations) {
        reenableAll();
        disableAllExcept(locations);
    }
    //TODO consolidate methods
    /**
     * Shows valid location when from castle placement
     * @param locations - locations next to castle that are valid
     * @param castle - castle tile locations are determined from.
     */
    public void showValidLocations(ArrayList<Integer> locations, Tile castle) {
        disableAllExcept(locations);
    }

    /**
     * Called after player surrender. Will skip player's turn no matter if he played a move or not.
     */
    public void skipTurn() {
        try {
            currentPlayer = game.getNextPlayer();
        } catch (NoSuchPlayerException e) {
            e.printStackTrace();
        }
    }

    public void endTurn() {
        endTurnActionPerformed();
    }

    // END LISTENER IMPLEMENTATION

    /**
     * Informs game that knights have been placed on castle
     * @param numberOfKnights
     */
    public void placeKnight(int numberOfKnights) {
        game.placeKnight(game.getBoard().getCastleTile(), numberOfKnights);
    }

    /**
     * Informs game knights have moved.
     */
    public void moveKnight(int numberOfKnights) {
        game.moveKnight(game.getBoard().getCastleTile(), game.getBoard().getTileMovingTo(), numberOfKnights);
//        Player current = game.getCurrentPlayer();
//        Tile goTo = game.getBoard().getTileMovingTo();
//        if(goTo.knights.size() > 0)
//            if(current.getColor() != goTo.getTopKnight())
//                playSound("resources/KillStab.wav");
    }


    /**
     * Helper method used to play sound .
     * @param filename  - file containing sound to play
     */
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
    public BufferedImage getKnightImage(domain.enums.Color color, int num){
        BufferedImage img = null;
        try {
            if(num == 0){
                if(color == domain.enums.Color.RED)
                    img = ImageIO.read(new File("resources" + separator + "knight red small.gif"));
                else if(color == domain.enums.Color.BLUE)
                    img = ImageIO.read(new File("resources" + separator + "knight blue small.gif"));
                else if(color == domain.enums.Color.GREEN)
                    img = ImageIO.read(new File("resources" + separator + "knight green small.gif"));
                else if(color == domain.enums.Color.YELLOW)
                    img = ImageIO.read(new File("resources" + separator + "knight yellow small.gif"));
                else return null;
            }
            else if(num == 1){
                if(color == domain.enums.Color.RED)
                    img = ImageIO.read(new File("resources" + separator + "knight red side small.jpg"));
                else if(color == domain.enums.Color.BLUE)
                    img = ImageIO.read(new File("resources" + separator + "knight blue side small.jpg"));
                else if(color == domain.enums.Color.GREEN)
                    img = ImageIO.read(new File("resources" + separator + "knight green side small.jpg"));
                else if(color == domain.enums.Color.YELLOW)
                    img = ImageIO.read(new File("resources" + separator + "knight yellow side small.jpg"));
                else return null;
            } else return null;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return img;
    }
}

