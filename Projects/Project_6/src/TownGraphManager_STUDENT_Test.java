import static org.junit.Assert.*;
import org.junit.*;

import java.util.ArrayList;

public class TownGraphManager_STUDENT_Test {
    private TownGraphManagerInterface graph;
    private String[] town;

    @Before
    public void setUp() throws Exception {
        graph = new TownGraphManager();
        town = new String[5];

        for (int i = 0; i < town.length; i++) {
            town[i] = "Town " + i;
            graph.addTown(town[i]);
        }

        graph.addRoad(town[0], town[1], 10, "Road A");
        graph.addRoad(town[0], town[2], 20, "Road B");
        graph.addRoad(town[0], town[3], 30, "Road C");
        graph.addRoad(town[0], town[4], 40, "Road D");
        graph.addRoad(town[1], town[2], 50, "Road E");
        graph.addRoad(town[2], town[3], 60, "Road F");
        graph.addRoad(town[3], town[4], 70, "Road G");
        graph.addRoad(town[4], town[1], 80, "Road H");
    }

    @After
    public void tearDown() throws Exception {
        graph = null;
        town = null;
    }

    @Test
    public void testAddRoad() {
        ArrayList<String> roads = graph.allRoads();
        assertEquals("Road A", roads.get(0));
        assertEquals("Road B", roads.get(1));
        assertEquals("Road C", roads.get(2));
        assertEquals("Road D", roads.get(3));

        graph.addRoad(town[1], town[3], 1, "Road 100");
        roads = graph.allRoads();

        assertEquals("Road 100", roads.get(0));
    }

    @Test
    public void testGetRoad() {
        assertEquals("Road H", graph.getRoad(town[1], town[4]));
        assertEquals("Road F", graph.getRoad(town[3], town[2]));
    }

    @Test
    public void testAddTown() {
        assertEquals(false, graph.containsTown("Town 5"));
        graph.addTown("Town 5");
        assertEquals(true, graph.containsTown("Town 5"));
    }

    @Test
    public void testGetTown() {
        assertEquals(new Town(town[0]), graph.getTown("Town 0"));
        assertEquals(new Town(town[4]), graph.getTown("Town 4"));
    }

    @Test
    public void testContainsTown() {
        assertEquals(true, graph.containsTown("Town 0"));
        assertEquals(false, graph.containsTown("Town 1000"));
    }

    @Test
    public void testContainsRoadConnection() {
        assertEquals(true, graph.containsRoadConnection(town[1], town[2]));
        assertEquals(false, graph.containsRoadConnection(town[1], town[3]));
    }

    @Test
    public void testAllRoads() {
        ArrayList<String> roads = graph.allRoads();
        assertEquals("Road A", roads.get(0));
        assertEquals("Road B", roads.get(1));
        assertEquals("Road C", roads.get(2));
        assertEquals("Road D", roads.get(3));
        assertEquals("Road E", roads.get(4));
        assertEquals("Road F", roads.get(5));
        assertEquals("Road G", roads.get(6));
        assertEquals("Road H", roads.get(7));
    }

    @Test
    public void testDeleteRoadConnection() {
        assertEquals(true, graph.containsRoadConnection(town[0], town[1]));
        assertEquals(true, graph.deleteRoadConnection(town[1], town[0], "Road A"));
        assertEquals(false, graph.containsRoadConnection(town[0], town[1]));
    }

    @Test
    public void testDeleteTown() {
        assertEquals(true, graph.containsTown("Town 4"));
        graph.deleteTown(town[4]);
        assertEquals(false, graph.containsTown("Town 4"));
    }

    @Test
    public void testAllTowns() {
        ArrayList<String> towns = graph.allTowns();
        assertEquals("Town 0", towns.get(0));
        assertEquals("Town 1", towns.get(1));
        assertEquals("Town 2", towns.get(2));
        assertEquals("Town 3", towns.get(3));
        assertEquals("Town 4", towns.get(4));
    }

    @Test
    public void testGetPath() {
        ArrayList<String> path = graph.getPath(town[1], town[3]);
        assertNotNull(path);
        assertTrue(path.size() > 0);
        assertEquals("Town 1 via Road A to Town 0 10 mi", path.get(0).trim());
        assertEquals("Town 0 via Road C to Town 3 30 mi", path.get(1).trim());
    }
}
