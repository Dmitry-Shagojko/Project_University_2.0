package services;

import model.Teacher;
import repository.TeacherRepository;
import util.AgeTeacherUtil;
import util.MaxWageComparatorUtil;

import java.util.ArrayList;

public class TeacherServices {

    public TeacherRepository teacherRepository;

    public TeacherServices() {
        this.teacherRepository = new TeacherRepository();
    }

//    public void addTeacher(Teacher teacher) {
//        teacherRepository.addTeacher(AgeTeacherUtil.checkAge(teacher));
//    }

    public void deleteTeacher(Teacher teacher) {
        teacherRepository.deleteTeacher(teacher);
    }

    public void setTeacher(int pos, Teacher teacher) {
        teacherRepository.setTeacher(pos, teacher);
    }



    public void addTeacherAll(ArrayList<Teacher> listAllTeachers){
        teacherRepository.addTeacherAll(AgeTeacherUtil.checkAge(listAllTeachers));
    }



    public void setWage(Teacher teacher, int hour) {
        if (hour > 0 && hour <= 50) {
            teacher.salary = hour * 20;
        } else if (hour > 50 && hour <= 100) {
            teacher.salary = hour * 20 + 20;
        } else if (hour > 100) {
            teacher.salary = hour * 20 + 40;
        } else if (hour <= 0) {
            teacher.salary = 0;
        }
    }

    public int getWage(Teacher teacher) {
        return teacher.salary;
    }

    public void outputListOfRetiretTeachers(TeacherServices teacherServices) {
        System.out.println('\n' + "List of retired teachers: ");
        teacherServices.teacherRepository.teachers.stream()
                .filter(t -> (t.getGender().equals("Female") && t.getAge() > 54) ||
                        t.getGender().equals("Male") && t.getAge() > 60)
                .forEach(t -> System.out.println(t.getName().concat(" ").concat(t.getFamilyName()).concat(", ")
                        .concat(t.getGender()).concat(", ")
                        .concat(String.valueOf(t.getAge())).concat(" years.")));
    }

    public void outputSortingTeacherBySalary(TeacherServices teacherServices) {
        System.out.println('\n' + "Sorting list of teachers by salary level (>2 000 USD):");
        teacherServices.teacherRepository.teachers.stream()
                .filter(t -> (teacherServices.getWage(t) > 2_000))
                .forEach(t -> System.out.println(t.getName() + " " + t.getFamilyName() + ", " + ": salary - " +
                        teacherServices.getWage(t) + " USD;"));
    }

    public void sortingTeacherByFamily(TeacherServices teacherServices) {
        System.out.println('\n' + "List of teachers in alphabetical order:");
        teacherServices.teacherRepository.teachers.stream()
                .map(t -> t.getFamilyName().concat(" ").concat(t.getName()))
                .sorted()
                .forEach(System.out::println);
    }

    public void sortingTeacherBySumSalary(TeacherServices teacherServices) {
        System.out.println('\n' + "Sorting list of teachers by salary level using Comparator:");
        MaxWageComparatorUtil maxWageComparatorUtil = new MaxWageComparatorUtil();
        teacherServices.teacherRepository.teachers.stream()
                .sorted(maxWageComparatorUtil)
                .forEach(t -> System.out.println(t.getFamilyName() + " " + t.getName() + " ---> " +
                        teacherServices.getWage(t) + " USD;"));
    }
}

