package model;

import java.util.ArrayList;

public class Group {
    private String nameGroup;
    private int course;
    private int yearOfEntry;
    private int yearOfGraduation;
    private ArrayList<Student> students;
    private Teacher teacher;

    public Group(String nameGroup, int course, int yearOfAdmission, int yearOfIssue,
                 ArrayList<Student> students, Teacher teacher) {
        this.nameGroup = nameGroup;
        this.course = course;
        this.yearOfEntry = yearOfAdmission;
        this.yearOfGraduation = yearOfIssue;
        this.students = students;
        this.teacher = teacher;
    }

    public String getNameGroup() {
        return nameGroup;
    }

    public void setNameGroup(String nameGroup) {
        this.nameGroup = nameGroup;
    }

    public int getCourse() {
        return course;
    }

    public void setCourse(int course) {
        this.course = course;
    }

    public int getYearOfEntry() {
        return yearOfEntry;
    }

    public void setYearOfEntry(int yearOfEntry) {
        this.yearOfEntry = yearOfEntry;
    }

    public int getYearOfGraduation() {
        return yearOfGraduation;
    }

    public void setYearOfGraduation(int yearOfGraduation) {
        this.yearOfGraduation = yearOfGraduation;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public void setStudents(ArrayList<Student> students) {
        this.students = students;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    @Override
    public String toString() {
        return "Group: " +
                "nameGroup='" + this.nameGroup + '\'' +
                ", course=" + this.course +
                ", yearOfAdmission=" + this.yearOfEntry +
                ", yearOfIssue=" + this.yearOfGraduation +
                ", student=" + this.students +
                ", teacher=" + this.teacher;
    }
}
