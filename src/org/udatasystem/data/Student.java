package org.udatasystem.data;

public class Student {

    private int studentId;
    private String fullName;
    private int age;

    public Student(int studentId, String fullName, int age) {
        this.studentId = studentId;
        this.fullName = fullName;
        this.age = age;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

