package domain;

import java.awt.Point;
import java.io.File;
import java.util.ArrayList;

import domain.enums.*;

import javax.swing.*;

public class Tile {
    private Terrain  terrain;
    private Building building;
    private char 	 letter;
    private Point	 location;
    private ImageIcon image;
    private int minimumKnights;
    public ArrayList<Color> knights = new ArrayList<Color>();

    public Tile(Terrain t, Building b, char l){
        terrain = t;
        building = b;
        letter = l;
        minimumKnights = t.getKnightRestriction();
        knights = new ArrayList<Color>();
        setImage(t,b);
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

    public int getMinimumKnights() {
        return minimumKnights;
    }

    public void setMinimumKnights(int minimumKnights) {
        this.minimumKnights = minimumKnights;
    }

    private void setImage(Terrain t, Building b){
        String separator = File.separator;
        if(Terrain.Lake.equals(t)){
            this.image = new ImageIcon("resources" + separator + "Lake.jpg");
        }
        else if(Terrain.Plain.equals(t)){
            if(Building.Castle.equals(b)){
                this.image = new ImageIcon("resources" + separator + "Castle.jpg");
            }
            else if(Building.Village.equals(b)){
                this.image = new ImageIcon("resources" + separator + "Village.jpg");
            }
            else if(Building.Town.equals(b)){
                this.image = new ImageIcon("resources" + separator + "Town.jpg");
            }
            else{
                this.image = new ImageIcon("resources" + separator + "Plains.jpg");
            }
        }
        else if (Terrain.Forest.equals(t)){
            if(Building.Castle.equals(b)){
                this.image = new ImageIcon("resources" + separator + "ForestCastle.jpg");
            }
            else if(Building.Village.equals(b)){
                this.image = new ImageIcon("resources" + separator + "ForestVillage.jpg");
            }
            else{
                this.image = new ImageIcon("resources" + separator + "ForestTown.jpg");
            }

        }
        else{
            this.image = new ImageIcon("resources" + separator + "Mountain.jpg");
        }

    }
}
