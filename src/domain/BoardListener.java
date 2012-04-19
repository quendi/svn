package domain;

import java.awt.*;


public interface BoardListener {
    // JAVA did this ... IDK what it means
	public static final long serialVersionUID = 1L;

	public void placedTile(Tile t);

    public void placedKnight(Tile t, int numKnights, Color playerColor);
}
