package Operations;

import java.io.*;
import java.util.*;

import Model.Student;

public class StudentManager {
    private List<Student> students;
    private static final String FILE_NAME = "Files/Students.txt";

    public StudentManager() {
        this.students = new ArrayList<>();
        loadFromFile();
    }
    
    public boolean idExists(int id) {
    	
    	// Check if student ID already exists
        boolean exists = students.stream().anyMatch(s -> s.getId() == id);
        
        if (exists) {
            System.out.println("A student with ID " + id + " already exists!");
            return true;
        }
    	
    	return false;
    }

    // Add Student
    public void addStudent(int id, String name, String course) {
        

        // Add new student
        students.add(new Student(id, name, course));
        
        // Save changes immediately
        saveToFile();
        System.out.println("Student added successfully.");
    }


    

    
    // View All Students
    public void viewStudents() {
        if (students.isEmpty()) {
            System.out.println("No students found.");
            return;
        }
        for (Student s : students) {
            System.out.println("ID: " + s.getId() + ", Name: " + s.getName() + ", Course: " + s.getCourse());
        }
    }

    // Update Student
    public void updateStudent(int id, String newName, String newCourse) {
        for (Student s : students) {
            if (s.getId() == id) {
                s.setName(newName);
                s.setCourse(newCourse);
                saveToFile();
                System.out.println("Student updated successfully!");
                return;
            }
        }
        System.out.println("Student not found.");
    }

    // Delete Student
 
    public void deleteStudent(int id) {
        boolean removed = students.removeIf(s -> s.getId() == id);
        if (removed) {
            saveToFile(); // Ensure the file updates immediately
            System.out.println("Student deleted successfully!");
        } else {
            System.out.println("Student not found.");
        }
    }

    // Save to File
    private void saveToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (Student s : students) {
                writer.write(s.toString());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error saving data.");
        }
    }

    // Load from File
    private void loadFromFile() {
        File file = new File(FILE_NAME);
        if (!file.exists()) return;

        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                students.add(new Student(Integer.parseInt(parts[0]), parts[1], parts[2]));
            }
        } catch (IOException e) {
            System.out.println("Error loading data.");
        }
    }
}

