package util;

import model.Address;
import model.Student;
import model.Teacher;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


import static java.lang.Integer.parseInt;

public class ReadingFilesUtil {

    public static ArrayList<Teacher> createTeachers(String name) {
        FileReader listTeacher = null;
        ArrayList<Teacher> teachers = new ArrayList<>();

        try {
            listTeacher = new FileReader(name);
            int a;
            String teachersStr = "";
            while ((a = listTeacher.read()) != -1) {
                teachersStr += (char) a;
            }
            String[] data = teachersStr.split("\r\n");
            for (String t : data) {
                String[] dataTeachers = t.split(", ");
                teachers.add(
                        new Teacher(dataTeachers[0],
                                dataTeachers[1],
                                parseInt(dataTeachers[2]),
                                dataTeachers[3],
                                new Address(dataTeachers[4],
                                        dataTeachers[5],
                                        parseInt(dataTeachers[6]),
                                        parseInt(dataTeachers[7]))));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                listTeacher.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return teachers;
    }


    public static ArrayList<Student> createStudents(String name) {
        FileReader listStudent = null;
        ArrayList<Student> students = new ArrayList<>();

        try {
            listStudent = new FileReader(name);
            int s;
            String studentsStr = "";
            while ((s = listStudent.read()) != -1) {
                studentsStr += (char) s;
            }
            String[] data = studentsStr.split("\r\n");
            for (String t : data) {
                String[] dataStudents = t.split(", ");
                students.add(
                        new Student(dataStudents[0],
                                dataStudents[1],
                                parseInt(dataStudents[2]),
                                dataStudents[3],
                                new Address(dataStudents[4],
                                        dataStudents[5],
                                        parseInt(dataStudents[6]),
                                        parseInt(dataStudents[7]))));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                listStudent.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return students;
    }
}
