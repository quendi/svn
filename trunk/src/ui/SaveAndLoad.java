package ui;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;

@SuppressWarnings("serial")
public class SaveAndLoad extends JMenu{

	static RobberKnight game = new RobberKnight(0, null, null, null);
	JMenuItem saveGame = new JMenuItem("Save");
	JMenu loadGame = new JMenu("Load");
	ArrayList<String> loadNames = new ArrayList<String>();
	JFrame saveFrame = new JFrame("Save Game");
	JPanel savePanel = new JPanel(new GridLayout(1,3));
	JTextArea textArea = new JTextArea("Date");
	JButton cancel = new JButton("Cancel");
	JButton ok = new JButton("OK");
	JMenuItem deleteAll = new JMenuItem("Delete All Saves");
	int i = 0;
		
	@SuppressWarnings("static-access")
	public SaveAndLoad(RobberKnight game){
		this.setText("Game");
		this.add(new JMenuItem("Restart"));//TODO

		this.game = game;
		
		saveGame.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0){
				createSaveFrame();
			}
		});
		
		//startLoad();
		
		deleteAll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					new FileOutputStream("LoadNames.txt").close();
				}catch (Exception e) {
					e.printStackTrace();
				}
				refresh();
			}
        });
		this.add(saveGame);
		this.add(loadGame);
		this.add(deleteAll);

	}
	private void refresh(){
		loadGame.removeAll();
		//getAvailableLoads("LoadNames.txt");
	}
	
	public void startLoad(){
		
		getAvailableLoads("LoadNames.txt");
		
		/**
		 * Add load items to menu
		 */
		for(int i = 0; i < loadNames.size(); i++){
			final JMenuItem addMenus = new JMenuItem();
			addMenus.setText(loadNames.get(i));
			addMenus.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					loadGame(addMenus.getText());
				}
	        });
			loadGame.add(addMenus);
		}
	}
	

	
	
	
	
    public static void saveGame (String filename){
    	filename = filename + ".ser";
    	GameState gs = new GameState(game);
    	
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        try {
	        ObjectOutputStream oos = new ObjectOutputStream(out);
	        oos.writeObject(gs);
			oos.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        System.out.println("Saving game");
        System.out.println(out.toByteArray().length > 0);
    	
    	/*try{ 
    		FileOutputStream fileOut = new FileOutputStream(filename);
    		ObjectOutputStream out = new ObjectOutputStream(fileOut);
    		out.writeObject(gs);
    		out.close();
    		fileOut.close();
    	}catch(IOException i){
    		i.printStackTrace();
    	}*/
    }
    
    public static void loadGame(String filename){
    	GUI gui = new GUI();
    	game = readFile(filename);
    	//System.out.println(game);
    	gui.loadGame(game);
    }
    
    public static RobberKnight readFile(String filename){
    	filename = filename + ".ser";
    	GameState gs = null;
    	try{
    		FileInputStream fileIn = new FileInputStream(filename);
    		ObjectInputStream in = new ObjectInputStream(fileIn);
    		gs = (GameState) in.readObject();
    		in.close();
    		fileIn.close();
    	}catch(IOException i){
    		i.printStackTrace();
    		return null;
    	}catch(ClassNotFoundException c){
    		System.out.println("GameState class not found");
    		c.printStackTrace();
    		return null;
    	}
    	System.out.println(gs.game);
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
    
    
    public void writeName(String filename, String loadName){
    	Writer output = null;
    	try {
        	output = new BufferedWriter(new FileWriter(new File(filename), true));
        	output.append(loadName + " ");
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

		//textArea.setText((new Date()).toString());//FIX SO YOU CAN SAVE AS A DATE...
		
		cancel.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0){
				saveFrame.dispose();
			}
		});
		if(i == 0){
			ok.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent arg0){
					saveGame(textArea.getText());
					writeName("LoadNames.txt", textArea.getText());
					saveFrame.dispose();
					refresh();
					startLoad();
					i = 1;
				}
			});
		}

		savePanel.add(textArea);
		savePanel.add(cancel);
		savePanel.add(ok);
		saveFrame.add(savePanel);
    }
	
}
