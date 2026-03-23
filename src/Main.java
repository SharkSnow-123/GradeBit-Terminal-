import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;


public class Main {
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        List<Course> courses = new ArrayList<>();

        System.out.println("GradeBit -- Model Prototype 1");
        System.out.print("How many courses are you taking: ");
        int numCourses = sc.nextInt();
        sc.nextLine();

        for(int i = 0; i < numCourses; i++){
            System.out.println("\n--- Course #" + (i + 1) + " ---");
            System.out.print("Course Name: ");
            String courseName = sc.nextLine();

            System.out.print("Units: ");
            int courseUnits = sc.nextInt();

            Course course = new Course(courseName, courseUnits);

            System.out.print("How many grading categories: ");
            int numCategory = sc.nextInt();

            for(int j = 0; j < numCategory; j++){
                sc.nextLine();
                System.out.print("Category Name (Quiz, Midterm, Prelim, etc..: ");
                String categoryName = sc.nextLine();
                System.out.print("Weight: ");
                double weight = sc.nextDouble();
                System.out.print("Score: ");
                double score = sc.nextDouble();

            }
            sc.nextLine(); //clear buffer to avoid errors
            courses.add(course);
        }


        //Final Calculations
        double weightedPoints = 0;
        int totalUnits = 0;

        System.out.println("\n--- SUMMARY ---");
        //easier printing
        for(Course c : courses){
            double gp = c.getGradePoint();
            System.out.println(c.name + " | Units: " + c.units + " | Grades: " + gp);
            weightedPoints += (gp * c.units);
            totalUnits += c.units;

        }

        double finalGPA = (totalUnits == 0) ? 0 : (weightedPoints / totalUnits);
        System.out.println("Final Grade: " + String.format("%.1f", finalGPA));


    }

}
