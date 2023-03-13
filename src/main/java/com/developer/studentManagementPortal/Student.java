package com.developer.studentManagementPortal;

public class Student {
    private String name;
    private int age;
    private String branch;
    private int admnNo;

    public Student(String name, int age, String branch, int admnNo) {
        this.name = name;
        this.age = age;
        this.branch = branch;
        this.admnNo = admnNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public int getAdmnNo() {
        return admnNo;
    }

    public void setAdmnNo(int admnNo) {
        this.admnNo = admnNo;
    }
}
