/**
 * Exception to be thrown when trying to add an InitBlock to an InitList containing a block of equal value.
 * This exception exists because behavior of such an event will differ depending on the application.
 * @author Josh Wright
 */

package inittracker;

public class EqualInitsException extends RuntimeException {
    public EqualInitsException() {
        super("Unhandled initiative equality");
    }
    public EqualInitsException(String s) {
        super(s);
    }
}
