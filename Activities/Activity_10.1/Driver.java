/**
 * Main driver to implement the Graph class.
 * 
 * @see https://www.softwaretestinghelp.com/java-graph-tutorial/
 * @author Raymond Karyshyn
 */
class Driver {
    public static void main(String[] args) {
        Graph graph = new Graph(5);

        graph.addEdge(new Edge(0, 1, 2));
        graph.addEdge(new Edge(0, 2, 10));
        graph.addEdge(new Edge(0, 3, 5));
        graph.addEdge(new Edge(1, 2, 3));
        graph.addEdge(new Edge(2, 4, 4));

        System.out.println("Adjacency List:");
        graph.adjacencyList();

        System.out.println("\nDepth-First Traversal (with 0 as starting vertex):");
        graph.DFS(0);

        System.out.println("\nBreadth-First Traversal (with 0 as starting vertex):");
        graph.BFS(0);
    }
}
