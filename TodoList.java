package pr;
import java.util.ArrayList;
import java.util.Scanner;

public class TodoList {
    private ArrayList<String> tasks;

    public TodoList() {
        tasks = new ArrayList<String>();
    }

    public void addTask(String task) {
        tasks.add(task);
        System.out.println("Task added: " + task);
    }

    public void removeTask(int index) {
        if (index >= 0 && index < tasks.size()) {
            String removedTask = tasks.remove(index);
            System.out.println("Task removed: " + removedTask);
        } else {
            System.out.println("Invalid index. Task not removed.");
        }
    }

    public void displayTasks() {
        if (tasks.isEmpty()) {
            System.out.println("Todo list is empty.");
        } else {
            System.out.println("Todo list:");
            for (int i = 0; i < tasks.size(); i++) {
                System.out.println((i + 1) + ". " + tasks.get(i));
            }
        }
    }

    public static void main(String[] args) {
        TodoList todoList = new TodoList();
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("\nChoose an option:");
            System.out.println("1. Add a task");
            System.out.println("2. Remove a task");
            System.out.println("3. Display tasks");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter the task to add: ");
                    String taskToAdd = scanner.nextLine();
                    todoList.addTask(taskToAdd);
                    break;
                case 2:
                    System.out.print("Enter the index of the task to remove: ");
                    int indexToRemove = scanner.nextInt() - 1; // Adjust index to 0-based
                    todoList.removeTask(indexToRemove);
                    break;
                case 3:
                    todoList.displayTasks();
                    break;
                case 4:
                    exit = true;
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please choose again.");
            }
        }

        scanner.close();
    }
}