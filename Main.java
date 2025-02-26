import java.util.Scanner;

import Operations.StudentManager;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentManager manager = new StudentManager();

        while (true) {
            System.out.println("\n1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    
                    if(manager.idExists(id)) {
                    	break;
                    }
                    
                    System.out.print("Enter Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Course: ");
                    String course = scanner.nextLine();
                    manager.addStudent(id, name, course);
                    break;

                case 2:
                    manager.viewStudents();
                    break;

                case 3:
                    System.out.print("Enter Student ID to update: ");
                    int updateId = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter New Name: ");
                    String newName = scanner.nextLine();
                    System.out.print("Enter New Course: ");
                    String newCourse = scanner.nextLine();
                    manager.updateStudent(updateId, newName, newCourse);
                    break;

                case 4:
                    System.out.print("Enter Student ID to delete: ");
                    int deleteId = scanner.nextInt();
                    manager.deleteStudent(deleteId);
                    break;

                case 5:
                    System.out.println("Exiting...");
                    System.out.println("Done");
                   
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice! Try again.");
            }
        }
    }
}

