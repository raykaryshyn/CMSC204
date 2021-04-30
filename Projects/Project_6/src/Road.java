/**
 * The class Road that can represent the edges of a Graph of Towns. The class
 * must implement Comparable. The class stores references to the two
 * vertices(Town endpoints), the distance between vertices, and a name, and the
 * traditional methods (constructors, getters/setters, toString, etc.), and a
 * compareTo, which compares two Road objects. Since this is a undirected graph,
 * an edge from A to B is equal to an edge from B to A.
 * 
 * @author Raymond Karyshyn
 */
public class Road implements Comparable<Road> {
    private Town source, destination;
    private int weight;
    private String name;

    /**
     * Contructor.
     * 
     * @param source      One town on the road
     * @param destination Another town on the road
     * @param weight      Weight of the edge (i.e. distance from one town to the
     *                    other)
     * @param name        Name of the road
     */
    public Road(Town source, Town destination, int weight, String name) {
        this.source = source;
        this.destination = destination;
        this.weight = weight;
        this.name = name;
    }

    /**
     * Constructor with weight preset at 1.
     * 
     * @param source      One town on the road
     * @param destination Another town on the road
     * @param name        Name of the road
     */
    public Road(Town source, Town destination, String name) {
        this(source, destination, 1, name);
    }

    /**
     * Compare to method.
     * 
     * @return 0 if the road names are the same, a positive or negative number if
     *         the road names are not the same
     */
    public int compareTo(Road o) {
        return name.compareTo(o.name);
    }

    /**
     * Returns true only if the edge contains the given town.
     * 
     * @param o a vertex of the graph
     * @return true only if the edge is connected to the given vertex
     */
    public boolean contains(Town town) {
        return (source.getName().equals(town.getName()) || destination.getName().equals(town.getName()));
    }

    /**
     * Returns true if each of the ends of the road r is the same as the ends of
     * this road. Remember that a road that goes from point A to point B is the same
     * as a road that goes from point B to point A.
     * 
     * @param o road object to compare it to
     */
    public boolean equals(Object o) {
        Road road = (Road) o;
        return ((source.equals(road.source) && destination.equals(road.destination)
                || (source.equals(road.destination) && destination.equals(road.source))));
    }

    /**
     * Returns the second town on the road.
     * 
     * @return A town on the road
     */
    public Town getDestination() {
        return destination;
    }

    /**
     * Returns the road name.
     * 
     * @return The name of the road
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the first town on the road.
     * 
     * @return A town on the road
     */
    public Town getSource() {
        return source;
    }

    /**
     * Returns the distance of the road.
     * 
     * @return the distance of the road
     */
    public int getWeight() {
        return weight;
    }

    /**
     * To string method.
     */
    public String toString() {
        return name + "," + weight + "," + source + ";" + destination;
    }

    /**
     * Hash code method.
     * 
     * @return the hashcode for the name of the road
     */
    public int hashCode() {
        return String.valueOf(toString()).hashCode();
    }
}
