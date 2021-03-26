import static org.junit.Assert.*;

import java.util.Comparator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Student tests for the SortedDoubleLinkedList class.
 * 
 * @author Raymond Karyshyn
 */
public class SortedDoubleLinkedList_STUDENT_Test {
    SortedDoubleLinkedList<String> sortedLinkedString;
    SortedDoubleLinkedList<Double> sortedLinkedDouble;
    SortedDoubleLinkedList<Course> sortedLinkedCourse;
    StringComparator comparator;
    DoubleComparator comparatorD;
    CourseComparator comparatorCourse;

    public Course a = new Course("Abe", "Spanish 1", 1234);
    public Course b = new Course("Bob", "Spanish 2", 2345);
    public Course c = new Course("Cook", "Computer Science 1", 3456);
    public Course d = new Course("Davis", "Computer Science 2", 4567);
    public Course e = new Course("Ed", "Math", 5678);
    public Course f = new Course("Frank", "History", 6789);

    @Before
    public void setUp() throws Exception {
        comparator = new StringComparator();
        sortedLinkedString = new SortedDoubleLinkedList<String>(comparator);

        comparatorD = new DoubleComparator();
        sortedLinkedDouble = new SortedDoubleLinkedList<Double>(comparatorD);

        comparatorCourse = new CourseComparator();
        sortedLinkedCourse = new SortedDoubleLinkedList<Course>(comparatorCourse);
    }

    @After
    public void tearDown() throws Exception {
        comparator = null;
        comparatorD = null;
        comparatorCourse = null;
        sortedLinkedString = null;
        sortedLinkedDouble = null;
        sortedLinkedCourse = null;
    }

    @Test
    public void testAddToFront() {
        try {
            sortedLinkedString.addToFront("Hi, Ray!");
            assertTrue("Did not throw an UnsupportedOperationException", false);
        } catch (UnsupportedOperationException e) {
            assertTrue("Successfully threw an UnsupportedOperationException", true);
        } catch (Exception e) {
            assertTrue("Threw an exception other than the UnsupportedOperationException", false);
        }
    }

    @Test
    public void testAddToEnd() {
        try {
            sortedLinkedString.addToEnd("Hi, Ray!");
            assertTrue("Did not throw an UnsupportedOperationException", false);
        } catch (UnsupportedOperationException e) {
            assertTrue("Successfully threw an UnsupportedOperationException", true);
        } catch (Exception e) {
            assertTrue("Threw an exception other than the UnsupportedOperationException", false);
        }
    }

    @Test
    public void testIteratorSuccessfulNext() {
        sortedLinkedCourse.add(c);
        sortedLinkedCourse.add(d);
        sortedLinkedCourse.add(a);
        sortedLinkedCourse.add(b);
        ListIterator<Course> iterator = sortedLinkedCourse.iterator();
        assertEquals(true, iterator.hasNext());
        assertEquals(a, iterator.next());
        assertEquals(b, iterator.next());
        assertEquals(c, iterator.next());
        assertEquals(true, iterator.hasNext());
    }

    @Test
    public void testIteratorSuccessfulStringPrevious() {
        sortedLinkedString.add("Hi, Ray!");
        sortedLinkedString.add("How ya doin'?");
        sortedLinkedString.add("Are the tests workin'?");
        sortedLinkedString.add("See ya later...");
        ListIterator<String> iterator = sortedLinkedString.iterator();
        assertEquals(true, iterator.hasNext());
        assertEquals("Are the tests workin'?", iterator.next());
        assertEquals("Hi, Ray!", iterator.next());
        assertEquals("How ya doin'?", iterator.next());
        assertEquals("See ya later...", iterator.next());
        assertEquals(true, iterator.hasPrevious());
        assertEquals("See ya later...", iterator.previous());
        assertEquals("How ya doin'?", iterator.previous());
        assertEquals("Hi, Ray!", iterator.previous());
    }

    @Test
    public void testIteratorSuccessfulCoursePrevious() {
        sortedLinkedCourse.add(e);
        sortedLinkedCourse.add(c);
        sortedLinkedCourse.add(b);
        sortedLinkedCourse.add(d);
        ListIterator<Course> iterator = sortedLinkedCourse.iterator();
        assertEquals(true, iterator.hasNext());
        assertEquals(b, iterator.next());
        assertEquals(c, iterator.next());
        assertEquals(d, iterator.next());
        assertEquals(e, iterator.next());
        assertEquals(true, iterator.hasPrevious());
        assertEquals(e, iterator.previous());
        assertEquals(d, iterator.previous());
        assertEquals(c, iterator.previous());
    }

    @Test
    public void testIteratorSuccessfulDoubleNext() {
        sortedLinkedDouble.add(Double.valueOf(1000));
        sortedLinkedDouble.add(Double.valueOf(10000));
        sortedLinkedDouble.add(Double.valueOf(10));
        sortedLinkedDouble.add(Double.valueOf(-9));
        ListIterator<Double> iterator = sortedLinkedDouble.iterator();
        assertEquals(true, iterator.hasNext());
        assertEquals(Double.valueOf(-9), iterator.next());
        assertEquals(Double.valueOf(10), iterator.next());
        assertEquals(Double.valueOf(1000), iterator.next());
        assertEquals(true, iterator.hasNext());
    }

