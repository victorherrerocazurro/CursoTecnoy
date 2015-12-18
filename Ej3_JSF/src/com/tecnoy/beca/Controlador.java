package com.tecnoy.beca;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class Controlador {

	private String option = "1";
	private String mensaje;

	//Metodos empleados por las expresiones JSF para acceder a los Atibutos
	
	public String getOption() {
		return option;
	}

	public void setOption(String option) {
		this.option = option;
	}
	
	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	//Metodo de Accion
	
	public String accion(){
		
		setMensaje("La opcion seleccionada es la " + option);
		
		return null; //"index"
	}
}
