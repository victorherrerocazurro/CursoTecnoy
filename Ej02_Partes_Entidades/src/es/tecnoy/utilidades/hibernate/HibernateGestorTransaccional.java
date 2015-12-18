package es.tecnoy.utilidades.hibernate;

import org.hibernate.Transaction;

//Como tiene constructor por defecto, es instanaciable por el contexto de JSF
public class HibernateGestorTransaccional {

	private HibernateContextoPersistencia cp;
	
	public void setCp(HibernateContextoPersistencia cp) {
		this.cp = cp;
	}

	public Transaction nuevaTransaccion(){
		return cp.getSesionActual().beginTransaction();
	}
	
}
