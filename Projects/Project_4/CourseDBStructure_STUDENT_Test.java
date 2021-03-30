import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CourseDBStructure_STUDENT_Test {
    CourseDBStructure structure;

    @Before
    public void setUp() throws Exception {
        structure = new CourseDBStructure("Testing", 2);
    }

    @After
    public void tearDown() throws Exception {
        structure = null;
    }

    @Test
    public void testGetTableSize() {
        CourseDBElement element1 = new CourseDBElement("123", 456, 3, "Upstairs 1", "Bob Smith");
        CourseDBElement element2 = new CourseDBElement("234", 457, 3, "Upstairs 2", "Rob Smith");
        CourseDBElement element3 = new CourseDBElement("345", 458, 4, "Upstairs 3", "Tod Smith");

        structure.add(element1);
        structure.add(element2);
        structure.add(element3);

        try {
            System.out.println(structure.get(456).getInstructorName());
            System.out.println(structure.get(457).getInstructorName());
            System.out.println(structure.get(458).getInstructorName());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
