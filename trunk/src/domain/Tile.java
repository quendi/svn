package domain;

import domain.enums.*;

public class Tile {
	private Terrain  terrain;
	private Building building;
	private char 	 Letter;
	private int 	 NumKnights=0;
	public  Color 	 TopKnight;
	
	public Tile(Terrain t, Building b){
		terrain=t;
		building=b;
	}
	
	void AddKnight(){
		NumKnights++;
	}
	
	void RemoveKnight(){
		NumKnights--;
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
        return Letter;
    }

    public void setLetter(char letter) {
        Letter = letter;
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
}
