import static org.junit.Assert.*;
import org.junit.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;

public class Graph_STUDENT_Test {
    private GraphInterface<Town, Road> graph;
    private Town[] town;

    @Before
    public void setUp() throws Exception {
        graph = new Graph();
        town = new Town[5];

        for (int i = 0; i < town.length; i++) {
            town[i] = new Town("Town " + i);
            graph.addVertex(town[i]);
        }

        graph.addEdge(town[0], town[1], 10, "Road A");
        graph.addEdge(town[0], town[2], 20, "Road B");
        graph.addEdge(town[0], town[3], 30, "Road C");
        graph.addEdge(town[0], town[4], 40, "Road D");
        graph.addEdge(town[1], town[2], 50, "Road E");
        graph.addEdge(town[2], town[3], 60, "Road F");
        graph.addEdge(town[3], town[4], 70, "Road G");
        graph.addEdge(town[4], town[1], 80, "Road H");
    }

    @After
    public void tearDown() throws Exception {
        graph = null;
    }

    @Test
    public void testGetEdge() {
        assertEquals(new Road(town[1], town[4], 80, "Road H"), graph.getEdge(town[4], town[1]));
        assertEquals(new Road(town[2], town[0], 20, "Road B"), graph.getEdge(town[0], town[2]));
    }

    @Test
    public void testAddEdge() {
        assertEquals(false, graph.containsEdge(town[1], town[3]));
        graph.addEdge(town[3], town[1], 1, "Road I");
        assertEquals(true, graph.containsEdge(town[1], town[3]));
        assertEquals(true, graph.containsEdge(town[3], town[1]));
    }

    @Test
    public void testAddVertex() {
        Town newTown = new Town("Town 5");
        assertEquals(false, graph.containsVertex(newTown));
        graph.addVertex(newTown);
        assertEquals(true, graph.containsVertex(newTown));
    }

    @Test
    public void testContainsEdge() {
        assertEquals(true, graph.containsEdge(town[4], town[3]));
        assertEquals(false, graph.containsEdge(town[1], town[3]));
    }

    @Test
    public void testContainsVertex() {
        assertEquals(true, graph.containsVertex(new Town("Town 4")));
        assertEquals(false, graph.containsVertex(new Town("Town 5")));
    }

    @Test
    public void testEdgeSet() {
        Set<Road> roads = graph.edgeSet();
        ArrayList<String> roadArrayList = new ArrayList<String>();
        for (Road road : roads)
            roadArrayList.add(road.getName());
        Collections.sort(roadArrayList);
        assertEquals("Road A", roadArrayList.get(0));
        assertEquals("Road B", roadArrayList.get(1));
        assertEquals("Road C", roadArrayList.get(2));
        assertEquals("Road D", roadArrayList.get(3));
        assertEquals("Road E", roadArrayList.get(4));
        assertEquals("Road F", roadArrayList.get(5));
        assertEquals("Road G", roadArrayList.get(6));
        assertEquals("Road H", roadArrayList.get(7));
    }

    @Test
    public void testEdgesOf() {
        Set<Road> roads = graph.edgesOf(town[0]);
        ArrayList<String> roadArrayList = new ArrayList<String>();
        for (Road road : roads)
            roadArrayList.add(road.getName());
        Collections.sort(roadArrayList);
        assertEquals("Road A", roadArrayList.get(0));
        assertEquals("Road B", roadArrayList.get(1));
        assertEquals("Road C", roadArrayList.get(2));
        assertEquals("Road D", roadArrayList.get(3));
    }

    @Test
    public void testRemoveEdge() {
        assertEquals(true, graph.containsEdge(town[1], town[2]));
        graph.removeEdge(town[2], town[1], 50, "Road E");
        assertEquals(false, graph.containsEdge(town[1], town[2]));
    }

    @Test
    public void testRemoveVertex() {
        assertEquals(true, graph.containsVertex(town[4]));
        graph.removeVertex(town[4]);
        assertEquals(false, graph.containsVertex(town[4]));
    }

    @Test
    public void testVertexSet() {
        Set<Town> roads = graph.vertexSet();
        assertEquals(true, roads.contains(town[0]));
        assertEquals(true, roads.contains(town[1]));
        assertEquals(true, roads.contains(town[2]));
        assertEquals(true, roads.contains(town[3]));
        assertEquals(true, roads.contains(town[4]));
    }

    @Test
    public void testTown4ToTown2() {
        String beginTown = "Town 4", endTown = "Town 2";
        Town beginIndex = null, endIndex = null;
        Set<Town> towns = graph.vertexSet();
        Iterator<Town> iterator = towns.iterator();
        while (iterator.hasNext()) {
            Town town = iterator.next();
            if (town.getName().equals(beginTown))
                beginIndex = town;
            if (town.getName().equals(endTown))
                endIndex = town;
        }
        if (beginIndex != null && endIndex != null) {
            ArrayList<String> path = graph.shortestPath(beginIndex, endIndex);
            assertNotNull(path);
            assertTrue(path.size() > 0);
            assertEquals("Town 4 via Road D to Town 0 40 mi", path.get(0).trim());
            assertEquals("Town 0 via Road B to Town 2 20 mi", path.get(1).trim());
        } else
            fail("Town names are not valid");

    }

    @Test
    public void testTown0ToTown4() {
        String beginTown = "Town 0", endTown = "Town 4";
        Town beginIndex = null, endIndex = null;
        Set<Town> towns = graph.vertexSet();
        Iterator<Town> iterator = towns.iterator();
        while (iterator.hasNext()) {
            Town town = iterator.next();
            if (town.getName().equals(beginTown))
                beginIndex = town;
            if (town.getName().equals(endTown))
                endIndex = town;
        }
        if (beginIndex != null && endIndex != null) {
            ArrayList<String> path = graph.shortestPath(beginIndex, endIndex);
            assertNotNull(path);
            assertTrue(path.size() > 0);
            assertEquals("Town 0 via Road D to Town 4 40 mi", path.get(0).trim());
        } else
            fail("Town names are not valid");

    }

    @Test
    public void testTown1ToTown3() {
        String beginTown = "Town 1", endTown = "Town 3";
        Town beginIndex = null, endIndex = null;
        Set<Town> towns = graph.vertexSet();
        Iterator<Town> iterator = towns.iterator();
        while (iterator.hasNext()) {
            Town town = iterator.next();
            if (town.getName().equals(beginTown))
                beginIndex = town;
            if (town.getName().equals(endTown))
                endIndex = town;
        }
        if (beginIndex != null && endIndex != null) {
            ArrayList<String> path = graph.shortestPath(beginIndex, endIndex);
            assertNotNull(path);
            assertTrue(path.size() > 0);
            assertEquals("Town 1 via Road A to Town 0 10 mi", path.get(0).trim());
            assertEquals("Town 0 via Road C to Town 3 30 mi", path.get(1).trim());
        } else
            fail("Town names are not valid");

    }
}
