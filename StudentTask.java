package student;

public class StudentTask extends Thread {
    private final FileHandler fileHandler;
    private final Student student;

    public StudentTask(FileHandler fileHandler, Student student) {
        this.fileHandler = fileHandler;
        this.student = student;
    }

    @Override
    public void run() {
        fileHandler.writeData(student);
        System.out.println(student.getFormattedData().trim() + " → written successfully.");
    }
}

	