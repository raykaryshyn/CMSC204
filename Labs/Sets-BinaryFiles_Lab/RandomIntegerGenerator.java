import java.util.ArrayList;
import java.util.Random;

import java.io.PrintWriter;
import java.io.ObjectOutputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Implements a method, generateRandomIntegers(), to randomly generate 50000
 * integer numbers between 1000 and 9999.
 * 
 * Saves the generated numbers as a binary data file, binary.dat.
 * 
 * Saves the same generated numbers to an ASCII text file, ascii.txt.
 * 
 * Implements another method, checkBinaryFile(), to read binary.dat, which
 * ensures that the content can be read correctly.
 * 
 * @author Raymond Karyshyn
 */
public class RandomIntegerGenerator {
    public static void main(String[] args) {
        ArrayList<Integer> randomIntegers = generateRandomIntegers(50000, 1000, 9999, "ascii.txt", "binary.dat");
        boolean success = checkBinaryFile("binary.dat", randomIntegers);

        if (success)
            System.out.println("The binary file passed the test!");
        else
            System.out.println("The binary file did not pass the test.");
    }

    public static ArrayList<Integer> generateRandomIntegers(int size, int min, int max, String fileName_ascii,
            String fileName_binary) {
        ArrayList<Integer> result = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < size; i++)
            result.add(i, random.nextInt((max - min) + 1) + min);

        // Write to the ASCII File
        try {
            PrintWriter toFile_ascii = new PrintWriter(fileName_ascii);

            for (int counter = 0; counter < size; counter++)
                toFile_ascii.println(result.get(counter));

            toFile_ascii.close();
        } catch (FileNotFoundException e) {
            System.out.println(e);
        }

        // Write to binary file
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName_binary));

            oos.writeObject(result);

            oos.close();
        } catch (IOException e) {
            System.out.println(e);
        }

        return result;
    }

    @SuppressWarnings("unchecked")
    public static boolean checkBinaryFile(String fileName, ArrayList<Integer> randomIntegers) {
        ArrayList<Integer> result = new ArrayList<>();

        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName));

            result = (ArrayList<Integer>) ois.readObject();
            result.removeAll(randomIntegers);

            ois.close();
        } catch (IOException e) {
            System.out.println(e);
        } catch (ClassNotFoundException e) {
            System.out.println(e);
        }

        return result.size() == 0;
    }
}
