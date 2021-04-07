import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Student JUnit tests for the CourseDBElement class.
 * 
 * @author Raymond Karyshyn
 */
public class CourseDBElement_STUDENT_Test {
    CourseDBElement element1, element2, element3;

    @Before
    public void setUp() throws Exception {
        element1 = new CourseDBElement("123", 456, 3, "Upstairs", "Bob Smith");
        element2 = new CourseDBElement("234", 789, 3, "Downstairs", "Cob Smith");
        element3 = new CourseDBElement("345", 123, 4, "Basement", "Rob Smith");
    }

    @After
    public void tearDown() throws Exception {
        element1 = null;
    }

    @Test
    public void testHashCode() {
        System.out.println(element1.hashCode());
    }

    @Test
    public void testToString() {
        assertEquals(element1.toString(), "\nCourse:123 CRN:456 Credits:3 Instructor:Bob Smith Room:Upstairs");
        assertEquals(element2.toString(), "\nCourse:234 CRN:789 Credits:3 Instructor:Cob Smith Room:Downstairs");
        assertEquals(element3.toString(), "\nCourse:345 CRN:123 Credits:4 Instructor:Rob Smith Room:Basement");
    }

    @Test
    public void testCompareTo() {
        assertTrue(element1.compareTo(element1) == 0);
        assertTrue(element1.compareTo(element2) < 0);
        assertTrue(element1.compareTo(element3) > 0);
        assertTrue(element2.compareTo(element3) > 0);
        assertTrue(element3.compareTo(element2) < 0);
        assertTrue(element3.compareTo(element2) < 0);
    }
}
