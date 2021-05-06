public class Driver {
    public static void main(String[] args) {
        String message = "create a huffman tree";

        System.out.println("Message: " + message);
        System.out.println("Huffman: " + Huffman.encode(message).getEncodedMessage());
    }
}
