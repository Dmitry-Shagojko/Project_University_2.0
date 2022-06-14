import model.Address;
import model.Group;
import model.Student;
import model.Teacher;
import services.GroupServices;
import services.MethodistServices;
import services.StudentServices;
import services.TeacherServices;

public class Main {
    public static void main(String[] args) {
        Address address1 = new Address("Cruickshanktown", "Doris Camp", 2914, 13);
        Address address2 = new Address("East Margarett", "Sabina Ranch", 1, 521);
        Address address3 = new Address("Marinaton", "Jovani Points Suite", 15, 101);
        Address address4 = new Address("Garrisonmouth", "Adrienne Parkways", 12, 22);
        Address address5 = new Address("West Robyn", "Elissa Squares", 20, 42);
        Address address6 = new Address("East Elzahaven", "Friesen Burgs", 706, 866);
        Address address7 = new Address("Gonzalobury", "Gonzalobury", 988, 732);
        Address address8 = new Address("Port Emilview", "Nicolette Glens", 72, 973);
        Address address9 = new Address("South Alena", "Blair Loaf Suite", 315, 174);
        Address address10 = new Address("East Felicitatown", "Erica Creek Suite", 22, 51);
        Address address11 = new Address("Lake Gabriella", "Sophia Parks", 396, 1);
        Address address12 = new Address("East Augustinestad", "Manley Mountains", 13, 33);
        Address address13 = new Address("Port Maverickberg", "Tromp Route Suite", 72, 29);
        Address address14 = new Address("Darrinton", "Granville Greens", 34, 52);
        Address address15 = new Address("Adolfoland", "Jammie Rapids", 48, 9);
        Address address16 = new Address("Emeliafurt", "Griffin Ways", 64, 24);
        Address address17 = new Address("Casperstad", "Kacie Mountains", 71, 9);
        Address address18 = new Address("West Adrienne", "Schaefer Junction", 1, 3);
        Address address19 = new Address("Olinshire", "Jett Brook", 35, 70);
        Address address20 = new Address("West Burley", "Barrows Flats", 30, 1);
        Address address21 = new Address("Connellymouth", "Schinner Avenue", 32, 7);
        Address address22 = new Address("South Akeemtown", "Soledad Curve", 82, 6);

        Teacher teacher1 = new Teacher("Petra", "Gutmann", 45, "Female", address1);
        Teacher teacher2 = new Teacher("Bennett", "Pearson", 65, "Male", address2);
        Teacher teacher3 = new Teacher("Sheila", "Herzog", 28, "Female", address14);
        Teacher teacher4 = new Teacher("Reilly", "Altenwerth", 29, "Male", address15);
        Teacher teacher5 = new Teacher("Julien", "Kassulke", 34, "Male", address16);
        Teacher teacher6 = new Teacher("Cordia", "Quitzon", 58, "Female", address17);
        Teacher teacher7 = new Teacher("Newell", "Kunde", 66, "Male", address18);
        Teacher teacher8 = new Teacher("Gwendolyn", "Zemlak Jr.", 33, "Male", address19);
        Teacher teacher9 = new Teacher("Holly", "McDermott", 59, "Female", address20);

        Student student1 = new Student("Kathlyn", "Alison", 19, "Female", address3);
        Student student2 = new Student("David", "Cobb", 20, "Male", address4);
        Student student3 = new Student("Thomas", "Willis", 22, "Male", address5);
        Student student4 = new Student("Arne", "Hintz II", 19, "Male", address6);
        Student student5 = new Student("Floyd", "Stanton", 20, "Male", address7);
        Student student6 = new Student("Rocky", "Lemke", 21, "Male", address8);
        Student student7 = new Student("Carmen", "Altenwerth IV", 18, "Female", address9);
        Student student8 = new Student("Annette", "Ryan", 19, "Female", address10);
        Student student9 = new Student("Lukas", "Bradtke", 20, "Female", address11);
        Student student10 = new Student("Chelsey", "Lowe", 21, "Female", address12);
        Student student11 = new Student("Harrison", "Hagenes", 20, "Male", address21);
        Student student12 = new Student("Hugh", "Swaniawski", 19, "Male", address22);

        Student student13 = new Student("Joy", "Lobe", 20, "Male", address13);

        TeacherServices teacherServices = new TeacherServices();
        teacherServices.addTeacher(teacher1);
        teacherServices.addTeacher(teacher2);
        teacherServices.addTeacher(teacher3);
        teacherServices.addTeacher(teacher4);
        teacherServices.addTeacher(teacher5);
        teacherServices.addTeacher(teacher6);
        teacherServices.addTeacher(teacher7);
        teacherServices.addTeacher(teacher8);
        teacherServices.addTeacher(teacher9);

        StudentServices studentServicesGroup1 = new StudentServices();
        studentServicesGroup1.addStudent(student1);
        studentServicesGroup1.addStudent(student2);
        studentServicesGroup1.addStudent(student3);
        studentServicesGroup1.deleteStudent(student2);
        studentServicesGroup1.addStudent(student13);

        StudentServices studentServicesGroup2 = new StudentServices();
        studentServicesGroup2.addStudent(student4);
        studentServicesGroup2.addStudent(student5);
        studentServicesGroup2.addStudent(student6);

        StudentServices studentServicesGroup3 = new StudentServices();
        studentServicesGroup3.addStudent(student7);
        studentServicesGroup3.addStudent(student8);
        studentServicesGroup3.addStudent(student9);

        StudentServices studentServicesGroup4 = new StudentServices();
        studentServicesGroup4.addStudent(student10);
        studentServicesGroup4.addStudent(student11);
        studentServicesGroup4.addStudent(student12);

        Group group1 = new Group("131B", 1, 2021, 2025, studentServicesGroup1.studentRepository.students, teacher1);
        Group group2 = new Group("119A", 3, 2019, 2023, studentServicesGroup2.studentRepository.students, teacher2);
        Group group3 = new Group("151F", 1, 2021, 2025, studentServicesGroup3.studentRepository.students, teacher3);
        Group group4 = new Group("110C", 2, 2020, 2024, studentServicesGroup4.studentRepository.students, teacher4);
        GroupServices groupServices = new GroupServices();
        groupServices.addGroup(group1);
        groupServices.addGroup(group2);
        groupServices.addGroup(group3);
        groupServices.addGroup(group4);

        // для получения суммы ЗП каждого учителя, необходимо установить кол-во отработнных часов
        teacherServices.setWage(teacher1, 110);
        teacherServices.setWage(teacher2, 50);
        teacherServices.setWage(teacher3, 100);
        teacherServices.setWage(teacher4, 130);
        teacherServices.setWage(teacher5, 30);
        teacherServices.setWage(teacher6, 150);
        teacherServices.setWage(teacher7, 70);
        teacherServices.setWage(teacher8, 85);
        teacherServices.setWage(teacher9, 74);

        teacherServices.outputListOfRetiretTeachers(teacherServices);  //вывод учителей на пенсии
        teacherServices.outputSortingTeacherBySalary(teacherServices); //вывод учителей по уровню ЗП > 2 000 USD
        groupServices.sortingGroupByYearOfGraduation(groupServices); //ввывод списка групп, выпуск которых 2023 - 2024 года
        teacherServices.sortingTeacherByFamily(teacherServices); //вывод списка учителей в алфавитном порядке

        StudentServices sumListStudents = new StudentServices();
        sumListStudents.addStudentSumList(studentServicesGroup1);
        sumListStudents.addStudentSumList(studentServicesGroup2);
        sumListStudents.addStudentSumList(studentServicesGroup3);
        sumListStudents.addStudentSumList(studentServicesGroup4);

        sumListStudents.sortingStudentsByFamily(sumListStudents); //сортировка Comparable <Student>_по фамилии (весь список)
        studentServicesGroup1.sortingStudentsByFamily(studentServicesGroup1); //сортровка Comparable <Student>_по фамилии (в группе)
        teacherServices.sortingTeacherBySumSalary(teacherServices); //сортировка Comparator <Teacher>_по ЗП

        MethodistServices methodistServices = new MethodistServices();
        methodistServices.conversionClass(teacher8);                //конвертация учителя в методиста

//        teacherServices.addTeacher(new Teacher("Molly", "Dermott", 159, "Female", address20)); // Exception на возраст
    }
}
