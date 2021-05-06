public class Driver {
    public static void main(String[] args) {
        String message = "create a huffman tree";

        System.out.println("Message: " + message);
        System.out.println("Huffman Encoded Message: " + Huffman.encode(message).getEncodedMessage());
    }
}
