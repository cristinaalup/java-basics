package interfaces;

import models.Student;

public interface Course {
    String getCourseName();
    int getCredits();
    void addStudent(Student newStudent);
    void removeStudent(Student oldStudent);
    boolean isMandatory();
}
