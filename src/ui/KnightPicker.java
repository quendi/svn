package ui;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

/**
 * User: Joe
 */
@SuppressWarnings({ "serial", "unused" })
public class KnightPicker extends JPanel {

    private static final int MAX_KNIGHTS = 5;
    private JComboBox knightPick;
    private final GUI gui;
    private JPanel knightPanel = new JPanel();
    private boolean knightMovement = false;

    /**
     * Constructor for knightpicker.  Called when clicking on a tile to move knights to.
     * @param gui - main game window
     * @param minimumKnights - minimum knights that player should be allowed to play
     */
    public KnightPicker(GUI gui, int minimumKnights, Color color){

        this.gui = gui;
        // this.setBounds(500, 500, 200, 200);
        JLabel message = new JLabel("Number of Knight to Place");
        String[] knightPickers = new String[MAX_KNIGHTS + 1];
        for(int i = minimumKnights; i <= MAX_KNIGHTS; i++){
            knightPickers[i] = Integer.toString(i);
        }
        knightPick =  new JComboBox(new DefaultComboBoxModel(knightPickers));
        JButton ok = new JButton("OK");
        ok.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okActionPerformed(evt);
            }
        });
        knightPanel.add(message);
        knightPanel.add(knightPick);
        knightPanel.add(ok);
        this.add(knightPanel);
        knightPanel.setBackground(color);
        knightPanel.setForeground(color);
        this.setBackground(color);
        this.setForeground(color);
    }

    /**
     * Creates a knightpicker for a surrounded castle.  This only allows up to 4 knight to be placed on a tile rather than that usual 5
     * @param gui
     * @param minimumKnights  - min knights for castle tile
     * @param color - color to set panel to
     * @param playerKnights - # of knights player has remaining.  Will be maximum allowed to place if less than the max amount of knights playable.
     * @param castleSurrounded - boolean if castle is surrounded.  allows 4 if surrounded, 5 if not.
     */
    public KnightPicker(GUI gui, int minimumKnights, Color color,int playerKnights, boolean castleSurrounded){

        this.gui = gui;
        // this.setBounds(500, 500, 200, 200);
        JLabel message = new JLabel("Number of Knight to Place");
        String[] knightPickers;
        int maxKnights = MAX_KNIGHTS;
        if(castleSurrounded){
            knightPickers = new String[Math.min(playerKnights + 1, maxKnights)];
        }
        else{
            maxKnights++;
            knightPickers = new String[Math.min(playerKnights + 1, maxKnights)];
        }
        for(int i = minimumKnights; i < Math.min(playerKnights + 1, maxKnights); i++){
            knightPickers[i] = Integer.toString(i);
        }
        knightPick =  new JComboBox(new DefaultComboBoxModel(knightPickers));
        JButton ok = new JButton("OK");
        ok.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okActionPerformed(evt);
            }
        });
        knightPanel.add(message);
        knightPanel.add(knightPick);
        knightPanel.add(ok);
        this.add(knightPanel);
        knightPanel.setBackground(color);
        knightPanel.setForeground(color);
        this.setBackground(color);
        this.setForeground(color);
    }


    /**
     * Sets avaiable options according to the available knights.  Used in knight movement.
     * @param availableKnights - knight player can still move
     */
    public void setKnightPicker(int availableKnights){
        knightMovement = true;
        String[] knightPickers = new String[availableKnights + 1];
        for(int i = 0; i <= availableKnights; i++){
            knightPickers[i] = Integer.toString(i);
        }

        knightPanel.remove(knightPick);
        knightPick = new JComboBox(new DefaultComboBoxModel(knightPickers));
        knightPanel.add(knightPick);
    }

    /**
     * Set available options when moving to an empty tile.
     * @param moveableKnights  - knights that can be moved from castle
     * @param minimumKnights  - minimum amount of knights the tile being moved to allows
     */

    public void setKnightPicker(int moveableKnights, int minimumKnights) {
        knightMovement = true;
        int knightOptions =(moveableKnights - minimumKnights) + 1;
        String[] knightPickers = new String[knightOptions];
        for(int i = 0; i < knightOptions; i++){
            knightPickers[i] = Integer.toString(minimumKnights);
            minimumKnights++;
        }

        knightPanel.remove(knightPick);
        knightPick = new JComboBox(new DefaultComboBoxModel(knightPickers));
        knightPanel.add(knightPick);

    }
    /**
     * User indicates the number of knights he wishes to place on a tile.
     * @param evt
     */
    protected void okActionPerformed(ActionEvent evt) {

        if (knightPick.getSelectedItem() != null) {
            int numberOfKnights = Integer.parseInt((String) knightPick.getSelectedItem());
            if(numberOfKnights > 0){
                this.setVisible(false);
                if(knightMovement){
                    gui.moveKnight(numberOfKnights);
                }
                else{
                    gui.placeKnight(numberOfKnights);
                }
            }
            else{
                gui.endKnightMovement();
                this.setVisible(false);
            }
        }
    }

    private void endKnightMovement() {
        gui.endKnightMovement();
    }

    public void changeColor(Color color){
        knightPanel.setBackground(color);
        knightPanel.setForeground(color);
        this.setBackground(color);
        this.setForeground(color);
    }


}
