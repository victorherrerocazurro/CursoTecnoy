package es.tecnoy.modelo.persistencia;

import java.util.List;

import es.tecnoy.modelo.entidad.Parte;

public interface Dao<E,K> {


	void add(E entidad);
	
	void remove(K codigo);
	
	void edit(E entidad);
	
	E query(K codigo);
	
	List<E> query();
	
}
