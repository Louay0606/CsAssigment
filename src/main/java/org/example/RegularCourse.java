package org.example;

import java.util.List;
import java.util.Map;

public class RegularCourse extends Course implements RScoreCalculable {
    public RegularCourse(String code, String title, double weight, Professor professor, List<Student> students, Map<Student, Double> grades) {
        super(code, title, weight, professor, students, grades);
    }

    /**
     * calculate a students R-score taking a regular course by using his grade the class average and the weight of the course
     * @param grade
     * @param classAverage
     * @param weight
     * @return
     */
    @Override
    public double calculateRScore(double grade, double classAverage, double weight) {
       if (classAverage==0 )return 0;
       return (grade + classAverage) * weight *10 ;
    }

}
