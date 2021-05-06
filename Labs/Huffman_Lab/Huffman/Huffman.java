import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeMap;

public class Huffman {
    public static HuffmanPair encode(String message) {
        return new HuffmanPair(Huffman.huffmanTree(message), Huffman.encodedMessage(message));
    }

    public static String decode(HuffmanPair pair) {
        return Huffman.decode(pair.getHuffmanTree(), pair.getEncodedMessage());
    }

    public static String decode(HuffmanTree tree, String code) {
        return "";
    }

    public static HuffmanTree huffmanTree(String message) {
        return new HuffmanTree(Huffman.priorityQueue(message));
    }

    public static PriorityQueue<HuffmanNode> priorityQueue(String message) {
        return Huffman.priorityQueue(Huffman.frequencyTable(message));
    }

    private static PriorityQueue<HuffmanNode> priorityQueue(Map<Character, Integer> frequencyTable) {
        PriorityQueue<HuffmanNode> priorityQueue = new PriorityQueue<HuffmanNode>(frequencyTable.size(),
                new HuffmanComparator());

        for (Map.Entry<Character, Integer> i : frequencyTable.entrySet())
            priorityQueue.add(new HuffmanNode(i.getKey(), i.getValue()));

        return priorityQueue;
    }

    public static Map<Character, Integer> frequencyTable(String message) {
        Map<Character, Integer> frequencies = new HashMap<>();

        for (char c : message.toCharArray())
            frequencies.put(c, frequencies.getOrDefault(c, 0) + 1);

        return frequencies;
    }

    public static TreeMap<String, String> encryptionMap(String message) {
        return Huffman.encryptionMap(Huffman.huffmanTree(message));
    }

    private static TreeMap<String, String> encryptionMap(HuffmanTree tree) {
        TreeMap<String, String> codeMap = new TreeMap<>();

        encryptionMapRecursive(codeMap, tree.getRoot(), "");

        return codeMap;
    }

    private static void encryptionMapRecursive(TreeMap<String, String> t, HuffmanNode root, String s) {
        if (root.getLeft() == null && root.getRight() == null) {
            t.put(root.getCharacter(), s);

            return;
        }

        encryptionMapRecursive(t, root.getLeft(), s + "0");
        encryptionMapRecursive(t, root.getRight(), s + "1");
    }

    public static String encodedMessage(String s) {
        TreeMap<String, String> t = Huffman.encryptionMap(s);

        String result = "";

        for (char c : s.toCharArray()) {
            if (t.containsKey(String.valueOf(c)))
                result += t.get(String.valueOf(c));
        }

        return result;
    }
}
