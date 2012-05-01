package ui;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import javax.swing.*;

import domain.RobberKnight;

@SuppressWarnings("serial")
public class GameMenu extends JMenuBar{
	/**
	 * Main bar
	 */
	JMenu file = new JMenu("File");
	JMenu help = new JMenu("Help");
	/**
	 * Items under File
	 */
	JMenuItem newGame = new JMenuItem("New Game");
	JMenuItem surrender = new JMenuItem("Surrender");
	JMenuItem close = new JMenuItem("Close");
	/**
	 * Load and Save
	 */
	SaveAndLoad saveAndLoad;
	/**
	 * Items under Help
	 */
	JMenuItem about = new JMenuItem("About");
	JMenuItem rules = new JMenuItem("Rules");
	
	
	public GameMenu(boolean inGame, final InitialScreen initialScreen, RobberKnight game){


		/**
		 * Add actionlisteners
		 */
        newGame.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
				new PlayerSelection();
				initialScreen.dispose();
            }
        });
        surrender.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                //TODO
            }
        });
        close.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                System.exit(0);
            }
        });
        about.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                new About();
            }
        });
        rules.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                File file = new File("resources/RobberKnights.pdf");

                try {
        			Desktop.getDesktop().open(file);
        		} catch (IOException e) {
        			e.printStackTrace();
        		}
            }
        });
        saveAndLoad = new SaveAndLoad(game);
        
		/**
		 * Add items to file menu
		 */
		file.add(newGame);
		file.add(surrender);
		file.add(close);
		/**
		 * Add items to help menu
		 */
		help.add(about);
		help.add(rules);
		/**
		 * Add items to Bar
		 */
		this.add(file);
		this.add(saveAndLoad);
		this.add(help);
		
	}

}
