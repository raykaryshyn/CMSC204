import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
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
        String fileName = "BasicDoubleLinkedList.java";
        final String[] keywords = { "abstract", "assert", "boolean", "break", "byte", "case", "catch", "char", "class",
                "const", "continue", "default", "do", "double", "else", "extends", "false", "final", "finally", "float",
                "for", "goto", "if", "implements", "import", "instanceof", "int", "interface", "long", "native", "new",
                "null", "package", "private", "protected", "public", "return", "short", "static", "strictfp", "super",
                "switch", "synchronized", "this", "throw", "throws", "transient", "true", "try", "void", "volatile",
                "while" };

        Map<String, Integer> keywordCountMap = keywordCounter(fileName, keywords);
        Map<String, Integer> sortedKeywordCountMap = mapSorter(keywordCountMap);

        System.out.println("Unique Java keywords in " + fileName + " as \"keyword (frequency)\":");
        for (Map.Entry<String, Integer> entry : sortedKeywordCountMap.entrySet())
            System.out.println("\t" + entry.getKey() + " (" + entry.getValue() + ")");
    }

    public static Map<String, Integer> keywordCounter(String fileName, String[] keywords) {
        Map<String, Integer> hashMap = new LinkedHashMap<>();

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

    public static <A extends Comparable<? super A>, B extends Comparable<? super B>> Map<A, B> mapSorter(
            Map<A, B> map) {
        Map<A, B> sortedMap = new LinkedHashMap<>();
        List<Map.Entry<A, B>> list = new ArrayList<>();

        // Map to List
        for (Map.Entry<A, B> entry : map.entrySet())
            list.add(entry);

        // Alphabelically sort the list by its keys
        list = sortList(list, 0, list.size() - 1);
        System.out.println(list);

        // List to Map
        for (Map.Entry<A, B> entry : list)
            sortedMap.put(entry.getKey(), entry.getValue());

        return sortedMap;
    }

    private static <A extends Comparable<? super A>, B extends Comparable<? super B>> List<Map.Entry<A, B>> sortList(
            List<Map.Entry<A, B>> list, int l, int r) {
        if (l < r) {
            // Find the middle point
            int m = l + (r - l) / 2;

            // Sort first and second halves
            sortList(list, l, m);
            sortList(list, m + 1, r);

            // Merge the sorted halves
            merge(list, l, m, r);
        }

        return list;
    }

    private static <A extends Comparable<? super A>, B extends Comparable<? super B>> void merge(
            List<Map.Entry<A, B>> list, int l, int m, int r) {
        // Find sizes of two subarrays to be merged
        int n1 = m - l + 1;
        int n2 = r - m;

        /* Create temp arrays */
        List<Map.Entry<A, B>> L = new ArrayList<>();
        List<Map.Entry<A, B>> R = new ArrayList<>();

        /* Copy data to temp arrays */
        for (int i = 0; i < n1; ++i)
            L.add(i, list.get(l + i));
        for (int j = 0; j < n2; ++j)
            R.add(j, list.get(m + 1 + j));

        /* Merge the temp arrays */

        // Initial indexes of first and second subarrays
        int i = 0, j = 0;

        // Initial index of merged subarry array
        int k = l;
        while (i < n1 && j < n2) {
            if (L.get(i).getKey().compareTo(R.get(j).getKey()) <= 0) {
                list.set(k, L.get(i));
                i++;
            } else {
                list.set(k, R.get(j));
                j++;
            }
            k++;
        }

        /* Copy remaining elements of L[] if any */
        while (i < n1) {
            list.set(k, L.get(i));
            i++;
            k++;
        }

        /* Copy remaining elements of R[] if any */
        while (j < n2) {
            list.set(k, R.get(j));
            j++;
            k++;
        }
    }
}
