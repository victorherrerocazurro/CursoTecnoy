package es.tecnoy.modelo.persistencia;

import static org.junit.Assert.*;

import java.util.Date;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Test;

import es.tecnoy.modelo.entidad.Parte;
import es.tecnoy.modelo.entidad.Parte.EstadoParte;

public class TestHibernateParteDao {

	@Test
	public void testUpdateWhereEstadoNoAprobado() {
		
		SessionFactory sf = HibernateUtil.getSessionFactory();
		
		ParteDao dao = new HibernateParteDao(sf);
		
		//------------------Tx 1---------------------
		
		Transaction tx = sf.getCurrentSession().beginTransaction();
		
		Parte parte = new Parte(null, "Nuevo Parte", 
				new Date(), new Date(), EstadoParte.PENDIENTE, null, null);

		//Añadimos el Parte a la BD
		dao.add(parte);
		
		//Modificar el parte
		parte.setEstado(EstadoParte.RECHAZADO);
		parte.setMotivoRechazo("Por que no esta bien hecho");
		
		
		dao.updateWhereEstadoNoAprobado(parte); //Esta sentencia si deberia cambiar el dato en BD
		
		parte.setEstado(EstadoParte.APROOBADO);
		
		dao.updateWhereEstadoNoAprobado(parte); //Esta sentencia no deberia cambiar el dato en BD
		
		tx.commit();
		
		//fail("Not yet implemented");
	}

}
