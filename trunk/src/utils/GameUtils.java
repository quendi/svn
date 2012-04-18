package utils;

import domain.Tile;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * User: 048661
 * Date: 4/16/12
 */
public class GameUtils {

    public GameUtils(){}


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
}
