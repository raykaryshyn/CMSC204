package src;

/**
 * Exception for passwords that have less than one uppercase alphabetic
 * character.
 * 
 * @author Raymond Karyshyn
 */

public class NoUpperAlphaException extends Exception {
	public NoUpperAlphaException() {
		super("The password must contain at least one uppercase alphabetic character");
	}

	public NoUpperAlphaException(String message) {
		super(message);
	}
}