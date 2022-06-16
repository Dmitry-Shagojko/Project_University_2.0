package base.tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import services.StudentServices;
import services.TeacherServices;
import util.ReadingFilesUtil;

public class PeopleTest {
    StudentServices studentServices;
    TeacherServices teacherServices;

    @Before
    public void setUp() throws Exception {
        studentServices = new StudentServices();
        studentServices.addStudentAll(ReadingFilesUtil.createStudents("ListStudents.txt"));
        teacherServices = new TeacherServices();
        teacherServices.addTeacherAll(ReadingFilesUtil.createTeachers("ListTeachers.txt"));
    }

    @Test
    public void checkPositiveAge() {
        studentServices.studentRepository.students.get(0).setAge(29);
        teacherServices.teacherRepository.teachers.get(0).setAge(46);
        Assert.assertTrue(29 == studentServices.studentRepository.students.get(0).getAge());
        Assert.assertTrue(46 == teacherServices.teacherRepository.teachers.get(0).getAge());
        Assert.assertNotNull(studentServices.studentRepository.students.get(0));
    }

    @Test
    public void checkZeroAge() {
        studentServices.studentRepository.students.get(0).setAge(0);
        teacherServices.teacherRepository.teachers.get(0).setAge(0);
        Assert.assertTrue(0 == studentServices.studentRepository.students.get(0).getAge());
        Assert.assertTrue(0 == teacherServices.teacherRepository.teachers.get(0).getAge());
        Assert.assertNotNull(studentServices.studentRepository.students.get(0));
    }

    @Test
    public void checkNegativeAge() {
        studentServices.studentRepository.students.get(0).setAge(-29);
        teacherServices.teacherRepository.teachers.get(0).setAge(-46);
        Assert.assertTrue(0 == studentServices.studentRepository.students.get(0).getAge());
        Assert.assertTrue(0 == teacherServices.teacherRepository.teachers.get(0).getAge());
        Assert.assertNotNull(studentServices.studentRepository.students.get(0));
    }
}