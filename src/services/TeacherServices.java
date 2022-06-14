package services;

import model.Teacher;
import repository.TeacherRepository;
import util.AgeTeacherUtil;
import util.MaxWageComparator;

public class TeacherServices {

    public TeacherRepository teacherRepository;

    public TeacherServices() {
        this.teacherRepository = new TeacherRepository();
    }

    public void addTeacher(Teacher teacher) {
        teacherRepository.addTeacher(AgeTeacherUtil.checkAge(teacher));
    }

    public void deleteTeacher(Teacher teacher) {
        teacherRepository.deleteTeacher(teacher);
    }

    public void setTeacher(int pos, Teacher teacher) {
        teacherRepository.setTeacher(pos, teacher);
    }

    public void setWage(Teacher teacher, int hour) {
        teacher.setSalary(hour);
    }

    public int getWage(Teacher teacher) {
        return teacher.getSalary();
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
                        t.getSalary() + " USD;"));
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
        MaxWageComparator maxWageComparator = new MaxWageComparator();
        teacherServices.teacherRepository.teachers.stream()
                .sorted(maxWageComparator)
                .forEach(t -> System.out.println(t.getFamilyName() + " " + t.getName() + " ---> " +
                        teacherServices.getWage(t) + " USD;"));
    }
}

