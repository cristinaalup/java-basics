import exceptions.NotSubscribedToThisCourseException;
import handlers.StudentCSVHandler;
import interfaces.Course;
import models.*;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        System.out.println("and let the training begin...\n\n\n");


        List<Student> students = StudentCSVHandler.readStudentsFromCSV("src/inputs/students-input.csv");
        for (Student s : students) {
            System.out.println(s);
        }

        Course businessCourse = new BusinessCourse();
        Course economyCourse = new EconomyCourse();
        Course frenchCourse = new FrenchCourse();
        Course literatureCourse = new LiteratureCourse();
        Course mathCourse = new MathCourse();
        Course statisticsCourse = new StatisticsCourse();

        List<Course> allCourses = Arrays.asList(businessCourse, economyCourse, frenchCourse, literatureCourse, mathCourse, statisticsCourse);

        Random random = new Random();

        for (Student student : students) {
            int numberOfCourses = random.nextInt(2) + 2;

            List<Course> selectedCourses = new ArrayList<>(allCourses);
            Collections.shuffle(selectedCourses);
            selectedCourses = selectedCourses.subList(0, numberOfCourses);

            for (Course course : selectedCourses) {
                course.addStudent(student);

                double randomGrade = 1.0 + (9.0 * random.nextDouble());
                String formattedGrade = String.format("%.2f", randomGrade);
                double finalGrade = Double.parseDouble(formattedGrade);
                try {
                    student.addGrades(course, finalGrade);
                } catch (NotSubscribedToThisCourseException e) {
                    System.err.println(e.getMessage());
                }
            }
        }

        Student newStudent1 = new Student("Mihai", "Popescu", true);
        Student newStudent2 = new Student("Ana", "Ionescu", false);

        businessCourse.addStudent(newStudent1);
        statisticsCourse.addStudent(newStudent1);
        frenchCourse.addStudent(newStudent2);
        literatureCourse.addStudent(newStudent2);
        try {
            newStudent1.addGrades(businessCourse, 5.9);
            newStudent1.addGrades(statisticsCourse, 9.8);
            newStudent2.addGrades(literatureCourse, 7.4);
            newStudent2.addGrades(frenchCourse, 8.5);
        } catch (NotSubscribedToThisCourseException e) {
            throw new RuntimeException(e);
        }

        students.add(newStudent1);
        students.add(newStudent2);

        StudentCSVHandler.saveAllStudentsToCSV(students, "students.csv");

        Student newStudent3 = new Student("Corina", "Marinescu", true);
        mathCourse.addStudent(newStudent3);
        businessCourse.addStudent(newStudent3);
        try {
            newStudent3.addGrades(mathCourse,10.0);
            newStudent3.addGrades(businessCourse,7.9);
        } catch (NotSubscribedToThisCourseException e) {
            throw new RuntimeException(e);
        }
        StudentCSVHandler.saveStudentToCSV(newStudent3,"students.csv");

    }


}