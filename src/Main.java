import models.Student;

import java.util.Date;

public class Main {
    public static void main(String[] args) {

        System.out.println("and let the training begin...\n\n\n");

        Student fullTimeStudent= new Student("Tudor", "Vadim", true);
        Student partTimeStudent= new Student("Andreea", "Balan", false);

        System.out.println(fullTimeStudent.toString());
        System.out.println(partTimeStudent.toString());

        fullTimeStudent.addGrade(9.8);
        fullTimeStudent.addGrade(7.7);
        System.out.println(fullTimeStudent.getGrades());
        System.out.println(fullTimeStudent.getGpa());
    }
}