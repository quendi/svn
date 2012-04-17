package domain;

import java.awt.Point;

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

    public Tile(Terrain t, Building b, char l){
        terrain = t;
        building = b;
        letter = l;
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

    private void setImage(Terrain t, Building b){
        if(Terrain.Lake.equals(t)){
            this.image = new ImageIcon("resources/Lake.jpg");
        }
        else if(Terrain.Plain.equals(t)){
            if(Building.Castle.equals(b)){
                this.image = new ImageIcon("resources/Castle.jpg");
            }
            else if(Building.Village.equals(b)){
                this.image = new ImageIcon("resources/Village.jpg");
            }
            else if(Building.Town.equals(b)){
                this.image = new ImageIcon("resources/Town.jpg");
            }
            else{
                this.image = new ImageIcon("resources/Plains.jpg");
            }
        }
        else if (Terrain.Forest.equals(t)){
            if(Building.Castle.equals(b)){
                this.image = new ImageIcon("resources/ForestCastle.jpg");
            }
            else if(Building.Village.equals(b)){
                this.image = new ImageIcon("resources/ForestVillage.jpg");
            }
            else{
                this.image = new ImageIcon("resources/ForestTown.jpg");
            }

        }
        else{
            this.image = new ImageIcon("resources/Mountain.jpg");
        }

    }
}
