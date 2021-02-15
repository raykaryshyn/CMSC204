/**
 * Exception occurs when a dequeue method is called on an empty queue.
 * 
 * @author Raymond Karyshyn
 */

@SuppressWarnings("serial")
public class QueueUnderflowException extends RuntimeException {
    public QueueUnderflowException() {
        super("A dequeue method was called on an empty queue.");
    }

    public QueueUnderflowException(String message) {
        super(message);
    }
}
