package util;

import model.Teacher;

import java.util.Comparator;

public class MaxWageComparator implements Comparator<Teacher> {
    @Override
    public int compare(Teacher o1, Teacher o2) {
        if (o2.getSalary() - o1.getSalary() == 0){
            return o1.getFamilyName().compareTo(o2.getFamilyName());
        }
        return o2.getSalary() - o1.getSalary();
    }
}
