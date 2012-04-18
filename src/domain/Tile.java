package domain;

import java.awt.Point;
import java.io.File;

import domain.enums.*;

import javax.swing.*;

public class Tile {
    private Terrain  terrain;
    private Building building;
    private char 	 letter;
    private int 	 NumKnights=0;
    private Point	 location;
    public  Color 	 TopKnight;
    private ImageIcon image;
    private int minimumKnights;

    public Tile(Terrain t, Building b, char l){
        terrain = t;
        building = b;
        letter = l;
        minimumKnights = t.getKnightRestriction();
        setImage(t,b);
    }

    void AddKnight(){
        NumKnights++;
    }

    void AddKnights(int n){
        NumKnights += n;
    }

    void RemoveKnight(){
        NumKnights--;
    }

    void RemoveKnights(int n){
        NumKnights -= n;
    }

    public Terrain getTerrain() {
        return terrain;
    }

    public void setTerrain(Terrain t) {
        terrain = t;
    }

    public Building getBuilding() {
        return building;
    }

    public void setBuilding(Building b) {
        building = b;
    }

    public char getLetter() {
        return letter;
    }

    public void setLetter(char l) {
        letter = l;
    }

    public int getNumKnights() {
        return NumKnights;
    }

    public void setNumKnights(int numKnights) {
        NumKnights = numKnights;
    }

    public Color getTopKnight() {
        return TopKnight;
    }

    public void setTopKnight(Color topKnight) {
        TopKnight = topKnight;
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
            //System.out.println("WIDTH: " + this.image.getIconWidth() + " HEIGHT: " + this.image.getIconHeight());
        }

    }
}
