package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Professor extends User {
        private String department;
        private List<Course> courses;

        public Professor(String id, String name, String email, String department, List<Course> courses) {
            super(id, name, email);
            this.department = department;
            this.courses = new ArrayList<>();
        }
        public void assignCourse(Course course) {
            courses.add(course);
        }

        @Override
        public boolean equals(Object o) {
            if (o == null || getClass() != o.getClass()) return false;
            if (!super.equals(o)) return false;
            Professor professor = (Professor) o;
            return Objects.equals(department, professor.department) && Objects.equals(courses, professor.courses);
        }

        @Override
        public int hashCode() {
            return Objects.hash(super.hashCode(), department, courses);
        }

        @Override
        public String toString() {
            return super.toString() +
                    "department='" + department + '\'' +
                    ", courses=" + courses +
                    '}';
        }

        public String getDepartment() {
            return department;
        }

        public void setDepartment(String department) {
            this.department = department;
        }

        public List<Course> getCourses() {
            return courses;
        }

        public void setCourses(List<Course> courses) {
            this.courses = courses;
        }
    }
