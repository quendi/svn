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
       /** Color color;
        try {
            Field field = Color.class.getField(c.toString());
            color = (Color)field.get(null);
        } catch (Exception e) {
            color = null; // Not defined
        }
        return color;*/
    	if(c == domain.enums.Color.RED){
    		return new java.awt.Color(255, 163, 163);
    	}
    	if(c == domain.enums.Color.GREEN){
    		return new java.awt.Color(163, 255, 163);
    	}
    	if(c == domain.enums.Color.BLUE){
    		return new java.awt.Color(163, 209, 255);
    	}
    	if(c == domain.enums.Color.YELLOW){
    		return new java.awt.Color(255, 255, 163);
    	}
    	return new java.awt.Color(0, 0, 255);

    }
    /**
     * Parse string into date.
     * @param month
     * @param day
     * @param year
     * @return
     */
    public static Date parseDate(String month, String day, String year) throws ParseException {

        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
        Date date = sdf.parse(month + "/" + day + "/" + year);
        return date;
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

//    public static Tile getTileLocation(Point p, Board b){
//
//        for(int i = 0; i < b.getSize(); i++){
//            for (int j = 0; j < b.getSize(); j++){
//
//            }
//        }
//    }
}
