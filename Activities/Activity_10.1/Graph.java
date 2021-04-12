import java.util.*;

/**
 * Class to represent a graph. 
 * 
 * @see https://www.softwaretestinghelp.com/java-graph-tutorial/
 * @author Raymond Karyshyn
 */
public class Graph {
    List<List<Node>> adj_list = new ArrayList<>();

    public Graph(int v) {
        for (int i = 0; i < v; i++)
            adj_list.add(i, new ArrayList<>());
    }

    public void addEdge(Edge edge) {
        adj_list.get(edge.getSrc()).add(new Node(edge.getDest(), edge.getWeight()));
    }

    public void adjacencyList() {
        int src_vertex = 0;
        int list_size = adj_list.size();

        while (src_vertex < list_size) {
            System.out.print("Vertex:" + src_vertex);

            for (Node edge : adj_list.get(src_vertex)) {
                System.out.print("\t==> " + edge.getValue() + " (" + edge.getWeight() + ")");
            }

            System.out.println();
            src_vertex++;
        }
    }

    void DFS(int v) {
        boolean visited[] = new boolean[adj_list.size()];

        DFS_helper(v, visited);

        System.out.println();
    }

    void DFS_helper(int v, boolean visited[]) {
        visited[v] = true;
        System.out.print(v + " ");

        Iterator<Node> i = adj_list.get(v).listIterator();
        while (i.hasNext()) {
            int n = i.next().getValue();
            if (!visited[n])
                DFS_helper(n, visited);
        }
    }

    void BFS(int root_node) {
        boolean visited[] = new boolean[adj_list.size()];

        LinkedList<Integer> queue = new LinkedList<Integer>();

        visited[root_node] = true;
        queue.add(root_node);

        while (queue.size() != 0) {
            root_node = queue.poll();
            System.out.print(root_node + " ");

            Iterator<Node> i = adj_list.get(root_node).listIterator();
            while (i.hasNext()) {
                int n = i.next().getValue();
                if (!visited[n]) {
                    visited[n] = true;
                    queue.add(n);
                }
            }
        }

        System.out.println();
    }
}
