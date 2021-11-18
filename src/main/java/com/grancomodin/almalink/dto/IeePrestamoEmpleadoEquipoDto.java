package com.grancomodin.almalink.dto;

import java.io.Serializable;
import java.util.Date;

public class IeePrestamoEmpleadoEquipoDto implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long id;
	private Long iee_equipo_id;
	private Long gral_empleado_id;
	private Short prestado;
	private Date fecha_prestamo;
	private Date fecha_devolucion_estimada;
	private Long gral_encargado_id;
	private Long gral_usr_id;
	
	public IeePrestamoEmpleadoEquipoDto(Long id, Long iee_equipo_id, Long gral_empleado_id, Short prestado,
			Date fecha_prestamo, Date fecha_devolucion_estimada, Long gral_encargado_id) {
		super();
		this.id = id;
		this.iee_equipo_id = iee_equipo_id;
		this.gral_empleado_id = gral_empleado_id;
		this.prestado = prestado;
		this.fecha_prestamo = fecha_prestamo;
		this.fecha_devolucion_estimada = fecha_devolucion_estimada;
		this.gral_encargado_id = gral_encargado_id;
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
	public Long getIee_equipo_id() {
		return iee_equipo_id;
	}
	public void setIee_equipo_id(Long iee_equipo_id) {
		this.iee_equipo_id = iee_equipo_id;
	}
	public Long getGral_empleado_id() {
		return gral_empleado_id;
	}
	public void setGral_empleado_id(Long gral_empleado_id) {
		this.gral_empleado_id = gral_empleado_id;
	}
	public Short getPrestado() {
		return prestado;
	}
	public void setPrestado(Short prestado) {
		this.prestado = prestado;
	}
	public Date getFecha_prestamo() {
		return fecha_prestamo;
	}
	public void setFecha_prestamo(Date fecha_prestamo) {
		this.fecha_prestamo = fecha_prestamo;
	}
	public Date getFecha_devolucion_estimada() {
		return fecha_devolucion_estimada;
	}
	public void setFecha_devolucion_estimada(Date fecha_devolucion_estimada) {
		this.fecha_devolucion_estimada = fecha_devolucion_estimada;
	}
	public Long getGral_encargado_id() {
		return gral_encargado_id;
	}
	public void setGral_encargado_id(Long gral_encargado_id) {
		this.gral_encargado_id = gral_encargado_id;
	}
	
	
}
