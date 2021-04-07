/**
 * A class representing objects containing information about a course.
 * 
 * @author Raymond Karyshyn
 */
public class CourseDBElement implements Comparable<CourseDBElement> {
    private String courseId;
    private int crn;
    private int numberOfCredits;
    private String roomNumber;
    private String instructorName;

    public CourseDBElement() {
    }

    public CourseDBElement(String courseId, int crn, int numberOfCredits, String roomNumber, String instructorName) {
        this.courseId = courseId;
        this.crn = crn;
        this.numberOfCredits = numberOfCredits;
        this.roomNumber = roomNumber;
        this.instructorName = instructorName;
    }

    public String getcourseId() {
        return courseId;
    }

    public void setcourseId(String courseId) {
        this.courseId = courseId;
    }

    public int getCRN() {
        return crn;
    }

    public void setCRN(int crn) {
        this.crn = crn;
    }

    public int getNumberOfCredits() {
        return numberOfCredits;
    }

    public void setNumberOfCredits(int numberOfCredits) {
        this.numberOfCredits = numberOfCredits;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String getInstructorName() {
        return instructorName;
    }

    public void setInstructorName(String instructorName) {
        this.instructorName = instructorName;
    }

    public int hashCode() {
        return String.valueOf(crn).hashCode();
    }

    @Override
    public int compareTo(CourseDBElement element) {
        return this.crn - element.crn;
    }

    public String toString() {
        return ("\nCourse:" + courseId + " CRN:" + crn + " Credits:" + numberOfCredits + " Instructor:" + instructorName
                + " Room:" + roomNumber);
    }
}
