package peaksoft.config;

import jakarta.persistence.EntityManager;
import org.hibernate.cfg.Configuration;
import peaksoft.entity.Course;
import peaksoft.entity.Instructor;
import peaksoft.entity.Lesson;
import peaksoft.entity.Task;

import static org.hibernate.cfg.AvailableSettings.*;

public class HibernateConfig {

public static EntityManager getEntityManager(){
    Configuration configuration = new Configuration();
    configuration.setProperty(DRIVER,"org.postgresql.Driver");
    configuration.setProperty(URL,"jdbc:postgresql://localhost:5432/contact");
    configuration.setProperty(USER,"postgres");
    configuration.setProperty(PASS,"postgres");
    configuration.setProperty(HBM2DDL_AUTO,"update");
    configuration.setProperty(DIALECT,"org.hibernate.dialect.PostgreSQLDialect");
    configuration.setProperty(SHOW_SQL,"true");
    configuration.addAnnotatedClass(Instructor.class);
    configuration.addAnnotatedClass(Course.class);
    configuration.addAnnotatedClass(Lesson.class);
    configuration.addAnnotatedClass(Task.class);
    return configuration.buildSessionFactory().createEntityManager();
}
}
