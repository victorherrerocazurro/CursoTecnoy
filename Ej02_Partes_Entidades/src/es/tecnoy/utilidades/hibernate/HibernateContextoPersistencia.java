package es.tecnoy.utilidades.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

//Como tiene constructor por defecto, es instanaciable por el contexto de JSF
public class HibernateContextoPersistencia {
	
	private static SessionFactory sf;
	
	static{
		Configuration configuration = new Configuration();
		configuration.configure("es/tecnoy/cfg/hibernate.cfg.xml");
		ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();        
		sf = configuration.buildSessionFactory(serviceRegistry);
	}
	
	public Session getSesionActual(){
		return sf.getCurrentSession();
	}

}
