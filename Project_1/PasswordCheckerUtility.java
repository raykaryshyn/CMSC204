import java.util.ArrayList;

public class PasswordCheckerUtility {
    public static void comparePasswords(String password, String passwordConfirm)
        throws UnmatchedException {
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
            }
            catch (Exception e) {
                invalidPasswords.add(pwd + " " + e.getMessage());
            }
        }

        return invalidPasswords;
    }

    public static boolean hasBetweenSixAndNineChars(String password) {
        return password.length() >= 6 && password.length() <= 9;
    }

    public static boolean hasDigit(String password) {
        
    }

    public static boolean hasLowerAlpha(String password) {

    }

    public static boolean hasSameCharInSequence(String password) {

    }

    public static boolean hasSpecialChar(String password) {

    }

    public static boolean hasUpperAlpha(String password) {

    }

    public static boolean isValidLength(String password) {

    }

    public static boolean isValidPassword(String password) {
        
    }

    public static boolean isWeakPassword(String password) {

    }
}
