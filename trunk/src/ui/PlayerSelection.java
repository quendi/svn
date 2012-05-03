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

    private JTextArea player1Name = new JTextArea("Player 1");
	private JTextArea player2Name = new JTextArea("Player 2");
	private JTextArea player3Name = new JTextArea("Player 3");
	private JTextArea player4Name = new JTextArea("Player 4");

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
        firstPanel.add(player1Name);
        firstPanel.add(new JLabel("Blue", JLabel.CENTER));//TODO - add jcombobox and give an option to the player
        JLabel birthday1 = new JLabel("Enter Birthday:", JLabel.CENTER);
        birthday1.setFont(font2);
        firstPanel.add(birthday1);
        JPanel birthdayPanel1 = new JPanel();
        birthdayPanel1.add(month1);
        birthdayPanel1.add(day1);
        birthdayPanel1.add(year1);
        firstPanel.add(birthdayPanel1);
        
        //Second Panel
        player2Name.setFont(font2);
        JPanel secondPanel = new JPanel(new GridLayout(4, 1));
        secondPanel.add(player2Name);
        secondPanel.add(new JLabel("Green", JLabel.CENTER));//TODO - add jcombobox and give an option to the player
        JLabel birthday2 = new JLabel("Enter Birthday:", JLabel.CENTER);
        birthday2.setFont(font2);
        secondPanel.add(birthday2);
        JPanel birthdayPanel2 = new JPanel();
        birthdayPanel2.add(month2);
        birthdayPanel2.add(day2);
        birthdayPanel2.add(year2);
        secondPanel.add(birthdayPanel2);
        
        //Third Panel
        player3Name.setFont(font2);
        JPanel thirdPanel = new JPanel(new GridLayout(4, 1));
        thirdPanel.add(player3Name);
        thirdPanel.add(new JLabel("Yellow", JLabel.CENTER));//TODO - add jcombobox and give an option to the player
        JLabel birthday3 = new JLabel("Enter Birthday:", JLabel.CENTER);
        birthday3.setFont(font2);
        thirdPanel.add(birthday3);
        JPanel birthdayPanel3 = new JPanel();
        birthdayPanel3.add(month3);
        birthdayPanel3.add(day3);
        birthdayPanel3.add(year3);
        thirdPanel.add(birthdayPanel3);
        
        //Fourth Panel
        player4Name.setFont(font2);
        JPanel fourthPanel = new JPanel(new GridLayout(4, 1));
        fourthPanel.add(player4Name);
        fourthPanel.add(new JLabel("Red", JLabel.CENTER));//TODO - add jcombobox and give an option to the player
        JLabel birthday4 = new JLabel("Enter Birthday:", JLabel.CENTER);
        birthday4.setFont(font2);
        fourthPanel.add(birthday4);
        JPanel birthdayPanel4 = new JPanel();
        birthdayPanel4.add(month4);
        birthdayPanel4.add(day4);
        birthdayPanel4.add(year4);
        fourthPanel.add(birthdayPanel4);
        
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
		        colors.add(Color.BLUE);
		        colors.add(Color.GREEN);
		        colors.add(Color.YELLOW);
		        colors.add(Color.RED);

		        //Set Player Selection to invisible
		        erase();
		        // Create game and return to main window(GUI).
		        GUI gui = new GUI();
		        gui.startGame(new RobberKnight(numOfPlayers, names, colors, dates, gui));
		        
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
		this.setVisible(false);
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
