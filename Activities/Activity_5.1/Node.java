/**
 * A class for nodes in a linked list.
 * 
 * @author Raymond Karyshyn
 */

public class Node<T> {
    private T data;
    private Node<T> next;

    public Node(T dataIn) {
        this(dataIn, null);
    }

    public Node(T dataIn, Node<T> nextNode) {
        data = dataIn;
        next = nextNode;
    }

    /**
     * Gets the data stored in the node.
     * 
     * @return The data in the node.
     */
    public T getData() {
        return data;
    }

    /**
     * Sets the data to be stored in the node.
     * 
     * @param dataIn The data to be stored in the node.
     */
    public void setData(T dataIn) {
        data = dataIn;
    }

    /**
     * Gets a reference to the next node in the chain link.
     * 
     * @return The next node in the chain link.
     */
    public Node<T> getNext() {
        return next;
    }

    /**
     * Set a reference to the next node in the chain link.
     * 
     * @param nextNode A reference to the next node in the chain link.
     */
    public void setNext(Node<T> nextNode) {
        next = nextNode;
    }
}
