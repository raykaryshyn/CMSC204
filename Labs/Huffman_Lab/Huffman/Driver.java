import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeMap;

public class Driver {
    public static void main(String[] args) {
        String input = "create a huffman tree";
        Map<Character, Integer> frequencies = new HashMap<>();
        for (char ch : input.toCharArray())
            frequencies.put(ch, frequencies.getOrDefault(ch, 0) + 1);

        System.out.println("Frequencies: " + frequencies);

        PriorityQueue<HuffmanNode> q = new PriorityQueue<HuffmanNode>(frequencies.size(), new HuffmanComparator());

        for (Map.Entry<Character, Integer> i : frequencies.entrySet())
            q.add(new HuffmanNode(i.getKey(), i.getValue()));

        HuffmanTree tree = new HuffmanTree(q);

        TreeMap<String, String> t = new TreeMap<>();
        createCode(t, tree.getRoot(), "");

        System.out.println("Code: " + t);

        System.out.println("Huffman: " + codeString(t, input));
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
