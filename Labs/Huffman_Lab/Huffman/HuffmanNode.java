public class HuffmanNode {
    private String character;
    private int frequency;
    private HuffmanNode left, right;
    private static int counter = 0;

    public HuffmanNode(char character, int frequency) {
        this(String.valueOf(character), frequency, null, null);
    }

    public HuffmanNode(String character, int frequency) {
        this(character, frequency, null, null);
    }

    public HuffmanNode(int frequency, HuffmanNode left, HuffmanNode right) {
        this(("~" + counter), frequency, left, right);
        counter++;
    }

    public HuffmanNode(String character, int frequency, HuffmanNode left, HuffmanNode right) {
        this.character = character;
        this.frequency = frequency;
        this.left = left;
        this.right = right;
    }

    public String getCharacter() {
        return character;
    }

    public void setCharacter(String character) {
        this.character = character;
    }

    public int getFrequency() {
        return frequency;
    }

    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }

    public HuffmanNode getLeft() {
        return left;
    }

    public void setLeft(HuffmanNode left) {
        this.left = left;
    }

    public HuffmanNode getRight() {
        return right;
    }

    public void setRight(HuffmanNode right) {
        this.right = right;
    }

    public String toString() {
        return "('" + this.character + "', " + this.frequency + ")";
    }
}
