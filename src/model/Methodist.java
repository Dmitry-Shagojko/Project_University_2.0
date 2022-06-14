package model;

import base.People;

public class Methodist extends People {
    public Methodist(String name, String familyName, int age, String gender, Address address) {
        super(name, familyName, age, gender, address);
    }

    @Override
    public String toString() {
        return "Methodist: " + super.getName() + " " + super.getFamilyName() + ", " + super.getAge() + " years," +
        super.getGender() + "; " + super.getAddress().toString();
    }
}
