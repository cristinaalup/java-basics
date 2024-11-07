package models;

import interfaces.Course;

import java.time.LocalDate;
import java.util.*;

public class Student {
    //attributes
    private static int NEXT_ID = 10;
    private String firstName;
    private String lastName;
    private int id;
    private boolean isFullTime;
    private Set<Course> courses;
    private LocalDate enrollmentDate;
    private Map<Course, Double> grades;

    //default constructor
    public Student() {
    }

    //constructor with parameters
    public Student(String firstName, String lastName, boolean isFullTime) {
        this.id = NEXT_ID++;
        this.firstName = firstName;
        this.lastName = lastName;
        this.isFullTime = isFullTime;
        this.enrollmentDate = LocalDate.now();
        this.courses = new HashSet<>();
        this.grades = new HashMap<>();
    }

    //getters and setters

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isFullTime() {
        return isFullTime;
    }

    public void setFullTime(boolean fullTime) {
        isFullTime = fullTime;
    }

    public LocalDate getEnrollmentDate() {
        return enrollmentDate;
    }

    public void setEnrollmentDate(LocalDate enrollmentDate) {
        this.enrollmentDate = enrollmentDate;
    }

    public Set<Course> getCourses() {
        return courses;
    }

    public void setCourses(Set<Course> courses) {
        this.courses = courses;
    }

    public Map<Course, Double> getGrades() {
        return grades;
    }

    public void addGrades(Course course, double grade) {
        if (this.grades.containsKey(course)) {
            this.grades.replace(course, grade);
        }
        this.grades.put(course, grade);
    }

    public double getGpa() {
        return grades.values()
                .stream()
                .mapToDouble(Double::doubleValue)
                .average()
                .orElse(0.0);
    }

    @Override
    public String toString() {
        return "Student " + firstName + " " + lastName +
                ", with ID: " + id + ", GPA: " + getGpa() +
                ", is studying " + (isFullTime ? "full time" : "part time") +
                " since " + enrollmentDate;
    }
}
