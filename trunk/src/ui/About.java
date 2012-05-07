package ui;
import java.awt.Font;

import javax.swing.*;

@SuppressWarnings("serial")
public class  About extends JFrame{

	JPanel panel = new JPanel();
	JLabel label = new JLabel();

	public About(){

		this.setTitle("About");
		this.setVisible(true);
        this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        this.setBounds(750, 300, 425, 500);
        //this.setResizable(false);

        label.setFont(new Font("Serif", Font.PLAIN, 34));

        label.setText("<html> <center>Robber Knights <br> " +
        		 "Class Project<br>" +
        		 "CS 536 Software Engineering<br>" +
        		 "Spring 2012<br>" +
        		 "Group Members:<br>"+
        		 "Joel Francisco<br>"+
        		 "Chun-Chieh Lee (Jim)<br>"+
        		 "Aaron Proffitt<br>"+
        		 "Samareh Shahmohammadi<br>"+
        		 "Yasodhara Siddineni</center></html>");

        this.add(label);

	}

	/***Testing***/
	public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new About();
            }
        });
	}
	/******/
}