import org.junit.*;
import static org.junit.Assert.*;

public class Road_STUDENT_Test {
    Town source, destination;
    int weight;
    String name;
    Road road;

    @Before
    public void setUp() throws Exception {
        source = new Town("Town A");
        destination = new Town("Town B");
        weight = 50;
        name = "My Road";

        road = new Road(source, destination, weight, name);
    }

    @After
    public void tearDown() throws Exception {
        source = null;
        destination = null;
        weight = 0;
        name = null;

        road = null;
    }

    @Test
    public void testCompareTo() {
        assertEquals(true, road.compareTo(new Road(source, destination, 10, "My Other Road")) > 0);
        assertEquals(true, road.compareTo(new Road(source, destination, 10, "My Zesty Road")) < 0);
        assertEquals(true, road.compareTo(new Road(source, destination, 10, "My Road")) == 0);
    }

    @Test
    public void testContains() {
        assertEquals(true, road.contains(source));
        assertEquals(true, road.contains(destination));
        assertEquals(false, road.contains(new Town("Cool Town")));
    }

    @Test
    public void testEquals() {
        assertEquals(true, road.equals(new Road(source, destination, weight, name)));
        assertEquals(true, road.equals(new Road(destination, source, weight, name)));
        assertEquals(false, road.equals(new Road(new Town("Town..."), source, weight, name)));
    }

    @Test
    public void testGetDestination() {
        assertEquals(destination, road.getDestination());
    }

    @Test
    public void testGetName() {
        assertEquals(name, road.getName());
    }

    @Test
    public void testGetSource() {
        assertEquals(source, road.getSource());
    }

    @Test
    public void testGetWeight() {
        assertEquals(weight, road.getWeight());
    }

    @Test
    public void testToString() {
        assertEquals(name + "," + weight + "," + source + ";" + destination, road.toString());
    }

    @Test
    public void testHashCode() {
        assertEquals(String.valueOf(name + "," + weight + "," + source + ";" + destination).hashCode(),
                road.hashCode());
    }
}
