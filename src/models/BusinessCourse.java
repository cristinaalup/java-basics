package models;

import interfaces.Course;

import java.util.HashSet;
import java.util.Set;

public class BusinessCourse implements Course {
    private final static String BUSINESS_COURSE_NAME = "Business";
    private final static int BUSINESS_COURSE_CREDITS = 6;
    private Set<Student> students;

    public BusinessCourse() {
        this.students = new HashSet<>();
    }

    @Override
    public String getCourseName() {
        return BUSINESS_COURSE_NAME;
    }

    @Override
    public int getCredits() {
        return BUSINESS_COURSE_CREDITS;
    }

    @Override
    public void addStudent(Student newStudent) {
        this.students.add(newStudent);
        newStudent.getCourses().add(this);
    }

    @Override
    public void removeStudent(Student oldStudent) {
        oldStudent.getCourses().remove(this);
        this.students.remove(oldStudent);
    }

    @Override
    public boolean isMandatory() {
        return BUSINESS_COURSE_CREDITS > 5 ? true : false;
    }
}
