import java.util.ArrayList;
import java.util.Scanner;

public class TodoList {

    public static void main(String[] args) {
        ArrayList<String> tasks = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\n--- Todo List Menu ---");
            System.out.println("1. Add Task");
            System.out.println("2. Remove Task");
            System.out.println("3. View Tasks");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int choice;
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter a number between 1-4.");
                continue;
            }

            switch (choice) {
                case 1:
                    System.out.print("Enter task to add: ");
                    String task = scanner.nextLine();
                    tasks.add(task);
                    System.out.println("Task added!");
                    break;
                    
                case 2:
                    if (tasks.isEmpty()) {
                        System.out.println("No tasks to remove!");
                        break;
                    }
                    System.out.println("Current tasks:");
                    displayTasks(tasks);
                    System.out.print("Enter task number to remove: ");
                    try {
                        int taskNumber = Integer.parseInt(scanner.nextLine());
                        if (taskNumber < 1 || taskNumber > tasks.size()) {
                            System.out.println("Invalid task number!");
                        } else {
                            tasks.remove(taskNumber - 1);
                            System.out.println("Task removed!");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid input! Please enter a valid number.");
                    }
                    break;
                    
                case 3:
                    if (tasks.isEmpty()) {
                        System.out.println("No tasks in the list!");
                    } else {
                        System.out.println("\n--- Your Tasks ---");
                        displayTasks(tasks);
                    }
                    break;
                    
                case 4:
                    running = false;
                    System.out.println("Exiting Todo List...");
                    break;
                    
                default:
                    System.out.println("Invalid choice! Please select 1-4.");
            }
        }
        scanner.close();
    }

    private static void displayTasks(ArrayList<String> tasks) {
        for (int i = 0; i < tasks.size(); i++) {
            System.out.println((i + 1) + ". " + tasks.get(i));
        }
    }
}
