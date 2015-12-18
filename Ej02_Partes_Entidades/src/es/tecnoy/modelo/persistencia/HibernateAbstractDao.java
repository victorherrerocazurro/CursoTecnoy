package es.tecnoy.modelo.persistencia;

import es.tecnoy.utilidades.hibernate.HibernateContextoPersistencia;

public abstract class HibernateAbstractDao {

	private HibernateContextoPersistencia cp;

	public HibernateContextoPersistencia getCp() {
		return cp;
	}

	public void setCp(HibernateContextoPersistencia cp) {
		this.cp = cp;
	}
	
	

}