import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Course> courses = new ArrayList<>();

        System.out.println("=== GradeBit Model Prototype 1 ===");
        System.out.print("How many courses are you taking: ");
        int numCourses = sc.nextInt();

        for (int i = 0; i < numCourses; i++) {
            sc.nextLine(); // Clear buffer
            System.out.print("\nCourse Name: ");
            String name = sc.nextLine();
            System.out.print("Units: ");
            int units = sc.nextInt();

            Course course = new Course(name, units);

            System.out.print("How many categories (e.g., 2 for Midterm & Final): ");
            int numCats = sc.nextInt();

            for (int j = 0; j < numCats; j++) {
                sc.nextLine();
                System.out.print("Category Name: ");
                String catName = sc.nextLine();
                System.out.print("Weight (e.g., 50): ");
                double weight = sc.nextDouble();
                System.out.print("Score (e.g., 4.5): ");
                double score = sc.nextDouble();

                // FIXED: Actually adding the category to the list
                course.addCategory(catName, score, weight);
            }
            courses.add(course);
        }

        // Final Summary Logic
        double totalWeightedPoints = 0;
        int totalUnits = 0;

        System.out.println("\n--- FINAL SUMMARY ---");
        for (Course c : courses) {
            double avg = c.calculateAverage();
            System.out.printf("%s | Units: %d | Grade: %.2f\n", c.name, c.units, avg);
            totalWeightedPoints += (avg * c.units);
            totalUnits += c.units;
        }

        double finalGWA = (totalUnits == 0) ? 0 : (totalWeightedPoints / totalUnits);
        System.out.println("----------------------");
        System.out.printf("TOTAL UNITS: %d\n", totalUnits);
        System.out.printf("FINAL GWA: %.2f\n", finalGWA);
    }
}