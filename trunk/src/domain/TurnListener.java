package domain;

/**
 * Created by IntelliJ IDEA.
 * User: Joe
 * Date: Apr 19, 2012
 * Time: 9:56:46 AM
 * To change this template use File | Settings | File Templates.
 */
public interface TurnListener {
    public void playerTurn(Player currentPlayer);
    public void endGame();
    public void endKnightMovement();
    public void endTurn();

}
