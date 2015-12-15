package es.tecnoy;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import es.tecnoy.modelo.entidad.Cliente;
import es.tecnoy.modelo.entidad.ContactoCliente;
import es.tecnoy.modelo.entidad.Domicilio;

public class PruebasHibernate {

	private static final boolean ContactoCliente = false;

	public static void main(String[] args) {
		
		//Hasta Hibernate3
				//SessionFactory sf = new Configuration().
				//		                configure("com/atrium/curso/cfg/hibernate.cfg.xml").
				//		                buildSessionFactory();

				//A partir de Hibernate 4
			    Configuration configuration = new Configuration();
			    configuration.configure("es/tecnoy/cfg/hibernate.cfg.xml");
			    ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();        
			    SessionFactory sf = configuration.buildSessionFactory(serviceRegistry);		
			
			    Domicilio domicilio= new Domicilio("Escondido", "C/Falsa", "123", "20000");
			    Cliente c = new Cliente(null, "Cliente1", "Descripcion bla bla bla" , "Comentarios no se que cuentos" , "www.tocoto.es", domicilio);
			    
			    ContactoCliente cc1= new ContactoCliente(null, "CCN1", "CCA1", c);
			    ContactoCliente cc2= new ContactoCliente(null, "CCN2", "CCA2", c);
			    ContactoCliente cc3= new ContactoCliente(null, "CCN3", "CCA3", c);
			    ContactoCliente cc4= new ContactoCliente(null, "CCN4", "CCA4", c);
			    ContactoCliente cc5= new ContactoCliente(null, "CCN5", "CCA5", c);
			    
			    List<ContactoCliente> contactos= new ArrayList<ContactoCliente>();
			    contactos.add(cc1);
			    contactos.add(cc2);
			    contactos.add(cc3);
			    contactos.add(cc4);
			    contactos.add(cc5);
			    
			    c.setContactos(contactos);
			    
			    Session s= sf.openSession();
			    s.beginTransaction();
			    
			    //Esto es lo que tendriamos que hacer si al cliente no le hubieramos colocado el extremo opcional
			    //s.persist(c);
			    //s.persist(cc1);
			    //s.persist(cc2);
			    //s.persist(cc3);
			    //s.persist(cc4);
			    //s.persist(cc5);
			    
			    //s.persist(c);
			    
			    
			    s.getTransaction().commit();
			    s.close();
			    
			 
			    s = sf.openSession();
			    
			    
			    System.out.println("====================================================");
			    ContactoCliente cc6 = (ContactoCliente) s.get(ContactoCliente.class, 1);
			    System.out.println(cc6.getNombre());
			    System.out.println(cc6.getCliente().getNombre());
			    
			    s.clear();
			    
			    
			   System.out.println("====================================================");
			   Cliente c2 = (Cliente) s.get(Cliente.class, 1);
			   System.out.println(c2.getNombre());

			   
			   for(ContactoCliente cc: c2.getContactos()){
				   System.out.println(cc.getNombre());
			   }
			   
			   s.close();
			   
			   
			  
			    
			    
	}

}
