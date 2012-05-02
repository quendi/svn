package domain;

import java.awt.*;
import java.util.ArrayList;


public interface BoardListener {
	public void placedTile(Tile t, boolean sys);
    public void placedCastle(Tile castle);
	public void removedTile(boolean x_end, boolean y_end);
    public void placedKnight(Tile t, int numKnights, Color playerColor);
    public void movedKnight(Tile start, int numKnights, Tile destination, int knights, Color color);
    public void endKnightMovement();
    public void showValidLocations(ArrayList<Integer> locations);
    public void showValidLocations(ArrayList<Integer> locations, Tile castle);
}
