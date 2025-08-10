import java.io.*;
import java.util.*;

public class MainMenu {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        RankingDisplay finder = new TopBottomFinder();

        // Read file and validate
        try (BufferedReader br = new BufferedReader(new FileReader("Student.TXT"))) {
            String line = br.readLine(); 

            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length < 6) {
                    System.out.println("Invalid data line (not enough fields): " + line);
                    continue;
                }

                String lastName = parts[0].trim();
                String firstName = parts[1].trim();
                String fullName = firstName + " " + lastName;

                boolean invalidMarkFound = false;
                double totalMarks = 0;

                for (int i = 3; i <= 5; i++) {
                    String markStr = parts[i].trim();

                    if (markStr.isEmpty()) {
                        System.out.printf("Validation Error: Missing mark for %s in A%d. Skipping student.%n", fullName, i - 2);
                        invalidMarkFound = true;
                        break;
                    }

                    double mark;
                    try {
                        mark = Double.parseDouble(markStr);
                    } catch (NumberFormatException e) {
                        System.out.printf("Validation Error: Invalid mark '%s' for %s in A%d. Skipping student.%n", markStr, fullName, i - 2);
                        invalidMarkFound = true;
                        break;
                    }

                    if (mark < 0) {
                        System.out.printf("Validation Error: Negative mark (%.2f) for %s in A%d. Skipping student.%n", mark, fullName, i - 2);
                        invalidMarkFound = true;
                        break;
                    }

                    totalMarks += mark;
                }

                if (invalidMarkFound) {
                    continue;  // skip student
                }

                students.add(new Student(fullName, totalMarks));
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
            return;
        }
         Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n===== MENU =====");
            System.out.println("1. Show Top 5 Students");
            System.out.println("2. Show bottom 5 Students");
            System.out.println("3. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    finder.showHighestFive(students);
                    break;
                case 2:
                    finder.showLowestFive(students);
                    break;
                case 3:
                    System.out.println("Exiting program...");
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        } while (choice != 3);

        sc.close();
    }
}   