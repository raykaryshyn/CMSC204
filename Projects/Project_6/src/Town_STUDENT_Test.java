import org.junit.*;
import static org.junit.Assert.*;

public class Town_STUDENT_Test {
    String name;
    Town town;

    @Before
    public void setUp() throws Exception {
        name = "My Town";
        town = new Town(name);
    }

    @After
    public void tearDown() throws Exception {
        name = null;
        town = null;
    }

    @Test
    public void testCompareTo() {
        assertEquals(true, town.compareTo(new Town("My Other Town")) > 0);
        assertEquals(true, town.compareTo(new Town("My Zesty Town")) < 0);
        assertEquals(true, town.compareTo(new Town("My Town")) == 0);
    }

    @Test
    public void testEquals() {
        assertEquals(true, town.equals(new Town(name)));
        assertEquals(false, town.equals(new Town("Town...")));
    }

    @Test
    public void testGetName() {
        assertEquals(name, town.getName());
    }

    @Test
    public void testToString() {
        assertEquals(name, town.toString());
    }

    @Test
    public void testHashCode() {
        assertEquals(String.valueOf(name).hashCode(), town.hashCode());
    }
}
