package base.tests;


import model.Address;
import model.Methodist;
import model.Student;
import model.Teacher;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PeopleTest {
    Student student;
    Teacher teacher;
    Methodist methodist;
    Address address;

    @Before
    public void setUp() throws Exception {
        address = new Address("Minsk", "Sverdlova str.", 23, 1);
        student = new Student("Dmitry", "Shagojko", 28, "Male", address);
        teacher = new Teacher("Alex", "Williams", 45, "Male", address);
        methodist = new Methodist("Kate", "Window", 34, "Female", address);
    }

    @Test
    public void checkPositiveAge() {
        student.setAge(29);
        teacher.setAge(46);
        methodist.setAge(35);
        Assert.assertTrue(29 == student.getAge());
        Assert.assertTrue(46 == teacher.getAge());
        Assert.assertTrue(35 == methodist.getAge());
        Assert.assertNotNull(student);
    }
    @Test
    public void checkZeroAge() {
        student.setAge(0);
        teacher.setAge(0);
        methodist.setAge(0);
        Assert.assertTrue(0 == student.getAge());
        Assert.assertTrue(0 == teacher.getAge());
        Assert.assertTrue(0 == methodist.getAge());
        Assert.assertNotNull(student);
    }

    @Test
    public void checkNegativeAge() {
        student.setAge(-29);
        teacher.setAge(-46);
        methodist.setAge(-35);
        Assert.assertTrue(0 == student.getAge());
        Assert.assertTrue(0 == teacher.getAge());
        Assert.assertTrue(0 == methodist.getAge());
        Assert.assertNotNull(student);
    }
}