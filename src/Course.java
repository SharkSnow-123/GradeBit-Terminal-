import java.util.ArrayList;
import java.util.List;

public class Course {
    String name;
    int units;
    List<GradeCategory> categories = new ArrayList<>();

    public Course(String name, int units) {
        this.name = name;
        this.units = units;
    }

    public void addCategory(String name, double weight, double score) {
        categories.add(new GradeCategory(name, weight, score));
    }

    public double calculateAverage() {
        double weightedSum = 0;
        double totalWeight = 0;
        for (GradeCategory cat : categories) {
            weightedSum += (cat.score * (cat.weight / 100.0));
            totalWeight += (cat.weight / 100.0);
        }
        return (totalWeight == 0) ? 0 : (weightedSum / totalWeight);
    }

    // Function 2: Predict what you need on the Final to reach a target
    public double predictRequiredFinal(double currentScore, double currentWeight, double target) {
        double remainingWeight = 100.0 - currentWeight;
        // Formula: (Target - (Current * Weight)) / RemainingWeight
        return (target - (currentScore * (currentWeight / 100.0))) / (remainingWeight / 100.0);
    }
}