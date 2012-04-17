package exceptions;

/**
 * Created by IntelliJ IDEA.
 * User: Joe
 * Date: Apr 10, 2012
 * Time: 7:55:31 PM
 * To change this template use File | Settings | File Templates.
 */
public class NoSuchPlayerException extends Exception {

    public NoSuchPlayerException(String message){
        super(message);
    }

    public String toString(){
        return "NoSuchPlayerException";
    }
}
