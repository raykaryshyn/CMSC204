/**
 * Exception occurs when a push method is called on a full stack.
 * 
 * @author Raymond Karyshyn
 */

@SuppressWarnings("serial")
public class StackOverflowException extends RuntimeException {
    public StackOverflowException() {
        super("A push method was called on a full stack.");
    }

    public StackOverflowException(String message) {
        super(message);
    }
}
