package com.capgi.repository;

import com.capgi.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class StudentRepository {

    private static SessionFactory sessionFactory;

    // Static block to create SessionFactory only once
    static {
        sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();
    }

    // -------------------- SAVE --------------------
    public void save(Student student) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();

        session.persist(student);

        tx.commit();
        session.close();
    }

    // -------------------- FETCH ALL --------------------
    public List<Student> fetchAll() {
        Session session = sessionFactory.openSession();
        List<Student> students =
                session.createQuery("from Student", Student.class).list();
        session.close();
        return students;
    }

    // -------------------- FETCH BY ID --------------------
    public Student fetchById(int id) {
        Session session = sessionFactory.openSession();
        Student student = session.get(Student.class, id);
        session.close();
        return student;
    }

    // -------------------- UPDATE MARKS --------------------
    public void updateMarks(int id, double marks) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();

        Student student = session.get(Student.class, id);
        if (student != null) {
            student.setMarks(marks);
        }

        tx.commit();
        session.close();
    }

    // -------------------- DELETE --------------------
    public void delete(int id) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();

        Student student = session.get(Student.class, id);
        if (student != null) {
            session.remove(student);
        }

        tx.commit();
        session.close();
    }

    // -------------------- CLOSE FACTORY --------------------
    public static void closeFactory() {
        sessionFactory.close();
    }
}