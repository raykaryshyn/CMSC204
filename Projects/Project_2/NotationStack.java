import java.util.Vector;
import java.util.ArrayList;

public class NotationStack<T> implements StackInterface<T> {
    private Vector<T> stack;
    private int size;
    private static final int DEFAULT_CAPACITY = 50;

    public NotationStack() {
        this(DEFAULT_CAPACITY);
    }

    public NotationStack(int initialCapacity) {
        size = initialCapacity;
        stack = new Vector<T>(initialCapacity);
    }

    /**
     * Determines if stack is empty.
     * 
     * @return True if stack is empty, False if not.
     */
    public boolean isEmpty() {
        return stack.isEmpty();
    }

    /**
     * Determines if the stack is full.
     * 
     * @return True if stack is full, False if not.
     */
    public boolean isFull() {
        return stack.size() >= size;
    }

    /**
     * Deletes and returns the element at the front of the stack.
     * 
     * @return The element at the front of the stack.
     */
    public T pop() throws StackUnderflowException {
        if (isEmpty())
            throw new StackUnderflowException();

        return stack.remove(stack.size() - 1);
    }

    /**
     * Returns the element at the top of the stack, does not pop it off the stack.
     * 
     * @return The element at the top of the stack.
     */
    public T top() throws StackUnderflowException {
        if (isEmpty())
            throw new StackUnderflowException();

        return stack.lastElement();
    }

    /**
     * Gets the number of elements in the stack.
     * 
     * @return The number of elements in the stack.
     */
    public int size() {
        return stack.size();
    }

    /**
     * Adds an element to the end of the stack.
     * 
     * @param e The element to add to the end of the stack.
     * @return True if the add was successful, False if not.
     */
    public boolean push(T e) throws StackOverflowException {
        if (isFull())
            throw new StackOverflowException();

        return stack.add(e);
    }

    /**
     * Returns the string representation of the elements in the stack, the beginning
     * of the string is the front of the stack.
     * 
     * @return String representation of the stack with elements.
     */
    public String toString() {
        String result = "";

        for (T e : stack)
            result += e;

        return result;
    }

    /**
     * Returns the string representation of the elements in the stack, the beginning
     * of the string is the front of the stack Place the delimiter between all
     * elements of the stack.
     * 
     * @return String representation of the stack with elements separated with the
     *         delimiter.
     */
    public String toString(String delimiter) {
        String result = "";

        for (T e : stack)
            result += e + delimiter;

        return result.substring(0, result.length() - delimiter.length());
    }

    /**
     * Fills the stack with the elements of the ArrayList. <br>
     * First element in the ArrayList is the first element in the stack. <br>
     * <br>
     * YOU MUST MAKE A COPY OF LIST AND ADD THOSE ELEMENTS TO THE stack. <br>
     * If you use the list reference within your stack, you will be allowing direct
     * access to the data of your stack causing a possible security breech.
     * 
     * @param list The elements to be added to the stack.
     */
    public void fill(ArrayList<T> list) {
        ArrayList<T> clone = new ArrayList<>(list);

        for (T e : clone) {
            push(e);
        }
    }
}
