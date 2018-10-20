package unq.eis.service.runner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class SessionFactoryProvider {
    private static SessionFactoryProvider INSTANCE;

    private SessionFactory sessionFactory;

    public static SessionFactoryProvider getInstance() {
        if (INSTANCE == null) INSTANCE = new SessionFactoryProvider();
        return INSTANCE;
    }

    public static void destroy() {
        if (INSTANCE != null && INSTANCE.sessionFactory != null) INSTANCE.sessionFactory.close();
        INSTANCE = null;
    }

    public static void clear() {
        Runner.runInSession(() -> {
            Session session = Runner.getCurrentSession();
            List<String> nombreDeTablas = session.createNativeQuery("show tables").getResultList();
            session.createNativeQuery("SET FOREIGN_KEY_CHECKS=0;").executeUpdate();
            nombreDeTablas.forEach(tabla -> session.createNativeQuery("truncate table " + tabla).executeUpdate());
            session.createNativeQuery("SET FOREIGN_KEY_CHECKS=1;").executeUpdate();
            return null;
        });
    }

    private SessionFactoryProvider() {
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");
        this.sessionFactory = configuration.buildSessionFactory();
    }

    public Session createSession() {
        return this.sessionFactory.openSession();
    }
}