package services.tests;


import model.Address;
import model.Teacher;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import services.TeacherServices;

public class TeacherServicesTest {
    TeacherServices teacherServices;
    Teacher teacher;
    int hour;
    Address address;

    @Before
    public void setUp() throws Exception {
        teacherServices = new TeacherServices();
        address = new Address("Minsk", "Sverdlova str.", 23, 1);
        teacher = new Teacher("Alex", "Williams", 45, "Male", address);
    }

    @Test
    public void checkWagePositive() {
        hour = 100;
        teacherServices.setWage(teacher, hour);
        Assert.assertNotNull(teacherServices.getWage(teacher));
        Assert.assertTrue(2020 == teacherServices.getWage(teacher));
    }

    @Test
    public void checkWageZero() {
        hour = 0;
        teacherServices.setWage(teacher, hour);
        Assert.assertNotNull(teacherServices.getWage(teacher));
        Assert.assertTrue(0 == teacherServices.getWage(teacher));
    }
    @Test
    public void checkWageNegative() {
        hour = -10;
        teacherServices.setWage(teacher, hour);
        Assert.assertNotNull(teacherServices.getWage(teacher));
        Assert.assertTrue(0 == teacherServices.getWage(teacher));
    }

}