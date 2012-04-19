package ui;

import domain.*;
import domain.enums.Building;
import exceptions.NoSuchPlayerException;
import utils.GameUtils;

import java.awt.*;
import java.awt.event.ActionEvent;
import javax.swing.*;

/**
 *
 * @author Aaron
 */
public class GUI extends JFrame implements PlayerListener,
        BoardListener {
    private JButton selectedCard = new JButton("Null");
    private int moves = 0;
    private Tile tileInPlay;
    protected Player currentPlayer;

    public RobberKnight game;
    PlayerSelection playerSelection;

    // Variables declaration - do not modify
    private JMenu Edit;
    private JMenu File;
    private JMenu Help;
    protected JFrame InGame;
    private JMenuBar Menu;

    private JMenuItem about;
    protected TileButton card1;
    protected TileButton card2;
    private JMenuItem close;
    protected JLabel currentColor;

    private JButton endTurn;
    private JDialog errorNotEnoughPlayers;
    private JLabel errorNotEnoughPlayersMsg;
    private JButton errorOK;

    protected JPanel grid;
    private JMenuItem help;
    private JButton jButton104;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel titleScreen;
    private JMenuItem loadGame;
    protected JMenuItem newGame;
    protected JLabel numberOfKnights;
    protected JLabel playersTurn;
    protected JPanel PlayerPanel;
    private JFrame pickKnightNum;
    private int NumKnightPlace = 0;
    private JComboBox knightPick;
    private JFrame initialTile;
    private int turn = 0;
    private int tilesPlaced = 0;
    private int selectedTile = 0;
    private int first = 0;
    private static final int SIZE = 117 * 7;

    // End of variables declaration

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public GUI() {
        initComponents();
    }

    // use init to check is this is an initial placement
    private int placeTile(Tile tile, Point location, int init ) {
        if (game.placeTile(tile, location, init) == -1) {
            return -1;
        } else
            return 0;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        initialTile = new JFrame();
        pickKnightNum = new JFrame();
        InGame = new JFrame();
        jButton104 = new JButton();
        jLabel1 = new JLabel();
        jLabel2 = new JLabel();
        endTurn = new JButton();
        card1 = new TileButton();
        card2 = new TileButton();
        numberOfKnights = new JLabel();
        playersTurn = new JLabel();
        currentColor = new JLabel();
        grid = new JPanel();
        errorNotEnoughPlayers = new JDialog();
        errorNotEnoughPlayersMsg = new JLabel();
        errorOK = new JButton();
        titleScreen = new JLabel();
        Menu = new JMenuBar();
        File = new JMenu();
        newGame = new JMenuItem();
        loadGame = new JMenuItem();
        close = new JMenuItem();
        Edit = new JMenu();
        Help = new JMenu();
        about = new JMenuItem();
        help = new JMenuItem();
        PlayerPanel = new JPanel();

        pickKnightNum.setBounds(500, 500, 200, 100);
        pickKnightNum.setDefaultCloseOperation(HIDE_ON_CLOSE);
        JPanel knightPanel = new JPanel();
        JLabel message = new JLabel("Number of Knight to Place");
        knightPick = new JComboBox(new DefaultComboBoxModel(
                new String[] { "1", "2", "3", "4", "5" }));
        JButton ok = new JButton("OK");
        ok.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okActionPerformed(evt);
            }
        });
        knightPanel.add(message);
        knightPanel.add(knightPick);
        knightPanel.add(ok);
        pickKnightNum.add(knightPanel);

        InGame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
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

        GroupLayout PlayerPanelLayout = new GroupLayout(
                PlayerPanel);
        PlayerPanel.setLayout(PlayerPanelLayout);
        PlayerPanelLayout
                .setHorizontalGroup(PlayerPanelLayout
                        .createParallelGroup(
                                GroupLayout.Alignment.LEADING)
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
                                                                                        .addGroup(
                                                                                                PlayerPanelLayout
                                                                                                        .createSequentialGroup()
                                                                                                        .addGap(33,
                                                                                                                33,
                                                                                                                33)
                                                                                                        .addComponent(
                                                                                                                jLabel2,
                                                                                                                GroupLayout.PREFERRED_SIZE,
                                                                                                                44,
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
                                                                                                                                jButton104,
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
                                                                                                                                                jLabel1)
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
                                                                jLabel1,
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
                                                jButton104,
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
                                                                jLabel2,
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
                                        .addGap(52, 52, 52)));

        GroupLayout gridLayout = new GroupLayout(grid);
        grid.setLayout(gridLayout);
        /*gridLayout.setHorizontalGroup(gridLayout.createParallelGroup(
                  GroupLayout.Alignment.LEADING).addGap(0, 574,
                  Short.MAX_VALUE));
          gridLayout.setVerticalGroup(gridLayout.createParallelGroup(
                  GroupLayout.Alignment.LEADING).addGap(0, 0,
                  Short.MAX_VALUE));*/

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
                                                // .addComponent(grid,
                                                // GroupLayout.DEFAULT_SIZE,
                                                // GroupLayout.DEFAULT_SIZE,
                                                // Short.MAX_VALUE)
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
                                .addComponent(grid/*
												 * , GroupLayout.
												 * DEFAULT_SIZE,
												 * GroupLayout
												 * .DEFAULT_SIZE,
												 * Short.MAX_VALUE
												 */).addContainerGap()));

        errorNotEnoughPlayers.setIconImage(null);
        errorNotEnoughPlayers.setMinimumSize(new java.awt.Dimension(400, 300));
        errorNotEnoughPlayers.setResizable(false);

        errorNotEnoughPlayersMsg
                .setText("                               Error: Must have at least two players");

        errorOK.setText("OK");
        errorOK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                errorOKActionPerformed(evt);
            }
        });

        GroupLayout errorNotEnoughPlayersLayout = new GroupLayout(
                errorNotEnoughPlayers.getContentPane());
        errorNotEnoughPlayers.getContentPane().setLayout(
                errorNotEnoughPlayersLayout);
        errorNotEnoughPlayersLayout
                .setHorizontalGroup(errorNotEnoughPlayersLayout
                        .createParallelGroup(
                                GroupLayout.Alignment.LEADING)
                        .addGroup(
                                errorNotEnoughPlayersLayout
                                        .createSequentialGroup()
                                        .addGroup(
                                                errorNotEnoughPlayersLayout
                                                        .createParallelGroup(
                                                                GroupLayout.Alignment.LEADING)
                                                        .addGroup(
                                                                errorNotEnoughPlayersLayout
                                                                        .createSequentialGroup()
                                                                        .addContainerGap()
                                                                        .addComponent(
                                                                                errorNotEnoughPlayersMsg,
                                                                                GroupLayout.DEFAULT_SIZE,
                                                                                380,
                                                                                Short.MAX_VALUE))
                                                        .addGroup(
                                                                errorNotEnoughPlayersLayout
                                                                        .createSequentialGroup()
                                                                        .addGap(146,
                                                                                146,
                                                                                146)
                                                                        .addComponent(
                                                                                errorOK,
                                                                                GroupLayout.PREFERRED_SIZE,
                                                                                93,
                                                                                GroupLayout.PREFERRED_SIZE)
                                                                        .addGap(0,
                                                                                0,
                                                                                Short.MAX_VALUE)))
                                        .addContainerGap()));
        errorNotEnoughPlayersLayout
                .setVerticalGroup(errorNotEnoughPlayersLayout
                        .createParallelGroup(
                                GroupLayout.Alignment.LEADING)
                        .addGroup(
                                errorNotEnoughPlayersLayout
                                        .createSequentialGroup()
                                        .addContainerGap()
                                        .addComponent(
                                                errorNotEnoughPlayersMsg,
                                                GroupLayout.PREFERRED_SIZE,
                                                191,
                                                GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(
                                                LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(
                                                errorOK,
                                                GroupLayout.PREFERRED_SIZE,
                                                40,
                                                GroupLayout.PREFERRED_SIZE)
                                        .addContainerGap(52, Short.MAX_VALUE)));

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        titleScreen.setIcon(new ImageIcon(
                "resources/RobberKnights.jpg")); // NOI18N

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

        GroupLayout layout = new GroupLayout(
                getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(
                GroupLayout.Alignment.LEADING).addGroup(
                layout.createSequentialGroup().addGap(25, 25, 25)
                        .addComponent(titleScreen)
                        .addContainerGap(30, Short.MAX_VALUE)));
        layout.setVerticalGroup(layout.createParallelGroup(
                GroupLayout.Alignment.LEADING).addGroup(
                layout.createSequentialGroup().addGap(24, 24, 24)
                        .addComponent(titleScreen)
                        .addContainerGap(33, Short.MAX_VALUE)));

        pack();
    }// </editor-fold>

    protected void okActionPerformed(ActionEvent evt) {
        pickKnightNum.setVisible(false);
        NumKnightPlace = knightPick.getSelectedIndex() + 1;
        // System.out.println("#ofknights" + NumKnightPlace);
    }

    private void aboutActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void helpActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    // startgame removed here

    private void errorOKActionPerformed(java.awt.event.ActionEvent evt) {
        errorNotEnoughPlayers.setVisible(false);
    }

    private void newGameActionPerformed(java.awt.event.ActionEvent evt) {
        playerSelection = new PlayerSelection(true, this, game);// true
        this.setVisible(false);
    }

    private void closeActionPerformed(java.awt.event.ActionEvent evt) {
        System.exit(0);
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
            /**
             * Reset move counter and update ui to reflect current player.
             */
            moves = 0;
            playersTurn.setText(Integer.toString(currentPlayer.getId() + 1));
            numberOfKnights.setText(Integer.toString(currentPlayer
                    .getNumKnights()));
            card1.setIcon(currentPlayer.getDeck().getTile1().getImage());
            card2.setIcon(currentPlayer.getDeck().getTile2().getImage());
            // Change color
            currentColor.setText(currentPlayer.getColor().toString());
            InGame.getContentPane().setBackground(Color.getColor(currentPlayer.getColor().toString()));
            PlayerPanel.setBackground(Color.getColor(currentPlayer.getColor().toString()));
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

    private void jButton104ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    /**
     * Creates appropriate grid for player SIZE.
     *
     * @param grid
     *            - Jpanel representation of game board
     * @param numPlayers
     */

    public void setUpGrid(JPanel grid, int numPlayers) {
        if (numPlayers == 2) {
            grid.setLayout(new java.awt.GridLayout(7, 7));
            for (int i = 0; i < 7; i++) {
                for (int j = 0; j < 7; j++) {
                    final TileButton button = new TileButton();
                    final Point location = new Point(j, i);
                    addGridListener(button, location);
                    grid.add(button);
                }
            }

        } else if (numPlayers == 3) {
            grid.setLayout(new java.awt.GridLayout(9, 9));
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    final TileButton button = new TileButton();
                    final Point location = new Point(j, i);
                    addGridListener(button, location);
                    grid.add(button);
                }
            }
        } else {
            grid.setLayout(new java.awt.GridLayout(10, 10));
            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < 10; j++) {
                    final TileButton button = new TileButton();
                    final Point location = new Point(j, i);
                    addGridListener(button, location);
                    grid.add(button);
                }
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

            // Click event for when play clicks on space in board.
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                if (tileInPlay != null && selectedCard != null) {
                    // check if tile have already been placed in location
                    if (game.placeTile(tileInPlay, location, 0) == 0) {
                        moves++;
                        // if a castle is placed, place knights
                        if (tileInPlay.getBuilding() == Building.Castle) {
                            pickKnightNum.setVisible(true);
                        }
                        tileInPlay.setLocation(location);
                        game.placeTile(tileInPlay, location, 0);
                        currentPlayer.playTile(tileInPlay);
                        tileInPlay = null;
                        // End turn once player has made 3 turns
                        if (moves > 2) {
                            endTurnActionPerformed(evt);
                        }
                    }
                }
                // TODO check to see if it's a valid move
                // draw a new card
                // after first play, set it = null
            }
        });
    }

    public void updateHand() {
        card1.setIcon(currentPlayer.getDeck().getTile1().getImage());
        card2.setIcon(currentPlayer.getDeck().getTile2().getImage());
    }

    public void updateHand(Player p){
        card1.setIcon(p.getDeck().getTile1().getImage());
        card2.setIcon(p.getDeck().getTile2().getImage());
    }

    public void updateKnights() {

    }

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                GUI gui = new GUI();
                gui.setVisible(true);
            }
        });
    }

    public void initializeTiles() {
        initialTile.setVisible(true);
        initialTile.setBounds(0, 0, 1200, 1200);
        initialTile.setDefaultCloseOperation(HIDE_ON_CLOSE);
        JPanel tilePanel = new JPanel();
        JLabel display = new JLabel("Player");
        final JLabel playername = new JLabel(Integer.toString(currentPlayer
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
                                                        + 3), 1);
                                currentPlayer.getDeck().playTile(
                                        game.getCurrentPlayer().getDeck()
                                                .getTile1());
                                updateHand();
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
                                                        + 3), 1);
                                currentPlayer.getDeck().playTile(
                                        game.getCurrentPlayer().getDeck()
                                                .getTile2());
                                updateHand();
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
                                                        + 3), 1);
                                currentPlayer.getDeck().playTile(
                                        game.getCurrentPlayer().getDeck()
                                                .getTile3());
                                updateHand();
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
                                                        + 3), 1);
                                currentPlayer.getDeck().playTile(
                                        game.getCurrentPlayer().getDeck()
                                                .getTile4());
                                updateHand();
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

        tilePanel.add(display);
        tilePanel.add(playername);
        tilePanel.add(tile1);
        tilePanel.add(tile2);
        tilePanel.add(tile4);
        tilePanel.add(gridHolder);
        tilePanel.add(select);
        select.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    if (turn < game.getNumPlayers() - 1) {
                        if (tilesPlaced >= 2) {
                            turn++;
                            currentPlayer = game.getNextPlayer();
                            playername.setText(Integer.toString(currentPlayer
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
        setUpGrid(grid, this.game.getNumPlayers());
        initializeTiles();

    }

    /**
     * Triggers when a piece is placed on the game board.  Updates UI board accordingly.
     * @param t
     */
    public void placedTile(Tile t) {
        int gridLocation = GameUtils.getGridLocation(t, game.getBoard().getSize());
        TileButton button = (TileButton) grid
                .getComponent(gridLocation);
        button.setIcon(t.getImage());
    }

    public void placedKnight(Tile t) {

    }
}
