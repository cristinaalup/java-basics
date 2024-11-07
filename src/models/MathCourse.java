package models;

import interfaces.Course;

import java.util.HashSet;
import java.util.Set;

public class MathCourse implements Course {
    private final static String MATH_COURSE_NAME = "Math";
    private final static int MATH_COURSE_CREDITS = 8;
    private Set<Student> students;

    public MathCourse() {
        this.students = new HashSet<>();
    }

    @Override
    public String getCourseName() {
        return MATH_COURSE_NAME;
    }

    @Override
    public int getCredits() {
        return MATH_COURSE_CREDITS;
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
        return MATH_COURSE_CREDITS > 5 ? true : false;
    }
}
