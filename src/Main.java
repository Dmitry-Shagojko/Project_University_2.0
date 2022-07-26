
import model.Group;
import services.GroupServices;
import services.MethodistServices;
import services.StudentServices;
import services.TeacherServices;
import util.ReadingFilesUtil;


public class Main {
    public static void main(String[] args) {

        TeacherServices listAllTeachers = new TeacherServices();
        listAllTeachers.addTeacherAll(ReadingFilesUtil.createTeachers("ListTeachers.txt"));

        StudentServices listAllStudents = new StudentServices();
        listAllStudents.addStudentAll(ReadingFilesUtil.createStudents("ListStudents.txt"));

        StudentServices studentServicesGroup1 = new StudentServices();
        studentServicesGroup1.addStudent(listAllStudents.studentRepository.students.get(0));
        studentServicesGroup1.addStudent(listAllStudents.studentRepository.students.get(1));
        studentServicesGroup1.addStudent(listAllStudents.studentRepository.students.get(2));
        studentServicesGroup1.deleteStudent(listAllStudents.studentRepository.students.get(2));
        studentServicesGroup1.addStudent(listAllStudents.studentRepository.students.get(12));

        StudentServices studentServicesGroup2 = new StudentServices();
        studentServicesGroup2.addStudent(listAllStudents.studentRepository.students.get(3));
        studentServicesGroup2.addStudent(listAllStudents.studentRepository.students.get(4));
        studentServicesGroup2.addStudent(listAllStudents.studentRepository.students.get(5));

        StudentServices studentServicesGroup3 = new StudentServices();
        studentServicesGroup3.addStudent(listAllStudents.studentRepository.students.get(6));
        studentServicesGroup3.addStudent(listAllStudents.studentRepository.students.get(7));
        studentServicesGroup3.addStudent(listAllStudents.studentRepository.students.get(8));

        StudentServices studentServicesGroup4 = new StudentServices();
        studentServicesGroup4.addStudent(listAllStudents.studentRepository.students.get(9));
        studentServicesGroup4.addStudent(listAllStudents.studentRepository.students.get(10));
        studentServicesGroup4.addStudent(listAllStudents.studentRepository.students.get(11));

        Group group1 = new Group("131B", 1, 2021, 2025, studentServicesGroup1.studentRepository.students,
                listAllTeachers.teacherRepository.teachers.get(0));
        Group group2 = new Group("119A", 3, 2019, 2023, studentServicesGroup2.studentRepository.students,
                listAllTeachers.teacherRepository.teachers.get(1));
        Group group3 = new Group("151F", 1, 2021, 2025, studentServicesGroup3.studentRepository.students,
                listAllTeachers.teacherRepository.teachers.get(2));
        Group group4 = new Group("110C", 2, 2020, 2024, studentServicesGroup4.studentRepository.students,
                listAllTeachers.teacherRepository.teachers.get(3));
        GroupServices groupServices = new GroupServices();
        groupServices.addGroup(group1);
        groupServices.addGroup(group2);
        groupServices.addGroup(group3);
        groupServices.addGroup(group4);

        // для получения суммы ЗП каждого учителя, необходимо установить кол-во отработнных часов
        listAllTeachers.setWage(listAllTeachers.teacherRepository.teachers.get(0), 110);
        listAllTeachers.setWage(listAllTeachers.teacherRepository.teachers.get(1), 50);
        listAllTeachers.setWage(listAllTeachers.teacherRepository.teachers.get(2), 100);
        listAllTeachers.setWage(listAllTeachers.teacherRepository.teachers.get(3), 130);
        listAllTeachers.setWage(listAllTeachers.teacherRepository.teachers.get(4), 30);
        listAllTeachers.setWage(listAllTeachers.teacherRepository.teachers.get(5), 150);
        listAllTeachers.setWage(listAllTeachers.teacherRepository.teachers.get(6), 70);
        listAllTeachers.setWage(listAllTeachers.teacherRepository.teachers.get(7), 85);
        listAllTeachers.setWage(listAllTeachers.teacherRepository.teachers.get(8), 74);

        listAllTeachers.outputListOfRetiretTeachers(listAllTeachers);  //вывод учителей на пенсии
        listAllTeachers.outputSortingTeacherBySalary(listAllTeachers); //вывод учителей по уровню ЗП > 2 000 USD
        groupServices.sortingGroupByYearOfGraduation(groupServices); //ввывод списка групп, выпуск которых 2023 - 2024 года
        listAllTeachers.sortingTeacherByFamily(listAllTeachers); //вывод списка учителей в алфавитном порядке

        listAllStudents.sortingStudentsByFamily(listAllStudents); //сортировка Comparable <Student>_по фамилии (весь список)
        studentServicesGroup1.sortingStudentsByFamily(studentServicesGroup1); //сортровка Comparable <Student>_по фамилии (в группе)
        listAllTeachers.sortingTeacherBySumSalary(listAllTeachers); //сортировка Comparator <Teacher>_по ЗП

        MethodistServices methodistServices = new MethodistServices();
        methodistServices.conversionClass(listAllTeachers.teacherRepository.teachers.get(8));   //конвертация учителя в методиста
        System.out.println("Test");
    }
}
