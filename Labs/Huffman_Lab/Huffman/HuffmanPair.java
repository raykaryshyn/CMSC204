public class HuffmanPair {
    private HuffmanTree tree;
    private String code;

    public HuffmanPair() {
        this(null, null);
    }

    public HuffmanPair(HuffmanTree tree, String code) {
        this.tree = tree;
        this.code = code;
    }

    public HuffmanTree getTree() {
        return tree;
    }

    public void setTree(HuffmanTree tree) {
        this.tree = tree;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
