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
public class UniqueKeywords {
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

        // List to Map
        for (Map.Entry<A, B> entry : list)
            sortedMap.put(entry.getKey(), entry.getValue());

        return sortedMap;
    }

    private static <A extends Comparable<? super A>, B extends Comparable<? super B>> List<Map.Entry<A, B>> sortList(
            List<Map.Entry<A, B>> list, int first, int last) {
        if (first < last) {
            int mid = first + (last - first) / 2;

            sortList(list, first, mid);
            sortList(list, mid + 1, last);

            merge(list, first, mid, last);
        }

        return list;
    }

    private static <A extends Comparable<? super A>, B extends Comparable<? super B>> void merge(
            List<Map.Entry<A, B>> list, int first, int mid, int last) {
        int firstSize = mid - first + 1;
        int lastSize = last - mid;

        List<Map.Entry<A, B>> firstList = new ArrayList<>();
        List<Map.Entry<A, B>> lastList = new ArrayList<>();

        for (int i = 0; i < firstSize; i++)
            firstList.add(i, list.get(first + i));
        for (int j = 0; j < lastSize; j++)
            lastList.add(j, list.get(mid + 1 + j));

        int firstIndex = 0, lastIndex = 0;

        int mergedIndex = first;
        while (firstIndex < firstSize && lastIndex < lastSize) {
            if (firstList.get(firstIndex).getKey().compareTo(lastList.get(lastIndex).getKey()) <= 0) {
                list.set(mergedIndex, firstList.get(firstIndex));
                firstIndex++;
            } else {
                list.set(mergedIndex, lastList.get(lastIndex));
                lastIndex++;
            }
            mergedIndex++;
        }

        while (firstIndex < firstSize) {
            list.set(mergedIndex, firstList.get(firstIndex));
            firstIndex++;
            mergedIndex++;
        }

        while (lastIndex < lastSize) {
            list.set(mergedIndex, lastList.get(lastIndex));
            lastIndex++;
            mergedIndex++;
        }
    }
}
