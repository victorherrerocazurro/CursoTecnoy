package es.tecnoy.modelo.persistencia;

import static org.junit.Assert.*;

import java.util.Date;

import org.hibernate.SessionFactory;
import org.junit.Test;

import es.tecnoy.modelo.entidad.Parte;
import es.tecnoy.modelo.entidad.Parte.EstadoParte;

public class TestHibernateParteDao {

	@Test
	public void testUpdateWhereEstadoNoAprobado() {
		
		SessionFactory sf = HibernateUtil.getSessionFactory();
		
		ParteDao dao = new HibernateParteDao(sf);
		
		Parte parte = new Parte(null, "Nuevo Parte", new Date(), new Date(), EstadoParte.PENDIENTE, "Rechazado por que esta mal", null);
		dao.updateWhereEstadoNoAprobado(parte );
		
		fail("Not yet implemented");
	}

}
