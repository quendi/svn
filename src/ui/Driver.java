package ui;

import javax.swing.JFrame;

import domain.Player;

@SuppressWarnings("serial")
public class Driver extends JFrame{
	
	public Driver(){
		this.add(new PlayerPanel(new Player()));
		this.setVisible(true);
		this.setBounds(0,0, 500, 500);
	}

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new InitialScreen();
            }
        });
    }
	
	
}
