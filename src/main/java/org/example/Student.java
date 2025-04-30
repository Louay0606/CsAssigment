package org.example;

import java.util.*;

public class Student extends User  {
    private String program;
    private int semester;
    private List<Course> courses;
    private double score;

    public Student(String id, String name, String email, String program, int semester, List<Course> courses, double score) {
        super(id, name, email);
        this.program = program;
        this.semester = semester;
        this.courses = new ArrayList<>();
        this.score = score;
    }
    public void addCourse(Course c) {
        courses.add(c);
    }

    public Map<String, Double> calculateRScore() {
        Map<String, Double> rScores = new HashMap<>();
        for (Course c : courses) {
            Double grade = c.getGradeForStudent(this);
            if (grade != null && c instanceof RScoreCalculable) {
                double classAvg = c.calculateClassAverage();
                double rScore = ((RScoreCalculable) c).calculateRScore(grade, classAvg, c.getWeight());
                rScores.put(c.getCode(), rScore);
            }
        }
        return rScores;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Student student = (Student) o;
        return semester == student.semester && Double.compare(score, student.score) == 0 && Objects.equals(program, student.program) && Objects.equals(courses, student.courses);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), program, semester, courses, score);
    }

    @Override
    public String toString() {
        return super.toString() +
                "program='" + program + '\'' +
                ", semester=" + semester +
                ", courses=" + courses +
                ", score=" + score +
                ", id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
    public static class ScoreComparator implements Comparator<Student> {
        @Override
        public int compare(Student s1, Student s2) {
            return Double.compare(s2.getScore(), s1.getScore()); // Descending order
        }
    }
    public String getProgram() {
        return program;
    }

    public void setProgram(String program) {
        this.program = program;
    }

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }
}
