package utils;

import domain.Board;
import domain.Tile;
import domain.enums.*;

import java.awt.*;
import java.awt.Color;
import java.lang.reflect.Field;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Date: 4/16/12
 */
public class GameUtils {

    public GameUtils(){}


    public static java.awt.Color getColor(domain.enums.Color c){
    	// This is for PASTEL Colors, good for BLACK writing
    	if(c == domain.enums.Color.RED){
    		return new java.awt.Color(255, 159, 148);
    	}
    	if(c == domain.enums.Color.GREEN){
    		return new java.awt.Color(191, 255, 148);
    	}
    	if(c == domain.enums.Color.BLUE){
    		return new java.awt.Color(148, 191, 255);
    	}
    	if(c == domain.enums.Color.YELLOW){
    		return new java.awt.Color(244, 255, 148);
    	}
    	return new java.awt.Color(0, 0, 0);

    }

    /**
     * Get tile's location in GUI grid.
     * @param t
     * @param boardSize
     * @return
     */
    public static int getGridLocation(Tile t, int boardSize){
        return (int) t.getLocation().getY()
                * boardSize
                + ((int) t.getLocation().getX());

    }

}
