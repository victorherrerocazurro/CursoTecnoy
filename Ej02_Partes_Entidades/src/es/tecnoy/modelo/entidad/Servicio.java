package es.tecnoy.modelo.entidad;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.JoinColumn;

@Entity
@Table(name="PTR_SERVICIOS")
public class Servicio {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer codigo;
	@Column(name="DESCRIPCION_SERVICIO", columnDefinition="clob")
	private String descripcion;
	@Column(name="FECHA_INICIO")
	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaInicio;
	@Column(name="FECHA_FIN")
	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaFin;
	
	//contacto cliente (texto libre)


	//--------Relaciones con tecnicos y contactos_cliente---------
	
	//Aqui colocamos toda la configuracion porque es de muchos a muchos y solo necesito ponerlo en uno
	// n-m
	@ManyToMany
	@JoinTable(name="PTR_SERVICIOS_CONTACTOS", 
				joinColumns={ @JoinColumn(name="FK_CODIGO_SERVICIO", referencedColumnName="codigo")},  //Que columna aporta servicio a la tabla intermedia
				inverseJoinColumns={ @JoinColumn(name="FK_CODIGO_CONTACTO", referencedColumnName="codigo")}) //Que columnas aportan las otras entidades
	private List<ContactoCliente> contactos;
	

	@ManyToMany
	@JoinTable(name="PTR_SERVICIOS_TECNICOS", 
				joinColumns={ @JoinColumn(name="FK_CODIGO_SERVICIO", referencedColumnName="codigo")},  //Que columna aporta servicio a la tabla intermedia
				inverseJoinColumns={ @JoinColumn(name="FK_CODIGO_TECNICO", referencedColumnName="codigo")}) 
	private List<Tecnico> tecnicos;
	
	
	//--------Relaciones con clientes y empresa---------
	//n-1
	@ManyToOne
	@JoinColumn(name="FK_CODIGO_CLIENTE", referencedColumnName="codigo")
	private Cliente cliente;
	
	@ManyToOne
	@JoinColumn(name="FK_CODIGO_EMPRESA", referencedColumnName="codigo")
	private EmpresaServicios empresa;
	
	
	//-----------------------Constructoras y metodos----------------------------

	public Servicio() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Servicio(Integer codigo, String descripcion, Date fechaInicio, Date fechaFin, Cliente cliente, EmpresaServicios empresa) {
		super();
		this.codigo = codigo;
		this.descripcion = descripcion;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.cliente = cliente;
		this.empresa = empresa;
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

	public Date getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public Date getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}

	public List<ContactoCliente> getContactos() {
		return contactos;
	}

	public void setContactos(List<ContactoCliente> contactos) {
		this.contactos = contactos;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	public List<Tecnico> getTecnicos() {
		return tecnicos;
	}

	public void setTecnicos(List<Tecnico> tecnicos) {
		this.tecnicos = tecnicos;
	}

	public EmpresaServicios getEmpresa() {
		return empresa;
	}

	public void setEmpresa(EmpresaServicios empresa) {
		this.empresa = empresa;
	}
	
}
