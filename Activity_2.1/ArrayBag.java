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

    public boolean isEmpty() {
        return numEntries == 0;
    }

    public int getCapacity() {
        return Integer.MAX_VALUE;
    }

    public int getCurrentSize() {
        return numEntries;
    }

    public boolean add(T newEntry) {
        Node<T> newNode = new Node<T>(newEntry, firstNode);
        firstNode = newNode;
        numEntries++;
        return true;
    }

    public T[] toArray() {
        // The cast is safe because the new array contains null entries
        @SuppressWarnings("unchecked")
        T[] result = (T[]) new Object[numEntries];
        int index = 0;
        Node<T> currentNode = firstNode;
        while ((index < numEntries) && (currentNode != null)) {
            result[index] = currentNode.getData();
            index++;
            currentNode = currentNode.getNext();
        }
        return result;
    }

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

    public boolean contains(T anEntry) {
        boolean found = false;
        Node<T> currentNode = firstNode;
        while (!found && (currentNode != null)) {
            if (anEntry.equals(currentNode.getData())) {
                found = true;
            } else {
                currentNode = currentNode.getNext();
            }
        }
        return found;
    }

    private Node<T> getReferenceTo(T anEntry) {
        boolean found = false;
        Node<T> currentNode = firstNode;
        while (!found && (currentNode != null)) {
            if (anEntry.equals(currentNode.getData())) {
                found = true;
            } else {
                currentNode = currentNode.getNext();
            }
        }
        return currentNode;
    }

    public void clear() {
        while (!isEmpty()) {
            remove();
        }
    }

    public T remove() {
        T result = null;
        if (firstNode != null) {
            result = firstNode.getData();
            firstNode = firstNode.getNext();
            numEntries--;
        }
        return result;
    }

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
}