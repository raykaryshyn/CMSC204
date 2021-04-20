import java.util.HashSet;
import java.util.Set;

/**
 * Represents a graph with a HashSet of Node objects.
 * 
 * @author Raymond Karyshyn
 * @see https://www.baeldung.com/java-dijkstra
 */
public class Graph {
    private Set<Node> nodes;

    public Graph() {
        nodes = new HashSet<>();
    }

    public void addNode(Node nodeA) {
        nodes.add(nodeA);
    }

    public Set<Node> getNodes() {
        return nodes;
    }

    public void setNodes(Set<Node> nodes) {
        this.nodes = nodes;
    }
}
