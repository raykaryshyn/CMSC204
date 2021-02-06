/**
 * Exception for passwords that are valid, but have less than 10 characters.
 * 
 * @author Raymond Karyshyn
 */

public class WeakPasswordException extends Exception {

	public WeakPasswordException() {
		super("The password is OK but weak - it contains fewer than 10 characters");
	}

	public WeakPasswordException(String message) {
		super(message);
	}
}