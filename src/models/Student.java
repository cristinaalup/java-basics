package models;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Student {
    //attributes
    private static int NEXT_ID = 10;
    private String firstName;
    private String lastName;
    private int id;
    private boolean isFullTime;
    private List<Double> grades = new ArrayList<>();
    private double gpa;
    private LocalDate enrollmentDate;

    //default constructor
    public Student() {
    }

    //constructor with parameters
    public Student(String firstName, String lastName, boolean isFullTime) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = NEXT_ID++;
        this.isFullTime = isFullTime;
        this.enrollmentDate = LocalDate.now();
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

    public double getGpa() {
        return this.grades.stream()
                .mapToDouble(Double::doubleValue)
                .average()
                .orElse(0.0);
    }

    public LocalDate getEnrollmentDate() {
        return enrollmentDate;
    }

    public void setEnrollmentDate(LocalDate enrollmentDate) {
        this.enrollmentDate = enrollmentDate;
    }

    public List<Double> getGrades() {
        return grades;
    }

    public void addGrade(double grade) {
        this.grades.add(grade);
    }

    @Override
    public String toString() {
        return "Student " + firstName + " " + lastName +
                ", with ID: " + id+ ", GPA: " + getGpa() +
                ", is studying " + (isFullTime ? "full time" : "part time") +
                " since " + enrollmentDate;
    }
}
