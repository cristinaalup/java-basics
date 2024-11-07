package models;

import interfaces.Course;

import java.util.HashSet;
import java.util.Set;

public class EconomyCourse implements Course {
    private final static String ECONOMY_COURSE_NAME = "Economy";
    private final static int ECONOMY_COURSE_CREDITS = 4;
    private Set<Student> students;

    public EconomyCourse() {
        this.students = new HashSet<>();
    }

    @Override
    public String getCourseName() {
        return ECONOMY_COURSE_NAME;
    }

    @Override
    public int getCredits() {
        return ECONOMY_COURSE_CREDITS;
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
        return ECONOMY_COURSE_CREDITS > 5 ? true : false;
    }
}
