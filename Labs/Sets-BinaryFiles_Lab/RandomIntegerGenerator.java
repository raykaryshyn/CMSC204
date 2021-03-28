import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

public class RandomIntegerGenerator {
    public static void main(String[] args) {
        int[] randomIntegers = generateRandomIntegers(50000, 1000, 9999, "ascii.txt", "binary.dat");
        boolean success = checkBinaryFile("binary.dat", randomIntegers);

        System.out.println(success);
    }

    public static int[] generateRandomIntegers(int size, int min, int max, String fileName_ascii,
            String fileName_binary) {
        int[] result = new int[size];
        Random random = new Random();

        for (int i = 0; i < result.length; i++)
            result[i] = random.nextInt((max - min) + 1) + min;

        // Write to the ASCII File
        boolean fileOpened_ascii = true;
        PrintWriter toFile_ascii = null;

        try {
            toFile_ascii = new PrintWriter(fileName_ascii);
        } catch (FileNotFoundException e) {
            fileOpened_ascii = false;
        }

        if (fileOpened_ascii) {
            for (int counter = 0; counter < result.length; counter++) {
                int line = result[counter];
                toFile_ascii.println(line);
            }

            toFile_ascii.close();
        }

        // Write to binary file
        // int resultCode = 0;
        Random generator = new Random();
        DataOutputStream toFile_binary = null;
        try {
            FileOutputStream fos = new FileOutputStream(fileName_binary);
            toFile_binary = new DataOutputStream(fos);

            for (int counter = 0; counter < result.length; counter++) {
                toFile_binary.writeInt(generator.nextInt());
            } // end for
        } catch (FileNotFoundException e) {
            // resultCode = 1; // Error opening file
        } catch (IOException e) {
            // resultCode = 2; // Error writing file
        } finally {
            try {
                if (toFile_binary != null)
                    toFile_binary.close();
            } catch (IOException e) {
                // resultCode = 3; // Error closing file
            }
            // return resultCode;
        }

        return result;
    }

    public static boolean checkBinaryFile(String fileName, int[] randomIntegers) {
        boolean result = false;

        int resultCode = 0;
        DataInputStream fromFile = null;
        try {
            FileInputStream fis = new FileInputStream(fileName);
            fromFile = new DataInputStream(fis);

            while (true) {
                int number = fromFile.readInt();
                System.out.println(number);
            } // end while
        } catch (FileNotFoundException e) {
            resultCode = 1; // Error opening file
        } catch (EOFException e) {
            // Normal occurrence since entire file is read; ignore exception
        } catch (IOException e) {
            resultCode = 2; // Error reading file
        } finally {
            try {
                if (fromFile != null)
                    fromFile.close();
            } catch (IOException e) {
                resultCode = 3; // Error closing file
            }
            // return resultCode;
        }

        return result;
    }
}