package models;

import interfaces.Course;

import java.util.HashSet;
import java.util.Set;

public class FrenchCourse implements Course {
    private final static String FRENCH_COURSE_NAME = "French";
    private final static int FRENCH_COURSE_CREDITS = 3;
    private Set<Student> students;

    public FrenchCourse() {
        this.students=new HashSet<>();
    }

    @Override
    public String getCourseName() {
        return FRENCH_COURSE_NAME;
    }

    @Override
    public int getCredits() {
        return FRENCH_COURSE_CREDITS;
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
        return FRENCH_COURSE_CREDITS > 5 ? true : false;
    }
}
