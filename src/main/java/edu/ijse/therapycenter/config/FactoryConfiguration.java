package edu.ijse.therapycenter.config;

import edu.ijse.therapycenter.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class FactoryConfiguration {
    private static FactoryConfiguration factoryConfiguration;
    private SessionFactory sessionFactory;

    private FactoryConfiguration() {
        Configuration configuration = new Configuration().configure()
                .addAnnotatedClass(Users.class)
                .addAnnotatedClass(Therapists.class)
                .addAnnotatedClass(Patients.class)
                .addAnnotatedClass(TherapyPrograms.class)
                .addAnnotatedClass(TherapySessions.class)
                .addAnnotatedClass(Payments.class);
        sessionFactory = configuration.buildSessionFactory();
    }

    public static FactoryConfiguration getInstance() {
        return (factoryConfiguration == null)
                ? factoryConfiguration = new FactoryConfiguration() : factoryConfiguration;
    }
    
    public Session getSession() {
        return sessionFactory.openSession();
    }
}