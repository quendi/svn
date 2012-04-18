package ui;

import javax.swing.*;
import java.awt.*;



/**
 * Created by IntelliJ IDEA.
 * User: Joe
 * Date: Apr 17, 2012
 * Time: 3:23:44 PM
 * To change this template use File | Settings | File Templates.
 */
public class TileButton extends JButton {
    // width of images used on buttons.
    private static final int BUTTON_WIDTH = 117;
    private static final int BUTTON_HEIGHT = 117;

    public TileButton(){
        super();
        this.setSize(BUTTON_WIDTH, BUTTON_HEIGHT);
    }

    public void paintComponent(Graphics g) {
       super.paintComponent(g);
    }
}

