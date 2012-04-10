package domain;

import domain.enums.*;

public class Tile {
	private int 	Terrain;
	private int 	Building;
	private char 	Letter;
	private int 	NumKnights=0;
	public  Color 	TopKnight;
	
	void AddKnight(){
		NumKnights++;
	}
	
	void RemoveKnight(){
		NumKnights--;
	}

    public int getTerrain() {
        return Terrain;
    }

    public void setTerrain(int terrain) {
        Terrain = terrain;
    }

    public int getBuilding() {
        return Building;
    }

    public void setBuilding(int building) {
        Building = building;
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
