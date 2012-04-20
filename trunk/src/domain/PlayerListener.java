package domain;

/**
 * User: Joe
 * Date: Apr 14, 2012
 * Time: 4:56:03 PM
 */
public interface PlayerListener {

    public void updateHand();
    public void updateHand(Player p);
    public void updateKnights(int numberOfKnights);
}
