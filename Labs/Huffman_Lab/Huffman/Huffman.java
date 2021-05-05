import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeMap;

public class Huffman {
    public static HuffmanPair encode(String message) {
        HuffmanPair pair = new HuffmanPair();

        Map<Character, Integer> frequencyTable = Huffman.buildFrequencyTable(message);

        PriorityQueue<HuffmanNode> priorityQueue = new PriorityQueue<HuffmanNode>(frequencyTable.size(),
                new HuffmanComparator());

        for (Map.Entry<Character, Integer> i : frequencyTable.entrySet())
            priorityQueue.add(new HuffmanNode(i.getKey(), i.getValue()));

        HuffmanTree tree = new HuffmanTree(priorityQueue);

        TreeMap<String, String> t = new TreeMap<>();

        createCode(t, tree.getRoot(), "");

        pair.setTree(tree);
        pair.setCode(codeString(t, message));

        return pair;
    }

    public static String decode(HuffmanPair pair) {
        return Huffman.decode(pair.getTree(), pair.getCode());
    }

    public static String decode(HuffmanTree tree, String code) {
        return "";
    }

    private static Map<Character, Integer> buildFrequencyTable(String message) {
        Map<Character, Integer> frequencies = new HashMap<>();

        for (char c : message.toCharArray())
            frequencies.put(c, frequencies.getOrDefault(c, 0) + 1);

        return frequencies;
    }

    private static void createCode(TreeMap<String, String> t, HuffmanNode root, String s) {
        if (root.getLeft() == null && root.getRight() == null) {
            t.put(root.getCharacter(), s);

            return;
        }

        createCode(t, root.getLeft(), s + "0");
        createCode(t, root.getRight(), s + "1");
    }

    private static String codeString(TreeMap<String, String> t, String s) {
        String result = "";

        for (char c : s.toCharArray()) {
            for (Map.Entry<String, String> n : t.entrySet()) {
                if (String.valueOf(c).equals(n.getKey()))
                    result += n.getValue();
            }
        }

        return result;
    }
}
