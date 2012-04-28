package ui;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.swing.*;

import domain.GameState;
import domain.RobberKnight;

@SuppressWarnings("serial")
public class SaveAndLoad extends JMenu{

	static RobberKnight game = new RobberKnight(0, null, null, null);
	private int loadNum = 0;
	JMenuItem saveGame = new JMenuItem("Save");
	JMenu loadGame = new JMenu("Load");
		
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
		/**
		 * Add load items to menu
		 */

		for(int i = 0; i < loadNum; i++){
			final JMenuItem addMenus = new JMenuItem();
			
			addMenus.setText("");//TODO Get what states are available
			
			//Add response
			addMenus.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					loadGame(addMenus.getText());
				}
	        });
		}
		this.add(loadGame);
	}
	
	public void startSave(){
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
    
    public String getAvailableLoads(String filename){
    	return null; //TODO
    }
	
}
