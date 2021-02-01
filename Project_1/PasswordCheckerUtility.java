import java.util.ArrayList;
import java.util.regex.*;

public class PasswordCheckerUtility {
    public static void comparePasswords(String password, String passwordConfirm) throws UnmatchedException {
        if (!comparePasswordsWithReturn(password, passwordConfirm))
            throw new UnmatchedException();
    }

    public static boolean comparePasswordsWithReturn(String password, String passwordConfirm) {
        return passwordConfirm.equals(password);
    }

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

    public static boolean hasBetweenSixAndNineChars(String password) {
        return password.length() >= 6 && password.length() <= 9;
    }

    public static boolean hasDigit(String password) throws NoDigitException {
        Pattern pattern = Pattern.compile("[\\d]");
        Matcher matcher = pattern.matcher(password);

        if (!matcher.find())
            throw new NoDigitException();

        return true;
    }

    public static boolean hasLowerAlpha(String password) throws NoLowerAlphaException {
        Pattern pattern = Pattern.compile("[a-z]");
        Matcher matcher = pattern.matcher(password);

        if (!matcher.find())
            throw new NoLowerAlphaException();

        return true;
    }

    public static boolean hasSameCharInSequence(String password) throws InvalidSequenceException {
        Pattern pattern = Pattern.compile("(.)\\1{2}");
        Matcher matcher = pattern.matcher(password);

        if (matcher.find())
            throw new InvalidSequenceException();

        return true;
    }

    public static boolean hasSpecialChar(String password) throws NoSpecialCharacterException {
        Pattern pattern = Pattern.compile("[\\W]");
        Matcher matcher = pattern.matcher(password);

        if (!matcher.find())
            throw new NoSpecialCharacterException();

        return true;
    }

    public static boolean hasUpperAlpha(String password) throws NoUpperAlphaException {
        Pattern pattern = Pattern.compile("[A-Z]+");
        Matcher matcher = pattern.matcher(password);

        if (!matcher.find())
            throw new NoUpperAlphaException();

        return true;
    }

    public static boolean isValidLength(String password) throws LengthException {
        if (password.length() < 6)
            throw new LengthException();

        return true;
    }

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

    public static boolean isWeakPassword(String password) throws WeakPasswordException {
        if (hasBetweenSixAndNineChars(password))
            throw new WeakPasswordException();

        return true;
    }
}
