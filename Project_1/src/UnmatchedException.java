package src;

/**
 * Exception for a pair of passwords that do not match.
 * 
 * @author Raymond Karyshyn
 */

public class UnmatchedException extends Exception {
	public UnmatchedException() {
		super("The passwords do not match");
	}

	public UnmatchedException(String message) {
		super(message);
	}
}
