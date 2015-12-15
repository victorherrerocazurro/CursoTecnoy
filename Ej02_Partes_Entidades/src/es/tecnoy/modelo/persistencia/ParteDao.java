package es.tecnoy.modelo.persistencia;

import java.util.Date;
import java.util.List;

import es.tecnoy.modelo.entidad.Parte;

public interface ParteDao extends Dao<Parte,Integer> {
	
	//Anteriores a
	List<Parte> queryBefore(Date fechaInicio);
	//Posteriores a
	List<Parte> queryAfter(Date fechaInicio);
	void updateWhereEstadoNoAprobado(Parte entidad);
	
	
	
}
