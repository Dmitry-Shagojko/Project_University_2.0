package services.tests;


import model.Address;
import model.Group;
import model.Student;
import model.Teacher;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import services.StudentServices;

public class StudentServicesTest {
    StudentServices studentServices;
    Address address1;
    Address address2;
    Address address3;
    Address address4;
    Student student1;
    Student student2;
    Student student3;
    Teacher teacher;
    Group group;

    @Before
    public void setUp() throws Exception {
        studentServices = new StudentServices();
        address1 = new Address("Cruickshanktown", "Doris Camp", 2914, 13);
        address2 = new Address("East Margarett", "Sabina Ranch", 1, 521);
        address3 = new Address("Marinaton", "Jovani Points Suite", 15, 101);
        address4 = new Address("Garrisonmouth", "Adrienne Parkways", 12, 22);
        student1 = new Student("Kathlyn", "Alison", 19, "Female", address1);
        student2 = new Student("David", "Cobb", 20, "Male", address2);
        student3 = new Student("Thomas", "Willis", 22, "Male", address3);
        teacher = new Teacher("Petra", "Gutmann", 45, "Female", address4);
        group = new Group("131B", 1, 2021, 2025, studentServices.studentRepository.students, teacher);
    }

    @Test
    public void addStudent() {
        Assert.assertTrue(0 == studentServices.studentRepository.students.size());
        studentServices.addStudent(student1);
        studentServices.addStudent(student2);
        studentServices.addStudent(student3);
        Assert.assertTrue(3 == studentServices.studentRepository.students.size());
        Assert.assertEquals(group.getStudents(), studentServices.studentRepository.students);
        Assert.assertSame(group.getStudents(), studentServices.studentRepository.students);

    }

    @Test
    public void deleteStudent() {
        studentServices.addStudent(student1);
        studentServices.addStudent(student2);
        studentServices.addStudent(student3);
        studentServices.deleteStudent(student2);
        Assert.assertTrue(2 == studentServices.studentRepository.students.size());
        Assert.assertEquals(group.getStudents(), studentServices.studentRepository.students);
        Assert.assertFalse(studentServices.studentRepository.students
                .contains(student2.getFamilyName()));
    }
}