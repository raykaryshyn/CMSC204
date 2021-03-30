import java.util.LinkedList;
import java.io.IOException;

public class CourseDBStructure implements CourseDBStructureInterface {
    protected LinkedList<CourseDBElement>[] hashTable;

    @SuppressWarnings("unchecked")
    public CourseDBStructure(int size) {
        hashTable = new LinkedList[size];
    }

    public CourseDBStructure(String testing, int size) {
        this(size);
    }

    @Override
    public void add(CourseDBElement element) {
        // TODO Auto-generated method stub

    }

    @Override
    public CourseDBElement get(int crn) throws IOException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public int getTableSize() {
        return hashTable.length;
    }
}
