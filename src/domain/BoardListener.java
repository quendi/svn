package domain;

import java.awt.*;


public interface BoardListener {
	public void placedTile(Tile t);
    public void placedCastle(Tile castle);
	// while shift, remove the icon of the tile which has been set to null
	public void removedTile(boolean x_end, boolean y_end);
    public void placedKnight(Tile t, int numKnights, Color playerColor);
    public void movedKnight(Tile start, int numKnights, Tile destination, int knights, Color color);
}
