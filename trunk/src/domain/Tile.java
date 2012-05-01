package domain;

import java.awt.Point;
import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;

import domain.enums.*;

import javax.swing.*;

public class Tile implements Serializable{
    private Terrain  terrain;
    private Building building;
    private char 	 letter;
    private Point	 location;
    private ImageIcon image;
    private ImageIcon back;
    private int minimumKnights;
    public ArrayList<Color> knights = new ArrayList<Color>();

    public Tile(Terrain t, Building b, char l, Color color){
        terrain = t;
        building = b;
        letter = l;
        minimumKnights = t.getKnightRestriction();
        knights = new ArrayList<Color>();
        setImage(t,b);
        setBack(l, color);
    }

    void AddKnight(Color c){
    	knights.add(c);
    }

    void AddKnights(int n, Color c){
       	for(int i = 0; i < n; i++){
        	knights.add(c);
    	}
    }

    void RemoveKnight(){
    	knights.remove(knights.size()-1);
    }

    void RemoveKnights(int n){
    	for(int i = 0; i < n; i++){
    		knights.remove(knights.size()-1);
    	}
    }

    public Terrain getTerrain() {
        return terrain;
    }

    public Building getBuilding() {
        return building;
    }

    public char getLetter() {
        return letter;
    }

    public int getNumKnights() {
        return knights.size();
    }

    public Color getTopKnight() {
        return knights.get(knights.size()-1);
    }
    
    public void setLocation(Point p){
        location=p;
    }

    public Point getLocation() {
        return location;
    }

    public ImageIcon getImage() {
        return image;
    }

    public void setImage(ImageIcon image) {
        this.image = image;
    }
    
    public ImageIcon getBack() {
        return back;
    }
    
    public int getMinimumKnights() {
        return minimumKnights;
    }

    public void setMinimumKnights(int minimumKnights) {
        this.minimumKnights = minimumKnights;
    }

    private void setImage(Terrain t, Building b){
        String separator = File.separator;
        if(Terrain.Lake.equals(t)){
            this.image = new ImageIcon("resources" + separator + "Lake small.jpg");
        }
        else if(Terrain.Plain.equals(t)){
            if(Building.Castle.equals(b)){
                this.image = new ImageIcon("resources" + separator + "Plains Castle small.jpg");
            }
            else if(Building.Village.equals(b)){
                this.image = new ImageIcon("resources" + separator + "Plains Village small.jpg");
            }
            else if(Building.Town.equals(b)){
                this.image = new ImageIcon("resources" + separator + "Plains Town small.jpg");
            }
            else{
                this.image = new ImageIcon("resources" + separator + "Plains small.jpg");
            }
        }
        else if (Terrain.Forest.equals(t)){
            if(Building.Castle.equals(b)){
                this.image = new ImageIcon("resources" + separator + "Forested Castle small.jpg");
            }
            else if(Building.Village.equals(b)){
                this.image = new ImageIcon("resources" + separator + "Forested Village small.jpg");
            }
            else{
                this.image = new ImageIcon("resources" + separator + "Forested Town small.jpg");
            }

        }
        else{
            this.image = new ImageIcon("resources" + separator + "Mountains small.jpg");
        }
    }
    
    private void setBack(char letter, Color color){
    	String separator = File.separator;
    	
    	if( color == Color.BLUE ){
    		if( letter == 'A')
    			this.back = new ImageIcon("resources" + separator + "blue A small.jpg");
    		if( letter == 'B')
    			this.back = new ImageIcon("resources" + separator + "blue B small.jpg");
    		if( letter == 'C')
    			this.back = new ImageIcon("resources" + separator + "blue C small.jpg");
    		if( letter == 'D')
    			this.back = new ImageIcon("resources" + separator + "blue D small.jpg");
    		if( letter == 'E')
    			this.back = new ImageIcon("resources" + separator + "blue E small.jpg");
    	}
    	else if( color == Color.GREEN ){
    		if( letter == 'A')
    			this.back = new ImageIcon("resources" + separator + "green A small.jpg");
    		if( letter == 'B')
    			this.back = new ImageIcon("resources" + separator + "green B small.jpg");
    		if( letter == 'C')
    			this.back = new ImageIcon("resources" + separator + "green C small.jpg");
    		if( letter == 'D')
    			this.back = new ImageIcon("resources" + separator + "green D small.jpg");
    		if( letter == 'E')
    			this.back = new ImageIcon("resources" + separator + "green E small.jpg");
    	}
    	else if( color == Color.RED ){
    		if( letter == 'A')
    			this.back = new ImageIcon("resources" + separator + "red A small.jpg");
    		if( letter == 'B')
    			this.back = new ImageIcon("resources" + separator + "red B small.jpg");
    		if( letter == 'C')
    			this.back = new ImageIcon("resources" + separator + "red C small.jpg");
    		if( letter == 'D')
    			this.back = new ImageIcon("resources" + separator + "red D small.jpg");
    		if( letter == 'E')
    			this.back = new ImageIcon("resources" + separator + "red E small.jpg");
    	}
    	else if( color == Color.YELLOW ){
    		if( letter == 'A')
    			this.back = new ImageIcon("resources" + separator + "yellow A small.jpg");
    		if( letter == 'B')
    			this.back = new ImageIcon("resources" + separator + "yellow B small.jpg");
    		if( letter == 'C')
    			this.back = new ImageIcon("resources" + separator + "yellow C small.jpg");
    		if( letter == 'D')
    			this.back = new ImageIcon("resources" + separator + "yellow D small.jpg");
    		if( letter == 'E')
    			this.back = new ImageIcon("resources" + separator + "yellow E small.jpg");
    	}
 
    }
}
