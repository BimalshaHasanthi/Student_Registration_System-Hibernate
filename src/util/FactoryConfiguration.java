package util;

import entity.Detail;
import entity.Program;
import entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import java.io.IOException;
import java.util.Properties;

public class FactoryConfiguration {
    private  static FactoryConfiguration factoryConfiguration;

    private static SessionFactory sessionFactory;

    private FactoryConfiguration(){
        StandardServiceRegistry stg = new StandardServiceRegistryBuilder().loadProperties("hibernate.properties").build();

        Metadata metadata= new MetadataSources(stg)
                .addAnnotatedClass(Student.class)
                .addAnnotatedClass(Program.class)
                .addAnnotatedClass(Detail.class)
                .getMetadataBuilder().build();
        sessionFactory=metadata.getSessionFactoryBuilder().build();

    }

    public  static FactoryConfiguration getInstance(){
        if (factoryConfiguration == null){
            factoryConfiguration = new FactoryConfiguration();
        }
        return factoryConfiguration;
    }

    public Session getSession(){
        return sessionFactory.openSession();
    }
}