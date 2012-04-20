package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;


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
        this.setPreferredSize(new Dimension(BUTTON_WIDTH, BUTTON_HEIGHT));
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
    }


    /**
     * setIcon that takes additional parameter to determine size of the image used.
     * @param icon - image to be placed on button
     * @param playerSize - determines how the image should be scaled
     */
    public void setIcon(ImageIcon icon, int playerSize){
        ImageIcon newIcon = scale(icon.getImage(), playerSize);
        this.setIcon(newIcon);
    }

    /**
     * Resized image based on size of board determined by the number of players.
     * @param img - image used to be resied
     * @param NumPlayers - determines board size which changes scaling factor
     * @return resized ImageIcon
     */
    private ImageIcon scale(Image img, int NumPlayers) {
        double scale = 1;
        if( NumPlayers == 2 )
            scale = 0.875;
        else if( NumPlayers == 3 )
            scale = 0.7;
        else if( NumPlayers == 4 )
            scale = 0.636;

        int width = (int)(scale*img.getWidth(this));
        int height = (int)(scale*img.getHeight(this));
        BufferedImage out_img = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics graph = out_img.createGraphics();
        graph.drawImage(img, 0, 0, width, height, null);
        graph.dispose();
        return new ImageIcon(out_img);
    }
}

