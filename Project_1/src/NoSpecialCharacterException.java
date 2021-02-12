package src;

/**
 * Exception for passwords that have less than one special character.
 * 
 * @author Raymond Karyshyn
 */

public class NoSpecialCharacterException extends Exception {
	public NoSpecialCharacterException() {
		super("The password must contain at least one special character");
	}

	public NoSpecialCharacterException(String message) {
		super(message);
	}
}