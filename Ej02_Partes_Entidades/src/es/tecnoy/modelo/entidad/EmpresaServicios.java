package es.tecnoy.modelo.entidad;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="PTR_EMP_SERVICIOS")
public class EmpresaServicios {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer codigo;
	
	private String nombre;
	@Column(columnDefinition = "clob")
	private String descripcion;
	private String web;
	@Column(columnDefinition = "clob")
	private String observaciones;
	
	@Embedded
	private Domicilio domicilio;

	
	@OneToMany(mappedBy="empresa", cascade = { CascadeType.ALL })
	private List<Tecnico> tecnicos;
	


	public EmpresaServicios() {
		super();
	}


	public EmpresaServicios(Integer codigo, String nombre, String descripcion, String web, String observaciones,
			Domicilio domicilio) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.web = web;
		this.observaciones = observaciones;
		this.domicilio = domicilio;
	}


	public Integer getCodigo() {
		return codigo;
	}


	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getDescripcion() {
		return descripcion;
	}


	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	public String getWeb() {
		return web;
	}


	public void setWeb(String web) {
		this.web = web;
	}


	public String getObservaciones() {
		return observaciones;
	}


	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}


	public Domicilio getDomicilio() {
		return domicilio;
	}


	public void setDomicilio(Domicilio domicilio) {
		this.domicilio = domicilio;
	}


	public List<Tecnico> getTecnicos() {
		return tecnicos;
	}


	public void setTecnicos(List<Tecnico> tecnicos) {
		this.tecnicos = tecnicos;
	} 
	
	
	
}
