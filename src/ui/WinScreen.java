package ui;

import java.awt.BorderLayout;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;

import domain.RobberKnight;

public class WinScreen {

	private int winner = 0;
	private int total = 0;
	private int[] playerTotals;
	private JFrame frame = new JFrame();
	private JPanel panel = new JPanel();
	private JPanel winningPanel = new JPanel();
	private JPanel playerPoints = new JPanel();
	private JPanel buttonPanel = new JPanel();
	private JLabel player = new JLabel();
	private JLabel winningPlayer = new JLabel();
	private JLabel win = new JLabel();
	private JLabel pic = new JLabel();
	private JButton newGame = new JButton("New Game");
	private JButton quit = new JButton("Quit");
	private Font font = new Font("Serif", Font.BOLD, 34);
	
	public WinScreen(RobberKnight game){
		
		/**
		 *Calculations
		 */
		playerTotals = game.getTotals();
		for(int i = 0; i < 4; i++){
			if (playerTotals[i] > total){
				total = playerTotals[i];
				winner = playerTotals[i];
			}
		}
		
		/**
		 *Default
		 */
		frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
        frame.setBounds(750, 300, 250, 250);
        frame.setResizable(false);
        panel.setLayout(new BorderLayout());
        
        /**
         * Play Sound
         */
		try {
			AudioInputStream audio = AudioSystem.getAudioInputStream(new java.io.File("resources/YouWin.wav"));
			DataLine.Info info = new DataLine.Info(Clip.class,audio.getFormat());
			Clip clip = (Clip) AudioSystem.getLine(info);
			clip.open(audio);
			clip.start();
		}catch (Exception e) {
			System.out.println(e);
		}
		
        /**
         *Display who won game
         */
        player.setText("Player ");
        player.setFont(font);
        
        winningPlayer.setText(Integer.toString(winner + 1));
        winningPlayer.setFont(font);
        
        win.setText(" Wins!");
        win.setFont(font);
        
        winningPanel.add(player);
        winningPanel.add(winningPlayer);
        winningPanel.add(win);
        panel.add(winningPanel, BorderLayout.NORTH);
        
        /**
         *Display Picture
         */
        pic.setIcon(new ImageIcon("resources/fireworks.gif"));
        panel.add(pic, BorderLayout.WEST);
        
        /**
         *Display player scores
         */
        playerPoints.add(new JLabel("Player 1: "));
        playerPoints.add(new JLabel(Integer.toString(playerTotals[0])));
   
        playerPoints.add(new JLabel("Player 2: "));
        playerPoints.add(new JLabel(Integer.toString(playerTotals[1])));
        
        playerPoints.add(new JLabel("Player 3: "));
        playerPoints.add(new JLabel(Integer.toString(playerTotals[2])));
        
        playerPoints.add(new JLabel("Player 4: "));
        playerPoints.add(new JLabel(Integer.toString(playerTotals[3])));
        
        panel.add(playerPoints, BorderLayout.CENTER);
        
        /**
         *Add button ActionListeners
         */
        newGame.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				frame.setVisible(false);
				new PlayerSelection(true, new GUI(), new RobberKnight(0, null, null, null));
			}
        });
        quit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
        });
        
        /**
         *Add buttons
         */
        newGame.setPreferredSize(new Dimension(110,50));
        quit.setPreferredSize(new Dimension(110,50));
        buttonPanel.add(newGame);
        buttonPanel.add(quit);
        panel.add(buttonPanel, BorderLayout.SOUTH);

        /**
         * Add everything to frame
         */
        frame.add(panel);
	}
	
	/***Testing purposes***/
	public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
            	
                new WinScreen(new RobberKnight(0, null, null, null));
            }
        });
	}
	/******/
}
