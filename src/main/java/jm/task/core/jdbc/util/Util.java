package jm.task.core.jdbc.util;


import jm.task.core.jdbc.model.User;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import java.util.Properties;

public class Util {

    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        Configuration configuration = new Configuration();
        Properties properties = new Properties();
        properties.put("hibernate.connection.url", "jdbc:mysql://localhost:3306/mydbtest");
        properties.put("hibernate.connection.username", "root");
        properties.put("hibernate.connection.password", "root");
        properties.put("hibernate.connection.driver_class", "com.mysql.jdbc.Driver");
        properties.put("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
        properties.put("hibernate.show_sql", "true");
        properties.put("hibernate.hbm2ddl_auto", "update");

        configuration.setProperties(properties).addAnnotatedClass(User.class);
        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(properties).build();
        sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        return sessionFactory;
    }
}