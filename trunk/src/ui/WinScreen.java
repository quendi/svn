package ui;

import javax.swing.*;

import domain.RobberKnight;

public class WinScreen {

	private JFrame frame = new JFrame();
	private JPanel panel = new JPanel();
	private int[] playerTotals;


	
	public WinScreen(RobberKnight game){

		playerTotals = game.getTotals();
		
		frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
        frame.setBounds(500, 500, 500, 500);
        frame.setResizable(false);
        
        panel.add(new JLabel("Player 1: "));
        panel.add(new JLabel(Integer.toString(playerTotals[0])));
        
        panel.add(new JLabel("Player 2: "));
        panel.add(new JLabel(Integer.toString(playerTotals[1])));
        
        panel.add(new JLabel("Player 3: "));
        panel.add(new JLabel(Integer.toString(playerTotals[2])));
        
        panel.add(new JLabel("Player 4: "));
        panel.add(new JLabel(Integer.toString(playerTotals[3])));
        
        frame.add(panel);
        
	}
	
	
	
	
	
}
