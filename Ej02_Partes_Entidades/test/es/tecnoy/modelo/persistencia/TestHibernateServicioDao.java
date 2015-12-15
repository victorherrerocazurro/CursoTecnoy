package es.tecnoy.modelo.persistencia;

import static org.junit.Assert.fail;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Assert;
import org.junit.Test;

import es.tecnoy.modelo.entidad.Servicio;

public class TestHibernateServicioDao {

	@Test
	public void testAltaServicio() {
		
		Session s = null; 
		
		try{
			
		SessionFactory sf = HibernateUtil.getSessionFactory();
		
		ServicioDao dao = new HibernateServicioDao(sf);
		
		// Si pusieramos aqui openSession nos crearia una nueva sesion y no accederiamos a la misma que tenemos en el otro lado
		s= sf.getCurrentSession();
		s.beginTransaction();
		    
		Servicio servicio= new Servicio(-1, "descripcion", new Date(), new Date(), null, null);
		dao.add(servicio);
		
		Assert.assertTrue(servicio.getCodigo() > 0);
		//Assert.assertEquals(Integer.valueOf(1), servicio.getCodigo());
		
		s.getTransaction().commit();
		
		
		} catch (Exception e){
			
			e.printStackTrace();
			s.getTransaction().rollback();
			fail("Not yet implemented");
		
		
		}
		
	}

}
