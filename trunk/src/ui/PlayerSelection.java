package ui;

import domain.RobberKnight;
import domain.enums.Color;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.*;

import domain.RobberKnight;
import domain.enums.Color;

@SuppressWarnings("serial")
public class PlayerSelection extends JFrame{

	private JPanel mainPanel = new JPanel(new BorderLayout());
	/**
	 * North panel
	 */
	private JLabel header = new JLabel("Player Selection", JLabel.CENTER);
	/**
	 * Center panel
	 */
	JPanel centerPanel = new JPanel(new GridLayout(1,4));
	
	JPanel firstPanel = new JPanel(new GridLayout(4,1));
	JPanel secondPanel = new JPanel(new GridLayout(4,1));
	JPanel thirdPanel = new JPanel(new GridLayout(4,1));
	JPanel fourthPanel = new JPanel(new GridLayout(4,1));
	
	JLabel player1Name = new JLabel("Player 1", JLabel.CENTER);
	JLabel player2Name = new JLabel("Player 2", JLabel.CENTER);
	JLabel player3Name = new JLabel("Player 3", JLabel.CENTER);
	JLabel player4Name = new JLabel("Player 4", JLabel.CENTER);
	
	JLabel birthday1 = new JLabel("Enter Birthday:", JLabel.CENTER);
	JLabel birthday2 = new JLabel("Enter Birthday:", JLabel.CENTER);
	JLabel birthday3 = new JLabel("Enter Birthday:", JLabel.CENTER);
	JLabel birthday4 = new JLabel("Enter Birthday:", JLabel.CENTER);
	
	String month[] = new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" };
	String day[] = new String[] { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", 
								  "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", 
								  "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" };
	String year[] = new String[] { "1950", "1951", "1952", "1953", "1954", "1955", "1956", "1957", "1958", "1959",
								   "1960", "1961", "1962", "1963", "1964", "1965", "1966", "1967", "1968", "1969",
								   "1970", "1971", "1972", "1973", "1974", "1975", "1976", "1977", "1978", "1979",
								   "1980", "1981", "1982", "1983", "1984", "1985", "1986", "1987", "1988", "1989", 
								   "1990", "1991", "1992", "1993", "1994", "1995", "1996", "1997", "1998", "1999", 
								   "2000", "2001", "2002", "2003", "2004", "2005", "2006", "2007", "2008", "2009", 
								   "2010", "2011", "2012" };
	
	
	private JPanel birthdayPanel1 = new JPanel();
	JComboBox month1 = new JComboBox(month);
	JComboBox day1 = new JComboBox(day);
	JComboBox year1 = new JComboBox(year);
	
	private JPanel birthdayPanel2 = new JPanel();
	JComboBox month2 = new JComboBox(month);
	JComboBox day2 = new JComboBox(day);
	JComboBox year2 = new JComboBox(year);
	
	private JPanel birthdayPanel3 = new JPanel();
	JComboBox month3 = new JComboBox(month);
	JComboBox day3 = new JComboBox(day);
	JComboBox year3 = new JComboBox(year);
	
	private JPanel birthdayPanel4 = new JPanel();
	JComboBox month4 = new JComboBox(month);
	JComboBox day4 = new JComboBox(day);
	JComboBox year4 = new JComboBox(year);
	
	private CardLayout cl1 = new CardLayout();
	private CardLayout cl2 = new CardLayout();
	JPanel sub1 = new JPanel(cl1);
	private JPanel sub1ButtonPanel = new JPanel(new BorderLayout());
	JPanel sub2 = new JPanel(cl2);
	private JPanel sub2ButtonPanel = new JPanel(new BorderLayout());
	JButton addPlayer3 = new JButton("Add Player");
	JButton addPlayer4 = new JButton("Add Player");

