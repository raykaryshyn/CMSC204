import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The root interface in the graph hierarchy. A mathematical graph-theory graph
 * object G(V,E) contains a set V of vertices and a set E of edges. Each edge
 * e=(v1,v2) in E connects vertex v1 to vertex v2.
 *
 * Through generics, a graph can be typed to specific classes for vertices V and
 * edges E<T>. Such a graph can contain vertices of type V and all sub-types and
 * Edges of type E and all sub-types.
 * 
 * @author Raymond Karyshyn
 */
public class Graph implements GraphInterface<Town, Road> {
    private Set<Town> towns;
    private Set<Road> roads;
    private Map<Town, List<Town>> adjacencyList;
    Map<Town, Town> previousVerticies;

    public Graph() {
        towns = new HashSet<>();
        roads = new HashSet<>();
        adjacencyList = new HashMap<>();
        previousVerticies = new HashMap<>();
    }

    /**
     * Returns an edge connecting source vertex to target vertex if such vertices
     * and such edge exist in this graph. Otherwise returns null. If any of the
     * specified vertices is null returns null
     *
     * In undirected graphs, the returned edge may have its source and target
     * vertices in the opposite order.
     *
     * @param sourceVertex      source vertex of the edge.
     * @param destinationVertex target vertex of the edge.
     *
     * @return an edge connecting source vertex to target vertex.
     */
    public Road getEdge(Town sourceVertex, Town destinationVertex) {
        for (Road road : roads) {
            if (road.contains(sourceVertex) && road.contains(destinationVertex))
                return road;
        }

        return null;
    }

    /**
     * Creates a new edge in this graph, going from the source vertex to the target
     * vertex, and returns the created edge.
     * 
     * The source and target vertices must already be contained in this graph. If
     * they are not found in graph IllegalArgumentException is thrown.
     *
     *
     * @param sourceVertex      source vertex of the edge.
     * @param destinationVertex target vertex of the edge.
     * @param weight            weight of the edge
     * @param description       description for edge
     *
     * @return The newly created edge if added to the graph, otherwise null.
     *
     * @throws IllegalArgumentException if source or target vertices are not found
     *                                  in the graph.
     * @throws NullPointerException     if any of the specified vertices is null.
     */
    public Road addEdge(Town sourceVertex, Town destinationVertex, int weight, String description)
            throws IllegalArgumentException, NullPointerException {
        if (sourceVertex == null || destinationVertex == null)
            throw new NullPointerException();

        if (!towns.contains(sourceVertex) || !towns.contains(destinationVertex))
            throw new IllegalArgumentException();

        Road road = new Road(sourceVertex, destinationVertex, weight, description);
        roads.add(road);
        return road;
    }

    /**
     * Adds the specified vertex to this graph if not already present. More
     * formally, adds the specified vertex, v, to this graph if this graph contains
     * no vertex u such that u.equals(v). If this graph already contains such
     * vertex, the call leaves this graph unchanged and returns false. In
     * combination with the restriction on constructors, this ensures that graphs
     * never contain duplicate vertices.
     *
     * @param v vertex to be added to this graph.
     *
     * @return true if this graph did not already contain the specified vertex.
     *
     * @throws NullPointerException if the specified vertex is null.
     */
    public boolean addVertex(Town v) throws NullPointerException {
        if (v == null)
            throw new NullPointerException();

        if (!towns.contains(v)) {
            towns.add(v);
            return true;
        }

        return false;
    }

    /**
     * Returns true if and only if this graph contains an edge going from the source
     * vertex to the target vertex. In undirected graphs the same result is obtained
     * when source and target are inverted. If any of the specified vertices does
     * not exist in the graph, or if is null, returns false.
     *
     * @param sourceVertex      source vertex of the edge.
     * @param destinationVertex target vertex of the edge.
     *
     * @return true if this graph contains the specified edge.
     */
    public boolean containsEdge(Town sourceVertex, Town destinationVertex) {
        if (getEdge(sourceVertex, destinationVertex) != null)
            return true;

        return false;
    }

    /**
     * Returns true if this graph contains the specified vertex. More formally,
     * returns true if and only if this graph contains a vertex u such that
     * u.equals(v). If the specified vertex is null returns false.
     *
     * @param v vertex whose presence in this graph is to be tested.
     *
     * @return true if this graph contains the specified vertex.
     */
    public boolean containsVertex(Town v) {
        return towns.contains(v);
    }

    /**
     * Returns a set of the edges contained in this graph. The set is backed by the
     * graph, so changes to the graph are reflected in the set. If the graph is
     * modified while an iteration over the set is in progress, the results of the
     * iteration are undefined.
     *
     * @return a set of the edges contained in this graph.
     */
    public Set<Road> edgeSet() {
        return roads;
    }

    /**
     * Returns a set of all edges touching the specified vertex (also referred to as
     * adjacent vertices). If no edges are touching the specified vertex returns an
     * empty set.
     *
     * @param vertex the vertex for which a set of touching edges is to be returned.
     *
     * @return a set of all edges touching the specified vertex.
     *
     * @throws IllegalArgumentException if vertex is not found in the graph.
     * @throws NullPointerException     if vertex is null.
     */
    public Set<Road> edgesOf(Town vertex) throws IllegalArgumentException, NullPointerException {
        Set<Road> edges = new HashSet<>();

        for (Road r : roads) {
            if (r.contains(vertex))
                edges.add(r);
        }

        return edges;
    }

