/**
 * Exception occurs when a Notation format is incorrect.
 * 
 * @author Raymond Karyshyn
 */

@SuppressWarnings("serial")
public class InvalidNotationFormatException extends RuntimeException {
    public InvalidNotationFormatException() {
		super("A Notation format was incorrect.");
	}

    public InvalidNotationFormatException(String message) {
		super(message);
	}
}
