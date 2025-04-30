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

    public double applyBonus(double grade) {
        return honorBonus + grade;
    }

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