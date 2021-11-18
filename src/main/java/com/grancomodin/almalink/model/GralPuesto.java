package com.grancomodin.almalink.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class GralPuesto {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String titulo;
	private String descripcion;
	private Long gral_usr_id_alta;
	private Long gral_usr_id_actualiza;
	private Long gral_usr_id_baja;
	private Date fecha_alta;
	private Date fecha_actualiza;
	private Date fecha_baja;
	private boolean activo;
	public GralPuesto(Long id) {
		super();
		this.id = id;
	}public GralPuesto() {
		super();
	}
	public boolean isActivo() {
		return activo;
	}
	public void setActivo(boolean activo) {
		this.activo = activo;
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
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
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
	
	
}
