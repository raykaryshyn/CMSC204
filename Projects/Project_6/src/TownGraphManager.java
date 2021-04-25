import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Set;

/**
 * Holds an object of Graph.
 * 
 * @author Raymond Karyshyn
 */
public class TownGraphManager implements TownGraphManagerInterface {
    private Graph graph;

    TownGraphManager() {
        graph = new Graph();
    }

    /**
     * Adds a road with 2 towns and a road name
     * 
     * @param town1    name of town 1 (lastname, firstname)
     * @param town2    name of town 2 (lastname, firstname)
     * @param roadName name of road
     * @return true if the road was added successfully
     */
    public boolean addRoad(String town1, String town2, int weight, String roadName) {
        if (graph.addEdge(new Town(town1), new Town(town2), weight, roadName) != null)
            return true;

        return false;
    }

    /**
     * Returns the name of the road that both towns are connected through
     * 
     * @param town1 name of town 1 (lastname, firstname)
     * @param town2 name of town 2 (lastname, firstname)
     * @return name of road if town 1 and town2 are in the same road, returns null
     *         if not
     */
    public String getRoad(String town1, String town2) {
        return graph.getEdge(new Town(town1), new Town(town2)).getName();
    }

    /**
     * Adds a town to the graph
     * 
     * @param v the town's name (lastname, firstname)
     * @return true if the town was successfully added, false if not
     */
    public boolean addTown(String v) {
        return graph.addVertex(new Town(v));
    }

    /**
     * Gets a town with a given name
     * 
     * @param name the town's name
     * @return the Town specified by the name, or null if town does not exist
     */
    public Town getTown(String name) {
        if (graph.vertexSet().contains(new Town(name))) {
            for (Town town : graph.vertexSet()) {
                if (town.equals(new Town(name)))
                    return town;
            }
        }

        return null;
    }

    /**
     * Determines if a town is already in the graph
     * 
     * @param v the town's name
     * @return true if the town is in the graph, false if not
     */
    public boolean containsTown(String v) {
        return graph.containsVertex(new Town(v));
    }

    /**
     * Determines if a road is in the graph
     * 
     * @param town1 name of town 1 (lastname, firstname)
     * @param town2 name of town 2 (lastname, firstname)
     * @return true if the road is in the graph, false if not
     */
    public boolean containsRoadConnection(String town1, String town2) {
        return graph.containsEdge(new Town(town1), new Town(town2));
    }

    /**
     * Creates an arraylist of all road titles in sorted order by road name
     * 
     * @return an arraylist of all road titles in sorted order by road name
     */
    public ArrayList<String> allRoads() {
        ArrayList<String> arrayList = new ArrayList<>();

        for (Road road : graph.edgeSet())
            arrayList.add(road.getName());

        Collections.sort(arrayList);
        return arrayList;
    }

    /**
     * Deletes a road from the graph
     * 
     * @param town1    name of town 1 (lastname, firstname)
     * @param town2    name of town 2 (lastname, firstname)
     * @param roadName the road name
     * @return true if the road was successfully deleted, false if not
     */
    public boolean deleteRoadConnection(String town1, String town2, String road) {
        Road e = graph.getEdge(new Town(town1), new Town(town2)), e_deleted = null;

        if (e != null)
            e_deleted = graph.removeEdge(new Town(town1), new Town(town2), e.getWeight(), e.getName());
        if (e_deleted != null)
            return true;

        return false;
    }

    /**
     * Deletes a town from the graph
     * 
     * @param v name of town (lastname, firstname)
     * @return true if the town was successfully deleted, false if not
     */
    public boolean deleteTown(String v) {
        return graph.removeVertex(new Town(v));
    }

    /**
     * Creates an arraylist of all towns in alphabetical order (last name, first
     * name)
     * 
     * @return an arraylist of all towns in alphabetical order (last name, first
     *         name)
     */
    public ArrayList<String> allTowns() {
        ArrayList<String> arrayList = new ArrayList<>();

        for (Town town : graph.vertexSet())
            arrayList.add(town.getName());

        Collections.sort(arrayList);
        return arrayList;
    }

    /**
     * Returns the shortest path from town 1 to town 2
     * 
     * @param town1 name of town 1 (lastname, firstname)
     * @param town2 name of town 2 (lastname, firstname)
     * @return an Arraylist of roads connecting the two towns together, null if the
     *         towns have no path to connect them.
     */
    public ArrayList<String> getPath(String town1, String town2) {
        return graph.shortestPath(new Town(town1), new Town(town2));
    }

    public void populateTownGraph(File selectedFile) throws FileNotFoundException, IOException {
        // TODO Auto-generated method stub
    }
}
