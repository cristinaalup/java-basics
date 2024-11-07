package models;

import interfaces.Course;

import java.util.HashSet;
import java.util.Set;

public class StatisticsCourse implements Course {
    private final static String STATISTICS_COURSE_NAME = "Statistics";
    private final static int STATISTICS_COURSE_CREDITS = 8;
    private Set<Student> students;

    public StatisticsCourse() {
        this.students = new HashSet<>();
    }

    @Override
    public String getCourseName() {
        return STATISTICS_COURSE_NAME;
    }

    @Override
    public int getCredits() {
        return STATISTICS_COURSE_CREDITS;
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
        return STATISTICS_COURSE_CREDITS > 5 ? true : false;
    }
}
