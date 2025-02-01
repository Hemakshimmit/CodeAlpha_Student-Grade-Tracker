import java.util.ArrayList;
import java.util.Scanner;

public class StudentGradeTracker {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Create an ArrayList to store student grades
        ArrayList<Integer> grades = new ArrayList<>();
        
        System.out.println("Welcome to the Student Grade Tracker!");

        // Input loop to enter grades
        while (true) {
            System.out.print("Enter student's grade (or type 'done' to finish): ");
            String input = scanner.nextLine();
            
            // If user types 'done', stop input
            if (input.equalsIgnoreCase("done")) {
                break;
            }
            
            try {
                // Try to parse the grade as an integer
                int grade = Integer.parseInt(input);
                
                // Validate if the grade is within a reasonable range (0 to 100)
                if (grade < 0 || grade > 100) {
                    System.out.println("Please enter a grade between 0 and 100.");
                } else {
                    grades.add(grade);
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid grade.");
            }
        }

        // Check if no grades were entered
        if (grades.isEmpty()) {
            System.out.println("No grades were entered.");
        } else {
            // Calculate and display the average, highest, and lowest grades
            double average = calculateAverage(grades);
            int highest = findHighestGrade(grades);
            int lowest = findLowestGrade(grades);

            System.out.println("\nGrade Report:");
            System.out.println("Average Grade: " + average);
            System.out.println("Highest Grade: " + highest);
            System.out.println("Lowest Grade: " + lowest);
        }

        scanner.close();
    }

    // Method to calculate the average grade
    public static double calculateAverage(ArrayList<Integer> grades) {
        int sum = 0;
        for (int grade : grades) {
            sum += grade;
        }
        return (double) sum / grades.size();
    }

    // Method to find the highest grade
    public static int findHighestGrade(ArrayList<Integer> grades) {
        int highest = grades.get(0);
        for (int grade : grades) {
            if (grade > highest) {
                highest = grade;
            }
        }
        return highest;
    }

    // Method to find the lowest grade
    public static int findLowestGrade(ArrayList<Integer> grades) {
        int lowest = grades.get(0);
        for (int grade : grades) {
            if (grade < lowest) {
                lowest = grade;
            }
        }
        return lowest;
    }
}
