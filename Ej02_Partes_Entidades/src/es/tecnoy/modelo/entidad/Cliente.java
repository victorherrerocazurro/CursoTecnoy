package es.tecnoy.modelo.entidad;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

@Entity
@Table(name = "PTR_CLIENTES")
public class Cliente {

	/*
	 * @Id
	 * 
	 * @GeneratedValue(strategy=GenerationType.IDENTITY) private Integer id;
	 * 
	 * @Column(unique=true) private String codigo;
	 */

	/*
	 * @Id private String codigo
	 */

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer codigo;
	
	
	
	private String nombre;
	@Column(columnDefinition = "clob")
	private String descripcion;
	@Column(columnDefinition = "clob")
	private String observaciones;
	private String web;
	

	@Embedded // Para que esten las columnas definidas en la clase domicilio
	private Domicilio domicilio;

	@OneToMany(mappedBy="cliente", cascade = { CascadeType.ALL }/*, fetch=FetchType.EAGER */) // si hubiera mas relaciones necesito colocar el nombre de atributo donde esta la joincolumn al que me refiero con  mappedBy="cliente"
	private List<ContactoCliente> contactos; // Esto es opcional dependiendo si lo necesito o no

	
	
	
	public Cliente() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Cliente(Integer codigo, String nombre, String descripcion, String observaciones, String web, Domicilio domicilio) {
		super();
		this.codigo = codigo;
		this.nombre=nombre;
		this.descripcion = descripcion;
		this.observaciones = observaciones;
		this.web = web;
		this.domicilio = domicilio;
	}

	public String getNombre(){
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public String getWeb() {
		return web;
	}

	public void setWeb(String web) {
		this.web = web;
	}

	public Domicilio getDomicilio() {
		return domicilio;
	}

	public void setDomicilio(Domicilio domicilio) {
		this.domicilio = domicilio;
	}

	public List<ContactoCliente> getContactos() {
		return contactos;
	}

	public void setContactos(List<ContactoCliente> contactos) {
		this.contactos = contactos;
	}

}
