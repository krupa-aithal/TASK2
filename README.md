# TASK2
[19:06, 10/29/2025] Krupa: 
Overview

This project shows how multiple threads can work together to write data into a shared file without interfering with each other.
Each student record (name, roll number, and marks) is written by a separate thread, and synchronization ensures that no data overlaps or gets lost.


🧩 Features

✅ Uses threads to simulate multiple students writing data at once

✅ Implements synchronized file writing to prevent race conditions

✅ Saves data in CSV format for easy viewing

✅ Includes JUnit tests for file writing and thread completion

✅ Demonstrates object-oriented design and clean code structure
 
⚙️ How It Works

1. Each StudentTask runs on its own thread.

2. All threads share a common FileHandler object.

3. The writeData() method is synchronized, so only one thread writes at a time.

4. Each student’s details are stored in a CSV file (student_scores.csv).

5. Once all threads finish, the main program confirms that data writing is complete
