/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.se.hibernate.mssql.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

/**
 *
 * @author Admin
 */
public class HibernateUtil {
    private static final SessionFactory sessionFactory;
    static {
        try {
            StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure().build();
            Metadata metadata = new MetadataSources(registry)
                    .getMetadataBuilder()
                    .build();
            sessionFactory = metadata.getSessionFactoryBuilder().build();
        } catch (Throwable th) {
            throw new ExceptionInInitializerError(th);
        }
        
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
    
}
