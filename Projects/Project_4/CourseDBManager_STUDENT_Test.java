import static org.junit.Assert.*;

import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CourseDBManager_STUDENT_Test {
    CourseDBManagerInterface manager = new CourseDBManager();

    @Before
    public void setUp() throws Exception {
        manager = new CourseDBManager();
    }

    @After
    public void tearDown() throws Exception {
        manager = null;
    }

    @Test
    public void testAddToDB() {
        try {
            manager.add("456", 123, 3, "MATH102", "Mr. Ray");
            manager.add("789", 456, 4, "MATH103", "Mr. Ray");
            manager.add("123", 789, 4, "MATH104", "Mr. Ray");
        } catch (Exception e) {
            fail("This should not have caused an Exception");
        }
    }

    @Test
    public void testShowAll() {
        manager.add("MATH102", 123, 3, "456", "Mr. Ray");
        manager.add("MATH103", 456, 4, "789", "Mr. Ray");
        manager.add("MATH104", 789, 5, "123", "Mr. Ray");

        ArrayList<String> list = manager.showAll();
        assertEquals(list.get(0), "\nCourse:MATH102 CRN:123 Credits:3 Instructor:Mr. Ray Room:456");
        assertEquals(list.get(2), "\nCourse:MATH103 CRN:456 Credits:4 Instructor:Mr. Ray Room:789");
        assertEquals(list.get(1), "\nCourse:MATH104 CRN:789 Credits:5 Instructor:Mr. Ray Room:123");
    }

    @Test
    public void testRead() {
        try {
            File inputFile = new File("Test.txt");
            PrintWriter inFile = new PrintWriter(inputFile);
            inFile.println("MATH888 123 4 Upstairs Mr. Ray");
            inFile.println("MATH999 456 3 Downstairs Mr. Ray");
            inFile.println("MATH000 789 3 Basement Mr. Ray");

            inFile.close();
            manager.readFile(inputFile);

            assertEquals(manager.get(123).toString(), "\nCourse:MATH888 CRN:123 Credits:4 Instructor:Mr. Ray Room:Upstairs");
            assertEquals(manager.get(456).toString(), "\nCourse:MATH999 CRN:456 Credits:3 Instructor:Mr. Ray Room:Downstairs");
            assertEquals(manager.get(789).toString(), "\nCourse:MATH000 CRN:789 Credits:3 Instructor:Mr. Ray Room:Basement");
        } catch (Exception e) {
            fail("Should not have thrown an exception");
        }
    }
}
