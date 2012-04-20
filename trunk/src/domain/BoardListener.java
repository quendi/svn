package domain;

import java.awt.*;


public interface BoardListener {
	public void placedTile(Tile t);
	// while shift, remove the icon of the tile which has been set to null
	public void removedTile();
    public void placedKnight(Tile t, int numKnights, Color playerColor);
}
