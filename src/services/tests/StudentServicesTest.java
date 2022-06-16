package services.tests;

import model.Group;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import services.StudentServices;
import services.TeacherServices;
import util.ReadingFilesUtil;

public class StudentServicesTest {
    StudentServices studentServices;
    StudentServices studentServicesGroup;
    TeacherServices teacherServices;
    Group group;

    @Before
    public void setUp() throws Exception {
        studentServices = new StudentServices();
        studentServices.addStudentAll(ReadingFilesUtil.createStudents("ListStudents.txt"));
        studentServicesGroup = new StudentServices();
        teacherServices = new TeacherServices();
        teacherServices.addTeacherAll(ReadingFilesUtil.createTeachers("ListTeachers.txt"));
        group = new Group("131B", 1, 2021, 2025, studentServicesGroup.studentRepository.students,
                teacherServices.teacherRepository.teachers.get(0));
    }

    @Test
    public void addStudent() {
        Assert.assertTrue(0 == studentServicesGroup.studentRepository.students.size());
        studentServicesGroup.addStudent(studentServices.studentRepository.students.get(0));
        studentServicesGroup.addStudent(studentServices.studentRepository.students.get(1));
        studentServicesGroup.addStudent(studentServices.studentRepository.students.get(2));
        Assert.assertTrue(3 == studentServicesGroup.studentRepository.students.size());
        Assert.assertEquals(group.getStudents(), studentServicesGroup.studentRepository.students);
        Assert.assertSame(group.getStudents(), studentServicesGroup.studentRepository.students);
    }

    @Test
    public void deleteStudent() {
        studentServicesGroup.addStudent(studentServices.studentRepository.students.get(0));
        studentServicesGroup.addStudent(studentServices.studentRepository.students.get(1));
        studentServicesGroup.addStudent(studentServices.studentRepository.students.get(2));
        studentServicesGroup.deleteStudent(studentServices.studentRepository.students.get(1));
        Assert.assertTrue(2 == studentServicesGroup.studentRepository.students.size());
        Assert.assertEquals(group.getStudents(), studentServicesGroup.studentRepository.students);
        Assert.assertFalse(studentServicesGroup.studentRepository.students
                .contains(studentServicesGroup.studentRepository.students.get(1).getFamilyName()));
    }
}