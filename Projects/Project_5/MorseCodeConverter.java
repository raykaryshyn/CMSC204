import java.io.File;
import java.io.FileNotFoundException;

public class MorseCodeConverter {
    public MorseCodeConverter() {

    }

    /**
     * returns a string with all the data in the tree in LNR order with an space in
     * between them. Uses the toArrayList method in MorseCodeTree It should return
     * the data in this order:
     * 
     * "h s v i f u e l r a p w j b d x n c k y t z g q m o"
     * 
     * Note the extra space between j and b - that is because there is an empty
     * string that is the root, and in the LNR traversal, the root would come
     * between the right most child of the left tree (j) and the left most child of
     * the right tree (b). This is used for testing purposes to make sure the
     * MorseCodeTree has been built properly
     * 
     * @return the data in the tree in LNR order separated by a space.
     */
    public static String printTree() {
        return "";
    }

    /**
     * Converts Morse code into English. Each letter is delimited by a space (‘ ‘).
     * Each word is delimited by a ‘/’.
     * 
     * Example:
     * 
     * code = ".... . .-.. .-.. --- / .-- --- .-. .-.. -.."
     * 
     * string returned = "Hello World"
     * 
     * @param code the morse code
     * @return the English translation
     */
    public static String convertToEnglish(String code) {
        return "";
    }

    /**
     * Converts a file of Morse code into English Each letter is delimited by a
     * space (‘ ‘). Each word is delimited by a ‘/’.
     * 
     * Example:
     * 
     * a file that contains ".... . .-.. .-.. --- / .-- --- .-. .-.. -.."
     * 
     * string returned = "Hello World"
     * 
     * @param codeFile name of the File that contains Morse Code
     * @return the English translation of the file
     * @throws FileNotFoundException if file cannot to be opened
     */
    public static String convertToEnglish(File codeFile) throws FileNotFoundException {
        return "";
    }
}
