import java.util.PriorityQueue;

public class HuffmanTree {
    private HuffmanNode root;
    private PriorityQueue<HuffmanNode> priorityQueue;

    public HuffmanTree(PriorityQueue<HuffmanNode> priorityQueue) {
        this.root = null;
        this.priorityQueue = new PriorityQueue<>(priorityQueue);
        buildTree();
    }

    public HuffmanNode getRoot() {
        return this.root;
    }

    private void buildTree() {
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
}