	/**
	 * South panel
	 */
	JPanel southPanel = new JPanel();
	JButton startGame = new JButton("Start Game");
	/**
	 * Other
	 */
	private int numOfPlayers = 2;
    private Font font = new Font("Serif", Font.BOLD, 34);
    private Font font2 = new Font("Serif", Font.BOLD, 20);
	
	
	public PlayerSelection(final GUI gui){
		/**
		 * Default
		 */
		this.setTitle("Player Selection");
		this.setVisible(true);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setMinimumSize(new java.awt.Dimension(1100, 500));
        header.setFont(font);
        
        /**
         * Add content to player panels
         */
        //First Panel
        player1Name.setFont(font2);
        firstPanel.add(player1Name);
        firstPanel.add(new JLabel("Blue", JLabel.CENTER));//TODO - add jcombobox and give an option to the player
        birthday1.setFont(font2);
        firstPanel.add(birthday1);
        birthdayPanel1.add(month1);
        birthdayPanel1.add(day1);
        birthdayPanel1.add(year1);
        firstPanel.add(birthdayPanel1);
        
        //Second Panel
        player2Name.setFont(font2);
        secondPanel.add(player2Name);
        secondPanel.add(new JLabel("Green", JLabel.CENTER));//TODO - add jcombobox and give an option to the player
        birthday2.setFont(font2);
        secondPanel.add(birthday2);
        birthdayPanel2.add(month2);
        birthdayPanel2.add(day2);
        birthdayPanel2.add(year2);
        secondPanel.add(birthdayPanel2);
        
        //Third Panel
        player3Name.setFont(font2);
        thirdPanel.add(player3Name);
        thirdPanel.add(new JLabel("Yellow", JLabel.CENTER));//TODO - add jcombobox and give an option to the player
        birthday3.setFont(font2);
        thirdPanel.add(birthday3);
        birthdayPanel3.add(month3);
        birthdayPanel3.add(day3);
        birthdayPanel3.add(year3);
        thirdPanel.add(birthdayPanel3);
        
        //Fourth Panel
        player4Name.setFont(font2);
        fourthPanel.add(player4Name);
        fourthPanel.add(new JLabel("Red", JLabel.CENTER));//TODO - add jcombobox and give an option to the player
        birthday4.setFont(font2);
        fourthPanel.add(birthday4);
        birthdayPanel4.add(month4);
        birthdayPanel4.add(day4);
        birthdayPanel4.add(year4);
        fourthPanel.add(birthdayPanel4);
        
        /**
         * Set up cardlayout
         */
        sub1ButtonPanel.add(addPlayer3);
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
        startGame.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent arg0) {
				ArrayList<Date> dates = new ArrayList<Date>();
		        dates.add(new Date(Integer.parseInt(year1.getSelectedItem().toString()) - 1900, month1.getSelectedIndex(), day1.getSelectedIndex()+1));
		        dates.add(new Date(Integer.parseInt(year2.getSelectedItem().toString()) - 1900, month2.getSelectedIndex(), day2.getSelectedIndex()+1));
		        dates.add(new Date(Integer.parseInt(year3.getSelectedItem().toString()) - 1900, month3.getSelectedIndex(), day3.getSelectedIndex()+1));
		        dates.add(new Date(Integer.parseInt(year4.getSelectedItem().toString()) - 1900, month4.getSelectedIndex(), day4.getSelectedIndex()+1));
		        ArrayList<Color> colors = new ArrayList<Color>();
		        colors.add(Color.BLUE);
		        colors.add(Color.GREEN);
		        colors.add(Color.YELLOW);
		        colors.add(Color.RED);

		        //Set Player Selection to invisible
		        erase();
		        // Create game and return to main window(GUI).
		        gui.startGame(new RobberKnight(numOfPlayers, colors, dates, gui));
		        
		    }
        });
        
        /**
         * Center panel
         */
        centerPanel.add(firstPanel);
        centerPanel.add(secondPanel);
        centerPanel.add(sub1);
        centerPanel.add(sub2);
        
        /**
         * South panel
         */
        startGame.setPreferredSize(new Dimension(200, 100));
        southPanel.add(startGame);
        
        
        /**
         * Add to main panel
         */
        mainPanel.add(header, BorderLayout.NORTH);
        mainPanel.add(centerPanel, BorderLayout.CENTER);
        mainPanel.add(southPanel, BorderLayout.SOUTH);
        
        
        
        /**
         * Add to frame
         */
        this.add(mainPanel);
	}
	
	private void erase(){
		this.setVisible(false);
	}
	
	/***Testing***/
	public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PlayerSelection(new GUI());
            }
        });
	}
	/******/
}
