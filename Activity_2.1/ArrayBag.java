/**
 * A linked list for storing entries in a chain of linked nodes.
 * 
 * @author Raymond Karyshyn
 */
public final class ArrayBag<T> implements BagInterface<T> {
    private Node<T> firstNode;
    private int numEntries;

    public ArrayBag() {
        firstNode = null;
        numEntries = 0;
    }

    /**
     * Gets the current number of entries in this bag.
     * 
     * @return The integer number of entries currently in the bag.
     */
    public int getCurrentSize() {
        return numEntries;
    }

    /**
     * Sees whether this bag is empty.
     * 
     * @return True if the bag is empty, or false if not.
     */
    public boolean isEmpty() {
        return numEntries == 0;
    }

    /**
     * Adds a new entry to this bag.
     * 
     * @param newEntry The object to be added as a new entry.
     * @return True if the addition is successful, or false if not.
     */
    public boolean add(T newEntry) {
        firstNode = new Node<T>(newEntry, firstNode);
        numEntries++;
        return true;
    }

    /**
     * Removes one unspecified entry from this bag, if possible.
     * 
     * @return Either the removed entry, if the removal was successful, or null.
     */
    public T remove() {
        T result = null;
        if (firstNode != null) {
            result = firstNode.getData();
            firstNode = firstNode.getNext();
            numEntries--;
        }
        return result;
    }

    /**
     * Removes one occurrence of a given entry from this bag, if possible.
     * 
     * @param anEntry The entry to be removed.
     * @return True if the removal was successful, or false if not.
     */
    public boolean remove(T anEntry) {
        boolean result = false;
        Node<T> NodeN = getReferenceTo(anEntry);
        if (NodeN != null) {
            NodeN.setData(firstNode.getData());
            firstNode = firstNode.getNext();
            numEntries--;
            result = true;
        }
        return result;
    }

    /** Removes all entries from this bag. */
    public void clear() {
        while (!isEmpty()) {
            remove();
        }
    }

    /**
     * Counts the number of times a given entry appears in this bag.
     * 
     * @param anEntry The entry to be counted.
     * @return The number of times anEntry appears in the bag.
     */
    public int getFrequencyOf(T anEntry) {
        int frequency = 0;
        int counter = 0;
        Node<T> currentNode = firstNode;
        while ((counter < numEntries) && (currentNode != null)) {
            if (anEntry.equals(currentNode.getData())) {
                frequency++;
            }
            counter++;
            currentNode = currentNode.getNext();
        }
        return frequency;
    }

    /**
     * Tests whether this bag contains a given entry.
     * 
     * @param anEntry The entry to find.
     * @return True if the bag contains anEntry, or false if not.
     */
    public boolean contains(T anEntry) {
        return (getReferenceTo(anEntry) != null);
    }

    /**
     * Retrieves all entries that are in this bag.
     * 
     * @return A newly allocated array of all the entries in the bag. <br>
     *         Note: If the bag is empty, the returned array is empty.
     */
    public T[] toArray() {
        // The cast is safe because the new array contains null entries
        @SuppressWarnings("unchecked")
        T[] result = (T[]) new Object[numEntries];
        int index = 0;
        Node<T> currentNode = firstNode;
        while ((index < numEntries) && (currentNode != null)) {
            result[index] = currentNode.getData();
            currentNode = currentNode.getNext();
            index++;
        }
        return result;
    }

    private Node<T> getReferenceTo(T anEntry) {
        Node<T> currentNode = firstNode;
        boolean found = false;
        while (!found && (currentNode != null)) {
            if (anEntry.equals(currentNode.getData()))
                found = true;
            else
                currentNode = currentNode.getNext();
        }
        return currentNode;
    }
} // end ArrayBag
