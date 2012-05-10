package ui;
import java.awt.Font;

import javax.swing.*;

@SuppressWarnings("serial")
public class  About extends JFrame{

	JLabel label = new JLabel();

	public About(){

		this.setTitle("About");
		this.setVisible(true);
        this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        this.setBounds(750, 300, 350, 400);

        label.setFont(new Font("Serif", Font.PLAIN, 20));

        label.setText("<html>" +
        		"<H1 align=\"center\">Robber Knights</H1><br>" +
        		"Class Project<br>" +
				"CS 536 Software Engineering<br>" +
				"Spring 2012<br><br>" +
				"Group Members:<br>" +
				"Joel Francisco<br>" +
				"Chun-Chieh Lee (Jim)<br>" +
				"Aaron Dean Proffitt<br>" +
				"Samareh Shahmohammadi<br>" +
				"Yasodhara Siddineni<br><br>" +
				"<small><right>© Copyright 2005 Queen</right></small></html>");
        this.add(label);

	}

}