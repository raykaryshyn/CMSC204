import org.junit.*;
import static org.junit.Assert.*;

public class GradebookTester {
    private GradeBook g1;
    private GradeBook g2;

    @Before
    public void setUp() {
        g1 = new GradeBook(5);
        g1.addScore(90);
        g1.addScore(67);
        g1.addScore(88);
        g1.addScore(96);
        g1.addScore(67);

        g2 = new GradeBook(5);
        g2.addScore(88);
        g2.addScore(99);
        g2.addScore(86);
        g2.addScore(95);
        g2.addScore(68);
    }

    @After
	public void tearDown() throws Exception {
        g1 = null;
        g2 = null;
    }
    
    @Test
    public void addScoreTest() {
        assertTrue(g1.toString().equals("90.0, 67.0, 88.0, 96.0, 67.0"));
        assertTrue(g2.toString().equals("88.0, 99.0, 86.0, 95.0, 68.0"));

        assertEquals(5, g1.getScoreSize());
        assertEquals(5, g2.getScoreSize());
    }

    @Test
    public void sumTest() {
        assertEquals(408.0, g1.sum(), 0);
        assertEquals(436.0, g2.sum(), 0);
    }

    @Test
    public void minimumTest() {
        assertEquals(67.0, g1.minimum(), 0);
        assertEquals(68.0, g2.minimum(), 0);
    }

    @Test
    public void finalScoreTest() {
        assertEquals(341.0, g1.finalScore(), 0);
        assertEquals(368.0, g2.finalScore(), 0);
    }
}
