public class HuffmanPair {
    private HuffmanTree huffmanTree;
    private String encodedMessage;

    public HuffmanPair() {
        this(null, null);
    }

    public HuffmanPair(HuffmanTree huffmanTree, String encodedMessage) {
        this.huffmanTree = huffmanTree;
        this.encodedMessage = encodedMessage;
    }

    public HuffmanTree getHuffmanTree() {
        return huffmanTree;
    }

    public void setHuffmanTree(HuffmanTree huffmanTree) {
        this.huffmanTree = huffmanTree;
    }

    public String getEncodedMessage() {
        return encodedMessage;
    }

    public void setEncodedMessage(String encodedMessage) {
        this.encodedMessage = encodedMessage;
    }
}
