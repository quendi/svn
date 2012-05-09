package ui;

import java.awt.*;
import java.awt.event.*;
import javax.sound.sampled.*;
import javax.swing.*;

import domain.Player;
import domain.RobberKnight;

@SuppressWarnings("unused")
public class WinScreen{

    private JFrame frame = new JFrame("Win Screen");

    public WinScreen(RobberKnight game,final GUI gui){

        /**
         *Calculations
         */

        int total = -2;
        int total_knight = 0;
        int[] playerTotals = game.getTotals();
        int winner = 0;
        int same_score = 0;
        int same_knight = 0;

        for(int i = 0; i < 4; i++){
            if (playerTotals[i] > total){
                total = playerTotals[i];
                winner = i;
            }
            else if(playerTotals[i] == total)
            	same_score = 1;
        }

        /**
         *Default
         */
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setBounds(750, 300, 600, 300);
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.setSize(Toolkit.getDefaultToolkit().getScreenSize());

        /**
         *Display who won game
         */
        Font font = new Font("Serif", Font.BOLD, 34);

        JLabel winningPlayer = new JLabel();
        JLabel win = new JLabel();
        int num_surrander = 0;
        
        for( int i = 0; i < game.getNumPlayers(); i++ ){
        	if( playerTotals[i] == -1 )
        		num_surrander++;
        }
        
        if( same_score == 1 ){
            for( int i = 0; i < game.getNumPlayers(); i++ ){
            	if( playerTotals[i] == total && game.getPlayerByNumber(i).getNumKnights() > total_knight){
            		total_knight = game.getPlayerByNumber(i).getNumKnights();
            		winner = i;
            	}
            	else if( playerTotals[i] == total && game.getPlayerByNumber(i).getNumKnights() == total_knight){
            		same_knight = 1;
            	}
            }
            if( same_knight == 1  ){
            	winningPlayer.setText("Draw ");
        		win.setText(" Game!");
            }
        	else {
            	winningPlayer.setText(game.getPlayerByNumber(winner).getName());
            	win.setText(" Wins!");
        	}
        }
        else if( num_surrander == (game.getNumPlayers()-1) ){
            for( int i = 0; i < game.getNumPlayers(); i++ ){
            	if( playerTotals[i] != -1 ){
                	winningPlayer.setText(game.getPlayerByNumber(i).getName());
                	win.setText(" Wins!");
            	}
            }
        }
        else {
        	winningPlayer.setText(game.getPlayerByNumber(winner).getName());
        	win.setText(" Wins!");
        }
        
        
        
        winningPlayer.setFont(font);
        win.setFont(font);

        JPanel winningPanel = new JPanel();
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
        JPanel playerPoints = new JPanel(new GridLayout(game.getNumPlayers(),2));
        for(int i=0;i<game.getNumPlayers();i++){
        	playerPoints.add(new JLabel("    "+game.getPlayerByNumber(i).getName()+":   "));
        	if( playerTotals[i] == -1 )
        		playerPoints.add(new JLabel("Surrender"));
        	else {
        		if( same_score == 1 )
        			playerPoints.add(new JLabel(""+playerTotals[i]+" ( with Knight Left:"+game.getPlayerByNumber(i).getNumKnights()+")"));
        		else
        			playerPoints.add(new JLabel(""+playerTotals[i]));
        	}
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
                if(gui!= null && gui.InGame != null){
                    gui.InGame.dispose();
                    gui.stopSound();
                }
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
