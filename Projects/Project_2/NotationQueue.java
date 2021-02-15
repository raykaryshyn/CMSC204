import java.util.Vector;
import java.util.ArrayList;

public class NotationQueue<T> implements QueueInterface<T> {
    private Vector<T> queue;
    private int size;
    private static final int DEFAULT_CAPACITY = 50;

    public NotationQueue() {
        this(DEFAULT_CAPACITY);
    }

    public NotationQueue(int initialCapacity) {
        size = initialCapacity;
        queue = new Vector<T>(initialCapacity);
    }

    /**
     * Determines if queue is empty.
     * 
     * @return True if queue is empty, False if not.
     */
    public boolean isEmpty() {
        return queue.isEmpty();
    }

    /**
     * Determines if the queue is full.
     * 
     * @return True if queue is full, False if not.
     */
    public boolean isFull() {
        return queue.size() >= size;
    }

    /**
     * Deletes and returns the element at the front of the queue.
     * 
     * @return The element at the front of the queue.
     */
    public T dequeue() throws QueueUnderflowException {
        if (isEmpty())
            throw new QueueUnderflowException();

        return queue.remove(0);
    }

    /**
     * Gets the number of elements in the queue.
     * 
     * @return The number of elements in the queue.
     */
    public int size() {
        return queue.size();
    }

    /**
     * Adds an element to the end of the queue.
     * 
     * @param e The element to add to the end of the queue.
     * @return True if the add was successful, False if not.
     */
    public boolean enqueue(T e) throws QueueOverflowException {
        if (isFull())
            throw new QueueOverflowException();

        return queue.add(e);
    }

    /**
     * Returns the string representation of the elements in the queue, the beginning
     * of the string is the front of the queue.
     * 
     * @return String representation of the queue with elements.
     */
    public String toString() {
        String result = "";

        for (T e : queue)
            result += e;

        return result;
    }

    /**
     * Returns the string representation of the elements in the queue, the beginning
     * of the string is the front of the queue Place the delimiter between all
     * elements of the queue.
     * 
     * @return String representation of the queue with elements separated with the
     *         delimiter.
     */
    public String toString(String delimiter) {
        String result = "";

        for (T e : queue)
            result += e + delimiter;

        return result.substring(0, result.length() - delimiter.length());
    }

    /**
     * Fills the queue with the elements of the ArrayList. <br>
     * First element in the ArrayList is the first element in the queue. <br>
     * <br>
     * YOU MUST MAKE A COPY OF LIST AND ADD THOSE ELEMENTS TO THE QUEUE. <br>
     * If you use the list reference within your queue, you will be allowing direct
     * access to the data of your queue causing a possible security breech.
     * 
     * @param list The elements to be added to the queue.
     */
    public void fill(ArrayList<T> list) {
        ArrayList<T> clone = new ArrayList<>(list);

        for (T e : clone) {
            enqueue(e);
        }
    }
}
