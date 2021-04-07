import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * A class representing objects that manage a CourseDBStructure with the added
 * ability to read data from a file containing information for multiple
 * CourseDBElement objects.
 * 
 * @author Raymond Karyshyn
 */
public class CourseDBManager implements CourseDBManagerInterface {
    private CourseDBStructure structure;

    public CourseDBManager() {
        structure = new CourseDBStructure(5);
    }

    @Override
    public void add(String id, int crn, int credits, String roomNum, String instructor) {
        CourseDBElement element = new CourseDBElement(id, crn, credits, roomNum, instructor);
        structure.add(element);
    }

    @Override
    public CourseDBElement get(int crn) {
        CourseDBElement element = null;

        try {
            element = structure.get(crn);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return element;
    }

    @Override
    public void readFile(File input) throws FileNotFoundException {
        Scanner scanner = new Scanner(input);

        while (scanner.hasNextLine()) {
            CourseDBElement element = new CourseDBElement();

            String[] line = scanner.nextLine().split(" ");

            if (line.length > 5) {
                for (int i = 5; i < line.length; i++) {
                    String name_stripped = line[i].replaceAll("\\s", "");
                    if (!name_stripped.isEmpty())
                        line[4] += " " + name_stripped;
                }
            }

            int i = 0;
            for (String word : line) {
                switch (i) {
                case 0:
                    element.setcourseId(word);
                    break;
                case 1:
                    element.setCRN(Integer.parseInt(word));
                    break;
                case 2:
                    element.setNumberOfCredits(Integer.parseInt(word));
                    break;
                case 3:
                    element.setRoomNumber(word);
                    break;
                case 4:
                    element.setInstructorName(word);
                    break;
                }

                i++;
            }

            structure.add(element);
        }

        scanner.close();
    }

    @Override
    public ArrayList<String> showAll() {
        ArrayList<String> result = new ArrayList<>();

        for (LinkedList<CourseDBElement> temp1 : structure.hashTable) {
            if (temp1 != null) {
                for (CourseDBElement temp2 : temp1)
                    result.add(temp2.toString());
            }
        }

        return result;
    }
}
