package student;

import org.junit.jupiter.api.*;
import java.io.IOException;
import java.nio.file.*;
import static org.junit.jupiter.api.Assertions.*;

public class FileHandlerTest {

    private static final String TEST_FILE = "test_scores.csv";
    private FileHandler handler;

    @BeforeEach
    public void setup() {
        handler = new FileHandler(TEST_FILE);
    }

    @AfterEach
    public void cleanup() throws IOException {
       
        Files.deleteIfExists(Paths.get(TEST_FILE));
    }

    
    @Test
    public void testFileWrite() throws IOException {
        Student s = new Student("Alice", 111, 95);
        handler.writeData(s);

        // Read file content
        String content = Files.readString(Paths.get(TEST_FILE));
        assertTrue(content.contains("Alice,111,95"), "File should contain the student data");
    }

   
    @Test
    public void testThreadCompletion() throws InterruptedException, IOException {
        Student s1 = new Student("Bob", 201, 88);
        Student s2 = new Student("Charlie", 202, 77);

        // Create threads for writing
        Thread t1 = new StudentTask(handler, s1);
        Thread t2 = new StudentTask(handler, s2);

        t1.start();
        t2.start();

        // Wait for both threads to finish
        t1.join();
        t2.join();

       
        String content = Files.readString(Paths.get(TEST_FILE));
        assertTrue(content.contains("Bob,201,88"), "File should contain Bob's data");
        assertTrue(content.contains("Charlie,202,77"), "File should contain Charlie's data");
    }
}