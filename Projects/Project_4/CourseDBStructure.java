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
        int index = element.hashCode() % hashTable.length;

        if (hashTable[index] == null) {
            LinkedList<CourseDBElement> input = new LinkedList<CourseDBElement>();
            input.add(element);
            hashTable[index] = input;
        } else
            hashTable[index].add(element);
    }

    @Override
    public CourseDBElement get(int crn) throws IOException {
        int index = String.valueOf(crn).hashCode() % hashTable.length;

        if (hashTable[index].size() > 0) {
            for (CourseDBElement temp : hashTable[index]) {
                if (temp.getCRN() == crn)
                    return temp;
            }
        }

        throw new IOException();
    }

    @Override
    public int getTableSize() {
        return hashTable.length;
    }
}
