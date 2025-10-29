package student;
import java.io.FileWriter;
import java.io.IOException;


public class FileHandler {

    private final String fileName;

    public FileHandler(String fileName) {
        this.fileName = fileName;
    }

    // synchronized to avoid multiple threads writing at once
    public synchronized void writeData(Student s) {
        FileWriter writer = null;
        try {
            writer = new FileWriter(fileName, true);
            writer.write(s.getFormattedData());
        } catch (IOException e) {
            System.out.println(" Error while writing file: " + e.getMessage());
        } finally {
            try {
                if (writer != null) writer.close();
            } catch (IOException ex) {
                System.out.println(" Could not close file properly.");
            }
        }
    }
}