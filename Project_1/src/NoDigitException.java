/**
 * Exception for passwords that have less than one digit.
 * 
 * @author Raymond Karyshyn
 */

public class NoDigitException extends Exception {
    public NoDigitException() {
		super("The password must contain at least one digit");
	}

	public NoDigitException(String message) {
		super(message);
	}
}
