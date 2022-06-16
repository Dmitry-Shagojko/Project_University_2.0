package base;

import model.Address;

public abstract class People {
    private String name;
    private String familyName;
    private int age;
    private String gender;
    Address address;

    public People(String name, String familyName, int age, String gender, Address address) {
        this.name = name;
        this.familyName = familyName;
        this.age = age;
        this.gender = gender;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age > 0) {
            this.age = age;
        } else if (age == 0 || age < 0) {
            System.out.println("Check entered age: " + getClass() + " " + getName() +
                    " " + getFamilyName() + " !!!");
            this.age = 0;
        }
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "People{" +
                "name='" + this.name + '\'' +
                ", familyName='" + this.familyName + '\'' +
                ", age=" + this.age +
                ", gender='" + this.gender + '\'' +
                ", address=" + this.address.toString() +
                '}';
    }
}
