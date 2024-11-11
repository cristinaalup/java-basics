import interfaces.Course;
import models.*;

import java.util.Date;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        System.out.println("and let the training begin...\n\n\n");

        Student fullTimeStudent= new Student("Tudor", "Vadim", true);
        Student partTimeStudent= new Student("Andreea", "Balan", false);
        Student student1= new Student("Vladimir", "Putin", false);
        Student student2= new Student("Donald", "Trump", false);
        Student student3= new Student("Sofia", "Vergara", true);
        Student student4= new Student("Antonio", "Banderas", true);

        System.out.println(fullTimeStudent.toString());
        System.out.println(partTimeStudent.toString());
        System.out.println(student1.toString());
        System.out.println(student2.toString());
        System.out.println(student3.toString());
        System.out.println(student4.toString());

        Course businessCourse = new BusinessCourse();
        Course economyCourse = new EconomyCourse();
        Course frenchCourse = new FrenchCourse();
        Course literatureCourse = new LiteratureCourse();
        Course mathCourse = new MathCourse();
        Course statisticsCourse = new StatisticsCourse();

        businessCourse.addStudent(fullTimeStudent);
        economyCourse.addStudent(fullTimeStudent);
        mathCourse.addStudent(fullTimeStudent);
        statisticsCourse.addStudent(fullTimeStudent);

        frenchCourse.addStudent(partTimeStudent);
        literatureCourse.addStudent(partTimeStudent);

        businessCourse.addStudent(student1);
        economyCourse.addStudent(student1);
        mathCourse.addStudent(student1);
        statisticsCourse.addStudent(student1);

        frenchCourse.addStudent(student2);
        literatureCourse.addStudent(student2);

        businessCourse.addStudent(student3);
        economyCourse.addStudent(student3);
        mathCourse.addStudent(student3);
        statisticsCourse.addStudent(student3);

        frenchCourse.addStudent(student4);
        literatureCourse.addStudent(student4);

        fullTimeStudent.addGrades(mathCourse,10.0);
        fullTimeStudent.addGrades(businessCourse,8.9);
        fullTimeStudent.addGrades(statisticsCourse, 6.7);
        fullTimeStudent.addGrades(economyCourse, 5.6);
        System.out.println(fullTimeStudent.getGpa());
        System.out.println(fullTimeStudent.getCourses().stream().map(Course::getCourseName).toList());
        fullTimeStudent.addGrades(statisticsCourse,9.0);
        System.out.println(fullTimeStudent.getGpa());
        fullTimeStudent.addGrades(literatureCourse,9.0);
        System.out.println(fullTimeStudent.getGpa());
    }
}