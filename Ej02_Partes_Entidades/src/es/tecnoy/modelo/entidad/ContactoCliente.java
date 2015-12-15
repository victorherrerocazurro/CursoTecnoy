package es.tecnoy.modelo.entidad;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "PTR_CONTACTOS_CLIENTE")
public class ContactoCliente {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer Codigo;

	private String nombre;
	private String apellidos;

	@ManyToOne/*(fetch=FetchType.LAZY)*/ // Estamos en el lado del mucho
	@JoinColumn(name = "FK_CODIGO_CLIENTE", referencedColumnName = "codigo") // Esto hace falta cuando creamos x primera vez la tabla y si la tenemos creada no hace falta
	private Cliente cliente; // relacion de composicion

	@OneToMany(mappedBy="contactoCliente", cascade = { CascadeType.ALL })
	private List<Telefono> telefonos;
	
	@ManyToMany(mappedBy="contactos")
	private List<Servicio> servicios;
	
	
	public ContactoCliente(Integer codigo, String nombre, String apellidos, Cliente cliente) {
		super();
		Codigo = codigo;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.cliente = cliente;
	}

	public Integer getCodigo() {
		return Codigo;
	}

	public void setCodigo(Integer codigo) {
		Codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public ContactoCliente() {
		super();
		// TODO Auto-generated constructor stub
	}

	public List<Telefono> getTelefonos() {
		return telefonos;
	}

	public void setTelefonos(List<Telefono> telefonos) {
		this.telefonos = telefonos;
	}

	public List<Servicio> getServicios() {
		return servicios;
	}

	public void setServicios(List<Servicio> servicios) {
		this.servicios = servicios;
	}

	
}
