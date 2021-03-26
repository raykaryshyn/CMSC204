import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Student tests for the BasicDoubleLinkedList class.
 * 
 * @author Raymond Karyshyn
 */
public class BasicDoubleLinkedList_STUDENT_Test {
    BasicDoubleLinkedList<String> linkedString;
    BasicDoubleLinkedList<Double> linkedDouble;
    BasicDoubleLinkedList<Person> linkedPerson;
    StringComparator comparator;
    DoubleComparator comparatorD;
    PersonComparator comparatorPerson;

    public Person a = new Person("John", "Smith", 15);
    public Person b = new Person("Mike", "Jones", 23);
    public Person c = new Person("Juan", "Carlos", 50);
    public Person d = new Person("Joe", "Smith", 65);
    public Person e = new Person("Sarah", "Smith", 34);
    public Person f = new Person("James", "Smith", 41);

    public ArrayList<Person> fill = new ArrayList<Person>();

    @Before
    public void setUp() throws Exception {
        linkedString = new BasicDoubleLinkedList<String>();
        linkedString.addToEnd("Good");
        linkedString.addToEnd("Day");
        comparator = new StringComparator();

        linkedDouble = new BasicDoubleLinkedList<Double>();
        linkedDouble.addToEnd(26.5);
        linkedDouble.addToEnd(999.1);
        comparatorD = new DoubleComparator();

        linkedPerson = new BasicDoubleLinkedList<Person>();
        linkedPerson.addToEnd(b);
        linkedPerson.addToEnd(c);
        comparatorPerson = new PersonComparator();
    }

    @After
    public void tearDown() throws Exception {
        linkedString = null;
        linkedDouble = null;
        linkedPerson = null;
        comparatorD = null;
        comparator = null;
    }

    @Test
    public void testGetSize() {
        assertEquals(2, linkedString.getSize());
        assertEquals(2, linkedDouble.getSize());
        assertEquals(2, linkedPerson.getSize());
    }

    @Test
    public void testAddToEnd() {
        assertEquals("Day", linkedString.getLast());
        linkedString.addToEnd("Last");
        assertEquals("Last", linkedString.getLast());

        assertEquals(c, linkedPerson.getLast());
        linkedPerson.addToEnd(d);
        assertEquals(d, linkedPerson.getLast());
    }

    @Test
    public void testAddToFront() {
        assertEquals("Good", linkedString.getFirst());
        linkedString.addToFront("The FRONT");
        assertEquals("The FRONT", linkedString.getFirst());

        assertEquals(b, linkedPerson.getFirst());
        linkedPerson.addToFront(a);
        assertEquals(a, linkedPerson.getFirst());
    }

    @Test
    public void testGetFirst() {
        assertEquals("Good", linkedString.getFirst());
        linkedString.addToFront("A NEW ENTRY");
        assertEquals("A NEW ENTRY", linkedString.getFirst());

        assertEquals(b, linkedPerson.getFirst());
        linkedPerson.addToFront(a);
        assertEquals(a, linkedPerson.getFirst());
    }

    @Test
    public void testGetLast() {
        assertEquals("Day", linkedString.getLast());
        linkedString.addToEnd("A NEW ENTRY");
        assertEquals("A NEW ENTRY", linkedString.getLast());

        assertEquals(c, linkedPerson.getLast());
        linkedPerson.addToEnd(d);
        assertEquals(d, linkedPerson.getLast());
    }

    @Test
    public void testToArrayList() {
        ArrayList<Person> list;
        linkedPerson.addToFront(a);
        linkedPerson.addToEnd(d);
        list = linkedPerson.toArrayList();
        assertEquals(a, list.get(0));
        assertEquals(b, list.get(1));
        assertEquals(c, list.get(2));
        assertEquals(d, list.get(3));
    }

    @Test
    public void testIteratorSuccessfulNext() {
        linkedString.addToFront("A NEW FRONT ENTRY");
        linkedString.addToEnd("A NEW LAST ENTRY");
        ListIterator<String> iterator = linkedString.iterator();
        assertEquals(true, iterator.hasNext());
        assertEquals("A NEW FRONT ENTRY", iterator.next());
        assertEquals("Good", iterator.next());
        assertEquals("Day", iterator.next());
        assertEquals(true, iterator.hasNext());
        assertEquals("A NEW LAST ENTRY", iterator.next());

        linkedPerson.addToFront(a);
        linkedPerson.addToEnd(d);
        ListIterator<Person> iteratorCar = linkedPerson.iterator();
        assertEquals(true, iteratorCar.hasNext());
        assertEquals(a, iteratorCar.next());
        assertEquals(b, iteratorCar.next());
        assertEquals(c, iteratorCar.next());
        assertEquals(true, iteratorCar.hasNext());
        assertEquals(d, iteratorCar.next());
    }

    @Test
    public void testIteratorSuccessfulPrevious() {
        linkedPerson.addToFront(a);
        linkedPerson.addToEnd(d);
        ListIterator<Person> iteratorCar = linkedPerson.iterator();
        assertEquals(true, iteratorCar.hasNext());
        assertEquals(a, iteratorCar.next());
        assertEquals(b, iteratorCar.next());
        assertEquals(c, iteratorCar.next());
        assertEquals(d, iteratorCar.next());
        assertEquals(true, iteratorCar.hasPrevious());
        assertEquals(d, iteratorCar.previous());
        assertEquals(c, iteratorCar.previous());
        assertEquals(b, iteratorCar.previous());
        assertEquals(a, iteratorCar.previous());
    }

