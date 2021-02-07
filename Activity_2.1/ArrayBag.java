/**
 * ...
 * 
 * @author Raymond Karyshyn
 */
public final class ArrayBag<T> implements BagInterface<T> {
    private Node<T> firstNode;
    private int numberOfEntries;

    public ArrayBag() {
        firstNode = null;
        numberOfEntries = 0;
    }

    public boolean isEmpty() {
        return numberOfEntries == 0;
    }

    public int getCapacity() {
        return Integer.MAX_VALUE;
    }

    public int getCurrentSize() {
        return numberOfEntries;
    }

    public boolean add(T newEntry) {
        Node<T> newNode = new Node<T>(newEntry);
        newNode.setNext(firstNode);
        firstNode = newNode;
        numberOfEntries++;
        return true;
    }

    public T[] toArray() {
        @SuppressWarnings("unchecked")
        T[] result = (T[]) new Object[numberOfEntries];
        int index = 0;
        Node<T> currentNode = firstNode;
        while ((index < numberOfEntries) && (currentNode != null)) {
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
        while ((counter < numberOfEntries) && (currentNode != null)) {
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
            numberOfEntries--;
        }
        return result;
    }

    public boolean remove(T anEntry) {
        boolean result = false;
        Node<T> NodeN = getReferenceTo(anEntry);
        if (NodeN != null) {
            NodeN.setData(firstNode.getData());
            firstNode = firstNode.getNext();
            numberOfEntries--;
            result = true;
        }
        return result;
    }
}