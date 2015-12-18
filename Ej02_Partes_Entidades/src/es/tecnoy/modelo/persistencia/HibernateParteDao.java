package es.tecnoy.modelo.persistencia;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import es.tecnoy.modelo.entidad.Parte;
import es.tecnoy.modelo.entidad.Parte.EstadoParte;
import es.tecnoy.utilidades.hibernate.HibernateContextoPersistencia;

public class HibernateParteDao extends HibernateAbstractDao implements ParteDao {

	public HibernateParteDao() {
		super();
		// TODO Auto-generated constructor stub
	}

	// A esto se le llama inyeccion por dependencia o inyeccion por constructor
	public HibernateParteDao(HibernateContextoPersistencia cp) {
		super();
		this.setCp(cp);
	}

	@Override
	public void add(Parte entidad) {
		Session session = getCp().getSesionActual();
		Integer codigo = (Integer) session.save(entidad);
		session.evict(entidad);
		entidad.setCodigo(codigo);
	}

	@Override
	public void remove(Integer codigo) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Todavia no esta implementado");
	}

	@Override
	public void edit(Parte entidad) {
		// TODO Auto-generated method stub

	}

	@Override
	public Parte query(Integer codigo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Parte> query() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Parte> queryBefore(Date fechaInicio) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Parte> queryAfter(Date fechaInicio) {
		// TODO Auto-generated method stub
		return null;
	}

	// Hay que establecer cuando se considera no aprobado un Parte, si es cuando
	// tiene el estado Pendiente solo, o si en cambio es con Pendiente y
	// Rechazado

	@Override
	public void updateWhereEstadoNoAprobado(Parte entidad) {
		Session session = getCp().getSesionActual();
		
//		StringBuilder hql = new StringBuilder("update Parte p set ")
//		.append("p.descripcion = :descripcion, ")
//		.append("p.fechaInicio = :fechaInicio, ")
//		.append("p.fechaFin = :fechaFin, ")
//		.append("p.estado = :estado, ")
//		.append("p.motivoRechazo = :motivoRechazo ")
//		.append("where p.codigo = :codigo and p.estado = :estadoPendiente");
//		
//		Query query = session.createQuery(hql.toString());
		
		Query query = session.getNamedQuery("updateWhereEstadoNoAprobado");
		
		query.setParameter("descripcion", entidad.getDescripcion());
		query.setParameter("fechaInicio", entidad.getFechaInicio());
		query.setParameter("fechaFin", entidad.getFechaFin());
		query.setParameter("estado", entidad.getEstado());
		query.setParameter("motivoRechazo", entidad.getMotivoRechazo());
		query.setParameter("codigo", entidad.getCodigo());
		query.setParameter("estadoPendiente", EstadoParte.PENDIENTE);
		
		int registrosAfectados = query.executeUpdate();
		
	}

}
