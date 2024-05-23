
import java.util.ArrayList; 
import javax.swing.JOptionPane;

public class EasyKanBan {
    public static void main(String[] args) {
        
    }
        
       public class Task {  
        private String taskName;
        private String taskID;
        private String description;
        private String developerFirstName;
        private String developerLastName;
        private double taskNumber;
        private double estimatedDuration;
        private String status;
      

public Task(String TaskName,String description, String developerFirstName, String developerLastName, double estimatedDuration, String status) {
            if (description.length() > 50) {
                JOptionPane.showMessageDialog(null, "Please enter a task description of less than 50 characters.");
                return;
            }
            this.taskName = taskName;
            this.taskID = taskID;
            this.description = description;
            this.developerFirstName = developerFirstName;
            this.developerLastName = developerLastName;
            this.taskNumber = 0;
            this.estimatedDuration = estimatedDuration;
            this.status = "To Do"; // Default status
}
            public boolean checkDecription() {
                return description.length() <= 50;
            }
            public String createTaskID() {
                return taskName.substring( 0, 2).toUpperCase() + ":" + taskNumber + ":" + developerFirstName.substring(developerFirstName);
            }
       
            public String printDeveloperFirstName() {
                return "status" + status + "\nDeveloperFirstName:" + developerFirstName + "\nTask Number:" + taskNumber + "\ntaskName:" + taskName;
            }
            
            public String printDeveloperLastName() {
                return "status" + status + "\nDeveloperLastName:" + developerLastName + "\nTask Number:" + taskNumber + "\ntaskName:" + taskName;
            }    
            
            public double returnTotalHours() {
                return estimatedDuration;
            }
            
            public static void main(String[] args) {
                JOptionPane.showMessageDialog(null, "Welcome to EasyKanBan");
                
                int numTasks = Integer.parseInt(JOptionPane.showInputDialog("Enter the number of tasks"));
                
                Task[] tasks = new Task[numTasks];
                int totalHours = 0;
                
                for (int 1 = 0; 1 < numTasks; 1++) {
                    String taskName = JOptionPane.showInputDialog("Enter task name");
                    String description = JOptionPane.showInputDialog("Enter description");
                    String developerFirstName = JOptionPane.showInputDialog("Enter developer first name");
                    String developerLastName = JOptionPane.showInputDialog("Enter developer last name");
                    int estimatedDuration = JOptionPane.showInputDialog("Enter developer last name");
                    
                    Task task = new Task(taskName, description, developerFirstName, developerLastName, estimatedDuration);
                    
                    if (task.checkDecription()) {
                        JOptionPane.showMessageDialog(null, "Task successfully captured");
                    } else {
                        JOptionPane.showMessageDialog(null, "Please eneter a task description of less than 50 characters");
                    }
                    
                    JOptionPane.showMessageDialog(null,task.printDeveloperFirstName());
                    JOptionPane.showMessageDialog(null,task.printDeveloperLastName());
                    
                    tasks[1] = task;
                    totalHours += task.returnTotalHours();
            }
                
                JOptionPane.showMessageDialog(null,"Total hours:" + totalHours);
                    
                    
                    
                    
                    
            }
                
            }
                
            }