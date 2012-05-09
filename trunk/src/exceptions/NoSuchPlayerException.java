package exceptions;

/**
 * User: Joe
 * Date: Apr 10, 2012
 */
@SuppressWarnings("serial")
public class NoSuchPlayerException extends Exception {

    public NoSuchPlayerException(String message){
        super(message);
    }

    public String toString(){
        return "NoSuchPlayerException";
    }
}
