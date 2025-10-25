// Importing required classes
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner; // Changed to Scanner

// Class to manage a to-do list
public class javaTest {

    // Main method to run the program
    public static void main(String[] args) {

        // Initialize variables
        List<String> tasks = new ArrayList<>();         // List for task descriptions (String type)
        List<Boolean> completed = new ArrayList<>();    // List for completion status
        Scanner scanner = new Scanner(System.in);       // Use Scanner for input
        boolean continueAdding = true;                  // Boolean flag to control loop

        // Print welcome message
        System.out.println("Welcome to the To-Do List Manager!");

        // Loop to collect tasks
        while (continueAdding) {

            // Get user input for task description
            System.out.print("Enter task description (or 'quit' to exit): ");
            String task = scanner.nextLine();  // Changed from IO.readln()

            // Check if user wants to quit
            if (task.equalsIgnoreCase("quit")) {
                continueAdding = false;
                continue;
            }

            // Validate task input
            if (task.trim().isEmpty()) {
                System.out.println("Error: Task cannot be empty.");
                continue;
            }

            // Ask if task is completed
            System.out.print("Is this task completed? (yes/no): ");
            String statusInput = scanner.nextLine().toLowerCase();  // Changed from IO.readln()

            boolean isCompleted;

            // Handle potential input errors
            try {

                // Validate completion status for 'yes'
                if (statusInput.equals("yes")) {
                    isCompleted = true;

                    // Validate completion status for 'no'
                } else if (statusInput.equals("no")) {
                    isCompleted = false;

                    // Handle invalid completion status
                } else {
                    throw new IllegalArgumentException("Please enter 'yes' or 'no'.");
                }

                // Add task and status to lists
                tasks.add(task);
                completed.add(isCompleted);
                System.out.println("Added task: " + task + " (Completed: " + isCompleted + ")");

                // Catch invalid input errors
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }

        // Print the list of tasks
        System.out.println("\nTo-Do List:");
        for (int count = 0; count < tasks.size(); count++) {
            System.out.println((count + 1) + ". " + tasks.get(count) + " - Completed: " + completed.get(count));
        }

        // Count completed tasks
        int completedCount = countCompletedTasks(completed);
        System.out.println("Number of completed tasks: " + completedCount);

        // Save tasks to file
        try {
            saveTasksToFile(tasks, completed, "tasks.txt");
        } catch (IOException errorMessage) {
            System.out.println("Error saving to file: " + errorMessage.getMessage());
        }

        scanner.close(); // Close Scanner
    }

    /**
     * Counts the number of completed tasks in the list.
     *      @param completed List of task completion statuses
     *      @return Number of completed tasks
     */
    public static int countCompletedTasks(List<Boolean> completed) {
        int count = 0;
        for (Boolean status : completed) {
            if (status) {
                count++;
            }
        }
        return count;
    }

    /**
     * Saves tasks and their completion status to a file.
     *      @param tasks List of task descriptions
     *      @param completed List of task completion statuses
     *      @param filename Name of the file to write to
     *      @throws IOException If file writing fails
     */
    public static void saveTasksToFile(List<String> tasks, List<Boolean> completed, String filename) throws IOException {
        // Use try-with-resources to automatically close the FileWriter
        try (FileWriter writer = new FileWriter(filename)) {
            // Save tasks to file
            for (int count = 0; count < tasks.size(); count++) {
                writer.write(tasks.get(count) + "," + completed.get(count) + "\n");
            }
        }
    }
}