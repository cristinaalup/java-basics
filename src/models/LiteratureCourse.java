package models;

import interfaces.Course;

import java.util.HashSet;
import java.util.Set;

public class LiteratureCourse implements Course {
    private final static String LITERATURE_COURSE_NAME = "Literature";
    private final static int LITERATURE_COURSE_CREDITS = 7;
    private Set<Student> students;

    public LiteratureCourse() {
        this.students = new HashSet<>();
    }

    @Override
    public String getCourseName() {
        return LITERATURE_COURSE_NAME;
    }

    @Override
    public int getCredits() {
        return LITERATURE_COURSE_CREDITS;
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
        return LITERATURE_COURSE_CREDITS > 5 ? true : false;
    }
}
