import java.util.Map;
import java.util.PriorityQueue;

/**
 * Represents a Huffman tree of HuffmanNodes.
 * 
 * @author Raymond Karyshyn
 */
public class HuffmanTree {
    private HuffmanNode root;
    private PriorityQueue<HuffmanNode> priorityQueue;

    /**
     * Constructor which uses a priority queue for controlling the order in which
     * the nodes are removed.
     * 
     * @param priorityQueue A PriorityQueue of HuffmanNodes.
     */
    public HuffmanTree(PriorityQueue<HuffmanNode> priorityQueue) {
        this.root = null;
        this.priorityQueue = new PriorityQueue<>(priorityQueue);

        buildTree();
    }

    /**
     * The root of the Huffman tree.
     * 
     * @return A HuffmanNode representing the root of the Huffman tree.
     */
    public HuffmanNode getRoot() {
        return this.root;
    }

    /**
     * An internal method for building a Huffman tree from the instance's priority
     * queue.
     */
    private void buildTree() {
        while (this.priorityQueue.size() > 1) {
            HuffmanNode a = this.priorityQueue.peek();
            this.priorityQueue.poll();

            HuffmanNode b = this.priorityQueue.peek();
            this.priorityQueue.poll();

            HuffmanNode newRoot = new HuffmanNode(a.getFrequency() + b.getFrequency(), a, b);

            this.root = newRoot;

            this.priorityQueue.add(newRoot);
        }
    }

    /**
     * Represents the Huffman tree as a string formatted as: <br>
     * "{(character, encoding), ...}"
     * 
     * @return A String representing the Huffman tree.
     */
    public String toString() {
        Map<String, String> encodingMap = Huffman.encodingMap(this);

        String output = "{";

        for (Map.Entry<String, String> entry : encodingMap.entrySet()) {
            output += "('" + entry.getKey() + "', " + entry.getValue() + "), ";
        }

        output = output.substring(0, output.length() - 2) + "}";

        return output;
    }
}
