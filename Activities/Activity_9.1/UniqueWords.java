import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.Map;
import java.io.File;
import java.io.FileNotFoundException;

/**
 * Scans a Java file and displays the unique keywords and their frequencies. The
 * keywords are displayed in alphabetical order which were sorted with a
 * recursive merge sort algorithm.
 * 
 * Java keywords were taken from
 * https://docs.oracle.com/javase/tutorial/java/nutsandbolts/_keywords.html.
 * 
 * @author Raymond Karyshyn
 */
public class UniqueWords {
    public static void main(String[] args) {
        final String[] keywords = { "abstract", "assert", "boolean", "break", "byte", "case", "catch", "char", "class",
                "const", "continue", "default", "do", "double", "else", "extends", "false", "final", "finally", "float",
                "for", "goto", "if", "implements", "import", "instanceof", "int", "interface", "long", "native", "new",
                "null", "package", "private", "protected", "public", "return", "short", "static", "strictfp", "super",
                "switch", "synchronized", "this", "throw", "throws", "transient", "true", "try", "void", "volatile",
                "while" };
        String fileName = "BasicDoubleLinkedList.java";

        Map<String, Integer> keywordCountMap = keywordCounter(keywords, fileName);
        Map<String, Integer> sortedKeywordCountMap = mapSorter(keywordCountMap);

        System.out.println("Unique Java keywords in " + fileName + " as \"keyword (frequency)\":");
        for (Map.Entry<String, Integer> entry : sortedKeywordCountMap.entrySet())
            System.out.println("\t" + entry.getKey() + " (" + entry.getValue() + ")");
    }

    public static Map<String, Integer> keywordCounter(String[] keywords, String fileName) {
        Map<String, Integer> hashMap = new HashMap<>();

        try {
            Scanner fileData = new Scanner(new File(fileName));

            while (fileData.hasNext()) {
                String word = fileData.next();

                if (Arrays.binarySearch(keywords, word) >= 0) {
                    if (hashMap.containsKey(word))
                        hashMap.put(word, hashMap.get(word) + 1);
                    else
                        hashMap.put(word, 1);
                }
            }

            fileData.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error opening file named " + fileName);
        }

        return hashMap;
    }

    public static <A, B> Map<A, B> mapSorter(Map<A, B> map) {
        Map<A, B> temp_map = new HashMap<>();

        List<Map.Entry<A, B>> b = new ArrayList<>();

        for (Map.Entry<A, B> a : map.entrySet()) {
            b.add(a);
        }

        for (Map.Entry<A, B> a : b) {
            temp_map.put(a.getKey(), a.getValue());
        }

        return temp_map;
    }
}
