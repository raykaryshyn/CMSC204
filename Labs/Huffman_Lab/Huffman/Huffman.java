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
     * Encodes a message without the needed HuffmanTree for decoding.
     * 
     * @param message The message to be encoded.
     * @return A String of the encoded message.
     */
    public static String encodedMessage(String message) {
        Map<String, String> t = Huffman.encodingMap(message);

        String result = "";

        for (char c : message.toCharArray()) {
            if (t.containsKey(String.valueOf(c)))
                result += t.get(String.valueOf(c));
        }

        return result;
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
     * The priority queue for encoding a given message.
     * 
     * @param message The message to be encoded.
     * @return A PriorityQueue of HuffmanNodes for encoding the message.
     */
    public static PriorityQueue<HuffmanNode> priorityQueue(String message) {
        return Huffman.priorityQueue(Huffman.frequencyMap(message));
    }

    /**
     * The priority queue made from a message's given character frequency map.
     * 
     * @param frequencyMap The frequency map.
     * @return A PriorityQueue of HuffmanNodes.
     */
    public static PriorityQueue<HuffmanNode> priorityQueue(Map<Character, Integer> frequencyMap) {
        PriorityQueue<HuffmanNode> priorityQueue = new PriorityQueue<HuffmanNode>(frequencyMap.size(),
                new HuffmanComparator());

        for (Map.Entry<Character, Integer> i : frequencyMap.entrySet())
            priorityQueue.add(new HuffmanNode(i.getKey(), i.getValue()));

        return priorityQueue;
    }

    /**
     * The frequency map of a given message.
     * 
     * @param message The message which frequencies are to be mapped.
     * @return A Map object representing the frequency map whose key's are the
     *         characters and values are the frequency counters.
     */
    public static Map<Character, Integer> frequencyMap(String message) {
        Map<Character, Integer> frequencies = new HashMap<>();

        for (char c : message.toCharArray())
            frequencies.put(c, frequencies.getOrDefault(c, 0) + 1);

        return frequencies;
    }

    /**
     * The encoding map that is used to encode a given message.
     * 
     * @param message The message to be encoded.
     * @return A Map object representing the encoding map whose key's are the
     *         characters and values are the location in the HuffmanTree for that
     *         character. The location is found by starting at the root node and
     *         traversing to the left when encountering a 0 and to the right when
     *         encountering a 1.
     */
    public static Map<String, String> encodingMap(String message) {
        return Huffman.encodingMap(Huffman.huffmanTree(message));
    }

    /**
     * The encoding map that is used to encode messages with a given HuffmanTree.
     * 
     * @param tree The HuffmanTree for encoding a mesage.
     * @return A Map object representing the encoding map whose key's are the
     *         characters and values are the location in the HuffmanTree for that
     *         character. The location is found by starting at the root node and
     *         traversing to the left when encountering a 0 and to the right when
     *         encountering a 1.
     */
    public static Map<String, String> encodingMap(HuffmanTree tree) {
        Map<String, String> encodingMap = new TreeMap<>();

        encodingMapRecursive(encodingMap, tree.getRoot(), "");

        return encodingMap;
    }

    /**
     * An internal method for generating the encoding map recursively.
     * 
     * @param tree The Map object to store the character encodings in.
     * @param root The current root node of the HuffmanTree.
     * @param s    The current character's current encoding.
     */
    private static void encodingMapRecursive(Map<String, String> map, HuffmanNode root, String s) {
        if (root.getLeft() == null && root.getRight() == null) {
            map.put(root.getCharacter(), s);

            return;
        }

        encodingMapRecursive(map, root.getLeft(), s + "0");
        encodingMapRecursive(map, root.getRight(), s + "1");
    }
}
