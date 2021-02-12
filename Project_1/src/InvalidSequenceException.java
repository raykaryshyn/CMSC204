package src;

/**
 * Exception for passwords that have two or more of the same character in
 * sequence.
 * 
 * @author Raymond Karyshyn
 */

public class InvalidSequenceException extends Exception {
	public InvalidSequenceException() {
		super("The password cannot contain more than two of the same character in sequence");
	}

	public InvalidSequenceException(String message) {
		super(message);
	}
}