package org.example;

import java.util.List;
import java.util.Map;
import java.util.Objects;

public class HonorsCourse extends Course implements RScoreCalculable {
    private double honorBonus;

    public HonorsCourse(String code, String title, double weight, Professor professor, List<Student> students, Map<Student, Double> grades, double honorBonus) {
        super(code, title, weight, professor, students, grades);
        this.honorBonus = honorBonus;
    }

    /**
     * apply a bonus to the student grade if taking a hounours course
     * @param grade
     * @return bonified grade
     */
    public double applyBonus(double grade) {
        return honorBonus + grade;
    }

    /**
     * calculate a students r-Score using their grade , the class average and the weight of eaxh course
     *
     * @param grade
     * @param classAverage
     * @param weight
     * @return the rscore with a bonus due to the student being in honours
     */
    @Override
    public double calculateRScore(double grade, double classAverage, double weight) {
        double boosted = applyBonus(grade);
        if (classAverage == 0.0) return 0;
        return (boosted / classAverage) * weight * 10;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        HonorsCourse that = (HonorsCourse) o;
        return Double.compare(honorBonus, that.honorBonus) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), honorBonus);
    }

    @Override
    public String toString() {
        return super.toString() + "HonorsCourse{" +
                "honorBonus=" + honorBonus +
                '}';
    }

    public double getHonorBonus() {
        return honorBonus;
    }

    public void setHonorBonus(double honorBonus) {
        this.honorBonus = honorBonus;
    }
}