package es.tecnoy.modelo.persistencia;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import es.tecnoy.modelo.entidad.Servicio;

public abstract class HibernateAbstractDao {

	private SessionFactory sf;

	public SessionFactory getSf() {
		return sf;
	}

	public HibernateAbstractDao() {
		super();
	}

	public void setSf(SessionFactory sf) {
		this.sf = sf;
	}
}