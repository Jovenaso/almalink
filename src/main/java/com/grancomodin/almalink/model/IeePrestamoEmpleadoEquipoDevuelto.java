package com.grancomodin.almalink.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class IeePrestamoEmpleadoEquipoDevuelto {
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "iee_prestamo_empleado_equipo_id", referencedColumnName = "id")
	// @Where(clause = "ctb = true")
	private IeePrestamoEmpleadoEquipo prestamo;
	private Short devuelto;
	private String comentarios;
	private String foto_evidencia;
	private Date fecha_alta;
	private Date fecha_actualiza;
	private Date fecha_baja;
	private boolean activo;
	public Date getFecha_alta() {
		return fecha_alta;
	}
	public void setFecha_alta(Date fecha_alta) {
		this.fecha_alta = fecha_alta;
	}
	public Date getFecha_actualiza() {
		return fecha_actualiza;
	}
	public void setFecha_actualiza(Date fecha_actualiza) {
		this.fecha_actualiza = fecha_actualiza;
	}
	public Date getFecha_baja() {
		return fecha_baja;
	}
	public void setFecha_baja(Date fecha_baja) {
		this.fecha_baja = fecha_baja;
	}
	public Long getGral_usr_id_alta() {
		return gral_usr_id_alta;
	}
	public void setGral_usr_id_alta(Long gral_usr_id_alta) {
		this.gral_usr_id_alta = gral_usr_id_alta;
	}
	public Long getGral_usr_id_actualiza() {
		return gral_usr_id_actualiza;
	}
	public void setGral_usr_id_actualiza(Long gral_usr_id_actualiza) {
		this.gral_usr_id_actualiza = gral_usr_id_actualiza;
	}
	public Long getGral_usr_id_baja() {
		return gral_usr_id_baja;
	}
	public void setGral_usr_id_baja(Long gral_usr_id_baja) {
		this.gral_usr_id_baja = gral_usr_id_baja;
	}
	private Long gral_usr_id_alta;
	private Long gral_usr_id_actualiza;
	private Long gral_usr_id_baja;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public IeePrestamoEmpleadoEquipo getPrestamo() {
		return prestamo;
	}
	public void setPrestamo(IeePrestamoEmpleadoEquipo prestamo) {
		this.prestamo = prestamo;
	}
	public Short getDevuelto() {
		return devuelto;
	}
	public void setDevuelto(Short devuelto) {
		this.devuelto = devuelto;
	}
	public String getComentarios() {
		return comentarios;
	}
	public void setComentarios(String comentarios) {
		this.comentarios = comentarios;
	}
	public String getFoto_evidencia() {
		return foto_evidencia;
	}
	public void setFoto_evidencia(String foto_evidencia) {
		this.foto_evidencia = foto_evidencia;
	}
	public boolean isActivo() {
		return activo;
	}
	public void setActivo(boolean activo) {
		this.activo = activo;
	}
	
	
}
