/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.se.hibernate.mssql.dao;

import com.se.hibernate.mssql.model.Student;
import com.se.hibernate.mssql.util.HibernateUtil;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author Admin
 */
public class StudentDao {
    private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
    public void saveStudent(Student student) {
        Session session = null;
        Transaction tr = null;
        try {
            session = sessionFactory.getCurrentSession();
            tr = session.beginTransaction();
            session.save(student);
            tr.commit();
        } catch (HibernateException e) {
            if(tr != null) tr.rollback();
            e.printStackTrace();
        }
    }
    
    public void removeStudent(int id) {
        Session session = null;
        Transaction tr = null;
        try {
            session = sessionFactory.getCurrentSession();
            tr = session.beginTransaction();
            Student st = session.find(Student.class, id);
            if(st != null) {
                session.delete(st);
                System.out.println("Deleted");
            }
            tr.commit();
        } catch (HibernateException e) {
            if(tr != null) tr.rollback();
            e.printStackTrace();
        }
    }
    
    public void updateStudent(Student student) {
        Session session = null;
        Transaction tr = null;
        try {
            session = sessionFactory.getCurrentSession();
            tr = session.beginTransaction();
            Student st = session.find(Student.class, student.getId());
            if(st != null) {
                session.update(st);
                System.out.println("Updated");
            }
            tr.commit();
        } catch (HibernateException e) {
            if(tr != null) tr.rollback();
            e.printStackTrace();
        }
    }
    
    public Student getStudent(int id) {
        Session session = null;
        Transaction tr = null;
        Student st = null;
        try {
            session = sessionFactory.getCurrentSession();
            tr = session.beginTransaction();
            st = session.find(Student.class, id);
            tr.commit();
        } catch (HibernateException e) {
            if(tr != null) tr.rollback();
            e.printStackTrace();
        }
        return st;
    }
    
    public List<Student> getListStudent() {
        Session session = null;
        Transaction tr = null;
        List<Student> list = null;
        try {
            session = sessionFactory.getCurrentSession();
            tr = session.beginTransaction();
            list = session.createQuery("select * from student").getResultList();
            tr.commit();
        } catch (HibernateException e) {
            if(tr != null) tr.rollback();
            e.printStackTrace();
        }
        return list;
    }
}
