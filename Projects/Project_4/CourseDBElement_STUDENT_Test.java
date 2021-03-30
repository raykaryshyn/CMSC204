import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CourseDBElement_STUDENT_Test {
    CourseDBElement element;

    @Before
    public void setUp() throws Exception {
        element = new CourseDBElement("123", 456, 3, "Upstairs", "Bob Smith");
    }

    @After
    public void tearDown() throws Exception {
        element = null;
    }

    @Test
    public void testGetTableSize() {
        System.out.println(element.hashCode());
    }
}
