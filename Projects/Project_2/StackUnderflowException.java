/**
 * Exception occurs when a top or pop method is called on an empty stack.
 * 
 * @author Raymond Karyshyn
 */

@SuppressWarnings("serial")
public class StackUnderflowException extends RuntimeException {
    public StackUnderflowException() {
        super("A top or pop method is called on an empty stack.");
    }

    public StackUnderflowException(String message) {
        super(message);
    }
}
