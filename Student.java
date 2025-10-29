package student;

public class Student {

    private String studentName;
    private int rollNumber;
    private int marksScored;

    public Student(String studentName, int rollNumber, int marksScored) {
        this.studentName = studentName;
        this.rollNumber = rollNumber;
        this.marksScored = marksScored;
    }

    // Convert to a single line for writing into CSV
    public String getFormattedData() {
        return studentName + "," + rollNumber + "," + marksScored + System.lineSeparator();
    }
}