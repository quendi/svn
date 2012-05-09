package domain;

/**
 * User: Joe
 * Date: Apr 19, 2012
 */
public interface TurnListener {
    public void playerTurn(Player currentPlayer);
    public void endGame();
    public void endKnightMovement();
    public void skipTurn();
    public void endTurn();

}