    @Test
    public void testIteratorSuccessfulDoublePrevious() {
        sortedLinkedDouble.add(Double.valueOf(999));
        sortedLinkedDouble.add(Double.valueOf(9));
        sortedLinkedDouble.add(Double.valueOf(99999));
        sortedLinkedDouble.add(Double.valueOf(9999));
        ListIterator<Double> iterator = sortedLinkedDouble.iterator();
        assertEquals(Double.valueOf(9), iterator.next());
        assertEquals(Double.valueOf(999), iterator.next());
        assertEquals(Double.valueOf(9999), iterator.next());
        assertEquals(true, iterator.hasPrevious());
        assertEquals(Double.valueOf(9999), iterator.previous());
        assertEquals(true, iterator.hasPrevious());
    }

    @Test
    public void testIteratorNoSuchElementException() {
        sortedLinkedCourse.add(e);
        sortedLinkedCourse.add(c);
        sortedLinkedCourse.add(b);
        sortedLinkedCourse.add(d);
        ListIterator<Course> iterator = sortedLinkedCourse.iterator();

        assertEquals(true, iterator.hasNext());
        assertEquals(b, iterator.next());
        assertEquals(c, iterator.next());
        assertEquals(d, iterator.next());
        assertEquals(true, iterator.hasNext());
        assertEquals(e, iterator.next());
        try {
            iterator.next();
            assertTrue("Did not throw a NoSuchElementException", false);
        } catch (NoSuchElementException e) {
            assertTrue("Successfully threw a NoSuchElementException", true);
        } catch (Exception e) {
            assertTrue("Threw an exception other than the NoSuchElementException", false);
        }
    }

    @Test
    public void testIteratorUnsupportedOperationExceptionString() {
        sortedLinkedCourse.add(e);
        sortedLinkedCourse.add(c);
        sortedLinkedCourse.add(b);
        sortedLinkedCourse.add(d);
        ListIterator<Course> iterator = sortedLinkedCourse.iterator();

        try {
            iterator.remove();
            assertTrue("Did not throw a UnsupportedOperationException", false);
        } catch (UnsupportedOperationException e) {
            assertTrue("Successfully threw a UnsupportedOperationException", true);
        } catch (Exception e) {
            assertTrue("Threw an exception other than the UnsupportedOperationException", false);
        }
    }

    @Test
    public void testAddCourse() {
        sortedLinkedCourse.add(e);
        sortedLinkedCourse.add(d);
        assertEquals(d, sortedLinkedCourse.getFirst());
        assertEquals(e, sortedLinkedCourse.getLast());
        sortedLinkedCourse.add(b);
        sortedLinkedCourse.add(f);
        sortedLinkedCourse.add(a);
        assertEquals(a, sortedLinkedCourse.getFirst());
        assertEquals(f, sortedLinkedCourse.getLast());
        assertEquals(f, sortedLinkedCourse.retrieveLastElement());
        assertEquals(e, sortedLinkedCourse.getLast());
    }

    @Test
    public void testRemoveFirstCourse() {
        sortedLinkedCourse.add(c);
        sortedLinkedCourse.add(b);
        assertEquals(b, sortedLinkedCourse.getFirst());
        assertEquals(c, sortedLinkedCourse.getLast());
        sortedLinkedCourse.add(a);
        assertEquals(a, sortedLinkedCourse.getFirst());
        sortedLinkedCourse.remove(a, comparatorCourse);
        assertEquals(b, sortedLinkedCourse.getFirst());
    }

    @Test
    public void testRemoveEndCourse() {
        sortedLinkedCourse.add(d);
        sortedLinkedCourse.add(b);
        assertEquals(b, sortedLinkedCourse.getFirst());
        assertEquals(d, sortedLinkedCourse.getLast());
        sortedLinkedCourse.add(f);
        assertEquals(f, sortedLinkedCourse.getLast());
        sortedLinkedCourse.remove(f, comparatorCourse);
        assertEquals(d, sortedLinkedCourse.getLast());
    }

    @Test
    public void testRemoveMiddleCourse() {
        sortedLinkedCourse.add(b);
        sortedLinkedCourse.add(a);
        assertEquals(a, sortedLinkedCourse.getFirst());
        assertEquals(b, sortedLinkedCourse.getLast());
        sortedLinkedCourse.add(f);
        assertEquals(f, sortedLinkedCourse.getLast());
        assertEquals(a, sortedLinkedCourse.getFirst());
        assertEquals(3, sortedLinkedCourse.getSize());
        sortedLinkedCourse.remove(a, comparatorCourse);
        assertEquals(b, sortedLinkedCourse.getFirst());
        assertEquals(f, sortedLinkedCourse.getLast());
        assertEquals(2, sortedLinkedCourse.getSize());
    }

    private class StringComparator implements Comparator<String> {

        @Override
        public int compare(String arg0, String arg1) {
            return arg0.compareTo(arg1);
        }

    }

    private class DoubleComparator implements Comparator<Double> {

        @Override
        public int compare(Double arg0, Double arg1) {
            return arg0.compareTo(arg1);
        }

    }

    private class CourseComparator implements Comparator<Course> {

        @Override
        public int compare(Course arg0, Course arg1) {
            return arg0.toString().compareTo(arg1.toString());
        }
    }

    private class Course {
        String teacher;
        String course;
        int id;

        public Course(String teacher, String course, int id) {
            this.teacher = teacher;
            this.course = course;
            this.id = id;
        }

        public String getMake() {
            return teacher;
        }

        public String getCourse() {
            return course;
        }

        public int getId() {
            return id;
        }

        public String toString() {
            return (getMake() + " " + getCourse() + " " + getId());
        }
    }
}
