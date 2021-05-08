import java.util.Map;

/**
 * Utilizes the Huffman class to encode and decode various messages with Huffman
 * coding.
 * 
 * @author Raymond Karyshyn
 */
public class Driver {
    public static void main(String[] args) {
        String[] messages = { "create a huffman tree", "huffman tree", "I can't believe this works...!",
                "better tree" };

        for (String message : messages) {
            // Encode the original message
            HuffmanPair huffmanPair = Huffman.encode(message);
            HuffmanTree huffmanTree = huffmanPair.getHuffmanTree();
            String encodedMessage = huffmanPair.getEncodedMessage();
            Map<Character, Integer> frequencyMap = Huffman.frequencyMap(message);

            // Decode the encoded message
            String decodedMessage = Huffman.decode(huffmanPair);

            System.out.println("Original Message:\t\t" + message);
            System.out.println("Frequency Map:\t\t\t" + frequencyMap);
            System.out.println("Huffman Encoding Map:\t\t" + huffmanTree);
            System.out.println("Huffman Encoded Message:\t" + encodedMessage);
            System.out.println("Huffman Decoded Message:\t" + decodedMessage + "\n");
        }
    }
}
