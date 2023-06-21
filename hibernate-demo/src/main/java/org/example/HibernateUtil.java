package org.example;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    private static SessionFactory factory;

    public static SessionFactory getSessionFactory() {
        if (factory == null) {
            Configuration configuration = new Configuration();
            configuration.configure("hibernate.cfg.xml");
            factory = configuration.buildSessionFactory();
        }
        return factory;
    }
}
