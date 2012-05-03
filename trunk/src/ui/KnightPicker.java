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
     * Constructor for knightpicker.  Called when castle is placed.
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

    public KnightPicker(GUI gui, int minimumKnights, Color color, boolean castleSurrounded){

        this.gui = gui;
        // this.setBounds(500, 500, 200, 200);
        JLabel message = new JLabel("Number of Knight to Place");
        String[] knightPickers;
        if(castleSurrounded){
            knightPickers = new String[MAX_KNIGHTS];
        }
        else{
            knightPickers = new String[MAX_KNIGHTS + 1];
        }
        for(int i = minimumKnights; i < MAX_KNIGHTS; i++){
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
     * Set available options when move to an empty tile.
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
