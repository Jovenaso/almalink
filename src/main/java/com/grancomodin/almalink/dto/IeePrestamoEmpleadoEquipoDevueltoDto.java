package com.grancomodin.almalink.dto;

import java.io.Serializable;

public class IeePrestamoEmpleadoEquipoDevueltoDto implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long id;
	private String iee_prestamo_equipo_nombre;
	private Long iee_prestamo_id;
	private Short devuelto;
	private String comentarios;
	private String foto_evidencia;
	private Long gral_usr_id;
	
	public IeePrestamoEmpleadoEquipoDevueltoDto(Long id, Long iee_prestamo_id, Short devuelto, String comentarios,
			String foto_evidencia) {
		super();
		this.id = id;
		this.iee_prestamo_id = iee_prestamo_id;
		this.devuelto = devuelto;
		this.comentarios = comentarios;
		this.foto_evidencia = foto_evidencia;
	}
	public IeePrestamoEmpleadoEquipoDevueltoDto(Long id, String iee_prestamo_equipo_nombre, Short devuelto, String comentarios,
			String foto_evidencia) {
		super();
		this.id = id;
		this.iee_prestamo_equipo_nombre = iee_prestamo_equipo_nombre;
		this.devuelto = devuelto;
		this.comentarios = comentarios;
		this.foto_evidencia = foto_evidencia;
	}
	public String getIee_prestamo_equipo_nombre() {
		return iee_prestamo_equipo_nombre;
	}

	public void setIee_prestamo_equipo_nombre(String iee_prestamo_equipo_nombre) {
		this.iee_prestamo_equipo_nombre = iee_prestamo_equipo_nombre;
	}

	public Long getGral_usr_id() {
		return gral_usr_id;
	}
	public void setGral_usr_id(Long gral_usr_id) {
		this.gral_usr_id = gral_usr_id;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getIee_prestamo_id() {
		return iee_prestamo_id;
	}
	public void setIee_prestamo_id(Long iee_prestamo_id) {
		this.iee_prestamo_id = iee_prestamo_id;
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
	
	
}
