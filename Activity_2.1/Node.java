public class Node<T> {
    private T data;
    private Node<T> next;

    public Node(T dataPortion) {
        this(dataPortion, null);
    }

    public Node(T dataPortion, Node<T> nextNode) {
        data = dataPortion;
        next = nextNode;
    }

    public T getData() {
        return data;
    }

    public void setData(T dataPortion) {
        data = dataPortion;
    }

    public Node<T> getNext() {
        return next;
    }

    public void setNext(Node<T> nextNode) {
        next = nextNode;
    }
}
