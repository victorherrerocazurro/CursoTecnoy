package es.tecnoy.modelo.entidad;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "PTR_TELEFONOS")
public class Telefono {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer codigo;

	private String numero;
	private String observaciones;

	@ManyToOne
	@JoinColumn(name = "FK_CODIGO_CONTACTO", referencedColumnName = "codigo")
	private ContactoCliente contactoCliente;

	public Telefono(Integer codigo, String numero, String observaciones, ContactoCliente contactoCliente) {
		super();
		this.codigo = codigo;
		this.numero = numero;
		this.observaciones = observaciones;
		this.contactoCliente = contactoCliente;
	}

	public Telefono() {
		super();
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public ContactoCliente getContactoCliente() {
		return contactoCliente;
	}

	public void setContactoCliente(ContactoCliente contactoCliente) {
		this.contactoCliente = contactoCliente;
	}

}