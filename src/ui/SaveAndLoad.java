package ui;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Writer;

import javax.swing.*;

import domain.GameState;
import domain.RobberKnight;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;

@SuppressWarnings("serial")
public class SaveAndLoad extends JMenu{

	static RobberKnight game = new RobberKnight(0, null, null, null, null);
	JMenuItem saveGame = new JMenuItem("Save");
	JMenu loadGame = new JMenu("Load");
	static ArrayList<String> loadNames = new ArrayList<String>();
	JFrame saveFrame = new JFrame("Save Game");
	JPanel savePanel = new JPanel(new GridLayout(1,3));
	JTextField textArea = new JTextField();
	JButton cancel = new JButton("Cancel");
	JButton ok = new JButton("OK");
	JMenuItem deleteAll = new JMenuItem("Delete All Saves");
	static InitialScreen init;
    static GUI gui = null;
	File toDelete;
	Font font = new Font("Serif", Font.BOLD, 18);

	ActionListener okActionListener = new ActionListener(){
		public void actionPerformed(ActionEvent arg0){
			saveGame(textArea.getText());
			writeName("LoadNames.txt", textArea.getText());
			//loadGame.add(textArea.getText());
			saveFrame.dispose();
			refresh();
			startLoad();
			ok.removeActionListener(okActionListener);
		}
	};
		
	@SuppressWarnings("static-access")
	public SaveAndLoad(RobberKnight game, GUI gui, InitialScreen initialScreen, boolean inGame){
		this.init = initialScreen;
		this.gui = gui;
		this.setText("Game");
		/**
		 * Save game
		 */
		this.game = game;
		startSave();
		
		/**
		 * Load game
		 */
		startLoad();
		
		deleteAll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				for (String loadName : loadNames) {
					loadName = loadName + ".ser";
					toDelete = new File(loadName);
					toDelete.delete();
				}
				try {
					new FileOutputStream("LoadNames.txt").close();
				}catch (Exception e) {
					e.printStackTrace();
				}
				refresh();
				loadNames = new ArrayList<String>();
				startLoad();
			}
        });
		this.add(saveGame);
		this.add(loadGame);
		this.add(deleteAll);
		if(!inGame)
			saveGame.setEnabled(false);

	}
	private void refresh(){
		loadGame.removeAll();
	}


    	/**
		 * Add load items to menu
		 */
	public void startLoad(){
		getAvailableLoads("LoadNames.txt");

        for (String loadName : loadNames) {
            final JMenuItem addMenus = new JMenuItem();
            addMenus.setText(loadName);
            addMenus.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent arg0) {
                    loadGame(addMenus.getText());
                }
            });
            loadGame.add(addMenus);
        }
	}


	public void startSave(){	
		saveGame.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0){
				createSaveFrame();
			}
		});
	}

	
    public static void saveGame (String filename){
    	filename = filename + ".ser";
    	GameState gs = new GameState(game);

    	try{
    		FileOutputStream fileOut = new FileOutputStream(filename);
    		ObjectOutputStream out = new ObjectOutputStream(fileOut);
    		out.writeObject(gs);
    		out.close();
    		fileOut.close();
    	}catch(IOException i){
    		i.printStackTrace();
    	}
    }
    
    public static void loadGame(String filename){
		if(init != null)
			init.dispose();
    	game = readFile(filename);
    	if(gui == null){
    		gui = new GUI();
            gui.loadGame(game);
            gui.playBackgroundMusic();
        }
    	else 
    		gui.loadGame(game);
    }
    
    public static RobberKnight readFile(String filename){
    	filename = filename + ".ser";
    	GameState gs;
    	try{
    		FileInputStream fileIn = new FileInputStream(filename);
    		ObjectInputStream in = new ObjectInputStream(fileIn);
    		gs = (GameState) in.readObject();
    		in.close();
    		fileIn.close();
    	}catch(IOException i){
    		i.printStackTrace();
    		System.out.println("IOexeption! returning NULL");
    		return null;
    	}catch(ClassNotFoundException c){
    		System.out.println("GameState class not found");
    		c.printStackTrace();
    		return null;
    	}
    	return gs.game;
    	
	}
    
    /**
     * Set the arraylist according to the filenames inside LoadNames.txt
     * @param filename
     */
    public void getAvailableLoads(String filename){
    	loadNames = new ArrayList<String>();
    	try{
			Scanner in = new Scanner(new File(filename));
			if(in.hasNextLine())
				loadNames.addAll(Arrays.asList(in.nextLine().split("\\s+")));
		}catch (FileNotFoundException e){
			e.printStackTrace();
		}
    }
    
    
    public static void writeName(String filename, String loadName){

    	loadNames.add(loadName);
    	Writer output;
    	try {
        	output = new BufferedWriter(new FileWriter(new File(filename), true));
            //for (String loadName1 : loadNames) {
                output.append(loadName + " ");
            //}
	    	output.close();
		}catch (IOException e){
			e.printStackTrace();
		}
    }
    
    private void createSaveFrame(){
    	
		saveFrame.setVisible(true);
		saveFrame.setBounds(0, 0, 500, 100);
		saveFrame.setResizable(false);
		saveFrame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		
		DateFormat df = new SimpleDateFormat("MM-dd-yyyy_HH:mm");
		textArea.setText(df.format(new Date()));
		textArea.setPreferredSize(new Dimension(150, 25));
		textArea.setFont(font);
		cancel.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0){
				saveFrame.dispose();
			}
		});

			ok.addActionListener(okActionListener);
		JPanel panel = new JPanel();
		panel.add(textArea);
		savePanel.add(panel);
		savePanel.add(cancel);
		savePanel.add(ok);
		saveFrame.add(savePanel);
    }
    
 
	
}
