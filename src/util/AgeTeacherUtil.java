package util;

import exception.OldTeacherException;
import exception.YoungTeacherException;
import model.Teacher;

import java.util.ArrayList;

public class AgeTeacherUtil {

    public static ArrayList<Teacher> checkAge(ArrayList<Teacher> teachers) {
        boolean test = false;
        ArrayList<Teacher> checkedListTeacher = new ArrayList<Teacher>();
        for (Teacher teacher : teachers) {
            try {
                checkYoungTeacherAge(teacher.getAge());
                checkOldTeacherAge(teacher.getAge());
                System.out.println("New teacher " + teacher.getName() + " " +
                        teacher.getFamilyName() + " add at university!");
                checkedListTeacher.add(teacher);
//            return teacher;
            } catch (YoungTeacherException | OldTeacherException e) {
                e.printStackTrace();
                System.out.println("New teacher " + teacher.getName() + " " +
                        teacher.getFamilyName() + " is not added at university! <----------");
                test = false;
//            return null;
            }
        }return checkedListTeacher;

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
