package org.example;

import java.util.*;

public abstract class Course implements Comparable<Course> {
    protected String code;
    protected String title;
    protected double weight;
    protected Professor professor;
    protected List<Student> students = new ArrayList<>();
    protected Map<Student, Double> grades = new HashMap<>();

    public Course(String code, String title, double weight,Professor professor, List<Student> students, Map<Student, Double> grades) {
        this.code = code;
        this.title = title;
        this.weight = weight;
        this.professor = professor;
        this.students = students;
        this.grades = grades;
    }
    public void addStudent(Student s) {
        students.add(s);
    }

    public void addGrade(Student student, double grade) {
        grades.put(student, grade);
    }

    public void addGrade(String studentId, double grade) {
        for (Student s : students) {
            if (s.getId().equals(studentId)) {
                addGrade(s, grade);
                break;
            }
        }
    }

    public Double getGradeForStudent(Student s) {
        return grades.get(s);
    }

    public double calculateClassAverage() {
        return grades.values().stream().mapToDouble(Double::doubleValue).average().orElse(0.0);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Course course = (Course) o;
        return Double.compare(weight, course.weight) == 0 && Objects.equals(code, course.code) && Objects.equals(title, course.title) && Objects.equals(professor, course.professor) && Objects.equals(students, course.students) && Objects.equals(grades, course.grades);
    }

    @Override
    public int compareTo(Course o) {
        return Double.compare(weight, o.weight);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code, title, weight, professor, students, grades);
    }

    @Override
    public String toString() {
        return "Course{" +
                "code='" + code + '\'' +
                ", title='" + title + '\'' +
                ", weight=" + weight +
                ", professor=" + professor +
                ", students=" + students +
                ", grades=" + grades +
                '}';
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public Map<Student, Double> getGrades() {
        return grades;
    }

    public void setGrades(Map<Student, Double> grades) {
        this.grades = grades;
    }
}

