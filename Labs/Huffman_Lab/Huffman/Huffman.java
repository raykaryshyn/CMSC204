import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeMap;

/**
 * Represents a utility class for encoding and decoding messages with Huffman
 * coding.
 * 
 * @author Raymond Karyshyn
 */
public class Huffman {
    /**
     * Encodes a given message.
     * 
     * @param message The message to be encoded.
     * @return A HuffmanPair object containing the HuffmanTree used to encode and
     *         the encoded message.
     */
    public static HuffmanPair encode(String message) {
        return new HuffmanPair(Huffman.huffmanTree(message), Huffman.encodedMessage(message));
    }

    /**
     * Decodes a given encoded message using a HuffmanPair object.
     * 
     * @param pair The HuffmanPair containing the HuffmanTree used to encode and the
     *             encoded message.
     * @return A string of the decoded message.
     */
    public static String decode(HuffmanPair pair) {
        return Huffman.decode(pair.getHuffmanTree(), pair.getEncodedMessage());
    }

    /**
     * Decodes a given encoded message using a HuffmanTree object and the encoded
     * message.
     * 
     * @param huffmanTree    The HuffmanTree used to encode the message.
     * @param encodedMessage The encoded message.
     * @return A string of the decoded message.
     */
    public static String decode(HuffmanTree huffmanTree, String encodedMessage) {
        HuffmanNode root = huffmanTree.getRoot();

        String decodedMessage = "";

        for (char c : encodedMessage.toCharArray()) {
            if (c == '0' && root.hasLeft())
                root = root.getLeft();
            else if (c == '1' && root.hasRight())
                root = root.getRight();

            if (!(root.hasLeft() && root.hasRight())) {
                decodedMessage += root.getCharacter();
                root = huffmanTree.getRoot();
            }
        }

        return decodedMessage;
    }

    /**
     * The HuffmanTree for encoding a given message.
     * 
     * @param message The message to be encoded.
     * @return A HuffmanTree object for encoding the message.
     */
    public static HuffmanTree huffmanTree(String message) {
        return new HuffmanTree(Huffman.priorityQueue(message));
    }

    /**
     * The PriorityQueue for encoding a given message.
     * 
     * @param message The message to be encoded.
     * @return A PriorityQueue of HuffmanNodes for encoding the message.
     */
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

    public static TreeMap<String, String> encodingMap(String message) {
        return Huffman.encodingMap(Huffman.huffmanTree(message));
    }

    public static TreeMap<String, String> encodingMap(HuffmanTree tree) {
        TreeMap<String, String> codeMap = new TreeMap<>();

        encodingMapRecursive(codeMap, tree.getRoot(), "");

        return codeMap;
    }

    private static void encodingMapRecursive(TreeMap<String, String> t, HuffmanNode root, String s) {
        if (root.getLeft() == null && root.getRight() == null) {
            t.put(root.getCharacter(), s);

            return;
        }

        encodingMapRecursive(t, root.getLeft(), s + "0");
        encodingMapRecursive(t, root.getRight(), s + "1");
    }

    public static String encodedMessage(String s) {
        TreeMap<String, String> t = Huffman.encodingMap(s);

        String result = "";

        for (char c : s.toCharArray()) {
            if (t.containsKey(String.valueOf(c)))
                result += t.get(String.valueOf(c));
        }

        return result;
    }
}
