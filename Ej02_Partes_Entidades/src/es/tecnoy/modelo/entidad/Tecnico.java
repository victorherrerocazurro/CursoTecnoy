package es.tecnoy.modelo.entidad;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="PTR_TECNICOS")
public class Tecnico {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer codigo;
	
	private String nombre;
	private String apellidos;
	
	private String email;
	private String telefono;
	
	@ManyToOne
	@JoinColumn(name = "FK_CODIGO_EMPRESA", referencedColumnName = "codigo")
	private EmpresaServicios empresa;
	
	@ManyToMany(mappedBy="tecnicos")
	private List<Servicio> servicios;

	public Tecnico() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Tecnico(Integer codigo, String nombre, String apellidos, String email, String telefono,
			EmpresaServicios empresa) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.email = email;
		this.telefono = telefono;
		this.empresa = empresa;
	
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

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public EmpresaServicios getEmpresa() {
		return empresa;
	}

	public void setEmpresa(EmpresaServicios empresa) {
		this.empresa = empresa;
	}

	public List<Servicio> getServicios() {
		return servicios;
	}

	public void setServicios(List<Servicio> servicios) {
		this.servicios = servicios;
	}
	
	
	
	
	

	
}
