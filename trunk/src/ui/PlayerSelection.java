package ui;

import domain.RobberKnight;
import domain.enums.Color;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.*;


@SuppressWarnings("serial")
public class PlayerSelection extends JFrame{

    private JTextField player1Name = new JTextField("Player 1");
	private JTextField player2Name = new JTextField("Player 2");
	private JTextField player3Name = new JTextField("Player 3");
	private JTextField player4Name = new JTextField("Player 4");

    private String month[] = new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" };
	private String day[] = new String[] { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", 
								  		  "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", 
								  		  "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" };
	private String year[] = new String[] { "1950", "1951", "1952", "1953", "1954", "1955", "1956", "1957", "1958", "1959",
								   		   "1960", "1961", "1962", "1963", "1964", "1965", "1966", "1967", "1968", "1969",
								   		   "1970", "1971", "1972", "1973", "1974", "1975", "1976", "1977", "1978", "1979",
										   "1980", "1981", "1982", "1983", "1984", "1985", "1986", "1987", "1988", "1989", 
										   "1990", "1991", "1992", "1993", "1994", "1995", "1996", "1997", "1998", "1999", 
										   "2000", "2001", "2002", "2003", "2004", "2005", "2006", "2007", "2008", "2009", 
										   "2010", "2011", "2012" };
	private String color[] = new String[] {"blue", "green", "yellow", "red"};


    private JComboBox month1 = new JComboBox(month);
	private JComboBox day1 = new JComboBox(day);
	private JComboBox year1 = new JComboBox(year);

    private JComboBox month2 = new JComboBox(month);
	private JComboBox day2 = new JComboBox(day);
	private JComboBox year2 = new JComboBox(year);

    private JComboBox month3 = new JComboBox(month);
	private JComboBox day3 = new JComboBox(day);
	private JComboBox year3 = new JComboBox(year);

    private JComboBox month4 = new JComboBox(month);
	private JComboBox day4 = new JComboBox(day);
	private JComboBox year4 = new JComboBox(year);
	
	private CardLayout cl1 = new CardLayout();
	private CardLayout cl2 = new CardLayout();
	private JPanel sub1 = new JPanel(cl1);
    private JPanel sub2 = new JPanel(cl2);
    
    JComboBox color1 = new JComboBox(color);

    private ArrayList<String> names = new ArrayList<String>();

    /**
	 * Other
	 */
	private int numOfPlayers = 2;


