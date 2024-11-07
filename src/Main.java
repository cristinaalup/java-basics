import interfaces.Course;
import models.*;

import java.util.Date;

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

    }
}