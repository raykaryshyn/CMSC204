/**
 * Represents an town as a node of a graph. The Town class holds the name of the
 * town and a list of adjacent towns, and other fields as desired, and the
 * traditional methods (constructors, getters/setters, toString, etc.). It will
 * implement the Comparable interface These are the minimum methods that are
 * needed. Please feel free to add as many methods as you need.
 * 
 * @author Raymond Karyshyn
 */
public class Town implements Comparable<Town> {
    private String name;

    /**
     * Constructor. Requires town's name.
     * 
     * @param name
     */
    public Town(String name) {
        this.name = name;
    }

    /**
     * Copy constructor.
     * 
     * @param templateTown an instance of Town
     */
    public Town(Town templateTown) {
        name = templateTown.getName();
    }

    /**
     * Compare to method.
     * 
     * @return 0 if names are equal, a positive or negative number if the names are
     *         not equal
     */
    public int compareTo(Town o) {
        return name.compareTo(o.name);
    }

    public boolean equals(Object o) {
        return true;
    }

    /**
     * Returns the town's name.
     * 
     * @return town's name
     */
    public String getName() {
        return name;
    }

    /**
     * Hash code method.
     * 
     * @return the hashcode for the name of the town
     */
    public int hashCode() {
        return String.valueOf(name).hashCode();
    }

    /**
     * To string method.
     * 
     * @return the town's name
     */
    public String toString() {
        return name;
    }
}