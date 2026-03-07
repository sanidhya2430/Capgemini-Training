package com.capgi.dao;

import com.capgi.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class StudentDAOImpl implements StudentDAO {

    private SessionFactory sessionFactory;

    public StudentDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void save(Student student) {
            Session session = sessionFactory.openSession();
            Transaction tx = session.beginTransaction();
            session.persist(student);
            tx.commit();
            session.close();
    }

    @Override
    public List<Student> fetchAll() {
            Session session = sessionFactory.openSession();
            List<Student> list= session.createQuery("from Student", Student.class).list();
            session.close();
            return list;
    }

    @Override
    public Student fetchById(int id) {
            Session session = sessionFactory.openSession();
            return session.get(Student.class, id);

    }

    @Override
    public void updateMarks(int id, double marks) {
            Session session = sessionFactory.openSession();
            Transaction tx = session.beginTransaction();

            Student student = session.get(Student.class, id);
            if (student != null) {
                student.setMarks(marks);
            }

            tx.commit();
    }

    @Override
    public void delete(int id) {
            Session session = sessionFactory.openSession();
            Transaction tx = session.beginTransaction();

            Student student = session.get(Student.class, id);
            if (student != null) {
                session.remove(student);
            }

            tx.commit();
    }

    @Override
    public List<Student> sortByMarks() {
            Session session = sessionFactory.openSession();
            return session.createQuery(
                    "from Student order by marks",
                    Student.class
            ).list();
    }

    @Override
    public List<Student> sortByAgeDesc() {
            Session session = sessionFactory.openSession();
            return session.createQuery(
                    "from Student order by age desc",
                    Student.class
            ).list();

    }

    @Override
    public List<Student> filterByDept(String dept) {
            Session session = sessionFactory.openSession() ;
            return session.createQuery(
                            "from Student where dept = :dept",
                            Student.class
                    )
                    .setParameter("dept", dept)
                    .list();
    }

    @Override
    public List<Student> nativeFetch() {
            Session session = sessionFactory.openSession();
            return session.createNativeQuery(
                    "select * from student",
                    Student.class
            ).list();
    }

    @Override
    public void nativeUpdateMarks(int id, double marks) {
            Session session = sessionFactory.openSession();
            Transaction tx = session.beginTransaction();

            session.createNativeQuery(
                            "update student set marks = :marks where id = :id"
                    )
                    .setParameter("marks", marks)
                    .setParameter("id", id)
                    .executeUpdate();

            tx.commit();
    }
}