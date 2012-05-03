package ui;
import javax.swing.*;

public class  About {
	
	JFrame frame = new JFrame("About");
	JPanel panel = new JPanel();
	JLabel label = new JLabel();
	
	public About(){
		
		frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        frame.setBounds(750, 300, 500, 500);
        frame.setResizable(false);

        
        label.setText("Created by...");
        frame.add(label);
        
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
