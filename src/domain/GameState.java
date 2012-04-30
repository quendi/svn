package domain;

import java.io.Serializable;

// To be used for saving/loading of game.

@SuppressWarnings("serial")
public class GameState implements Serializable {
	public RobberKnight game;
	public GameState(RobberKnight g){
		game = g;
	}
}
