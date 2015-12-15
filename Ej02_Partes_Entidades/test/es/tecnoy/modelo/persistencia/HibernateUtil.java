package es.tecnoy.modelo.persistencia;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class HibernateUtil {
	public static SessionFactory getSessionFactory() {
		Configuration configuration = new Configuration();
		configuration.configure("es/tecnoy/cfg/hibernate.cfg.xml");
		ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();        
		SessionFactory sf = configuration.buildSessionFactory(serviceRegistry);
		return sf;
	}
}
