import java.util.Comparator;
import java.lang.UnsupportedOperationException;
import java.util.ListIterator;

/**
 * Implements a generic sorted double list using a provided Comparator. It
 * extends BasicDoubleLinkedList class.
 * 
 * @author Raymond Karyshyn
 */
public class SortedDoubleLinkedList<T> extends BasicDoubleLinkedList<T> {
    private Comparator<T> comparator = null;

    /**
     * Creates an empty list that is associated with the specified comparator.
     * 
     * @param comparator2 Comparator to compare data elements.
     */
    public SortedDoubleLinkedList(Comparator<T> comparator2) {
        this.comparator = comparator2;
    }

    /**
     * Inserts the specified element at the correct position in the sorted list.
     * Notice we can insert the same element several times. Your implementation must
     * traverse the list only once in order to perform the insertion. Do not
     * implement this method using iterators. Notice that you don't need to call any
     * of the super class methods in order to implement this method.
     * 
     * @param data The data to be added to the list.
     * @return A reference to the current object.
     */
    public SortedDoubleLinkedList<T> add(T data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = tail = newNode;
            size++;
        } else if (comparator.compare(head.getData(), data) >= 0)
            super.addToFront(data);
        else if (comparator.compare(tail.getData(), data) < 0)
            super.addToEnd(data);
        else {
            Node current = head;

            while (current != null) {
                if (comparator.compare(current.getData(), data) >= 0) {
                    Node before = current.getPrevious();
                    Node after = current;

                    before.setNext(newNode);
                    after.setPrevious(newNode);
                    newNode.setPrevious(before);
                    newNode.setNext(after);

                    break;
                }

                current = current.getNext();
            }

            size++;
        }

        return this;
    }

    /**
     * This operation is invalid for a sorted list. An UnsupportedOperationException
     * will be generated using the message "Invalid operation for sorted list."
     * 
     * @param data The data for the Node within the linked list.
     * @return Reference to the current object.
     * @throws UnsupportedOperationException If method is called.
     */
    @Override
    public BasicDoubleLinkedList<T> addToEnd(T data) throws UnsupportedOperationException {
        throw new UnsupportedOperationException("Invalid operation for sorted list");
    }

    /**
     * This operation is invalid for a sorted list. An UnsupportedOperationException
     * will be generated using the message "Invalid operation for sorted list."
     * 
     * @param data The data for the Node within the linked list.
     * @return Reference to the current object.
     * @throws UnsupportedOperationException If method is called.
     */
    @Override
    public BasicDoubleLinkedList<T> addToFront(T data) throws UnsupportedOperationException {
        throw new UnsupportedOperationException("Invalid operation for sorted list");
    }

    /**
     * Implements the remove operation by calling the super class remove method.
     * 
     * @param data       The data element to be removed.
     * @param comparator The comparator to determine equality of data elements.
     * @return Data element or null.
     */
    @Override
    public SortedDoubleLinkedList<T> remove(T data, Comparator<T> comparator) {
        if (super.remove(data, comparator) == null)
            return null;

        return this;
    }

    /**
     * Implements the iterator by calling the super class iterator method.
     * 
     * @return An iterator positioned at the head of the list.
     */
    @Override
    public ListIterator<T> iterator() {
        return super.iterator();
    }
}
