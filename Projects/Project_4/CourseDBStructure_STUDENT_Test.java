import static org.junit.Assert.*;

import java.io.IOException;
import java.util.LinkedList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CourseDBStructure_STUDENT_Test {
    CourseDBStructure structure;
    CourseDBElement element1, element2, element3;

    @Before
    public void setUp() throws Exception {
        structure = new CourseDBStructure("Testing", 2);

        element1 = new CourseDBElement("123", 456, 3, "Upstairs", "Bob Smith");
        element2 = new CourseDBElement("234", 789, 3, "Downstairs", "Cob Smith");
        element3 = new CourseDBElement("345", 123, 4, "Basement", "Rob Smith");

        structure.add(element1);
        structure.add(element2);
        structure.add(element3);
    }

    @After
    public void tearDown() throws Exception {
        structure = null;
    }

    @Test
    public void testAddGet() {
        CourseDBElement element4 = new CourseDBElement("1", 4, 4, "Upstairs 1", "Bob Smith");
        CourseDBElement element5 = new CourseDBElement("2", 5, 4, "Upstairs 2", "Rob Smith");
        CourseDBElement element6 = new CourseDBElement("3", 6, 2, "Upstairs 3", "Tod Smith");

        structure.add(element4);
        structure.add(element5);
        structure.add(element6);

        try {
            assertEquals(structure.get(456).toString(), element1.toString());
            assertEquals(structure.get(789).toString(), element2.toString());
            assertEquals(structure.get(123).toString(), element3.toString());
            assertEquals(structure.get(4).toString(), element4.toString());
            assertEquals(structure.get(5).toString(), element5.toString());
            assertEquals(structure.get(6).toString(), element6.toString());
        } catch (IOException e) {
            fail("This should not have caused an Exception");
        }
    }

    @Test
    public void testGetTableSize() {
        assertEquals(structure.getTableSize(), 2);
    }

    @Test
    public void testHashTable() {
        CourseDBElement element = new CourseDBElement("999", 888, 4, "RT123", "Mr. Ray");
        structure.add(element);
        LinkedList<CourseDBElement> list = structure.hashTable[element.hashCode() % structure.getTableSize()];
        assertEquals(888, list.get(2).getCRN());

        CourseDBStructure structure2 = new CourseDBStructure("Testing", 3);
        assertEquals(structure2.getTableSize(), 3);
        structure2.add(element);
        list = structure2.hashTable[element.hashCode() % 3];
        assertEquals(888, list.get(0).getCRN());
    }
}
