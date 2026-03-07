package com.capgi;

import com.capgi.entity.Student;
import com.capgi.repository.StudentRepository;

import java.util.List;

public class MainApp {

    public static void main(String[] args) {

        StudentRepository repository = new StudentRepository();

        // ------------------ CREATE ------------------
        Student s1 = new Student();
        s1.setName("Rahul");
        s1.setDept("CSE");
        s1.setAge(21);
        s1.setMarks(85.5);

        repository.save(s1);

        Student s2 = new Student();
        s2.setName("Anjali");
        s2.setDept("IT");
        s2.setAge(22);
        s2.setMarks(90.0);

        repository.save(s2);

        Student s3 = new Student();
        s3.setName("Sanidhya");
        s3.setDept("IT");
        s3.setAge(22);
        s3.setMarks(95.0);

        repository.save(s3);

        System.out.println("Students inserted successfully!\n");

        // ------------------ FETCH ALL ------------------
        System.out.println("All Students:");
        List<Student> students = repository.fetchAll();
        students.forEach(System.out::println);

        // ------------------ FETCH BY ID ------------------
        System.out.println("\nStudent with ID 1:");
        Student student = repository.fetchById(1);
        System.out.println(student);

        // ------------------ UPDATE ------------------
        repository.updateMarks(1, 95.0);
        System.out.println("\nMarks updated successfully!");

        // Verify Update
        System.out.println("After Update:");
        System.out.println(repository.fetchById(1));

        // ------------------ DELETE ------------------
//        repository.delete(2);
//        System.out.println("\nStudent with ID 2 deleted!");

        // Verify Delete
        System.out.println("Final Student List:");
        repository.fetchAll().forEach(System.out::println);

        // Close SessionFactory
        StudentRepository.closeFactory();
    }
}