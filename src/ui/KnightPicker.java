package ui;

import org.apache.commons.lang3.ArrayUtils;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

/**
 * User: Joe
 */
public class KnightPicker extends JFrame {
    private JComboBox knightPick;
    private int numberOfKnights;
    private GUI gui;
    private JPanel knightPanel = new JPanel();
    private boolean knightMovement = false;
    public KnightPicker(GUI gui){
        this.gui = gui;
        this.setBounds(500, 500, 200, 100);
        this.setDefaultCloseOperation(HIDE_ON_CLOSE);
        JLabel message = new JLabel("Number of Knight to Place");
        knightPick = new JComboBox(new DefaultComboBoxModel(
                new String[] { "0", "1", "2", "3", "4", "5" }));
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
    }

    /**
     * Sets avaiable options accoarding to the available knights.  Used in knight movement.
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
     * User indicates the number of knights he wishes to place on a tile.
     * @param evt
     */
    protected void okActionPerformed(ActionEvent evt) {
        numberOfKnights =  Integer.parseInt( (String) knightPick.getSelectedItem());
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
