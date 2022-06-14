package services;

import model.Student;
import repository.StudentRepository;

public class StudentServices {

    public StudentRepository studentRepository;

    public StudentServices() {
        studentRepository = new StudentRepository();
    }

    public void addStudent(Student student) {
        studentRepository.addStudent(student);
    }

    public void deleteStudent(Student student) {
        studentRepository.deleteStudent(student);
    }

    public void setStudent(int pos, Student student) {
        studentRepository.setStudent(pos, student);
    }

    public void addStudentSumList(StudentServices sumListStudents) {
        studentRepository.students.addAll(sumListStudents.studentRepository.students);
    }

    public void sortingStudentsByFamily(StudentServices sumListStudents) {
        System.out.println('\n' + "Sorting list of students using Comparable:");
        sumListStudents.studentRepository.students.stream()
                .sorted()
                .forEach(t -> System.out.println(t.getFamilyName() + " " + t.getName()));
    }
}
