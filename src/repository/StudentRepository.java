package repository;

import model.Student;

import java.util.ArrayList;

public class StudentRepository {

    public ArrayList<Student> students;

    public StudentRepository() {
        this.students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        students.add(student);
    }
    public void addStudentAll(ArrayList<Student> listAllStudents) {
        students.addAll(listAllStudents);
    }

    public void deleteStudent(Student student) {
        students.remove(student);
    }
    public void setStudent (int pos, Student student){
        students.set(pos, student);
    }

}
