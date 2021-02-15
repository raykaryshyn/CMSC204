/**
 * Exception occurs when an enqueue method is called on a full queue.
 * 
 * @author Raymond Karyshyn
 */

@SuppressWarnings("serial")
public class QueueOverflowException extends RuntimeException {
    public QueueOverflowException() {
        super("An enqueue method was called on a full queue.");
    }

    public QueueOverflowException(String message) {
        super(message);
    }
}
