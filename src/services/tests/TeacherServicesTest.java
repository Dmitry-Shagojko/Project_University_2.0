package services.tests;


import model.Address;
import model.Teacher;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import services.TeacherServices;
import util.ReadingFilesUtil;

public class TeacherServicesTest {
    TeacherServices teacherServices;
    int hour;

    @Before
    public void setUp() throws Exception {
        teacherServices = new TeacherServices();
        teacherServices.addTeacherAll(ReadingFilesUtil.createTeachers("ListTeachers.txt"));
    }

    @Test
    public void checkWagePositive() {
        hour = 100;
        teacherServices.setWage(teacherServices.teacherRepository.teachers.get(0), hour);
        Assert.assertNotNull(teacherServices.getWage(teacherServices.teacherRepository.teachers.get(0)));
        Assert.assertTrue(2020 == teacherServices.getWage(teacherServices.teacherRepository.teachers.get(0)));
    }

    @Test
    public void checkWageZero() {
        hour = 0;
        teacherServices.setWage(teacherServices.teacherRepository.teachers.get(0), hour);
        Assert.assertNotNull(teacherServices.getWage(teacherServices.teacherRepository.teachers.get(0)));
        Assert.assertTrue(0 == teacherServices.getWage(teacherServices.teacherRepository.teachers.get(0)));
    }

    @Test
    public void checkWageNegative() {
        hour = -10;
        teacherServices.setWage(teacherServices.teacherRepository.teachers.get(0), hour);
        Assert.assertNotNull(teacherServices.getWage(teacherServices.teacherRepository.teachers.get(0)));
        Assert.assertTrue(0 == teacherServices.getWage(teacherServices.teacherRepository.teachers.get(0)));
    }

}