    @Test
    public void testIteratorNoSuchElementExceptionNext() {
        linkedPerson.addToFront(a);
        linkedPerson.addToEnd(d);
        ListIterator<Person> iteratorCar = linkedPerson.iterator();
        assertEquals(true, iteratorCar.hasNext());
        assertEquals(a, iteratorCar.next());
        assertEquals(b, iteratorCar.next());
        assertEquals(c, iteratorCar.next());
        assertEquals(true, iteratorCar.hasNext());
        assertEquals(d, iteratorCar.next());

        try {
            iteratorCar.next();
            assertTrue("Did not throw a NoSuchElementException", false);
        } catch (NoSuchElementException e) {
            assertTrue("Successfully threw a NoSuchElementException", true);
        } catch (Exception e) {
            assertTrue("Threw an exception other than the NoSuchElementException", false);
        }

    }

    @Test
    public void testIteratorNoSuchElementExceptionPrevious() {
        linkedPerson.addToFront(a);
        linkedPerson.addToEnd(d);
        ListIterator<Person> iteratorCar = linkedPerson.iterator();
        assertEquals(true, iteratorCar.hasNext());
        assertEquals(a, iteratorCar.next());
        assertEquals(b, iteratorCar.next());
        assertEquals(c, iteratorCar.next());
        assertEquals(d, iteratorCar.next());
        assertEquals(true, iteratorCar.hasPrevious());
        assertEquals(d, iteratorCar.previous());
        assertEquals(c, iteratorCar.previous());
        assertEquals(b, iteratorCar.previous());
        assertEquals(a, iteratorCar.previous());

        try {
            iteratorCar.previous();
            assertTrue("Did not throw a NoSuchElementException", false);
        } catch (NoSuchElementException e) {
            assertTrue("Successfully threw a NoSuchElementException", true);
        } catch (Exception e) {
            assertTrue("Threw an exception other than the NoSuchElementException", false);
        }

    }

    @Test
    public void testIteratorUnsupportedOperationException() {
        linkedPerson.addToFront(a);
        linkedPerson.addToEnd(d);
        ListIterator<Person> iteratorCar = linkedPerson.iterator();
        assertEquals(true, iteratorCar.hasNext());
        assertEquals(a, iteratorCar.next());
        assertEquals(b, iteratorCar.next());
        assertEquals(c, iteratorCar.next());
        assertEquals(true, iteratorCar.hasNext());
        assertEquals(d, iteratorCar.next());

        try {
            iteratorCar.remove();
            assertTrue("Did not throw a UnsupportedOperationException", false);
        } catch (UnsupportedOperationException e) {
            assertTrue("Successfully threw a UnsupportedOperationException", true);
        } catch (Exception e) {
            assertTrue("Threw an exception other than the UnsupportedOperationException", false);
        }

    }

    @Test
    public void testRemove() {
        assertEquals(b, linkedPerson.getFirst());
        assertEquals(c, linkedPerson.getLast());
        linkedPerson.addToFront(a);
        assertEquals(a, linkedPerson.getFirst());
        linkedPerson.remove(a, comparatorPerson);
        assertEquals(b, linkedPerson.getFirst());
        linkedPerson.addToEnd(d);
        assertEquals(d, linkedPerson.getLast());
        linkedPerson.remove(d, comparatorPerson);
        assertEquals(c, linkedPerson.getLast());
        linkedPerson.addToFront(a);
        assertEquals(a, linkedPerson.getFirst());
        assertEquals(c, linkedPerson.getLast());
        linkedPerson.remove(b, comparatorPerson);
        assertEquals(a, linkedPerson.getFirst());
        assertEquals(c, linkedPerson.getLast());

    }

    @Test
    public void testRetrieveFirstElement() {
        assertEquals(b, linkedPerson.getFirst());
        linkedPerson.addToFront(a);
        assertEquals(a, linkedPerson.getFirst());
        assertEquals(a, linkedPerson.retrieveFirstElement());
        assertEquals(b, linkedPerson.getFirst());
        assertEquals(b, linkedPerson.retrieveFirstElement());
        assertEquals(c, linkedPerson.getFirst());

        assertEquals("Good", linkedString.getFirst());
        linkedString.addToFront("A NEW ENTRY");
        assertEquals("A NEW ENTRY", linkedString.getFirst());
        assertEquals("A NEW ENTRY", linkedString.retrieveFirstElement());
        assertEquals("Good", linkedString.getFirst());
        assertEquals("Good", linkedString.retrieveFirstElement());
        assertEquals("Day", linkedString.getFirst());

    }

    @Test
    public void testRetrieveLastElement() {
        assertEquals(c, linkedPerson.getLast());
        linkedPerson.addToEnd(d);
        assertEquals(d, linkedPerson.getLast());
        assertEquals(d, linkedPerson.retrieveLastElement());
        assertEquals(c, linkedPerson.getLast());

        assertEquals("Day", linkedString.getLast());
        linkedString.addToEnd("A NEW ENTRY");
        assertEquals("A NEW ENTRY", linkedString.getLast());
        assertEquals("A NEW ENTRY", linkedString.retrieveLastElement());
        assertEquals("Day", linkedString.getLast());
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

    private class PersonComparator implements Comparator<Person> {
        @Override
        public int compare(Person arg0, Person arg1) {
            return arg0.toString().compareTo(arg1.toString());
        }
    }

    private class Person {
        String firstName, lastName;
        int age;

        public Person(String firstName, String lastName, int age) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.age = age;
        }

        public String getFirstName() {
            return firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public int getAge() {
            return age;
        }

        public String toString() {
            return (getFirstName() + " " + getLastName() + " " + getAge());
        }
    }
}
