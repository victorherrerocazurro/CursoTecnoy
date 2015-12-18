package es.tecnoy.modelo.persistencia;

import java.util.List;

import org.hibernate.Session;

import es.tecnoy.modelo.entidad.Servicio;
import es.tecnoy.utilidades.hibernate.HibernateContextoPersistencia;

public class HibernateServicioDao extends HibernateAbstractDao implements ServicioDao {

	public HibernateServicioDao() {
		super();
	}

	// A esto se le llama inyeccion por dependencia o inyeccion por constructor
	public HibernateServicioDao(HibernateContextoPersistencia cp) {
		super();
		this.setCp(cp);
	}

	@Override
	public void add(Servicio entidad) {
		Session sesion = getCp().getSesionActual();
		Integer pk = (Integer) sesion.save(entidad);
		entidad.setCodigo(pk);
	}
	
	@Override
	public void remove(Integer codigo) {
		// TODO Auto-generated method stub

	}

	@Override
	public void edit(Servicio entidad) {
		Session sesion = getCp().getSesionActual();
		sesion.update(entidad);
	}

	//SELECT * FROM PTR_SERVICIOS WHERE codigo = ?
	@Override
	public Servicio query(Integer codigo) {
	
		Session sesion = getCp().getSesionActual();

		//Metodo Load
		return (Servicio) sesion.load(Servicio.class, codigo);
		
		
		//Criteria (validaciones)
		//return (Servicio) sesion.createCriteria(Servicio.class).
		//		add(Restrictions.eq("codigo", codigo)).
		//		uniqueResult();
		
		
		//HQL
//		Query query = sesion.createQuery("select s from " +
//					" es.tecnoy.modelo.entidad.Servicio as s " +
//					" where s.codigo = :codigo");
		//:codigo es una variable, donde haya : lo sustituyes x el valor de codigo 
		
//		query.setParameter("codigo", codigo);
//		return (Servicio) query.uniqueResult();

		
		//SQL
//		SQLQuery query = sesion.createSQLQuery("SELECT * FROM PTR_SERVICIOS WHERE codigo = ?");
		
//		query.setParameter(1, codigo);
//		query.addEntity(Servicio.class);
//		return (Servicio) query.uniqueResult();
		
	}
	

	//SELECT * FROM PTR_SERVICIOS
	@SuppressWarnings("unchecked")
	@Override
	public List<Servicio> query() {
		
		Session sesion = getCp().getSesionActual();
		
		return sesion.createCriteria(Servicio.class).list();
		
	}

}
