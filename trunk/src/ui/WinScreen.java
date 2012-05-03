package ui;

import java.awt.*;
import java.awt.event.*;
import javax.sound.sampled.*;
import javax.swing.*;
import domain.RobberKnight;

@SuppressWarnings("unused")
public class WinScreen{

    private JFrame frame = new JFrame("Win Screen");

    public WinScreen(RobberKnight game){
		
		/**
		 *Calculations
		 */
        int[] playerTotals = game.getTotals();
        int winner = 0;
        for(int i = 0; i < 4; i++){
            int total = 0;
            if (playerTotals[i] > total){
				total = playerTotals[i];
				winner = i;
			}
		}
		
		/**
		 *Default
		 */
		frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setBounds(750, 300, 250, 250);
        //frame.setResizable(false);
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        /**
         *Display who won game
         */
        JLabel player = new JLabel();
        player.setText("Player ");
        Font font = new Font("Serif", Font.BOLD, 34);
        player.setFont(font);

        JLabel winningPlayer = new JLabel();
        winningPlayer.setText(Integer.toString(winner + 1));
        winningPlayer.setFont(font);

        JLabel win = new JLabel();
        win.setText(" Wins!");
        win.setFont(font);

        JPanel winningPanel = new JPanel();
        winningPanel.add(player);
        winningPanel.add(winningPlayer);
        winningPanel.add(win);
        panel.add(winningPanel, BorderLayout.NORTH);
        
        /**
         *Display Picture
         */
        JLabel pic = new JLabel();
        pic.setIcon(new ImageIcon("resources/fireworks.gif"));
        panel.add(pic, BorderLayout.WEST);
        
        /** 
         * Play Sound
         */
        GUI.playSound("resources/YouWin.wav");

        /**
         *Display player scores
         */
        JPanel playerPoints = new JPanel();
        playerPoints.add(new JLabel("Player 1: "));
        playerPoints.add(new JLabel(Integer.toString(playerTotals[0])));
   
        playerPoints.add(new JLabel("Player 2: "));
        playerPoints.add(new JLabel(Integer.toString(playerTotals[1])));
        
        if(game.getNumPlayers() > 2){
	        playerPoints.add(new JLabel("Player 3: "));
	        playerPoints.add(new JLabel(Integer.toString(playerTotals[2])));
        }
        
        if(game.getNumPlayers() > 3){
	        playerPoints.add(new JLabel("Player 4: "));
	        playerPoints.add(new JLabel(Integer.toString(playerTotals[3])));
        }
        
        panel.add(playerPoints, BorderLayout.CENTER);
        
        /**
         *Add button ActionListeners
         */
        JButton newGame = new JButton("New Game");
        newGame.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				frame.setVisible(false);
				new PlayerSelection();
			}
        });
        JButton quit = new JButton("Quit");
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
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(newGame);
        buttonPanel.add(quit);
        panel.add(buttonPanel, BorderLayout.SOUTH);

        /**
         * Add everything to frame
         */
        frame.add(panel);
	}
	
	/***Testing**
	public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new WinScreen(new RobberKnight(0, null, null, null), new GameMenu(true));
            }
        });
	}
	/******/
}
