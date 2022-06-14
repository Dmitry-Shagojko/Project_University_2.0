package util;

import exception.OldTeacherException;
import exception.YoungTeacherException;
import model.Teacher;

public class AgeTeacherUtil {

    public static Teacher checkAge(Teacher teacher) {

        try {
            checkYoungTeacherAge(teacher.getAge());
            checkOldTeacherAge(teacher.getAge());
            System.out.println("New teacher " + teacher.getName() + " " +
                    teacher.getFamilyName() + " add at university!");
            return teacher;
        } catch (YoungTeacherException | OldTeacherException e) {
            e.printStackTrace();
            System.out.println("New teacher " + teacher.getName() + " " +
                    teacher.getFamilyName() + " is not added at university!");
            return null;
        }
    }

    public static void checkYoungTeacherAge(int age) throws YoungTeacherException {
        if (age < 25) {
            throw new YoungTeacherException("New Teacher is young");
        }
    }

    public static void checkOldTeacherAge(int age) throws OldTeacherException {
        if (age > 70) {
            throw new OldTeacherException("New Teacher is old");
        }
    }
}
