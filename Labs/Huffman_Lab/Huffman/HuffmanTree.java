import java.util.Map;
import java.util.PriorityQueue;

public class HuffmanTree {
    private HuffmanNode root;
    private PriorityQueue<HuffmanNode> priorityQueue;

    public HuffmanTree(PriorityQueue<HuffmanNode> priorityQueue) {
        this.root = null;
        this.priorityQueue = new PriorityQueue<>(priorityQueue);
        buildTree(this.priorityQueue);
    }

    public HuffmanNode getRoot() {
        return this.root;
    }

    private void buildTree(PriorityQueue<HuffmanNode> priorityQueue) {
        this.priorityQueue = priorityQueue;

        while (this.priorityQueue.size() > 1) {
            HuffmanNode x = this.priorityQueue.peek();
            this.priorityQueue.poll();

            HuffmanNode y = this.priorityQueue.peek();
            this.priorityQueue.poll();

            HuffmanNode f = new HuffmanNode(x.getFrequency() + y.getFrequency(), x, y);

            this.root = f;

            this.priorityQueue.add(f);
        }
    }

    public String toString() {
        Map<String, String> encodingMap = Huffman.encodingMap(this);

        String output = "{";

        for (Map.Entry<String, String> entry : encodingMap.entrySet()) {
            output += "('" + entry.getKey() + "', " + entry.getValue() + "), ";
        }
        output = output.substring(0, output.length() - 2);

        output += "}";

        return output;
    }
}
