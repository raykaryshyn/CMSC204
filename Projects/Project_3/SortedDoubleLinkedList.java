import java.util.Comparator;
import java.lang.UnsupportedOperationException;
import java.util.ListIterator;

public class SortedDoubleLinkedList<T> extends BasicDoubleLinkedList<T> {
    /**
     * Creates an empty list that is associated with the specified comparator.
     * 
     * @param comparator2 Comparator to compare data elements.
     */
    public SortedDoubleLinkedList(Comparator<T> comparator2) {

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
        // TODO Auto-generated method stub
        return null;
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
        // TODO Auto-generated method stub
        return null;
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
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * Implements the remove operation by calling the super class remove method.
     * 
     * @param data       The data element to be removed.
     * @param comparator The comparator to determine equality of data elements.
     */
    @Override
    public SortedDoubleLinkedList<T> remove(T data, Comparator<T> comparator) {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * Implements the iterator by calling the super class iterator method.
     * 
     * @return An iterator positioned at the head of the list.
     */
    @Override
    public ListIterator<T> iterator() {
        // TODO Auto-generated method stub
        return null;
    }
}
