import java.util.TreeSet;
import java.util.Scanner;
import java.util.Set;
import java.io.File;
import java.io.FileNotFoundException;

/**
 * Uses a data structure from the Java Standard Library, TreeSet, to implement a
 * small program that processes any text file and displays all of the unique
 * words of the file in ascending order.
 * 
 * @author Raymond Karyshyn
 */
public class UniqueWords {
    public static void main(String[] args) {
        String fileName = "quotes_BobRoss.txt";

        // Use TreeSet to store words in alphabetical order
        Set<String> treeSet = new TreeSet<>();

        // Add all words in the file to treeSet
        try {
            Scanner fileData = new Scanner(new File(fileName));

            while (fileData.hasNext()) {
                // Get next word
                String word = fileData.next();

                // Strip all punctuation except for apostrophes (\u0027)
                word = word.replaceAll("[\\p{P}&&[^\u0027]]", "").toLowerCase();

                // Capitalize first letter
                word = word.substring(0, 1).toUpperCase() + word.substring(1);

                // Add word to treeSet (only if word doesn't already exist in the treeSet)
                treeSet.add(word);
            }

            fileData.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error opening file named '" + fileName + "'");
        }

        // Print unique words in the file
        System.out.println("Unique words in '" + fileName + "':");
        for (String str : treeSet)
            System.out.println("\t" + str);
    }
}
