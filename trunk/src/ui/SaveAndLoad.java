package ui;

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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

@SuppressWarnings("serial")
public class SaveAndLoad extends JMenu{

	static RobberKnight game = new RobberKnight(0, null, null, null);
	private int loadNum = 0;
	JMenuItem saveGame = new JMenuItem("Save");
	JMenu loadGame = new JMenu("Load");
	ArrayList<String> loadNames = new ArrayList<String>();
		
	@SuppressWarnings("static-access")
	public SaveAndLoad(RobberKnight game){
		this.setText("Game");
		this.add(new JMenuItem("Restart"));//TODO
		/**
		 * Save game
		 */
		this.game = game;
		startSave();
		
		/**
		 * Load game
		 */

		startLoad();
		
	}
	
	public void startLoad(){
		
		getAvailableLoads("LoadNames.txt");
		
		/**
		 * Add load items to menu
		 */
		for(int i = 0; i < loadNum; i++){
			final JMenuItem addMenus = new JMenuItem();
			
			addMenus.setText(loadNames.get(i));//TODO Get what states are available
			//Add response
			addMenus.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					loadGame(addMenus.getText());
				}
	        });
			loadGame.add(addMenus);
		}
		loadGame("SaveGame");
		this.add(loadGame);
	}
	
	public void startSave(){
		writeName("LoadNames.txt", "hi");
		writeName("LoadNames.txt", "no");
		saveGame("SaveGame");
		this.add(saveGame);//TODO
	}
	
	
	
	
    public static void saveGame(String filename)
    {
    	filename = filename + ".ser";
    	GameState gs = new GameState();
    	gs.game = game;
    	try
    	{ 
    		FileOutputStream fileOut = new FileOutputStream(filename);
    		ObjectOutputStream out = new ObjectOutputStream(fileOut);
    		out.writeObject(gs);
    		out.close();
    		fileOut.close();
    	}catch(IOException i)
    	{
    		i.printStackTrace();
    	}
    }
    
    public static void loadGame (String filename)
    {
    	filename = filename + ".ser";
    	GameState gs = null;
    	try
    	{
    		FileInputStream fileIn = new FileInputStream(filename);
    		ObjectInputStream in = new ObjectInputStream(fileIn);
    		gs = (GameState) in.readObject();
    		in.close();
    		fileIn.close();
    	}catch(IOException i)
    	{
    		i.printStackTrace();
    		return;
    	}catch(ClassNotFoundException c)
    	{
    		System.out.println("GameState class not found");
    		c.printStackTrace();
    		return;
    	}
    	game = gs.game;
	}
    
    public void getAvailableLoads(String filename){

    	try {
			Scanner in = new Scanner(new File(filename));
			loadNames.addAll(Arrays.asList(in.nextLine().split("\\s+")));


		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

    }
    
    
    public void writeName(String filename, String loadName){
    		  Writer output = null;
    		  try {
        		  File file = new File(filename);
        		  output = new BufferedWriter(new FileWriter(file));
        		  System.out.print(loadNames.size());
        		  for(int i = 0; i < loadNames.size(); i++){
        			  output.append(loadNames.get(i));
        		  }
        		  if(loadNum == 0)
        			  output.write(loadName);
        		  else
        			  output.append(" " + loadName);
	    		  output.close();
			} catch (IOException e){
				e.printStackTrace();
			}
    		  loadNum++;
    }
	
}
