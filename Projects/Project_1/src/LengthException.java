package src;

/**
 * Exception for passwords that are less than 6 characters in length.
 * 
 * @author Raymond Karyshyn
 */

@SuppressWarnings("serial")
public class LengthException extends Exception {
	public LengthException() {
		super("The password must be at least 6 characters long");
	}

	public LengthException(String message) {
		super(message);
	}
}