    public PlayerSelection(){
		/**
		 * Default
		 */
		this.setTitle("Player Selection");
		this.setVisible(true);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setMinimumSize(new java.awt.Dimension(1100, 500));
        Font font = new Font("Serif", Font.BOLD, 34);
        JLabel header = new JLabel("Player Selection", JLabel.CENTER);
        header.setFont(font);
        
        /**
         * Add content to player panels
         */
        //First Panel
        Font font2 = new Font("Serif", Font.BOLD, 20);
        player1Name.setFont(font2);
        JPanel firstPanel = new JPanel(new GridLayout(4, 1));
        JPanel player1Panel = new JPanel();
        player1Name.setPreferredSize(new Dimension(100,40));
        player1Panel.add(player1Name);
        firstPanel.add(player1Panel);
        JLabel birthday1 = new JLabel("Enter Birthday:", JLabel.CENTER);
        birthday1.setFont(font2);
        firstPanel.add(birthday1);
        JPanel birthdayPanel1 = new JPanel();
        birthdayPanel1.add(month1);
        birthdayPanel1.add(day1);
        birthdayPanel1.add(year1);
        firstPanel.add(birthdayPanel1);
        JPanel color1Panel = new JPanel();
        color1Panel.add(color1);
        firstPanel.add(color1Panel);
        
        //Second Panel
        player2Name.setFont(font2);
        JPanel secondPanel = new JPanel(new GridLayout(4, 1));
        JPanel player2Panel = new JPanel();
        player2Name.setPreferredSize(new Dimension(100,40));
        player2Panel.add(player2Name);
        secondPanel.add(player2Panel);
        JLabel birthday2 = new JLabel("Enter Birthday:", JLabel.CENTER);
        birthday2.setFont(font2);
        secondPanel.add(birthday2);
        JPanel birthdayPanel2 = new JPanel();
        birthdayPanel2.add(month2);
        birthdayPanel2.add(day2);
        birthdayPanel2.add(year2);
        secondPanel.add(birthdayPanel2);
        final JComboBox color2 = new JComboBox(color);
        JPanel color2Panel = new JPanel();
        color2Panel.add(color2);
        secondPanel.add(color2Panel);
        
        //Third Panel
        player3Name.setFont(font2);
        JPanel thirdPanel = new JPanel(new GridLayout(4, 1));
        JPanel player3Panel = new JPanel();
        player3Name.setPreferredSize(new Dimension(100,40));
        player3Panel.add(player3Name);
        thirdPanel.add(player3Panel);
        JLabel birthday3 = new JLabel("Enter Birthday:", JLabel.CENTER);
        birthday3.setFont(font2);
        thirdPanel.add(birthday3);
        JPanel birthdayPanel3 = new JPanel();
        birthdayPanel3.add(month3);
        birthdayPanel3.add(day3);
        birthdayPanel3.add(year3);
        thirdPanel.add(birthdayPanel3);
        final JComboBox color3 = new JComboBox(color);
        JPanel color3Panel = new JPanel();
        color3Panel.add(color3);
        thirdPanel.add(color3Panel);
        
        //Fourth Panel
        player4Name.setFont(font2);
        JPanel fourthPanel = new JPanel(new GridLayout(4, 1));
        JPanel player4Panel = new JPanel();
        player4Name.setPreferredSize(new Dimension(100,40));
        player4Panel.add(player4Name);
        fourthPanel.add(player4Panel);
        JLabel birthday4 = new JLabel("Enter Birthday:", JLabel.CENTER);
        birthday4.setFont(font2);
        fourthPanel.add(birthday4);
        JPanel birthdayPanel4 = new JPanel();
        birthdayPanel4.add(month4);
        birthdayPanel4.add(day4);
        birthdayPanel4.add(year4);
        fourthPanel.add(birthdayPanel4);
        final JComboBox color4 = new JComboBox(color);
        JPanel color4Panel = new JPanel();
        color4Panel.add(color4);
        fourthPanel.add(color4Panel);
        
        /**
         * Set up cardlayout
         */
        JButton addPlayer3 = new JButton("Add Player");
        JPanel sub1ButtonPanel = new JPanel(new BorderLayout());
        sub1ButtonPanel.add(addPlayer3);
        JPanel sub2ButtonPanel = new JPanel(new BorderLayout());
        JButton addPlayer4 = new JButton("Add Player");
        sub2ButtonPanel.add(addPlayer4);
        sub1.add(sub1ButtonPanel, "1");
        sub1.add(thirdPanel, "2");
        sub2.add(sub2ButtonPanel, "1");
        sub2.add(fourthPanel, "2");
               
        /**
         * Add actionlisteners to buttons
         */
        addPlayer3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cl1.show(sub1, "2");
				numOfPlayers++;
			}
        });
        addPlayer4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cl2.show(sub2, "2");
				numOfPlayers++;
			}
        });
        JButton startGame = new JButton("Start Game");
        startGame.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent arg0) {
				ArrayList<Date> dates = new ArrayList<Date>();
		        dates.add(new Date(Integer.parseInt(year1.getSelectedItem().toString()) - 1900, month1.getSelectedIndex(), day1.getSelectedIndex()+1));
		        dates.add(new Date(Integer.parseInt(year2.getSelectedItem().toString()) - 1900, month2.getSelectedIndex(), day2.getSelectedIndex()+1));
		        dates.add(new Date(Integer.parseInt(year3.getSelectedItem().toString()) - 1900, month3.getSelectedIndex(), day3.getSelectedIndex()+1));
		        dates.add(new Date(Integer.parseInt(year4.getSelectedItem().toString()) - 1900, month4.getSelectedIndex(), day4.getSelectedIndex()+1));
		        names.add(player1Name.getText());
		        names.add(player2Name.getText());
		        names.add(player3Name.getText());
		        names.add(player4Name.getText());
		        
		        ArrayList<Color> colors = new ArrayList<Color>();
		        //Player 1
		        if(color1.getSelectedItem().equals("blue")){
		        	colors.add(Color.BLUE);
		        }
		        else if(color1.getSelectedItem().equals("green")){
		        	colors.add(Color.GREEN);
		        }
		        else if(color1.getSelectedItem().equals("yellow")){
		        	colors.add(Color.YELLOW);
		        }
		        else{
		        	colors.add(Color.RED);
		        }
		        //Player 2
		        if(color2.getSelectedItem().equals("blue")){
		        	colors.add(Color.BLUE);
		        }
		        else if(color2.getSelectedItem().equals("green")){
		        	colors.add(Color.GREEN);
		        }
		        else if(color2.getSelectedItem().equals("yellow")){
		        	colors.add(Color.YELLOW);
		        }
		        else{
		        	colors.add(Color.RED);
		        }
		        //Player 3
		        if(color3.getSelectedItem().equals("blue")){
		        	colors.add(Color.BLUE);
		        }
		        else if(color3.getSelectedItem().equals("green")){
		        	colors.add(Color.GREEN);
		        }
		        else if(color3.getSelectedItem().equals("yellow")){
		        	colors.add(Color.YELLOW);
		        }
		        else{
		        	colors.add(Color.RED);
		        }
		      //Player 4
		        if(color4.getSelectedItem().equals("blue")){
		        	colors.add(Color.BLUE);
		        }
		        else if(color4.getSelectedItem() .equals("green")){
		        	colors.add(Color.GREEN);
		        }
		        else if(color4.getSelectedItem().equals("yellow")){
		        	colors.add(Color.YELLOW);
		        }
		        else{
		        	colors.add(Color.RED);
		        }
		        

				if(allUniqueColors(numOfPlayers, colors)){
			        //delete player selection
			        erase();
			        // Create game and return to main window(GUI).
			        GUI gui = new GUI();
			        gui.startGame(new RobberKnight(numOfPlayers, names, colors, dates, gui));
				}
				else{
					JOptionPane.showMessageDialog(null,
                            "Players must have different colors.",
                            "Error", JOptionPane.ERROR_MESSAGE);
				}
		    }
        });
        
        /**
         * Center panel
         */
        JPanel centerPanel = new JPanel(new GridLayout(1, 4));
        centerPanel.add(firstPanel);
        centerPanel.add(secondPanel);
        centerPanel.add(sub1);
        centerPanel.add(sub2);
        
        /**
         * South panel
         */
        startGame.setPreferredSize(new Dimension(200, 100));
        JPanel southPanel = new JPanel();
        southPanel.add(startGame);
        
        
        /**
         * Add to main panel
         */
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.add(header, BorderLayout.NORTH);
        mainPanel.add(centerPanel, BorderLayout.CENTER);
        mainPanel.add(southPanel, BorderLayout.SOUTH);
        
        
        
        /**
         * Add to frame
         */
        this.add(mainPanel);
	}
	
	private void erase(){
		this.dispose();
	}
	
	private boolean allUniqueColors(int numOfPlayers, ArrayList<Color> colors) {
		for(int i = 0; i < numOfPlayers; i++){
			for(int j = i + 1; j < numOfPlayers; j++){
				if(j != i){
					if(colors.get(i) == colors.get(j))
						return false;
				}
			}
		}
		return true;
	}
	
	/***Testing***/
	public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
              //  new PlayerSelection(new GUI());
            }
        });
	}
	/******/
}
