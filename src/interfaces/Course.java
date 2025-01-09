package interfaces;

import models.Student;

public interface Course {
    String getCourseName();
    void addStudent(Student newStudent);
    void removeStudent(Student oldStudent);
}
