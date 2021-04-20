import java.util.Arrays;
import java.util.List;

/**
 * Simulation of Dijkstra's algorithm.
 * 
 * @author Raymond Karyshyn
 * @see https://www.baeldung.com/java-dijkstra
 */
public class Driver {
    public static void main(String[] args) {
        Node nodeA = new Node("A");
        Node nodeB = new Node("B");
        Node nodeC = new Node("C");
        Node nodeD = new Node("D");
        Node nodeE = new Node("E");
        Node nodeF = new Node("F");

        nodeA.addDestination(nodeB, 10);
        nodeA.addDestination(nodeC, 15);

        nodeB.addDestination(nodeD, 12);
        nodeB.addDestination(nodeF, 15);

        nodeC.addDestination(nodeE, 10);

        nodeD.addDestination(nodeE, 2);
        nodeD.addDestination(nodeF, 1);

        nodeF.addDestination(nodeE, 5);

        Graph graph = new Graph();

        graph.addNode(nodeA);
        graph.addNode(nodeB);
        graph.addNode(nodeC);
        graph.addNode(nodeD);
        graph.addNode(nodeE);
        graph.addNode(nodeF);

        graph = Dijkstra.calculateShortestPathFromSource(graph, nodeA);

        List<Node> shortestPathForNodeB = Arrays.asList(nodeA);
        List<Node> shortestPathForNodeC = Arrays.asList(nodeA);
        List<Node> shortestPathForNodeD = Arrays.asList(nodeA, nodeB);
        List<Node> shortestPathForNodeE = Arrays.asList(nodeA, nodeB, nodeD);
        List<Node> shortestPathForNodeF = Arrays.asList(nodeA, nodeB, nodeD);

        for (Node node : graph.getNodes()) {
            switch (node.getName()) {
            case "B":
                System.out.println("It is " + node.getShortestPath().equals(shortestPathForNodeB)
                        + " that the shortest path for Node B is: A -> B.");
                break;
            case "C":
                System.out.println("It is " + node.getShortestPath().equals(shortestPathForNodeC)
                        + " that the shortest path for Node C is: A -> C.");
                break;
            case "D":
                System.out.println("It is " + node.getShortestPath().equals(shortestPathForNodeD)
                        + " that the shortest path for Node D is: A -> B -> D.");
                break;
            case "E":
                System.out.println("It is " + node.getShortestPath().equals(shortestPathForNodeE)
                        + " that the shortest path for Node E is: A -> B -> D -> E.");
                break;
            case "F":
                System.out.println("It is " + node.getShortestPath().equals(shortestPathForNodeF)
                        + " that the shortest path for Node F is: A -> B -> D -> F.");
                break;
            }
        }
    }
}
