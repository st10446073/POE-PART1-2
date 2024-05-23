

import java.util.ArrayList;
import javax.swing.JOptionPane;


public class TASK2PART2 {

    public static void main(String[] args) {
        System.out.println("Welcome to EasyKanBan");
        
        String username = "";
        String password = "";

        // Get username and password from user
        username = JOptionPane.showInputDialog("Enter your username:");
        password = JOptionPane.showInputDialog("Enter your password:");

        // Validate the input
        if (username.equals("admin") && password.equals("password")) {
            JOptionPane.showMessageDialog(null, "Login Successful!");
        } else {
            JOptionPane.showMessageDialog(null, "Invalid username or password. Please try again.");
    }
}


public class TaskManager {
public static class Task {
        private String taskId;
        private String description;
        private String developerFirstName;
        private String developerLastName;
        private double estimatedDuration;
        private String status;

        public Task(String description, String developerFirstName, String developerLastName, double estimatedDuration, String status) {
            if (description.length() > 50) {
                JOptionPane.showMessageDialog(null, "Please enter a task description of less than 50 characters.");
                return;
            }

            this.description = description;
            this.developerFirstName = developerFirstName;
            this.developerLastName = developerLastName;
            this.estimatedDuration = estimatedDuration;
            this.status = status;
            this.taskId = generateTaskId(description, developerLastName);
            
            JOptionPane.showMessageDialog(null, "Task successfully captured.");
        }

        private String generateTaskId(String description, String developerLastName) {
            String firstTwoLetters = description.length() >= 2 ? description.substring(0, 2).toUpperCase() : description.toUpperCase();
            String lastThreeLetters = developerLastName.length() >= 3 ? developerLastName.substring(developerLastName.length() - 3).toUpperCase() : developerLastName.toUpperCase();
            return firstTwoLetters + ":" + ":" + lastThreeLetters;
        }

        
       
        public String toString() {
            return "Task ID: " + taskId +
                    ", Description: " + description +
                    ", Developer: " + developerFirstName + " " + developerLastName +
                    ", Estimated Duration: " + estimatedDuration + " hours" +
                    ", Status: " + status;
        }
    }

    public static void main(String[] args) {
        ArrayList<Task> tasks = new ArrayList<>();

        while (true) {
            String description = JOptionPane.showInputDialog("Enter task description:");
            if (description == null || description.length() > 50) {
                JOptionPane.showMessageDialog(null, "Please enter a task description of less than 50 characters.");
                continue;
            }

            String firstName = JOptionPane.showInputDialog("Enter developer first name:");
            if (firstName == null) break;

            String lastName = JOptionPane.showInputDialog("Enter developer last name:");
            if (lastName == null) break;

            double duration = 0;
            try {
                duration = Double.parseDouble(JOptionPane.showInputDialog("Enter estimated duration in hours:"));
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Invalid input for duration. Please enter a numeric value.");
                continue;
            }

            String[] options = {"To Do", "Done", "Doing"};
            int statusChoice = JOptionPane.showOptionDialog(null, 
                    "Select task status:", 
                    "Task Status", 
                    JOptionPane.DEFAULT_OPTION, 
                    JOptionPane.INFORMATION_MESSAGE, 
                    null, 
                    options, 
                    options[0]);

            if (statusChoice == JOptionPane.CLOSED_OPTION) break;

            String status = options[statusChoice];

            Task task = new Task(description, firstName, lastName, duration, status);
            tasks.add(task);

            int choice = JOptionPane.showConfirmDialog(null, "Do you want to add another task?", "Continue", JOptionPane.YES_NO_OPTION);
            if (choice == JOptionPane.NO_OPTION) {
                break;
            }
        }

        StringBuilder tasksList = new StringBuilder("Tasks List:\n");
        for (Task task : tasks) {
            tasksList.append(task).append("\n");
        }

        JOptionPane.showMessageDialog(null, tasksList.toString());
    }
}
}