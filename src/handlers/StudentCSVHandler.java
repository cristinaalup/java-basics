package handlers;

import interfaces.Course;
import models.Student;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class StudentCSVHandler {
    public static List<Student> readStudentsFromCSV(String fileName) {
        List<Student> students = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            boolean isHeader = true;

            while ((line = reader.readLine()) != null) {
                if (isHeader) {
                    isHeader = false;
                    continue;
                }

                String[] parts = line.split(",");

                String firstName = parts[0].trim();
                String lastName = parts[1].trim();
                boolean fullTime = Boolean.parseBoolean(parts[2].trim());

                Student student = new Student(firstName, lastName, fullTime);
                students.add(student);
            }
        } catch (IOException e) {
            System.err.println("Error reading csv file: " + e.getMessage());
        }

        return students;
    }

    private static boolean doesStudentExist(String filename, int studentId) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            reader.readLine();

            while ((line = reader.readLine()) != null) {
                String[] columns = line.split(",");
                int id = Integer.parseInt(columns[0].trim());
                if (id == studentId) {
                    return true;
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading the csv file: " + e.getMessage());
        }
        return false;
    }

    public static void saveStudentToCSV(Student student, String filename) {
        try (FileWriter writer = new FileWriter(filename, true)) {
            boolean isFileEmpty = new java.io.File(filename).length() == 0;

            if (isFileEmpty) {
                writer.append("ID,FirstName,LastName,FullTime,EnrollmentDate,Courses,GPA\n");
            }

            if (doesStudentExist(filename, student.getId())) {
                return;
            }

            StringBuilder sb = new StringBuilder();

            String courses = String.join(";", student.getCourses().stream().map(Course::getCourseName).toList());

            double gpa = student.getGpa();
            DecimalFormat df = new DecimalFormat("0.00");
            String gpaFormatted = df.format(gpa);

            sb.append(student.getId()).append(",")
                    .append(student.getFirstName()).append(",")
                    .append(student.getLastName()).append(",")
                    .append(student.isFullTime()).append(",")
                    .append(student.getEnrollmentDate()).append(",")
                    .append(courses).append(",")
                    .append(gpaFormatted).append("\n");


            writer.append(sb.toString());


        } catch (IOException e) {
            System.err.println("Error saving the student in csv file: " + e.getMessage());
        }
    }

    public static void saveAllStudentsToCSV(List<Student> students, String filename) {
        for (Student student : students) {
            saveStudentToCSV(student, filename);
        }
    }
}
