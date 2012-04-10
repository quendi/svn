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
}
