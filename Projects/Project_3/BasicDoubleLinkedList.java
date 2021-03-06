import java.lang.Iterable;
import java.util.ListIterator;
import java.util.ArrayList;
import java.util.Comparator;
import java.lang.UnsupportedOperationException;
import java.util.NoSuchElementException;

public class BasicDoubleLinkedList<T> implements Iterable<T> {
    private Node head, tail;
    int size;

    public BasicDoubleLinkedList() {
        head = tail = null;
        size = 0;
    }

    /**
     * This method just returns the value of the instance variable you use to keep
     * track of size.
     * 
     * @return The size of the linked list.
     */
    public int getSize() {
        return size;
    }

    /**
     * Adds an element to the end of the list. Do not use iterators to implement
     * this method.
     * 
     * @param data The data for the Node within the linked list.
     * @return Reference to the current object.
     */
    public BasicDoubleLinkedList<T> addToEnd(T data) {
        if (tail == null)
            head = tail = new Node(data);
        else {
            Node newNode = new Node(data, null, tail);
            tail.setNext(newNode);
            tail = newNode;
        }

        size++;
        return this;
    }

    /**
     * Adds element to the front of the list. Do not use iterators to implement this
     * method.
     * 
     * @param data The data for the Node within the linked list.
     * @return Reference to the current object.
     */
    public BasicDoubleLinkedList<T> addToFront(T data) {
        if (head == null)
            head = tail = new Node(data);
        else {
            Node newNode = new Node(data, head, null);
            head.setPrevious(newNode);
            head = newNode;
        }

        size++;
        return this;
    }

    /**
     * Returns but does not remove the first element from the list. If there are no
     * elements the method returns null. Do not implement this method using
     * iterators.
     * 
     * @return The data element or null.
     */
    public T getFirst() {
        if (head != null)
            return head.getData();

        return null;
    }

    /**
     * Returns but does not remove the last element from the list. If there are no
     * elements the method returns null. Do not implement this method using
     * iterators.
     * 
     * @return The data element or null.
     */
    public T getLast() {
        if (tail != null)
            return tail.getData();

        return null;
    }

    /**
     * Removes the first instance of the targetData from the list. Notice that you
     * must remove the elements by performing a single traversal over the list. You
     * may not use any of the other retrieval methods associated with the class in
     * order to complete the removal process. You must use the provided comparator
     * (do not use equals) to find those elements that match the target. Do not
     * implement this method using iterators.
     * 
     * @param target     Data The data element to be removed.
     * @param comparator The comparator to determine equality of data elements.
     * @return Data element or null.
     */
    public BasicDoubleLinkedList<T> remove(T targetData, Comparator<T> comparator) {
        boolean removed = false;

        if (head != null) {
            if (comparator.compare(head.data, targetData) == 0) {
                if (head.getNext() == null)
                    head = tail = null;
                else {
                    head = head.getNext();
                    head.setPrevious(null);
                }

                removed = true;
            } else {
                Node current = head.getNext();

                while (current != null) {
                    if (comparator.compare(current.getData(), targetData) == 0) {
                        if (current.getNext() == null) {
                            tail = current.getPrevious();
                            tail.setNext(null);
                        } else {
                            current.getPrevious().setNext(current.getNext());
                            current.getNext().setPrevious(current.getPrevious());
                        }

                        removed = true;
                        break;
                    }

                    current = current.getNext();
                }
            }
        }

        if (removed) {
            size--;
            return this;
        }

        return null;
    }

    /**
     * Removes and returns the first element from the list. If there are no elements
     * the method returns null. Do not implement this method using iterators.
     * 
     * @return Data element or null.
     */
    public T retrieveFirstElement() {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * Removes and returns the last element from the list. If there are no elements
     * the method returns null. Do not implement implement this method using
     * iterators.
     * 
     * @return Data element or null.
     */
    public T retrieveLastElement() {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * Returns an arraylist of the items in the list from head of list to tail of
     * list.
     * 
     * @return An arraylist of the items in the list.
     */
    public ArrayList<T> toArrayList() {
        ArrayList<T> arrayList = new ArrayList<>();
        Node current = head;

        while (current != null) {
            arrayList.add(current.getData());
            current = current.getNext();
        }

        return arrayList;
    }

    /**
     * This method must be implemented using an inner class that implements
     * ListIterator and defines the methods of hasNext(), next(), hasPrevious() and
     * previous(). Remember that we should be able to call the hasNext() method as
     * many times as we want without changing what is considered the next element.
     * 
     * @throws UnsupportedOperationException You don't need to implement the
     *                                       ListIterator's remove(), add(),
     *                                       nextIndex() and previousIndex() and
     *                                       set() methods, throw
     *                                       UnsupportedOperationException if
     *                                       called.
     * @throws NoSuchElementException        Your next() method should throw
     *                                       NoSuchElementException if there are no
     *                                       more elements (at the end of the list
     *                                       and calling next() or at the beginning
     *                                       of the list and calling previous()).
     */
    @Override
    public ListIterator<T> iterator() throws UnsupportedOperationException, NoSuchElementException {
        MyIterator iterator = new MyIterator();
        return iterator;
    }

    private class Node {
        private T data;
        private Node next;
        private Node previous;

        private Node(T data) {
            this(data, null, null);
        }

        private Node(T data, Node next, Node previous) {
            this.data = data;
            this.next = next;
            this.previous = previous;
        }

        private T getData() {
            return data;
        }

        private void setData(T data) {
            this.data = data;
        }

        private Node getNext() {
            return next;
        }

        private void setNext(Node next) {
            this.next = next;
        }

        private Node getPrevious() {
            return previous;
        }

        private void setPrevious(Node previous) {
            this.previous = previous;
        }
    }

    private class MyIterator implements ListIterator<T> {
        private Node current;
        private int size;

        public MyIterator() {
            current = new Node(null, null, head);
        }

        @Override
        public boolean hasNext() {
            // TODO Auto-generated method stub
            return false;
        }

        @Override
        public T next() {
            // TODO Auto-generated method stub
            return null;
        }

        @Override
        public boolean hasPrevious() {
            // TODO Auto-generated method stub
            return false;
        }

        @Override
        public T previous() {
            // TODO Auto-generated method stub
            return null;
        }

        @Override
        public int nextIndex() throws UnsupportedOperationException {
            throw new UnsupportedOperationException();
        }

        @Override
        public int previousIndex() throws UnsupportedOperationException {
            throw new UnsupportedOperationException();
        }

        @Override
        public void remove() throws UnsupportedOperationException {
            throw new UnsupportedOperationException();
        }

        @Override
        public void set(Object e) throws UnsupportedOperationException {
            throw new UnsupportedOperationException();
        }

        @Override
        public void add(Object e) throws UnsupportedOperationException {
            throw new UnsupportedOperationException();
        }
    }
}
