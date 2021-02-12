package src;

/**
 * Exception for passwords that have less than one lowecase alphabetic
 * character.
 * 
 * @author Raymond Karyshyn
 */

public class NoLowerAlphaException extends Exception {
	public NoLowerAlphaException() {
		super("The password must contain at least one lowercase alphabetic character");
	}

	public NoLowerAlphaException(String message) {
		super(message);
	}
}
