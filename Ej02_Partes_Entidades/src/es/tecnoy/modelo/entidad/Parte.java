package es.tecnoy.modelo.entidad;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "PTR_PARTES")
public class Parte {

	public enum EstadoParte {
		PENDIENTE, APROOBADO, RECHAZADO
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer codigo;

	@Column(name = "DESCRIPCION_PARTE", columnDefinition = "clob")
	private String descripcion;
	@Column(name = "FECHA_INICIO")
	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaInicio;
	@Column(name = "FECHA_FIN")
	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaFin;

	@Enumerated(EnumType.STRING)
	private EstadoParte estado;

	@Column(name = "MOTIVO_RECHAZO", columnDefinition = "clob")
	private String motivoRechazo;
	
	@ManyToOne
	@JoinColumn(name = "FK_CODIGO_SERVICIO", referencedColumnName = "codigo")
	private Servicio servicio;

	public Parte() {
		super();
	}

	public Parte(Integer codigo, String descripcion, Date fechaInicio, Date fechaFin, EstadoParte estado,
			String motivoRechazo, Servicio servicio) {
		super();
		this.codigo = codigo;
		this.descripcion = descripcion;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.estado = estado;
		this.motivoRechazo = motivoRechazo;
		this.servicio = servicio;
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

	public EstadoParte getEstado() {
		return estado;
	}

	public void setEstado(EstadoParte estado) {
		this.estado = estado;
	}

	public String getMotivoRechazo() {
		return motivoRechazo;
	}

	public void setMotivoRechazo(String motivoRechazo) {
		this.motivoRechazo = motivoRechazo;
	}

	public Servicio getServicio() {
		return servicio;
	}

	public void setServicio(Servicio servicio) {
		this.servicio = servicio;
	}
	
	
}