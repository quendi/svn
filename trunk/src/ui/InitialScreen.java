package ui;

import java.awt.*;

import javax.swing.*;

@SuppressWarnings("serial")
public class InitialScreen extends JFrame{

    public InitialScreen(){
		this.setResizable(false);
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setMinimumSize(new Dimension(460, 670));
        JLabel picLabel = new JLabel(new ImageIcon("resources/robber knights cover small.jpg"));
        this.add(picLabel);
		this.setJMenuBar(new GameMenu(false, this, null, null));
	}
}
