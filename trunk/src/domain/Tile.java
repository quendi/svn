package domain;

import java.awt.Point;

import domain.enums.*;

public class Tile {
	private Terrain  terrain;
	private Building building;
	private char 	 letter;
	private int 	 NumKnights=0;
	private Point	 location;
	public  Color 	 TopKnight;
	
	public Tile(Terrain t, Building b, char l){
		terrain = t;
		building = b;
		letter = l;
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
}
