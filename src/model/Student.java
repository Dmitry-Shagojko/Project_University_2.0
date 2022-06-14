package model;

import base.People;

public class Student extends People implements Comparable<Student>{

    public Student(String name, String familyName, int age, String gender, Address address) {
        super(name, familyName, age, gender, address);
    }

    @Override
    public String toString() {
        return "Student: " + super.getName() + " " + super.getFamilyName() + ", " + super.getAge() + " years," +
                super.getGender() + "; " + super.getAddress().toString();
    }

    @Override
    public int compareTo(Student o) {
        if (this.getFamilyName().compareTo(o.getFamilyName())==0){
        return  this.getName().compareTo(o.getName());
        }
        else {
            return this.getFamilyName().compareTo(o.getFamilyName());
        }
    }
}
