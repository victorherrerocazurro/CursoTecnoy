package es.tecnoy.modelo.persistencia;

import static org.junit.Assert.fail;

import java.util.Date;

import org.hibernate.Transaction;
import org.junit.Assert;
import org.junit.Test;

import es.tecnoy.modelo.entidad.Servicio;
import es.tecnoy.utilidades.hibernate.HibernateContextoPersistencia;
import es.tecnoy.utilidades.hibernate.HibernateGestorTransaccional;

public class TestHibernateServicioDao {

	@Test
	public void testAltaServicio() {

		HibernateContextoPersistencia cp = new HibernateContextoPersistencia();
		HibernateGestorTransaccional gt = new HibernateGestorTransaccional();
		gt.setCp(cp);

		Transaction tx = null;

		try {
			ServicioDao dao = new HibernateServicioDao(cp);
			// Si pusieramos aqui openSession nos crearia una nueva sesion y no
			// accederiamos a la misma que tenemos en el otro lado
			tx = gt.nuevaTransaccion();
			Servicio servicio = new Servicio(-1, "descripcion", new Date(),
					new Date(), null, null);
			dao.add(servicio);
			Assert.assertTrue(servicio.getCodigo() > 0);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
			fail("Not yet implemented");
		}
	}
}
