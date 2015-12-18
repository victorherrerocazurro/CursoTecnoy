package es.tecnoy.modelo.servicio;

import es.tecnoy.modelo.entidad.Parte;
import es.tecnoy.modelo.entidad.Servicio;
import es.tecnoy.modelo.persistencia.ParteDao;
import es.tecnoy.modelo.persistencia.ServicioDao;

public class ServicioAdministrador {
	
	private ParteDao parteDao;
	private ServicioDao servicioDao;
	
	public void setParteDao(ParteDao parteDao) {
		this.parteDao = parteDao;
	}

	public void setServicioDao(ServicioDao servicioDao) {
		this.servicioDao = servicioDao;
	}

	public void altaParteDeTrabajo(Parte parte){
		//Invocar (utilizar) cada una de las funcionalidad (herramientas)
		//necesarias para realizar el trabajo de dar de alta un parte
		parteDao.add(parte);

		//Mandar correo (si fuese necesario, segun los requisitos no hay que hacerlo)
	}
	
	public void altaServicio(Servicio servicio){
		servicioDao.add(servicio);
	}
	
	//....
}
