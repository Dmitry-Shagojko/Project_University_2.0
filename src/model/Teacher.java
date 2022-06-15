package model;

import base.People;

public class Teacher extends People {
    public int salary;

    public Teacher(String name, String familyName, int age, String gender, Address address) {
        super(name, familyName, age, gender, address);
    }

    @Override
    public String toString() {
        return "Teacher: " + super.getName() + " " + super.getFamilyName() + ", " + super.getAge() + " years," +
                super.getGender() + "; " + super.getAddress().toString();
    }
}
