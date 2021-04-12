/**
 * Class to represent a node of a graph. 
 * 
 * @see https://www.softwaretestinghelp.com/java-graph-tutorial/
 * @author Raymond Karyshyn
 */
public class Node {
    private int value, weight;

    Node(int value, int weight) {
        this.value = value;
        this.weight = weight;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
}
