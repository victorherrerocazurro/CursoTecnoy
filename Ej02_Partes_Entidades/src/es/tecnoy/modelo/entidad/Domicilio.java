package es.tecnoy.modelo.entidad;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable // No es una entidad xq no tiene id asi que va a ir en la tabla de Cliente
public class Domicilio {

	private String localidad;
	private String calle;
	private String numero;
	@Column(name = "codigo_portal")
	private String codigoPostal;

	public Domicilio(String localidad, String calle, String numero, String codigoPostal) {
		super();
		this.localidad = localidad;
		this.calle = calle;
		this.numero = numero;
		this.codigoPostal = codigoPostal;
	}

	public Domicilio() {
		super();
	}

	public String getLocalidad() {
		return localidad;
	}

	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}

	public String getCalle() {
		return calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getCodigoPostal() {
		return codigoPostal;
	}

	public void setCodigoPostal(String codigoPostal) {
		this.codigoPostal = codigoPostal;
	}

}
