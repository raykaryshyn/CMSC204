/**
 * Represents an encoding of a message with the necessary information for
 * decoding.
 * 
 * @author Raymond Karyshyn
 */
public class HuffmanPair {
    private HuffmanTree huffmanTree;
    private String encodedMessage;

    /**
     * Constructor setting both attributes as null.
     */
    public HuffmanPair() {
        this(null, null);
    }

    /**
     * Constructor for setting both attributes with given arguments.
     * 
     * @param huffmanTree    The Huffman tree used to encode the message.
     * @param encodedMessage The encoded message.
     */
    public HuffmanPair(HuffmanTree huffmanTree, String encodedMessage) {
        this.huffmanTree = huffmanTree;
        this.encodedMessage = encodedMessage;
    }

    /**
     * Gets the stored Huffman tree.
     * 
     * @return A HuffmanTree object representing the stored Huffman tree.
     */
    public HuffmanTree getHuffmanTree() {
        return huffmanTree;
    }

    /**
     * Sets the Huffman tree.
     * 
     * @param huffmanTree The Huffman tree to be stored.
     */
    public void setHuffmanTree(HuffmanTree huffmanTree) {
        this.huffmanTree = huffmanTree;
    }

    /**
     * Gets the stored encoded message.
     * 
     * @return A string representing the stored encoded message.
     */
    public String getEncodedMessage() {
        return encodedMessage;
    }

    /**
     * Sets the encoded message.
     * 
     * @param encodedMessage The encoded message to be stored.
     */
    public void setEncodedMessage(String encodedMessage) {
        this.encodedMessage = encodedMessage;
    }
}
