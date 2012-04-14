package ui;

import domain.BoardListener;
import domain.PlayerListener;
import domain.Tile;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * User: Joe
 * Date: Apr 14, 2012
 * Time: 5:43:59 PM
 */
public class PlayerWindow extends JPanel implements PlayerListener, BoardListener {

    int playerId;
    private ArrayList<Tile> tileDisplay = new ArrayList<Tile>();

    public PlayerWindow(final GUI gui, ArrayList<Tile> tiles){
        this.tileDisplay = tiles;
		JPanel center = new JPanel(new FlowLayout());
		//todo have tiles act as buttons?
		JButton tileOne = new JButton ("Place Tile");
		JButton tileTwo = new JButton ("Place Tile");



        //todo how to handle this? need to ask where user wants to place the tile they selected
		tileOne.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
                gui.placeTile(tileDisplay.get(0), new Point()); // how to get coordinates?

			}
		});


        tileTwo.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){


			}
		});

    }

    public int getPlayerId() {
        return playerId;
    }

    public void setPlayerId(int playerId) {
        this.playerId = playerId;
    }

    public void updateDeck(Tile t) {
       
    }

    public void updateKnights(int knights) {
        
        //To change body of implemented methods use File | Settings | File Templates.
    }

    public void placeTile(Tile t) {
        //To change body of implemented methods use File | Settings | File Templates.
    }
}
