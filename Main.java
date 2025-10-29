package student;

public class Main {

    public static void main(String[] args) {
        String filePath = "student_scores.csv";
        FileHandler fileHandler = new FileHandler(filePath);

        System.out.println("Starting student score logging...\n");

        // create few students
        Student st1 = new Student("Krupa", 201, 87);
        Student st2 = new Student("Ravi", 202, 91);
        Student st3 = new Student("Meghna", 203, 76);

        // create threads
        Thread th1 = new StudentTask(fileHandler, st1);
        Thread th2 = new StudentTask(fileHandler, st2);
        Thread th3 = new StudentTask(fileHandler, st3);

        // start all at once
        th1.start();
        th2.start();
        th3.start();

        try {
            // wait till all threads are done
            th1.join();
            th2.join();
            th3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("\n All scores have been written to " + filePath);
    }
}