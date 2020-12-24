package com.lkl.entity;

public class Dog {
    private int did;
    private String dname;
    private String dspecies;
    private int age;

    public Dog() {
    }

    public Dog(int did, String dname, String dspecies, int age) {
        this.did = did;
        this.dname = dname;
        this.dspecies = dspecies;
        this.age = age;
    }

    public int getDid() {
        return did;
    }

    public void setDid(int did) {
        this.did = did;
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public String getDspecies() {
        return dspecies;
    }

    public void setDspecies(String dspecies) {
        this.dspecies = dspecies;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "did=" + did +
                ", dname='" + dname + '\'' +
                ", dspecies='" + dspecies + '\'' +
                ", age=" + age +
                '}';
    }
}
