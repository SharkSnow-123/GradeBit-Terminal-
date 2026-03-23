import java.util.ArrayList;
import java.util.List;

public class Course {

    String name;
    int units;
    List<GradeCategory> categories = new ArrayList<>();

    public Course(String name, int units){
        this.name = name;
        this.units = units;
    }

    public void addCategory(String name, double weight, double score){
        categories.add(new GradeCategory(name, weight, score));
    }

    public double calculateAverage(){
        double weightedSum = 0;
        double totalWeight = 0;

        for(GradeCategory cat : categories){
            weightedSum += (cat.score * cat.weight);
            totalWeight += cat.weight;
        }

        return (totalWeight == 0) ? 0 : (weightedSum / totalWeight);
    }

    public double getGradePoint() {
        double grade = calculateAverage();

        if (grade >= 95) return 5.0;
        if (grade == 94) return 4.9;
        if (grade == 93) return 4.8;
        if (grade == 92) return 4.7;
        if (grade == 91) return 4.6;
        if (grade == 90) return 4.5;
        if (grade == 89) return 4.4;
        if (grade == 88) return 4.3;
        if (grade == 87) return 4.2;
        if (grade == 86) return 4.1;
        if (grade == 85) return 4.0;
        if (grade == 84) return 3.9;
        if (grade == 83) return 3.8;
        if (grade == 82) return 3.7;
        if (grade == 81) return 3.6;
        if (grade == 80) return 3.5;
        if (grade == 79) return 3.4;
        if (grade == 78) return 3.3;
        if (grade == 77) return 3.2;
        if (grade == 76) return 3.1;
        if (grade == 75) return 3.0;

        return 1.0; // below 75 = Failed
    }

    public String getStatus(){ //Status of the grade like if 5.0 = Excellent;
        double grade = calculateAverage();
        if(grade >= 93) return "Excellent";
        if(grade >= 86 && grade <= 92) return "Very Good";
        if(grade >= 80 && grade <= 85) return "Good";
        if(grade >= 75 && grade <= 79) return "Fair";

        return "Fail";
    }
}


