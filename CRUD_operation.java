import java.util.ArrayList;
import java.util.Scanner;
class Task {
    private int id;
    private String title;
    private String description;
    public Task(int id, String title, String description) {
        this.id = id;
        this.title = title;
        this.description = description;
    }
   public int getId() {
        return id;
    }
    public String getTitle() {
        return title;
    }
    public String getDescription() {
        return description;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    @Override
    public String toString() {
        return "Task ID: " + id + "\nTitle: " + title + "\nDescription: " + description + "\n";
    }
}
public class CRUD_operation {
    private static ArrayList<Task> tasks = new ArrayList<>();
    private static int taskIdCounter = 1;
    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        while (true) {
            System.out.println("\n=== Task Manager ===");
            System.out.println("1. Create Task");
            System.out.println("2. View Tasks");
            System.out.println("3. Update Task");
            System.out.println("4. Delete Task");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");    
            int choice = scanner.nextInt();
            scanner.nextLine(); 
            switch (choice) {
                case 1: createTask(); break;
                case 2: viewTasks(); break;
                case 3: updateTask(); break;
                case 4: deleteTask(); break;
                case 5: System.out.println("Exiting..."); return;
                default: System.out.println("Invalid choice. Try again.");
            }
        }
    }
    private static void createTask() {
        System.out.print("Enter task title: ");
        String title = scanner.nextLine();
        System.out.print("Enter task description: ");
        String description = scanner.nextLine();
        Task newTask = new Task(taskIdCounter++, title, description);
        tasks.add(newTask);
        System.out.println("Task added successfully!");
    }
    private static void viewTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks available.");
        } else {
            for (Task task : tasks) {
                System.out.println(task);
            }
        }
    }
    private static void updateTask() {
        System.out.print("Enter Task ID to update: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        for (Task task : tasks) {
            if (task.getId() == id) {
                System.out.print("Enter new title: ");
                task.setTitle(scanner.nextLine());
                System.out.print("Enter new description: ");
                task.setDescription(scanner.nextLine());
                System.out.println("Task updated successfully!");
                return;
            }
        }
        System.out.println("Task not found.");
    }
    private static void deleteTask() {
        System.out.print("Enter Task ID to delete: ");
        int id = scanner.nextInt();
        for (Task task : tasks) {
            if (task.getId() == id) {
                tasks.remove(task);
                System.out.println("Task deleted successfully!");
                return;
            }
        }
        System.out.println("Task not found.");
    }
}