    /**
     * Removes an edge going from source vertex to target vertex, if such vertices
     * and such edge exist in this graph.
     * 
     * If weight > -1 it must be checked. If description != null, it must be checked
     * 
     * Returns the edge if removed or null otherwise.
     *
     * @param sourceVertex      source vertex of the edge.
     * @param destinationVertex target vertex of the edge.
     * @param weight            weight of the edge
     * @param description       description of the edge
     *
     * @return The removed edge, or null if no edge removed.
     */
    public Road removeEdge(Town sourceVertex, Town destinationVertex, int weight, String description) {
        Road temp = new Road(sourceVertex, destinationVertex, weight, description);

        if (roads.contains(temp) && weight > -1 && description != null) {
            roads.remove(temp);
            return temp;
        }

        return null;
    }

    /**
     * Removes the specified vertex from this graph including all its touching edges
     * if present. More formally, if the graph contains a vertex u such that
     * u.equals(v), the call removes all edges that touch u and then removes u
     * itself. If no such u is found, the call leaves the graph unchanged. Returns
     * true if the graph contained the specified vertex. (The graph will not contain
     * the specified vertex once the call returns).
     *
     * If the specified vertex is null returns false.
     *
     * @param v vertex to be removed from this graph, if present.
     *
     * @return true if the graph contained the specified vertex; false otherwise.
     */
    public boolean removeVertex(Town v) {
        return towns.remove(v);
    }

    /**
     * Returns a set of the vertices contained in this graph. The set is backed by
     * the graph, so changes to the graph are reflected in the set. If the graph is
     * modified while an iteration over the set is in progress, the results of the
     * iteration are undefined.
     * 
     * @return a set view of the vertices contained in this graph.
     */
    public Set<Town> vertexSet() {
        return towns;
    }

    /**
     * Find the shortest path from the sourceVertex to the destinationVertex call
     * the dijkstraShortestPath with the sourceVertex
     * 
     * @param sourceVertex      starting vertex
     * @param destinationVertex ending vertex
     * @return An arraylist of Strings that describe the path from sourceVertex to
     *         destinationVertex They will be in the format: startVertex "via" Edge
     *         "to" endVertex weight As an example: if finding path from Vertex_1 to
     *         Vertex_10, the ArrayList<String> would be in the following format
     *         (this is a hypothetical solution): Vertex_1 via Edge_2 to Vertex_3 4
     *         (first string in ArrayList) Vertex_3 via Edge_5 to Vertex_8 2 (second
     *         string in ArrayList) Vertex_8 via Edge_9 to Vertex_10 2 (third string
     *         in ArrayList)
     */
    public ArrayList<String> shortestPath(Town sourceVertex, Town destinationVertex) {
        ArrayList<String> arrayList = new ArrayList<String>();

        dijkstraShortestPath(sourceVertex);
        System.out.println(previousVerticies);

        Town nextTown = destinationVertex;
        while (!nextTown.equals(sourceVertex)) {
            if (!previousVerticies.containsKey(nextTown) || previousVerticies.get(nextTown) == null)
                break;

            Town previousTown = previousVerticies.get(nextTown);
            Road edge = getEdge(previousTown, nextTown);
            arrayList.add(0, previousTown.getName() + " via " + edge.getName() + " to " + nextTown.getName() + " "
                    + edge.getWeight() + " mi");
            nextTown = previousTown;
        }

        return arrayList;
    }

    /**
     * Dijkstra's Shortest Path Method. Internal structures are built which hold the
     * ability to retrieve the path, shortest distance from the sourceVertex to all
     * the other vertices in the graph, etc.
     * 
     * @param sourceVertex the vertex to find shortest path from
     */
    public void dijkstraShortestPath(Town sourceVertex) {
        Map<Town, Integer> dist = new HashMap<>();
        Map<Town, Town> previous = new HashMap<>();

        buildAdjacencyList();

        for (Town town : towns) {
            dist.put(town, Integer.MAX_VALUE);
            previous.put(town, null);
        }

        dist.replace(sourceVertex, 0);

        Set<Town> Q = new HashSet<Town>(dist.keySet());

        while (!Q.isEmpty()) {
            Iterator<Town> Q_iterator = Q.iterator();
            Town u = Q_iterator.next();
            while (Q_iterator.hasNext()) {
                Town town = Q_iterator.next();
                if (dist.get(town) < dist.get(u)) {
                    u = town;
                }
            }

            Q.remove(u);

            for (Town v : adjacencyList.get(u)) {
                if (Q.contains(v)) {
                    int alt = dist.get(u) + getEdge(u, v).getWeight();
                    if (alt < dist.get(v)) {
                        dist.replace(v, alt);
                        previous.replace(v, u);
                    }
                }
            }
        }

        previousVerticies = previous;
    }

    private void buildAdjacencyList() {
        adjacencyList = new HashMap<>();

        for (Town town : towns) {
            adjacencyList.put(town, new LinkedList<>());
        }

        for (Road road : roads) {
            adjacencyList.get(road.getSource()).add(road.getDestination());
            adjacencyList.get(road.getDestination()).add(road.getSource());
        }
    }
}
