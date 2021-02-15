package src;

import java.util.ArrayList;
import java.util.regex.*;

/**
 * PasswordCheckerUtility returns validity status of provided passwords.
 * 
 * @author Raymond Karyshyn
 */
public class PasswordCheckerUtility {
    /**
     * Compare equality of two passwords
     * 
     * @param password        password string to be checked for
     * @param passwordConfirm passwordConfirm string to be checked against password
     *                        for
     * @throws UnmatchedException thrown if not same (case sensitive)
     */
    public static void comparePasswords(String password, String passwordConfirm) throws UnmatchedException {
        if (!comparePasswordsWithReturn(password, passwordConfirm))
            throw new UnmatchedException();
    }

    /**
     * Compare equality of two passwords
     * 
     * @param password        password string to be checked for
     * @param passwordConfirm passwordConfirm string to be checked against password
     *                        for
     * @return true if both same (case sensitive)
     */
    public static boolean comparePasswordsWithReturn(String password, String passwordConfirm) {
        return passwordConfirm.equals(password);
    }

    /**
     * Reads a file of passwords and the passwords that failed the check will be
     * added to an invalidPasswords with the reason
     * 
     * @param passwords list of passwords read from a file
     * @return ArrayList of invalid passwords in the correct format
     */
    public static ArrayList<String> getInvalidPasswords(ArrayList<String> passwords) {
        ArrayList<String> invalidPasswords = new ArrayList<String>();

        String pwd;
        for (int i = 0; i < passwords.size(); i++) {
            pwd = passwords.get(i);

            try {
                isValidPassword(pwd);
            } catch (Exception e) {
                invalidPasswords.add(pwd + " -> " + e.getMessage());
            }
        }

        return invalidPasswords;
    }

    /**
     * Weak password length check - Password contains 6 to 9 characters, still
     * considers valid, just weak
     * 
     * @param password password string to be checked for Sequence requirement
     * @return true if password contains 6 to 9 characters
     */
    public static boolean hasBetweenSixAndNineChars(String password) {
        return password.length() >= 6 && password.length() <= 9;
    }

    /**
     * Checks the password Digit requirement - Password must contain a numeric
     * character
     * 
     * @param password password string to be checked for Digit requirement
     * @return true if meet Digit requirement
     * @throws NoDigitException thrown if does not meet Digit requirement
     */
    public static boolean hasDigit(String password) throws NoDigitException {
        Pattern pattern = Pattern.compile("[\\d]");
        Matcher matcher = pattern.matcher(password);

        if (!matcher.find())
            throw new NoDigitException();

        return true;
    }

    /**
     * Checks the password lowercase requirement - Password must contain a lowercase
     * alpha character
     * 
     * @param password password string to be checked for lowercase requirement
     * @return true if meet lowercase requirement
     * @throws NoLowerAlphaException thrown if does not meet lowercase requirement
     */
    public static boolean hasLowerAlpha(String password) throws NoLowerAlphaException {
        Pattern pattern = Pattern.compile("[a-z]");
        Matcher matcher = pattern.matcher(password);

        if (!matcher.find())
            throw new NoLowerAlphaException();

        return true;
    }

    /**
     * Checks the password Sequence requirement - Password should not contain more
     * than 2 of the same character in sequence
     * 
     * @param password password string to be checked for Sequence requirement
     * @return false if does NOT meet Sequence requirement
     * @throws InvalidSequenceException thrown if does not meet Sequence requirement
     */
    public static boolean hasSameCharInSequence(String password) throws InvalidSequenceException {
        Pattern pattern = Pattern.compile("(.)\\1{2}");
        Matcher matcher = pattern.matcher(password);

        if (matcher.find())
            throw new InvalidSequenceException();

        return true;
    }

    /**
     * Checks the password SpecialCharacter requirement - Password must contain a
     * Special Character
     * 
     * @param password password string to be checked for SpecialCharacter
     *                 requirement
     * @return true if meet SpecialCharacter requirement
     * @throws NoSpecialCharacterException thrown if does not meet SpecialCharacter
     *                                     requirement
     */
    public static boolean hasSpecialChar(String password) throws NoSpecialCharacterException {
        Pattern pattern = Pattern.compile("[\\W]");
        Matcher matcher = pattern.matcher(password);

        if (!matcher.find())
            throw new NoSpecialCharacterException();

        return true;
    }

    /**
     * Checks the password alpha character requirement - Password must contain an
     * uppercase alpha character
     * 
     * @param password password string to be checked for alpha character requirement
     * @return true if meet alpha character requirement
     * @throws NoUpperAlphaException thrown if does not meet alpha character
     *                               requirement
     */
    public static boolean hasUpperAlpha(String password) throws NoUpperAlphaException {
        Pattern pattern = Pattern.compile("[A-Z]+");
        Matcher matcher = pattern.matcher(password);

        if (!matcher.find())
            throw new NoUpperAlphaException();

        return true;
    }

    /**
     * Checks the password length requirement - The password must be at least 6
     * characters long
     * 
     * @param password password string to be checked for length
     * @return true if meet min length requirement
     * @throws LengthException thrown if does not meet min length requirement
     */
    public static boolean isValidLength(String password) throws LengthException {
        if (password.length() < 6)
            throw new LengthException();

        return true;
    }

    /**
     * Return true if valid password (follows all rules from above), returns false
     * if an invalid password
     * 
     * @param password string to be checked for validity
     * @return true if valid password (follows all rules from above), false if an
     *         invalid password
     * @throws LengthException             thrown if length is less than 6
     *                                     characters
     * @throws NoUpperAlphaException       thrown if no uppercase alphabetic
     * @throws NoLowerAlphaException       thrown if no lowercase alphabetic
     * @throws NoDigitException            thrown if no digit
     * @throws NoSpecialCharacterException thrown if does not meet SpecialCharacter
     *                                     requirement
     * @throws InvalidSequenceException    thrown if more than 2 of same character
     */
    public static boolean isValidPassword(String password) throws LengthException, NoUpperAlphaException,
            NoLowerAlphaException, NoDigitException, NoSpecialCharacterException, InvalidSequenceException {
        if (!isValidLength(password))
            throw new LengthException();

        if (!hasUpperAlpha(password))
            throw new NoUpperAlphaException();

        if (!hasLowerAlpha(password))
            throw new NoLowerAlphaException();

        if (!hasDigit(password))
            throw new NoDigitException();

        if (!hasSpecialChar(password))
            throw new NoSpecialCharacterException();

        if (!hasSameCharInSequence(password))
            throw new InvalidSequenceException();

        return true;
    }

    /**
     * Checks if password is valid but between 6-9 characters
     * 
     * @param password string to be checked if weak password
     * @return true if length of password is between 6 and 9 (inclusive)
     * @throws WeakPasswordException thrown if length between password is 6 and 9
     *                               characters (inclusive)
     */
    public static boolean isWeakPassword(String password) throws WeakPasswordException {
        if (hasBetweenSixAndNineChars(password))
            throw new WeakPasswordException();

        return false;
    }
}
