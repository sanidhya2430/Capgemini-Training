package com.capgi.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "student")
public class Student implements Comparable<Student> {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private String dept;
    private int age;
    private double marks;

    public Student(){}

    public Student(int id, String name, String dept, int age, double marks) {
        this.id = id;
        this.name = name;
        this.dept = dept;
        this.age = age;
        this.marks = marks;
    }

    public void setMarks(double marks) {
        this.marks = marks;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDept() {
        return dept;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public double getMarks() {
        return marks;
    }
    @Override
    public int compareTo(Student other){
        return Double.compare(this.marks,other.marks);
    }
    public String toString(){
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", dept='" + dept + '\'' +
                ", age=" + age +
                ", marks=" + marks +
                '}';
    }
}
